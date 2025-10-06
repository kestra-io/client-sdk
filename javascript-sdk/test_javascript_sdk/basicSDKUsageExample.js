import KestraClient from "../src/KestraClient";

const host = "http://localhost:9903"
const username = "admin@kestra.io"
const password = "Admin1234"
const tenantId = "main";

export async function searchAndCreateFlowsExample() {
    const kestraClient = new KestraClient(host, null, username, password);

    const searchRes = await new Promise(function(resolve, reject) {
        let promisify = (err, data, res) => {
            if(err){
                console.error(`error while calling KestraClient: ${err}, res: ${res}`)
                return reject(err);
            }
            return resolve({data, res});
        };
        kestraClient.flowsApi.searchFlows(1, 10, tenantId, null,
            promisify);
    });
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
    const createRes = await new Promise(function(resolve, reject) {
        kestraClient.flowsApi.createFlow(tenantId, flow, (err, data, res) => err ? reject(err) : resolve(data));
    });
    console.log(createRes);

}
