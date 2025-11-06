# MiscControllerApiUsage

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Flows** | Pointer to [**FlowUsage**](FlowUsage.md) |  | [optional] 
**Executions** | Pointer to [**ExecutionUsage**](ExecutionUsage.md) |  | [optional] 

## Methods

### NewMiscControllerApiUsage

`func NewMiscControllerApiUsage() *MiscControllerApiUsage`

NewMiscControllerApiUsage instantiates a new MiscControllerApiUsage object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMiscControllerApiUsageWithDefaults

`func NewMiscControllerApiUsageWithDefaults() *MiscControllerApiUsage`

NewMiscControllerApiUsageWithDefaults instantiates a new MiscControllerApiUsage object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFlows

`func (o *MiscControllerApiUsage) GetFlows() FlowUsage`

GetFlows returns the Flows field if non-nil, zero value otherwise.

### GetFlowsOk

`func (o *MiscControllerApiUsage) GetFlowsOk() (*FlowUsage, bool)`

GetFlowsOk returns a tuple with the Flows field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlows

`func (o *MiscControllerApiUsage) SetFlows(v FlowUsage)`

SetFlows sets Flows field to given value.

### HasFlows

`func (o *MiscControllerApiUsage) HasFlows() bool`

HasFlows returns a boolean if a field has been set.

### GetExecutions

`func (o *MiscControllerApiUsage) GetExecutions() ExecutionUsage`

GetExecutions returns the Executions field if non-nil, zero value otherwise.

### GetExecutionsOk

`func (o *MiscControllerApiUsage) GetExecutionsOk() (*ExecutionUsage, bool)`

GetExecutionsOk returns a tuple with the Executions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutions

`func (o *MiscControllerApiUsage) SetExecutions(v ExecutionUsage)`

SetExecutions sets Executions field to given value.

### HasExecutions

`func (o *MiscControllerApiUsage) HasExecutions() bool`

HasExecutions returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


