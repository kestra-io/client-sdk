# DependsOn


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**inputs** | **List[str]** |  | [optional] 
**condition** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.depends_on import DependsOn

# TODO update the JSON string below
json = "{}"
# create an instance of DependsOn from a JSON string
depends_on_instance = DependsOn.from_json(json)
# print the JSON string representation of the object
print(DependsOn.to_json())

# convert the object into a dict
depends_on_dict = depends_on_instance.to_dict()
# create an instance of DependsOn from a dict
depends_on_from_dict = DependsOn.from_dict(depends_on_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


