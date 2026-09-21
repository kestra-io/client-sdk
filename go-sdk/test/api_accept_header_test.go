package test

import (
	"context"
	"net/http"
	"net/http/httptest"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// Regression for #434: two text endpoints requested the wrong media type because
// they relied on doText's text/plain default instead of passing an Accept override.
//   - ExportFlowsByQueryCsv must send Accept: text/csv (route produces=TEXT_CSV).
//   - InternalBlueprintFlow (custom blueprint source) must send Accept: application/yaml,
//     matching its community sibling BlueprintSource.
//
// The live suite can't guard these: exportFlowsByQueryCsvTest self-skips on 403
// (flow CSV export is permission-gated on the EE image), so a green run never
// exercises the header. This mock server pins the exact Accept header — the byte
// each fix actually changes — so a later refactor that drops the doText override
// (silently reverting to text/plain) fails here.
func TestTextEndpointAcceptHeaders(t *testing.T) {
	const tenant = "acme-tenant"

	var flowsCsvAccept, blueprintSourceAccept string
	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		switch {
		case r.Method == http.MethodGet && r.URL.Path == "/api/v1/"+tenant+"/flows/export/by-query/csv":
			flowsCsvAccept = r.Header.Get("Accept")
			w.Header().Set("Content-Type", "text/csv")
			_, _ = w.Write([]byte("id,namespace\nmy-flow,acme\n"))
		case r.Method == http.MethodGet && r.URL.Path == "/api/v1/"+tenant+"/blueprints/custom/bp-1/source":
			blueprintSourceAccept = r.Header.Get("Accept")
			w.Header().Set("Content-Type", "application/yaml")
			_, _ = w.Write([]byte("id: my-flow\nnamespace: acme\n"))
		default:
			t.Errorf("unexpected request: %s %s", r.Method, r.URL.Path)
			w.WriteHeader(http.StatusNotFound)
		}
	}))
	defer srv.Close()

	client := kestra_api_client.NewClient(srv.URL, kestra_api_client.WithTokenAuth("qa-token"))
	ctx := context.Background()

	csv, err := client.Flows().ExportFlowsByQueryCsv(ctx, tenant, nil)
	require.NoError(t, err)
	require.Equal(t, "text/csv", flowsCsvAccept, "flows CSV export must request Accept: text/csv")
	require.Contains(t, csv, "my-flow")

	source, err := client.Blueprints().InternalBlueprintFlow(ctx, "bp-1", tenant)
	require.NoError(t, err)
	require.Equal(t, "application/yaml", blueprintSourceAccept, "custom blueprint source must request Accept: application/yaml")
	require.Contains(t, source, "id: my-flow")
}
