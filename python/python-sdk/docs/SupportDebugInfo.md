# SupportDebugInfo

Debug information collected automatically and attached to a support ticket.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**kestra_version** | **str** |  | 
**license_id** | **str** |  | [optional] 
**auth_type** | [**SupportDebugInfoAuthType**](SupportDebugInfoAuthType.md) |  | 
**deployment_type** | [**SupportDebugInfoDeploymentType**](SupportDebugInfoDeploymentType.md) |  | 
**deployment_topology** | [**SupportDebugInfoDeploymentTopology**](SupportDebugInfoDeploymentTopology.md) |  | 
**queue_type** | **str** |  | 
**queue_version** | **str** |  | [optional] 
**storage_type** | **str** |  | 
**repository_type** | **str** |  | 
**repository_version** | **str** |  | [optional] 
**secret_type** | **str** |  | 

## Example

```python
from kestrapy.models.support_debug_info import SupportDebugInfo

# TODO update the JSON string below
json = "{}"
# create an instance of SupportDebugInfo from a JSON string
support_debug_info_instance = SupportDebugInfo.from_json(json)
# print the JSON string representation of the object
print(SupportDebugInfo.to_json())

# convert the object into a dict
support_debug_info_dict = support_debug_info_instance.to_dict()
# create an instance of SupportDebugInfo from a dict
support_debug_info_from_dict = SupportDebugInfo.from_dict(support_debug_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


