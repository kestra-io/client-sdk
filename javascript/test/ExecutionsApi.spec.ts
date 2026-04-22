// ExecutionsApi.spec.ts
import { describe, it, expect } from "vitest";
import { kestraClient, MAIN_TENANT, randomId } from "./CommonTestSetup.js";
import type { QueryFilter, QueryFilterField, QueryFilterOp, StateType } from "@kestra-io/kestra-sdk";

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
    delay: PT2S
`;

const WEBHOOK_FLOW = (id: string, ns: string): string => `
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
const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

function getDataOrThrow<T>(resp: { data?: T }, message?: string): T {
    if (!resp.data) {
        throw new Error(message ?? "Data not found");
    }
    return resp.data;
}

async function createFlow(flowYaml: string) {
    const flow = getDataOrThrow(await kestraClient().Flows.createFlow({
        body: flowYaml,
    }), "Failed to create flow");
    await sleep(200);
    return flow;
}

async function createSimpleFlow(flowId: string, ns: string, tmpl: (id: string, ns: string) => string = LOG_FLOW) {
    return createFlow(tmpl(flowId, ns));
}

async function createFlowWithExecution(flowId: string, ns: string) {
    await createSimpleFlow(flowId, ns);
    return getDataOrThrow(await kestraClient().Executions.createExecution({
        namespace: ns,
        id: flowId,
        wait: false,
    }), "Failed to create execution");
}

async function createFlowWithExecutionFromYaml(flowYaml: string) {
    const f = await createFlow(flowYaml);
    return getDataOrThrow(await kestraClient().Executions.createExecution({
        namespace: f.namespace,
        id: f.id,
        wait: false,
    }), "Failed to create execution with Yaml");
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
        const last = getDataOrThrow(await kestraClient().Executions.execution({
            executionId,
        }), "Failed to fetch execution while awaiting execution");
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
    const ex = await createFlowWithExecutionFromYaml(flowTemplate(id, ns));
    return await awaitExecution(ex.id, desiredState, 3000, 100);
}

// filters
const qf = (query: Omit<QueryFilter, "value"> & { value?: any }) => query as QueryFilter;
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

        const resp = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
            labels,
            kind: "NORMAL",
            body: [inputs],
        }), "failed to create simple execution");

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

        await kestraClient().Executions.deleteExecution({
            executionId: ex.id,
        });

        await expect(
            kestraClient().Executions.execution({
                executionId: ex.id,
            }),
        ).rejects.toThrow();
    });

    // --- delete executions by ids ---
    it("delete_executions_by_ids", async () => {
        const ns = randomId();
        const flowId = randomId();
        const e1 = await createFlowWithExecution(flowId, ns);
        const e2 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));

        const e3 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));


        const resp = getDataOrThrow(await kestraClient().Executions.deleteExecutionsByIds({
            body: [e1.id, e3.id],
            includeNonTerminated: true,
            deleteLogs: false,
            deleteMetrics: false,
            deleteStorage: false,
        }), "Failed to delete executions by ids");


        expect(resp.count).toBe(2);

        await expect(
            kestraClient().Executions.execution({
                executionId: e1.id,
                tenant: MAIN_TENANT,
            }),
        ).rejects.toThrow();
        await expect(
            kestraClient().Executions.execution({
                executionId: e3.id,
                tenant: MAIN_TENANT,
            }),
        ).rejects.toThrow();
        expect(
            await kestraClient().Executions.execution({
                executionId: e2.id,
                tenant: MAIN_TENANT,
            }),
        ).toBeTruthy();
    });

    // --- delete executions by query ---
    it("delete_executions_by_query", async () => {
        const ns1 = randomId();
        const flow1 = randomId();
        const a = await createFlowWithExecution(flow1, ns1);
        const b = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns1,
            id: flow1,
            wait: false,
        }));

        const ns2 = randomId();
        const flow2 = randomId();
        await createFlowWithExecution(flow2, ns2);

        const filters = [
            qf({
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.EQUALS,
                value: ns1,
            }),
        ];
        const resp = getDataOrThrow(await kestraClient().Executions.deleteExecutionsByQuery({
            filters,
            includeNonTerminated: true,
            deleteLogs: false,
            deleteMetrics: false,
            deleteStorage: false,
        }), "Failed to delete executions by query");
        expect(resp.count).toBe(2);

        await expect(
            kestraClient().Executions.execution({
                executionId: a.id,
            }),
        ).rejects.toThrow();
        await expect(
            kestraClient().Executions.execution({
                executionId: b.id,
            }),
        ).rejects.toThrow();
    });

    // --- download file from execution ---
    it("download_file_from_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        const done = await (async () => {
            const e = await createFlowWithExecutionFromYaml(
                FILE_FLOW(flowId, ns),
            );
            return await awaitExecution(e.id, "SUCCESS", 5000, 100);
        })();

        const uri = done?.taskRunList?.[0]?.outputs?.uri;
        expect(uri).toBeTruthy();

        const { data: file } =
            await kestraClient().Executions.downloadFileFromExecution({
                executionId: done.id ?? "",
                path: uri,
            });
        // depending on generator, this might be a Buffer/string/file path.
        const txt = file?.text ?? file;
        expect(String(txt)).toContain("Hello from file");
    });

    // --- force run by ids ---
    it("force_run_by_ids", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        await awaitExecution(running.id, "RUNNING", 1500, 100);

        const queued = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        await awaitExecution(queued.id, "QUEUED", 1500, 100);

        const bulk = getDataOrThrow(await kestraClient().Executions.forceRunByIds({
            body: [queued.id],
        }));
        expect(bulk.count).toBe(1);

        const after = await awaitExecution(queued.id, "RUNNING", 1500, 100);
        expect(after.state?.current).toBe("RUNNING");
    });

    // --- force run execution (single) ---
    it("force_run_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const running = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        await awaitExecution(running.id, "RUNNING", 1500, 100);

        const queued = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        await awaitExecution(queued.id, "QUEUED", 1500, 100);

        const resp = getDataOrThrow(await kestraClient().Executions.forceRunExecution({
            executionId: queued.id,
        }));
        const after = await awaitExecution(resp.id, "RUNNING", 1500, 100);
        expect(after.state?.current).toBe("RUNNING");
    });

    // --- force run by query ---
    it("force_run_by_query", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const e1 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        await awaitExecution(e1.id, "RUNNING", 1500, 100);
        const e2 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        await awaitExecution(e2.id, "QUEUED", 1500, 100);

        const filters = [
            qf({
                field: QF_FIELD.FLOW_ID,
                operation: QF_OP.EQUALS,
                value: flowId,
            }),
        ];
        const resp = getDataOrThrow(await kestraClient().Executions.forceRunExecutionsByQuery({
            filters: filters,
        }));
        expect(resp.count).toBeGreaterThanOrEqual(1);

        const after = await awaitExecution(e2.id, "RUNNING", 1500, 100);
        expect(after.state?.current).toBe("RUNNING");
    });

    // --- get execution ---
    it("get_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        const ex = await createFlowWithExecution(flowId, ns);

        const fetched = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: ex.id,
        }));
        expect(fetched.id).toBe(ex.id);
    });

    // --- execution flow graph ---
    it("execution_flow_graph", async () => {
        const ns = randomId();
        const flowId = randomId();
        const ex = await createFlowWithExecution(flowId, ns);

        const graph = getDataOrThrow(await kestraClient().Executions.executionFlowGraph({
            executionId: ex.id,
        }));
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

        const uri = done?.taskRunList?.[0]?.outputs?.uri;
        const metas = getDataOrThrow(await kestraClient().Executions.fileMetadatasFromExecution({
            executionId: done.id ?? "",
            path: uri,
        }));
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

        const flow = getDataOrThrow(await kestraClient().Executions.flowFromExecutionById({
            executionId: done.id ?? "",
        }));
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
        const secondA = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowA,
            wait: false,
        }));
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
        const list = getDataOrThrow(await kestraClient().Executions.latestExecutions(
            { body: filters },
        ));
        expect(Array.isArray(list)).toBe(true);
        expect(list.length).toBe(2);
        const ids = list.map((x) => x.id);
        expect(ids).toContain(secondA.id);
        expect(ids).toContain(b.id);
    });

    // --- kill execution (single) ---
    it("kill_execution", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const e = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        await sleep(200);
        await kestraClient().Executions.killExecution({
            executionId: e.id,
            isOnKillCascade: true,
        });

        const killed = await awaitExecution(e.id, "KILLED", 2000, 100);
        expect(killed.state?.current).toBe("KILLED");
    });

    // --- kill by ids ---
    it("kill_executions_by_ids", async () => {
        const ns = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, ns, SLEEP_CONCURRENCY_FLOW);

        const e1 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        const e2 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));
        const e3 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flowId,
            wait: false,
        }));

        const bulk = getDataOrThrow(await kestraClient().Executions.killExecutionsByIds({
            body: [e2.id, e3.id],
        }));
        expect(bulk.count).toBe(2);

        const s2 = await awaitExecution(e2.id, "KILLED", 2000, 100);
        const s3 = await awaitExecution(e3.id, "KILLED", 2000, 100);
        expect(s2.state?.current).toBe("KILLED");
        expect(s3.state?.current).toBe("KILLED");

        const s1 = await awaitExecution(e1.id, "SUCCESS", 4000, 100);
        expect(s1.state?.current).toBe("SUCCESS");
    });

    // --- kill by query ---
    it("kill_executions_by_query", async () => {
        const ns = randomId();
        const flow1 = randomId();
        const flow2 = randomId();
        await createSimpleFlow(flow1, ns, SLEEP_CONCURRENCY_FLOW);
        await createSimpleFlow(flow2, ns, SLEEP_CONCURRENCY_FLOW);

        const a = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flow1,
            wait: false,
        }));
        const b = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flow1,
            wait: false,
        }));
        const c = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace: ns,
            id: flow2,
            wait: false,
        }));

        const filters = [
            qf({
                field: QF_FIELD.FLOW_ID,
                operation: QF_OP.EQUALS,
                value: flow1,
            }),
        ];
        const bulk = getDataOrThrow(await kestraClient().Executions.killExecutionsByQuery({
            filters: filters,
        }));
        expect(bulk.count).toBe(2);

        const sA = await awaitExecution(a.id, "KILLED", 2000, 100);
        const sB = await awaitExecution(b.id, "KILLED", 2000, 100);
        const sC = await awaitExecution(c.id, "SUCCESS", 4000, 100);

        expect(sA.state?.current).toBe("KILLED");
        expect(sB.state?.current).toBe("KILLED");
        expect(sC.state?.current).toBe("SUCCESS");
    });

    // --- pause (single) ---
    it("pause_execution", async () => {
        const e = await createdExecution(SLEEP_CONCURRENCY_FLOW, "RUNNING");
        await kestraClient().Executions.pauseExecution({
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

        const bulk = getDataOrThrow(await kestraClient().Executions.pauseExecutionsByIds({
            body: [e1.id ?? "", e2.id ?? ""],
        }));
        expect(bulk.count).toBe(2);

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
            qf({
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [e1.namespace, e2.namespace],
            }),
        ];
        const bulk = getDataOrThrow(await kestraClient().Executions.pauseExecutionsByQuery(
            { filters: filters },
        ));
        expect(bulk.count).toBe(2);

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
        const replay = getDataOrThrow(await kestraClient().Executions.replayExecution(
            { executionId: e.id ?? "" },

        ));
        expect(replay.state?.current).toBe("CREATED");
        const done = await awaitExecution(replay.id ?? "", "SUCCESS", 2000, 100);
        expect(done.state?.current).toBe("SUCCESS");
    });

    // --- replay execution with inputs (single) ---
    it("replay_execution_with_inputs", async () => {
        const e = await createdExecution(FAILED_FLOW, "FAILED");
        const inputs = { key: "value" } as any;
        const taskRunId = e.taskRunList?.[0]?.id ?? null;
        const resp = getDataOrThrow(await kestraClient().Executions.replayExecutionWithinputs(
            { executionId: e.id ?? "", taskRunId, revision: e.flowRevision, body: [inputs] },
        ));
        expect(resp.id).toBeTruthy();
    });

    // --- replay by ids ---
    it("replay_executions_by_ids", async () => {
        const e1 = await createdExecution(LOG_FLOW, "SUCCESS");
        const e2 = await createdExecution(LOG_FLOW, "SUCCESS");
        const bulk = getDataOrThrow(await kestraClient().Executions.replayExecutionsByIds({
            body: [e1.id ?? "", e2.id ?? ""]
        }));
        expect(bulk.count).toBe(2);
    });

    // --- replay by query ---
    it("replay_executions_by_query", async () => {
        const e1 = await createdExecution(LOG_FLOW, "SUCCESS");
        const e2 = await createdExecution(LOG_FLOW, "SUCCESS");
        const filters = [
            qf({
                field: QF_FIELD.FLOW_ID,
                operation: QF_OP.EQUALS,
                value: e1.flowId,
            }),
        ];
        const resp = getDataOrThrow(await kestraClient().Executions.replayExecutionsByQuery(
            { filters: filters, latestRevision: true },
        ));
        expect(resp.count).toBe(1);
    });

    // --- restart execution (single) ---
    it("restart_execution", async () => {
        const e = await createdExecution(FAILED_FLOW, "FAILED");
        const resp = getDataOrThrow(await kestraClient().Executions.restartExecution(
            { executionId: e.id ?? "" },
        ));
        expect(resp.state?.current).toBe("RESTARTED");
    });

    // --- restart by ids ---
    it("restart_executions_by_ids", async () => {
        const e1 = await createdExecution(FAILED_FLOW, "FAILED");
        const e2 = await createdExecution(FAILED_FLOW, "FAILED");
        const bulk = getDataOrThrow(await kestraClient().Executions.restartExecutionsByIds(
            { body: [e1.id ?? "", e2.id ?? ""] },
        ));
        expect(bulk.count).toBe(2);
    });

    // --- restart by query ---
    it("restart_executions_by_query", async () => {
        const e1 = await createdExecution(FAILED_FLOW, "FAILED");
        const e2 = await createdExecution(FAILED_FLOW, "FAILED");
        const filters = [
            qf({
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [e1.namespace, e2.namespace],
            }),
        ];
        const resp = getDataOrThrow(await kestraClient().Executions.restartExecutionsByQuery(
            { filters: filters },
        ));
        expect(resp.count).toBe(2);
    });

    // --- resume execution (single) ---
    it("resume_execution", async () => {
        const e = await createdExecution(PAUSE_FLOW, "PAUSED");
        await kestraClient().Executions.resumeExecution({
            executionId: e.id ?? "",
            body: [],
        });
        const done = await awaitExecution(e.id ?? "", "SUCCESS", 2000, 100);
        expect(done.state?.current).toBe("SUCCESS");
    });

    // --- resume by ids ---
    it("resume_executions_by_ids", async () => {
        const e1 = await createdExecution(PAUSE_FLOW, "PAUSED");
        const e2 = await createdExecution(PAUSE_FLOW, "PAUSED");
        const bulk = getDataOrThrow(await kestraClient().Executions.resumeExecutionsByIds(
            { body: [e1.id, e2.id] },
        ));
        expect(bulk.count).toBe(2);
        const d1 = await awaitExecution(e1.id, "SUCCESS", 2000, 100);
        const d2 = await awaitExecution(e2.id, "SUCCESS", 2000, 100);
        expect(d1.state.current).toBe("SUCCESS");
        expect(d2.state.current).toBe("SUCCESS");
    });

    // --- resume by query ---
    it("resume_executions_by_query", async () => {
        const e1 = await createdExecution(PAUSE_FLOW, "PAUSED");
        const e2 = await createdExecution(PAUSE_FLOW, "PAUSED");
        const filters = [
            qf({
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [e1.namespace, e2.namespace],
            }),
        ];
        const resp = getDataOrThrow(await kestraClient().Executions.resumeExecutionsByQuery(
            { filters: filters },
        ));
        expect(resp.count).toBe(2);
        const d1 = await awaitExecution(e1.id, "SUCCESS", 2000, 100);
        const d2 = await awaitExecution(e2.id, "SUCCESS", 2000, 100);
        expect(d1.state.current).toBe("SUCCESS");
        expect(d2.state.current).toBe("SUCCESS");
    });

    // --- search executions ---
    it("search_executions", async () => {
        const ns = randomId();
        const flowId = randomId();
        const e1 = await createFlowWithExecution(flowId, ns);
        const e2 = getDataOrThrow(await kestraClient().Executions.createExecution(
            { namespace: ns, id: flowId, wait: false },
        ));
        await Promise.all(new Array(3).fill(1)
            .map(() => kestraClient().Executions.createExecution(
                { namespace: ns, id: flowId, wait: false },
            ))
        );

        const sort = ["state.startDate:asc"];
        const filters = [
            qf({
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.EQUALS,
                value: [ns],
            }),
        ];

        const page1 = getDataOrThrow(await kestraClient().Executions.searchExecutions(
            { page: 1, size: 2, sort: sort, filters: filters },
        ));
        expect(page1.total).toBe(5);
        expect(page1.results.length).toBe(2);
        expect(page1.results[0].id).toBe(e1.id);
        expect(page1.results[1].id).toBe(e2.id);

        const page3 = getDataOrThrow(await kestraClient().Executions.searchExecutions(
            { page: 3, size: 2, sort: sort, filters: filters },
        ));
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
        await kestraClient().Executions.setLabelsOnTerminatedExecution({
            executionId: e.id ?? "",
            body: labels,
        });
        const after = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: e.id ?? "",
        }));
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

    // --- set labels by ids ---
    it("set_labels_on_terminated_executions_by_ids", async () => {
        const a = await createdExecution(LOG_FLOW, "SUCCESS");
        const b = await createdExecution(LOG_FLOW, "SUCCESS");
        const c = await createdExecution(LOG_FLOW, "SUCCESS");

        const labels = [
            { key: "foo", value: "bar" },
            { key: "terminated", value: "yes" },
        ];
        const bulk =
            getDataOrThrow(await kestraClient().Executions.setLabelsOnTerminatedExecutionsByIds({ executionsId: [a.id ?? "", b.id ?? ""], executionLabels: labels }));
        expect(bulk.count).toBe(2);

        const a2 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: a.id ?? "",
        }));
        const b2 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: b.id ?? "",
        }));
        const c2 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: c.id ?? "",
        }));

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
            qf({
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [a.namespace, b.namespace],
            }),
        ];
        const resp =
            getDataOrThrow(await kestraClient().Executions.setLabelsOnTerminatedExecutionsByQuery({
                filters: filters,
                body: labels
            }));
        expect(resp.count).toBe(2);

        const a2 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: a.id ?? ""
        }));
        const b2 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: b.id ?? ""
        }));
        const c2 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: c.id ?? ""
        }));

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
            getDataOrThrow(await kestraClient().Executions.triggerExecutionByGetWebhook({
                namespace,
                id,
                key: "a-secret-key",
            }));
        expect(resp).toBeTruthy();
        const done = await awaitExecution(resp.id, "SUCCESS", 5000, 100);
        expect(done.state?.current).toBe("SUCCESS");
    });

    // --- unqueue (single) ---
    it("unqueue_execution", async () => {
        const namespace = randomId();
        const id = randomId();
        await createSimpleFlow(id, namespace, SLEEP_CONCURRENCY_FLOW);

        const running = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace,
            id,
            wait: false,
        }));
        await awaitExecution(running.id, "RUNNING", 1500, 100);
        const queued = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace,
            id,
            wait: false,
        }));
        await awaitExecution(queued.id, "QUEUED", 1500, 100);

        const resp = getDataOrThrow(await kestraClient().Executions.unqueueExecution({
            executionId: queued.id,
            state: "RUNNING",
        }));
        expect(resp.state?.current).toBe("RUNNING");
        const after = await awaitExecution(queued.id, "RUNNING", 1500, 100);
        expect(after.state?.current).toBe("RUNNING");
    });

    // --- unqueue by ids ---
    it("unqueue_executions_by_ids", async () => {
        const namespace = randomId();
        const id = randomId();
        await createSimpleFlow(id, namespace, SLEEP_CONCURRENCY_FLOW);

        const running = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace,
            id,
            wait: false,
        }));
        await awaitExecution(running.id, "RUNNING", 1500, 100);
        const q1 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace,
            id,
            wait: false,
        }));
        await awaitExecution(q1.id, "QUEUED", 1500, 100);
        const q2 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace,
            id,
            wait: false,
        }));
        await awaitExecution(q2.id, "QUEUED", 1500, 100);

        const bulk = getDataOrThrow(await kestraClient().Executions.unqueueExecutionsByIds({
            state: "RUNNING",
            body: [q1.id, q2.id],
        }));
        expect(bulk.count).toBe(2);

        const a1 = await awaitExecution(q1.id, "RUNNING", 1500, 100);
        const a2 = await awaitExecution(q2.id, "RUNNING", 1500, 100);
        expect(a1.state?.current).toBe("RUNNING");
        expect(a2.state?.current).toBe("RUNNING");
    });

    // --- unqueue by query ---
    it("unqueue_executions_by_query", async () => {
        const namespace = randomId();
        const id = randomId();
        await createSimpleFlow(id, namespace, SLEEP_CONCURRENCY_FLOW);

        const running = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace,
            id,
            wait: false,
        }));
        await awaitExecution(running.id, "RUNNING", 1500, 100);
        const q1 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace,
            id,
            wait: false,
        }));
        await awaitExecution(q1.id, "QUEUED", 1500, 100);
        const q2 = getDataOrThrow(await kestraClient().Executions.createExecution({
            namespace,
            id,
            wait: false,
        }));
        await awaitExecution(q2.id, "QUEUED", 1500, 100);

        const filters = [
            qf({
                field: QF_FIELD.QUERY,
                operation: QF_OP.EQUALS,
                value: [q1.id],
            }),
        ];
        const resp = getDataOrThrow(await kestraClient().Executions.unqueueExecutionsByQuery({
            filters: filters,
            newState: "RUNNING",
        }));
        expect(resp.count).toBeGreaterThanOrEqual(1);

        const a1 = await awaitExecution(q1.id, "RUNNING", 1500, 100);
        expect(a1.state?.current).toBe("RUNNING");
    });

    // --- update status (single) ---
    it("update_execution_status", async () => {
        const e = await createdExecution(LOG_FLOW, "SUCCESS");
        const updated = getDataOrThrow(await kestraClient().Executions.updateExecutionStatus({
            executionId: e.id ?? "",
            status: "CANCELLED",
        }));
        expect(updated.state?.current).toBe("CANCELLED");
        const fetched = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: e.id ?? "",
        }));
        expect(fetched.state?.current).toBe("CANCELLED");
    });

    // --- update status by ids ---
    it("update_executions_status_by_ids", async () => {
        const e1 = await createdExecution(LOG_FLOW, "SUCCESS");
        const e2 = await createdExecution(LOG_FLOW, "SUCCESS");
        const other = await createdExecution(LOG_FLOW, "SUCCESS");

        const bulk = getDataOrThrow(await kestraClient().Executions.updateExecutionsStatusByIds({
            newStatus: "CANCELLED",
            body: [e1.id ?? "", e2.id ?? ""],
        }));
        expect(bulk.count).toBe(2);

        const s1 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: e1.id ?? "",
        }));
        const s2 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: e2.id ?? "",
        }));
        const sO = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: other.id ?? "",
        }));
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
            qf({
                field: QF_FIELD.NAMESPACE,
                operation: QF_OP.IN,
                value: [e1.namespace, e2.namespace],
            }),
        ];
        const bulk = getDataOrThrow(await kestraClient().Executions.updateExecutionsStatusByQuery({
            newStatus: "CANCELLED",
            filters: filters,
        }));
        expect(bulk.count).toBe(2);

        const s1 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: e1.id ?? "",
        }));
        const s2 = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: e2.id ?? "",
        }));
        const sO = getDataOrThrow(await kestraClient().Executions.execution({
            executionId: other.id ?? "",
        }));
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

    it.skip("follow_execution (SSE/WebSocket required)", async () => { });
    it.skip("follow_dependencies_execution (SSE/WebSocket required)", async () => { });
});
