# ApiToken

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Prefix** | Pointer to **string** |  | [optional] 
**Iat** | Pointer to **time.Time** |  | [optional] 
**Exp** | Pointer to **time.Time** |  | [optional] 
**LastUsed** | Pointer to **time.Time** |  | [optional] 
**Extended** | Pointer to **bool** |  | [optional] 
**Expired** | Pointer to **bool** |  | [optional] 

## Methods

### NewApiToken

`func NewApiToken() *ApiToken`

NewApiToken instantiates a new ApiToken object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiTokenWithDefaults

`func NewApiTokenWithDefaults() *ApiToken`

NewApiTokenWithDefaults instantiates a new ApiToken object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ApiToken) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ApiToken) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ApiToken) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ApiToken) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *ApiToken) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *ApiToken) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *ApiToken) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *ApiToken) HasName() bool`

HasName returns a boolean if a field has been set.

### GetDescription

`func (o *ApiToken) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ApiToken) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ApiToken) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *ApiToken) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetPrefix

`func (o *ApiToken) GetPrefix() string`

GetPrefix returns the Prefix field if non-nil, zero value otherwise.

### GetPrefixOk

`func (o *ApiToken) GetPrefixOk() (*string, bool)`

GetPrefixOk returns a tuple with the Prefix field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPrefix

`func (o *ApiToken) SetPrefix(v string)`

SetPrefix sets Prefix field to given value.

### HasPrefix

`func (o *ApiToken) HasPrefix() bool`

HasPrefix returns a boolean if a field has been set.

### GetIat

`func (o *ApiToken) GetIat() time.Time`

GetIat returns the Iat field if non-nil, zero value otherwise.

### GetIatOk

`func (o *ApiToken) GetIatOk() (*time.Time, bool)`

GetIatOk returns a tuple with the Iat field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIat

`func (o *ApiToken) SetIat(v time.Time)`

SetIat sets Iat field to given value.

### HasIat

`func (o *ApiToken) HasIat() bool`

HasIat returns a boolean if a field has been set.

### GetExp

`func (o *ApiToken) GetExp() time.Time`

GetExp returns the Exp field if non-nil, zero value otherwise.

### GetExpOk

`func (o *ApiToken) GetExpOk() (*time.Time, bool)`

GetExpOk returns a tuple with the Exp field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExp

`func (o *ApiToken) SetExp(v time.Time)`

SetExp sets Exp field to given value.

### HasExp

`func (o *ApiToken) HasExp() bool`

HasExp returns a boolean if a field has been set.

### GetLastUsed

`func (o *ApiToken) GetLastUsed() time.Time`

GetLastUsed returns the LastUsed field if non-nil, zero value otherwise.

### GetLastUsedOk

`func (o *ApiToken) GetLastUsedOk() (*time.Time, bool)`

GetLastUsedOk returns a tuple with the LastUsed field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLastUsed

`func (o *ApiToken) SetLastUsed(v time.Time)`

SetLastUsed sets LastUsed field to given value.

### HasLastUsed

`func (o *ApiToken) HasLastUsed() bool`

HasLastUsed returns a boolean if a field has been set.

### GetExtended

`func (o *ApiToken) GetExtended() bool`

GetExtended returns the Extended field if non-nil, zero value otherwise.

### GetExtendedOk

`func (o *ApiToken) GetExtendedOk() (*bool, bool)`

GetExtendedOk returns a tuple with the Extended field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExtended

`func (o *ApiToken) SetExtended(v bool)`

SetExtended sets Extended field to given value.

### HasExtended

`func (o *ApiToken) HasExtended() bool`

HasExtended returns a boolean if a field has been set.

### GetExpired

`func (o *ApiToken) GetExpired() bool`

GetExpired returns the Expired field if non-nil, zero value otherwise.

### GetExpiredOk

`func (o *ApiToken) GetExpiredOk() (*bool, bool)`

GetExpiredOk returns a tuple with the Expired field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpired

`func (o *ApiToken) SetExpired(v bool)`

SetExpired sets Expired field to given value.

### HasExpired

`func (o *ApiToken) HasExpired() bool`

HasExpired returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


