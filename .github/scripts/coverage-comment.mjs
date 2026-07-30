#!/usr/bin/env node
/**
 * Posts (or updates) a sticky comment on the pull request with the JavaScript
 * SDK test status:
 *
 *  - failing tests, grouped by spec file, each one linking to its source line
 *    on GitHub and showing the recorded error, so a red build is readable from
 *    the PR without digging through the job logs;
 *  - every uncovered function in `openapi/sdk/`.
 *
 * Failure data comes from `coverage/test-failures.json` (written by
 * test_javascript_sdk/failureReporter.ts), falling back to vitest's built-in
 * json report when that file is absent.
 *
 * Usage: node coverage-comment.mjs <coverage-final.json> [test-results.json] [test-failures.json]
 *
 * Env vars:
 *   GITHUB_REPOSITORY  – e.g. "owner/repo"       (required to post)
 *   PR_NUMBER          – pull-request number     (required to post)
 *   GH_TOKEN           – token with pull-requests:write
 *   COMMIT_SHA         – sha the spec links point at (defaults to GITHUB_SHA)
 *   RUN_URL            – link to the workflow run, shown next to the failures
 *   TESTS_OUTCOME      – outcome of the test step ("success" / "failure" / …).
 *                        Used to still report something when the run died
 *                        before writing any report.
 */

import { readFileSync, writeFileSync, existsSync } from "fs";
import { execSync } from "child_process";
import { join } from "path";

const MARKER = "<!-- js-sdk-coverage-comment -->";

/** Spec paths are rendered relative to this directory. */
const TEST_DIR = "javascript/test_javascript_sdk";
/** Failures listed in full; beyond that the comment would be unreadable. */
const MAX_FAILURES_SHOWN = 60;
/** Lines of error message kept per failing test. */
const MAX_ERROR_LINES = 8;
/** Characters kept per failing test error. */
const MAX_ERROR_CHARS = 600;
/** GitHub rejects comment bodies over 65536 characters. */
const MAX_BODY_CHARS = 60000;

const coveragePathArg =
    process.argv[2] ?? "javascript/coverage/coverage-final.json";
const testResultsPathArg =
    process.argv[3] ?? "javascript/coverage/test-results.json";
const failuresPathArg =
    process.argv[4] ?? "javascript/coverage/test-failures.json";
const repoRoot = join(import.meta.dirname, "..", "..");
const coveragePath = join(repoRoot, coveragePathArg);
const testResultsPath = join(repoRoot, testResultsPathArg);
const failuresPath = join(repoRoot, failuresPathArg);

const {
    GITHUB_REPOSITORY: repo,
    PR_NUMBER: prNumber,
    GITHUB_SERVER_URL: serverUrl = "https://github.com",
    COMMIT_SHA,
    GITHUB_SHA,
    RUN_URL,
    TESTS_OUTCOME,
} = process.env;

const sha = COMMIT_SHA || GITHUB_SHA;

// ---------------------------------------------------------------------------
// Helpers
// ---------------------------------------------------------------------------

/** Escape the characters that would break a markdown table cell or inline text. */
const escapeMd = (s) => s.replace(/([|`*_[\]<>])/g, "\\$1");

const stripAnsi = (s) => s.replace(/\[[0-9;]*m/g, "");

/**
 * Permalink to a spec file (optionally a given line) on GitHub. Returns null
 * when we don't know the repo/sha, so the caller can degrade to plain text.
 */
function specLink(file, line) {
    if (!repo || !sha) return null;
    const anchor = line ? `#L${line}` : "";
    return `${serverUrl}/${repo}/blob/${sha}/${TEST_DIR}/${file}${anchor}`;
}

/**
 * Keep the human-readable head of a vitest failure message: drop the stack
 * frames and clamp the length.
 */
function formatError(rawMessages) {
    const raw = stripAnsi(rawMessages?.[0] ?? "").trim();
    if (!raw) return "";

    const lines = [];
    for (const line of raw.split("\n")) {
        // Stack frames — "    at foo (/path:1:2)" and vitest's "❯ …" variant.
        if (/^\s*(at\s|❯\s)/.test(line)) break;
        lines.push(line);
    }

    let message = (lines.length ? lines : raw.split("\n"))
        .slice(0, MAX_ERROR_LINES)
        .join("\n")
        .trimEnd();

    if (message.length > MAX_ERROR_CHARS) {
        message = `${message.slice(0, MAX_ERROR_CHARS)}…`;
    }
    return message;
}

// ---------------------------------------------------------------------------
// Parse test results (failing tests)
// ---------------------------------------------------------------------------

/**
 * @type {{ file: string; name: string; title: string; suite: string;
 *          line: number | null; error: string }[]}
 */
const failingTests = [];
/** @type {string[]} */
const unhandledErrors = [];
let testResultsFound = false;
let testRunSucceeded = null;

// Preferred source: our own reporter, which keeps the real error message for
// timed-out tests (vitest's json report replaces it with an internal sentinel).
if (existsSync(failuresPath)) {
    try {
        const report = JSON.parse(readFileSync(failuresPath, "utf8"));
        testResultsFound = true;

        for (const failure of report.failures ?? []) {
            failingTests.push({
                file: failure.file ?? "unknown",
                name: failure.name ?? "<unnamed test>",
                title: failure.name ?? "<unnamed test>",
                suite: failure.suite ?? "",
                line: failure.line ?? null,
                error: formatError([failure.error]),
            });
        }

        for (const moduleError of report.moduleErrors ?? []) {
            failingTests.push({
                file: moduleError.file ?? "unknown",
                name: "(spec failed to load)",
                title: "(spec failed to load)",
                suite: "",
                line: null,
                error: formatError([moduleError.error]),
            });
        }

        unhandledErrors.push(...(report.unhandledErrors ?? []));
        testRunSucceeded =
            failingTests.length === 0 && unhandledErrors.length === 0;
    } catch (err) {
        console.warn("Could not parse failure report:", err.message);
    }
}

// Fallback: vitest's built-in json report.
if (!testResultsFound && existsSync(testResultsPath)) {
    try {
        const results = JSON.parse(readFileSync(testResultsPath, "utf8"));
        testResultsFound = true;
        testRunSucceeded = results.success !== false;

        for (const suite of results.testResults ?? []) {
            // vitest's json reporter names the field `name`; jest uses
            // `testFilePath`. Accept both so the script survives a reporter swap.
            const absolutePath = suite.name ?? suite.testFilePath ?? "";
            const inTestDir = absolutePath.match(
                new RegExp(`${TEST_DIR}/(.+)$`),
            );
            const file =
                inTestDir?.[1] ?? absolutePath.split("/").pop() ?? "unknown";

            for (const t of suite.assertionResults ?? []) {
                if (t.status !== "failed") continue;
                failingTests.push({
                    file,
                    name: t.fullName ?? t.title ?? "<unnamed test>",
                    title: t.title ?? t.fullName ?? "<unnamed test>",
                    suite: (t.ancestorTitles ?? []).join(" › "),
                    line: t.location?.line ?? null,
                    error: formatError(t.failureMessages),
                });
            }

            // A file that blew up while collecting (bad import, syntax error)
            // has no failed assertion, only a suite-level message.
            const suiteMessage = stripAnsi(suite.message ?? "").trim();
            const hasFailedAssertion = (suite.assertionResults ?? []).some(
                (t) => t.status === "failed",
            );
            if (suite.status === "failed" && !hasFailedAssertion) {
                failingTests.push({
                    file,
                    name: "(suite failed to run)",
                    title: "(suite failed to run)",
                    suite: "",
                    line: null,
                    error: suiteMessage
                        ? formatError([suiteMessage])
                        : "Suite failed before any test ran — see the run logs.",
                });
            }
        }
    } catch (err) {
        console.warn("Could not parse test results:", err.message);
    }
}

/** Failing tests grouped by spec file, files sorted alphabetically. */
const failingByFile = [...new Set(failingTests.map((t) => t.file))]
    .sort((a, b) => a.localeCompare(b))
    .map((file) => ({
        file,
        tests: failingTests.filter((t) => t.file === file),
    }));

// ---------------------------------------------------------------------------
// Parse coverage data
// ---------------------------------------------------------------------------

let totalFunctions = 0;
let coveredFunctions = 0;
const coverageFound = existsSync(coveragePath);

/** @type {{ file: string; uncovered: string[]; pct: number }[]} */
const uncoveredByFile = [];

if (coverageFound) {
    const coverage = JSON.parse(readFileSync(coveragePath, "utf8"));

    for (const [filePath, data] of Object.entries(coverage)) {
        if (!filePath.includes("openapi/sdk")) continue;

        const uncovered = [];

        for (const [key, count] of Object.entries(data.f)) {
            totalFunctions++;
            if (count === 0) {
                const fn = data.fnMap[key];
                const name =
                    fn?.name && !/^\(anonymous/.test(fn.name)
                        ? fn.name
                        : `<anonymous:${fn?.decl?.start?.line ?? "?"}>`;
                uncovered.push(name);
            } else {
                coveredFunctions++;
            }
        }

        if (uncovered.length > 0) {
            // Strip everything up to and including "openapi/sdk/" for a tidy display name.
            const match = filePath.match(/openapi\/sdk\/(.+)/);
            const file = match ? match[1] : filePath.split("/").pop();
            const totalFunctionsInFile = Object.keys(data.f).length;
            uncoveredByFile.push({
                file,
                uncovered,
                pct: totalFunctionsInFile
                    ? ((totalFunctionsInFile - uncovered.length) /
                          totalFunctionsInFile) *
                      100
                    : 0,
            });
        }
    }

    uncoveredByFile.sort((a, b) => a.file.localeCompare(b.file));
} else {
    console.log(`Coverage file not found at ${coveragePath}.`);
}

const pct =
    totalFunctions > 0
        ? ((coveredFunctions / totalFunctions) * 100).toFixed(1)
        : "100.0";

// ---------------------------------------------------------------------------
// Build the failing-tests section
// ---------------------------------------------------------------------------

/** Errors vitest could not attribute to any test (unhandled rejections, …). */
function buildUnhandledErrorsBlock() {
    if (unhandledErrors.length === 0) return "";
    const items = unhandledErrors
        .slice(0, 5)
        .map((e) => `  ${formatError([e]).split("\n").join("\n  ")}`)
        .join("\n\n");
    return `\n\n<details>
<summary>⚠️ ${unhandledErrors.length} unhandled error(s) outside of any test</summary>

\`\`\`
${items}
\`\`\`

</details>`;
}

function buildFailingSection() {
    if (failingTests.length === 0 && unhandledErrors.length > 0) {
        return `### ❌ JavaScript SDK — tests failed

No individual test failed, but the run recorded unhandled error(s).${
            RUN_URL ? ` See the [workflow logs](${RUN_URL}).` : ""
        }${buildUnhandledErrorsBlock()}`;
    }

    if (failingTests.length === 0) {
        // Nothing parseable, but the test step still went red: say so instead of
        // leaving the PR with a green-looking comment.
        if (TESTS_OUTCOME === "failure" && (!testResultsFound || !testRunSucceeded)) {
            const reason = testResultsFound
                ? "The run reported a failure but no individual test failed (setup, teardown or an unhandled error)"
                : "No test report was produced — the run failed before or while starting vitest";
            return `### ❌ JavaScript SDK — tests failed

${reason}.${RUN_URL ? ` See the [workflow logs](${RUN_URL}).` : ""}`;
        }
        return "";
    }

    const shown = failingTests.slice(0, MAX_FAILURES_SHOWN);
    const shownFiles = new Set(shown.map((t) => t.file));
    const hidden = failingTests.length - shown.length;
    // Expand automatically while the list is still short enough to skim.
    const open = failingTests.length <= 20 ? " open" : "";

    const groups = failingByFile
        .filter(({ file }) => shownFiles.has(file))
        .map(({ file, tests }) => {
            const items = tests
                .filter((t) => shown.includes(t))
                .map((t) => {
                    const link = specLink(file, t.line);
                    const label = escapeMd(t.title);
                    const heading = link ? `[${label}](${link})` : label;
                    const suite = t.suite ? ` — \`${t.suite}\`` : "";
                    const error = t.error
                        ? `\n\n  \`\`\`\n${t.error
                              .split("\n")
                              .map((l) => `  ${l}`)
                              .join("\n")}\n  \`\`\``
                        : "";
                    return `- **${heading}**${suite}${error}`;
                })
                .join("\n");

            const fileLink = specLink(file, null);
            const fileHeading = fileLink
                ? `<a href="${fileLink}"><code>${file}</code></a>`
                : `<code>${file}</code>`;

            return `<details${open}>
<summary>❌ ${fileHeading} — ${tests.length} failing</summary>

${items}

</details>`;
        })
        .join("\n\n");

    const fileCount = failingByFile.length;
    const summary = `**${failingTests.length}** test(s) failed across **${fileCount}** spec file(s).${
        RUN_URL ? ` [Full logs](${RUN_URL})` : ""
    }`;

    return `### ❌ JavaScript SDK — Failing Tests

${summary}

${groups}${hidden > 0 ? `\n\n_…and ${hidden} more failing test(s) — see the [workflow logs](${RUN_URL ?? "the run"})._` : ""}${buildUnhandledErrorsBlock()}

> Reproduce locally: \`cd javascript && sh run-tests.sh <kestra-version>\`, or target one file with
> \`npm test --workspace test_javascript_sdk -- ${failingByFile[0].file}\`.`;
}

// ---------------------------------------------------------------------------
// Build the coverage section
// ---------------------------------------------------------------------------

function buildCoverageSection() {
    if (!coverageFound) return "";

    if (uncoveredByFile.length === 0) {
        return `### ✅ JavaScript SDK — Function Coverage

All **${totalFunctions}** functions in \`openapi/sdk/\` are covered (**${pct}%**). Nothing to do here!`;
    }

    const rows = uncoveredByFile
        .map(({ file, uncovered, pct: filePct }) => {
            const fns = uncovered.map((f) => `\`${f}\``).join(", ");
            return `| \`${file}\` | ${uncovered.length} | ${fns} | ${filePct.toFixed(1)}% |`;
        })
        .join("\n");

    return `### ⚠️ JavaScript SDK — Uncovered Functions

**${pct}%** of functions covered (${coveredFunctions} / ${totalFunctions}).
${uncoveredByFile.length} file(s) contain functions with **no test coverage** in \`openapi/sdk/\`:

<details>
<summary>Show uncovered functions</summary>

| File | # uncovered | Functions | percentage |
|------|:-----------:|-----------|------------|
${rows}

</details>

> Run \`npm run test --workspace test_javascript_sdk -- --coverage\` locally to reproduce.`;
}

// ---------------------------------------------------------------------------
// Assemble the comment
// ---------------------------------------------------------------------------

// Failures first: they are what a dev opening the PR needs to act on.
const sections = [buildFailingSection(), buildCoverageSection()].filter(Boolean);

if (sections.length === 0) {
    console.log("Nothing to report (no coverage data, no test results) — skipping comment.");
    process.exit(0);
}

let body = `${MARKER}\n${sections.join("\n\n---\n\n")}`;

if (body.length > MAX_BODY_CHARS) {
    body = `${body.slice(0, MAX_BODY_CHARS)}\n\n_…comment truncated._${
        RUN_URL ? ` [Full logs](${RUN_URL})` : ""
    }`;
}

// ---------------------------------------------------------------------------
// Post or update sticky PR comment
// ---------------------------------------------------------------------------

writeFileSync("/tmp/coverage-body.json", JSON.stringify({ body }));

if (!repo || !prNumber) {
    console.log("GITHUB_REPOSITORY or PR_NUMBER not set — skipping comment.");
    console.log("Would have posted this comment:\n", body);
    process.exit(0);
}

let existingCommentId = null;
try {
    const raw = execSync(
        `gh api "repos/${repo}/issues/${prNumber}/comments?per_page=100"`,
        { encoding: "utf8" },
    );
    const comments = JSON.parse(raw);
    const existing = comments.find((c) => c.body?.includes(MARKER));
    if (existing) existingCommentId = existing.id;
} catch (err) {
    console.warn("Could not fetch existing comments:", err.message);
}

try {
    if (existingCommentId) {
        execSync(
            `gh api "repos/${repo}/issues/comments/${existingCommentId}" -X PATCH --input /tmp/coverage-body.json`,
            { stdio: "inherit" },
        );
        console.log(`Updated coverage comment (id ${existingCommentId}).`);
    } else {
        execSync(
            `gh api "repos/${repo}/issues/${prNumber}/comments" --input /tmp/coverage-body.json`,
            { stdio: "inherit" },
        );
        console.log("Posted new coverage comment.");
    }
} catch (err) {
    console.error("Failed to post coverage comment:", err.message);
    process.exit(1);
}
