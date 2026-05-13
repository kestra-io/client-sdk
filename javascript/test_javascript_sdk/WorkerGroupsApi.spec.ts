import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
import type { InstanceControllerApiCreateOrUpdateWorkerGroupRequest } from '@kestra-io/kestra-sdk';

function makeWorkerGroupRequest(): InstanceControllerApiCreateOrUpdateWorkerGroupRequest {
    return {
        key: `test-wg-${randomId()}`,
        description: 'Test worker group',
    };
}

describe('WorkerGroupsApi', () => {
    it('listWorkerGroups: lists all worker groups', async () => {
        const result = await kestraClient.WorkerGroups.listWorkerGroups();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('createWorkerGroup: creates a new worker group', async () => {
        const req = makeWorkerGroupRequest();
        const result = await kestraClient.WorkerGroups.createWorkerGroup(req);
        expect(result).toBeDefined();
        expect((result as any).key ?? (result as any).id).toBeDefined();
    });

    it('workerGroupById: retrieves a worker group by id', async () => {
        const created = await kestraClient.WorkerGroups.createWorkerGroup(makeWorkerGroupRequest());
        const id = (created as any).id;

        const result = await kestraClient.WorkerGroups.workerGroupById({ id });
        expect(result).toBeDefined();
        expect((result as any).id).toBe(id);
    });

    it('updateWorkerGroupById: updates a worker group', async () => {
        const created = await kestraClient.WorkerGroups.createWorkerGroup(makeWorkerGroupRequest());
        const id = (created as any).id;
        const key = (created as any).key ?? makeWorkerGroupRequest().key;

        const result = await kestraClient.WorkerGroups.updateWorkerGroupById({
            id,
            key,
            description: 'Updated worker group description',
        });
        expect(result).toBeDefined();
    });

    it('deleteWorkerGroupById: deletes a worker group', async () => {
        const created = await kestraClient.WorkerGroups.createWorkerGroup(makeWorkerGroupRequest());
        const id = (created as any).id;

        await kestraClient.WorkerGroups.deleteWorkerGroupById({ id });
    });
});
