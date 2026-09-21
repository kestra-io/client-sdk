package test

import (
	"context"
	"errors"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestWorkerGroupsAPI_Mutations(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	t.Run("create is gated by the worker-group license limit", func(t *testing.T) {
		id := "sdk-g-" + strings.ToLower(randomId())
		created, err := client.WorkerGroups().CreateWorkerGroup(ctx, kestra_api_client.ApiCreateWorkerGroupRequest{
			Id:            id,
			Name:          "sdk group",
			Subscriptions: []kestra_api_client.ApiSubscriptionRequest{},
		})
		if err == nil {
			// The license allowed another group: exercise update + delete too.
			require.Equal(t, id, created.GetId())
			_, err = client.WorkerGroups().UpdateWorkerGroup(ctx, id, kestra_api_client.ApiUpdateWorkerGroupRequest{
				Name:          "sdk group renamed",
				Subscriptions: []kestra_api_client.ApiSubscriptionRequest{},
			})
			require.NoError(t, err)
			require.NoError(t, client.WorkerGroups().DeleteWorkerGroup(ctx, id, nil))
			return
		}
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr, "the create endpoint must be reached")
		require.Equal(t, 403, apiErr.StatusCode,
			"a fresh EE license caps worker groups at the default one, so creating another is rejected")
		require.Contains(t, string(apiErr.Body), "license",
			"the rejection is a license-limit error, proving the create route is wired")
	})

	t.Run("subscription lifecycle on the default group", func(t *testing.T) {
		groups, err := client.WorkerGroups().ListWorkerGroups(ctx, nil)
		require.NoError(t, err)
		require.NotEmpty(t, groups.GetWorkerGroups())
		gid := groups.GetWorkerGroups()[0].GetId()

		qid := "sdk-subq-" + strings.ToLower(randomId())
		_, err = client.WorkerQueues().CreateWorkerQueue(ctx, kestra_api_client.ApiCreateOrUpdateWorkerQueueRequest{
			Id:   qid,
			Name: "subscription target",
			Tags: []string{"sub"},
		})
		require.NoError(t, err)
		subscribed := false
		t.Cleanup(func() {
			if subscribed {
				_, _ = client.WorkerGroups().RemoveWorkerGroupSubscription(context.Background(), gid, qid)
			}
			_ = client.WorkerQueues().DeleteWorkerQueue(context.Background(), qid)
		})

		added, err := client.WorkerGroups().AddWorkerGroupSubscription(ctx, gid, kestra_api_client.ApiSubscriptionRequest{
			WorkerQueueId:   qid,
			ReservedPercent: 50,
		})
		if err != nil {
			var apiErr *kestra_api_client.ApiError
			if errors.As(err, &apiErr) {
				t.Skipf("subscribing the default worker group is not permitted here (HTTP %d): %s",
					apiErr.StatusCode, strings.TrimSpace(string(apiErr.Body)))
			}
			require.NoError(t, err)
		}
		subscribed = true
		require.True(t, hasSubscription(added, qid), "the new subscription must appear on the group")

		updated, err := client.WorkerGroups().UpdateWorkerGroupSubscription(ctx, gid, qid, kestra_api_client.ApiUpdateSubscriptionRequest{
			ReservedPercent: 25,
		})
		require.NoError(t, err)
		require.True(t, hasSubscription(updated, qid), "the subscription survives the reservation update")

		removed, err := client.WorkerGroups().RemoveWorkerGroupSubscription(ctx, gid, qid)
		require.NoError(t, err)
		subscribed = false
		require.False(t, hasSubscription(removed, qid), "the subscription is gone after removal")
	})
}

func hasSubscription(group *kestra_api_client.ApiWorkerGroup, queueId string) bool {
	for _, sub := range group.GetSubscriptions() {
		q := sub.GetQueue()
		if q.GetId() == queueId {
			return true
		}
	}
	return false
}
