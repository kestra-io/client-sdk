import { describe, it, expect } from "vitest";
import { featureToSlugMap } from "@kestra-io/kestra-sdk";
import { ENTERPRISE_ONLY_ROUTES_JSON } from "@kestra-io/kestra-sdk/enterprise-only-routes";

// Guards against the featureToSlugMap silently drifting out of sync with the generated registry.
describe("featureToSlugMap exhaustiveness", () => {
    it("has a key for every feature present in the generated EE-only route registry", () => {
        const registry: Record<string, { feature: string }> = JSON.parse(ENTERPRISE_ONLY_ROUTES_JSON);
        const registryFeatures = new Set(Object.values(registry).map(route => route.feature));

        const missing = [...registryFeatures].filter(feature => !(feature in featureToSlugMap));

        expect(missing).toEqual([]);
    });
});
