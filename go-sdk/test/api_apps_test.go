package test

import (
	"context"
	"fmt"
	"strings"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func appYaml(id, namespace, flowId string) string {
	return fmt.Sprintf(`
id: %s
type: io.kestra.plugin.ee.apps.Execution
namespace: %s
flowId: %s
displayName: Test App %s
layout:
  - on: OPEN
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "# Test App"
  - on: RUNNING
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "Running..."
  - on: SUCCESS
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "Done!"
`, id, namespace, flowId, id)
}

func createAppWithFlow(t *testing.T, ctx context.Context) (*kestra_api_client.AppsControllerApiAppSource, string, string, string) {
	ns := randomId()
	flowId := randomId()
	appId := randomId()
	createSimpleFlow(ctx, flowId, ns)

	created, err := KestraTestClient().Apps().CreateApp(ctx, MAIN_TENANT, appYaml(appId, ns, flowId))
	require.NoError(t, err)
	return created, appId, ns, flowId
}

func TestAppsAPI_All(t *testing.T) {

	// ========================================================================
	// CRUD
	// ========================================================================

	t.Run("createApp_basic", func(t *testing.T) {
		ctx := context.Background()
		ns := randomId()
		flowId := randomId()
		createSimpleFlow(ctx, flowId, ns)

		result, err := KestraTestClient().Apps().CreateApp(ctx, MAIN_TENANT, appYaml(randomId(), ns, flowId))
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Equal(t, ns, result.GetNamespace())
	})

	t.Run("app_getByUid", func(t *testing.T) {
		ctx := context.Background()
		created, _, _, _ := createAppWithFlow(t, ctx)

		result, err := KestraTestClient().Apps().App(ctx, created.GetUid(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Equal(t, created.GetUid(), result.GetUid())
	})

	t.Run("updateApp_basic", func(t *testing.T) {
		ctx := context.Background()
		created, appId, _, _ := createAppWithFlow(t, ctx)

		updatedYaml := strings.Replace(created.GetSource(), "Test App "+appId, "Updated App "+appId, 1)
		err := KestraTestClient().Apps().UpdateApp(ctx, created.GetUid(), MAIN_TENANT, updatedYaml)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Apps().App(ctx, created.GetUid(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, fetched)
		require.Equal(t, created.GetUid(), fetched.GetUid())
	})

	t.Run("deleteApp_basic", func(t *testing.T) {
		ctx := context.Background()
		created, _, _, _ := createAppWithFlow(t, ctx)

		err := KestraTestClient().Apps().DeleteApp(ctx, created.GetUid(), MAIN_TENANT)
		require.NoError(t, err)
	})

	// ========================================================================
	// Enable / Disable
	// ========================================================================

	t.Run("enableDisableApp", func(t *testing.T) {
		ctx := context.Background()
		created, _, _, _ := createAppWithFlow(t, ctx)

		disabled, err := KestraTestClient().Apps().DisableApp(ctx, created.GetUid(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, disabled)

		enabled, err := KestraTestClient().Apps().EnableApp(ctx, created.GetUid(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, enabled)
	})

	// ========================================================================
	// Search
	// ========================================================================

	t.Run("searchApps_basic", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Apps().SearchApps(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil, nil, nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
	})

	t.Run("searchAppsFromCatalog_basic", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Apps().SearchAppsFromCatalog(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
	})

	t.Run("searchApps_withNamespace", func(t *testing.T) {
		ctx := context.Background()
		created, _, ns, _ := createAppWithFlow(t, ctx)

		result, err := KestraTestClient().Apps().SearchApps(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, kestra_api_client.PtrString(ns), nil, nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Greater(t, len(result.Results), 0)

		found := false
		for _, app := range result.Results {
			if app.GetUid() == created.GetUid() {
				found = true
				break
			}
		}
		require.True(t, found, "Expected to find the created app in search results")
	})

	t.Run("searchApps_withFlowId", func(t *testing.T) {
		ctx := context.Background()
		created, _, ns, flowId := createAppWithFlow(t, ctx)

		result, err := KestraTestClient().Apps().SearchApps(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, kestra_api_client.PtrString(ns), kestra_api_client.PtrString(flowId), nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Greater(t, len(result.Results), 0)

		found := false
		for _, app := range result.Results {
			if app.GetUid() == created.GetUid() {
				found = true
				break
			}
		}
		require.True(t, found, "Expected to find the created app in search results")
	})

	t.Run("searchApps_withQuery", func(t *testing.T) {
		ctx := context.Background()
		ns := randomId()
		flowId := randomId()
		createSimpleFlow(ctx, flowId, ns)

		appId := "searchq" + randomId()
		_, err := KestraTestClient().Apps().CreateApp(ctx, MAIN_TENANT, appYaml(appId, ns, flowId))
		require.NoError(t, err)

		result, err := KestraTestClient().Apps().SearchApps(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), kestra_api_client.PtrString("Test App "+appId), kestra_api_client.PtrString(ns), nil, nil, nil, nil)
		require.NoError(t, err)
		require.Greater(t, len(result.Results), 0)
		for _, app := range result.Results {
			require.Contains(t, app.GetName(), appId)
		}
	})

	t.Run("searchApps_withSort", func(t *testing.T) {
		ctx := context.Background()
		ns := randomId()
		flowId := randomId()
		createSimpleFlow(ctx, flowId, ns)

		appId1 := "aaa" + randomId()
		appId2 := "zzz" + randomId()
		_, err := KestraTestClient().Apps().CreateApp(ctx, MAIN_TENANT, appYaml(appId2, ns, flowId))
		require.NoError(t, err)
		_, err = KestraTestClient().Apps().CreateApp(ctx, MAIN_TENANT, appYaml(appId1, ns, flowId))
		require.NoError(t, err)

		result, err := KestraTestClient().Apps().SearchApps(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, kestra_api_client.PtrString(ns), nil, []string{"id:asc"}, nil, nil)
		require.NoError(t, err)
		require.GreaterOrEqual(t, len(result.Results), 2)

		ids := make([]string, len(result.Results))
		for i, app := range result.Results {
			ids[i] = app.GetId()
		}
		idx1 := indexOf(ids, appId1)
		idx2 := indexOf(ids, appId2)
		require.GreaterOrEqual(t, idx1, 0)
		require.Greater(t, idx2, idx1)
	})

	t.Run("searchApps_withFilters", func(t *testing.T) {
		ctx := context.Background()
		ns := randomId()
		flowId := randomId()
		createSimpleFlow(ctx, flowId, ns)

		_, err := KestraTestClient().Apps().CreateApp(ctx, MAIN_TENANT, appYaml(randomId(), ns, flowId))
		require.NoError(t, err)

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     ns,
			},
		}
		result, err := KestraTestClient().Apps().SearchApps(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil, nil, nil, nil, filters)
		require.NoError(t, err)
		require.Greater(t, len(result.Results), 0)
		for _, app := range result.Results {
			require.Equal(t, ns, app.GetNamespace())
		}
	})

	t.Run("searchAppsFromCatalog_withFilters", func(t *testing.T) {
		ctx := context.Background()
		ns := randomId()
		flowId := randomId()
		createSimpleFlow(ctx, flowId, ns)

		_, err := KestraTestClient().Apps().CreateApp(ctx, MAIN_TENANT, appYaml(randomId(), ns, flowId))
		require.NoError(t, err)

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     ns,
			},
		}
		result, err := KestraTestClient().Apps().SearchAppsFromCatalog(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), filters)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Greater(t, len(result.Results), 0)
	})

	t.Run("searchApps_noResults", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Apps().SearchApps(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, kestra_api_client.PtrString("nonexistent_ns_"+randomId()), nil, nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Empty(t, result.Results)
	})

	// ========================================================================
	// Tags
	// ========================================================================

	t.Run("listTags_basic", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Apps().ListTags(ctx, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	// ========================================================================
	// Bulk operations
	// ========================================================================

	t.Run("bulkDeleteApps_basic", func(t *testing.T) {
		ctx := context.Background()
		created, _, _, _ := createAppWithFlow(t, ctx)

		request := map[string]interface{}{
			"uids": []string{created.GetUid()},
		}
		_, err := KestraTestClient().Apps().BulkDeleteApps(ctx, MAIN_TENANT, request)
		require.NoError(t, err)
	})

	t.Run("bulkEnableApps_basic", func(t *testing.T) {
		ctx := context.Background()
		created, _, _, _ := createAppWithFlow(t, ctx)

		request := map[string]interface{}{
			"uids": []string{created.GetUid()},
		}
		_, err := KestraTestClient().Apps().BulkEnableApps(ctx, MAIN_TENANT, request)
		require.NoError(t, err)
	})

	t.Run("bulkDisableApps_basic", func(t *testing.T) {
		ctx := context.Background()
		created, _, _, _ := createAppWithFlow(t, ctx)

		request := map[string]interface{}{
			"uids": []string{created.GetUid()},
		}
		_, err := KestraTestClient().Apps().BulkDisableApps(ctx, MAIN_TENANT, request)
		require.NoError(t, err)
	})

	t.Run("bulkImportAppsTest", func(t *testing.T) {
		t.Skip("Requires a pre-built ZIP file with app definitions")
	})

	t.Run("fileMetaFromAppExecutionTest", func(t *testing.T) {
		t.Skip("Requires a running app execution with file outputs")
	})

	t.Run("filePreviewFromAppExecutionTest", func(t *testing.T) {
		t.Skip("Requires a running app execution with file outputs")
	})

	t.Run("logsFromAppExecutionTest", func(t *testing.T) {
		t.Skip("Requires a running app execution")
	})

	t.Run("bulkExportApps_basic", func(t *testing.T) {
		ctx := context.Background()
		created, _, _, _ := createAppWithFlow(t, ctx)

		request := map[string]interface{}{
			"uids": []string{created.GetUid()},
		}
		result, err := KestraTestClient().Apps().BulkExportApps(ctx, MAIN_TENANT, request)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Greater(t, len(result), 0)
	})
}
