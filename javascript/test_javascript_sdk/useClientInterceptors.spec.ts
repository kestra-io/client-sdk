import { describe, it, expect, beforeEach, vi } from "vitest";
import { configureClient, useClient } from "@kestra-io/kestra-sdk";

// Unit tests, no live backend needed: fetch is stubbed directly.
describe("useClient shares client.interceptors with configureClient()", () => {
    beforeEach(() => {
        configureClient({ baseUrl: "http://localhost:8080" });
    });

    it("applies a request interceptor registered on the client returned by configureClient()", async () => {
        let capturedRequest: Request | undefined;
        vi.stubGlobal("fetch", vi.fn(async (request: Request) => {
            capturedRequest = request;
            return new Response(JSON.stringify({ ok: true }), {
                status: 200,
                headers: { "content-type": "application/json" },
            });
        }));

        const client = configureClient({ baseUrl: "http://localhost:8080" });
        client.interceptors.request.use((request) => {
            request.headers.set("X-CSRF-TOKEN", "abc123");
            return request;
        });

        await useClient().get("http://localhost:8080/api/v1/foo");

        expect(capturedRequest?.headers.get("X-CSRF-TOKEN")).toBe("abc123");

        vi.unstubAllGlobals();
    });

    it("serializes params on useClient() calls the same way generated endpoints do", async () => {
        let capturedUrl = "";
        vi.stubGlobal("fetch", vi.fn(async (request: Request) => {
            capturedUrl = request.url;
            return new Response(JSON.stringify({ ok: true }), {
                status: 200,
                headers: { "content-type": "application/json" },
            });
        }));

        await useClient().get("http://localhost:8080/api/v1/foo", { params: { q: "bar", tags: ["a", "b"] } });

        expect(capturedUrl).toBe("http://localhost:8080/api/v1/foo?q=bar&tags=a&tags=b");

        vi.unstubAllGlobals();
    });
});
