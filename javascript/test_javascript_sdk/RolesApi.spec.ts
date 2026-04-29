import { describe, expect, it } from 'vitest';
import { kestraClient, randomId } from "./CommonTestSetup.js";

describe('RolesApi', () => {

    it('autocomplete_roles — lists roles for autocomplete', async () => {
        const prefix = `test_autocomplete_roles_${randomId()}`;

        const created = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name: `${prefix}_complete_roles`,
            description: 'An example role',
        });

        const results = await kestraClient.Roles.autocompleteRoles({
            q: prefix,
        });

        expect(
            results.some(
                (r) => (r.id && r.id === created.id) || (r.name && r.name === created.name),
            ),
        ).toBe(true);
    });

    it('create_role — creates a role', async () => {
        const name = `test_create_role_${randomId()}`;

        const created = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name,
            description: 'An example role',
        });

        expect(created).toHaveProperty('name', name);
    });

    it('delete_role — deletes a role', async () => {
        const name = `test_delete_role_${randomId()}`;

        const created = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name,
        });

        if (!created.id) {
            throw new Error('Failed to create role');
        }

        await kestraClient.Roles.deleteRole({ id: created.id });

        await expect(kestraClient.Roles.role({ id: created.id })).rejects.toThrow();
    });

    it('get_role — retrieves a role', async () => {
        const name = `test_get_role_${randomId()}`;

        const created = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name,
        });
        if (!created.id) {
            throw new Error('Failed to create role');
        }

        const fetched = await kestraClient.Roles.role({ id: created.id });
        expect(fetched.id).toBe(created.id);
    });

    it('list_roles_from_given_ids — lists roles by ids', async () => {
        const name = `test_list_roles_from_given_ids_${randomId()}`;

        const created = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name,
        });

        if (!created.id) {
            throw new Error('Failed to create role');
        }

        const fetched = await kestraClient.Roles.listRolesFromGivenIds({
            ids: [created.id],
        });

        expect(Array.isArray(fetched)).toBe(true);
        expect(fetched.length).toBeGreaterThan(0);
    });

    it('search_roles — searches for roles', async () => {
        const name = `test_search_roles_${randomId()}`;

        const created = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name,
        });

        const results = await kestraClient.Roles.searchRoles({
            page: 1,
            size: 10000,
            filters: [],
        });

        // search typically returns { results, total, ... }
        expect(results.results.map(x => x.id)).toContain(created.id)
    });

    it('update_role — updates a role', async () => {
        const name = `test_update_role_${randomId()}`;

        const created = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name,
            description: 'Before',
        });

        if (!created.id || !created.name) {
            throw new Error('Failed to create role');
        }

        const updateDesc = 'Updated description';

        const updated = await kestraClient.Roles.updateRole({
            id: created.id,
            permissions: { FLOW: ['READ'] },
            name: created.name,
            description: updateDesc,
        });

        expect(updated).toHaveProperty('description', updateDesc);
    });
});
