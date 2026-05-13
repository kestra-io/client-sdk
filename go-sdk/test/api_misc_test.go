package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestMiscAPI_All(t *testing.T) {
	t.Run("configurationTest", func(t *testing.T) {
		ctx := context.Background()

		config, err := KestraTestClient().Misc().Configuration(ctx)
		require.NoError(t, err)
		require.NotNil(t, config)
	})

	t.Run("pingTest", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Misc().Ping(ctx)
		require.NoError(t, err)
		require.Equal(t, "pong", result)
	})
}
