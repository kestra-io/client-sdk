# Cache


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**enabled** | **bool** |  | 
**ttl** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.cache import Cache

# TODO update the JSON string below
json = "{}"
# create an instance of Cache from a JSON string
cache_instance = Cache.from_json(json)
# print the JSON string representation of the object
print(Cache.to_json())

# convert the object into a dict
cache_dict = cache_instance.to_dict()
# create an instance of Cache from a dict
cache_from_dict = Cache.from_dict(cache_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


