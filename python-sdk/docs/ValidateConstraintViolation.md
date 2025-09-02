# ValidateConstraintViolation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flow** | **str** |  | 
**namespace** | **str** |  | 
**index** | **int** |  | 
**constraints** | **str** |  | 
**outdated** | **bool** |  | 
**deprecation_paths** | **List[str]** |  | 
**warnings** | **List[str]** |  | 
**infos** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.validate_constraint_violation import ValidateConstraintViolation

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


