# AssetsControllerApiAssetLineageEvent

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Uid** | Pointer to **string** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**FlowId** | Pointer to **string** |  | [optional] 
**FlowRevision** | Pointer to **int32** |  | [optional] 
**ExecutionId** | Pointer to **string** |  | [optional] 
**TaskId** | Pointer to **string** |  | [optional] 
**TaskRunId** | Pointer to **string** |  | [optional] 
**State** | Pointer to **string** |  | [optional] 
**Inputs** | Pointer to [**[]AssetIdentifier**](AssetIdentifier.md) |  | [optional] 
**Outputs** | Pointer to [**[]AssetIdentifier**](AssetIdentifier.md) |  | [optional] 
**Created** | Pointer to **time.Time** |  | [optional] 
**StartDate** | Pointer to **time.Time** |  | [optional] 
**EndDate** | Pointer to **time.Time** |  | [optional] 

## Methods

### NewAssetsControllerApiAssetLineageEvent

`func NewAssetsControllerApiAssetLineageEvent() *AssetsControllerApiAssetLineageEvent`

NewAssetsControllerApiAssetLineageEvent instantiates a new AssetsControllerApiAssetLineageEvent object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssetsControllerApiAssetLineageEventWithDefaults

`func NewAssetsControllerApiAssetLineageEventWithDefaults() *AssetsControllerApiAssetLineageEvent`

NewAssetsControllerApiAssetLineageEventWithDefaults instantiates a new AssetsControllerApiAssetLineageEvent object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUid

`func (o *AssetsControllerApiAssetLineageEvent) GetUid() string`

GetUid returns the Uid field if non-nil, zero value otherwise.

### GetUidOk

`func (o *AssetsControllerApiAssetLineageEvent) GetUidOk() (*string, bool)`

GetUidOk returns a tuple with the Uid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUid

`func (o *AssetsControllerApiAssetLineageEvent) SetUid(v string)`

SetUid sets Uid field to given value.

### HasUid

`func (o *AssetsControllerApiAssetLineageEvent) HasUid() bool`

HasUid returns a boolean if a field has been set.

### GetNamespace

`func (o *AssetsControllerApiAssetLineageEvent) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *AssetsControllerApiAssetLineageEvent) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *AssetsControllerApiAssetLineageEvent) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *AssetsControllerApiAssetLineageEvent) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetFlowId

`func (o *AssetsControllerApiAssetLineageEvent) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *AssetsControllerApiAssetLineageEvent) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *AssetsControllerApiAssetLineageEvent) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.

### HasFlowId

`func (o *AssetsControllerApiAssetLineageEvent) HasFlowId() bool`

HasFlowId returns a boolean if a field has been set.

### GetFlowRevision

`func (o *AssetsControllerApiAssetLineageEvent) GetFlowRevision() int32`

GetFlowRevision returns the FlowRevision field if non-nil, zero value otherwise.

### GetFlowRevisionOk

`func (o *AssetsControllerApiAssetLineageEvent) GetFlowRevisionOk() (*int32, bool)`

GetFlowRevisionOk returns a tuple with the FlowRevision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowRevision

`func (o *AssetsControllerApiAssetLineageEvent) SetFlowRevision(v int32)`

SetFlowRevision sets FlowRevision field to given value.

### HasFlowRevision

`func (o *AssetsControllerApiAssetLineageEvent) HasFlowRevision() bool`

HasFlowRevision returns a boolean if a field has been set.

### GetExecutionId

`func (o *AssetsControllerApiAssetLineageEvent) GetExecutionId() string`

GetExecutionId returns the ExecutionId field if non-nil, zero value otherwise.

### GetExecutionIdOk

`func (o *AssetsControllerApiAssetLineageEvent) GetExecutionIdOk() (*string, bool)`

GetExecutionIdOk returns a tuple with the ExecutionId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionId

`func (o *AssetsControllerApiAssetLineageEvent) SetExecutionId(v string)`

SetExecutionId sets ExecutionId field to given value.

### HasExecutionId

`func (o *AssetsControllerApiAssetLineageEvent) HasExecutionId() bool`

HasExecutionId returns a boolean if a field has been set.

### GetTaskId

`func (o *AssetsControllerApiAssetLineageEvent) GetTaskId() string`

GetTaskId returns the TaskId field if non-nil, zero value otherwise.

### GetTaskIdOk

`func (o *AssetsControllerApiAssetLineageEvent) GetTaskIdOk() (*string, bool)`

GetTaskIdOk returns a tuple with the TaskId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskId

`func (o *AssetsControllerApiAssetLineageEvent) SetTaskId(v string)`

SetTaskId sets TaskId field to given value.

### HasTaskId

`func (o *AssetsControllerApiAssetLineageEvent) HasTaskId() bool`

HasTaskId returns a boolean if a field has been set.

### GetTaskRunId

`func (o *AssetsControllerApiAssetLineageEvent) GetTaskRunId() string`

GetTaskRunId returns the TaskRunId field if non-nil, zero value otherwise.

### GetTaskRunIdOk

`func (o *AssetsControllerApiAssetLineageEvent) GetTaskRunIdOk() (*string, bool)`

GetTaskRunIdOk returns a tuple with the TaskRunId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskRunId

`func (o *AssetsControllerApiAssetLineageEvent) SetTaskRunId(v string)`

SetTaskRunId sets TaskRunId field to given value.

### HasTaskRunId

`func (o *AssetsControllerApiAssetLineageEvent) HasTaskRunId() bool`

HasTaskRunId returns a boolean if a field has been set.

### GetState

`func (o *AssetsControllerApiAssetLineageEvent) GetState() string`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *AssetsControllerApiAssetLineageEvent) GetStateOk() (*string, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *AssetsControllerApiAssetLineageEvent) SetState(v string)`

SetState sets State field to given value.

### HasState

`func (o *AssetsControllerApiAssetLineageEvent) HasState() bool`

HasState returns a boolean if a field has been set.

### GetInputs

`func (o *AssetsControllerApiAssetLineageEvent) GetInputs() []AssetIdentifier`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *AssetsControllerApiAssetLineageEvent) GetInputsOk() (*[]AssetIdentifier, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *AssetsControllerApiAssetLineageEvent) SetInputs(v []AssetIdentifier)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *AssetsControllerApiAssetLineageEvent) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *AssetsControllerApiAssetLineageEvent) GetOutputs() []AssetIdentifier`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *AssetsControllerApiAssetLineageEvent) GetOutputsOk() (*[]AssetIdentifier, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *AssetsControllerApiAssetLineageEvent) SetOutputs(v []AssetIdentifier)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *AssetsControllerApiAssetLineageEvent) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetCreated

`func (o *AssetsControllerApiAssetLineageEvent) GetCreated() time.Time`

GetCreated returns the Created field if non-nil, zero value otherwise.

### GetCreatedOk

`func (o *AssetsControllerApiAssetLineageEvent) GetCreatedOk() (*time.Time, bool)`

GetCreatedOk returns a tuple with the Created field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreated

`func (o *AssetsControllerApiAssetLineageEvent) SetCreated(v time.Time)`

SetCreated sets Created field to given value.

### HasCreated

`func (o *AssetsControllerApiAssetLineageEvent) HasCreated() bool`

HasCreated returns a boolean if a field has been set.

### GetStartDate

`func (o *AssetsControllerApiAssetLineageEvent) GetStartDate() time.Time`

GetStartDate returns the StartDate field if non-nil, zero value otherwise.

### GetStartDateOk

`func (o *AssetsControllerApiAssetLineageEvent) GetStartDateOk() (*time.Time, bool)`

GetStartDateOk returns a tuple with the StartDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartDate

`func (o *AssetsControllerApiAssetLineageEvent) SetStartDate(v time.Time)`

SetStartDate sets StartDate field to given value.

### HasStartDate

`func (o *AssetsControllerApiAssetLineageEvent) HasStartDate() bool`

HasStartDate returns a boolean if a field has been set.

### GetEndDate

`func (o *AssetsControllerApiAssetLineageEvent) GetEndDate() time.Time`

GetEndDate returns the EndDate field if non-nil, zero value otherwise.

### GetEndDateOk

`func (o *AssetsControllerApiAssetLineageEvent) GetEndDateOk() (*time.Time, bool)`

GetEndDateOk returns a tuple with the EndDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEndDate

`func (o *AssetsControllerApiAssetLineageEvent) SetEndDate(v time.Time)`

SetEndDate sets EndDate field to given value.

### HasEndDate

`func (o *AssetsControllerApiAssetLineageEvent) HasEndDate() bool`

HasEndDate returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


