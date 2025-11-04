package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.MAIN_TENANT;
import static io.kestra.example.CommonTestSetup.kestraClient;
import static io.kestra.example.CommonTestSetup.randomId;
import static org.junit.jupiter.api.Assertions.*;

public class GroupsApiTest {

    @Test
    public void addUserToGroupTest() throws ApiException {
        // create group
        IAMGroupControllerApiCreateGroupRequest groupReq = new IAMGroupControllerApiCreateGroupRequest()
            .name("test_add_user_to_group_" + randomId())
            .description("An example group");
        IAMGroupControllerApiGroupDetail createdGroup =
            kestraClient().groups().createGroup(MAIN_TENANT, groupReq);

        // create user
        IAMUserControllerApiCreateOrUpdateUserRequest userReq =
            new IAMUserControllerApiCreateOrUpdateUserRequest()
                .email("test_add_user_to_group_" + randomId() + "@kestra.io");
        IAMUserControllerApiUser createdUser =
            kestraClient().users().createUser(userReq);

        // add user to group
        IAMGroupControllerApiGroupMember member =
            kestraClient().groups().addUserToGroup(createdGroup.getId(), createdUser.getId(), MAIN_TENANT);

        assertTrue(
            member.getGroups().stream().anyMatch(g ->
                createdGroup.getId().equals(g.getId())),
            "Member should contain newly-added group"
        );
    }

    @Test
    public void autocompleteGroupsTest() throws ApiException {
        String prefix = "test_auto_" + randomId();
        IAMGroupControllerApiCreateGroupRequest groupReq = new IAMGroupControllerApiCreateGroupRequest()
            .name(prefix + "_complete_groups")
            .description("An example group");
        IAMGroupControllerApiGroupDetail created =
            kestraClient().groups().createGroup(MAIN_TENANT, groupReq);

        ApiAutocomplete ac = new ApiAutocomplete().q(prefix);
        List<ApiGroupSummary> results =
            kestraClient().groups().autocompleteGroups(MAIN_TENANT, ac);

        assertTrue(results.stream().anyMatch(r ->
                created.getId().equals(r.getId()) || created.getName().equals(r.getName())),
            "Autocomplete should include the created group");
    }

    @Test
    public void createGroupTest() throws ApiException {
        String name = "test_create_group_" + randomId();
        IAMGroupControllerApiCreateGroupRequest groupReq = new IAMGroupControllerApiCreateGroupRequest()
            .name(name)
            .description("An example group");

        IAMGroupControllerApiGroupDetail created =
            kestraClient().groups().createGroup(MAIN_TENANT, groupReq);

        assertEquals(name, created.getName());
        assertNotNull(created.getId());
    }

    @Test
    public void deleteGroupTest() throws ApiException {
        IAMGroupControllerApiCreateGroupRequest groupReq = new IAMGroupControllerApiCreateGroupRequest()
            .name("test_delete_group_" + randomId())
            .description("An example group");
        IAMGroupControllerApiGroupDetail created =
            kestraClient().groups().createGroup(MAIN_TENANT, groupReq);

        kestraClient().groups().deleteGroup(created.getId(), MAIN_TENANT);

        // Optional: verify deletion by expecting a 404/ApiException on fetch
        assertThrows(ApiException.class, () ->
            kestraClient().groups().group(created.getId(), MAIN_TENANT));
    }

    @Test
    public void deleteUserFromGroupTest() throws ApiException {
        // group
        IAMGroupControllerApiGroupDetail group =
            kestraClient().groups().createGroup(MAIN_TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                    .name("test_delete_user_from_group_" + randomId())
                    .description("An example group"));

        // user
        IAMUserControllerApiUser user =
            kestraClient().users().createUser(
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                    .email("test_delete_user_from_group_" + randomId() + "@kestra.io"));

        // add then delete
        kestraClient().groups().addUserToGroup(group.getId(), user.getId(), MAIN_TENANT);

        IAMGroupControllerApiGroupMember member =
            kestraClient().groups().deleteUserFromGroup(group.getId(), user.getId(), MAIN_TENANT);

        assertTrue(
            member.getGroups().stream().noneMatch(g -> group.getId().equals(g.getId())),
            "Member groups should no longer include the removed group"
        );
    }

    @Test
    public void getGroupTest() throws ApiException {
        IAMGroupControllerApiGroupDetail created =
            kestraClient().groups().createGroup(MAIN_TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                    .name("test_get_group_" + randomId())
                    .description("An example group"));

        IAMGroupControllerApiGroupDetail fetched =
            kestraClient().groups().group(created.getId(), MAIN_TENANT);

        assertEquals(created.getId(), fetched.getId());
        assertEquals(created.getName(), fetched.getName());
    }

    @Test
    public void listGroupIdsTest() throws ApiException {
        IAMGroupControllerApiGroupDetail created =
            kestraClient().groups().createGroup(MAIN_TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                    .name("test_list_group_ids_" + randomId())
                    .description("An example group"));

        ApiIds ids = new ApiIds().ids(List.of(created.getId()));
        List<ApiGroupSummary> fetched =
            kestraClient().groups().listGroupIds(MAIN_TENANT, ids);

        assertFalse(fetched.isEmpty());
        assertTrue(fetched.stream().anyMatch(g -> created.getId().equals(g.getId())));
    }

    @Test
    public void searchGroupMembersTest() throws ApiException {
        // group + user
        IAMGroupControllerApiGroupDetail group =
            kestraClient().groups().createGroup(MAIN_TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                    .name("test_search_group_members_" + randomId())
                    .description("An example group"));
        IAMUserControllerApiUser user =
            kestraClient().users().createUser(
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                    .email("test_search_group_members_" + randomId() + "@kestra.io"));

        kestraClient().groups().addUserToGroup(group.getId(), user.getId(), MAIN_TENANT);

        PagedResultsIAMGroupControllerApiGroupMember page =
            kestraClient().groups().searchGroupMembers(
                group.getId(), 1, 10, MAIN_TENANT, user.getEmail(), null);

        assertNotNull(page);
        assertNotNull(page.getResults());
        assertTrue(page.getResults().stream().anyMatch(m -> user.getId().equals(m.getId())),
            "Search should return the added user");
    }

    @Test
    public void searchGroupsTest() throws ApiException {
        String name = "test_search_groups_" + randomId();
        IAMGroupControllerApiGroupDetail created =
            kestraClient().groups().createGroup(MAIN_TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                    .name(name)
                    .description("An example group"));

        PagedResultsApiGroupSummary results =
            kestraClient().groups().searchGroups(1, 10, MAIN_TENANT, name, null);

        assertNotNull(results);
        assertNotNull(results.getResults());
        assertTrue(results.getResults().stream().anyMatch(r -> created.getId().equals(r.getId())));
    }

    @Test
    public void setUserMembershipForGroupTest() throws ApiException {
        IAMGroupControllerApiGroupDetail group =
            kestraClient().groups().createGroup(MAIN_TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                    .name("test_set_user_membership_for_group_" + randomId())
                    .description("An example group"));

        IAMUserControllerApiUser user =
            kestraClient().users().createUser(
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                    .email("test_set_user_membership_for_group_" + randomId() + "@kestra.io"));

        kestraClient().groups().addUserToGroup(group.getId(), user.getId(), MAIN_TENANT);

        IAMGroupControllerApiGroupMember member =
            kestraClient().groups().setUserMembershipForGroup(
                group.getId(), user.getId(), GroupIdentifierMembership.OWNER, MAIN_TENANT);

        assertTrue(member.getGroups().stream().anyMatch(g -> group.getId().equals(g.getId())));
        // (Optional) If the model exposes membership per group, assert it's OWNER.
    }

    @Test
    public void updateGroupTest() throws ApiException {
        IAMGroupControllerApiGroupDetail created =
            kestraClient().groups().createGroup(MAIN_TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                    .name("test_update_group_" + randomId())
                    .description("Before"));

        String updatedDesc = "Updated description";
        IAMGroupControllerApiUpdateGroupRequest updateReq =
            new IAMGroupControllerApiUpdateGroupRequest()
                .name(created.getName())
                .description(updatedDesc);

        IAMGroupControllerApiGroupDetail updated =
            kestraClient().groups().updateGroup(created.getId(), MAIN_TENANT, updateReq);

        assertEquals(updatedDesc, updated.getDescription());
    }
}
