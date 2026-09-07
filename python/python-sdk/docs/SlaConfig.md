# SlaConfig


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**acknowledgement** | **str** |  | [optional] 
**resolution** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.sla_config import SlaConfig

# TODO update the JSON string below
json = "{}"
# create an instance of SlaConfig from a JSON string
sla_config_instance = SlaConfig.from_json(json)
# print the JSON string representation of the object
print(SlaConfig.to_json())

# convert the object into a dict
sla_config_dict = sla_config_instance.to_dict()
# create an instance of SlaConfig from a dict
sla_config_from_dict = SlaConfig.from_dict(sla_config_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


