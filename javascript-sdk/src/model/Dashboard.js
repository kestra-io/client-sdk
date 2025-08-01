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
import ChartChartOption from './ChartChartOption';
import TimeWindow from './TimeWindow';

/**
 * The Dashboard model module.
 * @module model/Dashboard
 * @version v0.24.0
 */
class Dashboard {
    /**
     * Constructs a new <code>Dashboard</code>.
     * @alias module:model/Dashboard
     * @param title {String} 
     */
    constructor(title) { 
        
        Dashboard.initialize(this, title);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, title) { 
        obj['title'] = title;
    }

    /**
     * Constructs a <code>Dashboard</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/Dashboard} obj Optional instance to populate.
     * @return {module:model/Dashboard} The populated <code>Dashboard</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Dashboard();

            if (data.hasOwnProperty('title')) {
                obj['title'] = ApiClient.convertToType(data['title'], 'String');
            }
            if (data.hasOwnProperty('description')) {
                obj['description'] = ApiClient.convertToType(data['description'], 'String');
            }
            if (data.hasOwnProperty('timeWindow')) {
                obj['timeWindow'] = TimeWindow.constructFromObject(data['timeWindow']);
            }
            if (data.hasOwnProperty('charts')) {
                obj['charts'] = ApiClient.convertToType(data['charts'], [ChartChartOption]);
            }
            if (data.hasOwnProperty('sourceCode')) {
                obj['sourceCode'] = ApiClient.convertToType(data['sourceCode'], 'String');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>Dashboard</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>Dashboard</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of Dashboard.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
        // ensure the json data is a string
        if (data['title'] && !(typeof data['title'] === 'string' || data['title'] instanceof String)) {
            throw new Error("Expected the field `title` to be a primitive type in the JSON string but got " + data['title']);
        }
        // ensure the json data is a string
        if (data['description'] && !(typeof data['description'] === 'string' || data['description'] instanceof String)) {
            throw new Error("Expected the field `description` to be a primitive type in the JSON string but got " + data['description']);
        }
        // validate the optional field `timeWindow`
        if (data['timeWindow']) { // data not null
          TimeWindow.validateJSON(data['timeWindow']);
        }
        if (data['charts']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['charts'])) {
                throw new Error("Expected the field `charts` to be an array in the JSON data but got " + data['charts']);
            }
            // validate the optional field `charts` (array)
            for (const item of data['charts']) {
                ChartChartOption.validateJSON(item);
            };
        }
        // ensure the json data is a string
        if (data['sourceCode'] && !(typeof data['sourceCode'] === 'string' || data['sourceCode'] instanceof String)) {
            throw new Error("Expected the field `sourceCode` to be a primitive type in the JSON string but got " + data['sourceCode']);
        }

        return true;
    }


}

Dashboard.RequiredProperties = ["title"];

/**
 * @member {String} title
 */
Dashboard.prototype['title'] = undefined;

/**
 * @member {String} description
 */
Dashboard.prototype['description'] = undefined;

/**
 * @member {module:model/TimeWindow} timeWindow
 */
Dashboard.prototype['timeWindow'] = undefined;

/**
 * @member {Array.<module:model/ChartChartOption>} charts
 */
Dashboard.prototype['charts'] = undefined;

/**
 * @member {String} sourceCode
 */
Dashboard.prototype['sourceCode'] = undefined;






export default Dashboard;

