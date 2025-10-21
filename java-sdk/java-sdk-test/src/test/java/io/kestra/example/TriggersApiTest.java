package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.DeleteExecutionsByQueryRequest;
import io.kestra.sdk.model.PagedResultsTrigger;
import io.kestra.sdk.model.PagedResultsTriggerControllerTriggers;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.Trigger;
import io.kestra.sdk.model.TriggerControllerSetDisabledRequest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.kestraClient;

public class TriggersApiTest {


    /**
     * Delete a backfill
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteBackfillTest() throws ApiException {
        String tenant = null;
        Trigger trigger = null;
        Trigger response = kestraClient().triggers().deleteBackfill(tenant, trigger);

        // TODO: test validations
    }
    /**
     * Delete backfill for given triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteBackfillByIdsTest() throws ApiException {
        String tenant = null;
        List<Trigger> trigger = null;
        Object response = kestraClient().triggers().deleteBackfillByIds(tenant, trigger);

        // TODO: test validations
    }
    /**
     * Delete backfill for given triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteBackfillByQueryTest() throws ApiException {
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = null;
        Object response = kestraClient().triggers().deleteBackfillByQuery(tenant, deleteExecutionsByQueryRequest, q, namespace);

        // TODO: test validations
    }
    /**
     * Disable/enable given triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void disabledTriggersByIdsTest() throws ApiException {
        String tenant = null;
        TriggerControllerSetDisabledRequest triggerControllerSetDisabledRequest = null;
        Object response = kestraClient().triggers().disabledTriggersByIds(tenant, triggerControllerSetDisabledRequest);

        // TODO: test validations
    }
    /**
     * Disable/enable triggers by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void disabledTriggersByQueryTest() throws ApiException {
        Boolean disabled = null;
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = null;
        Object response = kestraClient().triggers().disabledTriggersByQuery(disabled, tenant, deleteExecutionsByQueryRequest, q, namespace);

        // TODO: test validations
    }
    /**
     * Pause a backfill
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pauseBackfillTest() throws ApiException {
        String tenant = null;
        Trigger trigger = null;
        Trigger response = kestraClient().triggers().pauseBackfill(tenant, trigger);

        // TODO: test validations
    }
    /**
     * Pause backfill for given triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pauseBackfillByIdsTest() throws ApiException {
        String tenant = null;
        List<Trigger> trigger = null;
        Object response = kestraClient().triggers().pauseBackfillByIds(tenant, trigger);

        // TODO: test validations
    }
    /**
     * Pause backfill for given triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pauseBackfillByQueryTest() throws ApiException {
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = null;
        Object response = kestraClient().triggers().pauseBackfillByQuery(tenant, deleteExecutionsByQueryRequest, q, namespace);

        // TODO: test validations
    }
    /**
     * Restart a trigger
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartTriggerTest() throws ApiException {
        String namespace = null;
        String flowId = null;
        String triggerId = null;
        String tenant = null;
        Object response = kestraClient().triggers().restartTrigger(namespace, flowId, triggerId, tenant);

        // TODO: test validations
    }
    /**
     * Search for triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchTriggersTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        String tenant = null;
        List<String> sort = null;
        List<QueryFilter> filters = null;
        String q = null;
        String namespace = null;
        String workerId = null;
        String flowId = null;
        PagedResultsTriggerControllerTriggers response = kestraClient().triggers().searchTriggers(page, size, tenant, sort, filters, q, namespace, workerId, flowId);

        // TODO: test validations
    }
    /**
     * Get all triggers for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchTriggersForFlowTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        String namespace = null;
        String flowId = null;
        String tenant = null;
        List<String> sort = null;
        String q = null;
        PagedResultsTrigger response = kestraClient().triggers().searchTriggersForFlow(page, size, namespace, flowId, tenant, sort, q);

        // TODO: test validations
    }
    /**
     * Unlock a trigger
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unlockTriggerTest() throws ApiException {
        String namespace = null;
        String flowId = null;
        String triggerId = null;
        String tenant = null;
        Trigger response = kestraClient().triggers().unlockTrigger(namespace, flowId, triggerId, tenant);

        // TODO: test validations
    }
    /**
     * Unlock given triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unlockTriggersByIdsTest() throws ApiException {
        String tenant = null;
        List<Trigger> trigger = null;
        Object response = kestraClient().triggers().unlockTriggersByIds(tenant, trigger);

        // TODO: test validations
    }
    /**
     * Unlock triggers by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unlockTriggersByQueryTest() throws ApiException {
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = null;
        Object response = kestraClient().triggers().unlockTriggersByQuery(tenant, deleteExecutionsByQueryRequest, q, namespace);

        // TODO: test validations
    }
    /**
     * Unpause a backfill
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unpauseBackfillTest() throws ApiException {
        String tenant = null;
        Trigger trigger = null;
        Trigger response = kestraClient().triggers().unpauseBackfill(tenant, trigger);

        // TODO: test validations
    }
    /**
     * Unpause backfill for given triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unpauseBackfillByIdsTest() throws ApiException {
        String tenant = null;
        List<Trigger> trigger = null;
        Object response = kestraClient().triggers().unpauseBackfillByIds(tenant, trigger);

        // TODO: test validations
    }
    /**
     * Unpause backfill for given triggers
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unpauseBackfillByQueryTest() throws ApiException {
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = null;
        Object response = kestraClient().triggers().unpauseBackfillByQuery(tenant, deleteExecutionsByQueryRequest, q, namespace);

        // TODO: test validations
    }
    /**
     * Update a trigger
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateTriggerTest() throws ApiException {
        String tenant = null;
        Trigger trigger = null;
        Trigger response = kestraClient().triggers().updateTrigger(tenant, trigger);

        // TODO: test validations
    }
}
