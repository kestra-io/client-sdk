# Go SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` if necessary with latest openspec api changes.

2. Generate the SDK using the script `generate-sdks.sh` that uses the openapi-generator-cli docker image.

Note: For now `go.mod` is generated with module name `github.com/GIT_USER_ID/GIT_REPO_ID` we will need to check if we can change that at generation time.

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

On the first request for a new version, `proxy.golang.org` fetches this repo,
finds the matching tag, zips the source, and caches it immutably (its checksum is
also recorded in `sum.golang.org`). Nothing is published by CI — the tag *is* the
release.

### Tag format: `go-sdk/vX.Y.Z` (not `vX.Y.Z-go`)

The other SDKs use a language suffix (`v1.2.3-java`, `-javascript`, `-python`) —
an arbitrary string that only exists to trigger the right release workflow; the
version is passed *into* the publish command, so the registry never sees the tag
name.

Go is the opposite: **the Go toolchain parses the tag name itself.** Because the
module lives in the `go-sdk/` subdirectory (its module path ends in `/go-sdk`),
the spec *requires* the tag to be `go-sdk/vMAJOR.MINOR.PATCH`. A `v1.1.0-go` tag
would never be resolved by `go get` — so the per-language suffix convention
deliberately does not apply here. The version is always the bare semver after the
`go-sdk/` prefix.

