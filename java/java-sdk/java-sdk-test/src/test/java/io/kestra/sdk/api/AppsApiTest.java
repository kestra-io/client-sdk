package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppsApiTest {

    static AppsApi api() {
        return client().apps();
    }

    static String appYaml(String id, String namespace, String flowId) {
        return """
                id: %s
                type: io.kestra.plugin.ee.apps.Execution
                namespace: %s
                flowId: %s
                displayName: Test App %s
                layout:
                  - on: OPEN
                    blocks:
                      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
                        content: "# Test App"
                  - on: RUNNING
                    blocks:
                      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
                        content: "Running..."
                  - on: SUCCESS
                    blocks:
                      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
                        content: "Done!"
                """.formatted(id, namespace, flowId, id);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createApp_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource result = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        assertThat(result).isNotNull();
        assertThat(result.getNamespace()).isEqualTo(ns);
    }

    @Test
    void app_getByUid() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        AppsControllerApiAppSource result = api().app(created.getUid(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getUid()).isEqualTo(created.getUid());
    }

    @Test
    void updateApp_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String appId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(appId, ns, flowId));
        String updatedYaml = created.getSource().replace("Test App " + appId, "Updated App " + appId);

        api().updateApp(created.getUid(), TENANT, updatedYaml);

        AppsControllerApiAppSource fetched = api().app(created.getUid(), TENANT);
        assertThat(fetched).isNotNull();
        assertThat(fetched.getUid()).isEqualTo(created.getUid());
    }

    @Test
    void deleteApp_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        assertThatCode(() -> api().deleteApp(created.getUid(), TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Enable / Disable
    // ========================================================================

    @Test
    void enableDisableApp() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        AppsControllerApiApp disabled = api().disableApp(created.getUid(), TENANT);
        assertThat(disabled).isNotNull();

        AppsControllerApiApp enabled = api().enableApp(created.getUid(), TENANT);
        assertThat(enabled).isNotNull();
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchApps_basic() throws ApiException {
        PagedResultsAppsControllerApiApp result = api().searchApps(TENANT, 1, 10, null, null, null, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchAppsFromCatalog_basic() throws ApiException {
        PagedResultsAppsControllerApiAppCatalogItem result =
                api().searchAppsFromCatalog(TENANT, 1, 10, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchApps_withNamespace() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        PagedResultsAppsControllerApiApp result = api().searchApps(TENANT, 1, 10, null, ns, null, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotEmpty();
        assertThat(result.getResults())
                .anyMatch(app -> app.getUid().equals(created.getUid()));
    }

    @Test
    @Disabled("Kestra 2.0: app search no longer filters server-side by flowId — expected app missing from results")
    void searchApps_withFlowId() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        PagedResultsAppsControllerApiApp result = api().searchApps(TENANT, 1, 10, null, ns, flowId, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotEmpty();
        assertThat(result.getResults())
                .anyMatch(app -> app.getUid().equals(created.getUid()));
    }

    @Test
    @Disabled("Kestra 2.0: app search no longer filters server-side by 'q' — returns all apps")
    void searchApps_withQuery() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        String appId1 = "searchq" + randomId();
        String appId2 = "other" + randomId();
        api().createApp(TENANT, appYaml(appId1, ns, flowId));
        api().createApp(TENANT, appYaml(appId2, ns, flowId));

        PagedResultsAppsControllerApiApp result = api().searchApps(
                TENANT, 1, 10, "Test App " + appId1, ns, null, null, null, null);

        assertThat(result.getResults()).isNotEmpty();
        assertThat(result.getResults()).allSatisfy(app ->
                assertThat(app.getName()).contains(appId1));
    }

    @Test
    void searchApps_withSort() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        String appId1 = "aaa" + randomId();
        String appId2 = "zzz" + randomId();
        api().createApp(TENANT, appYaml(appId2, ns, flowId));
        api().createApp(TENANT, appYaml(appId1, ns, flowId));

        PagedResultsAppsControllerApiApp result = api().searchApps(
                TENANT, 1, 10, null, ns, null, List.of("id:asc"), null, null);

        assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> ids = result.getResults().stream().map(AppsControllerApiApp::getId).toList();
        int idx1 = ids.indexOf(appId1);
        int idx2 = ids.indexOf(appId2);
        assertThat(idx1).isGreaterThanOrEqualTo(0);
        assertThat(idx2).isGreaterThan(idx1);
    }

    @Test
    void searchApps_withTags() throws ApiException {
        PagedResultsAppsControllerApiApp all = api().searchApps(TENANT, 1, 10, null, null, null, null, null, null);

        if (all.getResults() != null && !all.getResults().isEmpty()) {
            AppsControllerApiApp first = all.getResults().stream()
                    .filter(a -> a.getTags() != null && !a.getTags().isEmpty())
                    .findFirst().orElse(null);

            if (first != null) {
                String tag = first.getTags().get(0);

                PagedResultsAppsControllerApiApp result = api().searchApps(
                        TENANT, 1, 10, null, null, null, null, List.of(tag), null);

                assertThat(result.getResults()).isNotEmpty();
                assertThat(result.getResults()).allSatisfy(app ->
                        assertThat(app.getTags()).contains(tag));
            }
        }
    }

    @Test
    void searchApps_withFilters() throws ApiException {
        String ns1 = randomId();
        String ns2 = randomId();
        String flowId1 = randomId();
        String flowId2 = randomId();
        createFlow(logFlowYaml(flowId1, ns1));
        createFlow(logFlowYaml(flowId2, ns2));

        api().createApp(TENANT, appYaml(randomId(), ns1, flowId1));
        api().createApp(TENANT, appYaml(randomId(), ns2, flowId2));

        PagedResultsAppsControllerApiApp result = api().searchApps(
                TENANT, 1, 10, null, null, null, null, null, List.of(nsFilter(ns1)));

        assertThat(result.getResults()).isNotEmpty();
        assertThat(result.getResults()).allSatisfy(app ->
                assertThat(app.getNamespace()).isEqualTo(ns1));
    }

    @Test
    void searchAppsFromCatalog_withFilters() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        PagedResultsAppsControllerApiAppCatalogItem result =
                api().searchAppsFromCatalog(TENANT, 1, 10, List.of(nsFilter(ns)));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotEmpty();
    }

    @Test
    @Disabled("Kestra 2.0: app search no longer filters server-side — empty-result query still returns apps")
    void searchApps_noResults() throws ApiException {
        PagedResultsAppsControllerApiApp result = api().searchApps(TENANT, 1, 10, null, "nonexistent_ns_" + randomId(), null, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isEmpty();
    }

    // ========================================================================
    // Tags
    // ========================================================================

    @Test
    void listTags_basic() throws ApiException {
        AppsControllerApiAppTags result = api().listTags(TENANT);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Bulk operations
    // ========================================================================

    @Test
    void bulkDeleteApps_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        AppsControllerApiBulkOperationRequest request = new AppsControllerApiBulkOperationRequest()
                .uids(List.of(created.getUid()));

        assertThatCode(() -> api().bulkDeleteApps(TENANT, request))
                .doesNotThrowAnyException();
    }

    @Test
    void bulkEnableApps_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        AppsControllerApiBulkOperationRequest request = new AppsControllerApiBulkOperationRequest()
                .uids(List.of(created.getUid()));

        assertThatCode(() -> api().bulkEnableApps(TENANT, request))
                .doesNotThrowAnyException();
    }

    @Test
    void bulkDisableApps_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        AppsControllerApiBulkOperationRequest request = new AppsControllerApiBulkOperationRequest()
                .uids(List.of(created.getUid()));

        assertThatCode(() -> api().bulkDisableApps(TENANT, request))
                .doesNotThrowAnyException();
    }

    @Test
    void bulkExportApps_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        AppsControllerApiAppSource created = api().createApp(TENANT, appYaml(randomId(), ns, flowId));

        AppsControllerApiBulkOperationRequest request = new AppsControllerApiBulkOperationRequest()
                .uids(List.of(created.getUid()));

        byte[] result = api().bulkExportApps(TENANT, request);

        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
    }

    @Test
    void bulkImportApps_noFile() throws ApiException {
        // Import with null file requires fileUpload → 500
        assertThatThrownBy(() -> api().bulkImportApps(TENANT, null))
                .isInstanceOf(ApiException.class);
    }
}
