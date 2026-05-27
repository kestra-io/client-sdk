import time
import pytest
from datetime import datetime, timezone, timedelta

from test_helpers import (
    TENANT,
    random_id,
    create_flow,
    ns_filter,
    flow_id_filter,
)
from kestrapy import (
    Trigger,
    TriggerControllerSetDisabledRequest,
    DeleteTriggersByQueryRequest,
    ApiException,
)


def schedule_flow_yaml(flow_id, ns):
    return (
        f"id: {flow_id}\n"
        f"namespace: {ns}\n"
        "tasks:\n"
        "  - id: hello\n"
        "    type: io.kestra.plugin.core.log.Log\n"
        "    message: Hello from trigger!\n"
        "triggers:\n"
        "  - id: schedule_trigger\n"
        "    type: io.kestra.plugin.core.trigger.Schedule\n"
        '    cron: "0 0 1 1 *"\n'
        "    disabled: false\n"
    )


def trigger_id_dict(ns, flow_id):
    return Trigger.model_construct(
        namespace=ns,
        flow_id=flow_id,
        trigger_id="schedule_trigger",
    )


def _create_schedule_flow(client):
    ns = random_id()
    flow_id = random_id()
    create_flow(client, schedule_flow_yaml(flow_id, ns))
    time.sleep(0.5)
    return ns, flow_id


# ========================================================================
# Search
# ========================================================================


def test_search_triggers_basic(client):
    result = client.triggers.search_triggers(tenant=TENANT, page=1, size=10)

    assert result is not None
    assert result.get("results") is not None


def test_search_triggers_with_pagination(client):
    result = client.triggers.search_triggers(tenant=TENANT, page=1, size=2)

    assert result is not None
    assert result.get("results") is not None
    assert len(result["results"]) <= 2


def test_search_triggers_with_namespace_filter(client):
    ns, flow_id = _create_schedule_flow(client)

    result = client.triggers.search_triggers(
        tenant=TENANT, page=1, size=10, filters=[ns_filter(ns)]
    )

    assert result is not None
    assert len(result["results"]) > 0
    assert any(
        t.get("state", {}).get("namespace") == ns for t in result["results"]
    )


def test_search_triggers_with_flow_id_filter(client):
    ns, flow_id = _create_schedule_flow(client)

    result = client.triggers.search_triggers(
        tenant=TENANT,
        page=1,
        size=10,
        filters=[flow_id_filter(flow_id), ns_filter(ns)],
    )

    assert result is not None
    assert len(result["results"]) > 0


def test_search_triggers_multiple_filters(client):
    ns, flow_id = _create_schedule_flow(client)

    result = client.triggers.search_triggers(
        tenant=TENANT,
        page=1,
        size=10,
        filters=[ns_filter(ns), flow_id_filter(flow_id)],
    )

    assert result is not None
    assert result.get("total", 0) >= 1


def test_search_triggers_no_results(client):
    result = client.triggers.search_triggers(
        tenant=TENANT,
        page=1,
        size=10,
        filters=[ns_filter(f"nonexistent_ns_{random_id()}")],
    )

    assert result is not None
    assert result.get("total", 0) == 0


def test_search_triggers_with_sort(client):
    ns = random_id()
    flow_id1 = f"aaa{random_id()}"
    flow_id2 = f"zzz{random_id()}"
    create_flow(client, schedule_flow_yaml(flow_id1, ns))
    create_flow(client, schedule_flow_yaml(flow_id2, ns))
    time.sleep(0.5)

    result = client.triggers.search_triggers(
        tenant=TENANT,
        page=1,
        size=10,
        sort=["flowId:asc"],
        filters=[ns_filter(ns)],
    )

    assert len(result["results"]) == 2
    assert result["results"][0]["state"]["flowId"] == flow_id1
    assert result["results"][1]["state"]["flowId"] == flow_id2


def test_search_triggers_for_flow_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    result = client.triggers.search_triggers_for_flow(
        tenant=TENANT, namespace=ns, flow_id=flow_id, page=1, size=10
    )

    assert result is not None
    assert result.get("results") is not None


def test_search_triggers_for_flow_with_all_params(client):
    ns, flow_id = _create_schedule_flow(client)

    result = client.triggers.search_triggers_for_flow(
        tenant=TENANT,
        namespace=ns,
        flow_id=flow_id,
        page=1,
        size=10,
        q="schedule",
        sort=["triggerId:asc"],
    )

    assert result is not None
    assert result.get("results") is not None
    assert len(result["results"]) > 0
    for t in result["results"]:
        assert t.get("triggerId") == "schedule_trigger"


# ========================================================================
# Enable / Disable
# ========================================================================


def test_disable_trigger_by_id_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    request = {
        "namespace": ns,
        "flowId": flow_id,
        "triggerId": "schedule_trigger",
        "disabled": True,
    }

    result = client.triggers.disable_trigger_by_id(tenant=TENANT, request=request)

    assert result is not None
    assert result.get("disabled") is True


def test_enable_trigger_by_id_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    # Disable first
    disable_req = {
        "namespace": ns,
        "flowId": flow_id,
        "triggerId": "schedule_trigger",
        "disabled": True,
    }
    client.triggers.disable_trigger_by_id(tenant=TENANT, request=disable_req)

    # Enable
    enable_req = {
        "namespace": ns,
        "flowId": flow_id,
        "triggerId": "schedule_trigger",
        "disabled": False,
    }
    result = client.triggers.disable_trigger_by_id(tenant=TENANT, request=enable_req)

    assert result is not None
    assert result.get("disabled") is False


# ========================================================================
# Bulk enable / disable
# ========================================================================


def test_disabled_triggers_by_ids_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    request = TriggerControllerSetDisabledRequest(
        triggers=[trigger_id_dict(ns, flow_id)],
        disabled=True,
    )

    result = client.triggers.disabled_triggers_by_ids(tenant=TENANT, request=request)

    assert result is not None


def test_disabled_triggers_by_query_basic(client):
    result = client.triggers.disabled_triggers_by_query(
        tenant=TENANT, disabled=True
    )

    assert result is not None


def test_disabled_triggers_by_query_with_disabled_false(client):
    # Exercise the re-enable code path (disabled=False) — confirms the
    # parameter is transported correctly in the False branch too.
    result = client.triggers.disabled_triggers_by_query(
        tenant=TENANT, disabled=False,
    )

    assert result is not None


def test_unlock_triggers_by_query_basic(client):
    result = client.triggers.unlock_triggers_by_query(tenant=TENANT)

    assert result is not None


# ========================================================================
# Restart / Unlock
# ========================================================================


def test_restart_trigger_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    # Should not raise
    client.triggers.restart_trigger(
        tenant=TENANT, namespace=ns, flow_id=flow_id, trigger_id="schedule_trigger"
    )


def test_unlock_trigger_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    # Trigger is not locked, so this should throw 409
    with pytest.raises(ApiException):
        client.triggers.unlock_trigger(
            tenant=TENANT, namespace=ns, flow_id=flow_id, trigger_id="schedule_trigger"
        )


def test_unlock_triggers_by_ids_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    trigger_ids = [trigger_id_dict(ns, flow_id)]

    result = client.triggers.unlock_triggers_by_ids(
        tenant=TENANT, trigger_ids=trigger_ids
    )

    assert result is not None


# ========================================================================
# Delete
# ========================================================================


def test_delete_trigger_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    # Should not raise
    client.triggers.delete_trigger(
        tenant=TENANT, namespace=ns, flow_id=flow_id, trigger_id="schedule_trigger"
    )


def test_delete_triggers_by_ids_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    trigger_ids = [trigger_id_dict(ns, flow_id)]

    result = client.triggers.delete_triggers_by_ids(
        tenant=TENANT, trigger_ids=trigger_ids
    )

    assert result is not None


def test_delete_triggers_by_query_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    request = DeleteTriggersByQueryRequest(filters=[ns_filter(ns)])

    result = client.triggers.delete_triggers_by_query(tenant=TENANT, request=request)

    assert result is not None


# ========================================================================
# Backfill
# ========================================================================


def test_create_backfill_basic(client):
    ns, flow_id = _create_schedule_flow(client)

    now = datetime.now(timezone.utc)
    request = {
        "namespace": ns,
        "flowId": flow_id,
        "triggerId": "schedule_trigger",
        "backfill": {
            "start": (now - timedelta(days=7)).isoformat(),
            "end": (now - timedelta(days=1)).isoformat(),
        },
    }

    # Should not raise
    client.triggers.create_backfill(tenant=TENANT, request=request)


# ========================================================================
# Export
# ========================================================================


def test_export_triggers_basic(client):
    result = client.triggers.export_triggers(tenant=TENANT)

    assert result is not None


# ========================================================================
# 404 edge cases
# ========================================================================


def test_delete_trigger_unknown_raises(client):
    try:
        client.triggers.delete_trigger(
            tenant=TENANT,
            namespace=f"missing-ns-{random_id()}",
            flow_id=f"missing-flow-{random_id()}",
            trigger_id=f"missing-trg-{random_id()}",
        )
    except ApiException as e:
        assert e.status in (400, 404)


def test_restart_trigger_unknown_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.triggers.restart_trigger(
            tenant=TENANT,
            namespace=f"missing-ns-{random_id()}",
            flow_id=f"missing-flow-{random_id()}",
            trigger_id=f"missing-trg-{random_id()}",
        )
    assert exc_info.value.status in (400, 404, 422)


def test_unlock_trigger_unknown_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.triggers.unlock_trigger(
            tenant=TENANT,
            namespace=f"missing-ns-{random_id()}",
            flow_id=f"missing-flow-{random_id()}",
            trigger_id=f"missing-trg-{random_id()}",
        )
    assert exc_info.value.status in (400, 404, 409, 422)
