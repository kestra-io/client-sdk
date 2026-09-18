import { describe, it, expect } from 'vitest';
import { randomEmail, randomId } from './_utils.js';
import * as Bindings from '@kestra-io/kestra-sdk/bindings';
import * as Roles from '@kestra-io/kestra-sdk/roles';
import * as Users from '@kestra-io/kestra-sdk/users';
import type { IamBindingControllerApiCreateBindingRequest, BindingType } from '@kestra-io/kestra-sdk';

describe('BindingsApi', () => {
    it('searchBindings: returns bindings list', async () => {
        const result = await Bindings.searchBindings({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('createBinding: creates a user binding with a role', async () => {
        const email = randomEmail();
        const createdUser = await Users.createUser({ email });
        const userId = (createdUser as any).id;

        const role = await Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name: `test-role-${randomId()}`,
        });
        const roleId = (role as any).id;

        const req: IamBindingControllerApiCreateBindingRequest = {
            type: 'USER' as BindingType,
            externalId: userId,
            roleId,
        };

        const result = await Bindings.createBinding(req);
        expect(result).toBeDefined();
    });

    it('searchBindings: filters by type', async () => {
        const result = await Bindings.searchBindings({ page: 1, size: 10, type: 'USER' });
        expect(result).toBeDefined();
    });

    it('bulkCreateBinding: bulk creates bindings', async () => {
        const result = await Bindings.bulkCreateBinding({ body: [] });
        expect(result).toBeDefined();
    });

    it('binding: retrieves a binding by id', async () => {
        const email = randomEmail();
        const createdUser = await Users.createUser({ email });
        const userId = (createdUser as any).id;

        const role = await Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name: `test-role-binding-get-${randomId()}`,
        });
        const roleId = (role as any).id;

        const created = await Bindings.createBinding({
            type: 'USER' as any,
            externalId: userId,
            roleId,
        });
        const bindingId = (created as any).id;

        const result = await Bindings.binding({ id: bindingId });
        expect(result).toBeDefined();
    });

    it('deleteBinding: deletes a binding', async () => {
        const email = randomEmail();
        const createdUser = await Users.createUser({ email });
        const userId = (createdUser as any).id;

        const role = await Roles.createRole({
            permissions: { FLOW: ['READ'] },
            name: `test-role-binding-del-${randomId()}`,
        });
        const roleId = (role as any).id;

        const created = await Bindings.createBinding({
            type: 'USER' as any,
            externalId: userId,
            roleId,
        });
        const bindingId = (created as any).id;

        await Bindings.deleteBinding({ id: bindingId });
    });
});
