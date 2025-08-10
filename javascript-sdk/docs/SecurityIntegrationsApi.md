# KestraApi.SecurityIntegrationsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSecurityIntegration**](SecurityIntegrationsApi.md#createSecurityIntegration) | **POST** /api/v1/{tenant}/security-integrations | Create a security integration.
[**deleteSecurityIntegration**](SecurityIntegrationsApi.md#deleteSecurityIntegration) | **DELETE** /api/v1/{tenant}/security-integrations/{id} | Delete the security integration.
[**disableSecurityIntegration**](SecurityIntegrationsApi.md#disableSecurityIntegration) | **POST** /api/v1/{tenant}/security-integrations/{id}/disable | Disable the security integration.
[**enableSecurityIntegration**](SecurityIntegrationsApi.md#enableSecurityIntegration) | **POST** /api/v1/{tenant}/security-integrations/{id}/enable | Enable the security integration.
[**getSecurityIntegration**](SecurityIntegrationsApi.md#getSecurityIntegration) | **GET** /api/v1/{tenant}/security-integrations/{id} | Get a security integration.
[**listSecurityIntegrations**](SecurityIntegrationsApi.md#listSecurityIntegrations) | **GET** /api/v1/{tenant}/security-integrations | List all security integrations.



## createSecurityIntegration

> Object createSecurityIntegration(tenant, createSecurityIntegrationRequest)

Create a security integration.

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

let apiInstance = new KestraApi.SecurityIntegrationsApi();
let tenant = "tenant_example"; // String | 
let createSecurityIntegrationRequest = new KestraApi.CreateSecurityIntegrationRequest(); // CreateSecurityIntegrationRequest | The security integration definition
apiInstance.createSecurityIntegration(tenant, createSecurityIntegrationRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

Delete the security integration.

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

let apiInstance = new KestraApi.SecurityIntegrationsApi();
let id = "id_example"; // String | The ID of security integration
let tenant = "tenant_example"; // String | 
apiInstance.deleteSecurityIntegration(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

Disable the security integration.

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

let apiInstance = new KestraApi.SecurityIntegrationsApi();
let id = "id_example"; // String | The ID of security integration
let tenant = "tenant_example"; // String | 
apiInstance.disableSecurityIntegration(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

Enable the security integration.

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

let apiInstance = new KestraApi.SecurityIntegrationsApi();
let id = "id_example"; // String | The ID of security integration
let tenant = "tenant_example"; // String | 
apiInstance.enableSecurityIntegration(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

Get a security integration.

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

let apiInstance = new KestraApi.SecurityIntegrationsApi();
let id = "id_example"; // String | The ID of security integration
let tenant = "tenant_example"; // String | 
apiInstance.getSecurityIntegration(id, tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

List all security integrations.

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

let apiInstance = new KestraApi.SecurityIntegrationsApi();
let tenant = "tenant_example"; // String | 
apiInstance.listSecurityIntegrations(tenant).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
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

