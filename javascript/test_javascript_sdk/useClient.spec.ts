import { describe, it, expect, beforeAll } from "vitest";
import { configureAxios, useClient } from "@kestra-io/kestra-sdk";
import fixtures from "./fixtures.json" with { type: "json" };

const { baseURL, username, password, tenantId } = fixtures;

const textYamlHeader = {
    headers: {
        "Content-Type": "application/x-yaml",
    },
}

const VALIDATE = { validateStatus: (status: number) => status === 200 || status === 401 }

describe("useClient", () => {
    beforeAll(() => {
        const instance = configureAxios({
            auth: username + ":" + password,
        })
        instance.defaults.headers.common["Authorization"] = `Basic ${Buffer.from(username + ":" + password).toString("base64")}`;
    });

    it("should be able to call all get methods from a client by URL", async () => {
        const clientObj = useClient();
        const me: any = await clientObj.get(`${baseURL}/api/v1/me`);
        expect(me.data).toBeDefined();
    });

    it("should be able to call post methods from a client by URL", async () => {
        const clientObj = useClient();
        const flowId = `test-flow-${Math.floor(Math.random() * 1000)}`;
        const namespace = `test-namespace-${Math.floor(Math.random() * 1000)}`;

        const body = `id: ${flowId}
namespace: ${namespace}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
`;
        const flow: any = await clientObj.post(`${baseURL}/api/v1/${tenantId}/flows`, body, {
            ...textYamlHeader,
            ...VALIDATE,
        }); // Example of a POST request, adjust as needed
        expect(flow.data).toBeDefined();
    });

    it("should be able to call put methods from a client by URL", async () => {
        const clientObj = useClient();
        const flowId = `test-flow-${Math.floor(Math.random() * 1000)}`;
        const namespace = `test-namespace-${Math.floor(Math.random() * 1000)}`;

        const body = `id: ${flowId}
namespace: ${namespace}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
`;

        const body2 = `id: ${flowId}
namespace: ${namespace}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
  - id: hello2
    type: io.kestra.plugin.core.log.Log
    message: Hello World!2 🚀`

        await clientObj.post(`${baseURL}/api/v1/${tenantId}/flows`, body, {
            ...textYamlHeader,
            ...VALIDATE,
        });

        const flow2: any = await clientObj.put(`${baseURL}/api/v1/${tenantId}/flows/${namespace}/${flowId}`, body2, {
            ...textYamlHeader,
            ...VALIDATE,
        });
        expect(flow2.data).toBeDefined();
    });

    it("should be able to call delete methods from a client by URL", async () => {
        const clientObj = useClient();
        const flowId = `test-flow-${Math.floor(Math.random() * 1000)}`;
        const namespace = `test-namespace-${Math.floor(Math.random() * 1000)}`;

        const body = `id: ${flowId}
namespace: ${namespace}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
`;

        await clientObj.post(`${baseURL}/api/v1/${tenantId}/flows`, body, {
            ...textYamlHeader,
            ...VALIDATE,
        });

        const delRes: any = await clientObj.delete(`${baseURL}/api/v1/${tenantId}/flows/${namespace}/${flowId}`);
        expect(delRes.status).toBe(204);

        const allFlowsInNamespace: any = await clientObj.get(`${baseURL}/api/v1/${tenantId}/flows/${namespace}`);
        const flowIds = allFlowsInNamespace.data.map((f: any) => f.id);
        expect(flowIds).not.toContain(flowId);
    });
});