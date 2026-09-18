# BlueprintTemplate


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**source** | **str** |  | 
**template_arguments** | [**Dict[str, InputObject]**](InputObject.md) |  | [optional] 

## Example

```python
from kestrapy.models.blueprint_template import BlueprintTemplate

# TODO update the JSON string below
json = "{}"
# create an instance of BlueprintTemplate from a JSON string
blueprint_template_instance = BlueprintTemplate.from_json(json)
# print the JSON string representation of the object
print(BlueprintTemplate.to_json())

# convert the object into a dict
blueprint_template_dict = blueprint_template_instance.to_dict()
# create an instance of BlueprintTemplate from a dict
blueprint_template_from_dict = BlueprintTemplate.from_dict(blueprint_template_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


