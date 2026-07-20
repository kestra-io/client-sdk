import { describe, it, expect } from 'vitest';
import { randomId, getSimpleFlowAndId } from './_utils.js';
import * as Executions from '@kestra-io/kestra-sdk/executions';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Logs from '@kestra-io/kestra-sdk/logs';

const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

async function createExecutionWithLogs(): Promise<string> {
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
    return executionId;
}

describe('LogsApi', () => {
    it('searchLogs: returns a paged result', async () => {
        const result = await Logs.searchLogs({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect((result as any).results).toBeDefined();
    });

    it('listLogsFromExecution: returns logs for an execution', async () => {
        const executionId = await createExecutionWithLogs();
        const result = await Logs.listLogsFromExecution({ executionId });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listLogsFromExecution: filters by level', async () => {
        const executionId = await createExecutionWithLogs();
        const result = await Logs.listLogsFromExecution({
            executionId, filters: [{
                field: "level",
                operation: "GREATER_THAN_OR_EQUAL_TO",
                value: "INFO"
            }]
        });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('downloadLogsFromExecution: downloads logs as a file', async () => {
        const executionId = await createExecutionWithLogs();
        const result = await Logs.downloadLogsFromExecution({ executionId });
        expect(result).toBeDefined();
    });

    it('deleteLogsFromExecution: deletes logs for an execution', async () => {
        const executionId = await createExecutionWithLogs();
        await Logs.deleteLogsFromExecution({ executionId });
    });

    it('deleteLogsFromFlow: deletes logs for a flow trigger', async () => {
        const { flowId, flowNamespace, flowBody } = getSimpleFlowAndId();
        await Flows.createFlow({ body: flowBody });

        const triggerId = randomId();
        await Logs.deleteLogsFromFlow({ namespace: flowNamespace, flowId, triggerId });
    });
});
