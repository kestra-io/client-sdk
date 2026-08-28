# MaintenanceStatusResponseServices


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**executor** | [**MaintenanceStatusResponseServiceStatus**](MaintenanceStatusResponseServiceStatus.md) |  | [optional] 
**indexer** | [**MaintenanceStatusResponseServiceStatus**](MaintenanceStatusResponseServiceStatus.md) |  | [optional] 
**scheduler** | [**MaintenanceStatusResponseServiceStatus**](MaintenanceStatusResponseServiceStatus.md) |  | [optional] 
**webserver** | [**MaintenanceStatusResponseServiceStatus**](MaintenanceStatusResponseServiceStatus.md) |  | [optional] 
**worker** | [**MaintenanceStatusResponseServiceStatus**](MaintenanceStatusResponseServiceStatus.md) |  | [optional] 
**system_worker** | [**MaintenanceStatusResponseServiceStatus**](MaintenanceStatusResponseServiceStatus.md) |  | [optional] 
**controller** | [**MaintenanceStatusResponseServiceStatus**](MaintenanceStatusResponseServiceStatus.md) |  | [optional] 
**invalid** | [**MaintenanceStatusResponseServiceStatus**](MaintenanceStatusResponseServiceStatus.md) |  | [optional] 

## Example

```python
from kestrapy.models.maintenance_status_response_services import MaintenanceStatusResponseServices

# TODO update the JSON string below
json = "{}"
# create an instance of MaintenanceStatusResponseServices from a JSON string
maintenance_status_response_services_instance = MaintenanceStatusResponseServices.from_json(json)
# print the JSON string representation of the object
print(MaintenanceStatusResponseServices.to_json())

# convert the object into a dict
maintenance_status_response_services_dict = maintenance_status_response_services_instance.to_dict()
# create an instance of MaintenanceStatusResponseServices from a dict
maintenance_status_response_services_from_dict = MaintenanceStatusResponseServices.from_dict(maintenance_status_response_services_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


