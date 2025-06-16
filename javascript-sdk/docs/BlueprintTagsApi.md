# KestraApi.BlueprintTagsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**internalBlueprintTags**](BlueprintTagsApi.md#internalBlueprintTags) | **GET** /api/v1/{tenant}/blueprints/custom/tags | List all internal blueprint tags
[**listBlueprintTags**](BlueprintTagsApi.md#listBlueprintTags) | **GET** /api/v1/{tenant}/blueprints/community/{kind}/tags | List blueprint tags matching the filter



## internalBlueprintTags

> [String] internalBlueprintTags(tenant, opts)

List all internal blueprint tags

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintTagsApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example" // String | A string filter to get tags with matching blueprints only
};
apiInstance.internalBlueprintTags(tenant, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **q** | **String**| A string filter to get tags with matching blueprints only | [optional] 

### Return type

**[String]**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listBlueprintTags

> [BlueprintControllerApiBlueprintTagItem] listBlueprintTags(kind, tenant, opts)

List blueprint tags matching the filter

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintTagsApi();
let kind = new KestraApi.BlueprintControllerKind(); // BlueprintControllerKind | The blueprint kind
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example" // String | A string filter to get tags with matching blueprints only
};
apiInstance.listBlueprintTags(kind, tenant, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **String**|  | 
 **q** | **String**| A string filter to get tags with matching blueprints only | [optional] 

### Return type

[**[BlueprintControllerApiBlueprintTagItem]**](BlueprintControllerApiBlueprintTagItem.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

