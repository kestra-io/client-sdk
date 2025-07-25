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
 * The ClusterControllerApiPluginArtifactListPluginArtifact model module.
 * @module model/ClusterControllerApiPluginArtifactListPluginArtifact
 * @version v1
 */
class ClusterControllerApiPluginArtifactListPluginArtifact {
    /**
     * Constructs a new <code>ClusterControllerApiPluginArtifactListPluginArtifact</code>.
     * @alias module:model/ClusterControllerApiPluginArtifactListPluginArtifact
     */
    constructor() { 
        
        ClusterControllerApiPluginArtifactListPluginArtifact.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>ClusterControllerApiPluginArtifactListPluginArtifact</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/ClusterControllerApiPluginArtifactListPluginArtifact} obj Optional instance to populate.
     * @return {module:model/ClusterControllerApiPluginArtifactListPluginArtifact} The populated <code>ClusterControllerApiPluginArtifactListPluginArtifact</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new ClusterControllerApiPluginArtifactListPluginArtifact();

            if (data.hasOwnProperty('total')) {
                obj['total'] = ApiClient.convertToType(data['total'], 'Number');
            }
            if (data.hasOwnProperty('results')) {
                obj['results'] = ApiClient.convertToType(data['results'], [Object]);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>ClusterControllerApiPluginArtifactListPluginArtifact</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>ClusterControllerApiPluginArtifactListPluginArtifact</code>.
     */
    static validateJSON(data) {
        // ensure the json data is an array
        if (!Array.isArray(data['results'])) {
            throw new Error("Expected the field `results` to be an array in the JSON data but got " + data['results']);
        }

        return true;
    }


}



/**
 * @member {Number} total
 */
ClusterControllerApiPluginArtifactListPluginArtifact.prototype['total'] = undefined;

/**
 * @member {Array.<Object>} results
 */
ClusterControllerApiPluginArtifactListPluginArtifact.prototype['results'] = undefined;






export default ClusterControllerApiPluginArtifactListPluginArtifact;

