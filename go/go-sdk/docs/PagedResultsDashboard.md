# PagedResultsDashboard

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]Dashboard**](Dashboard.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsDashboard

`func NewPagedResultsDashboard(results []Dashboard, total int64, ) *PagedResultsDashboard`

NewPagedResultsDashboard instantiates a new PagedResultsDashboard object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsDashboardWithDefaults

`func NewPagedResultsDashboardWithDefaults() *PagedResultsDashboard`

NewPagedResultsDashboardWithDefaults instantiates a new PagedResultsDashboard object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsDashboard) GetResults() []Dashboard`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsDashboard) GetResultsOk() (*[]Dashboard, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsDashboard) SetResults(v []Dashboard)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsDashboard) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsDashboard) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsDashboard) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


