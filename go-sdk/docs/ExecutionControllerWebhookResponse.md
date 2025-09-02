# ExecutionControllerWebhookResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | **string** |  | 
**Id** | **string** |  | 
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**FlowRevision** | **int32** |  | 
**Trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  | 
**Outputs** | **map[string]map[string]interface{}** |  | 
**Labels** | [**[]Label**](Label.md) |  | 
**State** | [**State**](State.md) |  | 
**Url** | **string** |  | 

## Methods

### NewExecutionControllerWebhookResponse

`func NewExecutionControllerWebhookResponse(tenantId string, id string, namespace string, flowId string, flowRevision int32, trigger ExecutionTrigger, outputs map[string]map[string]interface{}, labels []Label, state State, url string, ) *ExecutionControllerWebhookResponse`

NewExecutionControllerWebhookResponse instantiates a new ExecutionControllerWebhookResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionControllerWebhookResponseWithDefaults

`func NewExecutionControllerWebhookResponseWithDefaults() *ExecutionControllerWebhookResponse`

NewExecutionControllerWebhookResponseWithDefaults instantiates a new ExecutionControllerWebhookResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenantId

`func (o *ExecutionControllerWebhookResponse) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *ExecutionControllerWebhookResponse) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *ExecutionControllerWebhookResponse) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.


### GetId

`func (o *ExecutionControllerWebhookResponse) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ExecutionControllerWebhookResponse) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ExecutionControllerWebhookResponse) SetId(v string)`

SetId sets Id field to given value.


### GetNamespace

`func (o *ExecutionControllerWebhookResponse) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ExecutionControllerWebhookResponse) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ExecutionControllerWebhookResponse) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *ExecutionControllerWebhookResponse) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *ExecutionControllerWebhookResponse) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *ExecutionControllerWebhookResponse) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetFlowRevision

`func (o *ExecutionControllerWebhookResponse) GetFlowRevision() int32`

GetFlowRevision returns the FlowRevision field if non-nil, zero value otherwise.

### GetFlowRevisionOk

`func (o *ExecutionControllerWebhookResponse) GetFlowRevisionOk() (*int32, bool)`

GetFlowRevisionOk returns a tuple with the FlowRevision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowRevision

`func (o *ExecutionControllerWebhookResponse) SetFlowRevision(v int32)`

SetFlowRevision sets FlowRevision field to given value.


### GetTrigger

`func (o *ExecutionControllerWebhookResponse) GetTrigger() ExecutionTrigger`

GetTrigger returns the Trigger field if non-nil, zero value otherwise.

### GetTriggerOk

`func (o *ExecutionControllerWebhookResponse) GetTriggerOk() (*ExecutionTrigger, bool)`

GetTriggerOk returns a tuple with the Trigger field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTrigger

`func (o *ExecutionControllerWebhookResponse) SetTrigger(v ExecutionTrigger)`

SetTrigger sets Trigger field to given value.


### GetOutputs

`func (o *ExecutionControllerWebhookResponse) GetOutputs() map[string]map[string]interface{}`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *ExecutionControllerWebhookResponse) GetOutputsOk() (*map[string]map[string]interface{}, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *ExecutionControllerWebhookResponse) SetOutputs(v map[string]map[string]interface{})`

SetOutputs sets Outputs field to given value.


### GetLabels

`func (o *ExecutionControllerWebhookResponse) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *ExecutionControllerWebhookResponse) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *ExecutionControllerWebhookResponse) SetLabels(v []Label)`

SetLabels sets Labels field to given value.


### GetState

`func (o *ExecutionControllerWebhookResponse) GetState() State`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *ExecutionControllerWebhookResponse) GetStateOk() (*State, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *ExecutionControllerWebhookResponse) SetState(v State)`

SetState sets State field to given value.


### GetUrl

`func (o *ExecutionControllerWebhookResponse) GetUrl() string`

GetUrl returns the Url field if non-nil, zero value otherwise.

### GetUrlOk

`func (o *ExecutionControllerWebhookResponse) GetUrlOk() (*string, bool)`

GetUrlOk returns a tuple with the Url field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUrl

`func (o *ExecutionControllerWebhookResponse) SetUrl(v string)`

SetUrl sets Url field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


