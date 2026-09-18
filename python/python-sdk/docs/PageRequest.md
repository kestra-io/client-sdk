# PageRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start_index** | **int** |  | [optional] 
**count** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.page_request import PageRequest

# TODO update the JSON string below
json = "{}"
# create an instance of PageRequest from a JSON string
page_request_instance = PageRequest.from_json(json)
# print the JSON string representation of the object
print(PageRequest.to_json())

# convert the object into a dict
page_request_dict = page_request_instance.to_dict()
# create an instance of PageRequest from a dict
page_request_from_dict = PageRequest.from_dict(page_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


