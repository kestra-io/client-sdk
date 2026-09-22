package io.kestra.sdk.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.kestra.sdk.model.Flow;
import io.kestra.sdk.model.Task;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pure serialization tests for {@link FlowsApi#flowToYaml(Object)} — no live
 * Kestra server involved. Verifies that plugin-specific task properties survive
 * serialization (they were silently dropped before Task gained
 * {@code @JsonAnyGetter}/{@code @JsonAnySetter}), including inside nested tasks.
 */
class FlowYamlTest {

    private static final YAMLMapper YAML = new YAMLMapper();

    private Flow buildFlow() {
        // Log task with a plugin-specific `message` property.
        Task log = new Task().id("log").type("io.kestra.plugin.core.log.Log");
        log.putAdditionalProperty("message", "Hello {{ inputs.name }}");

        // Nested Shell task with a plugin-specific multi-line `commands`.
        Task shell = new Task().id("shell").type("io.kestra.plugin.scripts.shell.Commands");
        shell.putAdditionalProperty("script", "echo start\necho done");
        shell.putAdditionalProperty("commands", List.of("echo one", "echo two"));

        // Sequential (flowable) task carrying a nested `tasks` list.
        Task seq = new Task().id("seq").type("io.kestra.plugin.core.flow.Sequential");
        seq.putAdditionalProperty("tasks", List.of(shell));

        Flow flow = new Flow();
        flow.setId("my-flow");
        flow.setNamespace("company.team");
        flow.setDisabled(false);
        flow.setDraft(false);
        flow.setDeleted(false);
        flow.setTasks(List.of(log, seq));
        return flow;
    }

    @Test
    void pluginPropertiesSurviveSerialization() throws Exception {
        String yaml = FlowsApi.flowToYaml(buildFlow());

        assertTrue(yaml.contains("message:"), yaml);
        assertTrue(yaml.contains("io.kestra.plugin.core.log.Log"), yaml);
        assertTrue(yaml.contains("commands:"), yaml);
        // Expression must not be mangled.
        assertTrue(yaml.contains("{{ inputs.name }}"), yaml);
        // No JSON document-start marker.
        assertTrue(!yaml.startsWith("---"), yaml);
    }

    @Test
    void roundTripPreservesRealValues() throws Exception {
        JsonNode root = YAML.readTree(FlowsApi.flowToYaml(buildFlow()));

        assertEquals("my-flow", root.get("id").asText());
        assertEquals("company.team", root.get("namespace").asText());

        JsonNode logNode = root.get("tasks").get(0);
        assertEquals("log", logNode.get("id").asText());
        assertEquals("io.kestra.plugin.core.log.Log", logNode.get("type").asText());
        assertEquals("Hello {{ inputs.name }}", logNode.get("message").asText());

        JsonNode seqNode = root.get("tasks").get(1);
        assertEquals("io.kestra.plugin.core.flow.Sequential", seqNode.get("type").asText());

        JsonNode nested = seqNode.get("tasks").get(0);
        assertEquals("shell", nested.get("id").asText());
        assertEquals("echo start\necho done", nested.get("script").asText());
        assertEquals("echo one", nested.get("commands").get(0).asText());
        assertEquals("echo two", nested.get("commands").get(1).asText());
    }

    @Test
    void mapInputIsSupported() throws Exception {
        Map<String, Object> flow = Map.of(
                "id", "dict-flow",
                "namespace", "company.team",
                "disabled", false,
                "draft", false,
                "deleted", false,
                "tasks", List.of(Map.of(
                        "id", "hello",
                        "type", "io.kestra.plugin.core.log.Log",
                        "message", "grüß gott"
                ))
        );
        String yaml = FlowsApi.flowToYaml(flow);

        // Non-ASCII must not be escaped to \\uXXXX.
        assertTrue(!yaml.contains("\\u"), yaml);
        assertTrue(yaml.contains("grüß gott"), yaml);

        JsonNode root = YAML.readTree(yaml);
        assertEquals("grüß gott", root.get("tasks").get(0).get("message").asText());
    }

    @Test
    void taskAdditionalPropertiesRoundTripThroughModel() {
        // Deserialize -> the @JsonAnySetter must capture plugin props.
        Task task = new Task().id("log").type("io.kestra.plugin.core.log.Log");
        task.putAdditionalProperty("message", "hi");
        assertEquals("hi", task.getAdditionalProperty("message"));
        assertEquals("hi", task.getAdditionalProperties().get("message"));
    }
}
