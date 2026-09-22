package io.kestra.sdk.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.kestra.sdk.model.AbstractTrigger;
import io.kestra.sdk.model.Flow;
import io.kestra.sdk.model.InputObject;
import io.kestra.sdk.model.Task;
import io.kestra.sdk.model.Type;
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
    void excludesServerManagedFields() throws Exception {
        // buildFlow sets draft/deleted (both false, so they would otherwise be
        // emitted); revision must not appear in flow source either.
        Flow flow = buildFlow();
        flow.setRevision(7);

        String yaml = FlowsApi.flowToYaml(flow);
        assertTrue(!yaml.contains("draft:"), yaml);
        assertTrue(!yaml.contains("deleted:"), yaml);
        assertTrue(!yaml.contains("revision:"), yaml);

        JsonNode root = YAML.readTree(yaml);
        for (String field : new String[] {"draft", "deleted", "revision", "tenantId", "source", "updated"}) {
            assertTrue(root.get(field) == null, "field must be stripped: " + field);
        }
    }

    @Test
    void omitsNullFields() throws Exception {
        // buildFlow leaves nullable Flow fields unset (e.g. description); a null
        // field must never be emitted as `key: null`.
        String yaml = FlowsApi.flowToYaml(buildFlow());
        assertTrue(!yaml.contains("null"), yaml);
        assertTrue(!yaml.contains("description:"), yaml);
    }

    @Test
    void serializesJavaTimeValuesAndStripsUpdated() throws Exception {
        // A Flow with a non-null `updated` (OffsetDateTime) and a java.time value
        // nested in a task must serialize without InvalidDefinitionException (the
        // mapper needs JavaTimeModule) and `updated` must not leak into the source.
        Flow flow = buildFlow();
        flow.setUpdated(java.time.OffsetDateTime.parse("2026-01-02T03:04:05Z"));

        Task withDate = new Task().id("scheduled").type("io.kestra.plugin.core.trigger.Schedule");
        withDate.putAdditionalProperty("date", java.time.OffsetDateTime.parse("2026-02-03T04:05:06Z"));
        flow.setTasks(List.of(withDate));

        String yaml = FlowsApi.flowToYaml(flow); // must not throw
        assertTrue(!yaml.contains("updated:"), yaml);

        JsonNode root = YAML.readTree(yaml);
        assertTrue(root.get("updated") == null, "updated must be stripped");
        // The java.time value nested in the task survived serialization.
        assertTrue(root.get("tasks").get(0).get("date").asText().startsWith("2026-02-03"), yaml);
    }

    @Test
    void triggerAndInputPluginPropertiesSurviveSerialization() throws Exception {
        // A typed Flow whose trigger and input carry plugin-specific properties.
        // Before AbstractTrigger/InputObject gained @JsonAnyGetter/@JsonAnySetter
        // these were silently dropped (only Task had the open-envelope treatment),
        // so a Schedule trigger's cron/timezone or a SELECT input's values never
        // reached the YAML source.
        AbstractTrigger trigger = new AbstractTrigger()
                .id("schedule")
                .type("io.kestra.plugin.core.trigger.Schedule");
        trigger.putAdditionalProperty("cron", "0 9 * * *");
        trigger.putAdditionalProperty("timezone", "Europe/Paris");

        InputObject input = new InputObject().id("tier").type(Type.SELECT);
        input.putAdditionalProperty("values", List.of("gold", "silver"));
        input.putAdditionalProperty("defaults", "gold");

        Flow flow = new Flow();
        flow.setId("with-trigger-and-input");
        flow.setNamespace("company.team");
        flow.setDisabled(false);
        flow.setDraft(false);
        flow.setDeleted(false);
        flow.setTriggers(List.of(trigger));
        flow.setInputs(List.of(input));
        flow.setTasks(List.of(new Task().id("log").type("io.kestra.plugin.core.log.Log")
                .putAdditionalProperty("message", "hi")));

        JsonNode root = YAML.readTree(FlowsApi.flowToYaml(flow));

        JsonNode triggerNode = root.get("triggers").get(0);
        assertEquals("io.kestra.plugin.core.trigger.Schedule", triggerNode.get("type").asText());
        assertEquals("0 9 * * *", triggerNode.get("cron").asText());
        assertEquals("Europe/Paris", triggerNode.get("timezone").asText());

        JsonNode inputNode = root.get("inputs").get(0);
        assertEquals("SELECT", inputNode.get("type").asText());
        assertEquals("gold", inputNode.get("values").get(0).asText());
        assertEquals("silver", inputNode.get("values").get(1).asText());
        assertEquals("gold", inputNode.get("defaults").asText());
    }

    @Test
    void omitsEmptyCollections() throws Exception {
        // The typed Flow model defaults its list fields to `new ArrayList<>()`, so
        // without empty-collection stripping a bare flow would emit noisy
        // `inputs: []`, `outputs: []`, `triggers: []`, ... which the other SDKs omit.
        String yaml = FlowsApi.flowToYaml(buildFlow());

        JsonNode root = YAML.readTree(yaml);
        for (String field : new String[] {"inputs", "outputs", "labels", "errors", "triggers", "sla", "checks"}) {
            assertTrue(root.get(field) == null, "empty collection must be omitted: " + field + "\n" + yaml);
        }
        // A populated list is still emitted.
        assertTrue(root.get("tasks") != null && root.get("tasks").size() == 2, yaml);
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
