import { describe, it, expect } from 'vitest';
import { randomId, getSimpleFlowAndId } from './_utils.js';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Apps from '@kestra-io/kestra-sdk/apps';

function appYaml(id: string, namespace: string, flowId: string): string {
    return `id: ${id}
type: io.kestra.plugin.ee.apps.Execution
namespace: ${namespace}
flowId: ${flowId}
displayName: Test App ${id}
layout:
  - on: OPEN
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "# Test App"
  - on: RUNNING
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "Running..."
  - on: SUCCESS
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "Done!"
`;
}

async function createApp() {
    const { flowId, flowNamespace, flowBody } = getSimpleFlowAndId();
    await Flows.createFlow({ body: flowBody });
    const app = await Apps.createApp({ body: appYaml(randomId(), flowNamespace, flowId) });
    return app;
}

describe('AppsApi', () => {
    it('createApp: creates an app from YAML', async () => {
        const app = await createApp();
        expect(app?.uid).toBeDefined();
    });

    it('app: retrieves the created app by uid', async () => {
        const app = await createApp();
        const uid = app?.uid;

        if (!uid) {
            throw new Error('createApp() did not return a uid');
        }

        const fetched = await Apps.app({ uid });
        expect(fetched.uid).toEqual(uid);
    });

    it('searchApps: returns a paged result', async () => {
        const result = await Apps.searchApps({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('updateApp: updates an existing app', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;
        const originalSrc = (app as any).source ?? '';
        // Modify the source to avoid 304 Not Modified
        const updatedSrc = originalSrc.replace('# Test App', `# Test App Updated ${randomId()}`);
        const body = updatedSrc || originalSrc;

        const updated = await Apps.updateApp({ uid, body });
        expect(updated).toBeDefined();
    });

    it('deleteApp: deletes an existing app', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await Apps.deleteApp({ uid });
    });

    it('listTags: lists all app tags', async () => {
        const result = await Apps.listTags();
        expect(result).toBeDefined();
    });

    it('searchAppsFromCatalog: returns catalog apps', async () => {
        const result = await Apps.searchAppsFromCatalog({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('bulkDeleteApps: bulk deletes by UIDs', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await Apps.bulkDeleteApps({ uids: [uid] });
    });

    it('bulkDisableApps: bulk disables apps by UIDs', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await Apps.bulkDisableApps({ uids: [uid] });
    });

    it('bulkEnableApps: bulk enables apps by UIDs', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await Apps.bulkEnableApps({ uids: [uid] });
    });

    it('disableApp: disables a single app', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await Apps.disableApp({ uid });
    });

    it('enableApp: enables a single app', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await Apps.enableApp({ uid });
    });
});
