package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import io.kestra.sdk.model.MiscControllerEEConfiguration;

import java.util.Collections;

public class MiscApi extends BaseApi {

    public MiscApi() {
        super(Configuration.getDefaultApiClient());
    }

    public MiscApi(ApiClient apiClient) {
        super(apiClient);
    }

    public MiscControllerEEConfiguration configuration() throws ApiException {
        return invoke("GET", "/api/v1/configs",
                null, Collections.emptyList(), Collections.emptyList(),
                JSON, null,
                new TypeReference<>() {});
    }

}
