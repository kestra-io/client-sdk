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
 * The AuthControllerAuth model module.
 * @module model/AuthControllerAuth
 * @version v0.24.0
 */
class AuthControllerAuth {
    /**
     * Constructs a new <code>AuthControllerAuth</code>.
     * @alias module:model/AuthControllerAuth
     */
    constructor() { 
        
        AuthControllerAuth.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>AuthControllerAuth</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/AuthControllerAuth} obj Optional instance to populate.
     * @return {module:model/AuthControllerAuth} The populated <code>AuthControllerAuth</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new AuthControllerAuth();

            if (data.hasOwnProperty('loginPassword')) {
                obj['loginPassword'] = ApiClient.convertToType(data['loginPassword'], 'Boolean');
            }
            if (data.hasOwnProperty('mailsEnabled')) {
                obj['mailsEnabled'] = ApiClient.convertToType(data['mailsEnabled'], 'Boolean');
            }
            if (data.hasOwnProperty('oauths')) {
                obj['oauths'] = ApiClient.convertToType(data['oauths'], ['String']);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>AuthControllerAuth</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>AuthControllerAuth</code>.
     */
    static validateJSON(data) {
        // ensure the json data is an array
        if (!Array.isArray(data['oauths'])) {
            throw new Error("Expected the field `oauths` to be an array in the JSON data but got " + data['oauths']);
        }

        return true;
    }


}



/**
 * @member {Boolean} loginPassword
 */
AuthControllerAuth.prototype['loginPassword'] = undefined;

/**
 * @member {Boolean} mailsEnabled
 */
AuthControllerAuth.prototype['mailsEnabled'] = undefined;

/**
 * @member {Array.<String>} oauths
 */
AuthControllerAuth.prototype['oauths'] = undefined;






export default AuthControllerAuth;

