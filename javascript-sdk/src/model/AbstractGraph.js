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
import AbstractGraphBranchType from './AbstractGraphBranchType';

/**
 * The AbstractGraph model module.
 * @module model/AbstractGraph
 * @version v0.24.0
 */
class AbstractGraph {
    /**
     * Constructs a new <code>AbstractGraph</code>.
     * @alias module:model/AbstractGraph
     */
    constructor() { 
        
        AbstractGraph.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>AbstractGraph</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/AbstractGraph} obj Optional instance to populate.
     * @return {module:model/AbstractGraph} The populated <code>AbstractGraph</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new AbstractGraph();

            if (data.hasOwnProperty('uid')) {
                obj['uid'] = ApiClient.convertToType(data['uid'], 'String');
            }
            if (data.hasOwnProperty('type')) {
                obj['type'] = ApiClient.convertToType(data['type'], 'String');
            }
            if (data.hasOwnProperty('branchType')) {
                obj['branchType'] = AbstractGraphBranchType.constructFromObject(data['branchType']);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>AbstractGraph</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>AbstractGraph</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['uid'] && !(typeof data['uid'] === 'string' || data['uid'] instanceof String)) {
            throw new Error("Expected the field `uid` to be a primitive type in the JSON string but got " + data['uid']);
        }
        // ensure the json data is a string
        if (data['type'] && !(typeof data['type'] === 'string' || data['type'] instanceof String)) {
            throw new Error("Expected the field `type` to be a primitive type in the JSON string but got " + data['type']);
        }

        return true;
    }


}



/**
 * @member {String} uid
 */
AbstractGraph.prototype['uid'] = undefined;

/**
 * @member {String} type
 */
AbstractGraph.prototype['type'] = undefined;

/**
 * @member {module:model/AbstractGraphBranchType} branchType
 */
AbstractGraph.prototype['branchType'] = undefined;






export default AbstractGraph;

