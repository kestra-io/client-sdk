# ApiPolicyImportResultError


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**document** | **str** |  | [optional] 
**message** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.api_policy_import_result_error import ApiPolicyImportResultError

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPolicyImportResultError from a JSON string
api_policy_import_result_error_instance = ApiPolicyImportResultError.from_json(json)
# print the JSON string representation of the object
print(ApiPolicyImportResultError.to_json())

# convert the object into a dict
api_policy_import_result_error_dict = api_policy_import_result_error_instance.to_dict()
# create an instance of ApiPolicyImportResultError from a dict
api_policy_import_result_error_from_dict = ApiPolicyImportResultError.from_dict(api_policy_import_result_error_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


