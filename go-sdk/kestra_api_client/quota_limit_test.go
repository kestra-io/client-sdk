package kestra_api_client

import (
	"encoding/json"
	"testing"
)

// A tenant-wide quota limit is reported with an explicit null namespace/flowId,
// which has to stay distinguishable from the field simply being absent.
func TestQuotaLimit_ExplicitNullsSurviveRoundTrip(t *testing.T) {
	const payload = `{"tenantId":"t","namespace":null,"flowId":null,"count":5}`

	var q QuotaLimit
	if err := json.Unmarshal([]byte(payload), &q); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}

	if !q.Namespace.IsSet() || q.Namespace.Get() != nil {
		t.Errorf("namespace should be set to an explicit nil, got IsSet=%v value=%v",
			q.Namespace.IsSet(), q.Namespace.Get())
	}
	if !q.HasFlowId() || q.FlowId.Get() != nil {
		t.Errorf("flowId should be set to an explicit nil")
	}

	out, err := json.Marshal(q)
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	var got map[string]interface{}
	if err := json.Unmarshal(out, &got); err != nil {
		t.Fatalf("re-unmarshal: %v", err)
	}
	for _, key := range []string{"namespace", "flowId"} {
		v, present := got[key]
		if !present {
			t.Errorf("%q was dropped on re-marshal; a tenant-wide limit is then indistinguishable from an unreported field", key)
			continue
		}
		if v != nil {
			t.Errorf("%q = %v, want explicit null", key, v)
		}
	}
}
