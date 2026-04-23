# DashboardControllerDashboardResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | Pointer to **string** |  | [optional] 
**Id** | **string** |  | 
**Title** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**TimeWindow** | Pointer to [**TimeWindow**](TimeWindow.md) |  | [optional] 
**Charts** | Pointer to [**[]ChartChartOption**](ChartChartOption.md) |  | [optional] 
**Deleted** | **bool** |  | 
**Created** | Pointer to **time.Time** |  | [optional] 
**Updated** | Pointer to **time.Time** |  | [optional] 
**SourceCode** | Pointer to **string** |  | [optional] 

## Methods

### NewDashboardControllerDashboardResponse

`func NewDashboardControllerDashboardResponse(id string, title string, deleted bool, ) *DashboardControllerDashboardResponse`

NewDashboardControllerDashboardResponse instantiates a new DashboardControllerDashboardResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewDashboardControllerDashboardResponseWithDefaults

`func NewDashboardControllerDashboardResponseWithDefaults() *DashboardControllerDashboardResponse`

NewDashboardControllerDashboardResponseWithDefaults instantiates a new DashboardControllerDashboardResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenantId

`func (o *DashboardControllerDashboardResponse) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *DashboardControllerDashboardResponse) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *DashboardControllerDashboardResponse) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *DashboardControllerDashboardResponse) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetId

`func (o *DashboardControllerDashboardResponse) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *DashboardControllerDashboardResponse) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *DashboardControllerDashboardResponse) SetId(v string)`

SetId sets Id field to given value.


### GetTitle

`func (o *DashboardControllerDashboardResponse) GetTitle() string`

GetTitle returns the Title field if non-nil, zero value otherwise.

### GetTitleOk

`func (o *DashboardControllerDashboardResponse) GetTitleOk() (*string, bool)`

GetTitleOk returns a tuple with the Title field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTitle

`func (o *DashboardControllerDashboardResponse) SetTitle(v string)`

SetTitle sets Title field to given value.


### GetDescription

`func (o *DashboardControllerDashboardResponse) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *DashboardControllerDashboardResponse) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *DashboardControllerDashboardResponse) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *DashboardControllerDashboardResponse) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetTimeWindow

`func (o *DashboardControllerDashboardResponse) GetTimeWindow() TimeWindow`

GetTimeWindow returns the TimeWindow field if non-nil, zero value otherwise.

### GetTimeWindowOk

`func (o *DashboardControllerDashboardResponse) GetTimeWindowOk() (*TimeWindow, bool)`

GetTimeWindowOk returns a tuple with the TimeWindow field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTimeWindow

`func (o *DashboardControllerDashboardResponse) SetTimeWindow(v TimeWindow)`

SetTimeWindow sets TimeWindow field to given value.

### HasTimeWindow

`func (o *DashboardControllerDashboardResponse) HasTimeWindow() bool`

HasTimeWindow returns a boolean if a field has been set.

### GetCharts

`func (o *DashboardControllerDashboardResponse) GetCharts() []ChartChartOption`

GetCharts returns the Charts field if non-nil, zero value otherwise.

### GetChartsOk

`func (o *DashboardControllerDashboardResponse) GetChartsOk() (*[]ChartChartOption, bool)`

GetChartsOk returns a tuple with the Charts field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCharts

`func (o *DashboardControllerDashboardResponse) SetCharts(v []ChartChartOption)`

SetCharts sets Charts field to given value.

### HasCharts

`func (o *DashboardControllerDashboardResponse) HasCharts() bool`

HasCharts returns a boolean if a field has been set.

### GetDeleted

`func (o *DashboardControllerDashboardResponse) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *DashboardControllerDashboardResponse) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *DashboardControllerDashboardResponse) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetCreated

`func (o *DashboardControllerDashboardResponse) GetCreated() time.Time`

GetCreated returns the Created field if non-nil, zero value otherwise.

### GetCreatedOk

`func (o *DashboardControllerDashboardResponse) GetCreatedOk() (*time.Time, bool)`

GetCreatedOk returns a tuple with the Created field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreated

`func (o *DashboardControllerDashboardResponse) SetCreated(v time.Time)`

SetCreated sets Created field to given value.

### HasCreated

`func (o *DashboardControllerDashboardResponse) HasCreated() bool`

HasCreated returns a boolean if a field has been set.

### GetUpdated

`func (o *DashboardControllerDashboardResponse) GetUpdated() time.Time`

GetUpdated returns the Updated field if non-nil, zero value otherwise.

### GetUpdatedOk

`func (o *DashboardControllerDashboardResponse) GetUpdatedOk() (*time.Time, bool)`

GetUpdatedOk returns a tuple with the Updated field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUpdated

`func (o *DashboardControllerDashboardResponse) SetUpdated(v time.Time)`

SetUpdated sets Updated field to given value.

### HasUpdated

`func (o *DashboardControllerDashboardResponse) HasUpdated() bool`

HasUpdated returns a boolean if a field has been set.

### GetSourceCode

`func (o *DashboardControllerDashboardResponse) GetSourceCode() string`

GetSourceCode returns the SourceCode field if non-nil, zero value otherwise.

### GetSourceCodeOk

`func (o *DashboardControllerDashboardResponse) GetSourceCodeOk() (*string, bool)`

GetSourceCodeOk returns a tuple with the SourceCode field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSourceCode

`func (o *DashboardControllerDashboardResponse) SetSourceCode(v string)`

SetSourceCode sets SourceCode field to given value.

### HasSourceCode

`func (o *DashboardControllerDashboardResponse) HasSourceCode() bool`

HasSourceCode returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


