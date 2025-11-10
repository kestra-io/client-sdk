# SortRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**SortBy** | Pointer to [**AttributeReference**](AttributeReference.md) |  | [optional] 
**SortOrder** | Pointer to [**SortOrder**](SortOrder.md) |  | [optional] 

## Methods

### NewSortRequest

`func NewSortRequest() *SortRequest`

NewSortRequest instantiates a new SortRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSortRequestWithDefaults

`func NewSortRequestWithDefaults() *SortRequest`

NewSortRequestWithDefaults instantiates a new SortRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSortBy

`func (o *SortRequest) GetSortBy() AttributeReference`

GetSortBy returns the SortBy field if non-nil, zero value otherwise.

### GetSortByOk

`func (o *SortRequest) GetSortByOk() (*AttributeReference, bool)`

GetSortByOk returns a tuple with the SortBy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSortBy

`func (o *SortRequest) SetSortBy(v AttributeReference)`

SetSortBy sets SortBy field to given value.

### HasSortBy

`func (o *SortRequest) HasSortBy() bool`

HasSortBy returns a boolean if a field has been set.

### GetSortOrder

`func (o *SortRequest) GetSortOrder() SortOrder`

GetSortOrder returns the SortOrder field if non-nil, zero value otherwise.

### GetSortOrderOk

`func (o *SortRequest) GetSortOrderOk() (*SortOrder, bool)`

GetSortOrderOk returns a tuple with the SortOrder field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSortOrder

`func (o *SortRequest) SetSortOrder(v SortOrder)`

SetSortOrder sets SortOrder field to given value.

### HasSortOrder

`func (o *SortRequest) HasSortOrder() bool`

HasSortOrder returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


