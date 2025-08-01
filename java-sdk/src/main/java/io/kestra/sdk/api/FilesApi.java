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

import java.io.File;
import io.kestra.sdk.model.FileAttributes;
import java.net.URI;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class FilesApi extends BaseApi {

  public FilesApi() {
    super(Configuration.getDefaultApiClient());
  }

  public FilesApi(ApiClient apiClient) {
    super(apiClient);
  }

  /**
   * Create a directory
   * 
   * @param namespace The namespace id (required)
   * @param tenant  (required)
   * @param path The internal storage uri (optional)
   * @throws ApiException if fails to make API call
   */
  public void createNamespaceDirectory(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String path) throws ApiException {
    this.createNamespaceDirectory(namespace, tenant, path, Collections.emptyMap());
  }


  /**
   * Create a directory
   * 
   * @param namespace The namespace id (required)
   * @param tenant  (required)
   * @param path The internal storage uri (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void createNamespaceDirectory(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String path, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling createNamespaceDirectory");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling createNamespaceDirectory");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files/directory"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
    
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
        null
    );
  }

  /**
   * Create a file
   * 
   * @param namespace The namespace id (required)
   * @param path The internal storage uri (required)
   * @param tenant  (required)
   * @param fileContent The file to upload (optional)
   * @throws ApiException if fails to make API call
   */
  public void createNamespaceFile(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String path, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable File fileContent) throws ApiException {
    this.createNamespaceFile(namespace, path, tenant, fileContent, Collections.emptyMap());
  }


  /**
   * Create a file
   * 
   * @param namespace The namespace id (required)
   * @param path The internal storage uri (required)
   * @param tenant  (required)
   * @param fileContent The file to upload (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void createNamespaceFile(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String path, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable File fileContent, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling createNamespaceFile");
    }
    
    // verify the required parameter 'path' is set
    if (path == null) {
      throw new ApiException(400, "Missing the required parameter 'path' when calling createNamespaceFile");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling createNamespaceFile");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    if (fileContent != null)
      localVarFormParams.put("fileContent", fileContent);

    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    apiClient.invokeAPI(
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
        null
    );
  }

  /**
   * Delete a file or directory
   * 
   * @param namespace The namespace id (required)
   * @param path The internal storage uri of the file / directory to delete (required)
   * @param tenant  (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteFileDirectory(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String path, @javax.annotation.Nonnull String tenant) throws ApiException {
    this.deleteFileDirectory(namespace, path, tenant, Collections.emptyMap());
  }


  /**
   * Delete a file or directory
   * 
   * @param namespace The namespace id (required)
   * @param path The internal storage uri of the file / directory to delete (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void deleteFileDirectory(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String path, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling deleteFileDirectory");
    }
    
    // verify the required parameter 'path' is set
    if (path == null) {
      throw new ApiException(400, "Missing the required parameter 'path' when calling deleteFileDirectory");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling deleteFileDirectory");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
    
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
   * Export namespace files as a ZIP
   * 
   * @param namespace The namespace id (required)
   * @param tenant  (required)
   * @return byte[]
   * @throws ApiException if fails to make API call
   */
  public byte[] exportNamespaceFiles(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.exportNamespaceFiles(namespace, tenant, Collections.emptyMap());
  }


  /**
   * Export namespace files as a ZIP
   * 
   * @param namespace The namespace id (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return byte[]
   * @throws ApiException if fails to make API call
   */
  public byte[] exportNamespaceFiles(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling exportNamespaceFiles");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling exportNamespaceFiles");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files/export"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
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
      "application/octet-stream"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<byte[]> localVarReturnType = new TypeReference<byte[]>() {};
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
   * Get namespace file content
   * 
   * @param namespace The namespace id (required)
   * @param path The internal storage uri (required)
   * @param tenant  (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File getFileContent(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String path, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.getFileContent(namespace, path, tenant, Collections.emptyMap());
  }


  /**
   * Get namespace file content
   * 
   * @param namespace The namespace id (required)
   * @param path The internal storage uri (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File getFileContent(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String path, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling getFileContent");
    }
    
    // verify the required parameter 'path' is set
    if (path == null) {
      throw new ApiException(400, "Missing the required parameter 'path' when calling getFileContent");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling getFileContent");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/octet-stream"
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
   * Get namespace file stats such as size, creation &amp; modification dates and type
   * 
   * @param namespace The namespace id (required)
   * @param tenant  (required)
   * @param path The internal storage uri (optional)
   * @return FileAttributes
   * @throws ApiException if fails to make API call
   */
  public FileAttributes getFileMetadatas(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String path) throws ApiException {
    return this.getFileMetadatas(namespace, tenant, path, Collections.emptyMap());
  }


  /**
   * Get namespace file stats such as size, creation &amp; modification dates and type
   * 
   * @param namespace The namespace id (required)
   * @param tenant  (required)
   * @param path The internal storage uri (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return FileAttributes
   * @throws ApiException if fails to make API call
   */
  public FileAttributes getFileMetadatas(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String path, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling getFileMetadatas");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling getFileMetadatas");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files/stats"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<FileAttributes> localVarReturnType = new TypeReference<FileAttributes>() {};
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
   * List directory content
   * 
   * @param namespace The namespace id (required)
   * @param tenant  (required)
   * @param path The internal storage uri (optional)
   * @return List&lt;FileAttributes&gt;
   * @throws ApiException if fails to make API call
   */
  public List<FileAttributes> listNamespaceDirectoryFiles(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String path) throws ApiException {
    return this.listNamespaceDirectoryFiles(namespace, tenant, path, Collections.emptyMap());
  }


  /**
   * List directory content
   * 
   * @param namespace The namespace id (required)
   * @param tenant  (required)
   * @param path The internal storage uri (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;FileAttributes&gt;
   * @throws ApiException if fails to make API call
   */
  public List<FileAttributes> listNamespaceDirectoryFiles(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String tenant, @javax.annotation.Nullable String path, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling listNamespaceDirectoryFiles");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling listNamespaceDirectoryFiles");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files/directory"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    TypeReference<List<FileAttributes>> localVarReturnType = new TypeReference<List<FileAttributes>>() {};
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
   * Move a file or directory
   * 
   * @param namespace The namespace id (required)
   * @param from The internal storage uri to move from (required)
   * @param to The internal storage uri to move to (required)
   * @param tenant  (required)
   * @throws ApiException if fails to make API call
   */
  public void moveFileDirectory(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull URI from, @javax.annotation.Nonnull URI to, @javax.annotation.Nonnull String tenant) throws ApiException {
    this.moveFileDirectory(namespace, from, to, tenant, Collections.emptyMap());
  }


  /**
   * Move a file or directory
   * 
   * @param namespace The namespace id (required)
   * @param from The internal storage uri to move from (required)
   * @param to The internal storage uri to move to (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void moveFileDirectory(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull URI from, @javax.annotation.Nonnull URI to, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling moveFileDirectory");
    }
    
    // verify the required parameter 'from' is set
    if (from == null) {
      throw new ApiException(400, "Missing the required parameter 'from' when calling moveFileDirectory");
    }
    
    // verify the required parameter 'to' is set
    if (to == null) {
      throw new ApiException(400, "Missing the required parameter 'to' when calling moveFileDirectory");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling moveFileDirectory");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
      .replaceAll("\\{" + "tenant" + "\\}", apiClient.escapeString(apiClient.parameterToString(tenant)));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPair("from", from));
    localVarQueryParams.addAll(apiClient.parameterToPair("to", to));
    
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
        null
    );
  }

  /**
   * Find files which path contain the given string in their URI
   * 
   * @param namespace The namespace id (required)
   * @param q The string the file path should contain (required)
   * @param tenant  (required)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> searchNamespaceFiles(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String q, @javax.annotation.Nonnull String tenant) throws ApiException {
    return this.searchNamespaceFiles(namespace, q, tenant, Collections.emptyMap());
  }


  /**
   * Find files which path contain the given string in their URI
   * 
   * @param namespace The namespace id (required)
   * @param q The string the file path should contain (required)
   * @param tenant  (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> searchNamespaceFiles(@javax.annotation.Nonnull String namespace, @javax.annotation.Nonnull String q, @javax.annotation.Nonnull String tenant, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'namespace' is set
    if (namespace == null) {
      throw new ApiException(400, "Missing the required parameter 'namespace' when calling searchNamespaceFiles");
    }
    
    // verify the required parameter 'q' is set
    if (q == null) {
      throw new ApiException(400, "Missing the required parameter 'q' when calling searchNamespaceFiles");
    }
    
    // verify the required parameter 'tenant' is set
    if (tenant == null) {
      throw new ApiException(400, "Missing the required parameter 'tenant' when calling searchNamespaceFiles");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/{tenant}/namespaces/{namespace}/files/search"
      .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(apiClient.parameterToString(namespace)))
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
