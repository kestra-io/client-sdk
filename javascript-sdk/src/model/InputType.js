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
 * The InputType model module.
 * @module model/InputType
 * @version v0.24.0
 */
class InputType {
    /**
     * Constructs a new <code>InputType</code>.
     * @alias module:model/InputType
     */
    constructor() { 
        
        InputType.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>InputType</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/InputType} obj Optional instance to populate.
     * @return {module:model/InputType} The populated <code>InputType</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new InputType();

            if (data.hasOwnProperty('type')) {
                obj['type'] = ApiClient.convertToType(data['type'], 'String');
            }
            if (data.hasOwnProperty('cls')) {
                obj['cls'] = ApiClient.convertToType(data['cls'], 'String');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>InputType</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>InputType</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['type'] && !(typeof data['type'] === 'string' || data['type'] instanceof String)) {
            throw new Error("Expected the field `type` to be a primitive type in the JSON string but got " + data['type']);
        }
        // ensure the json data is a string
        if (data['cls'] && !(typeof data['cls'] === 'string' || data['cls'] instanceof String)) {
            throw new Error("Expected the field `cls` to be a primitive type in the JSON string but got " + data['cls']);
        }

        return true;
    }


}



/**
 * @member {String} type
 */
InputType.prototype['type'] = undefined;

/**
 * @member {String} cls
 */
InputType.prototype['cls'] = undefined;






export default InputType;

