# StateHistory

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**State** | [**StateType**](StateType.md) |  | 
**Date** | **time.Time** |  | 

## Methods

### NewStateHistory

`func NewStateHistory(state StateType, date time.Time, ) *StateHistory`

NewStateHistory instantiates a new StateHistory object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewStateHistoryWithDefaults

`func NewStateHistoryWithDefaults() *StateHistory`

NewStateHistoryWithDefaults instantiates a new StateHistory object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetState

`func (o *StateHistory) GetState() StateType`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *StateHistory) GetStateOk() (*StateType, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *StateHistory) SetState(v StateType)`

SetState sets State field to given value.


### GetDate

`func (o *StateHistory) GetDate() time.Time`

GetDate returns the Date field if non-nil, zero value otherwise.

### GetDateOk

`func (o *StateHistory) GetDateOk() (*time.Time, bool)`

GetDateOk returns a tuple with the Date field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDate

`func (o *StateHistory) SetDate(v time.Time)`

SetDate sets Date field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


