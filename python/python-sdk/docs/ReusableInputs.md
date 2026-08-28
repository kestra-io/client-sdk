# ReusableInputs

A reusable set of inputs referenced from flows via a REUSABLE_INPUTS input.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** | Defaults to the namespace it is created in. | 
**id** | **str** |  | 
**description** | **str** |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | 

## Example

```python
from kestrapy.models.reusable_inputs import ReusableInputs

# TODO update the JSON string below
json = "{}"
# create an instance of ReusableInputs from a JSON string
reusable_inputs_instance = ReusableInputs.from_json(json)
# print the JSON string representation of the object
print(ReusableInputs.to_json())

# convert the object into a dict
reusable_inputs_dict = reusable_inputs_instance.to_dict()
# create an instance of ReusableInputs from a dict
reusable_inputs_from_dict = ReusableInputs.from_dict(reusable_inputs_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


