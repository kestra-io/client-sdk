import { describe, it, expect } from 'vitest';
import { randomId, expectStatus } from './_utils.js';
import * as ReusableInputs from '@kestra-io/kestra-sdk/reusable-inputs';
// list/get/delete land in the `-admin` module: the spec numbers their
// operationIds (list_4/get_6/delete_5) because the names collide across tags.
import * as ReusableInputsAdmin from '@kestra-io/kestra-sdk/reusable-inputs-admin';

function source(namespace: string, id: string, description = 'shared inputs') {
    return `id: ${id}\nnamespace: ${namespace}\ndescription: ${description}\ninputs:\n  - id: name\n    type: STRING\n`;
}

describe('ReusableInputsApi', () => {
    it('namespacesWithBlocks: lists namespaces defining reusable inputs', async () => {
        const namespace = randomId();
        const id = randomId();
        await ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id) });

        const result = await ReusableInputs.namespacesWithBlocks();

        expect(result).toContain(namespace);
    });

    it('createOrUpdate: creates reusable inputs from YAML source', async () => {
        const namespace = randomId();
        const id = randomId();
        const body = source(namespace, id);

        const result = await ReusableInputs.createOrUpdate({ namespace, id, body });

        expect(result.id).toBe(id);
        expect(result.namespace).toBe(namespace);
        expect(result.description).toBe('shared inputs');
        expect(result.inputs).toEqual([expect.objectContaining({ id: 'name', type: 'STRING' })]);
        expect(result.source).toBe(body);
        expect(result.revision).toBe(1);
        expect(result.last).toBe(true);
        expect(result.deleted).toBe(false);
        expect(result.created).toBeTruthy();
    });

    it('revisions: lists revision history for reusable inputs', async () => {
        const namespace = randomId();
        const id = randomId();
        await ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id) });
        await ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id, 'updated inputs') });

        const result = await ReusableInputs.revisions({ namespace, id });

        expect(result).toHaveLength(2);
        expect(result.map((block) => block.revision)).toEqual([1, 2]);
        expect(result[0]).toMatchObject({ id, namespace, description: 'shared inputs' });
        expect(result[1]).toMatchObject({ description: 'updated inputs' });
    });

    it('createOrUpdate: failIfExists rejects an existing block', async () => {
        const namespace = randomId();
        const id = randomId();
        await ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id) });

        await expectStatus(
            ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id), failIfExists: true }),
            409,
        );
    });

    it('get: reads a block back, and an older revision on request', async () => {
        const namespace = randomId();
        const id = randomId();
        await ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id) });
        await ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id, 'updated inputs') });

        const latest = await ReusableInputsAdmin.get({ namespace, id });
        expect(latest.description).toBe('updated inputs');

        const first = await ReusableInputsAdmin.get({ namespace, id, revision: 1 });
        expect(first.description).toBe('shared inputs');
    });

    it('list: pages the blocks of a namespace', async () => {
        const namespace = randomId();
        for (let i = 0; i < 3; i++) {
            const id = randomId();
            await ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id) });
        }

        const all = await ReusableInputsAdmin.list({ namespace });
        expect(all.total).toBe(3);

        const firstPage = await ReusableInputsAdmin.list({ namespace, page: 1, size: 2 });
        expect(firstPage.total).toBe(3);
        expect(firstPage.results).toHaveLength(2);
    });

    it('list/get: resolve namespace inheritance from a parent namespace', async () => {
        const parent = randomId();
        const child = `${parent}.child`;
        const id = randomId();
        await ReusableInputs.createOrUpdate({ namespace: parent, id, body: source(parent, id) });

        const inherited = await ReusableInputsAdmin.get({ namespace: child, id });
        expect(inherited.namespace).toBe(parent);

        const listed = await ReusableInputsAdmin.list({ namespace: child });
        expect(listed.total).toBe(1);
        expect(listed.results[0]).toMatchObject({ id, namespace: parent });
    });

    it('deleteReusableInputs: removes a block', async () => {
        const namespace = randomId();
        const id = randomId();
        await ReusableInputs.createOrUpdate({ namespace, id, body: source(namespace, id) });

        await ReusableInputsAdmin.deleteReusableInputs({ namespace, id });

        await expectStatus(ReusableInputsAdmin.get({ namespace, id }), 404);
    });
});
