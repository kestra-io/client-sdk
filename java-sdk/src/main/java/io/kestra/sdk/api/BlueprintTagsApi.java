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

import io.kestra.sdk.model.BlueprintControllerApiBlueprintTagItem;
import io.kestra.sdk.model.BlueprintControllerKind;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class BlueprintTagsApi extends BaseApi {

  public BlueprintTagsApi() {
    super(Configuration.getDefaultApiClient());
  }

  public BlueprintTagsApi(ApiClient apiClient) {
    super(apiClient);
  }

  /**
   * List all internal blueprint tags
   * Lists all tags used by internal (custom) blueprints for the current tenant.
   * @param tenant  (required)
   * @param q A string filter to get tags with matching blueprints only (optional)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> internalBlueprintTags(@javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String q) throws ApiException {
    return this.internalBlueprintTags(tenant, q, Collections.emptyMap());
  }


  /**
   * List all internal blueprint tags
   * Lists all tags used by internal (custom) blueprints for the current tenant.
   * @param tenant  (required)
   * @param q A string filter to get tags with matching blueprints only (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> internalBlueprintTags(@javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String q, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling internalBlueprintTags");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/custom/tags"
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("q", q));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

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
   * List blueprint tags matching the filter
   * Lists tags for community blueprints of the specified kind, optionally filtered by query.
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @param q A string filter to get tags with matching blueprints only (optional)
   * @return List&lt;BlueprintControllerApiBlueprintTagItem&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BlueprintControllerApiBlueprintTagItem> listBlueprintTags(@javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String q) throws ApiException {
    return this.listBlueprintTags(kind, tenant, q, Collections.emptyMap());
  }


  /**
   * List blueprint tags matching the filter
   * Lists tags for community blueprints of the specified kind, optionally filtered by query.
   * @param kind The blueprint kind (required)
   * @param tenant  (required)
   * @param q A string filter to get tags with matching blueprints only (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;BlueprintControllerApiBlueprintTagItem&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BlueprintControllerApiBlueprintTagItem> listBlueprintTags(@javax.annotation.Nonnull BlueprintControllerKind kind, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String q, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'kind' is set
    if (kind == null) {
      throw new ApiException(400, "Missing the required parameter 'kind' when calling listBlueprintTags");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling listBlueprintTags");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/blueprints/community/{kind}/tags"
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
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    TypeReference<List<BlueprintControllerApiBlueprintTagItem>> localVarReturnType = new TypeReference<List<BlueprintControllerApiBlueprintTagItem>>() {};
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
