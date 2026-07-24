import { describe, it, expect, beforeEach, vi } from "vitest";
import { configureClient, EnterpriseFeatureError } from "@kestra-io/kestra-sdk";
import { searchAuditLogsForAllTenants } from "@kestra-io/kestra-sdk/audit-logs";

// Unit tests, no live backend needed: fetch is stubbed directly.
//
// searchAuditLogsForAllTenants calls "GET /api/v1/auditlogs/search", a real EE-only route from
// the generated registry (see enterprise-only-routes-plugin.ts /
// src/openapi/sdk/enterpriseOnlyRoutes.gen.ts) — unlike the axios-like useClient() facade, the
// generated SDK functions pass the templated OpenAPI path that matchRoute needs.
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
