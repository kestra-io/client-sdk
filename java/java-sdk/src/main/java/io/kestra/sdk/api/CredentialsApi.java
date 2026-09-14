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
 * Tenant-level credential endpoints under {@code /api/v1/{tenant}/credentials/**}.
 * Requires the {@code CREDENTIAL} resource. Namespace-scoped credentials live on
 * {@link NamespacesApi}.
 */
public class CredentialsApi extends BaseApi {

    public CredentialsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public CredentialsApi(ApiClient apiClient) {
        super(apiClient);
    }

    public Map<String, Object> listCredentials(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                tenantPath(tenant, "credentials"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createCredential(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "credentials"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> getCredential(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "credentials", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> updateCredential(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "credentials", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteCredential(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "credentials", id),
                null, null, null,
                JSON, null,
                null);
    }

    public Map<String, Object> testCredentialConnection(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "credentials", id, "test"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

}
