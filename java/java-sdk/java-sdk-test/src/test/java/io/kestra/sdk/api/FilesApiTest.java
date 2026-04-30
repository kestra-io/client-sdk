package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.FileAttributes;
import io.kestra.sdk.model.NamespaceFileRevision;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FilesApiTest {

    static FilesApi api() {
        return client().files();
    }

    static File tempFile(String name, String content) throws IOException {
        File f = Files.createTempFile(name, ".txt").toFile();
        Files.writeString(f.toPath(), content);
        f.deleteOnExit();
        return f;
    }

    // ========================================================================
    // Directories
    // ========================================================================

    @Test
    void createNamespaceDirectory_basic() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        assertThatCode(() -> api().createNamespaceDirectory(ns, TENANT, "/testdir"))
                .doesNotThrowAnyException();
    }

    @Test
    void listNamespaceDirectoryFiles_basic() throws ApiException, IOException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().createNamespaceFile(ns, "/hello.txt", TENANT, tempFile("hello", "world"));

        List<FileAttributes> files = api().listNamespaceDirectoryFiles(ns, TENANT, null);
        assertThat(files).isNotNull().isNotEmpty();
    }

    @Test
    void listNamespaceDirectoryFiles_empty() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        List<FileAttributes> files = api().listNamespaceDirectoryFiles(ns, TENANT, null);
        assertThat(files).isNotNull();
    }

    // ========================================================================
    // Files
    // ========================================================================

    @Test
    void createAndGetNamespaceFile() throws ApiException, IOException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().createNamespaceFile(ns, "/myfile.txt", TENANT, tempFile("myfile", "content here"));

        File downloaded = api().fileContent(ns, "/myfile.txt", TENANT, null);
        assertThat(downloaded).isNotNull();
        assertThat(downloaded.length()).isGreaterThan(0);
    }

    @Test
    void fileMetadatas_basic() throws ApiException, IOException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().createNamespaceFile(ns, "/meta.txt", TENANT, tempFile("meta", "some data"));

        FileAttributes attrs = api().fileMetadatas(ns, TENANT, "/meta.txt");
        assertThat(attrs).isNotNull();
    }

    @Test
    void fileRevisions_basic() throws ApiException, IOException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().createNamespaceFile(ns, "/rev.txt", TENANT, tempFile("rev", "version 1"));

        List<NamespaceFileRevision> revisions = api().fileRevisions(ns, TENANT, "/rev.txt");
        assertThat(revisions).isNotNull();
    }

    // ========================================================================
    // Move & Delete
    // ========================================================================

    @Test
    void moveFileDirectory_basic() throws ApiException, IOException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().createNamespaceFile(ns, "/tomove.txt", TENANT, tempFile("move", "data"));

        assertThatCode(() -> api().moveFileDirectory(ns,
                URI.create("/tomove.txt"), URI.create("/moved.txt"), TENANT))
                .doesNotThrowAnyException();
    }

    @Test
    void deleteFileDirectory_basic() throws ApiException, IOException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().createNamespaceFile(ns, "/todelete.txt", TENANT, tempFile("del", "data"));

        assertThatCode(() -> api().deleteFileDirectory(ns, "/todelete.txt", TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Search & Export
    // ========================================================================

    @Test
    void searchNamespaceFiles_basic() throws ApiException, IOException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().createNamespaceFile(ns, "/searchable.txt", TENANT, tempFile("search", "data"));

        List<String> results = api().searchNamespaceFiles(ns, "searchable", TENANT);
        assertThat(results).isNotNull().isNotEmpty();
    }

    @Test
    void exportNamespaceFiles_basic() throws ApiException, IOException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().createNamespaceFile(ns, "/export.txt", TENANT, tempFile("export", "data"));

        byte[] zip = api().exportNamespaceFiles(ns, TENANT);
        assertThat(zip).isNotNull();
        assertThat(zip.length).isGreaterThan(0);
    }
}
