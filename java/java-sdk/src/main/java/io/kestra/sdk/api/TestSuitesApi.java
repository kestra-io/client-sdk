package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.PagedResultsTestSuite;
import io.kestra.sdk.model.PagedResultsTestSuiteRunResult;
import io.kestra.sdk.model.TestSuite;
import io.kestra.sdk.model.TestSuiteControllerRunRequest;
import io.kestra.sdk.model.TestSuiteControllerSearchTestsLastResult;
import io.kestra.sdk.model.TestSuiteControllerTestSuiteBulkRequest;
import io.kestra.sdk.model.TestSuiteControllerTestsLastResultResponse;
import io.kestra.sdk.model.TestSuiteRunResult;
import io.kestra.sdk.model.TestSuiteServiceRunByQueryRequest;
import io.kestra.sdk.model.TestSuiteServiceTestRunByQueryResult;
import io.kestra.sdk.model.ValidateConstraintViolation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSuitesApi extends BaseApi {

    private static final String[] AUTH = {"basicAuth", "bearerAuth"};
    private static final String JSON = "application/json";
    private static final String YAML = "application/x-yaml";

    public TestSuitesApi() {
        super(Configuration.getDefaultApiClient());
    }

    public TestSuitesApi(ApiClient apiClient) {
        super(apiClient);
    }

    // ---- Path builders ----

    private String tenantPath(String tenant, String... segments) {
        StringBuilder sb = new StringBuilder("/api/v1/");
        sb.append(esc(tenant));
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

    private List<Pair> csvParams(String name, @jakarta.annotation.Nullable List<String> values) {
        if (values == null || values.isEmpty()) {
            return Collections.emptyList();
        }
        return apiClient.parameterToPairs("csv", name, values);
    }

    // ---- HTTP helpers ----

    private <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         TypeReference<T> returnType) throws ApiException {
        return apiClient.invokeAPI(
                path, method,
                queryParams != null ? queryParams : Collections.emptyList(),
                collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
                "",
                body,
                new HashMap<>(),
                new HashMap<>(),
                new HashMap<>(),
                accept, contentType, AUTH, returnType
        );
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    public TestSuite createTestSuite(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "tests"),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public TestSuite testSuite(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "tests", namespace, id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public TestSuite updateTestSuite(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("PUT",
                tenantPath(tenant, "tests", namespace, id),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    public Object deleteTestSuite(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "tests", namespace, id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Bulk operations
    // ========================================================================

    public BulkResponse deleteTestSuitesByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TestSuiteControllerTestSuiteBulkRequest request) throws ApiException {
        return invoke("DELETE",
                tenantPath(tenant, "tests", "by-ids"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public BulkResponse enableTestSuitesByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TestSuiteControllerTestSuiteBulkRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "tests", "enable", "by-ids"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public BulkResponse disableTestSuitesByIds(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TestSuiteControllerTestSuiteBulkRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "tests", "disable", "by-ids"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Run
    // ========================================================================

    public TestSuiteRunResult runTestSuite(
            @jakarta.annotation.Nonnull String namespace,
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable TestSuiteControllerRunRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "tests", namespace, id, "run"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    public TestSuiteServiceTestRunByQueryResult runTestSuitesByQuery(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TestSuiteServiceRunByQueryRequest request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "tests", "run"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Search
    // ========================================================================

    public PagedResultsTestSuite searchTestSuites(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable String namespace,
            @jakarta.annotation.Nullable String flowId,
            @jakarta.annotation.Nullable Boolean includeChildNamespaces) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "tests", "search"),
                null,
                queryParams("page", page, "size", size, "namespace", namespace,
                        "flowId", flowId, "includeChildNamespaces", includeChildNamespaces),
                csvParams("sort", sort),
                JSON, null,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Results
    // ========================================================================

    public TestSuiteRunResult testResult(
            @jakarta.annotation.Nonnull String id,
            @jakarta.annotation.Nonnull String tenant) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "tests", "results", id),
                null, null, null,
                JSON, null,
                new TypeReference<>() {});
    }

    public PagedResultsTestSuiteRunResult searchTestSuitesResults(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nullable Integer page,
            @jakarta.annotation.Nullable Integer size,
            @jakarta.annotation.Nullable List<String> sort,
            @jakarta.annotation.Nullable String testSuiteId,
            @jakarta.annotation.Nullable String namespace,
            @jakarta.annotation.Nullable String flowId) throws ApiException {
        return invoke("GET",
                tenantPath(tenant, "tests", "results", "search"),
                null,
                queryParams("page", page, "size", size, "testSuiteId", testSuiteId,
                        "namespace", namespace, "flowId", flowId),
                csvParams("sort", sort),
                JSON, null,
                new TypeReference<>() {});
    }

    public TestSuiteControllerTestsLastResultResponse testsLastResult(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull TestSuiteControllerSearchTestsLastResult request) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "tests", "results", "search", "last"),
                request, null, null,
                JSON, JSON,
                new TypeReference<>() {});
    }

    // ========================================================================
    // Validation
    // ========================================================================

    public ValidateConstraintViolation validateTestSuite(
            @jakarta.annotation.Nonnull String tenant,
            @jakarta.annotation.Nonnull String yamlBody) throws ApiException {
        return invoke("POST",
                tenantPath(tenant, "tests", "validate"),
                yamlBody, null, null,
                JSON, YAML,
                new TypeReference<>() {});
    }

    // ========================================================================
    // BaseApi override
    // ========================================================================

    @Override
    public <T> T invokeAPI(String url, String method, Object request,
                           TypeReference<T> returnType,
                           Map<String, String> additionalHeaders) throws ApiException {
        String path = url.replace(apiClient.getBaseURL(), "");
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
