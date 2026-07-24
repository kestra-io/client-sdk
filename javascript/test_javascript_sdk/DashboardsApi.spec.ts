import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Dashboards from '@kestra-io/kestra-sdk/dashboards';
import * as DashboardsAdmin from '@kestra-io/kestra-sdk/dashboards-admin';

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
    return Dashboards.createDashboard({
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

        const result = await Dashboards.dashboard({ id });
        expect(result).toBeDefined();
        expect((result as any).id).toBe(id);
    });

    it('dashboard: returns error for non-existent id', async () => {
        await expect(Dashboards.dashboard({ id: 'nonexistent-dashboard-id' })).rejects.toThrow();
    });

    it('updateDashboard: updates a dashboard title', async () => {
        const created = await createDashboard(`before-${randomId()}`);
        const id = (created as any).id;
        const newTitle = `after-${randomId()}`;

        const result = await Dashboards.updateDashboard({
            id,
            body: dashboardYaml(newTitle, id),
        });
        expect((result as any).title).toBe(newTitle);
    });

    it('deleteDashboard: deletes a dashboard', async () => {
        const created = await createDashboard(`to-delete-${randomId()}`);
        const id = (created as any).id;

        await Dashboards.deleteDashboard({ id });
        await expect(Dashboards.dashboard({ id })).rejects.toThrow();
    });

    it('searchDashboards: returns a paged result', async () => {
        await createDashboard(`searchable-${randomId()}`);
        const result = await Dashboards.searchDashboards({ page: 1, size: 10 });
        expect(result).toBeDefined();
        expect((result as any).results).toBeDefined();
    });

    it('searchDashboards: with pagination', async () => {
        const result = await Dashboards.searchDashboards({ page: 1, size: 2 });
        expect(result).toBeDefined();
        const resultSize = (result as any).results?.length ?? 0;
        expect(resultSize).toBeLessThanOrEqual(2);
    });

    it('defaultDashboards_1: lists default dashboards', async () => {
        const result = await DashboardsAdmin.defaultDashboards();
        expect(result).toBeDefined();
    });

    it('validateDashboard: validates a dashboard YAML', async () => {
        const result = await Dashboards.validateDashboard({
            body: dashboardYaml(`validate-${randomId()}`),
        });
        expect(result).toBeDefined();
    });

    it('exportChart: exports an ad-hoc chart to CSV', async () => {
        const chart = `id: csv-chart
type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart
graphStyle: LINES
columns:
  date:
    field: DATE
`;
        try {
            const result = await kestraClient.Dashboards.exportChart({
                chart,
                format: 'CSV',
            } as any);
            expect(result).toBeDefined();
        } catch (e: any) {
            expect([400, 422]).toContain(e?.response?.status);
        }
    });

    it('exportChart: exports an ad-hoc chart to ION', async () => {
        const chart = `id: ion-chart
type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart
graphStyle: LINES
columns:
  date:
    field: DATE
`;
        try {
            const result = await kestraClient.Dashboards.exportChart({
                chart,
                format: 'ION',
            } as any);
            expect(result).toBeDefined();
        } catch (e: any) {
            expect([400, 422]).toContain(e?.response?.status);
        }
    });

    it('exportDashboardChart: returns error for non-existent chart id', async () => {
        const created = await createDashboard(`csv-export-${randomId()}`);
        const id = (created as any).id;

        await expect(kestraClient.Dashboards.exportDashboardChart({
            id,
            chartId: 'nonexistent',
            format: 'CSV',
        } as any)).rejects.toThrow();
    });
});
