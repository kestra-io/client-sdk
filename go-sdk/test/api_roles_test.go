package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestRolesAPI_All(t *testing.T) {
	t.Run("autocompleteRolesTest", func(t *testing.T) {
		ctx := context.Background()

		prefix := "test_autocomplete_roles_" + randomId()
		roleReq := map[string]interface{}{
			"name":        prefix + "_complete_roles",
			"description": "An example role",
			"permissions": map[string]interface{}{
				"FLOW": []string{"READ"},
			},
		}

		created, err := KestraTestClient().Roles().CreateRole(ctx, MAIN_TENANT, roleReq)
		require.NoError(t, err)

		ac := map[string]interface{}{"q": prefix}
		results, err := KestraTestClient().Roles().AutocompleteRoles(ctx, MAIN_TENANT, ac)
		require.NoError(t, err)

		found := false
		for _, r := range results {
			if r.GetId() == created.GetId() || r.GetName() == created.GetName() {
				found = true
				break
			}
		}
		require.True(t, found, "autocomplete should include the created role")
	})

	t.Run("createRoleTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test_create_role_" + randomId()
		req := map[string]interface{}{
			"name":        name,
			"description": "An example role",
			"permissions": map[string]interface{}{
				"FLOW": []string{"READ"},
			},
		}

		created, err := KestraTestClient().Roles().CreateRole(ctx, MAIN_TENANT, req)
		require.NoError(t, err)
		require.Equal(t, name, created.GetName())
		require.NotEmpty(t, created.GetId())
	})

	t.Run("deleteRoleTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test_delete_role_" + randomId()
		req := map[string]interface{}{
			"name": name,
			"permissions": map[string]interface{}{
				"FLOW": []string{"READ"},
			},
		}

		created, err := KestraTestClient().Roles().CreateRole(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		err = KestraTestClient().Roles().DeleteRole(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		_, err = KestraTestClient().Roles().Role(ctx, created.GetId(), MAIN_TENANT)
		require.Error(t, err)
	})

	t.Run("getRoleTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test_get_role_" + randomId()
		req := map[string]interface{}{
			"name": name,
			"permissions": map[string]interface{}{
				"FLOW": []string{"READ"},
			},
		}

		created, err := KestraTestClient().Roles().CreateRole(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Roles().Role(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
		require.Equal(t, created.GetName(), fetched.GetName())
	})

	t.Run("listRolesFromGivenIdsTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test_list_roles_from_given_ids_" + randomId()
		req := map[string]interface{}{
			"name": name,
			"permissions": map[string]interface{}{
				"FLOW": []string{"READ"},
			},
		}

		created, err := KestraTestClient().Roles().CreateRole(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		ids := []string{created.GetId()}
		fetched, err := KestraTestClient().Roles().ListRolesFromGivenIds(ctx, MAIN_TENANT, ids)
		require.NoError(t, err)
		require.NotEmpty(t, fetched)

		found := false
		for _, r := range fetched {
			if r.GetId() == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found)
	})

	t.Run("searchRolesTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test_search_roles_" + randomId()
		req := map[string]interface{}{
			"name": name,
			"permissions": map[string]interface{}{
				"FLOW": []string{"READ"},
			},
		}

		created, err := KestraTestClient().Roles().CreateRole(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		page, err := KestraTestClient().Roles().SearchRoles(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, kestra_api_client.PtrString(name))
		require.NoError(t, err)
		require.NotNil(t, page)
		require.NotNil(t, page.GetResults())

		found := false
		for _, r := range page.GetResults() {
			if r.GetId() == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found)
	})

	t.Run("updateRoleTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test_update_role_" + randomId()
		createReq := map[string]interface{}{
			"name":        name,
			"description": "Before",
			"permissions": map[string]interface{}{
				"FLOW": []string{"READ"},
			},
		}

		created, err := KestraTestClient().Roles().CreateRole(ctx, MAIN_TENANT, createReq)
		require.NoError(t, err)

		updatedDesc := "Updated description"
		updateReq := map[string]interface{}{
			"name":        created.GetName(),
			"description": updatedDesc,
			"permissions": map[string]interface{}{
				"FLOW": []string{"READ"},
			},
		}
		updated, err := KestraTestClient().Roles().UpdateRole(ctx, created.GetId(), MAIN_TENANT, updateReq)
		require.NoError(t, err)
		require.Equal(t, updatedDesc, updated.GetDescription())
	})
}
