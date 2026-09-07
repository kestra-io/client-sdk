package io.kestra.sdk;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

class KestraClientAuthTest {

    @Test
    void noCredentials_sendsNoAuthorizationHeader() {
        var client = KestraClient.builder().build();
        assertThat(client.apiClient().getDefaultHeaders()).doesNotContainKey("Authorization");
    }

    @Test
    void noAuth_sendsNoAuthorizationHeader() {
        var client = KestraClient.builder().noAuth().build();
        assertThat(client.apiClient().getDefaultHeaders()).doesNotContainKey("Authorization");
    }

    @Test
    void noAuth_overridesBasicAuth() {
        var client = KestraClient.builder().basicAuth("user", "pass").noAuth().build();
        assertThat(client.apiClient().getDefaultHeaders()).doesNotContainKey("Authorization");
    }

    @Test
    void noAuth_overridesTokenAuth() {
        var client = KestraClient.builder().tokenAuth("my-token").noAuth().build();
        assertThat(client.apiClient().getDefaultHeaders()).doesNotContainKey("Authorization");
    }

    @Test
    void basicAuth_overridesNoAuth() {
        var client = KestraClient.builder().noAuth().basicAuth("user", "pass").build();
        assertThat(client.apiClient().getDefaultHeaders())
                .containsEntry("Authorization", "Basic " + base64("user:pass"));
    }

    @Test
    void basicAuth_sendsBase64EncodedCredentials() {
        var client = KestraClient.builder().basicAuth("user", "pass").build();
        assertThat(client.apiClient().getDefaultHeaders())
                .containsEntry("Authorization", "Basic " + base64("user:pass"));
    }

    @Test
    void tokenAuth_sendsBearerToken() {
        var client = KestraClient.builder().tokenAuth("my-token").build();
        assertThat(client.apiClient().getDefaultHeaders())
                .containsEntry("Authorization", "Bearer my-token");
    }

    @Test
    void defaultHeaders_isASnapshot() {
        var apiClient = KestraClient.builder().build().apiClient();
        var headers = apiClient.getDefaultHeaders();

        apiClient.addDefaultHeader("Authorization", "Bearer sneaked-in");

        assertThat(headers).doesNotContainKey("Authorization");
    }

    private static String base64(String credentials) {
        return Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
    }
}
