# InstanceControllerApiServiceInstance

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Type** | Pointer to [**ServiceType**](ServiceType.md) |  | [optional] 
**State** | Pointer to [**ServiceServiceState**](ServiceServiceState.md) |  | [optional] 
**Server** | Pointer to [**InstanceControllerApiServerInstance**](InstanceControllerApiServerInstance.md) |  | [optional] 
**CreatedAt** | Pointer to **time.Time** |  | [optional] 
**UpdatedAt** | Pointer to **time.Time** |  | [optional] 

## Methods

### NewInstanceControllerApiServiceInstance

`func NewInstanceControllerApiServiceInstance() *InstanceControllerApiServiceInstance`

NewInstanceControllerApiServiceInstance instantiates a new InstanceControllerApiServiceInstance object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInstanceControllerApiServiceInstanceWithDefaults

`func NewInstanceControllerApiServiceInstanceWithDefaults() *InstanceControllerApiServiceInstance`

NewInstanceControllerApiServiceInstanceWithDefaults instantiates a new InstanceControllerApiServiceInstance object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *InstanceControllerApiServiceInstance) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *InstanceControllerApiServiceInstance) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *InstanceControllerApiServiceInstance) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *InstanceControllerApiServiceInstance) HasId() bool`

HasId returns a boolean if a field has been set.

### GetType

`func (o *InstanceControllerApiServiceInstance) GetType() ServiceType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *InstanceControllerApiServiceInstance) GetTypeOk() (*ServiceType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *InstanceControllerApiServiceInstance) SetType(v ServiceType)`

SetType sets Type field to given value.

### HasType

`func (o *InstanceControllerApiServiceInstance) HasType() bool`

HasType returns a boolean if a field has been set.

### GetState

`func (o *InstanceControllerApiServiceInstance) GetState() ServiceServiceState`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *InstanceControllerApiServiceInstance) GetStateOk() (*ServiceServiceState, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *InstanceControllerApiServiceInstance) SetState(v ServiceServiceState)`

SetState sets State field to given value.

### HasState

`func (o *InstanceControllerApiServiceInstance) HasState() bool`

HasState returns a boolean if a field has been set.

### GetServer

`func (o *InstanceControllerApiServiceInstance) GetServer() InstanceControllerApiServerInstance`

GetServer returns the Server field if non-nil, zero value otherwise.

### GetServerOk

`func (o *InstanceControllerApiServiceInstance) GetServerOk() (*InstanceControllerApiServerInstance, bool)`

GetServerOk returns a tuple with the Server field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetServer

`func (o *InstanceControllerApiServiceInstance) SetServer(v InstanceControllerApiServerInstance)`

SetServer sets Server field to given value.

### HasServer

`func (o *InstanceControllerApiServiceInstance) HasServer() bool`

HasServer returns a boolean if a field has been set.

### GetCreatedAt

`func (o *InstanceControllerApiServiceInstance) GetCreatedAt() time.Time`

GetCreatedAt returns the CreatedAt field if non-nil, zero value otherwise.

### GetCreatedAtOk

`func (o *InstanceControllerApiServiceInstance) GetCreatedAtOk() (*time.Time, bool)`

GetCreatedAtOk returns a tuple with the CreatedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreatedAt

`func (o *InstanceControllerApiServiceInstance) SetCreatedAt(v time.Time)`

SetCreatedAt sets CreatedAt field to given value.

### HasCreatedAt

`func (o *InstanceControllerApiServiceInstance) HasCreatedAt() bool`

HasCreatedAt returns a boolean if a field has been set.

### GetUpdatedAt

`func (o *InstanceControllerApiServiceInstance) GetUpdatedAt() time.Time`

GetUpdatedAt returns the UpdatedAt field if non-nil, zero value otherwise.

### GetUpdatedAtOk

`func (o *InstanceControllerApiServiceInstance) GetUpdatedAtOk() (*time.Time, bool)`

GetUpdatedAtOk returns a tuple with the UpdatedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUpdatedAt

`func (o *InstanceControllerApiServiceInstance) SetUpdatedAt(v time.Time)`

SetUpdatedAt sets UpdatedAt field to given value.

### HasUpdatedAt

`func (o *InstanceControllerApiServiceInstance) HasUpdatedAt() bool`

HasUpdatedAt returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


