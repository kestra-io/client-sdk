import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';

describe('ServicesApi', () => {
    it('activeServices: returns active services', async () => {
        const result = await kestraClient.Services.activeServices();
        expect(result).toBeDefined();
    });

    it('searchServices: returns a list of services', async () => {
        const result = await kestraClient.Services.searchServices({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });
});
