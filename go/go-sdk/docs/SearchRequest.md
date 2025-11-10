# SearchRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Schemas** | Pointer to **[]string** |  | [optional] 
**PageRequest** | Pointer to [**PageRequest**](PageRequest.md) |  | [optional] 
**SortRequest** | Pointer to [**SortRequest**](SortRequest.md) |  | [optional] 
**Attributes** | Pointer to [**[]AttributeReference**](AttributeReference.md) |  | [optional] 
**ExcludedAttributes** | Pointer to [**[]AttributeReference**](AttributeReference.md) |  | [optional] 
**Filter** | Pointer to [**Filter**](Filter.md) |  | [optional] 
**SortBy** | Pointer to [**AttributeReference**](AttributeReference.md) |  | [optional] 
**SortOrder** | Pointer to [**SortOrder**](SortOrder.md) |  | [optional] 
**StartIndex** | Pointer to **int32** |  | [optional] 
**Count** | Pointer to **int32** |  | [optional] 

## Methods

### NewSearchRequest

`func NewSearchRequest() *SearchRequest`

NewSearchRequest instantiates a new SearchRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSearchRequestWithDefaults

`func NewSearchRequestWithDefaults() *SearchRequest`

NewSearchRequestWithDefaults instantiates a new SearchRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSchemas

`func (o *SearchRequest) GetSchemas() []string`

GetSchemas returns the Schemas field if non-nil, zero value otherwise.

### GetSchemasOk

`func (o *SearchRequest) GetSchemasOk() (*[]string, bool)`

GetSchemasOk returns a tuple with the Schemas field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemas

`func (o *SearchRequest) SetSchemas(v []string)`

SetSchemas sets Schemas field to given value.

### HasSchemas

`func (o *SearchRequest) HasSchemas() bool`

HasSchemas returns a boolean if a field has been set.

### GetPageRequest

`func (o *SearchRequest) GetPageRequest() PageRequest`

GetPageRequest returns the PageRequest field if non-nil, zero value otherwise.

### GetPageRequestOk

`func (o *SearchRequest) GetPageRequestOk() (*PageRequest, bool)`

GetPageRequestOk returns a tuple with the PageRequest field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPageRequest

`func (o *SearchRequest) SetPageRequest(v PageRequest)`

SetPageRequest sets PageRequest field to given value.

### HasPageRequest

`func (o *SearchRequest) HasPageRequest() bool`

HasPageRequest returns a boolean if a field has been set.

### GetSortRequest

`func (o *SearchRequest) GetSortRequest() SortRequest`

GetSortRequest returns the SortRequest field if non-nil, zero value otherwise.

### GetSortRequestOk

`func (o *SearchRequest) GetSortRequestOk() (*SortRequest, bool)`

GetSortRequestOk returns a tuple with the SortRequest field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSortRequest

`func (o *SearchRequest) SetSortRequest(v SortRequest)`

SetSortRequest sets SortRequest field to given value.

### HasSortRequest

`func (o *SearchRequest) HasSortRequest() bool`

HasSortRequest returns a boolean if a field has been set.

### GetAttributes

`func (o *SearchRequest) GetAttributes() []AttributeReference`

GetAttributes returns the Attributes field if non-nil, zero value otherwise.

### GetAttributesOk

`func (o *SearchRequest) GetAttributesOk() (*[]AttributeReference, bool)`

GetAttributesOk returns a tuple with the Attributes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttributes

`func (o *SearchRequest) SetAttributes(v []AttributeReference)`

SetAttributes sets Attributes field to given value.

### HasAttributes

`func (o *SearchRequest) HasAttributes() bool`

HasAttributes returns a boolean if a field has been set.

### GetExcludedAttributes

`func (o *SearchRequest) GetExcludedAttributes() []AttributeReference`

GetExcludedAttributes returns the ExcludedAttributes field if non-nil, zero value otherwise.

### GetExcludedAttributesOk

`func (o *SearchRequest) GetExcludedAttributesOk() (*[]AttributeReference, bool)`

GetExcludedAttributesOk returns a tuple with the ExcludedAttributes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExcludedAttributes

`func (o *SearchRequest) SetExcludedAttributes(v []AttributeReference)`

SetExcludedAttributes sets ExcludedAttributes field to given value.

### HasExcludedAttributes

`func (o *SearchRequest) HasExcludedAttributes() bool`

HasExcludedAttributes returns a boolean if a field has been set.

### GetFilter

`func (o *SearchRequest) GetFilter() Filter`

GetFilter returns the Filter field if non-nil, zero value otherwise.

### GetFilterOk

`func (o *SearchRequest) GetFilterOk() (*Filter, bool)`

GetFilterOk returns a tuple with the Filter field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFilter

`func (o *SearchRequest) SetFilter(v Filter)`

SetFilter sets Filter field to given value.

### HasFilter

`func (o *SearchRequest) HasFilter() bool`

HasFilter returns a boolean if a field has been set.

### GetSortBy

`func (o *SearchRequest) GetSortBy() AttributeReference`

GetSortBy returns the SortBy field if non-nil, zero value otherwise.

### GetSortByOk

`func (o *SearchRequest) GetSortByOk() (*AttributeReference, bool)`

GetSortByOk returns a tuple with the SortBy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSortBy

`func (o *SearchRequest) SetSortBy(v AttributeReference)`

SetSortBy sets SortBy field to given value.

### HasSortBy

`func (o *SearchRequest) HasSortBy() bool`

HasSortBy returns a boolean if a field has been set.

### GetSortOrder

`func (o *SearchRequest) GetSortOrder() SortOrder`

GetSortOrder returns the SortOrder field if non-nil, zero value otherwise.

### GetSortOrderOk

`func (o *SearchRequest) GetSortOrderOk() (*SortOrder, bool)`

GetSortOrderOk returns a tuple with the SortOrder field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSortOrder

`func (o *SearchRequest) SetSortOrder(v SortOrder)`

SetSortOrder sets SortOrder field to given value.

### HasSortOrder

`func (o *SearchRequest) HasSortOrder() bool`

HasSortOrder returns a boolean if a field has been set.

### GetStartIndex

`func (o *SearchRequest) GetStartIndex() int32`

GetStartIndex returns the StartIndex field if non-nil, zero value otherwise.

### GetStartIndexOk

`func (o *SearchRequest) GetStartIndexOk() (*int32, bool)`

GetStartIndexOk returns a tuple with the StartIndex field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartIndex

`func (o *SearchRequest) SetStartIndex(v int32)`

SetStartIndex sets StartIndex field to given value.

### HasStartIndex

`func (o *SearchRequest) HasStartIndex() bool`

HasStartIndex returns a boolean if a field has been set.

### GetCount

`func (o *SearchRequest) GetCount() int32`

GetCount returns the Count field if non-nil, zero value otherwise.

### GetCountOk

`func (o *SearchRequest) GetCountOk() (*int32, bool)`

GetCountOk returns a tuple with the Count field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCount

`func (o *SearchRequest) SetCount(v int32)`

SetCount sets Count field to given value.

### HasCount

`func (o *SearchRequest) HasCount() bool`

HasCount returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


