import { describe, it, expect, beforeEach, afterEach, vi } from "vitest";
import { configureClient, EnterpriseFeatureError } from "@kestra-io/kestra-sdk";
import { searchAuditLogsForAllTenants } from "@kestra-io/kestra-sdk/audit-logs";
import { invitation } from "@kestra-io/kestra-sdk/invitations";

// Unit tests, no live backend needed: fetch is stubbed.
describe("EE-only-route 404 disambiguation", () => {
    beforeEach(() => {
        configureClient({ baseUrl: "http://localhost:8080" });
    });

    afterEach(() => {
        vi.unstubAllGlobals();
    });

    it("throws EnterpriseFeatureError for a 404 on a known EE-only route", async () => {
        vi.stubGlobal("fetch", vi.fn(async () =>
            new Response(JSON.stringify({ message: "Not Found" }), {
                status: 404,
                headers: { "content-type": "application/json" },
            })
        ));

        // GET /api/v1/auditlogs/search has no path params - exercises the non-templated case.
        const error = await searchAuditLogsForAllTenants().catch((e: unknown) => e);

        expect(error).toBeInstanceOf(EnterpriseFeatureError);
        expect((error as EnterpriseFeatureError).feature).toBe("audit-logs");
    });

    it("throws EnterpriseFeatureError for a 404 on a templated {tenant}-scoped EE-only route", async () => {
        vi.stubGlobal("fetch", vi.fn(async () =>
            new Response(JSON.stringify({ message: "Not Found" }), {
                status: 404,
                headers: { "content-type": "application/json" },
            })
        ));

        // GET /api/v1/{tenant}/invitations/{id} has two path params - proves matchRoute still
        // sees the templated path (not the resolved URL with real tenant/id values substituted in).
        const error = await invitation({ id: "missing-id", tenant: "main" }).catch((e: unknown) => e);

        expect(error).toBeInstanceOf(EnterpriseFeatureError);
        expect((error as EnterpriseFeatureError).feature).toBe("invitations");
    });
});
