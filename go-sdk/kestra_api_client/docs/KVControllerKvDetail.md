# KVControllerKvDetail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Type** | Pointer to [**KVType**](KVType.md) |  | [optional] 
**Value** | Pointer to **map[string]interface{}** |  | [optional] 
**Revision** | Pointer to **int32** |  | [optional] 
**Updated** | Pointer to **time.Time** |  | [optional] 

## Methods

### NewKVControllerKvDetail

`func NewKVControllerKvDetail() *KVControllerKvDetail`

NewKVControllerKvDetail instantiates a new KVControllerKvDetail object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewKVControllerKvDetailWithDefaults

`func NewKVControllerKvDetailWithDefaults() *KVControllerKvDetail`

NewKVControllerKvDetailWithDefaults instantiates a new KVControllerKvDetail object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetType

`func (o *KVControllerKvDetail) GetType() KVType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *KVControllerKvDetail) GetTypeOk() (*KVType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *KVControllerKvDetail) SetType(v KVType)`

SetType sets Type field to given value.

### HasType

`func (o *KVControllerKvDetail) HasType() bool`

HasType returns a boolean if a field has been set.

### GetValue

`func (o *KVControllerKvDetail) GetValue() map[string]interface{}`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *KVControllerKvDetail) GetValueOk() (*map[string]interface{}, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *KVControllerKvDetail) SetValue(v map[string]interface{})`

SetValue sets Value field to given value.

### HasValue

`func (o *KVControllerKvDetail) HasValue() bool`

HasValue returns a boolean if a field has been set.

### GetRevision

`func (o *KVControllerKvDetail) GetRevision() int32`

GetRevision returns the Revision field if non-nil, zero value otherwise.

### GetRevisionOk

`func (o *KVControllerKvDetail) GetRevisionOk() (*int32, bool)`

GetRevisionOk returns a tuple with the Revision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevision

`func (o *KVControllerKvDetail) SetRevision(v int32)`

SetRevision sets Revision field to given value.

### HasRevision

`func (o *KVControllerKvDetail) HasRevision() bool`

HasRevision returns a boolean if a field has been set.

### GetUpdated

`func (o *KVControllerKvDetail) GetUpdated() time.Time`

GetUpdated returns the Updated field if non-nil, zero value otherwise.

### GetUpdatedOk

`func (o *KVControllerKvDetail) GetUpdatedOk() (*time.Time, bool)`

GetUpdatedOk returns a tuple with the Updated field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUpdated

`func (o *KVControllerKvDetail) SetUpdated(v time.Time)`

SetUpdated sets Updated field to given value.

### HasUpdated

`func (o *KVControllerKvDetail) HasUpdated() bool`

HasUpdated returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


