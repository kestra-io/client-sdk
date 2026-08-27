import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Assets from '@kestra-io/kestra-sdk/assets';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Executions from '@kestra-io/kestra-sdk/executions';

function assetYaml(id: string): string {
    return `id: ${id}
type: io.kestra.plugin.ee.assets.Table
namespace: assets.test
tableName: ${id}
description: Test asset ${id}
`;
}

function logFlowYaml(id: string, ns: string): string {
    return `id: ${id}
namespace: ${ns}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World!
`;
}

async function createLogFlowExecution() {
    const flowId = randomId();
    const namespace = randomId();
    await Flows.createFlow({ body: logFlowYaml(flowId, namespace) });
    const execution = await Executions.createExecution({ namespace, id: flowId, wait: true });
    return { flowId, namespace, executionId: execution.id ?? "" };
}

describe('AssetsApi', () => {
    it('searchAssets: returns a paged result', async () => {
        const result = await Assets.searchAssets({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect(result.results).toBeDefined();
    });

    it('searchAssets: with pagination', async () => {
        const result = await Assets.searchAssets({ page: 1, size: 2 });
        expect(result).toBeDefined();
        const resultSize = (result).results?.length ?? 0;
        expect(resultSize).toBeLessThanOrEqual(2);
    });

    it('searchAssetLineageEvents: returns a paged result', async () => {
        const result = await Assets.searchAssetLineageEvents({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect(result.results).toBeDefined();
    });

    it('searchAssetUsages: returns a paged result', async () => {
        const result = await Assets.searchAssetUsages({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect(result.results).toBeDefined();
    });

    it('createAsset: creates an asset from YAML', async () => {
        const id = randomId();
        const result = await Assets.createAsset({ body: assetYaml(id) });
        expect(result).toBeDefined();
    });

    it('asset: retrieves a created asset', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });

        const fetched = await Assets.asset({ id: created.id ?? "" });
        expect(fetched).toBeDefined();
    });

    it('deleteAsset: deletes a created asset', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });

        await Assets.deleteAsset({ id: created.id ?? "" });
    });

    it('assetDependencies: retrieves dependencies for an asset', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });

        const result = await Assets.assetDependencies({ id: created.id ?? "" });
        expect(result).toBeDefined();
    });

    it('lockAsset + unlockAsset: manually locks then unlocks an asset', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });
        const assetId = created.id ?? "";

        const locked = await Assets.lockAsset({ id: assetId, ttl: 'PT5M' });
        expect(locked).toBeDefined();
        expect(locked.ownerType).toBe("USER");

        await Assets.unlockAsset({ id: assetId });
    });

    it('lockAsset: the lock owner may still update the asset it holds the lock on', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });
        const assetId = created.id ?? "";

        await Assets.lockAsset({ id: assetId });

        // updating the asset (not re-creating it) is what allows the lock's own owner through.
        const updated = await Assets.updateAsset({ id: assetId, body: assetYaml(id) });
        expect(updated.id).toBe(assetId);

        await Assets.unlockAsset({ id: assetId });
    });

    it('unlockAsset: execution-owned lock is released by its own matching executionId', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });
        const assetId = created.id ?? "";
        const { flowId, namespace, executionId } = await createLogFlowExecution();

        const lock = await Assets.lockAsset({
            id: assetId, ttl: 'PT1H',
            executionId, flowId, flowNamespace: namespace, taskRunId: randomId(),
        });
        expect(lock.ownerType).toBe("EXECUTION");

        // matching executionId is the owner-checked release path: the execution releases its own lock
        await Assets.unlockAsset({ id: assetId, executionId });

        const relock = await Assets.lockAsset({ id: assetId, ttl: 'PT1H' });
        expect(relock.ownerType).toBe("USER");

        await Assets.unlockAsset({ id: assetId });
    });

    it('unlockAsset: a mismatched executionId is owner-checked and is a no-op', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });
        const assetId = created.id ?? "";
        const owner = await createLogFlowExecution();
        const other = await createLogFlowExecution();

        await Assets.lockAsset({ id: assetId, ttl: 'PT1H', executionId: owner.executionId });

        // a different execution's unlock is owner-checked against the lock holder: no-op, does not throw
        await Assets.unlockAsset({ id: assetId, executionId: other.executionId });

        // lock is still held by the original owner: a manual USER lock attempt is rejected
        await expect(Assets.lockAsset({ id: assetId, ttl: 'PT1H' })).rejects.toThrow();

        await Assets.unlockAsset({ id: assetId, executionId: owner.executionId });
    });
});
