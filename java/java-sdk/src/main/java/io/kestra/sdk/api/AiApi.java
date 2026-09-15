package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import io.kestra.sdk.model.AppGenerationPrompt;
import io.kestra.sdk.model.DashboardGenerationPrompt;
import io.kestra.sdk.model.TestSuiteGenerationPrompt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AI Copilot endpoints under {@code /api/v1/{tenant}/ai/**}: YAML generation
 * ({@code app}/{@code dashboard}/{@code test}) and the conversational agent threads.
 * <p>
 * All of these require the {@code COPILOT} resource and an EE instance with an AI
 * provider configured. The generation endpoints answer with raw {@code application/yaml};
 * {@link #chat} and {@link #confirm} are server-sent-event streams whose full payload is
 * returned here as the raw {@code text/event-stream} body.
 */
public class AiApi extends BaseApi {

    private static final String YAML = "application/yaml";
    private static final String EVENT_STREAM = "text/event-stream";

    public AiApi() {
        super(Configuration.getDefaultApiClient());
    }

    public AiApi(ApiClient apiClient) {
        super(apiClient);
    }

    /** Builds a JSON request body, skipping {@code null} values. */
    private static Map<String, Object> bodyMap(Object... keyValues) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            Object value = keyValues[i + 1];
            if (value != null) {
                map.put((String) keyValues[i], value);
            }
        }
        return map;
    }

    // ========================================================================
    // Generation (returns raw YAML)
    // ========================================================================

    public String generateApp(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull AppGenerationPrompt prompt) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "ai", "generate", "app"),
                prompt, null, null,
                YAML, JSON,
                new TypeReference<>() {});
    }

    public String generateDashboard(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull DashboardGenerationPrompt prompt) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "ai", "generate", "dashboard"),
                prompt, null, null,
                YAML, JSON,
                new TypeReference<>() {});
    }

    public String generateTestSuite(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TestSuiteGenerationPrompt prompt) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "ai", "generate", "test"),
                prompt, null, null,
                YAML, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Threads
    // ========================================================================

    public List<Map<String, Object>> listThreads(
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "ai", "threads"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createThread(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "ai", "threads"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> getThread(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String threadId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "ai", "threads", threadId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void deleteThread(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String threadId) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "ai", "threads", threadId),
                null, null, null,
                JSON, null,
                null);
    }

    public Map<String, Object> renameThread(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String threadId,
            @jakarta.annotation.Nonnull String title) throws ApiException {
        return invoke("PATCH",
                tenantPath(tenant, "ai", "threads", threadId, "rename"),
                bodyMap("title", title), null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    /**
     * Sends a message to the agent thread and returns the full server-sent-event stream
     * (the concatenated {@code text/event-stream} body) once the turn completes.
     */
    public String chat(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String threadId,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "ai", "threads", threadId, "chat"),
                request, null, null,
                EVENT_STREAM, JSON,
                new TypeReference<>() {});
    }

    /**
     * Confirms (or rejects) a pending agent action and returns the full server-sent-event
     * stream once the turn completes.
     */
    public String confirm(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String threadId,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "ai", "threads", threadId, "confirm"),
                request, null, null,
                EVENT_STREAM, JSON,
                new TypeReference<>() {});
    }

}
