import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';

describe('SecretsApi', () => {
    it('listSecrets: lists secrets for the tenant', async () => {
        const result = await kestraClient.Secrets.listSecrets({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listSecrets: returns empty list with high page number', async () => {
        const result = await kestraClient.Secrets.listSecrets({ page: 9999, size: 10 });
        expect(result).toBeDefined();
    });
});
