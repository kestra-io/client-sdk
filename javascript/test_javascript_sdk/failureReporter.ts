import { mkdirSync, writeFileSync } from "node:fs";
import { dirname, resolve } from "node:path";
import type { Reporter, SerializedError, TestCase, TestModule } from "vitest/node";

/**
 * Writes `coverage/test-failures.json`, consumed by
 * `.github/scripts/coverage-comment.mjs` to post the failing tests on the PR.
 *
 * Why not just read vitest's built-in `json` report? It serialises failures
 * from the error's stack, and for a timed-out test that stack belongs to
 * vitest's internal sentinel error — the report ends up with a useless
 * `Error: STACK_TRACE_ERROR` and the real "Test timed out in 5000ms." message
 * is nowhere in the file (the `junit` reporter drops those tests entirely).
 * Timeouts are a common way for these e2e specs to fail, so the reporter API,
 * which hands us the actual error objects, is the only source that keeps them.
 */

/** Anything before this in a module id is noise for a PR comment. */
const TEST_DIR = "test_javascript_sdk/";

interface RecordedFailure {
    /** Spec path relative to `test_javascript_sdk/`, e.g. `ExecutionsApi.spec.ts`. */
    file: string;
    /** Test title, e.g. `set_labels_on_terminated_executions_by_ids`. */
    name: string;
    /** Enclosing describe blocks, e.g. `ExecutionsApi › bulk`. */
    suite: string;
    /** Line of the `it(...)` call — needs `includeTaskLocation` in the config. */
    line: number | null;
    /** Recorded error(s), newest attempt first, deduplicated. */
    error: string;
}

interface FailureReport {
    /** Failing tests, in completion order. */
    failures: RecordedFailure[];
    /** Spec files that failed to load or collect at all. */
    moduleErrors: { file: string; error: string }[];
    /** Errors vitest could not attribute to a test. */
    unhandledErrors: string[];
}

function relativeSpec(moduleId: string | undefined): string {
    if (!moduleId) return "unknown";
    const index = moduleId.indexOf(TEST_DIR);
    return index === -1
        ? (moduleId.split("/").pop() ?? moduleId)
        : moduleId.slice(index + TEST_DIR.length);
}

/** `AssertionError: expected 1 to be 2`, without duplicating the name. */
function describeError(error: SerializedError): string {
    const message = (error.message ?? "").trim();
    const name = (error.name ?? "").trim();
    if (!message) return name || "Unknown error (no message recorded)";
    if (!name || message.startsWith(name)) return message;
    return `${name}: ${message}`;
}

/**
 * With `retry`, vitest keeps one error per attempt — almost always the same
 * message repeated. Show each distinct one once.
 */
function collectErrors(errors: ReadonlyArray<SerializedError>): string {
    const seen: string[] = [];
    for (const error of errors ?? []) {
        const described = describeError(error);
        if (!seen.includes(described)) seen.push(described);
    }
    return seen.join("\n\n") || "Test failed with no recorded error.";
}

export default class FailureReporter implements Reporter {
    private report: FailureReport = {
        failures: [],
        moduleErrors: [],
        unhandledErrors: [],
    };

    /**
     * Fires once per test with its final result, so a flaky test that passes on
     * a retry is never recorded as a failure.
     */
    onTestCaseResult(testCase: TestCase) {
        const result = testCase.result();
        if (result.state !== "failed") return;

        const name = testCase.name ?? "<unnamed test>";
        const fullName: string = testCase.fullName ?? name;
        // fullName is "Outer > Inner > title"; keep the describe path only.
        const suite = fullName.endsWith(name)
            ? fullName.slice(0, -name.length).replace(/\s*>\s*$/, "")
            : "";

        this.report.failures.push({
            file: relativeSpec(testCase.module?.moduleId),
            name,
            suite: suite.split(">").map((part: string) => part.trim()).filter(Boolean).join(" › "),
            line: testCase.location?.line ?? null,
            error: collectErrors(result.errors ?? []),
        });
    }

    onTestRunEnd(testModules: ReadonlyArray<TestModule>, unhandledErrors: ReadonlyArray<SerializedError>) {
        for (const module of testModules ?? []) {
            for (const error of module.errors()) {
                this.report.moduleErrors.push({
                    file: relativeSpec(module.moduleId),
                    error: describeError(error),
                });
            }
        }

        for (const error of unhandledErrors ?? []) {
            this.report.unhandledErrors.push(describeError(error));
        }

        // Always write the file, even for a green run: an empty report tells the
        // comment script "the suite ran and nothing failed", which is different
        // from a missing file ("the run died before reporting").
        const output = resolve(
            import.meta.dirname,
            "..",
            "coverage",
            "test-failures.json",
        );
        mkdirSync(dirname(output), { recursive: true });
        writeFileSync(output, `${JSON.stringify(this.report, null, 2)}\n`);
    }
}
