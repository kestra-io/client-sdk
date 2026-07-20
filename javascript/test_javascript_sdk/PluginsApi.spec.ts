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
});
