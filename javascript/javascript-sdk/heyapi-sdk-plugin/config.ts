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
                const capitalizedTag = tag.charAt(0).toUpperCase()
                    + tag.slice(1).replace(/[_ ][a-zA-Z0-9]/g, (match: string) =>
                        match.charAt(1).toUpperCase()
                    ).replace(/[^a-zA-Z0-9]/g, '');
                return operation.operationId + capitalizedTag;
            }
            return operation.operationId
        }
    },
    dependencies: ["@hey-api/typescript", "@hey-api/client-axios", "@hey-api/sdk"],
    handler,
    name: "ks-sdk",
};

export const defineConfigKestraHeyOptionalTenant = definePluginConfig(defaultConfig);