# TestSuiteServiceRunByQueryRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Namespace** | **NullableString** |  | 
**FlowId** | **NullableString** |  | 
**IncludeChildNamespaces** | **bool** | Should child namespaces be included or not | [default to true]

## Methods

### NewTestSuiteServiceRunByQueryRequest

`func NewTestSuiteServiceRunByQueryRequest(namespace NullableString, flowId NullableString, includeChildNamespaces bool, ) *TestSuiteServiceRunByQueryRequest`

NewTestSuiteServiceRunByQueryRequest instantiates a new TestSuiteServiceRunByQueryRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTestSuiteServiceRunByQueryRequestWithDefaults

`func NewTestSuiteServiceRunByQueryRequestWithDefaults() *TestSuiteServiceRunByQueryRequest`

NewTestSuiteServiceRunByQueryRequestWithDefaults instantiates a new TestSuiteServiceRunByQueryRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetNamespace

`func (o *TestSuiteServiceRunByQueryRequest) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *TestSuiteServiceRunByQueryRequest) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *TestSuiteServiceRunByQueryRequest) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### SetNamespaceNil

`func (o *TestSuiteServiceRunByQueryRequest) SetNamespaceNil(b bool)`

 SetNamespaceNil sets the value for Namespace to be an explicit nil

### UnsetNamespace
`func (o *TestSuiteServiceRunByQueryRequest) UnsetNamespace()`

UnsetNamespace ensures that no value is present for Namespace, not even an explicit nil
### GetFlowId

`func (o *TestSuiteServiceRunByQueryRequest) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *TestSuiteServiceRunByQueryRequest) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *TestSuiteServiceRunByQueryRequest) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### SetFlowIdNil

`func (o *TestSuiteServiceRunByQueryRequest) SetFlowIdNil(b bool)`

 SetFlowIdNil sets the value for FlowId to be an explicit nil

### UnsetFlowId
`func (o *TestSuiteServiceRunByQueryRequest) UnsetFlowId()`

UnsetFlowId ensures that no value is present for FlowId, not even an explicit nil
### GetIncludeChildNamespaces

`func (o *TestSuiteServiceRunByQueryRequest) GetIncludeChildNamespaces() bool`

GetIncludeChildNamespaces returns the IncludeChildNamespaces field if non-nil, zero value otherwise.

### GetIncludeChildNamespacesOk

`func (o *TestSuiteServiceRunByQueryRequest) GetIncludeChildNamespacesOk() (*bool, bool)`

GetIncludeChildNamespacesOk returns a tuple with the IncludeChildNamespaces field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIncludeChildNamespaces

`func (o *TestSuiteServiceRunByQueryRequest) SetIncludeChildNamespaces(v bool)`

SetIncludeChildNamespaces sets IncludeChildNamespaces field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


