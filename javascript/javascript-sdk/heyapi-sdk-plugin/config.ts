import { definePluginConfig } from "@hey-api/openapi-ts";
import { handler } from "./plugin";
import type { KestraSdkPlugin } from "./types";

const defaultConfig: KestraSdkPlugin["Config"] = {
    config: {
        output: "kestra-sdk",
        methodNameBuilder(operation) {
            // if its a typescript reserved name, use
            // load as a prefix to avoid conflict
            if (operation.operationId === "namespace") {
                return `load${operation.operationId[0].toUpperCase()}${operation.operationId.slice(1)}`;
            }
            return operation.operationId
        }
    },
    dependencies: ["@hey-api/typescript", "@hey-api/client-axios", "@hey-api/sdk"],
    handler,
    name: "ks-sdk",
};

export const defineConfigKestraHeyOptionalTenant = definePluginConfig(defaultConfig);