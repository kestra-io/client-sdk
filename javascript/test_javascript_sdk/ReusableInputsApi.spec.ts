import { describe, it, expect } from 'vitest';
import { randomId } from './CommonTestSetup.js';
import * as ReusableInputs from '@kestra-io/kestra-sdk/reusable-inputs';

describe('ReusableInputsApi', () => {
    it('createOrUpdate + revisions + namespacesWithBlocks: full lifecycle', async () => {
        const namespace = `io.kestra.test.reusable.${randomId()}`;
        const id = `block-${randomId()}`;
        const body = [
            `id: ${id}`,
            `namespace: ${namespace}`,
            'description: Reusable inputs block created by the JS SDK test suite',
            'inputs:',
            '  - id: reusable_string',
            '    type: STRING',
        ].join('\n');

        // createOrUpdate parses the YAML source and echoes back the stored block.
        const created = await ReusableInputs.createOrUpdate({ namespace, id, body });
        expect(created.id).toBe(id);
        expect(created.namespace).toBe(namespace);
        expect(created.inputs.map(i => i.id)).toContain('reusable_string');

        // The namespace now owns a reusable inputs definition, so it appears in
        // the autocompletion list.
        const namespaces = await ReusableInputs.namespacesWithBlocks();
        expect(namespaces).toContain(namespace);

        // A single create produces exactly one revision of the block.
        const revisions = await ReusableInputs.revisions({ namespace, id });
        expect(revisions).toHaveLength(1);
        expect(revisions[0].id).toBe(id);
        expect(revisions[0].namespace).toBe(namespace);
    });
});
