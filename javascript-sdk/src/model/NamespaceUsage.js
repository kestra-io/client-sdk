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
 * The NamespaceUsage model module.
 * @module model/NamespaceUsage
 * @version v0.24.0
 */
class NamespaceUsage {
    /**
     * Constructs a new <code>NamespaceUsage</code>.
     * @alias module:model/NamespaceUsage
     */
    constructor() { 
        
        NamespaceUsage.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>NamespaceUsage</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/NamespaceUsage} obj Optional instance to populate.
     * @return {module:model/NamespaceUsage} The populated <code>NamespaceUsage</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new NamespaceUsage();

            if (data.hasOwnProperty('count')) {
                obj['count'] = ApiClient.convertToType(data['count'], 'Number');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>NamespaceUsage</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>NamespaceUsage</code>.
     */
    static validateJSON(data) {

        return true;
    }


}



/**
 * @member {Number} count
 */
NamespaceUsage.prototype['count'] = undefined;






export default NamespaceUsage;

