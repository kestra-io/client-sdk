import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as ReusableInputs from '@kestra-io/kestra-sdk/reusable-inputs';

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
});
