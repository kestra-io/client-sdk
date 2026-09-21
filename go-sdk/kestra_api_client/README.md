# kestra_api_client — Kestra Go SDK

Official Go SDK for the [Kestra](https://kestra.io) API. Use it to manage flows,
executions and other resources programmatically from a Go application.

All API operations, except for Superadmin-only endpoints, require a tenant
identifier in the HTTP path. Endpoints designated as Superadmin-only are not
tenant-scoped.

- Module: `github.com/kestra-io/client-sdk/go-sdk/v2`
- Package import path: `github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client`
- Source: <https://github.com/kestra-io/client-sdk> (`go-sdk`)

> This SDK is hand-written. Do not regenerate it — edit the sources under
> `go-sdk` directly.

## Installation

```sh
go get github.com/kestra-io/client-sdk/go-sdk/v2@latest
```

## Getting started

The SDK exposes a single client that contains all the API endpoints. Configure
the host, then pass authentication through the request `context`:

```go
package main

import (
	"context"
	"fmt"
	"log"

	kestra_api_client "github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func main() {
	// 1. Configure the client with the server URL.
	configuration := kestra_api_client.NewConfiguration()
	configuration.Servers = []kestra_api_client.ServerConfiguration{
		{URL: "http://localhost:8080"},
	}
	apiClient := kestra_api_client.NewAPIClient(configuration)

	// 2. Attach authentication to the context passed to each call.
	ctx := context.WithValue(context.Background(), kestra_api_client.ContextBasicAuth, kestra_api_client.BasicAuth{
		UserName: "root@root.com",
		Password: "Root!1234",
	})

	// 3. Build and execute a request.
	tenant := "main"
	flows, _, err := apiClient.FlowsAPI.SearchFlows(ctx, tenant).Page(1).Size(10).Execute()
	if err != nil {
		log.Fatalf("SearchFlows failed: %v", err)
	}
	fmt.Printf("Found %d flows\n", len(flows.Results))
}
```

For bearer-token authentication, use `kestra_api_client.ContextAccessToken`
instead of `ContextBasicAuth`.

See [`README_GO_SDK.md`](https://github.com/kestra-io/client-sdk/blob/main/README_GO_SDK.md)
in the repository root for release/versioning details.
