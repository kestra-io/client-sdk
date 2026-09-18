import { describe, it, expect } from 'vitest';
import { randomId, getExecutableFlowAndId, waitForExecutionSuccess } from './_utils.js';
import * as Executions from '@kestra-io/kestra-sdk/executions';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Outputs from '@kestra-io/kestra-sdk/outputs';

async function createExecutionAndWait(): Promise<{ executionId: string }> {
    const { flowId, flowNamespace, flowBody } = getExecutableFlowAndId();
    await Flows.createFlow({ body: flowBody });

    const exec = await Executions.createExecution({ namespace: flowNamespace, id: flowId, wait: true });
    const executionId = (exec as any).id;

    await waitForExecutionSuccess(executionId);
    return { executionId };
}

/**
 * A flow declaring a flow-level `outputs:` block so `executionOutputs` returns a
 * concrete value to assert on. `getExecutableFlowAndId` declares no flow outputs,
 * which would leave the endpoint returning an empty map.
 */
async function createExecutionWithFlowOutput(): Promise<{ executionId: string }> {
    const flowId = randomId();
    const namespace = randomId();
    const flowBody = `id: ${flowId}
namespace: ${namespace}

tasks:
  - id: produce
    type: io.kestra.plugin.core.debug.Return
    format: hello_world

outputs:
  - id: greeting
    type: STRING
    value: "{{ outputs.produce.value }}"
`;
    await Flows.createFlow({ body: flowBody });

    const exec = await Executions.createExecution({ namespace, id: flowId, wait: true });
    const executionId = (exec as any).id;

    await waitForExecutionSuccess(executionId);
    return { executionId };
}

describe('OutputsApi', () => {
    it('executionOutputs: returns the flow-level outputs of an execution', async () => {
        const { executionId } = await createExecutionWithFlowOutput();
        const result = await Outputs.executionOutputs({ executionId });
        // The flow declares a `greeting` output resolved from the Return task.
        expect(result.greeting).toBe('hello_world');
    });

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
