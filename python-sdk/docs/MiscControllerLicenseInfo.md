# MiscControllerLicenseInfo


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | 
**expiry** | **datetime** |  | 
**expired** | **bool** |  | 
**max_servers** | **int** |  | 
**standalone** | **bool** |  | 
**worker_groups** | **bool** |  | 

## Example

```python
from kestrapy.models.misc_controller_license_info import MiscControllerLicenseInfo

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerLicenseInfo from a JSON string
misc_controller_license_info_instance = MiscControllerLicenseInfo.from_json(json)
# print the JSON string representation of the object
print(MiscControllerLicenseInfo.to_json())

# convert the object into a dict
misc_controller_license_info_dict = misc_controller_license_info_instance.to_dict()
# create an instance of MiscControllerLicenseInfo from a dict
misc_controller_license_info_from_dict = MiscControllerLicenseInfo.from_dict(misc_controller_license_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


