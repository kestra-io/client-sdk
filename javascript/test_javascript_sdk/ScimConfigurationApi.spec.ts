import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as ScimConfiguration from '@kestra-io/kestra-sdk/scim-configuration';
import * as SecurityIntegrations from '@kestra-io/kestra-sdk/security-integrations';

async function createScimIntegration(): Promise<string> {
    const result = await SecurityIntegrations.createSecurityIntegration({
        name: `scim-int-${randomId()}`,
        type: 'SCIM',
        description: 'Test SCIM integration',
    });
    return (result as any).id;
}

describe('ScimConfigurationApi', () => {
    it('allResourceTypes: returns all SCIM resource types for an integration', async () => {

        const integration = await createScimIntegration();
        const result = await ScimConfiguration.allResourceTypes({ integration });
        expect(result).toBeDefined();
    });

    it('resourceType: retrieves a SCIM resource type by name', async () => {
        const integration = await createScimIntegration();
        const result = await ScimConfiguration.resourceType({ integration, name: 'User' });
        expect(result).toBeDefined();
    });

    it('allSchemas: returns all SCIM schemas for an integration', async () => {
        const integration = await createScimIntegration();
        const result = await ScimConfiguration.allSchemas({ integration });
        expect(result).toBeDefined();
    });

    it('schema: retrieves a SCIM schema by uri', async () => {
        const integration = await createScimIntegration();
        const result = await ScimConfiguration.schema({
            integration,
            uri: 'urn:ietf:params:scim:schemas:core:2.0:User',
        });
        expect(result).toBeDefined();
    });

    it.skip('serviceProviderConfiguration: returns SCIM service provider config', async () => {
        const integration = await createScimIntegration();
        const result = await ScimConfiguration.serviceProviderConfiguration({ integration });
        expect(result).toBeDefined();
    });
});
