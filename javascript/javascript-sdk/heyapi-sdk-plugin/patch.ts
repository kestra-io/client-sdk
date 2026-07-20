/**
 * hey-api prefers a declared `application/json` request-body variant, mislabeling raw YAML source bodies (#340).
 * For string-schema YAML bodies, drop the JSON variant and put `application/x-yaml` first so the parser picks it.
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
