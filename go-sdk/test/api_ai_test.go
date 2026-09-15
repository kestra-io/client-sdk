package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestAiAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	t.Run("listProviders", func(t *testing.T) {
		providers, err := client.Ai().ListAiProviders(ctx)
		if skipIfGated(t, err, "the AI Copilot") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, providers, "the providers endpoint returns a JSON array, not null")
	})

	t.Run("listThreads", func(t *testing.T) {
		threads, err := client.Ai().ListThreads(ctx, MAIN_TENANT)
		if skipIfGated(t, err, "the COPILOT feature") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, threads, "the threads listing returns a JSON array, not null")
	})

	t.Run("getUnknownThread", func(t *testing.T) {
		_, err := client.Ai().Thread(ctx, "missing-"+randomId(), MAIN_TENANT)
		require.Error(t, err, "fetching a missing AI thread is an error")
	})

	t.Run("generateAndChatNeedAConfiguredProvider", func(t *testing.T) {
		// generate/app|dashboard|test|flow, thread create/rename/delete and the SSE
		// chat/confirm turns all call a configured LLM provider (503 without one),
		// and the EE generators additionally require a provider API key.
		t.Skip("AI generation and chat need a configured provider with an API key; wrappers are compile-and-coverage only")
	})
}
