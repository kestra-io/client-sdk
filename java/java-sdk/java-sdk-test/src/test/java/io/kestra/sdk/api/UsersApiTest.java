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
}
