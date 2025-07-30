# Go SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` with the latest OpenSpec API changes (if necessary).

- As of 2025-06-13, `the kestra-ee.yml` has been generated and used without modifications.
- Micronaut OpenAPI version `6.16.2` was used. As of 2025-06-13, this version has not been committed to the core and was only modified locally.
2. Generate the SDK using the `generate-sdks.sh` script which uses the `openapi-generator-cli` Docker image.

Note: For now `go.mod` is generated with module name `github.com/GIT_USER_ID/GIT_REPO_ID`. You may need to manually change this, or investigate if this can be set at generation time.

## How to use

The OpenAPI generator produces a single Kestra client that includes all API endpoints.

You can import it like this:

```go
kestra_api_client "github.com/GIT_USER_ID/GIT_REPO_ID"
```

Then you need to follow two steps to configure the client:

* Step 1: Configure the server and instantiate the client:

```go
configuration := kestra_api_client.NewConfiguration()

configuration.Servers = []kestra_api_client.ServerConfiguration{
  {
      URL: url,
  },
}

apiClient := kestra_api_client.NewAPIClient(configuration)
```
* Step 2: Set up authentication

Authentication is configured through the request context:

```go
ctx := context.Background()

basicAuth := kestra_api_client.BasicAuth{
  UserName: username,
  Password: password,
}

ctx = context.WithValue(ctx, kestra_api_client.ContextBasicAuth, basicAuth)
```

With the context and client configured, create and execute your request:

```go
request := apiClient.FlowsAPI.SearchFlows(ctx, tenantId).Page(1).Size(10)
flows, resp, err := request.Execute()
```
