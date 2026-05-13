import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';

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
        const result = await kestraClient.Assets.searchAssets({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect((result as any).results).toBeDefined();
    });

    it('searchAssets: with pagination', async () => {
        const result = await kestraClient.Assets.searchAssets({ page: 1, size: 2 });
        expect(result).toBeDefined();
        const resultSize = (result as any).results?.length ?? 0;
        expect(resultSize).toBeLessThanOrEqual(2);
    });

    it('searchAssetLineageEvents: returns a paged result', async () => {
        const result = await kestraClient.Assets.searchAssetLineageEvents({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect((result as any).results).toBeDefined();
    });

    it('searchAssetUsages: returns a paged result', async () => {
        const result = await kestraClient.Assets.searchAssetUsages({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect((result as any).results).toBeDefined();
    });

    it('createAsset: creates an asset from YAML', async () => {
        const id = randomId();
        const result = await kestraClient.Assets.createAsset({ body: assetYaml(id) });
        expect(result).toBeDefined();
    });

    it('asset: retrieves a created asset', async () => {
        const id = randomId();
        const created = await kestraClient.Assets.createAsset({ body: assetYaml(id) });
        const assetId = (created as any).id ?? (created as any).uid;

        const fetched = await kestraClient.Assets.asset({ id: assetId });
        expect(fetched).toBeDefined();
    });

    it('deleteAsset: deletes a created asset', async () => {
        const id = randomId();
        const created = await kestraClient.Assets.createAsset({ body: assetYaml(id) });
        const assetId = (created as any).id ?? (created as any).uid;

        await kestraClient.Assets.deleteAsset({ id: assetId });
    });

    it('assetDependencies: retrieves dependencies for an asset', async () => {
        const id = randomId();
        const created = await kestraClient.Assets.createAsset({ body: assetYaml(id) });
        const assetId = (created as any).id ?? (created as any).uid;

        const result = await kestraClient.Assets.assetDependencies({ id: assetId });
        expect(result).toBeDefined();
    });
});
