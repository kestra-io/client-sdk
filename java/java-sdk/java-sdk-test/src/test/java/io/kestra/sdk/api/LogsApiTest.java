package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.time.Duration;
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

        List<LogEntry> logs = api().listLogsFromExecution(executionId, TENANT, null, null, "hello", null);

        assertThat(logs).isNotNull();
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
    // Search logs
    // ========================================================================

    @Test
    void searchLogs_basic() throws ApiException {
        createExecutionWithLogs();

        PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchLogs_withPagination() throws ApiException {
        PagedResultsLogEntry result = api().searchLogs(TENANT, 1, 5, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(5);
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
}
