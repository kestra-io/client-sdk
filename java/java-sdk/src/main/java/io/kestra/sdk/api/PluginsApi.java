package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.DocumentationWithSchema;
import io.kestra.sdk.model.InputType;
import io.kestra.sdk.model.Plugin;
import io.kestra.sdk.model.PluginArtifact;
import io.kestra.sdk.model.PluginControllerApiPluginVersions;
import io.kestra.sdk.model.PluginUiManifest;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.SchemaType;
import io.kestra.sdk.model.TaskWithVersion;
import io.kestra.sdk.model.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Plugin discovery, documentation and (EE) auto-install endpoints. None of these are
 * tenant-scoped: they describe the plugins available on the server, not tenant data.
 */
public class PluginsApi extends BaseApi {

    private static final String SVG = "image/svg+xml";
    private static final String OCTET_STREAM = "application/octet-stream";
    private static final String TEXT_PLAIN = "text/plain";

    public PluginsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public PluginsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ========================================================================
    // Listing & search
    // ========================================================================

    public Map<String, Object> listPlugins(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                apiPath("plugins"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public List<Plugin> getPluginBySubgroups() throws ApiException {
        return invoke("GET",
                apiPath("plugins", "groups", "subgroups"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> listTriggerPlugins() throws ApiException {
        return invoke("GET",
                apiPath("plugins", "triggers"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Icons
    // ========================================================================

    public Map<String, Object> getPluginIcons() throws ApiException {
        return invoke("GET",
                apiPath("plugins", "icons"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getPluginGroupIcons() throws ApiException {
        return invoke("GET",
                apiPath("plugins", "icons", "groups"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getPluginIcon(
            @jakarta.annotation.Nonnull String cls) throws ApiException {
        return invoke("GET",
                apiPath("plugins", "icons", cls),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public byte[] getPluginIconSvg(
            @jakarta.annotation.Nonnull String cls) throws ApiException {
        return invoke("GET",
                apiPath("plugins", "icons", cls, "icon.svg"),
                null, null, null,
                SVG, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Input types
    // ========================================================================

    public List<InputType> getAllInputTypes() throws ApiException {
        return invoke("GET",
                apiPath("plugins", "inputs"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public DocumentationWithSchema getSchemaFromInputType(
            @jakarta.annotation.Nonnull Type type) throws ApiException {
        return invoke("GET",
                apiPath("plugins", "inputs", type.getValue()),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Auto-install (EE)
    // ========================================================================

    public Object detectMissingPlugins(
            @jakarta.annotation.Nonnull String flowSource) throws ApiException {
        return invoke("POST",
                apiPath("plugins", "auto-install", "detect"),
                flowSource, null, null,
                JSON, TEXT_PLAIN,
                new TypeReference<>() {});
    }

    public Object installPlugins(
            @jakarta.annotation.Nonnull List<PluginArtifact> artifacts) throws ApiException {
        return invoke("POST",
                apiPath("plugins", "install"),
                artifacts, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> getInstallJob(
            @jakarta.annotation.Nonnull String jobId) throws ApiException {
        return invoke("GET",
                apiPath("plugins", "install", jobId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // UI manifest
    // ========================================================================

    public PluginUiManifest getPluginUiManifest(
            @jakarta.annotation.Nonnull List<TaskWithVersion> tasks) throws ApiException {
        return invoke("POST",
                apiPath("plugins", "pluginUiManifest"),
                tasks, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public byte[] getPluginUi(
            @jakarta.annotation.Nonnull String group,
            @jakarta.annotation.Nonnull String path) throws ApiException {
        return invoke("GET",
                apiPath("plugins", group, "pluginUi", path),
                null, null, null,
                OCTET_STREAM, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Schemas & properties
    // ========================================================================

    public Map<String, Object> getPropertiesFromType(
            @jakarta.annotation.Nonnull SchemaType type) throws ApiException {
        return invoke("GET",
                apiPath("plugins", "properties", type.getValue()),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getSchemasFromType(
            @jakarta.annotation.Nonnull SchemaType type,
            @jakarta.annotation.Nullable Boolean arrayOf,
            @jakarta.annotation.Nullable Boolean includeCatalog) throws ApiException {
        return invoke("GET",
                apiPath("plugins", "schemas", type.getValue()),
                null, queryParams("arrayOf", arrayOf, "includeCatalog", includeCatalog), null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Documentation
    // ========================================================================

    public DocumentationWithSchema getPluginDocumentation(
            @jakarta.annotation.Nonnull String cls,
            @jakarta.annotation.Nullable Boolean all) throws ApiException {
        return invoke("GET",
                apiPath("plugins", cls),
                null, queryParams("all", all), null,
                JSON, null,
                new TypeReference<>() {});
    }

    public PluginControllerApiPluginVersions getPluginVersions(
            @jakarta.annotation.Nonnull String cls) throws ApiException {
        return invoke("GET",
                apiPath("plugins", cls, "versions"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public DocumentationWithSchema getPluginDocumentationFromVersion(
            @jakarta.annotation.Nonnull String cls,
            @jakarta.annotation.Nonnull String version,
            @jakarta.annotation.Nullable Boolean all) throws ApiException {
        return invoke("GET",
                apiPath("plugins", cls, "versions", version),
                null, queryParams("all", all), null,
                JSON, null,
                new TypeReference<>() {});
    }

}
