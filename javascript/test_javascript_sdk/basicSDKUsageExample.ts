/**
 * Basic, runnable usage example for the Kestra JavaScript SDK.
 *
 * The region between the `region:`/`endregion` markers below is the *single
 * source of truth* for the usage snippet in `README_JAVASCRIPT_SDK.md`: it is
 * injected verbatim by `test-utils/embed_snippets.py` and exercised against a
 * live Kestra by `basicSDKUsageExample.spec.ts`. Keeping the README snippet
 * physically identical to tested code is what stops the docs from drifting
 * (issue #144), so edit the example here — never the README block — and re-run
 * the injector:
 *
 *     python3 test-utils/embed_snippets.py --write README_JAVASCRIPT_SDK.md
 *
 * The shared `client` is configured by the caller (the README shows how, just
 * above the injected block); `tenant` is passed in. The region body is written
 * flush-left so the YAML literal stays at column 0 (valid flow source) and the
 * injector dedents it cleanly.
 */
import { configureClient } from "@kestra-io/kestra-sdk";
import * as FlowsAPI from "@kestra-io/kestra-sdk/flows";
import * as ExecutionsAPI from "@kestra-io/kestra-sdk/executions";
import fixtures from "./fixtures.json" with { type: "json" };

const { baseURL, username, password } = fixtures;

export function dedent(strings: TemplateStringsArray, ...values: string[]) {
    const raw = strings.raw.reduce((acc, str, i) => acc + str + (values[i] ?? ""), "");
    const lines = raw.split("\n");
    const indent = lines.reduce((min, line) => {
        if (line.trim() === "") return min;
        const match = line.match(/^(\s*)/);
        return match ? Math.min(min, match[1].length) : min;
    }, Infinity);
    return lines.map(line => line.slice(indent)).join("\n").trim();
}

export async function flowLifecycleExample(tenant: string) {
    configureClient({
        baseUrl: baseURL,
        auth: () => `${username}:${password}`,
    });

    // region:flow-lifecycle
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
    // endregion

    return execution;
}
