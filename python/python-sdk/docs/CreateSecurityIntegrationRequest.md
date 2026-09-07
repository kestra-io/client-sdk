# CreateSecurityIntegrationRequest

Create SecurityIntegration Request

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** | The name of security integration. | 
**description** | **str** | The description of security integration. | 
**type** | [**SecurityIntegrationType**](SecurityIntegrationType.md) |  | 

## Example

```python
from kestrapy.models.create_security_integration_request import CreateSecurityIntegrationRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateSecurityIntegrationRequest from a JSON string
create_security_integration_request_instance = CreateSecurityIntegrationRequest.from_json(json)
# print the JSON string representation of the object
print(CreateSecurityIntegrationRequest.to_json())

# convert the object into a dict
create_security_integration_request_dict = create_security_integration_request_instance.to_dict()
# create an instance of CreateSecurityIntegrationRequest from a dict
create_security_integration_request_from_dict = CreateSecurityIntegrationRequest.from_dict(create_security_integration_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


