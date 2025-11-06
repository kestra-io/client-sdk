# ApiAutocomplete

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Q** | Pointer to **NullableString** |  | [optional] 
**Ids** | Pointer to **[]string** |  | [optional] 
**ExistingOnly** | Pointer to **bool** |  | [optional] 

## Methods

### NewApiAutocomplete

`func NewApiAutocomplete() *ApiAutocomplete`

NewApiAutocomplete instantiates a new ApiAutocomplete object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiAutocompleteWithDefaults

`func NewApiAutocompleteWithDefaults() *ApiAutocomplete`

NewApiAutocompleteWithDefaults instantiates a new ApiAutocomplete object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetQ

`func (o *ApiAutocomplete) GetQ() string`

GetQ returns the Q field if non-nil, zero value otherwise.

### GetQOk

`func (o *ApiAutocomplete) GetQOk() (*string, bool)`

GetQOk returns a tuple with the Q field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetQ

`func (o *ApiAutocomplete) SetQ(v string)`

SetQ sets Q field to given value.

### HasQ

`func (o *ApiAutocomplete) HasQ() bool`

HasQ returns a boolean if a field has been set.

### SetQNil

`func (o *ApiAutocomplete) SetQNil(b bool)`

 SetQNil sets the value for Q to be an explicit nil

### UnsetQ
`func (o *ApiAutocomplete) UnsetQ()`

UnsetQ ensures that no value is present for Q, not even an explicit nil
### GetIds

`func (o *ApiAutocomplete) GetIds() []string`

GetIds returns the Ids field if non-nil, zero value otherwise.

### GetIdsOk

`func (o *ApiAutocomplete) GetIdsOk() (*[]string, bool)`

GetIdsOk returns a tuple with the Ids field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIds

`func (o *ApiAutocomplete) SetIds(v []string)`

SetIds sets Ids field to given value.

### HasIds

`func (o *ApiAutocomplete) HasIds() bool`

HasIds returns a boolean if a field has been set.

### SetIdsNil

`func (o *ApiAutocomplete) SetIdsNil(b bool)`

 SetIdsNil sets the value for Ids to be an explicit nil

### UnsetIds
`func (o *ApiAutocomplete) UnsetIds()`

UnsetIds ensures that no value is present for Ids, not even an explicit nil
### GetExistingOnly

`func (o *ApiAutocomplete) GetExistingOnly() bool`

GetExistingOnly returns the ExistingOnly field if non-nil, zero value otherwise.

### GetExistingOnlyOk

`func (o *ApiAutocomplete) GetExistingOnlyOk() (*bool, bool)`

GetExistingOnlyOk returns a tuple with the ExistingOnly field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExistingOnly

`func (o *ApiAutocomplete) SetExistingOnly(v bool)`

SetExistingOnly sets ExistingOnly field to given value.

### HasExistingOnly

`func (o *ApiAutocomplete) HasExistingOnly() bool`

HasExistingOnly returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


