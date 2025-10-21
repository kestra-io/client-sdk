package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.*;

public class ServiceAccountApiTest {


    /**
     * Create a service account
     *
     * Superadmin-only. CReate service account with access to multiple tenants.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createServiceAccountTest() throws ApiException {
        IAMServiceAccountControllerApiCreateServiceAccountRequest iaMServiceAccountControllerApiCreateServiceAccountRequest = null;
        IAMServiceAccountControllerApiServiceAccountDetail response = kestraClient().serviceAccount().createServiceAccount(iaMServiceAccountControllerApiCreateServiceAccountRequest);

        // TODO: test validations
    }
    /**
     * Create a service account for the given tenant
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createServiceAccountForTenantTest() throws ApiException {

        IAMServiceAccountControllerApiServiceAccountRequest iaMServiceAccountControllerApiServiceAccountRequest = null;
        IAMServiceAccountControllerApiServiceAccountResponse response = kestraClient().serviceAccount().createServiceAccountForTenant(MAIN_TENANT, iaMServiceAccountControllerApiServiceAccountRequest);

        // TODO: test validations
    }
    /**
     * Delete a service account
     *
     * Superadmin-only. Delete a service account including all its access.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteServiceAccountTest() throws ApiException {
        String id = randomId();
        kestraClient().serviceAccount().deleteServiceAccount(id);

        // TODO: test validations
    }
    /**
     * Delete a service account
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteServiceAccountForTenantTest() throws ApiException {
        String id = randomId();

        kestraClient().serviceAccount().deleteServiceAccountForTenant(id, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Get a service account
     *
     * Superadmin-only. Get user account details.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getServiceAccountTest() throws ApiException {
        String id = randomId();
        IAMServiceAccountControllerApiServiceAccountDetail response = kestraClient().serviceAccount().getServiceAccount(id);

        // TODO: test validations
    }
    /**
     * Retrieve a service account
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getServiceAccountForTenantTest() throws ApiException {
        String id = randomId();

        IAMServiceAccountControllerApiServiceAccountResponse response = kestraClient().serviceAccount().getServiceAccountForTenant(id, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * List service accounts. Superadmin-only.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listServiceAccountsTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        String q = null;
        List<String> sort = null;
        PagedResultsIAMServiceAccountControllerApiServiceAccountDetail response = kestraClient().serviceAccount().listServiceAccounts(page, size, q, sort);

        // TODO: test validations
    }
    /**
     * Update service account details
     *
     * Superadmin-only. Updates the details of a service account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchServiceAccountDetailsTest() throws ApiException {
        String id = randomId();
        IAMServiceAccountControllerApiPatchServiceAccountRequest iaMServiceAccountControllerApiPatchServiceAccountRequest = null;
        IAMServiceAccountControllerApiServiceAccountDetail response = kestraClient().serviceAccount().patchServiceAccountDetails(id, iaMServiceAccountControllerApiPatchServiceAccountRequest);

        // TODO: test validations
    }
    /**
     * Update service account superadmin privileges
     *
     * Superadmin-only. Updates whether a service account is a superadmin.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchServiceAccountSuperAdminTest() throws ApiException {
        String id = randomId();
        ApiPatchSuperAdminRequest apiPatchSuperAdminRequest = null;
        kestraClient().serviceAccount().patchServiceAccountSuperAdmin(id, apiPatchSuperAdminRequest);

        // TODO: test validations
    }
    /**
     * Update a user service account
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateServiceAccountTest() throws ApiException {
        String id = randomId();

        IAMServiceAccountControllerApiServiceAccountRequest iaMServiceAccountControllerApiServiceAccountRequest = null;
        IAMServiceAccountControllerApiServiceAccountResponse response = kestraClient().serviceAccount().updateServiceAccount(id, MAIN_TENANT, iaMServiceAccountControllerApiServiceAccountRequest);

        // TODO: test validations
    }
}
