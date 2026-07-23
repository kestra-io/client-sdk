import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Assets from '@kestra-io/kestra-sdk/assets';

function assetYaml(id: string): string {
    return `id: ${id}
type: io.kestra.plugin.ee.assets.Table
namespace: assets.test
tableName: ${id}
description: Test asset ${id}
`;
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

        await Assets.unlockAsset({ id: assetId });
    });

    it('lockAsset: the lock owner may still update the asset it holds the lock on', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });
        const assetId = created.id ?? "";

        await Assets.lockAsset({ id: assetId });

        // re-upserting the same asset is an update, not a create; the lock's own owner is allowed through.
        const updated = await Assets.createAsset({ body: assetYaml(id) });
        expect(updated.id).toBe(assetId);

        await Assets.unlockAsset({ id: assetId });
    });

    it('lockAsset: acquires a manual user lock', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });

        const lock = await Assets.lockAsset({ id: created.id ?? "", ttl: "PT1H" });
        expect(lock).toBeDefined();
        expect(lock.ownerType).toBe("USER");
        expect(lock.lockedUntil).toBeDefined();
    });

    it('unlockAsset: releases the lock so it can be re-acquired', async () => {
        const id = randomId();
        const created = await Assets.createAsset({ body: assetYaml(id) });
        await Assets.lockAsset({ id: created.id ?? "", ttl: "PT1H" });

        await Assets.unlockAsset({ id: created.id ?? "" });

        const relock = await Assets.lockAsset({ id: created.id ?? "", ttl: "PT1H" });
        expect(relock).toBeDefined();
    });
});
