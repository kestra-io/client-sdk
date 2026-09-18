# MaintenanceStatusResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**maintenance** | **bool** |  | [optional] 
**ready** | **bool** |  | [optional] 
**services** | [**MaintenanceStatusResponseServices**](MaintenanceStatusResponseServices.md) |  | [optional] 

## Example

```python
from kestrapy.models.maintenance_status_response import MaintenanceStatusResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MaintenanceStatusResponse from a JSON string
maintenance_status_response_instance = MaintenanceStatusResponse.from_json(json)
# print the JSON string representation of the object
print(MaintenanceStatusResponse.to_json())

# convert the object into a dict
maintenance_status_response_dict = maintenance_status_response_instance.to_dict()
# create an instance of MaintenanceStatusResponse from a dict
maintenance_status_response_from_dict = MaintenanceStatusResponse.from_dict(maintenance_status_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


