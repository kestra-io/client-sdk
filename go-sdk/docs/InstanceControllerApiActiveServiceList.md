# InstanceControllerApiActiveServiceList

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Total** | **int32** |  | 
**Services** | [**[]InstanceControllerApiActiveService**](InstanceControllerApiActiveService.md) |  | 

## Methods

### NewInstanceControllerApiActiveServiceList

`func NewInstanceControllerApiActiveServiceList(total int32, services []InstanceControllerApiActiveService, ) *InstanceControllerApiActiveServiceList`

NewInstanceControllerApiActiveServiceList instantiates a new InstanceControllerApiActiveServiceList object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInstanceControllerApiActiveServiceListWithDefaults

`func NewInstanceControllerApiActiveServiceListWithDefaults() *InstanceControllerApiActiveServiceList`

NewInstanceControllerApiActiveServiceListWithDefaults instantiates a new InstanceControllerApiActiveServiceList object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTotal

`func (o *InstanceControllerApiActiveServiceList) GetTotal() int32`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *InstanceControllerApiActiveServiceList) GetTotalOk() (*int32, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *InstanceControllerApiActiveServiceList) SetTotal(v int32)`

SetTotal sets Total field to given value.


### GetServices

`func (o *InstanceControllerApiActiveServiceList) GetServices() []InstanceControllerApiActiveService`

GetServices returns the Services field if non-nil, zero value otherwise.

### GetServicesOk

`func (o *InstanceControllerApiActiveServiceList) GetServicesOk() (*[]InstanceControllerApiActiveService, bool)`

GetServicesOk returns a tuple with the Services field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetServices

`func (o *InstanceControllerApiActiveServiceList) SetServices(v []InstanceControllerApiActiveService)`

SetServices sets Services field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


