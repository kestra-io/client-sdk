package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestInstanceAPI_VersionedPlugins(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	t.Run("available storage plugins", func(t *testing.T) {
		list, err := client.Instance().ListAvailableVersionedPluginsForStorage(ctx)
		require.NoError(t, err, "requires plugin management to be enabled (on by default on develop)")
		require.Greater(t, list.GetTotal(), int32(0), "the storage plugin catalogue is a fixed non-empty list")
		require.NotEmpty(t, list.GetResults())
		require.NotEmpty(t, list.GetResults()[0].GetArtifactId(), "each available plugin has an artifactId")
	})

	t.Run("available secret-manager plugins", func(t *testing.T) {
		list, err := client.Instance().ListAvailableVersionedPluginsForSecretManager(ctx)
		require.NoError(t, err)
		require.Greater(t, list.GetTotal(), int32(0), "the secret-manager plugin catalogue is a fixed non-empty list")
	})

	t.Run("available plugins", func(t *testing.T) {
		list, err := client.Instance().ListAvailableVersionedPlugins(ctx)
		require.NoError(t, err)
		require.Equal(t, int32(len(list.GetResults())), list.GetTotal(), "total matches the number of returned rows")
	})

	t.Run("installed plugins list", func(t *testing.T) {
		page, size := 1, 50
		results, err := client.Instance().ListVersionedPlugins(ctx, &page, &size, nil, nil)
		require.NoError(t, err, "the installed-plugins listing is reachable")
		require.GreaterOrEqual(t, results.GetTotal(), int64(0), "a valid page envelope is returned")
	})
}
