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

