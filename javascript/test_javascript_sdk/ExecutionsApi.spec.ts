// ExecutionsApi.spec.ts
import { describe, it, expect } from "vitest";
import { kestraClient, randomId } from "./CommonTestSetup.js";
import type { Execution, QueryFilterField, QueryFilterOp, StateType } from "@kestra-io/kestra-sdk";

// ---------- Flow YAML templates ----------
const FAILED_FLOW = (id: string, ns: string): string => `
id: ${id}
namespace: ${ns}

tasks:
  - id: fail
    type: io.kestra.plugin.core.execution.Fail
`;

const SLEEP_CONCURRENCY_FLOW = (id: string, ns: string): string => `
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

const LONG_SLEEP_FLOW = (id: string, ns: string): string => `
id: ${id}
namespace: ${ns}

tasks:
  - id: sleep
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT30S
`;

const FILE_FLOW = (id: string, ns: string): string => `
id: ${id}
namespace: ${ns}

tasks:
  - id: write
    type: io.kestra.plugin.core.storage.Write
    content: "Hello from file"
    extension: .txt
`;

const LOG_FLOW = (id: string, ns: string): string => `
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

const PAUSE_FLOW = (id: string, ns: string): string => `
id: ${id}
namespace: ${ns}

tasks:
  - id: pause_flow
    type: io.kestra.plugin.core.flow.Pause
    pauseDuration: PT2S
`;

const WEBHOOK_FLOW = (id: string, ns: string): string => `
id: ${id}
namespace: ${ns}

tasks:
  - id: out
    type: io.kestra.plugin.core.debug.Return
    format: "triggered"

triggers:
  - id: webhook
    type: io.kestra.plugin.core.trigger.Webhook
    key: a-secret-key
`;

const DEPENDENT_FLOW_OF_LOG_FLOW = (id: string, ns: string, triggeringFlowId: string): string => `
id: ${id}
namespace: ${ns}

triggers:
  - id: upstream_dependency
    type: io.kestra.plugin.core.trigger.Flow
    dependsOn:
      - flowId: ${triggeringFlowId}
        namespace: ${ns}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Dependent flow triggered
`;

// ---------- helpers ----------
const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));


async function createFlow(flowYaml: string) {
    const flow = await kestraClient.Flows.createFlow({
        body: flowYaml,
    });
    await sleep(200);
    return flow;
}

async function createSimpleFlow(flowId: string, ns: string, tmpl: (id: string, ns: string) => string = LOG_FLOW) {
    return createFlow(tmpl(flowId, ns));
}

async function createFlowWithExecution(flowId: string, ns: string) {
    await createSimpleFlow(flowId, ns);
    return kestraClient.Executions.createExecution({
        namespace: ns,
        id: flowId,
        wait: true,
    });
}

async function createFlowWithExecutionFromYaml(flowYaml: string, wait = true) {
    const f = await createFlow(flowYaml);
    return await kestraClient.Executions.createExecution({
        namespace: f.namespace,
        id: f.id,
        wait,
    });
}

async function createDependentFlow(flowId: string, ns: string, triggeringFlowId: string) {
    return createFlow(DEPENDENT_FLOW_OF_LOG_FLOW(flowId, ns, triggeringFlowId));
}

async function awaitExecution(
    executionId: string,
    desiredState: StateType,
    timeoutMs = 5000,
    pollMs = 100,
) {
    const start = Date.now();
    // eslint-disable-next-line no-constant-condition
    while (true) {
        let last = {} as Execution;

        last = await kestraClient.Executions.execution({
            executionId,
        });

        if (last.state?.current === desiredState) return last;
        if (Date.now() - start > timeoutMs) {
            if (!last) throw new Error("Execution not found within timeout");
            return last;
        };
        await sleep(pollMs);
    }
}

async function createdExecution(flowTemplate: (id: string, ns: string) => string, desiredState: StateType) {
    const ns = randomId();
    const id = randomId();
    const ex = await createFlowWithExecutionFromYaml(flowTemplate(id, ns), false);
    return await awaitExecution(ex.id, desiredState, 3000, 100);
}

async function getOutputUriFromExecution(opt: { executionId: string, taskRunId: string }) {
    const execution = await kestraClient.Executions.execution({ executionId: opt.executionId });
    const taskRuns = (execution as any).taskRunList ?? [];
    const taskRun = taskRuns.find((t: any) => t.id === opt.taskRunId) ?? taskRuns[0];
    return taskRun?.outputs?.uri as string;
}

// filters
const QF_FIELD: Record<string, QueryFilterField> = {
    NAMESPACE: "NAMESPACE",
    FLOW_ID: "FLOW_ID",
    QUERY: "QUERY",
};
const QF_OP: Record<string, QueryFilterOp> = {
    EQUALS: "EQUALS",
    IN: "IN",
};

// ---------- tests ----------
describe("ExecutionsApi", () => {
    it("create_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns);

        const labels = ["label1:created"];
        const inputs = { key: "value" } as any;

        const resp = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: true,
            labels,
            kind: "NORMAL",
            body: [inputs],
        });

        expect(resp.flowId).toBe(flowId);
        expect(resp.namespace).toBe(ns);
        const lbls = resp.labels ?? [];
        expect(
            lbls.some((l) => l.key === "label1" && l.value === "created"),
        ).toBe(true);
    });

    // --- delete execution (single) ---
    it("delete_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        const ex = await createFlowWithExecution(flowId, ns);

        await kestraClient.Executions.deleteExecution({
            executionId: ex.id,
        });

        await expect(
            kestraClient.Executions.execution({
                executionId: ex.id,
            }),
        ).rejects.toThrow();
    });

    // --- delete executions by ids ---
    it("delete_executions_by_ids", async () => {
        const ns = randomId();
        const flowId = randomId();
        const e1 = await createFlowWithExecution(flowId, ns);
        const e2 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });

        const e3 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });


        const resp = await kestraClient.Executions.deleteExecutionsByIds({
            body: [e1.id, e3.id],
            includeNonTerminated: true,
            deleteLogs: false,
            deleteMetrics: false,
            deleteStorage: false,
        });


        expect(resp.count).toBe(2);

        await expect(
            kestraClient.Executions.execution({
                executionId: e1.id,
            }),
        ).rejects.toThrow();
        await expect(
            kestraClient.Executions.execution({
                executionId: e3.id,
            }),
        ).rejects.toThrow();
        expect(
            await kestraClient.Executions.execution({
                executionId: e2.id,
            }),
        ).toBeTruthy();
    });

    // --- delete executions by query ---
    it("delete_executions_by_query", async () => {
        const ns1 = randomId();
        const flow1 = randomId();
        const a = await createFlowWithExecution(flow1, ns1);
        const b = await kestraClient.Executions.createExecution({
            namespace: ns1,
            id: flow1,
            wait: true,
        });

        const ns2 = randomId();
        const flow2 = randomId();
        await createFlowWithExecution(flow2, ns2);

        const filters = [
            {
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.EQUALS,
                value: ns1,
            },
        ];
        const resp = await kestraClient.Executions.deleteExecutionsByQuery({
            filters,
            includeNonTerminated: true,
            deleteLogs: false,
            deleteMetrics: false,
            deleteStorage: false,
        });
        expect(resp.count).toBe(2);

        await expect(
            kestraClient.Executions.execution({
                executionId: a.id,
            }),
        ).rejects.toThrow();
        await expect(
            kestraClient.Executions.execution({
                executionId: b.id,
            }),
        ).rejects.toThrow();
    });

    // --- download file from execution ---
    it("download_file_from_execution", async () => {
        const ns = randomId();
        const flowId = randomId();

        const e = await createFlowWithExecutionFromYaml(
            FILE_FLOW(flowId, ns),
        );
        const done = await awaitExecution(e.id, "SUCCESS", 5000, 100);

        const taskRunId = done.taskRunList?.[0]?.id ?? null;

        if (!taskRunId) throw new Error("Task run not found");

        const uri = await getOutputUriFromExecution({ executionId: e.id, taskRunId });
        expect(uri).toBeTruthy();

        const file =
            await kestraClient.Executions.downloadFileFromExecution({
                executionId: e.id ?? "",
                path: uri,
            });

        expect(file).toContain("Hello from file");
    });

    // --- force run by ids ---
    it("force_run_by_ids", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        await awaitExecution(running.id, "RUNNING", 1500, 100);

        const queued1 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        const queued2 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        await Promise.all([
            awaitExecution(queued1.id, "QUEUED", 1500, 100),
            awaitExecution(queued2.id, "QUEUED", 1500, 100)
        ])

        const bulk = await kestraClient.Executions.forceRunByIds({
            body: [queued1.id, queued2.id],
        });
        expect(bulk.count).toBe(2);

        const after = await awaitExecution(queued1.id, "RUNNING", 1500, 100);
        const after2 = await awaitExecution(queued2.id, "RUNNING", 1500, 100);
        expect(after.state?.current).toBe("RUNNING");
        expect(after2.state?.current).toBe("RUNNING");
    }, 10000);

    // --- force run execution (single) ---
    it("force_run_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        await awaitExecution(running.id, "RUNNING", 1500, 100);

        const queued = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        await awaitExecution(queued.id, "QUEUED", 1500, 100);

        const resp = await kestraClient.Executions.forceRunExecution({
            executionId: queued.id,
        });

        const after = await awaitExecution(resp.id, "RUNNING", 1500, 100);
        expect(after.state?.current).toBe("RUNNING");
    });

    // --- force run by query ---
    it("force_run_by_query", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const e1 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        await awaitExecution(e1.id, "RUNNING", 1500, 100);
        const e2 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        await awaitExecution(e2.id, "QUEUED", 1500, 100);

        const filters = [
            {
                field: QF_FIELD.FLOW_ID,
                operation: QF_OP.EQUALS,
                value: flowId,
            },
        ];
        const resp = await kestraClient.Executions.forceRunExecutionsByQuery({
            filters: filters,
        });

        expect(resp.totalItems).toBeGreaterThanOrEqual(1);

        const after = await awaitExecution(e2.id, "RUNNING", 1500, 100);
        expect(after.state?.current).toBe("RUNNING");
    });

    // --- get execution ---
    it("get_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        const ex = await createFlowWithExecution(flowId, ns);

        const fetched = await kestraClient.Executions.execution({
            executionId: ex.id,
        });
        expect(fetched.id).toBe(ex.id);
    });

    // --- execution flow graph ---
    it("execution_flow_graph", async () => {
        const ns = randomId();
        const flowId = randomId();
        const ex = await createFlowWithExecution(flowId, ns);

        const graph = await kestraClient.Executions.executionFlowGraph({
            executionId: ex.id,
        });
        expect(graph).toBeTruthy();
    });

    // --- file metadata from execution ---
    it("file_metadatas_from_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        const done = await (async () => {
            const e = await createFlowWithExecutionFromYaml(
                FILE_FLOW(flowId, ns),
            );
            return await awaitExecution(e.id, "SUCCESS", 5000, 100);
        })();

        const uri = await getOutputUriFromExecution({ executionId: done.id, taskRunId: done.taskRunList?.[0]?.id ?? "" });
        const metas = await kestraClient.Executions.fileMetadatasFromExecution({
            executionId: done.id ?? "",
            path: uri,
        });
        expect([15, 16]).toContain(metas.size);
    });

    // --- flow from execution ---
    it("flow_from_execution_by_id", async () => {
        const ns = randomId();
        const flowId = randomId();
        const done = await (async () => {
            const e = await createFlowWithExecutionFromYaml(
                FILE_FLOW(flowId, ns),
            );
            return await awaitExecution(e.id, "SUCCESS", 5000, 100);
        })();

        const flow = await kestraClient.Executions.flowFromExecutionById({
            executionId: done.id ?? "",
        });
        expect(flow.id).toBe(flowId);
        expect(flow.namespace).toBe(ns);
    });

    // --- latest executions ---
    it("latest_executions", async () => {
        const ns = randomId();
        const flowA = randomId();
        const first = await (async () => {
            const e = await createFlowWithExecutionFromYaml(
                FILE_FLOW(flowA, ns),
            );
            await awaitExecution(e.id, "SUCCESS", 5000, 100);
            return e;
        })();
        // another run of A to ensure “latest” changes
        const secondA = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowA,
            wait: true,
        });
        const flowB = randomId();
        const b = await (async () => {
            const e = await createFlowWithExecutionFromYaml(
                FILE_FLOW(flowB, ns),
            );
            return await awaitExecution(e.id, "SUCCESS", 5000, 100);
        })();

        const filters = [
            { id: flowA, namespace: ns },
            { id: flowB, namespace: ns },
        ];
        const list = await kestraClient.Executions.latestExecutions(
            { body: filters },
        );
        expect(Array.isArray(list)).toBe(true);
        expect(list.length).toBe(2);
        const ids = list.map((x) => x.id);
        expect(ids).toContain(secondA.id);
        expect(ids).toContain(b.id);
    });

    // --- kill execution (single) ---
    it("kill_execution", async () => {
        const e = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");

        await kestraClient.Executions.killExecution({
            executionId: e.id,
            isOnKillCascade: false,
        });

        const killed = await awaitExecution(e.id, "KILLED", 2000, 100);
        expect(killed.state?.current).toBe("KILLED");
    });

    // --- kill by ids ---
    it("kill_executions_by_ids", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, LONG_SLEEP_FLOW);

        const e1 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        const e2 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });
        const e3 = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });

        await Promise.all([
            awaitExecution(e1.id, "RUNNING", 3000, 100),
            awaitExecution(e2.id, "RUNNING", 3000, 100),
            awaitExecution(e3.id, "RUNNING", 3000, 100),
        ]);

        const bulk: any = await kestraClient.Executions.killExecutionsByIds({
            body: [e2.id, e3.id],
        });
        expect(bulk.totalItems).toBe(2);

        const [s2, s3] = await Promise.all([
            awaitExecution(e2.id, "KILLED", 5000, 100),
            awaitExecution(e3.id, "KILLED", 5000, 100)
        ]);
        expect(s2.state?.current).toBe("KILLED");
        expect(s3.state?.current).toBe("KILLED");
    }, 15000);

    // --- kill by query ---
    it("kill_executions_by_query", async () => {
        const ns = randomId();
        const flow1 = randomId();
        const flow2 = randomId();
        await createSimpleFlow(flow1, ns, LONG_SLEEP_FLOW);
        await createSimpleFlow(flow2, ns, LONG_SLEEP_FLOW);

        const [a, b, c] = await Promise.all([
            kestraClient.Executions.createExecution({
                namespace: ns,
                id: flow1,
                wait: false,
            }),
            kestraClient.Executions.createExecution({
                namespace: ns,
                id: flow1,
                wait: false,
            }),
            kestraClient.Executions.createExecution({
                namespace: ns,
                id: flow2,
                wait: false,
            })
        ]);

        await Promise.all([
            awaitExecution(a.id, "RUNNING", 3000, 100),
            awaitExecution(b.id, "RUNNING", 3000, 100),
            awaitExecution(c.id, "RUNNING", 3000, 100)
        ]);

        const filters = [
            {
                field: QF_FIELD.FLOW_ID,
                operation: QF_OP.EQUALS,
                value: flow1,
            },
        ];

        const bulk = await kestraClient.Executions.killExecutionsByQuery({
            filters: filters,
        });
        expect(bulk.totalItems).toBe(2);

        await awaitExecution(a.id, "KILLED", 5000, 100);
        await awaitExecution(b.id, "KILLED", 5000, 100);
    });

    // --- pause (single) ---
    it("pause_execution", async () => {
        const e = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");
        await kestraClient.Executions.pauseExecution({
            executionId: e.id ?? "",
        });
        const paused = await awaitExecution(e.id ?? '', "PAUSED", 2000, 100);
        expect(paused.state?.current).toBe("PAUSED");
    });

    // --- pause by ids ---
    it("pause_executions_by_ids", async () => {
        const e1 = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");
        const e2 = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");
        const other = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");

        const bulk: any = await kestraClient.Executions.pauseExecutionsByIds({
            body: [e1.id ?? "", e2.id ?? ""],
        });
        expect(bulk.totalItems).toBe(2);

        const p1 = await awaitExecution(e1.id ?? "", "PAUSED", 2000, 100);
        const p2 = await awaitExecution(e2.id ?? "", "PAUSED", 2000, 100);
        expect(p1.state?.current).toBe("PAUSED");
        expect(p2.state?.current).toBe("PAUSED");

        // let "other" finish or keep running (not paused assertion necessary here)
    });

    // --- pause by query ---
    it("pause_executions_by_query", async () => {
        const e1 = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");
        const e2 = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");
        const other = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");

        const filters = [
            {
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [e1.namespace, e2.namespace],
            },
        ];
        const bulk: any = await kestraClient.Executions.pauseExecutionsByQuery(
            { filters: filters },
        );
        expect(bulk.totalItems).toBe(2);

        const p1 = await awaitExecution(e1.id ?? "", "PAUSED", 2000, 100);
        const p2 = await awaitExecution(e2.id ?? "", "PAUSED", 2000, 100);
        const o = await awaitExecution(other.id ?? "", "SUCCESS", 4000, 100);

        expect(p1.state?.current).toBe("PAUSED");
        expect(p2.state?.current).toBe("PAUSED");
        expect(o.state?.current).toBe("SUCCESS");
    });

    // --- replay execution (single) ---
    it("replay_execution", async () => {
        const e = await createdExecution(LOG_FLOW, "SUCCESS");
        const replay = await kestraClient.Executions.replayExecution(
            { executionId: e.id ?? "" },

        );

        expect(replay.state?.current).toBe("RUNNING");

        const done = await awaitExecution(replay.id ?? "", "SUCCESS", 2000, 100);
        expect(done.state?.current).toBe("SUCCESS");
    });

    // --- replay execution with inputs (single) ---
    it("replay_execution_with_inputs", async () => {
        const e = await createdExecution(FAILED_FLOW, "FAILED");
        const inputs = { key: "value" } as any;
        const taskRunId = e.taskRunList?.[0]?.id ?? null;
        const resp = await kestraClient.Executions.replayExecutionWithinputs(
            { executionId: e.id ?? "", taskRunId, revision: e.flowRevision, body: [inputs] },
        );

        expect(resp.id).toBeTruthy();
    });

    // --- replay by ids ---
    it("replay_executions_by_ids", async () => {
        const e1 = await createdExecution(LOG_FLOW, "SUCCESS");
        const e2 = await createdExecution(LOG_FLOW, "SUCCESS");
        const bulk: any = await kestraClient.Executions.replayExecutionsByIds({
            body: [e1.id ?? "", e2.id ?? ""]
        });
        expect(bulk.totalItems).toBe(2);
    });

    // --- replay by query ---
    it("replay_executions_by_query", async () => {
        const e1 = await createdExecution(LOG_FLOW, "SUCCESS");
        const e2 = await createdExecution(LOG_FLOW, "SUCCESS");
        const filters = [
            {
                field: QF_FIELD.FLOW_ID,
                operation: QF_OP.EQUALS,
                value: e1.flowId,
            },
        ];
        const resp: any = await kestraClient.Executions.replayExecutionsByQuery(
            { filters: filters, latestRevision: true },
        );
        expect(resp.totalItems).toBe(1);
    });

    // --- restart execution (single) ---
    it("restart_execution", async () => {
        const e = await createdExecution(FAILED_FLOW, "FAILED");
        const resp = await kestraClient.Executions.restartExecution(
            { executionId: e.id },
        );

        // RESTARTED is a transient state — the executor immediately resumes the
        // execution, so by the time the API responds we may already be past it.
        // Assert RESTARTED appears in the state history instead.
        expect(resp.state?.histories?.map((h) => h.state)).toContain("RESTARTED");
    });

    // --- restart by ids ---
    it("restart_executions_by_ids", async () => {
        const e1 = await createdExecution(FAILED_FLOW, "FAILED");
        const e2 = await createdExecution(FAILED_FLOW, "FAILED");
        const bulk: any = await kestraClient.Executions.restartExecutionsByIds(
            { body: [e1.id, e2.id] },
        );
        expect(bulk.totalItems).toBe(2);
    });

    // --- restart by query ---
    it("restart_executions_by_query", async () => {
        const e1 = await createdExecution(FAILED_FLOW, "FAILED");
        const e2 = await createdExecution(FAILED_FLOW, "FAILED");
        const filters = [
            {
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [e1.namespace, e2.namespace],
            },
        ];
        const resp: any = await kestraClient.Executions.restartExecutionsByQuery(
            { filters: filters },
        );
        expect(resp.totalItems).toBe(2);
    });

    // --- resume execution (single) ---
    it("resume_execution", async () => {
        const e = await createdExecution(PAUSE_FLOW, "PAUSED");
        await kestraClient.Executions.resumeExecution({
            executionId: e.id ?? "",
            body: [],
        });
        const done = await awaitExecution(e.id, "SUCCESS", 2000, 100);
        expect(done.state?.current).toBe("SUCCESS");
    });

    // --- resume by ids ---
    it("resume_executions_by_ids", async () => {
        const e1 = await createdExecution(PAUSE_FLOW, "PAUSED");
        const e2 = await createdExecution(PAUSE_FLOW, "PAUSED");
        const bulk: any = await kestraClient.Executions.resumeExecutionsByIds(
            { body: [e1.id, e2.id] },
        );
        expect(bulk.totalItems).toBe(2);
        const d1 = await awaitExecution(e1.id, "SUCCESS", 2000, 100);
        const d2 = await awaitExecution(e2.id, "SUCCESS", 2000, 100);
        expect(d1.state?.current).toBe("SUCCESS");
        expect(d2.state?.current).toBe("SUCCESS");
    });

    // --- resume by query ---
    it("resume_executions_by_query", async () => {
        const e1 = await createdExecution(PAUSE_FLOW, "PAUSED");
        const e2 = await createdExecution(PAUSE_FLOW, "PAUSED");
        const filters = [
            {
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [e1.namespace, e2.namespace],
            },
        ];
        const resp: any = await kestraClient.Executions.resumeExecutionsByQuery(
            { filters: filters },
        );
        expect(resp.totalItems).toBe(2);
        const d1 = await awaitExecution(e1.id, "SUCCESS", 2000, 100);
        const d2 = await awaitExecution(e2.id, "SUCCESS", 2000, 100);
        expect(d1.state?.current).toBe("SUCCESS");
        expect(d2.state?.current).toBe("SUCCESS");
    });

    // --- search executions ---
    it("search_executions", async () => {
        const ns = randomId();
        const flowId = randomId();
        const e1 = await createFlowWithExecution(flowId, ns);
        const e2 = await kestraClient.Executions.createExecution(
            { namespace: ns, id: flowId, wait: true },
        );
        await Promise.all(new Array(3).fill(1)
            .map(() => kestraClient.Executions.createExecution(
                { namespace: ns, id: flowId, wait: true },
            ))
        );

        const sort = ["state.startDate:asc"];
        const filters = [
            {
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.EQUALS,
                value: [ns],
            },
        ];

        const page1 = await kestraClient.Executions.searchExecutions(
            { page: 1, size: 2, sort: sort, filters: filters },
        );
        expect(page1.total).toBe(5);
        expect(page1.results.length).toBe(2);
        expect(page1.results[0].id).toBe(e1.id);
        expect(page1.results[1].id).toBe(e2.id);

        const page3 = await kestraClient.Executions.searchExecutions(
            { page: 3, size: 2, sort: sort, filters: filters },
        );
        expect(page3.total).toBe(5);
        expect(page3.results.length).toBe(1);
    });

    // --- set labels on (single) terminated execution ---
    it("set_labels_on_terminated_execution", async () => {
        const e = await createdExecution(LOG_FLOW, "SUCCESS");
        const labels = [
            { key: "foo", value: "bar" },
            { key: "terminated", value: "yes" },
        ];
        await kestraClient.Executions.setLabelsOnTerminatedExecution({
            executionId: e.id ?? "",
            body: labels,
        });
        const after = await kestraClient.Executions.execution({
            executionId: e.id ?? "",
        });
        const lbls = after.labels ?? [];
        expect(lbls.some((l) => l.key === "foo" && l.value === "bar")).toBe(
            true,
        );
        expect(
            lbls.some((l) => l.key === "terminated" && l.value === "yes"),
        ).toBe(true);
    });

    const has = (e: { labels?: { key: string; value: string }[] }, k: string, v: string) =>
        (e.labels ?? []).some((l) => l.key === k && l.value === v);

    async function awaitLabel(executionId: string, k: string, v: string, timeoutMs = 3000, pollMs = 100) {
        const start = Date.now();
        while (true) {
            const ex = await kestraClient.Executions.execution({ executionId });
            if (has(ex, k, v)) return ex;
            if (Date.now() - start > timeoutMs) return ex;
            await sleep(pollMs);
        }
    }

    // --- set labels by ids ---
    it("set_labels_on_terminated_executions_by_ids", async () => {
        const a = await createdExecution(LOG_FLOW, "SUCCESS");
        const b = await createdExecution(LOG_FLOW, "SUCCESS");
        const c = await createdExecution(LOG_FLOW, "SUCCESS");

        const labels = [
            { key: "foo", value: "bar" },
            { key: "terminated", value: "yes" },
        ];
        const bulk: any =
            await kestraClient.Executions.setLabelsOnTerminatedExecutionsByIds({ executionsId: [a.id ?? "", b.id ?? ""], executionLabels: labels });
        expect(bulk.totalItems).toBe(2);

        const a2 = await awaitLabel(a.id, "foo", "bar");
        const b2 = await awaitLabel(b.id, "foo", "bar");
        const c2 = await kestraClient.Executions.execution({
            executionId: c.id,
        });

        expect(has(a2, "foo", "bar") && has(a2, "terminated", "yes")).toBe(
            true,
        );
        expect(has(b2, "foo", "bar") && has(b2, "terminated", "yes")).toBe(
            true,
        );
        expect(!(has(c2, "foo", "bar") && has(c2, "terminated", "yes"))).toBe(
            true,
        );
    });

    // --- set labels by query ---
    it("set_labels_on_terminated_executions_by_query", async () => {
        const a = await createdExecution(LOG_FLOW, "SUCCESS");
        const b = await createdExecution(LOG_FLOW, "SUCCESS");
        const c = await createdExecution(LOG_FLOW, "SUCCESS");

        const labels = [
            { key: "foo", value: "bar" },
            { key: "terminated", value: "yes" },
        ];
        const filters = [
            {
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [a.namespace, b.namespace],
            },
        ];
        const resp =
            await kestraClient.Executions.setLabelsOnTerminatedExecutionsByQuery({
                filters: filters,
                body: labels,
            });
        expect(resp.totalItems).toBe(2);

        const a2 = await awaitLabel(a.id, "foo", "bar");
        const b2 = await awaitLabel(b.id, "foo", "bar");
        const c2 = await kestraClient.Executions.execution({
            executionId: c.id
        });

        expect(has(a2, "foo", "bar") && has(a2, "terminated", "yes")).toBe(
            true,
        );
        expect(has(b2, "foo", "bar") && has(b2, "terminated", "yes")).toBe(
            true,
        );
        expect(!(has(c2, "foo", "bar") && has(c2, "terminated", "yes"))).toBe(
            true,
        );
    });

    // --- trigger by GET webhook ---
    it("trigger_execution_by_get_webhook", async () => {
        const namespace = randomId();
        const id = randomId();
        await createFlow(WEBHOOK_FLOW(id, namespace));
        const resp =
            await kestraClient.Executions.triggerExecutionByGetWebhook({
                namespace,
                id,
                key: "a-secret-key",
            });

        // wait for the webhook-triggered execution to start
        // and update its state from QUEUED to RUNNING
        await sleep(500);
        expect(resp).toBeTruthy();
        const done = await awaitExecution(resp.id ?? "", "SUCCESS", 5000, 100);
        expect(done.state?.current).toBe("SUCCESS");
    }, 10000);

    // --- unqueue (single) ---
    it("unqueue_execution", async () => {
        const namespace = randomId();
        const id = randomId();
        await createSimpleFlow(id, namespace, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient.Executions.createExecution({
            namespace,
            id,
            wait: false,
        });
        await awaitExecution(running.id, "RUNNING", 1500, 100);
        const queued = await kestraClient.Executions.createExecution({
            namespace,
            id,
            wait: false,
        });
        await awaitExecution(queued.id, "QUEUED", 1500, 100);

        const resp = await kestraClient.Executions.unqueueExecution({
            executionId: queued.id,
            state: "RUNNING",
        });
        expect(resp.state?.current).toBe("RUNNING");
        const after = await awaitExecution(queued.id, "RUNNING", 1500, 100);
        expect(after.state?.current).toBe("RUNNING");
    }, 10000);

    // --- unqueue by ids ---
    it("unqueue_executions_by_ids", async () => {
        const namespace = randomId();
        const id = randomId();
        await createSimpleFlow(id, namespace, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient.Executions.createExecution({
            namespace,
            id,
            wait: false,
        });
        await awaitExecution(running.id, "RUNNING", 1500, 100);
        const q1 = await kestraClient.Executions.createExecution({
            namespace,
            id,
            wait: false,
        });
        await awaitExecution(q1.id, "QUEUED", 1500, 100);
        const q2 = await kestraClient.Executions.createExecution({
            namespace,
            id,
            wait: false,
        });
        await awaitExecution(q2.id, "QUEUED", 1500, 100);

        const bulk: any = await kestraClient.Executions.unqueueExecutionsByIds({
            state: "RUNNING",
            body: [q1.id, q2.id],
        });
        expect(bulk.totalItems).toBe(2);

        const a1 = await awaitExecution(q1.id, "RUNNING", 1500, 100);
        const a2 = await awaitExecution(q2.id, "RUNNING", 1500, 100);
        expect(a1.state?.current).toBe("RUNNING");
        expect(a2.state?.current).toBe("RUNNING");
    }, 10000);

    // --- unqueue by query ---
    it("unqueue_executions_by_query", async () => {
        const namespace = randomId();
        const id = randomId();
        await createSimpleFlow(id, namespace, SLEEP_CONCURRENCY_FLOW);

        const running = await kestraClient.Executions.createExecution({
            namespace,
            id,
            wait: false,
        });
        await awaitExecution(running.id, "RUNNING", 1500, 100);
        const q1 = await kestraClient.Executions.createExecution({
            namespace,
            id,
            wait: false,
        });
        await awaitExecution(q1.id, "QUEUED", 1500, 100);
        const q2 = await kestraClient.Executions.createExecution({
            namespace,
            id,
            wait: false,
        });
        await awaitExecution(q2.id, "QUEUED", 1500, 100);

        const filters = [
            {
                field: QF_FIELD.QUERY,
                operation: QF_OP.EQUALS,
                value: [q1.id],
            },
        ];
        const resp: any = await kestraClient.Executions.unqueueExecutionsByQuery({
            filters: filters,
            newState: "RUNNING",
        });
        expect(resp.totalItems).toBeGreaterThanOrEqual(1);

        const a1 = await awaitExecution(q1.id, "RUNNING", 1500, 100);
        expect(a1.state?.current).toBe("RUNNING");
    }, 10000);

    // --- update status (single) ---
    it("update_execution_status", async () => {
        const e = await createdExecution(LOG_FLOW, "SUCCESS");
        const updated = await kestraClient.Executions.updateExecutionStatus({
            executionId: e.id ?? "",
            status: "CANCELLED",
        });

        expect(updated.state?.current).toBe("CANCELLED");
        const fetched = await kestraClient.Executions.execution({
            executionId: e.id ?? "",
        });
        expect(fetched.state?.current).toBe("CANCELLED");
    });

    // --- update status by ids ---
    it("update_executions_status_by_ids", async () => {
        const e1 = await createdExecution(LOG_FLOW, "SUCCESS");
        const e2 = await createdExecution(LOG_FLOW, "SUCCESS");
        const other = await createdExecution(LOG_FLOW, "SUCCESS");

        const bulk: any = await kestraClient.Executions.updateExecutionsStatusByIds({
            newStatus: "CANCELLED",
            body: [e1.id ?? "", e2.id ?? ""],
        });
        expect(bulk.totalItems).toBe(2);

        const s1 = await awaitExecution(e1.id ?? "", "CANCELLED", 2000, 100);
        const s2 = await awaitExecution(e2.id ?? "", "CANCELLED", 2000, 100);
        const sO = await kestraClient.Executions.execution({
            executionId: other.id ?? "",
        });
        expect(s1.state?.current).toBe("CANCELLED");
        expect(s2.state?.current).toBe("CANCELLED");
        expect(sO.state?.current).toBe("SUCCESS");
    });

    // --- update status by query ---
    it("update_executions_status_by_query", async () => {
        const e1 = await createdExecution(LOG_FLOW, "SUCCESS");
        const e2 = await createdExecution(LOG_FLOW, "SUCCESS");
        const other = await createdExecution(LOG_FLOW, "SUCCESS");

        const filters = [
            {
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [e1.namespace, e2.namespace],
            },
        ];
        const bulk: any = await kestraClient.Executions.updateExecutionsStatusByQuery({
            newStatus: "CANCELLED",
            filters: filters,
        });
        expect(bulk.totalItems).toBe(2);

        const s1 = await awaitExecution(e1.id ?? "", "CANCELLED", 2000, 100);
        const s2 = await awaitExecution(e2.id ?? "", "CANCELLED", 2000, 100);
        const sO = await kestraClient.Executions.execution({
            executionId: other.id ?? "",
        });
        expect(s1.state?.current).toBe("CANCELLED");
        expect(s2.state?.current).toBe("CANCELLED");
        expect(sO.state?.current).toBe("SUCCESS");
    });

    const LONG_FLOW = (ns: string, id: string): string => `
id: ${id}
namespace: ${ns}
tasks:
  - id: long-sleep
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT1S
  - id: message
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
  - id: long-sleep-again
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT1S
  - id: final-message
    type: io.kestra.plugin.core.log.Log
    message: Good Bye! 👋
`;

    it("follow_execution (SSE/WebSocket required)", async () => {
        const e = await createFlowWithExecutionFromYaml(LONG_FLOW(randomId(), randomId()), false);
        const { stream } = await kestraClient.Executions.followExecution({
            executionId: e.id
        })
        const result = await (async () => {
            const successfulTaskIds: Set<string> = new Set();
            for await (const evt of stream) {
                const successfulTaskRuns = evt.taskRunList?.filter((t) => t.state?.current === "SUCCESS");
                if (successfulTaskRuns?.length) {
                    for (const t of successfulTaskRuns) {
                        successfulTaskIds.add(t.taskId);
                    }
                }
            }
            return successfulTaskIds;
        })();

        expect(Array.from(result)).toMatchInlineSnapshot(`
          [
            "long-sleep",
            "message",
            "long-sleep-again",
            "final-message",
          ]
        `);
    });

    // SKIPPED: Server-side bug in Kestra's H2 queue subscriber.
    //
    // When followDependenciesExecutions (or followExecution) opens an SSE stream,
    // Kestra registers a FollowExecutionEvent subscriber in the H2 queue. When the
    // SSE connection closes (test ends), the subscriber is NOT removed from H2.
    //
    // Later, when any execution event arrives, H2 delivers it to the stale subscriber.
    // The delivery throws (response writer is closed), and AbstractSubscriber treats
    // ALL delivery errors as fatal → "fatal error while consuming messages. Initiating
    // application shutdown." → server exits with code 0.
    //
    // Confirmed via docker logs:
    //   ERROR [FollowExecutionEvent] fatal error while consuming messages.
    //          Initiating application shutdown.
    //   INFO  Kestra server - Shutdown initiated
    //
    // Fix needed in Kestra server:
    //   1. Unsubscribe the FollowExecutionEvent subscriber when the SSE response closes.
    //   2. Don't treat subscriber delivery failures as application-fatal errors.
    it.skip("follow_dependencies_executions (SSE/WebSocket required)", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, LOG_FLOW);
        await createDependentFlow(flowId + "-dep", ns, flowId);
        const e = await kestraClient.Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        });

        // AbortController ensures the HTTP connection is always closed cleanly,
        // preventing Vitest from killing the worker with an open TCP connection.
        const ac = new AbortController();
        const abortTimer = setTimeout(() => ac.abort(), 20000);

        const { stream } = await kestraClient.Executions.followDependenciesExecutions({
            executionId: e.id,
            expandAll: false,
            destinationOnly: false,
        }, { signal: ac.signal })

        const result = await (async () => {
            const executionIds: Set<string> = new Set();
            try {
                for await (const evt of stream) {
                    executionIds.add(evt.executionId);
                }
            } catch {
                // AbortError if the 20s safety timer fired — proceed with what we have
            } finally {
                clearTimeout(abortTimer);
            }
            return Array.from(executionIds);
        })();

        expect(result).toContain(e.id);
    }, 25000);
});
