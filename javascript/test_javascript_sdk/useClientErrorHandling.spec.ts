import { describe, it, expect, beforeEach, vi } from "vitest";
import { configureClient, useClient } from "@kestra-io/kestra-sdk";

// Unit tests, no live backend needed: fetch is stubbed directly.
describe("useClient error handling", () => {
    beforeEach(() => {
        configureClient({ baseUrl: "http://localhost:8080" });
    });

    it("normalizes a JSON error body: status, message, and response.data", async () => {
        vi.stubGlobal("fetch", vi.fn(async () =>
            new Response(JSON.stringify({ message: "Invalid flow", constraints: "bad input" }), {
                status: 400,
                headers: { "content-type": "application/json" },
            })
        ));

        const client = useClient();
        await expect(client.get("http://localhost:8080/api/v1/flows/x/y")).rejects.toMatchObject({
            status: 400,
            message: "400 Invalid flow",
            response: {
                status: 400,
                data: { message: "Invalid flow", constraints: "bad input" },
            },
            constraints: "bad input",
        });

        vi.unstubAllGlobals();
    });

    it("shares a client.interceptors.error.use() registration with generated endpoint calls", async () => {
        vi.stubGlobal("fetch", vi.fn(async () =>
            new Response(JSON.stringify({ message: "nope" }), {
                status: 403,
                headers: { "content-type": "application/json" },
            })
        ));

        const client = useClient();
        const seenStatuses: unknown[] = [];
        configureClient({ baseUrl: "http://localhost:8080" }).interceptors.error.use((error) => {
            seenStatuses.push((error as { status?: number }).status);
            return error;
        });

        await expect(client.get("http://localhost:8080/api/v1/flows/x/y")).rejects.toBeDefined();
        expect(seenStatuses).toEqual([403]);

        vi.unstubAllGlobals();
    });
});
