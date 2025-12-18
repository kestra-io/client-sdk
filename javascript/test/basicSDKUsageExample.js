// @ts-check
import {client, Flows} from "@kestra-io/kestra-sdk";

const baseUrl = "http://localhost:9903"
const username = "root@root.com"
const password = "Root!1234"
const tenantId = "main";

export async function searchAndCreateFlowsExample() {
    client.setConfig({
        baseUrl,
        headers: {
            "Authorization": "Basic " + Buffer.from(username + ":" + password).toString("base64"),
        }
    });

    const searchRes = await Flows.searchFlows({
        page: 1,
        size: 10,
        tenant: tenantId,
    })
    console.log(searchRes);

    const flowId = "flow-" + Math.floor(Math.random() * 1000)
    const namespace = "namespace-" + Math.floor(Math.random() * 1000);
    const flow = `
id: ${flowId}
namespace: ${namespace}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
`;

    console.log("Creating flow with id: " + flowId + " in namespace: " + namespace);

    console.log("flows api: ", Flows);
    const createRes = await Flows.createFlow({
        tenant: tenantId,
        body: flow,
    });
    console.log(createRes);

}
