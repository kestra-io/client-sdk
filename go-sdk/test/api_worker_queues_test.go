package test

import (
	"context"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestWorkerQueuesAPI_CRUD(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	id := "sdk-wq-" + strings.ToLower(randomId())
	created, err := client.WorkerQueues().CreateWorkerQueue(ctx, kestra_api_client.ApiCreateOrUpdateWorkerQueueRequest{
		Id:          id,
		Name:        "sdk queue",
		Tags:        []string{"sdk", "test"},
		Description: "created by the Go SDK test suite",
	})
	require.NoError(t, err, "creating a worker queue requires the WORKER_QUEUE feature (enabled on develop)")
	require.Equal(t, id, created.GetId())
	require.ElementsMatch(t, []string{"sdk", "test"}, created.GetTags(), "the tags round-trip")

	deleted := false
	t.Cleanup(func() {
		if !deleted {
			_ = client.WorkerQueues().DeleteWorkerQueue(context.Background(), id)
		}
	})

	t.Run("list contains the new queue", func(t *testing.T) {
		list, err := client.WorkerQueues().ListWorkerQueues(ctx)
		require.NoError(t, err)
		found := false
		for _, q := range list.GetWorkerQueues() {
			if q.GetId() == id {
				found = true
			}
		}
		require.True(t, found, "the created queue must appear in the list")
	})

	t.Run("get by id", func(t *testing.T) {
		fetched, err := client.WorkerQueues().WorkerQueue(ctx, id)
		require.NoError(t, err)
		require.Equal(t, id, fetched.GetId())
		require.ElementsMatch(t, []string{"sdk", "test"}, fetched.GetTags())
	})

	t.Run("update", func(t *testing.T) {
		updated, err := client.WorkerQueues().UpdateWorkerQueue(ctx, id, kestra_api_client.ApiCreateOrUpdateWorkerQueueRequest{
			Id:   id,
			Name: "sdk queue renamed",
			Tags: []string{"sdk", "renamed"},
		})
		require.NoError(t, err)
		require.Equal(t, id, updated.GetId(), "the id is immutable across the update")
		require.ElementsMatch(t, []string{"sdk", "renamed"}, updated.GetTags(), "the tag change round-trips")
	})

	t.Run("subscribers is reachable and empty", func(t *testing.T) {
		subs, err := client.WorkerQueues().WorkerQueueSubscribers(ctx, id)
		require.NoError(t, err)
		require.Empty(t, subs.GetGroups(), "a brand-new queue has no subscribing worker groups")
	})

	t.Run("delete", func(t *testing.T) {
		require.NoError(t, client.WorkerQueues().DeleteWorkerQueue(ctx, id))
		deleted = true
		_, err := client.WorkerQueues().WorkerQueue(ctx, id)
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr, "the queue must be gone after deletion")
		require.Equal(t, 404, apiErr.StatusCode)
	})
}
