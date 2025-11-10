# TestSuiteServiceTestRunByQueryResult

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**RequestMade** | Pointer to [**TestSuiteServiceRunByQueryRequest**](TestSuiteServiceRunByQueryRequest.md) |  | [optional] 
**TenantId** | Pointer to **string** |  | [optional] 
**NumberOfTestSuitesToBeRun** | Pointer to **int32** |  | [optional] 
**NumberOfTestCasesToBeRun** | Pointer to **int32** |  | [optional] 
**Results** | Pointer to [**[]TestSuiteRunResult**](TestSuiteRunResult.md) |  | [optional] 

## Methods

### NewTestSuiteServiceTestRunByQueryResult

`func NewTestSuiteServiceTestRunByQueryResult() *TestSuiteServiceTestRunByQueryResult`

NewTestSuiteServiceTestRunByQueryResult instantiates a new TestSuiteServiceTestRunByQueryResult object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTestSuiteServiceTestRunByQueryResultWithDefaults

`func NewTestSuiteServiceTestRunByQueryResultWithDefaults() *TestSuiteServiceTestRunByQueryResult`

NewTestSuiteServiceTestRunByQueryResultWithDefaults instantiates a new TestSuiteServiceTestRunByQueryResult object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetRequestMade

`func (o *TestSuiteServiceTestRunByQueryResult) GetRequestMade() TestSuiteServiceRunByQueryRequest`

GetRequestMade returns the RequestMade field if non-nil, zero value otherwise.

### GetRequestMadeOk

`func (o *TestSuiteServiceTestRunByQueryResult) GetRequestMadeOk() (*TestSuiteServiceRunByQueryRequest, bool)`

GetRequestMadeOk returns a tuple with the RequestMade field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRequestMade

`func (o *TestSuiteServiceTestRunByQueryResult) SetRequestMade(v TestSuiteServiceRunByQueryRequest)`

SetRequestMade sets RequestMade field to given value.

### HasRequestMade

`func (o *TestSuiteServiceTestRunByQueryResult) HasRequestMade() bool`

HasRequestMade returns a boolean if a field has been set.

### GetTenantId

`func (o *TestSuiteServiceTestRunByQueryResult) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *TestSuiteServiceTestRunByQueryResult) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *TestSuiteServiceTestRunByQueryResult) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *TestSuiteServiceTestRunByQueryResult) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetNumberOfTestSuitesToBeRun

`func (o *TestSuiteServiceTestRunByQueryResult) GetNumberOfTestSuitesToBeRun() int32`

GetNumberOfTestSuitesToBeRun returns the NumberOfTestSuitesToBeRun field if non-nil, zero value otherwise.

### GetNumberOfTestSuitesToBeRunOk

`func (o *TestSuiteServiceTestRunByQueryResult) GetNumberOfTestSuitesToBeRunOk() (*int32, bool)`

GetNumberOfTestSuitesToBeRunOk returns a tuple with the NumberOfTestSuitesToBeRun field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNumberOfTestSuitesToBeRun

`func (o *TestSuiteServiceTestRunByQueryResult) SetNumberOfTestSuitesToBeRun(v int32)`

SetNumberOfTestSuitesToBeRun sets NumberOfTestSuitesToBeRun field to given value.

### HasNumberOfTestSuitesToBeRun

`func (o *TestSuiteServiceTestRunByQueryResult) HasNumberOfTestSuitesToBeRun() bool`

HasNumberOfTestSuitesToBeRun returns a boolean if a field has been set.

### GetNumberOfTestCasesToBeRun

`func (o *TestSuiteServiceTestRunByQueryResult) GetNumberOfTestCasesToBeRun() int32`

GetNumberOfTestCasesToBeRun returns the NumberOfTestCasesToBeRun field if non-nil, zero value otherwise.

### GetNumberOfTestCasesToBeRunOk

`func (o *TestSuiteServiceTestRunByQueryResult) GetNumberOfTestCasesToBeRunOk() (*int32, bool)`

GetNumberOfTestCasesToBeRunOk returns a tuple with the NumberOfTestCasesToBeRun field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNumberOfTestCasesToBeRun

`func (o *TestSuiteServiceTestRunByQueryResult) SetNumberOfTestCasesToBeRun(v int32)`

SetNumberOfTestCasesToBeRun sets NumberOfTestCasesToBeRun field to given value.

### HasNumberOfTestCasesToBeRun

`func (o *TestSuiteServiceTestRunByQueryResult) HasNumberOfTestCasesToBeRun() bool`

HasNumberOfTestCasesToBeRun returns a boolean if a field has been set.

### GetResults

`func (o *TestSuiteServiceTestRunByQueryResult) GetResults() []TestSuiteRunResult`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *TestSuiteServiceTestRunByQueryResult) GetResultsOk() (*[]TestSuiteRunResult, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *TestSuiteServiceTestRunByQueryResult) SetResults(v []TestSuiteRunResult)`

SetResults sets Results field to given value.

### HasResults

`func (o *TestSuiteServiceTestRunByQueryResult) HasResults() bool`

HasResults returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


