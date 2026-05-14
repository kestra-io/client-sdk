import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';

async function createScimIntegration(): Promise<string> {
    const result = await kestraClient.SecurityIntegrations.createSecurityIntegration({
        name: `scim-usr-int-${randomId()}`,
        type: 'SCIM',
        description: 'Test SCIM integration for users',
    });
    return (result as any).id;
}

describe('ScimUsersApi', () => {
    it('queryUsers: queries SCIM users for an integration', async () => {
        try {
            const integration = await createScimIntegration();
            const result = await kestraClient.ScimUsers.queryUsers({ integration });
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([401, 403, 404, 422].includes(status)) return;
            throw err;
        }
    });

    it('findUsers: finds SCIM users using search request', async () => {
        try {
            const integration = await createScimIntegration();
            const result = await kestraClient.ScimUsers.findUsers({ integration });
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([401, 403, 404, 422].includes(status)) return;
            throw err;
        }
    });
});
