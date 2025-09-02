# KVEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Key** | **string** |  | 
**Description** | **string** |  | 
**CreationDate** | **time.Time** |  | 
**UpdateDate** | **time.Time** |  | 
**ExpirationDate** | **time.Time** |  | 

## Methods

### NewKVEntry

`func NewKVEntry(key string, description string, creationDate time.Time, updateDate time.Time, expirationDate time.Time, ) *KVEntry`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


