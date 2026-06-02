import { describe, it, expect } from 'vitest';
import { kestraClient, randomEmail } from './CommonTestSetup.js';

describe('TenantAccessApi', () => {
    it('listTenantAccess: lists tenant access entries', async () => {
        const result = await kestraClient.TenantAccess.listTenantAccess({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('createTenantAccess: grants tenant access to a user', async () => {
        // createTenantAccess grants access to an existing user, so create one first.
        const email = randomEmail();
        const createdUser = await kestraClient.Users.createUser({ email });
        const userId = createdUser.id ?? "-";

        // The endpoint returns 204 No Content (no body), so verify the grant took
        // effect by reading the tenant access back instead of asserting on the result.
        await kestraClient.TenantAccess.createTenantAccess({ email });

        const access = await kestraClient.TenantAccess.tenantAccess({ userId });
        expect(access).toBeDefined();
    });

    it('tenantAccess: retrieves tenant access for a user', async () => {
        const email = randomEmail();
        const createdUser = await kestraClient.Users.createUser({ email });
        const userId = createdUser.id ?? "-";

        await kestraClient.TenantAccess.createTenantAccess({ email });

        const result = await kestraClient.TenantAccess.tenantAccess({ userId });
        expect(result).toBeDefined();
    });

    it('deleteTenantAccess: revokes tenant access for a user', async () => {
        const email = randomEmail();
        const createdUser = await kestraClient.Users.createUser({ email });
        const userId = createdUser.id ?? "-";

        await kestraClient.TenantAccess.createTenantAccess({ email });

        await kestraClient.TenantAccess.deleteTenantAccess({ userId });
    });
});
