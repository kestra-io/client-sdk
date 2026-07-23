// PoliciesApi.spec.ts
import { describe, it, expect } from 'vitest';
import { randomId, getSimpleFlowAndId } from './_utils.js';
import { tenantId } from './_setup.js';
import * as Policies from '@kestra-io/kestra-sdk/policies';
import * as Namespaces from '@kestra-io/kestra-sdk/namespaces';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import type { PolicyRequest, Rule } from '@kestra-io/kestra-sdk';

// `io.kestra.plugin.ee.rules.Require` is a built-in FLOW-scoped governance rule: it reports
// a violation when the listed properties are missing from a flow after mutation.
function requireTimeoutRule(): Rule {
    return {
        type: 'io.kestra.plugin.ee.rules.Require',
        on: 'FLOW',
        action: 'WARN',
        errorMessage: 'timeout is required',
        properties: ['timeout'],
    } as Rule;
}

function policyRequest(id: string): PolicyRequest {
    return {
        id,
        displayName: `Test policy ${id}`,
        enforcement: 'EVALUATE',
        rules: [requireTimeoutRule()],
    };
}

async function createTestNamespace() {
    const nsId = `test_policy_ns_${randomId()}`;
    return Namespaces.createNamespace({ id: nsId, deleted: false, tenant: tenantId });
}

const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

// Policy search reads from an index that's updated asynchronously after a create,
// so a search issued immediately afterwards can miss a just-created policy. Poll
// until it shows up (or give up after timeoutMs) instead of asserting on a single read.
async function waitForPolicyInSearch(
    search: () => Promise<{ results?: any[] } | undefined>,
    id: string,
    timeoutMs = 5000,
    pollMs = 200,
) {
    const start = Date.now();
    // eslint-disable-next-line no-constant-condition
    while (true) {
        const result = await search();
        const results = result?.results ?? [];
        if (results.some((p: any) => p.id === id)) return results;
        if (Date.now() - start > timeoutMs) return results;
        await sleep(pollMs);
    }
}

describe('PoliciesApi (instance scope)', () => {
    it('createInstancePolicy + instancePolicy: creates and retrieves a policy', async () => {
        const id = `test-instance-policy-${randomId()}`;
        const created = await Policies.createInstancePolicy(policyRequest(id));
        expect(created.id).toBe(id);

        const fetched = await Policies.instancePolicy({ id });
        expect(fetched.id).toBe(id);
        expect(fetched.enforcement).toBe('EVALUATE');
    });

    it('searchInstancePolicies: finds a created policy', async () => {
        const id = `test-search-instance-policy-${randomId()}`;
        await Policies.createInstancePolicy(policyRequest(id));

        const results = await waitForPolicyInSearch(
            () => Policies.searchInstancePolicies({ page: 1, size: 100 }),
            id,
        );
        expect(results.some((p: any) => p.id === id)).toBeTruthy();
    });

    it('updateInstancePolicy: updates displayName and enforcement', async () => {
        const id = `test-update-instance-policy-${randomId()}`;
        await Policies.createInstancePolicy(policyRequest(id));

        const updated = await Policies.updateInstancePolicy({
            ...policyRequest(id),
            displayName: 'Updated display name',
            enforcement: 'ACTIVE',
        });

        expect(updated.displayName).toBe('Updated display name');
        expect(updated.enforcement).toBe('ACTIVE');
    });

    it('evaluateInstancePolicy: dry-runs the policy against flows in scope', async () => {
        const id = `test-evaluate-instance-policy-${randomId()}`;
        await Policies.createInstancePolicy(policyRequest(id));

        const result = await Policies.evaluateInstancePolicy({ id, page: 1, size: 10 });
        expect(result).toBeDefined();
        expect(typeof result.total).toBe('number');
    });

    it('deleteInstancePoliciesByIds: removes a policy', async () => {
        const id = `test-delete-instance-policy-${randomId()}`;
        await Policies.createInstancePolicy(policyRequest(id));

        await Policies.deleteInstancePoliciesByIds({ body: [id] });

        await expect(() => Policies.instancePolicy({ id })).rejects.toThrow();
    });
});

describe('PoliciesApi (namespace scope)', () => {
    it('createNamespacePolicy + namespacePolicy: creates and retrieves a policy', async () => {
        const ns = await createTestNamespace();
        const id = `test-namespace-policy-${randomId()}`;

        const created = await Policies.createNamespacePolicy({
            ...policyRequest(id),
            namespace: ns.id,
        });
        expect(created.id).toBe(id);

        const fetched = await Policies.namespacePolicy({ namespace: ns.id, id });
        expect(fetched.id).toBe(id);
    });

    it('searchNamespacePolicies: resolves the scope chain for a namespace', async () => {
        const ns = await createTestNamespace();
        const id = `test-search-namespace-policy-${randomId()}`;
        await Policies.createNamespacePolicy({ ...policyRequest(id), namespace: ns.id });

        const results = await waitForPolicyInSearch(
            () => Policies.searchNamespacePolicies({ namespace: ns.id, page: 1, size: 100 }),
            id,
        );
        expect(results.some((p: any) => p.id === id)).toBeTruthy();
    });

    it('updateNamespacePolicy: updates the policy description', async () => {
        const ns = await createTestNamespace();
        const id = `test-update-namespace-policy-${randomId()}`;
        await Policies.createNamespacePolicy({ ...policyRequest(id), namespace: ns.id });

        const updated = await Policies.updateNamespacePolicy({
            ...policyRequest(id),
            namespace: ns.id,
            description: 'now requires a timeout',
        });
        expect(updated.description).toBe('now requires a timeout');
    });

    it('evaluateNamespacePolicy: dry-runs the policy against flows in the namespace', async () => {
        const ns = await createTestNamespace();
        const id = `test-evaluate-namespace-policy-${randomId()}`;
        await Policies.createNamespacePolicy({ ...policyRequest(id), namespace: ns.id });

        const result = await Policies.evaluateNamespacePolicy({ namespace: ns.id, id, page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('deleteNamespacePolicy: removes a policy', async () => {
        const ns = await createTestNamespace();
        const id = `test-delete-namespace-policy-${randomId()}`;
        await Policies.createNamespacePolicy({ ...policyRequest(id), namespace: ns.id });

        await Policies.deleteNamespacePolicy({ namespace: ns.id, id });

        await expect(() => Policies.namespacePolicy({ namespace: ns.id, id })).rejects.toThrow();
    });

    it('previewPolicies: reports a violation for a flow missing a required property', async () => {
        const ns = await createTestNamespace();
        const policyId = `test-preview-policy-${randomId()}`;
        await Policies.createNamespacePolicy({
            ...policyRequest(policyId),
            namespace: ns.id,
            enforcement: 'ACTIVE',
        });

        const { flowBody } = getSimpleFlowAndId();
        const preview = await Flows.previewPolicies({ namespace: ns.id, source: flowBody });

        expect(preview).toBeDefined();
        expect(Array.isArray(preview.violations)).toBe(true);
        expect(preview.violations?.some(v => v.target === 'timeout')).toBeTruthy();
    });
});

describe('PoliciesApi (tenant scope)', () => {
    it('createTenantPolicy + tenantPolicy: creates and retrieves a policy', async () => {
        const id = `test-tenant-policy-${randomId()}`;
        const created = await Policies.createTenantPolicy(policyRequest(id));
        expect(created.id).toBe(id);

        const fetched = await Policies.tenantPolicy({ id });
        expect(fetched.id).toBe(id);
    });

    it('searchPolicies: finds a tenant-scope policy across scopes', async () => {
        const id = `test-search-policies-${randomId()}`;
        await Policies.createTenantPolicy(policyRequest(id));

        const results = await waitForPolicyInSearch(
            () => Policies.searchPolicies({ page: 1, size: 100 }),
            id,
        );
        expect(results.some((p: any) => p.id === id)).toBeTruthy();
    });

    it('exportTenantPolicies: exports every tenant-scope policy as YAML', async () => {
        const id = `test-export-policy-${randomId()}`;
        await Policies.createTenantPolicy(policyRequest(id));

        const exported = await Policies.exportTenantPolicies();
        expect(typeof exported).toBe('string');
        expect(exported).toContain(id);
    });

    it('importPolicies: imports a policy from a YAML document', async () => {
        const id = `test-import-policy-${randomId()}`;
        const yaml = `id: ${id}\nscope: TENANT\nenforcement: EVALUATE\nrules:\n  - type: io.kestra.plugin.ee.rules.Require\n    on: FLOW\n    errorMessage: timeout is required\n    properties: [timeout]\n`;
        const fileUpload = new File([yaml], 'policies.yml', { type: 'application/x-yaml' });

        await Policies.importPolicies({ fileUpload });

        const fetched = await Policies.tenantPolicy({ id });
        expect(fetched.id).toBe(id);
    });

    it('deleteTenantPoliciesByIds: removes tenant-scope policies', async () => {
        const id = `test-delete-tenant-policy-${randomId()}`;
        await Policies.createTenantPolicy(policyRequest(id));

        await Policies.deleteTenantPoliciesByIds({ body: [id] });

        await expect(() => Policies.tenantPolicy({ id })).rejects.toThrow();
    });
});
