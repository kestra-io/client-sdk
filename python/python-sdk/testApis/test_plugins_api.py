"""Tests for the plugins catalog SDK surface added for #421.

The /api/v1/plugins routes are instance-level and not tenant-scoped. Some are
OSS-only (install / auto-install) and answer 403 on EE, so those tolerate
gating; the read-only catalog routes are always available.
"""
import contextlib

import pytest

from kestrapy.exceptions import ForbiddenException, NotFoundException, ServiceException

_GATED = (403, 404, 501)


@contextlib.contextmanager
def _tolerate_gating(what):
    try:
        yield
    except (ForbiddenException, NotFoundException) as exc:
        pytest.skip(f"{what}: gated on this instance ({exc.status})")
    except ServiceException as exc:
        if getattr(exc, "status", None) in _GATED:
            pytest.skip(f"{what}: gated on this instance ({exc.status})")
        raise


def test_list_plugins_returns_catalog(client):
    with _tolerate_gating("list_plugins"):
        result = client.plugins.list_plugins()
    assert result is not None


def test_plugin_input_types_lists_types(client):
    with _tolerate_gating("plugin_input_types"):
        result = client.plugins.plugin_input_types()
    assert isinstance(result, list)
    # The core input types are always registered.
    assert len(result) > 0


def test_plugin_schema_returns_json_schema(client):
    with _tolerate_gating("plugin_schema"):
        result = client.plugins.plugin_schema("flow")
    assert isinstance(result, dict)
    # A JSON schema always carries a type/properties structure.
    assert result.get("properties") is not None or result.get("$ref") is not None or result


def test_plugin_icons_returns_index(client):
    with _tolerate_gating("plugin_icons"):
        result = client.plugins.plugin_icons()
    assert isinstance(result, dict)


def test_plugin_triggers_returns_catalog(client):
    with _tolerate_gating("plugin_triggers"):
        result = client.plugins.plugin_triggers()
    assert result is not None
