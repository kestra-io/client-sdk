import * as path from "node:path";
import { readFileSync } from "node:fs";
import * as Executions from '@kestra-io/kestra-sdk/executions';

export function randomId() {
    return Math.random().toString(36).substring(2, 10);
}

export function randomIdWith(str: string) {
    return Math.random().toString(36).substring(2, 10) + str;
}

export function randomEmail() {
    return randomId() + "@example.com";
}

export const TEST_DATA_PATH = "../../test-utils";

/**
 * Largest `size` any list/search endpoint accepts. The server enforces this in
 * `PageableUtils.from(...)` (the choke point every OSS + EE list/search endpoint
 * routes through) and documents it as `maximum: 1000` on each `size` query
 * param; anything above it is rejected with a 422.
 */
export const MAX_PAGE_SIZE = 1000;

const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

/**
 * Polls until an execution has succeeded, and throws otherwise — on a terminal
 * failure as soon as it is seen, on anything else once `timeoutMs` is up.
 *
 * Never return to the caller with an execution that did not succeed: the
 * assertions that follow a fixture like this one (its logs, metrics or outputs
 * exist) would then fail for a reason unrelated to the endpoint under test, or
 * pass vacuously against an empty result.
 */
export async function waitForExecutionSuccess(executionId: string, timeoutMs = 10_000) {
    const terminalFailures = ["FAILED", "KILLED", "CANCELLED"];
    const deadline = Date.now() + timeoutMs;
    let state: string | undefined;

    while (Date.now() < deadline) {
        try {
            const execution = await Executions.execution({ executionId });
            state = (execution as any).state?.current;
            if (state === "SUCCESS" || state === "WARNING") return execution;
            if (state && terminalFailures.includes(state)) break;
        } catch (_) { /* the execution may not be in the DB yet */ }
        await sleep(500);
    }

    throw new Error(
        `Execution ${executionId} did not succeed within ${timeoutMs}ms `
        + `(last state: ${state ?? "unknown"}).`,
    );
}

export function get(filePath: string) {
    const absolute = path.isAbsolute(filePath)
        ? filePath
        : path.resolve(import.meta.dirname, filePath);
    return readFileSync(absolute, "utf8");
}

export function getCompleteFlow() {
    const raw = get(path.join(TEST_DATA_PATH, "flows", "flow_complete.yml"));
    return raw
        .split("flow_complete")
        .join(randomId())
        .split("tests")
        .join(randomId());
}

export function getSimpleFlow() {
    return getSimpleFlowAndId().flowBody;
}

export function getSimpleFlowAndId() {
    const flowId = randomId();
    const namespace = randomId();
    const raw = get(path.join(TEST_DATA_PATH, "flows", "simple_flow.yml"));

    const flowBody = raw
        .split("simple_flow_id_to_replace_by_random_id")
        .join(flowId)
        .split("simple_flow_namespace_to_replace_by_random_id")
        .join(namespace);

    return { flowBody, flowNamespace: namespace, flowId };
}