package test

import (
	"context"
	"testing"
	"time"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func createExecutionWithLogs(t *testing.T, ctx context.Context) (string, string, string) {
	namespace := randomId()
	flowId := randomId()
	createSimpleFlow(ctx, flowId, namespace)

	exec := createExecution(t, ctx, flowId, namespace)

	return exec.Id, namespace, flowId
}

func TestLogsAPI_All(t *testing.T) {

	t.Run("listLogsFromExecution_basic", func(t *testing.T) {
		ctx := context.Background()
		executionId, _, _ := createExecutionWithLogs(t, ctx)

		logs, err := KestraTestClient().Logs().ListLogsFromExecution(ctx, executionId, MAIN_TENANT, nil, nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, logs)
		require.NotEmpty(t, logs)
		require.Equal(t, executionId, logs[0].GetExecutionId())
	})

	t.Run("listLogsFromExecution_withMinLevel", func(t *testing.T) {
		ctx := context.Background()
		executionId, _, _ := createExecutionWithLogs(t, ctx)

		logs, err := KestraTestClient().Logs().ListLogsFromExecution(ctx, executionId, MAIN_TENANT, kestra_api_client.PtrString("INFO"), nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, logs)
	})

	t.Run("listLogsFromExecution_withTaskId", func(t *testing.T) {
		ctx := context.Background()
		executionId, _, _ := createExecutionWithLogs(t, ctx)

		require.Eventually(t, func() bool {
			logs, err := KestraTestClient().Logs().ListLogsFromExecution(ctx, executionId, MAIN_TENANT, nil, nil, kestra_api_client.PtrString("hello"), nil)
			if err != nil {
				return false
			}
			if len(logs) == 0 {
				return false
			}
			for _, log := range logs {
				if log.GetTaskId() != "hello" {
					return false
				}
			}
			return true
		}, 10*time.Second, 500*time.Millisecond, "expected logs filtered by taskId=hello")
	})

	t.Run("followLogsFromExecution_basic", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
		defer cancel()
		createFlow(ctx, flowId, namespace, SIMPLE_BUT_LONG_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)

		// this endpoint is returning SSE
		// logs is a channel that receives log entries and then gets closed when the execution is completed
		logs, err := KestraTestClient().Logs().FollowLogsFromExecution(ctx, exec.Id, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.NotNil(t, logs)

		// the server opens the stream with a synthetic empty entry (id "start"),
		// so only collect entries that carry an execution id
		var receivedLogs []*kestra_api_client.LogEntry
	loop:
		for {
			select {
			case log, ok := <-logs:
				if !ok {
					// received channel close
					break loop
				}
				if log.GetExecutionId() != "" {
					receivedLogs = append(receivedLogs, log)
				}
			case <-ctx.Done():
				break loop
			}
		}
		require.NotEmpty(t, receivedLogs, "expected to receive at least one log entry")
		for _, log := range receivedLogs {
			require.Equal(t, exec.Id, log.GetExecutionId())
		}
	})

	t.Run("followLogsFromExecution_shouldAllowGettingCancelledByUser", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx, cancel := context.WithCancel(context.Background())
		defer cancel()

		createFlow(ctx, flowId, namespace, LONG_RUNNING_FLOW)
		exec := createExecutionAsync(t, ctx, flowId, namespace)

		logs, err := KestraTestClient().Logs().FollowLogsFromExecution(ctx, exec.Id, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.NotNil(t, logs)

		// when a user explicitly cancels
		cancel()

		// then
		require.Eventually(t, func() bool {
			return checkChannelIsClosed(logs)
		}, 5*time.Second, 100*time.Millisecond,
			"channel should be closed soon after cancelling")
	})

	t.Run("downloadLogsFromExecution_basic", func(t *testing.T) {
		ctx := context.Background()
		executionId, _, _ := createExecutionWithLogs(t, ctx)

		file, err := KestraTestClient().Logs().DownloadLogsFromExecution(ctx, executionId, MAIN_TENANT, nil, nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, file)

		stat, err := file.Stat()
		require.NoError(t, err)
		require.Greater(t, stat.Size(), int64(0))
	})

	t.Run("searchLogs_basic", func(t *testing.T) {
		ctx := context.Background()
		createExecutionWithLogs(t, ctx)

		result, err := KestraTestClient().Logs().SearchLogs(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
		require.NotEmpty(t, result.Results)
	})

	t.Run("searchLogs_withPagination", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Logs().SearchLogs(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(5), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotNil(t, result.Results)
		require.LessOrEqual(t, len(result.Results), 5)
	})

	t.Run("searchLogs_withNamespaceFilter", func(t *testing.T) {
		ctx := context.Background()
		_, namespace, _ := createExecutionWithLogs(t, ctx)

		require.Eventually(t, func() bool {
			filters := []kestra_api_client.SearchFilter{
				{
					Field:     kestra_api_client.FilterNamespace,
					Operation: kestra_api_client.OpEquals,
					Value:     namespace,
				},
			}
			result, err := KestraTestClient().Logs().SearchLogs(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(25), nil, filters)
			if err != nil {
				return false
			}
			return len(result.Results) > 0
		}, 10*time.Second, 500*time.Millisecond, "expected logs with namespace filter")
	})

	t.Run("searchLogs_withFlowIdAndNamespaceFilter", func(t *testing.T) {
		ctx := context.Background()
		_, namespace, flowId := createExecutionWithLogs(t, ctx)

		require.Eventually(t, func() bool {
			filters := []kestra_api_client.SearchFilter{
				{
					Field:     kestra_api_client.FilterNamespace,
					Operation: kestra_api_client.OpEquals,
					Value:     namespace,
				},
				{
					Field:     kestra_api_client.FilterFlowId,
					Operation: kestra_api_client.OpEquals,
					Value:     flowId,
				},
			}
			result, err := KestraTestClient().Logs().SearchLogs(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(25), nil, filters)
			if err != nil {
				return false
			}
			return len(result.Results) > 0
		}, 10*time.Second, 500*time.Millisecond, "expected logs with flowId and namespace filters")
	})

	t.Run("searchLogs_withMinLevelFilter", func(t *testing.T) {
		ctx := context.Background()
		_, namespace, _ := createExecutionWithLogs(t, ctx)

		require.Eventually(t, func() bool {
			filters := []kestra_api_client.SearchFilter{
				{
					Field:     kestra_api_client.FilterMinLevel,
					Operation: kestra_api_client.OpGreaterThanOrEqualTo,
					Value:     "INFO",
				},
				{
					Field:     kestra_api_client.FilterNamespace,
					Operation: kestra_api_client.OpEquals,
					Value:     namespace,
				},
			}
			result, err := KestraTestClient().Logs().SearchLogs(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(25), nil, filters)
			if err != nil {
				return false
			}
			return len(result.Results) > 0
		}, 10*time.Second, 500*time.Millisecond)
	})

	t.Run("searchLogs_noResults", func(t *testing.T) {
		ctx := context.Background()

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     "nonexistent_ns_" + randomId(),
			},
		}
		result, err := KestraTestClient().Logs().SearchLogs(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, filters)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Empty(t, result.Results)
	})

	t.Run("deleteLogsFromExecution_basic", func(t *testing.T) {
		ctx := context.Background()
		executionId, _, _ := createExecutionWithLogs(t, ctx)

		err := KestraTestClient().Logs().DeleteLogsFromExecution(ctx, executionId, MAIN_TENANT, nil, nil, nil, nil)
		require.NoError(t, err)
	})

	t.Run("deleteLogsFromExecution_withMinLevel", func(t *testing.T) {
		ctx := context.Background()
		executionId, _, _ := createExecutionWithLogs(t, ctx)

		err := KestraTestClient().Logs().DeleteLogsFromExecution(ctx, executionId, MAIN_TENANT, kestra_api_client.PtrString("TRACE"), nil, nil, nil)
		require.NoError(t, err)
	})

	t.Run("deleteLogsFromFlow_basic", func(t *testing.T) {
		t.Skip("Server requires triggerId parameter which is not available for test flows")
	})
}
