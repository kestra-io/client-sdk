package test

import (
	"context"
	"fmt"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func assetYaml(id string) string {
	return fmt.Sprintf(`
id: %s
name: Test Asset %s
type: TABLE
`, id, id)
}

func TestAssetsAPI_All(t *testing.T) {

	t.Run("searchAssets_basic", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Assets().SearchAssets(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
	})

	t.Run("searchAssets_withPagination", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Assets().SearchAssets(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(2), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
		require.LessOrEqual(t, len(result.Results), 2)
	})

	t.Run("searchAssets_noResults", func(t *testing.T) {
		ctx := context.Background()

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     "nonexistent_ns_" + randomId(),
			},
		}
		result, err := KestraTestClient().Assets().SearchAssets(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, filters)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Empty(t, result.Results)
	})

	t.Run("searchAssetLineageEvents_basic", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Assets().SearchAssetLineageEvents(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
	})

	t.Run("searchAssetLineageEvents_withFilters", func(t *testing.T) {
		ctx := context.Background()

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     "nonexistent_ns_" + randomId(),
			},
		}
		result, err := KestraTestClient().Assets().SearchAssetLineageEvents(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, filters)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Empty(t, result.Results)
	})

	t.Run("searchAssetUsages_basic", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Assets().SearchAssetUsages(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
	})

	t.Run("searchAssetUsages_withFilters", func(t *testing.T) {
		ctx := context.Background()

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     "nonexistent_ns_" + randomId(),
			},
		}
		result, err := KestraTestClient().Assets().SearchAssetUsages(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, filters)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Empty(t, result.Results)
	})

	t.Run("createAsset_basic", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		result, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotEmpty(t, result.GetId())
	})

	t.Run("asset_getById", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)

		result, err := KestraTestClient().Assets().Asset(ctx, created.GetId(), MAIN_TENANT, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Equal(t, created.GetId(), result.GetId())
	})

	t.Run("deleteAsset_basic", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)

		err = KestraTestClient().Assets().DeleteAsset(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
	})

	t.Run("assetDependencies_basic", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)

		result, err := KestraTestClient().Assets().AssetDependencies(ctx, created.GetId(), MAIN_TENANT, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("deleteAssetsByIds_basic", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)

		result, err := KestraTestClient().Assets().DeleteAssetsByIds(ctx, MAIN_TENANT, []string{created.GetId()})
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("deleteAssetsByQuery_basic", func(t *testing.T) {
		ctx := context.Background()

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     "nonexistent",
			},
		}
		result, err := KestraTestClient().Assets().DeleteAssetsByQuery(ctx, MAIN_TENANT, filters, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("deleteAssetLineageEventsByQuery_basic", func(t *testing.T) {
		ctx := context.Background()

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     "nonexistent",
			},
		}
		result, err := KestraTestClient().Assets().DeleteAssetLineageEventsByQuery(ctx, MAIN_TENANT, filters)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("deleteAssetUsagesByQuery_basic", func(t *testing.T) {
		ctx := context.Background()

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     "nonexistent",
			},
		}
		result, err := KestraTestClient().Assets().DeleteAssetUsagesByQuery(ctx, MAIN_TENANT, filters)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("searchAssets_withSort", func(t *testing.T) {
		ctx := context.Background()
		id1 := "aaa" + randomId()
		id2 := "zzz" + randomId()

		_, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id2))
		require.NoError(t, err)
		_, err = KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id1))
		require.NoError(t, err)

		result, err := KestraTestClient().Assets().SearchAssets(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(100), []string{"id:asc"}, nil)
		require.NoError(t, err)
		require.GreaterOrEqual(t, len(result.Results), 2)

		ids := make([]string, 0, len(result.Results))
		for _, a := range result.Results {
			ids = append(ids, a.GetId())
		}
		require.Contains(t, ids, id1)
		require.Contains(t, ids, id2)
	})
}
