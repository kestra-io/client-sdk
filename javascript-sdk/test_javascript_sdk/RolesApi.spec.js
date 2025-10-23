import {describe, expect, it} from 'vitest';
import ApiAutocomplete from "../src/model/ApiAutocomplete";
import IAMRoleControllerApiRoleCreateOrUpdateRequest from "../src/model/IAMRoleControllerApiRoleCreateOrUpdateRequest";
import ApiIds from "../src/model/ApiIds";
import IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions
    from "../src/model/IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions";
import {kestraClient, MAIN_TENANT, randomId} from "./CommonTestSetup";

describe('RolesApi', () => {

    it('autocomplete_roles — lists roles for autocomplete', async () => {
        const prefix = `test_autocomplete_roles_${randomId()}`;
        const perms = new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions();
        perms.flow = ['READ'];

        const roleReq = new IAMRoleControllerApiRoleCreateOrUpdateRequest();
        roleReq.name = `${prefix}_complete_roles`;
        roleReq.permissions = perms;
        roleReq.description = 'An example role';

        const created = await kestraClient().rolesApi.createRole(
            MAIN_TENANT,
            roleReq,
        );

        const auto = new ApiAutocomplete();
        auto.q = prefix;

        const results = await kestraClient().rolesApi.autocompleteRoles(
            MAIN_TENANT,
            auto,
        );

        expect(
            results.some(
                (r) => (r.id && r.id === created.id) || (r.name && r.name === created.name),
            ),
        ).toBe(true);
    });

    it('create_role — creates a role', async () => {
        const name = `test_create_role_${randomId()}`;
        const perms = new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions();
        perms.flow = ['READ'];

        const roleReq = new IAMRoleControllerApiRoleCreateOrUpdateRequest();
        roleReq.name = name;
        roleReq.permissions = perms;
        roleReq.description = 'An example role';

        const created = await kestraClient().rolesApi.createRole(
            MAIN_TENANT,
            roleReq,
        );

        expect(created).toHaveProperty('name', name);
    });

    it('delete_role — deletes a role', async () => {
        const name = `test_delete_role_${randomId()}`;
        const perms = new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions();
        perms.flow = ['READ'];

        const roleReq = new IAMRoleControllerApiRoleCreateOrUpdateRequest();
        roleReq.name = name;
        roleReq.permissions = perms;

        const created = await kestraClient().rolesApi.createRole(
            MAIN_TENANT,
            roleReq,
        );

        await kestraClient().rolesApi.deleteRole(created.id, MAIN_TENANT);

        await expect(kestraClient().rolesApi.getRole(created.id, MAIN_TENANT)).rejects.toThrow();
    });

    it('get_role — retrieves a role', async () => {
        const name = `test_get_role_${randomId()}`;
        const perms = new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions();
        perms.flow = ['READ'];

        const roleReq = new IAMRoleControllerApiRoleCreateOrUpdateRequest();
        roleReq.name = name;
        roleReq.permissions = perms;

        const created = await kestraClient().rolesApi.createRole(
            MAIN_TENANT,
            roleReq,
        );

        const fetched = await kestraClient().rolesApi.getRole(created.id, MAIN_TENANT);
        expect(fetched.id).toBe(created.id);
    });

    it('list_roles_from_given_ids — lists roles by ids', async () => {
        const name = `test_list_roles_from_given_ids_${randomId()}`;
        const perms = new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions();
        perms.flow = ['READ'];

        const roleReq = new IAMRoleControllerApiRoleCreateOrUpdateRequest();
        roleReq.name = name;
        roleReq.permissions = perms;

        const created = await kestraClient().rolesApi.createRole(
            MAIN_TENANT,
            roleReq,
        );

        const ids = new ApiIds();
        ids.ids = [created.id];

        const fetched = await kestraClient().rolesApi.listRolesFromGivenIds(
            MAIN_TENANT,
            ids,
        );

        expect(Array.isArray(fetched)).toBe(true);
        expect(fetched.length).toBeGreaterThan(0);
    });

    it('search_roles — searches for roles', async () => {
        const name = `test_search_roles_${randomId()}`;
        const perms = new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions();
        perms.flow = ['READ'];

        const roleReq = new IAMRoleControllerApiRoleCreateOrUpdateRequest();
        roleReq.name = name;
        roleReq.permissions = perms;

        const created = await kestraClient().rolesApi.createRole(
            MAIN_TENANT,
            roleReq,
        );

        const results = await kestraClient().rolesApi.searchRoles(
            1,
            10000,
            MAIN_TENANT,
            name,
        );

        // search typically returns { results, total, ... }
        expect(results.results.map(x=>x.id)).toContain(created.id)
    });

    it('update_role — updates a role', async () => {
        const name = `test_update_role_${randomId()}`;
        const perms = new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions();
        perms.flow = ['READ'];

        const roleReq = new IAMRoleControllerApiRoleCreateOrUpdateRequest();
        roleReq.name = name;
        roleReq.permissions = perms;
        roleReq.description = 'Before';

        const created = await kestraClient().rolesApi.createRole(
            MAIN_TENANT,
            roleReq,
        );

        const updateReq = new IAMRoleControllerApiRoleCreateOrUpdateRequest();
        updateReq.name = created.name;
        updateReq.permissions = perms;
        const updateDesc = 'Updated description';
        updateReq.description = updateDesc;

        const updated = await kestraClient().rolesApi.updateRole(
            created.id,
            MAIN_TENANT,
            updateReq,
        );

        expect(updated).toHaveProperty('description', updateDesc);
    });
});