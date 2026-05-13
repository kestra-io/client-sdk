package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func createFlowBlueprintRequest(title string) kestra_api_client.BlueprintControllerFlowBlueprintCreateOrUpdate {
	return kestra_api_client.BlueprintControllerFlowBlueprintCreateOrUpdate{
		Title:  title,
		Source: LOG_FLOW(randomId(), randomId()),
	}
}

func TestBlueprintsAPI_All(t *testing.T) {

	// ========================================================================
	// Community Blueprints
	// ========================================================================

	t.Run("searchBlueprints_flow", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Blueprints().SearchBlueprints(ctx, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT, nil, nil, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(5))
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
	})

	t.Run("searchBlueprints_withQuery", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Blueprints().SearchBlueprints(ctx, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT, kestra_api_client.PtrString("hello"), nil, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(5))
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("searchBlueprints_withSort", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Blueprints().SearchBlueprints(ctx, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT, nil, []string{"title:asc"}, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10))
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
	})

	t.Run("searchBlueprints_withTags", func(t *testing.T) {
		ctx := context.Background()

		// First get a result to find a tag
		allResults, err := KestraTestClient().Blueprints().SearchBlueprints(ctx, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT, nil, nil, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(1))
		require.NoError(t, err)

		if len(allResults.Results) > 0 && len(allResults.Results[0].Tags) > 0 {
			tag := allResults.Results[0].Tags[0]

			result, err := KestraTestClient().Blueprints().SearchBlueprints(ctx, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT, nil, nil, []string{tag}, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10))
			require.NoError(t, err)
			require.NotEmpty(t, result.Results)
		}
	})

	t.Run("blueprint_basic", func(t *testing.T) {
		ctx := context.Background()

		search, err := KestraTestClient().Blueprints().SearchBlueprints(ctx, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT, nil, nil, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(1))
		require.NoError(t, err)

		if len(search.Results) > 0 {
			bpId := search.Results[0].GetId()

			result, err := KestraTestClient().Blueprints().Blueprint(ctx, bpId, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT)
			require.NoError(t, err)
			require.NotNil(t, result)
			require.Equal(t, bpId, result.GetId())
		}
	})

	t.Run("blueprintGraph_basic", func(t *testing.T) {
		ctx := context.Background()

		search, err := KestraTestClient().Blueprints().SearchBlueprints(ctx, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT, nil, nil, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(1))
		require.NoError(t, err)

		if len(search.Results) > 0 {
			bpId := search.Results[0].GetId()

			result, err := KestraTestClient().Blueprints().BlueprintGraph(ctx, bpId, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT)
			require.NoError(t, err)
			require.NotNil(t, result)
		}
	})

	t.Run("blueprintSource_basic", func(t *testing.T) {
		ctx := context.Background()

		search, err := KestraTestClient().Blueprints().SearchBlueprints(ctx, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT, nil, nil, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(1))
		require.NoError(t, err)

		if len(search.Results) > 0 {
			bpId := search.Results[0].GetId()

			result, err := KestraTestClient().Blueprints().BlueprintSource(ctx, bpId, string(kestra_api_client.BLUEPRINTCONTROLLERKIND_FLOW), MAIN_TENANT)
			require.NoError(t, err)
			require.NotEmpty(t, result)
		}
	})

	// ========================================================================
	// Flow Blueprints
	// ========================================================================

	t.Run("createFlowBlueprint_basic", func(t *testing.T) {
		ctx := context.Background()

		request := createFlowBlueprintRequest("test-bp-" + randomId())
		result, err := KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, request)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotEmpty(t, result.GetId())
	})

	t.Run("flowBlueprintById_basic", func(t *testing.T) {
		ctx := context.Background()

		request := createFlowBlueprintRequest("get-bp-" + randomId())
		created, err := KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, request)
		require.NoError(t, err)

		result, err := KestraTestClient().Blueprints().FlowBlueprintById(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Equal(t, created.GetId(), result.GetId())
	})

	t.Run("updateFlowBlueprint_basic", func(t *testing.T) {
		ctx := context.Background()

		request := createFlowBlueprintRequest("update-bp-" + randomId())
		created, err := KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, request)
		require.NoError(t, err)

		newTitle := "updated-bp-" + randomId()
		updateReq := createFlowBlueprintRequest(newTitle)
		updated, err := KestraTestClient().Blueprints().UpdateFlowBlueprint(ctx, created.GetId(), MAIN_TENANT, updateReq)
		require.NoError(t, err)
		require.Equal(t, newTitle, updated.GetTitle())
	})

	t.Run("deleteFlowBlueprints_basic", func(t *testing.T) {
		ctx := context.Background()

		request := createFlowBlueprintRequest("delete-bp-" + randomId())
		created, err := KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, request)
		require.NoError(t, err)

		err = KestraTestClient().Blueprints().DeleteFlowBlueprints(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
	})

	t.Run("flowBlueprint_basic", func(t *testing.T) {
		ctx := context.Background()

		request := createFlowBlueprintRequest("flow-bp-" + randomId())
		created, err := KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, request)
		require.NoError(t, err)

		result, err := KestraTestClient().Blueprints().FlowBlueprint(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Equal(t, created.GetId(), result.GetId())
	})

	// ========================================================================
	// Internal/Custom Blueprints
	// ========================================================================

	t.Run("searchInternalBlueprints_basic", func(t *testing.T) {
		ctx := context.Background()

		request := createFlowBlueprintRequest("internal-bp-" + randomId())
		created, err := KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, request)
		require.NoError(t, err)

		result, err := KestraTestClient().Blueprints().SearchInternalBlueprints(ctx, MAIN_TENANT, kestra_api_client.PtrString(created.GetTitle()), nil, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotEmpty(t, result.Results)
	})

	t.Run("searchInternalBlueprints_withSort", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Blueprints().SearchInternalBlueprints(ctx, MAIN_TENANT, nil, []string{"title:asc"}, nil, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil)
		require.NoError(t, err)
		require.NotEmpty(t, result.Results)
	})

	t.Run("searchInternalBlueprints_withTags", func(t *testing.T) {
		ctx := context.Background()
		tag := "sdktest" + randomId()[:8]

		reqWithTag := createFlowBlueprintRequest("tagged-bp-" + randomId())
		reqWithTag.Tags = []string{tag}
		_, err := KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, reqWithTag)
		require.NoError(t, err)

		_, err = KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, createFlowBlueprintRequest("untagged-bp-"+randomId()))
		require.NoError(t, err)

		result, err := KestraTestClient().Blueprints().SearchInternalBlueprints(ctx, MAIN_TENANT, nil, nil, []string{tag}, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil)
		require.NoError(t, err)
		require.NotEmpty(t, result.Results)
		for _, bp := range result.Results {
			require.Contains(t, bp.Tags, tag)
		}
	})

	// ========================================================================
	// Use template (non-template should fail)
	// ========================================================================

	t.Run("createAndGetInternalBlueprintTest", func(t *testing.T) {
		ctx := context.Background()

		req := map[string]interface{}{
			"title":       "Test Blueprint " + randomId(),
			"description": "test blueprint",
			"flow":        "id: test_bp\nnamespace: test\ntasks:\n  - id: hello\n    type: io.kestra.plugin.core.log.Log\n    message: Hello",
			"tags":        []string{"test"},
		}

		created, err := KestraTestClient().Blueprints().CreateInternalBlueprints(ctx, MAIN_TENANT, req)
		require.NoError(t, err)
		require.NotNil(t, created)
		require.NotEmpty(t, created.GetId())

		fetched, err := KestraTestClient().Blueprints().InternalBlueprint(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, fetched)
	})

	t.Run("internalBlueprintFlowTest", func(t *testing.T) {
		ctx := context.Background()

		req := map[string]interface{}{
			"title":       "Test Blueprint Source " + randomId(),
			"description": "test blueprint source",
			"flow":        "id: test_bp_src\nnamespace: test\ntasks:\n  - id: hello\n    type: io.kestra.plugin.core.log.Log\n    message: Hello",
		}

		created, err := KestraTestClient().Blueprints().CreateInternalBlueprints(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		source, err := KestraTestClient().Blueprints().InternalBlueprintFlow(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotEmpty(t, source)
	})

	t.Run("updateInternalBlueprintTest", func(t *testing.T) {
		ctx := context.Background()

		req := map[string]interface{}{
			"title":       "Test Blueprint Update " + randomId(),
			"description": "before update",
			"flow":        "id: test_bp_upd\nnamespace: test\ntasks:\n  - id: hello\n    type: io.kestra.plugin.core.log.Log\n    message: Hello",
		}

		created, err := KestraTestClient().Blueprints().CreateInternalBlueprints(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		updateReq := map[string]interface{}{
			"title":       "Updated Blueprint " + randomId(),
			"description": "after update",
			"flow":        "id: test_bp_upd\nnamespace: test\ntasks:\n  - id: hello\n    type: io.kestra.plugin.core.log.Log\n    message: Updated",
		}

		updated, err := KestraTestClient().Blueprints().UpdateInternalBlueprints(ctx, created.GetId(), MAIN_TENANT, updateReq)
		require.NoError(t, err)
		require.NotNil(t, updated)
	})

	t.Run("deleteInternalBlueprintTest", func(t *testing.T) {
		ctx := context.Background()

		req := map[string]interface{}{
			"title":       "Test Blueprint Delete " + randomId(),
			"description": "to be deleted",
			"flow":        "id: test_bp_del\nnamespace: test\ntasks:\n  - id: hello\n    type: io.kestra.plugin.core.log.Log\n    message: Hello",
		}

		created, err := KestraTestClient().Blueprints().CreateInternalBlueprints(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		err = KestraTestClient().Blueprints().DeleteInternalBlueprints(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
	})

	// ========================================================================
	// Use template (non-template should fail)
	// ========================================================================

	t.Run("useBlueprintTemplate_notTemplate", func(t *testing.T) {
		ctx := context.Background()

		request := createFlowBlueprintRequest("use-tpl-" + randomId())
		created, err := KestraTestClient().Blueprints().CreateFlowBlueprint(ctx, MAIN_TENANT, request)
		require.NoError(t, err)

		// Non-template blueprints cannot be used as templates
		_, err = KestraTestClient().Blueprints().UseBlueprintTemplate(ctx, created.GetId(), MAIN_TENANT, map[string]interface{}{})
		require.Error(t, err)
	})
}
