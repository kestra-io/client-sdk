# DeleteExecutionsByQueryRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Filters** | Pointer to [**[]QueryFilter**](QueryFilter.md) | Filters | [optional] 

## Methods

### NewDeleteExecutionsByQueryRequest

`func NewDeleteExecutionsByQueryRequest() *DeleteExecutionsByQueryRequest`

NewDeleteExecutionsByQueryRequest instantiates a new DeleteExecutionsByQueryRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewDeleteExecutionsByQueryRequestWithDefaults

`func NewDeleteExecutionsByQueryRequestWithDefaults() *DeleteExecutionsByQueryRequest`

NewDeleteExecutionsByQueryRequestWithDefaults instantiates a new DeleteExecutionsByQueryRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFilters

`func (o *DeleteExecutionsByQueryRequest) GetFilters() []QueryFilter`

GetFilters returns the Filters field if non-nil, zero value otherwise.

### GetFiltersOk

`func (o *DeleteExecutionsByQueryRequest) GetFiltersOk() (*[]QueryFilter, bool)`

GetFiltersOk returns a tuple with the Filters field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFilters

`func (o *DeleteExecutionsByQueryRequest) SetFilters(v []QueryFilter)`

SetFilters sets Filters field to given value.

### HasFilters

`func (o *DeleteExecutionsByQueryRequest) HasFilters() bool`

HasFilters returns a boolean if a field has been set.

### SetFiltersNil

`func (o *DeleteExecutionsByQueryRequest) SetFiltersNil(b bool)`

 SetFiltersNil sets the value for Filters to be an explicit nil

### UnsetFilters
`func (o *DeleteExecutionsByQueryRequest) UnsetFilters()`

UnsetFilters ensures that no value is present for Filters, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


