import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';

describe('AuditLogsApi', () => {
    it('searchAuditLogs: returns a paged result', async () => {
        const result = await kestraClient.AuditLogs.searchAuditLogs({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect((result as any).results).toBeDefined();
    });

    it('searchAuditLogs: with pagination size 1', async () => {
        const result = await kestraClient.AuditLogs.searchAuditLogs({ page: 1, size: 1 });
        expect(result).toBeDefined();
        const resultSize = (result as any).results?.length ?? 0;
        expect(resultSize).toBeLessThanOrEqual(1);
    });

    it('exportAuditLogs: exports audit logs', async () => {
        const result = await kestraClient.AuditLogs.exportAuditLogs({});
        expect(result).toBeDefined();
    });

    it('exportAuditLogs: response matches declared type (object[])', async () => {
        const result = await kestraClient.AuditLogs.exportAuditLogs({});

        // The declared return type is object[] but the endpoint returns text/csv (a raw string).
        // This test fails until the OpenAPI annotation is corrected to type: string.
        expect(Array.isArray(result)).toBe(true);
    });

    it('searchAuditLogsForAllTenants: returns a paged result', async () => {
        const result = await kestraClient.AuditLogs.searchAuditLogsForAllTenants({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('exportAuditLogsForAllTenants: exports audit logs for all tenants', async () => {
        const result = await kestraClient.AuditLogs.exportAuditLogsForAllTenants({});
        expect(result).toBeDefined();
    });

    it('exportAuditLogsForAllTenants: response matches declared type (object[])', async () => {
        const result = await kestraClient.AuditLogs.exportAuditLogsForAllTenants({});

        // The declared return type is object[] but the endpoint returns text/csv (a raw string).
        // This test fails until the OpenAPI annotation is corrected to type: string.
        expect(Array.isArray(result)).toBe(true);
    });

    it('findAuditLog: finds audit logs by criteria', async () => {
        const result = await kestraClient.AuditLogs.findAuditLog({ resource: 'FLOW' });
        expect(result).toBeDefined();
    });

    it('listAuditLogFromResourceId: lists audit logs for a resource', async () => {
        // Get a real resource id from audit log search results
        const search = await kestraClient.AuditLogs.searchAuditLogs({ page: 1, size: 1 });
        const detailId = (search as any).results?.[0]?.auditLog?.detail?.id ?? 'unknown-resource';
        const result = await kestraClient.AuditLogs.listAuditLogFromResourceId({ detailId });
        expect(result).toBeDefined();
    });

    it('resourceDiffFromAuditLog: retrieves diff for an audit log', async () => {
        const search = await kestraClient.AuditLogs.searchAuditLogs({ page: 1, size: 1 });
        const id = (search as any).results?.[0]?.auditLog?.id;
        if (!id) return; // skip if no audit logs exist
        const result = await kestraClient.AuditLogs.resourceDiffFromAuditLog({ id });
        expect(result).toBeDefined();
    });

    it('globalResourceDiffFromAuditLog: retrieves global diff for an audit log', async () => {
        const search = await kestraClient.AuditLogs.searchAuditLogsForAllTenants({ page: 1, size: 1 });
        const id = (search as any).results?.[0]?.auditLog?.id;
        if (!id) return; // skip if no audit logs exist
        const result = await kestraClient.AuditLogs.globalResourceDiffFromAuditLog({ id });
        expect(result).toBeDefined();
    });
});
