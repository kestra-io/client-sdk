package kestra_api_client

import (
	"context"
	"encoding/json"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"
)

func TestSetAssetParent_SendsParentIdBody(t *testing.T) {
	var method, path string
	var body map[string]any
	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		method, path = r.Method, r.URL.Path
		raw, _ := io.ReadAll(r.Body)
		if err := json.Unmarshal(raw, &body); err != nil {
			t.Errorf("body is not JSON: %s", raw)
		}
		w.Header().Set("Content-Type", "application/json")
		_, _ = w.Write([]byte(`{"id":"child","partOf":{"id":"parent"}}`))
	}))
	t.Cleanup(srv.Close)

	_, err := NewClient(srv.URL).Assets().SetAssetParent(context.Background(), "child", "main",
		AssetsControllerApiParentRequest{ParentId: "parent"})
	if err != nil {
		t.Fatalf("request failed: %v", err)
	}

	if method != "PUT" || path != "/api/v1/main/assets/child/parent" {
		t.Errorf("got %s %s", method, path)
	}
	if len(body) != 1 || body["parentId"] != "parent" {
		t.Errorf("body = %v, want {\"parentId\":\"parent\"}", body)
	}
	if _, ok := body["id"]; ok {
		t.Errorf("body must not carry an id key: %v", body)
	}
}
