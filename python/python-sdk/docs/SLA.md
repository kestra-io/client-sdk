# SLA


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | [**SLAType**](SLAType.md) |  | 
**behavior** | [**SLABehavior**](SLABehavior.md) |  | 
**labels** | [**SLALabels**](SLALabels.md) |  | [optional] 

## Example

```python
from kestrapy.models.sla import SLA

# TODO update the JSON string below
json = "{}"
# create an instance of SLA from a JSON string
sla_instance = SLA.from_json(json)
# print the JSON string representation of the object
print(SLA.to_json())

# convert the object into a dict
sla_dict = sla_instance.to_dict()
# create an instance of SLA from a dict
sla_from_dict = SLA.from_dict(sla_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


