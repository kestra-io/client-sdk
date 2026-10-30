package kestra_api_client

import (
	"encoding/json"
	"testing"
)

// An execution running the onWait tasks of an Approval is PAUSING, which the server sends since Kestra 2.1.
func TestStateType_UnmarshalJSON_AcceptsPausing(t *testing.T) {
	var state StateType
	if err := json.Unmarshal([]byte(`"PAUSING"`), &state); err != nil {
		t.Fatalf("unmarshal PAUSING: %v", err)
	}
	if state != STATETYPE_PAUSING {
		t.Fatalf("state = %v, want PAUSING", state)
	}
}

func TestDailyExecutionStatisticsExecutionCounts_UnmarshalJSON_ReadsPausing(t *testing.T) {
	var counts DailyExecutionStatisticsExecutionCounts
	if err := json.Unmarshal([]byte(`{"PAUSING":3}`), &counts); err != nil {
		t.Fatalf("unmarshal counts: %v", err)
	}
	if counts.GetPAUSING() != 3 {
		t.Fatalf("PAUSING = %v, want 3", counts.GetPAUSING())
	}
}
