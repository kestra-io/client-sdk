// @ts-check
// TriggersApi.spec.js
/* eslint-disable jest/no-standalone-expect */

import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup';

// --- helpers ---------------------------------------------------------------

const sleep = (ms) => new Promise((r) => setTimeout(r, ms));

/** Create a flow via YAML with a single scheduled trigger. */
async function createFlowWithTrigger(flowId, triggerId, namespace) {
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

    await kestraClient().flowsApi.createFlow(MAIN_TENANT, body);
    // give the server a beat to register the trigger
    await sleep(200);
}

/** Build the trigger reference object. */
function triggerRef(namespace, flowId, triggerId) {
    return {
        namespace,
        flowId,
        triggerId,
        date: new Date().toISOString(),
        tenantId: MAIN_TENANT,
    };
}

/** Attach a backfill to a trigger by calling updateTrigger; returns updated Trigger. */
async function createBackfillForTrigger(flowId, triggerId, namespace) {
    const nowIso = new Date().toISOString();
    const startIso = new Date(Date.now() - 5 * 60 * 60 * 1000).toISOString();

    const trigger = {
        namespace,
        flowId,
        triggerId,
        date: nowIso,
        backfill: {
            start: startIso,
            end: null,
        },
        tenantId: MAIN_TENANT,
    };

    return kestraClient().triggersApi.updateTrigger(MAIN_TENANT, trigger);
}

// Small helper to assert an API call rejects with a specific HTTP status
async function expectRejectStatus(promise, expectedStatus) {
    try {
        await promise;
        throw new Error(`Expected HTTP ${expectedStatus} but request succeeded`);
    } catch (err) {
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
        await sleep(1000);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().triggersApi.deleteBackfill(MAIN_TENANT, t);
        expect(resp).toBeTruthy();
    });

    it('deleteBackfillByIdsTest', async () => {
        const flowId = `deleteBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().triggersApi.deleteBackfillByIds(MAIN_TENANT, [t]);
        expect(resp).toBeTruthy();
    });

    it('deleteBackfillByQueryTest', async () => {
        const flowId = `deleteBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().triggersApi.deleteBackfillByQuery(MAIN_TENANT, {filters:[{ field: 'TRIGGER_ID', operation: 'CONTAINS', value: flowId }]});
        expect(resp).toBeTruthy();
    });

    it('disabledTriggersByIdsTest', async () => {
        const flowId = `disabledTriggersByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const req = { triggers: [t], disabled: true };
        const resp = await kestraClient().triggersApi.disabledTriggersByIds(MAIN_TENANT, req);
        expect(resp).toBeTruthy();
    });

    it('disabledTriggersByQueryTest', async () => {
        const flowId = `disabledTriggersByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().triggersApi.disabledTriggersByQuery(true, MAIN_TENANT, {
            filters:[{
                field: 'TRIGGER_ID',
                operation: 'CONTAINS',
                value: flowId
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
        const resp = await kestraClient().triggersApi.pauseBackfill(MAIN_TENANT, t);
        expect(resp).toBeTruthy();
    });

    it('pauseBackfillByIdsTest', async () => {
        const flowId = `pauseBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().triggersApi.pauseBackfillByIds(MAIN_TENANT, [t]);
        expect(resp).toBeTruthy();
    });

    it('pauseBackfillByQueryTest', async () => {
        const flowId = `pauseBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const qf = { field: 'TRIGGER_ID', operation: 'CONTAINS', value: flowId };
        const resp = await kestraClient().triggersApi.pauseBackfillByQuery(MAIN_TENANT, {
            filters:[{
                field: 'TRIGGER_ID',
                operation: 'CONTAINS',
                value: flowId
            }]
        });
        expect(resp).toBeTruthy();
    });

    it('restartTriggerTest', async () => {
        const flowId = `restartTriggerTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().triggersApi.restartTrigger(namespace, flowId, triggerId, MAIN_TENANT);
        expect(resp).toBeTruthy();
    });

    it('searchTriggersTest', async () => {
        const flowId = `searchTriggersTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;
        await createFlowWithTrigger(flowId, triggerId, namespace);

        const page = await kestraClient().triggersApi.searchTriggers(1, 10, MAIN_TENANT, {
            filters:[{
                field: 'NAMESPACE',
                operation: 'EQUALS',
                value: namespace
            }]
        });

        expect(page).toBeTruthy();
    });

    it('searchTriggersForFlowTest', async () => {
        const flowId = `searchTriggersForFlowTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const page = await kestraClient().triggersApi.searchTriggersForFlow(1, 10, namespace, flowId, MAIN_TENANT);
        expect(page).toBeTruthy();
    });

    it('unlockTriggerTest', async () => {
        const flowId = `unlockTriggerTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        // Expecting 409 if not locked
        await expectRejectStatus(
            kestraClient().triggersApi.unlockTrigger(namespace, flowId, triggerId, MAIN_TENANT),
            409
        );
    });

    it('unlockTriggersByIdsTest', async () => {
        const flowId = `unlockTriggersByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().triggersApi.unlockTriggersByIds(MAIN_TENANT, [t]);
        expect(resp).toBeTruthy();
    });

    it('unlockTriggersByQueryTest', async () => {
        const flowId = `unlockTriggersByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().triggersApi.unlockTriggersByQuery(MAIN_TENANT);
        expect(resp).toBeTruthy();
    });

    it('unpauseBackfillTest', async () => {
        const flowId = `unpauseBackfillTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().triggersApi.unpauseBackfill(MAIN_TENANT, t);
        expect(resp).toBeTruthy();
    });

    it('unpauseBackfillByIdsTest', async () => {
        const flowId = `unpauseBackfillByIdsTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);
        await createBackfillForTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().triggersApi.unpauseBackfillByIds(MAIN_TENANT, [t]);
        expect(resp).toBeTruthy();
    });

    it('unpauseBackfillByQueryTest', async () => {
        const flowId = `unpauseBackfillByQueryTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const resp = await kestraClient().triggersApi.unpauseBackfillByQuery(MAIN_TENANT);
        expect(resp).toBeTruthy();
    });

    it('updateTriggerTest', async () => {
        const flowId = `updateTriggerTest_${randomId()}`;
        const triggerId = `${flowId}_trigger`;
        const namespace = `test.triggers.${randomId()}`;

        await createFlowWithTrigger(flowId, triggerId, namespace);

        const t = triggerRef(namespace, flowId, triggerId);
        const resp = await kestraClient().triggersApi.updateTrigger(MAIN_TENANT, t);
        expect(resp).toBeTruthy();
    });
});
