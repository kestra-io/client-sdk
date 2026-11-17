package io.kestra.sdk;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadTimeoutRoundingTest {
    @Test
    void subMillisecondReadTimeout_roundsUpToOneMs() {
        var client = KestraClient.builder().readTimeout(Duration.ofNanos(500_000)).build();
        assertEquals(1, client.apiClient().getReadTimeout());
    }

    @Test
    void zeroAndNegativeReadTimeout_meanNoTimeout() {
        assertEquals(0, KestraClient.builder().readTimeout(Duration.ZERO).build().apiClient().getReadTimeout());
        assertEquals(0, KestraClient.builder().readTimeout(Duration.ofSeconds(-1)).build().apiClient().getReadTimeout());
    }
}
