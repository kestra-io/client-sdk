# ApiPatchInstanceOwnerRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instance_owner** | **bool** |  | 

## Example

```python
from kestrapy.models.api_patch_instance_owner_request import ApiPatchInstanceOwnerRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPatchInstanceOwnerRequest from a JSON string
api_patch_instance_owner_request_instance = ApiPatchInstanceOwnerRequest.from_json(json)
# print the JSON string representation of the object
print(ApiPatchInstanceOwnerRequest.to_json())

# convert the object into a dict
api_patch_instance_owner_request_dict = api_patch_instance_owner_request_instance.to_dict()
# create an instance of ApiPatchInstanceOwnerRequest from a dict
api_patch_instance_owner_request_from_dict = ApiPatchInstanceOwnerRequest.from_dict(api_patch_instance_owner_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


