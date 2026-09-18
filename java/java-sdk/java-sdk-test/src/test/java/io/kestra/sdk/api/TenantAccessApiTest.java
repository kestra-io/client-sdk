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

    static GroupsApi groupsApi() {
        return client().groups();
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

        assertThatCode(() -> api().createTenantAccess(TENANT, request))
                .doesNotThrowAnyException();
    }

    @Test
    void deleteTenantAccess_basic() throws ApiException {
        IAMUserControllerApiUser user = createTestUser();

        api().createTenantAccess(TENANT,
                new IAMTenantAccessControllerApiCreateTenantAccessRequest().email(user.getEmail()));

        assertThatCode(() -> api().deleteTenantAccess(user.getId(), TENANT))
                .doesNotThrowAnyException();
    }

    @Test
    void createTenantAccessById_grantsAccess() throws ApiException {
        IAMUserControllerApiUser user = createTestUser();

        api().createTenantAccessById(user.getId(), TENANT);

        IAMTenantAccessControllerApiTenantAccess access = api().tenantAccess(user.getId(), TENANT);
        assertThat(access).isNotNull();
        assertThat(access.getUserId()).isEqualTo(user.getId());
        assertThat(access.getTenantId()).isEqualTo(TENANT);
    }

    @Test
    void tenantAccess_unknownUser() throws ApiException {
        assertThatThrownBy(() -> api().tenantAccess(randomId(), TENANT))
                .isInstanceOf(ApiException.class)
                .extracting(e -> ((ApiException) e).getCode())
                .isEqualTo(404);
    }

    /**
     * Pins the reason this API exists: since Kestra 2.0 a group add resolves the user
     * through a {@code hasTenantAccess} filter, so it fails for a user created without
     * tenant access and succeeds once the access is granted.
     */
    @Test
    void createTenantAccessById_isPrerequisiteForGroupMembership() throws ApiException {
        IAMUserControllerApiUser user = createTestUser();
        IAMGroupControllerApiGroupDetail group = groupsApi().createGroup(TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                        .name("ta-group-" + randomId())
                        .description("tenant-access prerequisite test"));

        assertThatThrownBy(() -> groupsApi().addUserToGroup(group.getId(), user.getId(), TENANT))
                .isInstanceOf(ApiException.class)
                .extracting(e -> ((ApiException) e).getCode())
                .isEqualTo(404);

        api().createTenantAccessById(user.getId(), TENANT);

        assertThatCode(() -> groupsApi().addUserToGroup(group.getId(), user.getId(), TENANT))
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
