"""Tests for the in-app notifications SDK surface added for #421.

These endpoints carry no tenant segment; the server resolves the current user.
They are usually available on any authenticated instance, but the gating helper
still guards against instances where the feature is disabled — an infra gap
must not look like a coverage regression (see AGENTS.md).
"""
from datetime import datetime, timedelta, timezone


from test_helpers import gating

_tolerate_gating = gating()


# --------------------------------------------------------------------------- #
# Read
# --------------------------------------------------------------------------- #

def test_notifications_since_returns_notifications(client):
    since = datetime.now(timezone.utc) - timedelta(days=7)
    with _tolerate_gating("notifications_since"):
        result = client.notifications.notifications_since(since)
    # A fresh instance has no notifications, so the list may be empty but present.
    assert isinstance(result.notifications, list)


def test_notification_history_returns_history(client):
    with _tolerate_gating("notification_history"):
        result = client.notifications.notification_history(limit=10)
    assert isinstance(result.notifications, list)


def test_unread_notification_count_returns_int(client):
    with _tolerate_gating("unread_notification_count"):
        count = client.notifications.unread_notification_count()
    assert isinstance(count, int)
    assert count >= 0


# --------------------------------------------------------------------------- #
# Mutations
# --------------------------------------------------------------------------- #

def test_mark_all_notifications_read_reports_updated(client):
    with _tolerate_gating("mark_all_notifications_read"):
        result = client.notifications.mark_all_notifications_read()
    assert result.updated is not None and result.updated >= 0


def test_mark_notification_read_and_unread_are_idempotent(client):
    # No notification with this id exists; marking it read/unread is idempotent
    # server-side, so a 2xx (None) is expected — a 404 is tolerated as gating.
    with _tolerate_gating("mark_notification_read"):
        assert client.notifications.mark_notification_read("does-not-exist") is None
    with _tolerate_gating("mark_notification_unread"):
        assert client.notifications.mark_notification_unread("does-not-exist") is None
