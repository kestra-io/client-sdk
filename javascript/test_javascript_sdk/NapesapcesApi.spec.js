// @ts-check
// testApis/NamespacesApi.spec.js
import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup';

describe('NamespacesApi', () => {
    it('autocomplete_namespaces: List namespaces for autocomplete', async () => {
        const prefix = `test_autocomplete_namespaces_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, {
            id: prefix,
            deleted: false,
        });

        const results = await kestraClient().namespacesApi.autocompleteNamespaces(MAIN_TENANT, { q: prefix });

        expect(results.some(r => r === ns.id)).toBeTruthy();
    });

    it('create_namespace: Create a namespace', async () => {
        const nsId = `test_create_namespace_${randomId()}`;
        const created = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, {
            id: nsId,
            deleted: false,
        });

        expect(created?.id).toBe(nsId);
        expect(created).toBeTruthy();
    });

    it('delete_namespace: Delete a namespace', async () => {
        const nsId = `test_delete_namespace_${randomId()}`;
        const created = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, {
            id: nsId,
            deleted: false,
        });

        await kestraClient().namespacesApi.deleteNamespace(created.id, MAIN_TENANT);

        await expect(() =>
            (kestraClient().namespacesApi.namespace?.(created.id, MAIN_TENANT))
        ).toThrow();
    });

    it('get_inherited_secrets: List inherited secrets', async () => {
        const nsId = `test_get_inherited_secrets_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const inherited = await kestraClient().namespacesApi.inheritedSecrets(ns.id, MAIN_TENANT);

        expect(inherited).toBeTruthy(); // Map<String, List<String>>-like object
    });

    it('get_namespace: Get a namespace', async () => {
        const nsId = `test_get_namespace_${randomId()}`;
        const created = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const fetched =
            await kestraClient().namespacesApi.namespace?.(created.id, MAIN_TENANT);

        expect(fetched.id).toBe(created.id);
    });

    it('inherited_plugin_defaults: List inherited plugin defaults', async () => {
        const nsId = `test_inherited_plugin_defaults_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const defaults = await kestraClient().namespacesApi.inheritedPluginDefaults(ns.id, MAIN_TENANT);
        expect(Array.isArray(defaults)).toBeTruthy();
    });

    it('inherited_variables: List inherited variables', async () => {
        const nsId = `test_inherited_variables_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const variables = await kestraClient().namespacesApi.inheritedVariables(ns.id, MAIN_TENANT);
        expect(variables && typeof variables === 'object').toBeTruthy();
    });

    it('list_namespace_secrets: Get secrets for a namespace (with filter)', async () => {
        const nsId = `test_list_namespace_secrets_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const key = `list_keys_key_${randomId()}`;
        const unwantedKey = `unwanted_${randomId()}`;

        // create a couple of secrets
        await kestraClient().namespacesApi.putSecrets(ns.id, MAIN_TENANT, { key, value: 'list-value' });
        await kestraClient().namespacesApi.putSecrets(ns.id, MAIN_TENANT, { key: unwantedKey, value: 'list-value' });

        // filter by query==key
        const filters = [
            { field: 'QUERY', operation: 'EQUALS', value: key },
        ];

        // signature: listNamespaceSecrets(namespace, page, size, filters, tenant, sort)
        const resp = await kestraClient().namespacesApi.listNamespaceSecrets(ns.id, 1, 10, filters, MAIN_TENANT, null);
        const results = resp?.results ?? [];

        expect(results.length).toBeGreaterThan(0);
        const gotKeys = results.map(m => m.key);
        expect(gotKeys).toContain(key);
        expect(gotKeys).not.toContain(unwantedKey);
    });

    it('patch_secret: Patch secret metadata for a namespace', async () => {
        const nsId = `test_patch_secret_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const key = `test_patch_secret_key_${randomId()}`;
        await kestraClient().namespacesApi.putSecrets(ns.id, MAIN_TENANT, { key, value: 'secretValue' });

        // Patch metadata (depends what your API supports; we at least pass the key)
        const meta = { key: key, tags: []};
        const metas =
            await kestraClient().namespacesApi.patchSecret(ns.id, key, MAIN_TENANT, meta);

        expect(metas).toBeTruthy();
    });

    it('put_secrets: Update secrets for a namespace', async () => {
        const nsId = `test_put_secrets_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const metas = await kestraClient().namespacesApi.putSecrets(
            ns.id,
            MAIN_TENANT,
            { key: `test_put_secrets_key_${randomId()}`, value: 'value-put' }
        );

        expect(metas).toBeTruthy();
    });

    it('search_namespaces: Search for namespaces', async () => {
        const nsId = `test_search_namespaces_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        // Java sig was (page, size, existing, tenant, q, sort)
        const page = await kestraClient().namespacesApi.searchNamespaces(1, 10, false, MAIN_TENANT, {q: nsId});
        const results = page?.results ?? [];

        expect(results.some(r => r.id === ns.id)).toBeTruthy();
    });

    it('update_namespace: Update a namespace', async () => {
        const nsId = `test_update_namespace_${randomId()}`;
        const created = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const updated = await kestraClient().namespacesApi.updateNamespace(
            created.id,
            MAIN_TENANT,
            { id: created.id, deleted: false }
        );

        expect(updated.id).toBe(created.id);
    });

    // Optional extra from the Java class end: deleteSecret
    it('delete_secret: Delete a secret for a namespace', async () => {
        const nsId = `test_delete_secret_${randomId()}`;
        const ns = await kestraClient().namespacesApi.createNamespace(MAIN_TENANT, { id: nsId, deleted: false });

        const key = `to_delete_key_${randomId()}`;
        await kestraClient().namespacesApi.putSecrets(ns.id, MAIN_TENANT, { key, value: 'to-delete' });

        await kestraClient().namespacesApi.deleteSecret(ns.id, key, MAIN_TENANT);

        const list = await kestraClient().namespacesApi.listNamespaceSecrets(ns.id, 1, 10, [], MAIN_TENANT, null);
        const results = list?.results ?? [];
        expect(results.some(m => m.key === key)).toBeFalsy();
    });
});
