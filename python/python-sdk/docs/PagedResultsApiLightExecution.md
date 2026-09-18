# PagedResultsApiLightExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiLightExecution]**](ApiLightExecution.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_light_execution import PagedResultsApiLightExecution

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiLightExecution from a JSON string
paged_results_api_light_execution_instance = PagedResultsApiLightExecution.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiLightExecution.to_json())

# convert the object into a dict
paged_results_api_light_execution_dict = paged_results_api_light_execution_instance.to_dict()
# create an instance of PagedResultsApiLightExecution from a dict
paged_results_api_light_execution_from_dict = PagedResultsApiLightExecution.from_dict(paged_results_api_light_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


