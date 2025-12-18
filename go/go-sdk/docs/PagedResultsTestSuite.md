# PagedResultsTestSuite

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]TestSuite**](TestSuite.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsTestSuite

`func NewPagedResultsTestSuite(results []TestSuite, total int64, ) *PagedResultsTestSuite`

NewPagedResultsTestSuite instantiates a new PagedResultsTestSuite object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsTestSuiteWithDefaults

`func NewPagedResultsTestSuiteWithDefaults() *PagedResultsTestSuite`

NewPagedResultsTestSuiteWithDefaults instantiates a new PagedResultsTestSuite object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsTestSuite) GetResults() []TestSuite`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsTestSuite) GetResultsOk() (*[]TestSuite, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsTestSuite) SetResults(v []TestSuite)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsTestSuite) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsTestSuite) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsTestSuite) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


