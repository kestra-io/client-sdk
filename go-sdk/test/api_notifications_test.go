package test

import (
	"context"
	"testing"
	"time"

	"github.com/stretchr/testify/require"
)

func TestNotificationsAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	t.Run("unreadCount", func(t *testing.T) {
		count, err := client.Notifications().UnreadNotificationCount(ctx)
		require.NoError(t, err)
		require.GreaterOrEqual(t, count, int64(0), "the unread count is a non-negative number")
	})

	t.Run("history", func(t *testing.T) {
		limit := 20
		history, err := client.Notifications().NotificationHistory(ctx, nil, &limit)
		require.NoError(t, err)
		require.NotNil(t, history)
		require.NotNil(t, history.ServerTime, "the history response stamps a server time")
		for _, n := range history.GetNotifications() {
			require.NotEmpty(t, n.GetId(), "each notification has an id")
		}
	})

	t.Run("since", func(t *testing.T) {
		since, err := client.Notifications().NotificationsSince(ctx, time.Now().Add(-24*time.Hour))
		require.NoError(t, err)
		require.NotNil(t, since)
		require.NotNil(t, since.ServerTime, "the since response stamps a server time")
	})

	t.Run("markAllRead", func(t *testing.T) {
		result, err := client.Notifications().MarkAllNotificationsRead(ctx)
		require.NoError(t, err)
		require.NotNil(t, result)
		require.GreaterOrEqual(t, result.GetUpdated(), 0, "read-all reports how many rows it updated")
	})

	t.Run("markReadUnreadRequireAnExistingNotification", func(t *testing.T) {
		// A fresh CI instance has no notifications to target by id, and the mark
		// endpoints answer 404 for an unknown id.
		id := randomId()
		err := client.Notifications().MarkNotificationRead(ctx, id)
		if err == nil {
			require.NoError(t, client.Notifications().MarkNotificationUnread(ctx, id))
			return
		}
		_ = skipIfGated(t, err, "marking a specific notification (none exist on a fresh instance)")
		require.NoError(t, err)
	})
}
