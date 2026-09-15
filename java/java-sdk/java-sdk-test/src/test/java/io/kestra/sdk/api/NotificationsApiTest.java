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

    @Test
    void pollSince_returnsNotificationsAndServerTime() throws ApiException {
        // An epoch-start instant returns everything since the beginning of time (an empty list
        // for a fresh account) plus a fresh serverTime to pass on the next poll.
        Map<String, Object> result = api().pollNotificationsSince("1970-01-01T00:00:00Z");

        assertThat(result).containsKeys("notifications", "serverTime");
        assertThat(result.get("notifications")).isInstanceOf(java.util.List.class);
    }

    @Test
    void markRead_unknownId_isNoOp() {
        // The controller documents these as idempotent: a missing/foreign id is a no-op, not an
        // error — so the call returns cleanly rather than throwing.
        assertThatCode(() -> api().markNotificationRead("does-not-exist-" + randomId()))
                .doesNotThrowAnyException();
    }

    @Test
    void markUnread_unknownId_isNoOp() {
        assertThatCode(() -> api().markNotificationUnread("does-not-exist-" + randomId()))
                .doesNotThrowAnyException();
    }
}
