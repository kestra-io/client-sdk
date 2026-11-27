"""WorkerSelector tags decode/encode tests: no live Kestra server required.

Since Kestra 2.0.11 (kestra b0cd6ff07f), a flow/task/trigger workerSelector.tags is a
Pebble-capable property and Kestra returns it as a string (the JSON text of a literal
list, or the expression). Kestra 2.0.0-2.0.10 returns a JSON array.
"""

from kestrapy.models.flow_with_source import FlowWithSource
from kestrapy.models.worker_selector import WorkerSelector
from kestrapy.models.worker_selector_match import WorkerSelectorMatch


def _flow(worker_selector):
    return FlowWithSource.from_dict({
        "id": "f",
        "namespace": "ns",
        "disabled": False,
        "deleted": False,
        "draft": False,
        "tasks": [{"id": "t", "type": "io.kestra.plugin.core.log.Log"}],
        "workerSelector": worker_selector,
    })


def test_reads_the_string_tags_kestra_2_0_11_returns_for_a_literal_list():
    selector = _flow({"tags": '["gpu", "linux"]', "match": "ALL"}).worker_selector

    assert selector.tags == ["gpu", "linux"]
    assert selector.tags_expression is None
    assert selector.match == WorkerSelectorMatch.ALL


def test_reads_the_array_tags_kestra_before_2_0_11_returns():
    selector = _flow({"tags": ["gpu", "linux"]}).worker_selector

    assert selector.tags == ["gpu", "linux"]
    assert selector.tags_expression is None


def test_reads_a_pebble_expression_into_tags_expression():
    selector = _flow({"tags": "{{ inputs.workers }}"}).worker_selector

    assert selector.tags is None
    assert selector.tags_expression == "{{ inputs.workers }}"


def test_writes_tags_as_a_list_and_an_expression_as_a_string():
    assert WorkerSelector(tags=["gpu"], match=WorkerSelectorMatch.ANY).to_dict() == {
        "tags": ["gpu"], "match": "ANY",
    }
    assert WorkerSelector(tags_expression="{{ inputs.workers }}").to_dict() == {
        "tags": "{{ inputs.workers }}",
    }
    assert WorkerSelector().to_dict() == {}


def test_expression_round_trips():
    selector = WorkerSelector.from_dict({"tags": "{{ inputs.workers }}"})

    assert WorkerSelector.from_dict(selector.to_dict()) == selector


def test_reads_a_list_followed_by_trailing_text_as_an_expression():
    # Only a string that is exactly the JSON text of a list is a literal list
    selector = _flow({"tags": '["gpu"] {{ x }}'}).worker_selector

    assert selector.tags is None
    assert selector.tags_expression == '["gpu"] {{ x }}'


def test_from_dict_reads_a_model_dump():
    expression = WorkerSelector.from_dict(
        WorkerSelector(tags_expression="{{ inputs.workers }}").model_dump()
    )
    assert expression.tags is None
    assert expression.tags_expression == "{{ inputs.workers }}"
    assert "tags_expression" not in expression.additional_properties

    literal = WorkerSelector.from_dict(
        WorkerSelector(tags=["gpu"], match=WorkerSelectorMatch.ANY).model_dump()
    )
    assert literal.tags == ["gpu"]
    assert literal.tags_expression is None
    assert literal.match == WorkerSelectorMatch.ANY
