import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';

function dashboardYaml(title: string, id?: string): string {
    const dashId = id ?? randomId();
    return `id: ${dashId}
title: ${title}
description: Test dashboard
timeWindow:
  default: P30D
  max: P365D
charts: []
`;
}

async function createDashboard(title?: string) {
    return kestraClient.Dashboards.createDashboard({
        body: dashboardYaml(title ?? `test-dash-${randomId()}`),
    });
}

describe('DashboardsApi', () => {
    it('createDashboard: creates a dashboard from YAML', async () => {
        const title = `test-dash-${randomId()}`;
        const result = await createDashboard(title);
        expect(result).toBeDefined();
        expect((result as any).id).toBeDefined();
        expect((result as any).title).toBe(title);
    });

    it('dashboard: retrieves a dashboard by id', async () => {
        const title = `get-dash-${randomId()}`;
        const created = await createDashboard(title);
        const id = (created as any).id;

        const result = await kestraClient.Dashboards.dashboard({ id });
        expect(result).toBeDefined();
        expect((result as any).id).toBe(id);
    });

    it('dashboard: returns error for non-existent id', async () => {
        await expect(kestraClient.Dashboards.dashboard({ id: 'nonexistent-dashboard-id' })).rejects.toThrow();
    });

    it('updateDashboard: updates a dashboard title', async () => {
        const created = await createDashboard(`before-${randomId()}`);
        const id = (created as any).id;
        const newTitle = `after-${randomId()}`;

        const result = await kestraClient.Dashboards.updateDashboard({
            id,
            body: dashboardYaml(newTitle, id),
        });
        expect((result as any).title).toBe(newTitle);
    });

    it('deleteDashboard: deletes a dashboard', async () => {
        const created = await createDashboard(`to-delete-${randomId()}`);
        const id = (created as any).id;

        await kestraClient.Dashboards.deleteDashboard({ id });
        await expect(kestraClient.Dashboards.dashboard({ id })).rejects.toThrow();
    });

    it('searchDashboards: returns a paged result', async () => {
        await createDashboard(`searchable-${randomId()}`);
        const result = await kestraClient.Dashboards.searchDashboards({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect((result as any).results).toBeDefined();
    });

    it('searchDashboards: with pagination', async () => {
        const result = await kestraClient.Dashboards.searchDashboards({ page: 1, size: 2 });
        expect(result).toBeDefined();
        const resultSize = (result as any).results?.length ?? 0;
        expect(resultSize).toBeLessThanOrEqual(2);
    });

    it('validateDashboard: validates a dashboard YAML', async () => {
        const result = await kestraClient.Dashboards.validateDashboard({
            body: dashboardYaml(`validate-${randomId()}`),
        });
        expect(result).toBeDefined();
    });
});
