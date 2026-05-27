import { definePluginConfig } from "@hey-api/openapi-ts";
import { handler } from "./plugin";
import type { KestraSdkPlugin } from "./types";

const defaultConfig: KestraSdkPlugin["Config"] = {
    config: {
        output: "kestra-sdk",
        methodNameBuilder(operation) {
            // if its the "namespace" typescript reserved name, use
            // load as a prefix to avoid conflict
            if (operation.operationId === "namespace") {
                return `loadNamespace`;
            }
            if (["get", "delete"].includes(operation.operationId)) {
                const tag = operation.tags?.[0] ?? "default";
                return operation.operationId + tag.charAt(0).toUpperCase() + tag.slice(1);
            }
            return operation.operationId
        }
    },
    dependencies: ["@hey-api/typescript", "@hey-api/client-axios", "@hey-api/sdk"],
    handler,
    name: "ks-sdk",
};

export const defineConfigKestraHeyOptionalTenant = definePluginConfig(defaultConfig);