# KestraIoKestraApi.SCIMApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSCIMResourceByIdGroups**](SCIMApi.md#createSCIMResourceByIdGroups) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | {@inheritDoc}
[**createSCIMResourceByIdUsers**](SCIMApi.md#createSCIMResourceByIdUsers) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users | {@inheritDoc}
[**deleteGroups**](SCIMApi.md#deleteGroups) | **DELETE** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | {@inheritDoc}
[**deleteUsers**](SCIMApi.md#deleteUsers) | **DELETE** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | {@inheritDoc}
[**findGroups**](SCIMApi.md#findGroups) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/.search | {@inheritDoc}
[**findUsers**](SCIMApi.md#findUsers) | **POST** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/.search | {@inheritDoc}
[**getSCIMResourceByIdGroups**](SCIMApi.md#getSCIMResourceByIdGroups) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | {@inheritDoc}
[**getSCIMResourceByIdUsers**](SCIMApi.md#getSCIMResourceByIdUsers) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | {@inheritDoc}
[**patchGroups**](SCIMApi.md#patchGroups) | **PATCH** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | {@inheritDoc}
[**patchUsers**](SCIMApi.md#patchUsers) | **PATCH** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | {@inheritDoc}
[**queryGroups**](SCIMApi.md#queryGroups) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups | {@inheritDoc}
[**queryUsers**](SCIMApi.md#queryUsers) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users | {@inheritDoc}
[**updateGroups**](SCIMApi.md#updateGroups) | **PUT** /api/v1/{tenant}/integrations/{integration}/scim/v2/Groups/{id} | {@inheritDoc}
[**updateUsers**](SCIMApi.md#updateUsers) | **PUT** /api/v1/{tenant}/integrations/{integration}/scim/v2/Users/{id} | {@inheritDoc}



## createSCIMResourceByIdGroups

> Object createSCIMResourceByIdGroups(integration, tenant, scimUser, opts)

{@inheritDoc}

Create

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let scimUser = new KestraIoKestraApi.ScimUser(); // ScimUser | 
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

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json, application/json


## createSCIMResourceByIdUsers

> Object createSCIMResourceByIdUsers(integration, tenant, scimUser, opts)

{@inheritDoc}

Create

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let scimUser = new KestraIoKestraApi.ScimUser(); // ScimUser | 
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

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json, application/json


## deleteGroups

> Object deleteGroups(id, integration, tenant)

{@inheritDoc}

Delete from the backing store

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.deleteGroups(id, integration, tenant, (error, data, response) => {
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

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json, application/json


## deleteUsers

> Object deleteUsers(id, integration, tenant)

{@inheritDoc}

Delete from the backing store

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.deleteUsers(id, integration, tenant, (error, data, response) => {
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

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json, application/json


## findGroups

> ScimResource findGroups(integration, tenant, searchRequest)

{@inheritDoc}

Search

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let searchRequest = new KestraIoKestraApi.SearchRequest(); // SearchRequest | 
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


## findUsers

> ScimResource findUsers(integration, tenant, searchRequest)

{@inheritDoc}

Search

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let searchRequest = new KestraIoKestraApi.SearchRequest(); // SearchRequest | 
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


## getSCIMResourceByIdGroups

> ScimResource getSCIMResourceByIdGroups(id, integration, tenant, opts)

{@inheritDoc}

Find by id

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
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


## getSCIMResourceByIdUsers

> ScimResource getSCIMResourceByIdUsers(id, integration, tenant, opts)

{@inheritDoc}

Find by id

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
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


## patchGroups

> Object patchGroups(id, integration, tenant, patchRequest, opts)

{@inheritDoc}

Patch a portion of the backing store

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let patchRequest = new KestraIoKestraApi.PatchRequest(); // PatchRequest | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.patchGroups(id, integration, tenant, patchRequest, opts, (error, data, response) => {
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
 **patchRequest** | [**PatchRequest**](PatchRequest.md)|  | 
 **attributes** | **String**|  | [optional] 
 **excludedAttributes** | **String**|  | [optional] 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json, application/json


## patchUsers

> Object patchUsers(id, integration, tenant, patchRequest, opts)

{@inheritDoc}

Patch a portion of the backing store

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let patchRequest = new KestraIoKestraApi.PatchRequest(); // PatchRequest | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example" // String | 
};
apiInstance.patchUsers(id, integration, tenant, patchRequest, opts, (error, data, response) => {
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
 **patchRequest** | [**PatchRequest**](PatchRequest.md)|  | 
 **attributes** | **String**|  | [optional] 
 **excludedAttributes** | **String**|  | [optional] 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/scim+json
- **Accept**: application/scim+json, application/json


## queryGroups

> ScimResource queryGroups(integration, tenant, opts)

{@inheritDoc}

Find by a combination of query parameters

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example", // String | 
  'filter': "filter_example", // String | 
  'sortBy': "sortBy_example", // String | 
  'sortOrder': new KestraIoKestraApi.SortOrder(), // SortOrder | 
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


## queryUsers

> ScimResource queryUsers(integration, tenant, opts)

{@inheritDoc}

Find by a combination of query parameters

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let opts = {
  'attributes': "attributes_example", // String | 
  'excludedAttributes': "excludedAttributes_example", // String | 
  'filter': "filter_example", // String | 
  'sortBy': "sortBy_example", // String | 
  'sortOrder': new KestraIoKestraApi.SortOrder(), // SortOrder | 
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


## updateGroups

> ScimResource updateGroups(id, integration, tenant, scimResource, opts)

{@inheritDoc}

Update

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let scimResource = new KestraIoKestraApi.ScimResource(); // ScimResource | 
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


## updateUsers

> ScimResource updateUsers(id, integration, tenant, scimResource, opts)

{@inheritDoc}

Update

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';

let apiInstance = new KestraIoKestraApi.SCIMApi();
let id = "id_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
let scimResource = new KestraIoKestraApi.ScimResource(); // ScimResource | 
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

