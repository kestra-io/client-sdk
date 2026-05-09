import { definePluginConfig } from "@hey-api/openapi-ts";
import { handler } from "./plugin";
import type { KestraSdkPlugin } from "./types";

const defaultConfig: KestraSdkPlugin["Config"] = {
    config: {
        output: "kestra-sdk",
        methodNameBuilder(operation) {
            return operation.operationId
        }
    },
    dependencies: ["@hey-api/typescript", "@hey-api/client-fetch", "@hey-api/sdk"],
    handler,
    name: "ks-sdk",
};

export const defineConfigKestraHeyOptionalTenant = definePluginConfig(defaultConfig);