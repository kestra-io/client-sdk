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

import static io.kestra.example.CommonTestSetup.*;

public class TriggersApiTest {


    /**
     * Delete a backfill
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteBackfillTest() throws ApiException {

        Trigger trigger = null;
        Trigger response = kestraClient().triggers().deleteBackfill(MAIN_TENANT, trigger);

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

        List<Trigger> trigger = null;
        Object response = kestraClient().triggers().deleteBackfillByIds(MAIN_TENANT, trigger);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = randomId();
        Object response = kestraClient().triggers().deleteBackfillByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, namespace);

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

        TriggerControllerSetDisabledRequest triggerControllerSetDisabledRequest = null;
        Object response = kestraClient().triggers().disabledTriggersByIds(MAIN_TENANT, triggerControllerSetDisabledRequest);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = randomId();
        Object response = kestraClient().triggers().disabledTriggersByQuery(disabled, MAIN_TENANT, deleteExecutionsByQueryRequest, q, namespace);

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

        Trigger trigger = null;
        Trigger response = kestraClient().triggers().pauseBackfill(MAIN_TENANT, trigger);

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

        List<Trigger> trigger = null;
        Object response = kestraClient().triggers().pauseBackfillByIds(MAIN_TENANT, trigger);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = randomId();
        Object response = kestraClient().triggers().pauseBackfillByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, namespace);

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
        String namespace = randomId();
        String flowId = null;
        String triggerId = null;

        Object response = kestraClient().triggers().restartTrigger(namespace, flowId, triggerId, MAIN_TENANT);

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

        List<String> sort = null;
        List<QueryFilter> filters = null;
        String q = null;
        String namespace = randomId();
        String workerId = null;
        String flowId = null;
        PagedResultsTriggerControllerTriggers response = kestraClient().triggers().searchTriggers(page, size, MAIN_TENANT, sort, filters, q, namespace, workerId, flowId);

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
        String namespace = randomId();
        String flowId = null;

        List<String> sort = null;
        String q = null;
        PagedResultsTrigger response = kestraClient().triggers().searchTriggersForFlow(page, size, namespace, flowId, MAIN_TENANT, sort, q);

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
        String namespace = randomId();
        String flowId = null;
        String triggerId = null;

        Trigger response = kestraClient().triggers().unlockTrigger(namespace, flowId, triggerId, MAIN_TENANT);

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

        List<Trigger> trigger = null;
        Object response = kestraClient().triggers().unlockTriggersByIds(MAIN_TENANT, trigger);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = randomId();
        Object response = kestraClient().triggers().unlockTriggersByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, namespace);

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

        Trigger trigger = null;
        Trigger response = kestraClient().triggers().unpauseBackfill(MAIN_TENANT, trigger);

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

        List<Trigger> trigger = null;
        Object response = kestraClient().triggers().unpauseBackfillByIds(MAIN_TENANT, trigger);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        String namespace = randomId();
        Object response = kestraClient().triggers().unpauseBackfillByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, namespace);

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

        Trigger trigger = null;
        Trigger response = kestraClient().triggers().updateTrigger(MAIN_TENANT, trigger);

        // TODO: test validations
    }
}
