package io.kestra.sdk.model;

import io.kestra.sdk.internal.ApiClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class AssetTypeTest {

    @Test
    void flow_withAssetInputAndOutput_decodesWithoutError() throws Exception {
        var json = """
                {
                  "id": "f",
                  "namespace": "ns",
                  "disabled": false,
                  "deleted": false,
                  "tasks": [{"id": "t", "type": "io.kestra.plugin.core.log.Log"}],
                  "inputs": [{"id": "vm", "type": "ASSET"}],
                  "outputs": [{"id": "picked", "type": "ASSET", "value": "{{ inputs.vm }}"}]
                }
                """;

        var flow = new ApiClient().getObjectMapper().readValue(json, Flow.class);

        assertThat(flow.getInputs().getFirst().getType()).isEqualTo(Type.ASSET);
        assertThat(flow.getOutputs().getFirst().getType()).isEqualTo(OutputType.ASSET);
    }

    @ParameterizedTest
    @ValueSource(strings = {"STRING", "INT", "FLOAT", "BOOL", "DATETIME", "DATE", "TIME", "DURATION",
        "FILE", "JSON", "ION", "URI", "SECRET", "ARRAY", "YAML", "ASSET", "UNKNOWN"})
    void outputType_fromValue_resolvesEveryOutputTypeTheSpecDeclares(String value) {
        assertThat(OutputType.fromValue(value)).isNotEqualTo(OutputType.UNKNOWN_DEFAULT_OPEN_API);
        assertThat(OutputType.fromValue(value).getValue()).isEqualTo(value);
    }
}
