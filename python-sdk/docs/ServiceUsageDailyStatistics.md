# ServiceUsageDailyStatistics


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | [optional] 
**min** | **int** |  | [optional] 
**max** | **int** |  | [optional] 
**avg** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.service_usage_daily_statistics import ServiceUsageDailyStatistics

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceUsageDailyStatistics from a JSON string
service_usage_daily_statistics_instance = ServiceUsageDailyStatistics.from_json(json)
# print the JSON string representation of the object
print(ServiceUsageDailyStatistics.to_json())

# convert the object into a dict
service_usage_daily_statistics_dict = service_usage_daily_statistics_instance.to_dict()
# create an instance of ServiceUsageDailyStatistics from a dict
service_usage_daily_statistics_from_dict = ServiceUsageDailyStatistics.from_dict(service_usage_daily_statistics_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


