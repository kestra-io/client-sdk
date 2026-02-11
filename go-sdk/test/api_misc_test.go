package test

import (
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestMiscAPI_All(t *testing.T) {
	t.Run("configurationTest", func(t *testing.T) {
		ctx := GetAuthContext()

		config, _, err := KestraTestApiClient().MiscAPI.Configuration(ctx).Execute()
		require.NoError(t, err)
		require.NotNil(t, config)
	})

	t.Run("licenseInfoTest", func(t *testing.T) {
		ctx := GetAuthContext()

		license, _, err := KestraTestApiClient().MiscAPI.LicenseInfo(ctx).Execute()
		require.NoError(t, err)
		require.NotNil(t, license)
	})

	t.Run("listActionsTest", func(t *testing.T) {
		ctx := GetAuthContext()

		actions, _, err := KestraTestApiClient().MiscAPI.ListActions(ctx, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotEmpty(t, actions)

		found := false
		for _, action := range actions {
			if action == kestra_api_client.ACTION_READ {
				found = true
				break
			}
		}
		require.True(t, found, "actions should include READ")
	})

	t.Run("setupConfigurationTest", func(t *testing.T) {
		ctx := GetAuthContext()

		setup, _, err := KestraTestApiClient().MiscAPI.SetupConfiguration(ctx).Execute()
		require.NoError(t, err)
		require.NotNil(t, setup)
	})
}
