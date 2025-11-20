# ConcurrencyLimit


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**running** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.concurrency_limit import ConcurrencyLimit

# TODO update the JSON string below
json = "{}"
# create an instance of ConcurrencyLimit from a JSON string
concurrency_limit_instance = ConcurrencyLimit.from_json(json)
# print the JSON string representation of the object
print(ConcurrencyLimit.to_json())

# convert the object into a dict
concurrency_limit_dict = concurrency_limit_instance.to_dict()
# create an instance of ConcurrencyLimit from a dict
concurrency_limit_from_dict = ConcurrencyLimit.from_dict(concurrency_limit_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


