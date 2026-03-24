package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.*;
import static org.assertj.core.api.Assertions.*;

public class BlueprintsApiTest {

    /**
     * Create a flow blueprint
     */
    @Test
    public void createFlowBlueprintTest() throws ApiException {
        String id = randomId();
        BlueprintControllerFlowBlueprintCreateOrUpdate body = getBlueprintCreateOrUpdate(id);

        BlueprintControllerApiFlowBlueprint response = kestraClient().blueprints().createFlowBlueprint(MAIN_TENANT, body);

        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo(id);
        assertThat(response.getDescription()).isEqualTo("Test blueprint " + id);
        assertThat(response.getId()).isNotNull();
    }

    /**
     * Get a flow blueprint
     */
    @Test
    public void flowBlueprintTest() throws ApiException {
        String id = randomId();
        BlueprintControllerApiFlowBlueprint created = kestraClient().blueprints().createFlowBlueprint(MAIN_TENANT, getBlueprintCreateOrUpdate(id));

        BlueprintControllerApiFlowBlueprint response = kestraClient().blueprints().flowBlueprint(created.getId(), MAIN_TENANT);

        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo(id);
    }

    /**
     * Get a flow blueprint by ID
     */
    @Test
    public void flowBlueprintByIdTest() throws ApiException {
        String id = randomId();
        BlueprintControllerApiFlowBlueprint created = kestraClient().blueprints().createFlowBlueprint(MAIN_TENANT, getBlueprintCreateOrUpdate(id));

        BlueprintControllerApiFlowBlueprint response = kestraClient().blueprints().flowBlueprintById(created.getId(), MAIN_TENANT);

        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo(id);
    }

    /**
     * Update a flow blueprint
     */
    @Test
    public void updateFlowBlueprintTest() throws ApiException {
        String id = randomId();
        BlueprintControllerApiFlowBlueprint created = kestraClient().blueprints().createFlowBlueprint(MAIN_TENANT, getBlueprintCreateOrUpdate(id));

        BlueprintControllerFlowBlueprintCreateOrUpdate update = getBlueprintCreateOrUpdate(id)
                .description("Updated description");

        BlueprintControllerApiFlowBlueprint response = kestraClient().blueprints().updateFlowBlueprint(created.getId(), MAIN_TENANT, update);

        assertThat(response).isNotNull();
        assertThat(response.getDescription()).isEqualTo("Updated description");

        BlueprintControllerApiFlowBlueprint fetched = kestraClient().blueprints().flowBlueprintById(created.getId(), MAIN_TENANT);
        assertThat(fetched.getDescription()).isEqualTo("Updated description");
        assertThat(fetched.getTitle()).isEqualTo(id);
    }

    /**
     * Delete a flow blueprint
     */
    @Test
    public void deleteFlowBlueprintTest() throws ApiException {
        String id = randomId();
        BlueprintControllerApiFlowBlueprint created = kestraClient().blueprints().createFlowBlueprint(MAIN_TENANT, getBlueprintCreateOrUpdate(id));

        kestraClient().blueprints().deleteFlowBlueprints(created.getId(), MAIN_TENANT);

        assertThatThrownBy(() -> kestraClient().blueprints().flowBlueprint(created.getId(), MAIN_TENANT))
                .isInstanceOf(ApiException.class);
    }

    /**
     * Search internal blueprints
     */
    @Test
    public void searchInternalBlueprintsTest() throws ApiException {
        String id = randomId();
        BlueprintControllerApiBlueprintItemWithSource internalBlueprint = new BlueprintControllerApiBlueprintItemWithSource()
                .title(id)
                .description("Internal blueprint " + id)
                .source(getFlowSource());
        kestraClient().blueprints().createInternalBlueprints(MAIN_TENANT, internalBlueprint);

        PagedResultsBlueprint response = kestraClient().blueprints().searchInternalBlueprints(1, 100, MAIN_TENANT, id, null, null);

        assertThat(response).isNotNull();
        assertThat(response.getResults()).isNotEmpty();
        assertThat(response.getResults().stream().map(Blueprint::getTitle)).contains(id);
    }

    /**
     * Search community blueprints
     */
    @Test
    public void searchBlueprintsTest() throws ApiException {
        PagedResultsBlueprintControllerApiBlueprintItem response = kestraClient().blueprints().searchBlueprints(1, 10, BlueprintControllerKind.FLOW, MAIN_TENANT, null, null, null);

        assertThat(response).isNotNull();
        assertThat(response.getResults()).isNotNull();
        assertThat(response.getTotal()).isNotNull();
    }

    private static String getFlowSource() {
        String flowId = randomId();
        String namespace = randomId();
        return String.format("""
            id: %s
            namespace: %s
            tasks:
              - id: my_task
                type: io.kestra.plugin.core.log.Log
                message: Hello from blueprint
            """, flowId, namespace);
    }

    private static BlueprintControllerFlowBlueprintCreateOrUpdate getBlueprintCreateOrUpdate(String title) {
        return new BlueprintControllerFlowBlueprintCreateOrUpdate()
                .title(title)
                .source(getFlowSource())
                .description("Test blueprint " + title)
                .tags(List.of("test"));
    }
}
