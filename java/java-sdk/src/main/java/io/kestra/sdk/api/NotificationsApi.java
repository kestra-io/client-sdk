package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * Notification endpoints under {@code /api/v1/notifications/**}: the in-app notifications of
 * the authenticated user. Not tenant-scoped — they span every tenant the caller can access.
 */
public class NotificationsApi extends BaseApi {

    public NotificationsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public NotificationsApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Interval-polling delta: notifications updated strictly after {@code since} (an ISO-8601
     * instant), plus a fresh {@code serverTime} to pass as {@code since} on the next poll.
     */
    public Map<String, Object> pollNotificationsSince(
            @jakarta.annotation.Nonnull OffsetDateTime since) throws ApiException {
        return invoke("GET",
                apiPath("notifications", "since"),
                null, queryParams("since", since), null,
                JSON, null,
                new TypeReference<>() {});
    }

    /**
     * Cursor-based history: up to {@code limit} notifications older than {@code before} (a
     * {@code <createdDate>,<id>} cursor; {@code null} for the first page), plus a
     * {@code nextCursor} for the following page.
     */
    public Map<String, Object> notificationHistory(
            @jakarta.annotation.Nullable String before,
            @jakarta.annotation.Nullable Integer limit) throws ApiException {
        return invoke("GET",
                apiPath("notifications", "history"),
                null, queryParams("before", before, "limit", limit), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Long unreadNotificationCount() throws ApiException {
        return invoke("GET",
                apiPath("notifications", "unread-count"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void markNotificationRead(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("POST",
                apiPath("notifications", id, "read"),
                null, null, null,
                JSON, null,
                null);
    }

    public void markNotificationUnread(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("POST",
                apiPath("notifications", id, "unread"),
                null, null, null,
                JSON, null,
                null);
    }

    public Map<String, Object> markAllNotificationsRead() throws ApiException {
        return invoke("POST",
                apiPath("notifications", "read-all"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

}
