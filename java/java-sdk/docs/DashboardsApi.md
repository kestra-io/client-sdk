# DashboardsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDashboard**](DashboardsApi.md#createDashboard) | **POST** /api/v1/{tenant}/dashboards | Create a dashboard from yaml source |
| [**dashboard**](DashboardsApi.md#dashboard) | **GET** /api/v1/{tenant}/dashboards/{id} | Get a dashboard |
| [**dashboardChartData**](DashboardsApi.md#dashboardChartData) | **POST** /api/v1/{tenant}/dashboards/{id}/charts/{chartId} | Generate a dashboard chart data |
| [**deleteDashboard**](DashboardsApi.md#deleteDashboard) | **DELETE** /api/v1/{tenant}/dashboards/{id} | Delete a dashboard |
| [**exportChartToCsv**](DashboardsApi.md#exportChartToCsv) | **POST** /api/v1/{tenant}/dashboards/charts/export/to-csv | Export a table chart data to CSV |
| [**exportDashboardChartDataToCSV**](DashboardsApi.md#exportDashboardChartDataToCSV) | **POST** /api/v1/{tenant}/dashboards/{id}/charts/{chartId}/export/to-csv | Export a dashboard chart data to CSV |
| [**previewChart**](DashboardsApi.md#previewChart) | **POST** /api/v1/{tenant}/dashboards/charts/preview | Preview a chart data |
| [**searchDashboards**](DashboardsApi.md#searchDashboards) | **GET** /api/v1/{tenant}/dashboards | Search for dashboards |
| [**updateDashboard**](DashboardsApi.md#updateDashboard) | **PUT** /api/v1/{tenant}/dashboards/{id} | Update a dashboard |
| [**validateChart**](DashboardsApi.md#validateChart) | **POST** /api/v1/{tenant}/dashboards/validate/chart | Validate a chart from yaml source |
| [**validateDashboard**](DashboardsApi.md#validateDashboard) | **POST** /api/v1/{tenant}/dashboards/validate | Validate dashboard from yaml source |



## createDashboard

> Dashboard createDashboard(tenant, body)

Create a dashboard from yaml source

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The dashboard definition as YAML
        try {
            Dashboard result = kestraClient.DashboardsApi().createDashboard(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#createDashboard");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **body** | **String**| The dashboard definition as YAML | |

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | createDashboard 200 response |  -  |


## dashboard

> Dashboard dashboard(id, tenant)

Get a dashboard

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The dashboard id
        String tenant = "tenant_example"; // String | 
        try {
            Dashboard result = kestraClient.DashboardsApi().dashboard(id, tenant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#dashboard");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The dashboard id | |
| **tenant** | **String**|  | |

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getDashboard 200 response |  -  |


## dashboardChartData

> PagedResultsMapStringObject dashboardChartData(id, chartId, tenant, chartFiltersOverrides)

Generate a dashboard chart data

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The dashboard id
        String chartId = "chartId_example"; // String | The chart id
        String tenant = "tenant_example"; // String | 
        ChartFiltersOverrides chartFiltersOverrides = new ChartFiltersOverrides(); // ChartFiltersOverrides | The filters to apply, some can override chart definition like labels & namespace
        try {
            PagedResultsMapStringObject result = kestraClient.DashboardsApi().dashboardChartData(id, chartId, tenant, chartFiltersOverrides);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#dashboardChartData");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The dashboard id | |
| **chartId** | **String**| The chart id | |
| **tenant** | **String**|  | |
| **chartFiltersOverrides** | [**ChartFiltersOverrides**](ChartFiltersOverrides.md)| The filters to apply, some can override chart definition like labels &amp; namespace | |

### Return type

[**PagedResultsMapStringObject**](PagedResultsMapStringObject.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | getDashboardChartData 200 response |  -  |


## deleteDashboard

> deleteDashboard(id, tenant)

Delete a dashboard

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The dashboard id
        String tenant = "tenant_example"; // String | 
        try {
            kestraClient.DashboardsApi().deleteDashboard(id, tenant);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#deleteDashboard");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The dashboard id | |
| **tenant** | **String**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleteDashboard 200 response |  -  |


## exportChartToCsv

> byte[] exportChartToCsv(tenant, dashboardControllerPreviewRequest)

Export a table chart data to CSV

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        DashboardControllerPreviewRequest dashboardControllerPreviewRequest = new DashboardControllerPreviewRequest(); // DashboardControllerPreviewRequest | 
        try {
            byte[] result = kestraClient.DashboardsApi().exportChartToCsv(tenant, dashboardControllerPreviewRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#exportChartToCsv");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **dashboardControllerPreviewRequest** | [**DashboardControllerPreviewRequest**](DashboardControllerPreviewRequest.md)|  | |

### Return type

**byte[]**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | exportChartToCsv 200 response |  -  |


## exportDashboardChartDataToCSV

> byte[] exportDashboardChartDataToCSV(id, chartId, tenant, chartFiltersOverrides)

Export a dashboard chart data to CSV

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The dashboard id
        String chartId = "chartId_example"; // String | The chart id
        String tenant = "tenant_example"; // String | 
        ChartFiltersOverrides chartFiltersOverrides = new ChartFiltersOverrides(); // ChartFiltersOverrides | The filters to apply, some can override chart definition like labels & namespace
        try {
            byte[] result = kestraClient.DashboardsApi().exportDashboardChartDataToCSV(id, chartId, tenant, chartFiltersOverrides);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#exportDashboardChartDataToCSV");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The dashboard id | |
| **chartId** | **String**| The chart id | |
| **tenant** | **String**|  | |
| **chartFiltersOverrides** | [**ChartFiltersOverrides**](ChartFiltersOverrides.md)| The filters to apply, some can override chart definition like labels &amp; namespace | |

### Return type

**byte[]**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octet-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | exportDashboardChartDataToCSV 200 response |  -  |


## previewChart

> PagedResultsMapStringObject previewChart(tenant, dashboardControllerPreviewRequest)

Preview a chart data

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        DashboardControllerPreviewRequest dashboardControllerPreviewRequest = new DashboardControllerPreviewRequest(); // DashboardControllerPreviewRequest | 
        try {
            PagedResultsMapStringObject result = kestraClient.DashboardsApi().previewChart(tenant, dashboardControllerPreviewRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#previewChart");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **dashboardControllerPreviewRequest** | [**DashboardControllerPreviewRequest**](DashboardControllerPreviewRequest.md)|  | |

### Return type

[**PagedResultsMapStringObject**](PagedResultsMapStringObject.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | previewChart 200 response |  -  |


## searchDashboards

> PagedResultsDashboard searchDashboards(page, size, tenant, q, sort)

Search for dashboards

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        Integer page = 1; // Integer | The current page
        Integer size = 10; // Integer | The current page size
        String tenant = "tenant_example"; // String | 
        String q = "q_example"; // String | The filter query
        List<String> sort = Arrays.asList(); // List<String> | The sort of current page
        try {
            PagedResultsDashboard result = kestraClient.DashboardsApi().searchDashboards(page, size, tenant, q, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#searchDashboards");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| The current page | [default to 1] |
| **size** | **Integer**| The current page size | [default to 10] |
| **tenant** | **String**|  | |
| **q** | **String**| The filter query | [optional] |
| **sort** | [**List&lt;String&gt;**](String.md)| The sort of current page | [optional] |

### Return type

[**PagedResultsDashboard**](PagedResultsDashboard.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | searchDashboards 200 response |  -  |


## updateDashboard

> Dashboard updateDashboard(id, tenant, body)

Update a dashboard

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String id = "id_example"; // String | The dashboard id
        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The dashboard definition as YAML
        try {
            Dashboard result = kestraClient.DashboardsApi().updateDashboard(id, tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#updateDashboard");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The dashboard id | |
| **tenant** | **String**|  | |
| **body** | **String**| The dashboard definition as YAML | |

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | updateDashboard 200 response |  -  |


## validateChart

> ValidateConstraintViolation validateChart(tenant, body)

Validate a chart from yaml source

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The chart definition as YAML
        try {
            ValidateConstraintViolation result = kestraClient.DashboardsApi().validateChart(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#validateChart");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **body** | **String**| The chart definition as YAML | |

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | validateChart 200 response |  -  |


## validateDashboard

> ValidateConstraintViolation validateDashboard(tenant, body)

Validate dashboard from yaml source

### Example

```java
// Import classes:
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.internal.Configuration;
import io.kestra.sdk.internal.models.*;
import io.kestra.sdk.api.DashboardsApi;

public class Example {
    public static void main(String[] args) {
        public static String MAIN_TENANT = "main";

        KestraClient kestraClient = KestraClient.builder()
        .basicAuth("root@root.com", "Root!1234")
        .url("http://localhost:8080")
        .build();

        String tenant = "tenant_example"; // String | 
        String body = "body_example"; // String | The dashboard definition as YAML
        try {
            ValidateConstraintViolation result = kestraClient.DashboardsApi().validateDashboard(tenant, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DashboardsApi#validateDashboard");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenant** | **String**|  | |
| **body** | **String**| The dashboard definition as YAML | |

### Return type

[**ValidateConstraintViolation**](ValidateConstraintViolation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-yaml
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | validateDashboard 200 response |  -  |

