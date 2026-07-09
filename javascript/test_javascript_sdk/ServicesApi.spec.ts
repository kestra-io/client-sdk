import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';
import type { ServiceType } from '@kestra-io/kestra-sdk';

describe('ServicesApi', () => {
    it('activeServices: returns active services', async () => {
        const result = await kestraClient.Services.activeServices();
        expect(result).toBeDefined();
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

    it('service: returns the same service when fetched by id', async () => {
        // activeServices entries carry no id, so source a real id from the search endpoint.
        const page = await kestraClient.Services.searchServices({ page: 1, size: 10 });
        const source = page.results[0];
        expect(source?.id).toBeTruthy();

        const result = await kestraClient.Services.service({ id: source.id! });
        expect(result.id).toBe(source.id);
        expect(result.type).toBe(source.type);
    });
});
