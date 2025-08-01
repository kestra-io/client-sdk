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

import io.kestra.sdk.model.MetricAggregations;
import java.time.OffsetDateTime;
import io.kestra.sdk.model.PagedResultsMetricEntry;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class MetricsApi extends BaseApi {

  public MetricsApi() {
    super(Configuration.getDefaultApiClient());
  }

  public MetricsApi(ApiClient apiClient) {
    super(apiClient);
  }

  /**
   * Get metrics aggregations for a specific flow
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param metric The metric name (required)
   * @param aggregation The type of aggregation: avg, sum, min or max (required)
   * @param tenant  (required)
   * @param startDate The start datetime, default to now - 30 days (optional)
   * @param endDate The end datetime, default to now (optional)
   * @return MetricAggregations
   * @throws ApiException if fails to make API call
   */
  public MetricAggregations aggregateMetricsFromFlow(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String metric, @javax.annotation.Nonnull String aggregation, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable OffsetDateTime startDate, @javax.annotation.Nullable OffsetDateTime endDate) throws ApiException {
    return this.aggregateMetricsFromFlow(namespace, flowId, metric, aggregation, tenant, startDate, endDate, Collections.emptyMap());
  }


  /**
   * Get metrics aggregations for a specific flow
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param metric The metric name (required)
   * @param aggregation The type of aggregation: avg, sum, min or max (required)
   * @param tenant  (required)
   * @param startDate The start datetime, default to now - 30 days (optional)
   * @param endDate The end datetime, default to now (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return MetricAggregations
   * @throws ApiException if fails to make API call
   */
  public MetricAggregations aggregateMetricsFromFlow(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String metric, @javax.annotation.Nonnull String aggregation, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable OffsetDateTime startDate, @javax.annotation.Nullable OffsetDateTime endDate, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling aggregateMetricsFromFlow");
    }
    
    // verify the required parameter 'flowId' is set
    if (flowId == null) {
      throw new ApiException(400, "Missing the required parameter 'flowId' when calling aggregateMetricsFromFlow");
    }
    
    // verify the required parameter 'metric' is set
    if (metric == null) {
      throw new ApiException(400, "Missing the required parameter 'metric' when calling aggregateMetricsFromFlow");
    }
    
    // verify the required parameter 'aggregation' is set
    if (aggregation == null) {
      throw new ApiException(400, "Missing the required parameter 'aggregation' when calling aggregateMetricsFromFlow");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling aggregateMetricsFromFlow");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{metric}"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "flowId" + "\\}", apiClient.escapeString(apiClient.parameterToString(flowId)))
      .replaceAll("\\{" + "metric" + "\\}", apiClient.escapeString(apiClient.parameterToString(metric)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("startDate", startDate));
    localVarQueryParams.addAll(apiClient.parameterToPair("endDate", endDate));
    localVarQueryParams.addAll(apiClient.parameterToPair("aggregation", aggregation));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<MetricAggregations> localVarReturnType = new TypeReference<MetricAggregations>() {};
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
   * Get metrics aggregations for a specific flow
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param taskId The task Id (required)
   * @param metric The metric name (required)
   * @param aggregation The type of aggregation: avg, sum, min or max (required)
   * @param tenant  (required)
   * @param startDate The start datetime, default to now - 30 days (optional)
   * @param endDate The end datetime, default to now (optional)
   * @return MetricAggregations
   * @throws ApiException if fails to make API call
   */
  public MetricAggregations aggregateMetricsFromTask(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String taskId, @javax.annotation.Nonnull String metric, @javax.annotation.Nonnull String aggregation, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable OffsetDateTime startDate, @javax.annotation.Nullable OffsetDateTime endDate) throws ApiException {
    return this.aggregateMetricsFromTask(namespace, flowId, taskId, metric, aggregation, tenant, startDate, endDate, Collections.emptyMap());
  }


  /**
   * Get metrics aggregations for a specific flow
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param taskId The task Id (required)
   * @param metric The metric name (required)
   * @param aggregation The type of aggregation: avg, sum, min or max (required)
   * @param tenant  (required)
   * @param startDate The start datetime, default to now - 30 days (optional)
   * @param endDate The end datetime, default to now (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return MetricAggregations
   * @throws ApiException if fails to make API call
   */
  public MetricAggregations aggregateMetricsFromTask(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String taskId, @javax.annotation.Nonnull String metric, @javax.annotation.Nonnull String aggregation, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable OffsetDateTime startDate, @javax.annotation.Nullable OffsetDateTime endDate, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling aggregateMetricsFromTask");
    }
    
    // verify the required parameter 'flowId' is set
    if (flowId == null) {
      throw new ApiException(400, "Missing the required parameter 'flowId' when calling aggregateMetricsFromTask");
    }
    
    // verify the required parameter 'taskId' is set
    if (taskId == null) {
      throw new ApiException(400, "Missing the required parameter 'taskId' when calling aggregateMetricsFromTask");
    }
    
    // verify the required parameter 'metric' is set
    if (metric == null) {
      throw new ApiException(400, "Missing the required parameter 'metric' when calling aggregateMetricsFromTask");
    }
    
    // verify the required parameter 'aggregation' is set
    if (aggregation == null) {
      throw new ApiException(400, "Missing the required parameter 'aggregation' when calling aggregateMetricsFromTask");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling aggregateMetricsFromTask");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{taskId}/{metric}"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "flowId" + "\\}", apiClient.escapeString(apiClient.parameterToString(flowId)))
      .replaceAll("\\{" + "taskId" + "\\}", apiClient.escapeString(apiClient.parameterToString(taskId)))
      .replaceAll("\\{" + "metric" + "\\}", apiClient.escapeString(apiClient.parameterToString(metric)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("startDate", startDate));
    localVarQueryParams.addAll(apiClient.parameterToPair("endDate", endDate));
    localVarQueryParams.addAll(apiClient.parameterToPair("aggregation", aggregation));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<MetricAggregations> localVarReturnType = new TypeReference<MetricAggregations>() {};
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
   * Get metrics names for a specific flow
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param tenant  (required)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> listFlowMetrics(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.listFlowMetrics(namespace, flowId, tenant, Collections.emptyMap());
  }


  /**
   * Get metrics names for a specific flow
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> listFlowMetrics(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling listFlowMetrics");
    }
    
    // verify the required parameter 'flowId' is set
    if (flowId == null) {
      throw new ApiException(400, "Missing the required parameter 'flowId' when calling listFlowMetrics");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling listFlowMetrics");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/metrics/names/{namespace}/{flowId}"
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

    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<List<String>> localVarReturnType = new TypeReference<List<String>>() {};
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
   * Get metrics names for a specific task in a flow
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param taskId The task Id (required)
   * @param tenant  (required)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> listTaskMetrics(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String taskId, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.listTaskMetrics(namespace, flowId, taskId, tenant, Collections.emptyMap());
  }


  /**
   * Get metrics names for a specific task in a flow
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param taskId The task Id (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> listTaskMetrics(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String taskId, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling listTaskMetrics");
    }
    
    // verify the required parameter 'flowId' is set
    if (flowId == null) {
      throw new ApiException(400, "Missing the required parameter 'flowId' when calling listTaskMetrics");
    }
    
    // verify the required parameter 'taskId' is set
    if (taskId == null) {
      throw new ApiException(400, "Missing the required parameter 'taskId' when calling listTaskMetrics");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling listTaskMetrics");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/metrics/names/{namespace}/{flowId}/{taskId}"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "flowId" + "\\}", apiClient.escapeString(apiClient.parameterToString(flowId)))
      .replaceAll("\\{" + "taskId" + "\\}", apiClient.escapeString(apiClient.parameterToString(taskId)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
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

    TypeReference<List<String>> localVarReturnType = new TypeReference<List<String>>() {};
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
   * Get tasks id that have metrics for a specific flow, include deleted or renamed tasks
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param tenant  (required)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> listTasksWithMetrics(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.listTasksWithMetrics(namespace, flowId, tenant, Collections.emptyMap());
  }


  /**
   * Get tasks id that have metrics for a specific flow, include deleted or renamed tasks
   * 
   * @param namespace The namespace (required)
   * @param flowId The flow Id (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> listTasksWithMetrics(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String flowId, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling listTasksWithMetrics");
    }
    
    // verify the required parameter 'flowId' is set
    if (flowId == null) {
      throw new ApiException(400, "Missing the required parameter 'flowId' when calling listTasksWithMetrics");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling listTasksWithMetrics");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/metrics/tasks/{namespace}/{flowId}"
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

    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<List<String>> localVarReturnType = new TypeReference<List<String>>() {};
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
   * Get metrics for a specific execution
   * 
   * @param page The current page (required)
   * @param size The current page size (required)
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param sort The sort of current page (optional)
   * @param taskRunId The taskrun id (optional)
   * @param taskId The task id (optional)
   * @return PagedResultsMetricEntry
   * @throws ApiException if fails to make API call
   */
  public PagedResultsMetricEntry searchByExecution(@javax.annotation.Nonnull Integer page, @javax.annotation.Nonnull Integer size, @javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable List<String> sort, @javax.annotation.Nullable String taskRunId, @javax.annotation.Nullable String taskId) throws ApiException {
    return this.searchByExecution(page, size, executionId, tenant, sort, taskRunId, taskId, Collections.emptyMap());
  }


  /**
   * Get metrics for a specific execution
   * 
   * @param page The current page (required)
   * @param size The current page size (required)
   * @param executionId The execution id (required)
   * @param tenant  (required)
   * @param sort The sort of current page (optional)
   * @param taskRunId The taskrun id (optional)
   * @param taskId The task id (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return PagedResultsMetricEntry
   * @throws ApiException if fails to make API call
   */
  public PagedResultsMetricEntry searchByExecution(@javax.annotation.Nonnull Integer page, @javax.annotation.Nonnull Integer size, @javax.annotation.Nonnull String executionId, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable List<String> sort, @javax.annotation.Nullable String taskRunId, @javax.annotation.Nullable String taskId, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'page' is set
    if (page == null) {
      throw new ApiException(400, "Missing the required parameter 'page' when calling searchByExecution");
    }
    
    // verify the required parameter 'size' is set
    if (size == null) {
      throw new ApiException(400, "Missing the required parameter 'size' when calling searchByExecution");
    }
    
    // verify the required parameter 'executionId' is set
    if (executionId == null) {
      throw new ApiException(400, "Missing the required parameter 'executionId' when calling searchByExecution");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling searchByExecution");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/metrics/{executionId}"
      .replaceAll("\\{" + "executionId" + "\\}", apiClient.escapeString(apiClient.parameterToString(executionId)))
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
    localVarQueryParams.addAll(apiClient.parameterToPair("taskRunId", taskRunId));
    localVarQueryParams.addAll(apiClient.parameterToPair("taskId", taskId));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<PagedResultsMetricEntry> localVarReturnType = new TypeReference<PagedResultsMetricEntry>() {};
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
