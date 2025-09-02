# Concurrency


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**limit** | **int** |  | 
**behavior** | [**ConcurrencyBehavior**](ConcurrencyBehavior.md) |  | 

## Example

```python
from kestra_api_client.models.concurrency import Concurrency

# TODO update the JSON string below
json = "{}"
# create an instance of Concurrency from a JSON string
concurrency_instance = Concurrency.from_json(json)
# print the JSON string representation of the object
print(Concurrency.to_json())

# convert the object into a dict
concurrency_dict = concurrency_instance.to_dict()
# create an instance of Concurrency from a dict
concurrency_from_dict = Concurrency.from_dict(concurrency_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


