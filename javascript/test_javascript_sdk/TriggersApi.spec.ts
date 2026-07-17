// TriggersApi.spec.js
/* eslint-disable jest/no-standalone-expect */

import { describe, it, expect, beforeAll } from 'vitest';
import { randomId } from './_utils.js';
import { tenantId } from './_setup.js';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Triggers from '@kestra-io/kestra-sdk/triggers';

// --- helpers ---------------------------------------------------------------

const sleep = (ms: number) => new Promise((r) => setTimeout(r, ms));

/**
 * Before all tests, delete any flows with namespaces starting with "test.triggers." to ensure a clean slate.
 * Makes the tests less flaky on local machines
 */
beforeAll(async () => {
    // Delete all flows whose namespace starts with "test.triggers." to ensure a clean slate for the tests.
    const res = await Flows.deleteFlowsByQuery({
        filters: [{
            field: 'namespace',
            operation: 'STARTS_WITH',
            value: 'test.triggers.' as any
        }],
    });
    if (res) {
        console.log(`Deleted ${res.count} flows with namespace starting with 'test.triggers.'`);
    }
});

/** Create a flow via YAML with a single scheduled trigger. */
async function createFlowWithTrigger(flowId: string, triggerId: string, namespace: string) {
    const body =
        `id: ${flowId}
namespace: ${namespace}

tasks:
  - id: hello
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT5S

triggers:
  - id: ${triggerId}
    type: io.kestra.plugin.core.trigger.Schedule
    cron: "* * * * *"
`;

    await Flows.createFlow({ body });
    // give the server a beat to register the trigger
    await sleep(200);
}

/** Build the trigger reference object. */
function triggerRef(namespace: string, flowId: string, triggerId: string) {
    return {
        namespace,
        flowId,
        triggerId,
        date: new Date().toISOString(),
        tenantId: tenantId,
    };
}

/** Attach a backfill to a trigger by calling updateTrigger; returns updated Trigger. */
async function createBackfillForTrigger(flowId: string, triggerId: string, namespace: string) {
    const nowIso = new Date().toISOString();
    const startIso = new Date(Date.now() - 5 * 60 * 60 * 1000).toISOString();

    const trigger = {
        namespace,
        flowId,
        triggerId,
        date: nowIso,
        backfill: {
            start: startIso,
            end: undefined,
        },
    };

    return Triggers.createBackfill(trigger);
}

async function ensureTriggerExists(namespace: string, flowId: string, triggerId: string) {
    const maxRetries = 4;
    const delayMs = 1000;

    for (let i = 0; i < maxRetries; i++) {
        if (i > 0) await sleep(delayMs);
        try {
            const page = await Triggers.searchTriggersForFlow({
                page: 1,
                size: 10,
                namespace,
                flowId,
            });
            const results = page?.results ?? (Array.isArray(page) ? page : []);
            if (results.length > 0) {
                // Check by triggerId field or id field
                const found = results.find((t: any) =>
                    t.triggerId === triggerId || t.id === triggerId || t.trigger?.id === triggerId
                );
                if (found) return false;
            }
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if (status === 404) {
                // Not found, will retry
            } else {
                throw err;
            }
        }
    }
    return `Trigger '${triggerId}' for flow '${namespace}.${flowId}' was not found after ${maxRetries} retries`
}


describe('TriggersApiTest', () => {
    it('deleteBackfillTest', async () => {
        const flowId = `deleteBackfillTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        expect(await ensureTriggerExists(namespace, flowId, triggerId)).toBeFalsy();

        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await Triggers.deleteBackfill(t);
        expect(resp).toBeTruthy();
    });

    it('deleteBackfillByIdsTest', async () => {
        const flowId = `deleteBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await Triggers.deleteBackfillByIds({ body: [t] });
        expect(resp).toBeTruthy();
    }, 120000);

    it('deleteBackfillByQueryTest', async () => {
        const flowId = `deleteBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        await createBackfillForTrigger(flowId, triggerId, namespace);

        const resp = await Triggers.deleteBackfillByQuery({ filters: [{ field: 'triggerId', operation: 'CONTAINS', value: flowId as any }] });
        expect(resp).toBeTruthy();
    }, 120000);

    it('disabledTriggersByIdsTest', async () => {
        const flowId = `disabledTriggersByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const req = { triggers: [t], disabled: true };
        const resp = await Triggers.disabledTriggersByIds(req);
        expect(resp).toBeTruthy();
    });

    it('disabledTriggersByQueryTest', async () => {
        const flowId = `disabledTriggersByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await Triggers.disabledTriggersByQuery({
            disabled: true,
            filters: [{
                field: 'triggerId',
                operation: 'CONTAINS',
                value: flowId as any
            }]
        });
        expect(resp).toBeTruthy();
    });

    it('pauseBackfillTest', async () => {
        const flowId = `pauseBackfillTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await Triggers.pauseBackfill(t);
        expect(resp).toBeTruthy();
    }, 120000);

    it('pauseBackfillByIdsTest', async () => {
        const flowId = `pauseBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await Triggers.pauseBackfillByIds({ body: [t] });
        expect(resp).toBeTruthy();
    }, 120000);

    it('pauseBackfillByQueryTest', async () => {
        const flowId = `pauseBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const qf = { field: 'triggerId', operation: 'CONTAINS', value: flowId };
        const resp = await Triggers.pauseBackfillByQuery({
            filters: [{
                field: 'triggerId',
                operation: 'CONTAINS',
                value: flowId as any
            }]
        });
        expect(resp).toBeTruthy();
    });

    it('restartTriggerTest', async () => {
        const flowId = `restartTriggerTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        const resp = await Triggers.restartTrigger({ namespace, flowId, triggerId });
        expect(resp).toBeTruthy();
    }, 120000);

    it('searchTriggersTest', async () => {
        const flowId = `searchTriggersTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;
        await createFlowWithTrigger(flowId, triggerId, namespace);

        const page = await Triggers.searchTriggers({
            page: 1,
            size: 10,
            filters: [{
                field: 'namespace',
                operation: 'EQUALS',
                value: namespace as any
            }]
        });

        expect(page).toBeTruthy();
    });

    it('searchTriggersForFlowTest', async () => {
        const flowId = `searchTriggersForFlowTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const page = await Triggers.searchTriggersForFlow({
            page: 1,
            size: 10,
            namespace,
            flowId,
        });
        expect(page).toBeTruthy();
    });

    it('unlockTriggerTest', async () => {
        const flowId = `unlockTriggerTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        // Expecting 409 if not locked
        try {
            await Triggers.unlockTrigger({ namespace, flowId, triggerId });
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if (status === 409) return;
            throw err;
        }
    }, 120000);

    it('unlockTriggersByIdsTest', async () => {
        const flowId = `unlockTriggersByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await Triggers.unlockTriggersByIds({ body: [t] });
        expect(resp).toBeTruthy();
    }, 120000);

    it('unlockTriggersByQueryTest', async () => {
        const flowId = `unlockTriggersByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await Triggers.unlockTriggersByQuery();
        expect(resp).toBeTruthy();
    });

    it('unpauseBackfillTest', async () => {
        const flowId = `unpauseBackfillTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await Triggers.unpauseBackfill(t);
        expect(resp).toBeTruthy();
    }, 120000);

    it('unpauseBackfillByIdsTest', async () => {
        const flowId = `unpauseBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await Triggers.unpauseBackfillByIds({ body: [t] });
        expect(resp).toBeTruthy();
    }, 120000);

    it('unpauseBackfillByQueryTest', async () => {
        const flowId = `unpauseBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await Triggers.unpauseBackfillByQuery();
        expect(resp).toBeTruthy();
    });

    it('disableTriggerByIdTest', async () => {
        const flowId = `disableTriggerByIdTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        // Disable, then re-enable, asserting the persisted state flips each way.
        const disabled = await Triggers.disableTriggerById({ namespace, flowId, triggerId, disabled: true });
        expect(disabled.disabled).toBe(true);
        expect(disabled.namespace).toBe(namespace);
        expect(disabled.flowId).toBe(flowId);
        expect(disabled.triggerId).toBe(triggerId);

        const enabled = await Triggers.disableTriggerById({ namespace, flowId, triggerId, disabled: false });
        expect(enabled.disabled).toBe(false);
    }, 120000);

    it('deleteTriggerTest', async () => {
        const flowId = `deleteTriggerTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        expect(await ensureTriggerExists(namespace, flowId, triggerId)).toBeFalsy();

        // Persist a non-default (disabled) trigger context so the delete has something to reset.
        const disabled = await Triggers.disableTriggerById({ namespace, flowId, triggerId, disabled: true });
        expect(disabled.disabled).toBe(true);

        await Triggers.deleteTrigger({ namespace, flowId, triggerId });

        // With the context removed, the trigger is rebuilt from the flow definition,
        // so the disabled flag is back to its default (non-disabled) value.
        const page = await Triggers.searchTriggersForFlow({ page: 1, size: 10, namespace, flowId });
        const results = page?.results ?? (Array.isArray(page) ? page : []);
        const found = results.find((t: any) => t.triggerId === triggerId || t.id === triggerId || t.trigger?.id === triggerId);
        expect(found?.disabled ?? false).toBe(false);
    }, 120000);

    it('deleteTriggersByIdsTest', async () => {
        const flowId = `deleteTriggersByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        // Asynchronous bulk operation: assert the operation response is returned
        // (mirrors the Java SDK suite, which only checks reachability here).
        const resp = await Triggers.deleteTriggersByIds({ body: [{ namespace, flowId, triggerId }] });
        expect(resp).toBeDefined();
        expect(typeof resp).toBe('object');
    }, 120000);

    it('deleteTriggersByQueryTest', async () => {
        const flowId = `deleteTriggersByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await Triggers.deleteTriggersByQuery({
            filters: [{ field: 'namespace', operation: 'EQUALS', value: namespace as any }],
        });
        expect(resp).toBeDefined();
        expect(typeof resp).toBe('object');
    }, 120000);

    it('exportTriggersTest', async () => {
        const flowId = `exportTriggersTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        // Register a trigger so the CSV export has at least one row to emit.
        await createFlowWithTrigger(flowId, triggerId, namespace);
        await ensureTriggerExists(namespace, flowId, triggerId);

        const csv = await Triggers.exportTriggers() as unknown as string | string[];
        const text = typeof csv === 'string' ? csv : Array.isArray(csv) ? csv.join('\n') : String(csv);
        expect(text.length).toBeGreaterThan(0);
    }, 120000);
});
