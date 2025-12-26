package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.FileAttributes;
import io.kestra.sdk.model.NamespaceFileRevision;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static io.kestra.example.CommonTestSetup.*;
import static org.assertj.core.api.Assertions.*;

public class FilesApiTest {

    /**
     * Create a namespace directory
     */
    @Test
    public void createNamespaceDirectoryTest() throws ApiException {
        String namespace = "create_namespace_directory";
        String path = "testdir";

        // note: using parameter order as in generated test: (namespace, tenant, path)
        kestraClient().files().createNamespaceDirectory(namespace, MAIN_TENANT, path);
    }

    /**
     * Create a file
     */
    @Test
    public void createNamespaceFileTest() throws ApiException, IOException {
        String namespace = "create_namespace_file";
        String path = "file.txt";

        File tmpFile = File.createTempFile("file", ".txt");
        Files.writeString(tmpFile.toPath(), "test", StandardOpenOption.WRITE);

        // using generated signature: (namespace, path, tenant, file)
        kestraClient().files().createNamespaceFile(namespace, path, MAIN_TENANT, tmpFile);
    }

    /**
     * Get namespace file content
     */
    @Test
    public void fileContentTest() throws ApiException, IOException {
        String namespace = "file_content";
        String path = "file.txt";

        File tmpFile = File.createTempFile("file", ".txt");
        Files.writeString(tmpFile.toPath(), "test", StandardOpenOption.WRITE);
        kestraClient().files().createNamespaceFile(namespace, path, MAIN_TENANT, tmpFile);

        // signature: (namespace, path, tenant, revision)
        File response = kestraClient().files().fileContent(namespace, path, MAIN_TENANT, null);

        assertThat(response).isNotNull();
        String content = Files.readString(response.toPath());
        assertThat(content).contains("test");
    }

    /**
     * Get namespace file stats such as size, creation & modification dates and type
     */
    @Test
    public void fileMetadatasTest() throws ApiException, IOException {
        String namespace = "file_metadatas";
        String path = "file.txt";

        File tmpFile = File.createTempFile("file", ".txt");
        Files.writeString(tmpFile.toPath(), "test", StandardOpenOption.WRITE);
        kestraClient().files().createNamespaceFile(namespace, path, MAIN_TENANT, tmpFile);

        // signature: (namespace, tenant, path)
        FileAttributes response = kestraClient().files().fileMetadatas(namespace, MAIN_TENANT, path);

        assertThat(response).isNotNull();
        assertThat(response.getSize()).isNotNull();
    }

    /**
     * Get namespace file revisions
     */
    @Test
    @Disabled
    public void fileRevisionsTest() throws ApiException, IOException {
        String namespace = "file_revisions";
        String path = "file.txt";

        File tmpFile = File.createTempFile("file", ".txt");
        Files.writeString(tmpFile.toPath(), "test", StandardOpenOption.WRITE);
        kestraClient().files().createNamespaceFile(namespace, path, MAIN_TENANT, tmpFile);

        List<NamespaceFileRevision> response = kestraClient().files().fileRevisions(namespace, MAIN_TENANT, path);

        assertThat(response).isNotNull();
    }

    /**
     * List directory content
     */
    @Test
    public void listNamespaceDirectoryFilesTest() throws ApiException, IOException {
        String namespace = "list_namespace_directory_files";
        String path = ""; // root

        File tmpFile = File.createTempFile("file", ".txt");
        Files.writeString(tmpFile.toPath(), "test", StandardOpenOption.WRITE);
        kestraClient().files().createNamespaceFile(namespace, "file.txt", MAIN_TENANT, tmpFile);

        List<FileAttributes> response = kestraClient().files().listNamespaceDirectoryFiles(namespace, MAIN_TENANT, path);

        assertThat(response).isNotNull();
        assertThat(response).isNotEmpty();
    }

    /**
     * Move a file or directory
     */
    @Test
    public void moveFileDirectoryTest() throws ApiException, IOException {
        String namespace = "move_file_directory";
        String fromPath = "/file_to_move.txt";
        String toPath = "/moved_file.txt";

        File tmpFile = File.createTempFile("file", ".txt");
        Files.writeString(tmpFile.toPath(), "test", StandardOpenOption.WRITE);
        // create file under the namespace
        kestraClient().files().createNamespaceFile(namespace, fromPath.substring(1), MAIN_TENANT, tmpFile);

        // signature: (namespace, from, to, tenant)
        kestraClient().files().moveFileDirectory(namespace, URI.create(fromPath), URI.create(toPath), MAIN_TENANT);

        // search for moved file
        List<String> search = kestraClient().files().searchNamespaceFiles(namespace, "moved_file", MAIN_TENANT);
        assertThat(search).isNotNull();
    }

    /**
     * Delete a file or directory
     */
    @Test
    public void deleteFileDirectoryTest() throws ApiException, IOException {
        String namespace = "delete_file_directory";
        String path = "file_to_delete.txt";

        File tmpFile = File.createTempFile("file", ".txt");
        Files.writeString(tmpFile.toPath(), "test", StandardOpenOption.WRITE);
        kestraClient().files().createNamespaceFile(namespace, path, MAIN_TENANT, tmpFile);

        // signature: (namespace, path, tenant)
        kestraClient().files().deleteFileDirectory(namespace, path, MAIN_TENANT);
    }

    /**
     * Export namespace files as a ZIP
     */
    @Test
    public void exportNamespaceFilesTest() throws ApiException {
        String namespace = "export_namespace_files";

        byte[] response = kestraClient().files().exportNamespaceFiles(namespace, MAIN_TENANT);

        assertThat(response).isNotNull();
    }

    /**
     * Find files which path contain the given string in their URI
     */
    @Test
    public void searchNamespaceFilesTest() throws ApiException, IOException {
        String namespace = "search_namespace_files";
        String q = "file";

        File tmpFile = File.createTempFile("file", ".txt");
        Files.writeString(tmpFile.toPath(), "test", StandardOpenOption.WRITE);
        kestraClient().files().createNamespaceFile(namespace, "search_file.txt", MAIN_TENANT, tmpFile);

        List<String> response = kestraClient().files().searchNamespaceFiles(namespace, q, MAIN_TENANT);

        assertThat(response).isNotNull();
        assertThat(response.stream().anyMatch(s -> s.contains("search_file.txt"))).isTrue();
    }
}
