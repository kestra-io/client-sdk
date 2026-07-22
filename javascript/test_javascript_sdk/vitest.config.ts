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

const IGNORE_APIS = [
    "Ai",
    "Login",
    "TenantAccess",
    "WorkerAuth",
].flatMap(api => [`${api}Admin`, api]); // Ignore both regular and admin versions of these APIs

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
        setupFiles: ["test_javascript_sdk/_setup.ts"],
        environment: "node",
        include: ["test_javascript_sdk/**/*.spec.ts"],
        reporters: ["default", "json"],
        outputFile: {
            json: "coverage/test-results.json"
        },
        retry: 3,
        globalSetup: ["test_javascript_sdk/globalSetup.ts"],
        coverage: {
            // Paths are relative to root (".."), so no "../" needed.
            // picomatch matches these against absolute file paths using
            // contains:true, and tinyglobby globs from root for all:true.
            include: ["javascript-sdk/src/openapi/sdk/**"],
            exclude: IGNORE_APIS.flatMap(api => [
                `javascript-sdk/src/openapi/sdk/${api}.gen.ts`,
            ]),
            reporter: ["text", "json"],
            // Ratcheting floor: gates against coverage regressions. Bump this
            // number up as each coverage PR lands (see #332); the goal is 90
            // with perFile: true. Kept just below the current global level so
            // normal test flakiness doesn't trip it, while a real regression
            // (a whole untested domain) still fails CI.
            thresholds: {
                perFile: false,
                functions: 75,
            },
        },
    },
});