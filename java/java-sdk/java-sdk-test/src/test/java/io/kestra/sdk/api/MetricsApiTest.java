package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.FlowWithSource;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the metric endpoints under {@code /api/v1/{tenant}/metrics/**}. A freshly
 * created (never executed) flow has no recorded metrics yet, so the name/task listings return
 * an empty list rather than an error — a real value that still exercises the binding.
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
    void listTasksWithMetrics_forFreshFlow_isEmptyList() throws ApiException {
        FlowWithSource flow = createLogFlow();

        List<String> tasks = api().listTasksWithMetrics(TENANT, flow.getNamespace(), flow.getId());

        assertThat(tasks).isNotNull().isEmpty();
    }
}
