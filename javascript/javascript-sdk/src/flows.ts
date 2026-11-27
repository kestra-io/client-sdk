// The `@kestra-io/kestra-sdk/flows` subpath: the generated Flows operations plus
// the hand-written object -> YAML helpers (createFlowFromObject, ...). The
// generated module can't carry them (src/openapi/ is regenerated), so this
// wrapper replaces the generated `flows` entry in tsdown.config.ts.
export * from "./openapi/sdk/Flows.gen"
export * from "./flow-from-object"
