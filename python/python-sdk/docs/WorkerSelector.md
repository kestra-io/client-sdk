# WorkerSelector


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tags** | **List[str]** | Required tags used to route to a matching Worker Queue. Each tag is an RFC 1123 label: lowercase alphanumerics and hyphens, must start and end with alphanumeric, max 64 chars per tag, max 20 tags. | [optional] 
**match** | [**WorkerSelectorMatch**](WorkerSelectorMatch.md) | How selector tags are matched against a Worker Queue&#39;s tag set. ALL: queue tags must be a superset of the selector tags. ANY: queue tags must intersect the selector tags. Defaults to ALL when null. | [optional] 
**fallback** | [**WorkerQueueFallback**](WorkerQueueFallback.md) | Strategy when no worker is available. Defaults to FAIL when null. | [optional] 

## Example

```python
from kestrapy.models.worker_selector import WorkerSelector

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerSelector from a JSON string
worker_selector_instance = WorkerSelector.from_json(json)
# print the JSON string representation of the object
print(WorkerSelector.to_json())

# convert the object into a dict
worker_selector_dict = worker_selector_instance.to_dict()
# create an instance of WorkerSelector from a dict
worker_selector_from_dict = WorkerSelector.from_dict(worker_selector_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


