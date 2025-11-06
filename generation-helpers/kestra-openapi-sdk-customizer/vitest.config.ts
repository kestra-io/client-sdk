import { defineConfig } from "vitest/config";
import pkg from "./package.json";

export default defineConfig({
    test: {
        environment: "node",
        include: ["src/**/*.test.ts"],
        coverage: {
            reporter: ["text", "html"],
            reportsDirectory: "coverage",
        },
    },
    define: {
      __APP_VERSION__: JSON.stringify(pkg.version),
    },
});
