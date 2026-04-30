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
}
