package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

// TestBasicSDKUsageExample runs the curated README example end-to-end against
// the live Kestra container. This is the CI guarantee for the injected snippet:
// if flowLifecycle (and therefore the README block produced from it by
// test-utils/EmbedSnippets.java) ever stops matching the SDK, this test fails.
// See issue #144.
func TestBasicSDKUsageExample(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	// Best-effort cleanup so the example is re-runnable within a session.
	defer func() {
		_ = client.Flows().DeleteFlow(ctx, "company.team", "hello_from_sdk", MAIN_TENANT)
	}()

	executionID, err := flowLifecycle(ctx, client, MAIN_TENANT)
	require.NoError(t, err)
	require.NotEmpty(t, executionID)
}
