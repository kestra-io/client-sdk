# PagedResultsCasesControllerApiCase


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[CasesControllerApiCase]**](CasesControllerApiCase.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_cases_controller_api_case import PagedResultsCasesControllerApiCase

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsCasesControllerApiCase from a JSON string
paged_results_cases_controller_api_case_instance = PagedResultsCasesControllerApiCase.from_json(json)
# print the JSON string representation of the object
print(PagedResultsCasesControllerApiCase.to_json())

# convert the object into a dict
paged_results_cases_controller_api_case_dict = paged_results_cases_controller_api_case_instance.to_dict()
# create an instance of PagedResultsCasesControllerApiCase from a dict
paged_results_cases_controller_api_case_from_dict = PagedResultsCasesControllerApiCase.from_dict(paged_results_cases_controller_api_case_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


