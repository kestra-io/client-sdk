package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.QueryFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Promotion-target endpoints under {@code /api/v1/{tenant}/promotion-targets/**}: the
 * remote Kestra instances a tenant can promote flows to. Requires the
 * {@code PROMOTION_TARGET} resource and the EE {@code FEATURE_PROMOTE} license feature.
 */
public class PromotionTargetsApi extends BaseApi {

    public PromotionTargetsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public PromotionTargetsApi(ApiClient apiClient) {
        super(apiClient);
    }

    public Map<String, Object> listPromotionTargets(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "promotion-targets"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createPromotionTarget(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "promotion-targets"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> getPromotionTarget(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "promotion-targets", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> updatePromotionTarget(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "promotion-targets", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deletePromotionTarget(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "promotion-targets", id),
                null, null, null,
                JSON, null,
                null);
    }

    public Map<String, Object> getTargetFlowSource(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String flowId,
            @jakarta.annotation.Nullable Integer revision) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "promotion-targets", id, "flow-source"),
                null, queryParams("namespace", namespace, "flowId", flowId, "revision", revision), null,
                JSON, null,
                new TypeReference<>() {});
    }

    /**
     * Tests connectivity for an unsaved promotion target described by {@code request}.
     * Pass {@code id} to test against the credentials of an existing target being edited,
     * or {@code null} for a brand-new one.
     */
    public Map<String, Object> testPromotionTarget(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> request,
            @jakarta.annotation.Nullable String id) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "promotion-targets", "test"),
                request, queryParams("id", id), null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> getTargetFlowHashes(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "promotion-targets", id, "flow-hashes"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> testSavedPromotionTarget(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "promotion-targets", id, "test"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

}
