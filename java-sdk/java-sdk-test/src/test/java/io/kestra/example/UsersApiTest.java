package io.kestra.example;

import io.kestra.sdk.KestraClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UsersApiTest {
    public static String MAIN_TENANT = "main";
    private static final KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:9901")
        .build();

    /**
     * List users for autocomplete
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void autocompleteUsersTest() throws ApiException {

        IAMTenantAccessControllerUserApiAutocomplete iaMTenantAccessControllerUserApiAutocomplete = null;
        List<IAMTenantAccessControllerApiUserTenantAccess> response = kestraClient.users().autocompleteUsers(MAIN_TENANT, new IAMTenantAccessControllerUserApiAutocomplete());

        // TODO: test validations
    }
    /**
     * Create new API Token for a specific user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createApiTokensForUserTest() throws ApiException {
        var tokenId = "test-token";
        CreateApiTokenRequest createApiTokenRequest = new CreateApiTokenRequest().name(tokenId);
        Object response = kestraClient.users().createApiTokensForUser(tokenId, createApiTokenRequest);

        // TODO: test validations
    }
    /**
     * Create new API Token for a specific user
     *
     * Superadmin-only. Create a new API token for a user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createApiTokensForUser1Test() throws ApiException {
        String id = null;
        CreateApiTokenRequest createApiTokenRequest = null;
        CreateApiTokenResponse response =kestraClient.users().createApiTokensForUser1(id, createApiTokenRequest);

        // TODO: test validations
    }
    /**
     * Create new API Token for a specific user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createApiTokensForUserWithTenantTest() throws ApiException {
        String id = null;

        CreateApiTokenRequest createApiTokenRequest = null;
        Object response =kestraClient.users().createApiTokensForUserWithTenant(id, MAIN_TENANT, createApiTokenRequest);

        // TODO: test validations
    }
    /**
     * Create a new user account
     *
     * Superadmin-only. Create a new user account with an optional password based authentication method.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createUserTest() throws ApiException {
        IAMUserControllerApiCreateOrUpdateUserRequest iaMUserControllerApiCreateOrUpdateUserRequest = null;
        kestraClient.users().createUser(iaMUserControllerApiCreateOrUpdateUserRequest);

        // TODO: test validations
    }
    /**
     * Delete an API Token for specific user and token id
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteApiTokenTest() throws ApiException {
        String id = null;
        String tokenId = null;
        Object response =kestraClient.users().deleteApiToken(id, tokenId);

        // TODO: test validations
    }
    /**
     * Delete an API Token for specific user and token id
     *
     * Superadmin-only. Delete an API token for a user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteApiToken1Test() throws ApiException {
        String id = null;
        String tokenId = null;
        kestraClient.users().deleteApiToken1(id, tokenId);

        // TODO: test validations
    }
    /**
     * Delete an API Token for specific user and token id
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteApiTokenWithTenantTest() throws ApiException {
        String id = null;
        String tokenId = null;

        Object response =kestraClient.users().deleteApiTokenWithTenant(id, tokenId, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Delete a user refresh token
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteRefreshTokenTest() throws ApiException {
        String id = null;
        kestraClient.users().deleteRefreshToken(id);

        // TODO: test validations
    }
    /**
     * Delete a user
     *
     * Superadmin-only. Delete a user including all its access.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteUserTest() throws ApiException {
        String id = null;
        kestraClient.users().deleteUser(id);

        // TODO: test validations
    }
    /**
     * Update user password
     *
     * Superadmin-only. Updates whether a user is a superadmin.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteUserAuthMethodTest() throws ApiException {
        String id = null;
        String auth = null;
        IAMUserControllerApiUser response =kestraClient.users().deleteUserAuthMethod(id, auth);

        // TODO: test validations
    }
    /**
     * Get a user
     *
     * Superadmin-only. Get user account details.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getUserTest() throws ApiException {
        String id = null;
        IAMUserControllerApiUser response =kestraClient.users().getUser(id);

        // TODO: test validations
    }
    /**
     * Impersonate a user
     *
     * Superadmin-only. Allows an admin to impersonate another user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void impersonateTest() throws ApiException {
        String id = null;
        Object response =kestraClient.users().impersonate(id);

        // TODO: test validations
    }
    /**
     * List API tokens for a specific user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listApiTokensTest() throws ApiException {
        String id = null;
        Object response =kestraClient.users().listApiTokens(id);

        // TODO: test validations
    }
    /**
     * List API tokens for a specific user
     *
     * Superadmin-only. Get all API token existing for a user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listApiTokens1Test() throws ApiException {
        String id = null;
        Object response =kestraClient.users().listApiTokens1(id);

        // TODO: test validations
    }
    /**
     * List API tokens for a specific user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listApiTokensWithTenantTest() throws ApiException {
        String id = null;

        Object response =kestraClient.users().listApiTokensWithTenant(id, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Retrieve users
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listUsersTest() throws ApiException {
        Integer page = 1;
        Integer size = 50;
        String q = null;
        List<String> sort = null;
        PagedResultsIAMUserControllerApiUserSummary response =kestraClient.users().listUsers(page, size, q, sort);

        // TODO: test validations
    }
    /**
     * Update user details
     *
     * Superadmin-only. Updates the the details of a user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchUserTest() throws ApiException {
        String id = null;
        MeControllerApiUserDetailsRequest meControllerApiUserDetailsRequest = null;
        IAMUserControllerApiUser response =kestraClient.users().patchUser(id, meControllerApiUserDetailsRequest);

        // TODO: test validations
    }
    /**
     * Update user demo
     *
     * Superadmin-only. Updates whether a user is for demo.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchUserDemoTest() throws ApiException {
        String id = null;
        IAMUserControllerApiPatchRestrictedRequest iaMUserControllerApiPatchRestrictedRequest = null;
        kestraClient.users().patchUserDemo(id, iaMUserControllerApiPatchRestrictedRequest);

        // TODO: test validations
    }
    /**
     * Update user password
     *
     * Superadmin-only. Updates whether a user is a superadmin.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchUserPasswordTest() throws ApiException {
        String id = null;
        IAMUserControllerApiPatchUserPasswordRequest iaMUserControllerApiPatchUserPasswordRequest = null;
        Object response =kestraClient.users().patchUserPassword(id, iaMUserControllerApiPatchUserPasswordRequest);

        // TODO: test validations
    }
    /**
     * Update user superadmin privileges
     *
     * Superadmin-only. Updates whether a user is a superadmin.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchUserSuperAdminTest() throws ApiException {
        String id = null;
        ApiPatchSuperAdminRequest apiPatchSuperAdminRequest = null;
        kestraClient.users().patchUserSuperAdmin(id, apiPatchSuperAdminRequest);

        // TODO: test validations
    }
    /**
     * Update authenticated user password
     *
     * Changes the login password for the authenticated user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateCurrentUserPasswordTest() throws ApiException {
        MeControllerApiUpdatePasswordRequest meControllerApiUpdatePasswordRequest = null;
        Object response =kestraClient.users().updateCurrentUserPassword(meControllerApiUpdatePasswordRequest);

        // TODO: test validations
    }
    /**
     * Update a user account
     *
     * Superadmin-only. Update an existing user account with an optional password based authentication method.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateUserTest() throws ApiException {
        String id = null;
        IAMUserControllerApiCreateOrUpdateUserRequest iaMUserControllerApiCreateOrUpdateUserRequest = null;
        IAMUserControllerApiUser response =kestraClient.users().updateUser(id, iaMUserControllerApiCreateOrUpdateUserRequest);

        // TODO: test validations
    }
    /**
     * Update the list of groups a user belongs to for the given MAIN_TENANT
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateUserGroupsTest() throws ApiException {
        String id = null;

        IAMUserGroupControllerApiUpdateUserGroupsRequest iaMUserGroupControllerApiUpdateUserGroupsRequest = null;
        kestraClient.users().updateUserGroups(id, MAIN_TENANT, iaMUserGroupControllerApiUpdateUserGroupsRequest);

        // TODO: test validations
    }
}
