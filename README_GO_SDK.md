# Go SDK

## History: how the SDK was originally generated (before #230)

> **This SDK is hand-written since #230.** `./generate-sdks.sh` refuses to run
> for it, and the generator apparatus (`.openapi-generator/` metadata, embedded
> spec copy) has been removed from this repository. Edit the sources under
> `go-sdk` directly. The steps below describe how the SDK was generated before
> that change, kept for historical context only.

1. The `kestra-ee.yml` was updated as needed with the latest openapi spec changes.

2. The SDK was generated using the (now-removed) `generate-sdks.sh` script, which used the openapi-generator-cli docker image.

Note: `go.mod` was originally generated with module name `github.com/GIT_USER_ID/GIT_REPO_ID`.

## Step to use

The OpenApi generate a single Kestra Client that contains all the API endpoints.
You can import it like this:
```go
kestra_api_client "github.com/GIT_USER_ID/GIT_REPO_ID"
```

Then you need two step to configure the client:
* Set up the host URL in the server through the configuration and instantiate the client:
```go
configuration := kestra_api_client.NewConfiguration()

configuration.Servers = []kestra_api_client.ServerConfiguration{
  {
      URL: url,
  },
}

apiClient := kestra_api_client.NewAPIClient(configuration)
```
* Set up the authentication through the context that will be pass when calling the API:
```go
ctx := context.Background()

basicAuth := kestra_api_client.BasicAuth{
  UserName: username,
  Password: password,
}

ctx = context.WithValue(ctx, kestra_api_client.ContextBasicAuth, basicAuth)
```

Then finally create the request with the context and execute it:

```go
request := apiClient.FlowsAPI.SearchFlows(ctx, tenantId).Page(1).Size(10)
flows, resp, err := request.Execute()
```

## Releasing

Releasing is therefore a single action — pushing a Git tag.

```bash
git tag go-sdk/v1.1.0 <commit>
git push origin go-sdk/v1.1.0
```

Consumers then pull that exact version with:

```bash
go get github.com/kestra-io/client-sdk/go-sdk@v1.1.0
```

For a `v2.0.0` and later tag, Go modules require the module path itself to carry
the major version suffix (`go.mod`'s `module` line becomes
`github.com/kestra-io/client-sdk/go-sdk/v2`), so the pull command becomes:

```bash
go get github.com/kestra-io/client-sdk/go-sdk/v2@v2.0.0
```

On the first request for a new version, `proxy.golang.org` fetches this repo,
finds the matching tag, zips the source, and caches it immutably (its checksum is
also recorded in `sum.golang.org`). Nothing is published by CI — the tag *is* the
release.

### Tag format: `go-sdk/vX.Y.Z` (not `vX.Y.Z-go`)

The other SDKs use a language suffix (`v1.2.3-java`, `v1.2.3-javascript`, `v1.2.3-python`) —
an arbitrary string that only exists to trigger the right release workflow; the
version is passed *into* the publish command, so the registry never sees the tag
name.

Go is the opposite: **the Go toolchain parses the tag name itself.** Because the
module lives in the `go-sdk/` subdirectory (its module path ends in `/go-sdk`),
the spec *requires* the tag to be `go-sdk/vMAJOR.MINOR.PATCH`. A `v1.1.0-go` tag
would never be resolved by `go get` — so the per-language suffix convention
deliberately does not apply here. The version is always the bare semver after the
`go-sdk/` prefix.

## Complex queries (AND / OR filters)

Every `*ByQuery` / search endpoint accepts grouped filters. Build them with the `query`
DSL instead of hand-encoding `filters[...]` strings:

```go
import kestra "github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"

filters := kestra.Where(
    kestra.And(
        kestra.Eq(kestra.FilterNamespace, "company.team"),
        kestra.Or(
            kestra.Eq(kestra.FilterState, "SUCCESS"),
            kestra.Eq(kestra.FilterState, "WARNING"),
        ),
    ),
)
// filters is a []SearchFilter — pass it to the search / *ByQuery calls that accept filters.
```

- Helpers: `Where`, `And`, `Or`, `Eq`, `NotEq`, `In`, `NotIn`, `Contains`, `StartsWith`,
  `EndsWith`, `Regex`, `Prefix`, `Gt`, `Gte`, `Lt`, `Lte`, and the generic `FilterBy(field, op, value)`
  (named `FilterBy` rather than `Filter` because `Filter` is an existing model type).
- **Backward compatible:** a plain `[]SearchFilter` (or `Where(And(...leaves))`) serializes to the
  same flat `filters[field][OP]=value` wire format as before.
- Nesting is **one level deep** (an `And` containing an `Or`, or vice-versa). This is a client-side
  cap, not a server limit — the Kestra backend accepts deeper trees (default `maxDepth 3` /
  `maxWidth 20`, and the UI itself caps at 2). A tree deeper than one level (or a structurally
  invalid one) is reported as an error from the search / `*ByQuery` method's existing `error` return
  — the DSL and serializer never panic.

