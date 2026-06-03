package test

import (
	"net/url"
	"testing"
	"time"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func parseFilters(filters []kestra_api_client.SearchFilter) map[string]string {
	params := url.Values{}
	kestra_api_client.AppendFilterParams(params, filters)
	result := make(map[string]string)
	for k, v := range params {
		if len(v) > 0 {
			result[k] = v[0]
		}
	}
	return result
}

func TestFilters_All(t *testing.T) {
	t.Run("should_parse_valid_singleEquals", func(t *testing.T) {
		namespace := "aNamespace1"

		parsedFilters := parseFilters([]kestra_api_client.SearchFilter{
			{
				Field: kestra_api_client.FilterNamespace, Operation: kestra_api_client.OpEquals, Value: namespace,
			},
		})
		require.Equal(t, map[string]string{"filters[namespace][EQUALS]": "aNamespace1"}, parsedFilters)
	})
	t.Run("should_parse_valid_multiple", func(t *testing.T) {
		namespace := "aNamespace1"
		assetsIdPrefix := "some_prefix"

		parsedFilters := parseFilters([]kestra_api_client.SearchFilter{
			{
				Field: kestra_api_client.FilterNamespace, Operation: kestra_api_client.OpEquals, Value: namespace,
			},
			{
				Field: kestra_api_client.FilterAssetId, Operation: kestra_api_client.OpPrefix, Value: assetsIdPrefix,
			},
		})
		require.Equal(t, map[string]string{
			"filters[namespace][EQUALS]": "aNamespace1",
			"filters[assetId][PREFIX]":   "some_prefix",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_IN", func(t *testing.T) {
		states := []string{"CREATED", "RUNNING"}

		parsedFilters := parseFilters([]kestra_api_client.SearchFilter{
			{
				Field: kestra_api_client.FilterState, Operation: kestra_api_client.OpIn, Value: states,
			},
		})
		require.Equal(t, map[string]string{
			"filters[state][IN]": "CREATED,RUNNING",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_timeRange_duration", func(t *testing.T) {
		timeRange := "PT15M"

		parsedFilters := parseFilters([]kestra_api_client.SearchFilter{
			{
				Field: kestra_api_client.FilterTimeRange, Operation: kestra_api_client.OpEquals, Value: timeRange,
			},
		})
		require.Equal(t, map[string]string{
			"filters[timeRange][EQUALS]": "PT15M",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_startAndEndDate", func(t *testing.T) {
		startDate := time.Date(2026, time.February, 2, 2, 2, 2, 0, time.UTC)
		endDate := time.Date(2026, time.December, 17, 17, 17, 17, 0, time.UTC)

		parsedFilters := parseFilters([]kestra_api_client.SearchFilter{
			{
				Field: kestra_api_client.FilterStartDate, Operation: kestra_api_client.OpGreaterThanOrEqualTo, Value: startDate,
			},
			{
				Field: kestra_api_client.FilterEndDate, Operation: kestra_api_client.OpLessThanOrEqualTo, Value: endDate,
			},
		})
		require.Equal(t, map[string]string{
			"filters[startDate][GREATER_THAN_OR_EQUAL_TO]": "2026-02-02T02:02:02Z",
			"filters[endDate][LESS_THAN_OR_EQUAL_TO]":      "2026-12-17T17:17:17Z",
		}, parsedFilters)
	})
	t.Run("should_parse_valid_query_field_to_q", func(t *testing.T) {
		parsedFilters := parseFilters([]kestra_api_client.SearchFilter{
			{
				Field: kestra_api_client.FilterQuery, Operation: kestra_api_client.OpEquals, Value: "hello",
			},
		})
		require.Equal(t, map[string]string{"filters[q][EQUALS]": "hello"}, parsedFilters)
	})

	t.Run("should_parse_valid_map_value_for_any_field", func(t *testing.T) {
		parsedFilters := parseFilters([]kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterFlowId,
				Operation: kestra_api_client.OpEquals,
				Value: map[string]string{
					"a": "b",
					"c": "d",
				},
			},
		})
		require.Equal(t, map[string]string{
			"filters[flowId][EQUALS][a]": "b",
			"filters[flowId][EQUALS][c]": "d",
		}, parsedFilters)
	})
}

func ptr[T any](v T) *T { return &v }
