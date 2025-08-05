# KestraIoKestraSdk.SCIMUsersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSCIMResourceByIdUsers**](SCIMUsersApi.md#createSCIMResourceByIdUsers) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users | 
[**deleteUsers**](SCIMUsersApi.md#deleteUsers) | **DELETE** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | 
[**findUsers**](SCIMUsersApi.md#findUsers) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/.search | 
[**getSCIMResourceByIdUsers**](SCIMUsersApi.md#getSCIMResourceByIdUsers) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | 
[**patchUsers**](SCIMUsersApi.md#patchUsers) | **PATCH** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | 
[**queryUsers**](SCIMUsersApi.md#queryUsers) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users | 
[**updateUsers**](SCIMUsersApi.md#updateUsers) | **PUT** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | 



## createSCIMResourceByIdUsers

> ScimResource createSCIMResourceByIdUsers(integration, tenant, scimUser, opts)



Create

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMUsersApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let scimUser = new KestraIoKestraSdk.ScimUser(); // ScimUser | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.createSCIMResourceByIdUsers(integration, tenant, scimUser, opts, (error, data, response) => {
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


## deleteUsers

> deleteUsers(id, integration, tenant)



Delete from the backing store

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMUsersApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.deleteUsers(id, integration, tenant, (error, data, response) => {
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


## findUsers

> ScimResource findUsers(integration, tenant, searchRequest)



Search

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMUsersApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let searchRequest = new KestraIoKestraSdk.SearchRequest(); // SearchRequest | 
apiInstance.findUsers(integration, tenant, searchRequest, (error, data, response) => {
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


## getSCIMResourceByIdUsers

> ScimResource getSCIMResourceByIdUsers(id, integration, tenant, opts)



Find by id

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMUsersApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.getSCIMResourceByIdUsers(id, integration, tenant, opts, (error, data, response) => {
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


## patchUsers

> patchUsers(id, integration, tenant, patchRequest, opts)



Patch a portion of the backing store

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMUsersApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let patchRequest = new KestraIoKestraSdk.PatchRequest(); // PatchRequest | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.patchUsers(id, integration, tenant, patchRequest, opts, (error, data, response) => {
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


## queryUsers

> ScimResource queryUsers(integration, tenant, opts)



Find by a combination of query parameters

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMUsersApi();
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
apiInstance.queryUsers(integration, tenant, opts, (error, data, response) => {
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


## updateUsers

> ScimResource updateUsers(id, integration, tenant, scimResource, opts)



Update

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMUsersApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let scimResource = new KestraIoKestraSdk.ScimResource(); // ScimResource | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.updateUsers(id, integration, tenant, scimResource, opts, (error, data, response) => {
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

