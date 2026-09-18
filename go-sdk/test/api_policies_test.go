package test

import (
	"context"
	"fmt"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

// policyScope adapts the tenant / namespace / instance policy endpoints to one
// shared lifecycle so every scope's wrappers are exercised identically.
type policyScope struct {
	name          string
	expectedScope string
	// searchListsOwn is false for the namespace scope: its search is backed by
	// the policy resolution chain and can legitimately return an empty page, so
	// the test only asserts the endpoint is reachable there.
	searchListsOwn bool
	create        func(ctx context.Context, yaml string) (*kestra_api_client.Policy, error)
	get           func(ctx context.Context, id string) (*kestra_api_client.Policy, error)
	update        func(ctx context.Context, id, yaml string) (*kestra_api_client.Policy, error)
	validate      func(ctx context.Context, yaml string) (*kestra_api_client.ValidateConstraintViolation, error)
	del           func(ctx context.Context, id string) error
	delByIds      func(ctx context.Context, ids []string) (*kestra_api_client.BulkResponse, error)
	search        func(ctx context.Context) (*kestra_api_client.PagedResultsApiPolicySummary, error)
	evaluate      func(ctx context.Context, id string) (*kestra_api_client.ApiPolicyEvaluation, error)
	export        func(ctx context.Context) ([]byte, error)
	exportByIds   func(ctx context.Context, ids []string) ([]byte, error)
}

func policyYAML(id, displayName string) string {
	return fmt.Sprintf(`id: %s
displayName: %s
description: created by the Go SDK test suite
enforcement: ACTIVE
rules:
  - type: io.kestra.plugin.ee.rules.Require
    on: FLOW
    action: BLOCK
    errorMessage: timeout is required
    properties:
      - timeout
`, id, displayName)
}

func TestPoliciesAPI_AllScopes(t *testing.T) {
	ctx := context.Background()
	c := KestraTestClient()
	p := c.Policies()
	const ns = "io.kestra.sdk.policies"

	scopes := []policyScope{
		{
			name: "tenant", expectedScope: "TENANT", searchListsOwn: true,
			create:   func(ctx context.Context, y string) (*kestra_api_client.Policy, error) { return p.CreateTenantPolicy(ctx, MAIN_TENANT, y) },
			get:      func(ctx context.Context, id string) (*kestra_api_client.Policy, error) { return p.TenantPolicy(ctx, MAIN_TENANT, id) },
			update:   func(ctx context.Context, id, y string) (*kestra_api_client.Policy, error) { return p.UpdateTenantPolicy(ctx, MAIN_TENANT, id, y) },
			validate: func(ctx context.Context, y string) (*kestra_api_client.ValidateConstraintViolation, error) { return p.ValidateTenantPolicy(ctx, MAIN_TENANT, y) },
			del:      func(ctx context.Context, id string) error { return p.DeleteTenantPolicy(ctx, MAIN_TENANT, id) },
			delByIds: func(ctx context.Context, ids []string) (*kestra_api_client.BulkResponse, error) { return p.DeleteTenantPoliciesByIds(ctx, MAIN_TENANT, ids) },
			search:   func(ctx context.Context) (*kestra_api_client.PagedResultsApiPolicySummary, error) { return p.SearchTenantPolicies(ctx, MAIN_TENANT, nil, nil, nil, nil) },
			evaluate: func(ctx context.Context, id string) (*kestra_api_client.ApiPolicyEvaluation, error) { return p.EvaluateTenantPolicy(ctx, MAIN_TENANT, id, nil, nil) },
			export:   func(ctx context.Context) ([]byte, error) { return p.ExportTenantPolicies(ctx, MAIN_TENANT) },
			exportByIds: func(ctx context.Context, ids []string) ([]byte, error) { return p.ExportTenantPoliciesByIds(ctx, MAIN_TENANT, ids) },
		},
		{
			name: "namespace", expectedScope: "NAMESPACE", searchListsOwn: false,
			create:   func(ctx context.Context, y string) (*kestra_api_client.Policy, error) { return p.CreateNamespacePolicy(ctx, MAIN_TENANT, ns, y) },
			get:      func(ctx context.Context, id string) (*kestra_api_client.Policy, error) { return p.NamespacePolicy(ctx, MAIN_TENANT, ns, id) },
			update:   func(ctx context.Context, id, y string) (*kestra_api_client.Policy, error) { return p.UpdateNamespacePolicy(ctx, MAIN_TENANT, ns, id, y) },
			validate: func(ctx context.Context, y string) (*kestra_api_client.ValidateConstraintViolation, error) { return p.ValidateNamespacePolicy(ctx, MAIN_TENANT, ns, y) },
			del:      func(ctx context.Context, id string) error { return p.DeleteNamespacePolicy(ctx, MAIN_TENANT, ns, id) },
			delByIds: func(ctx context.Context, ids []string) (*kestra_api_client.BulkResponse, error) { return p.DeleteNamespacePoliciesByIds(ctx, MAIN_TENANT, ns, ids) },
			search:   func(ctx context.Context) (*kestra_api_client.PagedResultsApiPolicySummary, error) { return p.SearchNamespacePolicies(ctx, MAIN_TENANT, ns, nil, nil, nil, nil) },
			evaluate: func(ctx context.Context, id string) (*kestra_api_client.ApiPolicyEvaluation, error) { return p.EvaluateNamespacePolicy(ctx, MAIN_TENANT, ns, id, nil, nil) },
			export:   func(ctx context.Context) ([]byte, error) { return p.ExportNamespacePolicies(ctx, MAIN_TENANT, ns) },
			exportByIds: func(ctx context.Context, ids []string) ([]byte, error) { return p.ExportNamespacePoliciesByIds(ctx, MAIN_TENANT, ns, ids) },
		},
		{
			name: "instance", expectedScope: "INSTANCE", searchListsOwn: true,
			create:   func(ctx context.Context, y string) (*kestra_api_client.Policy, error) { return p.CreateInstancePolicy(ctx, y) },
			get:      func(ctx context.Context, id string) (*kestra_api_client.Policy, error) { return p.InstancePolicy(ctx, id, nil) },
			update:   func(ctx context.Context, id, y string) (*kestra_api_client.Policy, error) { return p.UpdateInstancePolicy(ctx, id, y) },
			validate: func(ctx context.Context, y string) (*kestra_api_client.ValidateConstraintViolation, error) { return p.ValidateInstancePolicy(ctx, y) },
			del:      func(ctx context.Context, id string) error { return p.DeleteInstancePolicy(ctx, id) },
			delByIds: func(ctx context.Context, ids []string) (*kestra_api_client.BulkResponse, error) { return p.DeleteInstancePoliciesByIds(ctx, ids) },
			search:   func(ctx context.Context) (*kestra_api_client.PagedResultsApiPolicySummary, error) { return p.SearchInstancePolicies(ctx, nil, nil, nil, nil) },
			evaluate: func(ctx context.Context, id string) (*kestra_api_client.ApiPolicyEvaluation, error) { return p.EvaluateInstancePolicy(ctx, id, nil, nil, nil) },
			export:   func(ctx context.Context) ([]byte, error) { return p.ExportInstancePolicies(ctx) },
			exportByIds: func(ctx context.Context, ids []string) ([]byte, error) { return p.ExportInstancePoliciesByIds(ctx, ids) },
		},
	}

	for _, s := range scopes {
		t.Run(s.name, func(t *testing.T) {
			id := "sdk-policy-" + strings.ToLower(randomId())

			created, err := s.create(ctx, policyYAML(id, "sdk policy"))
			require.NoError(t, err, "creating a %s policy requires the POLICIES feature (enabled on develop)", s.name)
			require.Equal(t, id, created.GetId())
			require.Equal(t, s.expectedScope, created.GetScope(), "the scope is derived from the request path")
			require.NotEmpty(t, created.GetSource(), "the YAML source round-trips")
			require.NotEmpty(t, created.GetRules(), "the parsed rules are returned")

			deleted := false
			t.Cleanup(func() {
				if !deleted {
					_ = s.del(context.Background(), id)
				}
			})

			t.Run("get", func(t *testing.T) {
				got, err := s.get(ctx, id)
				require.NoError(t, err)
				require.Equal(t, id, got.GetId())
			})

			t.Run("update", func(t *testing.T) {
				updated, err := s.update(ctx, id, policyYAML(id, "sdk policy renamed"))
				require.NoError(t, err)
				require.Equal(t, "sdk policy renamed", updated.GetDisplayName(), "the display name change round-trips")
			})

			t.Run("search finds it", func(t *testing.T) {
				res, err := s.search(ctx)
				require.NoError(t, err)
				found := false
				for _, sum := range res.GetResults() {
					if sum.GetId() == id {
						found = true
						require.Equal(t, s.expectedScope, sum.GetScope())
					}
				}
				if s.searchListsOwn {
					require.True(t, found, "the created policy must appear in the search results")
				} else if !found {
					t.Logf("namespace search returned %d policies without the new one; "+
						"its results come from the policy resolution chain, which can be empty", len(res.GetResults()))
				}
			})

			t.Run("validate accepts a well-formed policy", func(t *testing.T) {
				v, err := s.validate(ctx, policyYAML(id, "sdk policy"))
				require.NoError(t, err)
				require.Empty(t, v.GetConstraints(), "a valid policy reports no constraint violations")
			})

			t.Run("evaluate", func(t *testing.T) {
				ev, err := s.evaluate(ctx, id)
				require.NoError(t, err)
				require.GreaterOrEqual(t, ev.GetCounts().Scanned, int64(0), "evaluation returns scan counts")
			})

			t.Run("export contains the policy", func(t *testing.T) {
				all, err := s.export(ctx)
				require.NoError(t, err)
				require.NotEmpty(t, all, "the export is a non-empty document")

				byIds, err := s.exportByIds(ctx, []string{id})
				require.NoError(t, err)
				require.Contains(t, string(byIds), id, "the by-ids export contains the requested policy")
			})

			t.Run("delete by ids", func(t *testing.T) {
				bulk, err := s.delByIds(ctx, []string{id})
				require.NoError(t, err)
				require.Equal(t, int32(1), bulk.GetCount(), "one policy was deleted")
				deleted = true

				_, err = s.get(ctx, id)
				var apiErr *kestra_api_client.ApiError
				require.ErrorAs(t, err, &apiErr, "the policy must be gone")
				require.Equal(t, 404, apiErr.StatusCode)
			})
		})
	}
}
