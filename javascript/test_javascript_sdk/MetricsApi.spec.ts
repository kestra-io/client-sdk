import { describe, it, expect } from 'vitest';
import { randomId, getSimpleFlowAndId } from './_utils.js';
import * as Executions from '@kestra-io/kestra-sdk/executions';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Metrics from '@kestra-io/kestra-sdk/metrics';

const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

async function createFlowAndWaitForExecution(): Promise<{ namespace: string; flowId: string; executionId: string }> {
    const { flowId, flowNamespace, flowBody } = getSimpleFlowAndId();
    await Flows.createFlow({ body: flowBody });

    const exec = await Executions.createExecution({ namespace: flowNamespace, id: flowId, wait: true });
    const executionId = (exec as any).id;

    const deadline = Date.now() + 10_000;
    while (Date.now() < deadline) {
        try {
            const e = await Executions.execution({ executionId });
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
        const result = await Metrics.listFlowMetrics({ namespace, flowId });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listTaskMetrics: lists metrics names for a task', async () => {
        const { namespace, flowId } = await createFlowAndWaitForExecution();
        const result = await Metrics.listTaskMetrics({ namespace, flowId, taskId: 'my_task_1_id' });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listTasksWithMetrics: lists task ids that have metrics', async () => {
        const { namespace, flowId } = await createFlowAndWaitForExecution();
        const result = await Metrics.listTasksWithMetrics({ namespace, flowId });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('searchByExecution: gets metrics for an execution', async () => {
        const { executionId } = await createFlowAndWaitForExecution();
        const result = await Metrics.searchByExecution({ executionId });
        expect(result).toBeDefined();
    });

    it('aggregateMetricsFromFlow: aggregates metrics for a flow', async () => {
        const { namespace, flowId } = await createFlowAndWaitForExecution();
        const result = await Metrics.aggregateMetricsFromFlow({
            namespace,
            flowId,
            metric: randomId(),
        });
        expect(result).toBeDefined();
    });

    it('aggregateMetricsFromTask: aggregates metrics for a task', async () => {
        const { namespace, flowId } = await createFlowAndWaitForExecution();
        const result = await Metrics.aggregateMetricsFromTask({
            namespace,
            flowId,
            taskId: 'my_task_1_id',
            metric: randomId(),
        });
        // A random (non-existent) metric name yields zero-valued date buckets, not an empty array.
        expect(Array.isArray(result.aggregations)).toBe(true);
        result.aggregations.forEach((agg: any) => expect(agg.value).toBe(0));
    });
});
