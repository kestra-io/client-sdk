package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestMetricsAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()
	ns := "company.team"
	flow := "does-not-exist-" + randomId()

	t.Run("flowMetricNames", func(t *testing.T) {
		names, err := client.Metrics().FlowMetricNames(ctx, ns, flow, MAIN_TENANT)
		if skipIfGated(t, err, "the metrics API") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, names, "a flow with no metrics yields an empty array, not null")
	})

	t.Run("tasksWithMetrics", func(t *testing.T) {
		tasks, err := client.Metrics().TasksWithMetrics(ctx, ns, flow, MAIN_TENANT)
		if skipIfGated(t, err, "the metrics API") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, tasks, "a flow with no metrics yields an empty array, not null")
	})

	t.Run("taskMetricNames", func(t *testing.T) {
		names, err := client.Metrics().TaskMetricNames(ctx, ns, flow, "some-task", MAIN_TENANT)
		if skipIfGated(t, err, "the metrics API") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, names)
	})

	t.Run("aggregateFlowMetric", func(t *testing.T) {
		agg := "sum"
		res, err := client.Metrics().AggregateFlowMetric(ctx, ns, flow, "duration", MAIN_TENANT, nil, nil, &agg)
		if skipIfGated(t, err, "the metrics API") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, res, "the aggregation endpoint returns an object even with no data")
	})

	t.Run("aggregateTaskMetric", func(t *testing.T) {
		agg := "sum"
		res, err := client.Metrics().AggregateTaskMetric(ctx, ns, flow, "some-task", "duration", MAIN_TENANT, nil, nil, &agg)
		if skipIfGated(t, err, "the metrics API") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, res)
	})

	t.Run("executionMetrics", func(t *testing.T) {
		page, size := 1, 10
		_, err := client.Metrics().ExecutionMetrics(ctx, "missing-"+randomId(), MAIN_TENANT, &page, &size, nil, nil, nil)
		// An unknown execution id yields an empty page or a 404 depending on image.
		if err != nil {
			_ = skipIfGated(t, err, "metrics for a specific execution")
			require.NoError(t, err)
		}
	})
}
