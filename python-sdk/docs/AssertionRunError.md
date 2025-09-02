# AssertionRunError


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**message** | **str** |  | 
**details** | **str** |  | 

## Example

```python
from kestrapy.models.assertion_run_error import AssertionRunError

# TODO update the JSON string below
json = "{}"
# create an instance of AssertionRunError from a JSON string
assertion_run_error_instance = AssertionRunError.from_json(json)
# print the JSON string representation of the object
print(AssertionRunError.to_json())

# convert the object into a dict
assertion_run_error_dict = assertion_run_error_instance.to_dict()
# create an instance of AssertionRunError from a dict
assertion_run_error_from_dict = AssertionRunError.from_dict(assertion_run_error_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


