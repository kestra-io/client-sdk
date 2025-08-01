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
import AbstractFlow from './AbstractFlow';
import AbstractTrigger from './AbstractTrigger';
import Concurrency from './Concurrency';
import Flow from './Flow';
import FlowWithSourceAllOfLabels from './FlowWithSourceAllOfLabels';
import InputObject from './InputObject';
import Listener from './Listener';
import Output from './Output';
import PluginDefault from './PluginDefault';
import SLA from './SLA';
import Task from './Task';
import WorkerGroup from './WorkerGroup';

/**
 * The FlowWithSource model module.
 * @module model/FlowWithSource
 * @version v0.24.0
 */
class FlowWithSource {
    /**
     * Constructs a new <code>FlowWithSource</code>.
     * @alias module:model/FlowWithSource
     * @implements module:model/Flow
     * @implements module:model/AbstractFlow
     * @param id {String} 
     * @param namespace {String} 
     * @param disabled {Boolean} 
     * @param deleted {Boolean} 
     * @param tasks {Array.<module:model/Task>} 
     */
    constructor(id, namespace, disabled, deleted, tasks) { 
        Flow.initialize(this, id, namespace, disabled, deleted, tasks);AbstractFlow.initialize(this, id, namespace, disabled, deleted);
        FlowWithSource.initialize(this, id, namespace, disabled, deleted, tasks);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, id, namespace, disabled, deleted, tasks) { 
        obj['id'] = id;
        obj['namespace'] = namespace;
        obj['disabled'] = disabled;
        obj['deleted'] = deleted;
        obj['tasks'] = tasks;
    }

    /**
     * Constructs a <code>FlowWithSource</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/FlowWithSource} obj Optional instance to populate.
     * @return {module:model/FlowWithSource} The populated <code>FlowWithSource</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new FlowWithSource();
            Flow.constructFromObject(data, obj);
            AbstractFlow.constructFromObject(data, obj);

            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'String');
            }
            if (data.hasOwnProperty('namespace')) {
                obj['namespace'] = ApiClient.convertToType(data['namespace'], 'String');
            }
            if (data.hasOwnProperty('revision')) {
                obj['revision'] = ApiClient.convertToType(data['revision'], 'Number');
            }
            if (data.hasOwnProperty('inputs')) {
                obj['inputs'] = ApiClient.convertToType(data['inputs'], [InputObject]);
            }
            if (data.hasOwnProperty('outputs')) {
                obj['outputs'] = ApiClient.convertToType(data['outputs'], [Output]);
            }
            if (data.hasOwnProperty('disabled')) {
                obj['disabled'] = ApiClient.convertToType(data['disabled'], 'Boolean');
            }
            if (data.hasOwnProperty('labels')) {
                obj['labels'] = FlowWithSourceAllOfLabels.constructFromObject(data['labels']);
            }
            if (data.hasOwnProperty('variables')) {
                obj['variables'] = ApiClient.convertToType(data['variables'], {'String': Object});
            }
            if (data.hasOwnProperty('workerGroup')) {
                obj['workerGroup'] = WorkerGroup.constructFromObject(data['workerGroup']);
            }
            if (data.hasOwnProperty('deleted')) {
                obj['deleted'] = ApiClient.convertToType(data['deleted'], 'Boolean');
            }
            if (data.hasOwnProperty('finally')) {
                obj['finally'] = ApiClient.convertToType(data['finally'], [Task]);
            }
            if (data.hasOwnProperty('taskDefaults')) {
                obj['taskDefaults'] = ApiClient.convertToType(data['taskDefaults'], [PluginDefault]);
            }
            if (data.hasOwnProperty('description')) {
                obj['description'] = ApiClient.convertToType(data['description'], 'String');
            }
            if (data.hasOwnProperty('tasks')) {
                obj['tasks'] = ApiClient.convertToType(data['tasks'], [Task]);
            }
            if (data.hasOwnProperty('errors')) {
                obj['errors'] = ApiClient.convertToType(data['errors'], [Task]);
            }
            if (data.hasOwnProperty('listeners')) {
                obj['listeners'] = ApiClient.convertToType(data['listeners'], [Listener]);
            }
            if (data.hasOwnProperty('afterExecution')) {
                obj['afterExecution'] = ApiClient.convertToType(data['afterExecution'], [Task]);
            }
            if (data.hasOwnProperty('triggers')) {
                obj['triggers'] = ApiClient.convertToType(data['triggers'], [AbstractTrigger]);
            }
            if (data.hasOwnProperty('pluginDefaults')) {
                obj['pluginDefaults'] = ApiClient.convertToType(data['pluginDefaults'], [PluginDefault]);
            }
            if (data.hasOwnProperty('concurrency')) {
                obj['concurrency'] = Concurrency.constructFromObject(data['concurrency']);
            }
            if (data.hasOwnProperty('retry')) {
                obj['retry'] = ApiClient.convertToType(data['retry'], Object);
            }
            if (data.hasOwnProperty('sla')) {
                obj['sla'] = ApiClient.convertToType(data['sla'], [SLA]);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>FlowWithSource</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>FlowWithSource</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of FlowWithSource.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
        // ensure the json data is a string
        if (data['id'] && !(typeof data['id'] === 'string' || data['id'] instanceof String)) {
            throw new Error("Expected the field `id` to be a primitive type in the JSON string but got " + data['id']);
        }
        // ensure the json data is a string
        if (data['namespace'] && !(typeof data['namespace'] === 'string' || data['namespace'] instanceof String)) {
            throw new Error("Expected the field `namespace` to be a primitive type in the JSON string but got " + data['namespace']);
        }
        if (data['inputs']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['inputs'])) {
                throw new Error("Expected the field `inputs` to be an array in the JSON data but got " + data['inputs']);
            }
            // validate the optional field `inputs` (array)
            for (const item of data['inputs']) {
                InputObject.validateJSON(item);
            };
        }
        if (data['outputs']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['outputs'])) {
                throw new Error("Expected the field `outputs` to be an array in the JSON data but got " + data['outputs']);
            }
            // validate the optional field `outputs` (array)
            for (const item of data['outputs']) {
                Output.validateJSON(item);
            };
        }
        // validate the optional field `labels`
        if (data['labels']) { // data not null
          FlowWithSourceAllOfLabels.validateJSON(data['labels']);
        }
        // validate the optional field `workerGroup`
        if (data['workerGroup']) { // data not null
          WorkerGroup.validateJSON(data['workerGroup']);
        }
        if (data['finally']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['finally'])) {
                throw new Error("Expected the field `finally` to be an array in the JSON data but got " + data['finally']);
            }
            // validate the optional field `finally` (array)
            for (const item of data['finally']) {
                Task.validateJSON(item);
            };
        }
        if (data['taskDefaults']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['taskDefaults'])) {
                throw new Error("Expected the field `taskDefaults` to be an array in the JSON data but got " + data['taskDefaults']);
            }
            // validate the optional field `taskDefaults` (array)
            for (const item of data['taskDefaults']) {
                PluginDefault.validateJSON(item);
            };
        }
        // ensure the json data is a string
        if (data['description'] && !(typeof data['description'] === 'string' || data['description'] instanceof String)) {
            throw new Error("Expected the field `description` to be a primitive type in the JSON string but got " + data['description']);
        }
        if (data['tasks']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['tasks'])) {
                throw new Error("Expected the field `tasks` to be an array in the JSON data but got " + data['tasks']);
            }
            // validate the optional field `tasks` (array)
            for (const item of data['tasks']) {
                Task.validateJSON(item);
            };
        }
        if (data['errors']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['errors'])) {
                throw new Error("Expected the field `errors` to be an array in the JSON data but got " + data['errors']);
            }
            // validate the optional field `errors` (array)
            for (const item of data['errors']) {
                Task.validateJSON(item);
            };
        }
        if (data['listeners']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['listeners'])) {
                throw new Error("Expected the field `listeners` to be an array in the JSON data but got " + data['listeners']);
            }
            // validate the optional field `listeners` (array)
            for (const item of data['listeners']) {
                Listener.validateJSON(item);
            };
        }
        if (data['afterExecution']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['afterExecution'])) {
                throw new Error("Expected the field `afterExecution` to be an array in the JSON data but got " + data['afterExecution']);
            }
            // validate the optional field `afterExecution` (array)
            for (const item of data['afterExecution']) {
                Task.validateJSON(item);
            };
        }
        if (data['triggers']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['triggers'])) {
                throw new Error("Expected the field `triggers` to be an array in the JSON data but got " + data['triggers']);
            }
            // validate the optional field `triggers` (array)
            for (const item of data['triggers']) {
                AbstractTrigger.validateJSON(item);
            };
        }
        if (data['pluginDefaults']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['pluginDefaults'])) {
                throw new Error("Expected the field `pluginDefaults` to be an array in the JSON data but got " + data['pluginDefaults']);
            }
            // validate the optional field `pluginDefaults` (array)
            for (const item of data['pluginDefaults']) {
                PluginDefault.validateJSON(item);
            };
        }
        // validate the optional field `concurrency`
        if (data['concurrency']) { // data not null
          Concurrency.validateJSON(data['concurrency']);
        }
        if (data['sla']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['sla'])) {
                throw new Error("Expected the field `sla` to be an array in the JSON data but got " + data['sla']);
            }
            // validate the optional field `sla` (array)
            for (const item of data['sla']) {
                SLA.validateJSON(item);
            };
        }

        return true;
    }


}

FlowWithSource.RequiredProperties = ["id", "namespace", "disabled", "deleted", "tasks"];

/**
 * @member {String} id
 */
FlowWithSource.prototype['id'] = undefined;

/**
 * @member {String} namespace
 */
FlowWithSource.prototype['namespace'] = undefined;

/**
 * @member {Number} revision
 */
FlowWithSource.prototype['revision'] = undefined;

/**
 * @member {Array.<module:model/InputObject>} inputs
 */
FlowWithSource.prototype['inputs'] = undefined;

/**
 * Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages.
 * @member {Array.<module:model/Output>} outputs
 */
FlowWithSource.prototype['outputs'] = undefined;

/**
 * @member {Boolean} disabled
 */
FlowWithSource.prototype['disabled'] = undefined;

/**
 * @member {module:model/FlowWithSourceAllOfLabels} labels
 */
FlowWithSource.prototype['labels'] = undefined;

/**
 * @member {Object.<String, Object>} variables
 */
FlowWithSource.prototype['variables'] = undefined;

/**
 * @member {module:model/WorkerGroup} workerGroup
 */
FlowWithSource.prototype['workerGroup'] = undefined;

/**
 * @member {Boolean} deleted
 */
FlowWithSource.prototype['deleted'] = undefined;

/**
 * @member {Array.<module:model/Task>} finally
 */
FlowWithSource.prototype['finally'] = undefined;

/**
 * @member {Array.<module:model/PluginDefault>} taskDefaults
 */
FlowWithSource.prototype['taskDefaults'] = undefined;

/**
 * @member {String} description
 */
FlowWithSource.prototype['description'] = undefined;

/**
 * @member {Array.<module:model/Task>} tasks
 */
FlowWithSource.prototype['tasks'] = undefined;

/**
 * @member {Array.<module:model/Task>} errors
 */
FlowWithSource.prototype['errors'] = undefined;

/**
 * @member {Array.<module:model/Listener>} listeners
 */
FlowWithSource.prototype['listeners'] = undefined;

/**
 * @member {Array.<module:model/Task>} afterExecution
 */
FlowWithSource.prototype['afterExecution'] = undefined;

/**
 * @member {Array.<module:model/AbstractTrigger>} triggers
 */
FlowWithSource.prototype['triggers'] = undefined;

/**
 * @member {Array.<module:model/PluginDefault>} pluginDefaults
 */
FlowWithSource.prototype['pluginDefaults'] = undefined;

/**
 * @member {module:model/Concurrency} concurrency
 */
FlowWithSource.prototype['concurrency'] = undefined;

/**
 * @member {Object} retry
 */
FlowWithSource.prototype['retry'] = undefined;

/**
 * @member {Array.<module:model/SLA>} sla
 */
FlowWithSource.prototype['sla'] = undefined;


// Implement Flow interface:
/**
 * @member {String} id
 */
Flow.prototype['id'] = undefined;
/**
 * @member {String} namespace
 */
Flow.prototype['namespace'] = undefined;
/**
 * @member {Number} revision
 */
Flow.prototype['revision'] = undefined;
/**
 * @member {Array.<module:model/InputObject>} inputs
 */
Flow.prototype['inputs'] = undefined;
/**
 * Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages.
 * @member {Array.<module:model/Output>} outputs
 */
Flow.prototype['outputs'] = undefined;
/**
 * @member {Boolean} disabled
 */
Flow.prototype['disabled'] = undefined;
/**
 * @member {module:model/FlowAllOfLabels} labels
 */
Flow.prototype['labels'] = undefined;
/**
 * @member {Object.<String, Object>} variables
 */
Flow.prototype['variables'] = undefined;
/**
 * @member {module:model/WorkerGroup} workerGroup
 */
Flow.prototype['workerGroup'] = undefined;
/**
 * @member {Boolean} deleted
 */
Flow.prototype['deleted'] = undefined;
/**
 * @member {Array.<module:model/Task>} finally
 */
Flow.prototype['finally'] = undefined;
/**
 * @member {Array.<module:model/PluginDefault>} taskDefaults
 */
Flow.prototype['taskDefaults'] = undefined;
/**
 * @member {String} description
 */
Flow.prototype['description'] = undefined;
/**
 * @member {Array.<module:model/Task>} tasks
 */
Flow.prototype['tasks'] = undefined;
/**
 * @member {Array.<module:model/Task>} errors
 */
Flow.prototype['errors'] = undefined;
/**
 * @member {Array.<module:model/Listener>} listeners
 */
Flow.prototype['listeners'] = undefined;
/**
 * @member {Array.<module:model/Task>} afterExecution
 */
Flow.prototype['afterExecution'] = undefined;
/**
 * @member {Array.<module:model/AbstractTrigger>} triggers
 */
Flow.prototype['triggers'] = undefined;
/**
 * @member {Array.<module:model/PluginDefault>} pluginDefaults
 */
Flow.prototype['pluginDefaults'] = undefined;
/**
 * @member {module:model/Concurrency} concurrency
 */
Flow.prototype['concurrency'] = undefined;
/**
 * @member {Object} retry
 */
Flow.prototype['retry'] = undefined;
/**
 * @member {Array.<module:model/SLA>} sla
 */
Flow.prototype['sla'] = undefined;
// Implement AbstractFlow interface:
/**
 * @member {String} id
 */
AbstractFlow.prototype['id'] = undefined;
/**
 * @member {String} namespace
 */
AbstractFlow.prototype['namespace'] = undefined;
/**
 * @member {Number} revision
 */
AbstractFlow.prototype['revision'] = undefined;
/**
 * @member {Array.<module:model/InputObject>} inputs
 */
AbstractFlow.prototype['inputs'] = undefined;
/**
 * @member {Array.<module:model/Output>} outputs
 */
AbstractFlow.prototype['outputs'] = undefined;
/**
 * @member {Boolean} disabled
 */
AbstractFlow.prototype['disabled'] = undefined;
/**
 * @member {module:model/AbstractFlowLabels} labels
 */
AbstractFlow.prototype['labels'] = undefined;
/**
 * @member {Object.<String, Object>} variables
 */
AbstractFlow.prototype['variables'] = undefined;
/**
 * @member {module:model/WorkerGroup} workerGroup
 */
AbstractFlow.prototype['workerGroup'] = undefined;
/**
 * @member {Boolean} deleted
 */
AbstractFlow.prototype['deleted'] = undefined;




export default FlowWithSource;

