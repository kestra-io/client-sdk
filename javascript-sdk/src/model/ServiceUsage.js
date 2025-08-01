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
import ServiceUsageDailyServiceStatistics from './ServiceUsageDailyServiceStatistics';

/**
 * The ServiceUsage model module.
 * @module model/ServiceUsage
 * @version v0.24.0
 */
class ServiceUsage {
    /**
     * Constructs a new <code>ServiceUsage</code>.
     * @alias module:model/ServiceUsage
     */
    constructor() { 
        
        ServiceUsage.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>ServiceUsage</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/ServiceUsage} obj Optional instance to populate.
     * @return {module:model/ServiceUsage} The populated <code>ServiceUsage</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new ServiceUsage();

            if (data.hasOwnProperty('dailyStatistics')) {
                obj['dailyStatistics'] = ApiClient.convertToType(data['dailyStatistics'], [ServiceUsageDailyServiceStatistics]);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>ServiceUsage</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>ServiceUsage</code>.
     */
    static validateJSON(data) {
        if (data['dailyStatistics']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['dailyStatistics'])) {
                throw new Error("Expected the field `dailyStatistics` to be an array in the JSON data but got " + data['dailyStatistics']);
            }
            // validate the optional field `dailyStatistics` (array)
            for (const item of data['dailyStatistics']) {
                ServiceUsageDailyServiceStatistics.validateJSON(item);
            };
        }

        return true;
    }


}



/**
 * @member {Array.<module:model/ServiceUsageDailyServiceStatistics>} dailyStatistics
 */
ServiceUsage.prototype['dailyStatistics'] = undefined;






export default ServiceUsage;

