import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
import type { InstanceControllerApiCreateOrUpdateWorkerGroupRequest } from '@kestra-io/kestra-sdk';

function makeWorkerGroupRequest(): InstanceControllerApiCreateOrUpdateWorkerGroupRequest {
    return {
        key: `test-wg-${randomId()}`,
        description: 'Test worker group',
        allowedTenants: [],
    };
}

describe('WorkerGroupsApi', () => {
    it('listWorkerGroups: lists all worker groups', async () => {
        const result = await kestraClient.WorkerGroups.listWorkerGroups();
        expect(result).toBeDefined();
    });

    it('createWorkerGroup: creates a new worker group', async () => {
        const req = makeWorkerGroupRequest();
        const result = await kestraClient.WorkerGroups.createWorkerGroup(req);
        expect(result).toBeDefined();
        expect((result as any).key ?? (result as any).id).toBeDefined();
    });

    it('workerGroupById: retrieves a worker group by id', async () => {
        const created = await kestraClient.WorkerGroups.createWorkerGroup(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        const result = await kestraClient.WorkerGroups.workerGroupById({ id });
        expect(result).toBeDefined();
        expect(result.id).toBe(id);
    });

    it('updateWorkerGroupById: updates a worker group', async () => {
        const created = await kestraClient.WorkerGroups.createWorkerGroup(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        // `key` is immutable once created — the server derives a uid from it and
        // rejects updates that submit a different key with "Invalid uid for key".
        // Only description/allowedTenants can change; key must be resent as-is.
        const result = await kestraClient.WorkerGroups.updateWorkerGroupById({
            id,
            key: created.key ?? "",
            description: 'Updated worker group description',
            allowedTenants: [],
        });
        expect(result).toBeDefined();
        expect((result as any).description).toBe('Updated worker group description');
    });

    it('deleteWorkerGroupById: deletes a worker group', async () => {
        const created = await kestraClient.WorkerGroups.createWorkerGroup(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        await kestraClient.WorkerGroups.deleteWorkerGroupById({ id });
    });
});
