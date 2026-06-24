package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TenantAccessApiTest {

    static TenantAccessApi api() {
        return client().tenantAccess();
    }

    static UsersApi usersApi() {
        return client().users();
    }

    static IAMUserControllerApiUser createTestUser() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest req =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("ta-" + randomId() + "@test.com")
                        .firstName("TenantAccess")
                        .lastName("User")
                        .password("TestPass!1234");
        return usersApi().createUser(req);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createTenantAccess_basic() throws ApiException {
        IAMUserControllerApiUser user = createTestUser();

        IAMTenantAccessControllerApiCreateTenantAccessRequest request =
                new IAMTenantAccessControllerApiCreateTenantAccessRequest()
                        .email(user.getEmail());

        IAMTenantAccessControllerApiUserTenantAccess result = api().createTenantAccess(TENANT, request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
        assertThat(result.getUsername()).isEqualTo(user.getEmail());
    }

    @Test
    void deleteTenantAccess_basic() throws ApiException {
        IAMUserControllerApiUser user = createTestUser();

        api().createTenantAccess(TENANT,
                new IAMTenantAccessControllerApiCreateTenantAccessRequest().email(user.getEmail()));

        assertThatCode(() -> api().deleteTenantAccess(user.getId(), TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // List
    // ========================================================================

    @Test
    void listTenantAccess_basic() throws ApiException {
        PagedResultsIAMTenantAccessControllerApiUserTenantAccess result =
                api().listTenantAccess(TENANT, 1, 10);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void listTenantAccess_withPagination() throws ApiException {
        PagedResultsIAMTenantAccessControllerApiUserTenantAccess result =
                api().listTenantAccess(TENANT, 1, 2);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }
}
