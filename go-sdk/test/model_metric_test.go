package test

import (
	"encoding/json"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestMetric_UnmarshalNumericValue(t *testing.T) {
	raw := []byte(`{"name":"worker.job.pending","type":"WORKER","value":3}`)

	var metric kestra_api_client.Metric
	err := json.Unmarshal(raw, &metric)
	require.NoError(t, err)

	require.Equal(t, "worker.job.pending", metric.GetName())
	require.Equal(t, "WORKER", metric.GetType())
	require.True(t, metric.HasValue())
	require.Equal(t, float32(3), metric.GetValue())
}

func TestMetric_RejectsObjectValue(t *testing.T) {
	raw := []byte(`{"name":"worker.job.pending","type":"WORKER","value":{"pending":3}}`)

	var metric kestra_api_client.Metric
	err := json.Unmarshal(raw, &metric)
	require.Error(t, err)
}
