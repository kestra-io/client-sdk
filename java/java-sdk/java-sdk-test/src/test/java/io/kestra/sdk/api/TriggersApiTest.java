package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.time.OffsetDateTime;
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

    static TriggerControllerApiTriggerId triggerId(String ns, String flowId) {
        return new TriggerControllerApiTriggerId()
                .namespace(ns)
                .flowId(flowId)
                .triggerId("schedule_trigger");
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
        assertThat(result.getDisabled()).isTrue();
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
        assertThat(result.getDisabled()).isFalse();
    }

    // ========================================================================
    // Bulk enable / disable
    // ========================================================================

    @Test
    void disabledTriggersByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        TriggerControllerSetDisabledRequest request = new TriggerControllerSetDisabledRequest()
                .triggers(List.of(triggerId(ns, flowId)))
                .disabled(true);

        ApiAsyncOperationResponse result = api().disabledTriggersByIds(TENANT, request);

        assertThat(result).isNotNull();
    }

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
    // Restart / Unlock
    // ========================================================================

    @Test
    void restartTrigger_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        assertThatCode(() -> api().restartTrigger(TENANT, ns, flowId, "schedule_trigger"))
                .doesNotThrowAnyException();
    }

    @Test
    void unlockTrigger_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        // Trigger is not locked, so this should throw 409. Verifies the endpoint is reachable.
        assertThatThrownBy(() -> api().unlockTrigger(TENANT, ns, flowId, "schedule_trigger"))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void unlockTriggersByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        List<TriggerControllerApiTriggerId> triggerIds = List.of(triggerId(ns, flowId));

        ApiAsyncOperationResponse result = api().unlockTriggersByIds(TENANT, triggerIds);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Delete
    // ========================================================================

    @Test
    void deleteTrigger_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        assertThatCode(() -> api().deleteTrigger(TENANT, ns, flowId, "schedule_trigger"))
                .doesNotThrowAnyException();
    }

    @Test
    void deleteTriggersByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        List<TriggerControllerApiTriggerId> triggerIds = List.of(triggerId(ns, flowId));

        ApiAsyncOperationResponse result = api().deleteTriggersByIds(TENANT, triggerIds);

        assertThat(result).isNotNull();
    }

    @Test
    void deleteTriggersByQuery_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        DeleteTriggersByQueryRequest request = new DeleteTriggersByQueryRequest()
                .filters(List.of(nsFilter(ns)));

        ApiAsyncOperationResponse result = api().deleteTriggersByQuery(TENANT, request);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Backfill
    // ========================================================================

    @Test
    void createBackfill_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(scheduleFlowYaml(flowId, ns));

        TriggerControllerApiCreateBackfillRequestBackfill backfill =
                new TriggerControllerApiCreateBackfillRequestBackfill()
                        .start(OffsetDateTime.now().minusDays(7))
                        .end(OffsetDateTime.now().minusDays(1));

        TriggerControllerApiCreateBackfillRequest request =
                new TriggerControllerApiCreateBackfillRequest()
                        .namespace(ns)
                        .flowId(flowId)
                        .triggerId("schedule_trigger")
                        .backfill(backfill);

        assertThatCode(() -> api().createBackfill(TENANT, request))
                .doesNotThrowAnyException();
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
