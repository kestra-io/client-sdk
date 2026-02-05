package test

import (
	"os"
	"strings"
	"testing"

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
		ctx := GetAuthContext()

		namespace := "create_namespace_directory"
		path := "testdir"

		_, err := KestraTestApiClient().FilesAPI.CreateNamespaceDirectory(ctx, namespace, MAIN_TENANT).Path(path).Execute()
		require.NoError(t, err)
	})

	t.Run("createNamespaceFileTest", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := "create_namespace_file"
		path := "file.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		_, err := KestraTestApiClient().FilesAPI.CreateNamespaceFile(ctx, namespace, MAIN_TENANT).
			Path(path).
			FileContent(file).
			Execute()
		require.NoError(t, err)
	})

	t.Run("fileContentTest", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := "file_content"
		path := "file.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		_, err := KestraTestApiClient().FilesAPI.CreateNamespaceFile(ctx, namespace, MAIN_TENANT).
			Path(path).
			FileContent(file).
			Execute()
		require.NoError(t, err)

		response, _, err := KestraTestApiClient().FilesAPI.FileContent(ctx, namespace, MAIN_TENANT).
			Path(path).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, response)

		content, err := os.ReadFile(response.Name())
		require.NoError(t, err)
		require.Contains(t, string(content), "test")
	})

	t.Run("fileMetadatasTest", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := "file_metadatas"
		path := "file.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		_, err := KestraTestApiClient().FilesAPI.CreateNamespaceFile(ctx, namespace, MAIN_TENANT).
			Path(path).
			FileContent(file).
			Execute()
		require.NoError(t, err)

		response, _, err := KestraTestApiClient().FilesAPI.FileMetadatas(ctx, namespace, MAIN_TENANT).
			Path(path).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, response)
		require.NotNil(t, response.GetSize())
	})

	t.Run("fileRevisionsTest", func(t *testing.T) {
		t.Skip("disabled in Java tests")
	})

	t.Run("listNamespaceDirectoryFilesTest", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := "list_namespace_directory_files"
		path := ""

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		_, err := KestraTestApiClient().FilesAPI.CreateNamespaceFile(ctx, namespace, MAIN_TENANT).
			Path("file.txt").
			FileContent(file).
			Execute()
		require.NoError(t, err)

		response, _, err := KestraTestApiClient().FilesAPI.ListNamespaceDirectoryFiles(ctx, namespace, MAIN_TENANT).
			Path(path).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, response)
		require.NotEmpty(t, response)
	})

	t.Run("moveFileDirectoryTest", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := "move_file_directory"
		fromPath := "/file_to_move.txt"
		toPath := "/moved_file.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		_, err := KestraTestApiClient().FilesAPI.CreateNamespaceFile(ctx, namespace, MAIN_TENANT).
			Path(fromPath[1:]).
			FileContent(file).
			Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().FilesAPI.MoveFileDirectory(ctx, namespace, MAIN_TENANT).
			From(fromPath).
			To(toPath).
			Execute()
		require.NoError(t, err)

		search, _, err := KestraTestApiClient().FilesAPI.SearchNamespaceFiles(ctx, namespace, MAIN_TENANT).
			Q("moved_file").
			Execute()
		require.NoError(t, err)
		require.NotNil(t, search)
	})

	t.Run("deleteFileDirectoryTest", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := "delete_file_directory"
		path := "file_to_delete.txt"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		_, err := KestraTestApiClient().FilesAPI.CreateNamespaceFile(ctx, namespace, MAIN_TENANT).
			Path(path).
			FileContent(file).
			Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().FilesAPI.DeleteFileDirectory(ctx, namespace, MAIN_TENANT).
			Path(path).
			Execute()
		require.NoError(t, err)
	})

	t.Run("exportNamespaceFilesTest", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := "export_namespace_files"
		response, _, err := KestraTestApiClient().FilesAPI.ExportNamespaceFiles(ctx, namespace, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotEmpty(t, response)
	})

	t.Run("searchNamespaceFilesTest", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := "search_namespace_files"
		q := "file"

		pathOnDisk := createTempFile(t, "test")
		file := openTempFile(t, pathOnDisk)
		defer func() { _ = file.Close() }()

		_, err := KestraTestApiClient().FilesAPI.CreateNamespaceFile(ctx, namespace, MAIN_TENANT).
			Path("search_file.txt").
			FileContent(file).
			Execute()
		require.NoError(t, err)

		response, _, err := KestraTestApiClient().FilesAPI.SearchNamespaceFiles(ctx, namespace, MAIN_TENANT).
			Q(q).
			Execute()
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
