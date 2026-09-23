// Hand-written (not generated): build a flow from a native object instead of a
// YAML source string. Exposed on the `@kestra-io/kestra-sdk/flows` subpath
// (via src/flows.ts) and on `/all`, never on the root entry, so consumers that
// only import the root (types + client setup) don't bundle the `yaml` package
// or the Flows operations.
import { Document, Scalar, visit } from "yaml"
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
    const doc = new Document(
        source,
        (_key, value) => (value === null ? undefined : value),
        { aliasDuplicateObjects: false },
    )
    // Force quotes on string values a YAML 1.1 reader (Kestra's server parses
    // flow source with Jackson's YAMLParser) would re-type: the `yaml` library
    // emits per YAML 1.2 and leaves e.g. `yes`, `off` or `1_000` plain.
    visit(doc, {
        Scalar(_key, node) {
            if (typeof node.value === "string" && !node.value.includes("\n") && isAmbiguousYamlString(node.value)) {
                node.type = Scalar.QUOTE_DOUBLE
            }
        },
    })
    return doc.toString()
}

/** Plain scalars some YAML reader resolves to a boolean or null (case-insensitive). */
const AMBIGUOUS_YAML_WORDS = new Set(["", "~", "null", "y", "yes", "n", "no", "true", "false", "on", "off"])

/**
 * Strings a YAML 1.1 / 1.2 or Jackson reader may resolve to a number or
 * timestamp: signed ints/floats with underscores and exponents (with or without
 * a dot or exponent sign), hex/octal/binary, .inf/.nan, sexagesimal (12:30) and
 * dates. Deliberately permissive: quoting a string that did not need it is
 * harmless, leaving one plain is not.
 */
const AMBIGUOUS_YAML_SCALAR = new RegExp(
    "^[-+]?(" +
        "0x[0-9a-f_]+|0o[0-7_]+|0b[01_]+|" +
        "[0-9][0-9_]*(\\.[0-9_]*)?(e[-+]?[0-9_]+)?|" +
        "\\.[0-9][0-9_]*(e[-+]?[0-9_]+)?|" +
        "\\.(inf|nan)|" +
        "[0-9][0-9_]*(:[0-5]?[0-9])+(\\.[0-9_]*)?" +
        ")$|^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}",
    "i",
)

function isAmbiguousYamlString(value: string): boolean {
    return AMBIGUOUS_YAML_WORDS.has(value.toLowerCase()) || AMBIGUOUS_YAML_SCALAR.test(value)
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