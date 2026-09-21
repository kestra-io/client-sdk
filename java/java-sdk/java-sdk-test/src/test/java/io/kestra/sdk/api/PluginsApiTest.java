package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PluginsApiTest {

    static PluginsApi api() {
        return client().plugins();
    }

    // ========================================================================
    // Listing & search
    // ========================================================================

    @Test
    void listPlugins_containsCorePlugin() throws ApiException {
        Map<String, Object> result = api().listPlugins(1, 1000, null, null);

        assertThat((Number) result.get("total")).isNotNull();
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> results = (List<Map<String, Object>>) result.get("results");
        assertThat(results).extracting(p -> p.get("name")).contains("core");
    }

    @Test
    void getPluginBySubgroups_notEmpty() throws ApiException {
        List<Plugin> result = api().getPluginBySubgroups();

        assertThat(result).isNotEmpty();
    }

    @Test
    void listTriggerPlugins_hasResults() throws ApiException {
        Map<String, Object> result = api().listTriggerPlugins();

        // core ships built-in triggers (Schedule, Webhook, …), so this is never empty
        assertThat(((Number) result.get("total")).intValue()).isGreaterThan(0);
    }

    // ========================================================================
    // Icons
    // ========================================================================

    @Test
    void getPluginIcons_containsLog() throws ApiException {
        Map<String, Object> result = api().getPluginIcons();

        assertThat(result).containsKey("io.kestra.plugin.core.log.Log");
    }

    @Test
    void getPluginGroupIcons_notEmpty() throws ApiException {
        Map<String, Object> result = api().getPluginGroupIcons();

        assertThat(result).isNotEmpty();
    }

    @Test
    void getPluginIcon_forLogTask() throws ApiException {
        Map<String, Object> result = api().getPluginIcon("io.kestra.plugin.core.log.Log");

        assertThat(result).containsKey("icon");
    }

    @Test
    void getPluginIconSvg_forLogTask() throws ApiException {
        byte[] result = api().getPluginIconSvg("io.kestra.plugin.core.log.Log");

        assertThat(result).isNotEmpty();
    }

    // ========================================================================
    // Input types
    // ========================================================================

    @Test
    void getAllInputTypes_containsString() throws ApiException {
        List<InputType> result = api().getAllInputTypes();

        assertThat(result).extracting(InputType::getType).contains("STRING");
    }

    @Test
    void getSchemaFromInputType_string() throws ApiException {
        DocumentationWithSchema result = api().getSchemaFromInputType(Type.STRING);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Documentation
    // ========================================================================

    @Test
    void getPluginDocumentation_forLogTask() throws ApiException {
        DocumentationWithSchema result = api().getPluginDocumentation("io.kestra.plugin.core.log.Log", null);

        assertThat(result.getMarkdown()).contains("Log");
        assertThat(result.getSchema()).isNotNull();
    }

    @Test
    void getPluginVersions_forLogTask() throws ApiException {
        PluginControllerApiPluginVersions result = api().getPluginVersions("io.kestra.plugin.core.log.Log");

        assertThat(result.getType()).isEqualTo("io.kestra.plugin.core.log.Log");
        assertThat(result.getVersions()).isNotEmpty();
    }

    @Test
    void getPluginDocumentationFromVersion_forLogTask() throws ApiException {
        String version = api().getPluginVersions("io.kestra.plugin.core.log.Log").getVersions().get(0);

        DocumentationWithSchema result = api().getPluginDocumentationFromVersion(
                "io.kestra.plugin.core.log.Log", version, null);

        assertThat(result.getMarkdown()).contains("Log");
        assertThat(result.getSchema()).isNotNull();
    }

    // ========================================================================
    // Schemas & properties
    // ========================================================================

    @Test
    void getPropertiesFromType_task() throws ApiException {
        Map<String, Object> result = api().getPropertiesFromType(SchemaType.TASK);

        assertThat(result).isNotEmpty();
    }

    @Test
    void getSchemasFromType_task() throws ApiException {
        Map<String, Object> result = api().getSchemasFromType(SchemaType.TASK, null, null);

        assertThat(result).isNotEmpty();
    }

    // ========================================================================
    // Auto-install (EE)
    // ========================================================================

    // The CI kestra-ee:develop image always answers these three with the same
    // deterministic 403 (confirmed live): plugin auto-install is a feature the
    // Enterprise Edition itself turns off, in favor of Plugin Versioning — not a
    // CI-image defect, so it's asserted as the expected response rather than
    // skipped.
    private static final String AUTO_INSTALL_DISABLED_DETAIL =
            "Plugin auto-install is not available in Kestra Enterprise Edition; plugins are managed through Plugin Versioning.";

    private static void assertApiExceptionMatches(ThrowingCallable call, int expectedCode, String expectedDetail) {
        assertThatThrownBy(call)
                .isInstanceOf(ApiException.class)
                .satisfies(e -> {
                    ApiException apiException = (ApiException) e;
                    assertThat(apiException.getCode()).isEqualTo(expectedCode);
                    assertThat(apiException.getResponseBody()).contains(expectedDetail);
                });
    }

    @Test
    void detectMissingPlugins_disabledOnThisInstance() {
        String flowSource = """
                id: %s
                namespace: %s
                tasks:
                  - id: hello
                    type: io.kestra.plugin.core.log.Log
                    message: hi
                """.formatted(randomId(), randomId());

        assertApiExceptionMatches(() -> api().detectMissingPlugins(flowSource), 403, AUTO_INSTALL_DISABLED_DETAIL);
    }

    @Test
    void installPlugins_disabledOnThisInstance() {
        PluginArtifact artifact = new PluginArtifact()
                .groupId("io.kestra.plugin")
                .artifactId("plugin-notifications")
                .version("1.0.0");

        assertApiExceptionMatches(() -> api().installPlugins(List.of(artifact)), 403, AUTO_INSTALL_DISABLED_DETAIL);
    }

    @Test
    void getInstallJob_disabledOnThisInstance() {
        assertApiExceptionMatches(
                () -> api().getInstallJob("00000000-0000-0000-0000-000000000000"), 403, AUTO_INSTALL_DISABLED_DETAIL);
    }

    // ========================================================================
    // UI manifest
    // ========================================================================

    @Test
    void getPluginUiManifest_emptyForTaskWithNoUiModule() throws ApiException {
        // io.kestra.plugin.core.log.Log ships no plugin-ui module, so the manifest
        // for it is genuinely empty on this image; that emptiness is itself the
        // real, deterministic value being asserted here.
        TaskWithVersion task = new TaskWithVersion().cls("io.kestra.plugin.core.log.Log");

        PluginUiManifest result = api().getPluginUiManifest(List.of(task));

        assertThat(result.getManifest()).isEmpty();
    }

    @Test
    void getPluginUi_deniedForUnknownModule() {
        // no plugin on this image ships a UI module, so there's no fixture path that
        // reaches a 200; with the SDK's `Accept: application/octet-stream` (unlike a
        // bare browser-style GET) the server answers with its EE 2.0 catch-all 403
        // rather than a 404 — confirmed live, not a CI-image defect.
        assertApiExceptionMatches(() -> api().getPluginUi("core", "index.js"), 403, "Access denied");
    }
}
