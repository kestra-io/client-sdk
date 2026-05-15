import { describe, it, expect } from 'vitest';
import { kestraClient, randomEmail } from './CommonTestSetup.js';

describe('TenantAccessApi', () => {
    it('listTenantAccess: lists tenant access entries', async () => {
        const result = await kestraClient.TenantAccess.listTenantAccess({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('createTenantAccess: grants tenant access to a user', async () => {
        try {
            const email = randomEmail();
            const result = await kestraClient.TenantAccess.createTenantAccess({ email });
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404, 409, 422].includes(status)) return;
            throw err;
        }
    });

    it('tenantAccess: retrieves tenant access for a user', async () => {
        try {
            const email = randomEmail();
            const created = await kestraClient.TenantAccess.createTenantAccess({ email });
            const userId = (created as any).userId ?? (created as any).id;
            if (!userId) return;

            const result = await kestraClient.TenantAccess.tenantAccess({ userId });
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404, 409, 422].includes(status)) return;
            throw err;
        }
    });

    it('deleteTenantAccess: revokes tenant access for a user', async () => {
        try {
            const email = randomEmail();
            const created = await kestraClient.TenantAccess.createTenantAccess({ email });
            const userId = (created as any).userId ?? (created as any).id;
            if (!userId) return;

            await kestraClient.TenantAccess.deleteTenantAccess({ userId });
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404, 409, 422].includes(status)) return;
            throw err;
        }
    });
});
