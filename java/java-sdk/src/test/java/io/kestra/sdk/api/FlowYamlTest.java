package io.kestra.sdk.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.kestra.sdk.model.AbstractTrigger;
import io.kestra.sdk.model.Flow;
import io.kestra.sdk.model.InputObject;
import io.kestra.sdk.model.Task;
import io.kestra.sdk.model.Type;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    private static List<String> fieldNames(JsonNode node) {
        List<String> names = new ArrayList<>();
        node.fieldNames().forEachRemaining(names::add);
        return names;
    }

    // Enough keys that HashMap iteration order differs from insertion order.
    private static final List<String> PLUGIN_KEYS = List.of(
            "zeta", "alpha", "message", "beta", "commands", "yankee", "delta",
            "xray", "echo", "whiskey", "foxtrot", "victor");

    @Test
    void additionalPropertiesKeepInsertionOrder() throws Exception {
        Task task = new Task().id("t").type("io.kestra.plugin.core.log.Log");
        AbstractTrigger trigger = new AbstractTrigger().id("tr").type("io.kestra.plugin.core.trigger.Schedule");
        InputObject input = new InputObject().id("in").type(Type.STRING);
        for (String key : PLUGIN_KEYS) {
            task.putAdditionalProperty(key, "v-" + key);
            trigger.putAdditionalProperty(key, "v-" + key);
            input.putAdditionalProperty(key, "v-" + key);
        }
        Flow flow = buildFlow();
        flow.setTasks(List.of(task));
        flow.setTriggers(List.of(trigger));
        flow.setInputs(List.of(input));

        JsonNode root = YAML.readTree(FlowsApi.flowToYaml(flow));

        List<String> expected = new ArrayList<>(List.of("id", "type"));
        expected.addAll(PLUGIN_KEYS);
        assertEquals(expected, fieldNames(root.get("tasks").get(0)));
        assertEquals(expected, fieldNames(root.get("inputs").get(0)));
        // AbstractTrigger declares `disabled = false` as a model default; declared
        // properties come before the additional (plugin) ones.
        List<String> expectedTrigger = new ArrayList<>(List.of("id", "type", "disabled"));
        expectedTrigger.addAll(PLUGIN_KEYS);
        assertEquals(expectedTrigger, fieldNames(root.get("triggers").get(0)));
        assertEquals("v-zeta", root.get("tasks").get(0).get("zeta").asText());
    }

    @Test
    void explicitEmptyListsInPluginPropertiesSurvive() throws Exception {
        // Only the typed models' `new ArrayList<>()` defaults are hidden; an empty
        // list the user sets explicitly in a plugin property (at any depth) is
        // real content and must be emitted, like the Python/Go/JS SDKs do.
        Map<String, Object> env = new LinkedHashMap<>();
        env.put("paths", List.of());
        env.put("name", "x");
        Task shell = new Task().id("shell").type("io.kestra.plugin.scripts.shell.Commands");
        shell.putAdditionalProperty("commands", List.of());
        shell.putAdditionalProperty("env", env);

        Flow flow = buildFlow();
        flow.setTasks(List.of(shell));

        String yaml = FlowsApi.flowToYaml(flow);
        JsonNode root = YAML.readTree(yaml);
        JsonNode task = root.get("tasks").get(0);
        assertTrue(task.get("commands") != null && task.get("commands").isArray(), yaml);
        assertEquals(0, task.get("commands").size(), yaml);
        assertTrue(task.get("env").get("paths") != null && task.get("env").get("paths").isArray(), yaml);
        assertEquals(0, task.get("env").get("paths").size(), yaml);
        assertEquals("x", task.get("env").get("name").asText());

        // The model defaults are still omitted (flow root and trigger level).
        assertTrue(root.get("inputs") == null, yaml);
        assertTrue(root.get("triggers") == null, yaml);
        assertTrue(root.get("labels") == null, yaml);

        AbstractTrigger trigger = new AbstractTrigger().id("tr").type("io.kestra.plugin.core.trigger.Schedule");
        trigger.putAdditionalProperty("cron", "0 * * * *");
        flow.setTriggers(List.of(trigger));
        JsonNode triggerNode = YAML.readTree(FlowsApi.flowToYaml(flow)).get("triggers").get(0);
        // `labels`/`stopAfter` defaults ([]) are omitted; plugin `cron` is kept.
        assertEquals(List.of("id", "type", "disabled", "cron"), fieldNames(triggerNode));
    }

    // A typed round-trip of a flow read from the server: the ApiClient's mapper
    // must keep oneOf-typed values (Output.value: object | string, and the task
    // `assets` inputs/outputs) instead of deserializing them to null.
    private static final String SERVER_FLOW_JSON = """
            {
              "id": "outputs-flow",
              "namespace": "company.team",
              "revision": 3,
              "disabled": false,
              "deleted": false,
              "draft": false,
              "outputs": [
                {"id": "str", "type": "STRING", "value": "{{ outputs.ret.value }}"},
                {"id": "obj", "type": "JSON", "value": {"a": 1, "b": ["x", "y"]}}
              ],
              "tasks": [
                {
                  "id": "ret",
                  "type": "io.kestra.plugin.core.debug.Return",
                  "format": "hello",
                  "assets": {
                    "inputs": [{"id": "in_table", "type": "io.kestra.plugin.ee.assets.Table"}],
                    "outputs": "{{ outputs.ret.assets }}"
                  }
                }
              ]
            }
            """;

    @Test
    void outputAndAssetValuesSurviveTypedRoundTrip() throws Exception {
        io.kestra.sdk.model.FlowWithSource got = new io.kestra.sdk.internal.ApiClient().getObjectMapper()
                .readValue(SERVER_FLOW_JSON, io.kestra.sdk.model.FlowWithSource.class);

        JsonNode root = YAML.readTree(FlowsApi.flowToYaml(got));

        JsonNode outputs = root.get("outputs");
        assertEquals("str", outputs.get(0).get("id").asText());
        assertEquals("{{ outputs.ret.value }}", outputs.get(0).get("value").asText());
        assertEquals(1, outputs.get(1).get("value").get("a").asInt());
        assertEquals("x", outputs.get(1).get("value").get("b").get(0).asText());
        assertEquals("y", outputs.get(1).get("value").get("b").get(1).asText());

        JsonNode assets = root.get("tasks").get(0).get("assets");
        assertEquals("in_table", assets.get("inputs").get(0).get("id").asText());
        assertEquals("io.kestra.plugin.ee.assets.Table", assets.get("inputs").get(0).get("type").asText());
        assertEquals("{{ outputs.ret.assets }}", assets.get("outputs").asText());
    }

    @Test
    void outputValueCanBeBuiltFromAPlainValue() throws Exception {
        Flow flow = buildFlow();
        flow.setOutputs(List.of(
                new io.kestra.sdk.model.Output().id("o").type(Type.STRING)
                        .value(io.kestra.sdk.model.OutputValue.of("{{ outputs.log.value }}"))));
        JsonNode root = YAML.readTree(FlowsApi.flowToYaml(flow));
        assertEquals("{{ outputs.log.value }}", root.get("outputs").get(0).get("value").asText());
        assertEquals("{{ outputs.log.value }}", flow.getOutputs().get(0).getValue().getValue());
    }

    @Test
    void ambiguousStringsAreQuotedAndRoundTrip() throws Exception {
        JsonNode fixture = new ObjectMapper().readTree(ambiguousStringsFixture());
        List<String> mustQuote = new ArrayList<>();
        fixture.get("mustQuote").forEach(n -> mustQuote.add(n.asText()));
        List<String> staysPlain = new ArrayList<>();
        fixture.get("staysPlain").forEach(n -> staysPlain.add(n.asText()));

        // An empty key is left out: emitters write it in their own form
        // (SnakeYAML uses the complex-key `? ""`), which still reads back as "".
        Map<String, Object> keyed = new LinkedHashMap<>();
        mustQuote.stream().filter(s -> !s.isEmpty()).forEach(s -> keyed.put(s, "k"));
        Map<String, Object> task = new LinkedHashMap<>();
        task.put("id", "out");
        task.put("type", "io.kestra.plugin.core.output.OutputValues");
        task.put("values", mustQuote);
        task.put("keyed", keyed);
        task.put("plain", staysPlain);
        Map<String, Object> flow = new LinkedHashMap<>();
        flow.put("id", "tricky");
        flow.put("namespace", "company.team");
        flow.put("tasks", List.of(task));

        String yaml = FlowsApi.flowToYaml(flow);

        for (String s : mustQuote) {
            assertTrue(yaml.contains("\n  - \"" + s + "\"\n"), "value " + s + " not quoted:\n" + yaml);
        }
        for (String s : keyed.keySet()) {
            assertTrue(yaml.contains("\n    \"" + s + "\": k\n"), "key " + s + " not quoted:\n" + yaml);
        }
        for (String s : staysPlain) {
            assertTrue(yaml.contains("\n  - " + s + "\n"), "value " + s + " not plain:\n" + yaml);
        }

        // Jackson's YAML reader is what Kestra parses flow source with: every
        // value comes back as the exact original string, not a boolean/number.
        JsonNode values = YAML.readTree(yaml).get("tasks").get(0).get("values");
        assertEquals(mustQuote.size(), values.size());
        for (int i = 0; i < mustQuote.size(); i++) {
            assertTrue(values.get(i).isTextual(), mustQuote.get(i) + " re-typed to " + values.get(i).getNodeType());
            assertEquals(mustQuote.get(i), values.get(i).asText());
        }
    }

    @Test
    void multiLineStringsAreLiteralBlocksAndExpressionsStayQuoted() throws Exception {
        Task log = new Task().id("t").type("io.kestra.plugin.core.log.Log");
        log.putAdditionalProperty("message", "line1\nline2\n");
        log.putAdditionalProperty("expr", "{{ inputs.foo }}");
        Flow flow = new Flow();
        flow.setId("p");
        flow.setNamespace("ns");
        flow.setTasks(List.of(log));

        String yaml = FlowsApi.flowToYaml(flow);

        assertTrue(yaml.contains("id: p\n"), yaml);
        assertTrue(yaml.contains("  message: |\n    line1\n    line2\n"), yaml);
        assertTrue(yaml.contains("  expr: \"{{ inputs.foo }}\"\n")
                || yaml.contains("  expr: '{{ inputs.foo }}'\n"), yaml);
        JsonNode t = YAML.readTree(yaml).get("tasks").get(0);
        assertEquals("line1\nline2\n", t.get("message").asText());
        assertEquals("{{ inputs.foo }}", t.get("expr").asText());
    }

    private static File ambiguousStringsFixture() {
        File dir = new File(System.getProperty("user.dir")).getAbsoluteFile();
        while (dir != null) {
            File candidate = new File(dir, "test-utils/yaml-ambiguous-strings.json");
            if (candidate.isFile()) {
                return candidate;
            }
            dir = dir.getParentFile();
        }
        throw new IllegalStateException("could not locate test-utils/yaml-ambiguous-strings.json from " + System.getProperty("user.dir"));
    }
}
