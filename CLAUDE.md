# Claude Code Notes

## JavaScript SDK

### After modifying the JavaScript SDK source, always run:

```bash
git merge main                    # sync with main first
./generate-sdks.sh javascript
```

This script:
1. Runs the OpenAPI SDK customizer (pre-processes `kestra-ee.yml`)
2. Updates the package version
3. Runs `npm install` (which updates `package-lock.json`)
4. Runs `npm run build` (which runs `openapi-ts` to generate `src/openapi/`, then `tsdown` to build `dist/`)

Forgetting this step will leave `package-lock.json` out of sync, causing CI failures.

The `dist/` and `src/openapi/` directories are in `.gitignore` (they are regenerated at build time), but `package-lock.json` IS tracked and must be committed when dependencies change.

### To run the integration tests:

```bash
cd javascript
./run-tests.sh [kestra-version]   # default version: develop
```

This script:
1. Runs `npm ci` and `npm run build` to build the SDK (skip with `--no-build`)
2. Spins up a Kestra instance via `docker compose -f docker-compose-ci.yml up`
3. Runs `npm run test --workspace test_javascript_sdk -- --coverage`
4. Tears down the Kestra container

Run the tests after any SDK change to catch regressions.
