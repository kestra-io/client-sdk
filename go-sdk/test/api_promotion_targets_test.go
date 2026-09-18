package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestPromotionTargetsAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()
	page, size := 1, 10

	t.Run("list", func(t *testing.T) {
		res, err := client.PromotionTargets().ListPromotionTargets(ctx, MAIN_TENANT, &page, &size, nil, nil)
		if skipIfGated(t, err, "the FEATURE_PROMOTE feature") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, res)
		_, ok := res["results"]
		require.True(t, ok, "a promotion-targets page carries a results array")
	})

	t.Run("getUnknownTarget", func(t *testing.T) {
		_, err := client.PromotionTargets().PromotionTarget(ctx, "missing-"+randomId(), MAIN_TENANT)
		require.Error(t, err, "fetching a missing promotion target is an error")
	})

	t.Run("createUpdateDeleteNeedARemoteTarget", func(t *testing.T) {
		// Create/update/test open a connection to a remote Kestra instance
		// (url + targetTenant + token) and the controller is gated by
		// FEATURE_PROMOTE; there is no second instance to point at in CI.
		t.Skip("promotion-target create/update/delete/test need a reachable remote instance and FEATURE_PROMOTE; wrappers are compile-and-coverage only")
	})
}
