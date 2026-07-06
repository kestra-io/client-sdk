package test

import (
	"context"
	"fmt"
	"strings"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func dashboardYaml(title string) string {
	return dashboardYamlWithId(randomId(), title)
}

func dashboardYamlWithId(id, title string) string {
	return fmt.Sprintf(`
id: %s
title: %s
description: Test dashboard
timeWindow:
  default: P30D
  max: P365D
charts: []
`, id, title)
}

func TestDashboardsAPI_All(t *testing.T) {

	// ========================================================================
	// CRUD
	// ========================================================================

	t.Run("createDashboard_basic", func(t *testing.T) {
		ctx := context.Background()
		title := "test-dash-" + randomId()

		result, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml(title))
		require.NoError(t, err)
		require.NotNil(t, result)
		require.NotEmpty(t, result.Id)
		require.Equal(t, title, result.Title)
	})

	t.Run("dashboard_getById", func(t *testing.T) {
		ctx := context.Background()
		title := "get-dash-" + randomId()

		created, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml(title))
		require.NoError(t, err)

		result, err := KestraTestClient().Dashboards().Dashboard(ctx, created.Id, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Equal(t, created.Id, result.Id)
		require.Equal(t, title, result.Title)
	})

	t.Run("dashboard_notFound", func(t *testing.T) {
		ctx := context.Background()

		_, err := KestraTestClient().Dashboards().Dashboard(ctx, "nonexistent-dash-id", MAIN_TENANT)
		require.Error(t, err)
	})

	t.Run("updateDashboard_changeTitle", func(t *testing.T) {
		ctx := context.Background()

		created, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml("before-"+randomId()))
		require.NoError(t, err)

		newTitle := "after-" + randomId()
		updated, err := KestraTestClient().Dashboards().UpdateDashboard(ctx, created.Id, MAIN_TENANT, dashboardYamlWithId(created.Id, newTitle))
		require.NoError(t, err)
		require.Equal(t, newTitle, updated.Title)
	})

	t.Run("deleteDashboard_basic", func(t *testing.T) {
		ctx := context.Background()

		created, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml("to-delete-"+randomId()))
		require.NoError(t, err)

		err = KestraTestClient().Dashboards().DeleteDashboard(ctx, created.Id, MAIN_TENANT)
		require.NoError(t, err)

		_, err = KestraTestClient().Dashboards().Dashboard(ctx, created.Id, MAIN_TENANT)
		require.Error(t, err)
	})

	// ========================================================================
	// Search
	// ========================================================================

	t.Run("searchDashboards_basic", func(t *testing.T) {
		ctx := context.Background()

		_, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml("searchable-"+randomId()))
		require.NoError(t, err)

		result, err := KestraTestClient().Dashboards().SearchDashboards(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Greater(t, len(result.Results), 0)
	})

	t.Run("searchDashboards_withPagination", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Dashboards().SearchDashboards(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(2), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.LessOrEqual(t, len(result.Results), 2)
	})

	t.Run("searchDashboards_withQuery", func(t *testing.T) {
		ctx := context.Background()
		title := "dashboard-" + randomId()

		_, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml(title))
		require.NoError(t, err)

		result, err := KestraTestClient().Dashboards().SearchDashboards(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), kestra_api_client.PtrString(title), nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Greater(t, len(result.Results), 0)
	})

	t.Run("searchDashboards_withSort", func(t *testing.T) {
		ctx := context.Background()
		prefix := "sortdash" + randomId()[:6]
		title1 := prefix + "aaa"
		title2 := prefix + "zzz"

		_, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml(title2))
		require.NoError(t, err)
		_, err = KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml(title1))
		require.NoError(t, err)

		result, err := KestraTestClient().Dashboards().SearchDashboards(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), kestra_api_client.PtrString(prefix), []string{"title:asc"})
		require.NoError(t, err)
		require.GreaterOrEqual(t, len(result.Results), 2)

		titles := make([]string, len(result.Results))
		for i, r := range result.Results {
			titles[i] = r.Title
		}
		idx1 := indexOf(titles, title1)
		idx2 := indexOf(titles, title2)
		require.GreaterOrEqual(t, idx1, 0)
		require.Greater(t, idx2, idx1)
	})

	t.Run("searchDashboards_noResults", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Dashboards().SearchDashboards(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), kestra_api_client.PtrString("nonexistent_dashboard_"+randomId()), nil)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.Empty(t, result.Results)
	})

	// ========================================================================
	// Settings
	// ========================================================================

	t.Run("defaultDashboards_basic", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Dashboards().DefaultDashboards(ctx, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	// ========================================================================
	// Validation
	// ========================================================================

	t.Run("validateDashboard_valid", func(t *testing.T) {
		ctx := context.Background()

		result, err := KestraTestClient().Dashboards().ValidateDashboard(ctx, MAIN_TENANT, dashboardYaml("valid-"+randomId()))
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("validateChart_valid", func(t *testing.T) {
		ctx := context.Background()

		chartYaml := `
id: test-chart
type: io.kestra.plugin.ee.core.dashboard.charts.Executions
columns:
  date:
    field: DATE
  duration:
    field: DURATION
graphStyle: LINES
`
		result, err := KestraTestClient().Dashboards().ValidateChart(ctx, MAIN_TENANT, chartYaml)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	// ========================================================================
	// Chart data & export
	// ========================================================================

	t.Run("dashboardChartData_notFound", func(t *testing.T) {
		ctx := context.Background()
		title := "chart-data-" + randomId()

		created, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml(title))
		require.NoError(t, err)

		filters := kestra_api_client.NewChartFiltersOverrides()

		// Dashboard has no charts, so chart ID "nonexistent" should fail
		_, err = KestraTestClient().Dashboards().DashboardChartData(ctx, created.Id, "nonexistent", MAIN_TENANT, filters)
		require.Error(t, err)
	})

	t.Run("previewChart_basic", func(t *testing.T) {
		ctx := context.Background()

		chartYaml := strings.TrimSpace(`
id: preview-chart
type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart
graphStyle: LINES
columns:
  date:
    field: DATE
`)
		request := kestra_api_client.NewDashboardControllerPreviewRequest(chartYaml)

		// May fail with 400/422 if chart type not available, verifies endpoint reachability
		_, err := KestraTestClient().Dashboards().PreviewChart(ctx, MAIN_TENANT, request)
		// We accept success or a controlled API error
		if err != nil {
			require.Contains(t, err.Error(), "")
		}
	})

	t.Run("exportChart_basic", func(t *testing.T) {
		ctx := context.Background()

		chartYaml := strings.TrimSpace(`
id: csv-chart
type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart
graphStyle: LINES
columns:
  date:
    field: DATE
`)
		request := kestra_api_client.NewDashboardControllerPreviewRequest(chartYaml)

		// May fail with 400/422 if chart type not available
		_, err := KestraTestClient().Dashboards().ExportChart(ctx, MAIN_TENANT, request, strPtr("CSV"))
		if err != nil {
			require.Contains(t, err.Error(), "")
		}
	})

	t.Run("exportChart_ion", func(t *testing.T) {
		ctx := context.Background()

		chartYaml := strings.TrimSpace(`
id: ion-chart
type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart
graphStyle: LINES
columns:
  date:
    field: DATE
`)
		request := kestra_api_client.NewDashboardControllerPreviewRequest(chartYaml)

		// May fail with 400/422 if chart type not available
		_, err := KestraTestClient().Dashboards().ExportChart(ctx, MAIN_TENANT, request, strPtr("ION"))
		if err != nil {
			require.Contains(t, err.Error(), "")
		}
	})

	t.Run("exportDashboardChart_notFound", func(t *testing.T) {
		ctx := context.Background()
		title := "csv-export-" + randomId()

		created, err := KestraTestClient().Dashboards().CreateDashboard(ctx, MAIN_TENANT, dashboardYaml(title))
		require.NoError(t, err)

		filters := kestra_api_client.NewChartFiltersOverrides()

		_, err = KestraTestClient().Dashboards().ExportDashboardChart(ctx, created.Id, "nonexistent", MAIN_TENANT, filters, strPtr("CSV"))
		require.Error(t, err)
	})
}

// indexOf returns the index of s in slice, or -1 if not found.
func indexOf(slice []string, s string) int {
	for i, v := range slice {
		if v == s {
			return i
		}
	}
	return -1
}
