package kestra_api_client

import (
	"encoding/json"
	"testing"
)

// Since kestra f497a8372b, a flow/task/trigger workerSelector.tags is a Pebble-capable property
// and Kestra returns it as a string (the JSON text of a literal list, or the expression), so a
// []string field failed to decode every flow with a worker selector.

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
