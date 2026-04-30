package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

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

    // ========================================================================
    // Settings
    // ========================================================================

    @Test
    void defaultDashboards1_basic() throws ApiException {
        DashboardSettings settings = api().defaultDashboards1(TENANT);
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
}
