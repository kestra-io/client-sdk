import {describe, expect, it} from 'vitest';
import {kestraClient, MAIN_TENANT, randomIdWith} from "./CommonTestSetup";


describe('ServiceAccountApi', () => {

    it('create_service_account', async () => {
        const name = randomIdWith('test-create-service-account');

        const created = await kestraClient().serviceAccountApi.createServiceAccount({
            name,
            description: 'service account created by tests',
        });

        expect(created?.id).toBeDefined();
    });

    it('create_service_account_for_tenant', async () => {
        const name = randomIdWith('test-create-service-account-for-main');

        const created = await kestraClient().serviceAccountApi.createServiceAccountForTenant(MAIN_TENANT, {
            name,
            description: 'service account for MAIN_TENANT',
        });

        expect(created?.id).toBeDefined();
    });

    it('delete_service_account', async () => {
        const name = randomIdWith('test-delete-service-account');

        const created = await kestraClient().serviceAccountApi.createServiceAccount({name});
        await kestraClient().serviceAccountApi.deleteServiceAccount(created.id);

        // Optional: ensure it is gone (if API returns 404)
        // await expect(kestraClient().serviceAccountApi.getServiceAccount(created.id)).rejects.toBeDefined();
    });

    it('delete_service_account_for_tenant', async () => {
        const name = randomIdWith('test-delete-service-account-for-main');

        const created = await kestraClient().serviceAccountApi.createServiceAccountForTenant(MAIN_TENANT, {name});
        await kestraClient().serviceAccountApi.deleteServiceAccountForTenant(created.id, MAIN_TENANT);
    });

    it('get_service_account', async () => {
        const name = randomIdWith('test-get-service-account');

        const created = await kestraClient().serviceAccountApi.createServiceAccount({name});
        const fetched = await kestraClient().serviceAccountApi.getServiceAccount(created.id);

        expect(fetched?.id).toBe(created.id);
    });

    it('get_service_account_for_tenant', async () => {
        const name = randomIdWith('test-get-service-account-for-main');

        const created = await kestraClient().serviceAccountApi.createServiceAccountForTenant(MAIN_TENANT, {name});
        const fetched = await kestraClient().serviceAccountApi.getServiceAccountForTenant(created.id, MAIN_TENANT);

        expect(fetched?.id).toBe(created.id);
    });

    it('list_service_accounts (superadmin only)', async () => {
        const name = randomIdWith('test-list-service-accounts');
        const created = await kestraClient().serviceAccountApi.createServiceAccount({name});

        // Many SDKs use {page, size}; some use {page: 1, size: 50}, others 0-based.
        const results = await kestraClient().serviceAccountApi.listServiceAccounts(1, 10000);

        // tolerate different result shapes: {results: []} or direct array
        const items = Array.isArray(results) ? results : results?.results ?? [];
        const ids = items.map((r) => r?.id);

        expect(ids).toContain(created.id);
    });

    it('patch_service_account_details', async () => {
        const name = randomIdWith('test-patch-service-account-details');

        const created = await kestraClient().serviceAccountApi.createServiceAccount({name, description: 'old'});
        const patched = await kestraClient().serviceAccountApi.patchServiceAccountDetails(created.id, {
            name,
            description: 'new',
        });

        // Some SDKs expose "desc" instead of "description"
        expect(patched?.description ?? patched?.desc).toBe('new');
    });

    it('patch_service_account_super_admin', async () => {
        const name = randomIdWith('test-patch-service-account-super-admin');

        const created = await kestraClient().serviceAccountApi.createServiceAccount({name});

        // In Python you had a small typo in the method name; fixed here.
        await kestraClient().serviceAccountApi.patchServiceAccountSuperAdmin(created.id, {superAdmin: true});

        const fetched = await kestraClient().serviceAccountApi.getServiceAccount(created.id);
        // Depending on the SDK, the property could be super_admin or superAdmin
        expect(fetched.superAdmin).toBe(true);
    });

    it('update_service_account', async () => {
        const name = randomIdWith('test-update-service-account');

        const created = await kestraClient().serviceAccountApi.createServiceAccount({name, description: 'Before'});

        // Some SDKs require the "MAIN_TENANT" argument in update; keeping parity with Python.
        const updated = await kestraClient().serviceAccountApi.updateServiceAccount(created.id, MAIN_TENANT, {
            name: created.name ?? name,
            description: 'After',
        });

        expect(updated?.description ?? updated?.desc).toBe('After');
    });
});