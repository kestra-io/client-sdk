import { beforeAll } from "vitest";
import { setSelectedTenant } from "@kestra-io/kestra-sdk/shared";
import { configureClient } from "@kestra-io/kestra-sdk";
import * as Ai from "@kestra-io/kestra-sdk/ai";
import * as Apps from "@kestra-io/kestra-sdk/apps";
import * as AuditLogs from "@kestra-io/kestra-sdk/audit-logs";
import * as Auths from "@kestra-io/kestra-sdk/auths";
import * as Banners from "@kestra-io/kestra-sdk/banners";
import * as Bindings from "@kestra-io/kestra-sdk/bindings";
import * as Blueprints from "@kestra-io/kestra-sdk/blueprints";
import * as BlueprintTags from "@kestra-io/kestra-sdk/blueprint-tags";
import * as Cluster from "@kestra-io/kestra-sdk/cluster";
import * as Dashboards from "@kestra-io/kestra-sdk/dashboards";
import * as Executions from "@kestra-io/kestra-sdk/executions";
import * as Files from "@kestra-io/kestra-sdk/files";
import * as Flows from "@kestra-io/kestra-sdk/flows";
import * as Groups from "@kestra-io/kestra-sdk/groups";
import * as Invitations from "@kestra-io/kestra-sdk/invitations";
import * as Kv from "@kestra-io/kestra-sdk/kv";
import * as Login from "@kestra-io/kestra-sdk/login";
import * as Logs from "@kestra-io/kestra-sdk/logs";
import * as Maintenance from "@kestra-io/kestra-sdk";
import * as Metrics from "@kestra-io/kestra-sdk/metrics";
import * as Misc from "@kestra-io/kestra-sdk/misc";
import * as Namespaces from "@kestra-io/kestra-sdk/namespaces";
import * as Plugins from "@kestra-io/kestra-sdk/plugins";
import * as Roles from "@kestra-io/kestra-sdk/roles";
import * as ScimConfiguration from "@kestra-io/kestra-sdk/scim-configuration";
import * as ScimGroups from "@kestra-io/kestra-sdk/scim-groups";
import * as ScimUsers from "@kestra-io/kestra-sdk/scim-users";
import * as Secrets from "@kestra-io/kestra-sdk/secrets";
import * as SecurityIntegrations from "@kestra-io/kestra-sdk/security-integrations";
import * as ServiceAccount from "@kestra-io/kestra-sdk/service-account";
import * as Services from "@kestra-io/kestra-sdk/services";
import * as TenantAccess from "@kestra-io/kestra-sdk/tenant-access";
import * as Tenants from "@kestra-io/kestra-sdk/tenants";
import * as TestSuites from "@kestra-io/kestra-sdk/test-suites";
import * as Triggers from "@kestra-io/kestra-sdk/triggers";
import * as Users from "@kestra-io/kestra-sdk/users";
import * as WorkerGroups from "@kestra-io/kestra-sdk/worker-groups";
import * as path from "node:path";
import { readFileSync } from "node:fs";

export const baseUrl = "http://localhost:9903";
export const username = "root@root.com";
export const password = "Root!1234";
export const MAIN_TENANT = "main";

beforeAll(async () => {
    const instance = configureClient({
        auth: () => {
            return username + ":" + password;
        },
        baseUrl,
    });

    if (process.env.DEBUG) {
        instance.interceptors.request.use((request) => {
            //log the request method and url for debugging purposes
            console.log(`[${request.method?.toUpperCase()}] ${request.url}`, request.headers.get("Content-Type"));
            return request;
        });

        instance.interceptors.response.use((response) => {
            // when error log the response status and data for debugging purposes
            if (!response.ok) {
                console.error(`[${response.status}] ${response.url}`, response.statusText);
            }
            return response;
        });
    }
    setSelectedTenant(MAIN_TENANT);
});

export const kestraClient = {
    Ai,
    Apps,
    AuditLogs,
    Auths,
    Banners,
    Bindings,
    Blueprints,
    BlueprintTags,
    Cluster,
    Dashboards,
    Executions,
    Files,
    Flows,
    Groups,
    Invitations,
    Kv,
    Login,
    Logs,
    Maintenance,
    Metrics,
    Misc,
    Namespaces,
    Plugins,
    Roles,
    ScimConfiguration,
    ScimGroups,
    ScimUsers,
    Secrets,
    SecurityIntegrations,
    ServiceAccount,
    Services,
    TenantAccess,
    Tenants,
    TestSuites,
    Triggers,
    Users,
    WorkerGroups,
};

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
        : path.resolve(process.cwd(), filePath);
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
