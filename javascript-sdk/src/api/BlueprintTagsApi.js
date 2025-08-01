/**
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 * The version of the OpenAPI document: v1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 *
 */


import ApiClient from "../ApiClient";
import BlueprintControllerApiBlueprintTagItem from '../model/BlueprintControllerApiBlueprintTagItem';
import BlueprintControllerKind from '../model/BlueprintControllerKind';

/**
* BlueprintTags service.
* @module api/BlueprintTagsApi
* @version v0.24.0
*/
export default class BlueprintTagsApi {

    /**
    * Constructs a new BlueprintTagsApi. 
    * @alias module:api/BlueprintTagsApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instance} if unspecified.
    */
    constructor(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;
    }


    /**
     * Callback function to receive the result of the internalBlueprintTags operation.
     * @callback module:api/BlueprintTagsApi~internalBlueprintTagsCallback
     * @param {String} error Error message, if any.
     * @param {Array.<String>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * List all internal blueprint tags
     * Lists all tags used by internal (custom) blueprints for the current tenant.
     * @param {String} tenant 
     * @param {Object} opts Optional parameters
     * @param {String} [q] A string filter to get tags with matching blueprints only
     * @param {module:api/BlueprintTagsApi~internalBlueprintTagsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<String>}
     */
    internalBlueprintTags(tenant, opts, callback) {
      opts = opts || {};
      let postBody = null;
      // verify the required parameter 'tenant' is set
      if (tenant === undefined || tenant === null) {
        throw new Error("Missing the required parameter 'tenant' when calling internalBlueprintTags");
      }

      let pathParams = {
        'tenant': tenant
      };
      let queryParams = {
        'q': opts['q']
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = ['String'];
      return this.apiClient.callApi(
        '/api/v1/{tenant}/blueprints/custom/tags', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the listBlueprintTags operation.
     * @callback module:api/BlueprintTagsApi~listBlueprintTagsCallback
     * @param {String} error Error message, if any.
     * @param {Array.<module:model/BlueprintControllerApiBlueprintTagItem>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * List blueprint tags matching the filter
     * Lists tags for community blueprints of the specified kind, optionally filtered by query.
     * @param {module:model/BlueprintControllerKind} kind The blueprint kind
     * @param {String} tenant 
     * @param {Object} opts Optional parameters
     * @param {String} [q] A string filter to get tags with matching blueprints only
     * @param {module:api/BlueprintTagsApi~listBlueprintTagsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<module:model/BlueprintControllerApiBlueprintTagItem>}
     */
    listBlueprintTags(kind, tenant, opts, callback) {
      opts = opts || {};
      let postBody = null;
      // verify the required parameter 'kind' is set
      if (kind === undefined || kind === null) {
        throw new Error("Missing the required parameter 'kind' when calling listBlueprintTags");
      }
      // verify the required parameter 'tenant' is set
      if (tenant === undefined || tenant === null) {
        throw new Error("Missing the required parameter 'tenant' when calling listBlueprintTags");
      }

      let pathParams = {
        'kind': kind,
        'tenant': tenant
      };
      let queryParams = {
        'q': opts['q']
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = [BlueprintControllerApiBlueprintTagItem];
      return this.apiClient.callApi(
        '/api/v1/{tenant}/blueprints/community/{kind}/tags', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }


}
