import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as WorkerQueues from '@kestra-io/kestra-sdk/worker-queues';
import * as WorkerQueuesAdmin from '@kestra-io/kestra-sdk/worker-queues-admin';

describe('WorkerQueuesApi', () => {
    it('subscribers: a freshly created worker queue has no subscribing groups', async () => {
        // Worker Queues are created via the admin API; drive `subscribers`
        // against a queue we just created rather than a guessed id.
        const id = `test-wq-${randomId()}`;
        const created = await WorkerQueuesAdmin.create({ id, tags: [id] });
        expect(created.id).toBe(id);

        // A worker group subscribes to a queue via its own configuration, so a
        // brand-new queue has exactly zero subscribing groups.
        const result = await WorkerQueues.subscribers({ id });
        expect(result.groups ?? []).toEqual([]);
    });

    // A created queue's tags surface in `workerSelectorTags`, so each test that
    // creates one deletes it again in a `finally` — otherwise the leaked tags
    // break MiscApi's `workerSelectorTags: … equals []` expectation.
    it('list: lists all worker queues', async () => {
        const id = `test-wq-${randomId()}`;
        await WorkerQueuesAdmin.create({ id, tags: [id] });
        try {
            const result = await WorkerQueuesAdmin.list();
            expect((result.workerQueues ?? []).some((q) => q.id === id)).toBe(true);
        } finally {
            await WorkerQueuesAdmin.deleteWorkerQueues({ id }).catch(() => undefined);
        }
    });

    it('get: retrieves a worker queue by id', async () => {
        const id = `test-wq-${randomId()}`;
        await WorkerQueuesAdmin.create({ id, tags: [id] });
        try {
            const result = await WorkerQueuesAdmin.get({ id });
            expect(result.id).toBe(id);
        } finally {
            await WorkerQueuesAdmin.deleteWorkerQueues({ id }).catch(() => undefined);
        }
    });

    it('update: updates a worker queue', async () => {
        const id = `test-wq-${randomId()}`;
        await WorkerQueuesAdmin.create({ id, tags: [id] });
        try {
            const updatedTag = `${id}-updated`;
            const result = await WorkerQueuesAdmin.update({ id, tags: [id, updatedTag], description: 'updated queue' });
            expect(result.id).toBe(id);
            expect(result.tags ?? []).toContain(updatedTag);
        } finally {
            await WorkerQueuesAdmin.deleteWorkerQueues({ id }).catch(() => undefined);
        }
    });

    it('deleteWorkerQueues: deletes a worker queue', async () => {
        const id = `test-wq-${randomId()}`;
        await WorkerQueuesAdmin.create({ id, tags: [id] });

        await WorkerQueuesAdmin.deleteWorkerQueues({ id });

        const result = await WorkerQueuesAdmin.list();
        expect((result.workerQueues ?? []).some((q) => q.id === id)).toBe(false);
    });
});
