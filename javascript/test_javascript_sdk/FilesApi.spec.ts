import { describe, it, expect } from 'vitest';
import { kestraClient, randomId, getSimpleFlowAndId } from './CommonTestSetup.js';

function makeBlob(content: string): Blob {
    return new Blob([content], { type: 'text/plain' });
}

async function createNamespace(): Promise<string> {
    const { flowNamespace, flowBody } = getSimpleFlowAndId();
    await kestraClient.Flows.createFlow({ body: flowBody });
    return flowNamespace;
}

describe('FilesApi', () => {
    it('createNamespaceDirectory: creates a directory', async () => {
        const namespace = await createNamespace();
        await kestraClient.Files.createNamespaceDirectory({ namespace, path: '/testdir' });
    });

    it('listNamespaceDirectoryFiles: lists files in a namespace', async () => {
        const namespace = await createNamespace();
        const result = await kestraClient.Files.listNamespaceDirectoryFiles({ namespace });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('createNamespaceFile and fileContent: creates and retrieves a file', async () => {
        const namespace = await createNamespace();
        const path = '/hello.txt';

        await kestraClient.Files.createNamespaceFile({
            namespace,
            path,
            fileContent: makeBlob('Hello World'),
        });

        const content = await kestraClient.Files.fileContent({ namespace, path });
        expect(content).toBeDefined();
    });

    it('fileMetadatas: retrieves file metadata', async () => {
        const namespace = await createNamespace();
        const path = '/meta.txt';

        await kestraClient.Files.createNamespaceFile({
            namespace,
            path,
            fileContent: makeBlob('metadata test'),
        });

        const result = await kestraClient.Files.fileMetadatas({ namespace, path });
        expect(result).toBeDefined();
    });

    it('fileRevisions: retrieves file revisions', async () => {
        const namespace = await createNamespace();
        const path = '/rev.txt';

        await kestraClient.Files.createNamespaceFile({
            namespace,
            path,
            fileContent: makeBlob('version 1'),
        });

        const result = await kestraClient.Files.fileRevisions({ namespace, path });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('searchNamespaceFiles: searches files in namespace', async () => {
        const namespace = await createNamespace();

        await kestraClient.Files.createNamespaceFile({
            namespace,
            path: '/search.txt',
            fileContent: makeBlob('searchable content'),
        });

        const result = await kestraClient.Files.searchNamespaceFiles({ namespace, q: 'search' });
        expect(result).toBeDefined();
    });

    it('deleteFileDirectory: deletes a file', async () => {
        const namespace = await createNamespace();
        const path = '/to-delete.txt';

        await kestraClient.Files.createNamespaceFile({
            namespace,
            path,
            fileContent: makeBlob('to be deleted'),
        });

        await kestraClient.Files.deleteFileDirectory({ namespace, path });
    });

    it('moveFileDirectory: moves a file', async () => {
        const namespace = await createNamespace();
        const from = `/move-from-${randomId()}.txt`;
        const to = `/move-to-${randomId()}.txt`;

        await kestraClient.Files.createNamespaceFile({
            namespace,
            path: from,
            fileContent: makeBlob('move test'),
        });

        await kestraClient.Files.moveFileDirectory({ namespace, from, to });
    });

    it('exportNamespaceFiles: exports files as archive', async () => {
        const namespace = await createNamespace();

        const result = await kestraClient.Files.exportNamespaceFiles({ namespace });
        expect(result).toBeDefined();
    });
});
