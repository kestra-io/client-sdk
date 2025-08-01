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
import IAMInvitationControllerApiInvitationRole from './IAMInvitationControllerApiInvitationRole';

/**
 * The IAMInvitationControllerApiInvitationCreateRequest model module.
 * @module model/IAMInvitationControllerApiInvitationCreateRequest
 * @version v0.24.0
 */
class IAMInvitationControllerApiInvitationCreateRequest {
    /**
     * Constructs a new <code>IAMInvitationControllerApiInvitationCreateRequest</code>.
     * @alias module:model/IAMInvitationControllerApiInvitationCreateRequest
     * @param email {String} 
     */
    constructor(email) { 
        
        IAMInvitationControllerApiInvitationCreateRequest.initialize(this, email);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, email) { 
        obj['email'] = email;
    }

    /**
     * Constructs a <code>IAMInvitationControllerApiInvitationCreateRequest</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/IAMInvitationControllerApiInvitationCreateRequest} obj Optional instance to populate.
     * @return {module:model/IAMInvitationControllerApiInvitationCreateRequest} The populated <code>IAMInvitationControllerApiInvitationCreateRequest</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new IAMInvitationControllerApiInvitationCreateRequest();

            if (data.hasOwnProperty('superAdmin')) {
                obj['superAdmin'] = ApiClient.convertToType(data['superAdmin'], 'Boolean');
            }
            if (data.hasOwnProperty('roles')) {
                obj['roles'] = ApiClient.convertToType(data['roles'], [IAMInvitationControllerApiInvitationRole]);
            }
            if (data.hasOwnProperty('groups')) {
                obj['groups'] = ApiClient.convertToType(data['groups'], ['String']);
            }
            if (data.hasOwnProperty('email')) {
                obj['email'] = ApiClient.convertToType(data['email'], 'String');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>IAMInvitationControllerApiInvitationCreateRequest</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>IAMInvitationControllerApiInvitationCreateRequest</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of IAMInvitationControllerApiInvitationCreateRequest.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
        if (data['roles']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['roles'])) {
                throw new Error("Expected the field `roles` to be an array in the JSON data but got " + data['roles']);
            }
            // validate the optional field `roles` (array)
            for (const item of data['roles']) {
                IAMInvitationControllerApiInvitationRole.validateJSON(item);
            };
        }
        // ensure the json data is an array
        if (!Array.isArray(data['groups'])) {
            throw new Error("Expected the field `groups` to be an array in the JSON data but got " + data['groups']);
        }
        // ensure the json data is a string
        if (data['email'] && !(typeof data['email'] === 'string' || data['email'] instanceof String)) {
            throw new Error("Expected the field `email` to be a primitive type in the JSON string but got " + data['email']);
        }

        return true;
    }


}

IAMInvitationControllerApiInvitationCreateRequest.RequiredProperties = ["email"];

/**
 * @member {Boolean} superAdmin
 */
IAMInvitationControllerApiInvitationCreateRequest.prototype['superAdmin'] = undefined;

/**
 * @member {Array.<module:model/IAMInvitationControllerApiInvitationRole>} roles
 */
IAMInvitationControllerApiInvitationCreateRequest.prototype['roles'] = undefined;

/**
 * @member {Array.<String>} groups
 */
IAMInvitationControllerApiInvitationCreateRequest.prototype['groups'] = undefined;

/**
 * @member {String} email
 */
IAMInvitationControllerApiInvitationCreateRequest.prototype['email'] = undefined;






export default IAMInvitationControllerApiInvitationCreateRequest;

