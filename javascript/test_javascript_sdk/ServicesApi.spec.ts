import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';
import type { ServiceType } from '@kestra-io/kestra-sdk';

describe('ServicesApi', () => {
    it('activeServices: returns active services', async () => {
        const result = await kestraClient.Services.activeServices();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('searchServices: returns a list of services', async () => {
        const result = await kestraClient.Services.searchServices({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('metrics: returns metrics for WEBSERVER service type', async () => {
        const serviceType: ServiceType = 'WEBSERVER';
        const result = await kestraClient.Services.metrics({ serviceType });
        expect(result).toBeDefined();
    });
});
