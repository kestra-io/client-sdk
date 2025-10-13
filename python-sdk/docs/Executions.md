# Executions


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodes** | [**List[AbstractGraph]**](AbstractGraph.md) |  | [optional] 
**edges** | [**List[FlowGraphEdge]**](FlowGraphEdge.md) |  | [optional] 
**clusters** | [**List[FlowGraphCluster]**](FlowGraphCluster.md) |  | [optional] 
**flowables** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.executions import Executions

# TODO update the JSON string below
json = "{}"
# create an instance of Executions from a JSON string
executions_instance = Executions.from_json(json)
# print the JSON string representation of the object
print(Executions.to_json())

# convert the object into a dict
executions_dict = executions_instance.to_dict()
# create an instance of Executions from a dict
executions_from_dict = Executions.from_dict(executions_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


