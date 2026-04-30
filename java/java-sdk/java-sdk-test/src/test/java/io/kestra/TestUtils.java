package io.kestra;

import io.kestra.sdk.KestraClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.FlowWithSource;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterOp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class TestUtils {

    public static final String TENANT = "main";
    public static final String HOST = "http://localhost:9901";
    public static final String TEST_DATA_PATH = "../../../test-utils";

    // ========================================================================
    // Client
    // ========================================================================

    public static KestraClient client() {
        return KestraClient.builder()
                .basicAuth("root@root.com", "Root!1234")
                .url(HOST)
                .build();
    }

    // ========================================================================
    // ID & file helpers
    // ========================================================================

    public static String randomId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String readFile(String relativePath) {
        try {
            Path path = Path.of(relativePath);
            if (!path.isAbsolute()) {
                path = Path.of(System.getProperty("user.dir")).resolve(relativePath);
            }
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + relativePath, e);
        }
    }

    public static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    // ========================================================================
    // Flow fixtures (from test-utils YAML files)
    // ========================================================================

    public record FlowFixture(String body, String namespace, String id) {}

    public static FlowFixture simpleFlowFixture() {
        String id = randomId();
        String ns = randomId();
        String body = readFile(TEST_DATA_PATH + "/flows/simple_flow.yml")
                .replace("simple_flow_id_to_replace_by_random_id", id)
                .replace("simple_flow_namespace_to_replace_by_random_id", ns);
        return new FlowFixture(body, ns, id);
    }

    public static String completeFlowBody() {
        return readFile(TEST_DATA_PATH + "/flows/flow_complete.yml")
                .replace("flow_complete", randomId())
                .replace("tests", randomId());
    }

    // ========================================================================
    // Flow YAML templates (inline)
    // ========================================================================

    public static String logFlowYaml(String id, String ns) {
        return """
                id: %s
                namespace: %s
                description: a test flow

                tasks:
                  - id: hello
                    type: io.kestra.plugin.core.log.Log
                    message: Hello World!
                """.formatted(id, ns);
    }

    public static String logFlowYamlWithDescription(String id, String ns, String description) {
        return """
                id: %s
                namespace: %s
                description: %s

                tasks:
                  - id: hello
                    type: io.kestra.plugin.core.log.Log
                    message: Hello World!
                """.formatted(id, ns, description);
    }

    public static String twoTaskFlowYaml(String id, String ns) {
        return """
                id: %s
                namespace: %s
                description: two-task flow

                tasks:
                  - id: hello
                    type: io.kestra.plugin.core.log.Log
                    message: Hello World!
                  - id: goodbye
                    type: io.kestra.plugin.core.log.Log
                    message: Goodbye World!
                """.formatted(id, ns);
    }

    public static String concurrencyFlowYaml(String id, String ns, int limit) {
        return """
                id: %s
                namespace: %s
                concurrency:
                  behavior: QUEUE
                  limit: %d
                tasks:
                  - id: hello
                    type: io.kestra.plugin.core.log.Log
                    message: Hello World!
                """.formatted(id, ns, limit);
    }

    public static String invalidTaskFlowYaml(String id, String ns) {
        return """
                id: %s
                namespace: %s
                tasks:
                  - id: bad
                    type: io.kestra.plugin.nonexistent.BadTask
                """.formatted(id, ns);
    }

    // ========================================================================
    // Common creation helpers
    // ========================================================================

    public static FlowWithSource createFlow(String yaml) throws ApiException {
        FlowWithSource flow = client().flows().createFlow(TENANT, yaml);
        sleep(200);
        return flow;
    }

    public static FlowWithSource createLogFlow() throws ApiException {
        return createFlow(logFlowYaml(randomId(), randomId()));
    }

    // ========================================================================
    // Common filter helpers
    // ========================================================================

    public static QueryFilter nsFilter(String ns) {
        return new QueryFilter()
                .field(QueryFilterField.NAMESPACE)
                .operation(QueryFilterOp.EQUALS)
                .value(ns);
    }
}
