// testApis/GroupsApi.spec.js
import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup';

describe('GroupsApi', () => {
    it('add_user_to_group: Add a user to a group', async () => {
        // create group
        const group = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_add_user_to_group_${randomId()}`,
            description: 'An example group',
        });

        // create user
        const user = await kestraClient().usersApi.createUser({
            email: `test_add_user_to_group_${randomId()}@kestra.io`,
        });

        // add user to group
        const member = await kestraClient().groupsApi.addUserToGroup(group.id, user.id, MAIN_TENANT);

        expect(member.groups?.some(g => g.id === group.id)).toBeTruthy();
    });

    it('autocomplete_groups: List groups for autocomplete', async () => {
        const prefix = `test_auto_${randomId()}`;
        const created = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `${prefix}_complete_groups`,
            description: 'An example group',
        });

        const results = await kestraClient().groupsApi.autocompleteGroups(MAIN_TENANT, { q: prefix });

        expect(
            results.some(r => r.id === created.id || r.name === created.name)
        ).toBeTruthy();
    });

    it('create_group: Create a group', async () => {
        const name = `test_create_group_${randomId()}`;
        const created = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name,
            description: 'An example group',
        });

        expect(created.name).toBe(name);
        expect(created.id).toBeTruthy();
    });

    it('delete_group: Delete a group', async () => {
        const created = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_delete_group_${randomId()}`,
            description: 'An example group',
        });

        await kestraClient().groupsApi.deleteGroup(created.id, MAIN_TENANT);

        await expect(
            (kestraClient().groupsApi.getGroup?.(created.id, MAIN_TENANT)) ??
            (kestraClient().groupsApi.group?.(created.id, MAIN_TENANT))
        ).rejects.toThrow();
    });

    it('delete_user_from_group: Remove a user from a group', async () => {
        const group = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_delete_user_from_group_${randomId()}`,
            description: 'An example group',
        });

        const user = await kestraClient().usersApi.createUser({
            email: `test_delete_user_from_group_${randomId()}@kestra.io`,
        });

        await kestraClient().groupsApi.addUserToGroup(group.id, user.id, MAIN_TENANT);

        const member = await kestraClient().groupsApi.deleteUserFromGroup(
            group.id, user.id, MAIN_TENANT
        );

        expect(member.groups?.some(g => g.id === group.id)).toBeFalsy();
    });

    it('get_group: Retrieve a group', async () => {
        const created = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_get_group_${randomId()}`,
            description: 'An example group',
        });

        const fetched =
            (await kestraClient().groupsApi.getGroup?.(created.id, MAIN_TENANT)) ??
            (await kestraClient().groupsApi.group?.(created.id, MAIN_TENANT));

        expect(fetched.id).toBe(created.id);
        expect(fetched.name).toBe(created.name);
    });

    it('list_group_ids: List groups by ids', async () => {
        const created = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_list_group_ids_${randomId()}`,
            description: 'An example group',
        });

        const fetched = await kestraClient().groupsApi.listGroupIds(MAIN_TENANT, {
            ids: [created.id],
        });

        expect(Array.isArray(fetched) && fetched.length > 0).toBeTruthy();
        expect(fetched.some(g => g.id === created.id)).toBeTruthy();
    });

    it('search_group_members: Search for users in a group', async () => {
        const group = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_search_group_members_${randomId()}`,
            description: 'An example group',
        });

        const user = await kestraClient().usersApi.createUser({
            email: `test_search_group_members_${randomId()}@kestra.io`,
        });

        await kestraClient().groupsApi.addUserToGroup(group.id, user.id, MAIN_TENANT);

        // signature: (groupId, page, size, tenant, q, sort)
        const page = await kestraClient().groupsApi.searchGroupMembers(
            group.id, 1, 10, MAIN_TENANT, user.email, null
        );

        const results = page?.results ?? [];
        expect(results.some(m => m.id === user.id)).toBeTruthy();
    });

    it('search_groups: Search for groups', async () => {
        const name = `test_search_groups_${randomId()}`;
        const created = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name,
            description: 'An example group',
        });

        const resultsPage = await kestraClient().groupsApi.searchGroups(1, 10, MAIN_TENANT, {q: name});
        const results = resultsPage?.results ?? [];

        expect(results.some(r => r.id === created.id)).toBeTruthy();
    });

    it('set_user_membership_for_group: Update a user membership type', async () => {
        const group = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_set_user_membership_for_group_${randomId()}`,
            description: 'An example group',
        });

        const user = await kestraClient().usersApi.createUser({
            email: `test_set_user_membership_for_group_${randomId()}@kestra.io`,
        });

        await kestraClient().groupsApi.addUserToGroup(group.id, user.id, MAIN_TENANT);

        // Enum may be exported; fallback to string 'OWNER'
        const member = await kestraClient().groupsApi.setUserMembershipForGroup(
            group.id, user.id, 'OWNER', MAIN_TENANT
        );

        expect(member.groups?.some(g => g.id === group.id)).toBeTruthy();
    });

    it('update_group: Update a group', async () => {
        const created = await kestraClient().groupsApi.createGroup(MAIN_TENANT, {
            name: `test_update_group_${randomId()}`,
            description: 'Before',
        });

        const updated = await kestraClient().groupsApi.updateGroup(
            created.id,
            MAIN_TENANT,
            { name: created.name, description: 'Updated description' }
        );

        expect(updated.description).toBe('Updated description');
    });
});
