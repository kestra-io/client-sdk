# Kestra Client SDK

## Prerequisites

### JavaScript SDK

Before running JavaScript SDK tests or working with the generated JavaScript SDK source, you **must** generate the SDK first:

```bash
./generate-sdks.sh javascript
```

This runs the OpenAPI generator, installs npm dependencies, and builds the SDK. The generated files live in `javascript/javascript-sdk/src/openapi/` and `javascript/javascript-sdk/dist/`.

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

## NPM rules

The name of the workflow name `.github/workflows/javacript-sdk.yml` is hard linked into NPM registry so it should NEVER be changed otherwise it will break releases.