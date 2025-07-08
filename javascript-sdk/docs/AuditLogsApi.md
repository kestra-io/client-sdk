# KestraApi.AuditLogsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findAuditLog**](AuditLogsApi.md#findAuditLog) | **POST** /api/v1/{tenant}/auditlogs/find | Find a specific audit log
[**getResourceDiffFromAuditLog**](AuditLogsApi.md#getResourceDiffFromAuditLog) | **GET** /api/v1/{tenant}/auditlogs/{id}/diff | Get the diff of an object between current version and a previous version. Can also compare two version from specific audit logs.
[**listAuditLogFromResourceId**](AuditLogsApi.md#listAuditLogFromResourceId) | **GET** /api/v1/{tenant}/auditlogs/history/{detailId} | Find all audit logs about a specific resource.
[**searchAuditLogs**](AuditLogsApi.md#searchAuditLogs) | **GET** /api/v1/{tenant}/auditlogs/search | Search for audit logs



## findAuditLog

> AuditLogControllerAuditLogWithUser findAuditLog(tenant, auditLogControllerFindRequest)

Find a specific audit log

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.AuditLogsApi();
let tenant = "tenant_example"; // String | 
let auditLogControllerFindRequest = new KestraApi.AuditLogControllerFindRequest(); // AuditLogControllerFindRequest | The find request
apiInstance.findAuditLog(tenant, auditLogControllerFindRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tenant** | **String**|  | 
 **auditLogControllerFindRequest** | [**AuditLogControllerFindRequest**](AuditLogControllerFindRequest.md)| The find request | 

### Return type

[**AuditLogControllerAuditLogWithUser**](AuditLogControllerAuditLogWithUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## getResourceDiffFromAuditLog

> AuditLogControllerAuditLogDiff getResourceDiffFromAuditLog(id, tenant, opts)

Get the diff of an object between current version and a previous version. Can also compare two version from specific audit logs.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.AuditLogsApi();
let id = "id_example"; // String | The id of the audit log
let tenant = "tenant_example"; // String | 
let opts = {
  'previousId': "previousId_example" // String | The id of a previous audit log to compare with
};
apiInstance.getResourceDiffFromAuditLog(id, tenant, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the audit log | 
 **tenant** | **String**|  | 
 **previousId** | **String**| The id of a previous audit log to compare with | [optional] 

### Return type

[**AuditLogControllerAuditLogDiff**](AuditLogControllerAuditLogDiff.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listAuditLogFromResourceId

> [AuditLogControllerAuditLogOption] listAuditLogFromResourceId(detailId, tenant)

Find all audit logs about a specific resource.

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.AuditLogsApi();
let detailId = "detailId_example"; // String | The resource Id
let tenant = "tenant_example"; // String | 
apiInstance.listAuditLogFromResourceId(detailId, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **detailId** | **String**| The resource Id | 
 **tenant** | **String**|  | 

### Return type

[**[AuditLogControllerAuditLogOption]**](AuditLogControllerAuditLogOption.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchAuditLogs

> PagedResultsAuditLogControllerAuditLogWithUser searchAuditLogs(page, size, tenant, opts)

Search for audit logs

### Example

```javascript
import KestraApi from 'kestra_api';
let defaultClient = KestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraApi.AuditLogsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | A string filter
  'sort': ["null"], // [String] | The sort of current page
  'namespace': "namespace_example", // String | A namespace filter
  'flowId': "flowId_example", // String | A flow id filter
  'executionId': "executionId_example", // String | An execution filter
  'userId': "userId_example", // String | A user id filter
  'id': "id_example", // String | A id filter
  'permission': new KestraApi.Permission(), // Permission | A permission filter
  'startDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The start datetime
  'endDate': new Date("2013-10-20T19:20:30+01:00"), // Date | The end datetime
  'details': {key: "null"}, // {String: String} | A list of auditLog details
  'type': new KestraApi.CrudEventType() // CrudEventType | The event that create the audit log
};
apiInstance.searchAuditLogs(page, size, tenant, opts).then((data) => {
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
 **q** | **String**| A string filter | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 
 **namespace** | **String**| A namespace filter | [optional] 
 **flowId** | **String**| A flow id filter | [optional] 
 **executionId** | **String**| An execution filter | [optional] 
 **userId** | **String**| A user id filter | [optional] 
 **id** | **String**| A id filter | [optional] 
 **permission** | [**Permission**](.md)| A permission filter | [optional] 
 **startDate** | **Date**| The start datetime | [optional] 
 **endDate** | **Date**| The end datetime | [optional] 
 **details** | [**{String: String}**](String.md)| A list of auditLog details | [optional] 
 **type** | [**CrudEventType**](.md)| The event that create the audit log | [optional] 

### Return type

[**PagedResultsAuditLogControllerAuditLogWithUser**](PagedResultsAuditLogControllerAuditLogWithUser.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

