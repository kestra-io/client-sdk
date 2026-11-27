import { describe, it, expect } from "vitest";
import { restoreContentlessYamlRequestBodies, unwrapSseEventResponses } from "./openapi-customizer";

const eventSchemas = {
    Event_Execution_: {
        type: "object",
        properties: {
            data: { $ref: "#/components/schemas/Execution" },
            id: { type: "string" },
            name: { type: "string" },
            comment: { type: "string" },
            retry: { type: "string" },
        },
    },
    Execution: { type: "object", properties: { id: { type: "string" } } },
};

const sseSpec = (schema: unknown) => ({
    paths: {
        "/executions/{id}/follow": {
            get: {
                operationId: "followExecution",
                responses: { "200": { content: { "text/event-stream": { schema } } } },
            },
        },
    },
    components: { schemas: eventSchemas },
});

describe("unwrapSseEventResponses", () => {
    it("unwraps a bare Event<X> $ref", () => {
        const spec = sseSpec({ $ref: "#/components/schemas/Event_Execution_" });

        expect(unwrapSseEventResponses(spec)).toBe(1);
        expect(spec.paths["/executions/{id}/follow"].get.responses["200"].content["text/event-stream"].schema)
            .toEqual({ $ref: "#/components/schemas/Execution" });
    });

    it("unwraps an array of Event<X>, since each SSE frame carries a single object", () => {
        const spec = sseSpec({ type: "array", items: { $ref: "#/components/schemas/Event_Execution_" } });

        expect(unwrapSseEventResponses(spec)).toBe(2);
        expect(spec.paths["/executions/{id}/follow"].get.responses["200"].content["text/event-stream"].schema)
            .toEqual({ $ref: "#/components/schemas/Execution" });
    });

    it("drops the array of a stream whose item is not an Event<X> wrapper", () => {
        const spec = sseSpec({ type: "array", items: { $ref: "#/components/schemas/Execution" } });

        expect(unwrapSseEventResponses(spec)).toBe(1);
        expect(spec.paths["/executions/{id}/follow"].get.responses["200"].content["text/event-stream"].schema)
            .toEqual({ $ref: "#/components/schemas/Execution" });
    });
});

describe("restoreContentlessYamlRequestBodies", () => {
    const bodySpec = (requestBody: unknown) => ({
        paths: {
            "/flows/{namespace}": {
                post: { operationId: "updateFlowsInNamespace", requestBody },
            },
        },
    });

    it("gives back a YAML body to a requestBody that lost its content", () => {
        const spec = bodySpec({ description: "A list of flows source code" });

        expect(restoreContentlessYamlRequestBodies(spec)).toBe(1);
        expect(spec.paths["/flows/{namespace}"].post.requestBody).toEqual({
            description: "A list of flows source code",
            required: true,
            content: {
                "application/x-yaml": { schema: { type: "string" } },
                "application/yaml": { schema: { type: "string" } },
            },
        });
    });

    it("leaves a requestBody that declares content alone", () => {
        const content = { "application/json": { schema: { type: "object" } } };
        const spec = bodySpec({ content });

        expect(restoreContentlessYamlRequestBodies(spec)).toBe(0);
        expect(spec.paths["/flows/{namespace}"].post.requestBody).toEqual({ content });
    });
});
