import { describe, it, expect } from 'vitest';
import { kestraClient, randomId, getSimpleFlowAndId } from './CommonTestSetup.js';

const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

async function createExecutionWithLogs(): Promise<string> {
    const { flowId, flowNamespace, flowBody } = getSimpleFlowAndId();
    await kestraClient.Flows.createFlow({ body: flowBody });

    const exec = await kestraClient.Executions.createExecution({ namespace: flowNamespace, id: flowId });
    const executionId = (exec as any).id;

    const deadline = Date.now() + 10_000;
    while (Date.now() < deadline) {
        const e = await kestraClient.Executions.execution({ executionId });
        const state = (e as any).state?.current;
        if (state === 'SUCCESS' || state === 'FAILED') break;
        await sleep(500);
    }
    return executionId;
}

describe('LogsApi', () => {
    it('searchLogs: returns a paged result', async () => {
        const result = await kestraClient.Logs.searchLogs({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect((result as any).results).toBeDefined();
    });

    it('listLogsFromExecution: returns logs for an execution', async () => {
        const executionId = await createExecutionWithLogs();
        const result = await kestraClient.Logs.listLogsFromExecution({ executionId });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listLogsFromExecution: filters by level', async () => {
        const executionId = await createExecutionWithLogs();
        const result = await kestraClient.Logs.listLogsFromExecution({ executionId, minLevel: 'INFO' });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('downloadLogsFromExecution: downloads logs as a file', async () => {
        const executionId = await createExecutionWithLogs();
        const result = await kestraClient.Logs.downloadLogsFromExecution({ executionId });
        expect(result).toBeDefined();
    });

    it('deleteLogsFromExecution: deletes logs for an execution', async () => {
        const executionId = await createExecutionWithLogs();
        await kestraClient.Logs.deleteLogsFromExecution({ executionId });
    });

    it('deleteLogsFromFlow: deletes logs for a flow trigger', async () => {
        const { flowId, flowNamespace, flowBody } = getSimpleFlowAndId();
        await kestraClient.Flows.createFlow({ body: flowBody });

        const triggerId = randomId();
        await kestraClient.Logs.deleteLogsFromFlow({ namespace: flowNamespace, flowId, triggerId });
    });
});
