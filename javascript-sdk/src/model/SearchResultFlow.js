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
import Flow from './Flow';

/**
 * The SearchResultFlow model module.
 * @module model/SearchResultFlow
 * @version v0.24.0
 */
class SearchResultFlow {
    /**
     * Constructs a new <code>SearchResultFlow</code>.
     * @alias module:model/SearchResultFlow
     */
    constructor() { 
        
        SearchResultFlow.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>SearchResultFlow</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/SearchResultFlow} obj Optional instance to populate.
     * @return {module:model/SearchResultFlow} The populated <code>SearchResultFlow</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new SearchResultFlow();

            if (data.hasOwnProperty('model')) {
                obj['model'] = Flow.constructFromObject(data['model']);
            }
            if (data.hasOwnProperty('fragments')) {
                obj['fragments'] = ApiClient.convertToType(data['fragments'], ['String']);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>SearchResultFlow</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>SearchResultFlow</code>.
     */
    static validateJSON(data) {
        // validate the optional field `model`
        if (data['model']) { // data not null
          Flow.validateJSON(data['model']);
        }
        // ensure the json data is an array
        if (!Array.isArray(data['fragments'])) {
            throw new Error("Expected the field `fragments` to be an array in the JSON data but got " + data['fragments']);
        }

        return true;
    }


}



/**
 * @member {module:model/Flow} model
 */
SearchResultFlow.prototype['model'] = undefined;

/**
 * @member {Array.<String>} fragments
 */
SearchResultFlow.prototype['fragments'] = undefined;






export default SearchResultFlow;

