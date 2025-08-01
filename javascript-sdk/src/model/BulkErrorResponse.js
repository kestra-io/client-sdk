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

import ApiClient from '../ApiClient';

/**
 * The BulkErrorResponse model module.
 * @module model/BulkErrorResponse
 * @version v0.24.0
 */
class BulkErrorResponse {
    /**
     * Constructs a new <code>BulkErrorResponse</code>.
     * @alias module:model/BulkErrorResponse
     */
    constructor() { 
        
        BulkErrorResponse.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>BulkErrorResponse</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/BulkErrorResponse} obj Optional instance to populate.
     * @return {module:model/BulkErrorResponse} The populated <code>BulkErrorResponse</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new BulkErrorResponse();

            if (data.hasOwnProperty('message')) {
                obj['message'] = ApiClient.convertToType(data['message'], 'String');
            }
            if (data.hasOwnProperty('invalids')) {
                obj['invalids'] = ApiClient.convertToType(data['invalids'], Object);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>BulkErrorResponse</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>BulkErrorResponse</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['message'] && !(typeof data['message'] === 'string' || data['message'] instanceof String)) {
            throw new Error("Expected the field `message` to be a primitive type in the JSON string but got " + data['message']);
        }

        return true;
    }


}



/**
 * @member {String} message
 */
BulkErrorResponse.prototype['message'] = undefined;

/**
 * @member {Object} invalids
 */
BulkErrorResponse.prototype['invalids'] = undefined;






export default BulkErrorResponse;

