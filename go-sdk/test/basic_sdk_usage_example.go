package test

import (
	"context"
	"fmt"

	kestra "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

// The function between the region:flow-lifecycle / endregion markers below is
// the single source of truth for the Go usage snippet in the root README.md: it
// is injected verbatim by test-utils/EmbedSnippets.java and exercised against a
// live Kestra by TestBasicSDKUsageExample. Keeping the README snippet physically
// identical to tested code is what stops the docs from drifting (issue #144) —
// so edit the example here, never the README block, then re-run the injector:
//
//	java test-utils/EmbedSnippets.java --write README.md
//
// The caller supplies an authenticated client and the tenant; the README shows
// how to build the client just above the injected block.

// region:flow-lifecycle
// flowLifecycle lists the tenant's flows, creates one from YAML, updates it,
// then triggers an execution and waits for it to finish, returning its id.
func flowLifecycle(ctx context.Context, client *kestra.KestraClient, tenant string) (string, error) {
	namespace := "company.team"
	flowID := "hello_from_sdk"

	// List the first page of flows in the tenant.
	flows, err := client.Flows().SearchFlows(ctx, tenant, kestra.PtrInt(1), kestra.PtrInt(10), nil, nil)
	if err != nil {
		return "", err
	}
	fmt.Printf("Found %d flows\n", flows.GetTotal())

	// Create a flow from its YAML source.
	flowYAML := `id: hello_from_sdk
namespace: company.team

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello from the Kestra Go SDK!
`
	created, err := client.Flows().CreateFlow(ctx, tenant, flowYAML)
	if err != nil {
		return "", err
	}
	fmt.Printf("Created flow %s.%s (revision %d)\n", created.GetNamespace(), created.GetId(), created.GetRevision())

	// Update the flow — UpdateFlow takes (namespace, id, tenant, body).
	updatedYAML := `id: hello_from_sdk
namespace: company.team

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello after update!
`
	if _, err := client.Flows().UpdateFlow(ctx, namespace, flowID, tenant, updatedYAML); err != nil {
		return "", err
	}

	// Trigger an execution and wait for it to complete.
	execution, err := client.Executions().CreateExecution(ctx, tenant, namespace, flowID, nil, kestra.PtrBool(true), nil, nil, nil, nil)
	if err != nil {
		return "", err
	}
	state := execution.GetState()
	fmt.Printf("Execution %s finished in state %s\n", execution.GetId(), state.GetCurrent())

	return execution.GetId(), nil
}

// endregion
