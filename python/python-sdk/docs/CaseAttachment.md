# CaseAttachment


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**file_name** | **str** |  | [optional] 
**size** | **int** |  | [optional] 
**content_type** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.case_attachment import CaseAttachment

# TODO update the JSON string below
json = "{}"
# create an instance of CaseAttachment from a JSON string
case_attachment_instance = CaseAttachment.from_json(json)
# print the JSON string representation of the object
print(CaseAttachment.to_json())

# convert the object into a dict
case_attachment_dict = case_attachment_instance.to_dict()
# create an instance of CaseAttachment from a dict
case_attachment_from_dict = CaseAttachment.from_dict(case_attachment_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


