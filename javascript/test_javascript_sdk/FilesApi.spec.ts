import { describe, it, expect } from 'vitest';
import { randomId, getSimpleFlowAndId } from './_utils.js';
import * as Files from '@kestra-io/kestra-sdk/files';
import * as Flows from '@kestra-io/kestra-sdk/flows';

function makeBlob(content: string): Blob {
    return new Blob([content], { type: 'text/plain' });
}

async function createNamespace(): Promise<string> {
    const { flowNamespace, flowBody } = getSimpleFlowAndId();
    await Flows.createFlow({ body: flowBody });
    return flowNamespace;
}

describe('FilesApi', () => {
    it('createNamespaceDirectory: creates a directory', async () => {
        const namespace = await createNamespace();
        await Files.createNamespaceDirectory({ namespace, path: '/testdir' });
    });

    it('listNamespaceDirectoryFiles: lists files in a namespace', async () => {
        const namespace = await createNamespace();
        const result = await Files.listNamespaceDirectoryFiles({ namespace });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('createNamespaceFile and fileContent: creates and retrieves a file', async () => {
        const namespace = await createNamespace();
        const path = '/hello.txt';

        await Files.createNamespaceFile({
            namespace,
            path,
            fileContent: makeBlob('Hello World'),
        });

        const content = await Files.fileContent({ namespace, path });
        expect(content).toBeDefined();
    });

    it('fileMetadatas: retrieves file metadata', async () => {
        const namespace = await createNamespace();
        const path = '/meta.txt';

        await Files.createNamespaceFile({
            namespace,
            path,
            fileContent: makeBlob('metadata test'),
        });

        const result = await Files.fileMetadatas({ namespace, path });
        expect(result).toBeDefined();
    });

    it('fileRevisions: retrieves file revisions', async () => {
        const namespace = await createNamespace();
        const path = '/rev.txt';

        await Files.createNamespaceFile({
            namespace,
            path,
            fileContent: makeBlob('version 1'),
        });

        const result = await Files.fileRevisions({ namespace, path });
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('searchNamespaceFiles: searches files in namespace', async () => {
        const namespace = await createNamespace();

        await Files.createNamespaceFile({
            namespace,
            path: '/search.txt',
            fileContent: makeBlob('searchable content'),
        });

        const result = await Files.searchNamespaceFiles({ namespace, q: 'search' });
        expect(result).toBeDefined();
    });

    it('deleteFileDirectory: deletes a file', async () => {
        const namespace = await createNamespace();
        const path = '/to-delete.txt';

        await Files.createNamespaceFile({
            namespace,
            path,
            fileContent: makeBlob('to be deleted'),
        });

        await Files.deleteFileDirectory({ namespace, path });
    });

    it('moveFileDirectory: moves a file', async () => {
        const namespace = await createNamespace();
        const from = `/move-from-${randomId()}.txt`;
        const to = `/move-to-${randomId()}.txt`;

        await Files.createNamespaceFile({
            namespace,
            path: from,
            fileContent: makeBlob('move test'),
        });

        await Files.moveFileDirectory({ namespace, from, to });
    });

    it('exportNamespaceFiles: exports files as archive', async () => {
        const namespace = await createNamespace();

        const result = await Files.exportNamespaceFiles({ namespace });
        expect(result).toBeDefined();
    });
});
