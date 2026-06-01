import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
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
        const result = await kestraClient.WorkerGroups.list();
        expect(result).toBeDefined();
    });

    it('createWorkerGroup: creates a new worker group', async () => {
        const req = makeWorkerGroupRequest();
        const result = await kestraClient.WorkerGroups.create(req);
        expect(result).toBeDefined();
        expect((result as any).key ?? (result as any).id).toBeDefined();
    });

    it('workerGroupById: retrieves a worker group by id', async () => {
        const created = await kestraClient.WorkerGroups.create(makeWorkerGroupRequest());
        const id = (created as any).id;

        const result = await kestraClient.WorkerGroups.get({ id });
        expect(result).toBeDefined();
        expect((result as any).id).toBe(id);
    });

    it('updateWorkerGroupById: updates a worker group', async () => {
        const created = await kestraClient.WorkerGroups.create(makeWorkerGroupRequest());
        const id = created.id ?? "<none>";

        const result = await kestraClient.WorkerGroups.update({
            id,
            name: `updated-${id}`,
            description: 'Updated worker group description',
            subscriptions: [],
        });
        expect(result).toBeDefined();
    });

    it('deleteWorkerGroupById: deletes a worker group', async () => {
        const created = await kestraClient.WorkerGroups.create(makeWorkerGroupRequest());
        const id = (created as any).id;

        await kestraClient.WorkerGroups.deleteWorkerGroups({ id });
    });
});
