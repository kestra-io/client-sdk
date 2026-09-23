// Hand-written (not generated): build a flow from a native object instead of a
// YAML source string. Exposed on the `@kestra-io/kestra-sdk/flows` subpath
// (via src/flows.ts) and on `/all`, never on the root entry, so consumers that
// only import the root (types + client setup) don't bundle the `yaml` package
// or the Flows operations.
import { stringify as stringifyYaml } from "yaml"
import { createFlow, updateFlow } from "./openapi/sdk/Flows.gen"
import type { Flow } from "./openapi/types.gen"

/**
 * A flow described as a native object rather than a YAML source string.
 *
 * Accepts the typed {@link Flow} model or a plain object. The loose
 * `Record<string, unknown>` member is deliberate: the generated `Task` type is a
 * closed object with no index signature, so plugin-specific task properties
 * (e.g. `message` on a Log task, `commands` on a Shell task) would otherwise be
 * rejected by TypeScript. They are carried through verbatim into the emitted YAML.
 */
export type FlowObjectInput = Flow | Record<string, unknown>

/**
 * Read-only / server-managed flow fields that must never appear in a flow
 * *source* body. `draft` is a query parameter, not a body field.
 */
const SERVER_MANAGED_FLOW_FIELDS = ["deleted", "revision", "draft", "tenantId", "source", "updated"]

/**
 * Serialize a flow object to a YAML source string (block style, no anchors,
 * `null` fields omitted). Kestra expressions like `{{ inputs.foo }}` are quoted
 * by the YAML emitter and multi-line strings become literal block scalars.
 * Server-managed top-level fields are stripped so the YAML mirrors what a user
 * writes as flow source.
 */
export function flowToYaml(flow: FlowObjectInput): string {
    if (flow === null || flow === undefined) {
        throw new TypeError("flow must not be null or undefined")
    }
    const source: Record<string, unknown> = { ...(flow as Record<string, unknown>) }
    for (const field of SERVER_MANAGED_FLOW_FIELDS) {
        delete source[field]
    }
    return stringifyYaml(
        source,
        (_key, value) => (value === null ? undefined : value),
        { aliasDuplicateObjects: false },
    )
}

/**
 * Create a flow from a native object (typed {@link Flow} model or plain object).
 *
 * The flow-write endpoint is YAML-only (it does not accept JSON), so the object
 * is serialized to a YAML source string client-side and delegated to the
 * generated `createFlow`. `draft` stays a query parameter, not a body field.
 */
export function createFlowFromObject(
    parameters: { flow: FlowObjectInput; tenant?: string; draft?: boolean },
    options?: Parameters<typeof createFlow>[1],
) {
    const { flow, ...rest } = parameters
    return createFlow({ ...rest, body: flowToYaml(flow) }, options)
}

/**
 * Update a flow from a native object (typed {@link Flow} model or plain object).
 *
 * The object is serialized to a YAML source string client-side (the write
 * endpoint is YAML-only) and delegated to the generated `updateFlow`. `draft`
 * stays a query parameter, not a body field.
 */
export function updateFlowFromObject(
    parameters: { flow: FlowObjectInput; namespace: string; id: string; tenant?: string; draft?: boolean },
    options?: Parameters<typeof updateFlow>[1],
) {
    const { flow, ...rest } = parameters
    return updateFlow({ ...rest, body: flowToYaml(flow) }, options)
}