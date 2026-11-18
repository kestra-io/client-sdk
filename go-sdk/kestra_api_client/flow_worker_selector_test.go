package kestra_api_client

import (
	"encoding/json"
	"testing"
)

// Since Kestra 2.0.11 (kestra b0cd6ff07f), a flow/task/trigger workerSelector.tags is a
// Pebble-capable property and Kestra returns it as a string (the JSON text of a literal list, or
// the expression). Kestra 2.0.0-2.0.10 returns a JSON array.

func TestFlowWorkerSelector_ReadsTheStringTagsKestraReturns(t *testing.T) {
	var flow FlowWithSource
	payload := `{"id":"f","namespace":"ns","disabled":false,"deleted":false,"draft":false,` +
		`"tasks":[{"id":"t","type":"io.kestra.plugin.core.log.Log"}],` +
		`"workerSelector":{"tags":"[\"gpu\"]","match":"ALL"}}`
	if err := json.Unmarshal([]byte(payload), &flow); err != nil {
		t.Fatalf("decoding a flow with string tags: %v", err)
	}
	selector := flow.GetWorkerSelector()
	if got := selector.GetTags(); got != `["gpu"]` {
		t.Errorf("tags = %q, want %q", got, `["gpu"]`)
	}
	if got := selector.GetMatch(); got != WORKERSELECTORMATCH_ALL {
		t.Errorf("match = %q, want ALL", got)
	}
}

func TestFlowWorkerSelector_ReadsTheArrayTagsKestraBefore2011Returns(t *testing.T) {
	var flow FlowWithSource
	payload := `{"id":"f","namespace":"ns","disabled":false,"deleted":false,"draft":false,` +
		`"tasks":[{"id":"t","type":"io.kestra.plugin.core.log.Log"}],` +
		`"workerSelector":{"tags":["gpu", "linux"],"match":"ALL"}}`
	if err := json.Unmarshal([]byte(payload), &flow); err != nil {
		t.Fatalf("decoding a flow with array tags: %v", err)
	}
	selector := flow.GetWorkerSelector()
	if got := selector.GetTags(); got != `["gpu","linux"]` {
		t.Errorf("tags = %q, want %q", got, `["gpu","linux"]`)
	}
}
