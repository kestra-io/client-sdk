import pytest

from kestrapy import KVControllerApiDeleteBulkRequest
from kestrapy.exceptions import ApiException
from test_helpers import (
    TENANT, random_id, random_namespace, register_namespace, log_flow_yaml, create_flow, ns_filter,
)


# ========================================================================
# Set & Get
# ========================================================================

def test_set_and_get_key_value_string(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "mykey", TENANT, '"hello world"')

    detail = client.kv.key_value(ns, "mykey", TENANT)
    assert detail is not None
    assert detail.type is not None
    assert detail.value == "hello world"


def test_set_and_get_key_value_number(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "count", TENANT, "42")

    detail = client.kv.key_value(ns, "count", TENANT)
    assert detail is not None
    assert int(detail.value) == 42


def test_set_and_get_key_value_json_object(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "obj", TENANT, '{"foo":"bar"}')

    detail = client.kv.key_value(ns, "obj", TENANT)
    assert detail is not None
    assert isinstance(detail.value, dict)
    assert detail.value["foo"] == "bar"


def test_set_and_get_key_value_json_array(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "arr", TENANT, "[1,2,3]")

    detail = client.kv.key_value(ns, "arr", TENANT)
    assert detail is not None
    assert isinstance(detail.value, list)
    assert len(detail.value) == 3


def test_set_key_value_overwrite(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "key1", TENANT, '"first"')
    client.kv.set_key_value(ns, "key1", TENANT, '"second"')

    detail = client.kv.key_value(ns, "key1", TENANT)
    assert detail is not None
    assert detail.value == "second"


def test_key_value_not_found(client):
    with pytest.raises(ApiException):
        client.kv.key_value("nonexistent_ns_" + random_id(), "nonexistent", TENANT)


# ========================================================================
# Delete
# ========================================================================

def test_delete_key_value_existing(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "todelete", TENANT, '"value"')
    result = client.kv.delete_key_value(ns, "todelete", TENANT)
    assert result is True


def test_delete_key_value_nonexistent(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    result = client.kv.delete_key_value(ns, "nonexistent", TENANT)
    assert result is False


def test_delete_key_values_bulk(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "k1", TENANT, '"v1"')
    client.kv.set_key_value(ns, "k2", TENANT, '"v2"')

    request = KVControllerApiDeleteBulkRequest(keys=["k1", "k2"])
    resp = client.kv.delete_key_values(ns, TENANT, request)
    assert resp is not None


# ========================================================================
# List & Search
# ========================================================================

def test_list_all_keys_basic(client):
    result = client.kv.list_all_keys(TENANT, 1, 10)
    assert result is not None
    assert result.results is not None


def test_list_all_keys_with_pagination(client):
    result = client.kv.list_all_keys(TENANT, 1, 5)
    assert result is not None


def test_list_all_keys_with_namespace_filter(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "filtered_key", TENANT, '"filtered_value"')

    result = client.kv.list_all_keys(TENANT, 1, 10, filters=[ns_filter(ns)])
    assert result is not None
    assert len(result.results) > 0
    assert any(e.key == "filtered_key" for e in result.results)


def test_list_all_keys_with_sort(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.kv.set_key_value(ns, "zzz_key", TENANT, '"val1"')
    client.kv.set_key_value(ns, "aaa_key", TENANT, '"val2"')

    result = client.kv.list_all_keys(TENANT, 1, 10, sort=["key:asc"], filters=[ns_filter(ns)])
    assert len(result.results) == 2
    assert result.results[0].key == "aaa_key"
    assert result.results[1].key == "zzz_key"


def test_list_all_keys_no_results(client):
    result = client.kv.list_all_keys(TENANT, 1, 10, filters=[ns_filter("nonexistent_ns_" + random_id())])
    assert result is not None
    assert len(result.results) == 0


def test_list_keys_with_inheritance_basic(client):
    parent_ns = random_namespace()
    child_ns = register_namespace(parent_ns + "." + random_id())
    create_flow(client, log_flow_yaml(random_id(), parent_ns))
    create_flow(client, log_flow_yaml(random_id(), child_ns))

    client.kv.set_key_value(parent_ns, "parent_key", TENANT, '"value"')

    keys = client.kv.list_keys_with_inheritance(child_ns, TENANT)
    assert keys is not None
    assert any(k.key == "parent_key" for k in keys)


def test_list_keys_with_inheritance_empty_namespace(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    keys = client.kv.list_keys_with_inheritance(ns, TENANT)
    assert keys is not None
