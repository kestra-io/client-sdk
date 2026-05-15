import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';
import type { BlueprintControllerKind } from '@kestra-io/kestra-sdk';

describe('BlueprintTagsApi', () => {
    it('listBlueprintTags: returns a list of FLOW blueprint tags', async () => {
        const kind: BlueprintControllerKind = 'FLOW';
        const result = await kestraClient.BlueprintTags.listBlueprintTags({ kind });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listBlueprintTags: returns a list of APP blueprint tags', async () => {
        const kind: BlueprintControllerKind = 'APP';
        const result = await kestraClient.BlueprintTags.listBlueprintTags({ kind });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('internalBlueprintTags: returns internal blueprint tags', async () => {
        const result = await kestraClient.BlueprintTags.internalBlueprintTags();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });
});
