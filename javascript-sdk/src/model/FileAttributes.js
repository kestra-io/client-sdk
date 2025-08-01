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
import FileAttributesFileType from './FileAttributesFileType';

/**
 * The FileAttributes model module.
 * @module model/FileAttributes
 * @version v0.24.0
 */
class FileAttributes {
    /**
     * Constructs a new <code>FileAttributes</code>.
     * @alias module:model/FileAttributes
     */
    constructor() { 
        
        FileAttributes.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>FileAttributes</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/FileAttributes} obj Optional instance to populate.
     * @return {module:model/FileAttributes} The populated <code>FileAttributes</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new FileAttributes();

            if (data.hasOwnProperty('fileName')) {
                obj['fileName'] = ApiClient.convertToType(data['fileName'], 'String');
            }
            if (data.hasOwnProperty('lastModifiedTime')) {
                obj['lastModifiedTime'] = ApiClient.convertToType(data['lastModifiedTime'], 'Number');
            }
            if (data.hasOwnProperty('creationTime')) {
                obj['creationTime'] = ApiClient.convertToType(data['creationTime'], 'Number');
            }
            if (data.hasOwnProperty('type')) {
                obj['type'] = FileAttributesFileType.constructFromObject(data['type']);
            }
            if (data.hasOwnProperty('size')) {
                obj['size'] = ApiClient.convertToType(data['size'], 'Number');
            }
            if (data.hasOwnProperty('metadata')) {
                obj['metadata'] = ApiClient.convertToType(data['metadata'], {'String': 'String'});
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>FileAttributes</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>FileAttributes</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['fileName'] && !(typeof data['fileName'] === 'string' || data['fileName'] instanceof String)) {
            throw new Error("Expected the field `fileName` to be a primitive type in the JSON string but got " + data['fileName']);
        }

        return true;
    }


}



/**
 * @member {String} fileName
 */
FileAttributes.prototype['fileName'] = undefined;

/**
 * @member {Number} lastModifiedTime
 */
FileAttributes.prototype['lastModifiedTime'] = undefined;

/**
 * @member {Number} creationTime
 */
FileAttributes.prototype['creationTime'] = undefined;

/**
 * @member {module:model/FileAttributesFileType} type
 */
FileAttributes.prototype['type'] = undefined;

/**
 * @member {Number} size
 */
FileAttributes.prototype['size'] = undefined;

/**
 * @member {Object.<String, String>} metadata
 */
FileAttributes.prototype['metadata'] = undefined;






export default FileAttributes;

