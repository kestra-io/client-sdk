package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GroupsApiTest {

    static GroupsApi api() {
        return client().groups();
    }

    static IAMGroupControllerApiGroupDetail createTestGroup(String name) throws ApiException {
        IAMGroupControllerApiCreateGroupRequest request = new IAMGroupControllerApiCreateGroupRequest()
                .name(name)
                .description("Test group: " + name);
        return api().createGroup(TENANT, request);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createGroup_basic() throws ApiException {
        String name = "test-group-" + randomId();
        IAMGroupControllerApiGroupDetail result = createTestGroup(name);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getDescription()).contains(name);
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void group_getById() throws ApiException {
        String name = "test-group-" + randomId();
        IAMGroupControllerApiGroupDetail created = createTestGroup(name);

        IAMGroupControllerApiGroupDetail result = api().group(created.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
        assertThat(result.getName()).isEqualTo(name);
    }

    @Test
    void group_notFound() {
        assertThatThrownBy(() -> api().group("nonexistent-group-id", TENANT))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void updateGroup_changeName() throws ApiException {
        IAMGroupControllerApiGroupDetail created = createTestGroup("before-" + randomId());
        String newName = "after-" + randomId();

        IAMGroupControllerApiUpdateGroupRequest update = new IAMGroupControllerApiUpdateGroupRequest()
                .name(newName)
                .description("Updated description");

        IAMGroupControllerApiGroupDetail updated = api().updateGroup(created.getId(), TENANT, update);

        assertThat(updated.getName()).isEqualTo(newName);
        assertThat(updated.getDescription()).isEqualTo("Updated description");
    }

    @Test
    void deleteGroup_basic() throws ApiException {
        IAMGroupControllerApiGroupDetail created = createTestGroup("to-delete-" + randomId());

        assertThatCode(() -> api().deleteGroup(created.getId(), TENANT))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> api().group(created.getId(), TENANT))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // Search & List
    // ========================================================================

    @Test
    void searchGroups_basic() throws ApiException {
        createTestGroup("searchable-" + randomId());

        PagedResultsApiGroupSummary result = api().searchGroups(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchGroups_withPagination() throws ApiException {
        PagedResultsApiGroupSummary result = api().searchGroups(TENANT, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchGroups_withNameFilter() throws ApiException {
        String name = "name-filter-" + randomId();
        createTestGroup(name);

        PagedResultsApiGroupSummary result = api().searchGroups(TENANT, 1, 10, null, List.of(nameFilter(name)));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
        assertThat(result.getResults())
                .extracting(ApiGroupSummary::getName)
                .contains(name);
    }

    @Test
    void searchGroups_withQueryFilter() throws ApiException {
        String prefix = "qfgrp" + randomId();
        createTestGroup(prefix);

        PagedResultsApiGroupSummary result = api().searchGroups(TENANT, 1, 10, null, List.of(queryFilter(prefix)));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchGroups_withSort() throws ApiException {
        String name1 = "aaa" + randomId();
        String name2 = "zzz" + randomId();
        createTestGroup(name2);
        createTestGroup(name1);

        PagedResultsApiGroupSummary result = api().searchGroups(TENANT, 1, 100, List.of("name:asc"), null);

        assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> names = result.getResults().stream()
                .map(ApiGroupSummary::getName)
                .toList();
        int idx1 = names.indexOf(name1);
        int idx2 = names.indexOf(name2);
        assertThat(idx1).isGreaterThanOrEqualTo(0);
        assertThat(idx2).isGreaterThan(idx1);
    }

    @Test
    @Disabled("Server returns 500 for sort on group members — property mapping not configured")
    void searchGroupMembers_withSort() throws ApiException {
        IAMGroupControllerApiGroupDetail group = createTestGroup("members-sort-" + randomId());
        IAMUserControllerApiUser user1 = createTestUser();
        IAMUserControllerApiUser user2 = createTestUser();
        api().addUserToGroup(group.getId(), user1.getId(), TENANT);
        api().addUserToGroup(group.getId(), user2.getId(), TENANT);

        PagedResultsIAMGroupControllerApiGroupMember result =
                api().searchGroupMembers(group.getId(), TENANT, 1, 10, List.of("username:asc"), null);

        assertThat(result.getResults()).hasSize(2);
    }

    @Test
    void searchGroupMembers_withFilters() throws ApiException {
        IAMGroupControllerApiGroupDetail group = createTestGroup("members-filter-" + randomId());
        IAMUserControllerApiUser user1 = createTestUser();
        IAMUserControllerApiUser user2 = createTestUser();
        api().addUserToGroup(group.getId(), user1.getId(), TENANT);
        api().addUserToGroup(group.getId(), user2.getId(), TENANT);

        PagedResultsIAMGroupControllerApiGroupMember result =
                api().searchGroupMembers(group.getId(), TENANT, 1, 10, null, List.of(queryFilter(user1.getEmail())));

        assertThat(result.getResults()).isNotEmpty();
        assertThat(result.getResults()).allSatisfy(m ->
                assertThat(m.getUsername()).isEqualTo(user1.getEmail()));
    }

    @Test
    void searchGroups_noResults() throws ApiException {
        PagedResultsApiGroupSummary result = api().searchGroups(
                TENANT, 1, 10, null, List.of(nameFilter("nonexistent_group_" + randomId())));

        assertThat(result).isNotNull();
        assertThat(result.getResults() == null || result.getResults().isEmpty() || result.getTotal() == 0).isTrue();
    }

    @Test
    void autocompleteGroups_basic() throws ApiException {
        IAMGroupControllerApiGroupDetail created = createTestGroup("autocomplete-" + randomId());

        ApiAutocomplete request = new ApiAutocomplete().q(created.getName().substring(0, 10));
        List<ApiGroupSummary> result = api().autocompleteGroups(TENANT, request, null);

        assertThat(result).isNotNull().isNotEmpty();
    }

    @Test
    void listGroupIds_basic() throws ApiException {
        IAMGroupControllerApiGroupDetail g1 = createTestGroup("ids-test-" + randomId());

        ApiIds ids = new ApiIds().ids(List.of(g1.getId()));
        List<ApiGroupSummary> result = api().listGroupIds(TENANT, ids);

        assertThat(result).isNotNull().hasSize(1);
    }

    @Test
    void listGroupIds_multiple() throws ApiException {
        IAMGroupControllerApiGroupDetail g1 = createTestGroup("ids1-" + randomId());
        IAMGroupControllerApiGroupDetail g2 = createTestGroup("ids2-" + randomId());

        ApiIds ids = new ApiIds().ids(List.of(g1.getId(), g2.getId()));
        List<ApiGroupSummary> result = api().listGroupIds(TENANT, ids);

        assertThat(result).isNotNull().hasSize(2);
    }

    // ========================================================================
    // Members
    // ========================================================================

    @Test
    void searchGroupMembers_basic() throws ApiException {
        IAMGroupControllerApiGroupDetail group = createTestGroup("members-" + randomId());

        PagedResultsIAMGroupControllerApiGroupMember result =
                api().searchGroupMembers(group.getId(), TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    // ========================================================================
    // Member management
    // ========================================================================

    static UsersApi usersApi() {
        return client().users();
    }

    static IAMUserControllerApiUser createTestUser() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("grp-" + randomId() + "@test.com")
                        .firstName("Group")
                        .lastName("Member")
                        .password("TestPass!1234");
        return usersApi().createUser(request);
    }

    @Test
    void addUserToGroup_basic() throws ApiException {
        IAMGroupControllerApiGroupDetail group = createTestGroup("add-member-" + randomId());
        IAMUserControllerApiUser user = createTestUser();

        IAMGroupControllerApiGroupMember result = api().addUserToGroup(group.getId(), user.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(user.getId());
    }

    @Test
    void deleteUserFromGroup_basic() throws ApiException {
        IAMGroupControllerApiGroupDetail group = createTestGroup("del-member-" + randomId());
        IAMUserControllerApiUser user = createTestUser();

        api().addUserToGroup(group.getId(), user.getId(), TENANT);

        IAMGroupControllerApiGroupMember result = api().deleteUserFromGroup(group.getId(), user.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(user.getId());
    }

    @Test
    void setUserMembershipForGroup_basic() throws ApiException {
        IAMGroupControllerApiGroupDetail group = createTestGroup("membership-" + randomId());
        IAMUserControllerApiUser user = createTestUser();

        api().addUserToGroup(group.getId(), user.getId(), TENANT);

        IAMGroupControllerApiGroupMember result =
                api().setUserMembershipForGroup(group.getId(), user.getId(), GroupIdentifierMembership.OWNER, TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(user.getId());
    }
}
