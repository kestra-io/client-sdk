package io.kestra.example;

import io.kestra.sdk.api.AuthsApi;
import io.kestra.sdk.api.FlowsApi;
import io.kestra.sdk.api.MiscApi;
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.model.Flow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class BasicSDKUsageExample {
    private static final Logger logger = LoggerFactory.getLogger(BasicSDKUsageExample.class);
    public static String MAIN_TENANT = "main";
    static ApiClient defaultClient = Configuration.getDefaultApiClient()
        .setUsername("admin@kestra.io")
        .setPassword("Admin1234")
        .setBasePath("http://localhost:9901");

    // ee only
    public static String getCurrentUser() {
        AuthsApi authsApi = new AuthsApi(defaultClient);
        try {
            var user = authsApi.getCurrentUser();
            logger.debug("{}", user);
            return user.getId();
        } catch (
            ApiException e) {
            logger.error("Exception when calling API", e);
            logger.error("Status code: {}", e.getCode());
            logger.error("Reason: {}", e.getResponseBody());
            logger.error("Response headers: {}", e.getResponseHeaders());
            throw new RuntimeException(e);
        }
    }

    public static String getInstanceConfEdition() {
        MiscApi miscApi = new MiscApi(defaultClient);
        try {
            var conf = miscApi.getConfiguration();
            logger.debug("{}", conf);
            return conf.getEdition() != null ? conf.getEdition().getValue() : "";
        } catch (
            ApiException e) {
            logger.error("Exception when calling API", e);
            logger.error("Status code: {}", e.getCode());
            logger.error("Reason: {}", e.getResponseBody());
            logger.error("Response headers: {}", e.getResponseHeaders());
            throw new RuntimeException(e);
        }
    }

    public static List<Flow> listFlows() {
        FlowsApi flowsApi = new FlowsApi(defaultClient);
        try {
            var flows = flowsApi.searchFlows(1, 50, MAIN_TENANT, null, null, null, null, null, null, Map.of());
            logger.debug("{}", flows);
            return flows.getResults();
        } catch (
            ApiException e) {
            logger.error("Exception when calling API", e);
            logger.error("Status code: {}", e.getCode());
            logger.error("Reason: {}", e.getResponseBody());
            throw new RuntimeException(e);
        }
    }
}