package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.model.BlueprintControllerApiBlueprintItemWithSource;
import io.kestra.sdk.model.BlueprintControllerApiFlowBlueprint;
import io.kestra.sdk.model.BlueprintControllerFlowBlueprintCreateOrUpdate;
import io.kestra.sdk.model.BlueprintControllerKind;
import io.kestra.sdk.model.BlueprintControllerUseBlueprintTemplateRequest;
import io.kestra.sdk.model.BlueprintControllerUseBlueprintTemplateResponse;
import io.kestra.sdk.model.BlueprintWithFlowEntity;
import io.kestra.sdk.model.PagedResultsBlueprintControllerApiBlueprintItem;
import io.kestra.sdk.model.PagedResultsBlueprint;

import java.util.List;
import java.util.Map;

public class BlueprintsApi extends BaseApi {

    private static final String YAML_ACCEPT = "application/yaml";

    public BlueprintsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public BlueprintsApi(ApiClient apiClient) {
        super(apiClient);
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

    /**
     * Search community blueprints.
     *
     * <p>Community blueprints are served from the external Kestra blueprint catalog and
     * proxied through the server unchanged. <strong>The {@code sort} value is currently
     * ignored by the catalog</strong>: it returns a fixed, curated order regardless of the
     * expression passed (e.g. {@code "title:asc"} and {@code "title:desc"} yield identical
     * results). Do not rely on {@code sort} to order community blueprints — sort the results
     * client-side if a specific order is required.
     *
     * @param sort catalog sort expression, e.g. {@code "field:asc"} / {@code "field:desc"};
     *             accepted for API-contract parity but currently ignored by the community catalog
     */
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

}
