import { client } from "@kestra-io/kestra-sdk/client";
import * as Flows from "@kestra-io/kestra-sdk/flows";
import { username, password, baseURL, tenantId } from "./CommonTestSetup.js";

export async function searchAndCreateFlowsExample() {
    client.setConfig({
        auth: () => {
            return username + ":" + password;
        },
        baseURL,
    });

    const searchRes = await Flows.searchFlows({
        page: 1,
        size: 10,
        tenant: tenantId,
    });

    const flowId = "flow-" + Math.floor(Math.random() * 1000);
    const namespace = "namespace-" + Math.floor(Math.random() * 1000);
    const flow = `
id: ${flowId}
namespace: ${namespace}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
`;

    const createRes = await Flows.createFlow({
        tenant: tenantId,
        body: flow,
    });
}
