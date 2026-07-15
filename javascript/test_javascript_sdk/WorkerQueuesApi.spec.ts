import { describe, it, expect } from 'vitest';
import { randomId } from './CommonTestSetup.js';
import * as WorkerQueues from '@kestra-io/kestra-sdk/worker-queues';
import * as WorkerQueuesAdmin from '@kestra-io/kestra-sdk/worker-queues-admin';

describe('WorkerQueuesApi', () => {
    it('subscribers: a freshly created worker queue has no subscribing groups', async () => {
        // Worker Queues are created via the admin API; drive `subscribers`
        // against a queue we just created rather than a guessed id.
        const id = `test-wq-${randomId()}`;
        const created = await WorkerQueuesAdmin.create({ id, tags: ['test'] });
        expect(created.id).toBe(id);

        // A worker group subscribes to a queue via its own configuration, so a
        // brand-new queue has exactly zero subscribing groups.
        const result = await WorkerQueues.subscribers({ id });
        expect(result.groups ?? []).toEqual([]);
    });
});
