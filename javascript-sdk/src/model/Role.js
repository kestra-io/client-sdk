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
 * The Role model module.
 * @module model/Role
 * @version v0.24.0
 */
class Role {
    /**
     * Constructs a new <code>Role</code>.
     * @alias module:model/Role
     * @param isManaged {Boolean} 
     * @param name {String} 
     * @param deleted {Boolean} 
     */
    constructor(isManaged, name, deleted) { 
        
        Role.initialize(this, isManaged, name, deleted);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, isManaged, name, deleted) { 
        obj['isManaged'] = isManaged;
        obj['name'] = name;
        obj['deleted'] = deleted;
    }

    /**
     * Constructs a <code>Role</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/Role} obj Optional instance to populate.
     * @return {module:model/Role} The populated <code>Role</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Role();

            if (data.hasOwnProperty('isManaged')) {
                obj['isManaged'] = ApiClient.convertToType(data['isManaged'], 'Boolean');
            }
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
            if (data.hasOwnProperty('deleted')) {
                obj['deleted'] = ApiClient.convertToType(data['deleted'], 'Boolean');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>Role</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>Role</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of Role.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
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

Role.RequiredProperties = ["isManaged", "name", "deleted"];

/**
 * @member {Boolean} isManaged
 */
Role.prototype['isManaged'] = undefined;

/**
 * @member {String} id
 */
Role.prototype['id'] = undefined;

/**
 * @member {String} name
 */
Role.prototype['name'] = undefined;

/**
 * @member {String} description
 */
Role.prototype['description'] = undefined;

/**
 * @member {module:model/IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions} permissions
 */
Role.prototype['permissions'] = undefined;

/**
 * @member {Boolean} isDefault
 */
Role.prototype['isDefault'] = undefined;

/**
 * @member {Boolean} deleted
 */
Role.prototype['deleted'] = undefined;






export default Role;

