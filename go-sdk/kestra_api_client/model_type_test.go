/*
Kestra EE

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
	"testing"
)

func TestType_UnmarshalJSON_Form(t *testing.T) {
	var v Type
	if err := json.Unmarshal([]byte(`"FORM"`), &v); err != nil {
		t.Fatalf("expected FORM to unmarshal without error, got: %v", err)
	}
	if v != TYPE_FORM {
		t.Fatalf("expected TYPE_FORM, got: %v", v)
	}
}

func TestType_UnmarshalJSON_Invalid(t *testing.T) {
	var v Type
	err := json.Unmarshal([]byte(`"BOGUS"`), &v)
	if err == nil {
		t.Fatal("expected error for unknown Type value, got nil")
	}
}

func TestInputObject_UnmarshalJSON_FormType(t *testing.T) {
	payload := []byte(`{"id":"myform","type":"FORM"}`)
	var obj InputObject
	if err := json.Unmarshal(payload, &obj); err != nil {
		t.Fatalf("expected InputObject with FORM type to unmarshal without error, got: %v", err)
	}
	if obj.GetType() != TYPE_FORM {
		t.Fatalf("expected TYPE_FORM, got: %v", obj.GetType())
	}
}
