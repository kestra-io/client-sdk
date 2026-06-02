import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';

async function createScimIntegration(): Promise<string> {
    const result = await kestraClient.SecurityIntegrations.createSecurityIntegration({
        name: `scim-grp-int-${randomId()}`,
        type: 'SCIM',
        description: 'Test SCIM integration for groups',
    });
    return (result as any).id;
}

describe('ScimGroupsApi', () => {
    it('queryGroups: queries SCIM groups for an integration', async () => {
        const integration = await createScimIntegration();
        const result = await kestraClient.ScimGroups.queryGroups({ integration });
        expect(result).toBeDefined();
    });

    it('findGroups: finds SCIM groups using search request', async () => {
        const integration = await createScimIntegration();
        const result = await kestraClient.ScimGroups.findGroups({ integration });
        expect(result).toBeDefined();
    });
});
