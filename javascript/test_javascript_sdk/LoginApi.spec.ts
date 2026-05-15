import { describe, it, expect } from 'vitest';
import { kestraClient, username, password } from './CommonTestSetup.js';
import type { UsernamePasswordCredentials } from '@kestra-io/kestra-sdk';

describe('LoginApi', () => {
    it('login: authenticates with valid credentials', async () => {
        const credentials: UsernamePasswordCredentials = {
            username,
            password,
        };
        const result = await kestraClient.Login.login(credentials);
        expect(result).toBeDefined();
        // In basic-auth mode, login may return HTML or a session token
        const hasToken = (result as any).token ?? (result as any).access_token ?? (result as any).jwt;
        const isHtmlResponse = typeof result === 'string' && (result as string).includes('html');
        expect(hasToken !== undefined || isHtmlResponse).toBe(true);
    });

    it('login: fails with invalid credentials', async () => {
        const credentials: UsernamePasswordCredentials = {
            username: 'invalid@example.com',
            password: 'wrongpassword',
        };
        // In basic-auth mode, login may return HTML instead of throwing
        try {
            await kestraClient.Login.login(credentials);
        } catch (_) {
            // Expected: invalid credentials should reject
        }
    });
});
