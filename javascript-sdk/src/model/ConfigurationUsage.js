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
 * The ConfigurationUsage model module.
 * @module model/ConfigurationUsage
 * @version v0.24.0
 */
class ConfigurationUsage {
    /**
     * Constructs a new <code>ConfigurationUsage</code>.
     * @alias module:model/ConfigurationUsage
     */
    constructor() { 
        
        ConfigurationUsage.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>ConfigurationUsage</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/ConfigurationUsage} obj Optional instance to populate.
     * @return {module:model/ConfigurationUsage} The populated <code>ConfigurationUsage</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new ConfigurationUsage();

            if (data.hasOwnProperty('repositoryType')) {
                obj['repositoryType'] = ApiClient.convertToType(data['repositoryType'], 'String');
            }
            if (data.hasOwnProperty('queueType')) {
                obj['queueType'] = ApiClient.convertToType(data['queueType'], 'String');
            }
            if (data.hasOwnProperty('storageType')) {
                obj['storageType'] = ApiClient.convertToType(data['storageType'], 'String');
            }
            if (data.hasOwnProperty('secretType')) {
                obj['secretType'] = ApiClient.convertToType(data['secretType'], 'String');
            }
            if (data.hasOwnProperty('javaSecurityEnabled')) {
                obj['javaSecurityEnabled'] = ApiClient.convertToType(data['javaSecurityEnabled'], 'Boolean');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>ConfigurationUsage</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>ConfigurationUsage</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['repositoryType'] && !(typeof data['repositoryType'] === 'string' || data['repositoryType'] instanceof String)) {
            throw new Error("Expected the field `repositoryType` to be a primitive type in the JSON string but got " + data['repositoryType']);
        }
        // ensure the json data is a string
        if (data['queueType'] && !(typeof data['queueType'] === 'string' || data['queueType'] instanceof String)) {
            throw new Error("Expected the field `queueType` to be a primitive type in the JSON string but got " + data['queueType']);
        }
        // ensure the json data is a string
        if (data['storageType'] && !(typeof data['storageType'] === 'string' || data['storageType'] instanceof String)) {
            throw new Error("Expected the field `storageType` to be a primitive type in the JSON string but got " + data['storageType']);
        }
        // ensure the json data is a string
        if (data['secretType'] && !(typeof data['secretType'] === 'string' || data['secretType'] instanceof String)) {
            throw new Error("Expected the field `secretType` to be a primitive type in the JSON string but got " + data['secretType']);
        }

        return true;
    }


}



/**
 * @member {String} repositoryType
 */
ConfigurationUsage.prototype['repositoryType'] = undefined;

/**
 * @member {String} queueType
 */
ConfigurationUsage.prototype['queueType'] = undefined;

/**
 * @member {String} storageType
 */
ConfigurationUsage.prototype['storageType'] = undefined;

/**
 * @member {String} secretType
 */
ConfigurationUsage.prototype['secretType'] = undefined;

/**
 * @member {Boolean} javaSecurityEnabled
 */
ConfigurationUsage.prototype['javaSecurityEnabled'] = undefined;






export default ConfigurationUsage;

