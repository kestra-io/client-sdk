# coding: utf-8

"""Unit tests for the object -> YAML serialization used by
``create_flow_from_object`` / ``update_flow_from_object``.

These are pure serialization tests: no live Kestra server is involved.
"""

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
