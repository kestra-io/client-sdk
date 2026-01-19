package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static io.kestra.example.CommonTestSetup.*;
import static org.assertj.core.api.Assertions.*;

public class AppsApiTest {

    /**
     * Retrieve an app
     */
    @Test
    public void appTest() throws ApiException {
        String appId = "request_data_form";
        var flowBody = getSimpleFlowForApp(appId);
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, flowBody);

        String appYaml = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, appYaml);

        var response = kestraClient().apps().app(app.getUid(), MAIN_TENANT);

        assertThat(response).isNotNull();
    }

    /**
     * Delete existing apps (bulk)
     */
    @Test
    public void bulkDeleteAppsTest() throws ApiException {
        String appId = "bulkDeleteAppsTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        String appYaml = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, appYaml);

        AppsControllerApiBulkOperationRequest req = new AppsControllerApiBulkOperationRequest()
                .addUidsItem(app.getUid());

        Object response = kestraClient().apps().bulkDeleteApps(MAIN_TENANT, req);

        assertThat(response).isNotNull();
    }

    /**
     * Disable existing apps (bulk)
     */
    @Test
    public void bulkDisableAppsTest() throws ApiException {
        String appId = "bulkDisableAppsTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        String appYaml = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, appYaml);

        AppsControllerApiBulkOperationRequest req = new AppsControllerApiBulkOperationRequest()
                .addUidsItem(app.getUid());

        Object response = kestraClient().apps().bulkDisableApps(MAIN_TENANT, req);

        assertThat(response).isNotNull();
    }

    /**
     * Enable existing apps (bulk)
     */
    @Test
    public void bulkEnableAppsTest() throws ApiException {
        String appId = "bulkEnableAppsTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        String appYaml = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, appYaml);

        AppsControllerApiBulkOperationRequest req = new AppsControllerApiBulkOperationRequest()
                .addUidsItem(app.getUid());

        Object response = kestraClient().apps().bulkEnableApps(MAIN_TENANT, req);

        assertThat(response).isNotNull();
    }

    /**
     * Export apps as a ZIP archive of YAML sources.
     */
    @Test
    public void bulkExportAppsTest() throws ApiException {
        String appId = "bulkExportAppsTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        String appYaml = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, appYaml);

        AppsControllerApiBulkOperationRequest req = new AppsControllerApiBulkOperationRequest()
                .addUidsItem(app.getUid());

        byte[] response = kestraClient().apps().bulkExportApps(MAIN_TENANT, req);

        assertThat(response).isNotNull();
    }

    /**
     * Import apps as a ZIP archive or multi-object YAML
     */
    @Test
    public void bulkImportAppsTest() throws ApiException, IOException {
        String app1Id = "import_app_one";
        var flow1 = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(app1Id));
        String app1 = getAppSource(app1Id, flow1.getNamespace(), flow1.getId());

        String app2Id = "import_app_two";
        var flow2 = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(app2Id));
        String app2 = getAppSource(app2Id, flow2.getNamespace(), flow2.getId());

        String fileContent = app1 + "\n---\n" + app2;

        File tmpFile = File.createTempFile("apps", ".yaml");
        Files.writeString(tmpFile.toPath(), fileContent, StandardOpenOption.WRITE);

        AppsControllerApiBulkImportResponse response = kestraClient().apps().bulkImportApps(MAIN_TENANT, tmpFile);

        assertThat(response).isNotNull();
    }

    /**
     * Create a new app
     */
    @Test
    public void createAppTest() throws ApiException {
        String appId = "createAppTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        String body = getAppSource(appId, flow.getNamespace(), flow.getId());

        var response = kestraClient().apps().createApp(MAIN_TENANT, body);

        assertThat(response).isNotNull();
    }

    /**
     * Delete an existing app
     */
    @Test
    public void deleteAppTest() throws ApiException {
        String appId = "deleteAppTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        String body = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, body);

        Object response = kestraClient().apps().deleteApp(app.getUid(), MAIN_TENANT);

        assertThatThrownBy(() -> kestraClient().apps().app(appId, MAIN_TENANT))
                .isInstanceOf(ApiException.class)
                .hasMessageContaining("Not Found");
    }

    /**
     * Disable the app.
     */
    @Test
    public void disableAppTest() throws ApiException {
        String appId = "disableAppTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        String body = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, body);

        AppsControllerApiApp response = kestraClient().apps().disableApp(app.getUid(), MAIN_TENANT);

        assertThat(response).isNotNull();
    }

    /**
     * Enable the app.
     */
    @Test
    public void enableAppTest() throws ApiException {
        String appId = "enableAppTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        String body = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, body);

        AppsControllerApiApp response = kestraClient().apps().enableApp(app.getUid(), MAIN_TENANT);

        assertThat(response).isNotNull();
    }

    /**
     * Get all the app tags
     */
    @Test
    public void listTagsTest() throws ApiException {
        AppsControllerApiAppTags response = kestraClient().apps().listTags(MAIN_TENANT);

        assertThat(response).isNotNull();
        assertThat(response.getTags().stream().anyMatch(t -> t.equals("Reporting"))).isTrue();
    }

    /**
     * Search for apps
     */
    @Test
    public void searchAppsTest() throws ApiException {
        String appId = "searchAppsTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));
        kestraClient().apps().createApp(MAIN_TENANT, getAppSource(appId, flow.getNamespace(), flow.getId()));

        Integer page = 1;
        Integer size = 100;
        String q = appId;

        PagedResultsAppsControllerApiApp response = kestraClient().apps().searchApps(page, size, MAIN_TENANT, null, null, q, null, null);

        assertThat(response).isNotNull();
        assertThat(response.getResults().stream().anyMatch(app -> app.getId().equals(appId))).isTrue();
    }

    /**
     * Update an existing app
     */
    @Test
    public void updateAppTest() throws ApiException {
        String appId = "updateAppTest";
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlowForApp(appId));

        String body = getAppSource(appId, flow.getNamespace(), flow.getId());
        var app = kestraClient().apps().createApp(MAIN_TENANT, body);

        String updatedBody = body.replace("Form to request and download data", "Updated description from test");
        AppsControllerApiAppSource response = kestraClient().apps().updateApp(app.getUid(), MAIN_TENANT, updatedBody);

        assertThat(response).isNotNull();
    }

    private static String getSimpleFlowForApp(String id) {
        return String.format("""
            id: %s
            namespace: company.team
            description: minimal flow for apps tests
            tasks:
              - id: task1
                type: io.kestra.plugin.core.log.Log
                message: "hello"
            """, id);
    }

    private static String getAppSource(String id, String namespace, String flowId) {
        return String.format("""
            id: %s
            type: io.kestra.plugin.ee.apps.Execution
            displayName: Form to request and download data
            namespace: %s
            flowId: %s
            access:
              type: PRIVATE
            tags:
              - Reporting
              - Analytics

            layout:
              - on: OPEN
                blocks:
                  - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
                    content: |
                      ## Request data
                      Select the dataset you want to download.
                  - type: io.kestra.plugin.ee.apps.execution.blocks.CreateExecutionForm
                  - type: io.kestra.plugin.ee.apps.execution.blocks.CreateExecutionButton
                    text: Submit
            description: |
              App example for tests
            """, id, namespace, flowId);
    }
}
