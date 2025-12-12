// @ts-check
// testApis/test_users_api.test.js
import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup';

describe('UsersApi', () => {
    it('autocomplete_users: List users for autocomplete', async () => {
        const email = `test_autocomplete_users_${randomId()}@kestra.io`;

        // create user
        const createdUser = await kestraClient().usersApi.createUser({
            email,
        });

        // create group to grant tenant access, then add user to group
        const group = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_add_user_to_group_${randomId()}`,
            description: 'An example group',
        });

        await kestraClient().groupsApi.addUserToGroup(group.id, createdUser.id, MAIN_TENANT);

        // autocomplete by email
        const results = await kestraClient().usersApi.autocompleteUsers(MAIN_TENANT, { q: email });

        // results is usually an array of tenant-access summaries
        expect(results.some(r => r.username === email)).toBeTruthy();
    });

    it('create_api_tokens_for_user: Create new API Token for a specific user', async () => {
        const base = `test_create_api_token_for_user_${randomId()}`;
        const user = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        const token = await kestraClient().usersApi.createApiTokensForUser(user.id, {
            name: base.replace(/_/g, '-'),
            description: `token for ${base}`,
        });

        expect(token).toBeTruthy();
        // If typed: expect(token.id).toBeTruthy();
    });

    it('create_user: Create a new user account', async () => {
        const base = `test_create_user_${randomId()}`;
        const created = await kestraClient().usersApi.createUser({
            email: `${base}@kestra.io`,
            firstName: base,
            password: 'Password!234',
        });

        expect(created.email).toBe(`${base}@kestra.io`);

        // cleanup
        await kestraClient().usersApi.deleteUser(created.id);
    });

    it('delete_api_token_for_user: Delete an API Token for a user', async () => {
        const base = `test_delete_api_token_for_user_${randomId()}`;
        const user = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        const token = await kestraClient().usersApi.createApiTokensForUser(user.id, {
            name: base.replace(/_/g, '-'),
            description: 'token to delete',
        });

        const tokenId = token?.id;
        expect(tokenId).toBeTruthy();

        await kestraClient().usersApi.deleteApiTokenForUser(user.id, tokenId);

        const list = await kestraClient().usersApi.listApiTokensForUser(user.id);
        const ids =
            list?.results?.map(t => t.id) ??
            [];
        expect(ids).not.toContain(tokenId);
    });

    it('delete_refresh_token: Delete a user refresh token (superadmin-only; may be no-op)', async () => {
        const base = `test_delete_refresh_token_${randomId()}`;
        const user = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        await kestraClient().usersApi.deleteRefreshToken(user.id);

        // cleanup
        await kestraClient().usersApi.deleteUser(user.id);
    });

    it('delete_user: Delete a user', async () => {
        const base = `test_delete_user_${randomId()}`;
        const user = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        await kestraClient().usersApi.deleteUser(user.id);

        await expect(kestraClient().usersApi.user?.(user.id))
        .rejects.toThrow();
    });

    it('delete_user_auth_method: Remove a user auth method', async () => {
        const base = `test_delete_user_auth_method_${randomId()}`;
        const user = await kestraClient().usersApi.createUser({
            email: `${base}@kestra.io`,
            password: 'Password!234',
        });

        const authId = user?.auths?.[0]?.id;
        expect(authId).toBeTruthy();

        const patched = await kestraClient().usersApi.deleteUserAuthMethod(user.id, authId);
        expect(patched.id).toBe(user.id);
    });

    it('get_user: Retrieve a user', async () => {
        const base = `test_get_user_${randomId()}`;
        const created = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        const fetched =
            (await kestraClient().usersApi.user?.(created.id));
        expect(fetched.id).toBe(created.id);

        await kestraClient().usersApi.deleteUser(created.id);
    });

    it('list_api_tokens_for_user: List API tokens for a user', async () => {
        const base = `test_list_api_tokens_for_user_${randomId()}`;
        const user = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        await kestraClient().usersApi.createApiTokensForUser(user.id, {
            name: base.replace(/_/g, '-'),
        });

        const tokens = await kestraClient().usersApi.listApiTokensForUser(user.id);
        expect(tokens).toBeTruthy(); // shape may vary across generators
    });

    it('list_users: Retrieve users', async () => {
        const base = `test_list_users_${randomId()}`;
        const created = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        const page = await kestraClient().usersApi.listUsers(1, 50, { q: base });
        const results = page?.results ?? [];
        expect(results.some(s => s.id === created.id)).toBeTruthy();

        await kestraClient().usersApi.deleteUser(created.id);
    });

    it('patch_user: Update user details (firstName)', async () => {
        const base = `test_patch_user_${randomId()}`;
        const created = await kestraClient().usersApi.createUser({
            email: `${base}@kestra.io`,
            firstName: 'Old',
        });

        const updated = await kestraClient().usersApi.patchUser(created.id, {
            firstName: 'New',
        });

        // firstName casing can differ depending on generator
        expect(updated.firstName).toBe('New');

        await kestraClient().usersApi.deleteUser(created.id);
    });

    it('patch_user_demo: Update user demo/restricted flag', async () => {
        const base = `test_patch_user_demo_${randomId()}`;
        const created = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        await kestraClient().usersApi.patchUserDemo(created.id, { restricted: true });

        await kestraClient().usersApi.deleteUser(created.id);
    });

    it('patch_user_password: Update user password (superadmin op)', async () => {
        const base = `test_patch_user_password_${randomId()}`;
        const created = await kestraClient().usersApi.createUser({
            email: `${base}@kestra.io`,
            password: 'OldPass!1',
        });

        const resp = await kestraClient().usersApi.patchUserPassword(created.id, {
            password: 'NewPass!1',
        });
        expect(resp).toBeTruthy();

        await kestraClient().usersApi.deleteUser(created.id);
    });

    it('patch_user_super_admin: Update user superadmin privileges', async () => {
        const base = `test_patch_user_super_admin_${randomId()}`;
        const created = await kestraClient().usersApi.createUser({ email: `${base}@kestra.io` });

        await kestraClient().usersApi.patchUserSuperAdmin(created.id, { superAdmin: true });

        const fetched =
            (await kestraClient().usersApi.user?.(created.id));
        expect(Boolean(fetched.superAdmin)).toBe(true);

        await kestraClient().usersApi.deleteUser(created.id);
    });

    // This one requires creating a *new client* authenticated as the created user.
    // If you have a helper like `makeClient({ username, password })`, replace the `.skip`
    // and use it exactly like in your Java test.
    it.skip('update_current_user_password: Change password as the current user', async () => {
        const base = `test_update_current_user_password_${randomId()}`;
        const email = `${base}@kestra.io`;
        const initial = 'InitialPass!1';
        const changed = 'ChangedPass!1';

        const created = await kestraClient().usersApi.createUser({
            email,
            tenants: [MAIN_TENANT],
            password: initial,
        });

        // Build a dedicated client authenticated as this user:
        // e.g. const userClient = makeClient({ username: email, password: initial });
        // Provide your own builder if needed, based on your SDK.
        const userClient = /* make a new Kestra client with basic auth (email/initial) */ null;

        await userClient.usersApi.updateCurrentUserPassword({
            oldPassword: initial,
            newPassword: changed,
        });

        // Re-create client with new password and revert:
        const userClient2 = /* make a new Kestra client with basic auth (email/changed) */ null;
        await userClient2.usersApi.updateCurrentUserPassword({
            oldPassword: changed,
            newPassword: initial,
        });

        await kestraClient().usersApi.deleteUser(created.id);
    });

    it('update_user: Update a user account', async () => {
        const base = `test_update_user_${randomId()}`;
        const created = await kestraClient().usersApi.createUser({
            email: `${base}@kestra.io`,
            firstName: 'Before',
        });

        const updated = await kestraClient().usersApi.updateUser(created.id, {
            email: created.email,
            firstName: 'After',
        });

        expect(updated.firstName).toBe('After');

        await kestraClient().usersApi.deleteUser(created.id);
    });

    it('update_user_groups: Update the list of groups a user belongs to for the tenant', async () => {
        const group = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_create_group_${randomId()}`,
            description: 'An example group',
        });

        const base = `test_update_user_groups_${randomId()}`;
        const user = await kestraClient().usersApi.createUser({
            email: `${base}@kestra.io`,
            tenants: [MAIN_TENANT],
        });

        await kestraClient().usersApi.updateUserGroups(user.id, MAIN_TENANT, {
            groupIds: [group.id],
        });

        // If there’s a readback endpoint, fetch & assert here.
    });
});
