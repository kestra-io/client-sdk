import { describe, it, expect } from 'vitest';
import { randomEmail } from './_utils.js';
import * as TenantAccess from '@kestra-io/kestra-sdk/tenant-access';
import * as Users from '@kestra-io/kestra-sdk/users';

describe('TenantAccessApi', () => {
    it('listTenantAccess: lists tenant access entries', async () => {
        const result = await TenantAccess.listTenantAccess({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('createTenantAccess: grants tenant access to a user', async () => {
        // createTenantAccess grants access to an existing user, so create one first.
        const email = randomEmail();
        const createdUser = await Users.createUser({ email });
        const userId = createdUser.id ?? "-";

        // The endpoint returns 204 No Content (no body), so verify the grant took
        // effect by reading the tenant access back instead of asserting on the result.
        await TenantAccess.createTenantAccess({ email });

        const access = await TenantAccess.tenantAccess({ userId });
        expect(access).toBeDefined();
    });

    it('tenantAccess: retrieves tenant access for a user', async () => {
        const email = randomEmail();
        const createdUser = await Users.createUser({ email });
        const userId = createdUser.id ?? "-";

        await TenantAccess.createTenantAccess({ email });

        const result = await TenantAccess.tenantAccess({ userId });
        expect(result).toBeDefined();
    });

    it('deleteTenantAccess: revokes tenant access for a user', async () => {
        const email = randomEmail();
        const createdUser = await Users.createUser({ email });
        const userId = createdUser.id ?? "-";

        await TenantAccess.createTenantAccess({ email });

        await TenantAccess.deleteTenantAccess({ userId });
    });
});
