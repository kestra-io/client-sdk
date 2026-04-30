package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceAccountApiTest {

    static ServiceAccountApi api() {
        return client().serviceAccount();
    }

    // ========================================================================
    // CRUD (Superadmin-scoped)
    // ========================================================================

    @Test
    void createServiceAccount_basic() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest request =
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-" + randomId())
                        .description("Test service account");

        IAMServiceAccountControllerApiServiceAccountDetail result = api().createServiceAccount(request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void serviceAccount_getById() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest request =
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-get-" + randomId())
                        .description("Test get");

        IAMServiceAccountControllerApiServiceAccountDetail created = api().createServiceAccount(request);

        IAMServiceAccountControllerApiServiceAccountDetail result = api().serviceAccount(created.getId());

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
    }

    @Test
    void patchServiceAccountDetails_basic() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest request =
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-patch-" + randomId())
                        .description("Before");

        IAMServiceAccountControllerApiServiceAccountDetail created = api().createServiceAccount(request);

        IAMServiceAccountControllerApiPatchServiceAccountRequest patchRequest =
                new IAMServiceAccountControllerApiPatchServiceAccountRequest()
                        .name(request.getName())
                        .description("After");

        IAMServiceAccountControllerApiServiceAccountDetail result =
                api().patchServiceAccountDetails(created.getId(), patchRequest);

        assertThat(result).isNotNull();
        assertThat(result.getDescription()).isEqualTo("After");
    }

    @Test
    void deleteServiceAccount_basic() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest request =
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-del-" + randomId())
                        .description("To delete");

        IAMServiceAccountControllerApiServiceAccountDetail created = api().createServiceAccount(request);

        assertThatCode(() -> api().deleteServiceAccount(created.getId()))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Listing
    // ========================================================================

    @Test
    void listServiceAccounts_basic() throws ApiException {
        PagedResultsIAMServiceAccountControllerApiServiceAccountDetail result =
                api().listServiceAccounts(1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void listServiceAccounts_withPagination() throws ApiException {
        PagedResultsIAMServiceAccountControllerApiServiceAccountDetail result =
                api().listServiceAccounts(1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    // ========================================================================
    // Tenant-scoped
    // ========================================================================

    @Test
    void createServiceAccountForTenant_basic() throws ApiException {
        IAMServiceAccountControllerApiServiceAccountRequest request =
                new IAMServiceAccountControllerApiServiceAccountRequest()
                        .name("sa-tenant-" + randomId())
                        .description("Tenant-scoped SA");

        IAMServiceAccountControllerApiServiceAccountResponse result =
                api().createServiceAccountForTenant(TENANT, request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void serviceAccountForTenant_getById() throws ApiException {
        IAMServiceAccountControllerApiServiceAccountRequest request =
                new IAMServiceAccountControllerApiServiceAccountRequest()
                        .name("sa-tenant-get-" + randomId())
                        .description("Tenant get");

        IAMServiceAccountControllerApiServiceAccountResponse created =
                api().createServiceAccountForTenant(TENANT, request);

        IAMServiceAccountControllerApiServiceAccountResponse result =
                api().serviceAccountForTenant(created.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
    }

    @Test
    void updateServiceAccount_basic() throws ApiException {
        IAMServiceAccountControllerApiServiceAccountRequest request =
                new IAMServiceAccountControllerApiServiceAccountRequest()
                        .name("sa-update-" + randomId())
                        .description("Before");

        IAMServiceAccountControllerApiServiceAccountResponse created =
                api().createServiceAccountForTenant(TENANT, request);

        IAMServiceAccountControllerApiServiceAccountRequest updateRequest =
                new IAMServiceAccountControllerApiServiceAccountRequest()
                        .name(request.getName())
                        .description("After");

        IAMServiceAccountControllerApiServiceAccountResponse result =
                api().updateServiceAccount(created.getId(), TENANT, updateRequest);

        assertThat(result).isNotNull();
        assertThat(result.getDescription()).isEqualTo("After");
    }

    @Test
    void deleteServiceAccountForTenant_basic() throws ApiException {
        IAMServiceAccountControllerApiServiceAccountRequest request =
                new IAMServiceAccountControllerApiServiceAccountRequest()
                        .name("sa-tenant-del-" + randomId())
                        .description("To delete");

        IAMServiceAccountControllerApiServiceAccountResponse created =
                api().createServiceAccountForTenant(TENANT, request);

        assertThatCode(() -> api().deleteServiceAccountForTenant(created.getId(), TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // API tokens (tenant-scoped)
    // ========================================================================

    @Test
    void apiTokens_tenantScoped() throws ApiException {
        IAMServiceAccountControllerApiServiceAccountRequest saRequest =
                new IAMServiceAccountControllerApiServiceAccountRequest()
                        .name("sa-token-" + randomId())
                        .description("Token test");

        IAMServiceAccountControllerApiServiceAccountResponse sa =
                api().createServiceAccountForTenant(TENANT, saRequest);

        CreateApiTokenRequest tokenRequest = new CreateApiTokenRequest()
                .name("test-token-" + randomId());

        Object tokenResp = api().createApiTokensForServiceAccountWithTenant(sa.getId(), TENANT, tokenRequest);
        assertThat(tokenResp).isNotNull();

        Object tokens = api().listApiTokensForServiceAccountWithTenant(sa.getId(), TENANT);
        assertThat(tokens).isNotNull();
    }

    // ========================================================================
    // Delete API token (tenant-scoped)
    // ========================================================================

    @Test
    void deleteApiTokenForServiceAccountWithTenant_basic() throws ApiException {
        IAMServiceAccountControllerApiServiceAccountRequest saRequest =
                new IAMServiceAccountControllerApiServiceAccountRequest()
                        .name("sa-del-token-" + randomId())
                        .description("Delete token test");

        IAMServiceAccountControllerApiServiceAccountResponse sa =
                api().createServiceAccountForTenant(TENANT, saRequest);

        CreateApiTokenRequest tokenRequest = new CreateApiTokenRequest()
                .name("token-to-delete-" + randomId());

        @SuppressWarnings("unchecked")
        java.util.Map<String, Object> tokenResp =
                (java.util.Map<String, Object>) api().createApiTokensForServiceAccountWithTenant(sa.getId(), TENANT, tokenRequest);
        assertThat(tokenResp).isNotNull();
        String tokenId = (String) tokenResp.get("id");
        assertThat(tokenId).isNotBlank();

        assertThatCode(() -> api().deleteApiTokenForServiceAccountWithTenant(sa.getId(), tokenId, TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // API tokens (Superadmin-scoped)
    // ========================================================================

    @Test
    void createApiTokensForServiceAccount_superadmin() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest saRequest =
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-sa-token-" + randomId())
                        .description("Superadmin token test");

        IAMServiceAccountControllerApiServiceAccountDetail sa = api().createServiceAccount(saRequest);

        CreateApiTokenRequest tokenRequest = new CreateApiTokenRequest()
                .name("sa-token-" + randomId());

        Object tokenResp = api().createApiTokensForServiceAccount(sa.getId(), tokenRequest);
        assertThat(tokenResp).isNotNull();
    }

    @Test
    void listApiTokensForServiceAccount_superadmin() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest saRequest =
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-sa-list-" + randomId())
                        .description("Superadmin list token test");

        IAMServiceAccountControllerApiServiceAccountDetail sa = api().createServiceAccount(saRequest);

        CreateApiTokenRequest tokenRequest = new CreateApiTokenRequest()
                .name("sa-list-token-" + randomId());

        api().createApiTokensForServiceAccount(sa.getId(), tokenRequest);

        Object tokens = api().listApiTokensForServiceAccount(sa.getId());
        assertThat(tokens).isNotNull();
    }

    @Test
    void deleteApiTokenForServiceAccount_superadmin() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest saRequest =
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-sa-del-" + randomId())
                        .description("Superadmin delete token test");

        IAMServiceAccountControllerApiServiceAccountDetail sa = api().createServiceAccount(saRequest);

        CreateApiTokenRequest tokenRequest = new CreateApiTokenRequest()
                .name("sa-del-token-" + randomId());

        @SuppressWarnings("unchecked")
        java.util.Map<String, Object> tokenResp =
                (java.util.Map<String, Object>) api().createApiTokensForServiceAccount(sa.getId(), tokenRequest);
        assertThat(tokenResp).isNotNull();
        String tokenId = (String) tokenResp.get("id");
        assertThat(tokenId).isNotBlank();

        assertThatCode(() -> api().deleteApiTokenForServiceAccount(sa.getId(), tokenId))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Patch superadmin
    // ========================================================================

    @Test
    void patchServiceAccountSuperAdmin_basic() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest saRequest =
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-superadmin-" + randomId())
                        .description("Superadmin patch test");

        IAMServiceAccountControllerApiServiceAccountDetail sa = api().createServiceAccount(saRequest);

        ApiPatchSuperAdminRequest patchRequest = new ApiPatchSuperAdminRequest()
                .superAdmin(true);

        assertThatCode(() -> api().patchServiceAccountSuperAdmin(sa.getId(), patchRequest))
                .doesNotThrowAnyException();

        // Reset back to non-superadmin
        ApiPatchSuperAdminRequest resetRequest = new ApiPatchSuperAdminRequest()
                .superAdmin(false);
        assertThatCode(() -> api().patchServiceAccountSuperAdmin(sa.getId(), resetRequest))
                .doesNotThrowAnyException();
    }
}
