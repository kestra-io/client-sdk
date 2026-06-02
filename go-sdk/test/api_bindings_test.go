package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// createBindingPrereqs creates a group (used as the binding external entity) and a role,
// returning their ids. Bindings are an EE feature; these calls require an EE test image.
func createBindingPrereqs(t *testing.T, ctx context.Context) (groupId string, roleId string) {
	t.Helper()

	group, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, map[string]interface{}{
		"name": "test_binding_group_" + randomId(),
	})
	require.NoError(t, err)

	role, err := KestraTestClient().Roles().CreateRole(ctx, MAIN_TENANT, map[string]interface{}{
		"name": "test_binding_role_" + randomId(),
		"permissions": map[string]interface{}{
			"FLOW": []string{"READ"},
		},
	})
	require.NoError(t, err)

	return group.GetId(), role.GetId()
}

func TestBindingsAPI_All(t *testing.T) {
	t.Run("createBindingTest", func(t *testing.T) {
		ctx := context.Background()
		groupId, roleId := createBindingPrereqs(t, ctx)

		created, err := KestraTestClient().Bindings().CreateBinding(ctx, MAIN_TENANT, map[string]interface{}{
			"type":       "GROUP",
			"externalId": groupId,
			"roleId":     roleId,
		})
		require.NoError(t, err)
		require.NotEmpty(t, created.GetId())
		require.Equal(t, kestra_api_client.BINDINGTYPE_GROUP, created.GetType())
	})

	t.Run("getBindingTest", func(t *testing.T) {
		ctx := context.Background()
		groupId, roleId := createBindingPrereqs(t, ctx)

		created, err := KestraTestClient().Bindings().CreateBinding(ctx, MAIN_TENANT, map[string]interface{}{
			"type":       "GROUP",
			"externalId": groupId,
			"roleId":     roleId,
		})
		require.NoError(t, err)

		fetched, err := KestraTestClient().Bindings().Binding(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
	})

	t.Run("searchBindingsTest", func(t *testing.T) {
		ctx := context.Background()
		groupId, roleId := createBindingPrereqs(t, ctx)

		created, err := KestraTestClient().Bindings().CreateBinding(ctx, MAIN_TENANT, map[string]interface{}{
			"type":       "GROUP",
			"externalId": groupId,
			"roleId":     roleId,
		})
		require.NoError(t, err)

		page, err := KestraTestClient().Bindings().SearchBindings(
			ctx, MAIN_TENANT,
			kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10),
			nil, nil, &groupId, nil, nil,
		)
		require.NoError(t, err)
		require.NotNil(t, page)

		found := false
		for _, b := range page.GetResults() {
			if b.GetId() == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found, "search should include the created binding")
	})

	t.Run("deleteBindingTest", func(t *testing.T) {
		ctx := context.Background()
		groupId, roleId := createBindingPrereqs(t, ctx)

		created, err := KestraTestClient().Bindings().CreateBinding(ctx, MAIN_TENANT, map[string]interface{}{
			"type":       "GROUP",
			"externalId": groupId,
			"roleId":     roleId,
		})
		require.NoError(t, err)

		err = KestraTestClient().Bindings().DeleteBinding(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		_, err = KestraTestClient().Bindings().Binding(ctx, created.GetId(), MAIN_TENANT)
		require.Error(t, err)
	})

	t.Run("bulkCreateBindingTest", func(t *testing.T) {
		ctx := context.Background()
		groupId, roleId := createBindingPrereqs(t, ctx)

		bindings, err := KestraTestClient().Bindings().BulkCreateBinding(ctx, MAIN_TENANT, []map[string]interface{}{
			{"type": "GROUP", "externalId": groupId, "roleId": roleId},
		})
		require.NoError(t, err)
		require.Len(t, bindings, 1)
		require.NotEmpty(t, bindings[0].GetId())
	})
}
