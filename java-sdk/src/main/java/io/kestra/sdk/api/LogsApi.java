/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 * The version of the OpenAPI document: v1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package io.kestra.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.BaseApi;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.Pair;

import io.kestra.sdk.model.EventLogEntry;
import java.io.File;
import io.kestra.sdk.model.Level;
import io.kestra.sdk.model.LogEntry;
import java.time.OffsetDateTime;
import io.kestra.sdk.model.PagedResultsLogEntry;
import io.kestra.sdk.model.QueryFilter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class LogsApi extends BaseApi {

  public LogsApi() {
    super(Configuration.getDefaultApiClient());
  }

  public LogsApi(ApiClient apiClient) {
    super(apiClient);
  }

  /**
   * Delete logs for a specific execution, taskrun or task
   * 
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param minLevel The min log level filter (optional)
   * @param taskRunId The taskrun id (optional)
   * @param taskId The task id (optional)
   * @param attempt The attempt number (optional)
   * @throws ApiException if fails to make API call
   */
  public void deleteLogsFromExecution(@javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable Level minLevel, @javax.annotation.Nullable String taskRunId, @javax.annotation.Nullable String taskId, @javax.annotation.Nullable Integer attempt) throws ApiException {
    this.deleteLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt, Collections.emptyMap());
  }


  /**
   * Delete logs for a specific execution, taskrun or task
   * 
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param minLevel The min log level filter (optional)
   * @param taskRunId The taskrun id (optional)
   * @param taskId The task id (optional)
   * @param attempt The attempt number (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void deleteLogsFromExecution(@javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable Level minLevel, @javax.annotation.Nullable String taskRunId, @javax.annotation.Nullable String taskId, @javax.annotation.Nullable Integer attempt, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'executionId' is set
    if (executionId == null) {
      throw new ApiException(400, "Missing the required parameter 'executionId' when calling deleteLogsFromExecution");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling deleteLogsFromExecution");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/logs/{executionId}"
      .replaceAll("\\{" + "executionId" + "\\}", apiClient.escapeString(apiClient.parameterToString(executionId)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("minLevel", minLevel));
    localVarQueryParams.addAll(apiClient.parameterToPair("taskRunId", taskRunId));
    localVarQueryParams.addAll(apiClient.parameterToPair("taskId", taskId));
    localVarQueryParams.addAll(apiClient.parameterToPair("attempt", attempt));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    apiClient.invokeAPI(
        localVarPath,
        "DELETE",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        null
    );
  }

  /**
   * Delete logs for a specific execution, taskrun or task
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow identifier (required)
   * @param triggerId The trigger id (required)
   * @param tenant  (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteLogsFromFlow(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String triggerId, @javax.annotation.Nonnull String tenant) throws ApiException {
    this.deleteLogsFromFlow(namespace, flowId, triggerId, tenant, Collections.emptyMap());
  }


  /**
   * Delete logs for a specific execution, taskrun or task
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow identifier (required)
   * @param triggerId The trigger id (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void deleteLogsFromFlow(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String triggerId, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling deleteLogsFromFlow");
    }
    
    // verify the required parameter 'flowId' is set
    if (flowId == null) {
      throw new ApiException(400, "Missing the required parameter 'flowId' when calling deleteLogsFromFlow");
    }
    
    // verify the required parameter 'triggerId' is set
    if (triggerId == null) {
      throw new ApiException(400, "Missing the required parameter 'triggerId' when calling deleteLogsFromFlow");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling deleteLogsFromFlow");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/logs/{namespace}/{flowId}"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "flowId" + "\\}", apiClient.escapeString(apiClient.parameterToString(flowId)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("triggerId", triggerId));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    apiClient.invokeAPI(
        localVarPath,
        "DELETE",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        null
    );
  }

  /**
   * Download logs for a specific execution, taskrun or task
   * 
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param minLevel The min log level filter (optional)
   * @param taskRunId The taskrun id (optional)
   * @param taskId The task id (optional)
   * @param attempt The attempt number (optional)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File downloadLogsFromExecution(@javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable Level minLevel, @javax.annotation.Nullable String taskRunId, @javax.annotation.Nullable String taskId, @javax.annotation.Nullable Integer attempt) throws ApiException {
    return this.downloadLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt, Collections.emptyMap());
  }


  /**
   * Download logs for a specific execution, taskrun or task
   * 
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param minLevel The min log level filter (optional)
   * @param taskRunId The taskrun id (optional)
   * @param taskId The task id (optional)
   * @param attempt The attempt number (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File downloadLogsFromExecution(@javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable Level minLevel, @javax.annotation.Nullable String taskRunId, @javax.annotation.Nullable String taskId, @javax.annotation.Nullable Integer attempt, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'executionId' is set
    if (executionId == null) {
      throw new ApiException(400, "Missing the required parameter 'executionId' when calling downloadLogsFromExecution");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling downloadLogsFromExecution");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/logs/{executionId}/download"
      .replaceAll("\\{" + "executionId" + "\\}", apiClient.escapeString(apiClient.parameterToString(executionId)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("minLevel", minLevel));
    localVarQueryParams.addAll(apiClient.parameterToPair("taskRunId", taskRunId));
    localVarQueryParams.addAll(apiClient.parameterToPair("taskId", taskId));
    localVarQueryParams.addAll(apiClient.parameterToPair("attempt", attempt));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "text/plain"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<File> localVarReturnType = new TypeReference<File>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

  /**
   * Follow logs for a specific execution
   * 
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param minLevel The min log level filter (optional)
   * @return EventLogEntry
   * @throws ApiException if fails to make API call
   */
  public EventLogEntry followLogsFromExecution(@javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable Level minLevel) throws ApiException {
    return this.followLogsFromExecution(executionId, tenant, minLevel, Collections.emptyMap());
  }


  /**
   * Follow logs for a specific execution
   * 
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param minLevel The min log level filter (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return EventLogEntry
   * @throws ApiException if fails to make API call
   */
  public EventLogEntry followLogsFromExecution(@javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable Level minLevel, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'executionId' is set
    if (executionId == null) {
      throw new ApiException(400, "Missing the required parameter 'executionId' when calling followLogsFromExecution");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling followLogsFromExecution");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/logs/{executionId}/follow"
      .replaceAll("\\{" + "executionId" + "\\}", apiClient.escapeString(apiClient.parameterToString(executionId)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("minLevel", minLevel));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "text/event-stream"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<EventLogEntry> localVarReturnType = new TypeReference<EventLogEntry>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

  /**
   * Get logs for a specific execution, taskrun or task
   * 
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param minLevel The min log level filter (optional)
   * @param taskRunId The taskrun id (optional)
   * @param taskId The task id (optional)
   * @param attempt The attempt number (optional)
   * @return List&lt;LogEntry&gt;
   * @throws ApiException if fails to make API call
   */
  public List<LogEntry> listLogsFromExecution(@javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable Level minLevel, @javax.annotation.Nullable String taskRunId, @javax.annotation.Nullable String taskId, @javax.annotation.Nullable Integer attempt) throws ApiException {
    return this.listLogsFromExecution(executionId, tenant, minLevel, taskRunId, taskId, attempt, Collections.emptyMap());
  }


  /**
   * Get logs for a specific execution, taskrun or task
   * 
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param minLevel The min log level filter (optional)
   * @param taskRunId The taskrun id (optional)
   * @param taskId The task id (optional)
   * @param attempt The attempt number (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;LogEntry&gt;
   * @throws ApiException if fails to make API call
   */
  public List<LogEntry> listLogsFromExecution(@javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable Level minLevel, @javax.annotation.Nullable String taskRunId, @javax.annotation.Nullable String taskId, @javax.annotation.Nullable Integer attempt, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'executionId' is set
    if (executionId == null) {
      throw new ApiException(400, "Missing the required parameter 'executionId' when calling listLogsFromExecution");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling listLogsFromExecution");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/logs/{executionId}"
      .replaceAll("\\{" + "executionId" + "\\}", apiClient.escapeString(apiClient.parameterToString(executionId)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("minLevel", minLevel));
    localVarQueryParams.addAll(apiClient.parameterToPair("taskRunId", taskRunId));
    localVarQueryParams.addAll(apiClient.parameterToPair("taskId", taskId));
    localVarQueryParams.addAll(apiClient.parameterToPair("attempt", attempt));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<List<LogEntry>> localVarReturnType = new TypeReference<List<LogEntry>>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

  /**
   * Search for logs
   * 
   * @param page The current page (required)
   * @param size The current page size (required)
   * @param tenant  (required)
   * @param sort The sort of current page (optional)
   * @param filters Filters (optional)
   * @param q A string filter (optional)
   * @param namespace A namespace filter prefix (optional)
   * @param flowId A flow id filter (optional)
   * @param triggerId A trigger id filter (optional)
   * @param minLevel The min log level filter (optional)
   * @param startDate The start datetime (optional)
   * @param endDate The end datetime (optional)
   * @return PagedResultsLogEntry
   * @throws ApiException if fails to make API call
   */
  public PagedResultsLogEntry searchLogs(@javax.annotation.Nonnull Integer page, @javax.annotation.Nonnull Integer size, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable List<String> sort, @javax.annotation.Nullable List<QueryFilter> filters, @javax.annotation.Nullable String q, @javax.annotation.Nullable String namespace, @javax.annotation.Nullable String flowId, @javax.annotation.Nullable String triggerId, @javax.annotation.Nullable Level minLevel, @javax.annotation.Nullable OffsetDateTime startDate, @javax.annotation.Nullable OffsetDateTime endDate) throws ApiException {
    return this.searchLogs(page, size, tenant, sort, filters, q, namespace, flowId, triggerId, minLevel, startDate, endDate, Collections.emptyMap());
  }


  /**
   * Search for logs
   * 
   * @param page The current page (required)
   * @param size The current page size (required)
   * @param tenant  (required)
   * @param sort The sort of current page (optional)
   * @param filters Filters (optional)
   * @param q A string filter (optional)
   * @param namespace A namespace filter prefix (optional)
   * @param flowId A flow id filter (optional)
   * @param triggerId A trigger id filter (optional)
   * @param minLevel The min log level filter (optional)
   * @param startDate The start datetime (optional)
   * @param endDate The end datetime (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return PagedResultsLogEntry
   * @throws ApiException if fails to make API call
   */
  public PagedResultsLogEntry searchLogs(@javax.annotation.Nonnull Integer page, @javax.annotation.Nonnull Integer size, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable List<String> sort, @javax.annotation.Nullable List<QueryFilter> filters, @javax.annotation.Nullable String q, @javax.annotation.Nullable String namespace, @javax.annotation.Nullable String flowId, @javax.annotation.Nullable String triggerId, @javax.annotation.Nullable Level minLevel, @javax.annotation.Nullable OffsetDateTime startDate, @javax.annotation.Nullable OffsetDateTime endDate, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'page' is set
    if (page == null) {
      throw new ApiException(400, "Missing the required parameter 'page' when calling searchLogs");
    }
    
    // verify the required parameter 'size' is set
    if (size == null) {
      throw new ApiException(400, "Missing the required parameter 'size' when calling searchLogs");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling searchLogs");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/logs/search"
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
    localVarQueryParams.addAll(apiClient.parameterToPair("size", size));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filters", filters));
    localVarQueryParams.addAll(apiClient.parameterToPair("q", q));
    localVarQueryParams.addAll(apiClient.parameterToPair("namespace", namespace));
    localVarQueryParams.addAll(apiClient.parameterToPair("flowId", flowId));
    localVarQueryParams.addAll(apiClient.parameterToPair("triggerId", triggerId));
    localVarQueryParams.addAll(apiClient.parameterToPair("minLevel", minLevel));
    localVarQueryParams.addAll(apiClient.parameterToPair("startDate", startDate));
    localVarQueryParams.addAll(apiClient.parameterToPair("endDate", endDate));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<PagedResultsLogEntry> localVarReturnType = new TypeReference<PagedResultsLogEntry>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

  @Override
  public <T> T invokeAPI(String url, String method, Object request, TypeReference<T> returnType, Map<String, String> additionalHeaders) throws ApiException {
    String localVarPath = url.replace(apiClient.getBaseURL(), "");
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarHeaderParams.putAll(additionalHeaders);

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    return apiClient.invokeAPI(
      localVarPath,
        method,
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        request,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        returnType
    );
  }
}
