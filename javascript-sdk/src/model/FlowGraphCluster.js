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
import AbstractGraph from './AbstractGraph';

/**
 * The FlowGraphCluster model module.
 * @module model/FlowGraphCluster
 * @version v0.24.0
 */
class FlowGraphCluster {
    /**
     * Constructs a new <code>FlowGraphCluster</code>.
     * @alias module:model/FlowGraphCluster
     */
    constructor() { 
        
        FlowGraphCluster.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>FlowGraphCluster</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/FlowGraphCluster} obj Optional instance to populate.
     * @return {module:model/FlowGraphCluster} The populated <code>FlowGraphCluster</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new FlowGraphCluster();

            if (data.hasOwnProperty('cluster')) {
                obj['cluster'] = AbstractGraph.constructFromObject(data['cluster']);
            }
            if (data.hasOwnProperty('nodes')) {
                obj['nodes'] = ApiClient.convertToType(data['nodes'], ['String']);
            }
            if (data.hasOwnProperty('parents')) {
                obj['parents'] = ApiClient.convertToType(data['parents'], ['String']);
            }
            if (data.hasOwnProperty('start')) {
                obj['start'] = ApiClient.convertToType(data['start'], 'String');
            }
            if (data.hasOwnProperty('end')) {
                obj['end'] = ApiClient.convertToType(data['end'], 'String');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>FlowGraphCluster</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>FlowGraphCluster</code>.
     */
    static validateJSON(data) {
        // validate the optional field `cluster`
        if (data['cluster']) { // data not null
          AbstractGraph.validateJSON(data['cluster']);
        }
        // ensure the json data is an array
        if (!Array.isArray(data['nodes'])) {
            throw new Error("Expected the field `nodes` to be an array in the JSON data but got " + data['nodes']);
        }
        // ensure the json data is an array
        if (!Array.isArray(data['parents'])) {
            throw new Error("Expected the field `parents` to be an array in the JSON data but got " + data['parents']);
        }
        // ensure the json data is a string
        if (data['start'] && !(typeof data['start'] === 'string' || data['start'] instanceof String)) {
            throw new Error("Expected the field `start` to be a primitive type in the JSON string but got " + data['start']);
        }
        // ensure the json data is a string
        if (data['end'] && !(typeof data['end'] === 'string' || data['end'] instanceof String)) {
            throw new Error("Expected the field `end` to be a primitive type in the JSON string but got " + data['end']);
        }

        return true;
    }


}



/**
 * @member {module:model/AbstractGraph} cluster
 */
FlowGraphCluster.prototype['cluster'] = undefined;

/**
 * @member {Array.<String>} nodes
 */
FlowGraphCluster.prototype['nodes'] = undefined;

/**
 * @member {Array.<String>} parents
 */
FlowGraphCluster.prototype['parents'] = undefined;

/**
 * @member {String} start
 */
FlowGraphCluster.prototype['start'] = undefined;

/**
 * @member {String} end
 */
FlowGraphCluster.prototype['end'] = undefined;






export default FlowGraphCluster;

