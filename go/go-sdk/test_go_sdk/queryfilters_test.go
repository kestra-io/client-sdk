package main

import (
	"testing"
	"time"

	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
	"github.com/stretchr/testify/require"
)

func TestQueryFilters_All(t *testing.T) {
	t.Run("should_parse_valid_singleEquals", func(t *testing.T) {
		namespace := "aNamespace1"

		parsedFilters, err := openapiclient.ParseQueryFilters([]openapiclient.QueryFilter{
			{
				Field: ptr(openapiclient.QUERYFILTERFIELD_NAMESPACE), Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS), Value: namespace,
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{"filters[namespace][EQUALS]": "aNamespace1"}, parsedFilters)
	})
	t.Run("should_parse_valid_multiple", func(t *testing.T) {
		namespace := "aNamespace1"
		assetsIdPrefix := "some_prefix"

		parsedFilters, err := openapiclient.ParseQueryFilters([]openapiclient.QueryFilter{
			{
				Field: ptr(openapiclient.QUERYFILTERFIELD_NAMESPACE), Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS), Value: namespace,
			},
			{
				Field: ptr(openapiclient.QUERYFILTERFIELD_ASSET_ID), Operation: ptr(openapiclient.QUERYFILTEROP_PREFIX), Value: assetsIdPrefix,
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

		parsedFilters, err := openapiclient.ParseQueryFilters([]openapiclient.QueryFilter{
			{
				Field: ptr(openapiclient.QUERYFILTERFIELD_STATE), Operation: ptr(openapiclient.QUERYFILTEROP_IN), Value: states,
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{
			"filters[state][IN]": "CREATED,RUNNING",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_timeRange_duration", func(t *testing.T) {
		timeRange := "PT15M"

		parsedFilters, err := openapiclient.ParseQueryFilters([]openapiclient.QueryFilter{
			{
				Field: ptr(openapiclient.QUERYFILTERFIELD_TIME_RANGE), Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS), Value: timeRange,
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

		parsedFilters, err := openapiclient.ParseQueryFilters([]openapiclient.QueryFilter{
			{
				Field: ptr(openapiclient.QUERYFILTERFIELD_START_DATE), Operation: ptr(openapiclient.QUERYFILTEROP_GREATER_THAN_OR_EQUAL_TO), Value: startDate,
			},
			{
				Field: ptr(openapiclient.QUERYFILTERFIELD_END_DATE), Operation: ptr(openapiclient.QUERYFILTEROP_LESS_THAN_OR_EQUAL_TO), Value: endDate,
			},
		})
		require.NoError(t, err)
		require.Equal(t, map[string]string{
			"filters[startDate][GREATER_THAN_OR_EQUAL_TO]": "2026-02-02T02:02:02Z",
			"filters[endDate][LESS_THAN_OR_EQUAL_TO]":      "2026-12-17T17:17:17Z",
		}, parsedFilters)
	})
}
func ptr[T any](v T) *T { return &v }
