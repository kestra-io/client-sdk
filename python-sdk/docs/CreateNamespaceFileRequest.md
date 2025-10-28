# CreateNamespaceFileRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**file_content** | **bytearray** | The file to upload | [optional] 

## Example

```python
from kestrapy.models.create_namespace_file_request import CreateNamespaceFileRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateNamespaceFileRequest from a JSON string
create_namespace_file_request_instance = CreateNamespaceFileRequest.from_json(json)
# print the JSON string representation of the object
print(CreateNamespaceFileRequest.to_json())

# convert the object into a dict
create_namespace_file_request_dict = create_namespace_file_request_instance.to_dict()
# create an instance of CreateNamespaceFileRequest from a dict
create_namespace_file_request_from_dict = CreateNamespaceFileRequest.from_dict(create_namespace_file_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


