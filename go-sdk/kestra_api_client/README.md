# kestra_api_client — Kestra Go SDK

Official Go SDK for the [Kestra](https://kestra.io) API. Use it to manage flows,
executions and other resources programmatically from a Go application.

All API operations, except for Instance-owner-only endpoints, require a tenant
identifier in the HTTP path. Endpoints designated as Instance-owner-only are not
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

Build a single `KestraClient` with `NewClient`, then reach every API through
its accessors (`Flows()`, `Executions()`, `Kv()`, ...):

```go
package main

import (
	"context"
	"fmt"
	"log"
	"os"

	kestra "github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func main() {
	client := kestra.NewClient(
		"http://localhost:8080",
		kestra.WithBasicAuth(os.Getenv("KESTRA_USERNAME"), os.Getenv("KESTRA_PASSWORD")),
		// ...or a bearer token (service-account API token / JWT):
		// kestra.WithTokenAuth(os.Getenv("KESTRA_TOKEN")),
	)
	ctx := context.Background()
	tenant := "main"

	// List the first page of flows in the tenant.
	flows, err := client.Flows().SearchFlows(ctx, tenant, kestra.PtrInt(1), kestra.PtrInt(10), nil, nil)
	if err != nil {
		log.Fatalf("SearchFlows failed: %v", err)
	}
	fmt.Printf("Found %d flows\n", flows.GetTotal())

	// Create a new flow from its YAML source.
	created, err := client.Flows().CreateFlow(ctx, tenant, `id: hello_from_sdk
namespace: company.team

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello from the Kestra Go SDK!
`)
	if err != nil {
		log.Fatalf("CreateFlow failed: %v", err)
	}
	fmt.Printf("Created flow %s.%s\n", created.GetNamespace(), created.GetId())
}
```

The legacy `NewAPIClient` / context-based authentication (`ContextBasicAuth`,
`ContextAccessToken`) is kept for backward compatibility; prefer `NewClient`
for new code.

See [`README_GO_SDK.md`](https://github.com/kestra-io/client-sdk/blob/main/README_GO_SDK.md)
in the repository root for release/versioning details.
