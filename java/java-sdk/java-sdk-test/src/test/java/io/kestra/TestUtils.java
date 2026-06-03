package io.kestra;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.KestraClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.FlowWithSource;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterOp;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {

    public static final String TENANT = "main";
    public static final String HOST = "http://localhost:9901";
    public static final String TEST_DATA_PATH = "../../../test-utils";

    private static final String ADMIN_USERNAME = "root@root.com";
    private static final String ADMIN_PASSWORD = "Root!1234";
    private static final Pattern CSRF_META = Pattern.compile("<meta name=\"csrf-token\" content=\"([^\"]+)\">");

    private static volatile String apiToken;

    // ========================================================================
    // Client
    // ========================================================================

    public static KestraClient client() {
        return KestraClient.builder()
                .tokenAuth(apiToken())
                .url(HOST)
                .build();
    }

    // ========================================================================
    // Kestra 2.0 auth bootstrap
    // ========================================================================

    private static String apiToken() {
        if (apiToken == null) {
            synchronized (TestUtils.class) {
                if (apiToken == null) {
                    apiToken = mintApiToken();
                }
            }
        }
        return apiToken;
    }

    /**
     * Bootstrap auth against Kestra 2.0, which dropped both the config-based
     * super-admin and per-request HTTP Basic auth:
     * <ol>
     *   <li>create the first super-admin and the main tenant through
     *       {@code POST /api/v1/setup} (405 means a user already exists);</li>
     *   <li>login to get a JWT cookie;</li>
     *   <li>load the UI so StaticFilter sets the csrfToken cookie and exposes
     *       it in a meta tag;</li>
     *   <li>mint an API token — the JWT cookie authenticates, and the
     *       X-CSRF-TOKEN header equals the server-set csrfToken cookie
     *       (double-submit check).</li>
     * </ol>
     */
    private static String mintApiToken() {
        try {
            CookieManager cookies = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
            HttpClient http = HttpClient.newBuilder()
                    .cookieHandler(cookies)
                    // login answers with a 303 whose Set-Cookie carries the JWT;
                    // follow it like a browser (the cookie jar keeps the cookie)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .build();

            HttpResponse<String> setup = http.send(HttpRequest.newBuilder()
                    .uri(URI.create(HOST + "/api/v1/setup"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(
                            "{\"username\":\"%s\",\"password\":\"%s\",\"tenant\":{\"id\":\"%s\",\"name\":\"%s\"}}"
                                    .formatted(ADMIN_USERNAME, ADMIN_PASSWORD, TENANT, TENANT)))
                    .build(), HttpResponse.BodyHandlers.ofString());
            if (setup.statusCode() != 200 && setup.statusCode() != 405) {
                throw new IllegalStateException("setup failed: " + setup.statusCode() + " " + setup.body());
            }

            HttpResponse<String> login = http.send(HttpRequest.newBuilder()
                    .uri(URI.create(HOST + "/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(
                            "{\"username\":\"%s\",\"password\":\"%s\"}"
                                    .formatted(ADMIN_USERNAME, ADMIN_PASSWORD)))
                    .build(), HttpResponse.BodyHandlers.ofString());
            if (login.statusCode() < 200 || login.statusCode() >= 400) {
                throw new IllegalStateException("login failed: " + login.statusCode() + " " + login.body());
            }

            HttpResponse<String> ui = http.send(HttpRequest.newBuilder()
                    .uri(URI.create(HOST + "/ui/"))
                    .GET()
                    .build(), HttpResponse.BodyHandlers.ofString());
            Matcher matcher = CSRF_META.matcher(ui.body());
            if (!matcher.find()) {
                throw new IllegalStateException("no csrf token from /ui/ (status " + ui.statusCode() + ")");
            }
            String csrf = matcher.group(1);

            HttpResponse<String> tokenResponse = http.send(HttpRequest.newBuilder()
                    .uri(URI.create(HOST + "/api/v1/me/api-tokens"))
                    .header("Content-Type", "application/json")
                    .header("X-CSRF-TOKEN", csrf)
                    .POST(HttpRequest.BodyPublishers.ofString("{\"name\":\"ci-token\",\"maxAge\":\"P1D\"}"))
                    .build(), HttpResponse.BodyHandlers.ofString());
            if (tokenResponse.statusCode() != 200 && tokenResponse.statusCode() != 201) {
                throw new IllegalStateException("create api token failed: "
                        + tokenResponse.statusCode() + " " + tokenResponse.body());
            }

            String fullToken = new ObjectMapper().readTree(tokenResponse.body()).path("fullToken").asText(null);
            if (fullToken == null || fullToken.isEmpty()) {
                throw new IllegalStateException("api token response had no fullToken: " + tokenResponse.body());
            }
            return fullToken;
        } catch (IOException e) {
            throw new IllegalStateException("Kestra auth bootstrap failed", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Kestra auth bootstrap interrupted", e);
        }
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

    public static QueryFilter queryFilter(String q) {
        return new QueryFilter()
                .field(QueryFilterField.QUERY)
                .operation(QueryFilterOp.EQUALS)
                .value(q);
    }

    public static QueryFilter flowIdFilter(String flowId) {
        return new QueryFilter()
                .field(QueryFilterField.FLOW_ID)
                .operation(QueryFilterOp.EQUALS)
                .value(flowId);
    }

    public static QueryFilter stateFilter(String state) {
        return new QueryFilter()
                .field(QueryFilterField.STATE)
                .operation(QueryFilterOp.EQUALS)
                .value(state);
    }

    public static QueryFilter nameFilter(String name) {
        return new QueryFilter()
                .field(QueryFilterField.NAME)
                .operation(QueryFilterOp.EQUALS)
                .value(name);
    }

    public static QueryFilter labelsFilter(Map<String, String> labels) {
        return new QueryFilter()
                .field(QueryFilterField.LABELS)
                .operation(QueryFilterOp.EQUALS)
                .value(labels);
    }

    public static QueryFilter minLevelFilter(String level) {
        return new QueryFilter()
                .field(QueryFilterField.MIN_LEVEL)
                .operation(QueryFilterOp.EQUALS)
                .value(level);
    }

    public static QueryFilter executionIdFilter(String executionId) {
        return new QueryFilter()
                .field(QueryFilterField.EXECUTION_ID)
                .operation(QueryFilterOp.EQUALS)
                .value(executionId);
    }

    public static QueryFilter typeFilter(String type) {
        return new QueryFilter()
                .field(QueryFilterField.TYPE)
                .operation(QueryFilterOp.EQUALS)
                .value(type);
    }

    public static String logFlowYamlWithLabels(String id, String ns, Map<String, String> labels) {
        StringBuilder labelsYaml = new StringBuilder();
        labels.forEach((k, v) -> labelsYaml.append("  ").append(k).append(": ").append(v).append("\n"));
        return """
                id: %s
                namespace: %s
                description: a test flow with labels
                labels:
                %s
                tasks:
                  - id: hello
                    type: io.kestra.plugin.core.log.Log
                    message: Hello World!
                """.formatted(id, ns, labelsYaml.toString().stripTrailing());
    }
}
