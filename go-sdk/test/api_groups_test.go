package test

import (
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestGroupsAPI_All(t *testing.T) {
	t.Run("addUserToGroupTest", func(t *testing.T) {
		ctx := GetAuthContext()

		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_add_user_to_group_" + randomId(),
			Description: strPtr("An example group"),
		}
		createdGroup, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		userReq := kestra_api_client.IAMUserControllerApiCreateOrUpdateUserRequest{
			Email: "test_add_user_to_group_" + randomId() + "@kestra.io",
		}
		createdUser, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(userReq).Execute()
		require.NoError(t, err)

		member, _, err := KestraTestApiClient().GroupsAPI.AddUserToGroup(ctx, createdGroup.GetId(), createdUser.GetId(), MAIN_TENANT).Execute()
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
		ctx := GetAuthContext()

		prefix := "test_auto_" + randomId()
		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        prefix + "_complete_groups",
			Description: strPtr("An example group"),
		}
		created, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		ac := kestra_api_client.ApiAutocomplete{}
		ac.SetQ(prefix)
		results, _, err := KestraTestApiClient().GroupsAPI.AutocompleteGroups(ctx, MAIN_TENANT).ApiAutocomplete(ac).Execute()
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
		ctx := GetAuthContext()

		name := "test_create_group_" + randomId()
		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        name,
			Description: strPtr("An example group"),
		}

		created, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)
		require.Equal(t, name, created.GetName())
		require.NotEmpty(t, created.GetId())
	})

	t.Run("deleteGroupTest", func(t *testing.T) {
		ctx := GetAuthContext()

		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_delete_group_" + randomId(),
			Description: strPtr("An example group"),
		}
		created, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().GroupsAPI.DeleteGroup(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		_, httpResp, err := KestraTestApiClient().GroupsAPI.Group(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.Error(t, err)
		if httpResp != nil {
			require.Equal(t, 404, httpResp.StatusCode)
		}
	})

	t.Run("deleteUserFromGroupTest", func(t *testing.T) {
		ctx := GetAuthContext()

		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_delete_user_from_group_" + randomId(),
			Description: strPtr("An example group"),
		}
		group, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		userReq := kestra_api_client.IAMUserControllerApiCreateOrUpdateUserRequest{
			Email: "test_delete_user_from_group_" + randomId() + "@kestra.io",
		}
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(userReq).Execute()
		require.NoError(t, err)

		_, _, err = KestraTestApiClient().GroupsAPI.AddUserToGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		member, _, err := KestraTestApiClient().GroupsAPI.DeleteUserFromGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		for _, g := range member.GetGroups() {
			require.NotEqual(t, group.GetId(), g.GetId())
		}
	})

	t.Run("getGroupTest", func(t *testing.T) {
		ctx := GetAuthContext()

		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_get_group_" + randomId(),
			Description: strPtr("An example group"),
		}
		created, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		fetched, _, err := KestraTestApiClient().GroupsAPI.Group(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
		require.Equal(t, created.GetName(), fetched.GetName())
	})

	t.Run("listGroupIdsTest", func(t *testing.T) {
		ctx := GetAuthContext()

		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_list_group_ids_" + randomId(),
			Description: strPtr("An example group"),
		}
		created, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		ids := kestra_api_client.ApiIds{Ids: []string{created.GetId()}}
		fetched, _, err := KestraTestApiClient().GroupsAPI.ListGroupIds(ctx, MAIN_TENANT).ApiIds(ids).Execute()
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
		ctx := GetAuthContext()

		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_search_group_members_" + randomId(),
			Description: strPtr("An example group"),
		}
		group, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		userReq := kestra_api_client.IAMUserControllerApiCreateOrUpdateUserRequest{
			Email: "test_search_group_members_" + randomId() + "@kestra.io",
		}
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(userReq).Execute()
		require.NoError(t, err)

		_, _, err = KestraTestApiClient().GroupsAPI.AddUserToGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		page, _, err := KestraTestApiClient().GroupsAPI.SearchGroupMembers(ctx, group.GetId(), MAIN_TENANT).Page(1).Size(10).Q(user.GetEmail()).Execute()
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
		ctx := GetAuthContext()

		name := "test_search_groups_" + randomId()
		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        name,
			Description: strPtr("An example group"),
		}
		created, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		results, _, err := KestraTestApiClient().GroupsAPI.SearchGroups(ctx, MAIN_TENANT).Page(1).Size(10).Q(name).Execute()
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
		ctx := GetAuthContext()

		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_set_user_membership_for_group_" + randomId(),
			Description: strPtr("An example group"),
		}
		group, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		userReq := kestra_api_client.IAMUserControllerApiCreateOrUpdateUserRequest{
			Email: "test_set_user_membership_for_group_" + randomId() + "@kestra.io",
		}
		user, _, err := KestraTestApiClient().UsersAPI.CreateUser(ctx).IAMUserControllerApiCreateOrUpdateUserRequest(userReq).Execute()
		require.NoError(t, err)

		_, _, err = KestraTestApiClient().GroupsAPI.AddUserToGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		member, _, err := KestraTestApiClient().GroupsAPI.SetUserMembershipForGroup(ctx, group.GetId(), user.GetId(), MAIN_TENANT).Membership(kestra_api_client.GROUPIDENTIFIERMEMBERSHIP_OWNER).Execute()
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
		ctx := GetAuthContext()

		groupReq := kestra_api_client.IAMGroupControllerApiCreateGroupRequest{
			Name:        "test_update_group_" + randomId(),
			Description: strPtr("Before"),
		}
		created, _, err := KestraTestApiClient().GroupsAPI.CreateGroup(ctx, MAIN_TENANT).IAMGroupControllerApiCreateGroupRequest(groupReq).Execute()
		require.NoError(t, err)

		updatedDesc := "Updated description"
		updateReq := kestra_api_client.IAMGroupControllerApiUpdateGroupRequest{
			Name:        created.GetName(),
			Description: strPtr(updatedDesc),
		}
		updated, _, err := KestraTestApiClient().GroupsAPI.UpdateGroup(ctx, created.GetId(), MAIN_TENANT).IAMGroupControllerApiUpdateGroupRequest(updateReq).Execute()
		require.NoError(t, err)
		require.Equal(t, updatedDesc, updated.GetDescription())
	})
}
