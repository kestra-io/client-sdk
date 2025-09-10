# test_python_sdk
these are E2E tests to actually test the SDK when developing it, or in the CI

## how to run
use the script at [run-tests.sh](../run-tests.sh)

## utilities
### tips to run tests in local with nix-shell
```
# in python-sdk
nix-shell -p python3Full python3Packages.pytest --run '
  set -euo pipefail
  python -m venv .venv
  . .venv/bin/activate
  ./run-tests.sh
'
```

### tips to try out an already published kestrapy version
an example with nix-shell:
```
# in python-sdk/test_python_sdk
nix-shell -p python3Full python3Packages.pip python3Packages.pytest --run '
  set -euo pipefail
  python -m venv .venv
  . .venv/bin/activate

  pip install -r ../requirements.txt  && pip install kestrapy==1.0.0
  python -m pytest
'
```