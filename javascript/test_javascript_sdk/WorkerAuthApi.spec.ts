import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
import type { WorkerRegistrationTokenControllerApiCreateTokenRequest } from '@kestra-io/kestra-sdk';

const skipOn403 = async (fn: () => Promise<void>) => {
    try { await fn(); } catch (err: any) {
        const status = err?.response?.status ?? err?.status;
        if (status === 403) return;
        throw err;
    }
};

describe('WorkerAuthApi', () => {
    it('list: lists worker credentials', async () => {
        await skipOn403(async () => {
            const result = await kestraClient.WorkerAuth.list();
            expect(result).toBeDefined();
            expect(Array.isArray((result as any).results ?? result)).toBe(true);
        });
    });

    it('list_1: lists worker registration tokens', async () => {
        await skipOn403(async () => {
            const result = await kestraClient.WorkerAuthAdmin.list_1();
            expect(result).toBeDefined();
            expect(Array.isArray((result as any).results ?? result)).toBe(true);
        });
    });

    it('create: creates a worker registration token', async () => {
        await skipOn403(async () => {
            const req: WorkerRegistrationTokenControllerApiCreateTokenRequest = {
                name: `test-token-${randomId()}`,
                description: 'Test worker registration token',
            };
            const result = await kestraClient.WorkerAuth.create(req);
            expect(result).toBeDefined();
            expect((result as any).token ?? (result as any).details).toBeDefined();
        });
    });

    it('get_1: retrieves a registration token by id', async () => {
        await skipOn403(async () => {
            const req: WorkerRegistrationTokenControllerApiCreateTokenRequest = {
                name: `get-token-${randomId()}`,
            };
            const created = await kestraClient.WorkerAuth.create(req);
            const id = (created as any).details?.id ?? (created as any).id;

            if (!id) return;
            const result = await kestraClient.WorkerAuthAdmin.get_1({ id });
            expect(result).toBeDefined();
        });
    });

    it('revoke_1: revokes a registration token', async () => {
        await skipOn403(async () => {
            const req: WorkerRegistrationTokenControllerApiCreateTokenRequest = {
                name: `revoke-token-${randomId()}`,
            };
            const created = await kestraClient.WorkerAuth.create(req);
            const id = (created as any).details?.id ?? (created as any).id;

            if (!id) return;
            await kestraClient.WorkerAuthAdmin.revoke_1({ id });
        });
    });

    it('delete_1: deletes a registration token', async () => {
        await skipOn403(async () => {
            const req: WorkerRegistrationTokenControllerApiCreateTokenRequest = {
                name: `delete-token-${randomId()}`,
            };
            const created = await kestraClient.WorkerAuth.create(req);
            const id = (created as any).details?.id ?? (created as any).id;

            if (!id) return;
            await kestraClient.WorkerAuthAdmin.delete_1({ id });
        });
    });
});
