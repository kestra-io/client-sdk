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

    it('searchAuditLogsForAllTenants: returns a paged result', async () => {
        const result = await kestraClient.AuditLogs.searchAuditLogsForAllTenants({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('exportAuditLogsForAllTenants: exports audit logs for all tenants', async () => {
        const result = await kestraClient.AuditLogs.exportAuditLogsForAllTenants({});
        expect(result).toBeDefined();
    });
});
