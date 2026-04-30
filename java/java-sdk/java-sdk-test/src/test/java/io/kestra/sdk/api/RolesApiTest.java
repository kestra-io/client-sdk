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
        IAMRoleControllerApiRoleCreateOrUpdateRequest request = new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(name)
                .description("Test role: " + name)
                .permissions(new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions());
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
                .permissions(new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions());

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

        PagedResultsApiRoleSummary result = api().searchRoles(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchRoles_withPagination() throws ApiException {
        PagedResultsApiRoleSummary result = api().searchRoles(TENANT, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
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
