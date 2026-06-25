import { ref, watch } from "vue";
import { resolveTenant, useClient } from "../index";

/** Only values that actually contain a Pebble expression are worth a round-trip. */
const EXPRESSION_RE = /\{\{.*?}}/;

export interface RenderContext {
    executionId?: string;
    namespace?: string;
    flowId?: string;
    /** Live (possibly unsaved) flow source — resolves draft edits before they are saved. */
    flow?: string;
}

/**
 * Resolves Pebble expressions for display via `POST /api/v1/{tenant}/expressions/render`.
 *
 * Resolution is best-effort and segment-by-segment:
 * - `secret()` → `[secret: KEY]`
 * - `vars.*`, `flow.*`, `globals.*` → resolved
 * - `inputs.*`, `outputs.*`, `execution.*` → resolved when an executionId is provided; raw otherwise
 * - `env()`, `kv()`, non-deterministic / IO functions → kept raw
 * - Anything unresolvable → kept raw (no error thrown)
 *
 * Context priority (handled server-side): executionId → flow source → namespace + flowId → globals only.
 */
export function useRenderedExpressions(
    expressions: () => Array<string | undefined>,
    context: () => RenderContext,
) {
    const rendered = ref<Record<string, string>>({});

    async function load() {
        const values = (expressions() ?? []).filter(
            (v): v is string => typeof v === "string" && EXPRESSION_RE.test(v),
        );
        if (values.length === 0) {
            rendered.value = {};
            return;
        }
        try {
            const tenant = resolveTenant(undefined);
            const client = useClient();
            const ctx = context() ?? {};
            const resp = await client.post(
                `/api/v1/${tenant}/expressions/render`,
                {
                    expressions: values,
                    executionId: ctx.executionId,
                    namespace: ctx.namespace,
                    flowId: ctx.flowId,
                    flow: ctx.flow,
                },
                { validateStatus: (s: number) => s === 200 },
            );
            rendered.value = (resp.data?.rendered as Record<string, string>) ?? {};
        } catch {
            /* best-effort: keep raw values */
        }
    }

    watch(
        [
            () => (expressions() ?? []).join(" "),
            () => JSON.stringify(context() ?? {}),
        ],
        load,
        { immediate: true },
    );

    /** Returns the rendered value for `value`, falling back to the raw value. */
    function display(value?: string): string | undefined {
        if (value === undefined) return undefined;
        return rendered.value[value] ?? value;
    }

    return { display };
}
