/*
 * Kestra EE
 * All API operations allow an optional tenant identifier in the HTTP path, if you don't use multi-tenancy you must omit the tenant identifier.<br/> This means that, for example, when trying to access the Flows API, instead of using <code>/api/v1/{tenant}/flows</code> you must use <code>/api/v1/flows</code>.
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

import io.kestra.sdk.model.BlueprintControllerApiBlueprintItemWithSource;
import io.kestra.sdk.model.BlueprintControllerKind;
import io.kestra.sdk.model.BlueprintWithFlow;
import io.kestra.sdk.model.PagedResultsBlueprint;
import io.kestra.sdk.model.PagedResultsBlueprintControllerApiBlueprintItem;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-05T07:35:23.657005690Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class BlueprintsApi extends BaseApi {

  public BlueprintsApi() {
    super(Configuration.getDefaultApiClient());
  }

  public BlueprintsApi(ApiClient apiClient) {
    super(apiClient);
  }

  /**
   * Create a new internal blueprint
   *
   * @param tenant  (required)
   * @param blueprintControllerApiBlueprintItemWithSource The internal blueprint to create (required)
   * @return BlueprintControllerApiBlueprintItemWithSource
   * @throws ApiException if fails to make API call
   */
  public BlueprintControllerApiBlueprintItemWithSource createInternalBlueprints(@javax.annotation.Nonnull String tenant, @javax.annotation.Nonnull BlueprintControllerApiBlueprintItemWithSource blueprintControllerApiBlueprintItemWithSource) throws ApiException {
    return this.createInternalBlueprints(tenant, blueprintControllerApiBlueprintItemWithSource, Collections.emptyMap());
  }


  /**
   * Create a new internal blueprint
   *
   * @param tenant  (required)
   * @param blueprintControllerApiBlueprintItemWithSource The internal blueprint to create (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return BlueprintControllerApiBlueprintItemWithSource
   * @throws ApiException if fails to make API call
   */
  public BlueprintControllerApiBlueprintItemWithSource createInternalBlueprints(@javax.annotation.Nonnull String tenant, @javax.annotation.Nonnull BlueprintControllerApiBlueprintItemWithSource blueprintControllerApiBlueprintItemWithSource, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = blueprintControllerApiBlueprintItemWithSource;

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling createInternalBlueprints");
    }

    // verify the required parameter 'blueprintControllerApiBlueprintItemWithSource' is set
    if (blueprintControllerApiBlueprintItemWithSource == null) {
      throw new ApiException(400, "Missing the required parameter 'blueprintControllerApiBlueprintItemWithSource' when calling createInternalBlueprints");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/custom"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<BlueprintControllerApiBlueprintItemWithSource> localVarReturnType = new TypeReference<BlueprintControllerApiBlueprintItemWithSource>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "POST",
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
   * Delete an internal blueprint
   *
   * @param id The internal blueprint id to delete (required)
   * @param tenant  (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteInternalBlueprints(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String tenant) throws ApiException {
    this.deleteInternalBlueprints(id, tenant, Collections.emptyMap());
  }


  /**
   * Delete an internal blueprint
   *
   * @param id The internal blueprint id to delete (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void deleteInternalBlueprints(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteInternalBlueprints");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling deleteInternalBlueprints");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/custom/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(apiClient.parameterToString(id)))
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

    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {

    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

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
   * Get a blueprint
   *
   * @param id The blueprint id (required)
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @return BlueprintControllerApiBlueprintItemWithSource
   * @throws ApiException if fails to make API call
   */
  public BlueprintControllerApiBlueprintItemWithSource getBlueprint(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.getBlueprint(id, kind, tenant, Collections.emptyMap());
  }


  /**
   * Get a blueprint
   *
   * @param id The blueprint id (required)
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return BlueprintControllerApiBlueprintItemWithSource
   * @throws ApiException if fails to make API call
   */
  public BlueprintControllerApiBlueprintItemWithSource getBlueprint(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getBlueprint");
    }

    // verify the required parameter 'kind' is set
    if (kind == null) {
      throw new ApiException(400, "Missing the required parameter 'kind' when calling getBlueprint");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling getBlueprint");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/community/{kind}/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(apiClient.parameterToString(id)))
      .replaceAll("\\{" + "kind" + "\\}", apiClient.escapeString(apiClient.parameterToString(kind)))
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

    String[] localVarAuthNames = new String[] {  };

    TypeReference<BlueprintControllerApiBlueprintItemWithSource> localVarReturnType = new TypeReference<BlueprintControllerApiBlueprintItemWithSource>() {};
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
   * Get a blueprint graph
   *
   * @param id The blueprint id (required)
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @return Map&lt;String, Object&gt;
   * @throws ApiException if fails to make API call
   */
  public Map<String, Object> getBlueprintGraph(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.getBlueprintGraph(id, kind, tenant, Collections.emptyMap());
  }


  /**
   * Get a blueprint graph
   *
   * @param id The blueprint id (required)
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return Map&lt;String, Object&gt;
   * @throws ApiException if fails to make API call
   */
  public Map<String, Object> getBlueprintGraph(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getBlueprintGraph");
    }

    // verify the required parameter 'kind' is set
    if (kind == null) {
      throw new ApiException(400, "Missing the required parameter 'kind' when calling getBlueprintGraph");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling getBlueprintGraph");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/community/{kind}/{id}/graph"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(apiClient.parameterToString(id)))
      .replaceAll("\\{" + "kind" + "\\}", apiClient.escapeString(apiClient.parameterToString(kind)))
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

    String[] localVarAuthNames = new String[] {  };

    TypeReference<Map<String, Object>> localVarReturnType = new TypeReference<Map<String, Object>>() {};
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
   * Get a blueprint source code
   *
   * @param id The blueprint id (required)
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String getBlueprintSource(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.getBlueprintSource(id, kind, tenant, Collections.emptyMap());
  }


  /**
   * Get a blueprint source code
   *
   * @param id The blueprint id (required)
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String getBlueprintSource(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getBlueprintSource");
    }

    // verify the required parameter 'kind' is set
    if (kind == null) {
      throw new ApiException(400, "Missing the required parameter 'kind' when calling getBlueprintSource");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling getBlueprintSource");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/community/{kind}/{id}/source"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(apiClient.parameterToString(id)))
      .replaceAll("\\{" + "kind" + "\\}", apiClient.escapeString(apiClient.parameterToString(kind)))
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
      "application/yaml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {

    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<String> localVarReturnType = new TypeReference<String>() {};
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
   * Get an internal blueprint
   *
   * @param id The blueprint id (required)
   * @param tenant  (required)
   * @return BlueprintControllerApiBlueprintItemWithSource
   * @throws ApiException if fails to make API call
   */
  public BlueprintControllerApiBlueprintItemWithSource internalBlueprint(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.internalBlueprint(id, tenant, Collections.emptyMap());
  }


  /**
   * Get an internal blueprint
   *
   * @param id The blueprint id (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return BlueprintControllerApiBlueprintItemWithSource
   * @throws ApiException if fails to make API call
   */
  public BlueprintControllerApiBlueprintItemWithSource internalBlueprint(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling internalBlueprint");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling internalBlueprint");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/custom/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(apiClient.parameterToString(id)))
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

    String[] localVarAuthNames = new String[] {  };

    TypeReference<BlueprintControllerApiBlueprintItemWithSource> localVarReturnType = new TypeReference<BlueprintControllerApiBlueprintItemWithSource>() {};
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
   * Get an internal blueprint source code
   *
   * @param id The blueprint id (required)
   * @param tenant  (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String internalBlueprintFlow(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.internalBlueprintFlow(id, tenant, Collections.emptyMap());
  }


  /**
   * Get an internal blueprint source code
   *
   * @param id The blueprint id (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String internalBlueprintFlow(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling internalBlueprintFlow");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling internalBlueprintFlow");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/custom/{id}/source"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(apiClient.parameterToString(id)))
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
      "application/yaml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {

    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<String> localVarReturnType = new TypeReference<String>() {};
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
   * List all blueprints
   *
   * @param page The current page (required)
   * @param size The current page size (required)
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @param q A string filter (optional)
   * @param sort The sort of current page (optional)
   * @param tags A tags filter (optional)
   * @return PagedResultsBlueprintControllerApiBlueprintItem
   * @throws ApiException if fails to make API call
   */
  public PagedResultsBlueprintControllerApiBlueprintItem searchBlueprints(@javax.annotation.Nonnull Integer page, @javax.annotation.Nonnull Integer size, @javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String q, @javax.annotation.Nullable String sort, @javax.annotation.Nullable List<String> tags) throws ApiException {
    return this.searchBlueprints(page, size, kind, tenant, q, sort, tags, Collections.emptyMap());
  }


  /**
   * List all blueprints
   *
   * @param page The current page (required)
   * @param size The current page size (required)
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @param q A string filter (optional)
   * @param sort The sort of current page (optional)
   * @param tags A tags filter (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return PagedResultsBlueprintControllerApiBlueprintItem
   * @throws ApiException if fails to make API call
   */
  public PagedResultsBlueprintControllerApiBlueprintItem searchBlueprints(@javax.annotation.Nonnull Integer page, @javax.annotation.Nonnull Integer size, @javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String q, @javax.annotation.Nullable String sort, @javax.annotation.Nullable List<String> tags, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'page' is set
    if (page == null) {
      throw new ApiException(400, "Missing the required parameter 'page' when calling searchBlueprints");
    }

    // verify the required parameter 'size' is set
    if (size == null) {
      throw new ApiException(400, "Missing the required parameter 'size' when calling searchBlueprints");
    }

    // verify the required parameter 'kind' is set
    if (kind == null) {
      throw new ApiException(400, "Missing the required parameter 'kind' when calling searchBlueprints");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling searchBlueprints");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/community/{kind}"
      .replaceAll("\\{" + "kind" + "\\}", apiClient.escapeString(apiClient.parameterToString(kind)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("q", q));
    localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "tags", tags));
    localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
    localVarQueryParams.addAll(apiClient.parameterToPair("size", size));

    localVarHeaderParams.putAll(additionalHeaders);



    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {

    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<PagedResultsBlueprintControllerApiBlueprintItem> localVarReturnType = new TypeReference<PagedResultsBlueprintControllerApiBlueprintItem>() {};
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
   * List all internal blueprints
   *
   * @param page The current page (required)
   * @param size The current page size (required)
   * @param tenant  (required)
   * @param q A string filter (optional)
   * @param sort The sort of current page (optional)
   * @param tags A tags filter (optional)
   * @return PagedResultsBlueprint
   * @throws ApiException if fails to make API call
   */
  public PagedResultsBlueprint searchInternalBlueprints(@javax.annotation.Nonnull Integer page, @javax.annotation.Nonnull Integer size, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String q, @javax.annotation.Nullable String sort, @javax.annotation.Nullable List<String> tags) throws ApiException {
    return this.searchInternalBlueprints(page, size, tenant, q, sort, tags, Collections.emptyMap());
  }


  /**
   * List all internal blueprints
   *
   * @param page The current page (required)
   * @param size The current page size (required)
   * @param tenant  (required)
   * @param q A string filter (optional)
   * @param sort The sort of current page (optional)
   * @param tags A tags filter (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return PagedResultsBlueprint
   * @throws ApiException if fails to make API call
   */
  public PagedResultsBlueprint searchInternalBlueprints(@javax.annotation.Nonnull Integer page, @javax.annotation.Nonnull Integer size, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String q, @javax.annotation.Nullable String sort, @javax.annotation.Nullable List<String> tags, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'page' is set
    if (page == null) {
      throw new ApiException(400, "Missing the required parameter 'page' when calling searchInternalBlueprints");
    }

    // verify the required parameter 'size' is set
    if (size == null) {
      throw new ApiException(400, "Missing the required parameter 'size' when calling searchInternalBlueprints");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling searchInternalBlueprints");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/custom"
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("q", q));
    localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
    localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "tags", tags));
    localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
    localVarQueryParams.addAll(apiClient.parameterToPair("size", size));

    localVarHeaderParams.putAll(additionalHeaders);



    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {

    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<PagedResultsBlueprint> localVarReturnType = new TypeReference<PagedResultsBlueprint>() {};
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
   * Update an internal blueprint
   *
   * @param id The id of the internal blueprint to update (required)
   * @param tenant  (required)
   * @param blueprintControllerApiBlueprintItemWithSource The new internal blueprint for update (required)
   * @return BlueprintWithFlow
   * @throws ApiException if fails to make API call
   */
  public BlueprintWithFlow updateInternalBlueprints(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String tenant, @javax.annotation.Nonnull BlueprintControllerApiBlueprintItemWithSource blueprintControllerApiBlueprintItemWithSource) throws ApiException {
    return this.updateInternalBlueprints(id, tenant, blueprintControllerApiBlueprintItemWithSource, Collections.emptyMap());
  }


  /**
   * Update an internal blueprint
   *
   * @param id The id of the internal blueprint to update (required)
   * @param tenant  (required)
   * @param blueprintControllerApiBlueprintItemWithSource The new internal blueprint for update (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return BlueprintWithFlow
   * @throws ApiException if fails to make API call
   */
  public BlueprintWithFlow updateInternalBlueprints(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String tenant, @javax.annotation.Nonnull BlueprintControllerApiBlueprintItemWithSource blueprintControllerApiBlueprintItemWithSource, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = blueprintControllerApiBlueprintItemWithSource;

    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateInternalBlueprints");
    }

    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling updateInternalBlueprints");
    }

    // verify the required parameter 'blueprintControllerApiBlueprintItemWithSource' is set
    if (blueprintControllerApiBlueprintItemWithSource == null) {
      throw new ApiException(400, "Missing the required parameter 'blueprintControllerApiBlueprintItemWithSource' when calling updateInternalBlueprints");
    }

    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/custom/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(apiClient.parameterToString(id)))
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<BlueprintWithFlow> localVarReturnType = new TypeReference<BlueprintWithFlow>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "PUT",
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

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
