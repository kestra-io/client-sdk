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
 * The AppsControllerApiAppSource model module.
 * @module model/AppsControllerApiAppSource
 * @version v0.24.0
 */
class AppsControllerApiAppSource {
    /**
     * Constructs a new <code>AppsControllerApiAppSource</code>.
     * @alias module:model/AppsControllerApiAppSource
     */
    constructor() { 
        
        AppsControllerApiAppSource.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>AppsControllerApiAppSource</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/AppsControllerApiAppSource} obj Optional instance to populate.
     * @return {module:model/AppsControllerApiAppSource} The populated <code>AppsControllerApiAppSource</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new AppsControllerApiAppSource();

            if (data.hasOwnProperty('uid')) {
                obj['uid'] = ApiClient.convertToType(data['uid'], 'String');
            }
            if (data.hasOwnProperty('name')) {
                obj['name'] = ApiClient.convertToType(data['name'], 'String');
            }
            if (data.hasOwnProperty('namespace')) {
                obj['namespace'] = ApiClient.convertToType(data['namespace'], 'String');
            }
            if (data.hasOwnProperty('tags')) {
                obj['tags'] = ApiClient.convertToType(data['tags'], ['String']);
            }
            if (data.hasOwnProperty('disabled')) {
                obj['disabled'] = ApiClient.convertToType(data['disabled'], 'Boolean');
            }
            if (data.hasOwnProperty('source')) {
                obj['source'] = ApiClient.convertToType(data['source'], 'String');
            }
            if (data.hasOwnProperty('created')) {
                obj['created'] = ApiClient.convertToType(data['created'], 'Date');
            }
            if (data.hasOwnProperty('updated')) {
                obj['updated'] = ApiClient.convertToType(data['updated'], 'Date');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>AppsControllerApiAppSource</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>AppsControllerApiAppSource</code>.
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
        if (data['namespace'] && !(typeof data['namespace'] === 'string' || data['namespace'] instanceof String)) {
            throw new Error("Expected the field `namespace` to be a primitive type in the JSON string but got " + data['namespace']);
        }
        // ensure the json data is an array
        if (!Array.isArray(data['tags'])) {
            throw new Error("Expected the field `tags` to be an array in the JSON data but got " + data['tags']);
        }
        // ensure the json data is a string
        if (data['source'] && !(typeof data['source'] === 'string' || data['source'] instanceof String)) {
            throw new Error("Expected the field `source` to be a primitive type in the JSON string but got " + data['source']);
        }

        return true;
    }


}



/**
 * @member {String} uid
 */
AppsControllerApiAppSource.prototype['uid'] = undefined;

/**
 * @member {String} name
 */
AppsControllerApiAppSource.prototype['name'] = undefined;

/**
 * @member {String} namespace
 */
AppsControllerApiAppSource.prototype['namespace'] = undefined;

/**
 * @member {Array.<String>} tags
 */
AppsControllerApiAppSource.prototype['tags'] = undefined;

/**
 * @member {Boolean} disabled
 */
AppsControllerApiAppSource.prototype['disabled'] = undefined;

/**
 * @member {String} source
 */
AppsControllerApiAppSource.prototype['source'] = undefined;

/**
 * @member {Date} created
 */
AppsControllerApiAppSource.prototype['created'] = undefined;

/**
 * @member {Date} updated
 */
AppsControllerApiAppSource.prototype['updated'] = undefined;






export default AppsControllerApiAppSource;

