package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static io.kestra.example.CommonTestSetup.MAIN_TENANT;
import static io.kestra.example.CommonTestSetup.kestraClient;
import static io.kestra.example.CommonTestSetup.randomId;
import static org.junit.jupiter.api.Assertions.*;

public class TriggersApiTest {

    // --- helpers -------------------------------------------------------------

    /** Create a flow via YAML with a single scheduled trigger; returns [flowId, triggerId]. */
    private void createFlowWithTrigger(String flowId, String triggerId, String namespace) throws ApiException {

        String body = ""
            + "id: " + flowId + "\n"
            + "namespace: " + namespace + "\n"
            + "\n"
            + "tasks:\n"
            + "  - id: hello\n"
            + "    type: io.kestra.plugin.core.flow.Sleep\n"
            + "    duration: PT5S\n"
            + "\n"
            + "triggers:\n"
            + "  - id: " + triggerId + "\n"
            + "    type: io.kestra.plugin.core.trigger.Schedule\n"
            + "    cron: \"*/5 * * * *\"\n";

        kestraClient().flows().createFlow(MAIN_TENANT, body);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** Attach a backfill to a trigger by calling updateTrigger; returns updated Trigger. */
    private Trigger createBackfillForTrigger(String flowId, String triggerId, String namespace) throws ApiException {
        OffsetDateTime nowIso = OffsetDateTime.now(ZoneOffset.UTC);
        OffsetDateTime startIso = OffsetDateTime.now(ZoneOffset.UTC).minusHours(5);

        Backfill backfill = new Backfill()
            .start(startIso)
            .end(null);

        Trigger trigger = new Trigger()
            .namespace(namespace)
            .flowId(flowId)
            .triggerId(triggerId)
            .date(nowIso)
            .backfill(backfill)
            .tenantId(MAIN_TENANT);

        return kestraClient().triggers().updateTrigger(MAIN_TENANT, trigger);
    }

    private Trigger triggerRef(String namespace, String flowId, String triggerId) {
        return new Trigger()
            .namespace(namespace)
            .flowId(flowId)
            .triggerId(triggerId)
            .date(OffsetDateTime.now(ZoneOffset.UTC))
            .tenantId(MAIN_TENANT);
    }

    // --- tests --------------------------------------------------------------

    @Test
    public void deleteBackfillTest() throws ApiException, InterruptedException {
        String flowId = "deleteBackfillTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);
        // ensure trigger exists
        Thread.sleep(1000);
        createBackfillForTrigger(flowId, triggerId, namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        Trigger resp = kestraClient().triggers().deleteBackfill(MAIN_TENANT, t);
        assertNotNull(resp);
    }

    @Test
    public void deleteBackfillByIdsTest() throws ApiException {
        String flowId = "deleteBackfillByIdsTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, flowId + "_trigger", namespace);
        createBackfillForTrigger(flowId, triggerId, namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        Object resp = kestraClient().triggers().deleteBackfillByIds(MAIN_TENANT, List.of(t));
        assertNotNull(resp);
    }

    @Test
    public void deleteBackfillByQueryTest() throws ApiException {
        String flowId = "deleteBackfillByQueryTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);
        createBackfillForTrigger(flowId, triggerId, namespace);

        QueryFilter qf = new QueryFilter()
            .field(QueryFilterField.TRIGGER_ID)
            .operation(QueryFilterOp.CONTAINS)
            .value(flowId);

        Object resp = kestraClient().triggers().deleteBackfillByQuery(MAIN_TENANT, List.of(qf), null);
        assertNotNull(resp);
    }

    @Test
    public void disabledTriggersByIdsTest() throws ApiException {
        String flowId = "disabledTriggersByIdsTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, flowId + "_trigger", namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        TriggerControllerSetDisabledRequest req = new TriggerControllerSetDisabledRequest()
            .triggers(List.of(t))
            .disabled(true);

        Object resp = kestraClient().triggers().disabledTriggersByIds(MAIN_TENANT, req);
        assertNotNull(resp);
    }

    @Test
    public void disabledTriggersByQueryTest() throws ApiException {
        String flowId = "disabledTriggersByQueryTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        QueryFilter qf = new QueryFilter()
            .field(QueryFilterField.TRIGGER_ID)
            .operation(QueryFilterOp.CONTAINS)
            .value(flowId);

        Object resp = kestraClient().triggers().disabledTriggersByQuery(true, MAIN_TENANT, List.of(qf), null);
        assertNotNull(resp);
    }

    @Test
    public void pauseBackfillTest() throws ApiException {
        String flowId = "pauseBackfillTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);
        createBackfillForTrigger(flowId, triggerId, namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        Trigger resp = kestraClient().triggers().pauseBackfill(MAIN_TENANT, t);
        assertNotNull(resp);
    }

    @Test
    public void pauseBackfillByIdsTest() throws ApiException {
        String flowId = "pauseBackfillByIdsTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);
        createBackfillForTrigger(flowId, triggerId, namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        Object resp = kestraClient().triggers().pauseBackfillByIds(MAIN_TENANT, List.of(t));
        assertNotNull(resp);
    }

    @Test
    public void pauseBackfillByQueryTest() throws ApiException {
        String flowId = "pauseBackfillByQueryTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        QueryFilter qf = new QueryFilter()
            .field(QueryFilterField.TRIGGER_ID)
            .operation(QueryFilterOp.CONTAINS)
            .value(flowId);

        Object resp = kestraClient().triggers().pauseBackfillByQuery(MAIN_TENANT, List.of(qf), null);
        assertNotNull(resp);
    }

    @Test
    public void restartTriggerTest() throws ApiException {
        String flowId = "restartTriggerTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        Object resp = kestraClient().triggers().restartTrigger(namespace, flowId, triggerId, MAIN_TENANT);
        assertNotNull(resp);
    }

    @Test
    public void searchTriggersTest() throws ApiException {
        String flowId = "searchTriggersTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);
        var filters = List.of(new QueryFilter().field(QueryFilterField.NAMESPACE).operation(QueryFilterOp.EQUALS).value(namespace));

        PagedResultsTriggerControllerTriggers page =
            kestraClient().triggers().searchTriggers(1, 10, MAIN_TENANT, null, filters);

        assertNotNull(page);
    }

    @Test
    public void searchTriggersForFlowTest() throws ApiException {
        String flowId = "searchTriggersForFlowTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        PagedResultsTrigger page =
            kestraClient().triggers().searchTriggersForFlow(1, 10, namespace, flowId, MAIN_TENANT, null, null);

        assertNotNull(page);
    }

    @Test
    public void unlockTriggerTest() throws ApiException {
        String flowId = "unlockTriggerTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        ApiException ex = assertThrows(ApiException.class, () ->
            kestraClient().triggers().unlockTrigger(namespace, flowId, triggerId, MAIN_TENANT));

        // Expecting 409 if not locked
        Integer code = ex.getCode(); // if available
        assertEquals(409, code);
    }

    @Test
    public void unlockTriggersByIdsTest() throws ApiException {
        String flowId = "unlockTriggersByIdsTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        Object resp = kestraClient().triggers().unlockTriggersByIds(MAIN_TENANT, List.of(t));
        assertNotNull(resp);
    }

    @Test
    public void unlockTriggersByQueryTest() throws ApiException {
        String flowId = "unlockTriggersByQueryTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        Object resp = kestraClient().triggers().unlockTriggersByQuery(MAIN_TENANT, List.of(), null);
        assertNotNull(resp);
    }

    @Test
    public void unpauseBackfillTest() throws ApiException {
        String flowId = "unpauseBackfillTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);
        createBackfillForTrigger(flowId, triggerId, namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        Trigger resp = kestraClient().triggers().unpauseBackfill(MAIN_TENANT, t);
        assertNotNull(resp);
    }

    @Test
    public void unpauseBackfillByIdsTest() throws ApiException {
        String flowId = "unpauseBackfillByIdsTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);
        createBackfillForTrigger(flowId, triggerId, namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        Object resp = kestraClient().triggers().unpauseBackfillByIds(MAIN_TENANT, List.of(t));
        assertNotNull(resp);
    }

    @Test
    public void unpauseBackfillByQueryTest() throws ApiException {
        String flowId = "unpauseBackfillByQueryTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        Object resp = kestraClient().triggers().unpauseBackfillByQuery(MAIN_TENANT, List.of(), null);
        assertNotNull(resp);
    }

    @Test
    public void updateTriggerTest() throws ApiException {
        String flowId = "updateTriggerTest_" + randomId();
        String triggerId = flowId + "_trigger";
        String namespace = "test.triggers." + randomId();
        createFlowWithTrigger(flowId, triggerId, namespace);

        Trigger t = triggerRef(namespace, flowId, triggerId);
        Trigger resp = kestraClient().triggers().updateTrigger(MAIN_TENANT, t);
        assertNotNull(resp);
    }
}
