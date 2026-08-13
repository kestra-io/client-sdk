// CasesApi.spec.ts — covers both the Cases and CasesAdmin modules.
//
// Heads-up on module naming: the two `search` wrappers are crossed relative to
// what their module names suggest. `Cases.search` hits
// `/case-templates/search` (templates) and `CasesAdmin.search` hits
// `/cases/search` (cases). Both endpoints are tagged `Cases` in the spec, so
// the split comes from the generator, not the API. Aliases below keep the call
// sites honest about which resource is being searched.
import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Cases from '@kestra-io/kestra-sdk/cases';
import * as CasesAdmin from '@kestra-io/kestra-sdk/cases-admin';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Executions from '@kestra-io/kestra-sdk/executions';
import * as Assets from '@kestra-io/kestra-sdk/assets';

const searchCaseTemplates = Cases.search;
const searchCases = CasesAdmin.search;

// ---------- fixtures ----------

function logFlowYaml(id: string, ns: string): string {
    return `id: ${id}
namespace: ${ns}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World!
`;
}

function assetYaml(id: string): string {
    return `id: ${id}
type: io.kestra.plugin.ee.assets.Table
namespace: cases.test
tableName: ${id}
description: Test asset ${id}
`;
}

async function createCase(overrides: Record<string, unknown> = {}) {
    return Cases.createCase({
        namespace: `cases.test.${randomId()}`,
        title: `case_${randomId()}`,
        description: 'created by CasesApi.spec.ts',
        severity: 'LOW',
        ...overrides,
    } as Parameters<typeof Cases.createCase>[0]);
}

/** A case plus a flow in its namespace, for the action and auto-attach endpoints. */
async function createCaseWithFlow() {
    const namespace = `cases.test.${randomId()}`;
    const flowId = randomId();
    await Flows.createFlow({ body: logFlowYaml(flowId, namespace) });
    const created = await createCase({ namespace });
    return { id: created.id ?? '', namespace, flowId };
}

async function createExecution() {
    const namespace = `cases.test.${randomId()}`;
    const flowId = randomId();
    await Flows.createFlow({ body: logFlowYaml(flowId, namespace) });
    const execution = await Executions.createExecution({ namespace, id: flowId, wait: true });
    return { executionId: execution.id ?? '', namespace, flowId };
}

function namespaceFilter(namespace: string) {
    return [{ field: 'namespace', operation: 'EQUALS', value: namespace as any }] as any;
}

async function statusOf(promise: Promise<unknown>) {
    try {
        await promise;
        return 0;
    } catch (err: unknown) {
        return (err as any)?.status ?? (err as any)?.code ?? (err as any)?.response?.status;
    }
}

// ---------- case templates (CasesAdmin) ----------

describe('CasesAdminApi', () => {
    function templateRequest(name: string) {
        return {
            name,
            namespace: 'cases.test',
            defaultSeverity: 'MEDIUM' as const,
            description: `template ${name}`,
            resolutionReasons: ['FIXED', 'WONT_FIX'],
            requireResolutionNote: false,
        };
    }

    it('create: creates a case template', async () => {
        const result = await CasesAdmin.create(templateRequest(`tpl_${randomId()}`));
        expect(result).toBeDefined();
    });

    it('get: retrieves a created case template', async () => {
        const created = await CasesAdmin.create(templateRequest(`tpl_${randomId()}`));

        const result = await CasesAdmin.get({ id: created.id ?? '' });
        expect(result.id).toBe(created.id);
    });

    it('update: replaces a case template', async () => {
        const created = await CasesAdmin.create(templateRequest(`tpl_${randomId()}`));
        const renamed = `tpl_${randomId()}`;

        const result = await CasesAdmin.update({ id: created.id ?? '', ...templateRequest(renamed) });
        expect(result.name).toBe(renamed);
    });

    it('deleteCases: deletes a case template', async () => {
        const created = await CasesAdmin.create(templateRequest(`tpl_${randomId()}`));

        await CasesAdmin.deleteCases({ id: created.id ?? '' });

        // The wrapper is named `deleteCases` but deletes a *template*; confirm the
        // template is gone rather than trusting the name.
        expect(await statusOf(CasesAdmin.get({ id: created.id ?? '' }))).toBe(404);
    });

    it('search (case templates): returns a paged result', async () => {
        await CasesAdmin.create(templateRequest(`tpl_${randomId()}`));

        const result = await searchCaseTemplates({ page: 1, size: 10, filters: [] as any });
        expect(result.results).toBeDefined();
        expect(Array.isArray(result.results)).toBe(true);
    });
});

// ---------- cases ----------

describe('CasesApi', () => {
    it('createCase: creates a case', async () => {
        const result = await createCase();
        expect(result.id).toBeDefined();
    });

    it('case_: retrieves a created case', async () => {
        const created = await createCase();

        const result = await Cases.case_({ id: created.id ?? '' });
        expect(result.id).toBe(created.id);
    });

    it('updateCase: updates title, description and severity', async () => {
        const created = await createCase();
        const title = `renamed_${randomId()}`;

        const result = await Cases.updateCase({
            id: created.id ?? '',
            title,
            description: 'updated by CasesApi.spec.ts',
            severity: 'HIGH',
        });
        expect(result.title).toBe(title);
    });

    it('deleteCase: deletes a case', async () => {
        const created = await createCase();

        await Cases.deleteCase({ id: created.id ?? '' });

        expect(await statusOf(Cases.case_({ id: created.id ?? '' }))).toBe(404);
    });

    it('search (cases): returns a paged result', async () => {
        const created = await createCase();

        const result = await searchCases({ page: 1, size: 10, filters: [] as any });
        expect(Array.isArray(result.results)).toBe(true);
        void created;
    });

    it('counts: counts cases by status', async () => {
        const created = await createCase();

        const result = await Cases.counts({ filters: [] as any });
        expect(result).toBeDefined();
        void created;
    });

    it('assignees: lists the distinct assignees among matching cases', async () => {
        await createCase();

        const result = await Cases.assignees({ filters: [] as any });
        expect(result).toBeDefined();
    });

    it('acknowledge: acknowledges a single case', async () => {
        const created = await createCase();

        await Cases.acknowledge({ id: created.id ?? '' });

        const reloaded = await Cases.case_({ id: created.id ?? '' });
        expect(reloaded.status).not.toBe('OPEN');
    });

    it('acknowledgeCasesByIds: acknowledges a batch of cases', async () => {
        const first = await createCase();
        const second = await createCase();

        const result = await Cases.acknowledgeCasesByIds({ body: [first.id ?? '', second.id ?? ''] });
        expect(result).toBeDefined();
    });

    it('deleteCasesByIds: deletes a batch of cases', async () => {
        const first = await createCase();
        const second = await createCase();

        await Cases.deleteCasesByIds({ body: [first.id ?? '', second.id ?? ''] });

        expect(await statusOf(Cases.case_({ id: first.id ?? '' }))).toBe(404);
    });

    it('deleteCasesByQuery: deletes the cases matching a filter', async () => {
        const namespace = `cases.test.${randomId()}`;
        const created = await createCase({ namespace });

        await Cases.deleteCasesByQuery({ filters: namespaceFilter(namespace) });

        expect(await statusOf(Cases.case_({ id: created.id ?? '' }))).toBe(404);
    });

    it('changeStatus: moves a case to another status', async () => {
        const created = await createCase();

        const result = await Cases.changeStatus({ id: created.id ?? '', status: 'INVESTIGATING' });
        expect(result).toBeDefined();
    });

    it('resolve: resolves a case with a reason', async () => {
        const created = await createCase();

        const result = await Cases.resolve({
            id: created.id ?? '',
            reason: 'FIXED',
            note: 'resolved by CasesApi.spec.ts',
        });
        expect(result).toBeDefined();
    });

    it('cancel: cancels a case', async () => {
        const created = await createCase();

        const result = await Cases.cancel({
            id: created.id ?? '',
            reason: 'not actionable',
            note: 'cancelled by CasesApi.spec.ts',
        });
        expect(result).toBeDefined();
    });

    it('assign: records an assignment note on a case', async () => {
        const created = await createCase();

        const result = await Cases.assign({ id: created.id ?? '', note: 'triage' });
        expect(result).toBeDefined();
    });

    it('follow + unfollow: subscribes then unsubscribes from a case', async () => {
        const created = await createCase();

        await Cases.follow({ id: created.id ?? '' });
        await Cases.unfollow({ id: created.id ?? '' });
    });

    it('addComment + events: comments on a case and sees it on the timeline', async () => {
        const created = await createCase();

        // The wrapper flattens the multipart body: `body` is the comment text and
        // `filesPublisher` would carry attachments.
        await Cases.addComment({ id: created.id ?? '', body: 'a comment' });

        const timeline = await Cases.events({ id: created.id ?? '', page: 1, size: 10 });
        expect(Array.isArray(timeline.results)).toBe(true);
    });

    it('downloadAttachment: 404s for an attachment that does not exist', async () => {
        const created = await createCase();

        // Uploading an attachment needs a multipart publisher the generated client
        // does not expose conveniently, so exercise the endpoint through its
        // not-found path: a real attachment id would be read the same way.
        expect(await statusOf(Cases.downloadAttachment({
            id: created.id ?? '',
            attachmentId: randomId(),
        }))).toBe(404);
    });

    // ---------- actions ----------

    it('attachAction + updateAction + detachAction: manages a case action', async () => {
        const { id, namespace, flowId } = await createCaseWithFlow();

        await Cases.attachAction({ id, label: 'remediate', namespace, flowId });
        await Cases.updateAction({ id, namespace, flowId, label: 'remediate-renamed' });
        await Cases.detachAction({ id, namespace, flowId });
    });

    it('runAction: runs an attached flow action', async () => {
        const { id, namespace, flowId } = await createCaseWithFlow();
        await Cases.attachAction({ id, label: 'remediate', namespace, flowId });

        const result = await Cases.runAction({ id, namespace, flowId });
        expect(result).toBeDefined();
    });

    // ---------- assets ----------

    it('attachAsset + assets + detachAsset: links then unlinks an asset', async () => {
        const created = await createCase();
        const asset = await Assets.createAsset({ body: assetYaml(randomId()) });
        const caseId = created.id ?? '';
        const assetId = asset.id ?? '';

        await Cases.attachAsset({ id: caseId, assetId });

        // `assets` answers a paged result, not a bare array, and reports both the
        // explicitly linked assets and the ones derived from linked executions.
        const linked = await Cases.assets({ id: caseId });
        expect(linked.results.map((asset) => asset.assetId)).toContain(assetId);

        await Cases.detachAsset({ id: caseId, assetId });
    });

    it('byAsset: lists the cases linked to an asset', async () => {
        const created = await createCase();
        const asset = await Assets.createAsset({ body: assetYaml(randomId()) });
        const assetId = asset.id ?? '';
        await Cases.attachAsset({ id: created.id ?? '', assetId });

        const result = await Cases.byAsset({ assetId });
        expect(result).toBeDefined();
    });

    // ---------- executions ----------

    it('linkExecutions + executions + unlinkExecution: links then unlinks an execution', async () => {
        const created = await createCase();
        const { executionId } = await createExecution();
        const caseId = created.id ?? '';

        await Cases.linkExecutions({ id: caseId, executionIds: [executionId] });

        const linked = await Cases.executions({ id: caseId, page: 1, size: 10 });
        expect(linked.results).toBeDefined();

        await Cases.unlinkExecution({ id: caseId, executionId });
    });

    it('linkExecutionsByQuery: links the executions matching a filter', async () => {
        const created = await createCase();
        const { namespace } = await createExecution();

        const result = await Cases.linkExecutionsByQuery({
            id: created.id ?? '',
            filters: namespaceFilter(namespace),
        });
        expect(result).toBeDefined();
    });

    it('byExecutions: looks up the cases linked to a batch of executions', async () => {
        const created = await createCase();
        const { executionId } = await createExecution();
        await Cases.linkExecutions({ id: created.id ?? '', executionIds: [executionId] });

        const result = await Cases.byExecutions({ body: [executionId] });
        expect(result).toBeDefined();
    });

    it('createFromExecutions: creates a case from a selection of executions', async () => {
        const { executionId } = await createExecution();

        const result = await Cases.createFromExecutions({
            case: {
                namespace: `cases.test.${randomId()}`,
                title: `from_executions_${randomId()}`,
                severity: 'LOW',
            },
            executionIds: [executionId],
        });
        expect(result.id).toBeDefined();
    });

    it('createFromExecutionsByQuery: creates a case from executions matching a query', async () => {
        const { namespace } = await createExecution();

        const result = await Cases.createFromExecutionsByQuery({
            case: {
                namespace: `cases.test.${randomId()}`,
                title: `from_query_${randomId()}`,
                severity: 'LOW',
            },
            filters: namespaceFilter(namespace),
        });
        expect(result.id).toBeDefined();
    });

    it('createFromTask: creates a case from a task run', async () => {
        const { namespace, flowId } = await createExecution();

        const result = await Cases.createFromTask({
            namespace: `cases.test.${randomId()}`,
            title: `from_task_${randomId()}`,
            severity: 'LOW',
            flowNamespace: namespace,
            flowId,
            taskId: 'hello',
        });
        expect(result).toBeDefined();
    });

    // ---------- auto-attach ----------

    // Enabling auto-attach makes the server write a generated system flow whose task is
    // `io.kestra.plugin.kestra.ee.cases.CreateCase`. That task ships in a downstream plugin
    // repo, so on the `-no-plugins` image the tests run against the flow fails validation and
    // the endpoint answers 422 "Invalid type: io.kestra.plugin.kestra.ee.cases.CreateCase".
    // Nothing the SDK can pass avoids it — unskip once the test instance ships plugin-kestra.
    it.skip('enableAutoAttach: starts auto-attaching matching executions', async () => {
        const { id, namespace, flowId } = await createCaseWithFlow();

        const result = await Cases.enableAutoAttach({ id, namespace, flowId, states: ['FAILED'] });
        expect(result.id).toBe(id);
    });

    it('disableAutoAttach: is a no-op on a case that never enabled it', async () => {
        const created = await createCase();

        const result = await Cases.disableAutoAttach({ id: created.id ?? '' });
        expect(result.id).toBe(created.id);
    });
});
