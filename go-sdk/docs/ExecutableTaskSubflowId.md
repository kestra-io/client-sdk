# ExecutableTaskSubflowId

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**Revision** | Pointer to **NullableInt32** |  | [optional] 

## Methods

### NewExecutableTaskSubflowId

`func NewExecutableTaskSubflowId(namespace string, flowId string, ) *ExecutableTaskSubflowId`

NewExecutableTaskSubflowId instantiates a new ExecutableTaskSubflowId object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutableTaskSubflowIdWithDefaults

`func NewExecutableTaskSubflowIdWithDefaults() *ExecutableTaskSubflowId`

NewExecutableTaskSubflowIdWithDefaults instantiates a new ExecutableTaskSubflowId object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetNamespace

`func (o *ExecutableTaskSubflowId) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ExecutableTaskSubflowId) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ExecutableTaskSubflowId) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *ExecutableTaskSubflowId) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *ExecutableTaskSubflowId) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *ExecutableTaskSubflowId) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetRevision

`func (o *ExecutableTaskSubflowId) GetRevision() int32`

GetRevision returns the Revision field if non-nil, zero value otherwise.

### GetRevisionOk

`func (o *ExecutableTaskSubflowId) GetRevisionOk() (*int32, bool)`

GetRevisionOk returns a tuple with the Revision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevision

`func (o *ExecutableTaskSubflowId) SetRevision(v int32)`

SetRevision sets Revision field to given value.

### HasRevision

`func (o *ExecutableTaskSubflowId) HasRevision() bool`

HasRevision returns a boolean if a field has been set.

### SetRevisionNil

`func (o *ExecutableTaskSubflowId) SetRevisionNil(b bool)`

 SetRevisionNil sets the value for Revision to be an explicit nil

### UnsetRevision
`func (o *ExecutableTaskSubflowId) UnsetRevision()`

UnsetRevision ensures that no value is present for Revision, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


