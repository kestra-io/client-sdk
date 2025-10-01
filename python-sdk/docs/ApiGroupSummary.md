# ApiGroupSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.api_group_summary import ApiGroupSummary

# TODO update the JSON string below
json = "{}"
# create an instance of ApiGroupSummary from a JSON string
api_group_summary_instance = ApiGroupSummary.from_json(json)
# print the JSON string representation of the object
print(ApiGroupSummary.to_json())

# convert the object into a dict
api_group_summary_dict = api_group_summary_instance.to_dict()
# create an instance of ApiGroupSummary from a dict
api_group_summary_from_dict = ApiGroupSummary.from_dict(api_group_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


