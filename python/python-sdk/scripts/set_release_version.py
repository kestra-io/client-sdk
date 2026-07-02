#!/usr/bin/env python3
"""Patch every committed copy of the SDK's package version to the given release version.

python-sdk-release.yml calls this right before packaging so the git tag (e.g.
v1.0.11-python) is the single source of truth for the published version,
instead of requiring a manual version-bump PR before every release. These are
the same fields generate-sdks.sh's packageVersion templating renders (see
python/template/*.mustache) -- patched here because the release workflow
builds from the committed source rather than a fresh generation.
"""
import re
import sys
from pathlib import Path

SDK_ROOT = Path(__file__).resolve().parent.parent


def patch(path: Path, pattern: str, replacement: str) -> None:
    text = path.read_text()
    new_text, count = re.subn(pattern, replacement, text, count=1, flags=re.MULTILINE)
    if count != 1:
        raise SystemExit(f"expected exactly 1 match for {pattern!r} in {path}, found {count}")
    path.write_text(new_text)


def main() -> None:
    version = sys.argv[1]
    patch(SDK_ROOT / "pyproject.toml", r'^version = ".*"$', f'version = "{version}"')
    patch(SDK_ROOT / "setup.py", r'^VERSION = ".*"$', f'VERSION = "{version}"')
    patch(SDK_ROOT / "kestrapy" / "__init__.py", r'^__version__ = ".*"$', f'__version__ = "{version}"')
    patch(SDK_ROOT / "kestrapy" / "configuration.py", r'SDK Package Version: [^"]*', f'SDK Package Version: {version}')
    patch(SDK_ROOT / "README.md", r'^- Package version: .*$', f'- Package version: {version}')


if __name__ == "__main__":
    main()
