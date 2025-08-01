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
 * The InstanceControllerApiPluginArtifact model module.
 * @module model/InstanceControllerApiPluginArtifact
 * @version v0.24.0
 */
class InstanceControllerApiPluginArtifact {
    /**
     * Constructs a new <code>InstanceControllerApiPluginArtifact</code>.
     * @alias module:model/InstanceControllerApiPluginArtifact
     */
    constructor() { 
        
        InstanceControllerApiPluginArtifact.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>InstanceControllerApiPluginArtifact</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/InstanceControllerApiPluginArtifact} obj Optional instance to populate.
     * @return {module:model/InstanceControllerApiPluginArtifact} The populated <code>InstanceControllerApiPluginArtifact</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new InstanceControllerApiPluginArtifact();

            if (data.hasOwnProperty('title')) {
                obj['title'] = ApiClient.convertToType(data['title'], 'String');
            }
            if (data.hasOwnProperty('icon')) {
                obj['icon'] = ApiClient.convertToType(data['icon'], 'String');
            }
            if (data.hasOwnProperty('groupId')) {
                obj['groupId'] = ApiClient.convertToType(data['groupId'], 'String');
            }
            if (data.hasOwnProperty('artifactId')) {
                obj['artifactId'] = ApiClient.convertToType(data['artifactId'], 'String');
            }
            if (data.hasOwnProperty('versions')) {
                obj['versions'] = ApiClient.convertToType(data['versions'], ['String']);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>InstanceControllerApiPluginArtifact</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>InstanceControllerApiPluginArtifact</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['title'] && !(typeof data['title'] === 'string' || data['title'] instanceof String)) {
            throw new Error("Expected the field `title` to be a primitive type in the JSON string but got " + data['title']);
        }
        // ensure the json data is a string
        if (data['icon'] && !(typeof data['icon'] === 'string' || data['icon'] instanceof String)) {
            throw new Error("Expected the field `icon` to be a primitive type in the JSON string but got " + data['icon']);
        }
        // ensure the json data is a string
        if (data['groupId'] && !(typeof data['groupId'] === 'string' || data['groupId'] instanceof String)) {
            throw new Error("Expected the field `groupId` to be a primitive type in the JSON string but got " + data['groupId']);
        }
        // ensure the json data is a string
        if (data['artifactId'] && !(typeof data['artifactId'] === 'string' || data['artifactId'] instanceof String)) {
            throw new Error("Expected the field `artifactId` to be a primitive type in the JSON string but got " + data['artifactId']);
        }
        // ensure the json data is an array
        if (!Array.isArray(data['versions'])) {
            throw new Error("Expected the field `versions` to be an array in the JSON data but got " + data['versions']);
        }

        return true;
    }


}



/**
 * @member {String} title
 */
InstanceControllerApiPluginArtifact.prototype['title'] = undefined;

/**
 * @member {String} icon
 */
InstanceControllerApiPluginArtifact.prototype['icon'] = undefined;

/**
 * @member {String} groupId
 */
InstanceControllerApiPluginArtifact.prototype['groupId'] = undefined;

/**
 * @member {String} artifactId
 */
InstanceControllerApiPluginArtifact.prototype['artifactId'] = undefined;

/**
 * @member {Array.<String>} versions
 */
InstanceControllerApiPluginArtifact.prototype['versions'] = undefined;






export default InstanceControllerApiPluginArtifact;

