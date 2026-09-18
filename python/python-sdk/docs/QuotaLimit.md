# QuotaLimit


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**start** | **datetime** |  | [optional] 
**count** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.quota_limit import QuotaLimit

# TODO update the JSON string below
json = "{}"
# create an instance of QuotaLimit from a JSON string
quota_limit_instance = QuotaLimit.from_json(json)
# print the JSON string representation of the object
print(QuotaLimit.to_json())

# convert the object into a dict
quota_limit_dict = quota_limit_instance.to_dict()
# create an instance of QuotaLimit from a dict
quota_limit_from_dict = QuotaLimit.from_dict(quota_limit_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


