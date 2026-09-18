#!/usr/bin/env python3
"""Validate that every example in docs/*.md matches the hand-written SDK.

Background
----------
Since #237 the Python API classes are hand-written, so the OpenAPI doc
generator no longer describes the SDK and the per-API `docs/*.md` examples
drifted (issue #144: wrong accessor, wrong argument order, calls to renamed or
removed methods, invalid keyword arguments).

Rather than *regenerate* those reference docs from the signatures — which would
drop the rich, spec-derived sections (parameter descriptions, auth, HTTP
response codes) the generator produced — this script *validates* the example
code blocks against the live signatures. Every #144-class bug is "the example
disagrees with the function it calls", and that is exactly what this checks, by
construction, with no live server required.

Run it in CI (`--check`) to gate the docs:

    python scripts/validate_doc_examples.py --check

Checks per `kestra_client.<accessor>.<method>(...)` call found in docs/*.md:
  1. <accessor> is a real @property on KestraClient (catches FlowsApi -> flows);
  2. <method> exists on the API classes (catches renamed/removed methods);
  3. any positional argument whose name is a real parameter sits at the index
     that parameter occupies in the signature (catches tenant-last ordering);
  4. every keyword argument names a real parameter (catches q=/file_upload=).
"""
from __future__ import annotations

import argparse
import ast
import glob
import os
import re
import sys

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))  # python-sdk/
API_GLOB = os.path.join(BASE, "kestrapy", "api", "*_api.py")
CLIENT_PY = os.path.join(BASE, "kestrapy", "kestra_client.py")
DOCS_GLOB = os.path.join(BASE, "docs", "*.md")

_CALL_RE = re.compile(r"kestra_client\.([a-z_][a-z0-9_]*)\.([a-z_][a-z0-9_]*)\((.*)\)")


def load_signatures() -> dict[str, list[str]]:
    """method name -> ordered parameter names (excluding self)."""
    sigs: dict[str, list[str]] = {}
    for path in glob.glob(API_GLOB):
        tree = ast.parse(open(path, encoding="utf-8").read())
        for node in ast.walk(tree):
            if isinstance(node, ast.FunctionDef) and not node.name.startswith("_"):
                sigs.setdefault(node.name, [a.arg for a in node.args.args if a.arg != "self"])
    return sigs


def load_accessors() -> set[str]:
    """Names of @property accessors exposed by KestraClient (flows, kv, ...)."""
    tree = ast.parse(open(CLIENT_PY, encoding="utf-8").read())
    accessors: set[str] = set()
    for klass in tree.body:
        if isinstance(klass, ast.ClassDef) and klass.name == "KestraClient":
            for node in klass.body:
                if isinstance(node, ast.FunctionDef) and any(
                    isinstance(d, ast.Name) and d.id == "property" for d in node.decorator_list
                ):
                    accessors.add(node.name)
    return accessors


def _split_args(argstr: str) -> list[str]:
    out, depth, cur = [], 0, ""
    for ch in argstr:
        if ch in "([{":
            depth += 1
        elif ch in ")]}":
            depth -= 1
        if ch == "," and depth == 0:
            out.append(cur.strip())
            cur = ""
        else:
            cur += ch
    if cur.strip():
        out.append(cur.strip())
    return out


def validate() -> list[str]:
    sigs = load_signatures()
    accessors = load_accessors()
    problems: list[str] = []

    for path in sorted(glob.glob(DOCS_GLOB)):
        rel = os.path.relpath(path, BASE)
        for lineno, line in enumerate(open(path, encoding="utf-8"), 1):
            m = _CALL_RE.search(line)
            if not m:
                continue
            accessor, method, argstr = m.group(1), m.group(2), m.group(3)
            where = f"{rel}:{lineno} {accessor}.{method}"

            if accessor not in accessors:
                problems.append(f"{where}: unknown KestraClient accessor '{accessor}'")
                continue
            if method not in sigs:
                problems.append(f"{where}: method '{method}' does not exist on the SDK")
                continue

            params = sigs[method]
            args = _split_args(argstr)
            positional = [a for a in args if "=" not in a.split("(")[0]]
            keywords = [a.split("=")[0].strip() for a in args if "=" in a.split("(")[0]]

            for i, var in enumerate(positional):
                if var in params and params.index(var) != i:
                    problems.append(
                        f"{where}: argument '{var}' is at position {i} but the "
                        f"signature puts it at {params.index(var)} (params: {params})"
                    )
                    break
            for kw in keywords:
                if kw not in params:
                    problems.append(f"{where}: keyword '{kw}=' is not a parameter (params: {params})")

    return problems


def main(argv: list[str]) -> int:
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--check", action="store_true", help="exit non-zero if any example is invalid")
    ap.parse_args(argv)

    problems = validate()
    if problems:
        print(f"{len(problems)} invalid doc example(s):\n")
        for p in problems:
            print(f"  - {p}")
        return 1
    print("All docs/*.md examples match the SDK signatures.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv[1:]))
