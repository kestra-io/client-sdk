package kestra_api_client

import (
	"encoding/json"
	"strings"
	"testing"

	"gopkg.in/yaml.v3"
)

// buildFlow returns a Flow carrying plugin-specific task properties at the top
// level (Log.message) and inside a nested Sequential task (Shell.commands).
func buildFlow() Flow {
	log := Task{
		Id:   "log",
		Type: "io.kestra.plugin.core.log.Log",
		AdditionalProperties: map[string]interface{}{
			"message": "Hello {{ inputs.name }}",
		},
	}
	seq := Task{
		Id:   "seq",
		Type: "io.kestra.plugin.core.flow.Sequential",
		AdditionalProperties: map[string]interface{}{
			"tasks": []map[string]interface{}{
				{
					"id":       "shell",
					"type":     "io.kestra.plugin.scripts.shell.Commands",
					"commands": []string{"echo one", "echo two"},
					"script":   "echo start\necho done",
				},
			},
		},
	}
	return Flow{
		Id:        "my-flow",
		Namespace: "company.team",
		Disabled:  false,
		Draft:     false,
		Deleted:   false,
		Tasks:     []Task{log, seq},
	}
}

func TestFlowToYAML_PluginPropertiesSurvive(t *testing.T) {
	flow := buildFlow()
	out, err := flowToYAML(flow)
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}

	for _, needle := range []string{
		"message:",
		"io.kestra.plugin.core.log.Log",
		"commands:",
		"{{ inputs.name }}",
	} {
		if !strings.Contains(out, needle) {
			t.Errorf("expected YAML to contain %q, got:\n%s", needle, out)
		}
	}
}

func TestFlowToYAML_RoundTrip(t *testing.T) {
	out, err := flowToYAML(buildFlow())
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}

	var parsed map[string]interface{}
	if err := yaml.Unmarshal([]byte(out), &parsed); err != nil {
		t.Fatalf("re-parsing YAML failed: %v", err)
	}

	if parsed["id"] != "my-flow" {
		t.Errorf("id = %v, want my-flow", parsed["id"])
	}
	if parsed["namespace"] != "company.team" {
		t.Errorf("namespace = %v, want company.team", parsed["namespace"])
	}

	tasks, ok := parsed["tasks"].([]interface{})
	if !ok || len(tasks) != 2 {
		t.Fatalf("tasks not a 2-element list: %#v", parsed["tasks"])
	}

	log := tasks[0].(map[string]interface{})
	if log["message"] != "Hello {{ inputs.name }}" {
		t.Errorf("log.message = %v", log["message"])
	}

	seq := tasks[1].(map[string]interface{})
	nested := seq["tasks"].([]interface{})[0].(map[string]interface{})
	if nested["id"] != "shell" {
		t.Errorf("nested.id = %v, want shell", nested["id"])
	}
	if nested["script"] != "echo start\necho done" {
		t.Errorf("nested.script did not round-trip: %q", nested["script"])
	}
	cmds := nested["commands"].([]interface{})
	if len(cmds) != 2 || cmds[0] != "echo one" || cmds[1] != "echo two" {
		t.Errorf("nested.commands = %#v", cmds)
	}
}

func TestFlowToYAML_ExcludesServerManagedFields(t *testing.T) {
	// buildFlow sets Draft and Deleted (both false, so they would otherwise be
	// emitted); revision is set here too. None may appear in flow source.
	flow := buildFlow()
	rev := int32(7)
	flow.Revision = &rev

	out, err := flowToYAML(flow)
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}
	for _, needle := range []string{"draft:", "deleted:", "revision:"} {
		if strings.Contains(out, needle) {
			t.Errorf("server-managed field %q must not appear in flow source, got:\n%s", needle, out)
		}
	}

	var parsed map[string]interface{}
	if err := yaml.Unmarshal([]byte(out), &parsed); err != nil {
		t.Fatalf("re-parsing YAML failed: %v", err)
	}
	for _, key := range []string{"draft", "deleted", "revision", "tenantId", "source", "updated"} {
		if _, present := parsed[key]; present {
			t.Errorf("server-managed field %q must be absent, got:\n%s", key, out)
		}
	}
}

func TestFlowToYAML_NumberPrecision(t *testing.T) {
	// A large int64 must stay an integer and keep full precision (the old
	// json -> interface{} path coerced every number to float64).
	const big int64 = 9007199254740993 // 2^53 + 1, not representable as float64
	flow := map[string]interface{}{
		"id":        "num-flow",
		"namespace": "company.team",
		"tasks": []map[string]interface{}{
			{
				"id":      "t",
				"type":    "io.kestra.plugin.core.log.Log",
				"timeout": big,
			},
		},
	}
	out, err := flowToYAML(flow)
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}
	if !strings.Contains(out, "9007199254740993") {
		t.Errorf("large int64 lost precision, got:\n%s", out)
	}

	var parsed map[string]interface{}
	if err := yaml.Unmarshal([]byte(out), &parsed); err != nil {
		t.Fatalf("re-parsing YAML failed: %v", err)
	}
	got := parsed["tasks"].([]interface{})[0].(map[string]interface{})["timeout"]
	if v, ok := got.(int); ok {
		if int64(v) != big {
			t.Errorf("timeout = %d, want %d", v, big)
		}
	} else if v, ok := got.(int64); ok {
		if v != big {
			t.Errorf("timeout = %d, want %d", v, big)
		}
	} else {
		t.Errorf("timeout decoded as %T (%v), want an integer", got, got)
	}
}

func TestFlowToYAML_UintPrecision(t *testing.T) {
	// A value above math.MaxInt64 (uint64 range) must stay an integer, not fall
	// through to a lossy float.
	const big = "18446744073709551615" // math.MaxUint64
	flow := map[string]interface{}{
		"id":        "uint-flow",
		"namespace": "company.team",
		"tasks": []map[string]interface{}{
			{"id": "t", "type": "io.kestra.plugin.core.log.Log", "big": json.RawMessage(big)},
		},
	}
	out, err := flowToYAML(flow)
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}
	if !strings.Contains(out, big) {
		t.Errorf("large uint64 lost precision, got:\n%s", out)
	}
	// Must be emitted as a bare integer, not quoted or exponential.
	if strings.Contains(out, "1.8446744073709552e+19") {
		t.Errorf("uint64 was coerced to float, got:\n%s", out)
	}
}

func TestFlowToYAML_DropsNilMapValues(t *testing.T) {
	flow := map[string]interface{}{
		"id":          "x",
		"namespace":   "y",
		"description": nil, // top-level nil
		"labels":      nil, // top-level nil
		"tasks": []map[string]interface{}{
			{
				"id":      "log",
				"type":    "io.kestra.plugin.core.log.Log",
				"message": "hi",
				"timeout": nil,                                                           // nested nil
				"retry":   map[string]interface{}{"type": "constant", "maxAttempt": nil}, // deeper nil
			},
		},
	}
	out, err := flowToYAML(flow)
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}
	if strings.Contains(out, "null") {
		t.Errorf("nil-valued keys must be dropped, got:\n%s", out)
	}

	var parsed map[string]interface{}
	if err := yaml.Unmarshal([]byte(out), &parsed); err != nil {
		t.Fatalf("re-parsing YAML failed: %v", err)
	}
	for _, key := range []string{"description", "labels"} {
		if _, present := parsed[key]; present {
			t.Errorf("nil key %q must be dropped, got:\n%s", key, out)
		}
	}
	task := parsed["tasks"].([]interface{})[0].(map[string]interface{})
	if _, present := task["timeout"]; present {
		t.Errorf("nested nil key must be dropped, got:\n%s", out)
	}
	retry := task["retry"].(map[string]interface{})
	if _, present := retry["maxAttempt"]; present {
		t.Errorf("deeply nested nil key must be dropped, got:\n%s", out)
	}
	if retry["type"] != "constant" || task["message"] != "hi" {
		t.Errorf("real values must survive, got:\n%s", out)
	}
}

func TestFlowToYAML_NilInput(t *testing.T) {
	if _, err := flowToYAML(nil); err == nil {
		t.Error("expected an error for nil input, got nil")
	}
	var typedNil *Flow
	if _, err := flowToYAML(typedNil); err == nil {
		t.Error("expected an error for a typed-nil *Flow, got nil")
	}
}

func TestFlowToYAML_MapInput(t *testing.T) {
	flow := map[string]interface{}{
		"id":        "dict-flow",
		"namespace": "company.team",
		"disabled":  false,
		"draft":     false,
		"deleted":   false,
		"tasks": []map[string]interface{}{
			{
				"id":      "hello",
				"type":    "io.kestra.plugin.core.log.Log",
				"message": "grüß gott",
			},
		},
	}
	out, err := flowToYAML(flow)
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}
	if strings.Contains(out, `\u`) {
		t.Errorf("non-ASCII was escaped: %s", out)
	}
	if !strings.Contains(out, "grüß gott") {
		t.Errorf("expected non-ASCII verbatim, got:\n%s", out)
	}
}

// yamlKeys returns the keys of a YAML mapping node in document order.
func yamlKeys(t *testing.T, n *yaml.Node) []string {
	t.Helper()
	if n.Kind != yaml.MappingNode {
		t.Fatalf("expected a mapping node, got kind %v", n.Kind)
	}
	keys := make([]string, 0, len(n.Content)/2)
	for i := 0; i+1 < len(n.Content); i += 2 {
		keys = append(keys, n.Content[i].Value)
	}
	return keys
}

// yamlValue returns the value node of key in a mapping node.
func yamlValue(t *testing.T, n *yaml.Node, key string) *yaml.Node {
	t.Helper()
	for i := 0; i+1 < len(n.Content); i += 2 {
		if n.Content[i].Value == key {
			return n.Content[i+1]
		}
	}
	t.Fatalf("key %q not found", key)
	return nil
}

func TestFlowToYAML_CanonicalKeyOrderTyped(t *testing.T) {
	desc := "a flow"
	flow := &Flow{
		Id:          "my-flow",
		Namespace:   "company.team",
		Description: &desc,
		Tasks: []Task{{
			Id:   "hello",
			Type: "io.kestra.plugin.core.log.Log",
			AdditionalProperties: map[string]interface{}{
				"message": "hi",
			},
		}},
	}
	out, err := flowToYAML(flow)
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}
	want := "id: my-flow\n" +
		"namespace: company.team\n" +
		"description: a flow\n" +
		"tasks:\n" +
		"  - id: hello\n" +
		"    type: io.kestra.plugin.core.log.Log\n" +
		"    message: hi\n" +
		"disabled: false\n"
	if out != want {
		t.Errorf("unexpected YAML.\ngot:\n%s\nwant:\n%s", out, want)
	}
}

func TestFlowToYAML_CanonicalKeyOrderMap(t *testing.T) {
	flow := map[string]interface{}{
		"triggers": []map[string]interface{}{
			{"type": "io.kestra.plugin.core.trigger.Schedule", "cron": "0 * * * *", "id": "hourly"},
		},
		"tasks": []map[string]interface{}{
			{
				"type": "io.kestra.plugin.core.flow.Sequential",
				"id":   "seq",
				"tasks": []map[string]interface{}{
					{"message": "x", "type": "io.kestra.plugin.core.log.Log", "id": "inner"},
				},
			},
		},
		"inputs": []map[string]interface{}{
			{"type": "STRING", "defaults": "d", "id": "name"},
		},
		"labels":    map[string]interface{}{"team": "a"},
		"namespace": "company.team",
		"id":        "map-flow",
		"zzz":       "extra",
		"aaa":       "extra",
	}
	out, err := flowToYAML(flow)
	if err != nil {
		t.Fatalf("flowToYAML returned error: %v", err)
	}
	var doc yaml.Node
	if err := yaml.Unmarshal([]byte(out), &doc); err != nil {
		t.Fatalf("re-parsing YAML failed: %v", err)
	}
	root := doc.Content[0]
	assertKeys := func(name string, got, want []string) {
		t.Helper()
		if strings.Join(got, ",") != strings.Join(want, ",") {
			t.Errorf("%s key order = %v, want %v\nYAML:\n%s", name, got, want, out)
		}
	}
	assertKeys("root", yamlKeys(t, root),
		[]string{"id", "namespace", "labels", "inputs", "tasks", "triggers", "aaa", "zzz"})
	seq := yamlValue(t, root, "tasks").Content[0]
	assertKeys("task", yamlKeys(t, seq), []string{"id", "type", "tasks"})
	assertKeys("nested task", yamlKeys(t, yamlValue(t, seq, "tasks").Content[0]),
		[]string{"id", "type", "message"})
	assertKeys("trigger", yamlKeys(t, yamlValue(t, root, "triggers").Content[0]),
		[]string{"id", "type", "cron"})
	assertKeys("input", yamlKeys(t, yamlValue(t, root, "inputs").Content[0]),
		[]string{"id", "type", "defaults"})
	if !strings.Contains(out, "\n  - id: seq\n    type: io.kestra.plugin.core.flow.Sequential\n") {
		t.Errorf("expected 2-space indentation, got:\n%s", out)
	}
}
