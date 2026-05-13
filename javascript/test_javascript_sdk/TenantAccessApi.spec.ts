import { describe, it, expect } from 'vitest';
import { kestraClient, randomEmail } from './CommonTestSetup.js';

describe('TenantAccessApi', () => {
    it('listTenantAccess: lists tenant access entries', async () => {
        const result = await kestraClient.TenantAccess.listTenantAccess({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('createTenantAccess: grants tenant access to a user', async () => {
        const email = randomEmail();
        const result = await kestraClient.TenantAccess.createTenantAccess({ email });
        expect(result).toBeDefined();
    });

    it('tenantAccess: retrieves tenant access for a user', async () => {
        const email = randomEmail();
        const created = await kestraClient.TenantAccess.createTenantAccess({ email });
        const userId = (created as any).userId ?? (created as any).id;

        const result = await kestraClient.TenantAccess.tenantAccess({ userId });
        expect(result).toBeDefined();
    });

    it('deleteTenantAccess: revokes tenant access for a user', async () => {
        const email = randomEmail();
        const created = await kestraClient.TenantAccess.createTenantAccess({ email });
        const userId = (created as any).userId ?? (created as any).id;

        await kestraClient.TenantAccess.deleteTenantAccess({ userId });
    });
});
