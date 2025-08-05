# KestraIoKestraSdk.SCIMGroupsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSCIMResourceByIdGroups**](SCIMGroupsApi.md#createSCIMResourceByIdGroups) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | 
[**deleteGroups**](SCIMGroupsApi.md#deleteGroups) | **DELETE** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**findGroups**](SCIMGroupsApi.md#findGroups) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/.search | 
[**getSCIMResourceByIdGroups**](SCIMGroupsApi.md#getSCIMResourceByIdGroups) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**patchGroups**](SCIMGroupsApi.md#patchGroups) | **PATCH** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 
[**queryGroups**](SCIMGroupsApi.md#queryGroups) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | 
[**updateGroups**](SCIMGroupsApi.md#updateGroups) | **PUT** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | 



## createSCIMResourceByIdGroups

> ScimResource createSCIMResourceByIdGroups(integration, tenant, scimUser, opts)



Create

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMGroupsApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let scimUser = new KestraIoKestraSdk.ScimUser(); // ScimUser | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.createSCIMResourceByIdGroups(integration, tenant, scimUser, opts, (error, data, response) => {
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
 **integration** | **String**|  | 
 **tenant** | **String**|  | 
 **scimUser** | [**ScimUser**](ScimUser.md)|  | 
 **attributes** | **String**|  | [optional] 
 **excludedAttributes** | **String**|  | [optional] 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json


## deleteGroups

> deleteGroups(id, integration, tenant)



Delete from the backing store

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMGroupsApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.deleteGroups(id, integration, tenant, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 
 **integration** | **String**|  | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## findGroups

> ScimResource findGroups(integration, tenant, searchRequest)



Search

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMGroupsApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let searchRequest = new KestraIoKestraSdk.SearchRequest(); // SearchRequest | 
apiInstance.findGroups(integration, tenant, searchRequest, (error, data, response) => {
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
 **integration** | **String**|  | 
 **tenant** | **String**|  | 
 **searchRequest** | [**SearchRequest**](SearchRequest.md)|  | 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json


## getSCIMResourceByIdGroups

> ScimResource getSCIMResourceByIdGroups(id, integration, tenant, opts)



Find by id

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMGroupsApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.getSCIMResourceByIdGroups(id, integration, tenant, opts, (error, data, response) => {
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
 **id** | **String**|  | 
 **integration** | **String**|  | 
 **tenant** | **String**|  | 
 **attributes** | **String**|  | [optional] 
 **excludedAttributes** | **String**|  | [optional] 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json


## patchGroups

> patchGroups(id, integration, tenant, patchRequest, opts)



Patch a portion of the backing store

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMGroupsApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let patchRequest = new KestraIoKestraSdk.PatchRequest(); // PatchRequest | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.patchGroups(id, integration, tenant, patchRequest, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 
 **integration** | **String**|  | 
 **tenant** | **String**|  | 
 **patchRequest** | [**PatchRequest**](PatchRequest.md)|  | 
 **attributes** | **String**|  | [optional] 
 **excludedAttributes** | **String**|  | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: Not defined


## queryGroups

> ScimResource queryGroups(integration, tenant, opts)



Find by a combination of query parameters

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMGroupsApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example", // String | 
  'filter': "filter_example", // String | 
  'sortBy': "sortBy_example", // String | 
  'sortOrder': new KestraIoKestraSdk.SortOrder(), // SortOrder | 
  'startIndex': 56, // Number | 
  'count': 56 // Number | 
};
apiInstance.queryGroups(integration, tenant, opts, (error, data, response) => {
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
 **integration** | **String**|  | 
 **tenant** | **String**|  | 
 **attributes** | **String**|  | [optional] 
 **excludedAttributes** | **String**|  | [optional] 
 **filter** | **String**|  | [optional] 
 **sortBy** | **String**|  | [optional] 
 **sortOrder** | [**SortOrder**](.md)|  | [optional] 
 **startIndex** | **Number**|  | [optional] 
 **count** | **Number**|  | [optional] 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json


## updateGroups

> ScimResource updateGroups(id, integration, tenant, scimResource, opts)



Update

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMGroupsApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let scimResource = new KestraIoKestraSdk.ScimResource(); // ScimResource | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.updateGroups(id, integration, tenant, scimResource, opts, (error, data, response) => {
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
 **id** | **String**|  | 
 **integration** | **String**|  | 
 **tenant** | **String**|  | 
 **scimResource** | [**ScimResource**](ScimResource.md)|  | 
 **attributes** | **String**|  | [optional] 
 **excludedAttributes** | **String**|  | [optional] 

### Return type

[**ScimResource**](ScimResource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json

