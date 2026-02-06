
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
        if(localyRemovedParameters > 0){
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
                if(removeDeprecatedParameters){
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

    return counters;
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
