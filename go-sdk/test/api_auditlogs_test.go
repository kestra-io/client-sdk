package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestAuditLogsAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()
	page, size := 1, 10

	t.Run("search", func(t *testing.T) {
		res, err := client.AuditLogs().SearchAuditLogs(ctx, MAIN_TENANT, &page, &size, nil, nil)
		if skipIfGated(t, err, "the AUDITLOG feature") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, res)
		_, ok := res["results"]
		require.True(t, ok, "an audit-log page carries a results array")
	})

	t.Run("searchAllTenants", func(t *testing.T) {
		res, err := client.AuditLogs().SearchAllAuditLogs(ctx, &page, &size, nil, nil)
		if skipIfGated(t, err, "the AUDITLOG feature") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, res)
		_, ok := res["results"]
		require.True(t, ok, "the cross-tenant audit-log page carries a results array")
	})

	t.Run("exportCsv", func(t *testing.T) {
		csv, err := client.AuditLogs().ExportAuditLogs(ctx, MAIN_TENANT, nil)
		if skipIfGated(t, err, "the AUDITLOG feature") != nil {
			require.NoError(t, err)
		}
		// The CSV export always emits at least the header row when the feature is on.
		require.NotEmpty(t, csv, "the audit-log CSV export is non-empty (header row)")
	})

	t.Run("diffFindHistoryNeedAnExistingEntry", func(t *testing.T) {
		// {id}/diff, find and history resolve a specific audit-log
		// entry; a fresh instance may have none and the feature may be off.
		filters := []kestra_api_client.SearchFilter{
			{Field: kestra_api_client.FilterResources, Operation: kestra_api_client.OpEquals, Value: "FLOW"},
			{Field: kestra_api_client.FilterId, Operation: kestra_api_client.OpEquals, Value: "missing-" + randomId()},
			{Field: kestra_api_client.FilterNamespace, Operation: kestra_api_client.OpEquals, Value: randomId()},
		}
		res, err := client.AuditLogs().AuditLogHistory(ctx, MAIN_TENANT, &page, &size, nil, filters)
		if skipIfGated(t, err, "the AUDITLOG feature") != nil {
			require.NoError(t, err)
			require.Empty(t, res["results"], "an unknown id has no history")
		}
	})
}
