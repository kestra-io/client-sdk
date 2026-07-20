import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Quotas from '@kestra-io/kestra-sdk/quotas';
import * as TenantsAdmin from '@kestra-io/kestra-sdk/tenants-admin';
import type { Tenant } from '@kestra-io/kestra-sdk';

describe('QuotasApi', () => {
    it('search: lists quota limits for the tenant', async () => {
        // `search` (GET /quota-limits) returns QuotaLimit usage counters, which are
        // materialized lazily as quota-consuming activity occurs. A tenant with no
        // recorded usage returns an empty array, so assert the response shape.
        const result = await Quotas.search();
        expect(Array.isArray(result)).toBe(true);
    });

    it('quotas round-trip through the owning tenant', async () => {
        // Quotas are not a standalone create API — they are configured on the
        // Tenant (`Tenant.quotas`). Create a tenant carrying a quota and assert it
        // survives the round-trip, giving a real asserted quota value. (Verified
        // against a freshly-pulled kestra-ee `develop`: create + GET both echo the
        // quotas array back unchanged.)
        const id = randomId();
        const quota = { duration: 'PT1H', limit: 1000, behavior: 'FAIL' } as const;
        const tenant: Tenant = {
            id,
            name: `Quota Tenant ${id}`,
            deleted: false,
            quotas: [quota],
        };
        await TenantsAdmin.create(tenant);

        const result = await TenantsAdmin.get({ id });
        expect((result as any).quotas).toEqual([quota]);
    });
});
