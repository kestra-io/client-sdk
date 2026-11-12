package io.kestra.sdk.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.internal.ApiClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FlowWorkerSelectorTest {
    private final ObjectMapper mapper = new ApiClient().getObjectMapper();

    @Test
    void readsTheStringTagsKestraReturnsForALiteralList() throws Exception {
        // Kestra develop returns a flow's workerSelector.tags as the property's JSON text, not an array
        FlowWithSource flow = mapper.readValue(
            "{\"id\":\"f\",\"namespace\":\"n\",\"workerSelector\":{\"tags\":\"[\\\"gpu\\\"]\",\"match\":\"ALL\"}}",
            FlowWithSource.class);

        assertEquals("[\"gpu\"]", flow.getWorkerSelector().getTags());
        assertEquals(WorkerSelectorMatch.ALL, flow.getWorkerSelector().getMatch());
    }

    @Test
    void keepsAPebbleExpressionAsIs() throws Exception {
        FlowWorkerSelector selector = mapper.readValue("{\"tags\":\"{{ inputs.tags }}\"}", FlowWorkerSelector.class);

        assertEquals("{{ inputs.tags }}", selector.getTags());
    }

    @Test
    void nullTagsStayNull() throws Exception {
        assertNull(mapper.readValue("{\"tags\":null}", FlowWorkerSelector.class).getTags());
    }
}
