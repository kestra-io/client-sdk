# Task


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**version** | **str** | Defines the version of the plugin to use.  The version must follow the Semantic Versioning (SemVer) specification:   - A single-digit MAJOR version (e.g., &#x60;1&#x60;).   - A MAJOR.MINOR version (e.g., &#x60;1.1&#x60;).   - A MAJOR.MINOR.PATCH version, optionally with any qualifier     (e.g., &#x60;1.1.2&#x60;, &#x60;1.1.0-SNAPSHOT&#x60;).  | [optional] 
**description** | **str** |  | [optional] 
**retry** | **object** | Retry policy applied when the task fails. | [optional] 
**timeout** | [**PropertyDuration**](PropertyDuration.md) |  | [optional] 
**disabled** | **bool** |  | [optional] 
**worker_selector** | [**WorkerSelector**](WorkerSelector.md) | Routing requirements (tags + fallback) for this task. | [optional] 
**policy_refs** | **List[str]** | Identifiers of &#x60;enforcement: REFERENCE&#x60; governance policies to attach to this task and everything nested under it (Enterprise Edition; ignored in the open-source edition). | [optional] 
**log_level** | [**Level**](Level.md) |  | [optional] 
**allow_failure** | **bool** |  | [optional] 
**log_to_file** | **bool** |  | [optional] 
**run_if** | **str** |  | [optional] 
**allow_warning** | **bool** |  | [optional] 
**task_cache** | [**Cache**](Cache.md) |  | [optional] 
**assets** | [**AssetsDeclaration**](AssetsDeclaration.md) |  | [optional] 

## Example

```python
from kestrapy.models.task import Task

# TODO update the JSON string below
json = "{}"
# create an instance of Task from a JSON string
task_instance = Task.from_json(json)
# print the JSON string representation of the object
print(Task.to_json())

# convert the object into a dict
task_dict = task_instance.to_dict()
# create an instance of Task from a dict
task_from_dict = Task.from_dict(task_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


