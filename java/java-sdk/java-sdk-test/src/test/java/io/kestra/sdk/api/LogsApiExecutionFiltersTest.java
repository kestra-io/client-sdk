package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Pair;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterOp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Kestra 2.0 reads only {@code filters[...]} on {@code GET /logs/{executionId}} and
 * {@code /download}; the old {@code minLevel}/{@code taskRunId}/{@code taskId}/{@code attempt}
 * query params are ignored, so every log came back regardless of what was asked for.
 * This test runs without a live server: it captures what {@link LogsApi} passes to
 * {@code invoke(...)} and asserts the filters are sent and nothing else.
 */
public class LogsApiExecutionFiltersTest {

    /** Captures the request {@link LogsApi} builds instead of making an HTTP call. */
    static class RequestCapturingLogsApi extends LogsApi {
        String path;
        String accept;
        List<Pair> queryParams;
        List<Pair> collectionQueryParams;

        @Override
        protected <T> T invoke(String method, String path, Object body,
                               List<Pair> queryParams, List<Pair> collectionQueryParams,
                               String accept, String contentType,
                               TypeReference<T> returnType) throws ApiException {
            this.path = path;
            this.accept = accept;
            this.queryParams = queryParams;
            this.collectionQueryParams = collectionQueryParams;
            return null;
        }
    }

    private static final String TENANT = "main";
    private static final String EXECUTION_ID = "exec-id";

    private static final List<QueryFilter> FILTERS = List.of(
            new QueryFilter().field(QueryFilterField.MIN_LEVEL).operation(QueryFilterOp.GREATER_THAN_OR_EQUAL_TO).value("WARN"),
            new QueryFilter().field(QueryFilterField.TASK_ID).operation(QueryFilterOp.EQUALS).value("hello"),
            new QueryFilter().field(QueryFilterField.TASK_RUN_ID).operation(QueryFilterOp.EQUALS).value("taskrun-id"),
            new QueryFilter().field(QueryFilterField.ATTEMPT_NUMBER).operation(QueryFilterOp.EQUALS).value(1));

    @Test
    void listLogsFromExecution_sendsFilters() throws ApiException {
        RequestCapturingLogsApi api = new RequestCapturingLogsApi();

        api.listLogsFromExecution(EXECUTION_ID, TENANT, FILTERS);

        assertThat(api.path).endsWith("/logs/" + EXECUTION_ID);
        assertSentOnlyFilters(api);
    }

    @Test
    void downloadLogsFromExecution_sendsFilters() throws ApiException {
        RequestCapturingLogsApi api = new RequestCapturingLogsApi();

        api.downloadLogsFromExecution(EXECUTION_ID, TENANT, FILTERS);

        assertThat(api.path).endsWith("/logs/" + EXECUTION_ID + "/download");
        assertThat(api.accept).isEqualTo("text/plain");
        assertSentOnlyFilters(api);
    }

    @Test
    void listAndDownloadLogsFromExecution_withoutFilters_sendNoParams() throws ApiException {
        for (List<QueryFilter> filters : Arrays.asList(null, List.<QueryFilter>of())) {
            RequestCapturingLogsApi list = new RequestCapturingLogsApi();
            list.listLogsFromExecution(EXECUTION_ID, TENANT, filters);
            assertThat(list.queryParams).isEmpty();
            assertThat(list.collectionQueryParams).isEmpty();

            RequestCapturingLogsApi download = new RequestCapturingLogsApi();
            download.downloadLogsFromExecution(EXECUTION_ID, TENANT, filters);
            assertThat(download.queryParams).isEmpty();
            assertThat(download.collectionQueryParams).isEmpty();
        }
    }

    private static void assertSentOnlyFilters(RequestCapturingLogsApi api) {
        assertThat(api.queryParams).isEmpty();
        assertThat(api.collectionQueryParams)
                .extracting(Pair::getName, Pair::getValue)
                .containsExactly(
                        tuple("filters[level][GREATER_THAN_OR_EQUAL_TO]", "WARN"),
                        tuple("filters[taskId][EQUALS]", "hello"),
                        tuple("filters[taskRunId][EQUALS]", "taskrun-id"),
                        tuple("filters[attemptNumber][EQUALS]", "1"));
    }
}
