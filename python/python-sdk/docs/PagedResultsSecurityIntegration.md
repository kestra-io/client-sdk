# PagedResultsSecurityIntegration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[SecurityIntegration]**](SecurityIntegration.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_security_integration import PagedResultsSecurityIntegration

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsSecurityIntegration from a JSON string
paged_results_security_integration_instance = PagedResultsSecurityIntegration.from_json(json)
# print the JSON string representation of the object
print(PagedResultsSecurityIntegration.to_json())

# convert the object into a dict
paged_results_security_integration_dict = paged_results_security_integration_instance.to_dict()
# create an instance of PagedResultsSecurityIntegration from a dict
paged_results_security_integration_from_dict = PagedResultsSecurityIntegration.from_dict(paged_results_security_integration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


