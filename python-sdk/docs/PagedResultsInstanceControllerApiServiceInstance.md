# PagedResultsInstanceControllerApiServiceInstance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[InstanceControllerApiServiceInstance]**](InstanceControllerApiServiceInstance.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_instance_controller_api_service_instance import PagedResultsInstanceControllerApiServiceInstance

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsInstanceControllerApiServiceInstance from a JSON string
paged_results_instance_controller_api_service_instance_instance = PagedResultsInstanceControllerApiServiceInstance.from_json(json)
# print the JSON string representation of the object
print(PagedResultsInstanceControllerApiServiceInstance.to_json())

# convert the object into a dict
paged_results_instance_controller_api_service_instance_dict = paged_results_instance_controller_api_service_instance_instance.to_dict()
# create an instance of PagedResultsInstanceControllerApiServiceInstance from a dict
paged_results_instance_controller_api_service_instance_from_dict = PagedResultsInstanceControllerApiServiceInstance.from_dict(paged_results_instance_controller_api_service_instance_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


