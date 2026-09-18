# SecurityIntegration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**type** | [**SecurityIntegrationType**](SecurityIntegrationType.md) |  | [optional] 
**description** | **str** |  | [optional] 
**tenant_id** | **str** |  | [optional] 
**enabled** | **bool** |  | [optional] 
**deleted** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.security_integration import SecurityIntegration

# TODO update the JSON string below
json = "{}"
# create an instance of SecurityIntegration from a JSON string
security_integration_instance = SecurityIntegration.from_json(json)
# print the JSON string representation of the object
print(SecurityIntegration.to_json())

# convert the object into a dict
security_integration_dict = security_integration_instance.to_dict()
# create an instance of SecurityIntegration from a dict
security_integration_from_dict = SecurityIntegration.from_dict(security_integration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


