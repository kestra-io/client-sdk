package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestQuotasAPI_All(t *testing.T) {
	t.Run("searchQuotaLimitsTest", func(t *testing.T) {
		ctx := context.Background()
		limits, err := KestraTestClient().Quotas().SearchQuotaLimits(ctx, MAIN_TENANT)
		require.NoError(t, err, "listing quota limits should succeed even with no quotas configured")
		for _, limit := range limits {
			require.NotEmpty(t, limit.GetId())
		}
	})

	t.Run("resetQuotaLimitTest", func(t *testing.T) {
		ctx := context.Background()
		err := KestraTestClient().Quotas().ResetQuotaLimit(ctx, MAIN_TENANT, "nonexistent_"+randomId(), nil, nil)
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr, "resetting an unknown quota limit id should reach the endpoint and be rejected")
		require.Equal(t, 404, apiErr.StatusCode, "the server answers 404 Quota limit not found")
		require.Contains(t, string(apiErr.Body), "Quota limit not found",
			"a 404 without this message means the route itself was not reached")
	})
}
