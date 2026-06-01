import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
import type { Tenant } from '@kestra-io/kestra-sdk';

function makeTenant(id: string): Tenant {
    return {
        id,
        name: `Test Tenant ${id}`,
        deleted: false,
    };
}

describe('TenantsApi', () => {
    it('find: lists all tenants', async () => {
        const result = await kestraClient.Tenants.find({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('create_2: creates a new tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        const result = await kestraClient.TenantsAdmin.create_2(tenant);
        expect(result).toBeDefined();
    });

    it('get_2: retrieves a tenant by id', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await kestraClient.TenantsAdmin.create_2(tenant);

        const result = await kestraClient.TenantsAdmin.get_3({ id });
        expect(result).toBeDefined();
        expect((result as any).id).toBe(id);
    });

    it('update: updates a tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await kestraClient.TenantsAdmin.create_2(tenant);

        const updated: Tenant = { ...tenant, name: `Updated Tenant ${id}` };
        const result = await kestraClient.TenantsAdmin.update_2(updated);
        expect(result).toBeDefined();
    });

    it('delete_2: deletes a tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await kestraClient.TenantsAdmin.create_2(tenant);

        await kestraClient.TenantsAdmin.delete_2({ id });
    });

    it('flowDependenciesFromTenant: returns tenant flow dependencies', async () => {
        const result = await kestraClient.Tenants.flowDependenciesFromTenant();
        expect(result).toBeDefined();
    });

    it('appsCatalogConfig: returns apps catalog config for a tenant', async () => {
        const id = randomId();
        await kestraClient.TenantsAdmin.create_2(makeTenant(id));

        const result = await kestraClient.Tenants.appsCatalogConfig({ id });
        expect(result).toBeDefined();
    });

    it('setAppsCatalogConfig: sets apps catalog config for a tenant', async () => {
        const id = randomId();
        await kestraClient.TenantsAdmin.create_2(makeTenant(id));

        const result = await kestraClient.Tenants.setAppsCatalogConfig({ id, title: 'Test Title' });
        expect(result).toBeDefined();
    });

    it('deleteAppsCatalogLogo: deletes apps catalog logo for a tenant', async () => {
        const id = randomId();
        await kestraClient.TenantsAdmin.create_2(makeTenant(id));

        await kestraClient.Tenants.deleteAppsCatalogLogo({ id });
    });

    it('defaultDashboards: returns default dashboards for a tenant', async () => {
        const id = randomId();
        await kestraClient.TenantsAdmin.create_2(makeTenant(id));

        const result = await kestraClient.Tenants.defaultDashboards({ id });
        expect(result).toBeDefined();
    });

    it('setTenantDefaultDashboards: sets default dashboards for a tenant', async () => {
        const id = randomId();
        await kestraClient.TenantsAdmin.create_2(makeTenant(id));

        const result = await kestraClient.Tenants.setTenantDefaultDashboards({ id });
        expect(result).toBeDefined();
    });
});
