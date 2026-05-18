package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

// simple pointer helpers for request models
func strPtr(s string) *string { return &s }

func TestUsersAPI_All(t *testing.T) {

	t.Run("autocompleteUsersTest", func(t *testing.T) {
		ctx := context.Background()

		// Create user
		email := "test_autocomplete_users_" + randomId() + "@kestra.io"
		userReq := map[string]interface{}{
			"email": email,
		}
		createdUser, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)
		require.NotNil(t, createdUser)

		// Create group and add user
		groupReq := map[string]interface{}{
			"name":        "test_add_user_to_group_" + randomId(),
			"description": "An example group",
		}
		group, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)
		require.NotNil(t, group)

		_, err = KestraTestClient().Groups().AddUserToGroup(ctx, group.GetId(), createdUser.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		// Autocomplete by email
		ac := map[string]interface{}{"q": email}
		results, err := KestraTestClient().Users().AutocompleteUsers(ctx, MAIN_TENANT, ac)
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
		ctx := context.Background()

		base := "testcreateapitokenforuser" + randomId()

		// create user
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)
		require.NotNil(t, user)

		// create API token for user
		tokenReq := map[string]interface{}{
			"name":        base,
			"description": "token for " + base,
		}
		token, err := KestraTestClient().Users().CreateApiTokensForUser(ctx, user.GetId(), tokenReq)
		require.NoError(t, err)
		require.NotNil(t, token)
	})

	t.Run("createUserTest", func(t *testing.T) {
		ctx := context.Background()

		base := "testcreateuser" + randomId()
		email := base + "@kestra.io"
		req := map[string]interface{}{
			"email":     email,
			"firstName": base,
			"password":  "Password!234",
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, req)
		require.NoError(t, err)
		require.NotNil(t, created)
		assert.Equal(t, email, created.GetEmail())
	})

	t.Run("deleteApiTokenTest", func(t *testing.T) {
		ctx := context.Background()

		base := "testdeleteapitokenforuser" + randomId()
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		tokenReq := map[string]interface{}{
			"name":        base,
			"description": "token to delete",
		}
		createdToken, err := KestraTestClient().Users().CreateApiTokensForUser(ctx, user.GetId(), tokenReq)
		require.NoError(t, err)
		tokenId := createdToken.GetId()
		require.NotEmpty(t, tokenId)

		err = KestraTestClient().Users().DeleteApiTokenForUser(ctx, user.GetId(), tokenId)
		require.NoError(t, err)

		tokenList, err := KestraTestClient().Users().ListApiTokensForUser(ctx, user.GetId())
		require.NoError(t, err)
		assert.NotNil(t, tokenList)
		for _, tk := range tokenList.GetResults() {
			assert.NotEqual(t, tokenId, tk.GetId())
		}
	})

	t.Run("deleteRefreshTokenTest", func(t *testing.T) {
		ctx := context.Background()

		base := "test_delete_refresh_token_" + randomId()
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		err = KestraTestClient().Users().DeleteRefreshToken(ctx, user.GetId())
		require.NoError(t, err)

		_ = KestraTestClient().Users().DeleteUser(ctx, user.GetId())
	})

	t.Run("deleteUserTest", func(t *testing.T) {
		ctx := context.Background()

		base := "test_delete_user_" + randomId()
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		err = KestraTestClient().Users().DeleteUser(ctx, user.GetId())
		require.NoError(t, err)

		_, err = KestraTestClient().Users().User(ctx, user.GetId())
		require.Error(t, err)
	})

	t.Run("deleteUserAuthMethodTest", func(t *testing.T) {
		ctx := context.Background()

		base := "test_delete_user_auth_method_" + randomId()
		userReq := map[string]interface{}{
			"email":    base + "@kestra.io",
			"password": "Password!234",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		var authId string
		if auths := user.GetAuths(); auths != nil && len(auths) > 0 {
			authId = auths[0].GetId()
		}
		require.NotEmpty(t, authId)

		patched, err := KestraTestClient().Users().DeleteUserAuthMethod(ctx, user.GetId(), authId)
		require.NoError(t, err)
		require.Equal(t, user.GetId(), patched.GetId())

		_ = KestraTestClient().Users().DeleteUser(ctx, user.GetId())
	})

	t.Run("getUserTest", func(t *testing.T) {
		ctx := context.Background()

		base := "test_get_user_" + randomId()
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Users().User(ctx, created.GetId())
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())

		_ = KestraTestClient().Users().DeleteUser(ctx, created.GetId())
	})

	t.Run("listApiTokensTest", func(t *testing.T) {
		ctx := context.Background()

		base := "testlistapitokensforuser" + randomId()
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		tokenReq := map[string]interface{}{
			"name":        base,
			"description": "token for " + base,
		}
		_, err = KestraTestClient().Users().CreateApiTokensForUser(ctx, user.GetId(), tokenReq)
		require.NoError(t, err)

		tokens, err := KestraTestClient().Users().ListApiTokensForUser(ctx, user.GetId())
		require.NoError(t, err)
		require.NotNil(t, tokens)

		_ = KestraTestClient().Users().DeleteUser(ctx, user.GetId())
	})

	t.Run("listUsersTest", func(t *testing.T) {
		ctx := context.Background()

		base := "test_list_users_" + randomId()
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterQuery,
				Operation: kestra_api_client.OpEquals,
				Value:     base,
			},
		}
		page, err := KestraTestClient().Users().ListUsers(ctx, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(50), nil, filters)
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

		_ = KestraTestClient().Users().DeleteUser(ctx, created.GetId())
	})

	t.Run("patchUserTest", func(t *testing.T) {
		ctx := context.Background()

		base := "test_patch_user_" + randomId()
		userReq := map[string]interface{}{
			"email":     base + "@kestra.io",
			"firstName": "Old",
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		patch := map[string]interface{}{"firstName": "New"}
		updated, err := KestraTestClient().Users().PatchUser(ctx, created.GetId(), patch)
		require.NoError(t, err)
		assert.Equal(t, "New", *updated.FirstName)

		_ = KestraTestClient().Users().DeleteUser(ctx, created.GetId())
	})

	t.Run("patchUserDemoTest", func(t *testing.T) {
		ctx := context.Background()

		base := "testpatchuserdemo" + randomId()
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		req := map[string]interface{}{"restricted": true}
		err = KestraTestClient().Users().PatchUserDemo(ctx, created.GetId(), req)
		require.NoError(t, err)

		_ = KestraTestClient().Users().DeleteUser(ctx, created.GetId())
	})

	t.Run("patchUserPasswordTest", func(t *testing.T) {
		ctx := context.Background()

		base := "testpatchuserpassword" + randomId()
		userReq := map[string]interface{}{
			"email":    base + "@kestra.io",
			"password": "OldPass!1",
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		req := map[string]interface{}{"password": "NewPass!1"}
		resp, err := KestraTestClient().Users().PatchUserPassword(ctx, created.GetId(), req)
		require.NoError(t, err)
		require.NotNil(t, resp)

		_ = KestraTestClient().Users().DeleteUser(ctx, created.GetId())
	})

	t.Run("patchUserSuperAdminTest", func(t *testing.T) {
		ctx := context.Background()

		base := "testpatchusersuperadmin" + randomId()
		userReq := map[string]interface{}{
			"email": base + "@kestra.io",
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		patch := map[string]interface{}{"superAdmin": true}
		err = KestraTestClient().Users().PatchUserSuperAdmin(ctx, created.GetId(), patch)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Users().User(ctx, created.GetId())
		require.NoError(t, err)
		assert.True(t, fetched.GetSuperAdmin())

		_ = KestraTestClient().Users().DeleteUser(ctx, created.GetId())
	})

	t.Run("updateCurrentUserPasswordTest", func(t *testing.T) {
		ctx := context.Background()

		base := "testupdatecurrentuserpassword" + randomId()
		email := base + "@kestra.io"
		initial := "InitialPass!1"
		changed := "ChangedPass!1"

		userReq := map[string]interface{}{
			"email":    email,
			"tenants":  []string{MAIN_TENANT},
			"password": initial,
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		// build a user-specific client with basic auth
		userClient := kestra_api_client.NewClient(
			HOST,
			kestra_api_client.WithBasicAuth(email, initial),
		)

		change := map[string]interface{}{
			"oldPassword": initial,
			"newPassword": changed,
		}
		_, err = userClient.Users().UpdateCurrentUserPassword(ctx, change)
		require.NoError(t, err)

		// re-authenticate with changed password and revert
		userClient2 := kestra_api_client.NewClient(
			HOST,
			kestra_api_client.WithBasicAuth(email, changed),
		)

		revert := map[string]interface{}{
			"oldPassword": changed,
			"newPassword": initial,
		}
		_, err = userClient2.Users().UpdateCurrentUserPassword(ctx, revert)
		require.NoError(t, err)

		_ = KestraTestClient().Users().DeleteUser(ctx, created.GetId())
	})

	t.Run("updateUserTest", func(t *testing.T) {
		ctx := context.Background()

		base := "testupdateuser" + randomId()
		email := base + "@kestra.io"
		userReq := map[string]interface{}{
			"email":     email,
			"firstName": "Before",
		}
		created, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		updateReq := map[string]interface{}{
			"email":     *created.Email,
			"firstName": "After",
		}
		updated, err := KestraTestClient().Users().UpdateUser(ctx, created.GetId(), updateReq)
		require.NoError(t, err)
		assert.Equal(t, "After", *updated.FirstName)

		_ = KestraTestClient().Users().DeleteUser(ctx, created.GetId())
	})

	t.Run("updateUserGroupsTest", func(t *testing.T) {
		ctx := context.Background()

		// create group
		groupReq := map[string]interface{}{
			"name":        "testcreategroup" + randomId(),
			"description": "An example group",
		}
		group, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		// create user with tenant access
		base := "testupdateusergroups" + randomId()
		userReq := map[string]interface{}{
			"email":   base + "@kestra.io",
			"tenants": []string{MAIN_TENANT},
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		req := map[string]interface{}{
			"groupIds": []string{group.GetId()},
		}
		err = KestraTestClient().Users().UpdateUserGroups(ctx, user.GetId(), MAIN_TENANT, req)
		require.NoError(t, err)

		// cleanup
		_ = KestraTestClient().Users().DeleteUser(ctx, user.GetId())
		_ = KestraTestClient().Groups().DeleteGroup(ctx, group.GetId(), MAIN_TENANT)
	})

	t.Run("impersonateTest", func(t *testing.T) {
		t.Skip("Impersonate changes session state — skipped to avoid test interference")
	})
}
