import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';

describe('PluginsApi', () => {
    it('listPlugins: lists all installed plugins', async () => {
        const result = await kestraClient.Plugins.listPlugins();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('pluginBySubgroups: lists plugins organized by subgroups', async () => {
        const result = await kestraClient.Plugins.pluginBySubgroups();
        expect(result).toBeDefined();
    });

    it('allInputTypes: lists all input types', async () => {
        const result = await kestraClient.Plugins.allInputTypes();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listTriggerPlugins: lists trigger plugins', async () => {
        const result = await kestraClient.Plugins.listTriggerPlugins();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('pluginIcons: returns plugin icons', async () => {
        const result = await kestraClient.Plugins.pluginIcons();
        expect(result).toBeDefined();
    });

    it('pluginGroupIcons: returns plugin group icons', async () => {
        const result = await kestraClient.Plugins.pluginGroupIcons();
        expect(result).toBeDefined();
    });

    it('listVersionedPlugin: lists versioned plugins', async () => {
        const result = await kestraClient.Plugins.listVersionedPlugin();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('listAvailableVersionedPlugins: lists available versioned plugins', async () => {
        const result = await kestraClient.Plugins.listAvailableVersionedPlugins();
        expect(result).toBeDefined();
    });

    it('schemaFromInputType: gets JSON schema for STRING input type', async () => {
        const result = await kestraClient.Plugins.schemaFromInputType({ type: 'STRING' });
        expect(result).toBeDefined();
    });

    it('pluginDocumentation: gets documentation for a plugin', async () => {
        const result = await kestraClient.Plugins.pluginDocumentation({ cls: 'io.kestra.plugin.core.log.Log' });
        expect(result).toBeDefined();
    });
});
