package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.AppsControllerApiApp;
import io.kestra.sdk.model.AppsControllerApiAppSource;
import io.kestra.sdk.model.AppsControllerApiAppTags;
import io.kestra.sdk.model.AppsControllerApiBulkImportResponse;
import io.kestra.sdk.model.AppsControllerApiBulkOperationRequest;
import io.kestra.sdk.model.FileMetas;
import io.kestra.sdk.model.Level;
import io.kestra.sdk.model.PagedResultsAppsControllerApiApp;
import io.kestra.sdk.model.PagedResultsAppsControllerApiAppCatalogItem;
import io.kestra.sdk.model.EventAppResponse;
import io.kestra.sdk.model.QueryFilter;

import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class AppsApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String YAML = "application/x-yaml";
    private static final String OCTET_STREAM = "application/octet-stream";
    private static final String MULTIPART = "multipart/form-data";

    public AppsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public AppsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- Path builders ----

    private String tenantPath(String tenant, String... segments) {
        StringBuilder sb = new StringBuilder("/api/v1/");
        sb.append(esc(tenant));
        for (String s : segments) {
            sb.append("/").append(esc(s));
        }
        return sb.toString();
    }

    private String esc(String value) {
        return apiClient.escapeString(apiClient.parameterToString(value));
    }

    // ---- Query param builders ----

    private List<Pair> queryParams(Object... keyValues) {
        List<Pair> params = new ArrayList<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            String key = (String) keyValues[i];
            Object value = keyValues[i + 1];
            if (value != null) {
                params.addAll(apiClient.parameterToPair(key, value));
            }
        }
        return params;
    }

    private List<Pair> filterParams(@jakarta.annotation.Nullable List<QueryFilter> filters) {
        if (filters == null || filters.isEmpty()) {
            return Collections.emptyList();
        }
        return apiClient.parameterToPairs("csv", "filters", filters);
    }

    private List<Pair> csvParams(String name, @jakarta.annotation.Nullable List<String> values) {
        if (values == null || values.isEmpty()) {
            return Collections.emptyList();
        }
        return apiClient.parameterToPairs("csv", name, values);
    }

    // ---- HTTP helpers ----

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         TypeReference<T> returnType) throws ApiException {
        return invoke(method, path, body, queryParams, collectionQueryParams,
                accept, contentType, new HashMap<>(), returnType);
    }

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         Map<String, Object> formParams,
                         TypeReference<T> returnType) throws ApiException {
        return apiClient.invokeAPI(
                path, method,
                queryParams != null ? queryParams : Collections.emptyList(),
                collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
                "",
                body,
                new HashMap<>(),
                new HashMap<>(),
                formParams != null ? formParams : new HashMap<>(),
                accept, contentType, AUTH, returnType
        );
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    public AppsControllerApiAppSource createApp(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "apps"),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public AppsControllerApiAppSource app(
            @jakarta.annotation.Nonnull String uid,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "apps", uid),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void updateApp(
            @jakarta.annotation.Nonnull String uid,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        invoke("PUT",
                tenantPath(tenant, "apps", uid),
                yamlBody, null, null,
                JSON, YAML, null);
    }

    public void deleteApp(
            @jakarta.annotation.Nonnull String uid,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "apps", uid),
                null, null, null,
                JSON, null, null);
    }

    // ========================================================================
    // Enable / Disable
    // ========================================================================

    public AppsControllerApiApp enableApp(
            @jakarta.annotation.Nonnull String uid,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "apps", uid, "enable"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public AppsControllerApiApp disableApp(
            @jakarta.annotation.Nonnull String uid,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "apps", uid, "disable"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Bulk operations
    // ========================================================================

    public Object bulkDeleteApps(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull AppsControllerApiBulkOperationRequest request) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "apps"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object bulkEnableApps(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull AppsControllerApiBulkOperationRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "apps", "enable"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Object bulkDisableApps(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull AppsControllerApiBulkOperationRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "apps", "disable"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public byte[] bulkExportApps(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull AppsControllerApiBulkOperationRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "apps", "export"),
                request, null, null,
                OCTET_STREAM, JSON,
                new TypeReference<>() {});
    }

    public AppsControllerApiBulkImportResponse bulkImportApps(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable File fileUpload) throws ApiException {
        Map<String, Object> formParams = new HashMap<>();
        if (fileUpload != null) {
            formParams.put("fileUpload", fileUpload);
        }
        return invoke("POST",
                tenantPath(tenant, "apps", "import"),
                null, null, null,
                JSON, MULTIPART, formParams,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsAppsControllerApiApp searchApps(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable String q,
            @jakarta.annotation.Nullable String namespace,
            @jakarta.annotation.Nullable String flowId,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<String> tags,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(csvParams("tags", tags));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "apps", "search"),
                null,
                queryParams("page", page, "size", size, "q", q, "namespace", namespace, "flowId", flowId),
                collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public PagedResultsAppsControllerApiAppCatalogItem searchAppsFromCatalog(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "apps", "catalog"),
                null,
                queryParams("page", page, "size", size),
                filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Tags
    // ========================================================================

    public AppsControllerApiAppTags listTags(
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "apps", "tags"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // App execution helpers
    // ========================================================================

    public FileMetas fileMetaFromAppExecution(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull URI path,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "apps", "view", id, "file", "meta"),
                null, queryParams("path", path), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Object filePreviewFromAppExecution(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull URI path,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer maxRows,
            @jakarta.annotation.Nullable String encoding) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "apps", "view", id, "file", "preview"),
                null, queryParams("path", path, "maxRows", maxRows, "encoding", encoding), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public File logsFromAppExecution(
            @jakarta.annotation.Nonnull String uid,
            @jakarta.annotation.Nonnull String executionId,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Level minLevel,
            @jakarta.annotation.Nullable List<String> taskIds) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "apps", "view", uid, "logs", "download"),
                null,
                queryParams("executionId", executionId, "minLevel", minLevel),
                csvParams("taskIds", taskIds),
                OCTET_STREAM, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Streaming (SSE)
    // ========================================================================

    public Flux<EventAppResponse> streamEventsFromApp(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String stream,
            @jakarta.annotation.Nonnull String tenant) {
        return Flux.create(sink -> {
            AtomicReference<CloseableHttpResponse> responseRef = new AtomicReference<>();
            AtomicReference<BufferedReader> readerRef = new AtomicReference<>();

            sink.onDispose(() -> {
                try {
                    BufferedReader r = readerRef.get();
                    if (r != null) r.close();
                } catch (IOException ignored) {}
                try {
                    CloseableHttpResponse resp = responseRef.get();
                    if (resp != null) resp.close();
                } catch (IOException ignored) {}
            });

            try {
                CloseableHttpResponse response = apiClient.openEventStream(
                        tenantPath(tenant, "apps", "view", id, "streams", stream),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        "",
                        new HashMap<>(),
                        new HashMap<>(),
                        AUTH
                );
                responseRef.set(response);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
                readerRef.set(reader);

                String line;
                StringBuilder dataBuffer = new StringBuilder();

                while (!sink.isCancelled() && (line = reader.readLine()) != null) {
                    if (line.isEmpty()) {
                        if (dataBuffer.length() > 0) {
                            EventAppResponse ev = apiClient.getObjectMapper()
                                    .readValue(dataBuffer.toString(), EventAppResponse.class);
                            dataBuffer.setLength(0);
                            sink.next(ev);
                        }
                        continue;
                    }
                    if (line.startsWith("data:")) {
                        String payload = line.substring(5);
                        if (payload.startsWith(" ")) payload = payload.substring(1);
                        dataBuffer.append(payload).append('\n');
                    }
                }

                if (dataBuffer.length() > 0) {
                    EventAppResponse ev = apiClient.getObjectMapper()
                            .readValue(dataBuffer.toString(), EventAppResponse.class);
                    sink.next(ev);
                }
                sink.complete();
            } catch (IOException e) {
                if (!sink.isCancelled()) {
                    sink.error(new ApiException(e));
                }
            } catch (ApiException e) {
                sink.error(e);
            }
        });
    }

    // ========================================================================
    // BaseApi override
    // ========================================================================

    @Override
    public <T> T invokeAPI(String url, String method, Object request,
                           TypeReference<T> returnType,
                           Map<String, String> additionalHeaders) throws ApiException {
        String baseUrl = apiClient.getBaseURL(); String path = url.startsWith(baseUrl) ? url.substring(baseUrl.length()) : url;
        return apiClient.invokeAPI(
                path, method,
                Collections.emptyList(), Collections.emptyList(), "",
                request,
                additionalHeaders != null ? additionalHeaders : new HashMap<>(),
                new HashMap<>(), new HashMap<>(),
                JSON, JSON, AUTH, returnType
        );
    }
}
