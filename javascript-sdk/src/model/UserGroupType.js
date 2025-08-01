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
* Enum class UserGroupType.
* @enum {}
* @readonly
*/
export default class UserGroupType {
    
        /**
         * value: "DIRECT"
         * @const
         */
        "DIRECT" = "DIRECT";

    
        /**
         * value: "INDIRECT"
         * @const
         */
        "INDIRECT" = "INDIRECT";

    

    /**
    * Returns a <code>UserGroupType</code> enum value from a Javascript object name.
    * @param {Object} data The plain JavaScript object containing the name of the enum value.
    * @return {module:model/UserGroupType} The enum <code>UserGroupType</code> value.
    */
    static constructFromObject(object) {
        return object;
    }
}

