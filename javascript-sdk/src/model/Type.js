/**
 * Kestra EE
 * All API operations allow an optional tenant identifier in the HTTP path, if you don't use multi-tenancy you must omit the tenant identifier.<br/> This means that, for example, when trying to access the Flows API, instead of using <code>/api/v1/{tenant}/flows</code> you must use <code>/api/v1/flows</code>.
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
* Enum class Type.
* @enum {}
* @readonly
*/
export default class Type {
    
        /**
         * value: "STRING"
         * @const
         */
        "STRING" = "STRING";

    
        /**
         * value: "ENUM"
         * @const
         */
        "ENUM" = "ENUM";

    
        /**
         * value: "SELECT"
         * @const
         */
        "SELECT" = "SELECT";

    
        /**
         * value: "INT"
         * @const
         */
        "INT" = "INT";

    
        /**
         * value: "FLOAT"
         * @const
         */
        "FLOAT" = "FLOAT";

    
        /**
         * value: "BOOLEAN"
         * @const
         */
        "BOOLEAN" = "BOOLEAN";

    
        /**
         * value: "BOOL"
         * @const
         */
        "BOOL" = "BOOL";

    
        /**
         * value: "DATETIME"
         * @const
         */
        "DATETIME" = "DATETIME";

    
        /**
         * value: "DATE"
         * @const
         */
        "DATE" = "DATE";

    
        /**
         * value: "TIME"
         * @const
         */
        "TIME" = "TIME";

    
        /**
         * value: "DURATION"
         * @const
         */
        "DURATION" = "DURATION";

    
        /**
         * value: "FILE"
         * @const
         */
        "FILE" = "FILE";

    
        /**
         * value: "JSON"
         * @const
         */
        "JSON" = "JSON";

    
        /**
         * value: "URI"
         * @const
         */
        "URI" = "URI";

    
        /**
         * value: "SECRET"
         * @const
         */
        "SECRET" = "SECRET";

    
        /**
         * value: "ARRAY"
         * @const
         */
        "ARRAY" = "ARRAY";

    
        /**
         * value: "MULTISELECT"
         * @const
         */
        "MULTISELECT" = "MULTISELECT";

    
        /**
         * value: "YAML"
         * @const
         */
        "YAML" = "YAML";

    
        /**
         * value: "EMAIL"
         * @const
         */
        "EMAIL" = "EMAIL";

    

    /**
    * Returns a <code>Type</code> enum value from a Javascript object name.
    * @param {Object} data The plain JavaScript object containing the name of the enum value.
    * @return {module:model/Type} The enum <code>Type</code> value.
    */
    static constructFromObject(object) {
        return object;
    }
}

