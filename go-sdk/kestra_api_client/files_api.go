package kestra_api_client

import (
	"context"
	"io"
	"os"
)

type FilesAPI struct {
	baseAPI
}

func (a *FilesAPI) CreateNamespaceDirectory(ctx context.Context, namespace, tenant string, path *string) error {
	params := buildQueryParams("path", path)
	return a.doVoidJSON(ctx, "POST", tenantPath(tenant, "namespaces", namespace, "files", "directory"), nil, params)
}

func (a *FilesAPI) ListNamespaceDirectoryFiles(ctx context.Context, namespace, tenant string, path *string) ([]FileAttributes, error) {
	params := buildQueryParams("path", path)
	return doJSON[[]FileAttributes](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "files", "directory"), nil, params)
}

func (a *FilesAPI) CreateNamespaceFile(ctx context.Context, namespace, tenant string, path string, fileContent io.Reader, fileName string) error {
	params := buildQueryParams("path", path)
	return a.doMultipartUploadVoid(ctx, "POST", tenantPath(tenant, "namespaces", namespace, "files"), params, "fileContent", fileContent, fileName)
}

func (a *FilesAPI) FileContent(ctx context.Context, namespace, tenant string, path string, revision *int) (*os.File, error) {
	params := buildQueryParams("path", path, "revision", revision)
	return a.doDownload(ctx, "GET", tenantPath(tenant, "namespaces", namespace, "files"), nil, params)
}

func (a *FilesAPI) FileMetadatas(ctx context.Context, namespace, tenant string, path string) (*FileAttributes, error) {
	params := buildQueryParams("path", path)
	return doJSON[*FileAttributes](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "files", "stats"), nil, params)
}

func (a *FilesAPI) FileRevisions(ctx context.Context, namespace, tenant string, path string) ([]NamespaceFileRevision, error) {
	params := buildQueryParams("path", path)
	return doJSON[[]NamespaceFileRevision](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "files", "revisions"), nil, params)
}

func (a *FilesAPI) MoveFileDirectory(ctx context.Context, namespace, tenant, from, to string) error {
	params := buildQueryParams("from", from, "to", to)
	return a.doVoidJSON(ctx, "PUT", tenantPath(tenant, "namespaces", namespace, "files"), nil, params)
}

func (a *FilesAPI) DeleteFileDirectory(ctx context.Context, namespace, tenant, path string) error {
	params := buildQueryParams("path", path)
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "files"), nil, params)
}

func (a *FilesAPI) SearchNamespaceFiles(ctx context.Context, namespace, tenant string, q *string) ([]string, error) {
	params := buildQueryParams("q", q)
	return doJSON[[]string](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "files", "search"), nil, params)
}

func (a *FilesAPI) ExportNamespaceFiles(ctx context.Context, namespace, tenant string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "GET", tenantPath(tenant, "namespaces", namespace, "files", "export"), nil, nil)
}
