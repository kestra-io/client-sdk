import { describe, it, expect } from 'vitest';
import { getSimpleFlowAndId, waitForExecutionSuccess } from './_utils.js';
import * as Executions from '@kestra-io/kestra-sdk/executions';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Outputs from '@kestra-io/kestra-sdk/outputs';

async function createExecutionAndWait(): Promise<{ executionId: string }> {
    const { flowId, flowNamespace, flowBody } = getSimpleFlowAndId();
    await Flows.createFlow({ body: flowBody });

    const exec = await Executions.createExecution({ namespace: flowNamespace, id: flowId, wait: true });
    const executionId = (exec as any).id;

    await waitForExecutionSuccess(executionId);
    return { executionId };
}

describe('OutputsApi', () => {
    it('taskOutputsInformation: returns outputs information for an execution', async () => {
        const { executionId } = await createExecutionAndWait();
        const result = await Outputs.taskOutputsInformation({ executionId });
        expect(result).toBeDefined();
    });

    it('taskRunOutputs: returns outputs for a specific task run', async () => {
        const { executionId } = await createExecutionAndWait();

        const execution = await Executions.execution({ executionId });
        const taskRuns = (execution as any).taskRunList ?? [];
        if (taskRuns.length === 0) return;

        const taskRunId = taskRuns[0].id;
        const result = await Outputs.taskRunOutputs({ executionId, taskRunId });
        expect(result).toBeDefined();
    });
});
