package kestra_api_client

import (
	"context"
	"time"
)

// NotificationsAPI covers /api/v1/notifications — the in-app notifications of
// the currently authenticated user. These paths carry no tenant segment; the
// server resolves the current user and their accessible tenants.
type NotificationsAPI struct {
	baseAPI
}

// ApiNotification is a single in-app notification.
type ApiNotification struct {
	Id          string     `json:"id"`
	UserId      string     `json:"userId,omitempty"`
	TenantId    string     `json:"tenantId,omitempty"`
	Type        string     `json:"type,omitempty"`
	Title       string     `json:"title,omitempty"`
	ReferenceId string     `json:"referenceId,omitempty"`
	Current     *int       `json:"current,omitempty"`
	Total       *int       `json:"total,omitempty"`
	Read        bool       `json:"read"`
	CreatedDate *time.Time `json:"createdDate,omitempty"`
	UpdatedDate *time.Time `json:"updatedDate,omitempty"`
}

func (o *ApiNotification) GetId() string    { return o.Id }
func (o *ApiNotification) GetRead() bool    { return o.Read }
func (o *ApiNotification) GetTitle() string { return o.Title }

// ApiNotificationsSince is the response of GET /api/v1/notifications/since.
type ApiNotificationsSince struct {
	Notifications []ApiNotification `json:"notifications,omitempty"`
	ServerTime    *time.Time        `json:"serverTime,omitempty"`
}

func (o *ApiNotificationsSince) GetNotifications() []ApiNotification { return o.Notifications }

// ApiNotificationHistory is the response of GET /api/v1/notifications/history.
// It is cursor-paginated: pass NextCursor back as `before` to page further.
type ApiNotificationHistory struct {
	Notifications []ApiNotification `json:"notifications,omitempty"`
	ServerTime    *time.Time        `json:"serverTime,omitempty"`
	NextCursor    string            `json:"nextCursor,omitempty"`
}

func (o *ApiNotificationHistory) GetNotifications() []ApiNotification { return o.Notifications }
func (o *ApiNotificationHistory) GetNextCursor() string               { return o.NextCursor }

// ApiMarkAllRead is the response of POST /api/v1/notifications/read-all.
type ApiMarkAllRead struct {
	Updated int `json:"updated"`
}

func (o *ApiMarkAllRead) GetUpdated() int { return o.Updated }

// NotificationsSince returns notifications created since the given instant.
// Backs GET /api/v1/notifications/since.
func (a *NotificationsAPI) NotificationsSince(ctx context.Context, since time.Time) (*ApiNotificationsSince, error) {
	params := buildQueryParams("since", since.UTC().Format(time.RFC3339))
	return doJSON[*ApiNotificationsSince](&a.baseAPI, ctx, "GET", superadminPath("notifications", "since"), nil, params)
}

// NotificationHistory returns a cursor-paginated page of the current user's
// notification history. `before` is an opaque cursor (nil for the first page);
// `limit` defaults to 20 server-side when nil. Backs GET /api/v1/notifications/history.
func (a *NotificationsAPI) NotificationHistory(ctx context.Context, before *string, limit *int) (*ApiNotificationHistory, error) {
	params := buildQueryParams("before", before, "limit", limit)
	return doJSON[*ApiNotificationHistory](&a.baseAPI, ctx, "GET", superadminPath("notifications", "history"), nil, params)
}

// UnreadNotificationCount returns the number of unread notifications for the
// current user. Backs GET /api/v1/notifications/unread-count.
func (a *NotificationsAPI) UnreadNotificationCount(ctx context.Context) (int64, error) {
	return doJSON[int64](&a.baseAPI, ctx, "GET", superadminPath("notifications", "unread-count"), nil, nil)
}

// MarkNotificationRead marks a notification read. Idempotent. Backs POST
// /api/v1/notifications/{id}/read.
func (a *NotificationsAPI) MarkNotificationRead(ctx context.Context, id string) error {
	return a.doVoidJSON(ctx, "POST", superadminPath("notifications", id, "read"), nil, nil)
}

// MarkNotificationUnread marks a notification unread. Idempotent. Backs POST
// /api/v1/notifications/{id}/unread.
func (a *NotificationsAPI) MarkNotificationUnread(ctx context.Context, id string) error {
	return a.doVoidJSON(ctx, "POST", superadminPath("notifications", id, "unread"), nil, nil)
}

// MarkAllNotificationsRead marks every notification of the current user read.
// Backs POST /api/v1/notifications/read-all.
func (a *NotificationsAPI) MarkAllNotificationsRead(ctx context.Context) (*ApiMarkAllRead, error) {
	return doJSON[*ApiMarkAllRead](&a.baseAPI, ctx, "POST", superadminPath("notifications", "read-all"), nil, nil)
}
