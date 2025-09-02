# PagedResultsTestSuite


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[TestSuite]**](TestSuite.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_test_suite import PagedResultsTestSuite

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsTestSuite from a JSON string
paged_results_test_suite_instance = PagedResultsTestSuite.from_json(json)
# print the JSON string representation of the object
print(PagedResultsTestSuite.to_json())

# convert the object into a dict
paged_results_test_suite_dict = paged_results_test_suite_instance.to_dict()
# create an instance of PagedResultsTestSuite from a dict
paged_results_test_suite_from_dict = PagedResultsTestSuite.from_dict(paged_results_test_suite_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


