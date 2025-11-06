# Concurrency

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Limit** | **int32** |  | 
**Behavior** | [**ConcurrencyBehavior**](ConcurrencyBehavior.md) |  | 

## Methods

### NewConcurrency

`func NewConcurrency(limit int32, behavior ConcurrencyBehavior, ) *Concurrency`

NewConcurrency instantiates a new Concurrency object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewConcurrencyWithDefaults

`func NewConcurrencyWithDefaults() *Concurrency`

NewConcurrencyWithDefaults instantiates a new Concurrency object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetLimit

`func (o *Concurrency) GetLimit() int32`

GetLimit returns the Limit field if non-nil, zero value otherwise.

### GetLimitOk

`func (o *Concurrency) GetLimitOk() (*int32, bool)`

GetLimitOk returns a tuple with the Limit field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLimit

`func (o *Concurrency) SetLimit(v int32)`

SetLimit sets Limit field to given value.


### GetBehavior

`func (o *Concurrency) GetBehavior() ConcurrencyBehavior`

GetBehavior returns the Behavior field if non-nil, zero value otherwise.

### GetBehaviorOk

`func (o *Concurrency) GetBehaviorOk() (*ConcurrencyBehavior, bool)`

GetBehaviorOk returns a tuple with the Behavior field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBehavior

`func (o *Concurrency) SetBehavior(v ConcurrencyBehavior)`

SetBehavior sets Behavior field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


