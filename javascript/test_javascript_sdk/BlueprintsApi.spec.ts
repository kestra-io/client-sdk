import { describe, it, expect } from 'vitest';
import { kestraClient, randomId, getSimpleFlowAndId } from './CommonTestSetup.js';
import type { BlueprintControllerFlowBlueprintCreateOrUpdate, BlueprintControllerKind } from '@kestra-io/kestra-sdk';

function logFlowYaml(id: string, ns: string): string {
    return `id: ${id}
namespace: ${ns}
tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World
`;
}

async function createFlowBlueprint() {
    const req: BlueprintControllerFlowBlueprintCreateOrUpdate = {
        title: `test-bp-${randomId()}`,
        source: logFlowYaml(randomId(), randomId()),
        description: 'Test blueprint',
    };
    return kestraClient.Blueprints.createFlowBlueprint(req);
}

describe('BlueprintsApi', () => {
    it('searchBlueprints: returns paged results for FLOW kind', async () => {
        const kind: BlueprintControllerKind = 'FLOW';
        const result = await kestraClient.Blueprints.searchBlueprints({ kind, page: 1, size: 5 });
        expect(result).toBeDefined();
        expect(result.results).toBeDefined();
    });

    it('searchBlueprints: returns paged results for APP kind', async () => {
        const kind: BlueprintControllerKind = 'APP';
        const result = await kestraClient.Blueprints.searchBlueprints({ kind, page: 1, size: 5 });
        expect(result).toBeDefined();
    });

    it('searchInternalBlueprints: returns internal blueprints', async () => {
        const result = await kestraClient.Blueprints.searchInternalBlueprints({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('createFlowBlueprint: creates a new flow blueprint', async () => {
        const bp = await createFlowBlueprint();
        expect(bp).toBeDefined();
        expect(bp.id).toBeDefined();
    });

    it('flowBlueprintById: retrieves a flow blueprint by id', async () => {
        const created = await createFlowBlueprint();
        const id = created.id;

        const result = await kestraClient.Blueprints.flowBlueprintById({ id });
        expect(result).toBeDefined();
        expect(result.id).toBe(id);
    });

    it('updateFlowBlueprint: updates a flow blueprint', async () => {
        const created = await createFlowBlueprint();
        const id = created.id;
        const newTitle = `updated-bp-${randomId()}`;

        const update: BlueprintControllerFlowBlueprintCreateOrUpdate = {
            title: newTitle,
            source: logFlowYaml(randomId(), randomId()),
        };
        const result = await kestraClient.Blueprints.updateFlowBlueprint({ id, ...update });
        expect(result).toBeDefined();
    });

    it('deleteFlowBlueprints: deletes a flow blueprint', async () => {
        const created = await createFlowBlueprint();
        const id = created.id;

        await kestraClient.Blueprints.deleteFlowBlueprints({ id });
    });

    it('createInternalBlueprints: creates an internal blueprint', async () => {
        const { flowBody } = getSimpleFlowAndId();
        const result = await kestraClient.Blueprints.createInternalBlueprints({
            title: `internal-bp-${randomId()}`,
            source: flowBody,
            kind: 'FLOW',
        });
        expect(result).toBeDefined();
    });

    it('searchInternalBlueprints: paged result with query', async () => {
        const result = await kestraClient.Blueprints.searchInternalBlueprints({
            page: 1,
            size: 5,
            filters: [{
                field: 'q',
                operation: 'EQUALS',
                value: 'test'
            }],
        });
        expect(result).toBeDefined();
    });

    async function createInternalBlueprint() {
        return kestraClient.Blueprints.createInternalBlueprints({
            title: `internal-bp-${randomId()}`,
            source: getSimpleFlowAndId().flowBody,
            kind: 'FLOW',
        });
    }

    it('internalBlueprint: retrieves an internal blueprint by id', async () => {
        const created = await createInternalBlueprint();
        const id = created.id;

        const result = await kestraClient.Blueprints.internalBlueprint({ id });
        expect(result.id).toBe(id);
    });

    it('internalBlueprintFlow: retrieves internal blueprint source code', async () => {
        const created = await createInternalBlueprint();
        const id = created.id;

        const source = await kestraClient.Blueprints.internalBlueprintFlow({ id });
        expect(typeof source).toBe('string');
        expect(source).toContain('namespace:');
    });

    it('updateInternalBlueprints: updates an internal blueprint title', async () => {
        const created = await createInternalBlueprint();
        const id = created.id;
        const newTitle = `updated-internal-bp-${randomId()}`;

        const result = await kestraClient.Blueprints.updateInternalBlueprints({
            id,
            title: newTitle,
            source: getSimpleFlowAndId().flowBody,
            kind: 'FLOW',
        });
        expect(result.title).toBe(newTitle);
    });

    it('deleteInternalBlueprints: deletes an internal blueprint', async () => {
        const created = await createInternalBlueprint();
        const id = created.id;

        await kestraClient.Blueprints.deleteInternalBlueprints({ id });
        await expect(kestraClient.Blueprints.internalBlueprint({ id })).rejects.toThrow();
    });
});
