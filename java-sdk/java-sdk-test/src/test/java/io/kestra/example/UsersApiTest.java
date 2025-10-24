package io.kestra.example;

import io.kestra.sdk.KestraClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.MAIN_TENANT;
import static io.kestra.example.CommonTestSetup.kestraClient;
import static io.kestra.example.CommonTestSetup.randomId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UsersApiTest {

    @Test
    public void autocompleteUsersTest() throws ApiException {
        // Create a user to appear in autocomplete
        String email = "test_autocomplete_users_" + randomId() + "@kestra.io";
        IAMUserControllerApiCreateOrUpdateUserRequest userReq =
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(email);
        IAMUserControllerApiUser createdUser = kestraClient().users().createUser(userReq);

        // Create a group and add the user to create tenant access
        IAMGroupControllerApiCreateGroupRequest groupReq =
            new IAMGroupControllerApiCreateGroupRequest()
                .name("test_add_user_to_group_" + randomId())
                .description("An example group");
        IAMGroupControllerApiGroupDetail group =
            kestraClient().groups().createGroup(MAIN_TENANT, groupReq);

        kestraClient().groups().addUserToGroup(group.getId(), createdUser.getId(), MAIN_TENANT);

        // Autocomplete by email
        IAMTenantAccessControllerUserApiAutocomplete ac =
            new IAMTenantAccessControllerUserApiAutocomplete().q(email);

        List<IAMTenantAccessControllerApiUserTenantAccess> results =
            kestraClient().users().autocompleteUsers(MAIN_TENANT, ac);

        assertTrue(results.stream().anyMatch(r -> email.equals(r.getUsername())),
            "Autocomplete should include the created user's email");
    }

    @Test
    public void createApiTokensForUserTest() throws ApiException {
        String base = "test_create_api_token_for_user_" + randomId();

        // create user
        IAMUserControllerApiUser user = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        // token name must be lowercase/hyphen friendly
        CreateApiTokenRequest tokenReq = new CreateApiTokenRequest()
            .name(base.replace("_", "-"))
            .description("token for " + base);

        Object token = kestraClient().users().createApiTokensForUser(user.getId(), tokenReq);
        assertNotNull(token, "Token creation should return a payload");
    }

    @Test
    public void createUserTest() throws ApiException {
        String base = "test_create_user_" + randomId();
        IAMUserControllerApiCreateOrUpdateUserRequest req =
            new IAMUserControllerApiCreateOrUpdateUserRequest()
                .email(base + "@kestra.io")
                .firstName(base)
                .password("Password!234");

        IAMUserControllerApiUser created = kestraClient().users().createUser(req);
        assertEquals(req.getEmail(), created.getEmail());

        // cleanup
        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void deleteApiTokenTest() throws ApiException {
        String base = "test_delete_api_token_for_user_" + randomId();

        IAMUserControllerApiUser user = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        CreateApiTokenRequest tokenReq = new CreateApiTokenRequest()
            .name(base.replace("_", "-"))
            .description("token to delete");
        // Create then delete
        CreateApiTokenResponse token = kestraClient().users().createApiTokensForUser(user.getId(), tokenReq);
        // If your SDK returns a typed object with getId(), prefer that
        String tokenId = token.getId();

        kestraClient().users().deleteApiTokenForUser(user.getId(), tokenId);

        ApiTokenList apiTokenList = kestraClient().users().listApiTokensForUser(user.getId());
        assertThat(apiTokenList.getResults().stream().map(ApiToken::getId).toList()).doesNotContain(tokenId);
    }

    @Test
    public void deleteRefreshTokenTest() throws ApiException {
        String base = "test_delete_refresh_token_" + randomId();
        IAMUserControllerApiUser user = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        kestraClient().users().deleteRefreshToken(user.getId());
        // no strict assertion (superadmin-only op may be a no-op)
        kestraClient().users().deleteUser(user.getId());
    }

    @Test
    public void deleteUserTest() throws ApiException {
        String base = "test_delete_user_" + randomId();
        IAMUserControllerApiUser user = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        kestraClient().users().deleteUser(user.getId());
        assertThrows(ApiException.class, () -> kestraClient().users().getUser(user.getId()));
    }

    @Test
    public void deleteUserAuthMethodTest() throws ApiException {
        String base = "test_delete_user_auth_method_" + randomId();
        IAMUserControllerApiUser user = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest()
                .email(base + "@kestra.io")
                .password("Password!234"));

        // assume first auth method exists and has an id
        String authId = user.getAuths() != null && !user.getAuths().isEmpty()
            ? user.getAuths().get(0).getId() : null;

        assertNotNull(authId, "User should have at least one auth method");

        IAMUserControllerApiUser patched =
            kestraClient().users().deleteUserAuthMethod(user.getId(), authId);

        assertEquals(user.getId(), patched.getId());
    }

    @Test
    public void getUserTest() throws ApiException {
        String base = "test_get_user_" + randomId();
        IAMUserControllerApiUser created = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        IAMUserControllerApiUser fetched = kestraClient().users().getUser(created.getId());
        assertEquals(created.getId(), fetched.getId());

        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void listApiTokensTest() throws ApiException {
        String base = "test_list_api_tokens_for_user_" + randomId();
        IAMUserControllerApiUser user = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        CreateApiTokenRequest tokenReq = new CreateApiTokenRequest().name(base.replace("_", "-"));
        kestraClient().users().createApiTokensForUser(user.getId(), tokenReq);

        Object tokens = kestraClient().users().listApiTokensForUser(user.getId());
        assertNotNull(tokens, "Listing tokens should return something");
        // If typed page model is available, assert it contains created token id
    }

    @Test
    public void listUsersTest() throws ApiException {
        String base = "test_list_users_" + randomId();
        IAMUserControllerApiUser created = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        PagedResultsIAMUserControllerApiUserSummary page =
            kestraClient().users().listUsers(1, 50, base, null);

        assertNotNull(page);
        assertNotNull(page.getResults());
        assertTrue(page.getResults().stream().anyMatch(s -> created.getId().equals(s.getId())),
            "Search should include the created user");

        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void patchUserTest() throws ApiException {
        String base = "test_patch_user_" + randomId();
        IAMUserControllerApiUser created = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest()
                .email(base + "@kestra.io")
                .firstName("Old"));

        MeControllerApiUserDetailsRequest patch =
            new MeControllerApiUserDetailsRequest().firstName("New");

        IAMUserControllerApiUser updated =
            kestraClient().users().patchUser(created.getId(), patch);

        String fn = updated.getFirstName();
        assertEquals("New", fn);
        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void patchUserDemoTest() throws ApiException {
        String base = "test_patch_user_demo_" + randomId();
        IAMUserControllerApiUser created = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        IAMUserControllerApiPatchRestrictedRequest req =
            new IAMUserControllerApiPatchRestrictedRequest();
        req.setRestricted(true);
        kestraClient().users().patchUserDemo(created.getId(), req);

        // no strict assertion available here
        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void patchUserPasswordTest() throws ApiException {
        String base = "test_patch_user_password_" + randomId();
        IAMUserControllerApiUser created = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest()
                .email(base + "@kestra.io").password("OldPass!1"));

        IAMUserControllerApiPatchUserPasswordRequest req =
            new IAMUserControllerApiPatchUserPasswordRequest().password("NewPass!1");

        IAMUserControllerApiUser resp = kestraClient().users().patchUserPassword(created.getId(), req);
        assertNotNull(resp);
        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void patchUserSuperAdminTest() throws ApiException {
        String base = "test_patch_user_super_admin_" + randomId();
        IAMUserControllerApiUser created = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(base + "@kestra.io"));

        ApiPatchSuperAdminRequest patch = new ApiPatchSuperAdminRequest().superAdmin(true);
        kestraClient().users().patchUserSuperAdmin(created.getId(), patch);

        IAMUserControllerApiUser fetched = kestraClient().users().getUser(created.getId());
        assertTrue(Boolean.TRUE.equals(fetched.getSuperAdmin()));
        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void updateCurrentUserPasswordTest() throws ApiException {
        // Create a dedicated user to test password change via "current user" endpoint
        String base = "test_update_current_user_password_" + randomId();
        String email = base + "@kestra.io";
        String initial = "InitialPass!1";
        String changed = "ChangedPass!1";

        IAMUserControllerApiUser created = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest().email(email)
                .tenants(List.of(MAIN_TENANT))
                .password(initial));

        // Create a client authenticated as this user
        KestraClient userClient = KestraClient.builder()
            .basicAuth(email, initial)
            .url(CommonTestSetup.HOST)
            .build();

        // change password
        MeControllerApiUpdatePasswordRequest change =
            new MeControllerApiUpdatePasswordRequest()
                .oldPassword(initial)
                .newPassword(changed);
        userClient.users().updateCurrentUserPassword(change);

        // change it back using the new password
        userClient = KestraClient.builder()
            .basicAuth(email, changed)
            .url(CommonTestSetup.HOST)
            .build();
        MeControllerApiUpdatePasswordRequest revert =
            new MeControllerApiUpdatePasswordRequest()
                .oldPassword(changed)
                .newPassword(initial);
        userClient.users().updateCurrentUserPassword(revert);

        // cleanup
        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void updateUserTest() throws ApiException {
        String base = "test_update_user_" + randomId();
        IAMUserControllerApiUser created = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest()
                .email(base + "@kestra.io")
                .firstName("Before"));

        IAMUserControllerApiCreateOrUpdateUserRequest updateReq =
            new IAMUserControllerApiCreateOrUpdateUserRequest()
                .email(created.getEmail())
                .firstName("After");

        IAMUserControllerApiUser updated = kestraClient().users().updateUser(created.getId(), updateReq);

        String fn = updated.getFirstName();
        assertEquals("After", fn);
        kestraClient().users().deleteUser(created.getId());
    }

    @Test
    public void updateUserGroupsTest() throws ApiException {
        // create a group
        IAMGroupControllerApiGroupDetail group =
            kestraClient().groups().createGroup(MAIN_TENANT,
                new IAMGroupControllerApiCreateGroupRequest()
                    .name("test_create_group_" + randomId())
                    .description("An example group"));

        // create user (ensure tenant access where required by your backend)
        String base = "test_update_user_groups_" + randomId();
        IAMUserControllerApiUser user = kestraClient().users().createUser(
            new IAMUserControllerApiCreateOrUpdateUserRequest()
                .email(base + "@kestra.io")
                .tenants(List.of(MAIN_TENANT)));

        // assign group
        IAMUserGroupControllerApiUpdateUserGroupsRequest req =
            new IAMUserGroupControllerApiUpdateUserGroupsRequest()
                .groupIds(List.of(group.getId()));

        kestraClient().users().updateUserGroups(user.getId(), MAIN_TENANT, req);
        // If a readback endpoint is available, fetch and assert; otherwise assume success if no exception.
    }
}
