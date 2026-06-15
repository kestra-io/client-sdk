import { describe, it, expect } from "vitest";
import { configureAxios } from "@kestra-io/kestra-sdk";

describe("configureAxios timeout option", () => {
    it("defaults to 0 (infinite) when no timeout is provided", () => {
        const instance = configureAxios({});
        expect(instance.defaults.timeout).toBe(0);
    });

    it("propagates an explicit timeout value to the axios instance", () => {
        const instance = configureAxios({}, { timeout: 5000 });
        expect(instance.defaults.timeout).toBe(5000);
    });

    it("accepts timeout: 0 as an explicit infinite marker", () => {
        const instance = configureAxios({}, { timeout: 0 });
        expect(instance.defaults.timeout).toBe(0);
    });
});
