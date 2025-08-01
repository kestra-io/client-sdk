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
 * The DailyExecutionStatisticsExecutionCounts model module.
 * @module model/DailyExecutionStatisticsExecutionCounts
 * @version v0.24.0
 */
class DailyExecutionStatisticsExecutionCounts {
    /**
     * Constructs a new <code>DailyExecutionStatisticsExecutionCounts</code>.
     * @alias module:model/DailyExecutionStatisticsExecutionCounts
     */
    constructor() { 
        
        DailyExecutionStatisticsExecutionCounts.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>DailyExecutionStatisticsExecutionCounts</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/DailyExecutionStatisticsExecutionCounts} obj Optional instance to populate.
     * @return {module:model/DailyExecutionStatisticsExecutionCounts} The populated <code>DailyExecutionStatisticsExecutionCounts</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new DailyExecutionStatisticsExecutionCounts();

            if (data.hasOwnProperty('CREATED')) {
                obj['CREATED'] = ApiClient.convertToType(data['CREATED'], 'Number');
            }
            if (data.hasOwnProperty('RUNNING')) {
                obj['RUNNING'] = ApiClient.convertToType(data['RUNNING'], 'Number');
            }
            if (data.hasOwnProperty('PAUSED')) {
                obj['PAUSED'] = ApiClient.convertToType(data['PAUSED'], 'Number');
            }
            if (data.hasOwnProperty('RESTARTED')) {
                obj['RESTARTED'] = ApiClient.convertToType(data['RESTARTED'], 'Number');
            }
            if (data.hasOwnProperty('KILLING')) {
                obj['KILLING'] = ApiClient.convertToType(data['KILLING'], 'Number');
            }
            if (data.hasOwnProperty('SUCCESS')) {
                obj['SUCCESS'] = ApiClient.convertToType(data['SUCCESS'], 'Number');
            }
            if (data.hasOwnProperty('WARNING')) {
                obj['WARNING'] = ApiClient.convertToType(data['WARNING'], 'Number');
            }
            if (data.hasOwnProperty('FAILED')) {
                obj['FAILED'] = ApiClient.convertToType(data['FAILED'], 'Number');
            }
            if (data.hasOwnProperty('KILLED')) {
                obj['KILLED'] = ApiClient.convertToType(data['KILLED'], 'Number');
            }
            if (data.hasOwnProperty('CANCELLED')) {
                obj['CANCELLED'] = ApiClient.convertToType(data['CANCELLED'], 'Number');
            }
            if (data.hasOwnProperty('QUEUED')) {
                obj['QUEUED'] = ApiClient.convertToType(data['QUEUED'], 'Number');
            }
            if (data.hasOwnProperty('RETRYING')) {
                obj['RETRYING'] = ApiClient.convertToType(data['RETRYING'], 'Number');
            }
            if (data.hasOwnProperty('RETRIED')) {
                obj['RETRIED'] = ApiClient.convertToType(data['RETRIED'], 'Number');
            }
            if (data.hasOwnProperty('SKIPPED')) {
                obj['SKIPPED'] = ApiClient.convertToType(data['SKIPPED'], 'Number');
            }
            if (data.hasOwnProperty('BREAKPOINT')) {
                obj['BREAKPOINT'] = ApiClient.convertToType(data['BREAKPOINT'], 'Number');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>DailyExecutionStatisticsExecutionCounts</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>DailyExecutionStatisticsExecutionCounts</code>.
     */
    static validateJSON(data) {

        return true;
    }


}



/**
 * @member {Number} CREATED
 */
DailyExecutionStatisticsExecutionCounts.prototype['CREATED'] = undefined;

/**
 * @member {Number} RUNNING
 */
DailyExecutionStatisticsExecutionCounts.prototype['RUNNING'] = undefined;

/**
 * @member {Number} PAUSED
 */
DailyExecutionStatisticsExecutionCounts.prototype['PAUSED'] = undefined;

/**
 * @member {Number} RESTARTED
 */
DailyExecutionStatisticsExecutionCounts.prototype['RESTARTED'] = undefined;

/**
 * @member {Number} KILLING
 */
DailyExecutionStatisticsExecutionCounts.prototype['KILLING'] = undefined;

/**
 * @member {Number} SUCCESS
 */
DailyExecutionStatisticsExecutionCounts.prototype['SUCCESS'] = undefined;

/**
 * @member {Number} WARNING
 */
DailyExecutionStatisticsExecutionCounts.prototype['WARNING'] = undefined;

/**
 * @member {Number} FAILED
 */
DailyExecutionStatisticsExecutionCounts.prototype['FAILED'] = undefined;

/**
 * @member {Number} KILLED
 */
DailyExecutionStatisticsExecutionCounts.prototype['KILLED'] = undefined;

/**
 * @member {Number} CANCELLED
 */
DailyExecutionStatisticsExecutionCounts.prototype['CANCELLED'] = undefined;

/**
 * @member {Number} QUEUED
 */
DailyExecutionStatisticsExecutionCounts.prototype['QUEUED'] = undefined;

/**
 * @member {Number} RETRYING
 */
DailyExecutionStatisticsExecutionCounts.prototype['RETRYING'] = undefined;

/**
 * @member {Number} RETRIED
 */
DailyExecutionStatisticsExecutionCounts.prototype['RETRIED'] = undefined;

/**
 * @member {Number} SKIPPED
 */
DailyExecutionStatisticsExecutionCounts.prototype['SKIPPED'] = undefined;

/**
 * @member {Number} BREAKPOINT
 */
DailyExecutionStatisticsExecutionCounts.prototype['BREAKPOINT'] = undefined;






export default DailyExecutionStatisticsExecutionCounts;

