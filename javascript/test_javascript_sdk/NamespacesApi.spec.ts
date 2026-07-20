// testApis/NamespacesApi.spec.js
import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import { tenantId } from './_setup.js';
import * as Namespaces from '@kestra-io/kestra-sdk/namespaces';
import * as Secrets from '@kestra-io/kestra-sdk/secrets';

describe('NamespacesApi', () => {
    it('autocomplete_namespaces: List namespaces for autocomplete', async () => {
        const prefix = `test_autocomplete_namespaces_${randomId()}`;
        const ns = await Namespaces.createNamespace({
            id: prefix,
            deleted: false,
            tenant: tenantId,
        });

        const results = await Namespaces.autocompleteNamespaces({ q: prefix });

        expect(results.some(r => r === ns.id)).toBeTruthy();
    });

    it('create_namespace: Create a namespace', async () => {
        const nsId = `test_create_namespace_${randomId()}`;
        const created = await Namespaces.createNamespace({
            id: nsId,
            deleted: false,
            tenant: tenantId,
        });

        expect(created?.id).toBe(nsId);
        expect(created).toBeTruthy();
    });

    it('delete_namespace: Delete a namespace', async () => {
        const nsId = `test_delete_namespace_${randomId()}`;
        const created = await Namespaces.createNamespace({
            id: nsId,
            deleted: false,
            tenant: tenantId,
        });

        await Namespaces.deleteNamespace({ id: created.id });

        await expect(() =>
            (Namespaces.loadNamespace({ id: created.id }))
        ).rejects.toThrow();
    });

    it('get_inherited_secrets: List inherited secrets', async () => {
        const nsId = `test_get_inherited_secrets_${randomId()}`;
        const ns = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const inherited = await Namespaces.inheritedSecrets({ namespace: ns.id });

        expect(inherited).toBeTruthy(); // Map<String, List<String>>-like object
    });

    it('get_namespace: Get a namespace', async () => {
        const nsId = `test_get_namespace_${randomId()}`;
        const created = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const fetched =
            await Namespaces.loadNamespace?.({ id: created.id });

        expect(fetched.id).toBe(created.id);
    });

    it('inherited_plugin_defaults: List inherited plugin defaults', async () => {
        const nsId = `test_inherited_plugin_defaults_${randomId()}`;
        const ns = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const defaults = await Namespaces.inheritedPluginDefaults({ id: ns.id });
        expect(Array.isArray(defaults)).toBeTruthy();
    });

    it('inherited_variables: List inherited variables', async () => {
        const nsId = `test_inherited_variables_${randomId()}`;
        const ns = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const variables = await Namespaces.inheritedVariables({ id: ns.id });
        expect(variables && typeof variables === 'object').toBeTruthy();
    });

    it('list_namespace_secrets: Get secrets for a namespace (with filter)', async () => {
        const nsId = `test_list_namespace_secrets_${randomId()}`;
        const ns = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const key = `list_keys_key_${randomId()}`;
        const unwantedKey = `unwanted_${randomId()}`;

        // create a couple of secrets
        await Namespaces.putSecrets({ namespace: ns.id, key, value: 'list-value' });
        await Namespaces.putSecrets({ namespace: ns.id, key: unwantedKey, value: 'list-value' });

        const resp = await Secrets.listSecrets({
            filters: [
                { field: "namespace", operation: "EQUALS", value: ns.id as any },
                { field: "q", operation: "EQUALS", value: key as any },
            ], page: 1, size: 10
        });
        const results = resp?.results ?? [];

        expect(results.length).toBeGreaterThan(0);
        const gotKeys = results.map((m: any) => m.key);
        expect(gotKeys).toContain(key);
        expect(gotKeys).not.toContain(unwantedKey);
    });

    it('patch_secret: Patch secret metadata for a namespace', async () => {
        const nsId = `test_patch_secret_${randomId()}`;
        const ns = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const key = `test_patch_secret_key_${randomId()}`;
        await Namespaces.putSecrets({ namespace: ns.id, key, value: 'secretValue' });

        // Patch metadata (depends what your API supports; we at least pass the key)
        const metas =
            await Namespaces.patchSecret({ namespace: ns.id, key, tags: [] });

        expect(metas).toBeTruthy();
    });

    it('put_secrets: Update secrets for a namespace', async () => {
        const nsId = `test_put_secrets_${randomId()}`;
        const ns = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const metas = await Namespaces.putSecrets({
            namespace: ns.id,
            tenant: tenantId,
            key: `test_put_secrets_key_${randomId()}`,
            value: 'value-put',
        });

        expect(metas).toBeTruthy();
    });

    it('search_namespaces: Search for namespaces', async () => {
        const nsId = `test_search_namespaces_${randomId()}`;
        const ns = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const page = await Namespaces.searchNamespaces({
            page: 1,
            size: 10,
            existing: false,
            filters: [{
                field: "namespace",
                operation: "EQUALS",
                value: nsId
            }],
        });
        const results = page?.results ?? [];

        expect(results).toContainEqual(expect.objectContaining({ id: ns.id }));
    });

    it('update_namespace: Update a namespace', async () => {
        const nsId = `test_update_namespace_${randomId()}`;
        const created = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const updated = await Namespaces.updateNamespace({
            id: created.id,
            deleted: false,
            tenant: tenantId,
        });

        expect(updated.id).toBe(created.id);
    });

    // Optional extra from the Java class end: deleteSecret
    it('delete_secret: Delete a secret for a namespace', async () => {
        const nsId = `test_delete_secret_${randomId()}`;
        const ns = await Namespaces.createNamespace({ id: nsId, deleted: false });

        const key = `to_delete_key_${randomId()}`;
        await Namespaces.putSecrets({ namespace: ns.id, key, value: 'to-delete' });

        await Namespaces.deleteSecret({ namespace: ns.id, key });

        const list = await Secrets.listSecrets({ filters: [{ field: "namespace", operation: "EQUALS", value: ns.id as any }], page: 1, size: 10 });
        const results = list?.results ?? [];
        expect(results.some((m: any) => m.key === key)).toBeFalsy();
    });

    it('export_plugin_defaults: exports a namespace plugin defaults', async () => {
        const nsId = `test_export_plugin_defaults_${randomId()}`;
        const ns = await Namespaces.createNamespace({
            id: nsId,
            deleted: false,
            pluginDefaults: [{ type: 'io.kestra.plugin.core.log.Log', values: {} }],
        });

        const exported = await Namespaces.exportPluginDefaults({ id: ns.id });
        // The export echoes back the plugin default we configured on the namespace.
        expect(typeof exported).toBe('string');
        expect(exported).toContain('io.kestra.plugin.core.log.Log');
    });
});
