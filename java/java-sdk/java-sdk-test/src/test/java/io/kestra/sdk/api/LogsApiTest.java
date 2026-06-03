package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogsApiTest {

    static LogsApi api() {
        return client().logs();
    }

    static String createExecutionWithLogs() throws ApiException {
        String ns = randomId();
        String id = randomId();
        createFlow(logFlowYaml(id, ns));
        ExecutionControllerExecutionResponse exec = client().executions()
                .createExecution(TENANT, ns, id, null, null, null, null, null, null);

        AtomicReference<ApiExecution> ref = new AtomicReference<>();
        await().atMost(Duration.ofSeconds(10)).until(() -> {
            ref.set(client().executions().execution(exec.getId(), TENANT));
            return ref.get().getState().getCurrent().equals(StateType.SUCCESS);
        });
        return exec.getId();
    }

    // ========================================================================
    // List logs
    // ========================================================================

    @Test
    void listLogsFromExecution_basic() throws ApiException {
        String executionId = createExecutionWithLogs();

        List<LogEntry> logs = api().listLogsFromExecution(executionId, TENANT, null, null, null, null);

        assertThat(logs).isNotNull().isNotEmpty();
        assertThat(logs.get(0).getExecutionId()).isEqualTo(executionId);
    }

    @Test
    void listLogsFromExecution_withMinLevel() throws ApiException {
        String executionId = createExecutionWithLogs();

        List<LogEntry> logs = api().listLogsFromExecution(executionId, TENANT, Level.INFO, null, null, null);

        assertThat(logs).isNotNull();
        logs.forEach(log -> assertThat(log.getLevel()).isNotNull());
    }

    @Test
    void listLogsFromExecution_withTaskId() throws ApiException {
        String executionId = createExecutionWithLogs();

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(500)).untilAsserted(() -> {
            List<LogEntry> logs = api().listLogsFromExecution(executionId, TENANT, null, null, "hello", null);
            assertThat(logs).isNotNull().isNotEmpty();
            assertThat(logs).allSatisfy(log ->
                    assertThat(log.getTaskId()).isEqualTo("hello"));
        });
    }

    // ========================================================================
    // Download logs
    // ========================================================================

    @Test
    void downloadLogsFromExecution_basic() throws ApiException {
        String executionId = createExecutionWithLogs();

        File file = api().downloadLogsFromExecution(executionId, TENANT, null, null, null, null);

        assertThat(file).isNotNull();
        assertThat(file.length()).isGreaterThan(0);
    }

    // ========================================================================
    // Follow logs (SSE)
    // ========================================================================

    static ExecutionControllerExecutionResponse startExecutionWithLogs() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        return client().executions()
                .createExecution(TENANT, ns, flowId, null, null, null, null, null, null);
    }

    /**
     * The server interleaves empty {@code {}} keepalive frames (the SSE
     * {@code start} event) with real log events; keep only the real ones,
     * and stop as soon as one arrives so the test does not wait out the
     * full window.
     */
    static List<FollowLogEvent> collectFollowedLogs(Flux<FollowLogEvent> flux) {
        List<FollowLogEvent> events = new ArrayList<>();
        flux.filter(event -> event.getExecutionId() != null)
                .take(1)
                .take(Duration.ofSeconds(15))
                .doOnNext(events::add)
                .blockLast(Duration.ofSeconds(20));
        return events;
    }

    @Test
    void followLogsFromExecution_basic() throws ApiException {
        ExecutionControllerExecutionResponse exec = startExecutionWithLogs();

        List<FollowLogEvent> events = collectFollowedLogs(
                api().followLogsFromExecution(exec.getId(), TENANT, null));

        assertThat(events).isNotEmpty();
        assertThat(events).allSatisfy(event ->
                assertThat(event.getExecutionId()).isEqualTo(exec.getId()));
    }

    @Test
    void followLogsFromExecution_withMinLevelFilter() throws ApiException {
        ExecutionControllerExecutionResponse exec = startExecutionWithLogs();

        List<FollowLogEvent> events = collectFollowedLogs(
                api().followLogsFromExecution(exec.getId(), TENANT,
                        List.of(minLevelFilter("INFO"))));

        assertThat(events).isNotEmpty();
        assertThat(events).allSatisfy(event ->
                assertThat(event.getLevel()).isNotNull());
    }

    // ========================================================================
    // Search logs
    // ========================================================================

    @Test
    void searchLogs_basic() throws ApiException {
        createExecutionWithLogs();

        PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
        assertThat(result.getResults()).allSatisfy(log ->
                assertThat(log.getExecutionId()).isNotEmpty());
    }

    @Test
    void searchLogs_withPagination() throws ApiException {
        PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 5, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(5);
    }

    @Test
    void searchLogs_withNamespaceFilter() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        ExecutionControllerExecutionResponse exec = client().executions()
                .createExecution(TENANT, ns, flowId, null, null, null, null, null, null);

        await().atMost(Duration.ofSeconds(10)).until(() -> {
            ApiExecution e = client().executions().execution(exec.getId(), TENANT);
            return e.getState().getCurrent().equals(StateType.SUCCESS);
        });

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(500)).untilAsserted(() -> {
            PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 25, null, List.of(nsFilter(ns)));
            assertThat(result).isNotNull();
            assertThat(result.getResults()).isNotNull().isNotEmpty();
        });
    }

    @Test
    void searchLogs_withFlowIdAndNamespaceFilter() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        ExecutionControllerExecutionResponse exec = client().executions()
                .createExecution(TENANT, ns, flowId, null, null, null, null, null, null);

        await().atMost(Duration.ofSeconds(10)).until(() -> {
            ApiExecution e = client().executions().execution(exec.getId(), TENANT);
            return e.getState().getCurrent().equals(StateType.SUCCESS);
        });

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(500)).untilAsserted(() -> {
            PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 25, null,
                    List.of(nsFilter(ns), flowIdFilter(flowId)));
            assertThat(result).isNotNull();
            assertThat(result.getResults()).isNotNull().isNotEmpty();
        });
    }

    @Test
    void searchLogs_withExecutionIdFilter() throws ApiException {
        String executionId = createExecutionWithLogs();

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(500)).untilAsserted(() -> {
            PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 25, null, List.of(executionIdFilter(executionId)));
            assertThat(result).isNotNull();
            assertThat(result.getResults()).isNotNull().isNotEmpty();
            assertThat(result.getResults()).allSatisfy(log ->
                    assertThat(log.getExecutionId()).isEqualTo(executionId));
        });
    }

    @Test
    void searchLogs_withFlowIdFilter() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        ExecutionControllerExecutionResponse exec = client().executions()
                .createExecution(TENANT, ns, flowId, null, null, null, null, null, null);

        await().atMost(Duration.ofSeconds(10)).until(() -> {
            ApiExecution e = client().executions().execution(exec.getId(), TENANT);
            return e.getState().getCurrent().equals(StateType.SUCCESS);
        });

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(500)).untilAsserted(() -> {
            PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 25, null, List.of(flowIdFilter(flowId), nsFilter(ns)));
            assertThat(result).isNotNull();
            assertThat(result.getResults()).isNotNull().isNotEmpty();
        });
    }

    @Test
    void searchLogs_withSort() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        client().executions().createExecution(TENANT, ns, flowId, null, null, null, null, null, null);
        client().executions().createExecution(TENANT, ns, flowId, null, null, null, null, null, null);

        await().atMost(Duration.ofSeconds(15)).pollInterval(Duration.ofMillis(500)).untilAsserted(() -> {
            PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 25, List.of("timestamp:desc"),
                    List.of(nsFilter(ns)));

            assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
            for (int i = 0; i < result.getResults().size() - 1; i++) {
                assertThat(result.getResults().get(i).getTimestamp())
                        .isAfterOrEqualTo(result.getResults().get(i + 1).getTimestamp());
            }
        });
    }

    @Test
    void searchLogs_withMinLevelFilter() throws ApiException {
        String executionId = createExecutionWithLogs();

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(500)).untilAsserted(() -> {
            PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 25, null,
                    List.of(executionIdFilter(executionId), minLevelFilter("INFO")));
            assertThat(result).isNotNull();
            assertThat(result.getResults()).isNotNull().isNotEmpty();
        });
    }

    @Test
    void searchLogs_noResults() throws ApiException {
        PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 10, null,
                List.of(nsFilter("nonexistent_ns_" + randomId())));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isEmpty();
    }

    // ========================================================================
    // Delete logs
    // ========================================================================

    @Test
    void deleteLogsFromExecution_basic() throws ApiException {
        String executionId = createExecutionWithLogs();

        assertThatCode(() -> api().deleteLogsFromExecution(executionId, TENANT, null, null, null, null))
                .doesNotThrowAnyException();
    }

    @Test
    void deleteLogsFromExecution_withMinLevel() throws ApiException {
        String executionId = createExecutionWithLogs();

        assertThatCode(() -> api().deleteLogsFromExecution(executionId, TENANT, Level.TRACE, null, null, null))
                .doesNotThrowAnyException();
    }

    @Test
    void deleteLogsFromFlow_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        // Execute the flow to generate logs
        ExecutionControllerExecutionResponse exec = client().executions()
                .createExecution(TENANT, ns, flowId, null, null, null, null, null, null);

        await().atMost(Duration.ofSeconds(10)).until(() -> {
            ApiExecution e = client().executions().execution(exec.getId(), TENANT);
            return e.getState().getCurrent().equals(StateType.SUCCESS);
        });

        assertThatCode(() -> api().deleteLogsFromFlow(ns, flowId, "hello", TENANT))
                .doesNotThrowAnyException();
    }
}
