# TenantInterface


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.tenant_interface import TenantInterface

# TODO update the JSON string below
json = "{}"
# create an instance of TenantInterface from a JSON string
tenant_interface_instance = TenantInterface.from_json(json)
# print the JSON string representation of the object
print(TenantInterface.to_json())

# convert the object into a dict
tenant_interface_dict = tenant_interface_instance.to_dict()
# create an instance of TenantInterface from a dict
tenant_interface_from_dict = TenantInterface.from_dict(tenant_interface_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


