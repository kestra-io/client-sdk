# SLALabels


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**empty** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.sla_labels import SLALabels

# TODO update the JSON string below
json = "{}"
# create an instance of SLALabels from a JSON string
sla_labels_instance = SLALabels.from_json(json)
# print the JSON string representation of the object
print(SLALabels.to_json())

# convert the object into a dict
sla_labels_dict = sla_labels_instance.to_dict()
# create an instance of SLALabels from a dict
sla_labels_from_dict = SLALabels.from_dict(sla_labels_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


