package io.kestra.sdk.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.internal.ApiClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

class WorkerSelectorTest {
    private final ObjectMapper mapper = new ApiClient().getObjectMapper();

    @Test
    void readsTheStringTagsKestra2011ReturnsForALiteralList() throws Exception {
        // Kestra 2.0.11+ returns a flow's workerSelector.tags as the property's JSON text, not an array
        FlowWithSource flow = mapper.readValue(
            "{\"id\":\"f\",\"namespace\":\"n\",\"workerSelector\":{\"tags\":\"[\\\"gpu\\\", \\\"linux\\\"]\",\"match\":\"ALL\"}}",
            FlowWithSource.class);

        assertEquals(List.of("gpu", "linux"), flow.getWorkerSelector().getTags());
        assertNull(flow.getWorkerSelector().getTagsExpression());
        assertEquals(WorkerSelectorMatch.ALL, flow.getWorkerSelector().getMatch());
    }

    @Test
    void readsTheArrayTagsKestraBefore2011Returns() throws Exception {
        // Kestra 2.0.0-2.0.10 (and namespace / tenant defaults) return a JSON array
        FlowWithSource flow = mapper.readValue(
            "{\"id\":\"f\",\"namespace\":\"n\",\"workerSelector\":{\"tags\":[\"gpu\",\"linux\"]}}",
            FlowWithSource.class);

        assertEquals(List.of("gpu", "linux"), flow.getWorkerSelector().getTags());
        assertNull(flow.getWorkerSelector().getTagsExpression());
    }

    @Test
    void readsAPebbleExpressionIntoTagsExpression() throws Exception {
        Task task = mapper.readValue(
            "{\"id\":\"t\",\"type\":\"io.kestra.plugin.core.log.Log\",\"workerSelector\":{\"tags\":\"{{ inputs.workers }}\"}}",
            Task.class);

        assertNull(task.getWorkerSelector().getTags());
        assertEquals("{{ inputs.workers }}", task.getWorkerSelector().getTagsExpression());
    }

    @Test
    void writesTagsAsAListAndAnExpressionAsAString() throws Exception {
        JsonNode list = mapper.valueToTree(new WorkerSelector().tags(List.of("gpu")).match(WorkerSelectorMatch.ANY));
        assertEquals("{\"tags\":[\"gpu\"],\"match\":\"ANY\"}", list.toString());

        JsonNode expression = mapper.valueToTree(new WorkerSelector().tagsExpression("{{ inputs.workers }}"));
        assertEquals("{\"tags\":\"{{ inputs.workers }}\"}", expression.toString());

        JsonNode empty = mapper.valueToTree(new WorkerSelector());
        assertFalse(empty.has("tags"), empty.toString());
        assertFalse(empty.has("tagsExpression"), empty.toString());
    }

    @Test
    void settingOneFormClearsTheOther() {
        WorkerSelector selector = new WorkerSelector().tags(List.of("gpu")).tagsExpression("{{ x }}");
        assertNull(selector.getTags());

        selector.addTagsItem("gpu");
        assertNull(selector.getTagsExpression());
        assertEquals(List.of("gpu"), selector.getTags());
    }
}
