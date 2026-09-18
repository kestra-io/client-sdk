package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import java.util.List;
import java.util.Map;

/**
 * MCP-server endpoints under {@code /api/v1/{tenant}/mcp-servers/**}: the external Model
 * Context Protocol servers a tenant can register. Requires the {@code MCP_SERVER} resource.
 */
public class McpServersApi extends BaseApi {

    public McpServersApi() {
        super(Configuration.getDefaultApiClient());
    }

    public McpServersApi(ApiClient apiClient) {
        super(apiClient);
    }

    public Map<String, Object> listMcpServers(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "mcp-servers"),
                null, queryParams("page", page, "size", size), csvParams("sort", sort),
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> getMcpServer(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "mcp-servers", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public List<Map<String, Object>> listMcpServerTools(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "mcp-servers", id, "tools"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public Map<String, Object> createMcpServer(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull Map<String, Object> mcpServer) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "mcp-servers"),
                mcpServer, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public Map<String, Object> updateMcpServer(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull Map<String, Object> mcpServer) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "mcp-servers", id),
                mcpServer, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public void deleteMcpServer(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "mcp-servers", id),
                null, null, null,
                JSON, null,
                null);
    }

    public Map<String, Object> toggleMcpServer(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        return invoke("PATCH",
                tenantPath(tenant, "mcp-servers", id, "toggle"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

}
