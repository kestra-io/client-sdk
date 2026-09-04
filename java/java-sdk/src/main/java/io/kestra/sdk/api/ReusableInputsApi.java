package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;

import io.kestra.sdk.model.PagedResultsReusableInputs;
import io.kestra.sdk.model.ReusableInputs;

import java.util.Collections;
import java.util.List;

/**
 * Namespace-scoped reusable inputs blocks: named sets of flow input definitions
 * that flows reference via a REUSABLE_INPUTS input.
 */
public class ReusableInputsApi extends BaseApi {

    private static final String YAML = "application/x-yaml";

    public ReusableInputsApi() {
        super(Configuration.getDefaultApiClient());
    }

    public ReusableInputsApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    /** Creates or updates a block from its YAML source. */
    public ReusableInputs createOrUpdateReusableInputs(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String body,
            @jakarta.annotation.Nullable Boolean failIfExists) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id),
                body,
                queryParams("failIfExists", failIfExists),
                Collections.emptyList(),
                JSON, YAML,
                new TypeReference<>() {});
    }

    /** Retrieves a block, resolving namespace inheritance: the closest namespace defining it wins. */
    public ReusableInputs reusableInputs(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer revision) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id),
                null,
                queryParams("revision", revision),
                Collections.emptyList(),
                JSON, null,
                new TypeReference<>() {});
    }

    /** Deletes a block from the exact namespace it is defined in; inheritance is not resolved. */
    public void deleteReusableInputs(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        invoke("DELETE",
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id),
                null, null, null,
                null, null, null);
    }

    // ========================================================================
    // List & Revisions
    // ========================================================================

    /** Lists the blocks visible from a namespace, including those inherited from parent namespaces. */
    public PagedResultsReusableInputs listReusableInputs(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs"),
                null,
                queryParams("page", page, "size", size),
                Collections.emptyList(),
                JSON, null,
                new TypeReference<>() {});
    }

    /** Lists all revisions of a block. Unlike the read methods it does not resolve inheritance. */
    public List<ReusableInputs> listReusableInputsRevisions(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id, "revisions"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    /** Lists the namespaces that define at least one block, for editor autocompletion. */
    public List<String> listReusableInputsNamespaces(
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "reusable-inputs", "namespaces"),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

}
