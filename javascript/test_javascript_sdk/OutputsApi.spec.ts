import { describe, it, expect } from 'vitest';
import { kestraClient, getSimpleFlowAndId } from './CommonTestSetup.js';

const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

async function createExecutionAndWait(): Promise<{ executionId: string }> {
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
    return { executionId };
}

describe('OutputsApi', () => {
    it('taskOutputsInformation: returns outputs information for an execution', async () => {
        const { executionId } = await createExecutionAndWait();
        const result = await kestraClient.Outputs.taskOutputsInformation({ executionId });
        expect(result).toBeDefined();
    });

    it('taskRunOutputs: returns outputs for a specific task run', async () => {
        const { executionId } = await createExecutionAndWait();

        const execution = await kestraClient.Executions.execution({ executionId });
        const taskRuns = (execution as any).taskRunList ?? [];
        if (taskRuns.length === 0) return;

        const taskRunId = taskRuns[0].id;
        const result = await kestraClient.Outputs.taskRunOutputs({ executionId, taskRunId });
        expect(result).toBeDefined();
    });
});
