# GroupIdentifier


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | [optional] 
**group_id** | **str** |  | [optional] 
**membership** | [**GroupIdentifierMembership**](GroupIdentifierMembership.md) |  | [optional] 
**managed_externally** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.group_identifier import GroupIdentifier

# TODO update the JSON string below
json = "{}"
# create an instance of GroupIdentifier from a JSON string
group_identifier_instance = GroupIdentifier.from_json(json)
# print the JSON string representation of the object
print(GroupIdentifier.to_json())

# convert the object into a dict
group_identifier_dict = group_identifier_instance.to_dict()
# create an instance of GroupIdentifier from a dict
group_identifier_from_dict = GroupIdentifier.from_dict(group_identifier_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


