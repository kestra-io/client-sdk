// @ts-check
import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup';

describe('InvitationsApi', () => {
    it('search_invitations_by_email_filter: Retrieve invitations filtered by email', async () => {
        const client = kestraClient();
        const email = `test_invitation_filter_${randomId()}@kestra.io`;

        await client.invitationsApi.createInvitation(MAIN_TENANT, { email });

        const filters = [{ field: 'EMAIL', operation: 'EQUALS', value: email }];
        const page = await client.invitationsApi.searchInvitations(1, 50, filters, MAIN_TENANT);
        const results = page?.results ?? [];

        expect(results.some(i => i.email === email)).toBeTruthy();

        const invitations = await client.invitationsApi.listInvitationsByEmail(email, MAIN_TENANT);
        for (const invitation of invitations) {
            await client.invitationsApi.deleteInvitation(invitation.id, MAIN_TENANT);
        }
    });
});
