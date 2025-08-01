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
 * The ConversionServiceProvider model module.
 * @module model/ConversionServiceProvider
 * @version v0.24.0
 */
class ConversionServiceProvider {
    /**
     * Constructs a new <code>ConversionServiceProvider</code>.
     * @alias module:model/ConversionServiceProvider
     * @param conversionService {Object} 
     */
    constructor(conversionService) { 
        
        ConversionServiceProvider.initialize(this, conversionService);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, conversionService) { 
        obj['conversionService'] = conversionService;
    }

    /**
     * Constructs a <code>ConversionServiceProvider</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/ConversionServiceProvider} obj Optional instance to populate.
     * @return {module:model/ConversionServiceProvider} The populated <code>ConversionServiceProvider</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new ConversionServiceProvider();

            if (data.hasOwnProperty('conversionService')) {
                obj['conversionService'] = ApiClient.convertToType(data['conversionService'], Object);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>ConversionServiceProvider</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>ConversionServiceProvider</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of ConversionServiceProvider.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }

        return true;
    }


}

ConversionServiceProvider.RequiredProperties = ["conversionService"];

/**
 * @member {Object} conversionService
 */
ConversionServiceProvider.prototype['conversionService'] = undefined;






export default ConversionServiceProvider;

