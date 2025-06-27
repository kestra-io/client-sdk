# Backfill

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Start** | **time.Time** |  | 
**End** | Pointer to **time.Time** |  | [optional] 
**CurrentDate** | Pointer to **time.Time** |  | [optional] 
**Paused** | Pointer to **bool** |  | [optional] 
**Inputs** | Pointer to **map[string]interface{}** |  | [optional] 
**Labels** | Pointer to [**[]Label**](Label.md) |  | [optional] 
**PreviousNextExecutionDate** | Pointer to **time.Time** |  | [optional] 

## Methods

### NewBackfill

`func NewBackfill(start time.Time, ) *Backfill`

NewBackfill instantiates a new Backfill object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBackfillWithDefaults

`func NewBackfillWithDefaults() *Backfill`

NewBackfillWithDefaults instantiates a new Backfill object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetStart

`func (o *Backfill) GetStart() time.Time`

GetStart returns the Start field if non-nil, zero value otherwise.

### GetStartOk

`func (o *Backfill) GetStartOk() (*time.Time, bool)`

GetStartOk returns a tuple with the Start field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStart

`func (o *Backfill) SetStart(v time.Time)`

SetStart sets Start field to given value.


### GetEnd

`func (o *Backfill) GetEnd() time.Time`

GetEnd returns the End field if non-nil, zero value otherwise.

### GetEndOk

`func (o *Backfill) GetEndOk() (*time.Time, bool)`

GetEndOk returns a tuple with the End field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnd

`func (o *Backfill) SetEnd(v time.Time)`

SetEnd sets End field to given value.

### HasEnd

`func (o *Backfill) HasEnd() bool`

HasEnd returns a boolean if a field has been set.

### GetCurrentDate

`func (o *Backfill) GetCurrentDate() time.Time`

GetCurrentDate returns the CurrentDate field if non-nil, zero value otherwise.

### GetCurrentDateOk

`func (o *Backfill) GetCurrentDateOk() (*time.Time, bool)`

GetCurrentDateOk returns a tuple with the CurrentDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCurrentDate

`func (o *Backfill) SetCurrentDate(v time.Time)`

SetCurrentDate sets CurrentDate field to given value.

### HasCurrentDate

`func (o *Backfill) HasCurrentDate() bool`

HasCurrentDate returns a boolean if a field has been set.

### GetPaused

`func (o *Backfill) GetPaused() bool`

GetPaused returns the Paused field if non-nil, zero value otherwise.

### GetPausedOk

`func (o *Backfill) GetPausedOk() (*bool, bool)`

GetPausedOk returns a tuple with the Paused field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPaused

`func (o *Backfill) SetPaused(v bool)`

SetPaused sets Paused field to given value.

### HasPaused

`func (o *Backfill) HasPaused() bool`

HasPaused returns a boolean if a field has been set.

### GetInputs

`func (o *Backfill) GetInputs() map[string]interface{}`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *Backfill) GetInputsOk() (*map[string]interface{}, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *Backfill) SetInputs(v map[string]interface{})`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *Backfill) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetLabels

`func (o *Backfill) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *Backfill) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *Backfill) SetLabels(v []Label)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *Backfill) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetPreviousNextExecutionDate

`func (o *Backfill) GetPreviousNextExecutionDate() time.Time`

GetPreviousNextExecutionDate returns the PreviousNextExecutionDate field if non-nil, zero value otherwise.

### GetPreviousNextExecutionDateOk

`func (o *Backfill) GetPreviousNextExecutionDateOk() (*time.Time, bool)`

GetPreviousNextExecutionDateOk returns a tuple with the PreviousNextExecutionDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPreviousNextExecutionDate

`func (o *Backfill) SetPreviousNextExecutionDate(v time.Time)`

SetPreviousNextExecutionDate sets PreviousNextExecutionDate field to given value.

### HasPreviousNextExecutionDate

`func (o *Backfill) HasPreviousNextExecutionDate() bool`

HasPreviousNextExecutionDate returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


