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
import Trigger from './Trigger';

/**
 * The TriggerControllerSetDisabledRequest model module.
 * @module model/TriggerControllerSetDisabledRequest
 * @version v1
 */
class TriggerControllerSetDisabledRequest {
    /**
     * Constructs a new <code>TriggerControllerSetDisabledRequest</code>.
     * @alias module:model/TriggerControllerSetDisabledRequest
     */
    constructor() { 
        
        TriggerControllerSetDisabledRequest.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>TriggerControllerSetDisabledRequest</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/TriggerControllerSetDisabledRequest} obj Optional instance to populate.
     * @return {module:model/TriggerControllerSetDisabledRequest} The populated <code>TriggerControllerSetDisabledRequest</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new TriggerControllerSetDisabledRequest();

            if (data.hasOwnProperty('triggers')) {
                obj['triggers'] = ApiClient.convertToType(data['triggers'], [Trigger]);
            }
            if (data.hasOwnProperty('disabled')) {
                obj['disabled'] = ApiClient.convertToType(data['disabled'], 'Boolean');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>TriggerControllerSetDisabledRequest</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>TriggerControllerSetDisabledRequest</code>.
     */
    static validateJSON(data) {
        if (data['triggers']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['triggers'])) {
                throw new Error("Expected the field `triggers` to be an array in the JSON data but got " + data['triggers']);
            }
            // validate the optional field `triggers` (array)
            for (const item of data['triggers']) {
                Trigger.validateJSON(item);
            };
        }

        return true;
    }


}



/**
 * @member {Array.<module:model/Trigger>} triggers
 */
TriggerControllerSetDisabledRequest.prototype['triggers'] = undefined;

/**
 * @member {Boolean} disabled
 */
TriggerControllerSetDisabledRequest.prototype['disabled'] = undefined;






export default TriggerControllerSetDisabledRequest;

