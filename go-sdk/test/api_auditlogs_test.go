package test

import (
	"context"
	"testing"

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
		// {id}/diff, find and history/{detailId} resolve a specific audit-log
		// entry; a fresh instance may have none and the feature may be off.
		res, err := client.AuditLogs().AuditLogHistory(ctx, "missing-"+randomId(), MAIN_TENANT)
		if skipIfGated(t, err, "the AUDITLOG feature") != nil {
			require.NoError(t, err)
			require.NotNil(t, res)
		}
	})
}
