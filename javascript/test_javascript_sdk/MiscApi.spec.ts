import { describe, it, expect } from 'vitest';
import { getSimpleFlow } from './_utils.js';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Misc from '@kestra-io/kestra-sdk/misc';

describe('MiscApi', () => {
    it('configuration: returns server configuration', async () => {
        const result = await Misc.configuration();
        expect(result).toBeDefined();
    });

    it('licenseInfo: returns license information', async () => {
        const result = await Misc.licenseInfo();
        expect(result).toBeDefined();
    });

    it('expressionFilters: returns available expression filters', async () => {
        const result = await Misc.expressionFilters();
        expect(result).toBeDefined();
    });

    it('expressionFunctions: returns available expression functions', async () => {
        const result = await Misc.expressionFunctions();
        expect(result).toBeDefined();
    });

    it.skip('mainTenantFlows: returns flows from main tenant', async () => {
        const result = await Misc.mainTenantFlows();
        expect(result).toBeDefined();
    });

    it.skip('basicAuthConfigErrors: returns basic auth configuration errors', async () => {
        const result = await Misc.basicAuthConfigErrors();
        expect(result).toBeDefined();
    });

    it('setupConfiguration: returns setup configuration', async () => {
        const result = await Misc.setupConfiguration();
        expect(result).toBeDefined();
    });

    it('supportDebugInfo: returns support debug info', async () => {
        const result = await Misc.supportDebugInfo();
        expect(result).toBeDefined();
    });

    it('listTemplates: returns managed role templates', async () => {
        const result = await Misc.listTemplates();
        expect(result).toBeDefined();
    });

    it.skip('generate: generates something', async () => {
        const result = await Misc.generate();
        expect(result).toBeDefined();
    });

    it('usages: returns usages', async () => {
        const result = await Misc.usages();
        expect(result).toBeDefined();
    });

    it('workerSelectorTags: returns available worker selector tags', async () => {
        const result = await Misc.workerSelectorTags();
        // No worker selector tags are configured in the test environment.
        expect(result.tags).toEqual([]);
    });

    it('listPermissions: returns available permissions', async () => {
        const result = await Misc.listPermissions();
        // A resource-keyed map, each value being the list of allowed actions.
        expect(Array.isArray(result.FLOW)).toBe(true);
        expect(Array.isArray(result.EXECUTION)).toBe(true);
    });

    it('tenantUsage: returns tenant usage metrics', async () => {
        // Create a flow so the tenant-wide flow count is a real positive number.
        await Flows.createFlow({ body: getSimpleFlow() });

        const result = await Misc.tenantUsage();
        // This count is racy: it spans the whole tenant, and other spec files
        // create/delete flows concurrently, so we can't expect a precise value
        // — only that our own flow makes it at least 1.
        expect(result.flows?.count).toBeGreaterThanOrEqual(1);
    });
});
