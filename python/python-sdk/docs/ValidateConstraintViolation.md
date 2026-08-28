# ValidateConstraintViolation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**index** | **int** |  | 
**filename** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow** | **str** |  | [optional] 
**constraints** | **str** |  | [optional] 
**outdated** | **bool** |  | [optional] 
**deprecation_paths** | **List[str]** |  | [optional] 
**warnings** | **List[str]** |  | [optional] 
**infos** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation

# TODO update the JSON string below
json = "{}"
# create an instance of ValidateConstraintViolation from a JSON string
validate_constraint_violation_instance = ValidateConstraintViolation.from_json(json)
# print the JSON string representation of the object
print(ValidateConstraintViolation.to_json())

# convert the object into a dict
validate_constraint_violation_dict = validate_constraint_violation_instance.to_dict()
# create an instance of ValidateConstraintViolation from a dict
validate_constraint_violation_from_dict = ValidateConstraintViolation.from_dict(validate_constraint_violation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


