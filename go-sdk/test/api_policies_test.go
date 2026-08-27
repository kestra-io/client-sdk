package test

import (
	"context"
	"fmt"
	"testing"
	"time"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// policySource returns a minimal FLOW-scoped policy. Require reports a violation when the
// listed properties are missing; EVALUATE keeps it from blocking anything.
func policySource(id, displayName, enforcement string) string {
	return fmt.Sprintf(`id: %s
displayName: %s
enforcement: %s
rules:
  - type: io.kestra.plugin.ee.rules.Require
    on: FLOW
    action: WARN
    errorMessage: timeout is required
    properties:
      - timeout
`, id, displayName, enforcement)
}

func defaultPolicySource(id string) string {
	return policySource(id, "Test policy "+id, "EVALUATE")
}

// namespaceWithFlow creates a namespace by putting a flow in it.
func namespaceWithFlow(t *testing.T, ctx context.Context) string {
	t.Helper()

	ns := "test.policies." + randomId()
	body := fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: hello
`, randomId(), ns)

	_, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, body)
	require.NoError(t, err)
	time.Sleep(200 * time.Millisecond)
	return ns
}

// requirePolicyInSearch polls until id appears: policy search reads an index updated
// asynchronously after a write, so a single read after a create can miss it.
func requirePolicyInSearch(t *testing.T, search func() (*kestra_api_client.PagedResultsApiPolicySummary, error), id string) {
	t.Helper()

	deadline := time.Now().Add(10 * time.Second)
	for {
		page, err := search()
		require.NoError(t, err)
		for _, p := range page.Results {
			if p.GetId() == id {
				return
			}
		}
		if time.Now().After(deadline) {
			t.Fatalf("policy %s never appeared in search", id)
		}
		time.Sleep(200 * time.Millisecond)
	}
}

func TestPoliciesAPI_All(t *testing.T) {
	// INSTANCE scope

	t.Run("shouldRoundTripAuthoredSourceWhenCreatingInstancePolicy", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Policies().CreateInstancePolicy(ctx, defaultPolicySource(id))
		require.NoError(t, err)
		require.Equal(t, id, created.GetId())
		require.Equal(t, kestra_api_client.ENFORCEMENT_EVALUATE, created.GetEnforcement())

		read, err := KestraTestClient().Policies().InstancePolicy(ctx, id)
		require.NoError(t, err)
		require.Equal(t, id, read.GetId())
		// the API stores the authored YAML alongside the parsed model and returns it verbatim
		require.Contains(t, read.GetSource(), "io.kestra.plugin.ee.rules.Require")
		require.NotEmpty(t, read.GetRules())
	})

	t.Run("shouldReturnPolicyWhenSearchingInstancePolicies", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		_, err := KestraTestClient().Policies().CreateInstancePolicy(ctx, defaultPolicySource(id))
		require.NoError(t, err)

		requirePolicyInSearch(t, func() (*kestra_api_client.PagedResultsApiPolicySummary, error) {
			return KestraTestClient().Policies().SearchInstancePolicies(ctx,
				kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(100), nil, nil)
		}, id)
	})

	t.Run("shouldApplyDisplayNameAndEnforcementWhenUpdatingInstancePolicy", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		_, err := KestraTestClient().Policies().CreateInstancePolicy(ctx, defaultPolicySource(id))
		require.NoError(t, err)

		updated, err := KestraTestClient().Policies().UpdateInstancePolicy(ctx, id,
			policySource(id, "Renamed", "DISABLED"))
		require.NoError(t, err)
		require.Equal(t, "Renamed", updated.GetDisplayName())
		require.Equal(t, kestra_api_client.ENFORCEMENT_DISABLED, updated.GetEnforcement())
	})

	t.Run("shouldReturnValidationResultWhenValidatingInstancePolicySource", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Policies().ValidateInstancePolicy(ctx,
			defaultPolicySource(randomId()))
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("shouldReturnEvaluationWhenEvaluatingInstancePolicy", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		_, err := KestraTestClient().Policies().CreateInstancePolicy(ctx, defaultPolicySource(id))
		require.NoError(t, err)

		evaluation, err := KestraTestClient().Policies().EvaluateInstancePolicy(ctx, id,
			kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10))
		require.NoError(t, err)
		require.NotNil(t, evaluation)
	})

	t.Run("shouldReturnNonEmptyArchiveWhenExportingInstancePolicies", func(t *testing.T) {
		ctx := context.Background()
		_, err := KestraTestClient().Policies().CreateInstancePolicy(ctx, defaultPolicySource(randomId()))
		require.NoError(t, err)

		exported, err := KestraTestClient().Policies().ExportInstancePolicies(ctx)
		require.NoError(t, err)
		require.NotEmpty(t, exported)
	})

	t.Run("shouldRejectGetWhenInstancePolicyDeleted", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		_, err := KestraTestClient().Policies().CreateInstancePolicy(ctx, defaultPolicySource(id))
		require.NoError(t, err)

		require.NoError(t, KestraTestClient().Policies().DeleteInstancePolicy(ctx, id))

		_, err = KestraTestClient().Policies().InstancePolicy(ctx, id)
		require.Error(t, err)
	})

	t.Run("shouldCountEveryDeletionWhenDeletingInstancePoliciesByIds", func(t *testing.T) {
		ctx := context.Background()
		first, second := randomId(), randomId()
		_, err := KestraTestClient().Policies().CreateInstancePolicy(ctx, defaultPolicySource(first))
		require.NoError(t, err)
		_, err = KestraTestClient().Policies().CreateInstancePolicy(ctx, defaultPolicySource(second))
		require.NoError(t, err)

		response, err := KestraTestClient().Policies().DeleteInstancePoliciesByIds(ctx,
			[]string{first, second})
		require.NoError(t, err)
		require.Equal(t, int32(2), response.GetCount())
	})

	// TENANT scope

	t.Run("shouldRoundTripAuthoredSourceWhenCreatingTenantPolicy", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Policies().CreateTenantPolicy(ctx, MAIN_TENANT,
			defaultPolicySource(id))
		require.NoError(t, err)
		require.Equal(t, id, created.GetId())

		read, err := KestraTestClient().Policies().TenantPolicy(ctx, MAIN_TENANT, id)
		require.NoError(t, err)
		require.Contains(t, read.GetSource(), "timeout is required")
	})

	t.Run("shouldReturnPolicyWhenSearchingTenantPolicies", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		_, err := KestraTestClient().Policies().CreateTenantPolicy(ctx, MAIN_TENANT,
			defaultPolicySource(id))
		require.NoError(t, err)

		requirePolicyInSearch(t, func() (*kestra_api_client.PagedResultsApiPolicySummary, error) {
			return KestraTestClient().Policies().SearchPolicies(ctx, MAIN_TENANT,
				kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(100), nil, nil)
		}, id)
	})

	t.Run("shouldReturnNonEmptyArchiveWhenExportingTenantPoliciesByIds", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		_, err := KestraTestClient().Policies().CreateTenantPolicy(ctx, MAIN_TENANT,
			defaultPolicySource(id))
		require.NoError(t, err)

		exported, err := KestraTestClient().Policies().ExportTenantPoliciesByIds(ctx, MAIN_TENANT,
			[]string{id})
		require.NoError(t, err)
		require.NotEmpty(t, exported)
	})

	t.Run("shouldRejectGetWhenTenantPolicyDeleted", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		_, err := KestraTestClient().Policies().CreateTenantPolicy(ctx, MAIN_TENANT,
			defaultPolicySource(id))
		require.NoError(t, err)

		require.NoError(t, KestraTestClient().Policies().DeleteTenantPolicy(ctx, MAIN_TENANT, id))

		_, err = KestraTestClient().Policies().TenantPolicy(ctx, MAIN_TENANT, id)
		require.Error(t, err)
	})

	// NAMESPACE scope

	t.Run("shouldRoundTripAuthoredSourceWhenCreatingNamespacePolicy", func(t *testing.T) {
		ctx := context.Background()
		ns := namespaceWithFlow(t, ctx)
		id := randomId()

		created, err := KestraTestClient().Policies().CreateNamespacePolicy(ctx, MAIN_TENANT, ns,
			defaultPolicySource(id))
		require.NoError(t, err)
		require.Equal(t, id, created.GetId())

		read, err := KestraTestClient().Policies().NamespacePolicy(ctx, MAIN_TENANT, ns, id)
		require.NoError(t, err)
		require.Equal(t, id, read.GetId())
	})

	t.Run("shouldReturnPolicyWhenSearchingNamespacePolicies", func(t *testing.T) {
		ctx := context.Background()
		ns := namespaceWithFlow(t, ctx)
		id := randomId()
		_, err := KestraTestClient().Policies().CreateNamespacePolicy(ctx, MAIN_TENANT, ns,
			defaultPolicySource(id))
		require.NoError(t, err)

		requirePolicyInSearch(t, func() (*kestra_api_client.PagedResultsApiPolicySummary, error) {
			return KestraTestClient().Policies().SearchNamespacePolicies(ctx, MAIN_TENANT, ns,
				kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(100), nil, nil)
		}, id)
	})

	t.Run("shouldApplyEnforcementWhenUpdatingNamespacePolicy", func(t *testing.T) {
		ctx := context.Background()
		ns := namespaceWithFlow(t, ctx)
		id := randomId()
		_, err := KestraTestClient().Policies().CreateNamespacePolicy(ctx, MAIN_TENANT, ns,
			defaultPolicySource(id))
		require.NoError(t, err)

		updated, err := KestraTestClient().Policies().UpdateNamespacePolicy(ctx, MAIN_TENANT, ns, id,
			policySource(id, "Test policy "+id, "ACTIVE"))
		require.NoError(t, err)
		require.Equal(t, kestra_api_client.ENFORCEMENT_ACTIVE, updated.GetEnforcement())
	})

	t.Run("shouldReturnEvaluationWhenEvaluatingNamespacePolicy", func(t *testing.T) {
		ctx := context.Background()
		ns := namespaceWithFlow(t, ctx)
		id := randomId()
		_, err := KestraTestClient().Policies().CreateNamespacePolicy(ctx, MAIN_TENANT, ns,
			defaultPolicySource(id))
		require.NoError(t, err)

		evaluation, err := KestraTestClient().Policies().EvaluateNamespacePolicy(ctx, MAIN_TENANT, ns,
			id, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10))
		require.NoError(t, err)
		require.NotNil(t, evaluation)
	})

	t.Run("shouldRejectGetWhenNamespacePolicyDeleted", func(t *testing.T) {
		ctx := context.Background()
		ns := namespaceWithFlow(t, ctx)
		id := randomId()
		_, err := KestraTestClient().Policies().CreateNamespacePolicy(ctx, MAIN_TENANT, ns,
			defaultPolicySource(id))
		require.NoError(t, err)

		require.NoError(t, KestraTestClient().Policies().DeleteNamespacePolicy(ctx, MAIN_TENANT, ns, id))

		_, err = KestraTestClient().Policies().NamespacePolicy(ctx, MAIN_TENANT, ns, id)
		require.Error(t, err)
	})

	// Preview (tenant scope only)

	t.Run("shouldReturnPreviewWhenPreviewingPoliciesForAFlow", func(t *testing.T) {
		ctx := context.Background()
		ns := namespaceWithFlow(t, ctx)
		id := randomId()
		_, err := KestraTestClient().Policies().CreateNamespacePolicy(ctx, MAIN_TENANT, ns,
			defaultPolicySource(id))
		require.NoError(t, err)

		flow := fmt.Sprintf("id: %s\nnamespace: %s\ntasks:\n  - id: hello\n    type: io.kestra.plugin.core.log.Log\n    message: hello\n",
			randomId(), ns)
		request := kestra_api_client.PolicyPreviewRequest{Namespace: ns, Source: flow}

		preview, err := KestraTestClient().Policies().PreviewPolicies(ctx, MAIN_TENANT, request)
		require.NoError(t, err)
		require.NotNil(t, preview)
	})
}
