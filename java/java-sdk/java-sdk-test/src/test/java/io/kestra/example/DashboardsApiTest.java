package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;

import org.junit.jupiter.api.Test;

import static io.kestra.example.CommonTestSetup.*;
import static org.assertj.core.api.Assertions.*;

public class DashboardsApiTest {

    /**
     * Create a dashboard from yaml source
     */
    @Test
    public void createDashboardTest() throws ApiException {
        String id = "createDashboardTest";
        String body = getDashboardSource(id);

        Dashboard response = kestraClient().dashboards().createDashboard(MAIN_TENANT, body);

        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo(id);
    }

    /**
     * Get a dashboard
     */
    @Test
    public void dashboardTest() throws ApiException {
        String id = "dashboardTest";
        kestraClient().dashboards().createDashboard(MAIN_TENANT, getDashboardSource(id));

        Dashboard response = kestraClient().dashboards().dashboard(id, MAIN_TENANT);

        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo(id);
    }

    /**
     * Generate a dashboard chart data
     */
    @Test
    public void dashboardChartDataTest() throws ApiException {
        String id = "dashboardChartDataTest";
        kestraClient().dashboards().createDashboard(MAIN_TENANT, getDashboardSource(id));

        ChartFiltersOverrides filters = buildChartFilters(

        );
        PagedResultsMapStringObject response = kestraClient().dashboards().dashboardChartData(id, id, MAIN_TENANT, filters);

        assertThat(response).isNotNull();
    }

    /**
     * Delete a dashboard
     */
    @Test
    public void deleteDashboardTest() throws ApiException {
        String id = "deleteDashboardTest";
        kestraClient().dashboards().createDashboard(MAIN_TENANT, getDashboardSource(id));

        kestraClient().dashboards().deleteDashboard(id, MAIN_TENANT);

        assertThatThrownBy(() -> kestraClient().dashboards().dashboard(id, MAIN_TENANT))
                .isInstanceOf(ApiException.class)
                .hasMessageContaining("Not Found");
    }

    /**
     * Export a table chart data to CSV
     */
    @Test
    public void exportChartToCsvTest() throws ApiException {
        String id = "exportChartToCsvTest";
        kestraClient().dashboards().createDashboard(MAIN_TENANT, getDashboardSource(id));

        // Provide a preview request containing a data-chart YAML (required)
        DashboardControllerPreviewRequest preview = new DashboardControllerPreviewRequest().chart(getChartSource("executions_table"));

        byte[] response = kestraClient().dashboards().exportChartToCsv(MAIN_TENANT, preview);

        // API may return an empty result but should not throw
        assertThat(response).isNotNull();
    }

    /**
     * Export a dashboard chart data to CSV
     */
    @Test
    public void exportDashboardChartDataToCSVTest() throws ApiException {
        String id = "exportDashboardChartDataToCSVTest";
        kestraClient().dashboards().createDashboard(MAIN_TENANT, getDashboardSource(id));

        ChartFiltersOverrides filters = buildChartFilters();
        byte[] response = kestraClient().dashboards().exportDashboardChartDataToCSV(id, id, MAIN_TENANT, filters);

        assertThat(response).isNotNull();
    }

    /**
     * Preview a chart data
     */
    @Test
    public void previewChartTest() throws ApiException {
        String id = "previewChartTest";
        kestraClient().dashboards().createDashboard(MAIN_TENANT, getDashboardSource(id));

        // Build a valid preview request: chart must be a data chart YAML
        DashboardControllerPreviewRequest request = new DashboardControllerPreviewRequest().chart(getChartSource("executions_table"));

        PagedResultsMapStringObject response = kestraClient().dashboards().previewChart(MAIN_TENANT, request);

        assertThat(response).isNotNull();
    }

    /**
     * Search for dashboards
     */
    @Test
    public void searchDashboardsTest() throws ApiException {
        String id = "searchDashboardsTest";
        kestraClient().dashboards().createDashboard(MAIN_TENANT, getDashboardSource(id));

        Integer page = 1;
        Integer size = 100;
        String q = id;
        PagedResultsDashboard response = kestraClient().dashboards().searchDashboards(page, size, MAIN_TENANT, q, null);

        assertThat(response).isNotNull();
        assertThat(response.getResults().stream().map(Dashboard::getTitle)).contains(id);
    }

    /**
     * Update a dashboard
     */
    @Test
    public void updateDashboardTest() throws ApiException {
        String id = "updateDashboardTest";
        kestraClient().dashboards().createDashboard(MAIN_TENANT, getDashboardSource(id));

        String updatedBody = getDashboardSourceWithDescription(id, "Updated description from test");
        Dashboard response = kestraClient().dashboards().updateDashboard(id, MAIN_TENANT, updatedBody);

        assertThat(response).isNotNull();
        assertThat(response.getDescription()).isEqualTo("Updated description from test");
    }

    /**
     * Validate a chart from yaml source
     */
    @Test
    public void validateChartTest() throws ApiException {
        String chartYaml = getChartSource("validateChartTest");
        ValidateConstraintViolation response = kestraClient().dashboards().validateChart(MAIN_TENANT, chartYaml);

        assertThat(response).isNotNull();
        assertThat(response.getConstraints()).isNullOrEmpty();
    }

    /**
     * Validate dashboard from yaml source
     */
    @Test
    public void validateDashboardTest() throws ApiException {
        String id = "validateDashboardTest";
        String body = getDashboardSource(id);
        ValidateConstraintViolation response = kestraClient().dashboards().validateDashboard(MAIN_TENANT, body);

        assertThat(response).isNotNull();
        assertThat(response.getConstraints()).isNullOrEmpty();
    }

    private static ChartFiltersOverrides buildChartFilters() {
        return new ChartFiltersOverrides()
                .startDate(java.time.OffsetDateTime.now().minusDays(365))
                .endDate(java.time.OffsetDateTime.now())
                .pageSize(100)
                .pageNumber(1);
    }

    private static String getDashboardSource(String id) {
        return String.format("""
            id: %s
            description: Demo Dashboard for %s
            title: %s
            timeWindow:
              default: P365D
              max: P365D
            charts:
              - id: %s
                type: io.kestra.plugin.core.dashboard.chart.Table
                chartOptions:
                  displayName: Next Executions
                  pagination:
                    enabled: true
                  width: 6
                data:
                  type: io.kestra.plugin.core.dashboard.data.Triggers
                  columns:
                    namespace:
                      field: NAMESPACE
                      displayName: Namespace
                    flowId:
                      field: FLOW_ID
                      displayName: Flow
                    nextExec:
                      field: NEXT_EXECUTION_DATE
                      displayName: Next Execution Date
            """, id, id, id, id);
    }


    private static String getDashboardSourceWithDescription(String id, String description) {
        return String.format("""
            id: %s
            description: %s
            title: Executions
            timeWindow:
              default: P365D
              max: P365D
            charts:
              - id: kpi_success_ratio
                type: io.kestra.plugin.core.dashboard.chart.KPI
                chartOptions:
                  displayName: Success Ratio
                  numberType: PERCENTAGE
                  width: 3
                data:
                  type: io.kestra.plugin.core.dashboard.data.ExecutionsKPI
                  columns:
                    field: ID
                    agg: COUNT
                  numerator:
                    - type: IN
                      field: STATE
                      values:
                        - SUCCESS
            """, id, description);
    }

    private static String getChartSource(String chartId) {
        return String.format("""
            id: %s
            type: io.kestra.plugin.core.dashboard.chart.Table
            chartOptions:
              displayName: Next Executions
              pagination:
                enabled: true
              width: 6
            data:
              type: io.kestra.plugin.core.dashboard.data.Triggers
              columns:
                namespace:
                  field: NAMESPACE
                  displayName: Namespace
                flowId:
                  field: FLOW_ID
                  displayName: Flow
                nextExec:
                  field: NEXT_EXECUTION_DATE
                  displayName: Next Execution Date
            """, chartId);
    }
}
