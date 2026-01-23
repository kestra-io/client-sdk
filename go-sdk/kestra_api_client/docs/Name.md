# Name

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**FamilyName** | Pointer to **string** |  | [optional] 
**GivenName** | Pointer to **string** |  | [optional] 

## Methods

### NewName

`func NewName() *Name`

NewName instantiates a new Name object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewNameWithDefaults

`func NewNameWithDefaults() *Name`

NewNameWithDefaults instantiates a new Name object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFamilyName

`func (o *Name) GetFamilyName() string`

GetFamilyName returns the FamilyName field if non-nil, zero value otherwise.

### GetFamilyNameOk

`func (o *Name) GetFamilyNameOk() (*string, bool)`

GetFamilyNameOk returns a tuple with the FamilyName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFamilyName

`func (o *Name) SetFamilyName(v string)`

SetFamilyName sets FamilyName field to given value.

### HasFamilyName

`func (o *Name) HasFamilyName() bool`

HasFamilyName returns a boolean if a field has been set.

### GetGivenName

`func (o *Name) GetGivenName() string`

GetGivenName returns the GivenName field if non-nil, zero value otherwise.

### GetGivenNameOk

`func (o *Name) GetGivenNameOk() (*string, bool)`

GetGivenNameOk returns a tuple with the GivenName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGivenName

`func (o *Name) SetGivenName(v string)`

SetGivenName sets GivenName field to given value.

### HasGivenName

`func (o *Name) HasGivenName() bool`

HasGivenName returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


