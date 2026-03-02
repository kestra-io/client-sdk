# WebhookResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | Pointer to **string** |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**FlowId** | Pointer to **string** |  | [optional] 
**FlowRevision** | Pointer to **int32** |  | [optional] 
**Trigger** | Pointer to [**ExecutionTrigger**](ExecutionTrigger.md) |  | [optional] 
**Outputs** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**Labels** | Pointer to [**[]Label**](Label.md) |  | [optional] 
**State** | Pointer to [**State**](State.md) |  | [optional] 
**Url** | Pointer to **string** |  | [optional] 

## Methods

### NewWebhookResponse

`func NewWebhookResponse() *WebhookResponse`

NewWebhookResponse instantiates a new WebhookResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewWebhookResponseWithDefaults

`func NewWebhookResponseWithDefaults() *WebhookResponse`

NewWebhookResponseWithDefaults instantiates a new WebhookResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenantId

`func (o *WebhookResponse) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *WebhookResponse) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *WebhookResponse) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *WebhookResponse) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetId

`func (o *WebhookResponse) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *WebhookResponse) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *WebhookResponse) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *WebhookResponse) HasId() bool`

HasId returns a boolean if a field has been set.

### GetNamespace

`func (o *WebhookResponse) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *WebhookResponse) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *WebhookResponse) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *WebhookResponse) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetFlowId

`func (o *WebhookResponse) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *WebhookResponse) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *WebhookResponse) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.

### HasFlowId

`func (o *WebhookResponse) HasFlowId() bool`

HasFlowId returns a boolean if a field has been set.

### GetFlowRevision

`func (o *WebhookResponse) GetFlowRevision() int32`

GetFlowRevision returns the FlowRevision field if non-nil, zero value otherwise.

### GetFlowRevisionOk

`func (o *WebhookResponse) GetFlowRevisionOk() (*int32, bool)`

GetFlowRevisionOk returns a tuple with the FlowRevision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowRevision

`func (o *WebhookResponse) SetFlowRevision(v int32)`

SetFlowRevision sets FlowRevision field to given value.

### HasFlowRevision

`func (o *WebhookResponse) HasFlowRevision() bool`

HasFlowRevision returns a boolean if a field has been set.

### GetTrigger

`func (o *WebhookResponse) GetTrigger() ExecutionTrigger`

GetTrigger returns the Trigger field if non-nil, zero value otherwise.

### GetTriggerOk

`func (o *WebhookResponse) GetTriggerOk() (*ExecutionTrigger, bool)`

GetTriggerOk returns a tuple with the Trigger field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTrigger

`func (o *WebhookResponse) SetTrigger(v ExecutionTrigger)`

SetTrigger sets Trigger field to given value.

### HasTrigger

`func (o *WebhookResponse) HasTrigger() bool`

HasTrigger returns a boolean if a field has been set.

### GetOutputs

`func (o *WebhookResponse) GetOutputs() map[string]map[string]interface{}`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *WebhookResponse) GetOutputsOk() (*map[string]map[string]interface{}, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *WebhookResponse) SetOutputs(v map[string]map[string]interface{})`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *WebhookResponse) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetLabels

`func (o *WebhookResponse) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *WebhookResponse) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *WebhookResponse) SetLabels(v []Label)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *WebhookResponse) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetState

`func (o *WebhookResponse) GetState() State`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *WebhookResponse) GetStateOk() (*State, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *WebhookResponse) SetState(v State)`

SetState sets State field to given value.

### HasState

`func (o *WebhookResponse) HasState() bool`

HasState returns a boolean if a field has been set.

### GetUrl

`func (o *WebhookResponse) GetUrl() string`

GetUrl returns the Url field if non-nil, zero value otherwise.

### GetUrlOk

`func (o *WebhookResponse) GetUrlOk() (*string, bool)`

GetUrlOk returns a tuple with the Url field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUrl

`func (o *WebhookResponse) SetUrl(v string)`

SetUrl sets Url field to given value.

### HasUrl

`func (o *WebhookResponse) HasUrl() bool`

HasUrl returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


