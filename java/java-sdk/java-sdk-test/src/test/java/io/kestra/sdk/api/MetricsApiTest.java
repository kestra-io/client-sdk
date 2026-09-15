package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.ExecutionControllerExecutionResponse;
import io.kestra.sdk.model.FlowWithSource;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the metric endpoints under {@code /api/v1/{tenant}/metrics/**}. A freshly
 * created (never executed) flow has no recorded metrics yet, so the name/task listings return
 * an empty list and the aggregates return an empty-but-valid aggregation envelope — real
 * values that still exercise the binding.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MetricsApiTest {

    static MetricsApi api() {
        return client().metrics();
    }

    @Test
    void listFlowMetrics_forFreshFlow_isEmptyList() throws ApiException {
        FlowWithSource flow = createLogFlow();

        List<String> metrics = api().listFlowMetrics(TENANT, flow.getNamespace(), flow.getId());

        assertThat(metrics).isNotNull().isEmpty();
    }

    @Test
    void listTaskMetrics_forFreshFlow_isEmptyList() throws ApiException {
        FlowWithSource flow = createLogFlow();

        List<String> metrics = api().listTaskMetrics(TENANT, flow.getNamespace(), flow.getId(), "hello");

        assertThat(metrics).isNotNull().isEmpty();
    }

    @Test
    void listTasksWithMetrics_forFreshFlow_isEmptyList() throws ApiException {
        FlowWithSource flow = createLogFlow();

        List<String> tasks = api().listTasksWithMetrics(TENANT, flow.getNamespace(), flow.getId());

        assertThat(tasks).isNotNull().isEmpty();
    }

    @Test
    void aggregateMetricsFromFlow_returnsAggregationEnvelope() throws ApiException {
        FlowWithSource flow = createLogFlow();

        Map<String, Object> result = api().aggregateMetricsFromFlow(
                TENANT, flow.getNamespace(), flow.getId(), "duration", "sum", null, null);

        assertThat(result).isNotNull().isNotEmpty();
    }

    @Test
    void aggregateMetricsFromTask_returnsAggregationEnvelope() throws ApiException {
        FlowWithSource flow = createLogFlow();

        Map<String, Object> result = api().aggregateMetricsFromTask(
                TENANT, flow.getNamespace(), flow.getId(), "hello", "duration", "sum", null, null);

        assertThat(result).isNotNull().isNotEmpty();
    }

    @Test
    void searchMetricsByExecution_returnsPagedEnvelope() throws ApiException {
        FlowWithSource flow = createLogFlow();
        ExecutionControllerExecutionResponse execution = client().executions()
                .createExecution(TENANT, flow.getNamespace(), flow.getId(), null, null, null, null, null, null);

        Map<String, Object> result = api().searchMetricsByExecution(
                TENANT, execution.getId(), 1, 10, null, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(List.class);
    }
}
