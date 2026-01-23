# PagedResultsTestSuiteRunResult

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]TestSuiteRunResult**](TestSuiteRunResult.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsTestSuiteRunResult

`func NewPagedResultsTestSuiteRunResult(results []TestSuiteRunResult, total int64, ) *PagedResultsTestSuiteRunResult`

NewPagedResultsTestSuiteRunResult instantiates a new PagedResultsTestSuiteRunResult object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsTestSuiteRunResultWithDefaults

`func NewPagedResultsTestSuiteRunResultWithDefaults() *PagedResultsTestSuiteRunResult`

NewPagedResultsTestSuiteRunResultWithDefaults instantiates a new PagedResultsTestSuiteRunResult object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsTestSuiteRunResult) GetResults() []TestSuiteRunResult`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsTestSuiteRunResult) GetResultsOk() (*[]TestSuiteRunResult, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsTestSuiteRunResult) SetResults(v []TestSuiteRunResult)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsTestSuiteRunResult) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsTestSuiteRunResult) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsTestSuiteRunResult) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


