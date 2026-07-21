import type { UserConfig } from "@hey-api/openapi-ts";
import * as path from "path";
import { fileURLToPath } from "url";
// The one openapi-ts plugin for the whole product: @kestra-io/hey-api-plugin, maintained in the
// OSS monorepo (kestra/ui/packages/hey-api-plugin) and published to npm. Consumed here instead of
// a forked local copy so the client-sdk, the OSS UI SDK and the EE UI SDK all generate identically.
import { defineConfigKestraHeyOptionalTenant } from "@kestra-io/hey-api-plugin";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

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
