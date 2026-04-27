// testApis/NamespacesApi.spec.js
import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup.js';

describe('NamespacesApi', () => {
    it('autocomplete_namespaces: List namespaces for autocomplete', async () => {
        const prefix = `test_autocomplete_namespaces_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({
            id: prefix,
            deleted: false,
            tenant: MAIN_TENANT,
        });

        const results = await kestraClient().Namespaces.autocompleteNamespaces({ q: prefix, tenant: MAIN_TENANT });

        expect(results.some(r => r === ns.id)).toBeTruthy();
    });

    it('create_namespace: Create a namespace', async () => {
        const nsId = `test_create_namespace_${randomId()}`;
        const created = await kestraClient().Namespaces.createNamespace({
            id: nsId,
            deleted: false,
            tenant: MAIN_TENANT,
        });

        expect(created?.id).toBe(nsId);
        expect(created).toBeTruthy();
    });

    it('delete_namespace: Delete a namespace', async () => {
        const nsId = `test_delete_namespace_${randomId()}`;
        const created = await kestraClient().Namespaces.createNamespace({
            id: nsId,
            deleted: false,
            tenant: MAIN_TENANT,
        });

        await kestraClient().Namespaces.deleteNamespace({ id: created.id, tenant: MAIN_TENANT });

        await expect(() =>
            (kestraClient().Namespaces.namespace_?.({ id: created.id, tenant: MAIN_TENANT }))
        ).rejects.toThrow();
    });

    it('get_inherited_secrets: List inherited secrets', async () => {
        const nsId = `test_get_inherited_secrets_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const inherited = await kestraClient().Namespaces.inheritedSecrets({ namespace: ns.id, tenant: MAIN_TENANT });

        expect(inherited).toBeTruthy(); // Map<String, List<String>>-like object
    });

    it('get_namespace: Get a namespace', async () => {
        const nsId = `test_get_namespace_${randomId()}`;
        const created = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const fetched =
            await kestraClient().Namespaces.namespace_?.({ id: created.id, tenant: MAIN_TENANT });

        expect(fetched.id).toBe(created.id);
    });

    it('inherited_plugin_defaults: List inherited plugin defaults', async () => {
        const nsId = `test_inherited_plugin_defaults_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const defaults = await kestraClient().Namespaces.inheritedPluginDefaults({ id: ns.id, tenant: MAIN_TENANT });
        expect(Array.isArray(defaults)).toBeTruthy();
    });

    it('inherited_variables: List inherited variables', async () => {
        const nsId = `test_inherited_variables_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const variables = await kestraClient().Namespaces.inheritedVariables({ id: ns.id, tenant: MAIN_TENANT });
        expect(variables && typeof variables === 'object').toBeTruthy();
    });

    it('list_namespace_secrets: Get secrets for a namespace (with filter)', async () => {
        const nsId = `test_list_namespace_secrets_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const key = `list_keys_key_${randomId()}`;
        const unwantedKey = `unwanted_${randomId()}`;

        // create a couple of secrets
        await kestraClient().Namespaces.putSecrets({ namespace: ns.id, tenant: MAIN_TENANT, key, value: 'list-value' });
        await kestraClient().Namespaces.putSecrets({ namespace: ns.id, tenant: MAIN_TENANT, key: unwantedKey, value: 'list-value' });

        // TODO: listNamespaceSecrets does not exist in the SDK; using listSecrets as closest alternative
        // @ts-expect-error
        const resp = await kestraClient().Namespaces.listNamespaceSecrets(ns.id, 1, 10, [{ field: 'QUERY', operation: 'EQUALS', value: key }], MAIN_TENANT, null);
        const results = resp?.results ?? [];

        expect(results.length).toBeGreaterThan(0);
        const gotKeys = results.map(m => m.key);
        expect(gotKeys).toContain(key);
        expect(gotKeys).not.toContain(unwantedKey);
    });

    it('patch_secret: Patch secret metadata for a namespace', async () => {
        const nsId = `test_patch_secret_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const key = `test_patch_secret_key_${randomId()}`;
        await kestraClient().Namespaces.putSecrets({ namespace: ns.id, tenant: MAIN_TENANT, key, value: 'secretValue' });

        // Patch metadata (depends what your API supports; we at least pass the key)
        const metas =
            await kestraClient().Namespaces.patchSecret({ namespace: ns.id, key, tags: [], tenant: MAIN_TENANT });

        expect(metas).toBeTruthy();
    });

    it('put_secrets: Update secrets for a namespace', async () => {
        const nsId = `test_put_secrets_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const metas = await kestraClient().Namespaces.putSecrets({
            namespace: ns.id,
            tenant: MAIN_TENANT,
            key: `test_put_secrets_key_${randomId()}`,
            value: 'value-put',
        });

        expect(metas).toBeTruthy();
    });

    it('search_namespaces: Search for namespaces', async () => {
        const nsId = `test_search_namespaces_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const page = await kestraClient().Namespaces.searchNamespaces({ page: 1, size: 10, existing: false, tenant: MAIN_TENANT, q: nsId });
        const results = page?.results ?? [];

        expect(results.some(r => r.id === ns.id)).toBeTruthy();
    });

    it('update_namespace: Update a namespace', async () => {
        const nsId = `test_update_namespace_${randomId()}`;
        const created = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const updated = await kestraClient().Namespaces.updateNamespace({
            id: created.id,
            deleted: false,
            tenant: MAIN_TENANT,
        });

        expect(updated.id).toBe(created.id);
    });

    // Optional extra from the Java class end: deleteSecret
    it('delete_secret: Delete a secret for a namespace', async () => {
        const nsId = `test_delete_secret_${randomId()}`;
        const ns = await kestraClient().Namespaces.createNamespace({ id: nsId, deleted: false, tenant: MAIN_TENANT });

        const key = `to_delete_key_${randomId()}`;
        await kestraClient().Namespaces.putSecrets({ namespace: ns.id, tenant: MAIN_TENANT, key, value: 'to-delete' });

        await kestraClient().Namespaces.deleteSecret({ namespace: ns.id, key, tenant: MAIN_TENANT });

        // TODO: listNamespaceSecrets does not exist in the SDK
        // @ts-expect-error
        const list = await kestraClient().Namespaces.listNamespaceSecrets(ns.id, 1, 10, [], MAIN_TENANT, null);
        const results = list?.results ?? [];
        expect(results.some(m => m.key === key)).toBeFalsy();
    });
});
