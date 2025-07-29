# ExecutionMetadata


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attempt_number** | **int** |  | [optional] 
**original_created_date** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.execution_metadata import ExecutionMetadata

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionMetadata from a JSON string
execution_metadata_instance = ExecutionMetadata.from_json(json)
# print the JSON string representation of the object
print(ExecutionMetadata.to_json())

# convert the object into a dict
execution_metadata_dict = execution_metadata_instance.to_dict()
# create an instance of ExecutionMetadata from a dict
execution_metadata_from_dict = ExecutionMetadata.from_dict(execution_metadata_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


