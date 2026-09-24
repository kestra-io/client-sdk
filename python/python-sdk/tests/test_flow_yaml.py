# coding: utf-8

"""Unit tests for the object -> YAML serialization used by
``create_flow_from_object`` / ``update_flow_from_object``.

These are pure serialization tests: no live Kestra server is involved.
"""

import json
from datetime import datetime, timezone
from enum import Enum
from pathlib import Path

import pytest
import yaml

from kestrapy.flow_yaml import flow_to_yaml
from kestrapy.models.flow import Flow
from kestrapy.models.task import Task


def _build_flow() -> Flow:
    # A Log task carries the plugin-specific `message` property; a Sequential
    # task carries a plugin-specific `tasks` list holding a Shell task with a
    # multi-line `commands` list. Plugin props are free-form additional props.
    log_task = Task.from_dict({
        "id": "log",
        "type": "io.kestra.plugin.core.log.Log",
        "message": "Hello {{ inputs.name }}",
    })
    shell_task = {
        "id": "shell",
        "type": "io.kestra.plugin.scripts.shell.Commands",
        "commands": ["echo one", "echo two"],
        "script": "echo start\necho done",
    }
    sequential = Task.from_dict({
        "id": "seq",
        "type": "io.kestra.plugin.core.flow.Sequential",
        "tasks": [shell_task],
    })
    return Flow.from_dict({
        "id": "my-flow",
        "namespace": "company.team",
        "disabled": False,
        "draft": False,
        "deleted": False,
        "labels": [{"key": "env", "value": "prod"}],
        "tasks": [log_task, sequential],
    })


def test_plugin_properties_survive_serialization():
    yaml_str = flow_to_yaml(_build_flow())

    # Plugin-specific properties must be present in the emitted YAML.
    assert "message:" in yaml_str
    assert "io.kestra.plugin.core.log.Log" in yaml_str
    assert "commands:" in yaml_str

    # Kestra expressions must not be mangled.
    assert "{{ inputs.name }}" in yaml_str

    # Non-ASCII / block style sanity: no flow-style braces at task level, no
    # python object tags.
    assert "!!python" not in yaml_str


def test_round_trip_preserves_real_values():
    parsed = yaml.safe_load(flow_to_yaml(_build_flow()))

    assert parsed["id"] == "my-flow"
    assert parsed["namespace"] == "company.team"

    log = parsed["tasks"][0]
    assert log["id"] == "log"
    assert log["type"] == "io.kestra.plugin.core.log.Log"
    assert log["message"] == "Hello {{ inputs.name }}"

    seq = parsed["tasks"][1]
    assert seq["type"] == "io.kestra.plugin.core.flow.Sequential"
    nested = seq["tasks"][0]
    assert nested["id"] == "shell"
    assert nested["commands"] == ["echo one", "echo two"]
    # Multi-line string round-trips intact.
    assert nested["script"] == "echo start\necho done"

    assert parsed["labels"] == [{"key": "env", "value": "prod"}]


def test_dict_input_is_supported():
    flow_dict = {
        "id": "dict-flow",
        "namespace": "company.team",
        "disabled": False,
        "draft": False,
        "deleted": False,
        "tasks": [
            {
                "id": "hello",
                "type": "io.kestra.plugin.core.log.Log",
                "message": "grüß gott",  # non-ASCII must not be escaped
            }
        ],
    }
    yaml_str = flow_to_yaml(flow_dict)

    assert "\\u" not in yaml_str  # non-ASCII kept verbatim
    assert "grüß gott" in yaml_str

    parsed = yaml.safe_load(yaml_str)
    assert parsed["tasks"][0]["message"] == "grüß gott"


def test_excludes_server_managed_fields():
    # _build_flow sets draft/deleted (both False, so they would otherwise be
    # emitted); revision/tenantId/updated must never appear in flow source either.
    flow = Flow.from_dict({
        "id": "my-flow",
        "namespace": "company.team",
        "disabled": False,
        "draft": False,
        "deleted": False,
        "revision": 7,
        "tasks": [{"id": "log", "type": "io.kestra.plugin.core.log.Log"}],
    })
    yaml_str = flow_to_yaml(flow)

    for needle in ("draft:", "deleted:", "revision:"):
        assert needle not in yaml_str, f"{needle} must not appear in flow source"

    parsed = yaml.safe_load(yaml_str)
    for key in ("draft", "deleted", "revision", "tenantId", "source", "updated"):
        assert key not in parsed, f"{key} must be stripped from flow source"


def test_no_anchors_for_shared_references():
    # The same nested dict referenced twice must be expanded, not emitted as a
    # YAML anchor/alias (&id / *id).
    shared = {"retry": {"type": "constant", "interval": "PT1S"}}
    flow_dict = {
        "id": "shared-flow",
        "namespace": "company.team",
        "tasks": [
            {"id": "a", "type": "io.kestra.plugin.core.log.Log", **shared},
            {"id": "b", "type": "io.kestra.plugin.core.log.Log", **shared},
        ],
    }
    # Reference the exact same object twice to trigger aliasing if not disabled.
    flow_dict["tasks"][0]["retry"] = shared["retry"]
    flow_dict["tasks"][1]["retry"] = shared["retry"]

    yaml_str = flow_to_yaml(flow_dict)
    assert "&" not in yaml_str, f"unexpected YAML anchor:\n{yaml_str}"
    assert "*" not in yaml_str, f"unexpected YAML alias:\n{yaml_str}"

    parsed = yaml.safe_load(yaml_str)
    assert parsed["tasks"][0]["retry"] == {"type": "constant", "interval": "PT1S"}
    assert parsed["tasks"][1]["retry"] == {"type": "constant", "interval": "PT1S"}


def test_dict_input_with_nested_non_primitives():
    # The ergonomic dict path must convert non-primitive values (nested model
    # instances, enums, datetimes) at any depth without raising RepresenterError.
    class _Level(str, Enum):
        INFO = "INFO"

    nested_model = Task.from_dict({
        "id": "log",
        "type": "io.kestra.plugin.core.log.Log",
        "message": "hi",
    })
    flow_dict = {
        "id": "mixed-flow",
        "namespace": "company.team",
        "created": datetime(2026, 1, 2, 3, 4, 5, tzinfo=timezone.utc),
        "tasks": [
            nested_model,  # a model instance nested in a dict input
            {
                "id": "shell",
                "type": "io.kestra.plugin.scripts.shell.Commands",
                "level": _Level.INFO,  # an enum nested inside a task dict
            },
        ],
    }

    yaml_str = flow_to_yaml(flow_dict)  # must not raise
    parsed = yaml.safe_load(yaml_str)

    assert parsed["created"] == "2026-01-02T03:04:05+00:00"
    assert parsed["tasks"][0]["id"] == "log"
    assert parsed["tasks"][0]["message"] == "hi"
    assert parsed["tasks"][1]["level"] == "INFO"


def test_dict_input_drops_none_at_every_depth():
    flow_dict = {
        "id": "x",
        "namespace": "y",
        "description": None,          # top-level None
        "labels": None,              # top-level None
        "tasks": [
            {
                "id": "log",
                "type": "io.kestra.plugin.core.log.Log",
                "message": "hi",
                "timeout": None,     # nested None inside a task
                "retry": {"type": "constant", "maxAttempt": None},  # deeper None
            }
        ],
    }
    yaml_str = flow_to_yaml(flow_dict)

    assert "null" not in yaml_str, yaml_str
    assert "description" not in yaml_str
    assert "labels" not in yaml_str

    parsed = yaml.safe_load(yaml_str)
    assert "description" not in parsed
    assert "labels" not in parsed
    task = parsed["tasks"][0]
    assert "timeout" not in task
    assert "maxAttempt" not in task["retry"]
    # Real values survive.
    assert task["message"] == "hi"
    assert task["retry"]["type"] == "constant"


def test_bytes_value_is_decoded():
    yaml_str = flow_to_yaml({
        "id": "b",
        "namespace": "y",
        "tasks": [{"id": "t", "type": "io.kestra.plugin.core.log.Log", "message": b"bytes-msg"}],
    })
    parsed = yaml.safe_load(yaml_str)
    assert parsed["tasks"][0]["message"] == "bytes-msg"


def test_unsupported_type_raises_clear_type_error():
    class _Weird:
        pass

    with pytest.raises(TypeError, match="_Weird"):
        flow_to_yaml({
            "id": "w",
            "namespace": "y",
            "tasks": [{"id": "t", "type": "io.kestra.plugin.core.log.Log", "obj": _Weird()}],
        })


def test_none_input_raises_type_error():
    with pytest.raises(TypeError):
        flow_to_yaml(None)


def test_multiline_emitted_as_block_scalar():
    flow_dict = {
        "id": "ml-flow",
        "namespace": "company.team",
        "disabled": False,
        "draft": False,
        "deleted": False,
        "tasks": [
            {
                "id": "shell",
                "type": "io.kestra.plugin.scripts.shell.Commands",
                "script": "line1\nline2\nline3",
            }
        ],
    }
    yaml_str = flow_to_yaml(flow_dict)
    # Literal block scalar indicator for the multi-line string.
    assert "script: |" in yaml_str


def _load_ambiguous_strings_fixture() -> dict:
    """Load test-utils/yaml-ambiguous-strings.json, the contract shared by all
    four SDKs: strings a YAML 1.1 / Jackson reader (Kestra's server) would
    re-type to a boolean, null, number or timestamp must be emitted quoted;
    ordinary strings stay plain."""
    for parent in Path(__file__).resolve().parents:
        candidate = parent / "test-utils" / "yaml-ambiguous-strings.json"
        if candidate.is_file():
            return json.loads(candidate.read_text())
    raise FileNotFoundError("Could not locate test-utils/yaml-ambiguous-strings.json")


_AMBIGUOUS = _load_ambiguous_strings_fixture()
_MUST_QUOTE = _AMBIGUOUS["mustQuote"]
_STAYS_PLAIN = _AMBIGUOUS["staysPlain"]


def test_ambiguous_strings_are_quoted_and_round_trip():
    # An empty key is left out: emitters write it in their own form, which
    # still reads back as "".
    keyed = {s: "k" for s in _MUST_QUOTE if s}
    out = flow_to_yaml({
        "id": "tricky",
        "namespace": "company.team",
        "labels": {"approved": "yes"},
        "tasks": [{
            "id": "out",
            "type": "io.kestra.plugin.core.output.OutputValues",
            "values": list(_MUST_QUOTE),
            "keyed": keyed,
            "plain": list(_STAYS_PLAIN),
        }],
    })

    lines = out.splitlines()
    start = lines.index("  values:") + 1
    value_lines = lines[start:start + len(_MUST_QUOTE)]
    for s, line in zip(_MUST_QUOTE, value_lines):
        # Either quote style is fine; a plain scalar is not.
        assert line in (f'  - "{s}"', f"  - '{s}'"), (s, out)
    for s in keyed:
        assert f'    "{s}": k' in lines or f"    '{s}': k" in lines, (s, out)
    for s in _STAYS_PLAIN:
        assert f"  - {s}" in lines, (s, out)
    assert '  approved: "yes"' in lines, out

    # PyYAML's safe_load is a YAML 1.1 reader: every value and key comes back
    # as the exact original string.
    parsed = yaml.safe_load(out)
    assert parsed["tasks"][0]["values"] == _MUST_QUOTE
    assert parsed["tasks"][0]["keyed"] == keyed
    assert parsed["tasks"][0]["plain"] == _STAYS_PLAIN
    assert parsed["labels"]["approved"] == "yes"


def test_long_lines_are_not_folded():
    long_text = " ".join(["a very long single line description"] * 5)
    long_expr = "{{ " + "x" * 120 + " }}"
    out = flow_to_yaml({
        "id": "long",
        "namespace": "company.team",
        "description": long_text,
        "tasks": [{"id": "t", "type": "io.kestra.plugin.core.log.Log", "message": long_expr}],
    })

    assert f"description: {long_text}\n" in out, out
    assert f"message: '{long_expr}'" in out, out
    parsed = yaml.safe_load(out)
    assert parsed["description"] == long_text
    assert parsed["tasks"][0]["message"] == long_expr


def test_ordinary_strings_keep_their_styles():
    out = flow_to_yaml({
        "id": "plain",
        "namespace": "company.team",
        "tasks": [{
            "id": "t",
            "type": "io.kestra.plugin.core.log.Log",
            "message": "hello world",
            "expr": "{{ inputs.x }}",
            "script": "a\nb",
        }],
    })
    assert "  message: hello world\n" in out
    assert "  expr: '{{ inputs.x }}'\n" in out
    assert "  script: |-\n    a\n    b\n" in out


def _server_flow_payload():
    # Shape of a real GET /flows/{namespace}/{id} response: the trigger carries
    # no `when` (the 2.0 spec marks it required, the server never sends it).
    return {
        "id": "sched-flow",
        "namespace": "company.team",
        "revision": 1,
        "updated": "2026-09-23T10:11:12.345Z",
        "disabled": False,
        "deleted": False,
        "draft": False,
        "tasks": [{"id": "log", "type": "io.kestra.plugin.core.log.Log", "message": "hi"}],
        "triggers": [{
            "id": "sched",
            "type": "io.kestra.plugin.core.trigger.Schedule",
            "disabled": True,
            "cron": "0 0 1 1 *",
            "timezone": "Europe/Paris",
        }],
        "source": "id: sched-flow\n",
    }


def test_server_trigger_without_when_round_trips_plugin_props():
    from kestrapy.base_api import BaseApi
    from kestrapy.models.flow_with_source import FlowWithSource

    got = BaseApi._deserialize(_server_flow_payload(), FlowWithSource)
    trigger = got.triggers[0]
    assert trigger.when is None
    assert trigger.additional_properties == {"cron": "0 0 1 1 *", "timezone": "Europe/Paris"}
    assert isinstance(got.updated, datetime)

    out = flow_to_yaml(got)
    parsed = yaml.safe_load(out)
    assert parsed["triggers"] == [{
        "id": "sched",
        "type": "io.kestra.plugin.core.trigger.Schedule",
        "disabled": True,
        "cron": "0 0 1 1 *",
        "timezone": "Europe/Paris",
    }]
    assert "when" not in out


def test_construct_model_fallback_keeps_undeclared_keys():
    # If from_dict() ever fails again (spec/server drift), the fallback must not
    # silently drop plugin-specific keys nor leave timestamps as raw strings.
    from kestrapy.base_api import BaseApi
    from kestrapy.models.abstract_trigger import AbstractTrigger
    from kestrapy.models.flow_with_source import FlowWithSource

    payload = _server_flow_payload()
    payload["triggers"][0]["disabled"] = "not-a-bool"  # forces from_dict() to fail
    trigger = BaseApi._construct_model(payload["triggers"][0], AbstractTrigger)
    assert trigger.additional_properties == {"cron": "0 0 1 1 *", "timezone": "Europe/Paris"}
    assert trigger.to_dict()["cron"] == "0 0 1 1 *"

    flow = BaseApi._construct_model(payload, FlowWithSource)
    assert flow.updated == datetime(2026, 9, 23, 10, 11, 12, 345000, tzinfo=timezone.utc)
    assert flow.triggers[0].additional_properties["timezone"] == "Europe/Paris"
