# PolicyImportResult

Result of a policy import: how many policies were imported, plus per-document errors (valid documents still import).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**imported** | **int** |  | [optional] 
**errors** | [**List[ApiPolicyImportResultError]**](ApiPolicyImportResultError.md) |  | [optional] 

## Example

```python
from kestrapy.models.policy_import_result import PolicyImportResult

# TODO update the JSON string below
json = "{}"
# create an instance of PolicyImportResult from a JSON string
policy_import_result_instance = PolicyImportResult.from_json(json)
# print the JSON string representation of the object
print(PolicyImportResult.to_json())

# convert the object into a dict
policy_import_result_dict = policy_import_result_instance.to_dict()
# create an instance of PolicyImportResult from a dict
policy_import_result_from_dict = PolicyImportResult.from_dict(policy_import_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


