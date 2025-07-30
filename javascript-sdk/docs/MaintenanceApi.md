# KestraIoKestraApi.MaintenanceApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**enterMaintenance**](MaintenanceApi.md#enterMaintenance) | **POST** /api/v1/instance/maintenance/enter | Enter cluster maintenance mode
[**exitMaintenance**](MaintenanceApi.md#exitMaintenance) | **POST** /api/v1/instance/maintenance/exit | Exit cluster maintenance mode



## enterMaintenance

> enterMaintenance()

Enter cluster maintenance mode

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.MaintenanceApi();
apiInstance.enterMaintenance((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## exitMaintenance

> exitMaintenance()

Exit cluster maintenance mode

Requires a role with the INFRASTRUCTURE permission (Superadmin-only).

### Example

```javascript
import KestraIoKestraApi from '@kestra-io/kestra-api';
let defaultClient = KestraIoKestraApi.ApiClient.instance;
// Configure HTTP basic authorization: basicAuth
let basicAuth = defaultClient.authentications['basicAuth'];
basicAuth.username = 'YOUR USERNAME';
basicAuth.password = 'YOUR PASSWORD';
// Configure Bearer (Bearer) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new KestraIoKestraApi.MaintenanceApi();
apiInstance.exitMaintenance((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

