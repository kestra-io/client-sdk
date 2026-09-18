# PagedResultsApiPromotionTargetResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiPromotionTargetResponse]**](ApiPromotionTargetResponse.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_promotion_target_response import PagedResultsApiPromotionTargetResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiPromotionTargetResponse from a JSON string
paged_results_api_promotion_target_response_instance = PagedResultsApiPromotionTargetResponse.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiPromotionTargetResponse.to_json())

# convert the object into a dict
paged_results_api_promotion_target_response_dict = paged_results_api_promotion_target_response_instance.to_dict()
# create an instance of PagedResultsApiPromotionTargetResponse from a dict
paged_results_api_promotion_target_response_from_dict = PagedResultsApiPromotionTargetResponse.from_dict(paged_results_api_promotion_target_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


