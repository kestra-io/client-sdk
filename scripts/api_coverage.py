#!/usr/bin/env python3
"""Compute how much of the Kestra HTTP API each hand-written SDK covers.

The API surface (the 100%) is derived directly from the Micronaut controllers
in the Kestra backend (OSS `kestra-io/kestra` + EE `kestra-io/kestra-ee`), NOT
from any OpenAPI spec. Each `@Controller("/base")` class plus its method-level
`@Get/@Post/@Put/@Delete/@Patch` annotations yields one (verb, path) endpoint.

The SDK side (the numerator) is extracted from the hand-written sources:
  - Python  python/python-sdk/kestrapy/api/*.py   _tenant_path(...) + _json_request("VERB", ...)
  - Go      go-sdk/kestra_api_client/*_api.go      tenantPath(...)   + doJSON...("VERB", ...)
  - Java    java/java-sdk/src/main/java/io/kestra/sdk/api/*Api.java
                                                   tenantPath(...)   + get/postYaml/delete... helper

The JS SDK is generated at build time by @hey-api/openapi-ts (src/openapi is
gitignored) and therefore cannot be measured from committed source.

Endpoints are matched on (verb, normalized-path), where every path parameter
`{whatever}` is normalized to `{}` so positional templates line up regardless
of parameter naming.

Backend sources are fetched via `gh` by default (needs `gh auth` with access to
the private EE repo); pass --kestra-dir / --kestra-ee-dir to read local checkouts.

Usage:
  scripts/api_coverage.py                       # fetch develop from GitHub
  scripts/api_coverage.py --ref v0.20.0
  scripts/api_coverage.py --kestra-dir ../kestra --kestra-ee-dir ../kestra-ee
  scripts/api_coverage.py --json report.json    # also write machine-readable output
"""
from __future__ import annotations

import argparse
import base64
import json
import re
import subprocess
import sys
from collections import defaultdict
from concurrent.futures import ThreadPoolExecutor
from dataclasses import dataclass, field
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent.parent

# --------------------------------------------------------------------------- #
# Backend controller parsing                                                  #
# --------------------------------------------------------------------------- #

CONTROLLER_RE = re.compile(r'@Controller\(\s*"([^"]*)"')
# A method-level route annotation, capturing the verb and the full parenthesised args.
ROUTE_RE = re.compile(r'@(Get|Post|Put|Delete|Patch)\b\s*(\([^)]*\))?', re.DOTALL)
URI_KW_RE = re.compile(r'\buri\s*=\s*"([^"]*)"')
VALUE_KW_RE = re.compile(r'\bvalue\s*=\s*"([^"]*)"')
FIRST_POSITIONAL_STR_RE = re.compile(r'\(\s*"([^"]*)"')


def normalize_path(path: str) -> str:
    """Structural normalization: {param} -> {}, collapse //, and resolve the
    RFC-6570 / Micronaut URI-template operators that backend routes use:
      {/path}   optional path segment  ->  /{} (a real positional param)
      {?x},{&x} query expansion        ->  dropped (not part of the path)
      {#x},{.x},{;x} fragment/etc.     ->  dropped
      {+x}      reserved expansion     ->  {} (still a path param)
    Without this, e.g. `actions/kill{?isOnKillCascade}` and
    `webhook/{}/{}/{}{/path}` normalize to bogus `kill{}` / `.../{}{}` segments
    that never match the SDK's real paths (false "uncovered").
    """
    path = re.sub(r"\{/([^}]*)\}", r"/{\1}", path)   # {/path} -> /{path}
    path = re.sub(r"\{[?&#.;][^}]*\}", "", path)     # {?x}/{&x}/{#x}/... -> drop
    path = re.sub(r"\{\+([^}]*)\}", r"{\1}", path)   # {+x} -> {x}
    path = re.sub(r"\{[^}]*\}", "{}", path)
    path = re.sub(r"/+", "/", "/" + path)
    if len(path) > 1 and path.endswith("/"):
        path = path[:-1]
    return path


def annotation_uri(args: str | None) -> str:
    """Extract the route sub-path from an annotation's argument list.

    Handles `@Get("/x")`, `@Get(uri = "/x")`, `@Get(value = "/x")`, and
    `@Post(consumes = ...)` (no path -> maps to the controller base path).
    Crucially does NOT mistake `produces`/`consumes` strings for the uri.
    """
    if not args:
        return ""
    m = URI_KW_RE.search(args) or VALUE_KW_RE.search(args)
    if m:
        return m.group(1)
    # Positional first-arg string, only if the annotation doesn't start with `kw = `.
    if not re.match(r'\(\s*\w+\s*=', args):
        m = FIRST_POSITIONAL_STR_RE.search(args)
        if m:
            return m.group(1)
    return ""


def parse_controller(text: str) -> set[tuple[str, str]]:
    cm = CONTROLLER_RE.search(text)
    if not cm:
        return set()  # not an HTTP controller (or base path is non-literal)
    base = cm.group(1)
    endpoints: set[tuple[str, str]] = set()
    for m in ROUTE_RE.finditer(text):
        verb = m.group(1).upper()
        uri = annotation_uri(m.group(2))
        full = base if not uri else f"{base}/{uri}"
        endpoints.add((verb, normalize_path(full)))
    return endpoints


# --------------------------------------------------------------------------- #
# Backend source acquisition                                                  #
# --------------------------------------------------------------------------- #

CONTROLLER_FILE_RE = re.compile(r"webserver.*/controllers/.*Controller\.java$")


def gh(*args: str) -> str:
    return subprocess.run(
        ["gh", *args], check=True, capture_output=True, text=True
    ).stdout


def fetch_repo_controllers(repo: str, ref: str) -> dict[str, str]:
    """Return {path: file_text} for every controller in a repo at a git ref."""
    sha = gh("api", f"repos/{repo}/commits/{ref}", "--jq", ".sha").strip()
    tree = json.loads(gh("api", f"repos/{repo}/git/trees/{sha}?recursive=1"))
    paths = [
        e["path"]
        for e in tree["tree"]
        if e["type"] == "blob"
        and CONTROLLER_FILE_RE.search(e["path"])
        and "/test/" not in e["path"]
    ]

    def fetch(p: str) -> tuple[str, str]:
        raw = gh("api", f"repos/{repo}/contents/{p}?ref={sha}", "--jq", ".content")
        return p, base64.b64decode(raw).decode("utf-8", "replace")

    with ThreadPoolExecutor(max_workers=12) as pool:
        return dict(pool.map(fetch, paths))


def load_local_controllers(root: Path) -> dict[str, str]:
    out: dict[str, str] = {}
    for f in root.rglob("*Controller.java"):
        rel = str(f.relative_to(root))
        if CONTROLLER_FILE_RE.search(rel) and "/test/" not in rel:
            out[rel] = f.read_text(encoding="utf-8", errors="replace")
    return out


def collect_backend(args) -> dict[tuple[str, str], list[str]]:
    """Return {(verb, path): [source files]} across OSS + EE, /api/v1 only."""
    sources: list[tuple[str, dict[str, str]]] = []
    if args.kestra_dir:
        sources.append(("OSS", load_local_controllers(Path(args.kestra_dir))))
    else:
        sources.append(("OSS", fetch_repo_controllers("kestra-io/kestra", args.ref)))
    if args.kestra_ee_dir:
        sources.append(("EE", load_local_controllers(Path(args.kestra_ee_dir))))
    else:
        sources.append(("EE", fetch_repo_controllers("kestra-io/kestra-ee", args.ref)))

    endpoints: dict[tuple[str, str], list[str]] = defaultdict(list)
    for origin, files in sources:
        for path, text in files.items():
            for ep in parse_controller(text):
                if ep[1].startswith("/api/v1"):
                    endpoints[ep].append(f"{origin}:{Path(path).name}")
    return endpoints


# --------------------------------------------------------------------------- #
# SDK endpoint extraction                                                     #
# --------------------------------------------------------------------------- #

# Path-helper calls used by the hand-written SDKs. Every argument is mapped:
#   "literal"  -> literal path segment    (a quoted string)
#   varName    -> {}                       (a path parameter)
# Most helpers are "generic": `/api/v1/` + mapped(args). The ns-files helpers
# hide two segments — nsFilesPath(tenant, namespace, *segs) expands to
# `/api/v1/{tenant}/namespaces/{namespace}/files/*segs`.
# The arg list allows one level of nested parens so that method-call arguments
# such as Java's `kind.getValue()` don't truncate the capture at their own `)`.
PATH_HELPER_RE = re.compile(
    r"\b(_ns_files_path|nsFilesPath|_superadmin_path|superadminPath"
    r"|_tenant_path|tenantPath|path)\s*\(((?:[^()]|\([^()]*\))*)\)"
)
NS_FILES_HELPERS = {"_ns_files_path", "nsFilesPath"}
# A path-param argument: either a quoted literal, or an identifier possibly with
# attribute access / a method call (`kind.value`, `kind.getValue()`) — the whole
# dotted chain is ONE path segment, not one per name part.
ARG_RE = re.compile(r'"([^"]*)"|([A-Za-z_]\w*(?:\.\w+)*)(?:\([^()]*\))?')
VERB_LITERAL_RE = re.compile(r'"(GET|POST|PUT|DELETE|PATCH)"')


def _map_args(arglist: str) -> list[str]:
    """Each call argument -> a path segment: quoted string kept, identifier -> {}."""
    segs = []
    for quoted, ident in ARG_RE.findall(arglist):
        segs.append("{}" if ident else quoted)
    return segs


def helper_to_path(name: str, arglist: str) -> str:
    segs = _map_args(arglist)
    if name in NS_FILES_HELPERS and len(segs) >= 2:
        segs = [segs[0], "namespaces", segs[1], "files", *segs[2:]]
    return normalize_path("/api/v1/" + "/".join(segs))


@dataclass
class SdkResult:
    language: str
    endpoints: set[tuple[str, str]] = field(default_factory=set)
    measurable: bool = True
    note: str = ""


def _scan_methods(text: str, split_re: re.Pattern, verb_fn) -> set[tuple[str, str]]:
    """Generic: split into method bodies; pair each path-helper with a verb."""
    out: set[tuple[str, str]] = set()
    parts = split_re.split(text)
    for body in parts:
        path_m = PATH_HELPER_RE.search(body)
        if not path_m:
            continue
        path = helper_to_path(path_m.group(1), path_m.group(2))
        for verb in verb_fn(body):
            out.add((verb, path))
    return out


def extract_python() -> SdkResult:
    res = SdkResult("Python")
    api_dir = REPO_ROOT / "python/python-sdk/kestrapy/api"
    split = re.compile(r"\n    def ")
    verb_call = re.compile(r'_(?:json_)?request\(\s*"(GET|POST|PUT|DELETE|PATCH)"')
    for f in sorted(api_dir.glob("*.py")):
        if f.name == "__init__.py":
            continue
        res.endpoints |= _scan_methods(
            f.read_text(), split, lambda b: verb_call.findall(b)
        )
    return res


def extract_go() -> SdkResult:
    res = SdkResult("Go")
    api_dir = REPO_ROOT / "go-sdk/kestra_api_client"
    split = re.compile(r"\nfunc ")
    for f in sorted(api_dir.glob("*_api.go")):
        if f.name == "base_api.go":
            continue
        res.endpoints |= _scan_methods(
            f.read_text(), split, lambda b: VERB_LITERAL_RE.findall(b)
        )
    return res


# Java request helpers whose *name* carries the verb (used when the method does
# not pass an explicit "VERB" string to invoke(...)).
JAVA_VERB_RE = re.compile(
    r"\b(getList|get|postYaml|postJson|postMultipart|post|putYaml|putJson|putNoBody|put"
    r"|deleteWithBody|deleteWithQuery|deleteWithReturn|delete|patchJson|patch)\s*\("
)
JAVA_VERB_MAP = {
    "get": "GET", "getList": "GET",
    "post": "POST", "postYaml": "POST", "postJson": "POST", "postMultipart": "POST",
    "put": "PUT", "putYaml": "PUT", "putJson": "PUT", "putNoBody": "PUT",
    "delete": "DELETE", "deleteWithBody": "DELETE", "deleteWithQuery": "DELETE",
    "deleteWithReturn": "DELETE", "patch": "PATCH", "patchJson": "PATCH",
}


def extract_java() -> SdkResult:
    res = SdkResult("Java")
    api_dir = REPO_ROOT / "java/java-sdk/src/main/java/io/kestra/sdk/api"
    split = re.compile(r"\n    public ")
    if not api_dir.is_dir():
        res.measurable = False
        res.note = "api directory not found"
        return res

    def verbs(body: str):
        # invoke("POST", ...) carries the verb as a literal; named helpers
        # (get/postJson/delete...) carry it in the method name. Prefer the
        # literal, fall back to the helper name, so we never double-count.
        literals = VERB_LITERAL_RE.findall(body)
        if literals:
            return literals
        return [JAVA_VERB_MAP[v] for v in JAVA_VERB_RE.findall(body) if v in JAVA_VERB_MAP]

    for f in sorted(api_dir.glob("*Api.java")):
        res.endpoints |= _scan_methods(f.read_text(), split, verbs)
    return res


def extract_js() -> SdkResult:
    res = SdkResult("JavaScript")
    res.measurable = False
    res.note = (
        "Generated at build by @hey-api/openapi-ts; src/openapi is gitignored, "
        "so there is no hand-written source to measure (and it cannot be "
        "produced without the OpenAPI spec)."
    )
    return res


# --------------------------------------------------------------------------- #
# Reporting                                                                    #
# --------------------------------------------------------------------------- #

def resource_of(path: str) -> str:
    """Best-effort grouping label, e.g. /api/v1/{}/flows/... -> flows."""
    parts = [p for p in path.split("/") if p and p != "{}"]
    # parts like ['api','v1','flows', ...]; resource is first after v1
    return parts[2] if len(parts) > 2 else (parts[-1] if parts else "?")


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--ref", default="develop", help="git ref of the backend repos (default: develop)")
    ap.add_argument("--kestra-dir", help="local checkout of kestra-io/kestra (skip fetch)")
    ap.add_argument("--kestra-ee-dir", help="local checkout of kestra-io/kestra-ee (skip fetch)")
    ap.add_argument("--json", help="write a machine-readable report to this path")
    ap.add_argument("--show-gaps", type=int, default=15, help="how many uncovered endpoints to list per SDK (default 15)")
    args = ap.parse_args()

    print("Deriving API surface from backend controllers (no OpenAPI)...", file=sys.stderr)
    backend = collect_backend(args)
    surface = set(backend.keys())
    total = len(surface)
    print(f"  -> {total} endpoints across OSS + EE\n", file=sys.stderr)

    sdks = [extract_python(), extract_go(), extract_java(), extract_js()]

    report = {"total_endpoints": total, "ref": args.ref, "sdks": {}}
    print(f"{'SDK':<12} {'covered':>9} {'total':>6} {'coverage':>9}   {'extra*':>6}")
    print("-" * 56)
    for s in sdks:
        if not s.measurable:
            print(f"{s.language:<12} {'n/a':>9} {total:>6} {'n/a':>9}   (generated)")
            report["sdks"][s.language] = {"measurable": False, "note": s.note}
            continue
        covered = s.endpoints & surface
        extra = s.endpoints - surface  # SDK paths with no backend match (parse/normalize issues or stale)
        pct = 100.0 * len(covered) / total if total else 0.0
        print(f"{s.language:<12} {len(covered):>9} {total:>6} {pct:>8.1f}%   {len(extra):>6}")
        report["sdks"][s.language] = {
            "measurable": True,
            "covered": len(covered),
            "total": total,
            "coverage_pct": round(pct, 1),
            "uncovered": sorted(f"{v} {p}" for v, p in (surface - s.endpoints)),
            "unmatched_sdk": sorted(f"{v} {p}" for v, p in extra),
        }

    print("\n* extra = endpoints found in the SDK that didn't match any backend route")
    print("  (usually a path-normalization or parser gap worth inspecting).")

    # Per-SDK gap detail
    for s in sdks:
        if not s.measurable:
            print(f"\n## {s.language}: not measurable — {s.note}")
            continue
        uncovered = sorted(surface - s.endpoints)
        by_res = defaultdict(int)
        for _, p in uncovered:
            by_res[resource_of(p)] += 1
        print(f"\n## {s.language}: {len(uncovered)} uncovered endpoints")
        top = sorted(by_res.items(), key=lambda kv: -kv[1])[:10]
        print("   biggest gaps by resource: " + ", ".join(f"{r}({n})" for r, n in top))
        for verb, p in uncovered[: args.show_gaps]:
            print(f"     {verb:<6} {p}")
        if len(uncovered) > args.show_gaps:
            print(f"     ... and {len(uncovered) - args.show_gaps} more (see --json for the full list)")

    if args.json:
        Path(args.json).write_text(json.dumps(report, indent=2))
        print(f"\nWrote {args.json}", file=sys.stderr)
    return 0


if __name__ == "__main__":
    sys.exit(main())
