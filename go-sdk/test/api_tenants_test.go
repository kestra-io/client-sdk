package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestTenantsAPI_All(t *testing.T) {
	t.Run("tenantLifecycleTest", func(t *testing.T) {
		ctx := context.Background()
		id := "sdktest" + randomId()

		tenant := *kestra_api_client.NewTenant(id, "SDK test tenant", false)
		tenant.Concurrency = &kestra_api_client.Concurrency{
			Limit:    5,
			Behavior: kestra_api_client.CONCURRENCYBEHAVIOR_QUEUE,
		}
		tenant.Quotas = []kestra_api_client.Quota{
			{
				Duration: "PT1H",
				Limit:    100,
				Behavior: kestra_api_client.QUOTABEHAVIOR_FAIL,
			},
		}

		created, err := KestraTestClient().Tenants().CreateTenant(ctx, tenant)
		require.NoError(t, err)
		t.Cleanup(func() {
			KestraTestClient().Tenants().DeleteTenant(context.Background(), id)
		})
		require.NotNil(t, created)
		require.Equal(t, id, created.Id)

		fetched, err := KestraTestClient().Tenants().Tenant(ctx, id)
		require.NoError(t, err)
		require.NotNil(t, fetched)
		require.NotNil(t, fetched.Concurrency, "the concurrency config should round-trip")
		assert.Equal(t, int32(5), fetched.Concurrency.Limit)
		assert.Equal(t, kestra_api_client.CONCURRENCYBEHAVIOR_QUEUE, fetched.Concurrency.Behavior)
		require.Len(t, fetched.Quotas, 1, "the quota config should round-trip")
		assert.Equal(t, "PT1H", fetched.Quotas[0].Duration)
		assert.Equal(t, int64(100), fetched.Quotas[0].Limit)
		assert.Equal(t, kestra_api_client.QUOTABEHAVIOR_FAIL, fetched.Quotas[0].Behavior)

		fetched.Name = "SDK test tenant renamed"
		fetched.Concurrency.Limit = 7
		updated, err := KestraTestClient().Tenants().UpdateTenant(ctx, id, *fetched)
		require.NoError(t, err)
		require.NotNil(t, updated)
		assert.Equal(t, "SDK test tenant renamed", updated.Name)
		require.NotNil(t, updated.Concurrency)
		assert.Equal(t, int32(7), updated.Concurrency.Limit)

		page, size := 1, MAX_PAGE_SIZE
		results, err := KestraTestClient().Tenants().SearchTenants(ctx, &page, &size, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, results)
		found := false
		for _, item := range results.Results {
			if item.Id == id {
				found = true
				break
			}
		}
		assert.True(t, found, "the created tenant should be listed by the search")

		require.NoError(t, KestraTestClient().Tenants().DeleteTenant(ctx, id))

		_, err = KestraTestClient().Tenants().Tenant(ctx, id)
		assert.Error(t, err, "the tenant should be gone once deleted")
	})
}
