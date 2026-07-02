package io.kestra.sdk.model;

import io.kestra.sdk.internal.ApiClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FormInputTypeTest {

    @Test
    void flow_withFormInput_decodesWithoutError() throws Exception {
        String json = """
                {
                  "id": "f",
                  "namespace": "ns",
                  "disabled": false,
                  "deleted": false,
                  "tasks": [{"id": "t", "type": "io.kestra.plugin.core.log.Log"}],
                  "inputs": [{"id": "myform", "type": "FORM"}]
                }
                """;

        Flow flow = new ApiClient().getObjectMapper().readValue(json, Flow.class);

        assertThat(flow.getInputs()).hasSize(1);
        assertThat(flow.getInputs().get(0).getType()).isEqualTo(Type.FORM);
    }
}
