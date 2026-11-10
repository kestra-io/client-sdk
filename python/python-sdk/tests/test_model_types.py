"""Pure model decode tests — no live Kestra server required."""

from kestrapy.models.type import Type
from kestrapy.models.input_object import InputObject
from kestrapy.models.flow import Flow
from kestrapy.models.state_type import StateType
from kestrapy.models.daily_execution_statistics_execution_counts import DailyExecutionStatisticsExecutionCounts
from kestrapy.models.iam_tenant_access_controller_api_user_permission import IAMTenantAccessControllerApiUserPermission
from kestrapy.models.resource import Resource
from kestrapy.models.action import Action
from kestrapy.models.case_event_type import CaseEventType


def test_type_form_value_exists():
    assert Type("FORM") == Type.FORM


def test_input_object_decodes_form_type():
    obj = InputObject.from_dict({"id": "myform", "type": "FORM"})
    assert obj.type == Type.FORM


def test_flow_decodes_input_with_form_type():
    flow = Flow.from_dict({
        "id": "f",
        "namespace": "ns",
        "disabled": False,
        "deleted": False,
        "draft": False,
        "tasks": [{"id": "t", "type": "io.kestra.plugin.core.log.Log"}],
        "inputs": [{"id": "myform", "type": "FORM"}],
    })
    assert flow.inputs[0].type == Type.FORM


def test_validate_scalar_coerces_and_caches_adapters():
    from datetime import datetime, timezone
    from typing import Optional

    from kestrapy.base_api import BaseApi, _cached_scalar_adapter

    _cached_scalar_adapter.cache_clear()
    for _ in range(3):
        value = BaseApi._validate_scalar("2026-09-24T10:00:00Z", Optional[datetime])
    assert value == datetime(2026, 9, 24, 10, 0, tzinfo=timezone.utc)
    # One adapter built for the annotation, reused on every later call.
    info = _cached_scalar_adapter.cache_info()
    assert (info.misses, info.hits) == (1, 2)

    # A value that does not validate is kept as-is.
    assert BaseApi._validate_scalar("not-a-date", datetime) == "not-a-date"


def test_state_type_pausing_value_exists():
    assert StateType("PAUSING") == StateType.PAUSING


def test_daily_execution_counts_reads_pausing():
    counts = DailyExecutionStatisticsExecutionCounts.from_dict({"PAUSING": 3})
    assert counts.pausing == 3


def test_user_permission_reads_every_action_the_server_sends():
    permission = IAMTenantAccessControllerApiUserPermission.from_dict(
        {"resource": "CASE", "actions": ["VIEW", "LIST", "REVIEW", "UPDATE_CONCURRENCY_LIMIT"]}
    )
    assert permission.resource == Resource.CASE
    assert permission.actions[2] == Action.REVIEW


def test_case_event_type_reads_the_approval_and_ticket_events():
    for value in ["APPROVAL_DECIDED", "TICKET_LINKED", "TICKET_UNLINKED"]:
        assert CaseEventType(value).value == value
