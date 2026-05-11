// testApis/GroupsApi.spec.ts
import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
import type { QueryFilter, QueryFilterField, QueryFilterOp } from '@kestra-io/kestra-sdk';

const qf = (query: Omit<QueryFilter, 'value'> & { value?: any }) => query as QueryFilter;
const QF_FIELD: Record<string, QueryFilterField> = {
    QUERY: 'QUERY',
    USERNAME: 'USERNAME',
};
const QF_OP: Record<string, QueryFilterOp> = {
    EQUALS: 'EQUALS',
};

describe('GroupsApi', () => {
    it('add_user_to_group: Add a user to a group', async () => {
        const group = await kestraClient.Groups.createGroup({
            name: `test_add_user_to_group_${randomId()}`,
            description: 'An example group',
        });

        const user = await kestraClient.Users.createUser({
            email: `test_add_user_to_group_${randomId()}@kestra.io`,
        });

        if (!group.id || !user.id) {
            throw new Error('Failed to create group or user');
        }

        const member = await kestraClient.Groups.addUserToGroup({ id: group.id, userId: user.id });

        expect(member.groups?.some(g => g.id === group.id)).toBeTruthy();
    });

    it('autocomplete_groups: List groups for autocomplete', async () => {
        const prefix = `test_auto_${randomId()}`;
        const created = await kestraClient.Groups.createGroup({
            name: `${prefix}_complete_groups`,
            description: 'An example group',
        });

        const results = await kestraClient.Groups.autocompleteGroups({ q: prefix, filters: [] });

        expect(
            results.some(r => r.id === created.id || r.name === created.name)
        ).toBeTruthy();
    });

    it('create_group: Create a group', async () => {
        const name = `test_create_group_${randomId()}`;
        const created = await kestraClient.Groups.createGroup({
            name,
            description: 'An example group',
        });

        expect(created.name).toBe(name);
        expect(created.id).toBeTruthy();
    });

    it('delete_group: Delete a group', async () => {
        const created = await kestraClient.Groups.createGroup({
            name: `test_delete_group_${randomId()}`,
            description: 'An example group',
        });

        if (!created.id) {
            throw new Error('Failed to create group');
        }

        await kestraClient.Groups.deleteGroup({ id: created.id });

        await expect(kestraClient.Groups.group({ id: created.id })).rejects.toThrow();
    });

    it('delete_user_from_group: Remove a user from a group', async () => {
        const group = await kestraClient.Groups.createGroup({
            name: `test_delete_user_from_group_${randomId()}`,
            description: 'An example group',
        });

        const user = await kestraClient.Users.createUser({
            email: `test_delete_user_from_group_${randomId()}@kestra.io`,
        });

        if (!group.id || !user.id) {
            throw new Error('Failed to create group or user');
        }

        await kestraClient.Groups.addUserToGroup({ id: group.id, userId: user.id });

        const member = await kestraClient.Groups.deleteUserFromGroup({ id: group.id, userId: user.id });

        expect(member.groups?.some(g => g.id === group.id)).toBeFalsy();
    });

    it('get_group: Retrieve a group', async () => {
        const created = await kestraClient.Groups.createGroup({
            name: `test_get_group_${randomId()}`,
            description: 'An example group',
        });

        if (!created.id) {
            throw new Error('Failed to create group');
        }

        const fetched = await kestraClient.Groups.group({ id: created.id });

        expect(fetched.id).toBe(created.id);
        expect(fetched.name).toBe(created.name);
    });

    it('list_group_ids: List groups by ids', async () => {
        const created = await kestraClient.Groups.createGroup({
            name: `test_list_group_ids_${randomId()}`,
            description: 'An example group',
        });

        if (!created.id) {
            throw new Error('Failed to create group');
        }

        const fetched = await kestraClient.Groups.listGroupIds({ ids: [created.id] });

        expect(Array.isArray(fetched) && fetched.length > 0).toBeTruthy();
        expect(fetched.some(g => g.id === created.id)).toBeTruthy();
    });

    it('search_group_members: Search for users in a group', async () => {
        const group = await kestraClient.Groups.createGroup({
            name: `test_search_group_members_${randomId()}`,
            description: 'An example group',
        });

        const user = await kestraClient.Users.createUser({
            email: `test_search_group_members_${randomId()}@kestra.io`,
        });

        if (!group.id || !user.id) {
            throw new Error('Failed to create group or user');
        }

        await kestraClient.Groups.addUserToGroup({ id: group.id, userId: user.id });

        const page = await kestraClient.Groups.searchGroupMembers({
            id: group.id,
            page: 1,
            size: 10,
            filters: [qf({ field: QF_FIELD.USERNAME, operation: QF_OP.EQUALS, value: user.email })],
        });

        const results = page?.results ?? [];
        expect(results.some(m => m.id === user.id)).toBeTruthy();
    });

    it('search_groups: Search for groups', async () => {
        const name = `test_search_groups_${randomId()}`;
        const created = await kestraClient.Groups.createGroup({
            name,
            description: 'An example group',
        });

        const resultsPage = await kestraClient.Groups.searchGroups({
            page: 1,
            size: 10,
            filters: [qf({ field: QF_FIELD.QUERY, operation: QF_OP.EQUALS, value: name })],
        });
        const results = resultsPage?.results ?? [];

        expect(results.some(r => r.id === created.id)).toBeTruthy();
    });

    it('set_user_membership_for_group: Update a user membership type', async () => {
        const group = await kestraClient.Groups.createGroup({
            name: `test_set_user_membership_for_group_${randomId()}`,
            description: 'An example group',
        });

        const user = await kestraClient.Users.createUser({
            email: `test_set_user_membership_for_group_${randomId()}@kestra.io`,
        });

        if (!group.id || !user.id) {
            throw new Error('Failed to create group or user');
        }

        await kestraClient.Groups.addUserToGroup({ id: group.id, userId: user.id });

        const member = await kestraClient.Groups.setUserMembershipForGroup({
            id: group.id,
            userId: user.id,
            membership: 'OWNER',
        });

        expect(member.groups?.some(g => g.id === group.id)).toBeTruthy();
    });

    it('update_group: Update a group', async () => {
        const created = await kestraClient.Groups.createGroup({
            name: `test_update_group_${randomId()}`,
            description: 'Before',
        });

        if (!created.id || !created.name) {
            throw new Error('Failed to create group');
        }

        const updated = await kestraClient.Groups.updateGroup({
            id: created.id,
            name: created.name,
            description: 'Updated description',
        });

        expect(updated.description).toBe('Updated description');
    });
});
