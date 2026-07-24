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
        ({ operation }: { operation: any }) => {
            const extension = (operation as { "x-kestra"?: { edition?: string } })["x-kestra"]
            if (extension?.edition !== "ee") return

            const method = String(operation.method).toUpperCase()
            const path = String(operation.path)
            const feature = kebabCase(operation.tags?.[0] ?? "enterprise")
            routes[`${method} ${path}`] = { feature }
        },
        { order: "declarations" },
    )

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
