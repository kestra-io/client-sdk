"""Guards scripts/set_release_version.py against version-field format drift.

Copies the real committed files (proving today's format matches the script's
regexes) plus the real script (no duplicated logic to drift out of sync), then
runs it exactly as python-sdk-release.yml does.
"""
import shutil
import subprocess
import sys
from pathlib import Path

SDK_ROOT = Path(__file__).parent.parent
PATCHED_FILES = [
    Path("pyproject.toml"),
    Path("setup.py"),
    Path("README.md"),
    Path("kestrapy", "__init__.py"),
    Path("kestrapy", "configuration.py"),
]


def test_set_release_version_patches_every_version_field(tmp_path):
    sdk_root = tmp_path / "python-sdk"
    (sdk_root / "scripts").mkdir(parents=True)
    (sdk_root / "kestrapy").mkdir()
    shutil.copy(SDK_ROOT / "scripts" / "set_release_version.py", sdk_root / "scripts" / "set_release_version.py")
    for rel in PATCHED_FILES:
        shutil.copy(SDK_ROOT / rel, sdk_root / rel)

    subprocess.run(
        [sys.executable, str(sdk_root / "scripts" / "set_release_version.py"), "9.9.9"],
        cwd=sdk_root,
        check=True,
    )

    assert 'version = "9.9.9"' in (sdk_root / "pyproject.toml").read_text()
    assert 'VERSION = "9.9.9"' in (sdk_root / "setup.py").read_text()
    assert "- Package version: 9.9.9" in (sdk_root / "README.md").read_text()
    assert '__version__ = "9.9.9"' in (sdk_root / "kestrapy" / "__init__.py").read_text()
    assert "SDK Package Version: 9.9.9" in (sdk_root / "kestrapy" / "configuration.py").read_text()
