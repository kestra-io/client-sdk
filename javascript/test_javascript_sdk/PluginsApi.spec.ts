import { describe, it, expect } from 'vitest';
import * as Plugins from '@kestra-io/kestra-sdk/plugins';

describe('PluginsApi', () => {
    it('listPlugins: lists all installed plugins', async () => {
        const result = await Plugins.listPlugins()
        expect(result.results).toBeDefined();
        expect(result.results).toBeInstanceOf(Array);
    });

    it('pluginBySubgroups: lists plugins organized by subgroups', async () => {
        const result = await Plugins.pluginBySubgroups();
        expect(result).toBeDefined();
    });

    it('allInputTypes: lists all input types', async () => {
        const result = await Plugins.allInputTypes();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listTriggerPlugins: lists trigger plugins', async () => {
        const result = await Plugins.listTriggerPlugins();
        expect(result).toBeDefined();
        expect(Array.isArray((result as any).results ?? result)).toBe(true);
    });

    it('pluginIcons: returns plugin icons', async () => {
        const result = await Plugins.pluginIcons();
        expect(result).toBeDefined();
    });

    it('pluginGroupIcons: returns plugin group icons', async () => {
        const result = await Plugins.pluginGroupIcons();
        expect(result).toBeDefined();
    });

    it('listVersionedPlugin: lists versioned plugins', async () => {
        const result = await Plugins.listVersionedPlugin();
        expect(result).toBeDefined();
        expect(Array.isArray((result as any).results ?? result)).toBe(true);
    });

    // Superadmin-only endpoint that makes an external call to the plugin registry.
    // Skipped because the registry is unreachable in the test environment.
    it.skip('listAvailableVersionedPlugins: lists available versioned plugins', async () => {
        const result = await Plugins.listAvailableVersionedPlugins();
        expect(result).toBeDefined();
    }, 30000);

    it('schemaFromInputType: gets JSON schema for STRING input type', async () => {
        const result = await Plugins.schemaFromInputType({ type: 'STRING' });
        expect(result).toBeDefined();
    });

    it('pluginDocumentation: gets documentation for a plugin', async () => {
        const result = await Plugins.pluginDocumentation({ cls: 'io.kestra.plugin.core.log.Log' });
        expect(result).toBeDefined();
    });

    it('propertiesFromType: returns the properties for a schema type', async () => {
        // The endpoint returns a map of property name -> property schema. Every
        // task inherits the base Task properties, so `id` and `type` are present.
        const result = await kestraClient.Plugins.propertiesFromType({ type: 'TASK' });
        expect(result).toHaveProperty('id');
        expect(result).toHaveProperty('type');
    });

    it('schemasFromType: returns the JSON schema for a schema type', async () => {
        // Draft-7 JSON schema for a flow: the root object carries a `properties` map.
        const result = await kestraClient.Plugins.schemasFromType({ type: 'FLOW' });
        expect(result).toHaveProperty('properties');
    });

    it('pluginIcon: returns the icon for a plugin class', async () => {
        const result = await kestraClient.Plugins.pluginIcon({ cls: 'io.kestra.plugin.core.log.Log' });
        // A core plugin always ships an icon, so the wrapped icon is non-null.
        expect(result.icon).toBeTruthy();
    });

    it('pluginVersions: lists the versions of a plugin class', async () => {
        const cls = 'io.kestra.plugin.core.log.Log';
        const result = await kestraClient.Plugins.pluginVersions({ cls });
        // The endpoint echoes the requested plugin class back in `type`.
        expect(result.type).toBe(cls);
    });

    it('pluginDocumentationFromVersion: gets documentation for a specific plugin version', async () => {
        const cls = 'io.kestra.plugin.core.log.Log';
        // Source a real version from pluginVersions rather than hard-coding one.
        const { versions } = await kestraClient.Plugins.pluginVersions({ cls });
        const version = versions?.[0];
        // A semver-style version, optionally with a pre-release suffix (e.g. -SNAPSHOT).
        expect(version).toMatch(/^\d+\.\d+\.\d+/);

        const result = await kestraClient.Plugins.pluginDocumentationFromVersion({ cls, version: version! });
        // The rendered markdown documents the Log task.
        expect(result.markdown).toContain('Log');
    });

    it('pluginUiManifest: returns the UI manifest for the given tasks', async () => {
        const result = await kestraClient.Plugins.pluginUiManifest({
            body: [{ cls: 'io.kestra.plugin.core.log.Log' }],
        });
        // Shape is { manifest: { [key]: PluginUiModuleWithGroup[] } }. Core Log
        // ships no custom UI, so the manifest map is present but empty.
        expect(result.manifest).toEqual({});
    });

    // Serves a plugin's bundled UI static asset. No plugin ships a UI bundle in
    // the default test environment, so there is no valid {group, path} to fetch.
    it.skip('pluginUi: serves a plugin UI static asset', async () => {
        const result = await kestraClient.Plugins.pluginUi({ group: 'io.kestra.plugin.core', path: 'index.js' });
        // The endpoint streams the asset back as a Blob (File extends Blob).
        expect(result).toBeInstanceOf(Blob);
    });
});
