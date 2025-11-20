# SetAppsCatalogLogoRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**logo** | **bytearray** | The logo file | [optional] 

## Example

```python
from kestrapy.models.set_apps_catalog_logo_request import SetAppsCatalogLogoRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetAppsCatalogLogoRequest from a JSON string
set_apps_catalog_logo_request_instance = SetAppsCatalogLogoRequest.from_json(json)
# print the JSON string representation of the object
print(SetAppsCatalogLogoRequest.to_json())

# convert the object into a dict
set_apps_catalog_logo_request_dict = set_apps_catalog_logo_request_instance.to_dict()
# create an instance of SetAppsCatalogLogoRequest from a dict
set_apps_catalog_logo_request_from_dict = SetAppsCatalogLogoRequest.from_dict(set_apps_catalog_logo_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


