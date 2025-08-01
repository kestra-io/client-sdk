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
import IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions from './IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions';

/**
 * The IAMRoleControllerApiRoleDetail model module.
 * @module model/IAMRoleControllerApiRoleDetail
 * @version v0.24.0
 */
class IAMRoleControllerApiRoleDetail {
    /**
     * Constructs a new <code>IAMRoleControllerApiRoleDetail</code>.
     * @alias module:model/IAMRoleControllerApiRoleDetail
     */
    constructor() { 
        
        IAMRoleControllerApiRoleDetail.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>IAMRoleControllerApiRoleDetail</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/IAMRoleControllerApiRoleDetail} obj Optional instance to populate.
     * @return {module:model/IAMRoleControllerApiRoleDetail} The populated <code>IAMRoleControllerApiRoleDetail</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new IAMRoleControllerApiRoleDetail();

            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'String');
            }
            if (data.hasOwnProperty('name')) {
                obj['name'] = ApiClient.convertToType(data['name'], 'String');
            }
            if (data.hasOwnProperty('description')) {
                obj['description'] = ApiClient.convertToType(data['description'], 'String');
            }
            if (data.hasOwnProperty('permissions')) {
                obj['permissions'] = IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.constructFromObject(data['permissions']);
            }
            if (data.hasOwnProperty('isDefault')) {
                obj['isDefault'] = ApiClient.convertToType(data['isDefault'], 'Boolean');
            }
            if (data.hasOwnProperty('isManaged')) {
                obj['isManaged'] = ApiClient.convertToType(data['isManaged'], 'Boolean');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>IAMRoleControllerApiRoleDetail</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>IAMRoleControllerApiRoleDetail</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['id'] && !(typeof data['id'] === 'string' || data['id'] instanceof String)) {
            throw new Error("Expected the field `id` to be a primitive type in the JSON string but got " + data['id']);
        }
        // ensure the json data is a string
        if (data['name'] && !(typeof data['name'] === 'string' || data['name'] instanceof String)) {
            throw new Error("Expected the field `name` to be a primitive type in the JSON string but got " + data['name']);
        }
        // ensure the json data is a string
        if (data['description'] && !(typeof data['description'] === 'string' || data['description'] instanceof String)) {
            throw new Error("Expected the field `description` to be a primitive type in the JSON string but got " + data['description']);
        }
        // validate the optional field `permissions`
        if (data['permissions']) { // data not null
          IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.validateJSON(data['permissions']);
        }

        return true;
    }


}



/**
 * @member {String} id
 */
IAMRoleControllerApiRoleDetail.prototype['id'] = undefined;

/**
 * @member {String} name
 */
IAMRoleControllerApiRoleDetail.prototype['name'] = undefined;

/**
 * @member {String} description
 */
IAMRoleControllerApiRoleDetail.prototype['description'] = undefined;

/**
 * @member {module:model/IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions} permissions
 */
IAMRoleControllerApiRoleDetail.prototype['permissions'] = undefined;

/**
 * @member {Boolean} isDefault
 */
IAMRoleControllerApiRoleDetail.prototype['isDefault'] = undefined;

/**
 * @member {Boolean} isManaged
 */
IAMRoleControllerApiRoleDetail.prototype['isManaged'] = undefined;






export default IAMRoleControllerApiRoleDetail;

