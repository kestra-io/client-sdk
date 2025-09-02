# ApiRoleSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**is_default** | **bool** |  | 
**is_managed** | **bool** |  | 

## Example

```python
from kestrapy.models.api_role_summary import ApiRoleSummary

# TODO update the JSON string below
json = "{}"
# create an instance of ApiRoleSummary from a JSON string
api_role_summary_instance = ApiRoleSummary.from_json(json)
# print the JSON string representation of the object
print(ApiRoleSummary.to_json())

# convert the object into a dict
api_role_summary_dict = api_role_summary_instance.to_dict()
# create an instance of ApiRoleSummary from a dict
api_role_summary_from_dict = ApiRoleSummary.from_dict(api_role_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


