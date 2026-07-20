import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as ScimGroups from '@kestra-io/kestra-sdk/scim-groups';
import * as SecurityIntegrations from '@kestra-io/kestra-sdk/security-integrations';

async function createScimIntegration(): Promise<string> {
    const result = await SecurityIntegrations.createSecurityIntegration({
        name: `scim-grp-int-${randomId()}`,
        type: 'SCIM',
        description: 'Test SCIM integration for groups',
    });
    return (result as any).id;
}

describe('ScimGroupsApi', () => {
    it('queryGroups: queries SCIM groups for an integration', async () => {
        const integration = await createScimIntegration();
        const result = await ScimGroups.queryGroups({ integration });
        expect(result).toBeDefined();
    });

    it('findGroups: finds SCIM groups using search request', async () => {
        const integration = await createScimIntegration();
        const result = await ScimGroups.findGroups({ integration });
        expect(result).toBeDefined();
    });
});
