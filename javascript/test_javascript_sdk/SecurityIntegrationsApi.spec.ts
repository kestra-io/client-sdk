import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as SecurityIntegrations from '@kestra-io/kestra-sdk/security-integrations';

async function createIntegration() {
    return SecurityIntegrations.createSecurityIntegration({
        name: `test-si-${randomId()}`,
        type: 'SCIM',
        description: 'Test security integration',
    });
}

describe('SecurityIntegrationsApi', () => {
    it('listSecurityIntegrations: lists security integrations', async () => {
        const result = await SecurityIntegrations.listSecurityIntegrations();
        expect(result).toBeDefined();
        expect(Array.isArray((result as any).results ?? result)).toBe(true);
    });

    it('createSecurityIntegration: creates a security integration', async () => {
        const result = await createIntegration();
        expect(result).toBeDefined();
        expect((result as any).id).toBeDefined();
    });

    it('securityIntegration: retrieves an integration by id', async () => {
        const created = await createIntegration();
        const id = (created as any).id;

        const result = await SecurityIntegrations.securityIntegration({ id });
        expect(result).toBeDefined();
        expect((result as any).id).toBe(id);
    });

    it('searchSecurityIntegration: searches security integrations', async () => {
        const result = await SecurityIntegrations.searchSecurityIntegration({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('disableSecurityIntegration: disables an integration', async () => {
        const created = await createIntegration();
        const id = (created as any).id;

        await SecurityIntegrations.disableSecurityIntegration({ id });
    });

    it('enableSecurityIntegration: enables a disabled integration', async () => {
        const created = await createIntegration();
        const id = (created as any).id;

        await SecurityIntegrations.disableSecurityIntegration({ id });
        await SecurityIntegrations.enableSecurityIntegration({ id });
    });

    it('deleteSecurityIntegration: deletes an integration', async () => {
        const created = await createIntegration();
        const id = (created as any).id;

        await SecurityIntegrations.deleteSecurityIntegration({ id });
    });
});
