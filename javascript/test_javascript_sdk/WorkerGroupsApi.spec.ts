import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as WorkerGroups from '@kestra-io/kestra-sdk/worker-groups';
import * as WorkerQueuesAdmin from '@kestra-io/kestra-sdk/worker-queues-admin';
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

    // A subscription edge points a worker group at an existing Worker Queue, so
    // every subscription test first creates a queue to route to.
    async function createWorkerQueue() {
        const wqId = `test-wq-${randomId()}`;
        await WorkerQueuesAdmin.create({ id: wqId, tags: [wqId] });
        return wqId;
    }

    it('addSubscription: subscribes a worker group to a worker queue', async () => {
        const group = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = group.id ?? "<none>";
        const workerQueueId = await createWorkerQueue();

        const result = await WorkerGroups.addSubscription({ id, workerQueueId, reservedPercent: 10 });
        expect(result.id).toBe(id);
        expect((result.subscriptions ?? []).some((s) => s.queue?.id === workerQueueId)).toBe(true);
    });

    it('updateSubscriptionReservation: updates a subscription\'s reserved capacity', async () => {
        const group = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = group.id ?? "<none>";
        const workerQueueId = await createWorkerQueue();
        await WorkerGroups.addSubscription({ id, workerQueueId, reservedPercent: 10 });

        const result = await WorkerGroups.updateSubscriptionReservation({ id, workerQueueId, reservedPercent: 25 });
        const sub = (result.subscriptions ?? []).find((s) => s.queue?.id === workerQueueId);
        expect(sub?.reservedPercent).toBe(25);
    });

    it('removeSubscription: removes a subscription from a worker group', async () => {
        const group = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = group.id ?? "<none>";
        const workerQueueId = await createWorkerQueue();
        await WorkerGroups.addSubscription({ id, workerQueueId, reservedPercent: 10 });

        const result = await WorkerGroups.removeSubscription({ id, workerQueueId });
        expect((result.subscriptions ?? []).some((s) => s.queue?.id === workerQueueId)).toBe(false);
    });

    it('generateToken: generates a registration token', async () => {
        const group = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = group.id ?? "<none>";

        const result = await WorkerGroups.generateToken({ id, name: `token-${randomId()}` });
        expect(result.token).toBeDefined();
        expect(result.details?.uid).toBeDefined();
    });

    it('revokeToken: revokes a registration token', async () => {
        const group = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = group.id ?? "<none>";
        const token = await WorkerGroups.generateToken({ id, name: `token-${randomId()}` });
        const tokenId = token.details?.uid ?? "<none>";

        await WorkerGroups.revokeToken({ id, tokenId });

        const group2 = await WorkerGroups.get({ id });
        const summary = (group2.tokens ?? []).find((t) => t.uid === tokenId);
        expect(summary?.revoked).toBe(true);
    });

    it('deleteToken: deletes a registration token', async () => {
        const group = await WorkerGroups.create(makeWorkerGroupRequest());
        const id = group.id ?? "<none>";
        const token = await WorkerGroups.generateToken({ id, name: `token-${randomId()}` });
        const tokenId = token.details?.uid ?? "<none>";

        await WorkerGroups.deleteToken({ id, tokenId });

        const group2 = await WorkerGroups.get({ id });
        expect((group2.tokens ?? []).some((t) => t.uid === tokenId)).toBe(false);
    });
});
