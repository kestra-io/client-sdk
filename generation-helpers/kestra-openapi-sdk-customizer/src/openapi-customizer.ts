
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
export function sanitizeOpenAPI(spec: any, opts: { removeDeprecatedOperations?: boolean, operationIdsToSkip?: string[] } = {}) {
    const counters = { removedProperties: 0, removedParameters: 0, removedOperations: 0 };
    const { removeDeprecatedOperations = true, operationIdsToSkip = [] } = opts;

    console.log(`sanitize OpenAPI spec with params:\n\tremoveDeprecatedOperations: ${removeDeprecatedOperations}\n\toperationIdsToSkip: ${operationIdsToSkip}`)

    if (!spec || typeof spec !== "object") return counters;

    // 1) components.schemas
    if (spec.components && spec.components.schemas && typeof spec.components.schemas === "object") {
        for (const name of Object.keys(spec.components.schemas)) {
            const schema = spec.components.schemas[name];
            stripDeprecatedFromSchema(schema, counters);
        }
    }

    // 2) components.parameters
    if (spec.components && spec.components.parameters && typeof spec.components.parameters === "object") {
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

                // Optionally delete whole operation if it's marked deprecated
                if (removeDeprecatedOperations && op.deprecated === true) {
                    const removedOperation = pathItem[method];
                    delete pathItem[method];
                    counters.removedOperations += 1;
                    console.debug(`remove deprecated operation: ${method} ${removedOperation.operationId}`)
                    continue;
                }

                // Remove deprecated parameters on operation
                stripDeprecatedParametersFromOperation(op, counters);

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

    return counters;
}