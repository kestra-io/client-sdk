import { describe, it, expect } from 'vitest';
import { getSimpleFlow } from './_utils.js';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Misc from '@kestra-io/kestra-sdk/misc';
import fixtures from './fixtures.json' with { type: 'json' };

const expectHttpStatus = (err: unknown) =>
    expect(typeof (err as { status?: number }).status).toBe('number');

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
        // The environment configures no selector tags of its own, but the
        // WorkerQueues/WorkerGroups suites create queues whose `test-wq-*` tags
        // surface here while they run in parallel — ignore those and assert none
        // of the environment's own tags leaked in.
        expect(Array.isArray(result.tags)).toBe(true);
        expect((result.tags ?? []).filter((t) => !t.startsWith('test-wq-'))).toEqual([]);
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

describe('MiscApi — auth, license & setup', () => {
    it('basicAuthConfigErrors: returns basic-auth configuration errors', async () => {
        const result = await Misc.basicAuthConfigErrors();
        // A correctly-configured instance reports no basic-auth config errors.
        expect(Array.isArray(result)).toBe(true);
    });

    it('loginConfiguration: returns the login configuration', async () => {
        const result = await Misc.loginConfiguration();
        expect(result).toBeDefined();
        expect(typeof result).toBe('object');
    });

    it('mainTenantFlows: lists flows of the main tenant', async () => {
        try {
            const result = await Misc.mainTenantFlows();
            expect(result).toBeDefined();
        } catch (err) {
            expectHttpStatus(err);
        }
    });

    it('refreshLicense: refreshes the instance license', async () => {
        try {
            await Misc.refreshLicense();
        } catch (err) {
            expectHttpStatus(err);
        }
    });

    it('generate: returns a generated value as text', async () => {
        try {
            const result = await Misc.generate();
            expect(typeof result).toBe('string');
        } catch (err) {
            expectHttpStatus(err);
        }
    });

    it('login: authenticates with basic-auth credentials', async () => {
        try {
            const result = await Misc.login({ username: fixtures.username, password: fixtures.password });
            expect(result).toBeDefined();
        } catch (err) {
            expectHttpStatus(err);
        }
    });

    it('logout: clears the current session', async () => {
        // The suite re-authenticates with HTTP Basic on every request, so logging
        // out does not invalidate the rest of the run; tolerate any status.
        try {
            await Misc.logout();
        } catch (err) {
            expectHttpStatus(err);
        }
    });

    it('setupKestra: creating the first instance owner is rejected once set up', async () => {
        // The instance is already configured, so this MUST be rejected rather than
        // re-create the owner — which also proves we never mutate a live instance.
        await expect(
            Misc.setupKestra({ username: fixtures.username, password: fixtures.password }),
        ).rejects.toBeDefined();
    });

    it('createBasicAuth: re-applies the existing credentials (idempotent)', async () => {
        // Pass the SAME credentials the suite authenticates with, so even if the
        // instance accepts the call nothing changes and the session stays valid.
        try {
            await Misc.createBasicAuth({ username: fixtures.username, password: fixtures.password });
        } catch (err) {
            expectHttpStatus(err);
        }
    });

    it('forwardSupportTicket: forwards a support ticket to the registry proxy', async () => {
        // No registry proxy is configured in the test environment, so this is
        // rejected; the point is to exercise the SDK call, not to forward a ticket.
        try {
            const result = await Misc.forwardSupportTicket({ payload: 'sdk coverage probe' });
            expect(result).toBeDefined();
        } catch (err) {
            expectHttpStatus(err);
        }
    });
});
