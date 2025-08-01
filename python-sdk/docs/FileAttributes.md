# FileAttributes


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**file_name** | **str** |  | [optional] 
**last_modified_time** | **int** |  | [optional] 
**creation_time** | **int** |  | [optional] 
**type** | [**FileAttributesFileType**](FileAttributesFileType.md) |  | [optional] 
**size** | **int** |  | [optional] 
**metadata** | **Dict[str, str]** |  | [optional] 

## Example

```python
from kestrapy.models.file_attributes import FileAttributes

# TODO update the JSON string below
json = "{}"
# create an instance of FileAttributes from a JSON string
file_attributes_instance = FileAttributes.from_json(json)
# print the JSON string representation of the object
print(FileAttributes.to_json())

# convert the object into a dict
file_attributes_dict = file_attributes_instance.to_dict()
# create an instance of FileAttributes from a dict
file_attributes_from_dict = FileAttributes.from_dict(file_attributes_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


