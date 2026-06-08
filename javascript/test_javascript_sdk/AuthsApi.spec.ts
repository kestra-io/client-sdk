import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
import type { CreateApiTokenRequest } from '@kestra-io/kestra-sdk';

describe('AuthsApi', () => {
    it('currentUser: returns the authenticated user', async () => {
        const result = await kestraClient.Auths.currentUser();
        expect(result).toBeDefined();
        expect((result as any).profile?.email ?? (result as any).email ?? (result as any).username).toBeDefined();
    });

    it('listApiTokensForCurrentUser: lists API tokens for the current user', async () => {
        const result = await kestraClient.Auths.listApiTokensForCurrentUser();
        expect(result).toBeDefined();
        expect(Array.isArray((result as any).results ?? result)).toBe(true);
    });

    it('createApiTokenForCurrentUser: creates an API token', async () => {
        const req: CreateApiTokenRequest = {
            name: `test-token-${randomId()}`,
            description: 'test token',
        };
        const result = await kestraClient.Auths.createApiTokenForCurrentUser(req);
        expect(result).toBeDefined();
        expect((result as any).fullToken ?? (result as any).id).toBeDefined();
    });

    it('deleteApiTokenForCurrentUser: deletes an API token', async () => {
        const req: CreateApiTokenRequest = {
            name: `to-delete-${randomId()}`,
        };
        const created = await kestraClient.Auths.createApiTokenForCurrentUser(req);
        const tokenId = (created as any).id;

        await kestraClient.Auths.deleteApiTokenForCurrentUser({ tokenId });
    });

    it('index: returns auth index info', async () => {
        const result = await kestraClient.Auths.index();
        expect(result).toBeDefined();
    });
});
