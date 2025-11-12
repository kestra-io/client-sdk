/*
This class is the only class that is not generated.
It is an easy-to-use entry point to create a client and access the different API endpoints.
 */
package io.kestra.sdk;


import io.kestra.sdk.api.*;
import io.kestra.sdk.api.*;
import io.kestra.sdk.internal.ApiClient;

import java.util.Base64;
import java.util.Objects;

/**
 * KestraClient is the main entry point to the Kestra API SDK.
 * You can create a client via its builder, then you can call any of its methods to access API endpoints.
 * <p>
 * For example, to access the Flows endpoint:
 * <pre>
 *     var kestraClient = KestraClient.builder().url("https://my-kestra-instance.org").build();
 *     var flowApi = kestraClient.flows();
 * </pre>
 */
// TODO we may want to generate it via a template
public class KestraClient {
    private final ApiClient apiClient;

    /**
     * Creates a KestraClient builder.
     * Use this build to instantiate a new client.
     */
    public static KestraClientBuilder builder() {
        return new KestraClientBuilder();
    }

    KestraClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    // FIXME we may want to hide some API from the generator (and also from the OpenAPI spec) as some are only there for the UI
    // START -- Individual API


    public ExecutionsApi executions() {
        return new ExecutionsApi(this.apiClient);
    }

    public FlowsApi flows() {
        return new FlowsApi(this.apiClient);
    }

    public GroupsApi groups() {
        return new GroupsApi(this.apiClient);
    }

    public KvApi kv() {
        return new KvApi(this.apiClient);
    }

    public NamespacesApi namespaces() {
        return new NamespacesApi(this.apiClient);
    }

    public RolesApi roles() {
        return new RolesApi(this.apiClient);
    }

    public TriggersApi triggers() {
        return new TriggersApi(this.apiClient);
    }

    public UsersApi users() {
        return new UsersApi(this.apiClient);
    }

    public ServiceAccountApi serviceAccount() { return new ServiceAccountApi(this.apiClient); }

    public TestSuitesApi testSuites() { return new TestSuitesApi(this.apiClient); }

    // END -- Individual API

    /**
     * Builder for a KestraClient.
     */
    public static class KestraClientBuilder {
        private String url = "http://localhost:8080";
        private Auth auth = Auth.BASIC;
        private String token;
        private String username;
        private String password;

        /**
         * The base URL of the Kestra API.
         * Will default to http://localhost:8080 if not set.
         */
        public KestraClientBuilder url(String url) {
            this.url = Objects.requireNonNull(url);
            return this;
        }

        /**
         * Enable Bearer Token authentication.
         */
        public KestraClientBuilder tokenAuth(String token) {
            this.token = Objects.requireNonNull(token);
            this.auth = Auth.TOKEN;

            return this;
        }

        /**
         * Enable Basic authentication.
         */
        public KestraClientBuilder basicAuth(String username, String password) {
            this.username = Objects.requireNonNull(username);
            this.password = Objects.requireNonNull(password);
            this.auth = Auth.BASIC;

            return this;
        }

        public KestraClient build() {
            ApiClient apiClient = new ApiClient();
            apiClient.setBasePath(url);
            switch (auth) {
                case TOKEN: {
                    apiClient.addDefaultHeader("Authorization", "Bearer " + token);
                    break;
                }
                case BASIC: {
                    String basicAuth = username + ":" + password;
                    apiClient.addDefaultHeader("Authorization", "Basic " + new String(Base64.getEncoder().encode(basicAuth.getBytes())));
                    break;
                }
            }

            return new KestraClient(apiClient);
        }
    }

    public enum Auth { NONE, BASIC, TOKEN }
}
