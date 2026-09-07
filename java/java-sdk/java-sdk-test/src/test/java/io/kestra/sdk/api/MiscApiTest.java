package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.MiscControllerEEConfiguration;
import org.junit.jupiter.api.*;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

public class MiscApiTest {

    static MiscApi api() {
        return client().misc();
    }

    @Test
    void configuration_basic() throws ApiException {
        MiscControllerEEConfiguration result = api().configuration();

        assertThat(result).isNotNull();
        assertThat(result.getUuid()).isNotBlank();
        assertThat(result.getVersion()).isNotBlank();
        assertThat(result.getEdition()).isNotNull();
    }
}
