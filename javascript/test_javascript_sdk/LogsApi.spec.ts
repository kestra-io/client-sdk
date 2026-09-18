import { describe, it, expect } from 'vitest';
import { randomId, getExecutableFlowAndId, getSimpleFlowAndId, waitForExecutionSuccess } from './_utils.js';
import * as Executions from '@kestra-io/kestra-sdk/executions';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Logs from '@kestra-io/kestra-sdk/logs';

async function createExecutionWithLogs(): Promise<string> {
    const { flowId, flowNamespace, flowBody } = getExecutableFlowAndId();
    await Flows.createFlow({ body: flowBody });

    const exec = await Executions.createExecution({ namespace: flowNamespace, id: flowId, wait: true });
    const executionId = (exec as any).id;

    await waitForExecutionSuccess(executionId);
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

    it('followLogsFromExecution: streams logs for an execution over SSE', async () => {
        const flowId = randomId();
        const namespace = randomId();
        const flowBody = `id: ${flowId}
namespace: ${namespace}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello from followLogs
`;
        await Flows.createFlow({ body: flowBody });

        // Don't wait — follow the logs live as the execution runs, mirroring the
        // follow_execution SSE test in ExecutionsApi.spec.ts.
        const exec = await Executions.createExecution({ namespace, id: flowId });
        const executionId = (exec as any).id;

        // Safety net: if the stream never closes on its own, abort after 20s so
        // the Vitest worker isn't killed with an open TCP connection.
        const ac = new AbortController();
        const abortTimer = setTimeout(() => ac.abort(), 20000);

        const { stream } = await Logs.followLogsFromExecution({ executionId }, { signal: ac.signal });

        const messages: string[] = [];
        try {
            for await (const evt of stream) {
                if (evt.message) messages.push(evt.message);
            }
        } catch {
            // AbortError if the 20s safety timer fired — proceed with what we have.
        } finally {
            clearTimeout(abortTimer);
        }

        expect(messages.some((m) => m.includes('Hello from followLogs'))).toBe(true);
    }, 25000);

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
