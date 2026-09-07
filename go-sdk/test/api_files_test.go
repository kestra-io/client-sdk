package test

import (
	"context"
	"os"
	"strings"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func createTempFile(t *testing.T, content string) string {
	t.Helper()

	tmpFile, err := os.CreateTemp("", "file-*.txt")
	require.NoError(t, err)

	_, err = tmpFile.WriteString(content)
	require.NoError(t, err)
	require.NoError(t, tmpFile.Close())

	return tmpFile.Name()
}

func openTempFile(t *testing.T, path string) *os.File {
	t.Helper()

	file, err := os.Open(path)
	require.NoError(t, err)
	return file
}

func TestFilesAPI_All(t *testing.T) {
	t.Run("createNamespaceDirectoryTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "create_namespace_directory"
		path := "testdir"

		err := KestraTestClient().Files().CreateNamespaceDirectory(ctx, namespace, MAIN_TENANT, &path)
		require.NoError(t, err)
	})

	t.Run("createNamespaceFileTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "create_namespace_file"
		path := "file.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		err := KestraTestClient().Files().CreateNamespaceFile(ctx, namespace, MAIN_TENANT, path, file, "file.txt")
		require.NoError(t, err)
	})

	t.Run("fileContentTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "file_content"
		path := "file.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		err := KestraTestClient().Files().CreateNamespaceFile(ctx, namespace, MAIN_TENANT, path, file, "file.txt")
		require.NoError(t, err)

		response, err := KestraTestClient().Files().FileContent(ctx, namespace, MAIN_TENANT, path, nil)
		require.NoError(t, err)
		require.NotNil(t, response)

		content, err := os.ReadFile(response.Name())
		require.NoError(t, err)
		require.Contains(t, string(content), "test")
	})

	t.Run("fileMetadatasTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "file_metadatas"
		path := "file.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		err := KestraTestClient().Files().CreateNamespaceFile(ctx, namespace, MAIN_TENANT, path, file, "file.txt")
		require.NoError(t, err)

		response, err := KestraTestClient().Files().FileMetadatas(ctx, namespace, MAIN_TENANT, path)
		require.NoError(t, err)
		require.NotNil(t, response)
		require.NotNil(t, response.GetSize())
	})

	t.Run("fileRevisionsTest", func(t *testing.T) {
		t.Skip("disabled in Java tests")
	})

	t.Run("listNamespaceDirectoryFilesTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "list_namespace_directory_files"
		path := ""

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		err := KestraTestClient().Files().CreateNamespaceFile(ctx, namespace, MAIN_TENANT, "file.txt", file, "file.txt")
		require.NoError(t, err)

		response, err := KestraTestClient().Files().ListNamespaceDirectoryFiles(ctx, namespace, MAIN_TENANT, kestra_api_client.PtrString(path))
		require.NoError(t, err)
		require.NotNil(t, response)
		require.NotEmpty(t, response)
	})

	t.Run("moveFileDirectoryTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "move_file_directory_" + randomId()
		fromPath := "/file_to_move.txt"
		toPath := "/moved_file.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		err := KestraTestClient().Files().CreateNamespaceFile(ctx, namespace, MAIN_TENANT, fromPath[1:], file, "file_to_move.txt")
		require.NoError(t, err)

		err = KestraTestClient().Files().MoveFileDirectory(ctx, namespace, MAIN_TENANT, fromPath, toPath)
		require.NoError(t, err)

		search, err := KestraTestClient().Files().SearchNamespaceFiles(ctx, namespace, MAIN_TENANT, kestra_api_client.PtrString("moved_file"))
		require.NoError(t, err)
		require.NotNil(t, search)
	})

	t.Run("deleteFileDirectoryTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "delete_file_directory"
		path := "file_to_delete.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		err := KestraTestClient().Files().CreateNamespaceFile(ctx, namespace, MAIN_TENANT, path, file, "file_to_delete.txt")
		require.NoError(t, err)

		err = KestraTestClient().Files().DeleteFileDirectory(ctx, namespace, MAIN_TENANT, path)
		require.NoError(t, err)
	})

	t.Run("exportNamespaceFilesTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "export_namespace_files"
		response, err := KestraTestClient().Files().ExportNamespaceFiles(ctx, namespace, MAIN_TENANT)
		require.NoError(t, err)
		require.NotEmpty(t, response)
	})

	t.Run("searchNamespaceFilesTest", func(t *testing.T) {
		ctx := context.Background()

		namespace := "search_namespace_files"
		q := "file"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		err := KestraTestClient().Files().CreateNamespaceFile(ctx, namespace, MAIN_TENANT, "search_file.txt", file, "search_file.txt")
		require.NoError(t, err)

		response, err := KestraTestClient().Files().SearchNamespaceFiles(ctx, namespace, MAIN_TENANT, kestra_api_client.PtrString(q))
		require.NoError(t, err)
		require.NotNil(t, response)

		found := false
		for _, item := range response {
			if item == "search_file.txt" || strings.Contains(item, "search_file.txt") {
				found = true
				break
			}
		}
		require.True(t, found)
	})
}
