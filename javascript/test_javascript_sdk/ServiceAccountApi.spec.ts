import { describe, expect, it } from 'vitest';
import { kestraClient, MAIN_TENANT, randomIdWith } from "./CommonTestSetup.js";


describe('ServiceAccountApi', () => {

    it('create_service_account', async () => {
        const name = randomIdWith('test-create-service-account');

        const created = await kestraClient().ServiceAccount.createServiceAccount({
            name,
            description: 'service account created by tests',
        });

        expect(created?.id).toBeDefined();
    });

    it('create_service_account_for_tenant', async () => {
        const name = randomIdWith('test-create-service-account-for-main');

        const created = await kestraClient().ServiceAccount.createServiceAccountForTenant({
            name,
            description: 'service account for MAIN_TENANT',
        });

        expect(created?.id).toBeDefined();
    });

    it('delete_service_account', async () => {
        const name = randomIdWith('test-delete-service-account');

        const created = await kestraClient().ServiceAccount.createServiceAccount({ name });
        await kestraClient().ServiceAccount.deleteServiceAccount({ id: created.id });

        // Optional: ensure it is gone (if API returns 404)
        // await expect(kestraClient().ServiceAccount.getServiceAccount(created.id)).rejects.toBeDefined();
    });

    it('delete_service_account_for_tenant', async () => {
        const name = randomIdWith('test-delete-service-account-for-main');

        const created = await kestraClient().ServiceAccount.createServiceAccountForTenant({ name });
        await kestraClient().ServiceAccount.deleteServiceAccountForTenant({ id: created.id });
    });

    it('get_service_account', async () => {
        const name = randomIdWith('test-get-service-account');

        const created = await kestraClient().ServiceAccount.createServiceAccount({ name });
        const fetched = await kestraClient().ServiceAccount.serviceAccount({ id: created.id });

        expect(fetched?.id).toBe(created.id);
    });

    it('get_service_account_for_tenant', async () => {
        const name = randomIdWith('test-get-service-account-for-main');

        const created = await kestraClient().ServiceAccount.createServiceAccountForTenant({ name });
        const fetched = await kestraClient().ServiceAccount.serviceAccountForTenant({ id: created.id });

        expect(fetched?.id).toBe(created.id);
    });

    it('list_service_accounts (superadmin only)', async () => {
        const name = randomIdWith('test-list-service-accounts');
        const created = await kestraClient().ServiceAccount.createServiceAccount({ name });

        // Many SDKs use {page, size}; some use {page: 1, size: 50}, others 0-based.
        const results = await kestraClient().ServiceAccount.listServiceAccounts({ page: 1, size: 10000, filters: [] });

        // tolerate different result shapes: {results: []} or direct array
        const items = Array.isArray(results) ? results : results?.results ?? [];
        const ids = items.map((r) => r?.id);

        expect(ids).toContain(created.id);
    });

    it('patch_service_account_details', async () => {
        const name = randomIdWith('test-patch-service-account-details');

        const created = await kestraClient().ServiceAccount.createServiceAccount({ name, description: 'old' });
        const patched = await kestraClient().ServiceAccount.patchServiceAccountDetails({
            id: created.id,
            name,
            description: 'new',
        });


        expect(patched?.description).toBe('new');
    });

    it('patch_service_account_super_admin', async () => {
        const name = randomIdWith('test-patch-service-account-super-admin');

        const created = await kestraClient().ServiceAccount.createServiceAccount({ name });

        // In Python you had a small typo in the method name; fixed here.
        await kestraClient().ServiceAccount.patchServiceAccountSuperAdmin({ id: created.id, superAdmin: true });

        const fetched = await kestraClient().ServiceAccount.serviceAccount({ id: created.id });
        // Depending on the SDK, the property could be super_admin or superAdmin
        expect(fetched.superAdmin).toBe(true);
    });

    it('update_service_account', async () => {
        const name = randomIdWith('test-update-service-account');

        const created = await kestraClient().ServiceAccount.createServiceAccount({ name, description: 'Before' });

        // Some SDKs require the "MAIN_TENANT" argument in update; keeping parity with Python.
        const updated = await kestraClient().ServiceAccount.updateServiceAccount({
            id: created.id,
            name: created.name ?? name,
            description: 'After',
        });

        expect(updated?.description).toBe('After');
    });
});