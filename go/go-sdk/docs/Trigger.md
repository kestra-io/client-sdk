# Trigger

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
**ExecutionId** | Pointer to **NullableString** |  | [optional] 
**UpdatedDate** | Pointer to **NullableTime** |  | [optional] 
**EvaluateRunningDate** | Pointer to **NullableTime** |  | [optional] 
**WorkerId** | Pointer to **NullableString** |  | [optional] 

## Methods

### NewTrigger

`func NewTrigger(namespace string, flowId string, triggerId string, date time.Time, ) *Trigger`

NewTrigger instantiates a new Trigger object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTriggerWithDefaults

`func NewTriggerWithDefaults() *Trigger`

NewTriggerWithDefaults instantiates a new Trigger object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDisabled

`func (o *Trigger) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *Trigger) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *Trigger) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.

### HasDisabled

`func (o *Trigger) HasDisabled() bool`

HasDisabled returns a boolean if a field has been set.

### GetTenantId

`func (o *Trigger) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *Trigger) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *Trigger) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *Trigger) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetNamespace

`func (o *Trigger) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *Trigger) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *Trigger) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *Trigger) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *Trigger) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *Trigger) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetTriggerId

`func (o *Trigger) GetTriggerId() string`

GetTriggerId returns the TriggerId field if non-nil, zero value otherwise.

### GetTriggerIdOk

`func (o *Trigger) GetTriggerIdOk() (*string, bool)`

GetTriggerIdOk returns a tuple with the TriggerId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggerId

`func (o *Trigger) SetTriggerId(v string)`

SetTriggerId sets TriggerId field to given value.


### GetDate

`func (o *Trigger) GetDate() time.Time`

GetDate returns the Date field if non-nil, zero value otherwise.

### GetDateOk

`func (o *Trigger) GetDateOk() (*time.Time, bool)`

GetDateOk returns a tuple with the Date field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDate

`func (o *Trigger) SetDate(v time.Time)`

SetDate sets Date field to given value.


### GetNextExecutionDate

`func (o *Trigger) GetNextExecutionDate() time.Time`

GetNextExecutionDate returns the NextExecutionDate field if non-nil, zero value otherwise.

### GetNextExecutionDateOk

`func (o *Trigger) GetNextExecutionDateOk() (*time.Time, bool)`

GetNextExecutionDateOk returns a tuple with the NextExecutionDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNextExecutionDate

`func (o *Trigger) SetNextExecutionDate(v time.Time)`

SetNextExecutionDate sets NextExecutionDate field to given value.

### HasNextExecutionDate

`func (o *Trigger) HasNextExecutionDate() bool`

HasNextExecutionDate returns a boolean if a field has been set.

### SetNextExecutionDateNil

`func (o *Trigger) SetNextExecutionDateNil(b bool)`

 SetNextExecutionDateNil sets the value for NextExecutionDate to be an explicit nil

### UnsetNextExecutionDate
`func (o *Trigger) UnsetNextExecutionDate()`

UnsetNextExecutionDate ensures that no value is present for NextExecutionDate, not even an explicit nil
### GetBackfill

`func (o *Trigger) GetBackfill() Backfill`

GetBackfill returns the Backfill field if non-nil, zero value otherwise.

### GetBackfillOk

`func (o *Trigger) GetBackfillOk() (*Backfill, bool)`

GetBackfillOk returns a tuple with the Backfill field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBackfill

`func (o *Trigger) SetBackfill(v Backfill)`

SetBackfill sets Backfill field to given value.

### HasBackfill

`func (o *Trigger) HasBackfill() bool`

HasBackfill returns a boolean if a field has been set.

### SetBackfillNil

`func (o *Trigger) SetBackfillNil(b bool)`

 SetBackfillNil sets the value for Backfill to be an explicit nil

### UnsetBackfill
`func (o *Trigger) UnsetBackfill()`

UnsetBackfill ensures that no value is present for Backfill, not even an explicit nil
### GetStopAfter

`func (o *Trigger) GetStopAfter() []StateType`

GetStopAfter returns the StopAfter field if non-nil, zero value otherwise.

### GetStopAfterOk

`func (o *Trigger) GetStopAfterOk() (*[]StateType, bool)`

GetStopAfterOk returns a tuple with the StopAfter field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStopAfter

`func (o *Trigger) SetStopAfter(v []StateType)`

SetStopAfter sets StopAfter field to given value.

### HasStopAfter

`func (o *Trigger) HasStopAfter() bool`

HasStopAfter returns a boolean if a field has been set.

### SetStopAfterNil

`func (o *Trigger) SetStopAfterNil(b bool)`

 SetStopAfterNil sets the value for StopAfter to be an explicit nil

### UnsetStopAfter
`func (o *Trigger) UnsetStopAfter()`

UnsetStopAfter ensures that no value is present for StopAfter, not even an explicit nil
### GetExecutionId

`func (o *Trigger) GetExecutionId() string`

GetExecutionId returns the ExecutionId field if non-nil, zero value otherwise.

### GetExecutionIdOk

`func (o *Trigger) GetExecutionIdOk() (*string, bool)`

GetExecutionIdOk returns a tuple with the ExecutionId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionId

`func (o *Trigger) SetExecutionId(v string)`

SetExecutionId sets ExecutionId field to given value.

### HasExecutionId

`func (o *Trigger) HasExecutionId() bool`

HasExecutionId returns a boolean if a field has been set.

### SetExecutionIdNil

`func (o *Trigger) SetExecutionIdNil(b bool)`

 SetExecutionIdNil sets the value for ExecutionId to be an explicit nil

### UnsetExecutionId
`func (o *Trigger) UnsetExecutionId()`

UnsetExecutionId ensures that no value is present for ExecutionId, not even an explicit nil
### GetUpdatedDate

`func (o *Trigger) GetUpdatedDate() time.Time`

GetUpdatedDate returns the UpdatedDate field if non-nil, zero value otherwise.

### GetUpdatedDateOk

`func (o *Trigger) GetUpdatedDateOk() (*time.Time, bool)`

GetUpdatedDateOk returns a tuple with the UpdatedDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUpdatedDate

`func (o *Trigger) SetUpdatedDate(v time.Time)`

SetUpdatedDate sets UpdatedDate field to given value.

### HasUpdatedDate

`func (o *Trigger) HasUpdatedDate() bool`

HasUpdatedDate returns a boolean if a field has been set.

### SetUpdatedDateNil

`func (o *Trigger) SetUpdatedDateNil(b bool)`

 SetUpdatedDateNil sets the value for UpdatedDate to be an explicit nil

### UnsetUpdatedDate
`func (o *Trigger) UnsetUpdatedDate()`

UnsetUpdatedDate ensures that no value is present for UpdatedDate, not even an explicit nil
### GetEvaluateRunningDate

`func (o *Trigger) GetEvaluateRunningDate() time.Time`

GetEvaluateRunningDate returns the EvaluateRunningDate field if non-nil, zero value otherwise.

### GetEvaluateRunningDateOk

`func (o *Trigger) GetEvaluateRunningDateOk() (*time.Time, bool)`

GetEvaluateRunningDateOk returns a tuple with the EvaluateRunningDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEvaluateRunningDate

`func (o *Trigger) SetEvaluateRunningDate(v time.Time)`

SetEvaluateRunningDate sets EvaluateRunningDate field to given value.

### HasEvaluateRunningDate

`func (o *Trigger) HasEvaluateRunningDate() bool`

HasEvaluateRunningDate returns a boolean if a field has been set.

### SetEvaluateRunningDateNil

`func (o *Trigger) SetEvaluateRunningDateNil(b bool)`

 SetEvaluateRunningDateNil sets the value for EvaluateRunningDate to be an explicit nil

### UnsetEvaluateRunningDate
`func (o *Trigger) UnsetEvaluateRunningDate()`

UnsetEvaluateRunningDate ensures that no value is present for EvaluateRunningDate, not even an explicit nil
### GetWorkerId

`func (o *Trigger) GetWorkerId() string`

GetWorkerId returns the WorkerId field if non-nil, zero value otherwise.

### GetWorkerIdOk

`func (o *Trigger) GetWorkerIdOk() (*string, bool)`

GetWorkerIdOk returns a tuple with the WorkerId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerId

`func (o *Trigger) SetWorkerId(v string)`

SetWorkerId sets WorkerId field to given value.

### HasWorkerId

`func (o *Trigger) HasWorkerId() bool`

HasWorkerId returns a boolean if a field has been set.

### SetWorkerIdNil

`func (o *Trigger) SetWorkerIdNil(b bool)`

 SetWorkerIdNil sets the value for WorkerId to be an explicit nil

### UnsetWorkerId
`func (o *Trigger) UnsetWorkerId()`

UnsetWorkerId ensures that no value is present for WorkerId, not even an explicit nil

[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


