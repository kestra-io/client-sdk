package kestra_api_client

import (
	"encoding/json"
	"testing"
)

func TestFlow_UnmarshalJSON_AssetInputAndOutput(t *testing.T) {
	payload := []byte(`{"id":"f","namespace":"ns","disabled":false,"deleted":false,"draft":false,` +
		`"tasks":[{"id":"t","type":"io.kestra.plugin.core.log.Log"}],` +
		`"inputs":[{"id":"vm","type":"ASSET"}],` +
		`"outputs":[{"id":"picked","type":"ASSET","value":"{{ inputs.vm }}"}]}`)
	var flow Flow
	if err := json.Unmarshal(payload, &flow); err != nil {
		t.Fatalf("expected a flow with an ASSET input and output to unmarshal, got: %v", err)
	}
	if got := flow.GetInputs()[0].GetType(); got != TYPE_ASSET {
		t.Fatalf("expected TYPE_ASSET, got: %v", got)
	}
	if got := flow.GetOutputs()[0].GetType(); got != OUTPUTTYPE_ASSET {
		t.Fatalf("expected OUTPUTTYPE_ASSET, got: %v", got)
	}
}

func TestOutputType_UnmarshalJSON_RejectsAnInputOnlyType(t *testing.T) {
	var v OutputType
	if err := json.Unmarshal([]byte(`"SELECT"`), &v); err == nil {
		t.Fatal("expected SELECT to be refused as an output type")
	}
}

func TestType_UnmarshalJSON_Table(t *testing.T) {
	var v Type
	if err := json.Unmarshal([]byte(`"TABLE"`), &v); err != nil {
		t.Fatalf("expected TABLE to unmarshal without error, got: %v", err)
	}
	if v != TYPE_TABLE {
		t.Fatalf("expected TYPE_TABLE, got: %v", v)
	}
}
