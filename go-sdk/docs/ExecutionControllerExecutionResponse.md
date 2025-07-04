# ExecutionControllerExecutionResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Labels** | [**[]Label**](Label.md) |  | 
**Id** | **string** |  | 
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**FlowRevision** | **int32** |  | 
**TaskRunList** | [**[]TaskRun**](TaskRun.md) |  | 
**Inputs** | **map[string]interface{}** |  | 
**Outputs** | **map[string]interface{}** |  | 
**Variables** | **map[string]interface{}** |  | 
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
**Url** | **string** |  | 

## Methods

### NewExecutionControllerExecutionResponse

`func NewExecutionControllerExecutionResponse(labels []Label, id string, namespace string, flowId string, flowRevision int32, taskRunList []TaskRun, inputs map[string]interface{}, outputs map[string]interface{}, variables map[string]interface{}, state State, parentId string, originalId string, trigger ExecutionTrigger, deleted bool, metadata ExecutionMetadata, traceParent string, url string, ) *ExecutionControllerExecutionResponse`

NewExecutionControllerExecutionResponse instantiates a new ExecutionControllerExecutionResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionControllerExecutionResponseWithDefaults

`func NewExecutionControllerExecutionResponseWithDefaults() *ExecutionControllerExecutionResponse`

NewExecutionControllerExecutionResponseWithDefaults instantiates a new ExecutionControllerExecutionResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetLabels

`func (o *ExecutionControllerExecutionResponse) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *ExecutionControllerExecutionResponse) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *ExecutionControllerExecutionResponse) SetLabels(v []Label)`

SetLabels sets Labels field to given value.


### GetId

`func (o *ExecutionControllerExecutionResponse) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ExecutionControllerExecutionResponse) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ExecutionControllerExecutionResponse) SetId(v string)`

SetId sets Id field to given value.


### GetNamespace

`func (o *ExecutionControllerExecutionResponse) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ExecutionControllerExecutionResponse) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ExecutionControllerExecutionResponse) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *ExecutionControllerExecutionResponse) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *ExecutionControllerExecutionResponse) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *ExecutionControllerExecutionResponse) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetFlowRevision

`func (o *ExecutionControllerExecutionResponse) GetFlowRevision() int32`

GetFlowRevision returns the FlowRevision field if non-nil, zero value otherwise.

### GetFlowRevisionOk

`func (o *ExecutionControllerExecutionResponse) GetFlowRevisionOk() (*int32, bool)`

GetFlowRevisionOk returns a tuple with the FlowRevision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowRevision

`func (o *ExecutionControllerExecutionResponse) SetFlowRevision(v int32)`

SetFlowRevision sets FlowRevision field to given value.


### GetTaskRunList

`func (o *ExecutionControllerExecutionResponse) GetTaskRunList() []TaskRun`

GetTaskRunList returns the TaskRunList field if non-nil, zero value otherwise.

### GetTaskRunListOk

`func (o *ExecutionControllerExecutionResponse) GetTaskRunListOk() (*[]TaskRun, bool)`

GetTaskRunListOk returns a tuple with the TaskRunList field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskRunList

`func (o *ExecutionControllerExecutionResponse) SetTaskRunList(v []TaskRun)`

SetTaskRunList sets TaskRunList field to given value.


### GetInputs

`func (o *ExecutionControllerExecutionResponse) GetInputs() map[string]interface{}`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *ExecutionControllerExecutionResponse) GetInputsOk() (*map[string]interface{}, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *ExecutionControllerExecutionResponse) SetInputs(v map[string]interface{})`

SetInputs sets Inputs field to given value.


### GetOutputs

`func (o *ExecutionControllerExecutionResponse) GetOutputs() map[string]interface{}`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *ExecutionControllerExecutionResponse) GetOutputsOk() (*map[string]interface{}, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *ExecutionControllerExecutionResponse) SetOutputs(v map[string]interface{})`

SetOutputs sets Outputs field to given value.


### GetVariables

`func (o *ExecutionControllerExecutionResponse) GetVariables() map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *ExecutionControllerExecutionResponse) GetVariablesOk() (*map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *ExecutionControllerExecutionResponse) SetVariables(v map[string]interface{})`

SetVariables sets Variables field to given value.


### GetState

`func (o *ExecutionControllerExecutionResponse) GetState() State`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *ExecutionControllerExecutionResponse) GetStateOk() (*State, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *ExecutionControllerExecutionResponse) SetState(v State)`

SetState sets State field to given value.


### GetParentId

`func (o *ExecutionControllerExecutionResponse) GetParentId() string`

GetParentId returns the ParentId field if non-nil, zero value otherwise.

### GetParentIdOk

`func (o *ExecutionControllerExecutionResponse) GetParentIdOk() (*string, bool)`

GetParentIdOk returns a tuple with the ParentId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetParentId

`func (o *ExecutionControllerExecutionResponse) SetParentId(v string)`

SetParentId sets ParentId field to given value.


### GetOriginalId

`func (o *ExecutionControllerExecutionResponse) GetOriginalId() string`

GetOriginalId returns the OriginalId field if non-nil, zero value otherwise.

### GetOriginalIdOk

`func (o *ExecutionControllerExecutionResponse) GetOriginalIdOk() (*string, bool)`

GetOriginalIdOk returns a tuple with the OriginalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOriginalId

`func (o *ExecutionControllerExecutionResponse) SetOriginalId(v string)`

SetOriginalId sets OriginalId field to given value.


### GetTrigger

`func (o *ExecutionControllerExecutionResponse) GetTrigger() ExecutionTrigger`

GetTrigger returns the Trigger field if non-nil, zero value otherwise.

### GetTriggerOk

`func (o *ExecutionControllerExecutionResponse) GetTriggerOk() (*ExecutionTrigger, bool)`

GetTriggerOk returns a tuple with the Trigger field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTrigger

`func (o *ExecutionControllerExecutionResponse) SetTrigger(v ExecutionTrigger)`

SetTrigger sets Trigger field to given value.


### GetDeleted

`func (o *ExecutionControllerExecutionResponse) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *ExecutionControllerExecutionResponse) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *ExecutionControllerExecutionResponse) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetMetadata

`func (o *ExecutionControllerExecutionResponse) GetMetadata() ExecutionMetadata`

GetMetadata returns the Metadata field if non-nil, zero value otherwise.

### GetMetadataOk

`func (o *ExecutionControllerExecutionResponse) GetMetadataOk() (*ExecutionMetadata, bool)`

GetMetadataOk returns a tuple with the Metadata field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMetadata

`func (o *ExecutionControllerExecutionResponse) SetMetadata(v ExecutionMetadata)`

SetMetadata sets Metadata field to given value.


### GetScheduleDate

`func (o *ExecutionControllerExecutionResponse) GetScheduleDate() time.Time`

GetScheduleDate returns the ScheduleDate field if non-nil, zero value otherwise.

### GetScheduleDateOk

`func (o *ExecutionControllerExecutionResponse) GetScheduleDateOk() (*time.Time, bool)`

GetScheduleDateOk returns a tuple with the ScheduleDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetScheduleDate

`func (o *ExecutionControllerExecutionResponse) SetScheduleDate(v time.Time)`

SetScheduleDate sets ScheduleDate field to given value.

### HasScheduleDate

`func (o *ExecutionControllerExecutionResponse) HasScheduleDate() bool`

HasScheduleDate returns a boolean if a field has been set.

### SetScheduleDateNil

`func (o *ExecutionControllerExecutionResponse) SetScheduleDateNil(b bool)`

 SetScheduleDateNil sets the value for ScheduleDate to be an explicit nil

### UnsetScheduleDate
`func (o *ExecutionControllerExecutionResponse) UnsetScheduleDate()`

UnsetScheduleDate ensures that no value is present for ScheduleDate, not even an explicit nil
### GetTraceParent

`func (o *ExecutionControllerExecutionResponse) GetTraceParent() string`

GetTraceParent returns the TraceParent field if non-nil, zero value otherwise.

### GetTraceParentOk

`func (o *ExecutionControllerExecutionResponse) GetTraceParentOk() (*string, bool)`

GetTraceParentOk returns a tuple with the TraceParent field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTraceParent

`func (o *ExecutionControllerExecutionResponse) SetTraceParent(v string)`

SetTraceParent sets TraceParent field to given value.


### GetFixtures

`func (o *ExecutionControllerExecutionResponse) GetFixtures() []TaskFixture`

GetFixtures returns the Fixtures field if non-nil, zero value otherwise.

### GetFixturesOk

`func (o *ExecutionControllerExecutionResponse) GetFixturesOk() (*[]TaskFixture, bool)`

GetFixturesOk returns a tuple with the Fixtures field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFixtures

`func (o *ExecutionControllerExecutionResponse) SetFixtures(v []TaskFixture)`

SetFixtures sets Fixtures field to given value.

### HasFixtures

`func (o *ExecutionControllerExecutionResponse) HasFixtures() bool`

HasFixtures returns a boolean if a field has been set.

### SetFixturesNil

`func (o *ExecutionControllerExecutionResponse) SetFixturesNil(b bool)`

 SetFixturesNil sets the value for Fixtures to be an explicit nil

### UnsetFixtures
`func (o *ExecutionControllerExecutionResponse) UnsetFixtures()`

UnsetFixtures ensures that no value is present for Fixtures, not even an explicit nil
### GetKind

`func (o *ExecutionControllerExecutionResponse) GetKind() ExecutionKind`

GetKind returns the Kind field if non-nil, zero value otherwise.

### GetKindOk

`func (o *ExecutionControllerExecutionResponse) GetKindOk() (*ExecutionKind, bool)`

GetKindOk returns a tuple with the Kind field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKind

`func (o *ExecutionControllerExecutionResponse) SetKind(v ExecutionKind)`

SetKind sets Kind field to given value.

### HasKind

`func (o *ExecutionControllerExecutionResponse) HasKind() bool`

HasKind returns a boolean if a field has been set.

### SetKindNil

`func (o *ExecutionControllerExecutionResponse) SetKindNil(b bool)`

 SetKindNil sets the value for Kind to be an explicit nil

### UnsetKind
`func (o *ExecutionControllerExecutionResponse) UnsetKind()`

UnsetKind ensures that no value is present for Kind, not even an explicit nil
### GetUrl

`func (o *ExecutionControllerExecutionResponse) GetUrl() string`

GetUrl returns the Url field if non-nil, zero value otherwise.

### GetUrlOk

`func (o *ExecutionControllerExecutionResponse) GetUrlOk() (*string, bool)`

GetUrlOk returns a tuple with the Url field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUrl

`func (o *ExecutionControllerExecutionResponse) SetUrl(v string)`

SetUrl sets Url field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


