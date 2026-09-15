package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestMiscAPI_ConfigsAndPebble(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	t.Run("loginConfiguration", func(t *testing.T) {
		config, err := client.Misc().LoginConfiguration(ctx)
		require.NoError(t, err)
		require.NotNil(t, config, "the login configuration is always served")
	})

	t.Run("pebbleFilters", func(t *testing.T) {
		filters, err := client.Misc().PebbleFilters(ctx)
		require.NoError(t, err)
		require.NotEmpty(t, filters, "the Pebble filter catalogue is a fixed non-empty list")
	})

	t.Run("pebbleFunctions", func(t *testing.T) {
		functions, err := client.Misc().PebbleFunctions(ctx)
		require.NoError(t, err)
		require.NotEmpty(t, functions, "the Pebble function catalogue is a fixed non-empty list")
	})
}
