# ServiceInstanceTimestampedEvent

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Ts** | Pointer to **time.Time** |  | [optional] 
**Value** | Pointer to **string** |  | [optional] 
**Type** | Pointer to **string** |  | [optional] 
**State** | Pointer to [**ServiceServiceState**](ServiceServiceState.md) |  | [optional] 

## Methods

### NewServiceInstanceTimestampedEvent

`func NewServiceInstanceTimestampedEvent() *ServiceInstanceTimestampedEvent`

NewServiceInstanceTimestampedEvent instantiates a new ServiceInstanceTimestampedEvent object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewServiceInstanceTimestampedEventWithDefaults

`func NewServiceInstanceTimestampedEventWithDefaults() *ServiceInstanceTimestampedEvent`

NewServiceInstanceTimestampedEventWithDefaults instantiates a new ServiceInstanceTimestampedEvent object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTs

`func (o *ServiceInstanceTimestampedEvent) GetTs() time.Time`

GetTs returns the Ts field if non-nil, zero value otherwise.

### GetTsOk

`func (o *ServiceInstanceTimestampedEvent) GetTsOk() (*time.Time, bool)`

GetTsOk returns a tuple with the Ts field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTs

`func (o *ServiceInstanceTimestampedEvent) SetTs(v time.Time)`

SetTs sets Ts field to given value.

### HasTs

`func (o *ServiceInstanceTimestampedEvent) HasTs() bool`

HasTs returns a boolean if a field has been set.

### GetValue

`func (o *ServiceInstanceTimestampedEvent) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *ServiceInstanceTimestampedEvent) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *ServiceInstanceTimestampedEvent) SetValue(v string)`

SetValue sets Value field to given value.

### HasValue

`func (o *ServiceInstanceTimestampedEvent) HasValue() bool`

HasValue returns a boolean if a field has been set.

### GetType

`func (o *ServiceInstanceTimestampedEvent) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *ServiceInstanceTimestampedEvent) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *ServiceInstanceTimestampedEvent) SetType(v string)`

SetType sets Type field to given value.

### HasType

`func (o *ServiceInstanceTimestampedEvent) HasType() bool`

HasType returns a boolean if a field has been set.

### GetState

`func (o *ServiceInstanceTimestampedEvent) GetState() ServiceServiceState`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *ServiceInstanceTimestampedEvent) GetStateOk() (*ServiceServiceState, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *ServiceInstanceTimestampedEvent) SetState(v ServiceServiceState)`

SetState sets State field to given value.

### HasState

`func (o *ServiceInstanceTimestampedEvent) HasState() bool`

HasState returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


