import { describe, it, expect, beforeEach, vi } from "vitest";
import { configureClient, EnterpriseFeatureError } from "@kestra-io/kestra-sdk";
import { searchAuditLogsForAllTenants } from "@kestra-io/kestra-sdk/audit-logs";

// Unit test, no live backend needed: fetch is stubbed. Uses a real EE-only route
// (GET /api/v1/auditlogs/search) via a generated SDK function so matchRoute gets a templated path.
describe("EE-only-route 404 disambiguation", () => {
    beforeEach(() => {
        configureClient({ baseUrl: "http://localhost:8080" });
    });

    it("throws EnterpriseFeatureError for a 404 on a known EE-only route", async () => {
        vi.stubGlobal("fetch", vi.fn(async () =>
            new Response(JSON.stringify({ message: "Not Found" }), {
                status: 404,
                headers: { "content-type": "application/json" },
            })
        ));

        const error = await searchAuditLogsForAllTenants().catch((e: unknown) => e);

        expect(error).toBeInstanceOf(EnterpriseFeatureError);
        expect((error as EnterpriseFeatureError).feature).toBe("audit-logs");

        vi.unstubAllGlobals();
    });
});
