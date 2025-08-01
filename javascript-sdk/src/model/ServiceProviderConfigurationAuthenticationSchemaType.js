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
* Enum class ServiceProviderConfigurationAuthenticationSchemaType.
* @enum {}
* @readonly
*/
export default class ServiceProviderConfigurationAuthenticationSchemaType {
    
        /**
         * value: "OAUTH"
         * @const
         */
        "OAUTH" = "OAUTH";

    
        /**
         * value: "OAUTH2"
         * @const
         */
        "OAUTH2" = "OAUTH2";

    
        /**
         * value: "OAUTH_BEARER"
         * @const
         */
        "OAUTH_BEARER" = "OAUTH_BEARER";

    
        /**
         * value: "HTTP_BASIC"
         * @const
         */
        "HTTP_BASIC" = "HTTP_BASIC";

    
        /**
         * value: "HTTP_DIGEST"
         * @const
         */
        "HTTP_DIGEST" = "HTTP_DIGEST";

    

    /**
    * Returns a <code>ServiceProviderConfigurationAuthenticationSchemaType</code> enum value from a Javascript object name.
    * @param {Object} data The plain JavaScript object containing the name of the enum value.
    * @return {module:model/ServiceProviderConfigurationAuthenticationSchemaType} The enum <code>ServiceProviderConfigurationAuthenticationSchemaType</code> value.
    */
    static constructFromObject(object) {
        return object;
    }
}

