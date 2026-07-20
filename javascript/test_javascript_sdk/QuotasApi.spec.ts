import { describe, it, expect } from 'vitest';
import './CommonTestSetup.js';
import * as Quotas from '@kestra-io/kestra-sdk/quotas';

describe('QuotasApi', () => {
    it('search: lists quota limits for the tenant', async () => {
        // `search` (GET /quota-limits) returns QuotaLimit *usage counters*
        // (`{tenantId, namespace, flowId, id, start, count}`), not the configured
        // limits — there is no create/config API for these on the tenant path.
        // A tenant with no recorded usage returns an empty array, so assert the
        // response shape. (Verified against kestra-ee `develop`: the endpoint
        // returns `[]` with 200 even after running flows, and tenant-level quotas
        // set via the Tenants API are not echoed back nor do they populate this
        // endpoint, so there is no real value to assert here.)
        const result = await Quotas.search();
        expect(Array.isArray(result)).toBe(true);
    });
});
