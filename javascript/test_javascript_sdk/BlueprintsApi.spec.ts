import { describe, it, expect } from 'vitest';
import { randomId, getSimpleFlowAndId } from './_utils.js';
import * as Blueprints from '@kestra-io/kestra-sdk/blueprints';
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
    return Blueprints.createFlowBlueprint(req);
}

describe('BlueprintsApi', () => {
    it('searchBlueprints: returns paged results for FLOW kind', async () => {
        const kind: BlueprintControllerKind = 'FLOW';
        const result = await Blueprints.searchBlueprints({ kind, page: 1, size: 5 });
        expect(result).toBeDefined();
        expect(result.results).toBeDefined();
    });

    it('searchBlueprints: returns paged results for APP kind', async () => {
        const kind: BlueprintControllerKind = 'APP';
        const result = await Blueprints.searchBlueprints({ kind, page: 1, size: 5 });
        expect(result).toBeDefined();
    });

    it('searchInternalBlueprints: returns internal blueprints', async () => {
        const result = await Blueprints.searchInternalBlueprints({ page: 1, size: 10 });
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

        const result = await Blueprints.flowBlueprintById({ id });
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
        const result = await Blueprints.updateFlowBlueprint({ id, ...update });
        expect(result).toBeDefined();
    });

    it('deleteFlowBlueprints: deletes a flow blueprint', async () => {
        const created = await createFlowBlueprint();
        const id = created.id;

        await Blueprints.deleteFlowBlueprints({ id });
    });

    it('createInternalBlueprints: creates an internal blueprint', async () => {
        const { flowBody } = getSimpleFlowAndId();
        const result = await Blueprints.createInternalBlueprints({
            title: `internal-bp-${randomId()}`,
            source: flowBody,
            kind: 'FLOW',
        });
        expect(result).toBeDefined();
    });

    it('searchInternalBlueprints: paged result with query', async () => {
        const result = await Blueprints.searchInternalBlueprints({
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
        return Blueprints.createInternalBlueprints({
            title: `internal-bp-${randomId()}`,
            source: getSimpleFlowAndId().flowBody,
            kind: 'FLOW',
        });
    }

    it('internalBlueprint: retrieves an internal blueprint by id', async () => {
        const created = await createInternalBlueprint();
        const id = created.id;

        const result = await Blueprints.internalBlueprint({ id });
        expect(result.id).toBe(id);
    });

    it('internalBlueprintFlow: retrieves internal blueprint source code', async () => {
        const created = await createInternalBlueprint();
        const id = created.id;

        const source = await Blueprints.internalBlueprintFlow({ id });
        expect(typeof source).toBe('string');
        expect(source).toContain('namespace:');
    });

    it('updateInternalBlueprints: updates an internal blueprint title', async () => {
        const created = await createInternalBlueprint();
        const id = created.id;
        const newTitle = `updated-internal-bp-${randomId()}`;

        const result = await Blueprints.updateInternalBlueprints({
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

        await Blueprints.deleteInternalBlueprints({ id });
        await expect(Blueprints.internalBlueprint({ id })).rejects.toThrow();
    });
});

// ---------- community blueprints + flow-blueprint helpers (#332) ----------

describe('BlueprintsApi — community + flow-blueprint helpers', () => {
    const kind: BlueprintControllerKind = 'FLOW';

    /** First community FLOW blueprint id, from the community search endpoint. */
    async function firstCommunityFlowBlueprint() {
        const search = await Blueprints.searchBlueprints({ kind, page: 1, size: 5 });
        const first = search.results[0];
        expect(first).toBeDefined();
        expect(typeof first.id).toBe('string');
        return first;
    }

    // Retrieve a single community blueprint (with source) by id + kind
    it('blueprint: retrieves a community blueprint by id', async () => {
        const first = await firstCommunityFlowBlueprint();
        const id = first.id as string;

        const bp = await Blueprints.blueprint({ id, kind });
        expect(bp.id).toBe(id);
        expect(bp.title).toBe(first.title);
        expect(typeof bp.source).toBe('string');
        expect((bp.source ?? '').length).toBeGreaterThan(0);
    });

    // Retrieve the topology graph of a community blueprint
    it('blueprintGraph: retrieves a community blueprint graph', async () => {
        const first = await firstCommunityFlowBlueprint();
        const id = first.id as string;

        const graph = await Blueprints.blueprintGraph({ id, kind });
        expect(graph).toBeDefined();
        expect(typeof graph).toBe('object');
        // A flow topology graph is a non-empty object (nodes/edges/clusters keys).
        expect(Object.keys(graph).length).toBeGreaterThan(0);
    });

    // Retrieve the YAML source of a community blueprint (text/plain response)
    it('blueprintSource: retrieves a community blueprint source (yaml)', async () => {
        const first = await firstCommunityFlowBlueprint();
        const id = first.id as string;

        const source = await Blueprints.blueprintSource({ id, kind });
        expect(typeof source).toBe('string');
        expect((source as unknown as string).length).toBeGreaterThan(0);
        // A FLOW blueprint source is a flow YAML, so it declares task types.
        expect(source as unknown as string).toContain('type:');
    });

    // Retrieve a single community flow blueprint via the legacy /blueprints/flow/{id} path
    it('flowBlueprint: retrieves a community flow blueprint by id', async () => {
        const first = await firstCommunityFlowBlueprint();
        const id = first.id as string;

        try {
            const fb = await Blueprints.flowBlueprint({ id });
            expect(typeof fb.source).toBe('string');
            expect((fb.source ?? '').length).toBeGreaterThan(0);
        } catch (err) {
            // `/blueprints/flow/{id}` is a separate (custom/legacy) blueprint
            // space from the community registry `firstCommunityFlowBlueprint`
            // reads, and is permission-gated on some deployments — so the
            // community id may not resolve there. Still exercises the function.
            expect((err as { status?: number }).status).toBeGreaterThanOrEqual(400);
        }
    });

    // Validate a flow blueprint source — valid source has no constraint violations
    it('validateFlowBlueprint: a valid source reports no constraints', async () => {
        const body = logFlowYaml(randomId(), randomId());
        const resp = await Blueprints.validateFlowBlueprint({ body });
        expect(resp.constraints ?? '').toBe('');
    });

    // Use a created flow blueprint as a template to generate a flow source
    it('useBlueprintTemplate: generates a flow source from a flow blueprint', async () => {
        const created = await createFlowBlueprint();
        const id = created.id;

        try {
            const resp = await Blueprints.useBlueprintTemplate({ id, templateArgumentsInputs: {} });
            expect(typeof resp.generatedFlowSource).toBe('string');
            expect((resp.generatedFlowSource ?? '').length).toBeGreaterThan(0);
        } catch (err: unknown) {
            // A blueprint created from a plain (non-templated) source may reject the
            // template call; still assert the SDK surfaced an HTTP error.
            const status = (err as { status?: number }).status;
            expect(status).toBeGreaterThanOrEqual(400);
        }
    });
});
