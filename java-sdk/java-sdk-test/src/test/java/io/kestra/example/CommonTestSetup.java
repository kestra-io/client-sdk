package io.kestra.example;

import io.kestra.sdk.KestraClient;

import java.util.UUID;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommonTestSetup {
    public static String MAIN_TENANT = "main";

    public static KestraClient kestraClient() {
        return KestraClient.builder()
            .basicAuth("root@root.com", "Root!1234")
            .url("http://localhost:9901")
            .build();
    }

    public static String randomId(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static final String TEST_DATA_PATH = "../../test-utils";

    public static String getCompleteFlow(){
        return get(TEST_DATA_PATH + "/flows/flow_complete.yml").replace("flow_complete", randomId());
    }

    public static String getSimpleFlow(){
        return get(TEST_DATA_PATH + "/flows/simple_flow.yml").replace("simple_flow", randomId());
    }

    public static String get(String filePath) {
        try {
            Path path = Paths.get(filePath);

            // If it's not absolute, resolve relative to project root
            if (!path.isAbsolute()) {
                // `user.dir` is usually the project root when running tests
                path = Paths.get(System.getProperty("user.dir")).resolve(filePath);
            }

            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file at " + filePath, e);
        }
    }
}
