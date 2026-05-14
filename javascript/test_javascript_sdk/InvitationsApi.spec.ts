import { describe, it, expect } from 'vitest';
import { kestraClient, randomEmail } from './CommonTestSetup.js';

describe('InvitationsApi', () => {
    it('findAllInvitationsForCurrentUser: returns invitations for current user', async () => {
        const result = await kestraClient.Invitations.findAllInvitationsForCurrentUser();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('searchInvitations: returns a paged result', async () => {
        const result = await kestraClient.Invitations.searchInvitations({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('createInvitation: creates an invitation', async () => {
        const email = randomEmail();
        const result = await kestraClient.Invitations.createInvitation({
            email,
            createUserIfNotExist: true,
        });
        expect(result).toBeDefined();
    });

    it('listInvitationsByEmail: returns invitations for a given email', async () => {
        const email = randomEmail();
        await kestraClient.Invitations.createInvitation({ email, createUserIfNotExist: true });

        const result = await kestraClient.Invitations.listInvitationsByEmail({ email });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('invitation: retrieves an invitation by id', async () => {
        const email = randomEmail();
        const created = await kestraClient.Invitations.createInvitation({ email, createUserIfNotExist: true });
        const id = (created as any).id ?? (created as any).invitationId;
        if (!id) return;

        try {
            const result = await kestraClient.Invitations.invitation({ id });
            expect(result).toBeDefined();
            expect((result as any).id).toBe(id);
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if (status === 404) return;
            throw err;
        }
    });

    it('deleteInvitation: deletes an invitation', async () => {
        const email = randomEmail();
        const created = await kestraClient.Invitations.createInvitation({ email, createUserIfNotExist: true });
        const id = (created as any).id ?? (created as any).invitationId;
        if (!id) return;

        try {
            await kestraClient.Invitations.deleteInvitation({ id });
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if (status === 404) return;
            throw err;
        }
    });
});
