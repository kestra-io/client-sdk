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
 * The FileMetas model module.
 * @module model/FileMetas
 * @version v0.24.0
 */
class FileMetas {
    /**
     * Constructs a new <code>FileMetas</code>.
     * @alias module:model/FileMetas
     * @param size {Number} 
     */
    constructor(size) { 
        
        FileMetas.initialize(this, size);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, size) { 
        obj['size'] = size;
    }

    /**
     * Constructs a <code>FileMetas</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/FileMetas} obj Optional instance to populate.
     * @return {module:model/FileMetas} The populated <code>FileMetas</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new FileMetas();

            if (data.hasOwnProperty('size')) {
                obj['size'] = ApiClient.convertToType(data['size'], 'Number');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>FileMetas</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>FileMetas</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of FileMetas.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }

        return true;
    }


}

FileMetas.RequiredProperties = ["size"];

/**
 * @member {Number} size
 */
FileMetas.prototype['size'] = undefined;






export default FileMetas;

