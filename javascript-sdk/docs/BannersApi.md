# KestraApi.BannersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBanner**](BannersApi.md#createBanner) | **POST** /api/v1/banners | Create a new banner
[**deleteBanner**](BannersApi.md#deleteBanner) | **DELETE** /api/v1/banners/{id} | Delete a banner
[**searchBanners**](BannersApi.md#searchBanners) | **GET** /api/v1/banners/search | Get banners
[**updateBanner**](BannersApi.md#updateBanner) | **PUT** /api/v1/banners/{id} | Update a banner



## createBanner

> Banner createBanner(banner)

Create a new banner

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

let apiInstance = new KestraApi.BannersApi();
let banner = new KestraApi.Banner(); // Banner | The banner to create
apiInstance.createBanner(banner).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **banner** | [**Banner**](Banner.md)| The banner to create | 

### Return type

[**Banner**](Banner.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## deleteBanner

> deleteBanner(id)

Delete a banner

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

let apiInstance = new KestraApi.BannersApi();
let id = "id_example"; // String | The banner id
apiInstance.deleteBanner(id).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The banner id | 

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## searchBanners

> [Banner] searchBanners()

Get banners

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

let apiInstance = new KestraApi.BannersApi();
apiInstance.searchBanners().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[Banner]**](Banner.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateBanner

> Banner updateBanner(id, banner)

Update a banner

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

let apiInstance = new KestraApi.BannersApi();
let id = "id_example"; // String | The banner id
let banner = new KestraApi.Banner(); // Banner | The banner to update
apiInstance.updateBanner(id, banner).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The banner id | 
 **banner** | [**Banner**](Banner.md)| The banner to update | 

### Return type

[**Banner**](Banner.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

