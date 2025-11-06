# TestSuite

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**Source** | Pointer to **string** |  | [optional] 
**TestCases** | [**[]UnitTest**](UnitTest.md) |  | 
**Deleted** | Pointer to **bool** |  | [optional] 
**Disabled** | Pointer to **bool** |  | [optional] 

## Methods

### NewTestSuite

`func NewTestSuite(id string, namespace string, flowId string, testCases []UnitTest, ) *TestSuite`

NewTestSuite instantiates a new TestSuite object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTestSuiteWithDefaults

`func NewTestSuiteWithDefaults() *TestSuite`

NewTestSuiteWithDefaults instantiates a new TestSuite object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *TestSuite) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *TestSuite) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *TestSuite) SetId(v string)`

SetId sets Id field to given value.


### GetDescription

`func (o *TestSuite) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *TestSuite) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *TestSuite) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *TestSuite) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetNamespace

`func (o *TestSuite) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *TestSuite) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *TestSuite) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *TestSuite) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *TestSuite) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *TestSuite) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetSource

`func (o *TestSuite) GetSource() string`

GetSource returns the Source field if non-nil, zero value otherwise.

### GetSourceOk

`func (o *TestSuite) GetSourceOk() (*string, bool)`

GetSourceOk returns a tuple with the Source field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSource

`func (o *TestSuite) SetSource(v string)`

SetSource sets Source field to given value.

### HasSource

`func (o *TestSuite) HasSource() bool`

HasSource returns a boolean if a field has been set.

### GetTestCases

`func (o *TestSuite) GetTestCases() []UnitTest`

GetTestCases returns the TestCases field if non-nil, zero value otherwise.

### GetTestCasesOk

`func (o *TestSuite) GetTestCasesOk() (*[]UnitTest, bool)`

GetTestCasesOk returns a tuple with the TestCases field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTestCases

`func (o *TestSuite) SetTestCases(v []UnitTest)`

SetTestCases sets TestCases field to given value.


### GetDeleted

`func (o *TestSuite) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *TestSuite) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *TestSuite) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.

### HasDeleted

`func (o *TestSuite) HasDeleted() bool`

HasDeleted returns a boolean if a field has been set.

### GetDisabled

`func (o *TestSuite) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *TestSuite) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *TestSuite) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.

### HasDisabled

`func (o *TestSuite) HasDisabled() bool`

HasDisabled returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


