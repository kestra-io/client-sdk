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
import InstanceControllerApiPluginVersionsApiPluginVersionAndMetadata from './InstanceControllerApiPluginVersionsApiPluginVersionAndMetadata';

/**
 * The InstanceControllerApiPluginVersions model module.
 * @module model/InstanceControllerApiPluginVersions
 * @version v0.24.0
 */
class InstanceControllerApiPluginVersions {
    /**
     * Constructs a new <code>InstanceControllerApiPluginVersions</code>.
     * @alias module:model/InstanceControllerApiPluginVersions
     */
    constructor() { 
        
        InstanceControllerApiPluginVersions.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>InstanceControllerApiPluginVersions</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/InstanceControllerApiPluginVersions} obj Optional instance to populate.
     * @return {module:model/InstanceControllerApiPluginVersions} The populated <code>InstanceControllerApiPluginVersions</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new InstanceControllerApiPluginVersions();

            if (data.hasOwnProperty('groupId')) {
                obj['groupId'] = ApiClient.convertToType(data['groupId'], 'String');
            }
            if (data.hasOwnProperty('artifactId')) {
                obj['artifactId'] = ApiClient.convertToType(data['artifactId'], 'String');
            }
            if (data.hasOwnProperty('versions')) {
                obj['versions'] = ApiClient.convertToType(data['versions'], [InstanceControllerApiPluginVersionsApiPluginVersionAndMetadata]);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>InstanceControllerApiPluginVersions</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>InstanceControllerApiPluginVersions</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['groupId'] && !(typeof data['groupId'] === 'string' || data['groupId'] instanceof String)) {
            throw new Error("Expected the field `groupId` to be a primitive type in the JSON string but got " + data['groupId']);
        }
        // ensure the json data is a string
        if (data['artifactId'] && !(typeof data['artifactId'] === 'string' || data['artifactId'] instanceof String)) {
            throw new Error("Expected the field `artifactId` to be a primitive type in the JSON string but got " + data['artifactId']);
        }
        if (data['versions']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['versions'])) {
                throw new Error("Expected the field `versions` to be an array in the JSON data but got " + data['versions']);
            }
            // validate the optional field `versions` (array)
            for (const item of data['versions']) {
                InstanceControllerApiPluginVersionsApiPluginVersionAndMetadata.validateJSON(item);
            };
        }

        return true;
    }


}



/**
 * @member {String} groupId
 */
InstanceControllerApiPluginVersions.prototype['groupId'] = undefined;

/**
 * @member {String} artifactId
 */
InstanceControllerApiPluginVersions.prototype['artifactId'] = undefined;

/**
 * @member {Array.<module:model/InstanceControllerApiPluginVersionsApiPluginVersionAndMetadata>} versions
 */
InstanceControllerApiPluginVersions.prototype['versions'] = undefined;






export default InstanceControllerApiPluginVersions;

