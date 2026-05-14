import { describe, it, expect } from 'vitest';
import { kestraClient, randomId, getSimpleFlowAndId } from './CommonTestSetup.js';

const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

async function createFlowAndWaitForExecution(): Promise<{ namespace: string; flowId: string; executionId: string }> {
    const { flowId, flowNamespace, flowBody } = getSimpleFlowAndId();
    await kestraClient.Flows.createFlow({ body: flowBody });

    const exec = await kestraClient.Executions.createExecution({ namespace: flowNamespace, id: flowId, wait: true });
    const executionId = (exec as any).id;

    const deadline = Date.now() + 10_000;
    while (Date.now() < deadline) {
        try {
            const e = await kestraClient.Executions.execution({ executionId });
            const state = (e as any).state?.current;
            if (state === 'SUCCESS' || state === 'FAILED') break;
        } catch (_) { /* execution may not be in DB yet */ }
        await sleep(500);
    }
    return { namespace: flowNamespace, flowId, executionId };
}

describe('MetricsApi', () => {
    it('listFlowMetrics: lists metrics names for a flow', async () => {
        const { namespace, flowId } = await createFlowAndWaitForExecution();
        const result = await kestraClient.Metrics.listFlowMetrics({ namespace, flowId });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listTaskMetrics: lists metrics names for a task', async () => {
        const { namespace, flowId } = await createFlowAndWaitForExecution();
        const result = await kestraClient.Metrics.listTaskMetrics({ namespace, flowId, taskId: 'my_task_1_id' });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listTasksWithMetrics: lists task ids that have metrics', async () => {
        const { namespace, flowId } = await createFlowAndWaitForExecution();
        const result = await kestraClient.Metrics.listTasksWithMetrics({ namespace, flowId });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('searchByExecution: gets metrics for an execution', async () => {
        const { executionId } = await createFlowAndWaitForExecution();
        const result = await kestraClient.Metrics.searchByExecution({ executionId });
        expect(result).toBeDefined();
    });

    it('aggregateMetricsFromFlow: aggregates metrics for a flow', async () => {
        const { namespace, flowId } = await createFlowAndWaitForExecution();
        const result = await kestraClient.Metrics.aggregateMetricsFromFlow({
            namespace,
            flowId,
            metric: randomId(),
        });
        expect(result).toBeDefined();
    });
});
