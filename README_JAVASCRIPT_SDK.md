# JavaScript SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` if necessary with latest openspec api changes.
2. Generate the SDK using the script `generate-sdks.sh` that uses the openapi-generator-cli docker image.

## Installation

```bash
npm install @kestra-io/kestra-sdk
```

## Usage

The SDK is organized into domain-specific modules (e.g. `flows`, `executions`, `apps`, `plugins`). Import only the modules you need to keep your bundle lean and benefit from tree-shaking.

### Configure the client

Import and configure the shared HTTP client once, at the entry point of your application:

```ts
import { client } from "@kestra-io/kestra-sdk/client";

client.setConfig({
    baseURL: "https://<your-kestra-host>",
    auth: () => "<username>:<password>",
});
```

For token-based authentication, pass the token directly:

```ts
client.setConfig({
    baseURL: "https://<your-kestra-host>",
    auth: () => "<your-api-token>",
});
```

### Import domain modules

Each domain is a separate entry point. Import them with a namespace alias to keep call sites readable:

```ts
import * as FlowsAPI      from "@kestra-io/kestra-sdk/flows";
import * as ExecutionsAPI from "@kestra-io/kestra-sdk/executions";
import * as AppsAPI       from "@kestra-io/kestra-sdk/apps";
import * as PluginsAPI    from "@kestra-io/kestra-sdk/plugins";
```

Other available domains:

```ts
import * as AiAPI                   from "@kestra-io/kestra-sdk/ai";
import * as AssetsAPI               from "@kestra-io/kestra-sdk/assets";
import * as AuditLogsAPI            from "@kestra-io/kestra-sdk/audit-logs";
import * as AuthsAPI                from "@kestra-io/kestra-sdk/auths";
import * as BannersAPI              from "@kestra-io/kestra-sdk/banners";
import * as BindingsAPI             from "@kestra-io/kestra-sdk/bindings";
import * as BlueprintTagsAPI        from "@kestra-io/kestra-sdk/blueprint-tags";
import * as BlueprintsAPI           from "@kestra-io/kestra-sdk/blueprints";
import * as ClusterAPI              from "@kestra-io/kestra-sdk/cluster";
import * as DashboardsAPI           from "@kestra-io/kestra-sdk/dashboards";
import * as FilesAPI                from "@kestra-io/kestra-sdk/files";
import * as GroupsAPI               from "@kestra-io/kestra-sdk/groups";
import * as InvitationsAPI          from "@kestra-io/kestra-sdk/invitations";
import * as KillSwitchesAPI         from "@kestra-io/kestra-sdk/kill-switches";
import * as KvAPI                   from "@kestra-io/kestra-sdk/kv";
import * as LoginAPI                from "@kestra-io/kestra-sdk/login";
import * as LogsAPI                 from "@kestra-io/kestra-sdk/logs";
import * as MetricsAPI              from "@kestra-io/kestra-sdk/metrics";
import * as MiscAPI                 from "@kestra-io/kestra-sdk/misc";
import * as NamespacesAPI           from "@kestra-io/kestra-sdk/namespaces";
import * as OutputsAPI              from "@kestra-io/kestra-sdk/outputs";
import * as RolesAPI                from "@kestra-io/kestra-sdk/roles";
import * as ScimConfigurationAPI    from "@kestra-io/kestra-sdk/scim-configuration";
import * as ScimGroupsAPI           from "@kestra-io/kestra-sdk/scim-groups";
import * as ScimUsersAPI            from "@kestra-io/kestra-sdk/scim-users";
import * as SecretsAPI              from "@kestra-io/kestra-sdk/secrets";
import * as SecurityIntegrationsAPI from "@kestra-io/kestra-sdk/security-integrations";
import * as ServiceAccountAPI       from "@kestra-io/kestra-sdk/service-account";
import * as ServicesAPI             from "@kestra-io/kestra-sdk/services";
import * as SharedAPI               from "@kestra-io/kestra-sdk/shared";
import * as TenantAccessAPI         from "@kestra-io/kestra-sdk/tenant-access";
import * as TenantsAPI              from "@kestra-io/kestra-sdk/tenants";
import * as TestSuitesAPI           from "@kestra-io/kestra-sdk/test-suites";
import * as TriggersAPI             from "@kestra-io/kestra-sdk/triggers";
import * as UsersAPI                from "@kestra-io/kestra-sdk/users";
import * as WorkerAuthAPI           from "@kestra-io/kestra-sdk/worker-auth";
import * as WorkerGroupsAPI         from "@kestra-io/kestra-sdk/worker-groups";
```

### Example: a flow lifecycle

Configure the client once (see [Configure the client](#configure-the-client)), pick a tenant, then
call the domain modules:

```ts
import { client } from "@kestra-io/kestra-sdk/client";
import * as FlowsAPI from "@kestra-io/kestra-sdk/flows";
import * as ExecutionsAPI from "@kestra-io/kestra-sdk/executions";

client.setConfig({
    baseURL: "https://<your-kestra-host>",
    auth: () => "root@root.com:Root!1234",
});

const tenant = "main";
```

The snippet below — search flows, create one, then trigger an execution and wait for it — is injected
from `javascript/test_javascript_sdk/basicSDKUsageExample.ts`, which runs in CI against a live Kestra,
so it stays in sync with the SDK. Edit the example there (not this block) and re-run the injector with
`python3 test-utils/embed_snippets.py --write README_JAVASCRIPT_SDK.md`.

<!-- snippet:flow-lifecycle src=javascript/test_javascript_sdk/basicSDKUsageExample.ts lang=ts -->
```ts
const namespace = "company.team";
const flowId = "hello_from_sdk";

// List the first page of flows in the tenant.
const flows = await FlowsAPI.searchFlows({ tenant, page: 1, size: 10 });
console.log(`Found ${flows.results?.length ?? 0} flows`);

// Create a flow from its YAML source.
const flow = dedent`
    id: ${flowId}
    namespace: ${namespace}

    tasks:
      - id: hello
        type: io.kestra.plugin.core.log.Log
        message: Hello from the Kestra JavaScript SDK!
`;
const created = await FlowsAPI.createFlow({ tenant, body: flow });
console.log(`Created flow ${created.namespace}.${created.id}`);

// Trigger an execution of that flow and wait for it to finish.
const execution = await ExecutionsAPI.createExecution({
    tenant,
    namespace,
    id: flowId,
    wait: true,
});
console.log(`Execution ${execution.id} finished in state ${execution.state?.current}`);
```
<!-- /snippet -->
