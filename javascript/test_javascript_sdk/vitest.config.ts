import { defineConfig } from "vitest/config";

export default defineConfig({
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
