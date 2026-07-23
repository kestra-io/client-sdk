import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as WorkerQueues from '@kestra-io/kestra-sdk/worker-queues';
import * as WorkerQueuesAdmin from '@kestra-io/kestra-sdk/worker-queues-admin';

describe('WorkerQueuesApi', () => {
    it('subscribers: a freshly created worker queue has no subscribing groups', async () => {
        // Worker Queues are created via the admin API; drive `subscribers`
        // against a queue we just created rather than a guessed id. Tags are
        // the canonical key, so they must be unique per run, not just the id.
        const id = `test-wq-${randomId()}`;
        const tagId = `test-tag-wq-${randomId()}`;
        const created = await WorkerQueuesAdmin.create({ id, tags: [tagId] });
        expect(created.id).toBe(id);

        try {
            // A worker group subscribes to a queue via its own configuration, so a
            // brand-new queue has exactly zero subscribing groups.
            const result = await WorkerQueues.subscribers({ id });
            expect(result.groups ?? []).toEqual([]);
        } finally {
            await WorkerQueuesAdmin.deleteWorkerQueues({ id });
        }
    });
});
