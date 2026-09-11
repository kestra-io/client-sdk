package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
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

        assertThat((Number) result.get("total")).isNotNull();
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

        assertThat(result).isNotNull();
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
}
