package test

import (
	"context"
	"encoding/json"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// Runs against a mock server so the request shape the CaseEvent trigger and the
// SetTicket task rely on is pinned even without an EE instance.
func TestCasesAPI_TicketAndEventSearchRequests(t *testing.T) {
	var ticketMethod, ticketPath string
	var ticketBody map[string]string
	var searchQuery map[string][]string
	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "application/json")
		switch r.URL.Path {
		case "/api/v1/main/cases/c1/ticket":
			ticketMethod, ticketPath = r.Method, r.URL.Path
			raw, _ := io.ReadAll(r.Body)
			_ = json.Unmarshal(raw, &ticketBody)
			_, _ = w.Write([]byte(`{"id":"c1","ticket":{"system":"GitHub","key":"acme/ops#412","url":"https://github.com/acme/ops/issues/412"},"deleted":false}`))
		case "/api/v1/main/cases/events/search":
			searchQuery = r.URL.Query()
			_, _ = w.Write([]byte(`{"results":[{"event":{"id":"e1","type":"TICKET_LINKED"},"case":{"id":"c1","url":"https://kestra/ui/main/cases/c1"}}],"nextSinceCreated":"2026-10-16T10:00:00Z","nextSinceId":"e1","hasMore":false}`))
		default:
			t.Errorf("unexpected request: %s %s", r.Method, r.URL.Path)
			w.WriteHeader(http.StatusNotFound)
		}
	}))
	defer srv.Close()

	client := kestra_api_client.NewClient(srv.URL, kestra_api_client.WithTokenAuth("qa-token"))
	ctx := context.Background()

	updated, err := client.Cases().SetCaseTicket(ctx, "main", "c1", kestra_api_client.CaseTicketRequest{
		System: "GitHub", Key: "acme/ops#412", Url: "https://github.com/acme/ops/issues/412",
	})
	require.NoError(t, err)
	require.Equal(t, http.MethodPut, ticketMethod)
	require.Equal(t, "/api/v1/main/cases/c1/ticket", ticketPath)
	require.Equal(t, map[string]string{"system": "GitHub", "key": "acme/ops#412", "url": "https://github.com/acme/ops/issues/412"}, ticketBody)
	require.Equal(t, "acme/ops#412", updated.Ticket.Key)

	sinceCreated, sinceId, namespace := "2026-10-16T09:00:00Z", "e0", "io.kestra"
	page, err := client.Cases().SearchCaseEvents(ctx, "main", &sinceCreated, &sinceId, []string{"CREATED", "TICKET_LINKED"}, []string{"CRITICAL"}, &namespace, []string{"alice", "ops"}, intPtr(50))
	require.NoError(t, err)
	require.Equal(t, map[string][]string{
		"sinceCreated": {sinceCreated},
		"sinceId":      {sinceId},
		"namespace":    {namespace},
		"size":         {"50"},
		"events":       {"CREATED", "TICKET_LINKED"},
		"severities":   {"CRITICAL"},
		"assignees":    {"alice", "ops"},
	}, searchQuery)
	require.Len(t, page.Results, 1)
	require.Equal(t, "c1", page.Results[0].Case.Id)
	require.Equal(t, "TICKET_LINKED", page.Results[0].Event.Type)
	require.Equal(t, "e1", page.NextSinceId)
}
