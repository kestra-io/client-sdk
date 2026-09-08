import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Tenants from '@kestra-io/kestra-sdk/tenants';
import * as TenantsAdmin from '@kestra-io/kestra-sdk/tenants-admin';
import type { Tenant } from '@kestra-io/kestra-sdk';

function makeTenant(id: string): Tenant {
    return {
        id,
        name: `Test Tenant ${id}`,
        deleted: false,
    };
}

// The logo upload endpoints reject anything but SVG ("422 Logo must be a SVG
// file"), so ship a minimal valid SVG rather than a raster image.
const SVG_LOGO = '<svg xmlns="http://www.w3.org/2000/svg" width="1" height="1"><rect width="1" height="1"/></svg>';

function makeLogo(): Blob {
    return new Blob([SVG_LOGO], { type: 'image/svg+xml' });
}

describe('TenantsApi', () => {
    it('find: lists all tenants', async () => {
        const result = await Tenants.find({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('create: creates a new tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        const result = await TenantsAdmin.create(tenant);
        expect(result).toBeDefined();
    });

    it('get: retrieves a tenant by id', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await TenantsAdmin.create(tenant);

        const result = await TenantsAdmin.get({ id });
        expect(result).toBeDefined();
        expect((result as any).id).toBe(id);
    });

    it('create: sets a tenant-level concurrency limit', async () => {
        const id = randomId();
        const tenant: Tenant = { ...makeTenant(id), concurrency: { limit: 5, behavior: 'FAIL' } };

        const result = await TenantsAdmin.create(tenant);
        expect((result as any).concurrency).toEqual({ limit: 5, behavior: 'FAIL' });

        const fetched = await TenantsAdmin.get({ id });
        expect((fetched as any).concurrency).toEqual({ limit: 5, behavior: 'FAIL' });
    });

    it('update: updates a tenant-level concurrency limit', async () => {
        const id = randomId();
        await TenantsAdmin.create(makeTenant(id));

        const updated = await TenantsAdmin.update({
            ...makeTenant(id),
            concurrency: { limit: 2, behavior: 'QUEUE' },
        });

        expect((updated as any).concurrency).toEqual({ limit: 2, behavior: 'QUEUE' });
    });

    it('update: updates a tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await TenantsAdmin.create(tenant);

        const updated: Tenant = { ...tenant, name: `Updated Tenant ${id}` };
        const result = await TenantsAdmin.update(updated);
        expect(result).toBeDefined();
    });

    it('delete: deletes a tenant', async () => {
        const id = randomId();
        const tenant = makeTenant(id);
        await TenantsAdmin.create(tenant);

        await TenantsAdmin.deleteTenants({ id });
    });

    it('flowDependenciesFromTenant: returns tenant flow dependencies', async () => {
        const result = await Tenants.flowDependenciesFromTenant();
        expect(result).toBeDefined();
    });

    it('appsCatalogConfig: returns apps catalog config for a tenant', async () => {
        const id = randomId();
        await TenantsAdmin.create(makeTenant(id));

        const result = await Tenants.appsCatalogConfig({ id });
        expect(result).toBeDefined();
    });

    it('setAppsCatalogConfig: sets apps catalog config for a tenant', async () => {
        const id = randomId();
        await TenantsAdmin.create(makeTenant(id));

        const result = await Tenants.setAppsCatalogConfig({ id, title: 'Test Title' });
        expect(result).toBeDefined();
    });

    it('setLogo: sets a tenant logo', async () => {
        const id = randomId();
        await TenantsAdmin.create(makeTenant(id));

        const result = await Tenants.setLogo({ id, logo: makeLogo() });
        expect((result as any).id).toBe(id);
        expect(typeof (result as any).logo).toBe('string');
    });

    it('setAppsCatalogLogo: sets the apps catalog logo for a tenant', async () => {
        const id = randomId();
        await TenantsAdmin.create(makeTenant(id));

        const result = await Tenants.setAppsCatalogLogo({ id, logo: makeLogo() });
        expect(typeof (result as any).logo).toBe('string');
    });

    it('deleteAppsCatalogLogo: deletes apps catalog logo for a tenant', async () => {
        const id = randomId();
        await TenantsAdmin.create(makeTenant(id));

        await Tenants.deleteAppsCatalogLogo({ id });
    });

    it('defaultDashboards: returns default dashboards for a tenant', async () => {
        const id = randomId();
        await TenantsAdmin.create(makeTenant(id));

        const result = await Tenants.defaultDashboards({ id });
        expect(result).toBeDefined();
    });

    it('setTenantDefaultDashboards: sets default dashboards for a tenant', async () => {
        const id = randomId();
        await TenantsAdmin.create(makeTenant(id));

        const result = await Tenants.setTenantDefaultDashboards({ id });
        expect(result).toBeDefined();
    });
});
