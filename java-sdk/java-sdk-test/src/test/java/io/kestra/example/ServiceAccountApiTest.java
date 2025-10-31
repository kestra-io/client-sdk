package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.MAIN_TENANT;
import static io.kestra.example.CommonTestSetup.kestraClient;
import static io.kestra.example.CommonTestSetup.randomId;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceAccountApiTest {

    @Test
    public void createServiceAccountTest() throws ApiException {
        String name = "test-create-service-account-" + randomId();

        IAMServiceAccountControllerApiCreateServiceAccountRequest req =
            new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                .name(name)
                .description("service account created by tests");

        IAMServiceAccountControllerApiServiceAccountDetail created =
            kestraClient().serviceAccount().createServiceAccount(req);

        assertNotNull(created.getId());
    }

    @Test
    public void createServiceAccountForTenantTest() throws ApiException {
        String fullName = "test-create-service-account-for-tenant-" + randomId();
        String name = fullName.substring(0, 62);

        IAMServiceAccountControllerApiServiceAccountRequest req =
            new IAMServiceAccountControllerApiServiceAccountRequest()
                .name(name)
                .description("service account for tenant");

        IAMServiceAccountControllerApiServiceAccountResponse created =
            kestraClient().serviceAccount().createServiceAccountForTenant(MAIN_TENANT, req);

        assertNotNull(created.getId());
    }

    @Test
    public void deleteServiceAccountTest() throws ApiException {
        String name = "test-delete-service-account-" + randomId();

        IAMServiceAccountControllerApiServiceAccountDetail created =
            kestraClient().serviceAccount().createServiceAccount(
                new IAMServiceAccountControllerApiCreateServiceAccountRequest().name(name));

        kestraClient().serviceAccount().deleteServiceAccount(created.getId());

        assertThrows(ApiException.class,
            () -> kestraClient().serviceAccount().getServiceAccount(created.getId()));
    }

    @Test
    public void deleteServiceAccountForTenantTest() throws ApiException {
        String fullName = "test-delete-service-account-for-tenant-" + randomId();
        String name = fullName.substring(0, 62);

        IAMServiceAccountControllerApiServiceAccountResponse created =
            kestraClient().serviceAccount().createServiceAccountForTenant(
                MAIN_TENANT,
                new IAMServiceAccountControllerApiServiceAccountRequest().name(name)
            );

        kestraClient().serviceAccount().deleteServiceAccountForTenant(created.getId(), MAIN_TENANT);
        assertThrows(ApiException.class,
            () -> kestraClient().serviceAccount().getServiceAccountForTenant(created.getId(), MAIN_TENANT));
    }

    @Test
    public void getServiceAccountTest() throws ApiException {
        String name = "test-get-service-account-" + randomId();

        IAMServiceAccountControllerApiServiceAccountDetail created =
            kestraClient().serviceAccount().createServiceAccount(
                new IAMServiceAccountControllerApiCreateServiceAccountRequest().name(name));

        IAMServiceAccountControllerApiServiceAccountDetail fetched =
            kestraClient().serviceAccount().getServiceAccount(created.getId());

        assertEquals(created.getId(), fetched.getId());
    }

    @Test
    public void getServiceAccountForTenantTest() throws ApiException {
        String fullName = "test-get-service-account-for-tenant-" + randomId();
        String name = fullName.substring(0, 62);

        IAMServiceAccountControllerApiServiceAccountResponse created =
            kestraClient().serviceAccount().createServiceAccountForTenant(
                MAIN_TENANT,
                new IAMServiceAccountControllerApiServiceAccountRequest().name(name));

        IAMServiceAccountControllerApiServiceAccountResponse fetched =
            kestraClient().serviceAccount().getServiceAccountForTenant(created.getId(), MAIN_TENANT);

        assertEquals(created.getId(), fetched.getId());
    }

    @Test
    public void listServiceAccountsTest() throws ApiException {
        String name = "test-list-service-accounts-" + randomId();

        IAMServiceAccountControllerApiServiceAccountDetail created =
            kestraClient().serviceAccount().createServiceAccount(
                new IAMServiceAccountControllerApiCreateServiceAccountRequest().name(name));

        PagedResultsIAMServiceAccountControllerApiServiceAccountDetail page =
            kestraClient().serviceAccount().listServiceAccounts(1, 50, null, null);

        assertNotNull(page);
        assertNotNull(page.getResults());
        assertTrue(page.getResults().stream().anyMatch(sa -> created.getId().equals(sa.getId())));
    }

    @Test
    public void patchServiceAccountDetailsTest() throws ApiException {
        String fullName = "test-patch-service-account-details-" + randomId();
        String name = fullName.substring(0, 62);

        IAMServiceAccountControllerApiServiceAccountDetail created =
            kestraClient().serviceAccount().createServiceAccount(
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                    .name(name).description("old"));

        IAMServiceAccountControllerApiPatchServiceAccountRequest patchReq =
            new IAMServiceAccountControllerApiPatchServiceAccountRequest()
                .name(name).description("new");

        IAMServiceAccountControllerApiServiceAccountDetail patched =
            kestraClient().serviceAccount().patchServiceAccountDetails(created.getId(), patchReq);

        String desc = patched.getDescription();
        assertEquals("new", desc);
    }

    @Test
    public void patchServiceAccountSuperAdminTest() throws ApiException {
        String fullName = "test-patch-service-account-super-admin-" + randomId();
        String name = fullName.substring(0, 62);

        IAMServiceAccountControllerApiServiceAccountDetail created =
            kestraClient().serviceAccount().createServiceAccount(
                new IAMServiceAccountControllerApiCreateServiceAccountRequest().name(name));

        ApiPatchSuperAdminRequest patch = new ApiPatchSuperAdminRequest().superAdmin(true);
        kestraClient().serviceAccount().patchServiceAccountSuperAdmin(created.getId(), patch);

        IAMServiceAccountControllerApiServiceAccountDetail fetched =
            kestraClient().serviceAccount().getServiceAccount(created.getId());

        assertTrue(Boolean.TRUE.equals(fetched.getSuperAdmin()));
    }

    @Test
    public void updateServiceAccountTest() throws ApiException {
        String name = "test-update-service-account-" + randomId();

        IAMServiceAccountControllerApiServiceAccountDetail created =
            kestraClient().serviceAccount().createServiceAccount(
                new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                    .name(name).description("Before"));

        IAMServiceAccountControllerApiServiceAccountRequest updateReq =
            new IAMServiceAccountControllerApiServiceAccountRequest()
                .name(created.getName()).description("After");

        IAMServiceAccountControllerApiServiceAccountResponse updated =
            kestraClient().serviceAccount().updateServiceAccount(created.getId(), MAIN_TENANT, updateReq);

        String desc = updated.getDescription();
        assertEquals("After", desc);
    }
}
