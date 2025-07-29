# KestraApi.DashboardsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDashboard**](DashboardsApi.md#createDashboard) | **POST** /api/v1/{tenant}/dashboards | Create a dashboard from yaml source
[**deleteDashboard**](DashboardsApi.md#deleteDashboard) | **DELETE** /api/v1/{tenant}/dashboards/{id} | Delete a dashboard
[**exportChartToCsv**](DashboardsApi.md#exportChartToCsv) | **POST** /api/v1/{tenant}/dashboards/charts/export/to-csv | Export a table chart data to CSV
[**exportDashboardChartDataToCSV**](DashboardsApi.md#exportDashboardChartDataToCSV) | **POST** /api/v1/{tenant}/dashboards/{id}/charts/{chartId}/export/to-csv | Export a dashboard chart data to CSV
[**getDashboard**](DashboardsApi.md#getDashboard) | **GET** /api/v1/{tenant}/dashboards/{id} | Get a dashboard
[**getDashboardChartData**](DashboardsApi.md#getDashboardChartData) | **POST** /api/v1/{tenant}/dashboards/{id}/charts/{chartId} | Generate a dashboard chart data
[**previewChart**](DashboardsApi.md#previewChart) | **POST** /api/v1/{tenant}/dashboards/charts/preview | Preview a chart data
[**searchDashboards**](DashboardsApi.md#searchDashboards) | **GET** /api/v1/{tenant}/dashboards | Search for dashboards
[**updateDashboard**](DashboardsApi.md#updateDashboard) | **PUT** /api/v1/{tenant}/dashboards/{id} | Update a dashboard
[**validateChart**](DashboardsApi.md#validateChart) | **POST** /api/v1/{tenant}/dashboards/validate/chart | Validate a chart from yaml source
[**validateDashboard**](DashboardsApi.md#validateDashboard) | **POST** /api/v1/{tenant}/dashboards/validate | Validate dashboard from yaml source



## createDashboard

> Dashboard createDashboard(tenant, body)

Create a dashboard from yaml source

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The dashboard definition as YAML
apiInstance.createDashboard(tenant, body, (error, data, response) => {
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
 **body** | **String**| The dashboard definition as YAML | 

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## deleteDashboard

> deleteDashboard(id, tenant)

Delete a dashboard

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let id = "id_example"; // String | The dashboard id
let tenant = "tenant_example"; // String | 
apiInstance.deleteDashboard(id, tenant, (error, data, response) => {
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
 **id** | **String**| The dashboard id | 
 **tenant** | **String**|  | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## exportChartToCsv

> Blob exportChartToCsv(tenant, dashboardControllerPreviewRequest)

Export a table chart data to CSV

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let tenant = "tenant_example"; // String | 
let dashboardControllerPreviewRequest = new KestraApi.DashboardControllerPreviewRequest(); // DashboardControllerPreviewRequest | 
apiInstance.exportChartToCsv(tenant, dashboardControllerPreviewRequest, (error, data, response) => {
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
 **dashboardControllerPreviewRequest** | [**DashboardControllerPreviewRequest**](DashboardControllerPreviewRequest.md)|  | 

### Return type

**Blob**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream


## exportDashboardChartDataToCSV

> Blob exportDashboardChartDataToCSV(id, chartId, tenant, chartFiltersOverrides)

Export a dashboard chart data to CSV

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let id = "id_example"; // String | The dashboard id
let chartId = "chartId_example"; // String | The chart id
let tenant = "tenant_example"; // String | 
let chartFiltersOverrides = new KestraApi.ChartFiltersOverrides(); // ChartFiltersOverrides | The filters to apply, some can override chart definition like labels & namespace
apiInstance.exportDashboardChartDataToCSV(id, chartId, tenant, chartFiltersOverrides, (error, data, response) => {
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
 **id** | **String**| The dashboard id | 
 **chartId** | **String**| The chart id | 
 **tenant** | **String**|  | 
 **chartFiltersOverrides** | [**ChartFiltersOverrides**](ChartFiltersOverrides.md)| The filters to apply, some can override chart definition like labels &amp; namespace | 

### Return type

**Blob**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream


## getDashboard

> Dashboard getDashboard(id, tenant)

Get a dashboard

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let id = "id_example"; // String | The dashboard id
let tenant = "tenant_example"; // String | 
apiInstance.getDashboard(id, tenant, (error, data, response) => {
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
 **id** | **String**| The dashboard id | 
 **tenant** | **String**|  | 

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getDashboardChartData

> PagedResultsMapStringObject getDashboardChartData(id, chartId, tenant, chartFiltersOverrides)

Generate a dashboard chart data

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let id = "id_example"; // String | The dashboard id
let chartId = "chartId_example"; // String | The chart id
let tenant = "tenant_example"; // String | 
let chartFiltersOverrides = new KestraApi.ChartFiltersOverrides(); // ChartFiltersOverrides | The filters to apply, some can override chart definition like labels & namespace
apiInstance.getDashboardChartData(id, chartId, tenant, chartFiltersOverrides, (error, data, response) => {
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
 **id** | **String**| The dashboard id | 
 **chartId** | **String**| The chart id | 
 **tenant** | **String**|  | 
 **chartFiltersOverrides** | [**ChartFiltersOverrides**](ChartFiltersOverrides.md)| The filters to apply, some can override chart definition like labels &amp; namespace | 

### Return type

[**PagedResultsMapStringObject**](PagedResultsMapStringObject.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## previewChart

> PagedResultsMapStringObject previewChart(tenant, dashboardControllerPreviewRequest)

Preview a chart data

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let tenant = "tenant_example"; // String | 
let dashboardControllerPreviewRequest = new KestraApi.DashboardControllerPreviewRequest(); // DashboardControllerPreviewRequest | 
apiInstance.previewChart(tenant, dashboardControllerPreviewRequest, (error, data, response) => {
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
 **dashboardControllerPreviewRequest** | [**DashboardControllerPreviewRequest**](DashboardControllerPreviewRequest.md)|  | 

### Return type

[**PagedResultsMapStringObject**](PagedResultsMapStringObject.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## searchDashboards

> PagedResultsDashboard searchDashboards(page, size, tenant, opts)

Search for dashboards

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let page = 1; // Number | The current page
let size = 10; // Number | The current page size
let tenant = "tenant_example"; // String | 
let opts = {
  'q': "q_example", // String | The filter query
  'sort': ["null"] // [String] | The sort of current page
};
apiInstance.searchDashboards(page, size, tenant, opts, (error, data, response) => {
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
 **page** | **Number**| The current page | [default to 1]
 **size** | **Number**| The current page size | [default to 10]
 **tenant** | **String**|  | 
 **q** | **String**| The filter query | [optional] 
 **sort** | [**[String]**](String.md)| The sort of current page | [optional] 

### Return type

[**PagedResultsDashboard**](PagedResultsDashboard.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## updateDashboard

> Dashboard updateDashboard(id, tenant, body)

Update a dashboard

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let id = "id_example"; // String | The dashboard id
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The dashboard definition as YAML
apiInstance.updateDashboard(id, tenant, body, (error, data, response) => {
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
 **id** | **String**| The dashboard id | 
 **tenant** | **String**|  | 
 **body** | **String**| The dashboard definition as YAML | 

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## validateChart

> ValidateConstraintViolation validateChart(tenant, body)

Validate a chart from yaml source

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The chart definition as YAML
apiInstance.validateChart(tenant, body, (error, data, response) => {
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
 **body** | **String**| The chart definition as YAML | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


## validateDashboard

> ValidateConstraintViolation validateDashboard(tenant, body)

Validate dashboard from yaml source

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DashboardsApi();
let tenant = "tenant_example"; // String | 
let body = "body_example"; // String | The dashboard definition as YAML
apiInstance.validateDashboard(tenant, body, (error, data, response) => {
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
 **body** | **String**| The dashboard definition as YAML | 

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json

