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
        expect((result as any).token ?? (result as any).access_token ?? (result as any).jwt).toBeDefined();
    });

    it('login: fails with invalid credentials', async () => {
        const credentials: UsernamePasswordCredentials = {
            username: 'invalid@example.com',
            password: 'wrongpassword',
        };
        await expect(kestraClient.Login.login(credentials)).rejects.toThrow();
    });
});
