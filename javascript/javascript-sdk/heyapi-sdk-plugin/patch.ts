/**
 * `parser.patch.operations` callback that forces the generator to emit
 * `Content-Type: application/x-yaml` for YAML-source request bodies.
 *
 * Some endpoints (e.g. `PUT .../reusable-inputs/{id}`) accept a raw YAML document and declare
 * `application/x-yaml`, `text/plain` AND `application/json` request-body variants, all with a
 * plain `type: string` schema. hey-api resolves a request body to the JSON variant whenever one
 * is declared (`contents.find(json) || contents[0]` in its requestBody parser), so the generated
 * operation hardcodes `Content-Type: application/json` and the server fails to deserialize the
 * raw YAML string (HTTP 500 — kestra-io/client-sdk#340).
 *
 * For these string-schema YAML bodies, drop the `application/json` variant and reorder the
 * remaining content so `application/x-yaml` comes first — the parser then resolves the body to
 * the YAML variant regardless of spec ordering, and both `sdk.gen.ts` operations and the
 * generated wrappers send the correct content type.
 *
 * Bodies whose JSON variant carries a structured (non-string) schema (e.g. `validateTask`,
 * whose variants are all `type: object`) are left untouched: JSON is a legitimate
 * representation there and the SDK serializes those bodies as JSON objects.
 */
const YAML_MEDIA_TYPE = "application/x-yaml";
const JSON_MEDIA_TYPE = "application/json";

function isPlainString(schema: any): boolean {
    return !!schema && schema.type === "string" && schema.format !== "binary";
}

export function fixYamlSourceRequestBodyContentType(method: string, path: string, operation: any): void {
    const requestBody = operation?.requestBody;
    const content = requestBody?.content;
    if (!content || typeof content !== "object") return;

    if (!isPlainString(content[YAML_MEDIA_TYPE]?.schema)) return;
    if (!isPlainString(content[JSON_MEDIA_TYPE]?.schema)) return;

    delete content[JSON_MEDIA_TYPE];

    const reordered: Record<string, unknown> = { [YAML_MEDIA_TYPE]: content[YAML_MEDIA_TYPE] };
    for (const [mediaType, value] of Object.entries(content)) {
        if (mediaType !== YAML_MEDIA_TYPE) reordered[mediaType] = value;
    }
    requestBody.content = reordered;

    console.debug(`fixYamlSourceRequestBodyContentType: ${method.toUpperCase()} ${path} (${operation.operationId}) now prefers ${YAML_MEDIA_TYPE}`);
}
