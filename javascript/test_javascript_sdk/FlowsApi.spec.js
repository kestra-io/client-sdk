// @ts-check
// FlowsApi.spec.js
import {
    MAIN_TENANT,
    kestraClient,
    getSimpleFlow,
    getCompleteFlow
} from './CommonTestSetup';
import { describe, it, expect } from 'vitest';

// ----- Helpers (mirror Java helpers) -----
async function createSimpleFlow() {
    const body = getSimpleFlow();
    const flow = await kestraClient().flowsApi.createFlow(MAIN_TENANT, body);
    await assertFlowExist(flow);
    return flow;
}

async function assertFlowExist(flow) {
    await expect(
        kestraClient().flowsApi.flow(
            flow.namespace,
            flow.id,
            false, // source
            false, // allowDeleted
            MAIN_TENANT,
            null   // revision
        )
    ).resolves.toBeDefined();
}

async function assertFlowDoesNotExist(flow) {
    try {
        await kestraClient().flowsApi.flow(flow.namespace, flow.id, false, false, MAIN_TENANT, {});
        throw new Error('Expected a 404 Not Found, but the call succeeded.');
    } catch (err) {
        const status = err?.status ?? err?.code ?? err?.response?.status;
        expect(status).toBe(404);
    }
}

describe('FlowsApi', () => {
    // Update from multiples yaml sources
    it('bulk_update_flows: Update from multiple yaml sources', async () => {
        const flowBody = getSimpleFlow();
        const flow = await kestraClient().flowsApi.createFlow(MAIN_TENANT, flowBody);
        await assertFlowExist(flow);
        expect(flow.description).toBe('simple_flow_description');

        const id = flow.id;
        const namespace = flow.namespace;
        const updatedBody = flowBody.replace('simple_flow_description', 'simple_flow_description_updated');

        // Java: bulkUpdateFlows(false, false, MAIN_TENANT, namespace, body)
        const resp = await kestraClient().flowsApi.bulkUpdateFlows(false, false, MAIN_TENANT, {namespace: namespace, body:updatedBody});

        // resp is a list; check first description updated
        const first = resp[0];
        expect(first?.description).toBe('simple_flow_description_updated');
    });

    // Create a flow from yaml source (simple)
    it('create_flow: simple', async () => {
        const body = getSimpleFlow();
        const flow = await kestraClient().flowsApi.createFlow(MAIN_TENANT, body);
        await assertFlowExist(flow);
    });

    // Create a flow from yaml source (full)
    it('create_flow: full', async () => {
        const body = getCompleteFlow();
        const flow = await kestraClient().flowsApi.createFlow(MAIN_TENANT, body);
        await assertFlowExist(flow);
    });

    // Delete a flow
    it('delete_flow', async () => {
        const flow = await createSimpleFlow();

        await kestraClient().flowsApi.deleteFlow(flow.namespace, flow.id, MAIN_TENANT);

        await assertFlowDoesNotExist(flow);
    });

    // Delete flows by their IDs
    it('delete_flows_by_ids', async () => {
        const flow = await createSimpleFlow();

        const idWithNamespace = [{ id: flow.id, namespace: flow.namespace }];
        await kestraClient().flowsApi.deleteFlowsByIds(MAIN_TENANT, idWithNamespace);

        await assertFlowDoesNotExist(flow);
    });

    // Delete flows returned by the query parameters
    it('delete_flows_by_query', async () => {
        const flow = await createSimpleFlow();

        const filters = [
            { field: 'NAMESPACE', operation: 'EQUALS', value: flow.namespace }
        ];
        await kestraClient().flowsApi.deleteFlowsByQuery(MAIN_TENANT, {filters:filters});

        await assertFlowDoesNotExist(flow);
    });

    // Disable flows by their IDs
    it('disable_flows_by_ids', async () => {
        const flow = await createSimpleFlow();
        const idWithNamespace = [{ id: flow.id, namespace: flow.namespace }];
        await kestraClient().flowsApi.disableFlowsByIds(MAIN_TENANT, idWithNamespace);
    });

    // Disable flows returned by the query parameters (placeholder like Java)
    it('disable_flows_by_query', async () => {
        const flow = await createSimpleFlow();
        const q = null;
        const scope = null;
        const namespace = null;
        const labels = null;
        void q; void scope; void namespace; void labels;
        // TODO when endpoint signature is available:
        // await kestraClient().flowsApi.disableFlowsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, labels);
    });

    // Enable flows by their IDs
    it('enable_flows_by_ids', async () => {
        const flow = await createSimpleFlow();
        const idWithNamespace = [{ id: flow.id, namespace: flow.namespace }];
        await kestraClient().flowsApi.enableFlowsByIds(MAIN_TENANT, idWithNamespace);
    });

    // Enable flows returned by the query parameters (placeholder like Java)
    it('enable_flows_by_query', async () => {
        // Keeping the shape; Java TODO
        const q = null;
        const scope = null;
        const namespace = null;
        const labels = null;
        void q; void scope; void namespace; void labels;
        // TODO when endpoint signature is available:
        // const resp = await kestraClient().flowsApi.enableFlowsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, labels);
    });

    // Export flows as ZIP by IDs
    it('export_flows_by_ids', async () => {
        const flow = await createSimpleFlow();
        const idWithNamespace = [{ id: flow.id, namespace: flow.namespace }];

        // Returns Blob/Buffer depending on runtime; no strict assertion in Java
        await kestraClient().flowsApi.exportFlowsByIds(MAIN_TENANT, idWithNamespace);
    });

    // Export flows as ZIP by query (placeholder like Java)
    it('export_flows_by_query', async () => {
        const flow = await createSimpleFlow();
        const filters = null;
        const q = null;
        const scope = null;
        const namespace = flow.namespace;
        const labels = null;
        void filters; void q; void scope; void namespace; void labels;
        // TODO when endpoint signature is available:
        // const zip = await kestraClient().flowsApi.exportFlowsByQuery(MAIN_TENANT, filters, q, scope, namespace, labels);
    });

    // Generate a graph for a flow
    it('generate_flow_graph', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;

        const revision = null;
        const subflows = null;
        await kestraClient().flowsApi.generateFlowGraph(namespace, id, MAIN_TENANT, {revision, subflows});
    });

    // Generate a graph for a flow source
    it('generate_flow_graph_from_source', async () => {
        const body = getSimpleFlow();
        const subflows = null;
        await kestraClient().flowsApi.generateFlowGraphFromSource(MAIN_TENANT, body, subflows);
    });

    // Get a flow
    it('get_flow', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;
        const source = false;
        const allowDeleted = false;
        const revision = null;

        const resp = await kestraClient().flowsApi.flow(namespace, id, source, allowDeleted, MAIN_TENANT, revision);
        expect(resp.id).toBe(id);
    });

    // Get flow dependencies
    it('get_flow_dependencies', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;
        const destinationOnly = true;
        const expandAll = false;

        await kestraClient().flowsApi.flowDependencies(namespace, id, destinationOnly, expandAll, MAIN_TENANT);
    });

    // Retrieve flow dependencies for a namespace
    it('get_flow_dependencies_from_namespace', async () => {
        const flow = await createSimpleFlow();
        const { namespace } = flow;
        const destinationOnly = true;

        await kestraClient().flowsApi.flowDependenciesFromNamespace(namespace, destinationOnly, MAIN_TENANT);
    });

    // Get a flow task
    it('get_task_from_flow', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;
        const taskId = flow.tasks?.[0]?.id;
        const revision = null;

        await kestraClient().flowsApi.taskFromFlow(namespace, id, taskId, MAIN_TENANT, revision);
    });

    // List all distinct namespaces
    it('list_distinct_namespaces', async () => {
        await createSimpleFlow();
        const q = null;
        const resp = await kestraClient().flowsApi.listDistinctNamespaces(MAIN_TENANT, q);
        expect(Array.isArray(resp)).toBe(true);
    });

    // Get revisions for a flow
    it('list_flow_revisions', async () => {
        const flow = await createSimpleFlow();
        const { namespace, id } = flow;
        const resp = await kestraClient().flowsApi.listFlowRevisions(namespace, id, MAIN_TENANT);
        expect(Array.isArray(resp)).toBe(true);
    });

    // Retrieve all flows from a given namespace
    it('list_flows_by_namespace', async () => {
        const flow = await createSimpleFlow();
        const { namespace } = flow;
        const resp = await kestraClient().flowsApi.listFlowsByNamespace(namespace, MAIN_TENANT);
        expect(Array.isArray(resp)).toBe(true);
    });

    // Search for flows (placeholder like Java)
    it('search_flows', async () => {
        const flow = await createSimpleFlow();
        const page = null;
        const size = null;
        const sort = null;
        const filters = null;
        const q = null;
        const scope = null;
        const namespace = flow.namespace;
        const labels = null;
        void page; void size; void sort; void filters; void q; void scope; void namespace; void labels;
        // TODO when endpoint/signature ready:
        // const resp = await kestraClient().flowsApi.searchFlows(page, size, MAIN_TENANT, sort, filters, q, scope, namespace, labels);
    });

    // Search for flows source code
    it('search_flows_by_source_code', async () => {
        const flow = await createSimpleFlow();
        const page = 1;
        const size = 10000;
        const sort = null;
        const q = flow.id;
        const namespace = flow.namespace;

        const resp = await kestraClient().flowsApi.searchFlowsBySourceCode(page, size, MAIN_TENANT, {sort, q, namespace});
        const ids = (resp?.results ?? []).map(x => x?.model?.id);
        expect(ids).toContain(flow.id);
    });

    // Update a flow
    it('update_flow', async () => {
        const flowBody = getSimpleFlow();
        const flow = await kestraClient().flowsApi.createFlow(MAIN_TENANT, flowBody);
        await assertFlowExist(flow);
        expect(flow.description).toBe('simple_flow_description');

        const id = flow.id;
        const namespace = flow.namespace;
        const updatedBody = flowBody.replace('simple_flow_description', 'simple_flow_description_updated');

        const resp = await kestraClient().flowsApi.updateFlow(namespace, id, MAIN_TENANT, updatedBody);
        expect(resp.description).toBe('simple_flow_description_updated');
    });

    // Validate flows (simple)
    it('validate_flows_simple', async () => {
        const body = getSimpleFlow();
        await kestraClient().flowsApi.validateFlows(MAIN_TENANT, body);
    });

    // Validate flows (complete)
    it('validate_flows_complete', async () => {
        const body = getCompleteFlow();
        await kestraClient().flowsApi.validateFlows(MAIN_TENANT, body);
    });

    // Validate a task
    it('validate_task', async () => {
        const section = 'TASKS'; // enum value
        const taskObj = {
            id: 'task_one',
            type: 'io.kestra.plugin.core.log.Log',
            message: 'strange---string',
        };

        const resp = await kestraClient().flowsApi.validateTask(section, MAIN_TENANT, taskObj);
        expect(resp.constraints ?? []).toHaveLength(0);
        expect(resp.warnings ?? []).toHaveLength(0);
    });

    // Validate a task (invalid)
    it('validate_task_invalid', async () => {
        const section = 'TASKS';
        const taskObj = {
            id: 'task_one',
            type: 'io.kestra.plugin.core.log.InvalidTask',
            message: 'strange---string',
        };

        const resp = await kestraClient().flowsApi.validateTask(section, MAIN_TENANT, taskObj);
        const raw = resp?.constraints ?? [];

        const constraints = Array.isArray(raw)
            ? raw
            : typeof raw === 'string'
                ? [raw]
                : Object.values(raw || {}).flatMap(v => Array.isArray(v) ? v : [String(v)]);

        expect(constraints.join(' ')).toMatch(/Invalid type: io\.kestra\.plugin\.core\.log\.InvalidTask/);
    });

    // Validate trigger
    it('validate_trigger', async () => {
        const triggerObj = {
            id: 'monthly',
            type: 'io.kestra.plugin.core.trigger.Schedule',
            cron: '0 9 1 * *',
        };
        const resp = await kestraClient().flowsApi.validateTrigger(MAIN_TENANT, triggerObj);
        expect(resp.constraints ?? []).toHaveLength(0);
        expect(resp.warnings ?? []).toHaveLength(0);
    });

    // Validate trigger (invalid)
    it('validate_trigger_invalid', async () => {
        const triggerObj = {
            id: 'monthly',
            type: 'io.kestra.plugin.core.trigger.InvalidType',
            cron: '0 9 1 * *',
        };

        const resp = await kestraClient().flowsApi.validateTrigger(MAIN_TENANT, triggerObj);
        const raw = resp?.constraints ?? [];

        const constraints = Array.isArray(raw)
            ? raw
            : typeof raw === 'string'
                ? [raw]
                : Object.values(raw || {}).flatMap(v => Array.isArray(v) ? v : [String(v)]);

        expect(constraints.join(' ')).toMatch(/Invalid type: io\.kestra\.plugin\.core\.trigger\.InvalidType/);
    });
});
