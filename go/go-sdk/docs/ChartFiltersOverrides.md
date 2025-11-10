# ChartFiltersOverrides

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**StartDate** | Pointer to **time.Time** |  | [optional] 
**EndDate** | Pointer to **time.Time** |  | [optional] 
**PageSize** | Pointer to **int32** |  | [optional] 
**PageNumber** | Pointer to **int32** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**Labels** | Pointer to **map[string]string** |  | [optional] 
**Filters** | Pointer to [**[]QueryFilter**](QueryFilter.md) |  | [optional] 

## Methods

### NewChartFiltersOverrides

`func NewChartFiltersOverrides() *ChartFiltersOverrides`

NewChartFiltersOverrides instantiates a new ChartFiltersOverrides object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewChartFiltersOverridesWithDefaults

`func NewChartFiltersOverridesWithDefaults() *ChartFiltersOverrides`

NewChartFiltersOverridesWithDefaults instantiates a new ChartFiltersOverrides object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetStartDate

`func (o *ChartFiltersOverrides) GetStartDate() time.Time`

GetStartDate returns the StartDate field if non-nil, zero value otherwise.

### GetStartDateOk

`func (o *ChartFiltersOverrides) GetStartDateOk() (*time.Time, bool)`

GetStartDateOk returns a tuple with the StartDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartDate

`func (o *ChartFiltersOverrides) SetStartDate(v time.Time)`

SetStartDate sets StartDate field to given value.

### HasStartDate

`func (o *ChartFiltersOverrides) HasStartDate() bool`

HasStartDate returns a boolean if a field has been set.

### GetEndDate

`func (o *ChartFiltersOverrides) GetEndDate() time.Time`

GetEndDate returns the EndDate field if non-nil, zero value otherwise.

### GetEndDateOk

`func (o *ChartFiltersOverrides) GetEndDateOk() (*time.Time, bool)`

GetEndDateOk returns a tuple with the EndDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEndDate

`func (o *ChartFiltersOverrides) SetEndDate(v time.Time)`

SetEndDate sets EndDate field to given value.

### HasEndDate

`func (o *ChartFiltersOverrides) HasEndDate() bool`

HasEndDate returns a boolean if a field has been set.

### GetPageSize

`func (o *ChartFiltersOverrides) GetPageSize() int32`

GetPageSize returns the PageSize field if non-nil, zero value otherwise.

### GetPageSizeOk

`func (o *ChartFiltersOverrides) GetPageSizeOk() (*int32, bool)`

GetPageSizeOk returns a tuple with the PageSize field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPageSize

`func (o *ChartFiltersOverrides) SetPageSize(v int32)`

SetPageSize sets PageSize field to given value.

### HasPageSize

`func (o *ChartFiltersOverrides) HasPageSize() bool`

HasPageSize returns a boolean if a field has been set.

### GetPageNumber

`func (o *ChartFiltersOverrides) GetPageNumber() int32`

GetPageNumber returns the PageNumber field if non-nil, zero value otherwise.

### GetPageNumberOk

`func (o *ChartFiltersOverrides) GetPageNumberOk() (*int32, bool)`

GetPageNumberOk returns a tuple with the PageNumber field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPageNumber

`func (o *ChartFiltersOverrides) SetPageNumber(v int32)`

SetPageNumber sets PageNumber field to given value.

### HasPageNumber

`func (o *ChartFiltersOverrides) HasPageNumber() bool`

HasPageNumber returns a boolean if a field has been set.

### GetNamespace

`func (o *ChartFiltersOverrides) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ChartFiltersOverrides) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ChartFiltersOverrides) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *ChartFiltersOverrides) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetLabels

`func (o *ChartFiltersOverrides) GetLabels() map[string]string`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *ChartFiltersOverrides) GetLabelsOk() (*map[string]string, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *ChartFiltersOverrides) SetLabels(v map[string]string)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *ChartFiltersOverrides) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetFilters

`func (o *ChartFiltersOverrides) GetFilters() []QueryFilter`

GetFilters returns the Filters field if non-nil, zero value otherwise.

### GetFiltersOk

`func (o *ChartFiltersOverrides) GetFiltersOk() (*[]QueryFilter, bool)`

GetFiltersOk returns a tuple with the Filters field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFilters

`func (o *ChartFiltersOverrides) SetFilters(v []QueryFilter)`

SetFilters sets Filters field to given value.

### HasFilters

`func (o *ChartFiltersOverrides) HasFilters() bool`

HasFilters returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


