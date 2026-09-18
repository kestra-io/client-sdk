from datetime import datetime, timezone
from typing import Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.notification_controller_api_mark_all_read import (
    NotificationControllerApiMarkAllRead,
)
from kestrapy.models.notification_controller_api_notification_history import (
    NotificationControllerApiNotificationHistory,
)
from kestrapy.models.notification_controller_api_notifications_since import (
    NotificationControllerApiNotificationsSince,
)


class NotificationsApi(BaseApi):
    """In-app notifications of the current user (`/api/v1/notifications`).

    These paths carry no tenant segment; the server resolves the current user
    and their accessible tenants.
    """

    def notifications_since(self, since: datetime) -> NotificationControllerApiNotificationsSince:
        """Return notifications created since the given instant.
        Backs GET /api/v1/notifications/since."""
        if since.tzinfo is None:
            since = since.replace(tzinfo=timezone.utc)
        stamp = since.astimezone(timezone.utc).strftime("%Y-%m-%dT%H:%M:%SZ")
        params = self._build_query_params(since=stamp)
        path = self._superadmin_path("notifications", "since")
        return self._json_request("GET", path, NotificationControllerApiNotificationsSince, params=params)

    def notification_history(
        self, before: Optional[str] = None, limit: Optional[int] = None
    ) -> NotificationControllerApiNotificationHistory:
        """Return a cursor-paginated page of the current user's notification
        history. ``before`` is an opaque cursor (None for the first page);
        ``limit`` defaults to 20 server-side. Backs GET /api/v1/notifications/history."""
        params = self._build_query_params(before=before, limit=limit)
        path = self._superadmin_path("notifications", "history")
        return self._json_request("GET", path, NotificationControllerApiNotificationHistory, params=params)

    def unread_notification_count(self) -> int:
        """Return the number of unread notifications for the current user.
        Backs GET /api/v1/notifications/unread-count."""
        path = self._superadmin_path("notifications", "unread-count")
        return self._json_request("GET", path, int)

    def mark_notification_read(self, id: str) -> None:
        """Mark a notification read (idempotent). Backs POST /api/v1/notifications/{id}/read."""
        path = self._superadmin_path("notifications", id, "read")
        self._void_request("POST", path)

    def mark_notification_unread(self, id: str) -> None:
        """Mark a notification unread (idempotent). Backs POST /api/v1/notifications/{id}/unread."""
        path = self._superadmin_path("notifications", id, "unread")
        self._void_request("POST", path)

    def mark_all_notifications_read(self) -> NotificationControllerApiMarkAllRead:
        """Mark every notification of the current user read.
        Backs POST /api/v1/notifications/read-all."""
        path = self._superadmin_path("notifications", "read-all")
        return self._json_request("POST", path, NotificationControllerApiMarkAllRead)
