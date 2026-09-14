package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestWorkerQueuesAPI_Read(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	list, err := client.WorkerQueues().ListWorkerQueues(ctx)
	require.NoError(t, err, "listing worker queues should succeed as instance owner")

	queues := list.GetWorkerQueues()
	if len(queues) == 0 {
		t.Skip("no worker queue configured on this instance (FEATURE_WORKER_QUEUE off); nothing to read")
	}

	first := queues[0]
	require.NotEmpty(t, first.GetId(), "each worker queue has an id")

	t.Run("get worker queue by id", func(t *testing.T) {
		fetched, err := client.WorkerQueues().WorkerQueue(ctx, first.GetId())
		require.NoError(t, err)
		require.Equal(t, first.GetId(), fetched.GetId(), "fetching by id returns the same queue")
	})

	t.Run("list subscribers", func(t *testing.T) {
		subs, err := client.WorkerQueues().WorkerQueueSubscribers(ctx, first.GetId())
		require.NoError(t, err, "the subscribers endpoint is reachable for an existing queue")
		for _, g := range subs.GetGroups() {
			require.NotEmpty(t, g.GetId(), "each subscribing group has an id")
		}
	})
}
