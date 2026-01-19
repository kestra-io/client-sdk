package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static io.kestra.example.CommonTestSetup.*;
import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class LogsApiTest {

    public static final String LOG_FLOW = """
        id: %s
        namespace: %s
        
        inputs:
          - id: key
            type: STRING
            defaults: 'empty'

        tasks:
          - id: hello
            type: io.kestra.plugin.core.log.Log
            message: Hello World! 🚀
        """;


    @Test
    public void listLogsFromExecutionTest() throws ApiException {
        Execution exec = createdExecution(LOG_FLOW, StateType.SUCCESS);
        String executionId = exec.getId();

        List<LogEntry> logs = kestraClient().logs().listLogsFromExecution(executionId, MAIN_TENANT, null, null, null, null);
        assertThat(logs).isNotEmpty();
        assertThat(logs.stream().anyMatch(l -> "Hello World! 🚀".equals(l.getMessage()))).isTrue();
    }

    @Test
    public void searchLogsTest() throws ApiException {
        Execution exec = createdExecution(LOG_FLOW, StateType.SUCCESS);

        Integer page = 1;
        Integer size = 10;
        List<String> sort = List.of("timestamp:desc");
        List<QueryFilter> filters = List.of(new QueryFilter()
            .field(QueryFilterField.NAMESPACE)
            .operation(QueryFilterOp.EQUALS)
            .value(exec.getNamespace()));

        PagedResultsLogEntry response = kestraClient().logs().searchLogs(page, size, MAIN_TENANT, sort, filters);
        assertThat(response.getTotal()).isGreaterThanOrEqualTo(1);
        assertThat(response.getResults()).isNotEmpty();
    }

    @Test
    public void deleteLogsFromExecutionTest() throws ApiException {
        Execution exec = createdExecution(LOG_FLOW, StateType.SUCCESS);
        String executionId = exec.getId();

        kestraClient().logs().deleteLogsFromExecution(executionId, MAIN_TENANT, null, null, null, null);

        List<LogEntry> logs = kestraClient().logs().listLogsFromExecution(executionId, MAIN_TENANT, null, null, null, null);
        assertThat(logs).isEmpty();
    }

    @Test
    public void deleteLogsFromFlowTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        createSimpleFlow(id, namespace);

        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(namespace, id, false, MAIN_TENANT, null, null, null, null, null);
        awaitExecution(StateType.SUCCESS, execution.getId());

        kestraClient().logs().deleteLogsFromFlow(namespace, id, id, MAIN_TENANT);

        PagedResultsLogEntry results = kestraClient().logs().searchLogs(1, 10, MAIN_TENANT, null, List.of(new QueryFilter()
            .field(QueryFilterField.FLOW_ID)
            .operation(QueryFilterOp.EQUALS)
            .value(id)));

        assertThat(results).isNotNull();
    }

    @Test
    public void downloadLogsFromExecutionTest() throws ApiException, IOException {
        Execution exec = createdExecution(LOG_FLOW, StateType.SUCCESS);
        String executionId = exec.getId();

        File response = kestraClient().logs().downloadLogsFromExecution(executionId, MAIN_TENANT, null, null, null, null);
        String content = Files.readString(response.toPath(), StandardCharsets.UTF_8);
        assertThat(content).contains("Hello World");
    }
}
