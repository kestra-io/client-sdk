package main

import (
	"fmt"
	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
	"testing"
)

// simple pointer helpers for request models
func strPtr(s string) *string { return &s }
func boolPtr(b bool) *bool    { return &b }

func TestUsersAPI_All(t *testing.T) {

	t.Run("autocompleteUsersTest", func(t *testing.T) {
		ctx := GetAuthContext()

		// Create user
		email := "test_autocomplete_users_" + randomId() + "@kestra.io"
		userReq := openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
			Email: *strPtr(email),
		}
		createdUser, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(userReq).Execute()
		require.NoError(t, err)
		require.NotNil(t, createdUser)

		// Create group and add user
		groupReq := openapiclient.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_add_user_to_group_" + randomId(),
			Description: strPtr("An example group"),
		}
		group, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)
		require.NotNil(t, group)

		_, _, err = KestraTestApiClient().GroupsAPI.AddUserToGroup(ctx, group.GetId(), createdUser.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		// Autocomplete by email
		ac := openapiclient.IAMTenantAccessControllerUserApiAutocomplete{Q: *openapiclient.NewNullableString(&email)}
		results, _, err := KestraTestApiClient().UsersAPI.AutocompleteUsers(ctx, MAIN_TENANT).IAMTenantAccessControllerUserApiAutocomplete(ac).Execute()
		require.NoError(t, err)
		require.NotNil(t, results)
		assert.True(t, func() bool {
			for _, r := range results {
				if r.GetUsername() == email {
					return true
				}
			}
			return false
		}(), "Autocomplete should include the created user's email")
	})

	t.Run("createApiTokensForUserTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "testcreateapitokenforuser" + randomId()

		// create user
		userReq := openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
			Email: base + "@kestra.io",
		}
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(userReq).Execute()
		require.NoError(t, err)
		require.NotNil(t, user)

		// create API token for user
		tokenReq := openapiclient.CreateApiTokenRequest{
			Name:        *strPtr(base),
			Description: strPtr("token for " + base),
		}
		token, _, err := KestraTestApiClient().UsersAPI.CreateApiTokensForUser(ctx, user.GetId()).CreateApiTokenRequest(tokenReq).Execute()
		require.NoError(t, err)
		require.NotNil(t, token)
	})

	t.Run("createUserTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "testcreateuser" + randomId()
		req := openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
			Email:     *strPtr(base + "@kestra.io"),
			FirstName: strPtr(base),
			Password:  strPtr("Password!234"),
		}
		created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(req).Execute()
		require.NoError(t, err)
		require.NotNil(t, created)
		assert.Equal(t, req.Email, created.GetEmail())
	})

	t.Run("deleteApiTokenTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "testdeleteapitokenforuser" + randomId()
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
			IAMUserControllerApiCreateOrUpdateUserRequest(
				openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{Email: *strPtr(base + "@kestra.io")},
			).Execute()

		require.NoError(t, err)

		tokenReq := openapiclient.CreateApiTokenRequest{
			Name:        *strPtr(base),
			Description: strPtr("token to delete"),
		}
		createdToken, _, err := KestraTestApiClient().UsersAPI.CreateApiTokensForUser(ctx, user.GetId()).CreateApiTokenRequest(tokenReq).Execute()
		require.NoError(t, err)
		tokenId := createdToken.GetId()
		require.NotEmpty(t, tokenId)

		_, err = KestraTestApiClient().UsersAPI.DeleteApiTokenForUser(ctx, user.GetId(), tokenId).Execute()
		require.NoError(t, err)

		tokenList, _, err := KestraTestApiClient().UsersAPI.ListApiTokensForUser(ctx, user.GetId()).Execute()
		require.NoError(t, err)
		assert.NotNil(t, tokenList)
		for _, tk := range tokenList.GetResults() {
			assert.NotEqual(t, tokenId, tk.GetId())
		}
	})

	t.Run("deleteRefreshTokenTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "test_delete_refresh_token_" + randomId()
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
			IAMUserControllerApiCreateOrUpdateUserRequest(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{Email: *strPtr(base + "@kestra.io")}).
			Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().UsersAPI.DeleteRefreshToken(ctx, user.GetId()).Execute()
		require.NoError(t, err)

		_, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx, user.GetId()).Execute()
	})

	t.Run("deleteUserTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "test_delete_user_" + randomId()
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
			IAMUserControllerApiCreateOrUpdateUserRequest(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{Email: *strPtr(base + "@kestra.io")}).
			Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().UsersAPI.DeleteUser(ctx, user.GetId()).Execute()
		require.NoError(t, err)

		_, httpResp, err := KestraTestApiClient().UsersAPI.GetUser(ctx, user.GetId()).Execute()
		require.Error(t, err)
		_ = httpResp
	})
	t.Run("deleteUserAuthMethodTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "test_delete_user_auth_method_" + randomId()
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(
			openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
				Email:    *strPtr(base + "@kestra.io"),
				Password: strPtr("Password!234"),
			},
		).Execute()
		require.NoError(t, err)

		var authId string
		if auths := user.GetAuths(); auths != nil && len(auths) > 0 {
			authId = auths[0].GetId()
		}
		require.NotEmpty(t, authId)

		patched, _, err := KestraTestApiClient().UsersAPI.DeleteUserAuthMethod(ctx, user.GetId(), authId).Execute()
		require.NoError(t, err)
		require.Equal(t, user.GetId(), patched.GetId())

		_, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx, user.GetId()).Execute()
	})

	t.Run("getUserTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "test_get_user_" + randomId()
		created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(
			openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{Email: *strPtr(base + "@kestra.io")},
		).Execute()
		require.NoError(t, err)

		fetched, _, err := KestraTestApiClient().UsersAPI.GetUser(ctx, created.GetId()).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())

		_, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx, created.GetId()).Execute()
	})

	t.Run("listApiTokensTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "testlistapitokensforuser" + randomId()
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
			IAMUserControllerApiCreateOrUpdateUserRequest(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{Email: *strPtr(base + "@kestra.io")}).
			Execute()
		require.NoError(t, err)

		tokenReq := openapiclient.CreateApiTokenRequest{
			Name:        *strPtr(base),
			Description: strPtr("token for " + base),
		}
		_, _, err = KestraTestApiClient().UsersAPI.CreateApiTokensForUser(ctx, user.GetId()).CreateApiTokenRequest(tokenReq).Execute()
		require.NoError(t, err)

		tokens, _, err := KestraTestApiClient().UsersAPI.ListApiTokensForUser(ctx, user.GetId()).Execute()
		require.NoError(t, err)
		require.NotNil(t, tokens)

		_, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx, user.GetId()).Execute()
	})

	t.Run("listUsersTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "test_list_users_" + randomId()
		created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
			IAMUserControllerApiCreateOrUpdateUserRequest(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{Email: *strPtr(base + "@kestra.io")}).
			Execute()
		require.NoError(t, err)

		page, _, err := KestraTestApiClient().UsersAPI.ListUsers(ctx).Page(1).Size(50).Q(base).Execute()
		require.NoError(t, err)
		require.NotNil(t, page)
		require.NotNil(t, page.GetResults())
		found := false
		for _, s := range page.GetResults() {
			if s.GetId() == created.GetId() {
				found = true
				break
			}
		}
		assert.True(t, found, "Search should include the created user")

		_, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx, created.GetId()).Execute()
	})

	t.Run("patchUserTest", func(t *testing.T) {
		ctx := GetAuthContext()

		base := "test_patch_user_" + randomId()
		created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
			IAMUserControllerApiCreateOrUpdateUserRequest(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
				Email:     *strPtr(base + "@kestra.io"),
				FirstName: strPtr("Old"),
			}).
			Execute()
		require.NoError(t, err)

		patch := openapiclient.MeControllerApiUserDetailsRequest{FirstName: strPtr("New")}
		updated, _, err := KestraTestApiClient().UsersAPI.PatchUser(ctx, created.GetId()).MeControllerApiUserDetailsRequest(patch).Execute()
		require.NoError(t, err)
		assert.Equal(t, "New", *updated.FirstName)

		_, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx, created.GetId()).Execute()
	})

	/*

	   t.Run("patchUserDemoTest", func(t *testing.T) {
	       base := "test_patch_user_demo_" + randomId()
	       created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
	           Body(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{Email: strPtr(base + "@kestra.io")}).
	           Execute()
	       require.NoError(t, err)

	       req := openapiclient.IAMUserControllerApiPatchRestrictedRequest{Restricted: boolPtr(true)}
	       _, _, err = KestraTestApiClient().UsersAPI.PatchUserDemo(ctx).UserId(created.GetId()).Body(req).Execute()
	       require.NoError(t, err)

	       _, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx).Id(created.GetId()).Execute()
	   })

	   t.Run("patchUserPasswordTest", func(t *testing.T) {
	       base := "test_patch_user_password_" + randomId()
	       created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
	           Body(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
	               Email:    strPtr(base + "@kestra.io"),
	               Password: strPtr("OldPass!1"),
	           }).
	           Execute()
	       require.NoError(t, err)

	       req := openapiclient.IAMUserControllerApiPatchUserPasswordRequest{Password: strPtr("NewPass!1")}
	       resp, _, err := KestraTestApiClient().UsersAPI.PatchUserPassword(ctx).UserId(created.GetId()).Body(req).Execute()
	       require.NoError(t, err)
	       require.NotNil(t, resp)

	       _, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx).Id(created.GetId()).Execute()
	   })

	   t.Run("patchUserSuperAdminTest", func(t *testing.T) {
	       base := "test_patch_user_super_admin_" + randomId()
	       created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
	           Body(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{Email: strPtr(base + "@kestra.io")}).
	           Execute()
	       require.NoError(t, err)

	       patch := openapiclient.ApiPatchSuperAdminRequest{SuperAdmin: boolPtr(true)}
	       _, _, err = KestraTestApiClient().UsersAPI.PatchUserSuperAdmin(ctx).UserId(created.GetId()).Body(patch).Execute()
	       require.NoError(t, err)

	       fetched, _, err := KestraTestApiClient().UsersAPI.GetUser(ctx).Id(created.GetId()).Execute()
	       require.NoError(t, err)
	       assert.True(t, fetched.GetSuperAdmin() != nil && *fetched.GetSuperAdmin())

	       _, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx).Id(created.GetId()).Execute()
	   })

	   t.Run("updateCurrentUserPasswordTest", func(t *testing.T) {
	       base := "test_update_current_user_password_" + randomId()
	       email := base + "@kestra.io"
	       initial := "InitialPass!1"
	       changed := "ChangedPass!1"

	       created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
	           Body(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
	               Email:    strPtr(email),
	               Tenants:  &[]string{MAIN_TENANT},
	               Password: strPtr(initial),
	           }).
	           Execute()
	       require.NoError(t, err)

	       // build a user-specific client with basic auth - adapt to how your SDK expects auth
	       userCfg := openapiclient.NewConfiguration()
	       userCfg.DefaultHeader = map[string]string{"Authorization": "Basic " + basicAuthHeader(email, initial)}
	       if host := os.Getenv("KESRTA_HOST"); host != "" {
	           userCfg.BasePath = host
	       }
	       userClient := openapiclient.NewAPIClient(userCfg)

	       change := openapiclient.MeControllerApiUpdatePasswordRequest{
	           OldPassword: strPtr(initial),
	           NewPassword: strPtr(changed),
	       }
	       _, _, err = userClient.UsersAPI.UpdateCurrentUserPassword(ctx).Body(change).Execute()
	       require.NoError(t, err)

	       // re-authenticate with changed password and revert
	       userCfg2 := openapiclient.NewConfiguration()
	       userCfg2.DefaultHeader = map[string]string{"Authorization": "Basic " + basicAuthHeader(email, changed)}
	       userClient2 := openapiclient.NewAPIClient(userCfg2)
	       revert := openapiclient.MeControllerApiUpdatePasswordRequest{
	           OldPassword: strPtr(changed),
	           NewPassword: strPtr(initial),
	       }
	       _, _, err = userClient2.UsersAPI.UpdateCurrentUserPassword(ctx).Body(revert).Execute()
	       require.NoError(t, err)

	       _, _, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx).Id(created.GetId()).Execute()
	   })

	   t.Run("updateUserTest", func(t *testing.T) {
	       base := "test_update_user_" + randomId()
	       created, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
	           Body(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
	               Email:     strPtr(base + "@kestra.io"),
	               FirstName: strPtr("Before"),
	           }).
	           Execute()
	       require.NoError(t, err)

	       updateReq := openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
	           Email:     created.Email,
	           FirstName: strPtr("After"),
	       }
	       updated, _, err := KestraTestApiClient().UsersAPI.UpdateUser(ctx).UserId(created.GetId()).Body(updateReq).Execute()
	       require.NoError(t, err)
	       assert.Equal(t, "After", *updated.FirstName)

	       _, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx).Id(created.GetId()).Execute()
	   })

	   t.Run("updateUserGroupsTest", func(t *testing.T) {
	       // create group
	       group, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx).
	           Tenant(MAIN_TENANT).
	           Body(openapiclient.IAMGroupControllerApiCreateGroupRequest{
	               Name:        strPtr("test_create_group_" + randomId()),
	               Description: strPtr("An example group"),
	           }).
	           Execute()
	       require.NoError(t, err)

	       // create user with tenant access
	       base := "test_update_user_groups_" + randomId()
	       user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).
	           Body(openapiclient.IAMUserControllerApiCreateOrUpdateUserRequest{
	               Email:   strPtr(base + "@kestra.io"),
	               Tenants: &[]string{MAIN_TENANT},
	           }).
	           Execute()
	       require.NoError(t, err)

	       req := openapiclient.IAMUserGroupControllerApiUpdateUserGroupsRequest{
	           GroupIds: &[]string{group.GetId()},
	       }
	       _, _, err = KestraTestApiClient().UsersAPI.UpdateUserGroups(ctx).UserId(user.GetId(), MAIN_TENANT).Body(req).Execute()
	       require.NoError(t, err)

	       // cleanup
	       _, _ = KestraTestApiClient().UsersAPI.DeleteUser(ctx).Id(user.GetId()).Execute()
	       _, _ = KestraTestApiClient().GroupsAPI.DeleteGroup(ctx, MAIN_TENANT).Id(group.GetId()).Execute()
	   })*/
}

// basicAuthHeader returns a base64 basic auth header value for simple re-auth tests.
// Replace with real encoding as needed.
func basicAuthHeader(user, pass string) string {
	return fmt.Sprintf("%s:%s", user, pass) // adapt to base64 encode if your SDK expects "Basic <base64>"
}
