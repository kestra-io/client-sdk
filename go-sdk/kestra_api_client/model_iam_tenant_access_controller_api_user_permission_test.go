package kestra_api_client

import (
	"encoding/json"
	"testing"
)

// The managed roles hold EXECUTION: REVIEW and CASE: VIEW, LIST since Kestra 2.1.
func TestUserPermission_UnmarshalJSON_AcceptsEveryActionAndResourceTheServerSends(t *testing.T) {
	var permission IAMTenantAccessControllerApiUserPermission
	src := `{"resource":"CASE","actions":["VIEW","LIST","REVIEW","TEMPLATE","LOCK","PROMOTE","UPDATE_CONCURRENCY_LIMIT"]}`
	if err := json.Unmarshal([]byte(src), &permission); err != nil {
		t.Fatalf("unmarshal permission: %v", err)
	}
	if permission.GetResource() != RESOURCE_CASE {
		t.Fatalf("resource = %v, want CASE", permission.GetResource())
	}
	if actions := permission.GetActions(); len(actions) != 7 || actions[2] != ACTION_REVIEW {
		t.Fatalf("actions = %v, want REVIEW third", actions)
	}
}

func TestResource_UnmarshalJSON_AcceptsEveryResourceTheServerSends(t *testing.T) {
	for _, value := range []string{"REUSABLE_INPUTS", "SUPPORT", "POLICY", "CASE", "PROMOTION_TARGET", "CASE_TEMPLATE", "BANNER", "WORKER_QUEUE"} {
		var resource Resource
		if err := json.Unmarshal([]byte(`"`+value+`"`), &resource); err != nil {
			t.Fatalf("unmarshal %s: %v", value, err)
		}
	}
}
