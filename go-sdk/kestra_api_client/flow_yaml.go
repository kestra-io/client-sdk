package kestra_api_client

import (
	"encoding/json"
	"fmt"

	"gopkg.in/yaml.v3"
)

// flowToYAML serializes a flow to a YAML source string.
//
// The flow-write endpoints only consume application/x-yaml (they do not accept
// JSON), so a native object (a *Flow / Flow value, or a map) is serialized to a
// YAML source string client-side and posted to the existing YAML endpoints.
//
// The value is first marshalled through the model's own JSON marshaller (which
// omits nil fields and re-inserts additional, plugin-specific task properties at
// every depth), then re-emitted as YAML. yaml.v3 produces block style, quotes
// Kestra expressions such as "{{ inputs.foo }}", emits multi-line strings as
// literal block scalars and keeps non-ASCII characters verbatim.
func flowToYAML(flow interface{}) (string, error) {
	jsonBytes, err := json.Marshal(flow)
	if err != nil {
		return "", fmt.Errorf("serialize flow to json: %w", err)
	}

	var generic interface{}
	if err := json.Unmarshal(jsonBytes, &generic); err != nil {
		return "", fmt.Errorf("normalize flow: %w", err)
	}

	out, err := yaml.Marshal(generic)
	if err != nil {
		return "", fmt.Errorf("serialize flow to yaml: %w", err)
	}
	return string(out), nil
}
