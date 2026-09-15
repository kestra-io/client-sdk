package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.InstanceControllerApiActiveServiceList;
import io.kestra.sdk.model.InstanceControllerApiCreateOrUpdateWorkerGroupRequest;
import io.kestra.sdk.model.InstanceControllerApiPluginArtifactListPluginArtifact;
import io.kestra.sdk.model.InstanceControllerApiPluginArtifactListPluginResolutionResult;
import io.kestra.sdk.model.InstanceControllerApiPluginListRequest;
import io.kestra.sdk.model.InstanceControllerApiPluginVersionDetails;
import io.kestra.sdk.model.InstanceControllerApiPluginVersions;
import io.kestra.sdk.model.InstanceControllerApiWorkerGroup;
import io.kestra.sdk.model.InstanceControllerApiWorkerGroupList;
import io.kestra.sdk.model.PagedResultsInstanceControllerApiPluginArtifact;
import io.kestra.sdk.model.PagedResultsInstanceControllerApiServiceInstance;
import io.kestra.sdk.model.PluginArtifact;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.ServiceInstance;
import io.kestra.sdk.model.WorkerCredentialControllerApiWorkerCredential;
import io.kestra.sdk.model.WorkerCredentialControllerApiWorkerList;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Instance-owner endpoints under {@code /api/v1/instance/**}: worker groups, worker
 * queues, versioned plugins, worker credentials, services, maintenance and MCP servers.
 * None of these are tenant-scoped — they operate on the whole Kestra cluster and require
 * the {@code IsInstanceOwner} role.
 * <p>
 * Instance-scoped policies ({@code /api/v1/instance/policies/**}) are intentionally NOT
 * here: they live on {@code PoliciesApi} alongside the tenant- and namespace-scoped
 * variants.
 */
public class InstanceApi extends BaseApi {

    private static final String SVG = "image/svg+xml";
    private static final String TEXT_PLAIN = "text/plain";
    private static final String MULTIPART = "multipart/form-data";

    public InstanceApi() {
        super(Configuration.getDefaultApiClient());
    }

    public InstanceApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ========================================================================
    // Worker groups
    // ========================================================================

    public InstanceControllerApiWorkerGroupList listWorkerGroups(
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        return invoke("GET",
                apiPath("instance", "worker-groups"),
                null, null, filterParams(filters),
                JSON, null,
                new TypeReference<>() {});
    }

    public InstanceControllerApiWorkerGroup createWorkerGroup(
            @jakarta.annotation.Nonnull InstanceControllerApiCreateOrUpdateWorkerGroupRequest request) throws ApiException {
        return invoke("POST",
                apiPath("instance", "worker-groups"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public InstanceControllerApiWorkerGroup getWorkerGroup(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                apiPath("instance", "worker-groups", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public InstanceControllerApiWorkerGroup updateWorkerGroup(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull InstanceControllerApiCreateOrUpdateWorkerGroupRequest request) throws ApiException {
        return invoke("PUT",
                apiPath("instance", "worker-groups", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteWorkerGroup(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable Boolean force) throws ApiException {
        invoke("DELETE",
                apiPath("instance", "worker-groups", id),
                null, queryParams("force", force), null,
                JSON, null,
                null);
    }

    public Map<String, Object> getWorkerGroupCapacity(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                apiPath("instance", "worker-groups", id, "capacity"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> listWorkerGroupWorkers(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                apiPath("instance", "worker-groups", id, "workers"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public InstanceControllerApiWorkerGroup addWorkerGroupSubscription(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                apiPath("instance", "worker-groups", id, "subscriptions"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public InstanceControllerApiWorkerGroup updateWorkerGroupSubscription(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String workerQueueId,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("PATCH",
                apiPath("instance", "worker-groups", id, "subscriptions", workerQueueId),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public InstanceControllerApiWorkerGroup removeWorkerGroupSubscription(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String workerQueueId) throws ApiException {
        return invoke("DELETE",
                apiPath("instance", "worker-groups", id, "subscriptions", workerQueueId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> generateWorkerGroupToken(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                apiPath("instance", "worker-groups", id, "tokens"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public InstanceControllerApiWorkerGroup revokeWorkerGroupToken(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tokenId) throws ApiException {
        return invoke("POST",
                apiPath("instance", "worker-groups", id, "tokens", tokenId, "revoke"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void deleteWorkerGroupToken(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tokenId) throws ApiException {
        invoke("DELETE",
                apiPath("instance", "worker-groups", id, "tokens", tokenId),
                null, null, null,
                JSON, null,
                null);
    }

    // ========================================================================
    // Worker queues
    // ========================================================================

    public Map<String, Object> listWorkerQueues() throws ApiException {
        return invoke("GET",
                apiPath("instance", "worker-queues"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createWorkerQueue(
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("POST",
                apiPath("instance", "worker-queues"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> getWorkerQueue(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                apiPath("instance", "worker-queues", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> updateWorkerQueue(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> request) throws ApiException {
        return invoke("PUT",
                apiPath("instance", "worker-queues", id),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteWorkerQueue(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                apiPath("instance", "worker-queues", id),
                null, null, null,
                JSON, null,
                null);
    }

    public Map<String, Object> getWorkerQueueSubscribers(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                apiPath("instance", "worker-queues", id, "subscribers"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Versioned plugins
    // ========================================================================

    public PagedResultsInstanceControllerApiPluginArtifact listVersionedPlugins(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                apiPath("instance", "versioned-plugins"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> listAvailableVersionedPlugins() throws ApiException {
        return invoke("GET",
                apiPath("instance", "versioned-plugins", "available"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> listAvailableVersionedPluginsForStorage() throws ApiException {
        return invoke("GET",
                apiPath("instance", "versioned-plugins", "available", "storages"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> listAvailableVersionedPluginsForSecretManager() throws ApiException {
        return invoke("GET",
                apiPath("instance", "versioned-plugins", "available", "secrets-managers"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public InstanceControllerApiPluginVersions getVersionedPluginDetails(
            @jakarta.annotation.Nonnull String groupId,
            @jakarta.annotation.Nonnull String artifactId) throws ApiException {
        return invoke("GET",
                apiPath("instance", "versioned-plugins", groupId, artifactId),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public byte[] getVersionedPluginIcon(
            @jakarta.annotation.Nonnull String groupId,
            @jakarta.annotation.Nonnull String artifactId,
            @jakarta.annotation.Nullable String version) throws ApiException {
        return invoke("GET",
                apiPath("instance", "versioned-plugins", groupId, artifactId, "icon.svg"),
                null, queryParams("v", version), null,
                SVG, null,
                new TypeReference<>() {});
    }

    public String getVersionedPluginReleaseNotes(
            @jakarta.annotation.Nonnull String groupId,
            @jakarta.annotation.Nonnull String artifactId,
            @jakarta.annotation.Nonnull String version) throws ApiException {
        return invoke("GET",
                apiPath("instance", "versioned-plugins", groupId, artifactId, "release-notes"),
                null, queryParams("version", version), null,
                TEXT_PLAIN, null,
                new TypeReference<>() {});
    }

    public InstanceControllerApiPluginVersionDetails getVersionedPluginDetailsFromVersion(
            @jakarta.annotation.Nonnull String groupId,
            @jakarta.annotation.Nonnull String artifactId,
            @jakarta.annotation.Nonnull String version) throws ApiException {
        return invoke("GET",
                apiPath("instance", "versioned-plugins", groupId, artifactId, version),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public InstanceControllerApiPluginArtifactListPluginArtifact installVersionedPlugins(
            @jakarta.annotation.Nonnull InstanceControllerApiPluginListRequest request) throws ApiException {
        return invoke("POST",
                apiPath("instance", "versioned-plugins", "install"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public InstanceControllerApiPluginArtifactListPluginResolutionResult resolveVersionedPlugins(
            @jakarta.annotation.Nonnull InstanceControllerApiPluginListRequest request) throws ApiException {
        return invoke("POST",
                apiPath("instance", "versioned-plugins", "resolve"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public PluginArtifact uploadVersionedPlugins(
            @jakarta.annotation.Nonnull File file,
            @jakarta.annotation.Nullable Boolean forceInstallOnExistingVersions) throws ApiException {
        Map<String, Object> formParams = new HashMap<>();
        formParams.put("file", file);
        return invoke("POST",
                apiPath("instance", "versioned-plugins", "upload"),
                null, queryParams("forceInstallOnExistingVersions", forceInstallOnExistingVersions), null,
                JSON, MULTIPART, formParams,
                new TypeReference<>() {});
    }

    public InstanceControllerApiPluginArtifactListPluginArtifact uninstallVersionedPlugins(
            @jakarta.annotation.Nonnull InstanceControllerApiPluginListRequest request) throws ApiException {
        return invoke("DELETE",
                apiPath("instance", "versioned-plugins", "uninstall"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Worker credentials
    // ========================================================================

    public WorkerCredentialControllerApiWorkerList listWorkerCredentials() throws ApiException {
        return invoke("GET",
                apiPath("instance", "workers", "credentials"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public WorkerCredentialControllerApiWorkerCredential getWorkerCredential(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                apiPath("instance", "workers", "credentials", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public WorkerCredentialControllerApiWorkerCredential revokeWorkerCredential(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("POST",
                apiPath("instance", "workers", "credentials", id, "revoke"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Services
    // ========================================================================

    public InstanceControllerApiActiveServiceList getActiveServices() throws ApiException {
        return invoke("GET",
                apiPath("instance", "services", "active"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public PagedResultsInstanceControllerApiServiceInstance searchServices(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable List<QueryFilter> filters) throws ApiException {
        List<Pair> collectionParams = new ArrayList<>();
        collectionParams.addAll(csvParams("sort", sort));
        collectionParams.addAll(filterParams(filters));
        return invoke("GET",
                apiPath("instance", "services", "search"),
                null, queryParams("page", page, "size", size), collectionParams,
                JSON, null,
                new TypeReference<>() {});
    }

    public ServiceInstance getService(
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                apiPath("instance", "services", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Maintenance
    // ========================================================================

    public Map<String, Object> getMaintenanceStatus() throws ApiException {
        return invoke("GET",
                apiPath("instance", "maintenance", "status"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public void enterMaintenance() throws ApiException {
        invoke("POST",
                apiPath("instance", "maintenance", "enter"),
                null, null, null,
                JSON, null,
                null);
    }

    public void exitMaintenance() throws ApiException {
        invoke("POST",
                apiPath("instance", "maintenance", "exit"),
                null, null, null,
                JSON, null,
                null);
    }

    // ========================================================================
    // MCP servers
    // ========================================================================

    public Map<String, Object> listMcpServers(
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort) throws ApiException {
        return invoke("GET",
                apiPath("instance", "mcp-servers"),
                null, queryParams("page", page, "size", size), csvParams("sort", sort),
                JSON, null,
                new TypeReference<>() {});
    }

}
