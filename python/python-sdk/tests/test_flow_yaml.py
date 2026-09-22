# coding: utf-8

"""Unit tests for the object -> YAML serialization used by
``create_flow_from_object`` / ``update_flow_from_object``.

These are pure serialization tests: no live Kestra server is involved.
"""

from datetime import datetime, timezone
from enum import Enum

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
