package io.kestra.example;

import io.kestra.sdk.KestraClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.Flow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class BasicSDKUsageExample {
    private static final Logger logger = LoggerFactory.getLogger(BasicSDKUsageExample.class);
    public static String MAIN_TENANT = "main";
    private static final KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:9901")
        .build();

    public static List<Flow> listFlows() {
        try {
            var flows = kestraClient.flows().searchFlows(1, 50, MAIN_TENANT, null, null, null, null, null, null, Map.of());
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