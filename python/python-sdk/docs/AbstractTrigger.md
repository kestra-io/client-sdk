# AbstractTrigger


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**version** | **str** | Defines the version of the plugin to use.  The version must follow the Semantic Versioning (SemVer) specification:   - A single-digit MAJOR version (e.g., &#x60;1&#x60;).   - A MAJOR.MINOR version (e.g., &#x60;1.1&#x60;).   - A MAJOR.MINOR.PATCH version, optionally with any qualifier     (e.g., &#x60;1.1.2&#x60;, &#x60;1.1.0-SNAPSHOT&#x60;).  | [optional] 
**description** | **str** |  | [optional] 
**when** | **str** | A Pebble expression evaluated at trigger time. The trigger fires only when the expression evaluates to a truthy value (&#x60;true&#x60;, a non-empty string, a non-zero number). Use this to gate trigger execution on dynamic runtime values such as execution labels, flow variables, or environment conditions. | 
**disabled** | **bool** |  | [optional] [default to False]
**worker_selector** | [**WorkerSelector**](WorkerSelector.md) | Routing requirements (tags + fallback) for this trigger. | [optional] 
**policy_refs** | **List[str]** | Identifiers of &#x60;enforcement: REFERENCE&#x60; governance policies to attach to this trigger and everything nested under it (Enterprise Edition; ignored in the open-source edition). | [optional] 
**log_level** | [**Level**](Level.md) |  | [optional] 
**labels** | [**TheLabelsToPassToTheExecutionCreated**](TheLabelsToPassToTheExecutionCreated.md) |  | [optional] 
**stop_after** | [**List[StateType]**](StateType.md) |  | [optional] 
**log_to_file** | **bool** |  | [optional] 
**fail_on_trigger_error** | **bool** |  | [optional] 
**allow_concurrent** | **bool** |  | [optional] 
**assets** | [**AssetsDeclaration**](AssetsDeclaration.md) |  | [optional] 

## Example

```python
from kestrapy.models.abstract_trigger import AbstractTrigger

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractTrigger from a JSON string
abstract_trigger_instance = AbstractTrigger.from_json(json)
# print the JSON string representation of the object
print(AbstractTrigger.to_json())

# convert the object into a dict
abstract_trigger_dict = abstract_trigger_instance.to_dict()
# create an instance of AbstractTrigger from a dict
abstract_trigger_from_dict = AbstractTrigger.from_dict(abstract_trigger_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


