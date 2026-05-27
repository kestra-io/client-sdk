#!/usr/bin/env node
/**
 * Reads a vitest/istanbul coverage-final.json and posts (or updates) a sticky
 * comment on the pull request listing every uncovered function in openapi/sdk/,
 * and optionally lists failing tests from a vitest JSON report.
 *
 * Usage: node coverage-comment.mjs <path-to-coverage-final.json> [path-to-test-results.json]
 *
 * Required env vars:
 *   GITHUB_REPOSITORY  – e.g. "owner/repo"
 *   PR_NUMBER          – pull-request number
 *   GH_TOKEN           – GitHub token with pull-requests:write
 */

import { readFileSync, writeFileSync, existsSync } from "fs";
import { execSync } from "child_process";

const MARKER = "<!-- js-sdk-coverage-comment -->";

const coveragePath =
    process.argv[2] ?? "javascript/coverage/coverage-final.json";
const testResultsPath =
    process.argv[3] ?? "javascript/coverage/test-results.json";

if (!existsSync(coveragePath)) {
    console.log(
        `Coverage file not found at ${coveragePath} — skipping comment.`,
    );
    process.exit(0);
}

const { GITHUB_REPOSITORY: repo, PR_NUMBER: prNumber } = process.env;

// ---------------------------------------------------------------------------
// Helpers
// ---------------------------------------------------------------------------

// ---------------------------------------------------------------------------
// Parse coverage data
// ---------------------------------------------------------------------------

const coverage = JSON.parse(readFileSync(coveragePath, "utf8"));

let totalFunctions = 0;
let coveredFunctions = 0;

/** @type {{ file: string; uncovered: string[] }[]} */
const uncoveredByFile = [];

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
        uncoveredByFile.push({ file, uncovered });
    }
}

uncoveredByFile.sort((a, b) => a.file.localeCompare(b.file));

const pct =
    totalFunctions > 0
        ? ((coveredFunctions / totalFunctions) * 100).toFixed(1)
        : "100.0";

// ---------------------------------------------------------------------------
// Parse test results (failing tests)
// ---------------------------------------------------------------------------

/** @type {{ suite: string; name: string; message: string }[]} */
const failingTests = [];

if (existsSync(testResultsPath)) {
    try {
        const results = JSON.parse(readFileSync(testResultsPath, "utf8"));
        for (const suite of results.testResults ?? []) {
            const suiteName = suite.testFilePath
                ? suite.testFilePath.replace(/.*\/test_javascript_sdk\//, "")
                : "unknown";
            for (const t of suite.assertionResults ?? []) {
                if (t.status === "failed") {
                    const message = (t.failureMessages?.[0] ?? "")
                        .split("\n")[0]
                        .trim()
                        .replace(/^Error:\s*/, "");
                    failingTests.push({
                        suite: suiteName,
                        name: t.fullName,
                        message,
                    });
                }
            }
        }
    } catch (err) {
        console.warn("Could not parse test results:", err.message);
    }
}

// ---------------------------------------------------------------------------
// Build comment body
// ---------------------------------------------------------------------------

let body;

const failingTestsSection =
    failingTests.length === 0
        ? ""
        : `
### ❌ Failing Tests

${failingTests.length} test(s) failed:

<details>
<summary>Show failing tests</summary>

| Suite | Test | Error |
|-------|------|-------|
${failingTests
    .map(
        ({ suite, name, message }) =>
            `| \`${suite}\` | ${name} | ${message ? `\`${message}\`` : "—"} |`,
    )
    .join("\n")}

</details>
`;

if (uncoveredByFile.length === 0) {
    body = `${MARKER}
### ✅ JavaScript SDK — Function Coverage

All **${totalFunctions}** functions in \`openapi/sdk/\` are covered (**${pct}%**). Nothing to do here!${failingTestsSection}`;
} else {
    const rows = uncoveredByFile
        .map(({ file, uncovered }) => {
            const fns = uncovered.map((f) => `\`${f}\``).join(", ");
            return `| \`${file}\` | ${uncovered.length} | ${fns} |`;
        })
        .join("\n");

    body = `${MARKER}
### ⚠️ JavaScript SDK — Uncovered Functions

**${pct}%** of functions covered (${coveredFunctions} / ${totalFunctions}).
${uncoveredByFile.length} file(s) contain functions with **no test coverage** in \`openapi/sdk/\`:

<details>
<summary>Show uncovered functions</summary>

| File | # uncovered | Functions |
|------|:-----------:|-----------|
${rows}

</details>

> Run \`npm run test --workspace test_javascript_sdk -- --coverage\` locally to reproduce.${failingTestsSection}\`\`\``;
}

// ---------------------------------------------------------------------------
// Post or update sticky PR comment
// ---------------------------------------------------------------------------

writeFileSync("/tmp/coverage-body.json", JSON.stringify({ body }));

let existingCommentId = null;
try {
    if (!repo || !prNumber) {
        console.log(
            "GITHUB_REPOSITORY or PR_NUMBER not set — skipping comment.",
        );
        console.log("Would have posted this comment:\n", body);
        process.exit(0);
    }
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
