package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the notification endpoints under {@code /api/v1/notifications/**}. These are
 * scoped to the authenticated user (not tenant-scoped) and return real, if empty, payloads for
 * a freshly bootstrapped account.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NotificationsApiTest {

    static NotificationsApi api() {
        return client().notifications();
    }

    @Test
    void unreadCount_isNonNegative() throws ApiException {
        Long count = api().unreadNotificationCount();

        assertThat(count).isNotNull();
        assertThat(count).isGreaterThanOrEqualTo(0L);
    }

    @Test
    void history_returnsNotificationsAndServerTime() throws ApiException {
        Map<String, Object> result = api().notificationHistory(null, 10);

        assertThat(result).containsKeys("notifications", "serverTime");
        assertThat(result.get("notifications")).isInstanceOf(java.util.List.class);
    }

    @Test
    void markAllRead_returnsUpdatedCount() throws ApiException {
        Map<String, Object> result = api().markAllNotificationsRead();

        assertThat(result).containsKey("updated");
        assertThat(((Number) result.get("updated")).intValue()).isGreaterThanOrEqualTo(0);
    }
}
