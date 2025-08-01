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
import AuditLogControllerAuditLogDiff from '../model/AuditLogControllerAuditLogDiff';
import AuditLogControllerAuditLogOption from '../model/AuditLogControllerAuditLogOption';
import AuditLogControllerAuditLogWithUser from '../model/AuditLogControllerAuditLogWithUser';
import AuditLogControllerFindRequest from '../model/AuditLogControllerFindRequest';
import CrudEventType from '../model/CrudEventType';
import PagedResultsAuditLogControllerAuditLogWithUser from '../model/PagedResultsAuditLogControllerAuditLogWithUser';
import Permission from '../model/Permission';

/**
* AuditLogs service.
* @module api/AuditLogsApi
* @version v0.24.0
*/
export default class AuditLogsApi {

    /**
    * Constructs a new AuditLogsApi. 
    * @alias module:api/AuditLogsApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instance} if unspecified.
    */
    constructor(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;
    }


    /**
     * Callback function to receive the result of the findAuditLog operation.
     * @callback module:api/AuditLogsApi~findAuditLogCallback
     * @param {String} error Error message, if any.
     * @param {module:model/AuditLogControllerAuditLogWithUser} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Find a specific audit log
     * @param {String} tenant 
     * @param {module:model/AuditLogControllerFindRequest} auditLogControllerFindRequest The find request
     * @param {module:api/AuditLogsApi~findAuditLogCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/AuditLogControllerAuditLogWithUser}
     */
    findAuditLog(tenant, auditLogControllerFindRequest, callback) {
      let postBody = auditLogControllerFindRequest;
      // verify the required parameter 'tenant' is set
      if (tenant === undefined || tenant === null) {
        throw new Error("Missing the required parameter 'tenant' when calling findAuditLog");
      }
      // verify the required parameter 'auditLogControllerFindRequest' is set
      if (auditLogControllerFindRequest === undefined || auditLogControllerFindRequest === null) {
        throw new Error("Missing the required parameter 'auditLogControllerFindRequest' when calling findAuditLog");
      }

      let pathParams = {
        'tenant': tenant
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = ['basicAuth', 'bearerAuth'];
      let contentTypes = ['application/json'];
      let accepts = ['application/json'];
      let returnType = AuditLogControllerAuditLogWithUser;
      return this.apiClient.callApi(
        '/api/v1/{tenant}/auditlogs/find', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the getResourceDiffFromAuditLog operation.
     * @callback module:api/AuditLogsApi~getResourceDiffFromAuditLogCallback
     * @param {String} error Error message, if any.
     * @param {module:model/AuditLogControllerAuditLogDiff} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Retrieve the diff between audit logs
     * Retrieves the diff between the current version and a selected previous version of a given resource based on audit logs.
     * @param {String} id The id of the audit log
     * @param {String} tenant 
     * @param {Object} opts Optional parameters
     * @param {String} [previousId] The id of a previous audit log to compare with
     * @param {module:api/AuditLogsApi~getResourceDiffFromAuditLogCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/AuditLogControllerAuditLogDiff}
     */
    getResourceDiffFromAuditLog(id, tenant, opts, callback) {
      opts = opts || {};
      let postBody = null;
      // verify the required parameter 'id' is set
      if (id === undefined || id === null) {
        throw new Error("Missing the required parameter 'id' when calling getResourceDiffFromAuditLog");
      }
      // verify the required parameter 'tenant' is set
      if (tenant === undefined || tenant === null) {
        throw new Error("Missing the required parameter 'tenant' when calling getResourceDiffFromAuditLog");
      }

      let pathParams = {
        'id': id,
        'tenant': tenant
      };
      let queryParams = {
        'previousId': opts['previousId']
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = ['basicAuth', 'bearerAuth'];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = AuditLogControllerAuditLogDiff;
      return this.apiClient.callApi(
        '/api/v1/{tenant}/auditlogs/{id}/diff', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the listAuditLogFromResourceId operation.
     * @callback module:api/AuditLogsApi~listAuditLogFromResourceIdCallback
     * @param {String} error Error message, if any.
     * @param {Array.<module:model/AuditLogControllerAuditLogOption>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Find all audit logs about a specific resource.
     * @param {String} detailId The resource Id
     * @param {String} tenant 
     * @param {module:api/AuditLogsApi~listAuditLogFromResourceIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<module:model/AuditLogControllerAuditLogOption>}
     */
    listAuditLogFromResourceId(detailId, tenant, callback) {
      let postBody = null;
      // verify the required parameter 'detailId' is set
      if (detailId === undefined || detailId === null) {
        throw new Error("Missing the required parameter 'detailId' when calling listAuditLogFromResourceId");
      }
      // verify the required parameter 'tenant' is set
      if (tenant === undefined || tenant === null) {
        throw new Error("Missing the required parameter 'tenant' when calling listAuditLogFromResourceId");
      }

      let pathParams = {
        'detailId': detailId,
        'tenant': tenant
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = ['basicAuth', 'bearerAuth'];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = [AuditLogControllerAuditLogOption];
      return this.apiClient.callApi(
        '/api/v1/{tenant}/auditlogs/history/{detailId}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the searchAuditLogs operation.
     * @callback module:api/AuditLogsApi~searchAuditLogsCallback
     * @param {String} error Error message, if any.
     * @param {module:model/PagedResultsAuditLogControllerAuditLogWithUser} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Search for audit logs
     * @param {Number} page The current page
     * @param {Number} size The current page size
     * @param {String} tenant 
     * @param {Object} opts Optional parameters
     * @param {String} [q] A string filter
     * @param {Array.<String>} [sort] The sort of current page
     * @param {String} [namespace] A namespace filter
     * @param {String} [flowId] A flow id filter
     * @param {String} [executionId] An execution filter
     * @param {String} [userId] A user id filter
     * @param {String} [id] A id filter
     * @param {module:model/Permission} [permission] A permission filter
     * @param {Date} [startDate] The start datetime
     * @param {Date} [endDate] The end datetime
     * @param {Object.<String, {String: String}>} [details] A list of auditLog details
     * @param {module:model/CrudEventType} [type] The event that create the audit log
     * @param {module:api/AuditLogsApi~searchAuditLogsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/PagedResultsAuditLogControllerAuditLogWithUser}
     */
    searchAuditLogs(page, size, tenant, opts, callback) {
      opts = opts || {};
      let postBody = null;
      // verify the required parameter 'page' is set
      if (page === undefined || page === null) {
        throw new Error("Missing the required parameter 'page' when calling searchAuditLogs");
      }
      // verify the required parameter 'size' is set
      if (size === undefined || size === null) {
        throw new Error("Missing the required parameter 'size' when calling searchAuditLogs");
      }
      // verify the required parameter 'tenant' is set
      if (tenant === undefined || tenant === null) {
        throw new Error("Missing the required parameter 'tenant' when calling searchAuditLogs");
      }

      let pathParams = {
        'tenant': tenant
      };
      let queryParams = {
        'q': opts['q'],
        'page': page,
        'size': size,
        'sort': this.apiClient.buildCollectionParam(opts['sort'], 'csv'),
        'namespace': opts['namespace'],
        'flowId': opts['flowId'],
        'executionId': opts['executionId'],
        'userId': opts['userId'],
        'id': opts['id'],
        'permission': opts['permission'],
        'startDate': opts['startDate'],
        'endDate': opts['endDate'],
        'details': opts['details'],
        'type': opts['type']
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = ['basicAuth', 'bearerAuth'];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = PagedResultsAuditLogControllerAuditLogWithUser;
      return this.apiClient.callApi(
        '/api/v1/{tenant}/auditlogs/search', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }


}
