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
            // Copilot is licensed on the CI image, so the (possibly empty) list is present.
            assertThat(result).isNotNull();
        } catch (ApiException e) {
            // The one deterministic non-200 is 503 when no AI provider is configured; a
            // mis-routed path would be the EE catch-all 403, so it must NOT be tolerated.
            assertThat(e.getCode()).isEqualTo(503);
        }
    }

    @Test
    void getThread_unknownId_throws() {
        // With no AI provider the Copilot service answers 503 before it can resolve the
        // (unknown) thread; with one it would be 404. A mis-routed path would instead be
        // the EE catch-all 403, so excluding 403 keeps this test guarding the binding.
        assertThatThrownBy(() -> api().getThread(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isIn(404, 503));
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
