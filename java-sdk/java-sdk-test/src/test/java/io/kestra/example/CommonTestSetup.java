package io.kestra.example;

import io.kestra.sdk.KestraClient;

public class CommonTestSetup {
    public static String MAIN_TENANT = "main";

    public static KestraClient kestraClient() {
        return KestraClient.builder()
            .basicAuth("root@root.com", "Root!1234")
            .url("http://localhost:9901")
            .build();
    }
}
