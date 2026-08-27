package kestra_api_client

import (
	"encoding/json"
	"testing"
)

// The server may send a label map either as a JSON object or, since Kestra 2.0,
// as a list of {key, value} pairs.
func TestMapObjectObject_UnmarshalJSON_AcceptsBothShapes(t *testing.T) {
	for name, payload := range map[string]string{
		"map":  `{"phase":"created"}`,
		"list": `[{"key":"phase","value":"created"}]`,
	} {
		t.Run(name, func(t *testing.T) {
			var m MapObjectObject
			if err := json.Unmarshal([]byte(payload), &m); err != nil {
				t.Fatalf("unmarshal %s: %v", payload, err)
			}
			if got := m.AdditionalProperties["phase"]; got != "created" {
				t.Fatalf("phase = %v, want created", got)
			}
		})
	}
}
