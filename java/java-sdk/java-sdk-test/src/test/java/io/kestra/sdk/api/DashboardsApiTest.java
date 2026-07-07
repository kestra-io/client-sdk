package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DashboardsApiTest {

    static DashboardsApi api() {
        return client().dashboards();
    }

    static String dashboardYaml(String title) {
        return dashboardYaml(randomId(), title);
    }

    static String dashboardYaml(String id, String title) {
        return """
                id: %s
                title: %s
                description: Test dashboard
                timeWindow:
                  default: P30D
                  max: P365D
                charts: []
                """.formatted(id, title);
    }

    // Dashboard with a single OSS-native Table chart over the Executions data
    // type, scoped to namespace so its export content is deterministic even on
    // a shared test instance with unrelated executions.
    static String executionsTableDashboardYaml(String dashboardId, String title, String chartId, String namespace) {
        return """
                id: %s
                title: %s
                description: Test dashboard
                timeWindow:
                  default: P30D
                  max: P365D
                charts:
                  - id: %s
                    type: io.kestra.plugin.core.dashboard.chart.Table
                    chartOptions:
                      displayName: Executions
                    data:
                      type: io.kestra.plugin.core.dashboard.data.Executions
                      where:
                        - field: NAMESPACE
                          type: EQUAL_TO
                          value: %s
                      columns:
                        id:
                          field: ID
                          displayName: Execution ID
                        namespace:
                          field: NAMESPACE
                          displayName: Namespace
                        flow:
                          field: FLOW_ID
                          displayName: Flow
                        state:
                          field: STATE
                          displayName: State
                """.formatted(dashboardId, title, chartId, namespace);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createDashboard_basic() throws ApiException {
        String title = "test-dash-" + randomId();
        DashboardControllerDashboardResponse result = api().createDashboard(TENANT, dashboardYaml(title));

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
        assertThat(result.getTitle()).isEqualTo(title);
    }

    @Test
    void dashboard_getById() throws ApiException {
        String title = "get-dash-" + randomId();
        DashboardControllerDashboardResponse created = api().createDashboard(TENANT, dashboardYaml(title));

        DashboardControllerDashboardResponse result = api().dashboard(created.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
        assertThat(result.getTitle()).isEqualTo(title);
    }

    @Test
    void dashboard_notFound() {
        assertThatThrownBy(() -> api().dashboard("nonexistent-dash-id", TENANT))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void updateDashboard_changeTitle() throws ApiException {
        DashboardControllerDashboardResponse created = api().createDashboard(TENANT,
                dashboardYaml("before-" + randomId()));
        String newTitle = "after-" + randomId();

        DashboardControllerDashboardResponse updated = api().updateDashboard(
                created.getId(), TENANT, dashboardYaml(created.getId(), newTitle));

        assertThat(updated.getTitle()).isEqualTo(newTitle);
    }

    @Test
    void deleteDashboard_basic() throws ApiException {
        DashboardControllerDashboardResponse created = api().createDashboard(TENANT,
                dashboardYaml("to-delete-" + randomId()));

        assertThatCode(() -> api().deleteDashboard(created.getId(), TENANT))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> api().dashboard(created.getId(), TENANT))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchDashboards_basic() throws ApiException {
        api().createDashboard(TENANT, dashboardYaml("searchable-" + randomId()));

        PagedResultsDashboardControllerDashboardResponse result =
                api().searchDashboards(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchDashboards_withPagination() throws ApiException {
        PagedResultsDashboardControllerDashboardResponse result =
                api().searchDashboards(TENANT, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchDashboards_withQuery() throws ApiException {
        String title = "dashboard-" + randomId();
        api().createDashboard(TENANT, dashboardYaml(title));

        PagedResultsDashboardControllerDashboardResponse result =
                api().searchDashboards(TENANT, 1, 10, title, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchDashboards_withSort() throws ApiException {
        String prefix = "sortdash" + randomId().substring(0, 6);
        String title1 = prefix + "aaa";
        String title2 = prefix + "zzz";
        api().createDashboard(TENANT, dashboardYaml(title2));
        api().createDashboard(TENANT, dashboardYaml(title1));

        PagedResultsDashboardControllerDashboardResponse result =
                api().searchDashboards(TENANT, 1, 10, prefix, List.of("title:asc"));

        assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> titles = result.getResults().stream()
                .map(DashboardControllerDashboardResponse::getTitle)
                .toList();
        int idx1 = titles.indexOf(title1);
        int idx2 = titles.indexOf(title2);
        assertThat(idx1).isGreaterThanOrEqualTo(0);
        assertThat(idx2).isGreaterThan(idx1);
    }

    @Test
    void searchDashboards_noResults() throws ApiException {
        PagedResultsDashboardControllerDashboardResponse result =
                api().searchDashboards(TENANT, 1, 10, "nonexistent_dashboard_" + randomId(), null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isEmpty();
    }

    // ========================================================================
    // Settings
    // ========================================================================

    @Test
    void defaultDashboards_basic() throws ApiException {
        DashboardSettings settings = api().defaultDashboards(TENANT);
        assertThat(settings).isNotNull();
    }

    // ========================================================================
    // Validation
    // ========================================================================

    @Test
    void validateDashboard_valid() throws ApiException {
        ValidateConstraintViolation result = api().validateDashboard(TENANT,
                dashboardYaml("valid-" + randomId()));

        assertThat(result).isNotNull();
    }

    @Test
    void validateChart_valid() throws ApiException {
        String chartYaml = """
                id: test-chart
                type: io.kestra.plugin.ee.core.dashboard.charts.Executions
                columns:
                  date:
                    field: DATE
                  duration:
                    field: DURATION
                graphStyle: LINES
                """;

        ValidateConstraintViolation result = api().validateChart(TENANT, chartYaml);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Chart data & export — these need a valid chart plugin, so we test
    // that the endpoints are reachable via expected error codes.
    // ========================================================================

    @Test
    void dashboardChartData_notFound() throws ApiException {
        String title = "chart-data-" + randomId();
        DashboardControllerDashboardResponse created = api().createDashboard(TENANT, dashboardYaml(title));

        ChartFiltersOverrides filters = new ChartFiltersOverrides();

        // Dashboard has no charts, so chart ID "nonexistent" should fail
        assertThatThrownBy(() -> api().dashboardChartData(created.getId(), "nonexistent", TENANT, filters))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void previewChart_basic() throws ApiException {
        DashboardControllerPreviewRequest request = new DashboardControllerPreviewRequest()
                .chart("""
                        id: preview-chart
                        type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart
                        graphStyle: LINES
                        columns:
                          date:
                            field: DATE
                        """);

        // May fail with 422 if chart type not available, verifies endpoint reachability
        try {
            PagedResultsMapStringObject result = api().previewChart(TENANT, request);
            assertThat(result).isNotNull();
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(400, 422);
        }
    }

    @Test
    void exportChart_basic() throws ApiException {
        DashboardControllerPreviewRequest request = new DashboardControllerPreviewRequest()
                .chart("""
                        id: csv-chart
                        type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart
                        graphStyle: LINES
                        columns:
                          date:
                            field: DATE
                        """);

        try {
            byte[] result = api().exportChart(TENANT, request, "CSV");
            assertThat(result).isNotNull();
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(400, 422);
        }
    }

    @Test
    void exportChart_ion() throws ApiException {
        DashboardControllerPreviewRequest request = new DashboardControllerPreviewRequest()
                .chart("""
                        id: ion-chart
                        type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart
                        graphStyle: LINES
                        columns:
                          date:
                            field: DATE
                        """);

        try {
            byte[] result = api().exportChart(TENANT, request, "ION");
            assertThat(result).isNotNull();
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(400, 422);
        }
    }

    @Test
    void exportDashboardChart_csv() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        String chartId = "recent_executions";

        createFlow(logFlowYaml(flowId, namespace));
        ExecutionControllerExecutionResponse execution = client().executions()
                .createExecution(TENANT, namespace, flowId, null, true, null, null, null, null);

        DashboardControllerDashboardResponse created = api().createDashboard(TENANT,
                executionsTableDashboardYaml(randomId(), "export-csv-" + randomId(), chartId, namespace));

        ChartFiltersOverrides filters = new ChartFiltersOverrides();
        byte[] result = api().exportDashboardChart(created.getId(), chartId, TENANT, filters, "CSV");
        assertThat(result).isNotEmpty();

        String csv = new String(result);
        assertThat(csv).contains(namespace, flowId, execution.getId());
    }

    @Test
    void exportDashboardChart_ion() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        String chartId = "recent_executions";

        createFlow(logFlowYaml(flowId, namespace));
        ExecutionControllerExecutionResponse execution = client().executions()
                .createExecution(TENANT, namespace, flowId, null, true, null, null, null, null);

        DashboardControllerDashboardResponse created = api().createDashboard(TENANT,
                executionsTableDashboardYaml(randomId(), "export-ion-" + randomId(), chartId, namespace));

        ChartFiltersOverrides filters = new ChartFiltersOverrides();
        byte[] result = api().exportDashboardChart(created.getId(), chartId, TENANT, filters, "ION");
        assertThat(result).isNotEmpty();

        String ion = new String(result);
        assertThat(ion).contains(namespace, flowId, execution.getId());
    }

    @Test
    void exportDashboardChart_notFound() throws ApiException {
        String title = "csv-export-" + randomId();
        DashboardControllerDashboardResponse created = api().createDashboard(TENANT, dashboardYaml(title));

        ChartFiltersOverrides filters = new ChartFiltersOverrides();

        assertThatThrownBy(() -> api().exportDashboardChart(created.getId(), "nonexistent", TENANT, filters, "CSV"))
                .isInstanceOf(ApiException.class);
    }
}
