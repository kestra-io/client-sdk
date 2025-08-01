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
 * The MiscControllerPreview model module.
 * @module model/MiscControllerPreview
 * @version v0.24.0
 */
class MiscControllerPreview {
    /**
     * Constructs a new <code>MiscControllerPreview</code>.
     * @alias module:model/MiscControllerPreview
     */
    constructor() { 
        
        MiscControllerPreview.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>MiscControllerPreview</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/MiscControllerPreview} obj Optional instance to populate.
     * @return {module:model/MiscControllerPreview} The populated <code>MiscControllerPreview</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new MiscControllerPreview();

            if (data.hasOwnProperty('initial')) {
                obj['initial'] = ApiClient.convertToType(data['initial'], 'Number');
            }
            if (data.hasOwnProperty('max')) {
                obj['max'] = ApiClient.convertToType(data['max'], 'Number');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>MiscControllerPreview</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>MiscControllerPreview</code>.
     */
    static validateJSON(data) {

        return true;
    }


}



/**
 * @member {Number} initial
 */
MiscControllerPreview.prototype['initial'] = undefined;

/**
 * @member {Number} max
 */
MiscControllerPreview.prototype['max'] = undefined;






export default MiscControllerPreview;

