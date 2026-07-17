package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BindingsApiTest {

    static BindingsApi api() {
        return client().bindings();
    }

    static RolesApi rolesApi() {
        return client().roles();
    }

    static UsersApi usersApi() {
        return client().users();
    }

    static IAMRoleControllerApiRoleDetail createTestRole() throws ApiException {
        // Kestra requires a role to have at least one permission.
        IAMRoleControllerApiRoleCreateOrUpdateRequest req = new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name("binding-role-" + randomId())
                .description("Role for binding tests")
                .permissions(new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                        .FLOW(List.of("CREATE", "READ")));
        return rolesApi().createRole(TENANT, req);
    }

    static IAMUserControllerApiUser createTestUser() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest req =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("binding-" + randomId() + "@test.com")
                        .firstName("Binding")
                        .lastName("User")
                        .password("TestPass!1234");
        return usersApi().createUser(req);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createBinding_userBinding() throws ApiException {
        IAMRoleControllerApiRoleDetail role = createTestRole();
        IAMUserControllerApiUser user = createTestUser();

        IAMBindingControllerApiCreateBindingRequest request = new IAMBindingControllerApiCreateBindingRequest()
                .type(BindingType.USER)
                .externalId(user.getId())
                .roleId(role.getId());

        IAMBindingControllerApiBindingDetail result = api().createBinding(TENANT, request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
        assertThat(result.getType()).isEqualTo(BindingType.USER);
    }

    @Test
    void deleteBinding_basic() throws ApiException {
        IAMRoleControllerApiRoleDetail role = createTestRole();
        IAMUserControllerApiUser user = createTestUser();

        IAMBindingControllerApiCreateBindingRequest request = new IAMBindingControllerApiCreateBindingRequest()
                .type(BindingType.USER)
                .externalId(user.getId())
                .roleId(role.getId());

        IAMBindingControllerApiBindingDetail created = api().createBinding(TENANT, request);

        assertThatCode(() -> api().deleteBinding(created.getId(), TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchBindings_basic() throws ApiException {
        IAMRoleControllerApiRoleDetail role = createTestRole();
        IAMUserControllerApiUser user = createTestUser();
        api().createBinding(TENANT, new IAMBindingControllerApiCreateBindingRequest()
                .type(BindingType.USER)
                .externalId(user.getId())
                .roleId(role.getId()));

        PagedResultsIAMBindingControllerApiBindingDetail result =
                api().searchBindings(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchBindings_withPagination() throws ApiException {
        PagedResultsIAMBindingControllerApiBindingDetail result =
                api().searchBindings(TENANT, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchBindings_withSort() throws ApiException {
        PagedResultsIAMBindingControllerApiBindingDetail result =
                api().searchBindings(TENANT, 1, 10, List.of("type:asc"), null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }
}
