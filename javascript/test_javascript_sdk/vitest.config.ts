import { defineConfig } from "vitest/config";
import { resolve } from "path";

// Redirect SDK imports to source so V8 instruments src/ directly,
// avoiding the need for a dist build with source maps and ensuring
// coverage paths resolve within the project root.
const sdkSrc = resolve(import.meta.dirname, "../javascript-sdk/src/index.js");

export default defineConfig({
    resolve: {
        alias: {
            "@kestra-io/kestra-sdk": sdkSrc,
        },
    },
    test: {
        environment: "node",
        include: ["**/*.spec.ts", "**/*.spec.js"],
        coverage: {
            provider: "v8",
            include: ["../javascript-sdk/src/api/**"],
            reporter: ["text", "html", "json", "lcov"],
            all: true,
            thresholds: {
                functions: 100,
            },
        },
    },
});
