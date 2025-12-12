import KestraClient from "../src/KestraClient";
import * as path from "node:path";
import {readFileSync} from "node:fs";

export const host = "http://localhost:9903"
export const username = "root@root.com"
export const password = "Root!1234"
export const MAIN_TENANT = "main";

export function kestraClient() {
    return new KestraClient(host, null, username, password);
}
export function randomId() {
    return Math.random().toString(36).substring(2, 10);
}

export function randomIdWith(str) {
    return Math.random().toString(36).substring(2, 10) + str;
}

export function randomEmail() {
    return randomId() + '@example.com';
}

export const TEST_DATA_PATH = '../../test-utils';

export function get(filePath) {
    const absolute = path.isAbsolute(filePath)
        ? filePath
        : path.resolve(process.cwd(), filePath);
    return readFileSync(absolute, 'utf8');
}

export function getCompleteFlow() {
    const raw = get(path.join(TEST_DATA_PATH, 'flows', 'flow_complete.yml'));
    return raw
    .split('flow_complete').join(randomId())
    .split('tests').join(randomId());
}

export function getSimpleFlow() {
    return getSimpleFlowAndId().flowBody;
}

export function getSimpleFlowAndId() {
    const flowId = randomId();
    const namespace = randomId();
    const raw = get(path.join(TEST_DATA_PATH, 'flows', 'simple_flow.yml'));

    const flowBody = raw
    .split('simple_flow_id_to_replace_by_random_id').join(flowId)
    .split('simple_flow_namespace_to_replace_by_random_id').join(namespace);

    return { flowBody, flowNamespace: namespace, flowId };
}
