import { describe, it, expect } from 'vitest';
import { kestraClient, randomId, getSimpleFlowAndId } from './CommonTestSetup.js';

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
    await kestraClient.Flows.createFlow({ body: flowBody });
    const app = await kestraClient.Apps.createApp({ body: appYaml(randomId(), flowNamespace, flowId) });
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

        const fetched = await kestraClient.Apps.app({ uid });
        expect(fetched.uid).toEqual(uid);
    });

    it('searchApps: returns a paged result', async () => {
        const result = await kestraClient.Apps.searchApps({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('updateApp: updates an existing app', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;
        const originalSrc = (app as any).source ?? '';
        // Modify the source to avoid 304 Not Modified
        const updatedSrc = originalSrc.replace('# Test App', `# Test App Updated ${randomId()}`);
        const body = updatedSrc || originalSrc;

        try {
            const updated = await kestraClient.Apps.updateApp({ uid, body });
            expect(updated).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if (status === 304) return; // Not Modified is acceptable
            throw err;
        }
    });

    it('deleteApp: deletes an existing app', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await kestraClient.Apps.deleteApp({ uid });
    });

    it('listTags: lists all app tags', async () => {
        const result = await kestraClient.Apps.listTags();
        expect(result).toBeDefined();
    });

    it('searchAppsFromCatalog: returns catalog apps', async () => {
        const result = await kestraClient.Apps.searchAppsFromCatalog({ page: 1, size: 10 });
        expect(result).toBeDefined();
    });

    it('bulkDeleteApps: bulk deletes by UIDs', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await kestraClient.Apps.bulkDeleteApps({ uids: [uid] });
    });

    it('bulkDisableApps: bulk disables apps by UIDs', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await kestraClient.Apps.bulkDisableApps({ uids: [uid] });
    });

    it('bulkEnableApps: bulk enables apps by UIDs', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await kestraClient.Apps.bulkEnableApps({ uids: [uid] });
    });

    it('disableApp: disables a single app', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await kestraClient.Apps.disableApp({ uid });
    });

    it('enableApp: enables a single app', async () => {
        const app = await createApp();
        const uid = (app as any).uid ?? (app as any).id;

        await kestraClient.Apps.enableApp({ uid });
    });
});
