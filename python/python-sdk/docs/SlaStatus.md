# SlaStatus


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**state** | [**SlaState**](SlaState.md) |  | [optional] 
**deadline** | **datetime** |  | [optional] 
**remaining** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.sla_status import SlaStatus

# TODO update the JSON string below
json = "{}"
# create an instance of SlaStatus from a JSON string
sla_status_instance = SlaStatus.from_json(json)
# print the JSON string representation of the object
print(SlaStatus.to_json())

# convert the object into a dict
sla_status_dict = sla_status_instance.to_dict()
# create an instance of SlaStatus from a dict
sla_status_from_dict = SlaStatus.from_dict(sla_status_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


