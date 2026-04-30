package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.BlueprintControllerApiBlueprintItemWithSource;
import io.kestra.sdk.model.BlueprintControllerApiFlowBlueprint;
import io.kestra.sdk.model.BlueprintControllerFlowBlueprintCreateOrUpdate;
import io.kestra.sdk.model.BlueprintControllerKind;
import io.kestra.sdk.model.BlueprintControllerUseBlueprintTemplateRequest;
import io.kestra.sdk.model.BlueprintControllerUseBlueprintTemplateResponse;
import io.kestra.sdk.model.BlueprintWithFlowEntity;
import io.kestra.sdk.model.PagedResultsBlueprintControllerApiBlueprintItem;
import io.kestra.sdk.model.PagedResultsBlueprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlueprintsApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String YAML_ACCEPT = "application/yaml";

    public BlueprintsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public BlueprintsApi(ApiClient apiClient) {
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
        return apiClient.invokeAPI(
                path, method,
                queryParams != null ? queryParams : Collections.emptyList(),
                collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
                "",
                body,
                new HashMap<>(),
                new HashMap<>(),
                new HashMap<>(),
                accept, contentType, AUTH, returnType
        );
    }

    // ========================================================================
    // Community Blueprints
    // ========================================================================

    public BlueprintControllerApiBlueprintItemWithSource blueprint(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull BlueprintControllerKind kind,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "community", kind.getValue(), id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> blueprintGraph(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull BlueprintControllerKind kind,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "community", kind.getValue(), id, "graph"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public String blueprintSource(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull BlueprintControllerKind kind,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "community", kind.getValue(), id, "source"),
                null, null, null,
                YAML_ACCEPT, null,
                new TypeReference<>() {});
    }

    public PagedResultsBlueprintControllerApiBlueprintItem searchBlueprints(
            @jakarta.annotation.Nonnull BlueprintControllerKind kind,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String q,
            @jakarta.annotation.Nullable String sort,
            @jakarta.annotation.Nullable List<String> tags,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "community", kind.getValue()),
                null,
                queryParams("q", q, "sort", sort, "page", page, "size", size),
                csvParams("tags", tags),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Flow Blueprints
    // ========================================================================

    public BlueprintControllerApiFlowBlueprint createFlowBlueprint(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull BlueprintControllerFlowBlueprintCreateOrUpdate request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "blueprints", "flows"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public BlueprintControllerApiFlowBlueprint flowBlueprintById(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "flows", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public BlueprintControllerApiFlowBlueprint updateFlowBlueprint(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull BlueprintControllerFlowBlueprintCreateOrUpdate request) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "blueprints", "flows", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteFlowBlueprints(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "blueprints", "flows", id),
                null, null, null,
                null, null, null);
    }

    public BlueprintControllerUseBlueprintTemplateResponse useBlueprintTemplate(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull BlueprintControllerUseBlueprintTemplateRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "blueprints", "flows", id, "use-template"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public BlueprintControllerApiFlowBlueprint flowBlueprint(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "flow", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Custom/Internal Blueprints (deprecated)
    // ========================================================================

    @Deprecated
    public BlueprintControllerApiBlueprintItemWithSource createInternalBlueprints(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull BlueprintControllerApiBlueprintItemWithSource request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "blueprints", "custom"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    @Deprecated
    public BlueprintControllerApiFlowBlueprint internalBlueprint(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "custom", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    @Deprecated
    public String internalBlueprintFlow(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "custom", id, "source"),
                null, null, null,
                YAML_ACCEPT, null,
                new TypeReference<>() {});
    }

    @Deprecated
    public BlueprintWithFlowEntity updateInternalBlueprints(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull BlueprintControllerApiBlueprintItemWithSource request) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "blueprints", "custom", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    @Deprecated
    public void deleteInternalBlueprints(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "blueprints", "custom", id),
                null, null, null,
                null, null, null);
    }

    public PagedResultsBlueprint searchInternalBlueprints(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String q,
            @jakarta.annotation.Nullable String sort,
            @jakarta.annotation.Nullable List<String> tags,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable Boolean source) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "blueprints", "custom"),
                null,
                queryParams("q", q, "sort", sort, "page", page, "size", size, "source", source),
                csvParams("tags", tags),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // BaseApi override
    // ========================================================================

    @Override
    public <T> T invokeAPI(String url, String method, Object request,
                           TypeReference<T> returnType,
                           Map<String, String> additionalHeaders) throws ApiException {
        String path = url.replace(apiClient.getBaseURL(), "");
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
