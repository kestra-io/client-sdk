package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import io.kestra.sdk.model.QueryFilter;

import java.util.List;
import java.util.Map;

/**
 * Announcement-banner endpoints under {@code /api/v1/banners/**}: global banners shown to
 * every tenant. Not tenant-scoped and instance-owner-only.
 */
public class BannersApi extends BaseApi {

    public BannersApi() {
        super(Configuration.getDefaultApiClient());
    }

    public BannersApi(ApiClient apiClient) {
        super(apiClient);
    }

    public Map<String, Object> createBanner(
            @jakarta.annotation.Nonnull Map<String, Object> banner) throws ApiException {
        return invoke("POST",
                apiPath("banners"),
                banner, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> updateBanner(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> banner) throws ApiException {
        return invoke("PUT",
                apiPath("banners", id),
                banner, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteBanner(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                apiPath("banners", id),
                null, null, null,
                JSON, null,
                null);
    }

    public List<Map<String, Object>> searchBanners(
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                apiPath("banners", "search"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

}
