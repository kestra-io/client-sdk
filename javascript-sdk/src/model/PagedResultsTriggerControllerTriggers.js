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
import TriggerControllerTriggers from './TriggerControllerTriggers';

/**
 * The PagedResultsTriggerControllerTriggers model module.
 * @module model/PagedResultsTriggerControllerTriggers
 * @version v0.24.0
 */
class PagedResultsTriggerControllerTriggers {
    /**
     * Constructs a new <code>PagedResultsTriggerControllerTriggers</code>.
     * @alias module:model/PagedResultsTriggerControllerTriggers
     * @param results {Array.<module:model/TriggerControllerTriggers>} 
     * @param total {Number} 
     */
    constructor(results, total) { 
        
        PagedResultsTriggerControllerTriggers.initialize(this, results, total);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, results, total) { 
        obj['results'] = results;
        obj['total'] = total;
    }

    /**
     * Constructs a <code>PagedResultsTriggerControllerTriggers</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/PagedResultsTriggerControllerTriggers} obj Optional instance to populate.
     * @return {module:model/PagedResultsTriggerControllerTriggers} The populated <code>PagedResultsTriggerControllerTriggers</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new PagedResultsTriggerControllerTriggers();

            if (data.hasOwnProperty('results')) {
                obj['results'] = ApiClient.convertToType(data['results'], [TriggerControllerTriggers]);
            }
            if (data.hasOwnProperty('total')) {
                obj['total'] = ApiClient.convertToType(data['total'], 'Number');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>PagedResultsTriggerControllerTriggers</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>PagedResultsTriggerControllerTriggers</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of PagedResultsTriggerControllerTriggers.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
        if (data['results']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['results'])) {
                throw new Error("Expected the field `results` to be an array in the JSON data but got " + data['results']);
            }
            // validate the optional field `results` (array)
            for (const item of data['results']) {
                TriggerControllerTriggers.validateJSON(item);
            };
        }

        return true;
    }


}

PagedResultsTriggerControllerTriggers.RequiredProperties = ["results", "total"];

/**
 * @member {Array.<module:model/TriggerControllerTriggers>} results
 */
PagedResultsTriggerControllerTriggers.prototype['results'] = undefined;

/**
 * @member {Number} total
 */
PagedResultsTriggerControllerTriggers.prototype['total'] = undefined;






export default PagedResultsTriggerControllerTriggers;

