package test

import (
	"context"
	"net/http"
	"net/http/httptest"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// Regression for #436: GenerateFlow and ListAiProviders must be tenant-scoped,
// not hardcoded to the "main" tenant. Both were built with superadminPath("main",
// ...) and silently targeted the wrong tenant on any non-"main" install. Unlike
// TestAiAPI (which self-skips without a configured AI provider), this uses a mock
// server so it always runs and pins the exact request path for a non-"main"
// tenant — the byte the fix actually changes.
func TestAiTenantScopedPaths(t *testing.T) {
	const tenant = "acme-tenant"

	var gotProviders, gotFlow string
	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		switch {
		case r.Method == http.MethodGet && r.URL.Path == "/api/v1/"+tenant+"/ai/providers":
			gotProviders = r.URL.Path
			w.Header().Set("Content-Type", "application/json")
			_, _ = w.Write([]byte(`[{"type":"openai"}]`))
		case r.Method == http.MethodPost && r.URL.Path == "/api/v1/"+tenant+"/ai/generate/flow":
			gotFlow = r.URL.Path
			w.Header().Set("Content-Type", "application/x-yaml")
			_, _ = w.Write([]byte("id: generated\nnamespace: acme\n"))
		default:
			// Anything else (e.g. the old /api/v1/main/... path) is a failure.
			t.Errorf("unexpected request: %s %s", r.Method, r.URL.Path)
			w.WriteHeader(http.StatusNotFound)
		}
	}))
	defer srv.Close()

	client := kestra_api_client.NewClient(srv.URL, kestra_api_client.WithTokenAuth("qa-token"))
	ctx := context.Background()

	providers, err := client.Ai().ListAiProviders(ctx, tenant)
	require.NoError(t, err)
	require.Equal(t, "/api/v1/"+tenant+"/ai/providers", gotProviders, "ListAiProviders must hit the tenant-scoped route")
	require.Len(t, providers, 1)
	require.Equal(t, "openai", providers[0]["type"])

	yaml, err := client.Ai().GenerateFlow(ctx, tenant, map[string]any{"userPrompt": "hi"})
	require.NoError(t, err)
	require.Equal(t, "/api/v1/"+tenant+"/ai/generate/flow", gotFlow, "GenerateFlow must hit the tenant-scoped route")
	require.Contains(t, yaml, "id: generated")
}
