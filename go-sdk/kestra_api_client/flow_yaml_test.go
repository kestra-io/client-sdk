package kestra_api_client

import (
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
