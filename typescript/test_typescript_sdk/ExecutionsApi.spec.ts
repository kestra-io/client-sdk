// ExecutionsApi.spec.js
import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup';

// ---------- Flow YAML templates ----------
const FAILED_FLOW = (id: string, ns: string) => `
id: ${id}
namespace: ${ns}

tasks:
  - id: fail
    type: io.kestra.plugin.core.execution.Fail
`;

const SLEEP_CONCURRENCY_FLOW = (id: string, ns: string) => `
id: ${id}
namespace: ${ns}

concurrency:
  behavior: QUEUE
  limit: 1

tasks:
  - id: sleep
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT2S
`;

const FILE_FLOW = (id: string, ns: string) => `
id: ${id}
namespace: ${ns}

tasks:
  - id: write
    type: io.kestra.plugin.core.storage.Write
    content: "Hello from file"
    extension: .txt
`;

const LOG_FLOW = (id: string, ns: string) => `
id: ${id}
namespace: ${ns}

inputs:
  - id: key
    type: STRING
    defaults: 'empty'

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
`;

const PAUSE_FLOW = (id: string, ns: string) => `
id: ${id}
namespace: ${ns}

tasks:
  - id: pause_flow
    type: io.kestra.plugin.core.flow.Pause
    delay: PT2S
`;

const WEBHOOK_FLOW = (id: string, ns: string) => `
id: ${id}
namespace: ${ns}

tasks:
  - id: out
    type: io.kestra.plugin.core.debug.Return
    format: "{{trigger | json }}"

triggers:
  - id: webhook
    type: io.kestra.plugin.core.trigger.Webhook
    key: a-secret-key
`;

// ---------- helpers ----------
const sleep = (ms: number) => new Promise((r) => setTimeout(r, ms));

async function createFlow(flowYaml: string) {
    const created = await kestraClient().flowsApi.createFlow({
        tenant: MAIN_TENANT,
        body: flowYaml,
    });
    await sleep(200);
    return created;
}

async function createSimpleFlow(flowId, ns, tmpl = LOG_FLOW) {
    return createFlow(tmpl(flowId, ns));
}

async function createFlowWithExecution(flowId, ns) {
    await createSimpleFlow(flowId, ns);
    return kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, null, null, null, null, null);
}

async function createFlowWithExecutionFromYaml(flowYaml) {
    const f = await createFlow(flowYaml);
    return kestraClient().executionsApi.createExecution(f.namespace, f.id, false, MAIN_TENANT, null, null, null, null, null);
}

async function awaitExecution(executionId, desiredState, timeoutMs = 5000, pollMs = 100) {
    const start = Date.now();
    let last;
    // eslint-disable-next-line no-constant-condition
    while (true) {
        last = await kestraClient().executionsApi.execution(executionId, MAIN_TENANT);
        if (last?.state?.current === desiredState) return last;
        if (Date.now() - start > timeoutMs) return last;
        await sleep(pollMs);
    }
}

async function createdExecution(flowTemplate, desiredState) {
    const ns = randomId();
    const id = randomId();
    const ex = await createFlowWithExecutionFromYaml(flowTemplate(id, ns));
    return await awaitExecution(ex.id, desiredState, 3000, 100);
}

// filters
const qf = ({ field, operation, value }) => ({ field, operation, value });
const QF_FIELD = {
    NAMESPACE: 'NAMESPACE',
    FLOW_ID: 'FLOW_ID',
    QUERY: 'QUERY',
};
const QF_OP = {
    EQUALS: 'EQUALS',
    IN: 'IN',
};

// ---------- tests ----------
describe('ExecutionsApi', () => {
    it('create_execution', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns);

        const labels = ['label1:created'];
        const inputs = { key: 'value' };

        const resp = await kestraClient().executionsApi.createExecution(
            ns, flowId, false, MAIN_TENANT, {"labels": labels, "kinds": 'NORMAL'}, inputs
        );

        expect(resp.flowId).toBe(flowId);
        expect(resp.namespace).toBe(ns);
        const lbls = resp.labels ?? [];
        expect(lbls.some(l => l.key === 'label1' && l.value === 'created')).toBe(true);
    });

    // --- delete execution (single) ---
    it('delete_execution', async () => {
        const ns = randomId();
        const flowId = randomId();
        const ex = await createFlowWithExecution(flowId, ns);

        await kestraClient().executionsApi.deleteExecution(ex.id, MAIN_TENANT, false, false, false);

        await expect(kestraClient().executionsApi.execution(ex.id, MAIN_TENANT)).rejects.toThrow();
    });

    // --- delete executions by ids ---
    it('delete_executions_by_ids', async () => {
        const ns = randomId();
        const flowId = randomId();
        const e1 = await createFlowWithExecution(flowId, ns);
        const e2 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        const e3 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);

        const resp = await kestraClient().executionsApi.deleteExecutionsByIds(
            MAIN_TENANT, [e1.id, e3.id], {includeNonTerminated: true, deleteLogs: false, deleteMetrics: false, deleteStorage: false});
        expect(resp.count).toBe(2);

        await expect(kestraClient().executionsApi.execution(e1.id, MAIN_TENANT)).rejects.toThrow();
        await expect(kestraClient().executionsApi.execution(e3.id, MAIN_TENANT)).rejects.toThrow();
        expect(await kestraClient().executionsApi.execution(e2.id, MAIN_TENANT)).toBeTruthy();
    });

    // --- delete executions by query ---
    it('delete_executions_by_query', async () => {
        const ns1 = randomId();
        const flow1 = randomId();
        const a = await createFlowWithExecution(flow1, ns1);
        const b = await kestraClient().executionsApi.createExecution(ns1, flow1, false, MAIN_TENANT, {}, null);

        const ns2 = randomId();
        const flow2 = randomId();
        await createFlowWithExecution(flow2, ns2);

        const filters = [qf({ field: QF_FIELD.NAMESPACE, operation: QF_OP.EQUALS, value: ns1 })];
        const resp = await kestraClient().executionsApi.deleteExecutionsByQuery(
            MAIN_TENANT, {filters: filters, includeNonTerminated: true, deleteLogs: false, deleteMetrics: false, deleteStorage: false});
        expect(resp.count).toBe(2);

        await expect(kestraClient().executionsApi.execution(a.id, MAIN_TENANT)).rejects.toThrow();
        await expect(kestraClient().executionsApi.execution(b.id, MAIN_TENANT)).rejects.toThrow();
    });

    // --- download file from execution ---
    it('download_file_from_execution', async () => {
        const ns = randomId();
        const flowId = randomId();
        const done = await (async () => {
            const e = await createFlowWithExecutionFromYaml(FILE_FLOW(flowId, ns));
            return await awaitExecution(e.id, 'SUCCESS', 5000, 100);
        })();

        const uri = done?.taskRunList?.[0]?.outputs?.uri;
        expect(uri).toBeTruthy();

        const file = await kestraClient().executionsApi.downloadFileFromExecution(done.id, uri, MAIN_TENANT);
        // depending on generator, this might be a Buffer/string/file path.
        const txt = file?.text ?? file?.content ?? file;
        expect(String(txt)).toContain('Hello from file');
    });

    // --- force run by ids ---
    it('force_run_by_ids', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(running.id, 'RUNNING', 1500, 100);

        const queued = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(queued.id, 'QUEUED', 1500, 100);

        const bulk = await kestraClient().executionsApi.forceRunByIds(MAIN_TENANT, [queued.id]);
        expect(bulk.count).toBe(1);

        const after = await awaitExecution(queued.id, 'RUNNING', 1500, 100);
        expect(after.state.current).toBe('RUNNING');
    });

    // --- force run execution (single) ---
    it('force_run_execution', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(running.id, 'RUNNING', 1500, 100);

        const queued = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(queued.id, 'QUEUED', 1500, 100);

        const resp = await kestraClient().executionsApi.forceRunExecution(queued.id, MAIN_TENANT);
        const after = await awaitExecution(resp.id, 'RUNNING', 1500, 100);
        expect(after.state.current).toBe('RUNNING');
    });

    // --- force run by query ---
    it('force_run_by_query', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const e1 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(e1.id, 'RUNNING', 1500, 100);
        const e2 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(e2.id, 'QUEUED', 1500, 100);

        const filters = [qf({ field: QF_FIELD.FLOW_ID, operation: QF_OP.EQUALS, value: flowId })];
        const resp = await kestraClient().executionsApi.forceRunExecutionsByQuery(MAIN_TENANT, {filters: filters});
        expect(resp.count).toBeGreaterThanOrEqual(1);

        const after = await awaitExecution(e2.id, 'RUNNING', 1500, 100);
        expect(after.state.current).toBe('RUNNING');
    });

    // --- get execution ---
    it('get_execution', async () => {
        const ns = randomId();
        const flowId = randomId();
        const ex = await createFlowWithExecution(flowId, ns);

        const fetched = await kestraClient().executionsApi.execution(ex.id, MAIN_TENANT);
        expect(fetched.id).toBe(ex.id);
    });

    // --- execution flow graph ---
    it('execution_flow_graph', async () => {
        const ns = randomId();
        const flowId = randomId();
        const ex = await createFlowWithExecution(flowId, ns);

        const graph = await kestraClient().executionsApi.executionFlowGraph(ex.id, MAIN_TENANT, null);
        expect(graph).toBeTruthy();
    });

    // --- file metadata from execution ---
    it('file_metadatas_from_execution', async () => {
        const ns = randomId();
        const flowId = randomId();
        const done = await (async () => {
            const e = await createFlowWithExecutionFromYaml(FILE_FLOW(flowId, ns));
            return await awaitExecution(e.id, 'SUCCESS', 5000, 100);
        })();

        const uri = done?.taskRunList?.[0]?.outputs?.uri;
        const metas = await kestraClient().executionsApi.fileMetadatasFromExecution(done.id, uri, MAIN_TENANT);
        expect([15, 16]).toContain(metas.size);
    });

    // --- flow from execution ---
    it('flow_from_execution_by_id', async () => {
        const ns = randomId();
        const flowId = randomId();
        const done = await (async () => {
            const e = await createFlowWithExecutionFromYaml(FILE_FLOW(flowId, ns));
            return await awaitExecution(e.id, 'SUCCESS', 5000, 100);
        })();

        const flow = await kestraClient().executionsApi.flowFromExecutionById(done.id, MAIN_TENANT);
        expect(flow.id).toBe(flowId);
        expect(flow.namespace).toBe(ns);
    });

    // --- latest executions ---
    it('latest_executions', async () => {
        const ns = randomId();
        const flowA = randomId();
        const first = await (async () => {
            const e = await createFlowWithExecutionFromYaml(FILE_FLOW(flowA, ns));
            await awaitExecution(e.id, 'SUCCESS', 5000, 100);
            return e;
        })();
        // another run of A to ensure “latest” changes
        const secondA = await kestraClient().executionsApi.createExecution(ns, flowA, false, MAIN_TENANT);
        const flowB = randomId();
        const b = await (async () => {
            const e = await createFlowWithExecutionFromYaml(FILE_FLOW(flowB, ns));
            return await awaitExecution(e.id, 'SUCCESS', 5000, 100);
        })();

        const filters = [
            { id: flowA, namespace: ns },
            { id: flowB, namespace: ns },
        ];
        const list = await kestraClient().executionsApi.latestExecutions(MAIN_TENANT, filters);
        expect(Array.isArray(list)).toBe(true);
        expect(list.length).toBe(2);
        const ids = list.map(x => x.id);
        expect(ids).toContain(secondA.id);
        expect(ids).toContain(b.id);
    });

    // --- kill execution (single) ---
    it('kill_execution', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const e = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await sleep(200);
        await kestraClient().executionsApi.killExecution(e.id, true, MAIN_TENANT);

        const killed = await awaitExecution(e.id, 'KILLED', 2000, 100);
        expect(killed.state.current).toBe('KILLED');
    });

    // --- kill by ids ---
    it('kill_executions_by_ids', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const e1 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        const e2 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        const e3 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);

        const bulk = await kestraClient().executionsApi.killExecutionsByIds(MAIN_TENANT, [e2.id, e3.id]);
        expect(bulk.count).toBe(2);

        const s2 = await awaitExecution(e2.id, 'KILLED', 2000, 100);
        const s3 = await awaitExecution(e3.id, 'KILLED', 2000, 100);
        expect(s2.state.current).toBe('KILLED');
        expect(s3.state.current).toBe('KILLED');

        const s1 = await awaitExecution(e1.id, 'SUCCESS', 4000, 100);
        expect(s1.state.current).toBe('SUCCESS');
    });

    // --- kill by query ---
    it('kill_executions_by_query', async () => {
        const ns = randomId();
        const flow1 = randomId();
        const flow2 = randomId();
        await createSimpleFlow(flow1, ns, SLEEP_CONCURRENCY_FLOW);
        await createSimpleFlow(flow2, ns, SLEEP_CONCURRENCY_FLOW);

        const a = await kestraClient().executionsApi.createExecution(ns, flow1, false, MAIN_TENANT, {}, null);
        const b = await kestraClient().executionsApi.createExecution(ns, flow1, false, MAIN_TENANT, {}, null);
        const c = await kestraClient().executionsApi.createExecution(ns, flow2, false, MAIN_TENANT, {}, null);

        const filters = [qf({ field: QF_FIELD.FLOW_ID, operation: QF_OP.EQUALS, value: flow1 })];
        const bulk = await kestraClient().executionsApi.killExecutionsByQuery(MAIN_TENANT, {filters: filters});
        expect(bulk.count).toBe(2);

        const sA = await awaitExecution(a.id, 'KILLED', 2000, 100);
        const sB = await awaitExecution(b.id, 'KILLED', 2000, 100);
        const sC = await awaitExecution(c.id, 'SUCCESS', 4000, 100);

        expect(sA.state.current).toBe('KILLED');
        expect(sB.state.current).toBe('KILLED');
        expect(sC.state.current).toBe('SUCCESS');
    });

    // --- pause (single) ---
    it('pause_execution', async () => {
        const e = await createdExecution(SLEEP_CONCURRENCY_FLOW, 'RUNNING');
        await kestraClient().executionsApi.pauseExecution(e.id, MAIN_TENANT);
        const paused = await awaitExecution(e.id, 'PAUSED', 2000, 100);
        expect(paused.state.current).toBe('PAUSED');
    });

    // --- pause by ids ---
    it('pause_executions_by_ids', async () => {
        const e1 = await createdExecution(SLEEP_CONCURRENCY_FLOW, 'RUNNING');
        const e2 = await createdExecution(SLEEP_CONCURRENCY_FLOW, 'RUNNING');
        const other = await createdExecution(SLEEP_CONCURRENCY_FLOW, 'RUNNING');

        const bulk = await kestraClient().executionsApi.pauseExecutionsByIds(MAIN_TENANT, [e1.id, e2.id]);
        expect(bulk.count).toBe(2);

        const p1 = await awaitExecution(e1.id, 'PAUSED', 2000, 100);
        const p2 = await awaitExecution(e2.id, 'PAUSED', 2000, 100);
        expect(p1.state.current).toBe('PAUSED');
        expect(p2.state.current).toBe('PAUSED');

        // let "other" finish or keep running (not paused assertion necessary here)
    });

    // --- pause by query ---
    it('pause_executions_by_query', async () => {
        const e1 = await createdExecution(SLEEP_CONCURRENCY_FLOW, 'RUNNING');
        const e2 = await createdExecution(SLEEP_CONCURRENCY_FLOW, 'RUNNING');
        const other = await createdExecution(SLEEP_CONCURRENCY_FLOW, 'RUNNING');

        const filters = [qf({ field: QF_FIELD.NAMESPACE, operation: QF_OP.IN, value: [e1.namespace, e2.namespace] })];
        const bulk = await kestraClient().executionsApi.pauseExecutionsByQuery(MAIN_TENANT, {filters: filters});
        expect(bulk.count).toBe(2);

        const p1 = await awaitExecution(e1.id, 'PAUSED', 2000, 100);
        const p2 = await awaitExecution(e2.id, 'PAUSED', 2000, 100);
        const o = await awaitExecution(other.id, 'SUCCESS', 4000, 100);

        expect(p1.state.current).toBe('PAUSED');
        expect(p2.state.current).toBe('PAUSED');
        expect(o.state.current).toBe('SUCCESS');
    });

    // --- replay execution (single) ---
    it('replay_execution', async () => {
        const e = await createdExecution(LOG_FLOW, 'SUCCESS');
        const replay = await kestraClient().executionsApi.replayExecution(e.id, MAIN_TENANT, null, null, null);
        expect(replay.state.current).toBe('CREATED');
        const done = await awaitExecution(replay.id, 'SUCCESS', 2000, 100);
        expect(done.state.current).toBe('SUCCESS');
    });

    // --- replay execution with inputs (single) ---
    it('replay_execution_with_inputs', async () => {
        const e = await createdExecution(FAILED_FLOW, 'FAILED');
        const inputs = { key: 'value' };
        const taskRunId = e.taskRunList?.[0]?.id ?? null;
        const resp = await kestraClient().executionsApi.replayExecutionWithinputs(
            e.id, MAIN_TENANT, taskRunId, e.flowRevision, null, {}, inputs
        );
        expect(resp.id).toBeTruthy();
    });

    // --- replay by ids ---
    it('replay_executions_by_ids', async () => {
        const e1 = await createdExecution(LOG_FLOW, 'SUCCESS');
        const e2 = await createdExecution(LOG_FLOW, 'SUCCESS');
        const bulk = await kestraClient().executionsApi.replayExecutionsByIds(MAIN_TENANT, [e1.id, e2.id], null);
        expect(bulk.count).toBe(2);
    });

    // --- replay by query ---
    it('replay_executions_by_query', async () => {
        const e1 = await createdExecution(LOG_FLOW, 'SUCCESS');
        const e2 = await createdExecution(LOG_FLOW, 'SUCCESS');
        const filters = [qf({ field: QF_FIELD.FLOW_ID, operation: QF_OP.EQUALS, value: e1.flowId })];
        const resp = await kestraClient().executionsApi.replayExecutionsByQuery(MAIN_TENANT, {filters: filters, latestRevision:true});
        expect(resp.count).toBe(1);
    });

    // --- restart execution (single) ---
    it('restart_execution', async () => {
        const e = await createdExecution(FAILED_FLOW, 'FAILED');
        const resp = await kestraClient().executionsApi.restartExecution(e.id, MAIN_TENANT, null);
        expect(resp.state.current).toBe('RESTARTED');
    });

    // --- restart by ids ---
    it('restart_executions_by_ids', async () => {
        const e1 = await createdExecution(FAILED_FLOW, 'FAILED');
        const e2 = await createdExecution(FAILED_FLOW, 'FAILED');
        const bulk = await kestraClient().executionsApi.restartExecutionsByIds(MAIN_TENANT, [e1.id, e2.id]);
        expect(bulk.count).toBe(2);
    });

    // --- restart by query ---
    it('restart_executions_by_query', async () => {
        const e1 = await createdExecution(FAILED_FLOW, 'FAILED');
        const e2 = await createdExecution(FAILED_FLOW, 'FAILED');
        const filters = [qf({ field: QF_FIELD.NAMESPACE, operation: QF_OP.IN, value: [e1.namespace, e2.namespace] })];
        const resp = await kestraClient().executionsApi.restartExecutionsByQuery(MAIN_TENANT, {filters:filters});
        expect(resp.count).toBe(2);
    });

    // --- resume execution (single) ---
    it('resume_execution', async () => {
        const e = await createdExecution(PAUSE_FLOW, 'PAUSED');
        await kestraClient().executionsApi.resumeExecution(e.id, MAIN_TENANT);
        const done = await awaitExecution(e.id, 'SUCCESS', 2000, 100);
        expect(done.state.current).toBe('SUCCESS');
    });

    // --- resume by ids ---
    it('resume_executions_by_ids', async () => {
        const e1 = await createdExecution(PAUSE_FLOW, 'PAUSED');
        const e2 = await createdExecution(PAUSE_FLOW, 'PAUSED');
        const bulk = await kestraClient().executionsApi.resumeExecutionsByIds(MAIN_TENANT, [e1.id, e2.id]);
        expect(bulk.count).toBe(2);
        const d1 = await awaitExecution(e1.id, 'SUCCESS', 2000, 100);
        const d2 = await awaitExecution(e2.id, 'SUCCESS', 2000, 100);
        expect(d1.state.current).toBe('SUCCESS');
        expect(d2.state.current).toBe('SUCCESS');
    });

    // --- resume by query ---
    it('resume_executions_by_query', async () => {
        const e1 = await createdExecution(PAUSE_FLOW, 'PAUSED');
        const e2 = await createdExecution(PAUSE_FLOW, 'PAUSED');
        const filters = [qf({ field: QF_FIELD.NAMESPACE, operation: QF_OP.IN, value: [e1.namespace, e2.namespace] })];
        const resp = await kestraClient().executionsApi.resumeExecutionsByQuery(MAIN_TENANT, {filters: filters});
        expect(resp.count).toBe(2);
        const d1 = await awaitExecution(e1.id, 'SUCCESS', 2000, 100);
        const d2 = await awaitExecution(e2.id, 'SUCCESS', 2000, 100);
        expect(d1.state.current).toBe('SUCCESS');
        expect(d2.state.current).toBe('SUCCESS');
    });

    // --- search executions ---
    it('search_executions', async () => {
        const ns = randomId();
        const flowId = randomId();
        const e1 = await createFlowWithExecution(flowId, ns);
        const e2 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);

        const sort = ['state.startDate:asc'];
        const filters = [qf({ field: QF_FIELD.NAMESPACE, operation: QF_OP.EQUALS, value: [ns] })];

        const page1 = await kestraClient().executionsApi.searchExecutions(1, 2, MAIN_TENANT, {sort:sort, filters:filters});
        expect(page1.total).toBe(5);
        expect(page1.results.length).toBe(2);
        expect(page1.results[0].id).toBe(e1.id);
        expect(page1.results[1].id).toBe(e2.id);

        const page3 = await kestraClient().executionsApi.searchExecutions(3, 2, MAIN_TENANT, {sort:sort, filters:filters});
        expect(page3.total).toBe(5);
        expect(page3.results.length).toBe(1);
    });

    // --- set labels on (single) terminated execution ---
    it('set_labels_on_terminated_execution', async () => {
        const e = await createdExecution(LOG_FLOW, 'SUCCESS');
        const labels = [{ key: 'foo', value: 'bar' }, { key: 'terminated', value: 'yes' }];
        await kestraClient().executionsApi.setLabelsOnTerminatedExecution(e.id, MAIN_TENANT, labels);
        const after = await kestraClient().executionsApi.execution(e.id, MAIN_TENANT);
        const lbls = after.labels ?? [];
        expect(lbls.some(l => l.key === 'foo' && l.value === 'bar')).toBe(true);
        expect(lbls.some(l => l.key === 'terminated' && l.value === 'yes')).toBe(true);
    });

    // --- set labels by ids ---
    it('set_labels_on_terminated_executions_by_ids', async () => {
        const a = await createdExecution(LOG_FLOW, 'SUCCESS');
        const b = await createdExecution(LOG_FLOW, 'SUCCESS');
        const c = await createdExecution(LOG_FLOW, 'SUCCESS');

        const labels = [{ key: 'foo', value: 'bar' }, { key: 'terminated', value: 'yes' }];
        const req = { executionsId: [a.id, b.id], executionLabels: labels };
        const bulk = await kestraClient().executionsApi.setLabelsOnTerminatedExecutionsByIds(MAIN_TENANT, req);
        expect(bulk.count).toBe(2);

        const a2 = await kestraClient().executionsApi.execution(a.id, MAIN_TENANT);
        const b2 = await kestraClient().executionsApi.execution(b.id, MAIN_TENANT);
        const c2 = await kestraClient().executionsApi.execution(c.id, MAIN_TENANT);
        const has = (e, k, v) => (e.labels ?? []).some(l => l.key === k && l.value === v);
        expect(has(a2, 'foo', 'bar') && has(a2, 'terminated', 'yes')).toBe(true);
        expect(has(b2, 'foo', 'bar') && has(b2, 'terminated', 'yes')).toBe(true);
        expect(!(has(c2, 'foo', 'bar') && has(c2, 'terminated', 'yes'))).toBe(true);
    });

    // --- set labels by query ---
    it('set_labels_on_terminated_executions_by_query', async () => {
        const a = await createdExecution(LOG_FLOW, 'SUCCESS');
        const b = await createdExecution(LOG_FLOW, 'SUCCESS');
        const c = await createdExecution(LOG_FLOW, 'SUCCESS');

        const labels = [{ key: 'foo', value: 'bar' }, { key: 'terminated', value: 'yes' }];
        const filters = [qf({ field: QF_FIELD.NAMESPACE, operation: QF_OP.IN, value: [a.namespace, b.namespace] })];
        const resp = await kestraClient().executionsApi.setLabelsOnTerminatedExecutionsByQuery(MAIN_TENANT, labels, {filters:filters});
        expect(resp.count).toBe(2);

        const a2 = await kestraClient().executionsApi.execution(a.id, MAIN_TENANT);
        const b2 = await kestraClient().executionsApi.execution(b.id, MAIN_TENANT);
        const c2 = await kestraClient().executionsApi.execution(c.id, MAIN_TENANT);
        const has = (e, k, v) => (e.labels ?? []).some(l => l.key === k && l.value === v);
        expect(has(a2, 'foo', 'bar') && has(a2, 'terminated', 'yes')).toBe(true);
        expect(has(b2, 'foo', 'bar') && has(b2, 'terminated', 'yes')).toBe(true);
        expect(!(has(c2, 'foo', 'bar') && has(c2, 'terminated', 'yes'))).toBe(true);
    });

    // --- trigger by GET webhook ---
    it('trigger_execution_by_get_webhook', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createFlow(WEBHOOK_FLOW(flowId, ns));
        const resp = await kestraClient().executionsApi.triggerExecutionByGetWebhook(ns, flowId, 'a-secret-key', MAIN_TENANT);
        expect(resp).toBeTruthy();
        const done = await awaitExecution(resp.id, 'SUCCESS', 5000, 100);
        expect(done.state.current).toBe('SUCCESS');
    });

    // --- unqueue (single) ---
    it('unqueue_execution', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(running.id, 'RUNNING', 1500, 100);
        const queued = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(queued.id, 'QUEUED', 1500, 100);

        const resp = await kestraClient().executionsApi.unqueueExecution(queued.id, 'RUNNING', MAIN_TENANT);
        expect(resp.state.current).toBe('RUNNING');
        const after = await awaitExecution(queued.id, 'RUNNING', 1500, 100);
        expect(after.state.current).toBe('RUNNING');
    });

    // --- unqueue by ids ---
    it('unqueue_executions_by_ids', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(running.id, 'RUNNING', 1500, 100);
        const q1 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(q1.id, 'QUEUED', 1500, 100);
        const q2 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(q2.id, 'QUEUED', 1500, 100);

        const bulk = await kestraClient().executionsApi.unqueueExecutionsByIds('RUNNING', MAIN_TENANT, [q1.id, q2.id]);
        expect(bulk.count).toBe(2);

        const a1 = await awaitExecution(q1.id, 'RUNNING', 1500, 100);
        const a2 = await awaitExecution(q2.id, 'RUNNING', 1500, 100);
        expect(a1.state.current).toBe('RUNNING');
        expect(a2.state.current).toBe('RUNNING');
    });

    // --- unqueue by query ---
    it('unqueue_executions_by_query', async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(running.id, 'RUNNING', 1500, 100);
        const q1 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(q1.id, 'QUEUED', 1500, 100);
        const q2 = await kestraClient().executionsApi.createExecution(ns, flowId, false, MAIN_TENANT, {}, null);
        await awaitExecution(q2.id, 'QUEUED', 1500, 100);

        const filters = [qf({ field: QF_FIELD.QUERY, operation: QF_OP.EQUALS, value: [q1.id] })];
        const resp = await kestraClient().executionsApi.unqueueExecutionsByQuery(MAIN_TENANT, {filters:filters, newState:'RUNNING'});
        expect(resp.count).toBe(1);

        const a1 = await awaitExecution(q1.id, 'RUNNING', 1500, 100);
        expect(a1.state.current).toBe('RUNNING');
    });

    // --- update status (single) ---
    it('update_execution_status', async () => {
        const e = await createdExecution(LOG_FLOW, 'SUCCESS');
        const updated = await kestraClient().executionsApi.updateExecutionStatus(e.id, 'CANCELLED', MAIN_TENANT);
        expect(updated.state.current).toBe('CANCELLED');
        const fetched = await kestraClient().executionsApi.execution(e.id, MAIN_TENANT);
        expect(fetched.state.current).toBe('CANCELLED');
    });

    // --- update status by ids ---
    it('update_executions_status_by_ids', async () => {
        const e1 = await createdExecution(LOG_FLOW, 'SUCCESS');
        const e2 = await createdExecution(LOG_FLOW, 'SUCCESS');
        const other = await createdExecution(LOG_FLOW, 'SUCCESS');

        const bulk = await kestraClient().executionsApi.updateExecutionsStatusByIds('CANCELLED', MAIN_TENANT, [e1.id, e2.id]);
        expect(bulk.count).toBe(2);

        const s1 = await kestraClient().executionsApi.execution(e1.id, MAIN_TENANT);
        const s2 = await kestraClient().executionsApi.execution(e2.id, MAIN_TENANT);
        const sO = await kestraClient().executionsApi.execution(other.id, MAIN_TENANT);
        expect(s1.state.current).toBe('CANCELLED');
        expect(s2.state.current).toBe('CANCELLED');
        expect(sO.state.current).toBe('SUCCESS');
    });

    // --- update status by query ---
    it('update_executions_status_by_query', async () => {
        const e1 = await createdExecution(LOG_FLOW, 'SUCCESS');
        const e2 = await createdExecution(LOG_FLOW, 'SUCCESS');
        const other = await createdExecution(LOG_FLOW, 'SUCCESS');

        const filters = [qf({ field: QF_FIELD.NAMESPACE, operation: QF_OP.IN, value: [e1.namespace, e2.namespace] })];
        const bulk = await kestraClient().executionsApi.updateExecutionsStatusByQuery('CANCELLED', MAIN_TENANT, {filters:filters});
        expect(bulk.count).toBe(2);

        const s1 = await kestraClient().executionsApi.execution(e1.id, MAIN_TENANT);
        const s2 = await kestraClient().executionsApi.execution(e2.id, MAIN_TENANT);
        const sO = await kestraClient().executionsApi.execution(other.id, MAIN_TENANT);
        expect(s1.state.current).toBe('CANCELLED');
        expect(s2.state.current).toBe('CANCELLED');
        expect(sO.state.current).toBe('SUCCESS');
    });

    // --- follow APIs (enable when your JS client exposes streaming) ---
    it.skip('follow_execution (SSE/WebSocket required)', async () => {});
    it.skip('follow_dependencies_execution (SSE/WebSocket required)', async () => {});
});
