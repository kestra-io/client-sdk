# KestraIoKestraSdk.TriggersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteBackfill**](TriggersApi.md#deleteBackfill) | **POST** /api/v1/{tenant}/triggers/backfill/delete | Delete a backfill
[**deleteBackfillByIds**](TriggersApi.md#deleteBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-triggers | Delete backfill for given triggers
[**deleteBackfillByQuery**](TriggersApi.md#deleteBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/delete/by-query | Delete backfill for given triggers
[**disabledTriggersByIds**](TriggersApi.md#disabledTriggersByIds) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-triggers | Disable/enable given triggers
[**disabledTriggersByQuery**](TriggersApi.md#disabledTriggersByQuery) | **POST** /api/v1/{tenant}/triggers/set-disabled/by-query | Disable/enable triggers by query parameters
[**pauseBackfill**](TriggersApi.md#pauseBackfill) | **PUT** /api/v1/{tenant}/triggers/backfill/pause | Pause a backfill
[**pauseBackfillByIds**](TriggersApi.md#pauseBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-triggers | Pause backfill for given triggers
[**pauseBackfillByQuery**](TriggersApi.md#pauseBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/pause/by-query | Pause backfill for given triggers
[**restartTrigger**](TriggersApi.md#restartTrigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/restart | Restart a trigger
[**searchTriggers**](TriggersApi.md#searchTriggers) | **GET** /api/v1/{tenant}/triggers/search | Search for triggers
[**searchTriggersForFlow**](TriggersApi.md#searchTriggersForFlow) | **GET** /api/v1/{tenant}/triggers/{namespace}/{flowId} | Get all triggers for a flow
[**unlockTrigger**](TriggersApi.md#unlockTrigger) | **POST** /api/v1/{tenant}/triggers/{namespace}/{flowId}/{triggerId}/unlock | Unlock a trigger
[**unlockTriggersByIds**](TriggersApi.md#unlockTriggersByIds) | **POST** /api/v1/{tenant}/triggers/unlock/by-triggers | Unlock given triggers
[**unlockTriggersByQuery**](TriggersApi.md#unlockTriggersByQuery) | **POST** /api/v1/{tenant}/triggers/unlock/by-query | Unlock triggers by query parameters
[**unpauseBackfill**](TriggersApi.md#unpauseBackfill) | **PUT** /api/v1/{tenant}/triggers/backfill/unpause | Unpause a backfill
[**unpauseBackfillByIds**](TriggersApi.md#unpauseBackfillByIds) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-triggers | Unpause backfill for given triggers
[**unpauseBackfillByQuery**](TriggersApi.md#unpauseBackfillByQuery) | **POST** /api/v1/{tenant}/triggers/backfill/unpause/by-query | Unpause backfill for given triggers
[**updateTrigger**](TriggersApi.md#updateTrigger) | **PUT** /api/v1/{tenant}/triggers | Update a trigger



## deleteBackfill

> Trigger deleteBackfill(tenant, trigger)

Delete a backfill

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let trigger = new KestraIoKestraSdk.Trigger(); // Trigger | 
apiInstance.deleteBackfill(tenant, trigger).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **trigger** | [**Trigger**](Trigger.md)|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteBackfillByIds

> Object deleteBackfillByIds(tenant, trigger)

Delete backfill for given triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let trigger = [new KestraIoKestraSdk.Trigger()]; // [Trigger] | 
apiInstance.deleteBackfillByIds(tenant, trigger).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **trigger** | [**[Trigger]**](Trigger.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteBackfillByQuery

> Object deleteBackfillByQuery(tenant, opts)

Delete backfill for given triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.deleteBackfillByQuery(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## disabledTriggersByIds

> Object disabledTriggersByIds(tenant, triggerControllerSetDisabledRequest)

Disable/enable given triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let triggerControllerSetDisabledRequest = new KestraIoKestraSdk.TriggerControllerSetDisabledRequest(); // TriggerControllerSetDisabledRequest | 
apiInstance.disabledTriggersByIds(tenant, triggerControllerSetDisabledRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **triggerControllerSetDisabledRequest** | [**TriggerControllerSetDisabledRequest**](TriggerControllerSetDisabledRequest.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## disabledTriggersByQuery

> Object disabledTriggersByQuery(disabled, tenant, opts)

Disable/enable triggers by query parameters

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let disabled = true; // Boolean | The disabled state
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.disabledTriggersByQuery(disabled, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **disabled** | **Boolean**| The disabled state | [default to true]
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## pauseBackfill

> Trigger pauseBackfill(tenant, trigger)

Pause a backfill

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let trigger = new KestraIoKestraSdk.Trigger(); // Trigger | 
apiInstance.pauseBackfill(tenant, trigger).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **trigger** | [**Trigger**](Trigger.md)|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## pauseBackfillByIds

> Object pauseBackfillByIds(tenant, trigger)

Pause backfill for given triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let trigger = [new KestraIoKestraSdk.Trigger()]; // [Trigger] | 
apiInstance.pauseBackfillByIds(tenant, trigger).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **trigger** | [**[Trigger]**](Trigger.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## pauseBackfillByQuery

> Object pauseBackfillByQuery(tenant, opts)

Pause backfill for given triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.pauseBackfillByQuery(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## restartTrigger

> Object restartTrigger(namespace, flowId, triggerId, tenant)

Restart a trigger

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow id
let triggerId = "triggerId_example"; // String | The trigger id
let tenant = "tenant_example"; // String | 
apiInstance.restartTrigger(namespace, flowId, triggerId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow id | 
 **triggerId** | **String**| The trigger id | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchTriggers

> PagedResultsTriggerControllerTriggers searchTriggers(page, size, tenant, opts)

Search for triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.searchTriggers(page, size, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **tenant** | **String**|  | 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

[**PagedResultsTriggerControllerTriggers**](PagedResultsTriggerControllerTriggers.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchTriggersForFlow

> PagedResultsTrigger searchTriggersForFlow(page, size, namespace, flowId, tenant, opts)

Get all triggers for a flow

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow id
let tenant = "tenant_example"; // String | 
let opts = {
  'sort': ["null"], // [String] | The sort of current page
  'q': "q_example" // String | A string filter
};
apiInstance.searchTriggersForFlow(page, size, namespace, flowId, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow id | 
 **tenant** | **String**|  | 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **q** | **String**| A string filter | [optional] 

### Return type

[**PagedResultsTrigger**](PagedResultsTrigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## unlockTrigger

> Trigger unlockTrigger(namespace, flowId, triggerId, tenant)

Unlock a trigger

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let namespace = "namespace_example"; // String | The namespace
let flowId = "flowId_example"; // String | The flow id
let triggerId = "triggerId_example"; // String | The trigger id
let tenant = "tenant_example"; // String | 
apiInstance.unlockTrigger(namespace, flowId, triggerId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **namespace** | **String**| The namespace | 
 **flowId** | **String**| The flow id | 
 **triggerId** | **String**| The trigger id | 
 **tenant** | **String**|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## unlockTriggersByIds

> Object unlockTriggersByIds(tenant, trigger)

Unlock given triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let trigger = [new KestraIoKestraSdk.Trigger()]; // [Trigger] | 
apiInstance.unlockTriggersByIds(tenant, trigger).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **trigger** | [**[Trigger]**](Trigger.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## unlockTriggersByQuery

> Object unlockTriggersByQuery(tenant, opts)

Unlock triggers by query parameters

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.unlockTriggersByQuery(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## unpauseBackfill

> Trigger unpauseBackfill(tenant, trigger)

Unpause a backfill

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let trigger = new KestraIoKestraSdk.Trigger(); // Trigger | 
apiInstance.unpauseBackfill(tenant, trigger).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **trigger** | [**Trigger**](Trigger.md)|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## unpauseBackfillByIds

> Object unpauseBackfillByIds(tenant, trigger)

Unpause backfill for given triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let trigger = [new KestraIoKestraSdk.Trigger()]; // [Trigger] | 
apiInstance.unpauseBackfillByIds(tenant, trigger).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **trigger** | [**[Trigger]**](Trigger.md)|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## unpauseBackfillByQuery

> Object unpauseBackfillByQuery(tenant, opts)

Unpause backfill for given triggers

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let opts = {
  'filters': [new KestraIoKestraSdk.QueryFilter()] // [QueryFilter] | Filters
};
apiInstance.unpauseBackfillByQuery(tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **filters** | [**[QueryFilter]**](QueryFilter.md)| Filters | [optional] 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateTrigger

> Trigger updateTrigger(tenant, trigger)

Update a trigger

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';
let defaultClient = KestraIoKestraSdk.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraSdk.TriggersApi();
let tenant = "tenant_example"; // String | 
let trigger = new KestraIoKestraSdk.Trigger(); // Trigger | 
apiInstance.updateTrigger(tenant, trigger).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **trigger** | [**Trigger**](Trigger.md)|  | 

### Return type

[**Trigger**](Trigger.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

