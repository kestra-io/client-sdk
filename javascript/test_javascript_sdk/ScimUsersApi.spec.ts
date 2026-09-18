import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as ScimUsers from '@kestra-io/kestra-sdk/scim-users';
import * as SecurityIntegrations from '@kestra-io/kestra-sdk/security-integrations';

async function createScimIntegration(): Promise<string> {
    const result = await SecurityIntegrations.createSecurityIntegration({
        name: `scim-usr-int-${randomId()}`,
        type: 'SCIM',
        description: 'Test SCIM integration for users',
    });
    return (result as any).id;
}

describe('ScimUsersApi', () => {
    it('queryUsers: queries SCIM users for an integration', async () => {
        const integration = await createScimIntegration();
        const result = await ScimUsers.queryUsers({ integration });
        expect(result).toBeDefined();
    });

    it('findUsers: finds SCIM users using search request', async () => {
        const integration = await createScimIntegration();
        const result = await ScimUsers.findUsers({ integration });
        expect(result).toBeDefined();
    });
});
