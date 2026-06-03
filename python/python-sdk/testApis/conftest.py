import os
import re
import sys

import pytest
import requests

from kestrapy import KestraClient

# Make test_helpers importable from test files
sys.path.insert(0, os.path.dirname(__file__))

HOST = "http://localhost:9902"
ADMIN_USERNAME = "root@root.com"
ADMIN_PASSWORD = "Root!1234"
MAIN_TENANT = "main"

_CSRF_META_RE = re.compile(r'<meta name="csrf-token" content="([^"]+)">')


def _setup_super_admin():
    """Create the first super-admin and the main tenant.

    Kestra 2.0 dropped the config-based super-admin bootstrap; the first
    user is created through POST /api/v1/setup instead. A 405 means a user
    already exists, which the CI container never hits since it starts from
    an empty database on every run.
    """
    resp = requests.post(
        f"{HOST}/api/v1/setup",
        json={
            "username": ADMIN_USERNAME,
            "password": ADMIN_PASSWORD,
            "tenant": {"id": MAIN_TENANT, "name": MAIN_TENANT},
        },
        timeout=30,
    )
    if resp.status_code not in (200, 405):
        raise RuntimeError(f"setup failed: {resp.status_code} {resp.text[:2048]}")


def _mint_api_token(username, password):
    """Authenticate as the given user and return a freshly minted API token.

    Kestra 2.0 dropped per-request HTTP Basic auth, so all on one cookie jar:
      1. login -> JWT cookie;
      2. load the UI so StaticFilter sets the csrfToken cookie (a static GET
         emits no JWT Set-Cookie, so the session is untouched);
      3. create the token — the JWT cookie authenticates, and the
         X-CSRF-TOKEN header equals the server-set csrfToken cookie
         (double-submit check).
    """
    session = requests.Session()

    resp = session.post(
        f"{HOST}/login",
        json={"username": username, "password": password},
        timeout=30,
    )
    if resp.status_code != 200:
        raise RuntimeError(f"login({username}) failed: {resp.status_code} {resp.text[:2048]}")

    resp = session.get(f"{HOST}/ui/", timeout=30)
    match = _CSRF_META_RE.search(resp.text)
    if match is None:
        raise RuntimeError(
            f"no csrf token from /ui/ (status {resp.status_code}, html={'<html' in resp.text})"
        )
    csrf = match.group(1)

    resp = session.post(
        f"{HOST}/api/v1/me/api-tokens",
        json={"name": "ci-token", "maxAge": "P1D"},
        headers={"X-CSRF-TOKEN": csrf},
        timeout=30,
    )
    if resp.status_code not in (200, 201):
        raise RuntimeError(f"create api token failed: {resp.status_code} {resp.text[:2048]}")
    full_token = resp.json().get("fullToken")
    if not full_token:
        raise RuntimeError("api token response had no fullToken")
    return full_token


@pytest.fixture(scope="session")
def client():
    _setup_super_admin()
    token = _mint_api_token(ADMIN_USERNAME, ADMIN_PASSWORD)
    return KestraClient(host=HOST, token=token)
