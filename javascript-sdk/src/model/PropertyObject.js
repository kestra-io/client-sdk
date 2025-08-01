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
 * The PropertyObject model module.
 * @module model/PropertyObject
 * @version v0.24.0
 */
class PropertyObject {
    /**
     * Constructs a new <code>PropertyObject</code>.
     * @alias module:model/PropertyObject
     */
    constructor() { 
        
        PropertyObject.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>PropertyObject</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/PropertyObject} obj Optional instance to populate.
     * @return {module:model/PropertyObject} The populated <code>PropertyObject</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new PropertyObject();

            if (data.hasOwnProperty('expression')) {
                obj['expression'] = ApiClient.convertToType(data['expression'], 'String');
            }
            if (data.hasOwnProperty('value')) {
                obj['value'] = ApiClient.convertToType(data['value'], Object);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>PropertyObject</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>PropertyObject</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['expression'] && !(typeof data['expression'] === 'string' || data['expression'] instanceof String)) {
            throw new Error("Expected the field `expression` to be a primitive type in the JSON string but got " + data['expression']);
        }

        return true;
    }


}



/**
 * @member {String} expression
 */
PropertyObject.prototype['expression'] = undefined;

/**
 * @member {Object} value
 */
PropertyObject.prototype['value'] = undefined;






export default PropertyObject;

