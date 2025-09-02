# Blueprint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**title** | **str** |  | 
**description** | **str** |  | 
**tags** | **List[str]** |  | 
**included_tasks** | **List[str]** |  | 
**published_at** | **datetime** |  | 
**deleted** | **bool** |  | 

## Example

```python
from kestra_api_client.models.blueprint import Blueprint

# TODO update the JSON string below
json = "{}"
# create an instance of Blueprint from a JSON string
blueprint_instance = Blueprint.from_json(json)
# print the JSON string representation of the object
print(Blueprint.to_json())

# convert the object into a dict
blueprint_dict = blueprint_instance.to_dict()
# create an instance of Blueprint from a dict
blueprint_from_dict = Blueprint.from_dict(blueprint_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


