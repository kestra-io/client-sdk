import { describe, it, expect } from 'vitest';
import { randomId, getSimpleFlowAndId, waitForExecutionSuccess } from './_utils.js';
import * as Dashboards from '@kestra-io/kestra-sdk/dashboards';
import * as DashboardsAdmin from '@kestra-io/kestra-sdk/dashboards-admin';
import * as Executions from '@kestra-io/kestra-sdk/executions';
import * as Flows from '@kestra-io/kestra-sdk/flows';

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

// Dashboard with a single OSS-native Table chart over the Executions data
// type, scoped to namespace so its export content is deterministic even on
// a shared test instance with unrelated executions.
function executionsTableDashboardYaml(dashboardId: string, title: string, chartId: string, namespace: string): string {
    return `id: ${dashboardId}
title: ${title}
description: Test dashboard
timeWindow:
  default: P30D
  max: P365D
charts:
  - id: ${chartId}
    type: io.kestra.plugin.core.dashboard.chart.Table
    chartOptions:
      displayName: Executions
    data:
      type: io.kestra.plugin.core.dashboard.data.Executions
      where:
        - field: NAMESPACE
          type: EQUAL_TO
          value: ${namespace}
      columns:
        id:
          field: ID
          displayName: Execution ID
        namespace:
          field: NAMESPACE
          displayName: Namespace
        flow:
          field: FLOW_ID
          displayName: Flow
        state:
          field: STATE
          displayName: State
`;
}

// executionsTableDashboardYaml's chart block on its own, usable directly in
// an ad-hoc PreviewRequest (no dashboard wrapper).
function executionsTableChartYaml(chartId: string, namespace: string): string {
    return `id: ${chartId}
type: io.kestra.plugin.core.dashboard.chart.Table
chartOptions:
  displayName: Executions
data:
  type: io.kestra.plugin.core.dashboard.data.Executions
  where:
    - field: NAMESPACE
      type: EQUAL_TO
      value: ${namespace}
  columns:
    id:
      field: ID
      displayName: Execution ID
    namespace:
      field: NAMESPACE
      displayName: Namespace
    flow:
      field: FLOW_ID
      displayName: Flow
    state:
      field: STATE
      displayName: State
`;
}

async function createFlowAndWaitForExecution(): Promise<{ namespace: string; flowId: string; executionId: string }> {
    const { flowId, flowNamespace, flowBody } = getSimpleFlowAndId();
    await Flows.createFlow({ body: flowBody });

    const exec = await Executions.createExecution({ namespace: flowNamespace, id: flowId, wait: true });
    const executionId = (exec as any).id;

    await waitForExecutionSuccess(executionId);
    return { namespace: flowNamespace, flowId, executionId };
}

// The CSV header uses the executionsTable*Yaml column keys (not their
// displayName), and the SQL layer does not guarantee they come back in
// declaration order, so tests compare against a sorted copy of the header.
const EXPECTED_EXPORT_COLUMNS = ['flow', 'id', 'namespace', 'state'];

function assertCsvHeader(csv: string) {
    const header = csv.split('\n', 1)[0].replace(/\r$/, '');
    expect(header.split(',').sort()).toEqual(EXPECTED_EXPORT_COLUMNS);
}

// The Node/axios client used in this test suite doesn't support
// `responseType: 'blob'` outside a browser, so both CSV and ION responses
// surface here as plain strings decoded as UTF-8. Binary Ion's opcode bytes
// aren't valid UTF-8, so that decode leaves U+FFFD replacement characters in
// the result — a reliable signal the payload is binary, not CSV text.
function assertIonLooksBinary(ion: string) {
    expect(ion).toContain(String.fromCharCode(0xfffd));
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
        const { namespace, flowId, executionId } = await createFlowAndWaitForExecution();

        const csv = await Dashboards.exportChart({
            chart: executionsTableChartYaml('adhoc-chart', namespace),
            format: 'CSV',
        });

        expect(csv).toContain(namespace);
        expect(csv).toContain(flowId);
        expect(csv).toContain(executionId);
        assertCsvHeader(csv);
    });

    it('exportChart: exports an ad-hoc chart to ION', async () => {
        const { namespace, flowId, executionId } = await createFlowAndWaitForExecution();

        const ion = await Dashboards.exportChart({
            chart: executionsTableChartYaml('adhoc-chart', namespace),
            format: 'ION',
        });

        expect(ion).toContain(namespace);
        expect(ion).toContain(flowId);
        expect(ion).toContain(executionId);
        assertIonLooksBinary(ion);
    });

    it('exportDashboardChart: exports a saved dashboard chart to CSV', async () => {
        const { namespace, flowId, executionId } = await createFlowAndWaitForExecution();
        const chartId = 'recent_executions';

        const created = await Dashboards.createDashboard({
            body: executionsTableDashboardYaml(randomId(), `export-csv-${randomId()}`, chartId, namespace),
        });
        const id = (created as any).id;

        const csv = await Dashboards.exportDashboardChart({ id, chartId, format: 'CSV' });

        expect(csv).toContain(namespace);
        expect(csv).toContain(flowId);
        expect(csv).toContain(executionId);
        assertCsvHeader(csv);
    });

    it('exportDashboardChart: exports a saved dashboard chart to ION', async () => {
        const { namespace, flowId, executionId } = await createFlowAndWaitForExecution();
        const chartId = 'recent_executions';

        const created = await Dashboards.createDashboard({
            body: executionsTableDashboardYaml(randomId(), `export-ion-${randomId()}`, chartId, namespace),
        });
        const id = (created as any).id;

        const ion = await Dashboards.exportDashboardChart({ id, chartId, format: 'ION' });

        expect(ion).toContain(namespace);
        expect(ion).toContain(flowId);
        expect(ion).toContain(executionId);
        assertIonLooksBinary(ion);
    });

    it('exportDashboardChart: returns error for non-existent chart id', async () => {
        const created = await createDashboard(`csv-export-${randomId()}`);
        const id = (created as any).id;

        await expect(Dashboards.exportDashboardChart({
            id,
            chartId: 'nonexistent',
            format: 'CSV',
        })).rejects.toThrow();
    });
});
