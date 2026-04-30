package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TriggersApiTest {

    static TriggersApi api() {
        return client().triggers();
    }

    static String scheduleFlowYaml(String id, String ns) {
        return """
                id: %s
                namespace: %s
                tasks:
                  - id: hello
                    type: io.kestra.plugin.core.log.Log
                    message: Hello from trigger!
                triggers:
                  - id: schedule_trigger
                    type: io.kestra.plugin.core.trigger.Schedule
                    cron: "0 0 1 1 *"
                    disabled: false
                """.formatted(id, ns);
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchTriggers_basic() throws ApiException {
        PagedResultsApiTriggerAndState result = api().searchTriggers(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchTriggers_withPagination() throws ApiException {
        PagedResultsApiTriggerAndState result = api().searchTriggers(TENANT, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchTriggersForFlow_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        PagedResultsApiTriggerState result = api().searchTriggersForFlow(TENANT, ns, flowId, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    // ========================================================================
    // Enable / Disable
    // ========================================================================

    @Test
    void disableTriggerById_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        TriggerControllerApiDisableTriggerRequest request =
                new TriggerControllerApiDisableTriggerRequest()
                        .namespace(ns)
                        .flowId(flowId)
                        .triggerId("schedule_trigger")
                        .disabled(true);

        ApiTriggerState result = api().disableTriggerById(TENANT, request);

        assertThat(result).isNotNull();
    }

    @Test
    void enableTriggerById_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        TriggerControllerApiDisableTriggerRequest disableReq =
                new TriggerControllerApiDisableTriggerRequest()
                        .namespace(ns)
                        .flowId(flowId)
                        .triggerId("schedule_trigger")
                        .disabled(true);
        api().disableTriggerById(TENANT, disableReq);

        TriggerControllerApiDisableTriggerRequest enableReq =
                new TriggerControllerApiDisableTriggerRequest()
                        .namespace(ns)
                        .flowId(flowId)
                        .triggerId("schedule_trigger")
                        .disabled(false);
        ApiTriggerState result = api().disableTriggerById(TENANT, enableReq);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Bulk operations
    // ========================================================================

    @Test
    void disabledTriggersByQuery_basic() throws ApiException {
        ApiAsyncOperationResponse result = api().disabledTriggersByQuery(TENANT, true, null);

        assertThat(result).isNotNull();
    }

    @Test
    void unlockTriggersByQuery_basic() throws ApiException {
        ApiAsyncOperationResponse result = api().unlockTriggersByQuery(TENANT, null);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Export
    // ========================================================================

    @Test
    void exportTriggers_basic() throws ApiException {
        String result = api().exportTriggers(TENANT, null);

        assertThat(result).isNotNull();
    }
}
