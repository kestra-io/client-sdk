# FlowWorkerSelector

Routing requirements for a Flow, Task or Trigger. Unlike [WorkerSelector](WorkerSelector.md) (namespace and tenant defaults), `tags` is a Kestra property: a JSON array literal such as `["gpu"]` or a Pebble expression rendered when the job is routed. The server returns it as a string in both cases.


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tags** | **str** | Required tags used to route to a matching Worker Queue, as a JSON array literal (e.g. &#x60;[&quot;gpu&quot;]&#x60;) or a Pebble expression rendering to the tags. Each tag is an RFC 1123 label, max 63 chars per tag, max 20 tags; a tag rendering to an empty value is ignored. | [optional] 
**match** | [**WorkerSelectorMatch**](WorkerSelectorMatch.md) | How selector tags are matched against a Worker Queue&#39;s tag set. ALL: queue tags must be a superset of the selector tags. ANY: queue tags must intersect the selector tags. Defaults to ALL when null. | [optional] 
**fallback** | [**WorkerQueueFallback**](WorkerQueueFallback.md) | Strategy when no worker is available. Defaults to FAIL when null. | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.flow_worker_selector import FlowWorkerSelector

json = r'{"tags": "[\"gpu\"]", "match": "ALL"}'
# create an instance of FlowWorkerSelector from a JSON string
flow_worker_selector_instance = FlowWorkerSelector.from_json(json)
# print the JSON string representation of the object
print(flow_worker_selector_instance.to_json())

# convert the object into a dict
flow_worker_selector_dict = flow_worker_selector_instance.to_dict()
# create an instance of FlowWorkerSelector from a dict
flow_worker_selector_from_dict = FlowWorkerSelector.from_dict(flow_worker_selector_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


