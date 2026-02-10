package test

import (
	"testing"
	"time"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestQueryFilters_All(t *testing.T) {
	t.Run("should_parse_valid_singleEquals", func(t *testing.T) {
		namespace := "aNamespace1"

		parsedFilters, err := kestra_api_client.ParseQueryFilters([]kestra_api_client.QueryFilter{
			{
				Field: ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE), Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS), Value: namespace,
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{"filters[namespace][EQUALS]": "aNamespace1"}, parsedFilters)
	})
	t.Run("should_parse_valid_multiple", func(t *testing.T) {
		namespace := "aNamespace1"
		assetsIdPrefix := "some_prefix"

		parsedFilters, err := kestra_api_client.ParseQueryFilters([]kestra_api_client.QueryFilter{
			{
				Field: ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE), Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS), Value: namespace,
			},
			{
				Field: ptr(kestra_api_client.QUERYFILTERFIELD_ASSET_ID), Operation: ptr(kestra_api_client.QUERYFILTEROP_PREFIX), Value: assetsIdPrefix,
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{
			"filters[namespace][EQUALS]": "aNamespace1",
			"filters[assetId][PREFIX]":   "some_prefix",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_IN", func(t *testing.T) {
		states := []string{"CREATED", "RUNNING"}

		parsedFilters, err := kestra_api_client.ParseQueryFilters([]kestra_api_client.QueryFilter{
			{
				Field: ptr(kestra_api_client.QUERYFILTERFIELD_STATE), Operation: ptr(kestra_api_client.QUERYFILTEROP_IN), Value: states,
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{
			"filters[state][IN]": "CREATED,RUNNING",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_timeRange_duration", func(t *testing.T) {
		timeRange := "PT15M"

		parsedFilters, err := kestra_api_client.ParseQueryFilters([]kestra_api_client.QueryFilter{
			{
				Field: ptr(kestra_api_client.QUERYFILTERFIELD_TIME_RANGE), Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS), Value: timeRange,
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{
			"filters[timeRange][EQUALS]": "PT15M",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_startAndEndDate", func(t *testing.T) {
		startDate := time.Date(2026, time.February, 2, 2, 2, 2, 0, time.UTC)
		endDate := time.Date(2026, time.December, 17, 17, 17, 17, 0, time.UTC)

		parsedFilters, err := kestra_api_client.ParseQueryFilters([]kestra_api_client.QueryFilter{
			{
				Field: ptr(kestra_api_client.QUERYFILTERFIELD_START_DATE), Operation: ptr(kestra_api_client.QUERYFILTEROP_GREATER_THAN_OR_EQUAL_TO), Value: startDate,
			},
			{
				Field: ptr(kestra_api_client.QUERYFILTERFIELD_END_DATE), Operation: ptr(kestra_api_client.QUERYFILTEROP_LESS_THAN_OR_EQUAL_TO), Value: endDate,
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{
			"filters[startDate][GREATER_THAN_OR_EQUAL_TO]": "2026-02-02T02:02:02Z",
			"filters[endDate][LESS_THAN_OR_EQUAL_TO]":      "2026-12-17T17:17:17Z",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_query_field_to_q", func(t *testing.T) {
		parsedFilters, err := kestra_api_client.ParseQueryFilters([]kestra_api_client.QueryFilter{
			{
				Field: ptr(kestra_api_client.QUERYFILTERFIELD_QUERY), Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS), Value: "hello",
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{"filters[q][EQUALS]": "hello"}, parsedFilters)
	})

	t.Run("should_parse_valid_map_value_for_any_field", func(t *testing.T) {
		parsedFilters, err := kestra_api_client.ParseQueryFilters([]kestra_api_client.QueryFilter{
			{
				Field:     ptr(kestra_api_client.QUERYFILTERFIELD_ID),
				Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
				Value: map[string]string{
					"a": "b",
					"c": "d",
				},
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{
			"filters[id][EQUALS][a]": "b",
			"filters[id][EQUALS][c]": "d",
		}, parsedFilters)
	})
}

func ptr[T any](v T) *T { return &v }
