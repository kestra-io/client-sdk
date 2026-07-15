import { describe, it, expect } from 'vitest';
import { tenantId } from './CommonTestSetup.js';
import * as Quotas from '@kestra-io/kestra-sdk/quotas';

describe('QuotasApi', () => {
    it('search: lists quota limits for the tenant', async () => {
        const result = await Quotas.search();
        // Read-only, tenant-scoped endpoint. A tenant with no configured quota
        // limits returns an empty array (there is no API to create one), so we
        // assert the response is a list and that every limit it does return is a
        // well-formed object scoped to the tenant we queried.
        expect(Array.isArray(result)).toBe(true);
        for (const quotaLimit of result) {
            expect(quotaLimit).toBeTypeOf('object');
            expect(quotaLimit.tenantId).toBe(tenantId);
        }
    });
});
