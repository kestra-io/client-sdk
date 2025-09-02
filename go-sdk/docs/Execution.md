# Execution

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Labels** | [**[]Label**](Label.md) |  | 
**Id** | **string** |  | 
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**FlowRevision** | **int32** |  | 
**TaskRunList** | [**[]TaskRun**](TaskRun.md) |  | 
**Inputs** | **map[string]map[string]interface{}** |  | 
**Outputs** | **map[string]map[string]interface{}** |  | 
**Variables** | **map[string]map[string]interface{}** |  | 
**State** | [**State**](State.md) |  | 
**ParentId** | **string** |  | 
**OriginalId** | **string** |  | 
**Trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  | 
**Deleted** | **bool** |  | 
**Metadata** | [**ExecutionMetadata**](ExecutionMetadata.md) |  | 
**ScheduleDate** | Pointer to **NullableTime** |  | [optional] 
**TraceParent** | **string** |  | 
**Fixtures** | Pointer to [**[]TaskFixture**](TaskFixture.md) |  | [optional] 
**Kind** | Pointer to [**NullableExecutionKind**](ExecutionKind.md) |  | [optional] 
**Breakpoints** | Pointer to [**[]Breakpoint**](Breakpoint.md) |  | [optional] 

## Methods

### NewExecution

`func NewExecution(labels []Label, id string, namespace string, flowId string, flowRevision int32, taskRunList []TaskRun, inputs map[string]map[string]interface{}, outputs map[string]map[string]interface{}, variables map[string]map[string]interface{}, state State, parentId string, originalId string, trigger ExecutionTrigger, deleted bool, metadata ExecutionMetadata, traceParent string, ) *Execution`

NewExecution instantiates a new Execution object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionWithDefaults

`func NewExecutionWithDefaults() *Execution`

NewExecutionWithDefaults instantiates a new Execution object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetLabels

`func (o *Execution) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *Execution) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *Execution) SetLabels(v []Label)`

SetLabels sets Labels field to given value.


### GetId

`func (o *Execution) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Execution) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Execution) SetId(v string)`

SetId sets Id field to given value.


### GetNamespace

`func (o *Execution) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *Execution) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *Execution) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *Execution) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *Execution) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *Execution) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetFlowRevision

`func (o *Execution) GetFlowRevision() int32`

GetFlowRevision returns the FlowRevision field if non-nil, zero value otherwise.

### GetFlowRevisionOk

`func (o *Execution) GetFlowRevisionOk() (*int32, bool)`

GetFlowRevisionOk returns a tuple with the FlowRevision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowRevision

`func (o *Execution) SetFlowRevision(v int32)`

SetFlowRevision sets FlowRevision field to given value.


### GetTaskRunList

`func (o *Execution) GetTaskRunList() []TaskRun`

GetTaskRunList returns the TaskRunList field if non-nil, zero value otherwise.

### GetTaskRunListOk

`func (o *Execution) GetTaskRunListOk() (*[]TaskRun, bool)`

GetTaskRunListOk returns a tuple with the TaskRunList field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskRunList

`func (o *Execution) SetTaskRunList(v []TaskRun)`

SetTaskRunList sets TaskRunList field to given value.


### GetInputs

`func (o *Execution) GetInputs() map[string]map[string]interface{}`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *Execution) GetInputsOk() (*map[string]map[string]interface{}, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *Execution) SetInputs(v map[string]map[string]interface{})`

SetInputs sets Inputs field to given value.


### GetOutputs

`func (o *Execution) GetOutputs() map[string]map[string]interface{}`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *Execution) GetOutputsOk() (*map[string]map[string]interface{}, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *Execution) SetOutputs(v map[string]map[string]interface{})`

SetOutputs sets Outputs field to given value.


### GetVariables

`func (o *Execution) GetVariables() map[string]map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *Execution) GetVariablesOk() (*map[string]map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *Execution) SetVariables(v map[string]map[string]interface{})`

SetVariables sets Variables field to given value.


### GetState

`func (o *Execution) GetState() State`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *Execution) GetStateOk() (*State, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *Execution) SetState(v State)`

SetState sets State field to given value.


### GetParentId

`func (o *Execution) GetParentId() string`

GetParentId returns the ParentId field if non-nil, zero value otherwise.

### GetParentIdOk

`func (o *Execution) GetParentIdOk() (*string, bool)`

GetParentIdOk returns a tuple with the ParentId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetParentId

`func (o *Execution) SetParentId(v string)`

SetParentId sets ParentId field to given value.


### GetOriginalId

`func (o *Execution) GetOriginalId() string`

GetOriginalId returns the OriginalId field if non-nil, zero value otherwise.

### GetOriginalIdOk

`func (o *Execution) GetOriginalIdOk() (*string, bool)`

GetOriginalIdOk returns a tuple with the OriginalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOriginalId

`func (o *Execution) SetOriginalId(v string)`

SetOriginalId sets OriginalId field to given value.


### GetTrigger

`func (o *Execution) GetTrigger() ExecutionTrigger`

GetTrigger returns the Trigger field if non-nil, zero value otherwise.

### GetTriggerOk

`func (o *Execution) GetTriggerOk() (*ExecutionTrigger, bool)`

GetTriggerOk returns a tuple with the Trigger field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTrigger

`func (o *Execution) SetTrigger(v ExecutionTrigger)`

SetTrigger sets Trigger field to given value.


### GetDeleted

`func (o *Execution) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *Execution) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *Execution) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetMetadata

`func (o *Execution) GetMetadata() ExecutionMetadata`

GetMetadata returns the Metadata field if non-nil, zero value otherwise.

### GetMetadataOk

`func (o *Execution) GetMetadataOk() (*ExecutionMetadata, bool)`

GetMetadataOk returns a tuple with the Metadata field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMetadata

`func (o *Execution) SetMetadata(v ExecutionMetadata)`

SetMetadata sets Metadata field to given value.


### GetScheduleDate

`func (o *Execution) GetScheduleDate() time.Time`

GetScheduleDate returns the ScheduleDate field if non-nil, zero value otherwise.

### GetScheduleDateOk

`func (o *Execution) GetScheduleDateOk() (*time.Time, bool)`

GetScheduleDateOk returns a tuple with the ScheduleDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetScheduleDate

`func (o *Execution) SetScheduleDate(v time.Time)`

SetScheduleDate sets ScheduleDate field to given value.

### HasScheduleDate

`func (o *Execution) HasScheduleDate() bool`

HasScheduleDate returns a boolean if a field has been set.

### SetScheduleDateNil

`func (o *Execution) SetScheduleDateNil(b bool)`

 SetScheduleDateNil sets the value for ScheduleDate to be an explicit nil

### UnsetScheduleDate
`func (o *Execution) UnsetScheduleDate()`

UnsetScheduleDate ensures that no value is present for ScheduleDate, not even an explicit nil
### GetTraceParent

`func (o *Execution) GetTraceParent() string`

GetTraceParent returns the TraceParent field if non-nil, zero value otherwise.

### GetTraceParentOk

`func (o *Execution) GetTraceParentOk() (*string, bool)`

GetTraceParentOk returns a tuple with the TraceParent field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTraceParent

`func (o *Execution) SetTraceParent(v string)`

SetTraceParent sets TraceParent field to given value.


### GetFixtures

`func (o *Execution) GetFixtures() []TaskFixture`

GetFixtures returns the Fixtures field if non-nil, zero value otherwise.

### GetFixturesOk

`func (o *Execution) GetFixturesOk() (*[]TaskFixture, bool)`

GetFixturesOk returns a tuple with the Fixtures field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFixtures

`func (o *Execution) SetFixtures(v []TaskFixture)`

SetFixtures sets Fixtures field to given value.

### HasFixtures

`func (o *Execution) HasFixtures() bool`

HasFixtures returns a boolean if a field has been set.

### SetFixturesNil

`func (o *Execution) SetFixturesNil(b bool)`

 SetFixturesNil sets the value for Fixtures to be an explicit nil

### UnsetFixtures
`func (o *Execution) UnsetFixtures()`

UnsetFixtures ensures that no value is present for Fixtures, not even an explicit nil
### GetKind

`func (o *Execution) GetKind() ExecutionKind`

GetKind returns the Kind field if non-nil, zero value otherwise.

### GetKindOk

`func (o *Execution) GetKindOk() (*ExecutionKind, bool)`

GetKindOk returns a tuple with the Kind field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKind

`func (o *Execution) SetKind(v ExecutionKind)`

SetKind sets Kind field to given value.

### HasKind

`func (o *Execution) HasKind() bool`

HasKind returns a boolean if a field has been set.

### SetKindNil

`func (o *Execution) SetKindNil(b bool)`

 SetKindNil sets the value for Kind to be an explicit nil

### UnsetKind
`func (o *Execution) UnsetKind()`

UnsetKind ensures that no value is present for Kind, not even an explicit nil
### GetBreakpoints

`func (o *Execution) GetBreakpoints() []Breakpoint`

GetBreakpoints returns the Breakpoints field if non-nil, zero value otherwise.

### GetBreakpointsOk

`func (o *Execution) GetBreakpointsOk() (*[]Breakpoint, bool)`

GetBreakpointsOk returns a tuple with the Breakpoints field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBreakpoints

`func (o *Execution) SetBreakpoints(v []Breakpoint)`

SetBreakpoints sets Breakpoints field to given value.

### HasBreakpoints

`func (o *Execution) HasBreakpoints() bool`

HasBreakpoints returns a boolean if a field has been set.

### SetBreakpointsNil

`func (o *Execution) SetBreakpointsNil(b bool)`

 SetBreakpointsNil sets the value for Breakpoints to be an explicit nil

### UnsetBreakpoints
`func (o *Execution) UnsetBreakpoints()`

UnsetBreakpoints ensures that no value is present for Breakpoints, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


