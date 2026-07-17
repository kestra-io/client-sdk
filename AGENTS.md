# Kestra Client SDK

## Prerequisites

### JavaScript SDK

Before running JavaScript SDK tests or working with the generated JavaScript SDK source, you **must** generate the SDK first:

```bash
./generate-sdks.sh javascript
```

This runs the OpenAPI generator, installs npm dependencies, and builds the SDK. The generated files live in `javascript/javascript-sdk/src/openapi/` and `javascript/javascript-sdk/dist/`.

> **Important:** Everything under `javascript/javascript-sdk/src/openapi/` is **auto-generated** and must not be edited by hand. Changes there will be overwritten on the next `./generate-sdks.sh javascript` run. To fix generated output, modify the generator sources instead:
>
> - `javascript/javascript-sdk/heyapi-sdk-plugin/plugin.ts` — custom hey-api plugin that emits the human-friendly SDK wrappers
> - `javascript/javascript-sdk/src/index.ts` — hand-written client setup and interceptors

## Repository Structure

- `javascript/` — JavaScript/TypeScript SDK
  - `javascript-sdk/` — SDK source (partly generated, partly hand-written)
  - `test_javascript_sdk/` — Vitest test suite
- `java/` — Java SDK
  - `java-sdk/` — SDK source
  - `java-sdk/java-sdk-test/` — JUnit 5 test suite
- `python/` — Python SDK
- `go-sdk/` — Go SDK
- `test-utils/` — Shared test data (flow YAML fixtures, etc.)
- `generation-helpers/` — Custom OpenAPI generator plugins
- `configurations/` — OpenAPI generator config files

## Running JavaScript Tests

```bash
cd javascript
npm test                        # run all tests
npm run check:types          # TypeScript type checking
```

Tests require a running Kestra instance at `http://localhost:9903` with credentials `root@root.com` / `Root!1234`.

## Generating SDKs

```bash
./generate-sdks.sh javascript   # JavaScript only
./generate-sdks.sh java         # Java only
./generate-sdks.sh python       # Python only
./generate-sdks.sh go           # Go only
```

## Signature Changes — Notify, Don't Block

Java, and now parts of Python (`executions_api.py`), are **hand-written**, not generated — a manual rewrite can silently drop a parameter with no generator to catch it. This already happened to `resumeExecution`'s `inputs` param in Java, and independently to `create_execution` / `resume_execution` / `replay_execution_with_inputs` in Python.

When touching a hand-written or generated API class, for every public method you change:

1. Diff the method's previous signature (params, types, arity) against the new one.
2. If it changed, add a line to the PR description under a `### ⚠️ Signature change` heading: `old signature → new signature`.
3. **Never block the change or revert it just because a signature changed** — a deliberate change is fine. The note exists so the reviewer and downstream SDK consumers (e.g. plugin-kestra) can catch an *unintended* drop before merge, not to gate the PR.

Unit tests alone won't catch this — they only fail if a test explicitly exercises the changed parameter. Plugin repos consuming this SDK run an analogous non-blocking check on their side (`kestra-plugin-developer` in `engineering-ai-hub`); a note here lets them catch a break sooner too.
