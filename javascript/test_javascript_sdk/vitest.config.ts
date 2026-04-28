import { defineConfig } from "vitest/config";
import { resolve, join } from "path";

// Alias the SDK package to its source so V8 instruments src/ directly.
// The dist/ output doesn't exist until the SDK is built; pointing to src/
// also avoids needing source maps.
const sdkSrc = resolve(import.meta.dirname, "../javascript-sdk/src");

export default defineConfig({
    root: "..",
    resolve: {
        alias: {
            "@kestra-io/kestra-sdk": join(sdkSrc, "index.js"),
        },
    },

    test: {
        environment: "node",
        include: ["test_javascript_sdk/**/*.spec.{ts,js}"],
        coverage: {
            // Paths are relative to root (".."), so no "../" needed.
            // picomatch matches these against absolute file paths using
            // contains:true, and tinyglobby globs from root for all:true.
            include: ["javascript-sdk/src/api/**"],
            thresholds: {
                functions: 80,
            },
        },
    },
});