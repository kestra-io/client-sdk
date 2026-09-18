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
 * Case-template endpoints under {@code /api/v1/{tenant}/case-templates/**}: reusable
 * templates (default severity, assignees, watchers, SLA…) applied when opening a case.
 * Requires the {@code CASE} resource with the {@code TEMPLATE} action.
 */
public class CaseTemplatesApi extends BaseApi {

    public CaseTemplatesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public CaseTemplatesApi(ApiClient apiClient) {
        super(apiClient);
    }

    public Map<String, Object> searchCaseTemplates(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "case-templates", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createCaseTemplate(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "case-templates"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> getCaseTemplate(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "case-templates", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> updateCaseTemplate(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "case-templates", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteCaseTemplate(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "case-templates", id),
                null, null, null,
                JSON, null,
                null);
    }

}
