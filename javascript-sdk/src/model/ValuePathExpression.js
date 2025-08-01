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
import AttributeReference from './AttributeReference';

/**
 * The ValuePathExpression model module.
 * @module model/ValuePathExpression
 * @version v0.24.0
 */
class ValuePathExpression {
    /**
     * Constructs a new <code>ValuePathExpression</code>.
     * @alias module:model/ValuePathExpression
     */
    constructor() { 
        
        ValuePathExpression.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>ValuePathExpression</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/ValuePathExpression} obj Optional instance to populate.
     * @return {module:model/ValuePathExpression} The populated <code>ValuePathExpression</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new ValuePathExpression();

            if (data.hasOwnProperty('attributePath')) {
                obj['attributePath'] = AttributeReference.constructFromObject(data['attributePath']);
            }
            if (data.hasOwnProperty('attributeExpression')) {
                obj['attributeExpression'] = ApiClient.convertToType(data['attributeExpression'], Object);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>ValuePathExpression</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>ValuePathExpression</code>.
     */
    static validateJSON(data) {
        // validate the optional field `attributePath`
        if (data['attributePath']) { // data not null
          AttributeReference.validateJSON(data['attributePath']);
        }

        return true;
    }


}



/**
 * @member {module:model/AttributeReference} attributePath
 */
ValuePathExpression.prototype['attributePath'] = undefined;

/**
 * @member {Object} attributeExpression
 */
ValuePathExpression.prototype['attributeExpression'] = undefined;






export default ValuePathExpression;

