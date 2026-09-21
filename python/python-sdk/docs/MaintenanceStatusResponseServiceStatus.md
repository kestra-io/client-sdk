# MaintenanceStatusResponseServiceStatus


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total** | **int** |  | [optional] 
**in_maintenance** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.maintenance_status_response_service_status import MaintenanceStatusResponseServiceStatus

# TODO update the JSON string below
json = "{}"
# create an instance of MaintenanceStatusResponseServiceStatus from a JSON string
maintenance_status_response_service_status_instance = MaintenanceStatusResponseServiceStatus.from_json(json)
# print the JSON string representation of the object
print(MaintenanceStatusResponseServiceStatus.to_json())

# convert the object into a dict
maintenance_status_response_service_status_dict = maintenance_status_response_service_status_instance.to_dict()
# create an instance of MaintenanceStatusResponseServiceStatus from a dict
maintenance_status_response_service_status_from_dict = MaintenanceStatusResponseServiceStatus.from_dict(maintenance_status_response_service_status_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


