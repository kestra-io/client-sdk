import { $, definePluginConfig, type DefinePlugin } from "@hey-api/openapi-ts"

// Local (client-sdk-only): reads the `x-kestra: {edition: ee}` tag off each operation and bakes a
// route registry into the generated SDK, consumed by src/index.ts's enterpriseFeature config.

type UserConfig = { name: "enterprise-only-routes" }
type EnterpriseOnlyRoutesPlugin = DefinePlugin<UserConfig>

function kebabCase(tag: string): string {
    return tag
        .replace(/([a-z0-9])([A-Z])/g, "$1-$2")
        .replace(/[\s_]+/g, "-")
        .toLowerCase()
}

const handler: EnterpriseOnlyRoutesPlugin["Handler"] = ({ plugin }) => {
    const routes: Record<string, { feature: string }> = {}

    plugin.forEach(
        "operation",
        ({ operation }) => {
            const extension = (operation as unknown as { "x-kestra"?: { edition?: string } })["x-kestra"]
            if (extension?.edition !== "ee") return

            const method = String(operation.method).toUpperCase()
            const path = String(operation.path)
            const feature = kebabCase(operation.tags?.[0] ?? "enterprise")
            routes[`${method} ${path}`] = { feature }
        },
        { order: "declarations" },
    )

    // Cheap guard against silent drift: if the x-kestra tag is ever renamed or dropped upstream,
    // generation would otherwise succeed with an empty registry and no signal that anything broke.
    if (Object.keys(routes).length === 0) {
        console.warn("[enterprise-only-routes-plugin] Collected zero EE-only routes from the spec — check the x-kestra tag is still present.")
    }

    const routesSymbol = plugin.symbol("ENTERPRISE_ONLY_ROUTES_JSON", {
        getFilePath: () => "sdk/enterpriseOnlyRoutes",
    })

    plugin.node($.const(routesSymbol).export().assign($.literal(JSON.stringify(routes))))
}

export const defineEnterpriseOnlyRoutesPlugin = definePluginConfig({
    config: {},
    dependencies: [],
    handler,
    name: "enterprise-only-routes",
})
