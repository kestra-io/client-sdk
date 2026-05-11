package io.kestra.sdk.internal;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseApi {

  protected static final String[] AUTH = {"basicAuth", "bearerAuth"};
  protected static final String JSON = "application/json";

  protected ApiClient apiClient;

  public BaseApi() {
    this(Configuration.getDefaultApiClient());
  }

  public BaseApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  // ---- Path builders ----

  protected String tenantPath(String tenant, String... segments) {
    StringBuilder sb = new StringBuilder("/api/v1/");
    sb.append(esc(tenant));
    for (String s : segments) {
      sb.append("/").append(esc(s));
    }
    return sb.toString();
  }

  protected String esc(String value) {
    return apiClient.escapeString(apiClient.parameterToString(value));
  }

  // ---- Query param builders ----

  protected List<Pair> queryParams(Object... keyValues) {
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

  protected List<Pair> filterParams(@jakarta.annotation.Nullable List<?> filters) {
    if (filters == null || filters.isEmpty()) {
      return Collections.emptyList();
    }
    return apiClient.parameterToPairs("csv", "filters", filters);
  }

  protected List<Pair> csvParams(String name, @jakarta.annotation.Nullable List<String> values) {
    if (values == null || values.isEmpty()) {
      return Collections.emptyList();
    }
    return apiClient.parameterToPairs("csv", name, values);
  }

  // ---- HTTP helpers ----

  protected <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         TypeReference<T> returnType) throws ApiException {
    return invoke(method, path, body, queryParams, collectionQueryParams,
            accept, contentType, new HashMap<>(), returnType);
  }

  protected <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         Map<String, Object> formParams,
                         TypeReference<T> returnType) throws ApiException {
    return apiClient.invokeAPI(
            path, method,
            queryParams != null ? queryParams : Collections.emptyList(),
            collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
            "",
            body,
            new HashMap<>(),
            new HashMap<>(),
            formParams != null ? formParams : new HashMap<>(),
            accept, contentType, AUTH, returnType
    );
  }

  // ---- BaseApi invokeAPI overloads ----

  public void invokeAPI(String url, String method) throws ApiException {
    invokeAPI(url, method, null, null, Collections.emptyMap());
  }

  public void invokeAPI(String url, String method, Map<String, String> additionalHeaders) throws ApiException {
    invokeAPI(url, method, null, null, additionalHeaders);
  }

  public void invokeAPI(String url, String method, Object request) throws ApiException {
    invokeAPI(url, method, request, null, Collections.emptyMap());
  }

  public void invokeAPI(String url, String method, Object request, Map<String, String> additionalHeaders) throws ApiException {
    invokeAPI(url, method, request, null, additionalHeaders);
  }

  public <T> T invokeAPI(String url, String method, TypeReference<T> returnType) throws ApiException {
    return invokeAPI(url, method, null, returnType, Collections.emptyMap());
  }

  public <T> T invokeAPI(String url, String method, Object request, TypeReference<T> returnType) throws ApiException {
    return invokeAPI(url, method, request, returnType, Collections.emptyMap());
  }

  public <T> T invokeAPI(String url, String method, Object request,
                         TypeReference<T> returnType,
                         Map<String, String> additionalHeaders) throws ApiException {
    String baseUrl = apiClient.getBaseURL();
    String path = url.startsWith(baseUrl) ? url.substring(baseUrl.length()) : url;
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
