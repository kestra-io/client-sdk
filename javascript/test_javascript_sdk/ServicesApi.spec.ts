import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';
import type { ServiceType } from '@kestra-io/kestra-sdk';

describe('ServicesApi', () => {
    it('activeServices: returns active services', async () => {
        try {
            const result = await kestraClient.Services.activeServices();
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404].includes(status)) return;
            throw err;
        }
    });

    it('searchServices: returns a list of services', async () => {
        const result = await kestraClient.Services.searchServices({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('metrics: returns metrics for WEBSERVER service type', async () => {
        const serviceType: ServiceType = 'WEBSERVER';
        try {
            const result = await kestraClient.Services.metrics({ serviceType });
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404, 422].includes(status)) return;
            throw err;
        }
    });
});
