#!/usr/bin/env python3
"""Embed CI-tested source regions into Markdown docs (single source of truth).

This is the language-agnostic injector described in
`design/examples-as-source-of-truth.md`. It keeps the example snippets in the
READMEs physically identical to code that the test suites compile/run, so the
docs can never silently drift from the SDK (the root cause of issue #144).

Usage
-----
    python test-utils/embed_snippets.py --write   README_PYTHON_SDK.md ...
    python test-utils/embed_snippets.py --check    README_PYTHON_SDK.md ...

`--check` is the CI gate: it exits non-zero (without modifying anything) if any
doc is out of sync with its source region.

Conventions
-----------
In a *source* file, mark a region with line comments (any of `#`, `//`, `--`):

    # region:search-and-create
    page = client.flows.search_flows(tenant, page=1, size=10)
    # endregion

In a *Markdown* file, declare where it goes:

    <!-- snippet:search-and-create src=path/to/example.py lang=python -->
    ```python
    (auto-managed — do not edit by hand)
    ```
    <!-- /snippet -->

`src` is resolved relative to the repo root (the parent of `test-utils/`). The
region body is dedented before insertion; `lang` only sets the fence language.
"""
from __future__ import annotations

import argparse
import os
import re
import sys
import textwrap

REPO_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

# <!-- snippet:NAME src=... [lang=...] --> ... <!-- /snippet -->
_SNIPPET_RE = re.compile(
    r"(?P<open><!--\s*snippet:(?P<name>[\w.-]+)\s+(?P<attrs>[^>]*?)-->[ \t]*\n)"
    r"(?P<body>.*?)"
    r"(?P<close>[ \t]*<!--\s*/snippet\s*-->)",
    re.DOTALL,
)
_ATTR_RE = re.compile(r"(\w+)=(\S+)")


def _comment_stripped(line: str) -> str:
    """Drop a leading line-comment marker so region tags are recognised."""
    return re.sub(r"^\s*(?:#|//|--)\s?", "", line).strip()


def extract_region(src_path: str, name: str) -> str:
    with open(src_path, encoding="utf-8") as fh:
        lines = fh.read().splitlines()
    start = end = None
    for i, line in enumerate(lines):
        tag = _comment_stripped(line)
        if tag in (f"region:{name}", f"region {name}"):
            start = i + 1
        elif start is not None and tag in ("endregion", f"endregion {name}", f"endregion:{name}"):
            end = i
            break
    if start is None or end is None:
        raise KeyError(f"region '{name}' not found in {src_path}")
    # textwrap.dedent strips only the *common* leading whitespace, so it never
    # corrupts the interior indentation of a multi-line string literal. Author
    # regions so they dedent cleanly (e.g. don't open a heredoc at column 0).
    body = "\n".join(lines[start:end])
    return textwrap.dedent(body).strip("\n")


def render(markdown: str) -> str:
    def repl(m: re.Match) -> str:
        attrs = dict(_ATTR_RE.findall(m.group("attrs")))
        src = attrs.get("src")
        if not src:
            raise ValueError(f"snippet '{m.group('name')}' is missing a src= attribute")
        lang = attrs.get("lang", "")
        region = extract_region(os.path.join(REPO_ROOT, src), m.group("name"))
        fenced = f"```{lang}\n{region}\n```\n"
        return f"{m.group('open')}{fenced}{m.group('close')}"

    return _SNIPPET_RE.sub(repl, markdown)


def process(path: str, write: bool) -> bool:
    """Return True if `path` is already up to date."""
    with open(path, encoding="utf-8") as fh:
        original = fh.read()
    updated = render(original)
    if updated == original:
        return True
    if write:
        with open(path, "w", encoding="utf-8") as fh:
            fh.write(updated)
        print(f"updated {path}")
    else:
        print(f"OUT OF SYNC: {path} (run with --write to fix)")
    return False


def main(argv: list[str]) -> int:
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    mode = ap.add_mutually_exclusive_group(required=True)
    mode.add_argument("--write", action="store_true", help="rewrite docs in place")
    mode.add_argument("--check", action="store_true", help="fail if any doc is out of sync")
    ap.add_argument("files", nargs="+", help="Markdown files to process")
    args = ap.parse_args(argv)

    in_sync = [process(f, write=args.write) for f in args.files]
    if args.check and not all(in_sync):
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv[1:]))
