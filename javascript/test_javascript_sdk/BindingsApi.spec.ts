import { describe, it, expect } from 'vitest';
import { kestraClient, randomEmail, randomId } from './CommonTestSetup.js';
import type { IamBindingControllerApiCreateBindingRequest, BindingType } from '@kestra-io/kestra-sdk';

describe('BindingsApi', () => {
    it('searchBindings: returns bindings list', async () => {
        const result = await kestraClient.Bindings.searchBindings({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('createBinding: creates a user binding with a role', async () => {
        const email = randomEmail();
        const createdUser = await kestraClient.Users.createUser({ email });
        const userId = (createdUser as any).id;

        const role = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name: `test-role-${randomId()}`,
        });
        const roleId = (role as any).id;

        const req: IamBindingControllerApiCreateBindingRequest = {
            type: 'USER' as BindingType,
            externalId: userId,
            roleId,
        };

        const result = await kestraClient.Bindings.createBinding(req);
        expect(result).toBeDefined();
    });

    it('searchBindings: filters by type', async () => {
        const result = await kestraClient.Bindings.searchBindings({ page: 1, size: 10, type: 'USER' });
        expect(result).toBeDefined();
    });

    it('bulkCreateBinding: bulk creates bindings', async () => {
        const result = await kestraClient.Bindings.bulkCreateBinding({ body: [] });
        expect(result).toBeDefined();
    });

    it('binding: retrieves a binding by id', async () => {
        const email = randomEmail();
        const createdUser = await kestraClient.Users.createUser({ email });
        const userId = (createdUser as any).id;

        const role = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name: `test-role-binding-get-${randomId()}`,
        });
        const roleId = (role as any).id;

        const created = await kestraClient.Bindings.createBinding({
            type: 'USER' as any,
            externalId: userId,
            roleId,
        });
        const bindingId = (created as any).id;

        const result = await kestraClient.Bindings.binding({ id: bindingId });
        expect(result).toBeDefined();
    });

    it('deleteBinding: deletes a binding', async () => {
        const email = randomEmail();
        const createdUser = await kestraClient.Users.createUser({ email });
        const userId = (createdUser as any).id;

        const role = await kestraClient.Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name: `test-role-binding-del-${randomId()}`,
        });
        const roleId = (role as any).id;

        const created = await kestraClient.Bindings.createBinding({
            type: 'USER' as any,
            externalId: userId,
            roleId,
        });
        const bindingId = (created as any).id;

        await kestraClient.Bindings.deleteBinding({ id: bindingId });
    });
});
