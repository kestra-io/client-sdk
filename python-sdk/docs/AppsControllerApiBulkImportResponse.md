# AppsControllerApiBulkImportResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | **List[str]** |  | [optional] 
**errors** | [**List[AppsControllerApiBulkImportResponseError]**](AppsControllerApiBulkImportResponseError.md) |  | [optional] 

## Example

```python
from kestrapy.models.apps_controller_api_bulk_import_response import AppsControllerApiBulkImportResponse

# TODO update the JSON string below
json = "{}"
# create an instance of AppsControllerApiBulkImportResponse from a JSON string
apps_controller_api_bulk_import_response_instance = AppsControllerApiBulkImportResponse.from_json(json)
# print the JSON string representation of the object
print(AppsControllerApiBulkImportResponse.to_json())

# convert the object into a dict
apps_controller_api_bulk_import_response_dict = apps_controller_api_bulk_import_response_instance.to_dict()
# create an instance of AppsControllerApiBulkImportResponse from a dict
apps_controller_api_bulk_import_response_from_dict = AppsControllerApiBulkImportResponse.from_dict(apps_controller_api_bulk_import_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


