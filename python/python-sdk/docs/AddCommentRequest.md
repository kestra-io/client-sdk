# AddCommentRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**body** | **str** |  | [optional] 
**files** | **List[bytes]** |  | [optional] 

## Example

```python
from kestrapy.models.add_comment_request import AddCommentRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AddCommentRequest from a JSON string
add_comment_request_instance = AddCommentRequest.from_json(json)
# print the JSON string representation of the object
print(AddCommentRequest.to_json())

# convert the object into a dict
add_comment_request_dict = add_comment_request_instance.to_dict()
# create an instance of AddCommentRequest from a dict
add_comment_request_from_dict = AddCommentRequest.from_dict(add_comment_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


