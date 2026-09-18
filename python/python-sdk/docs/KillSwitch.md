# KillSwitch


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | 
**tenant_id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**execution_ids** | **List[str]** |  | [optional] 
**start_date** | **datetime** |  | 
**end_date** | **datetime** |  | [optional] 
**description** | **str** |  | [optional] 
**evaluation_type** | [**EvaluationType**](EvaluationType.md) |  | 
**enabled** | **bool** |  | [optional] 
**deleted** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.kill_switch import KillSwitch

# TODO update the JSON string below
json = "{}"
# create an instance of KillSwitch from a JSON string
kill_switch_instance = KillSwitch.from_json(json)
# print the JSON string representation of the object
print(KillSwitch.to_json())

# convert the object into a dict
kill_switch_dict = kill_switch_instance.to_dict()
# create an instance of KillSwitch from a dict
kill_switch_from_dict = KillSwitch.from_dict(kill_switch_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


