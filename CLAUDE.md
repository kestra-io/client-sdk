# Claude Code Notes

## JavaScript SDK

### After modifying the JavaScript SDK source, always run:

```bash
./generate-sdks.sh javascript
```

This script:
1. Runs the OpenAPI SDK customizer (pre-processes `kestra-ee.yml`)
2. Updates the package version
3. Runs `npm install` (which updates `package-lock.json`)
4. Runs `npm run build` (which runs `openapi-ts` to generate `src/openapi/`, then `tsdown` to build `dist/`)

Forgetting this step will leave `package-lock.json` out of sync, causing CI failures.

The `dist/` and `src/openapi/` directories are in `.gitignore` (they are regenerated at build time), but `package-lock.json` IS tracked and must be committed when dependencies change.
