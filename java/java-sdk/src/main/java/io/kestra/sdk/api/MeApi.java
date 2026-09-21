package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import java.util.List;
import java.util.Map;

/**
 * Endpoints scoped to the currently-authenticated user under {@code /api/v1/me/**}:
 * the user's own profile and personal API tokens. Not tenant-scoped.
 */
public class MeApi extends BaseApi {

    public MeApi() {
        super(Configuration.getDefaultApiClient());
    }

    public MeApi(ApiClient apiClient) {
        super(apiClient);
    }

    public Map<String, Object> getCurrentUser() throws ApiException {
        return invoke("GET",
                apiPath("me"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> patchCurrentUser(
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("PATCH",
                apiPath("me"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> listApiTokens() throws ApiException {
        return invoke("GET",
                apiPath("me", "api-tokens"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createApiToken(
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                apiPath("me", "api-tokens"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteApiToken(
            @jakarta.annotation.Nonnull String tokenId) throws ApiException {
        invoke("DELETE",
                apiPath("me", "api-tokens", tokenId),
                null, null, null,
                JSON, null,
                null);
    }

    public List<Map<String, Object>> listInvitations() throws ApiException {
        return invoke("GET",
                apiPath("me", "invitations"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

}
