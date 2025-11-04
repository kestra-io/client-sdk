import {promises as fs} from "fs";
import path from "path";
import yaml from "js-yaml";
import {sanitizeOpenAPI} from "./openapi-customizer";

async function run(confPath: string, inputPath: string, outputPath?: string) {
    const absIn = path.resolve(inputPath);
    const out = outputPath || absIn;

    const raw = await fs.readFile(absIn, "utf8");
    const spec = yaml.load(raw);

    const absConf = path.resolve(confPath);
    const configuration = JSON.parse(await fs.readFile(absConf, "utf8")) as { removeDeprecatedOperations?: boolean, removeDeprecatedParameters?: boolean, operationIdsToSkip?: string[] };

    const counters = sanitizeOpenAPI(spec, configuration);
    const dumped = yaml.dump(spec, {
        lineWidth: 120,
        noRefs: true,
        quotingType: '"',       // ← forces double quotes
    });
    await fs.writeFile(absIn.replace(/\.ya?ml$/i, ".raw-from-ee-kestra-repo.yml"), raw, "utf8");
    await fs.writeFile(out, dumped, "utf8");
    // eslint-disable-next-line no-console
    console.log(
        `Wrote ${path.basename(out)} (removed: ${counters.removedProperties} properties, ${counters.removedParameters} parameters, ${counters.removedOperations} operations)`
    );
    return {out, counters};
}

const DEFAULT_C0NF = "./configurations/kestra-openapi-sdk-customizer.json";
const DEFAULT_SPEC = "./kestra-ee.yml";

(async () => {
    const args = process.argv.slice(2);

    try {
        const confPath = args[0] ?? DEFAULT_SPEC;
        const inputSpecPath = args[1] ?? DEFAULT_SPEC;
        const {out, counters} = await run(
            confPath,
            inputSpecPath
        );

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