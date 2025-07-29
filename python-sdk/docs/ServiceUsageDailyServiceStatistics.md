# ServiceUsageDailyServiceStatistics


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | [optional] 
**values** | [**List[ServiceUsageDailyStatistics]**](ServiceUsageDailyStatistics.md) |  | [optional] 

## Example

```python
from kestrapy.models.service_usage_daily_service_statistics import ServiceUsageDailyServiceStatistics

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceUsageDailyServiceStatistics from a JSON string
service_usage_daily_service_statistics_instance = ServiceUsageDailyServiceStatistics.from_json(json)
# print the JSON string representation of the object
print(ServiceUsageDailyServiceStatistics.to_json())

# convert the object into a dict
service_usage_daily_service_statistics_dict = service_usage_daily_service_statistics_instance.to_dict()
# create an instance of ServiceUsageDailyServiceStatistics from a dict
service_usage_daily_service_statistics_from_dict = ServiceUsageDailyServiceStatistics.from_dict(service_usage_daily_service_statistics_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


