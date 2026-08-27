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

		filters := []kestra_api_client.SearchFilter{
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

		filters := []kestra_api_client.SearchFilter{
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

		filters := []kestra_api_client.SearchFilter{
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

	// Kestra 2.0 stopped letting POST upsert an asset -- it now conflicts on an
	// existing id, so updates have to go through the new PUT endpoint.
	t.Run("updateAsset_basic", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)

		_, err = KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.Error(t, err, "creating the same asset id twice should conflict rather than upsert")

		updatedYaml := fmt.Sprintf(`
id: %s
name: Test Asset %s
type: TABLE
description: updated by the sdk
`, id, id)
		updated, err := KestraTestClient().Assets().UpdateAsset(ctx, created.GetId(), MAIN_TENANT, updatedYaml)
		require.NoError(t, err)
		require.Equal(t, "updated by the sdk", updated.GetDescription())

		read, err := KestraTestClient().Assets().Asset(ctx, created.GetId(), MAIN_TENANT, nil)
		require.NoError(t, err)
		require.Equal(t, "updated by the sdk", read.GetDescription())
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

	t.Run("lockAsset_manual", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)

		lock, err := KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{Ttl: kestra_api_client.PtrString("PT1H")})
		require.NoError(t, err)
		require.NotNil(t, lock)
		require.Equal(t, "USER", lock.GetOwnerType())
		require.NotNil(t, lock.LockedUntil)

		err = KestraTestClient().Assets().UnlockAsset(ctx, created.GetId(), MAIN_TENANT, nil)
		require.NoError(t, err)
	})

	t.Run("lockAsset_heldByAnotherOwnerIsRejected", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		flowId := randomId()
		ns := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)
		createSimpleFlow(ctx, flowId, ns)
		execution := createExecution(t, ctx, flowId, ns)

		lock, err := KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{
				Ttl:         kestra_api_client.PtrString("PT1H"),
				ExecutionId: kestra_api_client.PtrString(execution.GetId()),
			})
		require.NoError(t, err)
		require.Equal(t, "EXECUTION", lock.GetOwnerType())

		// held by an EXECUTION owner: a manual USER lock attempt is a different owner and must be rejected
		_, err = KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{Ttl: kestra_api_client.PtrString("PT1H")})
		require.Error(t, err)
	})

	t.Run("lockAsset_sameOwnerReacquireExtends", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)

		first, err := KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{Ttl: kestra_api_client.PtrString("PT1M")})
		require.NoError(t, err)

		second, err := KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{Ttl: kestra_api_client.PtrString("PT1H")})
		require.NoError(t, err)

		require.Equal(t, "USER", second.GetOwnerType())
		require.True(t, second.GetLockedUntil().After(first.GetLockedUntil()))

		err = KestraTestClient().Assets().UnlockAsset(ctx, created.GetId(), MAIN_TENANT, nil)
		require.NoError(t, err)
	})

	t.Run("unlockAsset_thenRelock", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)
		_, err = KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{Ttl: kestra_api_client.PtrString("PT1H")})
		require.NoError(t, err)

		err = KestraTestClient().Assets().UnlockAsset(ctx, created.GetId(), MAIN_TENANT, nil)
		require.NoError(t, err)

		relock, err := KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{Ttl: kestra_api_client.PtrString("PT1H")})
		require.NoError(t, err)
		require.NotNil(t, relock)

		err = KestraTestClient().Assets().UnlockAsset(ctx, created.GetId(), MAIN_TENANT, nil)
		require.NoError(t, err)
	})

	t.Run("unlockAsset_executionOwnedLock_releasedByMatchingExecutionId", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		flowId := randomId()
		ns := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)
		createSimpleFlow(ctx, flowId, ns)
		execution := createExecution(t, ctx, flowId, ns)

		lock, err := KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{
				Ttl:           kestra_api_client.PtrString("PT1H"),
				ExecutionId:   kestra_api_client.PtrString(execution.GetId()),
				FlowId:        kestra_api_client.PtrString(flowId),
				FlowNamespace: kestra_api_client.PtrString(ns),
				TaskRunId:     kestra_api_client.PtrString(randomId()),
			})
		require.NoError(t, err)
		require.Equal(t, "EXECUTION", lock.GetOwnerType())

		// matching executionId is the owner-checked release path: the execution releases its own lock
		err = KestraTestClient().Assets().UnlockAsset(ctx, created.GetId(), MAIN_TENANT, kestra_api_client.PtrString(execution.GetId()))
		require.NoError(t, err)

		relock, err := KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{Ttl: kestra_api_client.PtrString("PT1H")})
		require.NoError(t, err)
		require.Equal(t, "USER", relock.GetOwnerType())

		err = KestraTestClient().Assets().UnlockAsset(ctx, created.GetId(), MAIN_TENANT, nil)
		require.NoError(t, err)
	})

	t.Run("unlockAsset_executionOwnedLock_mismatchedExecutionIdIsNoop", func(t *testing.T) {
		ctx := context.Background()
		id := randomId()
		flowId := randomId()
		ns := randomId()

		created, err := KestraTestClient().Assets().CreateAsset(ctx, MAIN_TENANT, assetYaml(id))
		require.NoError(t, err)
		createSimpleFlow(ctx, flowId, ns)
		owner := createExecution(t, ctx, flowId, ns)
		other := createExecution(t, ctx, flowId, ns)

		_, err = KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{
				Ttl:         kestra_api_client.PtrString("PT1H"),
				ExecutionId: kestra_api_client.PtrString(owner.GetId()),
			})
		require.NoError(t, err)

		// a different execution's unlock is owner-checked against the lock holder: no-op, does not error
		err = KestraTestClient().Assets().UnlockAsset(ctx, created.GetId(), MAIN_TENANT, kestra_api_client.PtrString(other.GetId()))
		require.NoError(t, err)

		// lock is still held by the original owner: a manual USER lock attempt is rejected
		_, err = KestraTestClient().Assets().LockAsset(ctx, created.GetId(), MAIN_TENANT,
			kestra_api_client.AssetsControllerAssetLockRequest{Ttl: kestra_api_client.PtrString("PT1H")})
		require.Error(t, err)

		err = KestraTestClient().Assets().UnlockAsset(ctx, created.GetId(), MAIN_TENANT, kestra_api_client.PtrString(owner.GetId()))
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

		filters := []kestra_api_client.SearchFilter{
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

		filters := []kestra_api_client.SearchFilter{
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

		filters := []kestra_api_client.SearchFilter{
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
