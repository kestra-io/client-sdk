import type { UserConfig } from "@hey-api/openapi-ts";
import * as path from "path";
import { fileURLToPath } from "url";
import { defineConfigKestraHeyOptionalTenant, fixYamlSourceRequestBodyContentType } from "@kestra-io/hey-api-plugin";
import { defineEnterpriseOnlyRoutesPlugin } from "./enterprise-only-routes-plugin";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const YAML_MEDIA_TYPE = "application/x-yaml";
const RFC_YAML_MEDIA_TYPE = "application/yaml";

// Rewrite RFC-compliant `application/yaml` request bodies (introduced by the
// backend Micronaut migration) back to `application/x-yaml` so the #340 fix below
// still matches; both are accepted by the server (#444).
const normalizeYamlRequestBodyMediaType = (
    _method: string,
    _path: string,
    operation: any,
): void => {
    const content = operation?.requestBody?.content;
    if (!content || typeof content !== "object") return;
    const rfcYaml = content[RFC_YAML_MEDIA_TYPE];
    if (rfcYaml === undefined) return;
    if (content[YAML_MEDIA_TYPE] === undefined) content[YAML_MEDIA_TYPE] = rfcYaml;
    delete content[RFC_YAML_MEDIA_TYPE];
};

const NOTIFICATIONS_PATH_PREFIX = "/api/v1/notifications/";

// The notifications routes moved to OSS (kestra#19857) and the spec no longer declares `security`
// on them: the EE controller @Replaces the OSS one, and only the subclass is @Secured. The client
// then sent them unauthenticated and got a 401. Restore it; remove once kestra-ee fixes the spec.
const restoreNotificationsSecurity = (
    _method: string,
    path: string,
    operation: any,
): void => {
    if (!path.startsWith(NOTIFICATIONS_PATH_PREFIX) || operation.security) return;
    operation.security = [{ bearerAuth: [] }, { basicAuth: [] }];
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
            // hey-api prefers the application/json variant when resolving a request
            // body; force application/x-yaml for YAML-source bodies (issue #340).
            // normalize runs first so a migrated spec keeps matching (#444).
            operations: (method: string, path: string, operation: any): void => {
                normalizeYamlRequestBodyMediaType(method, path, operation);
                fixYamlSourceRequestBodyContentType(method, path, operation);
                restoreNotificationsSecurity(method, path, operation);
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
            name: "@hey-api/client-fetch",
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
        defineConfigKestraHeyOptionalTenant(),
        defineEnterpriseOnlyRoutesPlugin(),
    ],
} satisfies UserConfig
