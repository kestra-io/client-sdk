package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestGroupsAPI_All(t *testing.T) {
	t.Run("addUserToGroupTest", func(t *testing.T) {
		ctx := context.Background()

		groupReq := map[string]interface{}{
			"name":        "test_add_user_to_group_" + randomId(),
			"description": "An example group",
		}
		createdGroup, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		userReq := map[string]interface{}{
			"email": "test_add_user_to_group_" + randomId() + "@kestra.io",
		}
		createdUser, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		member, err := KestraTestClient().Groups().AddUserToGroup(ctx, createdGroup.GetId(), createdUser.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		found := false
		for _, g := range member.GetGroups() {
			if g.GetId() == createdGroup.GetId() {
				found = true
				break
			}
		}
		require.True(t, found, "member should contain newly-added group")
	})

	t.Run("autocompleteGroupsTest", func(t *testing.T) {
		ctx := context.Background()

		prefix := "test_auto_" + randomId()
		groupReq := map[string]interface{}{
			"name":        prefix + "_complete_groups",
			"description": "An example group",
		}
		created, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		ac := map[string]interface{}{"q": prefix}
		results, err := KestraTestClient().Groups().AutocompleteGroups(ctx, MAIN_TENANT, ac, nil)
		require.NoError(t, err)

		found := false
		for _, r := range results {
			if r.GetId() == created.GetId() || r.GetName() == created.GetName() {
				found = true
				break
			}
		}
		require.True(t, found, "autocomplete should include the created group")
	})

	t.Run("createGroupTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test_create_group_" + randomId()
		groupReq := map[string]interface{}{
			"name":        name,
			"description": "An example group",
		}

		created, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)
		require.Equal(t, name, created.GetName())
		require.NotEmpty(t, created.GetId())
	})

	t.Run("deleteGroupTest", func(t *testing.T) {
		ctx := context.Background()

		groupReq := map[string]interface{}{
			"name":        "test_delete_group_" + randomId(),
			"description": "An example group",
		}
		created, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		err = KestraTestClient().Groups().DeleteGroup(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		_, err = KestraTestClient().Groups().Group(ctx, created.GetId(), MAIN_TENANT)
		require.Error(t, err)
	})

	t.Run("deleteUserFromGroupTest", func(t *testing.T) {
		ctx := context.Background()

		groupReq := map[string]interface{}{
			"name":        "test_delete_user_from_group_" + randomId(),
			"description": "An example group",
		}
		group, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		userReq := map[string]interface{}{
			"email": "test_delete_user_from_group_" + randomId() + "@kestra.io",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		_, err = KestraTestClient().Groups().AddUserToGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		member, err := KestraTestClient().Groups().DeleteUserFromGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		for _, g := range member.GetGroups() {
			require.NotEqual(t, group.GetId(), g.GetId())
		}
	})

	t.Run("getGroupTest", func(t *testing.T) {
		ctx := context.Background()

		groupReq := map[string]interface{}{
			"name":        "test_get_group_" + randomId(),
			"description": "An example group",
		}
		created, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Groups().Group(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
		require.Equal(t, created.GetName(), fetched.GetName())
	})

	t.Run("listGroupIdsTest", func(t *testing.T) {
		ctx := context.Background()

		groupReq := map[string]interface{}{
			"name":        "test_list_group_ids_" + randomId(),
			"description": "An example group",
		}
		created, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		ids := []string{created.GetId()}
		fetched, err := KestraTestClient().Groups().ListGroupIds(ctx, MAIN_TENANT, ids)
		require.NoError(t, err)
		require.NotEmpty(t, fetched)

		found := false
		for _, g := range fetched {
			if g.GetId() == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found)
	})

	t.Run("searchGroupMembersTest", func(t *testing.T) {
		ctx := context.Background()

		groupReq := map[string]interface{}{
			"name":        "test_search_group_members_" + randomId(),
			"description": "An example group",
		}
		group, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		userReq := map[string]interface{}{
			"email": "test_search_group_members_" + randomId() + "@kestra.io",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		_, err = KestraTestClient().Groups().AddUserToGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterQuery,
				Operation: kestra_api_client.OpEquals,
				Value:     user.GetEmail(),
			},
		}
		page, err := KestraTestClient().Groups().SearchGroupMembers(ctx, group.GetId(), MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, filters)
		require.NoError(t, err)
		require.NotNil(t, page)
		require.NotNil(t, page.GetResults())

		found := false
		for _, m := range page.GetResults() {
			if m.GetId() == user.GetId() {
				found = true
				break
			}
		}
		require.True(t, found, "search should return the added user")
	})

	t.Run("searchGroupsTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test_search_groups_" + randomId()
		groupReq := map[string]interface{}{
			"name":        name,
			"description": "An example group",
		}
		created, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterQuery,
				Operation: kestra_api_client.OpEquals,
				Value:     name,
			},
		}
		results, err := KestraTestClient().Groups().SearchGroups(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, filters)
		require.NoError(t, err)
		require.NotNil(t, results)
		require.NotNil(t, results.GetResults())

		found := false
		for _, r := range results.GetResults() {
			if r.GetId() == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found)
	})

	t.Run("setUserMembershipForGroupTest", func(t *testing.T) {
		ctx := context.Background()

		groupReq := map[string]interface{}{
			"name":        "test_set_user_membership_for_group_" + randomId(),
			"description": "An example group",
		}
		group, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		userReq := map[string]interface{}{
			"email": "test_set_user_membership_for_group_" + randomId() + "@kestra.io",
		}
		user, err := KestraTestClient().Users().CreateUser(ctx, userReq)
		require.NoError(t, err)

		_, err = KestraTestClient().Groups().AddUserToGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		member, err := KestraTestClient().Groups().SetUserMembershipForGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT, kestra_api_client.PtrString("OWNER"))
		require.NoError(t, err)

		found := false
		for _, g := range member.GetGroups() {
			if g.GetId() == group.GetId() {
				found = true
				break
			}
		}
		require.True(t, found)
	})

	t.Run("updateGroupTest", func(t *testing.T) {
		ctx := context.Background()

		groupReq := map[string]interface{}{
			"name":        "test_update_group_" + randomId(),
			"description": "Before",
		}
		created, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, groupReq)
		require.NoError(t, err)

		updatedDesc := "Updated description"
		updateReq := map[string]interface{}{
			"name":        created.GetName(),
			"description": updatedDesc,
		}
		updated, err := KestraTestClient().Groups().UpdateGroup(ctx, created.GetId(), MAIN_TENANT, updateReq)
		require.NoError(t, err)
		require.Equal(t, updatedDesc, updated.GetDescription())
	})
}
