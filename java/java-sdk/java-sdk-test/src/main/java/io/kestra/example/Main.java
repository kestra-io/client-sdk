package io.kestra.example;

import io.kestra.sdk.KestraClient;

/**
 * Local runner for {@link BasicSDKUsageExample}. Point it at a running Kestra
 * and execute it by hand; CI exercises the same example through
 * {@code BasicSDKUsageExampleTest} instead.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        KestraClient client = KestraClient.builder()
            .url("http://localhost:9901")
            .basicAuth("root@root.com", "Root!1234")
            .build();

        BasicSDKUsageExample.flowLifecycle(client, "main");
    }
}
