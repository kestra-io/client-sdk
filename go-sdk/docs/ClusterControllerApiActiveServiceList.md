# ClusterControllerApiActiveServiceList

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Total** | Pointer to **int32** |  | [optional] 
**Services** | Pointer to [**[]ClusterControllerApiActiveService**](ClusterControllerApiActiveService.md) |  | [optional] 

## Methods

### NewClusterControllerApiActiveServiceList

`func NewClusterControllerApiActiveServiceList() *ClusterControllerApiActiveServiceList`

NewClusterControllerApiActiveServiceList instantiates a new ClusterControllerApiActiveServiceList object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewClusterControllerApiActiveServiceListWithDefaults

`func NewClusterControllerApiActiveServiceListWithDefaults() *ClusterControllerApiActiveServiceList`

NewClusterControllerApiActiveServiceListWithDefaults instantiates a new ClusterControllerApiActiveServiceList object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTotal

`func (o *ClusterControllerApiActiveServiceList) GetTotal() int32`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *ClusterControllerApiActiveServiceList) GetTotalOk() (*int32, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *ClusterControllerApiActiveServiceList) SetTotal(v int32)`

SetTotal sets Total field to given value.

### HasTotal

`func (o *ClusterControllerApiActiveServiceList) HasTotal() bool`

HasTotal returns a boolean if a field has been set.

### GetServices

`func (o *ClusterControllerApiActiveServiceList) GetServices() []ClusterControllerApiActiveService`

GetServices returns the Services field if non-nil, zero value otherwise.

### GetServicesOk

`func (o *ClusterControllerApiActiveServiceList) GetServicesOk() (*[]ClusterControllerApiActiveService, bool)`

GetServicesOk returns a tuple with the Services field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetServices

`func (o *ClusterControllerApiActiveServiceList) SetServices(v []ClusterControllerApiActiveService)`

SetServices sets Services field to given value.

### HasServices

`func (o *ClusterControllerApiActiveServiceList) HasServices() bool`

HasServices returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


