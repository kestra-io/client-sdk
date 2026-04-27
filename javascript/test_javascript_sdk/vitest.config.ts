import { defineConfig } from "vitest/config";
import { resolve, join } from "path";
import { sdkEntries } from "../javascript-sdk/tsdown.config.js";

// Alias the SDK package to its source so V8 instruments src/ directly.
// The dist/ output doesn't exist until the SDK is built; pointing to src/
// also avoids needing source maps.
const sdkSrc = resolve(import.meta.dirname, "../javascript-sdk");

const fullPathSdkEntries = Object.fromEntries(
    Object.entries(sdkEntries).map(([name, path]) => [`@kestra-io/kestra-sdk/${name}`, join(sdkSrc, path)])
);

export default defineConfig({
    root: "..",
    resolve: {
        alias: {
            ...fullPathSdkEntries,
            "@kestra-io/kestra-sdk/client": join(sdkSrc, "src/openapi/client.gen.ts"),
            "@kestra-io/kestra-sdk": join(sdkSrc, "src/index.ts"),
        },
    },

    test: {
        environment: "node",
        include: ["test_javascript_sdk/**/*.spec.ts"],
        coverage: {
            // Paths are relative to root (".."), so no "../" needed.
            // picomatch matches these against absolute file paths using
            // contains:true, and tinyglobby globs from root for all:true.
            include: ["javascript-sdk/src/sdk/**"],
            thresholds: {
                functions: 80,
            },
        },
    },
});