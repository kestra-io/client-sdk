# KestraIoKestraSdk.SecurityIntegrationsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSecurityIntegration**](SecurityIntegrationsApi.md#createSecurityIntegration) | **POST** /api/v1/{tenant}/security-integrations | Create a security integration
[**deleteSecurityIntegration**](SecurityIntegrationsApi.md#deleteSecurityIntegration) | **DELETE** /api/v1/{tenant}/security-integrations/{id} | Delete a security integration
[**disableSecurityIntegration**](SecurityIntegrationsApi.md#disableSecurityIntegration) | **POST** /api/v1/{tenant}/security-integrations/{id}/disable | Disable a security integration
[**enableSecurityIntegration**](SecurityIntegrationsApi.md#enableSecurityIntegration) | **POST** /api/v1/{tenant}/security-integrations/{id}/enable | Enable a security integration
[**getSecurityIntegration**](SecurityIntegrationsApi.md#getSecurityIntegration) | **GET** /api/v1/{tenant}/security-integrations/{id} | Retrieve a security integration
[**listSecurityIntegrations**](SecurityIntegrationsApi.md#listSecurityIntegrations) | **GET** /api/v1/{tenant}/security-integrations | List all security integrations



## createSecurityIntegration

> Object createSecurityIntegration(tenant, createSecurityIntegrationRequest)

Create a security integration

Superadmin-only.

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

let apiInstance = new KestraIoKestraSdk.SecurityIntegrationsApi();
let tenant = "tenant_example"; // String | 
let createSecurityIntegrationRequest = new KestraIoKestraSdk.CreateSecurityIntegrationRequest(); // CreateSecurityIntegrationRequest | The security integration definition
apiInstance.createSecurityIntegration(tenant, createSecurityIntegrationRequest, (error, data, response) => {
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
 **createSecurityIntegrationRequest** | [**CreateSecurityIntegrationRequest**](CreateSecurityIntegrationRequest.md)| The security integration definition | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteSecurityIntegration

> Object deleteSecurityIntegration(id, tenant)

Delete a security integration

Superadmin-only.

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

let apiInstance = new KestraIoKestraSdk.SecurityIntegrationsApi();
let id = "id_example"; // String | The ID of security integration
let tenant = "tenant_example"; // String | 
apiInstance.deleteSecurityIntegration(id, tenant, (error, data, response) => {
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
 **id** | **String**| The ID of security integration | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## disableSecurityIntegration

> Object disableSecurityIntegration(id, tenant)

Disable a security integration

Superadmin-only. Disables the specified integration.

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

let apiInstance = new KestraIoKestraSdk.SecurityIntegrationsApi();
let id = "id_example"; // String | The ID of security integration
let tenant = "tenant_example"; // String | 
apiInstance.disableSecurityIntegration(id, tenant, (error, data, response) => {
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
 **id** | **String**| The ID of security integration | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## enableSecurityIntegration

> Object enableSecurityIntegration(id, tenant)

Enable a security integration

Superadmin-only. Enables the specified integration.

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

let apiInstance = new KestraIoKestraSdk.SecurityIntegrationsApi();
let id = "id_example"; // String | The ID of security integration
let tenant = "tenant_example"; // String | 
apiInstance.enableSecurityIntegration(id, tenant, (error, data, response) => {
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
 **id** | **String**| The ID of security integration | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getSecurityIntegration

> Object getSecurityIntegration(id, tenant)

Retrieve a security integration

Superadmin-only.

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

let apiInstance = new KestraIoKestraSdk.SecurityIntegrationsApi();
let id = "id_example"; // String | The ID of security integration
let tenant = "tenant_example"; // String | 
apiInstance.getSecurityIntegration(id, tenant, (error, data, response) => {
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
 **id** | **String**| The ID of security integration | 
 **tenant** | **String**|  | 

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## listSecurityIntegrations

> Object listSecurityIntegrations(tenant)

List all security integrations

Superadmin-only.

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

let apiInstance = new KestraIoKestraSdk.SecurityIntegrationsApi();
let tenant = "tenant_example"; // String | 
apiInstance.listSecurityIntegrations(tenant, (error, data, response) => {
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

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

