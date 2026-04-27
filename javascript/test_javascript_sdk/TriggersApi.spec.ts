// TriggersApi.spec.js
/* eslint-disable jest/no-standalone-expect */

import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup.js';

// --- helpers ---------------------------------------------------------------

const sleep = (ms: number) => new Promise((r) => setTimeout(r, ms));

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
    cron: "*/5 * * * *"
`;

    await kestraClient().Flows.createFlow({ body });
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
        tenantId: MAIN_TENANT,
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

    return kestraClient().Triggers.createBackfill(trigger);
}

// Small helper to assert an API call rejects with a specific HTTP status
async function expectRejectStatus(promise: Promise<any>, expectedStatus: string | number) {
    try {
        await promise;
        throw new Error(`Expected HTTP ${expectedStatus} but request succeeded`);
    } catch (err: any) {
        const status = err?.status ?? err?.response?.status ?? err?.code ?? err?.data?.code;
        expect(status).toBe(expectedStatus);
    }
}

// --- tests ----------------------------------------------------------------

describe('TriggersApiTest', () => {
    it('deleteBackfillTest', async () => {
        const flowId = `deleteBackfillTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        // ensure trigger exists
        await sleep(4000);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().Triggers.deleteBackfill(t);
        expect(resp).toBeTruthy();
    });

    it('deleteBackfillByIdsTest', async () => {
        const flowId = `deleteBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().Triggers.deleteBackfillByIds({ body: [t] });
        expect(resp).toBeTruthy();
    });

    it('deleteBackfillByQueryTest', async () => {
        const flowId = `deleteBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().Triggers.deleteBackfillByQuery({ filters: [{ field: 'TRIGGER_ID', operation: 'CONTAINS', value: flowId as any }] });
        expect(resp).toBeTruthy();
    });

    it('disabledTriggersByIdsTest', async () => {
        const flowId = `disabledTriggersByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const req = { triggers: [t], disabled: true };
        const resp = await kestraClient().Triggers.disabledTriggersByIds(req);
        expect(resp).toBeTruthy();
    });

    it('disabledTriggersByQueryTest', async () => {
        const flowId = `disabledTriggersByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().Triggers.disabledTriggersByQuery({
            disabled: true,
            filters: [{
                field: 'TRIGGER_ID',
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
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().Triggers.pauseBackfill(t);
        expect(resp).toBeTruthy();
    });

    it('pauseBackfillByIdsTest', async () => {
        const flowId = `pauseBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().Triggers.pauseBackfillByIds({ body: [t] });
        expect(resp).toBeTruthy();
    });

    it('pauseBackfillByQueryTest', async () => {
        const flowId = `pauseBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const qf = { field: 'TRIGGER_ID', operation: 'CONTAINS', value: flowId };
        const resp = await kestraClient().Triggers.pauseBackfillByQuery({
            filters: [{
                field: 'TRIGGER_ID',
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

        const resp = await kestraClient().Triggers.restartTrigger({ namespace, flowId, triggerId });
        expect(resp).toBeTruthy();
    });

    it('searchTriggersTest', async () => {
        const flowId = `searchTriggersTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;
        await createFlowWithTrigger(flowId, triggerId, namespace);

        const page = await kestraClient().Triggers.searchTriggers({
            page: 1,
            size: 10,
            filters: [{
                field: 'NAMESPACE',
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

        const page = await kestraClient().Triggers.searchTriggersForFlow({
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

        // Expecting 409 if not locked
        await expectRejectStatus(
            kestraClient().Triggers.unlockTrigger({ namespace, flowId, triggerId }),
            409
        );
    });

    it('unlockTriggersByIdsTest', async () => {
        const flowId = `unlockTriggersByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().Triggers.unlockTriggersByIds({ body: [t] });
        expect(resp).toBeTruthy();
    });

    it('unlockTriggersByQueryTest', async () => {
        const flowId = `unlockTriggersByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().Triggers.unlockTriggersByQuery();
        expect(resp).toBeTruthy();
    });

    it('unpauseBackfillTest', async () => {
        const flowId = `unpauseBackfillTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().Triggers.unpauseBackfill(t);
        expect(resp).toBeTruthy();
    });

    it('unpauseBackfillByIdsTest', async () => {
        const flowId = `unpauseBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().Triggers.unpauseBackfillByIds({ body: [t] });
        expect(resp).toBeTruthy();
    });

    it('unpauseBackfillByQueryTest', async () => {
        const flowId = `unpauseBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().Triggers.unpauseBackfillByQuery();
        expect(resp).toBeTruthy();
    });
});
