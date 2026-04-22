// FlowsApi.spec.ts
import { describe, it, expect } from 'vitest';
import { kestraClient, getSimpleFlow, getCompleteFlow, getSimpleFlowAndId } from './CommonTestSetup.js';
import type { FlowControllerTaskValidationType } from '@kestra-io/kestra-sdk';

// ---------- helpers ----------

function getDataOrThrow<T>(resp: { data?: T }, message?: string): T {
    if (!resp.data) {
        throw new Error(message ?? 'Data not found');
    }
    return resp.data;
}

async function createSimpleFlow() {
    const body = getSimpleFlow();
    const flow = getDataOrThrow(await kestraClient().Flows.createFlow({ body }), 'Failed to create flow');
    await assertFlowExist(flow);
    return flow;
}

async function assertFlowExist(flow: { namespace: string; id: string }) {
    const result = await kestraClient().Flows.flow({
        namespace: flow.namespace,
        id: flow.id,
    });
    expect(result.data).toBeDefined();
}

async function assertFlowDoesNotExist(flow: { namespace: string; id: string }) {
    try {
        await kestraClient().Flows.flow({
            namespace: flow.namespace,
            id: flow.id,
        });
        throw new Error('Expected a 404 Not Found, but the call succeeded.');
    } catch (err: unknown) {
        const status = (err as any)?.status ?? (err as any)?.code ?? (err as any)?.response?.status;
        expect(status).toBe(404);
    }
}

describe('FlowsApi', () => {
    // Update from multiples yaml sources
    it('bulk_update_flows: Update from multiple yaml sources', async () => {
        const { flowBody, flowNamespace, flowId } = getSimpleFlowAndId();
        const flow = getDataOrThrow(await kestraClient().Flows.createFlow({ body: flowBody }), 'Failed to create flow for bulk update');
        await assertFlowExist(flow);
        expect(flow.description).toBe('simple_flow_description');

        const namespace = flowNamespace;
        const id = flowId;
        const updatedBody = flowBody.replace('simple_flow_description', 'simple_flow_description_updated');

        const resp = getDataOrThrow(await kestraClient().Flows.bulkUpdateFlows({
            delete: false,
            allowNamespaceChild: false,
            namespace,
            body: updatedBody,
        }), 'Failed to bulk update flows');

        const first = Array.isArray(resp) ? resp[0] : (resp as any)?.[0];
        expect(first?.description).toBe('simple_flow_description_updated');
        void id;
    });

    // Create a flow from yaml source (simple)
    it('create_flow: simple', async () => {
        const body = getSimpleFlow();
        const flow = getDataOrThrow(await kestraClient().Flows.createFlow({ body }), 'Failed to create simple flow');
        await assertFlowExist(flow);
    });

    // Create a flow from yaml source (full)
    it('create_flow: full', async () => {
        const body = getCompleteFlow();
        const flow = getDataOrThrow(await kestraClient().Flows.createFlow({ body }), 'Failed to create complete flow');
        await assertFlowExist(flow);
    });

    // Delete a flow
    it('delete_flow', async () => {
        const flow = await createSimpleFlow();

        await kestraClient().Flows.deleteFlow({ namespace: flow.namespace, id: flow.id });

        await assertFlowDoesNotExist(flow);
    });

    // Delete flows by their IDs
    it('delete_flows_by_ids', async () => {
        const flow = await createSimpleFlow();

        const idWithNamespace = [{ id: flow.id, namespace: flow.namespace }];
        await kestraClient().Flows.deleteFlowsByIds({ body: idWithNamespace });

        await assertFlowDoesNotExist(flow);
    });

    // Delete flows returned by the query parameters
    it('delete_flows_by_query', async () => {
        const flow = await createSimpleFlow();

        await kestraClient().Flows.deleteFlowsByQuery({
            filters: [
                { field: 'NAMESPACE', operation: 'EQUALS', value: flow.namespace as any },
            ],
        });

        await assertFlowDoesNotExist(flow);
    });

    // Disable flows by their IDs
    it('disable_flows_by_ids', async () => {
        const flow = await createSimpleFlow();
        const idWithNamespace = [{ id: flow.id, namespace: flow.namespace }];
        await kestraClient().Flows.disableFlowsByIds({ body: idWithNamespace });
    });

    // Disable flows returned by the query parameters (placeholder like Java)
    it('disable_flows_by_query', async () => {
        const flow = await createSimpleFlow();
        void flow;
        // TODO when endpoint signature is available:
        // await kestraClient().Flows.disableFlowsByQuery({ filters: [...] });
    });

    // Enable flows by their IDs
    it('enable_flows_by_ids', async () => {
        const flow = await createSimpleFlow();
        const idWithNamespace = [{ id: flow.id, namespace: flow.namespace }];
        await kestraClient().Flows.enableFlowsByIds({ body: idWithNamespace });
    });

    // Enable flows returned by the query parameters (placeholder like Java)
    it('enable_flows_by_query', async () => {
        // TODO when endpoint signature is available:
        // await kestraClient().Flows.enableFlowsByQuery({ filters: [...] });
    });

    // Export flows as ZIP by IDs
    it('export_flows_by_ids', async () => {
        const flow = await createSimpleFlow();
        const idWithNamespace = [{ id: flow.id, namespace: flow.namespace }];
        await kestraClient().Flows.exportFlowsByIds({ body: idWithNamespace });
    });

    // Export flows as ZIP by query (placeholder like Java)
    it('export_flows_by_query', async () => {
        const flow = await createSimpleFlow();
        void flow;
        // TODO when endpoint signature is available:
        // await kestraClient().Flows.exportFlowsByQuery({ filters: [...] });
    });

    // Generate a graph for a flow
    it('generate_flow_graph', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;

        await kestraClient().Flows.generateFlowGraph({ namespace, id });
    });

    // Generate a graph for a flow source
    it('generate_flow_graph_from_source', async () => {
        const body = getSimpleFlow();
        await kestraClient().Flows.generateFlowGraphFromSource({ body });
    });

    // Get a flow
    it('get_flow', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;

        const resp = getDataOrThrow(await kestraClient().Flows.flow({ namespace, id }), 'Failed to get flow');
        expect(resp.id).toBe(id);
    });

    // Get flow dependencies
    it('get_flow_dependencies', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;

        await kestraClient().Flows.flowDependencies({ namespace, id, destinationOnly: true, expandAll: false });
    });

    // Retrieve flow dependencies for a namespace
    it('get_flow_dependencies_from_namespace', async () => {
        const flow = await createSimpleFlow();
        const { namespace } = flow;

        await kestraClient().Flows.flowDependenciesFromNamespace({ namespace, destinationOnly: true });
    });

    // Get a flow task
    it('get_task_from_flow', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;
        const taskId = (flow as any).tasks?.[0]?.id;

        await kestraClient().Flows.taskFromFlow({ namespace, id, taskId });
    });

    // List all distinct namespaces
    it('list_distinct_namespaces', async () => {
        await createSimpleFlow();
        const resp = getDataOrThrow(await kestraClient().Flows.listDistinctNamespaces({}), 'Failed to list distinct namespaces');
        expect(Array.isArray(resp)).toBe(true);
    });

    // Get revisions for a flow
    it('list_flow_revisions', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;
        const resp = getDataOrThrow(await kestraClient().Flows.listFlowRevisions({ namespace, id }), 'Failed to list flow revisions');
        expect(Array.isArray(resp)).toBe(true);
    });

    // Retrieve all flows from a given namespace
    it('list_flows_by_namespace', async () => {
        const flow = await createSimpleFlow();
        const { namespace } = flow;
        const resp = getDataOrThrow(await kestraClient().Flows.listFlowsByNamespace({ namespace }), 'Failed to list flows by namespace');
        expect(Array.isArray(resp)).toBe(true);
    });

    // Search for flows (placeholder like Java)
    it('search_flows', async () => {
        const flow = await createSimpleFlow();
        void flow;
        // TODO when endpoint/signature ready:
        // const resp = getDataOrThrow(await kestraClient().Flows.searchFlows({ page: 1, size: 10, namespace: flow.namespace }));
    });

    // Search for flows source code
    it('search_flows_by_source_code', async () => {
        const flow = await createSimpleFlow();
        const resp = getDataOrThrow(await kestraClient().Flows.searchFlowsBySourceCode({
            page: 1,
            size: 10000,
            q: flow.id,
            namespace: flow.namespace,
        }), 'Failed to search flows by source code');
        const ids = ((resp as any)?.results ?? []).map((x: any) => x?.model?.id);
        expect(ids).toContain(flow.id);
    });

    // Update a flow
    it('update_flow', async () => {
        const { flowBody, flowNamespace, flowId } = getSimpleFlowAndId();
        const flow = getDataOrThrow(await kestraClient().Flows.createFlow({ body: flowBody }), 'Failed to create flow for update');
        await assertFlowExist(flow);
        expect(flow.description).toBe('simple_flow_description');

        const namespace = flowNamespace;
        const id = flowId;
        const updatedBody = flowBody.replace('simple_flow_description', 'simple_flow_description_updated');

        const resp = getDataOrThrow(await kestraClient().Flows.updateFlow({ namespace, id, body: updatedBody }), 'Failed to update flow');
        expect(resp.description).toBe('simple_flow_description_updated');
    });

    // Validate flows (simple)
    it('validate_flows_simple', async () => {
        const body = getSimpleFlow();
        await kestraClient().Flows.validateFlows({ body });
    });

    // Validate flows (complete)
    it('validate_flows_complete', async () => {
        const body = getCompleteFlow();
        await kestraClient().Flows.validateFlows({ body });
    });

    // Validate a task
    it('validate_task', async () => {
        const section: FlowControllerTaskValidationType = 'TASKS';
        const taskObj = {
            id: 'task_one',
            type: 'io.kestra.plugin.core.log.Log',
            message: 'strange---string',
        };

        const resp = getDataOrThrow(await kestraClient().Flows.validateTask({ section, body: taskObj }), 'Failed to validate task');
        expect((resp as any).constraints ?? []).toHaveLength(0);
        expect((resp as any).warnings ?? []).toHaveLength(0);
    });

    // Validate a task (invalid)
    it('validate_task_invalid', async () => {
        const section: FlowControllerTaskValidationType = 'TASKS';
        const taskObj = {
            id: 'task_one',
            type: 'io.kestra.plugin.core.log.InvalidTask',
            message: 'strange---string',
        };

        const resp = getDataOrThrow(await kestraClient().Flows.validateTask({ section, body: taskObj }), 'Failed to validate invalid task');
        const raw = (resp as any)?.constraints ?? [];

        const constraints = Array.isArray(raw)
            ? raw
            : typeof raw === 'string'
                ? [raw]
                : Object.values(raw || {}).flatMap((v: unknown) => Array.isArray(v) ? v : [String(v)]);

        expect(constraints.join(' ')).toMatch(/Invalid type: io\.kestra\.plugin\.core\.log\.InvalidTask/);
    });

    // Validate trigger
    it('validate_trigger', async () => {
        const triggerObj = {
            id: 'monthly',
            type: 'io.kestra.plugin.core.trigger.Schedule',
            cron: '0 9 1 * *',
        };
        const resp = getDataOrThrow(await kestraClient().Flows.validateTrigger({ body: triggerObj }), 'Failed to validate trigger');
        expect((resp as any).constraints ?? []).toHaveLength(0);
        expect((resp as any).warnings ?? []).toHaveLength(0);
    });

    // Validate trigger (invalid)
    it('validate_trigger_invalid', async () => {
        const triggerObj = {
            id: 'monthly',
            type: 'io.kestra.plugin.core.trigger.InvalidType',
            cron: '0 9 1 * *',
        };

        const resp = getDataOrThrow(await kestraClient().Flows.validateTrigger({ body: triggerObj }), 'Failed to validate invalid trigger');
        const raw = (resp as any)?.constraints ?? [];

        const constraints = Array.isArray(raw)
            ? raw
            : typeof raw === 'string'
                ? [raw]
                : Object.values(raw || {}).flatMap((v: unknown) => Array.isArray(v) ? v : [String(v)]);

        expect(constraints.join(' ')).toMatch(/Invalid type: io\.kestra\.plugin\.core\.trigger\.InvalidType/);
    });
});
