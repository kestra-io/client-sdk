package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.FileAttributes;
import io.kestra.sdk.model.NamespaceFileRevision;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String OCTET_STREAM = "application/octet-stream";
    private static final String MULTIPART = "multipart/form-data";

    public FilesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public FilesApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- Path builders ----

    private String nsFilesPath(String tenant, String namespace, String... segments) {
        StringBuilder sb = new StringBuilder("/api/v1/");
        sb.append(esc(tenant)).append("/namespaces/").append(esc(namespace)).append("/files");
        for (String s : segments) {
            sb.append("/").append(esc(s));
        }
        return sb.toString();
    }

    private String esc(String value) {
        return apiClient.escapeString(apiClient.parameterToString(value));
    }

    // ---- Query param builders ----

    private List<Pair> queryParams(Object... keyValues) {
        List<Pair> params = new ArrayList<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            String key = (String) keyValues[i];
            Object value = keyValues[i + 1];
            if (value != null) {
                params.addAll(apiClient.parameterToPair(key, value));
            }
        }
        return params;
    }

    // ---- HTTP helpers ----

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams,
                         String accept, String contentType,
                         Map<String, Object> formParams,
                         TypeReference<T> returnType) throws ApiException {
        return apiClient.invokeAPI(
                path, method,
                queryParams != null ? queryParams : Collections.emptyList(),
                Collections.emptyList(),
                "",
                body,
                new HashMap<>(),
                new HashMap<>(),
                formParams != null ? formParams : new HashMap<>(),
                accept, contentType, AUTH, returnType
        );
    }

    // ========================================================================
    // Directories
    // ========================================================================

    public void createNamespaceDirectory(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String path) throws ApiException {
        invoke("POST", nsFilesPath(tenant, namespace, "directory"),
                null, queryParams("path", path),
                null, null, null, null);
    }

    public List<FileAttributes> listNamespaceDirectoryFiles(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String path) throws ApiException {
        return invoke("GET", nsFilesPath(tenant, namespace, "directory"),
                null, queryParams("path", path),
                JSON, null, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Files
    // ========================================================================

    public void createNamespaceFile(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String path,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable File fileContent) throws ApiException {
        Map<String, Object> formParams = new HashMap<>();
        if (fileContent != null) {
            formParams.put("fileContent", fileContent);
        }
        invoke("POST", nsFilesPath(tenant, namespace),
                null, queryParams("path", path),
                null, MULTIPART, formParams, null);
    }

    public File fileContent(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String path,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer revision) throws ApiException {
        return invoke("GET", nsFilesPath(tenant, namespace),
                null, queryParams("path", path, "revision", revision),
                OCTET_STREAM, null, null,
                new TypeReference<>() {});
    }

    public FileAttributes fileMetadatas(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String path) throws ApiException {
        return invoke("GET", nsFilesPath(tenant, namespace, "stats"),
                null, queryParams("path", path),
                JSON, null, null,
                new TypeReference<>() {});
    }

    public List<NamespaceFileRevision> fileRevisions(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable String path) throws ApiException {
        return invoke("GET", nsFilesPath(tenant, namespace, "revisions"),
                null, queryParams("path", path),
                JSON, null, null,
                new TypeReference<>() {});
    }

    public void moveFileDirectory(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull URI from,
            @jakarta.annotation.Nonnull URI to,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("PUT", nsFilesPath(tenant, namespace),
                null, queryParams("from", from, "to", to),
                null, null, null, null);
    }

    public void deleteFileDirectory(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String path,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE", nsFilesPath(tenant, namespace),
                null, queryParams("path", path),
                null, null, null, null);
    }

    // ========================================================================
    // Search & Export
    // ========================================================================

    public List<String> searchNamespaceFiles(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String q,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET", nsFilesPath(tenant, namespace, "search"),
                null, queryParams("q", q),
                JSON, null, null,
                new TypeReference<>() {});
    }

    public byte[] exportNamespaceFiles(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET", nsFilesPath(tenant, namespace, "export"),
                null, null,
                OCTET_STREAM, null, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // BaseApi override
    // ========================================================================

    @Override
    public <T> T invokeAPI(String url, String method, Object request,
                           TypeReference<T> returnType,
                           Map<String, String> additionalHeaders) throws ApiException {
        String baseUrl = apiClient.getBaseURL(); String path = url.startsWith(baseUrl) ? url.substring(baseUrl.length()) : url;
        return apiClient.invokeAPI(
                path, method,
                Collections.emptyList(), Collections.emptyList(), "",
                request,
                additionalHeaders != null ? additionalHeaders : new HashMap<>(),
                new HashMap<>(), new HashMap<>(),
                JSON, JSON, AUTH, returnType
        );
    }
}
