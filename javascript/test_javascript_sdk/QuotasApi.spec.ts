import { describe, it, expect } from 'vitest';
import { tenantId } from './CommonTestSetup.js';
import * as Quotas from '@kestra-io/kestra-sdk/quotas';

describe('QuotasApi', () => {
    it('search: lists quota limits for the tenant', async () => {
        // Read-only, tenant-scoped endpoint with no create API, so a tenant with
        // no configured limits returns an empty array. Assert the shape, and that
        // any limit returned is scoped to the tenant we queried.
        const result = await Quotas.search();
        expect(Array.isArray(result)).toBe(true);
        for (const quotaLimit of result) {
            expect(quotaLimit.tenantId).toBe(tenantId);
        }
    });
});
