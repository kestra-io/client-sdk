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
 * Security-integration (SCIM) endpoints under {@code /api/v1/{tenant}/security-integrations/**}.
 * Instance-owner only and gated by the EE {@code FEATURE_SCIM} license feature.
 */
public class SecurityIntegrationsApi extends BaseApi {

    public SecurityIntegrationsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public SecurityIntegrationsApi(ApiClient apiClient) {
        super(apiClient);
    }

    /** @deprecated use {@link #searchSecurityIntegrations} — the backend route is deprecated. */
    @Deprecated
    public Map<String, Object> listSecurityIntegrations(
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "security-integrations"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> searchSecurityIntegrations(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "security-integrations", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getSecurityIntegration(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "security-integrations", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createSecurityIntegration(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "security-integrations"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteSecurityIntegration(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "security-integrations", id),
                null, null, null,
                JSON, null,
                null);
    }

    public Map<String, Object> enableSecurityIntegration(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "security-integrations", id, "enable"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> disableSecurityIntegration(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "security-integrations", id, "disable"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

}
