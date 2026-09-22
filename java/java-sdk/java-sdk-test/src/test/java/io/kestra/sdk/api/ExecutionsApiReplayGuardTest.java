package io.kestra.sdk.api;

import io.kestra.sdk.KestraClient;
import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * replayExecutionWithInputs requires a non-empty inputs body; the endpoint rejects a call
 * with none. The client guards this before any HTTP request, so this runs offline against a
 * client that is never connected.
 */
class ExecutionsApiReplayGuardTest {

    private final KestraClient client = KestraClient.builder().build();

    @Test
    void nullInputs_throwsBeforeRequest() {
        assertThatThrownBy(() ->
                client.executions().replayExecutionWithInputs("some-execution", "some-tenant", null, null, null, null))
                .isInstanceOf(ApiException.class)
                .hasMessageContaining("replayExecution");
    }

    @Test
    void emptyInputs_throwsBeforeRequest() {
        assertThatThrownBy(() ->
                client.executions().replayExecutionWithInputs("some-execution", "some-tenant", null, null, null, Map.of()))
                .isInstanceOf(ApiException.class)
                .hasMessageContaining("replayExecution");
    }
}
