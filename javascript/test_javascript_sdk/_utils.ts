import * as path from "node:path";
import { readFileSync } from "node:fs";

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