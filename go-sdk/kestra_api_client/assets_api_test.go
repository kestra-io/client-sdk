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

func TestSearchAssetLineageEvents_HitsKestra20Route(t *testing.T) {
	var path string
	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		path = r.URL.Path
		w.Header().Set("Content-Type", "application/json")
		_, _ = w.Write([]byte(`{"results":[{"uid":"e1","flowId":"f"}],"total":1}`))
	}))
	t.Cleanup(srv.Close)

	got, err := NewClient(srv.URL).Assets().SearchAssetLineageEvents(context.Background(), "main", nil, nil, nil, nil)
	if err != nil {
		t.Fatalf("request failed: %v", err)
	}

	if path != "/api/v1/main/assets/lineage-events/search" {
		t.Errorf("path = %s", path)
	}
	if got.Total != 1 || len(got.Results) != 1 || got.Results[0].GetUid() != "e1" {
		t.Errorf("results = %+v", got)
	}
}
