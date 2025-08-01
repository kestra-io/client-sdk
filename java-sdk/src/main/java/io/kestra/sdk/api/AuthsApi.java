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

import io.kestra.sdk.model.AuthControllerAuth;
import io.kestra.sdk.model.CreateApiTokenRequest;
import io.kestra.sdk.model.MeControllerApiMe;
import io.kestra.sdk.model.MeControllerApiUserDetailsRequest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class AuthsApi extends BaseApi {

  public AuthsApi() {
    super(Configuration.getDefaultApiClient());
  }

  public AuthsApi(ApiClient apiClient) {
    super(apiClient);
  }

  /**
   * Create API token for the authenticated user
   * 
   * @param createApiTokenRequest  (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object createApiTokenForCurrentUser(@javax.annotation.Nonnull CreateApiTokenRequest createApiTokenRequest) throws ApiException {
    return this.createApiTokenForCurrentUser(createApiTokenRequest, Collections.emptyMap());
  }


  /**
   * Create API token for the authenticated user
   * 
   * @param createApiTokenRequest  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object createApiTokenForCurrentUser(@javax.annotation.Nonnull CreateApiTokenRequest createApiTokenRequest, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = createApiTokenRequest;
    
    // verify the required parameter 'createApiTokenRequest' is set
    if (createApiTokenRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'createApiTokenRequest' when calling createApiTokenForCurrentUser");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/me/api-tokens";

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

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
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
   * Delete API token for the authenticated user
   * 
   * @param tokenId The token id (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object deleteApiTokenForCurrentUser(@javax.annotation.Nonnull String tokenId) throws ApiException {
    return this.deleteApiTokenForCurrentUser(tokenId, Collections.emptyMap());
  }


  /**
   * Delete API token for the authenticated user
   * 
   * @param tokenId The token id (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object deleteApiTokenForCurrentUser(@javax.annotation.Nonnull String tokenId, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'tokenId' is set
    if (tokenId == null) {
      throw new ApiException(400, "Missing the required parameter 'tokenId' when calling deleteApiTokenForCurrentUser");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/me/api-tokens/{tokenId}"
      .replaceAll("\\{" + "tokenId" + "\\}", apiClient.escapeString(apiClient.parameterToString(tokenId)));

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

    TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
    return apiClient.invokeAPI(
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
        localVarReturnType
    );
  }

  /**
   * Get details about the authenticated user
   * Requires the ME permission.
   * @return MeControllerApiMe
   * @throws ApiException if fails to make API call
   */
  public MeControllerApiMe getCurrentUser() throws ApiException {
    return this.getCurrentUser(Collections.emptyMap());
  }


  /**
   * Get details about the authenticated user
   * Requires the ME permission.
   * @param additionalHeaders additionalHeaders for this call
   * @return MeControllerApiMe
   * @throws ApiException if fails to make API call
   */
  public MeControllerApiMe getCurrentUser(Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v1/me";

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

    TypeReference<MeControllerApiMe> localVarReturnType = new TypeReference<MeControllerApiMe>() {};
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
   * Retrieve list of authentication methods
   * 
   * @return AuthControllerAuth
   * @throws ApiException if fails to make API call
   */
  public AuthControllerAuth index() throws ApiException {
    return this.index(Collections.emptyMap());
  }


  /**
   * Retrieve list of authentication methods
   * 
   * @param additionalHeaders additionalHeaders for this call
   * @return AuthControllerAuth
   * @throws ApiException if fails to make API call
   */
  public AuthControllerAuth index(Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v1/auths";

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

    TypeReference<AuthControllerAuth> localVarReturnType = new TypeReference<AuthControllerAuth>() {};
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
   * List API tokens for authenticated user
   * Returns all API tokens belonging to the authenticated user.
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object listApiTokensForCurrentUser() throws ApiException {
    return this.listApiTokensForCurrentUser(Collections.emptyMap());
  }


  /**
   * List API tokens for authenticated user
   * Returns all API tokens belonging to the authenticated user.
   * @param additionalHeaders additionalHeaders for this call
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object listApiTokensForCurrentUser(Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/v1/me/api-tokens";

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

    TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
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
   * Update authenticated user details
   * Updates the authenticated user&#39;s profile information and returns the updated user.
   * @param meControllerApiUserDetailsRequest The user details (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object patchCurrentUser(@javax.annotation.Nonnull MeControllerApiUserDetailsRequest meControllerApiUserDetailsRequest) throws ApiException {
    return this.patchCurrentUser(meControllerApiUserDetailsRequest, Collections.emptyMap());
  }


  /**
   * Update authenticated user details
   * Updates the authenticated user&#39;s profile information and returns the updated user.
   * @param meControllerApiUserDetailsRequest The user details (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object patchCurrentUser(@javax.annotation.Nonnull MeControllerApiUserDetailsRequest meControllerApiUserDetailsRequest, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = meControllerApiUserDetailsRequest;
    
    // verify the required parameter 'meControllerApiUserDetailsRequest' is set
    if (meControllerApiUserDetailsRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'meControllerApiUserDetailsRequest' when calling patchCurrentUser");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/me";

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

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "PATCH",
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
