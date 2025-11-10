# UnitTestResult

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TestId** | **string** |  | 
**TestType** | **string** |  | 
**ExecutionId** | Pointer to **string** |  | [optional] 
**Url** | Pointer to **string** |  | [optional] 
**State** | [**TestState**](TestState.md) |  | 
**AssertionResults** | [**[]AssertionResult**](AssertionResult.md) |  | 
**Errors** | [**[]AssertionRunError**](AssertionRunError.md) |  | 
**Fixtures** | Pointer to [**Fixtures**](Fixtures.md) |  | [optional] 

## Methods

### NewUnitTestResult

`func NewUnitTestResult(testId string, testType string, state TestState, assertionResults []AssertionResult, errors []AssertionRunError, ) *UnitTestResult`

NewUnitTestResult instantiates a new UnitTestResult object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUnitTestResultWithDefaults

`func NewUnitTestResultWithDefaults() *UnitTestResult`

NewUnitTestResultWithDefaults instantiates a new UnitTestResult object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTestId

`func (o *UnitTestResult) GetTestId() string`

GetTestId returns the TestId field if non-nil, zero value otherwise.

### GetTestIdOk

`func (o *UnitTestResult) GetTestIdOk() (*string, bool)`

GetTestIdOk returns a tuple with the TestId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTestId

`func (o *UnitTestResult) SetTestId(v string)`

SetTestId sets TestId field to given value.


### GetTestType

`func (o *UnitTestResult) GetTestType() string`

GetTestType returns the TestType field if non-nil, zero value otherwise.

### GetTestTypeOk

`func (o *UnitTestResult) GetTestTypeOk() (*string, bool)`

GetTestTypeOk returns a tuple with the TestType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTestType

`func (o *UnitTestResult) SetTestType(v string)`

SetTestType sets TestType field to given value.


### GetExecutionId

`func (o *UnitTestResult) GetExecutionId() string`

GetExecutionId returns the ExecutionId field if non-nil, zero value otherwise.

### GetExecutionIdOk

`func (o *UnitTestResult) GetExecutionIdOk() (*string, bool)`

GetExecutionIdOk returns a tuple with the ExecutionId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionId

`func (o *UnitTestResult) SetExecutionId(v string)`

SetExecutionId sets ExecutionId field to given value.

### HasExecutionId

`func (o *UnitTestResult) HasExecutionId() bool`

HasExecutionId returns a boolean if a field has been set.

### GetUrl

`func (o *UnitTestResult) GetUrl() string`

GetUrl returns the Url field if non-nil, zero value otherwise.

### GetUrlOk

`func (o *UnitTestResult) GetUrlOk() (*string, bool)`

GetUrlOk returns a tuple with the Url field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUrl

`func (o *UnitTestResult) SetUrl(v string)`

SetUrl sets Url field to given value.

### HasUrl

`func (o *UnitTestResult) HasUrl() bool`

HasUrl returns a boolean if a field has been set.

### GetState

`func (o *UnitTestResult) GetState() TestState`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *UnitTestResult) GetStateOk() (*TestState, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *UnitTestResult) SetState(v TestState)`

SetState sets State field to given value.


### GetAssertionResults

`func (o *UnitTestResult) GetAssertionResults() []AssertionResult`

GetAssertionResults returns the AssertionResults field if non-nil, zero value otherwise.

### GetAssertionResultsOk

`func (o *UnitTestResult) GetAssertionResultsOk() (*[]AssertionResult, bool)`

GetAssertionResultsOk returns a tuple with the AssertionResults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAssertionResults

`func (o *UnitTestResult) SetAssertionResults(v []AssertionResult)`

SetAssertionResults sets AssertionResults field to given value.


### GetErrors

`func (o *UnitTestResult) GetErrors() []AssertionRunError`

GetErrors returns the Errors field if non-nil, zero value otherwise.

### GetErrorsOk

`func (o *UnitTestResult) GetErrorsOk() (*[]AssertionRunError, bool)`

GetErrorsOk returns a tuple with the Errors field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetErrors

`func (o *UnitTestResult) SetErrors(v []AssertionRunError)`

SetErrors sets Errors field to given value.


### GetFixtures

`func (o *UnitTestResult) GetFixtures() Fixtures`

GetFixtures returns the Fixtures field if non-nil, zero value otherwise.

### GetFixturesOk

`func (o *UnitTestResult) GetFixturesOk() (*Fixtures, bool)`

GetFixturesOk returns a tuple with the Fixtures field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFixtures

`func (o *UnitTestResult) SetFixtures(v Fixtures)`

SetFixtures sets Fixtures field to given value.

### HasFixtures

`func (o *UnitTestResult) HasFixtures() bool`

HasFixtures returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


