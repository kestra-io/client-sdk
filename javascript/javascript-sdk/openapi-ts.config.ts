import type { UserConfig } from "@hey-api/openapi-ts";
import * as path from "path";
import { fileURLToPath } from "url";
import { defineConfigKestraHeyOptionalTenant } from "./heyapi-sdk-plugin";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// KVController reads `ttl` and `description` straight off the request headers,
// so the published spec does not declare them; declare them here so the
// generated `setKeyValue` accepts both.
const KV_SET_HEADERS = [
    { name: "ttl", description: "How long the key lives, as an ISO-8601 duration (e.g. PT1H)" },
    { name: "description", description: "The description of the key" },
];

const addKvSetHeaders = (_method: string, _path: string, operation: any): void => {
    if (operation?.operationId !== "setKeyValue") return;
    operation.parameters ??= [];
    for (const { name, description } of KV_SET_HEADERS) {
        const declared = operation.parameters.some((p: any) => p?.in === "header" && p?.name === name);
        if (declared) continue;
        operation.parameters.push({ name, in: "header", description, required: false, schema: { type: "string" } });
    }
};

const generateHash = (str: string) => {
    let hash = 0;
    for (const char of str) {
        hash = (hash << 5) - hash + char.charCodeAt(0);
        hash |= 0; // Constrain to 32bit integer
    }
    return hash.toString(16).replace("-", "0");
};

export default {
    input: path.resolve(__dirname, "../../kestra-ee.sanitized.yml"),
    parser: {
        patch: {
            operations: (method: string, path: string, operation: any): void => {
                addKvSetHeaders(method, path, operation);
            },
        },
    },
    output: {
        path: path.resolve(__dirname, "./src/openapi"),
        postProcess: [
            {
                command: "node",
                args: ["scripts/convert-openapi-sdk-functions.mjs", "{{path}}"],
            },
        ],
    },

    plugins: [
        {
            name: "@hey-api/client-axios",
            throwOnError: true,
        },
        {
            name: "@hey-api/sdk",
            paramsStructure: "flat",
            operations: {
                methodName(operation) {
                    return `__${generateHash(operation)}__`
                },
            }
        },
        defineConfigKestraHeyOptionalTenant()
    ],
} satisfies UserConfig
