package kestra_api_client

import (
	"encoding/json"
	"reflect"
	"testing"
)

// Since Kestra 2.0.11 (kestra b0cd6ff07f), a flow/task/trigger workerSelector.tags is a
// Pebble-capable property and Kestra returns it as a string (the JSON text of a literal list, or
// the expression). Kestra 2.0.0-2.0.10 returns a JSON array.

func decodeFlowWorkerSelector(t *testing.T, selectorJSON string) *WorkerSelector {
	t.Helper()
	var flow FlowWithSource
	payload := `{"id":"f","namespace":"ns","disabled":false,"deleted":false,"draft":false,` +
		`"tasks":[{"id":"t","type":"io.kestra.plugin.core.log.Log"}],` +
		`"workerSelector":` + selectorJSON + `}`
	if err := json.Unmarshal([]byte(payload), &flow); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}
	return flow.WorkerSelector
}

func TestWorkerSelector_ReadsTheStringTagsKestra2011ReturnsForALiteralList(t *testing.T) {
	selector := decodeFlowWorkerSelector(t, `{"tags":"[\"gpu\", \"linux\"]","match":"ALL"}`)

	if !reflect.DeepEqual(selector.Tags, []string{"gpu", "linux"}) {
		t.Errorf("tags = %#v, want [gpu linux]", selector.Tags)
	}
	if selector.TagsExpression != nil {
		t.Errorf("tagsExpression = %q, want nil", *selector.TagsExpression)
	}
	if selector.GetMatch() != WORKERSELECTORMATCH_ALL {
		t.Errorf("match = %v, want ALL", selector.GetMatch())
	}
}

func TestWorkerSelector_ReadsTheArrayTagsKestraBefore2011Returns(t *testing.T) {
	selector := decodeFlowWorkerSelector(t, `{"tags":["gpu","linux"]}`)

	if !reflect.DeepEqual(selector.Tags, []string{"gpu", "linux"}) {
		t.Errorf("tags = %#v, want [gpu linux]", selector.Tags)
	}
	if selector.TagsExpression != nil {
		t.Errorf("tagsExpression = %q, want nil", *selector.TagsExpression)
	}
}

func TestWorkerSelector_ReadsAPebbleExpressionIntoTagsExpression(t *testing.T) {
	selector := decodeFlowWorkerSelector(t, `{"tags":"{{ inputs.workers }}"}`)

	if selector.Tags != nil {
		t.Errorf("tags = %#v, want nil", selector.Tags)
	}
	if got := selector.GetTagsExpression(); got != "{{ inputs.workers }}" {
		t.Errorf("tagsExpression = %q, want {{ inputs.workers }}", got)
	}
}

func TestWorkerSelector_WritesTagsAsAListAndAnExpressionAsAString(t *testing.T) {
	cases := []struct {
		selector WorkerSelector
		want     string
	}{
		{WorkerSelector{Tags: []string{"gpu"}, Match: WORKERSELECTORMATCH_ANY.Ptr()}, `{"match":"ANY","tags":["gpu"]}`},
		{WorkerSelector{TagsExpression: PtrString("{{ inputs.workers }}")}, `{"tags":"{{ inputs.workers }}"}`},
		{WorkerSelector{}, `{}`},
	}
	for _, c := range cases {
		got, err := json.Marshal(c.selector)
		if err != nil {
			t.Fatalf("marshal: %v", err)
		}
		if string(got) != c.want {
			t.Errorf("marshal = %s, want %s", got, c.want)
		}
	}
}

func TestWorkerSelector_SettingOneFormClearsTheOther(t *testing.T) {
	selector := WorkerSelector{Tags: []string{"gpu"}}
	selector.SetTagsExpression("{{ x }}")
	if selector.Tags != nil {
		t.Errorf("tags = %#v after SetTagsExpression, want nil", selector.Tags)
	}
	selector.SetTags([]string{"gpu"})
	if selector.TagsExpression != nil {
		t.Errorf("tagsExpression = %q after SetTags, want nil", *selector.TagsExpression)
	}
}
