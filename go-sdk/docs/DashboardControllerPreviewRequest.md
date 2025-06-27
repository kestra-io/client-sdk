# DashboardControllerPreviewRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Chart** | **string** |  | 
**GlobalFilter** | Pointer to [**NullableGlobalFilter**](GlobalFilter.md) |  | [optional] 

## Methods

### NewDashboardControllerPreviewRequest

`func NewDashboardControllerPreviewRequest(chart string, ) *DashboardControllerPreviewRequest`

NewDashboardControllerPreviewRequest instantiates a new DashboardControllerPreviewRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewDashboardControllerPreviewRequestWithDefaults

`func NewDashboardControllerPreviewRequestWithDefaults() *DashboardControllerPreviewRequest`

NewDashboardControllerPreviewRequestWithDefaults instantiates a new DashboardControllerPreviewRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetChart

`func (o *DashboardControllerPreviewRequest) GetChart() string`

GetChart returns the Chart field if non-nil, zero value otherwise.

### GetChartOk

`func (o *DashboardControllerPreviewRequest) GetChartOk() (*string, bool)`

GetChartOk returns a tuple with the Chart field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetChart

`func (o *DashboardControllerPreviewRequest) SetChart(v string)`

SetChart sets Chart field to given value.


### GetGlobalFilter

`func (o *DashboardControllerPreviewRequest) GetGlobalFilter() GlobalFilter`

GetGlobalFilter returns the GlobalFilter field if non-nil, zero value otherwise.

### GetGlobalFilterOk

`func (o *DashboardControllerPreviewRequest) GetGlobalFilterOk() (*GlobalFilter, bool)`

GetGlobalFilterOk returns a tuple with the GlobalFilter field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGlobalFilter

`func (o *DashboardControllerPreviewRequest) SetGlobalFilter(v GlobalFilter)`

SetGlobalFilter sets GlobalFilter field to given value.

### HasGlobalFilter

`func (o *DashboardControllerPreviewRequest) HasGlobalFilter() bool`

HasGlobalFilter returns a boolean if a field has been set.

### SetGlobalFilterNil

`func (o *DashboardControllerPreviewRequest) SetGlobalFilterNil(b bool)`

 SetGlobalFilterNil sets the value for GlobalFilter to be an explicit nil

### UnsetGlobalFilter
`func (o *DashboardControllerPreviewRequest) UnsetGlobalFilter()`

UnsetGlobalFilter ensures that no value is present for GlobalFilter, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


