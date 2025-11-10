# KVEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Key** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **NullableString** |  | [optional] 
**CreationDate** | Pointer to **time.Time** |  | [optional] 
**UpdateDate** | Pointer to **time.Time** |  | [optional] 
**ExpirationDate** | Pointer to **NullableTime** |  | [optional] 

## Methods

### NewKVEntry

`func NewKVEntry() *KVEntry`

NewKVEntry instantiates a new KVEntry object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewKVEntryWithDefaults

`func NewKVEntryWithDefaults() *KVEntry`

NewKVEntryWithDefaults instantiates a new KVEntry object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetKey

`func (o *KVEntry) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *KVEntry) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *KVEntry) SetKey(v string)`

SetKey sets Key field to given value.

### HasKey

`func (o *KVEntry) HasKey() bool`

HasKey returns a boolean if a field has been set.

### GetDescription

`func (o *KVEntry) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *KVEntry) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *KVEntry) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *KVEntry) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### SetDescriptionNil

`func (o *KVEntry) SetDescriptionNil(b bool)`

 SetDescriptionNil sets the value for Description to be an explicit nil

### UnsetDescription
`func (o *KVEntry) UnsetDescription()`

UnsetDescription ensures that no value is present for Description, not even an explicit nil
### GetCreationDate

`func (o *KVEntry) GetCreationDate() time.Time`

GetCreationDate returns the CreationDate field if non-nil, zero value otherwise.

### GetCreationDateOk

`func (o *KVEntry) GetCreationDateOk() (*time.Time, bool)`

GetCreationDateOk returns a tuple with the CreationDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreationDate

`func (o *KVEntry) SetCreationDate(v time.Time)`

SetCreationDate sets CreationDate field to given value.

### HasCreationDate

`func (o *KVEntry) HasCreationDate() bool`

HasCreationDate returns a boolean if a field has been set.

### GetUpdateDate

`func (o *KVEntry) GetUpdateDate() time.Time`

GetUpdateDate returns the UpdateDate field if non-nil, zero value otherwise.

### GetUpdateDateOk

`func (o *KVEntry) GetUpdateDateOk() (*time.Time, bool)`

GetUpdateDateOk returns a tuple with the UpdateDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUpdateDate

`func (o *KVEntry) SetUpdateDate(v time.Time)`

SetUpdateDate sets UpdateDate field to given value.

### HasUpdateDate

`func (o *KVEntry) HasUpdateDate() bool`

HasUpdateDate returns a boolean if a field has been set.

### GetExpirationDate

`func (o *KVEntry) GetExpirationDate() time.Time`

GetExpirationDate returns the ExpirationDate field if non-nil, zero value otherwise.

### GetExpirationDateOk

`func (o *KVEntry) GetExpirationDateOk() (*time.Time, bool)`

GetExpirationDateOk returns a tuple with the ExpirationDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpirationDate

`func (o *KVEntry) SetExpirationDate(v time.Time)`

SetExpirationDate sets ExpirationDate field to given value.

### HasExpirationDate

`func (o *KVEntry) HasExpirationDate() bool`

HasExpirationDate returns a boolean if a field has been set.

### SetExpirationDateNil

`func (o *KVEntry) SetExpirationDateNil(b bool)`

 SetExpirationDateNil sets the value for ExpirationDate to be an explicit nil

### UnsetExpirationDate
`func (o *KVEntry) UnsetExpirationDate()`

UnsetExpirationDate ensures that no value is present for ExpirationDate, not even an explicit nil

[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


