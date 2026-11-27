import { spawn } from "child_process";
import { createRequire } from "module";
import { fileURLToPath, pathToFileURL } from "url";

const require = createRequire(import.meta.url);

// Run the package's JS bin with the current node binary: no shell, works on Windows too.
const spawnBin = (pkg, bin, args, stdio) => {
    const pkgJson = require.resolve(`${pkg}/package.json`);
    const { bin: entry } = require(pkgJson);
    const binPath = fileURLToPath(new URL(entry[bin], pathToFileURL(pkgJson)));
    return spawn(process.execPath, [binPath, ...args], { stdio });
};

const openapiTs = spawnBin("@hey-api/openapi-ts", "openapi-ts", ["--watch"], ["inherit", "pipe", "inherit"]);

let tsdownStarted = false;

openapiTs.stdout.on("data", (data) => {
    process.stdout.write(data);
    if (!tsdownStarted && data.toString().includes("Done!")) {
        tsdownStarted = true;
        const tsdown = spawnBin("tsdown", "tsdown", ["--watch"], "inherit");
        tsdown.on("close", (code) => process.exit(code ?? 0));
    }
});

openapiTs.on("close", (code) => {
    if (code !== 0) process.exit(code ?? 1);
});
