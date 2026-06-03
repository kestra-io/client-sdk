# Releasing the Go SDK

The Go SDK is released by **pushing a git tag**. There is no goreleaser or
publish job — Go's module proxy (`proxy.golang.org`) indexes the tag
automatically on the first `go get`.

## Key facts about this module

| Thing            | Value |
|------------------|-------|
| Module path      | `github.com/kestra-io/client-sdk/go-sdk` (lives in a **subdirectory**) |
| Tag format       | `go-sdk/vX.Y.Z` — the `go-sdk/` prefix is **mandatory** for subdirectory modules |
| Publish          | `git push` the tag; the proxy indexes it on first fetch |
| Major versions   | `v2+` requires changing the module path to `.../go-sdk/v2` **and** tagging `go-sdk/v2.0.0` |

> ⚠️ Always tag `go-sdk/vX.Y.Z`, never a bare `vX.Y.Z`. A bare tag will **not**
> resolve for this subdirectory module.

## Choosing the version

Follow [semantic versioning](https://semver.org/):

- **Patch** (`vX.Y.Z+1`) — bug fixes, no API changes.
- **Minor** (`vX.Y+1.0`) — new features, **backward-compatible**. Existing
  consumers upgrade with zero code changes.
- **Major** (`vX+1.0.0`) — **breaking** API changes. Requires the `/vN` module
  path suffix (see "Breaking releases" below).

---

## Step 0 — Prerequisites

The change you want to release must be merged to `main` (or the relevant
`releases/v*` branch) with CI green.

```bash
git checkout main
git pull origin main

# Confirm the merge commit is present and CI passed
git log -1 --oneline
gh run list --branch main --workflow go-sdk.yml --limit 1
```

## Step 1 — Sanity-check the module from a clean tree

```bash
cd go-sdk
go build ./...
go vet ./...
# Optional full integration suite (needs Docker + EE license):
# sh run-tests.sh develop
```

Make sure there is **no leftover `replace` directive** and the working tree is
clean:

```bash
git status --porcelain go-sdk/        # must be empty
grep -n replace go-sdk/go.mod || echo "no replace ✓"
```

## Step 2 — Create the tag

Tag the merge commit on `main` (replace `X.Y.Z` with the chosen version):

```bash
git checkout main && git pull origin main

git tag -a go-sdk/vX.Y.Z -m "go-sdk vX.Y.Z

<short summary of what changed in this release>"
```

## Step 3 — Push the tag

```bash
git push origin go-sdk/vX.Y.Z
```

## Step 4 — Verify it is published

```bash
# Force the proxy to fetch/index the new version (run from anywhere online):
GOPROXY=proxy.golang.org go list -m github.com/kestra-io/client-sdk/go-sdk@vX.Y.Z
# → github.com/kestra-io/client-sdk/go-sdk vX.Y.Z
```

Indexing can take a few seconds on the first request.

## Step 5 — (Optional) Create a GitHub Release for changelog visibility

```bash
gh release create go-sdk/vX.Y.Z \
  --title "Go SDK vX.Y.Z" \
  --notes "<release notes>" \
  --target main
```

## Step 6 — Bump consumers

For each consumer of the SDK (e.g. `kestractl`):

```bash
go get github.com/kestra-io/client-sdk/go-sdk@vX.Y.Z
go mod tidy
go build ./... && go test ./...
git add go.mod go.sum && git commit -m "chore: bump go-sdk to vX.Y.Z"
```

---

## Breaking releases (`v2` and beyond)

Go enforces semantic import versioning: a major version `v2+` must live at a
distinct import path. To release a breaking version:

1. Update the module path in `go-sdk/go.mod`:
   ```
   module github.com/kestra-io/client-sdk/go-sdk/v2
   ```
2. Update internal imports within the module accordingly.
3. Tag `go-sdk/v2.0.0` and push as above.
4. Consumers must update their import paths to `.../go-sdk/v2`.

Prefer keeping releases backward-compatible (minor bumps) whenever possible so
consumers upgrade without code changes.
