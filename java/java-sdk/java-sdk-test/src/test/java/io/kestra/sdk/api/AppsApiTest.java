package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

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

    // ========================================================================
    // Tags
    // ========================================================================

    @Test
    void listTags_basic() throws ApiException {
        AppsControllerApiAppTags result = api().listTags(TENANT);

        assertThat(result).isNotNull();
    }
}
