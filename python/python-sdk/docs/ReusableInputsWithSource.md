# ReusableInputsWithSource

A stored reusable inputs block: its authorable shape plus the fields the server owns.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** | Defaults to the namespace it is created in. | 
**id** | **str** |  | 
**description** | **str** |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | 
**revision** | **int** | The revision of the block, bumped on every save. | [readonly] 
**last** | **bool** | Whether this is the block&#39;s current revision. | [optional] [readonly] 
**created** | **datetime** | When the block was first created. | [optional] [readonly] 
**updated** | **datetime** | When this revision was created. | [optional] [readonly] 
**deleted** | **bool** | Whether the block is soft-deleted. | [optional] [readonly] 
**source** | **str** | The block&#39;s YAML source, as written in the editor. | [optional] [readonly] 

## Example

```python
from kestrapy.models.reusable_inputs_with_source import ReusableInputsWithSource

# TODO update the JSON string below
json = "{}"
# create an instance of ReusableInputsWithSource from a JSON string
reusable_inputs_with_source_instance = ReusableInputsWithSource.from_json(json)
# print the JSON string representation of the object
print(ReusableInputsWithSource.to_json())

# convert the object into a dict
reusable_inputs_with_source_dict = reusable_inputs_with_source_instance.to_dict()
# create an instance of ReusableInputsWithSource from a dict
reusable_inputs_with_source_from_dict = ReusableInputsWithSource.from_dict(reusable_inputs_with_source_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


