# RelationProvenance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**flow_revision** | **int** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**task_id** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 
**task_type** | **str** |  | [optional] 
**state** | [**StateType**](StateType.md) |  | [optional] 
**start_date** | **datetime** |  | [optional] 
**end_date** | **datetime** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.relation_provenance import RelationProvenance

# TODO update the JSON string below
json = "{}"
# create an instance of RelationProvenance from a JSON string
relation_provenance_instance = RelationProvenance.from_json(json)
# print the JSON string representation of the object
print(RelationProvenance.to_json())

# convert the object into a dict
relation_provenance_dict = relation_provenance_instance.to_dict()
# create an instance of RelationProvenance from a dict
relation_provenance_from_dict = RelationProvenance.from_dict(relation_provenance_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


