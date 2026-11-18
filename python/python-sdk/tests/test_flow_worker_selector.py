"""FlowWorkerSelector decode tests: no live Kestra server required.

Since Kestra 2.0.11 (kestra b0cd6ff07f), a flow/task/trigger workerSelector.tags is a
Pebble-capable property and Kestra returns it as a string (the JSON text of a literal
list, or the expression). Kestra 2.0.0-2.0.10 returns a JSON array.
"""

from kestrapy.models.flow_with_source import FlowWithSource
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


def test_flow_reads_the_string_tags_kestra_returns_for_a_literal_list():
    flow = _flow({"tags": '["gpu"]', "match": "ALL"})
    assert flow.worker_selector.tags == '["gpu"]'
    assert flow.worker_selector.match == WorkerSelectorMatch.ALL



def test_flow_reads_the_array_tags_kestra_before_2_0_11_returns():
    flow = _flow({"tags": ["gpu", "linux"], "match": "ALL"})
    assert flow.worker_selector.tags == '["gpu","linux"]'
