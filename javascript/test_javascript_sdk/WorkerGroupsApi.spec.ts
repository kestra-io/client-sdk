import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as WorkerGroups from '@kestra-io/kestra-sdk/worker-groups';
import { WorkerGroupControllerApiCreateWorkerGroupRequest } from '@kestra-io/kestra-sdk';

function makeWorkerGroupRequest(): WorkerGroupControllerApiCreateWorkerGroupRequest {
    return {
        id: `test-wg-${randomId()}`,
        name: `Test Worker Group ${randomId()}`,
        description: 'Test worker group',
        subscriptions: [],
    };
}

describe('WorkerGroupsApi', () => {
    it('listWorkerGroups: lists all worker groups', async () => {
        const result = await WorkerGroups.list();
        expect(result).toBeDefined();
    });

    it('createWorkerGroup: creates a new worker group', async () => {
        const req = makeWorkerGroupRequest();
        const result = await WorkerGroups.create(req);
        expect(result).toBeDefined();
        expect((result as any).key ?? (result as any).id).toBeDefined();
    });

    it('workerGroupById: retrieves a worker group by id', async () => {
        const created = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        const result = await WorkerGroups.get({ id });
        expect(result).toBeDefined();
        expect(result.id).toBe(id);
    });

    it('updateWorkerGroupById: updates a worker group', async () => {
        const created = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        const result = await WorkerGroups.update({
            id,
            name: `updated-${id}`,
            description: 'Updated worker group description',
            subscriptions: [],
        });
        expect(result).toBeDefined();
    });

    it('deleteWorkerGroupById: deletes a worker group', async () => {
        const created = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        await WorkerGroups.deleteWorkerGroups({ id });
    });

    it('capacity: returns the capacity of a worker group', async () => {
        const created = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        const result = await WorkerGroups.capacity({ id });
        expect(result.workerGroupId).toBe(id);
    });

    it('listRunningWorkers: lists running workers of a worker group', async () => {
        const created = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        const result = await WorkerGroups.listRunningWorkers({ id });
        // No workers subscribe to a freshly created group in the test environment.
        expect(result.workers ?? []).toEqual([]);
    });
});
