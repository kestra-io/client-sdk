import { describe, it, expect, beforeEach, afterEach, vi } from "vitest";
import type { AxiosResponse, InternalAxiosRequestConfig } from "axios";
import { configureClient, useClient } from "@kestra-io/kestra-sdk";

// Captures the outgoing request config so we can assert what the interceptor produced,
// without hitting a backend.
function stubAdapterCapturing(): { last: () => InternalAxiosRequestConfig } {
    const instance = configureClient();
    let captured: InternalAxiosRequestConfig;
    instance.defaults.adapter = async (config) => {
        captured = config;
        return {
            data: {},
            status: 200,
            statusText: "OK",
            headers: {},
            config,
        } as AxiosResponse;
    };
    return { last: () => captured };
}

function stubMetaToken(token: string) {
    vi.stubGlobal("document", {
        querySelectorAll: () => [{ getAttribute: () => token }],
    });
}

describe("CSRF interceptor", () => {
    afterEach(() => {
        vi.unstubAllGlobals();
    });

    it("sets X-CSRF-TOKEN from <meta> on unsafe methods", async () => {
        stubMetaToken("tok-123");
        const capture = stubAdapterCapturing();

        for (const method of ["post", "put", "patch", "delete"] as const) {
            await useClient().request({ url: "http://localhost/api/v1/x", method });
            expect(capture.last().headers["X-CSRF-TOKEN"]).toBe("tok-123");
        }
    });

    it("does not set X-CSRF-TOKEN on safe methods", async () => {
        stubMetaToken("tok-123");
        const capture = stubAdapterCapturing();

        await useClient().get("http://localhost/api/v1/x");
        expect(capture.last().headers["X-CSRF-TOKEN"]).toBeUndefined();
    });

    it("does not overwrite a caller-provided X-CSRF-TOKEN", async () => {
        stubMetaToken("tok-123");
        const capture = stubAdapterCapturing();

        await useClient().post("http://localhost/api/v1/x", null, {
            headers: { "X-CSRF-TOKEN": "caller-token" },
        });
        expect(capture.last().headers["X-CSRF-TOKEN"]).toBe("caller-token");
    });

    it("is a no-op outside the browser (no document)", async () => {
        // vitest node env: `document` is undefined unless stubbed.
        const capture = stubAdapterCapturing();

        await useClient().post("http://localhost/api/v1/x", null);
        expect(capture.last().headers["X-CSRF-TOKEN"]).toBeUndefined();
    });
});
