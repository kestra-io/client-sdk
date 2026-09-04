import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as ReusableInputs from '@kestra-io/kestra-sdk/reusable-inputs';
// list/get/delete land in the `-admin` module: the spec numbers their
// operationIds (list_4/get_6/delete_5) because the names collide across tags.
import * as ReusableInputsAdmin from '@kestra-io/kestra-sdk/reusable-inputs-admin';

function source(namespace: string, id: string, description = 'shared inputs') {
    return `id: ${id}\nnamespace: ${namespace}\ndescription: ${description}\ninputs:\n  - id: name\n    type: STRING\n`;
}

async function expectStatus(call: Promise<unknown>, expected: number) {
    try {
        await call;
        throw new Error(`Expected a ${expected} response, but the call succeeded.`);
    } catch (err: unknown) {
        const status = (err as any)?.status ?? (err as any)?.code ?? (err as any)?.response?.status;
        expect(status).toBe(expected);
    }
}

describe('ReusableInputsApi', () => {
    it('namespacesWithBlocks: lists namespaces defining reusable inputs', async () => {
        const result = await ReusableInputs.namespacesWithBlocks();
        // Read-only autocompletion endpoint returning the namespaces that own at
        // least one reusable inputs block. A tenant with none returns an empty
        // array, so assert the response shape.
        expect(Array.isArray(result)).toBe(true);
    });

    it('createOrUpdate: creates reusable inputs from YAML source', async () => {
        const namespace = randomId();
        const id = randomId();
        const body = `id: ${id}\nnamespace: ${namespace}\ninputs:\n  - id: in\n    type: STRING\n`;

        const result = await ReusableInputs.createOrUpdate({ namespace, id, body });

        expect(result.id).toBe(id);
        expect(result.namespace).toBe(namespace);
        expect(result.inputs).toEqual([expect.objectContaining({ id: 'in', type: 'STRING' })]);
    });

    it('revisions: lists revision history for reusable inputs', async () => {
        const namespace = randomId();
        const id = randomId();
        const body = `id: ${id}\nnamespace: ${namespace}\ninputs:\n  - id: in\n    type: STRING\n`;
        await ReusableInputs.createOrUpdate({ namespace, id, body });

        const result = await ReusableInputs.revisions({ namespace, id });

        expect(Array.isArray(result)).toBe(true);
        expect(result).toHaveLength(1);
        expect(result[0]).toMatchObject({ id, namespace });
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
