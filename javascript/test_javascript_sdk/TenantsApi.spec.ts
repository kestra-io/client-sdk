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

    it('create_1: creates a new tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        const result = await kestraClient.Tenants.create_1(tenant);
        expect(result).toBeDefined();
    });

    it('get_2: retrieves a tenant by id', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await kestraClient.Tenants.create_1(tenant);

        const result = await kestraClient.Tenants.get_2({ id });
        expect(result).toBeDefined();
        expect((result as any).id).toBe(id);
    });

    it('update: updates a tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await kestraClient.Tenants.create_1(tenant);

        const updated: Tenant = { ...tenant, name: `Updated Tenant ${id}` };
        const result = await kestraClient.Tenants.update({ id, ...updated });
        expect(result).toBeDefined();
    });

    it('delete_2: deletes a tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await kestraClient.Tenants.create_1(tenant);

        await kestraClient.Tenants.delete_2({ id });
    });

    it('flowDependenciesFromTenant: returns tenant flow dependencies', async () => {
        const result = await kestraClient.Tenants.flowDependenciesFromTenant();
        expect(result).toBeDefined();
    });
});
