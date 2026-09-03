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
        // failureReporter writes coverage/test-failures.json, which the PR
        // comment is built from (.github/scripts/coverage-comment.mjs). It reads
        // the error objects directly because the json report loses the message
        // of a timed-out test — see the comment in failureReporter.ts.
        reporters: ["default", "json", "./test_javascript_sdk/failureReporter.ts"],
        outputFile: {
            json: "coverage/test-results.json"
        },
        // Records each test's line number, so the PR comment can link straight
        // to the failing test's source on GitHub.
        includeTaskLocation: true,
        retry: 3,
        // The suite authenticates with HTTP Basic on every request, which EE verifies with
        // bcrypt (cost 12). On the current develop image that path got slow enough for the
        // bulk/query tests to overrun vitest's 5s default, so give them room.
        testTimeout: 20000,
        // All spec files share a single Kestra instance (docker-compose-ci.yml starts one
        // container), so unbounded file parallelism has every file's HTTP calls and
        // executions contending for the same worker threads and queue. Cap it to reduce
        // that contention; ExecutionsApi.spec.ts alone already dominates the suite's wall
        // clock, so the other files have slack to spare even at reduced concurrency.
        maxWorkers: 3,
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