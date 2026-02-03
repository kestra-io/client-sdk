package test

import (
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestRolesAPI_All(t *testing.T) {
	t.Run("autocompleteRolesTest", func(t *testing.T) {
		ctx := GetAuthContext()

		prefix := "test_autocomplete_roles_" + randomId()
		perms := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions{
			FLOW: []string{"READ"},
		}
		roleReq := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequest{
			Name:        prefix + "_complete_roles",
			Description: strPtr("An example role"),
			Permissions: perms,
		}

		created, _, err := KestraTestApiClient().RolesAPI.CreateRole(ctx, MAIN_TENANT).IAMRoleControllerApiRoleCreateOrUpdateRequest(roleReq).Execute()
		require.NoError(t, err)

		ac := kestra_api_client.ApiAutocomplete{}
		ac.SetQ(prefix)
		results, _, err := KestraTestApiClient().RolesAPI.AutocompleteRoles(ctx, MAIN_TENANT).ApiAutocomplete(ac).Execute()
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
		ctx := GetAuthContext()

		name := "test_create_role_" + randomId()
		perms := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions{
			FLOW: []string{"READ"},
		}
		req := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequest{
			Name:        name,
			Description: strPtr("An example role"),
			Permissions: perms,
		}

		created, _, err := KestraTestApiClient().RolesAPI.CreateRole(ctx, MAIN_TENANT).IAMRoleControllerApiRoleCreateOrUpdateRequest(req).Execute()
		require.NoError(t, err)
		require.Equal(t, name, created.GetName())
		require.NotEmpty(t, created.GetId())
	})

	t.Run("deleteRoleTest", func(t *testing.T) {
		ctx := GetAuthContext()

		name := "test_delete_role_" + randomId()
		perms := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions{
			FLOW: []string{"READ"},
		}
		req := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequest{
			Name:        name,
			Permissions: perms,
		}

		created, _, err := KestraTestApiClient().RolesAPI.CreateRole(ctx, MAIN_TENANT).IAMRoleControllerApiRoleCreateOrUpdateRequest(req).Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().RolesAPI.DeleteRole(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		_, httpResp, err := KestraTestApiClient().RolesAPI.Role(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.Error(t, err)
		if httpResp != nil {
			require.Equal(t, 404, httpResp.StatusCode)
		}
	})

	t.Run("getRoleTest", func(t *testing.T) {
		ctx := GetAuthContext()

		name := "test_get_role_" + randomId()
		perms := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions{
			FLOW: []string{"READ"},
		}
		req := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequest{
			Name:        name,
			Permissions: perms,
		}

		created, _, err := KestraTestApiClient().RolesAPI.CreateRole(ctx, MAIN_TENANT).IAMRoleControllerApiRoleCreateOrUpdateRequest(req).Execute()
		require.NoError(t, err)

		fetched, _, err := KestraTestApiClient().RolesAPI.Role(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
		require.Equal(t, created.GetName(), fetched.GetName())
	})

	t.Run("listRolesFromGivenIdsTest", func(t *testing.T) {
		ctx := GetAuthContext()

		name := "test_list_roles_from_given_ids_" + randomId()
		perms := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions{
			FLOW: []string{"READ"},
		}
		req := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequest{
			Name:        name,
			Permissions: perms,
		}

		created, _, err := KestraTestApiClient().RolesAPI.CreateRole(ctx, MAIN_TENANT).IAMRoleControllerApiRoleCreateOrUpdateRequest(req).Execute()
		require.NoError(t, err)

		ids := kestra_api_client.ApiIds{Ids: []string{created.GetId()}}
		fetched, _, err := KestraTestApiClient().RolesAPI.ListRolesFromGivenIds(ctx, MAIN_TENANT).ApiIds(ids).Execute()
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
		ctx := GetAuthContext()

		name := "test_search_roles_" + randomId()
		perms := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions{
			FLOW: []string{"READ"},
		}
		req := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequest{
			Name:        name,
			Permissions: perms,
		}

		created, _, err := KestraTestApiClient().RolesAPI.CreateRole(ctx, MAIN_TENANT).IAMRoleControllerApiRoleCreateOrUpdateRequest(req).Execute()
		require.NoError(t, err)

		page, _, err := KestraTestApiClient().RolesAPI.SearchRoles(ctx, MAIN_TENANT).Page(1).Size(10).Q(name).Execute()
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
		ctx := GetAuthContext()

		name := "test_update_role_" + randomId()
		perms := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions{
			FLOW: []string{"READ"},
		}
		createReq := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequest{
			Name:        name,
			Description: strPtr("Before"),
			Permissions: perms,
		}

		created, _, err := KestraTestApiClient().RolesAPI.CreateRole(ctx, MAIN_TENANT).IAMRoleControllerApiRoleCreateOrUpdateRequest(createReq).Execute()
		require.NoError(t, err)

		updatedDesc := "Updated description"
		updateReq := kestra_api_client.IAMRoleControllerApiRoleCreateOrUpdateRequest{
			Name:        created.GetName(),
			Description: strPtr(updatedDesc),
			Permissions: perms,
		}
		updated, _, err := KestraTestApiClient().RolesAPI.UpdateRole(ctx, created.GetId(), MAIN_TENANT).IAMRoleControllerApiRoleCreateOrUpdateRequest(updateReq).Execute()
		require.NoError(t, err)
		require.Equal(t, updatedDesc, updated.GetDescription())
	})
}
