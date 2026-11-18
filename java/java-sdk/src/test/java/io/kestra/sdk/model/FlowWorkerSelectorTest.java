package io.kestra.sdk.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.internal.ApiClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlowWorkerSelectorTest {
    private final ObjectMapper mapper = new ApiClient().getObjectMapper();

    @Test
    void readsTheStringTagsKestraReturnsForALiteralList() throws Exception {
        // Kestra 2.0.11+ returns a flow's workerSelector.tags as the property's JSON text, not an array
        FlowWithSource flow = mapper.readValue(
            "{\"id\":\"f\",\"namespace\":\"n\",\"workerSelector\":{\"tags\":\"[\\\"gpu\\\"]\",\"match\":\"ALL\"}}",
            FlowWithSource.class);

        assertEquals("[\"gpu\"]", flow.getWorkerSelector().getTags());
        assertEquals(WorkerSelectorMatch.ALL, flow.getWorkerSelector().getMatch());
    }

    @Test
    void readsTheArrayTagsKestraBefore2011Returns() throws Exception {
        // Kestra 2.0.0-2.0.10 typed tags as a plain list and returns a JSON array
        FlowWithSource flow = mapper.readValue(
            "{\"id\":\"f\",\"namespace\":\"n\",\"workerSelector\":{\"tags\":[\"gpu\",\"linux\"],\"match\":\"ALL\"}}",
            FlowWithSource.class);

        assertEquals("[\"gpu\",\"linux\"]", flow.getWorkerSelector().getTags());
    }
}
