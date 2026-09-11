package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Pair;
import io.kestra.sdk.model.ExecutionControllerStateRequest;
import io.kestra.sdk.model.Label;
import io.kestra.sdk.model.StateType;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Regression test for the {@code /actions/} URL bug (fixed in 57c4a06e): all twelve
 * single-execution actions must build a path containing the {@code /actions/} segment.
 * <p>
 * Before the fix, e.g. {@code killExecution} built
 * {@code /api/v1/{tenant}/executions/{id}/kill} instead of
 * {@code /api/v1/{tenant}/executions/{id}/actions/kill}. That 404s/403s against a real
 * server — a failure mode that was repeatedly misread as an RBAC or server problem for
 * months, because nothing asserted on the URL itself, only on a live response. This test
 * runs without a live server: it captures the path {@link ExecutionsApi} passes to
 * {@code invoke(...)} and asserts on it directly, so a future refactor that drops
 * {@code /actions/} again fails here instead of surfacing as a misleading 403/404.
 */
public class ExecutionsApiActionsPathTest {

    /** Captures the path passed to {@code invoke(...)} instead of making an HTTP call. */
    static class PathCapturingExecutionsApi extends ExecutionsApi {
        String lastPath;

        @Override
        protected <T> T invoke(String method, String path, Object body,
                                List<Pair> queryParams, List<Pair> collectionQueryParams,
                                String accept, String contentType,
                                TypeReference<T> returnType) throws ApiException {
            this.lastPath = path;
            return null;
        }

        @Override
        protected <T> T invoke(String method, String path, Object body,
                                List<Pair> queryParams, List<Pair> collectionQueryParams,
                                String accept, String contentType,
                                Map<String, Object> formParams,
                                TypeReference<T> returnType) throws ApiException {
            this.lastPath = path;
            return null;
        }
    }

    private static final String TENANT = "main";
    private static final String EXECUTION_ID = "exec-id";

    @Test
    void killExecution_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.killExecution(EXECUTION_ID, TENANT, null);
        assertThat(api.lastPath).contains("/actions/kill");
    }

    @Test
    void pauseExecution_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.pauseExecution(EXECUTION_ID, TENANT);
        assertThat(api.lastPath).contains("/actions/pause");
    }

    @Test
    void resumeExecution_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.resumeExecution(EXECUTION_ID, TENANT);
        assertThat(api.lastPath).contains("/actions/resume");
    }

    @Test
    void restartExecution_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.restartExecution(EXECUTION_ID, TENANT, null);
        assertThat(api.lastPath).contains("/actions/restart");
    }

    @Test
    void replayExecution_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.replayExecution(EXECUTION_ID, TENANT, null, null, null);
        assertThat(api.lastPath).contains("/actions/replay");
    }

    @Test
    void replayExecutionWithInputs_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.replayExecutionWithInputs(EXECUTION_ID, TENANT, null, null, null);
        assertThat(api.lastPath).contains("/actions/replay-with-inputs");
    }

    @Test
    void forceRunExecution_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.forceRunExecution(EXECUTION_ID, TENANT);
        assertThat(api.lastPath).contains("/actions/force-run");
    }

    @Test
    void unqueueExecution_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.unqueueExecution(EXECUTION_ID, TENANT, StateType.SUCCESS);
        assertThat(api.lastPath).contains("/actions/unqueue");
    }

    @Test
    void setLabelsOnTerminatedExecution_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.setLabelsOnTerminatedExecution(EXECUTION_ID, TENANT, List.of(new Label().key("k").value("v")));
        assertThat(api.lastPath).contains("/actions/labels");
    }

    @Test
    void updateExecutionStatus_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.updateExecutionStatus(EXECUTION_ID, StateType.WARNING, TENANT);
        assertThat(api.lastPath).contains("/actions/change-status");
    }

    @Test
    void updateTaskRunState_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.updateTaskRunState(EXECUTION_ID, TENANT, new ExecutionControllerStateRequest());
        assertThat(api.lastPath).contains("/actions/state");
    }

    @Test
    void evalExpression_usesActionsSegment() throws ApiException {
        PathCapturingExecutionsApi api = new PathCapturingExecutionsApi();
        api.evalExpression(EXECUTION_ID, TENANT, "{{ execution.id }}");
        assertThat(api.lastPath).contains("/actions/eval");
    }
}
