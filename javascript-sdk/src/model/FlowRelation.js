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
* Enum class FlowRelation.
* @enum {}
* @readonly
*/
export default class FlowRelation {
    
        /**
         * value: "FLOW_TASK"
         * @const
         */
        "FLOW_TASK" = "FLOW_TASK";

    
        /**
         * value: "FLOW_TRIGGER"
         * @const
         */
        "FLOW_TRIGGER" = "FLOW_TRIGGER";

    

    /**
    * Returns a <code>FlowRelation</code> enum value from a Javascript object name.
    * @param {Object} data The plain JavaScript object containing the name of the enum value.
    * @return {module:model/FlowRelation} The enum <code>FlowRelation</code> value.
    */
    static constructFromObject(object) {
        return object;
    }
}

