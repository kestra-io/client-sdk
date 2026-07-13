import { describe, it, expect } from 'vitest';
import { kestraClient, getSimpleFlow } from './CommonTestSetup.js';

describe('MiscApi', () => {
    it('configuration: returns server configuration', async () => {
        const result = await kestraClient.Misc.configuration();
        expect(result).toBeDefined();
    });

    it('licenseInfo: returns license information', async () => {
        const result = await kestraClient.Misc.licenseInfo();
        expect(result).toBeDefined();
    });

    it('expressionFilters: returns available expression filters', async () => {
        const result = await kestraClient.Misc.expressionFilters();
        expect(result).toBeDefined();
    });

    it('expressionFunctions: returns available expression functions', async () => {
        const result = await kestraClient.Misc.expressionFunctions();
        expect(result).toBeDefined();
    });

    it.skip('mainTenantFlows: returns flows from main tenant', async () => {
        const result = await kestraClient.Misc.mainTenantFlows();
        expect(result).toBeDefined();
    });

    it.skip('basicAuthConfigErrors: returns basic auth configuration errors', async () => {
        const result = await kestraClient.Misc.basicAuthConfigErrors();
        expect(result).toBeDefined();
    });

    it('setupConfiguration: returns setup configuration', async () => {
        const result = await kestraClient.Misc.setupConfiguration();
        expect(result).toBeDefined();
    });

    it('supportDebugInfo: returns support debug info', async () => {
        const result = await kestraClient.Misc.supportDebugInfo();
        expect(result).toBeDefined();
    });

    it('listTemplates: returns managed role templates', async () => {
        const result = await kestraClient.Misc.listTemplates();
        expect(result).toBeDefined();
    });

    it.skip('generate: generates something', async () => {
        const result = await kestraClient.Misc.generate();
        expect(result).toBeDefined();
    });

    it('usages: returns usages', async () => {
        const result = await kestraClient.Misc.usages();
        expect(result).toBeDefined();
    });

    it('workerSelectorTags: returns available worker selector tags', async () => {
        const result = await kestraClient.Misc.workerSelectorTags();
        // No worker selector tags are configured in the test environment.
        expect(result.tags).toEqual([]);
    });

    it('listPermissions: returns available permissions', async () => {
        const result = await kestraClient.Misc.listPermissions();
        // A resource-keyed map, each value being the list of allowed actions.
        expect(Array.isArray(result.FLOW)).toBe(true);
        expect(Array.isArray(result.EXECUTION)).toBe(true);
    });

    it('tenantUsage: returns tenant usage metrics', async () => {
        // Create a flow so the tenant-wide flow count is a real positive number.
        // An exact value can't be asserted: the count spans the whole tenant,
        // which other test files mutate concurrently.
        await kestraClient.Flows.createFlow({ body: getSimpleFlow() });

        const result = await kestraClient.Misc.tenantUsage();
        expect(result.flows?.count).toBeGreaterThanOrEqual(1);
    });
});
