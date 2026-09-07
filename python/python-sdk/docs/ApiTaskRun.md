# ApiTaskRun


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**task_id** | **str** |  | 
**parent_task_run_id** | **str** |  | [optional] 
**value** | **str** |  | [optional] 
**attempts** | [**List[TaskRunAttempt]**](TaskRunAttempt.md) |  | [optional] 
**asset_emits** | [**List[AssetsInOut]**](AssetsInOut.md) |  | [optional] 
**state** | [**State**](State.md) |  | 
**iteration** | **int** |  | [optional] 
**dynamic** | **bool** |  | [optional] 
**force_execution** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.api_task_run import ApiTaskRun

# TODO update the JSON string below
json = "{}"
# create an instance of ApiTaskRun from a JSON string
api_task_run_instance = ApiTaskRun.from_json(json)
# print the JSON string representation of the object
print(ApiTaskRun.to_json())

# convert the object into a dict
api_task_run_dict = api_task_run_instance.to_dict()
# create an instance of ApiTaskRun from a dict
api_task_run_from_dict = ApiTaskRun.from_dict(api_task_run_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


