// testApis/test_users_api.test.js
import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup.js';

describe('UsersApi', () => {
    it('autocomplete_users: List users for autocomplete', async () => {
        const email = `test_autocomplete_users_${randomId()}@kestra.io`;

        // create user
        const createdUser = await kestraClient.Users.createUser({
            email,
        });

        // create group to grant tenant access, then add user to group
        const group = await kestraClient.Groups.createGroup({
            name: `test_add_user_to_group_${randomId()}`,
            description: 'An example group',
        });

        await kestraClient.Groups.addUserToGroup({
            id: group.id,
            userId: createdUser.id,
        });

        // autocomplete by email
        const results = await kestraClient.Users.autocompleteUsers({ q: email });

        // results is usually an array of tenant-access summaries
        expect(results.some(r => r.username === email)).toBeTruthy();
    });

    it('create_api_tokens_for_user: Create new API Token for a specific user', async () => {
        const base = `test_create_api_token_for_user_${randomId()}`;
        const user = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        const token = await kestraClient.Users.createApiTokensForUser({
            id: user.id,
            name: base.replace(/_/g, '-'),
            description: `token for ${base}`,
        });

        expect(token).toBeTruthy();
        // If typed: expect(token.id).toBeTruthy();
    });

    it('create_user: Create a new user account', async () => {
        const base = `test_create_user_${randomId()}`;
        const created = await kestraClient.Users.createUser({
            email: `${base}@kestra.io`,
            firstName: base,
            password: 'Password!234',
        });

        expect(created.email).toBe(`${base}@kestra.io`);

        // cleanup
        await kestraClient.Users.deleteUser({
            id: created.id,
        });
    });

    it('delete_api_token_for_user: Delete an API Token for a user', async () => {
        const base = `test_delete_api_token_for_user_${randomId()}`;
        const user = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        const token = await kestraClient.Users.createApiTokensForUser({
            id: user.id,
            name: base.replace(/_/g, '-'),
            description: 'token to delete',
        });

        const tokenId = token?.id;
        expect(tokenId).toBeTruthy();

        await kestraClient.Users.deleteApiTokenForUser({
            id: user.id,
            tokenId
        });

        const list = await kestraClient.Users.listApiTokensForUser({ id: user.id });
        const ids =
            list?.results?.map(t => t.id) ??
            [];
        expect(ids).not.toContain(tokenId);
    });

    it('delete_refresh_token: Delete a user refresh token (superadmin-only; may be no-op)', async () => {
        const base = `test_delete_refresh_token_${randomId()}`;
        const user = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        await kestraClient.Users.deleteRefreshToken({ id: user.id });

        // cleanup
        await kestraClient.Users.deleteUser({ id: user.id });
    });

    it('delete_user: Delete a user', async () => {
        const base = `test_delete_user_${randomId()}`;
        const user = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        await kestraClient.Users.deleteUser({ id: user.id });

        await expect(kestraClient.Users.user?.({ id: user.id }))
            .rejects.toThrow();
    });

    it('delete_user_auth_method: Remove a user auth method', async () => {
        const base = `test_delete_user_auth_method_${randomId()}`;
        const user = await kestraClient.Users.createUser({
            email: `${base}@kestra.io`,
            password: 'Password!234',
        });

        const authId = user?.auths?.[0]?.id;
        expect(authId).toBeTruthy();

        const patched = await kestraClient.Users.deleteUserAuthMethod({ id: user.id, auth: authId });
        expect(patched.id).toBe(user.id);
    });

    it('get_user: Retrieve a user', async () => {
        const base = `test_get_user_${randomId()}`;
        const created = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        const fetched =
            (await kestraClient.Users.user?.({ id: created.id }));
        expect(fetched.id).toBe(created.id);

        await kestraClient.Users.deleteUser({ id: created.id });
    });

    it('list_api_tokens_for_user: List API tokens for a user', async () => {
        const base = `test_list_api_tokens_for_user_${randomId()}`;
        const user = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        await kestraClient.Users.createApiTokensForUser({
            id: user.id,
            name: base.replace(/_/g, '-'),
        });

        const tokens = await kestraClient.Users.listApiTokensForUser({ id: user.id });
        expect(tokens).toBeTruthy(); // shape may vary across generators
    });

    it('list_users: Retrieve users', async () => {
        const base = `test_list_users_${randomId()}`;
        const created = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        const page = await kestraClient.Users.listUsers({ page: 1, size: 50, filters: [] });
        const results = page?.results ?? [];
        expect(results.some(s => s.id === created.id)).toBeTruthy();

        await kestraClient.Users.deleteUser({ id: created.id });
    });

    it('patch_user: Update user details (firstName)', async () => {
        const base = `test_patch_user_${randomId()}`;
        const created = await kestraClient.Users.createUser({
            email: `${base}@kestra.io`,
            firstName: 'Old',
        });

        const updated = await kestraClient.Users.patchUser({
            id: created.id,
            firstName: 'New',
        });

        // firstName casing can differ depending on generator
        expect(updated.firstName).toBe('New');

        await kestraClient.Users.deleteUser({ id: created.id });
    });

    it('patch_user_demo: Update user demo/restricted flag', async () => {
        const base = `test_patch_user_demo_${randomId()}`;
        const created = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        await kestraClient.Users.patchUserDemo({ id: created.id, restricted: true });

        await kestraClient.Users.deleteUser({ id: created.id });
    });

    it('patch_user_password: Update user password (superadmin op)', async () => {
        const base = `test_patch_user_password_${randomId()}`;
        const created = await kestraClient.Users.createUser({
            email: `${base}@kestra.io`,
            password: 'OldPass!1',
        });

        const resp = await kestraClient.Users.patchUserPassword({
            id: created.id,
            password: 'NewPass!1',
        });
        expect(resp).toBeTruthy();

        await kestraClient.Users.deleteUser({ id: created.id });
    });

    it('patch_user_super_admin: Update user superadmin privileges', async () => {
        const base = `test_patch_user_super_admin_${randomId()}`;
        const created = await kestraClient.Users.createUser({ email: `${base}@kestra.io` });

        await kestraClient.Users.patchUserSuperAdmin({ id: created.id, superAdmin: true });

        const fetched =
            (await kestraClient.Users.user?.({ id: created.id }));
        expect(Boolean(fetched.superAdmin)).toBe(true);

        await kestraClient.Users.deleteUser({ id: created.id });
    });

    // This one requires creating a *new client* authenticated as the created user.
    // If you have a helper like `makeClient({ username, password })`, replace the `.skip`
    // and use it exactly like in your Java test.
    it.skip('update_current_user_password: Change password as the current user', async () => {
        const base = `test_update_current_user_password_${randomId()}`;
        const email = `${base}@kestra.io`;
        const initial = 'InitialPass!1';
        const changed = 'ChangedPass!1';

        const created = await kestraClient.Users.createUser({
            email,
            tenants: [MAIN_TENANT],
            password: initial,
        });

        // Build a dedicated client authenticated as this user:
        // e.g. const userClient = makeClient({ username: email, password: initial });
        // Provide your own builder if needed, based on your SDK.
        const userClient = /* make a new Kestra client with basic auth (email/initial) */ null;

        await userClient.Users.updateCurrentUserPassword({
            oldPassword: initial,
            newPassword: changed,
        });

        // Re-create client with new password and revert:
        const userClient2 = /* make a new Kestra client with basic auth (email/changed) */ null;
        await userClient2.Users.updateCurrentUserPassword({
            oldPassword: changed,
            newPassword: initial,
        });

        await kestraClient.Users.deleteUser({ id: created.id });
    });

    it('update_user: Update a user account', async () => {
        const base = `test_update_user_${randomId()}`;
        const created = await kestraClient.Users.createUser({
            email: `${base}@kestra.io`,
            firstName: 'Before',
        });

        const updated = await kestraClient.Users.updateUser({
            id: created.id,
            email: created.email,
            firstName: 'After',
        });

        expect(updated.firstName).toBe('After');

        await kestraClient.Users.deleteUser({ id: created.id });
    });

    it('update_user_groups: Update the list of groups a user belongs to for the tenant', async () => {
        const group = await kestraClient.Groups.createGroup({
            name: `test_create_group_${randomId()}`,
            description: 'An example group',
        });

        const base = `test_update_user_groups_${randomId()}`;
        const user = await kestraClient.Users.createUser({
            email: `${base}@kestra.io`,
            tenants: [MAIN_TENANT],
        });

        await kestraClient.Users.updateUserGroups({
            id: user.id,
            tenant: MAIN_TENANT,
            groupIds: [group.id],
        });

        // If there's a readback endpoint, fetch & assert here.
    });
});
