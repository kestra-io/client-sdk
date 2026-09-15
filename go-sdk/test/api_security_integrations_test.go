package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestSecurityIntegrationsAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()
	page, size := 1, 10

	t.Run("search", func(t *testing.T) {
		res, err := client.SecurityIntegrations().SearchSecurityIntegrations(ctx, MAIN_TENANT, &page, &size, nil, nil)
		if skipIfGated(t, err, "the FEATURE_SCIM feature") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, res)
		_, ok := res["results"]
		require.True(t, ok, "a security-integrations search page carries a results array")
	})

	t.Run("list", func(t *testing.T) {
		res, err := client.SecurityIntegrations().ListSecurityIntegrations(ctx, MAIN_TENANT)
		if skipIfGated(t, err, "the FEATURE_SCIM feature") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, res)
		_, ok := res["results"]
		require.True(t, ok, "the (deprecated) list envelope carries a results array")
	})

	t.Run("getUnknownIntegration", func(t *testing.T) {
		_, err := client.SecurityIntegrations().SecurityIntegration(ctx, "missing-"+randomId(), MAIN_TENANT)
		require.Error(t, err, "fetching a missing security integration is an error")
	})

	t.Run("createEnableDisableDeleteNeedInstanceOwnerAndScim", func(t *testing.T) {
		// The controller requires instance-owner access plus FEATURE_SCIM, and a
		// created SCIM integration provisions a real bearer token; exercising the
		// mutating paths for real needs the SCIM feature enabled.
		t.Skip("security-integration create/enable/disable/delete need FEATURE_SCIM; wrappers are compile-and-coverage only")
	})
}
