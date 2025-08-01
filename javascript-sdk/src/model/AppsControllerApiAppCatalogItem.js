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
 * The AppsControllerApiAppCatalogItem model module.
 * @module model/AppsControllerApiAppCatalogItem
 * @version v0.24.0
 */
class AppsControllerApiAppCatalogItem {
    /**
     * Constructs a new <code>AppsControllerApiAppCatalogItem</code>.
     * @alias module:model/AppsControllerApiAppCatalogItem
     */
    constructor() { 
        
        AppsControllerApiAppCatalogItem.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>AppsControllerApiAppCatalogItem</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/AppsControllerApiAppCatalogItem} obj Optional instance to populate.
     * @return {module:model/AppsControllerApiAppCatalogItem} The populated <code>AppsControllerApiAppCatalogItem</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new AppsControllerApiAppCatalogItem();

            if (data.hasOwnProperty('uid')) {
                obj['uid'] = ApiClient.convertToType(data['uid'], 'String');
            }
            if (data.hasOwnProperty('name')) {
                obj['name'] = ApiClient.convertToType(data['name'], 'String');
            }
            if (data.hasOwnProperty('description')) {
                obj['description'] = ApiClient.convertToType(data['description'], 'String');
            }
            if (data.hasOwnProperty('type')) {
                obj['type'] = ApiClient.convertToType(data['type'], 'String');
            }
            if (data.hasOwnProperty('tags')) {
                obj['tags'] = ApiClient.convertToType(data['tags'], ['String']);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>AppsControllerApiAppCatalogItem</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>AppsControllerApiAppCatalogItem</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['uid'] && !(typeof data['uid'] === 'string' || data['uid'] instanceof String)) {
            throw new Error("Expected the field `uid` to be a primitive type in the JSON string but got " + data['uid']);
        }
        // ensure the json data is a string
        if (data['name'] && !(typeof data['name'] === 'string' || data['name'] instanceof String)) {
            throw new Error("Expected the field `name` to be a primitive type in the JSON string but got " + data['name']);
        }
        // ensure the json data is a string
        if (data['description'] && !(typeof data['description'] === 'string' || data['description'] instanceof String)) {
            throw new Error("Expected the field `description` to be a primitive type in the JSON string but got " + data['description']);
        }
        // ensure the json data is a string
        if (data['type'] && !(typeof data['type'] === 'string' || data['type'] instanceof String)) {
            throw new Error("Expected the field `type` to be a primitive type in the JSON string but got " + data['type']);
        }
        // ensure the json data is an array
        if (!Array.isArray(data['tags'])) {
            throw new Error("Expected the field `tags` to be an array in the JSON data but got " + data['tags']);
        }

        return true;
    }


}



/**
 * @member {String} uid
 */
AppsControllerApiAppCatalogItem.prototype['uid'] = undefined;

/**
 * @member {String} name
 */
AppsControllerApiAppCatalogItem.prototype['name'] = undefined;

/**
 * @member {String} description
 */
AppsControllerApiAppCatalogItem.prototype['description'] = undefined;

/**
 * @member {String} type
 */
AppsControllerApiAppCatalogItem.prototype['type'] = undefined;

/**
 * @member {Array.<String>} tags
 */
AppsControllerApiAppCatalogItem.prototype['tags'] = undefined;






export default AppsControllerApiAppCatalogItem;

