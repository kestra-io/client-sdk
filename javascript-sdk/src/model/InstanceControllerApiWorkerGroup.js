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
 * The InstanceControllerApiWorkerGroup model module.
 * @module model/InstanceControllerApiWorkerGroup
 * @version v0.24.0
 */
class InstanceControllerApiWorkerGroup {
    /**
     * Constructs a new <code>InstanceControllerApiWorkerGroup</code>.
     * ApiWorkerGroup.
     * @alias module:model/InstanceControllerApiWorkerGroup
     */
    constructor() { 
        
        InstanceControllerApiWorkerGroup.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>InstanceControllerApiWorkerGroup</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/InstanceControllerApiWorkerGroup} obj Optional instance to populate.
     * @return {module:model/InstanceControllerApiWorkerGroup} The populated <code>InstanceControllerApiWorkerGroup</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new InstanceControllerApiWorkerGroup();

            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'String');
            }
            if (data.hasOwnProperty('key')) {
                obj['key'] = ApiClient.convertToType(data['key'], 'String');
            }
            if (data.hasOwnProperty('description')) {
                obj['description'] = ApiClient.convertToType(data['description'], 'String');
            }
            if (data.hasOwnProperty('allowedTenants')) {
                obj['allowedTenants'] = ApiClient.convertToType(data['allowedTenants'], ['String']);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>InstanceControllerApiWorkerGroup</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>InstanceControllerApiWorkerGroup</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['id'] && !(typeof data['id'] === 'string' || data['id'] instanceof String)) {
            throw new Error("Expected the field `id` to be a primitive type in the JSON string but got " + data['id']);
        }
        // ensure the json data is a string
        if (data['key'] && !(typeof data['key'] === 'string' || data['key'] instanceof String)) {
            throw new Error("Expected the field `key` to be a primitive type in the JSON string but got " + data['key']);
        }
        // ensure the json data is a string
        if (data['description'] && !(typeof data['description'] === 'string' || data['description'] instanceof String)) {
            throw new Error("Expected the field `description` to be a primitive type in the JSON string but got " + data['description']);
        }
        // ensure the json data is an array
        if (!Array.isArray(data['allowedTenants'])) {
            throw new Error("Expected the field `allowedTenants` to be an array in the JSON data but got " + data['allowedTenants']);
        }

        return true;
    }


}



/**
 * The ID of worker group.
 * @member {String} id
 */
InstanceControllerApiWorkerGroup.prototype['id'] = undefined;

/**
 * The key of the worker group.
 * @member {String} key
 */
InstanceControllerApiWorkerGroup.prototype['key'] = undefined;

/**
 * The description of the worker group.
 * @member {String} description
 */
InstanceControllerApiWorkerGroup.prototype['description'] = undefined;

/**
 * @member {Array.<String>} allowedTenants
 */
InstanceControllerApiWorkerGroup.prototype['allowedTenants'] = undefined;






export default InstanceControllerApiWorkerGroup;

