import { ref, watch, readonly } from "vue";
import type { Ref } from "vue";

function resolveStaticPatterns(
    value: string,
    contexts: {
        vars?: Record<string, string>;
        namespace?: Record<string, string>;
    },
): string {
    return value.replace(/\{\{\s*([\w]+(?:\.[\w]+)*)\s*\}\}/g, (match, path: string) => {
        const dotIndex = path.indexOf(".");
        if (dotIndex < 0) return match;
        const ctx = path.slice(0, dotIndex);
        const key = path.slice(dotIndex + 1);
        if (ctx === "vars" && contexts.vars) {
            const v = contexts.vars[key];
            return v !== undefined ? v : match;
        }
        if (ctx === "namespace" && contexts.namespace) {
            const v = contexts.namespace[key];
            return v !== undefined ? v : match;
        }
        return match;
    });
}

export interface ExpressionResolverFetchers {
    fetchFlow: (params: {
        namespace: string;
        id: string;
    }) => Promise<{ variables?: Record<string, string> }>;

    fetchNamespaceVars?: (namespace: string) => Promise<Record<string, string>>;

    evalExpression?: (params: {
        executionId: string;
        body: string;
    }) => Promise<{ result?: string; error?: string }>;
}

export function useExpressionResolver(
    namespace: Ref<string | undefined>,
    flowId: Ref<string | undefined>,
    executionId: Ref<string | undefined> | undefined,
    fetchers: ExpressionResolverFetchers,
) {
    const flowVars = ref<Record<string, string>>({});
    const nsVars = ref<Record<string, string>>({});

    watch(
        [namespace, flowId],
        async ([ns, fid]) => {
            if (!ns || !fid || ns.startsWith("{") || fid.startsWith("{")) return;
            try {
                const f = await fetchers.fetchFlow({ namespace: ns, id: fid });
                flowVars.value = (f?.variables ?? {}) as Record<string, string>;
            } catch {
                /* best-effort */
            }
            if (fetchers.fetchNamespaceVars) {
                try {
                    nsVars.value = await fetchers.fetchNamespaceVars(ns);
                } catch {
                    /* best-effort */
                }
            }
        },
        { immediate: true },
    );

    function resolveSync(value: string | undefined): string | undefined {
        if (!value) return value;
        return resolveStaticPatterns(value, {
            vars: flowVars.value,
            namespace: nsVars.value,
        });
    }

    async function resolve(value: string | undefined): Promise<string | undefined> {
        if (!value) return value;
        let out = resolveSync(value)!;
        const execId = executionId?.value;
        if (execId && fetchers.evalExpression && /\{\{/.test(out)) {
            try {
                const r = await fetchers.evalExpression({
                    executionId: execId,
                    body: out,
                });
                if (r?.result !== undefined) out = r.result;
            } catch {
                /* best-effort */
            }
        }
        return out;
    }

    return {
        resolve,
        resolveSync,
        flowVars: readonly(flowVars),
        nsVars: readonly(nsVars),
    };
}
