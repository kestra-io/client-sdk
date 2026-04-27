import { spawn } from "child_process";

const openapiTs = spawn("openapi-ts", ["--watch"], {
    shell: true,
    stdio: ["inherit", "pipe", "inherit"],
});

let tsdownStarted = false;

openapiTs.stdout.on("data", (data) => {
    process.stdout.write(data);
    if (!tsdownStarted && data.toString().includes("Done!")) {
        tsdownStarted = true;
        const tsdown = spawn("tsdown", ["--watch"], {
            shell: true,
            stdio: "inherit",
        });
        tsdown.on("close", (code) => process.exit(code ?? 0));
    }
});

openapiTs.on("close", (code) => {
    if (code !== 0) process.exit(code ?? 1);
});
