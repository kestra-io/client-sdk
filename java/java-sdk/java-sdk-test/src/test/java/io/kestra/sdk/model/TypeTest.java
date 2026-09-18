package io.kestra.sdk.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class TypeTest {

    @ParameterizedTest
    @ValueSource(strings = {"STRING", "SELECT", "INT", "FLOAT", "BOOL", "DATETIME", "DATE", "TIME",
        "DURATION", "FILE", "JSON", "ION", "URI", "SECRET", "ARRAY", "MULTISELECT", "YAML",
        "EMAIL", "FORM", "REUSABLE_INPUTS"})
    void fromValue_resolvesEveryInputTypeTheSpecDeclares(String value) {
        // an unmapped value falls through to UNKNOWN_DEFAULT_OPEN_API and re-serializes as that, corrupting the block
        assertThat(Type.fromValue(value)).isNotEqualTo(Type.UNKNOWN_DEFAULT_OPEN_API);
        assertThat(Type.fromValue(value).getValue()).isEqualTo(value);
    }

    @Test
    void fromValue_stillFallsBackForAnUnknownValue() {
        assertThat(Type.fromValue("NOT_A_TYPE")).isEqualTo(Type.UNKNOWN_DEFAULT_OPEN_API);
    }
}
