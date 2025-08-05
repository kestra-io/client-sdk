# KestraIoKestraSdk.SCIMConfigurationApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllResourceTypes**](SCIMConfigurationApi.md#getAllResourceTypes) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/ResourceTypes | 
[**getAllSchemas**](SCIMConfigurationApi.md#getAllSchemas) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Schemas | 
[**getResourceType**](SCIMConfigurationApi.md#getResourceType) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/ResourceTypes/{name} | 
[**getSchema**](SCIMConfigurationApi.md#getSchema) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/Schemas/{uri} | 
[**getServiceProviderConfiguration**](SCIMConfigurationApi.md#getServiceProviderConfiguration) | **GET** /api/v1/{tenant}/integrations/{integration}/scim/v2/ServiceProviderConfig | 



## getAllResourceTypes

> [ResourceType] getAllResourceTypes(integration, tenant)



Get All Resource Types

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMConfigurationApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.getAllResourceTypes(integration, tenant, (error, data, response) => {
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

### Return type

[**[ResourceType]**](ResourceType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json


## getAllSchemas

> [Schema] getAllSchemas(integration, tenant)



Get All Schemas

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMConfigurationApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.getAllSchemas(integration, tenant, (error, data, response) => {
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

### Return type

[**[Schema]**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json


## getResourceType

> ResourceType getResourceType(name, integration, tenant)



Get Resource Type by URN

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMConfigurationApi();
let name = "name_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.getResourceType(name, integration, tenant, (error, data, response) => {
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
 **name** | **String**|  | 
 **integration** | **String**|  | 
 **tenant** | **String**|  | 

### Return type

[**ResourceType**](ResourceType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json


## getSchema

> Schema getSchema(uri, integration, tenant)



Get Schemas by URN

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMConfigurationApi();
let uri = "uri_example"; // String | 
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.getSchema(uri, integration, tenant, (error, data, response) => {
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
 **uri** | **String**|  | 
 **integration** | **String**|  | 
 **tenant** | **String**|  | 

### Return type

[**Schema**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json


## getServiceProviderConfiguration

> ServiceProviderConfiguration getServiceProviderConfiguration(integration, tenant)



Get Service Provider Configuration

### Example

```javascript
import KestraIoKestraSdk from '@kestra-io/kestra-sdk';

let apiInstance = new KestraIoKestraSdk.SCIMConfigurationApi();
let integration = "integration_example"; // String | 
let tenant = "tenant_example"; // String | 
apiInstance.getServiceProviderConfiguration(integration, tenant, (error, data, response) => {
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

### Return type

[**ServiceProviderConfiguration**](ServiceProviderConfiguration.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/scim+json

