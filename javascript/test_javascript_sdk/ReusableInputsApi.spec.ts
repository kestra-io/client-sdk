import { describe, it, expect } from 'vitest';
import './CommonTestSetup.js';
import * as ReusableInputs from '@kestra-io/kestra-sdk/reusable-inputs';

describe('ReusableInputsApi', () => {
    it('namespacesWithBlocks: lists namespaces defining reusable inputs', async () => {
        const result = await ReusableInputs.namespacesWithBlocks();
        // Read-only autocompletion endpoint returning the namespaces that own at
        // least one reusable inputs block. A tenant with none returns an empty
        // array, so assert the response shape.
        expect(Array.isArray(result)).toBe(true);
    });

    // `createOrUpdate` (and `revisions`, which needs a block to exist) are not
    // covered: the endpoint consumes application/x-yaml, but the generated SDK
    // wrapper hardcodes Content-Type: application/json, so the YAML body is
    // rejected (HTTP 500). Tracked in #340 — re-enable once the generator emits
    // the correct content type for YAML request bodies.
});
