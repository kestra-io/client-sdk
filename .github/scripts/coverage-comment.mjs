#!/usr/bin/env node
/**
 * Reads a vitest/istanbul coverage-final.json and posts (or updates) a sticky
 * comment on the pull request listing every uncovered function in openapi/sdk/.
 *
 * Usage: node coverage-comment.mjs <path-to-coverage-final.json>
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

if (!existsSync(coveragePath)) {
    console.log(
        `Coverage file not found at ${coveragePath} — skipping comment.`,
    );
    process.exit(0);
}

const { GITHUB_REPOSITORY: repo, PR_NUMBER: prNumber } = process.env;
if (!repo || !prNumber) {
    console.log("GITHUB_REPOSITORY or PR_NUMBER not set — skipping comment.");
    process.exit(0);
}

// ---------------------------------------------------------------------------
// Helpers
// ---------------------------------------------------------------------------

/** Cache of source file lines keyed by absolute file path. */
const fileLineCache = new Map();

/**
 * Returns the source line (1-based) from a file, or "" if unreadable.
 * @param {string} filePath
 * @param {number|undefined} lineNumber
 */
function getSourceLine(filePath, lineNumber) {
    if (lineNumber == null) return "";
    if (!fileLineCache.has(filePath)) {
        try {
            fileLineCache.set(
                filePath,
                readFileSync(filePath, "utf8").split("\n"),
            );
        } catch {
            fileLineCache.set(filePath, []);
        }
    }
    return fileLineCache.get(filePath)[lineNumber - 1] ?? "";
}

/**
 * Tries to extract the variable name from lines like:
 *   export const generateApp = () => {}
 *   const generateApp = async () => {}
 * Returns null if no match.
 * @param {string} line
 */
function extractConstName(line) {
    const m = line.match(/(?:export\s+)?const\s+(\w+)\s*=/);
    return m ? m[1] : null;
}

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
            const line = fn?.loc?.start?.line;
            const name =
                fn?.name && fn.name !== "(anonymous)"
                    ? fn.name
                    : (extractConstName(getSourceLine(filePath, line)) ??
                      `<anonymous:${line ?? "?"}>`);
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
// Build comment body
// ---------------------------------------------------------------------------

let body;

if (uncoveredByFile.length === 0) {
    body = `${MARKER}
### ✅ JavaScript SDK — Function Coverage

All **${totalFunctions}** functions in \`openapi/sdk/\` are covered (**${pct}%**). Nothing to do here!`;
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

> Run \`npm run test --workspace test_javascript_sdk -- --coverage\` locally to reproduce.`;
}

// ---------------------------------------------------------------------------
// Post or update sticky PR comment
// ---------------------------------------------------------------------------

writeFileSync("/tmp/coverage-body.json", JSON.stringify({ body }));

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
