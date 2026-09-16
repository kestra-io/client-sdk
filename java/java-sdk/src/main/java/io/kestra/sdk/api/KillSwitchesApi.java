package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import io.kestra.sdk.model.KillSwitch;

import java.util.List;

/**
 * Kill-switch endpoints under {@code /api/v1/kill-switches/**}: cluster-wide switches that
 * disable a Kestra feature. Not tenant-scoped and instance-owner-only.
 */
public class KillSwitchesApi extends BaseApi {

    public KillSwitchesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public KillSwitchesApi(ApiClient apiClient) {
        super(apiClient);
    }

    public KillSwitch createKillSwitch(
            @jakarta.annotation.Nonnull KillSwitch killSwitch) throws ApiException {
        return invoke("POST",
                apiPath("kill-switches"),
                killSwitch, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public KillSwitch updateKillSwitch(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull KillSwitch killSwitch) throws ApiException {
        return invoke("PUT",
                apiPath("kill-switches", id),
                killSwitch, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteKillSwitch(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                apiPath("kill-switches", id),
                null, null, null,
                JSON, null,
                null);
    }

    public List<KillSwitch> searchKillSwitches() throws ApiException {
        return invoke("GET",
                apiPath("kill-switches", "search"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

}
