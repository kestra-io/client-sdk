import {$, definePluginConfig, type DefinePlugin} from "@hey-api/openapi-ts"

// Local (client-sdk-only) hey-api-plugin codegen plugin: reads the `x-kestra: {edition: ee}`
// vendor extension that kestra-ee's update-openapi-spec.yml workflow stamps onto EE-only
// operations before the spec reaches this repo, and stamps a route registry into the generated
// SDK. Consumed by src/index.ts to build the `enterpriseFeature` config passed to
// createConfigureClient (see @kestra-io/hey-api-plugin/runtime's EnterpriseFeatureError).
//
// This lives here, not in @kestra-io/hey-api-plugin: only client-sdk (the one SDK spanning both
// editions) needs to tell an EE-only route apart from a genuinely-missing resource — ui/ and ui-ee/
// each generate from their own locally-accurate spec and never hit this case.

type UserConfig = {
    name: "enterprise-only-routes"
}

type EnterpriseOnlyRoutesPlugin = DefinePlugin<UserConfig>

function kebabCase(tag: string): string {
    return tag.replace(/([a-z0-9])([A-Z])/g, "$1-$2").toLowerCase()
}

const handler: EnterpriseOnlyRoutesPlugin["Handler"] = ({plugin}) => {
    const routes: Record<string, {feature: string}> = {}

    plugin.forEach(
        "operation",
        ({operation}) => {
            const extension = (operation as unknown as {"x-kestra"?: {edition?: string}})["x-kestra"]
            if (extension?.edition !== "ee") return

            const method = String(operation.method).toUpperCase()
            const path = String(operation.path)
            const feature = kebabCase(operation.tags?.[0] ?? "enterprise")
            routes[`${method} ${path}`] = {feature}
        },
        {order: "declarations"},
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
