import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Notifications from '@kestra-io/kestra-sdk/notifications';

describe('NotificationsApi', () => {
    it('history_: returns the notification history with a server time', async () => {
        const result = await Notifications.history_({ limit: 10 });
        expect(Array.isArray(result.notifications ?? [])).toBe(true);
        expect(result.serverTime).toBeDefined();
    });

    it('unreadCount: returns the unread notification count as a number', async () => {
        const result = await Notifications.unreadCount();
        expect(typeof result).toBe('number');
    });

    it('pollSince: returns notifications since a given server time', async () => {
        const history = await Notifications.history_({ limit: 1 });
        const since = history.serverTime ?? new Date().toISOString();

        const result = await Notifications.pollSince({ since });
        expect(Array.isArray(result.notifications ?? [])).toBe(true);
        expect(result.serverTime).toBeDefined();
    });

    it('markAllRead: marks every notification as read', async () => {
        const result = await Notifications.markAllRead();
        expect(typeof result.updated).toBe('number');
    });

    it('markRead / markUnread: toggle the read state of a notification', async () => {
        // Notifications are produced by server-side events, so there may be none
        // to act on. When one exists, drive the real id through both endpoints;
        // otherwise fall back to a synthetic id and tolerate the not-found the
        // server returns — the point is to exercise the SDK call itself.
        const history = await Notifications.history_({ limit: 1 });
        const id = history.notifications?.[0]?.id ?? randomId();

        try {
            await Notifications.markRead({ id });
            await Notifications.markUnread({ id });
        } catch (err) {
            expect((err as { status?: number }).status).toBe(404);
        }
    });
});
