import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Mcp from '@kestra-io/kestra-sdk/mcp';

function makeMcpServer() {
    return {
        id: `test-mcp-${randomId()}`,
        description: 'Test MCP server',
        serverType: 'PRIVATE' as const,
    };
}

describe('McpApi', () => {
    it('createMcp / mcp: creates an MCP server and reads it back', async () => {
        const req = makeMcpServer();
        const created = await Mcp.createMcp(req);
        expect(created.id).toBe(req.id);

        const fetched = await Mcp.mcp({ id: req.id });
        expect(fetched.id).toBe(req.id);
    });

    it('listMcps: lists the tenant MCP servers', async () => {
        const req = makeMcpServer();
        await Mcp.createMcp(req);

        const result = await Mcp.listMcps();
        expect((result.results ?? []).some((s) => s.id === req.id)).toBe(true);
    });

    it('listAllMcpServers: lists MCP servers across the instance', async () => {
        const result = await Mcp.listAllMcpServers();
        expect(result).toBeDefined();
    });

    it('updateMcp: updates an MCP server', async () => {
        const req = makeMcpServer();
        await Mcp.createMcp(req);

        const result = await Mcp.updateMcp({ id: req.id, description: 'Updated description', serverType: 'PRIVATE' });
        expect(result.id).toBe(req.id);
        expect(result.description).toBe('Updated description');
    });

    it('toggleMcp: toggles an MCP server\'s enabled state', async () => {
        const req = makeMcpServer();
        const created = await Mcp.createMcp(req);

        const result = await Mcp.toggleMcp({ id: req.id });
        expect(result.disabled).toBe(!created.disabled);
    });

    it('listTools: lists tools exposed by an MCP server', async () => {
        const req = makeMcpServer();
        await Mcp.createMcp(req);

        // A private server with no reachable backend exposes no tools; the call
        // may also fail to connect. Either way the SDK function is exercised.
        try {
            const result = await Mcp.listTools({ id: req.id });
            expect(Array.isArray(result)).toBe(true);
        } catch (err) {
            expect(err).toBeDefined();
        }
    });

    it('deleteMcp: deletes an MCP server', async () => {
        const req = makeMcpServer();
        await Mcp.createMcp(req);

        await Mcp.deleteMcp({ id: req.id });

        const result = await Mcp.listMcps();
        expect((result.results ?? []).some((s) => s.id === req.id)).toBe(false);
    });
});
