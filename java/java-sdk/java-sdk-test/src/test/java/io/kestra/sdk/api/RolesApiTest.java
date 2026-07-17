package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RolesApiTest {

    static RolesApi api() {
        return client().roles();
    }

    static IAMRoleControllerApiRoleDetail createTestRole(String name) throws ApiException {
        // Kestra requires a role to have at least one permission.
        IAMRoleControllerApiRoleCreateOrUpdateRequest request = new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(name)
                .description("Test role: " + name)
                .permissions(new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                        .FLOW(List.of("CREATE", "READ")));
        return api().createRole(TENANT, request);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createRole_basic() throws ApiException {
        String name = "test-role-" + randomId();
        IAMRoleControllerApiRoleDetail result = createTestRole(name);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getDescription()).contains(name);
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void role_getById() throws ApiException {
        String name = "test-role-" + randomId();
        IAMRoleControllerApiRoleDetail created = createTestRole(name);

        IAMRoleControllerApiRoleDetail result = api().role(created.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
        assertThat(result.getName()).isEqualTo(name);
    }

    @Test
    void role_notFound() {
        assertThatThrownBy(() -> api().role("nonexistent-role-id", TENANT))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void updateRole_changeName() throws ApiException {
        IAMRoleControllerApiRoleDetail created = createTestRole("before-" + randomId());
        String newName = "after-" + randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequest update = new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(newName)
                .description("Updated description")
                .permissions(new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                        .FLOW(List.of("CREATE", "READ")));

        IAMRoleControllerApiRoleDetail updated = api().updateRole(created.getId(), TENANT, update);

        assertThat(updated.getName()).isEqualTo(newName);
        assertThat(updated.getDescription()).isEqualTo("Updated description");
    }

    @Test
    void deleteRole_basic() throws ApiException {
        IAMRoleControllerApiRoleDetail created = createTestRole("to-delete-" + randomId());

        assertThatCode(() -> api().deleteRole(created.getId(), TENANT))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> api().role(created.getId(), TENANT))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchRoles_basic() throws ApiException {
        createTestRole("searchable-" + randomId());

        PagedResultsApiRoleSummary result = api().searchRoles(TENANT, 1, 10, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchRoles_withPagination() throws ApiException {
        PagedResultsApiRoleSummary result = api().searchRoles(TENANT, 1, 2, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchRoles_withNameQueryFilter() throws ApiException {
        String name = "name-filter-" + randomId();
        IAMRoleControllerApiRoleDetail created = createTestRole(name);

        PagedResultsApiRoleSummary result = api().searchRoles(TENANT, 1, 10, name, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotEmpty();
        assertThat(result.getResults())
                .extracting(ApiRoleSummary::getId)
                .contains(created.getId());
    }

    @Test
    void searchRoles_withQueryFilter() throws ApiException {
        String name = "query-filter-" + randomId();
        createTestRole(name);

        PagedResultsApiRoleSummary result = api().searchRoles(TENANT, 1, 10, name, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotEmpty();
    }

    @Test
    void searchRoles_withSort() throws ApiException {
        String name1 = "aaa" + randomId();
        String name2 = "zzz" + randomId();
        createTestRole(name2);
        createTestRole(name1);

        PagedResultsApiRoleSummary result = api().searchRoles(TENANT, 1, 100, null, List.of("name:asc"), null);

        assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> names = result.getResults().stream()
                .map(ApiRoleSummary::getName)
                .toList();
        int idx1 = names.indexOf(name1);
        int idx2 = names.indexOf(name2);
        assertThat(idx1).isGreaterThanOrEqualTo(0);
        assertThat(idx2).isGreaterThan(idx1);
    }

    @Test
    void searchRoles_noResults() throws ApiException {
        PagedResultsApiRoleSummary result = api().searchRoles(TENANT, 1, 10,
                "nonexistent_role_" + randomId(), null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isEmpty();
    }

    // ========================================================================
    // Autocomplete & List by IDs
    // ========================================================================

    @Test
    void autocompleteRoles_basic() throws ApiException {
        IAMRoleControllerApiRoleDetail created = createTestRole("autocomplete-" + randomId());

        ApiAutocomplete request = new ApiAutocomplete().q(created.getName().substring(0, 10));
        List<ApiRoleSummary> result = api().autocompleteRoles(TENANT, request);

        assertThat(result).isNotNull().isNotEmpty();
    }

    @Test
    void listRolesFromGivenIds_basic() throws ApiException {
        IAMRoleControllerApiRoleDetail r1 = createTestRole("ids-test-" + randomId());

        ApiIds ids = new ApiIds().ids(List.of(r1.getId()));
        List<Role> result = api().listRolesFromGivenIds(TENANT, ids);

        assertThat(result).isNotNull().hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(r1.getId());
    }

    @Test
    void listRolesFromGivenIds_multiple() throws ApiException {
        IAMRoleControllerApiRoleDetail r1 = createTestRole("ids1-" + randomId());
        IAMRoleControllerApiRoleDetail r2 = createTestRole("ids2-" + randomId());

        ApiIds ids = new ApiIds().ids(List.of(r1.getId(), r2.getId()));
        List<Role> result = api().listRolesFromGivenIds(TENANT, ids);

        assertThat(result).isNotNull().hasSize(2);
    }
}
