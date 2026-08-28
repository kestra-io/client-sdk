# ImportPoliciesRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**file_upload** | **bytes** |  | [optional] 

## Example

```python
from kestrapy.models.import_policies_request import ImportPoliciesRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ImportPoliciesRequest from a JSON string
import_policies_request_instance = ImportPoliciesRequest.from_json(json)
# print the JSON string representation of the object
print(ImportPoliciesRequest.to_json())

# convert the object into a dict
import_policies_request_dict = import_policies_request_instance.to_dict()
# create an instance of ImportPoliciesRequest from a dict
import_policies_request_from_dict = ImportPoliciesRequest.from_dict(import_policies_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


