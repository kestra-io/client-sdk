# Assertion


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**value** | [**PropertyObject**](PropertyObject.md) |  | 
**task_id** | **str** |  | [optional] 
**error_message** | [**PropertyString**](PropertyString.md) |  | [optional] 
**description** | [**PropertyString**](PropertyString.md) |  | [optional] 
**ends_with** | [**PropertyString**](PropertyString.md) |  | [optional] 
**starts_with** | [**PropertyString**](PropertyString.md) |  | [optional] 
**contains** | [**PropertyString**](PropertyString.md) |  | [optional] 
**equal_to** | [**PropertyObject**](PropertyObject.md) |  | [optional] 
**not_equal_to** | [**PropertyObject**](PropertyObject.md) |  | [optional] 
**greater_than** | [**PropertyDouble**](PropertyDouble.md) |  | [optional] 
**greater_than_or_equal_to** | [**PropertyDouble**](PropertyDouble.md) |  | [optional] 
**less_than** | [**PropertyDouble**](PropertyDouble.md) |  | [optional] 
**less_than_or_equal_to** | [**PropertyDouble**](PropertyDouble.md) |  | [optional] 
**var_in** | [**PropertyListString**](PropertyListString.md) |  | [optional] 
**not_in** | [**PropertyListString**](PropertyListString.md) |  | [optional] 
**is_null** | [**PropertyBoolean**](PropertyBoolean.md) |  | [optional] 
**is_not_null** | [**PropertyBoolean**](PropertyBoolean.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.assertion import Assertion

# TODO update the JSON string below
json = "{}"
# create an instance of Assertion from a JSON string
assertion_instance = Assertion.from_json(json)
# print the JSON string representation of the object
print(Assertion.to_json())

# convert the object into a dict
assertion_dict = assertion_instance.to_dict()
# create an instance of Assertion from a dict
assertion_from_dict = Assertion.from_dict(assertion_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


