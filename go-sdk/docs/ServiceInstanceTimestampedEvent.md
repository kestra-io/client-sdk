# ServiceInstanceTimestampedEvent

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Ts** | **time.Time** |  | 
**Value** | **string** |  | 
**Type** | **string** |  | 
**State** | [**ServiceServiceState**](ServiceServiceState.md) |  | 

## Methods

### NewServiceInstanceTimestampedEvent

`func NewServiceInstanceTimestampedEvent(ts time.Time, value string, type_ string, state ServiceServiceState, ) *ServiceInstanceTimestampedEvent`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


