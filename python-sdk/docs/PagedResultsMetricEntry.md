# PagedResultsMetricEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[MetricEntry]**](MetricEntry.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_metric_entry import PagedResultsMetricEntry

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsMetricEntry from a JSON string
paged_results_metric_entry_instance = PagedResultsMetricEntry.from_json(json)
# print the JSON string representation of the object
print(PagedResultsMetricEntry.to_json())

# convert the object into a dict
paged_results_metric_entry_dict = paged_results_metric_entry_instance.to_dict()
# create an instance of PagedResultsMetricEntry from a dict
paged_results_metric_entry_from_dict = PagedResultsMetricEntry.from_dict(paged_results_metric_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


