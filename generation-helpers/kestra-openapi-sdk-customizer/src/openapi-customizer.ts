
/**
 * Recursively strip deprecated properties from a JSON Schema object used in OpenAPI specs.
 * This handles nested objects as well as allOf/oneOf/anyOf compositions.
 */
function stripDeprecatedFromSchema(schema: any, counters: { removedProperties: number }) {
    if (!schema || typeof schema !== "object") return;

    // If this schema is an object with properties, remove those with deprecated: true
    if (schema.properties && typeof schema.properties === "object") {
        for (const key of Object.keys(schema.properties)) {
            const prop = schema.properties[key];
            if (prop && typeof prop === "object" && prop.deprecated === true) {
                delete schema.properties[key];
                counters.removedProperties += 1;
                console.debug(`remove property: ${key} ${JSON.stringify(prop)}`)
            } else {
                stripDeprecatedFromSchema(prop, counters);
            }
        }
    }

    // Items (arrays)
    if (schema.items) {
        stripDeprecatedFromSchema(schema.items, counters);
    }

    // allOf / anyOf / oneOf
    for (const alt of ["allOf", "anyOf", "oneOf"]) {
        if (Array.isArray(schema[alt])) {
            for (const subschema of schema[alt]) {
                stripDeprecatedFromSchema(subschema, counters);
            }
        }
    }

    // AdditionalProperties may itself be a schema
    if (schema.additionalProperties && typeof schema.additionalProperties === "object") {
        stripDeprecatedFromSchema(schema.additionalProperties, counters);
    }
}

/**
 * Remove deprecated parameters from an operation object (parameters: [...]).
 */
function stripDeprecatedParametersFromOperation(op: any, counters: { removedParameters: number }) {
    if (!op || typeof op !== "object") return;
    if (Array.isArray(op.parameters)) {
        const before = op.parameters.length;
        const removed = op.parameters.filter((p: any) => (p && typeof p === "object" && p.deprecated === true));
        op.parameters = op.parameters.filter((p: any) => !(p && typeof p === "object" && p.deprecated === true));
        const localyRemovedParameters = before - op.parameters.length;
        counters.removedParameters += localyRemovedParameters;
        if (localyRemovedParameters > 0) {
            console.debug(`strip parameters in params: ${JSON.stringify(removed)}`)
        }
    }

    // Walk requestBody/response schemas as well
    const touchSchema = (schema: any, countersRef = counters) => stripDeprecatedFromSchema(schema, { removedProperties: countersRef.removedParameters /* dummy aggregator not used */ });

    // Request body schemas
    if (op.requestBody && op.requestBody.content && typeof op.requestBody.content === "object") {
        for (const mt of Object.keys(op.requestBody.content)) {
            const s = op.requestBody.content[mt]?.schema;
            if (s) stripDeprecatedFromSchema(s, { removedProperties: 0 });
        }
    }

    // Response body schemas
    if (op.responses && typeof op.responses === "object") {
        for (const code of Object.keys(op.responses)) {
            const resp = op.responses[code];
            const content = resp && resp.content;
            if (content && typeof content === "object") {
                for (const mt of Object.keys(content)) {
                    const s = content[mt]?.schema;
                    if (s) stripDeprecatedFromSchema(s, { removedProperties: 0 });
                }
            }
        }
    }
}

/**
 * Sanitize an OpenAPI spec object:
 * - Remove deprecated schema properties (components.schemas.*.properties.* where deprecated: true)
 * - Remove deprecated parameters from operations and from components.parameters
 * - Optionally remove deprecated operations (if removeDeprecatedOperations = true)
 */
export function sanitizeOpenAPI(
    spec: any,
    opts: {
        removeDeprecatedOperations?: boolean,
        removeDeprecatedParameters?: boolean,
        operationIdsToSkip?: string[],
        tagsToSkip?: string[]
    } = {}
) {
    const counters = { removedProperties: 0, removedParameters: 0, removedOperations: 0, removedSchemas: 0 };
    let {
        removeDeprecatedOperations = true,
        removeDeprecatedParameters = true,
        operationIdsToSkip = [],
        tagsToSkip = []
    } = opts;

    console.log(
        `sanitize OpenAPI spec with params:\n\tremoveDeprecatedOperations: ${removeDeprecatedOperations}` +
        `\n\tremoveDeprecatedParameters: ${removeDeprecatedParameters}` +
        `\n\toperationIdsToSkip: ${operationIdsToSkip}` +
        `\n\ttagsToSkip: ${tagsToSkip}`
    )

    if (!spec || typeof spec !== "object") return counters;

    // 1) components.schemas
    if (spec.components && spec.components.schemas && typeof spec.components.schemas === "object") {
        for (const name of Object.keys(spec.components.schemas)) {
            const schema = spec.components.schemas[name];
            stripDeprecatedFromSchema(schema, counters);
        }
    }

    // 2) components.parameters
    if (removeDeprecatedParameters && spec.components && spec.components.parameters && typeof spec.components.parameters === "object") {
        for (const name of Object.keys(spec.components.parameters)) {
            const param = spec.components.parameters[name];
            if (param && typeof param === "object" && param.deprecated === true) {
                delete spec.components.parameters[name];
                counters.removedParameters += 1;
                console.debug(`remove parameter: ${name} or ${param}`)
            }
        }
    }

    // 3) paths -> operations
    const httpMethods = ["get", "put", "post", "delete", "options", "head", "patch", "trace"] as const;
    if (spec.paths && typeof spec.paths === "object") {
        for (const p of Object.keys(spec.paths)) {
            const pathItem = spec.paths[p];
            if (!pathItem || typeof pathItem !== "object") continue;

            for (const method of httpMethods) {
                if (!pathItem[method]) continue;
                const op = pathItem[method];

                // Optionally delete whole operation if requested skipped
                if (operationIdsToSkip && operationIdsToSkip.some(x => x === pathItem[method].operationId)) {
                    const removedOperation = pathItem[method];
                    delete pathItem[method];
                    counters.removedOperations += 1;
                    console.debug(`remove skipped operation: ${method} ${removedOperation.operationId} ${operationIdsToSkip}`)
                    continue;
                }

                // Optionally delete whole operation if its tag is skipped
                if (tagsToSkip && Array.isArray(op.tags) && op.tags.some((tag: string) => tagsToSkip.includes(tag))) {
                    const removedOperation = pathItem[method];
                    delete pathItem[method];
                    counters.removedOperations += 1;
                    console.debug(`remove skipped tag operation: ${method} ${removedOperation.operationId} ${op.tags}`)
                    continue;
                }

                // Optionally delete whole operation if it's marked deprecated
                if (removeDeprecatedOperations && op.deprecated === true) {
                    const removedOperation = pathItem[method];
                    delete pathItem[method];
                    counters.removedOperations += 1;
                    console.debug(`remove deprecated operation: ${method} ${removedOperation.operationId}`)
                    continue;
                }

                // Remove deprecated parameters on operation
                if (removeDeprecatedParameters) {
                    stripDeprecatedParametersFromOperation(op, counters);
                }

                // Also walk explicit op-level schemas for deprecations deep inside
                if (op.requestBody?.content) {
                    for (const mt of Object.keys(op.requestBody.content)) {
                        const s = op.requestBody.content[mt]?.schema;
                        if (s) stripDeprecatedFromSchema(s, counters);
                    }
                }
                if (op.responses) {
                    for (const code of Object.keys(op.responses)) {
                        const content = op.responses[code]?.content;
                        if (content) {
                            for (const mt of Object.keys(content)) {
                                const s = content[mt]?.schema;
                                if (s) stripDeprecatedFromSchema(s, counters);
                            }
                        }
                    }
                }
            }

            // If no operations remain on the path, remove the path entirely
            const hasOps = httpMethods.some((m) => !!pathItem[m]);
            if (!hasOps) {
                delete spec.paths[p];
            }
        }
    }

    // 4) Remove unreferenced component schemas after operation filtering
    counters.removedSchemas += removeUnreferencedSchemas(spec);

    // 5) Remove get from method name, temporary while its done on core side
    normalizeGetOperationIds(spec)

    // 6) Replace Flow.labels property schema
    replaceFlowLabelsSpec(spec)

    // 7) Normalize QueryFilter array query params to prevent broken querySerializer generation
    normalizeQueryFilterParams(spec)

    // 8) Widen QueryFilter.value from `type: object` to any-value, since it carries
    //    strings, numbers, booleans, and arrays depending on the operator.
    widenQueryFilterValue(spec)

    // 9) Unwrap Micronaut Event<X> wrapper schemas on SSE endpoints so the
    //    stream type is the inner Execution/X type, not the envelope type.
    unwrapSseEventResponses(spec)

    // 10) Fix parameters declared as `in: query` that actually appear as {param} in the path template.
    fixMisclassifiedPathParams(spec)

    // 11) Add missing security schemes to SCIM endpoints (upstream spec bug). Without a
    //     `security` block, the generated hey-api client never attaches credentials, so
    //     every SCIM call returns 401. TODO: fix at the source (Kestra EE) and drop this.
    addMissingScimSecurity(spec)

    // 12) Same upstream spec bug as above, on a different set of tags. TODO: fix at the
    //     source (Kestra EE) and drop this.
    addMissingEeControllerSecurity(spec)

    return counters;
}

/**
 * Add the standard `bearerAuth`/`basicAuth` security requirement to SCIM operations
 * (any operation tagged with a `SCIM-` tag) that lack a `security` block.
 *
 * Upstream, the Kestra EE OpenAPI spec omits `security` on the SCIM-Configuration,
 * SCIM-Users and SCIM-Groups operations. The hey-api axios client only attaches the
 * configured auth when an operation declares `security`, so these requests are sent
 * unauthenticated and the server replies 401. We mirror the security block used by
 * every other authenticated operation in the spec.
 *
 * Scoped to `SCIM-` tags on purpose: other security-less operations (the `Auths`
 * password-reset / invitation flows and `POST /login`) are intentionally public.
 */
export function addMissingScimSecurity(spec: any): number {
    if (!spec?.paths || typeof spec.paths !== "object") return 0;

    const httpMethods = ["get", "put", "post", "delete", "options", "head", "patch", "trace"] as const;
    const security = [{ bearerAuth: [] }, { basicAuth: [] }];
    let added = 0;

    for (const [path, pathItem] of Object.entries(spec.paths)) {
        if (!pathItem || typeof pathItem !== "object") continue;

        for (const method of httpMethods) {
            const op = (pathItem as any)[method];
            if (!op || typeof op !== "object") continue;
            if (op.security !== undefined) continue;
            if (!Array.isArray(op.tags) || !op.tags.some((tag: string) => typeof tag === "string" && tag.startsWith("SCIM-"))) continue;

            op.security = security;
            added += 1;
            console.debug(`addMissingScimSecurity: added security to ${method.toUpperCase()} ${path} (${op.operationId})`);
        }
    }

    return added;
}

/**
 * Add the standard `bearerAuth`/`basicAuth` security requirement to operations tagged
 * `Tenants`, `Secrets`, `Blueprints`, `Blueprint Tags`, `Dashboards` or `TestSuites` that
 * lack a `security` block.
 *
 * Same upstream spec bug as `addMissingScimSecurity`, on a different set of controllers.
 * The hey-api axios client only attaches the configured auth when an operation declares
 * `security`, so these requests are sent unauthenticated and the server replies 401
 * (verified against a real Kestra 1.3.26 instance: e.g. `GET /api/v1/tenants/search`
 * lacks `security` in the spec but 401s without Basic/Bearer auth).
 */
export function addMissingEeControllerSecurity(spec: any): number {
    if (!spec?.paths || typeof spec.paths !== "object") return 0;

    const httpMethods = ["get", "put", "post", "delete", "options", "head", "patch", "trace"] as const;
    const tagsToFix = ["Tenants", "Secrets", "Blueprints", "Blueprint Tags", "Dashboards", "TestSuites"];
    const security = [{ bearerAuth: [] }, { basicAuth: [] }];
    let added = 0;

    for (const [path, pathItem] of Object.entries(spec.paths)) {
        if (!pathItem || typeof pathItem !== "object") continue;

        for (const method of httpMethods) {
            const op = (pathItem as any)[method];
            if (!op || typeof op !== "object") continue;
            if (op.security !== undefined) continue;
            if (!Array.isArray(op.tags) || !op.tags.some((tag: string) => tagsToFix.includes(tag))) continue;

            op.security = security;
            added += 1;
            console.debug(`addMissingEeControllerSecurity: added security to ${method.toUpperCase()} ${path} (${op.operationId})`);
        }
    }

    return added;
}

function removeUnreferencedSchemas(spec: any): number {
    if (!spec?.components?.schemas || !spec?.paths || typeof spec.paths !== "object") return 0;

    const components = spec.components || {};
    const schemas = components.schemas || {};
    const referencedSchemas = new Set<string>();
    const visitedComponents = new Set<string>();

    const parseComponentRef = (ref: string) => {
        if (typeof ref !== "string" || !ref.startsWith("#/components/")) return null;
        const rest = ref.slice("#/components/".length);
        const parts = rest.split("/");
        const type = parts.shift();
        const name = parts.join("/");
        if (!type || !name) return null;
        return { type, name };
    };

    const traverseNode = (node: any) => {
        if (!node || typeof node !== "object") return;
        if (Array.isArray(node)) {
            for (const item of node) traverseNode(item);
            return;
        }

        const ref = node.$ref;
        if (typeof ref === "string") {
            const parsed = parseComponentRef(ref);
            if (parsed) {
                const { type, name } = parsed;
                const key = `${type}/${name}`;
                if (!visitedComponents.has(key)) {
                    visitedComponents.add(key);
                    if (type === "schemas") {
                        referencedSchemas.add(name);
                        if (schemas[name]) traverseNode(schemas[name]);
                    } else if (components[type] && components[type][name]) {
                        traverseNode(components[type][name]);
                    }
                }
            }
        }

        for (const value of Object.values(node)) {
            traverseNode(value);
        }
    };

    const httpMethods = ["get", "put", "post", "delete", "options", "head", "patch", "trace"] as const;
    for (const p of Object.keys(spec.paths)) {
        const pathItem = spec.paths[p];
        if (!pathItem || typeof pathItem !== "object") continue;

        if (Array.isArray(pathItem.parameters)) {
            traverseNode(pathItem.parameters);
        }

        for (const method of httpMethods) {
            const op = pathItem[method];
            if (!op || typeof op !== "object") continue;
            traverseNode(op);
        }
    }

    let removed = 0;
    for (const name of Object.keys(schemas)) {
        if (!referencedSchemas.has(name)) {
            delete schemas[name];
            removed += 1;
        }
    }

    return removed;
}

export function normalizeGetOperationIds(spec: any): number {
    if (!spec || typeof spec !== "object" || !spec.paths || typeof spec.paths !== "object") return 0;
    let renamed = 0;
    const lowerFirst = (s: string) => s.length ? s.charAt(0).toLowerCase() + s.slice(1) : s;

    for (const p of Object.keys(spec.paths)) {
        const pathItem = spec.paths[p];
        if (!pathItem || typeof pathItem !== "object") continue;

        for (const key of Object.keys(pathItem)) {
            const op = pathItem[key];
            if (!op || typeof op !== "object") continue;

            const id = op.operationId;
            if (typeof id === "string" && id.length > 3 && id.startsWith("get") && /^[A-Z]/.test(id.charAt(3))) {
                const remainder = id.slice(3);
                op.operationId = lowerFirst(remainder);
                renamed += 1;
                console.debug(`normalized operationId: ${id} -> ${op.operationId} (path: ${p}, key: ${key})`);
            }
        }
    }

    return renamed;
}

/**
 * Normalize QueryFilter array query parameters so hey-api does not generate
 * a broken `querySerializer: { array: { explode: false } }`.
 *
 * When a `filters` query parameter has `required: true` and a non-nullable schema,
 * hey-api emits that serializer which converts each QueryFilter object to "[object Object]".
 * Endpoints whose schema is already `nullable: true` (optional) use the default
 * bracket-style serialization correctly.
 *
 * Fix: for every query parameter whose schema items point to QueryFilter and that
 * has `required: true` without `nullable`, remove `required` and add `nullable: true`
 * so hey-api treats it the same way as the working endpoints.
 */
export function normalizeQueryFilterParams(spec: any): number {
    if (!spec?.paths || typeof spec.paths !== "object") return 0;

    const httpMethods = ["get", "put", "post", "delete", "options", "head", "patch", "trace"] as const;
    let normalized = 0;

    for (const pathItem of Object.values(spec.paths)) {
        if (!pathItem || typeof pathItem !== "object") continue;

        for (const method of httpMethods) {
            const op = (pathItem as any)[method];
            if (!op?.parameters) continue;

            for (const param of op.parameters) {
                if (!param || typeof param !== "object") continue;
                if (param.in !== "query") continue;

                const schema = param.schema;
                if (!schema || schema.type !== "array") continue;
                if (!schema.items?.["$ref"]?.endsWith("/QueryFilter")) continue;

                if (param.required === true && !schema.nullable) {
                    delete param.required;
                    schema.nullable = true;
                    normalized += 1;
                    console.debug(`normalizeQueryFilterParams: fixed filters param in ${op.operationId}`);
                }
            }
        }
    }

    return normalized;
}

/**
 * Widen `QueryFilter.value` from `type: object` (which generators turn into a
 * map type like `{ [key: string]: unknown }`) to an empty schema so it maps to
 * `unknown`/`Any`/`interface{}`. The value carries strings, numbers, booleans,
 * or arrays depending on the operator, so any-value is the accurate shape.
 */
export function widenQueryFilterValue(spec: any): boolean {
    const queryFilter = spec?.components?.schemas?.QueryFilter;
    if (!queryFilter?.properties?.value) return false;
    queryFilter.properties.value = {};
    console.debug("widenQueryFilterValue: QueryFilter.value set to any");
    return true;
}

export function replaceFlowLabelsSpec(spec: any) {
    if (!spec?.components?.schemas) return;

    const targets = ["Flow", "AbstractFlow", "FlowWithSource"];

    const updateLabels = (parent: any) => {
        if (parent?.properties?.labels) {
            parent.properties.labels = {
                type: "array",
                items: {
                    $ref: "#/components/schemas/Label"
                }
            };
            console.debug(`Replaced labels in schema with array of Label references`);
        }
    };

    for (const name of targets) {
        const schema = spec.components.schemas[name];
        if (!schema) continue;

        // Update direct properties
        updateLabels(schema);

        // Update properties within composition blocks
        for (const alt of ["allOf", "anyOf", "oneOf"]) {
            if (Array.isArray(schema[alt])) {
                schema[alt].forEach(updateLabels);
            }
        }
    }
}

/**
 * Unwrap Micronaut `Event<X>` wrapper schemas on SSE (`text/event-stream`) endpoints.
 *
 * In Micronaut, returning `Event<Execution>` from a controller generates an OpenAPI
 * schema like `Event_Execution_` with properties `data`, `id`, `name`, `comment`,
 * `retry`. These fields map to SSE *protocol* framing, NOT to JSON fields in the
 * response body. The actual JSON emitted in each SSE `data:` line is the inner type
 * (`Execution`), not the wrapper object.
 *
 * This function detects such wrapper schemas (named `Event_*_`, containing a `data`
 * property that is a `$ref`, plus only the SSE-envelope sibling fields) and replaces
 * the SSE endpoint response `$ref` with the inner data type's `$ref`, so generated
 * SDK types correctly reflect what the stream actually yields.
 */
export function unwrapSseEventResponses(spec: any): number {
    if (!spec?.paths || !spec?.components?.schemas) return 0;

    const schemas: Record<string, any> = spec.components.schemas;
    const httpMethods = ["get", "put", "post", "delete", "options", "head", "patch", "trace"] as const;
    const SSE_ENVELOPE_FIELDS = new Set(["data", "id", "name", "comment", "retry"]);

    /** Returns the inner $ref if the schema looks like a Micronaut Event<X> wrapper. */
    const innerDataRef = (schemaName: string): string | null => {
        const schema = schemas[schemaName];
        if (!schema || schema.type !== "object" || !schema.properties) return null;

        const props = Object.keys(schema.properties);
        // All properties must be known SSE-envelope fields
        if (!props.every((p) => SSE_ENVELOPE_FIELDS.has(p))) return null;

        const dataRef = schema.properties.data?.["$ref"];
        if (typeof dataRef !== "string") return null;

        return dataRef;
    };

    let unwrapped = 0;

    for (const pathItem of Object.values(spec.paths)) {
        if (!pathItem || typeof pathItem !== "object") continue;

        for (const method of httpMethods) {
            const op = (pathItem as any)[method];
            if (!op?.responses) continue;

            for (const resp of Object.values(op.responses)) {
                if (!resp || typeof resp !== "object") continue;
                const sseContent = (resp as any).content?.["text/event-stream"];
                if (!sseContent) continue;

                const ref: string | undefined = sseContent.schema?.["$ref"];
                if (!ref) continue;

                const schemaName = ref.replace("#/components/schemas/", "");
                const dataRef = innerDataRef(schemaName);
                if (!dataRef) continue;

                sseContent.schema = { $ref: dataRef };
                unwrapped += 1;
                console.debug(`unwrapSseEventResponses: ${op.operationId} ${schemaName} -> ${dataRef}`);
            }
        }
    }

    return unwrapped;
}

/**
 * Fix parameters that are declared `in: query` but whose name appears as a
 * `{name}` template variable in the path — i.e. they are path parameters.
 *
 * Workaround for upstream specs where the `in` field is wrong.
 */
export function fixMisclassifiedPathParams(spec: any): number {
    if (!spec?.paths || typeof spec.paths !== "object") return 0;

    const httpMethods = ["get", "put", "post", "delete", "options", "head", "patch", "trace"] as const;
    let fixed = 0;

    for (const [path, pathItem] of Object.entries(spec.paths)) {
        if (!pathItem || typeof pathItem !== "object") continue;

        const pathVars = new Set(
            [...path.matchAll(/\{(\w+)\}/g)].map((m) => m[1])
        );
        if (pathVars.size === 0) continue;

        for (const method of httpMethods) {
            const op = (pathItem as any)[method];
            if (!op?.parameters) continue;

            for (const param of op.parameters) {
                if (!param || typeof param !== "object") continue;
                if (param.in === "query" && pathVars.has(param.name)) {
                    param.in = "path";
                    fixed += 1;
                    console.debug(`fixMisclassifiedPathParams: ${param.name} in ${op.operationId} (${path}) changed query -> path`);
                }
            }
        }
    }

    return fixed;
}
