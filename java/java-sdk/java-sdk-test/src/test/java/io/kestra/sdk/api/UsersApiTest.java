package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersApiTest {

    static UsersApi api() {
        return client().users();
    }

    // ========================================================================
    // CRUD (Superadmin-scoped)
    // ========================================================================

    @Test
    void createUser_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("test-" + randomId() + "@test.com")
                        .firstName("Test")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser result = api().createUser(request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void user_getById() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("get-" + randomId() + "@test.com")
                        .firstName("Get")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser created = api().createUser(request);

        IAMUserControllerApiUser result = api().user(created.getId());

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
    }

    @Test
    void updateUser_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("update-" + randomId() + "@test.com")
                        .firstName("Before")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser created = api().createUser(request);

        IAMUserControllerApiCreateOrUpdateUserRequest updateRequest =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email(created.getEmail())
                        .firstName("After")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser updated = api().updateUser(created.getId(), updateRequest);

        assertThat(updated.getFirstName()).isEqualTo("After");
    }

    @Test
    void deleteUser_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("delete-" + randomId() + "@test.com")
                        .firstName("Delete")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser created = api().createUser(request);

        assertThatCode(() -> api().deleteUser(created.getId()))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void listUsers_basic() throws ApiException {
        PagedResultsIAMUserControllerApiUserSummary result = api().listUsers(1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void listUsers_withPagination() throws ApiException {
        PagedResultsIAMUserControllerApiUserSummary result = api().listUsers(1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    // ========================================================================
    // API tokens
    // ========================================================================

    @Test
    void apiTokens_createListDelete() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("token-" + randomId() + "@test.com")
                        .firstName("Token")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser created = api().createUser(request);

        CreateApiTokenRequest tokenRequest = new CreateApiTokenRequest()
                .name("test-token-" + randomId());

        CreateApiTokenResponse tokenResp = api().createApiTokensForUser(created.getId(), tokenRequest);
        assertThat(tokenResp).isNotNull();

        ApiTokenList tokens = api().listApiTokensForUser(created.getId());
        assertThat(tokens).isNotNull();
    }

    // ========================================================================
    // Patch operations
    // ========================================================================

    @Test
    void patchUser_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("patch-" + randomId() + "@test.com")
                        .firstName("Patch")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser created = api().createUser(request);

        MeControllerApiUserDetailsRequest patchRequest =
                new MeControllerApiUserDetailsRequest()
                        .firstName("Patched");

        IAMUserControllerApiUser result = api().patchUser(created.getId(), patchRequest);
        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo("Patched");
    }

    // ========================================================================
    // Autocomplete (tenant-scoped)
    // ========================================================================

    @Test
    void autocompleteUsers_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("auto-" + randomId() + "@test.com")
                        .firstName("Auto")
                        .lastName("Complete")
                        .password("TestPass!1234");

        api().createUser(request);

        IAMTenantAccessControllerUserApiAutocomplete autocomplete =
                new IAMTenantAccessControllerUserApiAutocomplete().q("auto");

        List<IAMTenantAccessControllerApiUserTenantAccess> result =
                api().autocompleteUsers(TENANT, autocomplete);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // User groups (tenant-scoped)
    // ========================================================================

    @Test
    void updateUserGroups_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest userRequest =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("groups-" + randomId() + "@test.com")
                        .firstName("Groups")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser user = api().createUser(userRequest);

        GroupsApi groupsApi = client().groups();
        IAMGroupControllerApiCreateGroupRequest groupRequest =
                new IAMGroupControllerApiCreateGroupRequest()
                        .name("user-grp-" + randomId())
                        .description("Test group for user");
        IAMGroupControllerApiGroupDetail group = groupsApi.createGroup(TENANT, groupRequest);

        IAMUserGroupControllerApiUpdateUserGroupsRequest updateRequest =
                new IAMUserGroupControllerApiUpdateUserGroupsRequest()
                        .groupIds(List.of(group.getId()));

        assertThatThrownBy(() -> api().updateUserGroups(user.getId(), TENANT, updateRequest))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // Delete API token
    // ========================================================================

    @Test
    void deleteApiTokenForUser_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("del-token-" + randomId() + "@test.com")
                        .firstName("DelToken")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser created = api().createUser(request);

        CreateApiTokenRequest tokenRequest = new CreateApiTokenRequest()
                .name("token-to-delete-" + randomId());

        CreateApiTokenResponse tokenResp = api().createApiTokensForUser(created.getId(), tokenRequest);
        assertThat(tokenResp).isNotNull();
        assertThat(tokenResp.getId()).isNotBlank();

        assertThatCode(() -> api().deleteApiTokenForUser(created.getId(), tokenResp.getId()))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Impersonation
    // ========================================================================

    @Test
    void impersonate_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("impersonate-" + randomId() + "@test.com")
                        .firstName("Impersonate")
                        .lastName("User")
                        .password("TestPass!1234");

        IAMUserControllerApiUser created = api().createUser(request);

        Object result = api().impersonate(created.getId());

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Patch superadmin
    // ========================================================================

    @Test
    void patchUserSuperAdmin_basic() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest request =
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("superadmin-" + randomId() + "@test.com")
                        .firstName("Super")
                        .lastName("Admin")
                        .password("TestPass!1234");

        IAMUserControllerApiUser created = api().createUser(request);

        ApiPatchSuperAdminRequest patchRequest = new ApiPatchSuperAdminRequest()
                .superAdmin(true);

        assertThatCode(() -> api().patchUserSuperAdmin(created.getId(), patchRequest))
                .doesNotThrowAnyException();

        // Reset back to non-superadmin
        ApiPatchSuperAdminRequest resetRequest = new ApiPatchSuperAdminRequest()
                .superAdmin(false);
        assertThatCode(() -> api().patchUserSuperAdmin(created.getId(), resetRequest))
                .doesNotThrowAnyException();
    }
}
