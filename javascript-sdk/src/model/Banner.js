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
import BannerType from './BannerType';

/**
 * The Banner model module.
 * @module model/Banner
 * @version v0.24.0
 */
class Banner {
    /**
     * Constructs a new <code>Banner</code>.
     * @alias module:model/Banner
     * @param message {String} 
     */
    constructor(message) { 
        
        Banner.initialize(this, message);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, message) { 
        obj['message'] = message;
    }

    /**
     * Constructs a <code>Banner</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/Banner} obj Optional instance to populate.
     * @return {module:model/Banner} The populated <code>Banner</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Banner();

            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'String');
            }
            if (data.hasOwnProperty('message')) {
                obj['message'] = ApiClient.convertToType(data['message'], 'String');
            }
            if (data.hasOwnProperty('type')) {
                obj['type'] = BannerType.constructFromObject(data['type']);
            }
            if (data.hasOwnProperty('startDate')) {
                obj['startDate'] = ApiClient.convertToType(data['startDate'], 'Date');
            }
            if (data.hasOwnProperty('endDate')) {
                obj['endDate'] = ApiClient.convertToType(data['endDate'], 'Date');
            }
            if (data.hasOwnProperty('tenantId')) {
                obj['tenantId'] = ApiClient.convertToType(data['tenantId'], 'String');
            }
            if (data.hasOwnProperty('active')) {
                obj['active'] = ApiClient.convertToType(data['active'], 'Boolean');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>Banner</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>Banner</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of Banner.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
        // ensure the json data is a string
        if (data['id'] && !(typeof data['id'] === 'string' || data['id'] instanceof String)) {
            throw new Error("Expected the field `id` to be a primitive type in the JSON string but got " + data['id']);
        }
        // ensure the json data is a string
        if (data['message'] && !(typeof data['message'] === 'string' || data['message'] instanceof String)) {
            throw new Error("Expected the field `message` to be a primitive type in the JSON string but got " + data['message']);
        }
        // ensure the json data is a string
        if (data['tenantId'] && !(typeof data['tenantId'] === 'string' || data['tenantId'] instanceof String)) {
            throw new Error("Expected the field `tenantId` to be a primitive type in the JSON string but got " + data['tenantId']);
        }

        return true;
    }


}

Banner.RequiredProperties = ["message"];

/**
 * @member {String} id
 */
Banner.prototype['id'] = undefined;

/**
 * @member {String} message
 */
Banner.prototype['message'] = undefined;

/**
 * @member {module:model/BannerType} type
 */
Banner.prototype['type'] = undefined;

/**
 * @member {Date} startDate
 */
Banner.prototype['startDate'] = undefined;

/**
 * @member {Date} endDate
 */
Banner.prototype['endDate'] = undefined;

/**
 * @member {String} tenantId
 */
Banner.prototype['tenantId'] = undefined;

/**
 * @member {Boolean} active
 */
Banner.prototype['active'] = undefined;






export default Banner;

