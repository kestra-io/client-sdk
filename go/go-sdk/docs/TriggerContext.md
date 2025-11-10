# TriggerContext

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Disabled** | Pointer to **bool** |  | [optional] [default to false]
**TenantId** | Pointer to **string** |  | [optional] 
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**TriggerId** | **string** |  | 
**Date** | **time.Time** |  | 
**NextExecutionDate** | Pointer to **NullableTime** |  | [optional] 
**Backfill** | Pointer to [**NullableBackfill**](Backfill.md) |  | [optional] 
**StopAfter** | Pointer to [**[]StateType**](StateType.md) |  | [optional] 

## Methods

### NewTriggerContext

`func NewTriggerContext(namespace string, flowId string, triggerId string, date time.Time, ) *TriggerContext`

NewTriggerContext instantiates a new TriggerContext object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTriggerContextWithDefaults

`func NewTriggerContextWithDefaults() *TriggerContext`

NewTriggerContextWithDefaults instantiates a new TriggerContext object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDisabled

`func (o *TriggerContext) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *TriggerContext) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *TriggerContext) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.

### HasDisabled

`func (o *TriggerContext) HasDisabled() bool`

HasDisabled returns a boolean if a field has been set.

### GetTenantId

`func (o *TriggerContext) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *TriggerContext) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *TriggerContext) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *TriggerContext) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetNamespace

`func (o *TriggerContext) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *TriggerContext) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *TriggerContext) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *TriggerContext) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *TriggerContext) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *TriggerContext) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetTriggerId

`func (o *TriggerContext) GetTriggerId() string`

GetTriggerId returns the TriggerId field if non-nil, zero value otherwise.

### GetTriggerIdOk

`func (o *TriggerContext) GetTriggerIdOk() (*string, bool)`

GetTriggerIdOk returns a tuple with the TriggerId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggerId

`func (o *TriggerContext) SetTriggerId(v string)`

SetTriggerId sets TriggerId field to given value.


### GetDate

`func (o *TriggerContext) GetDate() time.Time`

GetDate returns the Date field if non-nil, zero value otherwise.

### GetDateOk

`func (o *TriggerContext) GetDateOk() (*time.Time, bool)`

GetDateOk returns a tuple with the Date field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDate

`func (o *TriggerContext) SetDate(v time.Time)`

SetDate sets Date field to given value.


### GetNextExecutionDate

`func (o *TriggerContext) GetNextExecutionDate() time.Time`

GetNextExecutionDate returns the NextExecutionDate field if non-nil, zero value otherwise.

### GetNextExecutionDateOk

`func (o *TriggerContext) GetNextExecutionDateOk() (*time.Time, bool)`

GetNextExecutionDateOk returns a tuple with the NextExecutionDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNextExecutionDate

`func (o *TriggerContext) SetNextExecutionDate(v time.Time)`

SetNextExecutionDate sets NextExecutionDate field to given value.

### HasNextExecutionDate

`func (o *TriggerContext) HasNextExecutionDate() bool`

HasNextExecutionDate returns a boolean if a field has been set.

### SetNextExecutionDateNil

`func (o *TriggerContext) SetNextExecutionDateNil(b bool)`

 SetNextExecutionDateNil sets the value for NextExecutionDate to be an explicit nil

### UnsetNextExecutionDate
`func (o *TriggerContext) UnsetNextExecutionDate()`

UnsetNextExecutionDate ensures that no value is present for NextExecutionDate, not even an explicit nil
### GetBackfill

`func (o *TriggerContext) GetBackfill() Backfill`

GetBackfill returns the Backfill field if non-nil, zero value otherwise.

### GetBackfillOk

`func (o *TriggerContext) GetBackfillOk() (*Backfill, bool)`

GetBackfillOk returns a tuple with the Backfill field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBackfill

`func (o *TriggerContext) SetBackfill(v Backfill)`

SetBackfill sets Backfill field to given value.

### HasBackfill

`func (o *TriggerContext) HasBackfill() bool`

HasBackfill returns a boolean if a field has been set.

### SetBackfillNil

`func (o *TriggerContext) SetBackfillNil(b bool)`

 SetBackfillNil sets the value for Backfill to be an explicit nil

### UnsetBackfill
`func (o *TriggerContext) UnsetBackfill()`

UnsetBackfill ensures that no value is present for Backfill, not even an explicit nil
### GetStopAfter

`func (o *TriggerContext) GetStopAfter() []StateType`

GetStopAfter returns the StopAfter field if non-nil, zero value otherwise.

### GetStopAfterOk

`func (o *TriggerContext) GetStopAfterOk() (*[]StateType, bool)`

GetStopAfterOk returns a tuple with the StopAfter field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStopAfter

`func (o *TriggerContext) SetStopAfter(v []StateType)`

SetStopAfter sets StopAfter field to given value.

### HasStopAfter

`func (o *TriggerContext) HasStopAfter() bool`

HasStopAfter returns a boolean if a field has been set.

### SetStopAfterNil

`func (o *TriggerContext) SetStopAfterNil(b bool)`

 SetStopAfterNil sets the value for StopAfter to be an explicit nil

### UnsetStopAfter
`func (o *TriggerContext) UnsetStopAfter()`

UnsetStopAfter ensures that no value is present for StopAfter, not even an explicit nil

[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


