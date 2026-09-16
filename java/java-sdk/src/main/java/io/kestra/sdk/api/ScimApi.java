package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import io.kestra.sdk.model.PatchRequest;
import io.kestra.sdk.model.ScimResourceType;
import io.kestra.sdk.model.Schema;
import io.kestra.sdk.model.ScimResource;
import io.kestra.sdk.model.ScimUser;
import io.kestra.sdk.model.SearchRequest;
import io.kestra.sdk.model.ServiceProviderConfiguration;
import io.kestra.sdk.model.SortOrder;

import java.util.List;

/**
 * SCIM v2 endpoints under {@code /api/v1/{tenant}/integrations/{integration}/scim/v2/**}: the
 * RFC 7643/7644 Users, Groups and configuration resources an external identity provider drives
 * to provision members. Every request/response is SCIM JSON ({@code application/scim+json}); a
 * user/group listing comes back as a SCIM {@link ScimResource} {@code ListResponse} envelope.
 * <p>
 * {@code integration} is the id of a SCIM-enabled security integration (see
 * {@code SecurityIntegrationsApi}); requests are authorized with that integration's token.
 */
public class ScimApi extends BaseApi {

    private static final String SCIM = "application/scim+json";

    public ScimApi() {
        super(Configuration.getDefaultApiClient());
    }

    public ScimApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ========================================================================
    // Users
    // ========================================================================

    public ScimResource queryUsers(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes,
            @jakarta.annotation.Nullable String filter,
            @jakarta.annotation.Nullable String sortBy,
            @jakarta.annotation.Nullable SortOrder sortOrder,
            @jakarta.annotation.Nullable Integer startIndex,
            @jakarta.annotation.Nullable Integer count) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Users"),
                null,
                queryParams("attributes", attributes, "excludedAttributes", excludedAttributes,
                        "filter", filter, "sortBy", sortBy, "sortOrder", sortOrder,
                        "startIndex", startIndex, "count", count),
                null,
                SCIM, null,
                new TypeReference<>() {});
    }

    public ScimResource findUsers(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull SearchRequest searchRequest) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Users", ".search"),
                searchRequest, null, null,
                SCIM, SCIM,
                new TypeReference<>() {});
    }

    public ScimResource createUser(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull ScimUser user,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Users"),
                user, queryParams("attributes", attributes, "excludedAttributes", excludedAttributes), null,
                SCIM, SCIM,
                new TypeReference<>() {});
    }

    public ScimResource getUser(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Users", id),
                null, queryParams("attributes", attributes, "excludedAttributes", excludedAttributes), null,
                SCIM, null,
                new TypeReference<>() {});
    }

    public ScimResource updateUser(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull ScimResource resource,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Users", id),
                resource, queryParams("attributes", attributes, "excludedAttributes", excludedAttributes), null,
                SCIM, SCIM,
                new TypeReference<>() {});
    }

    public void patchUser(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull PatchRequest patchRequest,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes) throws ApiException {
        invoke("PATCH",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Users", id),
                patchRequest, queryParams("attributes", attributes, "excludedAttributes", excludedAttributes), null,
                SCIM, SCIM,
                null);
    }

    public void deleteUser(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Users", id),
                null, null, null,
                SCIM, null,
                null);
    }

    // ========================================================================
    // Groups
    // ========================================================================

    public ScimResource queryGroups(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes,
            @jakarta.annotation.Nullable String filter,
            @jakarta.annotation.Nullable String sortBy,
            @jakarta.annotation.Nullable SortOrder sortOrder,
            @jakarta.annotation.Nullable Integer startIndex,
            @jakarta.annotation.Nullable Integer count) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Groups"),
                null,
                queryParams("attributes", attributes, "excludedAttributes", excludedAttributes,
                        "filter", filter, "sortBy", sortBy, "sortOrder", sortOrder,
                        "startIndex", startIndex, "count", count),
                null,
                SCIM, null,
                new TypeReference<>() {});
    }

    public ScimResource findGroups(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull SearchRequest searchRequest) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Groups", ".search"),
                searchRequest, null, null,
                SCIM, SCIM,
                new TypeReference<>() {});
    }

    public ScimResource createGroup(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull ScimUser group,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Groups"),
                group, queryParams("attributes", attributes, "excludedAttributes", excludedAttributes), null,
                SCIM, SCIM,
                new TypeReference<>() {});
    }

    public ScimResource getGroup(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Groups", id),
                null, queryParams("attributes", attributes, "excludedAttributes", excludedAttributes), null,
                SCIM, null,
                new TypeReference<>() {});
    }

    public ScimResource updateGroup(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull ScimResource resource,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Groups", id),
                resource, queryParams("attributes", attributes, "excludedAttributes", excludedAttributes), null,
                SCIM, SCIM,
                new TypeReference<>() {});
    }

    public void patchGroup(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull PatchRequest patchRequest,
            @jakarta.annotation.Nullable String attributes,
            @jakarta.annotation.Nullable String excludedAttributes) throws ApiException {
        invoke("PATCH",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Groups", id),
                patchRequest, queryParams("attributes", attributes, "excludedAttributes", excludedAttributes), null,
                SCIM, SCIM,
                null);
    }

    public void deleteGroup(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String id) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Groups", id),
                null, null, null,
                SCIM, null,
                null);
    }

    // ========================================================================
    // Discovery / configuration (read-only)
    // ========================================================================

    public List<ScimResourceType> getAllResourceTypes(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration) throws ApiException {
        return scimList(tenant, integration, "ResourceTypes", ScimResourceType.class);
    }

    /**
     * Fetches a SCIM configuration listing, tolerating both shapes the server may return: a bare
     * JSON array (per the OpenAPI spec) or a SCIM {@code ListResponse} envelope carrying the items
     * under {@code Resources}. Keeps the {@code List<T>} public signature either way.
     */
    private <T> List<T> scimList(String tenant, String integration, String resource, Class<T> itemType)
            throws ApiException {
        JsonNode node = invoke("GET",
                tenantPath(tenant, "integrations", integration, "scim", "v2", resource),
                null, null, null,
                SCIM, null,
                new TypeReference<JsonNode>() {});
        JsonNode items = node.isArray() ? node : node.get("Resources");
        if (items == null || items.isNull()) {
            return java.util.Collections.emptyList();
        }
        ObjectMapper mapper = getApiClient().getObjectMapper();
        return mapper.convertValue(items,
                mapper.getTypeFactory().constructCollectionType(List.class, itemType));
    }

    public ScimResourceType getResourceType(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String name) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "ResourceTypes", name),
                null, null, null,
                SCIM, null,
                new TypeReference<>() {});
    }

    public List<Schema> getAllSchemas(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration) throws ApiException {
        return scimList(tenant, integration, "Schemas", Schema.class);
    }

    public Schema getSchema(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration,
            @jakarta.annotation.Nonnull String uri) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "Schemas", uri),
                null, null, null,
                SCIM, null,
                new TypeReference<>() {});
    }

    public ServiceProviderConfiguration getServiceProviderConfiguration(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String integration) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "integrations", integration, "scim", "v2", "ServiceProviderConfig"),
                null, null, null,
                SCIM, null,
                new TypeReference<>() {});
    }

}
