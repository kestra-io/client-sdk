package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import io.kestra.sdk.model.Banner;
import io.kestra.sdk.model.QueryFilter;

import java.util.List;

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

    public Banner createBanner(
            @jakarta.annotation.Nonnull Banner banner) throws ApiException {
        return invoke("POST",
                apiPath("banners"),
                banner, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Banner updateBanner(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Banner banner) throws ApiException {
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

    public List<Banner> searchBanners(
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                apiPath("banners", "search"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

}
