import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';

async function createScimIntegration(): Promise<string> {
    const result = await kestraClient.SecurityIntegrations.createSecurityIntegration({
        name: `scim-int-${randomId()}`,
        type: 'SCIM',
        description: 'Test SCIM integration',
    });
    return (result as any).id;
}

describe('ScimConfigurationApi', () => {
    it('allResourceTypes: returns all SCIM resource types for an integration', async () => {

        const integration = await createScimIntegration();
        const result = await kestraClient.ScimConfiguration.allResourceTypes({ integration });
        expect(result).toBeDefined();
    });

    it('resourceType: retrieves a SCIM resource type by name', async () => {
        const integration = await createScimIntegration();
        const result = await kestraClient.ScimConfiguration.resourceType({ integration, name: 'User' });
        expect(result).toBeDefined();
    });

    it('allSchemas: returns all SCIM schemas for an integration', async () => {
        const integration = await createScimIntegration();
        const result = await kestraClient.ScimConfiguration.allSchemas({ integration });
        expect(result).toBeDefined();
    });

    it('schema: retrieves a SCIM schema by uri', async () => {
        const integration = await createScimIntegration();
        const result = await kestraClient.ScimConfiguration.schema({
            integration,
            uri: 'urn:ietf:params:scim:schemas:core:2.0:User',
        });
        expect(result).toBeDefined();
    });

    it.skip('serviceProviderConfiguration: returns SCIM service provider config', async () => {
        const integration = await createScimIntegration();
        const result = await kestraClient.ScimConfiguration.serviceProviderConfiguration({ integration });
        expect(result).toBeDefined();
    });
});
