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
    }, 30_000); // 3 sequential live creates can exceed vitest's default 5s hook timeout.

    afterAll(async () => {
        for (const f of seeded) {
            try {
                await Flows.deleteFlow({ namespace: f.namespace, id: f.id });
            } catch {
                /* best-effort cleanup */
            }
        }
    }, 30_000);

    // Search flows with the given filters and return only OUR seeded flows' FQNs, sorted.
    // `filters` is deliberately typed as Array<QueryFilter> with NO `as any` cast: the whole
    // point of this test is to also guard the type — if a future hey-api-plugin bump drops the
    // grouped `logical`/`children` fields from QueryFilter, this file must fail `tsc`.
    async function matched(filters: Array<QueryFilter>): Promise<string[]> {
        const res = await Flows.searchFlows({
            filters,
            page: 1,
            size: MAX_PAGE_SIZE,
            tenant: tenantId,
        });
        return ((res as { results?: Array<{ namespace: string; id: string }> })?.results ?? [])
            .filter((r) => ours.has(r.namespace))
            .map(fqn)
            .sort();
    }

    // Poll `matched(filters)` until `done(result)` holds (or timeout), tolerating any
    // search-index lag between createFlow and the flow becoming searchable by label/namespace.
    async function matchedWhen(
        filters: Array<QueryFilter>,
        done: (r: string[]) => boolean,
        timeoutMs = 10_000,
    ): Promise<string[]> {
        const deadline = Date.now() + timeoutMs;
        let last: string[] = [];
        while (Date.now() < deadline) {
            last = await matched(filters);
            if (done(last)) return last;
            await new Promise((r) => setTimeout(r, 400));
        }
        return last;
    }

    const unionAll = [`${nsA}.orders`, `${nsA}.payments`, `${nsB}.orders`].sort();
    const nsAOnly = [`${nsA}.orders`, `${nsA}.payments`].sort();

    it('top-level OR returns the union', async () => {
        const got = await matchedWhen(
            [
                {
                    logical: 'or',
                    children: [
                        { field: 'namespace', operation: 'EQUALS', value: nsA },
                        { field: 'namespace', operation: 'EQUALS', value: nsB },
                    ],
                },
            ],
            (r) => r.length >= 3,
        );
        expect(got).toEqual(unionAll);
    });

    it('AND(OR) narrows to the intersection (and excludes the other namespace)', async () => {
        const got = await matchedWhen(
            [
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
            ],
            (r) => r.length >= 2,
        );
        expect(got).toEqual(nsAOnly);
        // Belt-and-suspenders (the control test below is the real proof the AND narrowed).
        expect(got).not.toContain(`${nsB}.orders`);
    });

    it('control: the OR alone (no namespace AND) includes the other namespace', async () => {
        // Scoped to OUR namespaces via the `ours` post-filter; asserted by containment rather
        // than exact equality because this query is not namespace-scoped server-side and its
        // full result set (every tier=gold/silver flow in the tenant) may be paginated.
        const got = await matchedWhen(
            [
                {
                    logical: 'or',
                    children: [
                        { field: 'labels', operation: 'EQUALS', value: { tier: 'gold' } },
                        { field: 'labels', operation: 'EQUALS', value: { tier: 'silver' } },
                    ],
                },
            ],
            (r) => r.includes(`${nsB}.orders`) && r.length >= 3,
        );
        // Without the namespace AND, the other namespace's flow IS returned — proving the AND
        // in the previous test genuinely narrowed the result.
        expect(got).toEqual(expect.arrayContaining(unionAll));
    });

    it('flat filter list still serializes to the legacy form (backward compat)', async () => {
        const got = await matchedWhen(
            [{ field: 'namespace', operation: 'EQUALS', value: nsA }],
            (r) => r.length >= 2,
        );
        expect(got).toEqual(nsAOnly);
    });
});
