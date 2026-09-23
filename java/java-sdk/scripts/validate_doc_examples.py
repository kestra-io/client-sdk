#!/usr/bin/env python3
"""Validate that every example in docs/*.md matches the hand-written Java SDK.

The Java SDK is hand-written (issue #222), so the OpenAPI doc generator no
longer describes it and the per-API `docs/*.md` examples drifted (issue #122:
wrong accessor casing such as ``kestraClient.ExecutionsApi()`` instead of
``kestraClient.executions()``, renamed/removed methods, wrong argument order).

This is the Java counterpart of ``python/python-sdk/scripts/validate_doc_examples.py``.
Rather than regenerate the reference docs, it validates each
``kestraClient.<accessor>().<method>(...)`` call found in the docs against the
live signatures parsed from the SDK sources. No JVM or server required.

Checks per call:
  1. <accessor> is a real accessor on KestraClient (catches ExecutionsApi -> executions);
  2. <method> exists on the accessor's API class (catches renamed/removed methods);
  3. the call fits *some* overload: it passes no more arguments than that
     overload declares (catches a removed/extra argument), and any positional
     argument whose name is a real parameter sits at the index that parameter
     occupies (catches tenant-last ordering).

Checks per method signature line (``> ReturnType method(a, b, c)``) in
docs/<Class>.md:
  4. it lists exactly the parameters of one of the method's overloads, in
     order — readers copy that line and the Parameters table as often as the
     example, so a stale generator ordering there is the same drift.

Run in CI with --check to gate the docs.
"""
from __future__ import annotations

import argparse
import glob
import os
import re
import sys

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))  # java-sdk/
CLIENT_JAVA = os.path.join(BASE, "src", "main", "java", "io", "kestra", "sdk", "KestraClient.java")
API_DIR = os.path.join(BASE, "src", "main", "java", "io", "kestra", "sdk", "api")
DOCS_GLOB = os.path.join(BASE, "docs", "*.md")

# The accessor group intentionally allows an initial capital so mis-cased
# accessors (e.g. the generator's `kestraClient.ExecutionsApi()`) are matched
# and then flagged as unknown, rather than slipping through unvalidated.
# DOTALL so a call wrapped across several lines (hand-edited examples often are)
# is matched rather than silently skipped; the non-greedy body plus the `)\s*;`
# anchor still stops at the first statement terminator.
SIGNATURE_LINE_RE = re.compile(r"^> (?:.* )?([a-zA-Z_][A-Za-z0-9_]*)\((.*)\)\s*$", re.MULTILINE)
CALL_RE = re.compile(
    r"kestraClient\.([A-Za-z_][A-Za-z0-9_]*)\(\)\.([a-zA-Z_][A-Za-z0-9_]*)\((.*?)\)\s*;",
    re.DOTALL,
)


def load_accessors() -> dict[str, str]:
    """accessor method name -> API class (e.g. 'executions' -> 'ExecutionsApi')."""
    text = open(CLIENT_JAVA, encoding="utf-8").read()
    mapping = {}
    for cls, name in re.findall(r"public\s+([A-Za-z_][A-Za-z0-9_]*Api)\s+([a-zA-Z_][A-Za-z0-9_]*)\(\)", text):
        mapping[name] = cls
    if not mapping:
        raise SystemExit("no accessors parsed from KestraClient.java")
    return mapping


def _top_level_split(s: str, sep: str = ",") -> list[str]:
    out, depth, cur = [], 0, ""
    for ch in s:
        if ch in "(<[{":
            depth += 1
        elif ch in ")>]}":
            depth -= 1
        if ch == sep and depth == 0:
            out.append(cur.strip())
            cur = ""
        else:
            cur += ch
    if cur.strip():
        out.append(cur.strip())
    return out


def _param_name(param: str) -> str:
    """'@ann.Foo Bar<Baz, Qux> myName' -> 'myName'."""
    param = re.sub(r"@[\w.]+(\([^)]*\))?", "", param).strip()  # drop annotations
    m = re.search(r"([A-Za-z_][A-Za-z0-9_]*)\s*$", param)
    return m.group(1) if m else ""


def load_signatures() -> dict[str, dict[str, list[list[str]]]]:
    """class name -> method name -> list of overloads (each a param-name list)."""
    sigs: dict[str, dict[str, list[list[str]]]] = {}
    for path in glob.glob(os.path.join(API_DIR, "*.java")):
        cls = os.path.splitext(os.path.basename(path))[0]
        text = open(path, encoding="utf-8").read()
        methods: dict[str, list[list[str]]] = {}
        # public <return type ...> name( ... )   — return type may span generics
        for m in re.finditer(r"\bpublic\s+[^;{}]+?\b([A-Za-z_][A-Za-z0-9_]*)\s*\(", text):
            name = m.group(1)
            if name == cls:
                continue  # constructor, not a callable method on the API surface
            # capture balanced parentheses for the parameter list
            i = m.end() - 1
            depth = 0
            for j in range(i, len(text)):
                if text[j] == "(":
                    depth += 1
                elif text[j] == ")":
                    depth -= 1
                    if depth == 0:
                        params_src = text[i + 1 : j]
                        break
            else:
                continue
            params = [_param_name(p) for p in _top_level_split(params_src) if p.strip()]
            methods.setdefault(name, []).append(params)
        sigs[cls] = methods
    return sigs


def validate() -> list[str]:
    accessors = load_accessors()
    sigs = load_signatures()
    problems: list[str] = []

    for path in sorted(glob.glob(DOCS_GLOB)):
        rel = os.path.relpath(path, BASE)
        text = open(path, encoding="utf-8").read()
        for m in CALL_RE.finditer(text):
            accessor, method, argstr = m.group(1), m.group(2), m.group(3)
            lineno = text.count("\n", 0, m.start()) + 1
            where = f"{rel}:{lineno} {accessor}().{method}"
            if accessor not in accessors:
                problems.append(f"{where}: unknown KestraClient accessor '{accessor}()'")
                continue
            cls = accessors[accessor]
            overloads = sigs.get(cls, {}).get(method)
            if not overloads:
                problems.append(f"{where}: method '{method}' does not exist on {cls}")
                continue

            args = [a for a in _top_level_split(argstr) if a]
            # Accept if the args fit ANY overload (arity + name ordering).
            if any(_fits(args, params) for params in overloads):
                continue
            problems.append(
                f"{where}: call does not match any overload "
                f"(args: {args}, overloads: {overloads})"
            )

        cls_methods = sigs.get(os.path.splitext(os.path.basename(path))[0], {})
        for m in SIGNATURE_LINE_RE.finditer(text):
            method, argstr = m.group(1), m.group(2)
            overloads = cls_methods.get(method)
            if not overloads:
                continue
            documented = [a.strip() for a in _top_level_split(argstr) if a.strip()]
            if documented not in overloads:
                lineno = text.count("\n", 0, m.start()) + 1
                problems.append(
                    f"{rel}:{lineno} {method}: signature line lists {documented} but the "
                    f"overloads are {overloads}"
                )
    return problems


def _fits(args: list[str], params: list[str]) -> bool:
    """Does this positional-arg list fit the overload's parameter list?

    Java calls are all positional, so ``args`` and ``params`` line up index by
    index. We reject a call that passes *more* args than the overload declares
    (catches a removed/extra argument — the #222/#122 drift), and require every
    argument whose text is a bare identifier naming a real parameter to sit at
    that parameter's declared position (catches tenant-last ordering). Literal
    and expression args occupy their slot but cannot be name-checked.
    """
    if len(args) > len(params):
        return False
    for i, arg in enumerate(args):
        if re.fullmatch(r"[A-Za-z_][A-Za-z0-9_]*", arg) and arg in params and params.index(arg) != i:
            return False
    return True


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
