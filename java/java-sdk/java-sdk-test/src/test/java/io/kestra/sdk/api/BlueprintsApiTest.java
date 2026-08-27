package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

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
                api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, null, 1, 5, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchBlueprints_withQuery() throws ApiException {
        PagedResultsBlueprintControllerApiBlueprintItem result =
                api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, null, 1, 5, List.of(queryFilter("hello")));

        assertThat(result).isNotNull();
    }

    @Test
    void searchBlueprints_withTags() throws ApiException {
        PagedResultsBlueprintControllerApiBlueprintItem allResults =
                api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, null, 1, 1, null);

        if (allResults.getResults() != null && !allResults.getResults().isEmpty()
                && allResults.getResults().get(0).getTags() != null
                && !allResults.getResults().get(0).getTags().isEmpty()) {
            String tag = allResults.getResults().get(0).getTags().get(0);

            PagedResultsBlueprintControllerApiBlueprintItem result =
                    api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, null, 1, 10, List.of(tagsFilter(List.of(tag))));

            assertThat(result.getResults()).isNotEmpty();
            assertThat(result.getResults()).allSatisfy(bp ->
                    assertThat(bp.getTags()).contains(tag));
        }
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
    void searchInternalBlueprints_withSort() throws ApiException {
        String title1 = "aaa-bp-" + randomId();
        String title2 = "zzz-bp-" + randomId();
        api().createFlowBlueprint(TENANT, new BlueprintControllerFlowBlueprintCreateOrUpdate()
                .title(title2).source(logFlowYaml(randomId(), randomId())));
        api().createFlowBlueprint(TENANT, new BlueprintControllerFlowBlueprintCreateOrUpdate()
                .title(title1).source(logFlowYaml(randomId(), randomId())));

        PagedResultsBlueprint result = api().searchInternalBlueprints(TENANT, "title:asc", 1, 100, null, null);

        assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> titles = result.getResults().stream().map(Blueprint::getTitle).toList();
        int idx1 = titles.indexOf(title1);
        int idx2 = titles.indexOf(title2);
        assertThat(idx1).isGreaterThanOrEqualTo(0);
        assertThat(idx2).isGreaterThan(idx1);
    }

    @Test
    @Disabled("Kestra 2.0: blueprint search no longer filters server-side by tags — returns unrelated blueprints")
    void searchInternalBlueprints_withTags() throws ApiException {
        String tag = "sdktest" + randomId().substring(0, 8);
        api().createFlowBlueprint(TENANT, new BlueprintControllerFlowBlueprintCreateOrUpdate()
                .title("tagged-bp-" + randomId())
                .source(logFlowYaml(randomId(), randomId()))
                .tags(List.of(tag)));
        api().createFlowBlueprint(TENANT, new BlueprintControllerFlowBlueprintCreateOrUpdate()
                .title("untagged-bp-" + randomId())
                .source(logFlowYaml(randomId(), randomId())));

        PagedResultsBlueprint result = api().searchInternalBlueprints(TENANT, null, 1, 10, null, List.of(tagsFilter(List.of(tag))));

        assertThat(result.getResults()).isNotEmpty();
        assertThat(result.getResults()).allSatisfy(bp ->
                assertThat(bp.getTags()).contains(tag));
    }

    @Test
    void searchInternalBlueprints_withSource() throws ApiException {
        api().createFlowBlueprint(TENANT, new BlueprintControllerFlowBlueprintCreateOrUpdate()
                .title("source-bp-" + randomId())
                .source(logFlowYaml(randomId(), randomId())));

        PagedResultsBlueprint result = api().searchInternalBlueprints(TENANT, null, 1, 10, true, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchInternalBlueprints_basic() throws ApiException {
        BlueprintControllerFlowBlueprintCreateOrUpdate request =
                new BlueprintControllerFlowBlueprintCreateOrUpdate()
                        .title("internal-bp-" + randomId())
                        .source(logFlowYaml(randomId(), randomId()))
                        .description("Internal blueprint for search test");

        BlueprintControllerApiFlowBlueprint created = api().createFlowBlueprint(TENANT, request);

        PagedResultsBlueprint result = api().searchInternalBlueprints(TENANT, null, 1, 10, null, List.of(queryFilter(created.getTitle())));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    // ========================================================================
    // Community blueprint details
    // ========================================================================

    @Test
    void blueprint_basic() throws ApiException {
        PagedResultsBlueprintControllerApiBlueprintItem search =
                api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, null, 1, 1, null);

        if (search.getResults() != null && !search.getResults().isEmpty()) {
            String bpId = search.getResults().get(0).getId();

            BlueprintControllerApiBlueprintItemWithSource result =
                    api().blueprint(bpId, BlueprintControllerKind.FLOW, TENANT);

            assertThat(result).isNotNull();
            assertThat(result.getId()).isEqualTo(bpId);
        }
    }

    @Test
    void blueprintGraph_basic() throws ApiException {
        PagedResultsBlueprintControllerApiBlueprintItem search =
                api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, null, 1, 1, null);

        if (search.getResults() != null && !search.getResults().isEmpty()) {
            String bpId = search.getResults().get(0).getId();

            java.util.Map<String, Object> result =
                    api().blueprintGraph(bpId, BlueprintControllerKind.FLOW, TENANT);

            assertThat(result).isNotNull();
        }
    }

    @Test
    void blueprintSource_basic() throws ApiException {
        PagedResultsBlueprintControllerApiBlueprintItem search =
                api().searchBlueprints(BlueprintControllerKind.FLOW, TENANT, null, 1, 1, null);

        if (search.getResults() != null && !search.getResults().isEmpty()) {
            String bpId = search.getResults().get(0).getId();

            String result = api().blueprintSource(bpId, BlueprintControllerKind.FLOW, TENANT);

            assertThat(result).isNotNull().isNotBlank();
        }
    }

    // ========================================================================
    // Use template
    // ========================================================================

    @Test
    void useBlueprintTemplate_notTemplate() throws ApiException {
        BlueprintControllerFlowBlueprintCreateOrUpdate request =
                new BlueprintControllerFlowBlueprintCreateOrUpdate()
                        .title("use-tpl-" + randomId())
                        .source(logFlowYaml(randomId(), randomId()));

        BlueprintControllerApiFlowBlueprint created = api().createFlowBlueprint(TENANT, request);

        BlueprintControllerUseBlueprintTemplateRequest useRequest =
                new BlueprintControllerUseBlueprintTemplateRequest();

        // Non-template blueprints can't be used as templates → 422
        assertThatThrownBy(() -> api().useBlueprintTemplate(created.getId(), TENANT, useRequest))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // flowBlueprint (singular path)
    // ========================================================================

    @Test
    void flowBlueprint_basic() throws ApiException {
        BlueprintControllerFlowBlueprintCreateOrUpdate request =
                new BlueprintControllerFlowBlueprintCreateOrUpdate()
                        .title("flow-bp-" + randomId())
                        .source(logFlowYaml(randomId(), randomId()));

        BlueprintControllerApiFlowBlueprint created = api().createFlowBlueprint(TENANT, request);

        BlueprintControllerApiFlowBlueprint result = api().flowBlueprint(created.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
    }
}
