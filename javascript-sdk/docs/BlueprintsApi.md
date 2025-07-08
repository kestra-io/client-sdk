# KestraApi.BlueprintsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInternalBlueprints**](BlueprintsApi.md#createInternalBlueprints) | **POST** /api/v1/{tenant}/blueprints/custom | Create a new internal blueprint
[**deleteInternalBlueprints**](BlueprintsApi.md#deleteInternalBlueprints) | **DELETE** /api/v1/{tenant}/blueprints/custom/{id} | Delete an internal blueprint
[**getBlueprint**](BlueprintsApi.md#getBlueprint) | **GET** /api/v1/{tenant}/blueprints/community/{kind}/{id} | Get a blueprint
[**getBlueprintGraph**](BlueprintsApi.md#getBlueprintGraph) | **GET** /api/v1/{tenant}/blueprints/community/{kind}/{id}/graph | Get a blueprint graph
[**getBlueprintSource**](BlueprintsApi.md#getBlueprintSource) | **GET** /api/v1/{tenant}/blueprints/community/{kind}/{id}/source | Get a blueprint source code
[**internalBlueprint**](BlueprintsApi.md#internalBlueprint) | **GET** /api/v1/{tenant}/blueprints/custom/{id} | Get an internal blueprint
[**internalBlueprintFlow**](BlueprintsApi.md#internalBlueprintFlow) | **GET** /api/v1/{tenant}/blueprints/custom/{id}/source | Get an internal blueprint source code
[**searchBlueprints**](BlueprintsApi.md#searchBlueprints) | **GET** /api/v1/{tenant}/blueprints/community/{kind} | List all blueprints
[**searchInternalBlueprints**](BlueprintsApi.md#searchInternalBlueprints) | **GET** /api/v1/{tenant}/blueprints/custom | List all internal blueprints
[**updateInternalBlueprints**](BlueprintsApi.md#updateInternalBlueprints) | **PUT** /api/v1/{tenant}/blueprints/custom/{id} | Update an internal blueprint



## createInternalBlueprints

> BlueprintControllerApiBlueprintItemWithSource createInternalBlueprints(tenant, blueprintControllerApiBlueprintItemWithSource)

Create a new internal blueprint

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let tenant = "tenant_example"; // String | 
let blueprintControllerApiBlueprintItemWithSource = new KestraApi.BlueprintControllerApiBlueprintItemWithSource(); // BlueprintControllerApiBlueprintItemWithSource | The internal blueprint to create
apiInstance.createInternalBlueprints(tenant, blueprintControllerApiBlueprintItemWithSource).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **blueprintControllerApiBlueprintItemWithSource** | [**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)| The internal blueprint to create | 

### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteInternalBlueprints

> deleteInternalBlueprints(id, tenant)

Delete an internal blueprint

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let id = "id_example"; // String | The internal blueprint id to delete
let tenant = "tenant_example"; // String | 
apiInstance.deleteInternalBlueprints(id, tenant).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The internal blueprint id to delete | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## getBlueprint

> BlueprintControllerApiBlueprintItemWithSource getBlueprint(id, kind, tenant)

Get a blueprint

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let id = "id_example"; // String | The blueprint id
let kind = new KestraApi.BlueprintControllerKind(); // BlueprintControllerKind | The blueprint kind
let tenant = "tenant_example"; // String | 
apiInstance.getBlueprint(id, kind, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The blueprint id | 
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **String**|  | 

### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getBlueprintGraph

> {String: Object} getBlueprintGraph(id, kind, tenant)

Get a blueprint graph

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let id = "id_example"; // String | The blueprint id
let kind = new KestraApi.BlueprintControllerKind(); // BlueprintControllerKind | The blueprint kind
let tenant = "tenant_example"; // String | 
apiInstance.getBlueprintGraph(id, kind, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The blueprint id | 
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **String**|  | 

### Return type

**{String: Object}**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getBlueprintSource

> String getBlueprintSource(id, kind, tenant)

Get a blueprint source code

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let id = "id_example"; // String | The blueprint id
let kind = new KestraApi.BlueprintControllerKind(); // BlueprintControllerKind | The blueprint kind
let tenant = "tenant_example"; // String | 
apiInstance.getBlueprintSource(id, kind, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The blueprint id | 
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **String**|  | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/yaml


## internalBlueprint

> BlueprintControllerApiBlueprintItemWithSource internalBlueprint(id, tenant)

Get an internal blueprint

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let id = "id_example"; // String | The blueprint id
let tenant = "tenant_example"; // String | 
apiInstance.internalBlueprint(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The blueprint id | 
 **tenant** | **String**|  | 

### Return type

[**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## internalBlueprintFlow

> String internalBlueprintFlow(id, tenant)

Get an internal blueprint source code

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let id = "id_example"; // String | The blueprint id
let tenant = "tenant_example"; // String | 
apiInstance.internalBlueprintFlow(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The blueprint id | 
 **tenant** | **String**|  | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/yaml


## searchBlueprints

> PagedResultsBlueprintControllerApiBlueprintItem searchBlueprints(page, size, kind, tenant, opts)

List all blueprints

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let page = 1; // Number | The current page
let size = 1; // Number | The current page size
let kind = new KestraApi.BlueprintControllerKind(); // BlueprintControllerKind | The blueprint kind
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': "sort_example", // String | The sort of current page
  'tags': ["null"] // [String] | A tags filter
};
apiInstance.searchBlueprints(page, size, kind, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 1]
 **kind** | [**BlueprintControllerKind**](.md)| The blueprint kind | 
 **tenant** | **String**|  | 
 **q** | **String**| A string filter | [optional] 
 **sort** | **String**| The sort of current page | [optional] 
 **tags** | [**[String]**](String.md)| A tags filter | [optional] 

### Return type

[**PagedResultsBlueprintControllerApiBlueprintItem**](PagedResultsBlueprintControllerApiBlueprintItem.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchInternalBlueprints

> PagedResultsBlueprint searchInternalBlueprints(page, size, tenant, opts)

List all internal blueprints

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let page = 1; // Number | The current page
let size = 1; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': "sort_example", // String | The sort of current page
  'tags': ["null"] // [String] | A tags filter
};
apiInstance.searchInternalBlueprints(page, size, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 1]
 **tenant** | **String**|  | 
 **q** | **String**| A string filter | [optional] 
 **sort** | **String**| The sort of current page | [optional] 
 **tags** | [**[String]**](String.md)| A tags filter | [optional] 

### Return type

[**PagedResultsBlueprint**](PagedResultsBlueprint.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateInternalBlueprints

> BlueprintWithFlow updateInternalBlueprints(id, tenant, blueprintControllerApiBlueprintItemWithSource)

Update an internal blueprint

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.BlueprintsApi();
let id = "id_example"; // String | The id of the internal blueprint to update
let tenant = "tenant_example"; // String | 
let blueprintControllerApiBlueprintItemWithSource = new KestraApi.BlueprintControllerApiBlueprintItemWithSource(); // BlueprintControllerApiBlueprintItemWithSource | The new internal blueprint for update
apiInstance.updateInternalBlueprints(id, tenant, blueprintControllerApiBlueprintItemWithSource).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the internal blueprint to update | 
 **tenant** | **String**|  | 
 **blueprintControllerApiBlueprintItemWithSource** | [**BlueprintControllerApiBlueprintItemWithSource**](BlueprintControllerApiBlueprintItemWithSource.md)| The new internal blueprint for update | 

### Return type

[**BlueprintWithFlow**](BlueprintWithFlow.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

