import {promises as fs} from "fs";
import path from "path";
import yaml from "js-yaml";
import {sanitizeOpenAPI} from "./openapi-customizer";

async function run(inputPath: string, opts: {
    removeDeprecatedOperations?: boolean,
    operationIdsToSkip?: string[]
} = {}, outputPath?: string) {
    const absIn = path.resolve(inputPath);
    const out = outputPath || absIn.replace(/\.ya?ml$/i, ".without-deprecated.yml");

    const raw = await fs.readFile(absIn, "utf8");
    const spec = yaml.load(raw);
    const counters = sanitizeOpenAPI(spec, opts);
    const dumped = yaml.dump(spec, {
        lineWidth: 120,
        noRefs: true,
        quotingType: '"',       // ← forces double quotes
    });
    await fs.writeFile(out, dumped, "utf8");
    // eslint-disable-next-line no-console
    console.log(
        `Wrote ${path.basename(out)} (removed: ${counters.removedProperties} properties, ${counters.removedParameters} parameters, ${counters.removedOperations} operations)`
    );
    return {out, counters};
}

const DEFAULT_SPEC = "./kestra-ee.yml";

(async () => {
    const args = process.argv.slice(2);

    try {
        const inputSpecPath = args[0] ?? DEFAULT_SPEC;
        const {out, counters} = await run(inputSpecPath,
            {
                operationIdsToSkip: [
                    'triggerExecutionByPostWebhook',
                    'validateNewExecutionInputs',
                    'validateResumeExecutionInputs',
                    'triggerExecutionByPutWebhook',
                    'triggerExecution',
                    'searchTaskRun',
                    'searchExecutionsByFlowId',
                    'resumeExecutionFromBreakpoint',
                    'previewFileFromExecution',
                    'listFlowExecutionsByNamespace',
                    'listExecutableDistinctNamespaces',
                    'followDependenciesExecutions'
                ]
            });

        const stat = await fs.stat(out);
        if (!stat || stat.size <= 0) throw new Error("Output file is empty");
        // eslint-disable-next-line no-console
        console.log("Removed counters:", counters);
    } catch (e: any) {
        if (e && e.code === "ENOENT") {
            // eslint-disable-next-line no-console
            console.warn(`⚠️  Spec file not found: ${DEFAULT_SPEC}. Place your spec there or call run(<path>).`);
        }
        throw e;
    }
})();