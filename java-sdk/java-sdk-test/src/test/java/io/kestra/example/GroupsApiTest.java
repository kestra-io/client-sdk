package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.ApiAutocomplete;
import io.kestra.sdk.model.ApiGroupSummary;
import io.kestra.sdk.model.ApiIds;
import io.kestra.sdk.model.GroupIdentifierMembership;
import io.kestra.sdk.model.IAMGroupControllerApiCreateGroupRequest;
import io.kestra.sdk.model.IAMGroupControllerApiGroupDetail;
import io.kestra.sdk.model.IAMGroupControllerApiGroupMember;
import io.kestra.sdk.model.IAMGroupControllerApiUpdateGroupRequest;
import io.kestra.sdk.model.PagedResultsApiGroupSummary;
import io.kestra.sdk.model.PagedResultsIAMGroupControllerApiGroupMember;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.kestraClient;

public class GroupsApiTest {

    /**
     * Add a user to a group
     *
     * Adds the specified user to the given group. If the user does not already have access to the tenant, tenant access will be created automatically.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addUserToGroupTest() throws ApiException {
        String id = null;
        String userId = null;
        String tenant = null;
        IAMGroupControllerApiGroupMember response = kestraClient().groups().addUserToGroup(id, userId, tenant);

        // TODO: test validations
    }
    /**
     * List groups for autocomplete
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void autocompleteGroupsTest() throws ApiException {
        String tenant = null;
        ApiAutocomplete apiAutocomplete = null;
        List<ApiGroupSummary> response = kestraClient().groups().autocompleteGroups(tenant, apiAutocomplete);

        // TODO: test validations
    }
    /**
     * Create a group
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createGroupTest() throws ApiException {
        String tenant = null;
        IAMGroupControllerApiCreateGroupRequest iaMGroupControllerApiCreateGroupRequest = null;
        IAMGroupControllerApiGroupDetail response = kestraClient().groups().createGroup(tenant, iaMGroupControllerApiCreateGroupRequest);

        // TODO: test validations
    }
    /**
     * Delete a group
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteGroupTest() throws ApiException {
        String id = null;
        String tenant = null;
        kestraClient().groups().deleteGroup(id, tenant);

        // TODO: test validations
    }
    /**
     * Remove a user from a group
     *
     * Removes the specified user from the given group. If the user has no other group bindings within the tenant, their access to the tenant will also be revoked.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteUserFromGroupTest() throws ApiException {
        String id = null;
        String userId = null;
        String tenant = null;
        IAMGroupControllerApiGroupMember response = kestraClient().groups().deleteUserFromGroup(id, userId, tenant);

        // TODO: test validations
    }
    /**
     * Retrieve a group
     *
     * Retrieves details of a specific group by its ID within the current tenant.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getGroupTest() throws ApiException {
        String id = null;
        String tenant = null;
        IAMGroupControllerApiGroupDetail response = kestraClient().groups().getGroup(id, tenant);

        // TODO: test validations
    }
    /**
     * List groups by ids
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listGroupIdsTest() throws ApiException {
        String tenant = null;
        ApiIds apiIds = null;
        List<ApiGroupSummary> response = kestraClient().groups().listGroupIds(tenant, apiIds);

        // TODO: test validations
    }
    /**
     * Search for users in a group
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchGroupMembersTest() throws ApiException {
        String id = null;
        Integer page = null;
        Integer size = null;
        String tenant = null;
        String q = null;
        List<String> sort = null;
        PagedResultsIAMGroupControllerApiGroupMember response = kestraClient().groups().searchGroupMembers(id, page, size, tenant, q, sort);

        // TODO: test validations
    }
    /**
     * Search for groups
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchGroupsTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        String tenant = null;
        String q = null;
        List<String> sort = null;
        PagedResultsApiGroupSummary response = kestraClient().groups().searchGroups(page, size, tenant, q, sort);

        // TODO: test validations
    }
    /**
     * Update a user&#39;s membership type in a group
     *
     * Allows a group owner or an authorized user to change the role of a user within a group to OWNER or MEMBER.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void setUserMembershipForGroupTest() throws ApiException {
        String id = null;
        String userId = null;
        GroupIdentifierMembership membership = null;
        String tenant = null;
        IAMGroupControllerApiGroupMember response = kestraClient().groups().setUserMembershipForGroup(id, userId, membership, tenant);

        // TODO: test validations
    }
    /**
     * Update a group
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateGroupTest() throws ApiException {
        String id = null;
        String tenant = null;
        IAMGroupControllerApiUpdateGroupRequest iaMGroupControllerApiUpdateGroupRequest = null;
        IAMGroupControllerApiGroupDetail response = kestraClient().groups().updateGroup(id, tenant, iaMGroupControllerApiUpdateGroupRequest);

        // TODO: test validations
    }
}
