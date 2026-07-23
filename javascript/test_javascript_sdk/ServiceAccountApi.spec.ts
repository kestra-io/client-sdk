import { describe, expect, it } from 'vitest';
import { randomIdWith } from './_utils.js';
import * as ServiceAccount from '@kestra-io/kestra-sdk/service-account';


describe('ServiceAccountApi', () => {

    it('create_service_account', async () => {
        const name = randomIdWith('test-create-service-account');

        const created = await ServiceAccount.createServiceAccount({
            name,
            description: 'service account created by tests',
        });

        expect(created?.id).toBeDefined();
    });

    it('create_service_account_for_tenant', async () => {
        const name = randomIdWith('test-create-service-account-for-main');

        const created = await ServiceAccount.createServiceAccountForTenant({
            name,
            description: 'service account for MAIN_TENANT',
        });

        expect(created?.id).toBeDefined();
    });

    it('delete_service_account', async () => {
        const name = randomIdWith('test-delete-service-account');

        const created = await ServiceAccount.createServiceAccount({ name });
        if (!created.id) {
            throw new Error('Failed to create service account');
        }

        await ServiceAccount.deleteServiceAccount({ id: created.id });

        // Optional: ensure it is gone (if API returns 404)
        await expect(ServiceAccount.serviceAccount({ id: created.id })).rejects.toBeDefined();
    });

    it('delete_service_account_for_tenant', async () => {
        const name = randomIdWith('test-delete-service-account-for-main');

        const created = await ServiceAccount.createServiceAccountForTenant({ name });
        if (!created.id) {
            throw new Error('Failed to create service account for tenant');
        }
        await ServiceAccount.deleteServiceAccountForTenant({ id: created.id });
    });

    it('get_service_account', async () => {
        const name = randomIdWith('test-get-service-account');

        const created = await ServiceAccount.createServiceAccount({ name });
        if (!created.id) {
            throw new Error('Failed to create service account');
        }
        const fetched = await ServiceAccount.serviceAccount({ id: created.id });

        expect(fetched?.id).toBe(created.id);
    });

    it('get_service_account_for_tenant', async () => {
        const name = randomIdWith('test-get-service-account-for-main');

        const created = await ServiceAccount.createServiceAccountForTenant({ name });
        if (!created.id) {
            throw new Error('Failed to create service account for tenant');
        }
        const fetched = await ServiceAccount.serviceAccountForTenant({ id: created.id });

        expect(fetched?.id).toBe(created.id);
    });

    it('list_service_accounts (superadmin only)', async () => {
        const name = randomIdWith('test-list-service-accounts');
        const created = await ServiceAccount.createServiceAccount({ name });

        // Many SDKs use {page, size}; some use {page: 1, size: 50}, others 0-based.
        const results = await ServiceAccount.listServiceAccounts({ page: 1, size: 10000, filters: [] });

        // tolerate different result shapes: {results: []} or direct array
        const items = Array.isArray(results) ? results : results?.results ?? [];
        const ids = items.map((r) => r?.id);

        expect(ids).toContain(created.id);
    });

    it('patch_service_account_details', async () => {
        const name = randomIdWith('test-patch-service-account-details');

        const created = await ServiceAccount.createServiceAccount({ name, description: 'old' });
        if (!created.id) {
            throw new Error('Failed to create service account');
        }
        const patched = await ServiceAccount.patchServiceAccountDetails({
            id: created.id,
            name,
            description: 'new',
        });


        expect(patched?.description).toBe('new');
    });

    it('patch_service_account_super_admin', async () => {
        const name = randomIdWith('test-patch-service-account-super-admin');

        const created = await ServiceAccount.createServiceAccount({ name });
        if (!created.id) {
            throw new Error('Failed to create service account');
        }

        // In Python you had a small typo in the method name; fixed here.
        await ServiceAccount.patchServiceAccountSuperAdmin({ id: created.id, superAdmin: true });

        const fetched = await ServiceAccount.serviceAccount({ id: created.id });
        // Depending on the SDK, the property could be super_admin or superAdmin
        expect(fetched.superAdmin).toBe(true);
    });

    it('update_service_account', async () => {
        const name = randomIdWith('test-update-service-account');

        const created = await ServiceAccount.createServiceAccount({ name, description: 'Before' });
        if (!created.id) {
            throw new Error('Failed to create service account');
        }
        // Some SDKs require the "MAIN_TENANT" argument in update; keeping parity with Python.
        const updated = await ServiceAccount.updateServiceAccount({
            id: created.id,
            name: created.name ?? name,
            description: 'After',
        });

        expect(updated?.description).toBe('After');
    });

    it('listApiTokensForServiceAccount: lists API tokens', async () => {
        const name = randomIdWith('test-list-api-tokens');
        const created = await ServiceAccount.createServiceAccount({ name });
        if (!created.id) throw new Error('Failed to create service account');

        const result = await ServiceAccount.listApiTokensForServiceAccount({ id: created.id });
        expect(result).toBeDefined();
    });

    it('createApiTokensForServiceAccount: creates an API token', async () => {
        const name = randomIdWith('test-create-api-token');
        const created = await ServiceAccount.createServiceAccount({ name });
        if (!created.id) throw new Error('Failed to create service account');

        const token = await ServiceAccount.createApiTokensForServiceAccount({
            id: created.id,
            name: randomIdWith('token'),
        });
        expect(token).toBeDefined();
    });

    it('deleteApiTokenForServiceAccount: deletes an API token', async () => {
        const name = randomIdWith('test-delete-api-token');
        const created = await ServiceAccount.createServiceAccount({ name });
        if (!created.id) throw new Error('Failed to create service account');

        const token = await ServiceAccount.createApiTokensForServiceAccount({
            id: created.id,
            name: randomIdWith('token'),
        });
        const tokenId = (token as any).id ?? (token as any).tokenId;
        if (!tokenId) return; // skip if token id not returned

        await ServiceAccount.deleteApiTokenForServiceAccount({ id: created.id, tokenId });
    });

    it('listServiceAccountsForTenant: lists service accounts for the tenant', async () => {
        const name = randomIdWith('test-list-service-accounts-for-tenant');
        const created = await ServiceAccount.createServiceAccountForTenant({ name });

        const results = await ServiceAccount.listServiceAccountsForTenant({ page: 1, size: 10000, filters: [] });
        const items = Array.isArray(results) ? results : (results as any)?.results ?? [];
        expect(items.map((r: any) => r?.id)).toContain(created.id);
    });

    it('listApiTokensForServiceAccountWithTenant: lists API tokens', async () => {
        const name = randomIdWith('test-list-api-tokens-tenant');
        const created = await ServiceAccount.createServiceAccountForTenant({ name });
        if (!created.id) throw new Error('Failed to create service account for tenant');

        const tokenName = randomIdWith('token');
        await ServiceAccount.createApiTokensForServiceAccountWithTenant({ id: created.id, name: tokenName });

        const result: any = await ServiceAccount.listApiTokensForServiceAccountWithTenant({ id: created.id });
        const tokens = result.results ?? result;
        expect(tokens.map((t: any) => t.name)).toContain(tokenName);
    });

    it('createApiTokensForServiceAccountWithTenant: creates an API token', async () => {
        const name = randomIdWith('test-create-api-token-tenant');
        const created = await ServiceAccount.createServiceAccountForTenant({ name });
        if (!created.id) throw new Error('Failed to create service account for tenant');

        const tokenName = randomIdWith('token');
        const token: any = await ServiceAccount.createApiTokensForServiceAccountWithTenant({
            id: created.id,
            name: tokenName,
        });
        expect(token.name).toBe(tokenName);
        expect(typeof token.fullToken).toBe('string');
    });

    it('deleteApiTokenForServiceAccountWithTenant: deletes an API token', async () => {
        const name = randomIdWith('test-delete-api-token-tenant');
        const created = await ServiceAccount.createServiceAccountForTenant({ name });
        if (!created.id) throw new Error('Failed to create service account for tenant');

        const tokenName = randomIdWith('token');
        const token: any = await ServiceAccount.createApiTokensForServiceAccountWithTenant({
            id: created.id,
            name: tokenName,
        });

        await ServiceAccount.deleteApiTokenForServiceAccountWithTenant({ id: created.id, tokenId: token.id });

        const after: any = await ServiceAccount.listApiTokensForServiceAccountWithTenant({ id: created.id });
        const tokens = after.results ?? after;
        expect(tokens.map((t: any) => t.name)).not.toContain(tokenName);
    });
});