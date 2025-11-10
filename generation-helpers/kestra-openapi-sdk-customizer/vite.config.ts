import { defineConfig } from "vite";
import { builtinModules } from "node:module";
import pkg from './package.json';

// ensure Node-builtins stay external
const externals = [...builtinModules, ...builtinModules.map((m) => `node:${m}`)];

export default defineConfig({
    build: {
        target: "node18",
        outDir: "dist",
        emptyOutDir: true,
        lib: {
            entry: "src/kestra-openapi-sdk-customizer.ts",
            formats: ["cjs"],
            fileName: () => "kestra-openapi-sdk-customizer.cjs",
        },
        rollupOptions: {
            external: externals,
            output: {
                // Make the output an executable CLI
                banner: "#!/usr/bin/env node",
            },
        },
    },
    define: {
      __APP_VERSION__: JSON.stringify(pkg.version),
    },
});
