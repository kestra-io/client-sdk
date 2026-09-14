package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the AI Copilot endpoints under {@code /api/v1/{tenant}/ai/**}.
 * <p>
 * The Copilot feature needs an AI provider configured on the EE instance. On a CI image
 * without one, the whole resource is gated behind {@code COPILOT} and answers 403. The
 * read-only tests therefore accept either the real payload or that gate; the generation
 * endpoints (which actually call a model) are {@link Disabled} until an instance with a
 * provider is available.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AiApiTest {

    static AiApi api() {
        return client().ai();
    }

    @Test
    void listThreads_returnsAListOrIsGated() throws ApiException {
        try {
            List<Map<String, Object>> result = api().listThreads(TENANT);
            // when Copilot is enabled the list is always present (possibly empty).
            assertThat(result).isNotNull();
        } catch (ApiException e) {
            // COPILOT resource / missing AI provider is the deterministic gate on a CI image.
            assertThat(e.getCode()).isIn(403, 404);
        }
    }

    @Test
    void getThread_unknownId_throws() {
        assertThatThrownBy(() -> api().getThread(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isIn(403, 404));
    }

    @Test
    @Disabled("Needs an EE instance with an AI provider configured; otherwise gated by COPILOT (403).")
    void generateApp_returnsYaml() throws ApiException {
        io.kestra.sdk.model.AppGenerationPrompt prompt = new io.kestra.sdk.model.AppGenerationPrompt()
                .conversationId(randomId())
                .userPrompt("An app with a single text input");

        String yaml = api().generateApp(TENANT, prompt);

        assertThat(yaml).contains("type:");
    }
}
