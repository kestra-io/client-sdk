# State

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Duration** | Pointer to **NullableString** |  | [optional] [readonly] 
**StartDate** | Pointer to **time.Time** |  | [optional] [readonly] 
**EndDate** | Pointer to **NullableTime** |  | [optional] [readonly] 
**Current** | [**StateType**](StateType.md) |  | 
**Histories** | Pointer to [**[]StateHistory**](StateHistory.md) |  | [optional] 

## Methods

### NewState

`func NewState(current StateType, ) *State`

NewState instantiates a new State object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewStateWithDefaults

`func NewStateWithDefaults() *State`

NewStateWithDefaults instantiates a new State object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDuration

`func (o *State) GetDuration() string`

GetDuration returns the Duration field if non-nil, zero value otherwise.

### GetDurationOk

`func (o *State) GetDurationOk() (*string, bool)`

GetDurationOk returns a tuple with the Duration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDuration

`func (o *State) SetDuration(v string)`

SetDuration sets Duration field to given value.

### HasDuration

`func (o *State) HasDuration() bool`

HasDuration returns a boolean if a field has been set.

### SetDurationNil

`func (o *State) SetDurationNil(b bool)`

 SetDurationNil sets the value for Duration to be an explicit nil

### UnsetDuration
`func (o *State) UnsetDuration()`

UnsetDuration ensures that no value is present for Duration, not even an explicit nil
### GetStartDate

`func (o *State) GetStartDate() time.Time`

GetStartDate returns the StartDate field if non-nil, zero value otherwise.

### GetStartDateOk

`func (o *State) GetStartDateOk() (*time.Time, bool)`

GetStartDateOk returns a tuple with the StartDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartDate

`func (o *State) SetStartDate(v time.Time)`

SetStartDate sets StartDate field to given value.

### HasStartDate

`func (o *State) HasStartDate() bool`

HasStartDate returns a boolean if a field has been set.

### GetEndDate

`func (o *State) GetEndDate() time.Time`

GetEndDate returns the EndDate field if non-nil, zero value otherwise.

### GetEndDateOk

`func (o *State) GetEndDateOk() (*time.Time, bool)`

GetEndDateOk returns a tuple with the EndDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEndDate

`func (o *State) SetEndDate(v time.Time)`

SetEndDate sets EndDate field to given value.

### HasEndDate

`func (o *State) HasEndDate() bool`

HasEndDate returns a boolean if a field has been set.

### SetEndDateNil

`func (o *State) SetEndDateNil(b bool)`

 SetEndDateNil sets the value for EndDate to be an explicit nil

### UnsetEndDate
`func (o *State) UnsetEndDate()`

UnsetEndDate ensures that no value is present for EndDate, not even an explicit nil
### GetCurrent

`func (o *State) GetCurrent() StateType`

GetCurrent returns the Current field if non-nil, zero value otherwise.

### GetCurrentOk

`func (o *State) GetCurrentOk() (*StateType, bool)`

GetCurrentOk returns a tuple with the Current field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCurrent

`func (o *State) SetCurrent(v StateType)`

SetCurrent sets Current field to given value.


### GetHistories

`func (o *State) GetHistories() []StateHistory`

GetHistories returns the Histories field if non-nil, zero value otherwise.

### GetHistoriesOk

`func (o *State) GetHistoriesOk() (*[]StateHistory, bool)`

GetHistoriesOk returns a tuple with the Histories field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHistories

`func (o *State) SetHistories(v []StateHistory)`

SetHistories sets Histories field to given value.

### HasHistories

`func (o *State) HasHistories() bool`

HasHistories returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


