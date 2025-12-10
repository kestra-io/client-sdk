import KestraClient from "@kestra-io/kestra-api";

const host = "http://localhost:9903"
const username = "root@root.com"
const password = "Root!1234"
const tenantId = "main";

export async function searchAndCreateFlowsExample() {
    const kestraClient = new KestraClient({basePath: host, username, password});

    const searchRes = await kestraClient.flowsApi.searchFlows(1, 10, tenantId, null);
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

    console.log("flows api: ", kestraClient.flowsApi);
    const createRes = await kestraClient.flowsApi.createFlow({tenantId, flow);
    console.log(createRes);

}
