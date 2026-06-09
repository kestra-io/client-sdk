import { describe, it, expect } from "vitest";
import * as FlowsAPI from "@kestra-io/kestra-sdk/flows";
import { flowLifecycleExample } from "./basicSDKUsageExample.js";
import fixtures from "./fixtures.json" with { type: "json" };

describe("flowLifecycleExample", () => {
    it("runs the README example end-to-end against a live Kestra", async () => {
        // The throwOnError client makes the example itself the assertion: any
        // drift from the SDK (wrong arg shape, renamed method, bad response
        // field) throws and fails the test. This is the CI guarantee behind the
        // injected README snippet (#144).
        try {
            const execution = await flowLifecycleExample(fixtures.tenantId);
            expect(execution.id).toBeTruthy();
        } finally {
            // Best-effort cleanup so the example is re-runnable within a session
            // (it creates a fixed company.team/hello_from_sdk flow). The example
            // configures the shared client before its first call, so the module
            // functions are usable here. Mirrors the Java/Python example tests.
            try {
                await FlowsAPI.deleteFlow({
                    tenant: fixtures.tenantId,
                    namespace: "company.team",
                    id: "hello_from_sdk",
                });
            } catch {
                // flow may not exist if the example failed before creating it
            }
        }
    });
});
