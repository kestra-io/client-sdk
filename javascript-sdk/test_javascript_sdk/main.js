import {KestraClient} from "@kestra-io/kestra-api";

const host = "http://localhost:8080"
const username = "root@root.com"
const password = "Root!1234"
const token = "UDXY2MY3DJX2NUE7HAH7CPWK3AUKXTVL2HGXFA5DT73HZLCAJ3HFOCJKBIR3GSKGTJBVDBPO2P353ZIDD2GMDAEEN7MLCHY25GUCIE6R2ZKKLID5PFUFYR6H7IX3T35CLYGT4PU7IGOB7XX6GJEV5W5IJU2XEQTMGAYFCOLQGNEUS6DXPIZEYUCUGR5GU";
const tenantId = "test";


function callback(error, data, response, source) {
    if (error) {
        console.log("Source: " + source);
        console.error(error);
    } else {
        console.log("Source: " + source);
        console.log("Response: ", response.statusCode);
        console.log("API called successfully. Returned data: " + JSON.stringify(data));
    }
}

const kestraClient = new KestraClient(host, null, username, password);

kestraClient.flowsApi.searchFlows(1, 10, tenantId, null, (err, data, res) => callback(err, data, res, "searchFlows"))

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
kestraClient.flowsApi.createFlow(tenantId, flow, (err, data, res) => callback(err, data, res, "createFlow"));


