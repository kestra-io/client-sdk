package io.kestra.sdk;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

class KestraClientTimeoutTest {

    @Test
    void defaultTimeouts_areInfinite() {
        var client = KestraClient.builder().build();
        assertThat(client.apiClient().getConnectTimeout()).isEqualTo(0);
        assertThat(client.apiClient().getReadTimeout()).isEqualTo(0);
    }

    @Test
    void connectTimeout_propagatesToApiClient() {
        var client = KestraClient.builder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        assertThat(client.apiClient().getConnectTimeout()).isEqualTo(5_000);
        assertThat(client.apiClient().getReadTimeout()).isEqualTo(0);
    }

    @Test
    void readTimeout_propagatesToApiClient() {
        var client = KestraClient.builder()
                .readTimeout(Duration.ofSeconds(30))
                .build();
        assertThat(client.apiClient().getConnectTimeout()).isEqualTo(0);
        assertThat(client.apiClient().getReadTimeout()).isEqualTo(30_000);
    }

    @Test
    void bothTimeouts_propagateIndependently() {
        var client = KestraClient.builder()
                .connectTimeout(Duration.ofMillis(2_500))
                .readTimeout(Duration.ofMinutes(2))
                .build();
        assertThat(client.apiClient().getConnectTimeout()).isEqualTo(2_500);
        assertThat(client.apiClient().getReadTimeout()).isEqualTo(120_000);
    }
}
