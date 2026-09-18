# PagedResultsApiPromotionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiPromotionResponse]**](ApiPromotionResponse.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_promotion_response import PagedResultsApiPromotionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiPromotionResponse from a JSON string
paged_results_api_promotion_response_instance = PagedResultsApiPromotionResponse.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiPromotionResponse.to_json())

# convert the object into a dict
paged_results_api_promotion_response_dict = paged_results_api_promotion_response_instance.to_dict()
# create an instance of PagedResultsApiPromotionResponse from a dict
paged_results_api_promotion_response_from_dict = PagedResultsApiPromotionResponse.from_dict(paged_results_api_promotion_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


