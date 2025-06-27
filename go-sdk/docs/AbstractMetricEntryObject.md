# AbstractMetricEntryObject

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Type** | Pointer to **string** |  | [optional] 
**Value** | Pointer to **interface{}** |  | [optional] 
**Name** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**Tags** | Pointer to **map[string]string** |  | [optional] 
**Timestamp** | Pointer to **time.Time** |  | [optional] 

## Methods

### NewAbstractMetricEntryObject

`func NewAbstractMetricEntryObject(name string, ) *AbstractMetricEntryObject`

NewAbstractMetricEntryObject instantiates a new AbstractMetricEntryObject object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAbstractMetricEntryObjectWithDefaults

`func NewAbstractMetricEntryObjectWithDefaults() *AbstractMetricEntryObject`

NewAbstractMetricEntryObjectWithDefaults instantiates a new AbstractMetricEntryObject object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetType

`func (o *AbstractMetricEntryObject) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AbstractMetricEntryObject) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AbstractMetricEntryObject) SetType(v string)`

SetType sets Type field to given value.

### HasType

`func (o *AbstractMetricEntryObject) HasType() bool`

HasType returns a boolean if a field has been set.

### GetValue

`func (o *AbstractMetricEntryObject) GetValue() interface{}`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *AbstractMetricEntryObject) GetValueOk() (*interface{}, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *AbstractMetricEntryObject) SetValue(v interface{})`

SetValue sets Value field to given value.

### HasValue

`func (o *AbstractMetricEntryObject) HasValue() bool`

HasValue returns a boolean if a field has been set.

### SetValueNil

`func (o *AbstractMetricEntryObject) SetValueNil(b bool)`

 SetValueNil sets the value for Value to be an explicit nil

### UnsetValue
`func (o *AbstractMetricEntryObject) UnsetValue()`

UnsetValue ensures that no value is present for Value, not even an explicit nil
### GetName

`func (o *AbstractMetricEntryObject) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *AbstractMetricEntryObject) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *AbstractMetricEntryObject) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *AbstractMetricEntryObject) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *AbstractMetricEntryObject) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *AbstractMetricEntryObject) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *AbstractMetricEntryObject) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetTags

`func (o *AbstractMetricEntryObject) GetTags() map[string]string`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *AbstractMetricEntryObject) GetTagsOk() (*map[string]string, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *AbstractMetricEntryObject) SetTags(v map[string]string)`

SetTags sets Tags field to given value.

### HasTags

`func (o *AbstractMetricEntryObject) HasTags() bool`

HasTags returns a boolean if a field has been set.

### GetTimestamp

`func (o *AbstractMetricEntryObject) GetTimestamp() time.Time`

GetTimestamp returns the Timestamp field if non-nil, zero value otherwise.

### GetTimestampOk

`func (o *AbstractMetricEntryObject) GetTimestampOk() (*time.Time, bool)`

GetTimestampOk returns a tuple with the Timestamp field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTimestamp

`func (o *AbstractMetricEntryObject) SetTimestamp(v time.Time)`

SetTimestamp sets Timestamp field to given value.

### HasTimestamp

`func (o *AbstractMetricEntryObject) HasTimestamp() bool`

HasTimestamp returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


