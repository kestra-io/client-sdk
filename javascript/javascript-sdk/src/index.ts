import { client } from "./openapi/client.gen"
import { formDataBodySerializer } from "./openapi/client"
import { ENTERPRISE_ONLY_ROUTES_JSON } from "./openapi/sdk/enterpriseOnlyRoutes.gen"
import { createConfigureClient, EnterpriseFeatureError, type EnterpriseFeatureConfig } from "@kestra-io/hey-api-plugin/runtime"

export * from "./openapi/index"
export { EnterpriseFeatureError }

// Populated by kestra-ee's update-openapi-spec.yml, which stamps `x-kestra: {edition: ee}` onto
// EE-only operations before the spec reaches this repo (see enterprise-only-routes-plugin.ts).
// Empty until that tagging lands and this SDK is regenerated against a tagged spec.
const enterpriseOnlyRoutes: Record<string, { feature: string }> = JSON.parse(ENTERPRISE_ONLY_ROUTES_JSON)

const featureToSlugMap: Record<string, string> = {
    "audit logs": "/governance/audit-logs",
    "bindings": "/auth/rbac",
    "auths": "/auth/authentication",
    "banners": "/instance/announcements",
    "cluster": "/instance/maintenance-mode",
    "mcp": "",
    "services": "",
    "policies": "/governance",
    "plugins": "/instance/versioned-plugins",
    "worker groups": "/scalability/worker-group",
    "worker-queues": "",
    "worker auth": "/auth/credentials",
    "kill-switches": "/instance/kill-switch",
    "misc": "",
    "invitations": "/auth/invitations",
    "users": "/auth/rbac",
    "notifications": "",
    "service-account": "/auth/service-accounts",
    "tenants": "/governance/tenants",
    "ai": "",
    "apps": "/scalability/apps",
    "assets": "/governance/assets",
    "blueprints": "/governance/custom-blueprints",
    "blueprint tags": "/governance/custom-blueprints",
    "flows": "/governance",
    "groups": "/auth/rbac",
    "scim-groups": "/auth/scim",
    "scim-configuration": "/auth/scim",
    "scim-users": "/auth/scim",
    "namespaces": "/governance/namespace-management",
    "reusable inputs": "",
    "quotas": "",
    "roles": "/auth/rbac",
    "security-integrations": "/auth/sso",
    "tenant access": "/auth/rbac",
    "test-suites": "/governance/unit-tests",
    "login": "/auth/authentication",
}

const enterpriseFeature: EnterpriseFeatureConfig = {
    matchRoute: (method, path) => enterpriseOnlyRoutes[`${method} ${path}`],
    docsUrl: (feature) => `https://kestra.io/docs/enterprise${featureToSlugMap[feature] ?? ""}`,
    contactSalesUrl: () => `https://kestra.io/demo`,
}

export const configureClient = createConfigureClient(client, formDataBodySerializer, enterpriseFeature)