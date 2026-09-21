import { describe, it, expect, beforeAll, afterAll } from 'vitest';
import { randomId, MAX_PAGE_SIZE } from './_utils.js';
import { tenantId } from './_setup.js';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import type { QueryFilter } from '@kestra-io/kestra-sdk';

/**
 * Regression test for complex query filters (issue #246): the grouped AND/OR +
 * one-level-nested `filters[...]` serialization lives in the shared
 * `@kestra-io/hey-api-plugin` runtime `querySerializer`, so a plugin bump could
 * silently break it with nothing here to catch it. This exercises the real wire
 * path end-to-end against a live instance and asserts the actual matched flows —
 * an OR must return the union and an AND(OR) the intersection — not just a
 * non-empty result.
 *
 * Requires a Kestra that supports grouped filters (kestra#16197 — v2.0.x /
 * develop; NOT 1.3.x, which silently ignores grouped filters).
 */
describe('Grouped query filters (AND / OR + nested)', () => {
    // Two distinct random namespaces so the union/intersection is provably
    // different and cannot collide with other suites' fixtures.
    const nsA = `qa${randomId()}`;
    const nsB = `qa${randomId()}`;
    const seeded = [
        { namespace: nsA, id: 'orders', tier: 'gold' },
        { namespace: nsA, id: 'payments', tier: 'silver' },
        { namespace: nsB, id: 'orders', tier: 'gold' },
    ];
    const fqn = (f: { namespace: string; id: string }) => `${f.namespace}.${f.id}`;
    const ours = new Set([nsA, nsB]);

    beforeAll(async () => {
        for (const f of seeded) {
            const body = `id: ${f.id}\n`
                + `namespace: ${f.namespace}\n`
                + `labels:\n  tier: ${f.tier}\n`
                + `tasks:\n`
                + `  - id: noop\n`
                + `    type: io.kestra.plugin.core.log.Log\n`
                + `    message: hi\n`;
            await Flows.createFlow({ body });
        }
    });

    afterAll(async () => {
        for (const f of seeded) {
            try {
                await Flows.deleteFlow({ namespace: f.namespace, id: f.id });
            } catch {
                /* best-effort cleanup */
            }
        }
    });

    // Search flows with the given filters and return only OUR seeded flows' FQNs, sorted.
    async function matched(filters: Array<QueryFilter>): Promise<string[]> {
        const res = await Flows.searchFlows({
            filters: filters as any,
            page: 1,
            size: MAX_PAGE_SIZE,
            tenant: tenantId,
        });
        return ((res as any)?.results ?? [])
            .filter((r: any) => ours.has(r.namespace))
            .map(fqn)
            .sort();
    }

    it('top-level OR returns the union', async () => {
        const got = await matched([
            {
                logical: 'or',
                children: [
                    { field: 'namespace', operation: 'EQUALS', value: nsA },
                    { field: 'namespace', operation: 'EQUALS', value: nsB },
                ],
            },
        ]);
        expect(got).toEqual([`${nsA}.orders`, `${nsA}.payments`, `${nsB}.orders`].sort());
    });

    it('AND(OR) narrows to the intersection (and excludes the other namespace)', async () => {
        const got = await matched([
            {
                logical: 'and',
                children: [
                    { field: 'namespace', operation: 'EQUALS', value: nsA },
                    {
                        logical: 'or',
                        children: [
                            { field: 'labels', operation: 'EQUALS', value: { tier: 'gold' } },
                            { field: 'labels', operation: 'EQUALS', value: { tier: 'silver' } },
                        ],
                    },
                ],
            },
        ]);
        expect(got).toEqual([`${nsA}.orders`, `${nsA}.payments`].sort());
        // The control below proves the AND genuinely narrowed rather than being ignored.
        expect(got).not.toContain(`${nsB}.orders`);
    });

    it('control: the OR alone (no namespace AND) includes the other namespace', async () => {
        const got = await matched([
            {
                logical: 'or',
                children: [
                    { field: 'labels', operation: 'EQUALS', value: { tier: 'gold' } },
                    { field: 'labels', operation: 'EQUALS', value: { tier: 'silver' } },
                ],
            },
        ]);
        expect(got).toContain(`${nsB}.orders`);
        expect(got).toEqual(
            [`${nsA}.orders`, `${nsA}.payments`, `${nsB}.orders`].sort(),
        );
    });

    it('flat filter list still serializes to the legacy form (backward compat)', async () => {
        const got = await matched([
            { field: 'namespace', operation: 'EQUALS', value: nsA },
        ]);
        expect(got).toEqual([`${nsA}.orders`, `${nsA}.payments`].sort());
    });
});
