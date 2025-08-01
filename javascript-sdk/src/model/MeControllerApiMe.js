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
import IAMTenantAccessControllerApiAuthentication from './IAMTenantAccessControllerApiAuthentication';
import MeControllerApiProfile from './MeControllerApiProfile';
import MeControllerApiTenant from './MeControllerApiTenant';

/**
 * The MeControllerApiMe model module.
 * @module model/MeControllerApiMe
 * @version v0.24.0
 */
class MeControllerApiMe {
    /**
     * Constructs a new <code>MeControllerApiMe</code>.
     * @alias module:model/MeControllerApiMe
     */
    constructor() { 
        
        MeControllerApiMe.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>MeControllerApiMe</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/MeControllerApiMe} obj Optional instance to populate.
     * @return {module:model/MeControllerApiMe} The populated <code>MeControllerApiMe</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new MeControllerApiMe();

            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'String');
            }
            if (data.hasOwnProperty('superAdmin')) {
                obj['superAdmin'] = ApiClient.convertToType(data['superAdmin'], 'Boolean');
            }
            if (data.hasOwnProperty('restricted')) {
                obj['restricted'] = ApiClient.convertToType(data['restricted'], 'Boolean');
            }
            if (data.hasOwnProperty('profile')) {
                obj['profile'] = MeControllerApiProfile.constructFromObject(data['profile']);
            }
            if (data.hasOwnProperty('auths')) {
                obj['auths'] = ApiClient.convertToType(data['auths'], [IAMTenantAccessControllerApiAuthentication]);
            }
            if (data.hasOwnProperty('tenants')) {
                obj['tenants'] = ApiClient.convertToType(data['tenants'], [MeControllerApiTenant]);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>MeControllerApiMe</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>MeControllerApiMe</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['id'] && !(typeof data['id'] === 'string' || data['id'] instanceof String)) {
            throw new Error("Expected the field `id` to be a primitive type in the JSON string but got " + data['id']);
        }
        // validate the optional field `profile`
        if (data['profile']) { // data not null
          MeControllerApiProfile.validateJSON(data['profile']);
        }
        if (data['auths']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['auths'])) {
                throw new Error("Expected the field `auths` to be an array in the JSON data but got " + data['auths']);
            }
            // validate the optional field `auths` (array)
            for (const item of data['auths']) {
                IAMTenantAccessControllerApiAuthentication.validateJSON(item);
            };
        }
        if (data['tenants']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['tenants'])) {
                throw new Error("Expected the field `tenants` to be an array in the JSON data but got " + data['tenants']);
            }
            // validate the optional field `tenants` (array)
            for (const item of data['tenants']) {
                MeControllerApiTenant.validateJSON(item);
            };
        }

        return true;
    }


}



/**
 * @member {String} id
 */
MeControllerApiMe.prototype['id'] = undefined;

/**
 * @member {Boolean} superAdmin
 */
MeControllerApiMe.prototype['superAdmin'] = undefined;

/**
 * @member {Boolean} restricted
 */
MeControllerApiMe.prototype['restricted'] = undefined;

/**
 * @member {module:model/MeControllerApiProfile} profile
 */
MeControllerApiMe.prototype['profile'] = undefined;

/**
 * @member {Array.<module:model/IAMTenantAccessControllerApiAuthentication>} auths
 */
MeControllerApiMe.prototype['auths'] = undefined;

/**
 * @member {Array.<module:model/MeControllerApiTenant>} tenants
 */
MeControllerApiMe.prototype['tenants'] = undefined;






export default MeControllerApiMe;

