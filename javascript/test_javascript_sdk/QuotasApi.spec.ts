import { describe, it, expect } from 'vitest';
import './CommonTestSetup.js';
import * as Quotas from '@kestra-io/kestra-sdk/quotas';

describe('QuotasApi', () => {
    it('search: lists quota limits for the tenant', async () => {
        // Read-only, tenant-scoped endpoint with no create API, so a tenant with
        // no configured limits returns an empty array. Assert the shape.
        const result = await Quotas.search();
        expect(Array.isArray(result)).toBe(true);
    });
});
