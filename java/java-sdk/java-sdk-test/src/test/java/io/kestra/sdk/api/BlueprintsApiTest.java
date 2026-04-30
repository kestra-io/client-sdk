package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlueprintsApiTest {

    static BlueprintsApi api() {
        return client().blueprints();
    }

    // ========================================================================
    // Community Blueprints
    // ========================================================================

    @Test
    void searchBlueprints_flow() throws ApiException {
        PagedResultsBlueprintControllerApiBlueprintItem result =
                api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, null, null, null, 1, 5);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchBlueprints_withQuery() throws ApiException {
        PagedResultsBlueprintControllerApiBlueprintItem result =
                api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, "hello", null, null, 1, 5);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Flow Blueprints
    // ========================================================================

    @Test
    void createFlowBlueprint_basic() throws ApiException {
        BlueprintControllerFlowBlueprintCreateOrUpdate request =
                new BlueprintControllerFlowBlueprintCreateOrUpdate()
                        .title("test-bp-" + randomId())
                        .source(logFlowYaml(randomId(), randomId()))
                        .description("Test blueprint");

        BlueprintControllerApiFlowBlueprint result = api().createFlowBlueprint(TENANT, request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void flowBlueprintById_basic() throws ApiException {
        BlueprintControllerFlowBlueprintCreateOrUpdate request =
                new BlueprintControllerFlowBlueprintCreateOrUpdate()
                        .title("get-bp-" + randomId())
                        .source(logFlowYaml(randomId(), randomId()));

        BlueprintControllerApiFlowBlueprint created = api().createFlowBlueprint(TENANT, request);

        BlueprintControllerApiFlowBlueprint result = api().flowBlueprintById(created.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
    }

    @Test
    void updateFlowBlueprint_basic() throws ApiException {
        BlueprintControllerFlowBlueprintCreateOrUpdate request =
                new BlueprintControllerFlowBlueprintCreateOrUpdate()
                        .title("update-bp-" + randomId())
                        .source(logFlowYaml(randomId(), randomId()));

        BlueprintControllerApiFlowBlueprint created = api().createFlowBlueprint(TENANT, request);

        String newTitle = "updated-bp-" + randomId();
        BlueprintControllerFlowBlueprintCreateOrUpdate update =
                new BlueprintControllerFlowBlueprintCreateOrUpdate()
                        .title(newTitle)
                        .source(logFlowYaml(randomId(), randomId()));

        BlueprintControllerApiFlowBlueprint updated = api().updateFlowBlueprint(created.getId(), TENANT, update);

        assertThat(updated.getTitle()).isEqualTo(newTitle);
    }

    @Test
    void deleteFlowBlueprints_basic() throws ApiException {
        BlueprintControllerFlowBlueprintCreateOrUpdate request =
                new BlueprintControllerFlowBlueprintCreateOrUpdate()
                        .title("delete-bp-" + randomId())
                        .source(logFlowYaml(randomId(), randomId()));

        BlueprintControllerApiFlowBlueprint created = api().createFlowBlueprint(TENANT, request);

        assertThatCode(() -> api().deleteFlowBlueprints(created.getId(), TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Internal/Custom Blueprints
    // ========================================================================

    @Test
    void searchInternalBlueprints_basic() throws ApiException {
        PagedResultsBlueprint result = api().searchInternalBlueprints(TENANT, null, null, null, 1, 10, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }
}
