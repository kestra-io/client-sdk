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
 * The ExecutionRepositoryInterfaceFlowFilter model module.
 * @module model/ExecutionRepositoryInterfaceFlowFilter
 * @version v0.24.0
 */
class ExecutionRepositoryInterfaceFlowFilter {
    /**
     * Constructs a new <code>ExecutionRepositoryInterfaceFlowFilter</code>.
     * @alias module:model/ExecutionRepositoryInterfaceFlowFilter
     * @param namespace {String} 
     * @param id {String} 
     */
    constructor(namespace, id) { 
        
        ExecutionRepositoryInterfaceFlowFilter.initialize(this, namespace, id);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, namespace, id) { 
        obj['namespace'] = namespace;
        obj['id'] = id;
    }

    /**
     * Constructs a <code>ExecutionRepositoryInterfaceFlowFilter</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/ExecutionRepositoryInterfaceFlowFilter} obj Optional instance to populate.
     * @return {module:model/ExecutionRepositoryInterfaceFlowFilter} The populated <code>ExecutionRepositoryInterfaceFlowFilter</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new ExecutionRepositoryInterfaceFlowFilter();

            if (data.hasOwnProperty('namespace')) {
                obj['namespace'] = ApiClient.convertToType(data['namespace'], 'String');
            }
            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'String');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>ExecutionRepositoryInterfaceFlowFilter</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>ExecutionRepositoryInterfaceFlowFilter</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of ExecutionRepositoryInterfaceFlowFilter.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
        // ensure the json data is a string
        if (data['namespace'] && !(typeof data['namespace'] === 'string' || data['namespace'] instanceof String)) {
            throw new Error("Expected the field `namespace` to be a primitive type in the JSON string but got " + data['namespace']);
        }
        // ensure the json data is a string
        if (data['id'] && !(typeof data['id'] === 'string' || data['id'] instanceof String)) {
            throw new Error("Expected the field `id` to be a primitive type in the JSON string but got " + data['id']);
        }

        return true;
    }


}

ExecutionRepositoryInterfaceFlowFilter.RequiredProperties = ["namespace", "id"];

/**
 * @member {String} namespace
 */
ExecutionRepositoryInterfaceFlowFilter.prototype['namespace'] = undefined;

/**
 * @member {String} id
 */
ExecutionRepositoryInterfaceFlowFilter.prototype['id'] = undefined;






export default ExecutionRepositoryInterfaceFlowFilter;

