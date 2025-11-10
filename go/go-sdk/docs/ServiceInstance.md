# ServiceInstance

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Server** | Pointer to [**ServerInstance**](ServerInstance.md) |  | [optional] 
**Metrics** | Pointer to [**[]Metric**](Metric.md) |  | [optional] 
**State** | Pointer to [**ServiceServiceState**](ServiceServiceState.md) |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Type** | Pointer to [**ServiceType**](ServiceType.md) |  | [optional] 
**CreatedAt** | Pointer to **time.Time** |  | [optional] 
**UpdatedAt** | Pointer to **time.Time** |  | [optional] 
**Events** | Pointer to [**[]ServiceInstanceTimestampedEvent**](ServiceInstanceTimestampedEvent.md) |  | [optional] 
**Config** | Pointer to [**ServerConfig**](ServerConfig.md) |  | [optional] 
**Props** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**SeqId** | Pointer to **int64** |  | [optional] 

## Methods

### NewServiceInstance

`func NewServiceInstance() *ServiceInstance`

NewServiceInstance instantiates a new ServiceInstance object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewServiceInstanceWithDefaults

`func NewServiceInstanceWithDefaults() *ServiceInstance`

NewServiceInstanceWithDefaults instantiates a new ServiceInstance object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetServer

`func (o *ServiceInstance) GetServer() ServerInstance`

GetServer returns the Server field if non-nil, zero value otherwise.

### GetServerOk

`func (o *ServiceInstance) GetServerOk() (*ServerInstance, bool)`

GetServerOk returns a tuple with the Server field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetServer

`func (o *ServiceInstance) SetServer(v ServerInstance)`

SetServer sets Server field to given value.

### HasServer

`func (o *ServiceInstance) HasServer() bool`

HasServer returns a boolean if a field has been set.

### GetMetrics

`func (o *ServiceInstance) GetMetrics() []Metric`

GetMetrics returns the Metrics field if non-nil, zero value otherwise.

### GetMetricsOk

`func (o *ServiceInstance) GetMetricsOk() (*[]Metric, bool)`

GetMetricsOk returns a tuple with the Metrics field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMetrics

`func (o *ServiceInstance) SetMetrics(v []Metric)`

SetMetrics sets Metrics field to given value.

### HasMetrics

`func (o *ServiceInstance) HasMetrics() bool`

HasMetrics returns a boolean if a field has been set.

### GetState

`func (o *ServiceInstance) GetState() ServiceServiceState`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *ServiceInstance) GetStateOk() (*ServiceServiceState, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *ServiceInstance) SetState(v ServiceServiceState)`

SetState sets State field to given value.

### HasState

`func (o *ServiceInstance) HasState() bool`

HasState returns a boolean if a field has been set.

### GetId

`func (o *ServiceInstance) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ServiceInstance) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ServiceInstance) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ServiceInstance) HasId() bool`

HasId returns a boolean if a field has been set.

### GetType

`func (o *ServiceInstance) GetType() ServiceType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *ServiceInstance) GetTypeOk() (*ServiceType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *ServiceInstance) SetType(v ServiceType)`

SetType sets Type field to given value.

### HasType

`func (o *ServiceInstance) HasType() bool`

HasType returns a boolean if a field has been set.

### GetCreatedAt

`func (o *ServiceInstance) GetCreatedAt() time.Time`

GetCreatedAt returns the CreatedAt field if non-nil, zero value otherwise.

### GetCreatedAtOk

`func (o *ServiceInstance) GetCreatedAtOk() (*time.Time, bool)`

GetCreatedAtOk returns a tuple with the CreatedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreatedAt

`func (o *ServiceInstance) SetCreatedAt(v time.Time)`

SetCreatedAt sets CreatedAt field to given value.

### HasCreatedAt

`func (o *ServiceInstance) HasCreatedAt() bool`

HasCreatedAt returns a boolean if a field has been set.

### GetUpdatedAt

`func (o *ServiceInstance) GetUpdatedAt() time.Time`

GetUpdatedAt returns the UpdatedAt field if non-nil, zero value otherwise.

### GetUpdatedAtOk

`func (o *ServiceInstance) GetUpdatedAtOk() (*time.Time, bool)`

GetUpdatedAtOk returns a tuple with the UpdatedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUpdatedAt

`func (o *ServiceInstance) SetUpdatedAt(v time.Time)`

SetUpdatedAt sets UpdatedAt field to given value.

### HasUpdatedAt

`func (o *ServiceInstance) HasUpdatedAt() bool`

HasUpdatedAt returns a boolean if a field has been set.

### GetEvents

`func (o *ServiceInstance) GetEvents() []ServiceInstanceTimestampedEvent`

GetEvents returns the Events field if non-nil, zero value otherwise.

### GetEventsOk

`func (o *ServiceInstance) GetEventsOk() (*[]ServiceInstanceTimestampedEvent, bool)`

GetEventsOk returns a tuple with the Events field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEvents

`func (o *ServiceInstance) SetEvents(v []ServiceInstanceTimestampedEvent)`

SetEvents sets Events field to given value.

### HasEvents

`func (o *ServiceInstance) HasEvents() bool`

HasEvents returns a boolean if a field has been set.

### GetConfig

`func (o *ServiceInstance) GetConfig() ServerConfig`

GetConfig returns the Config field if non-nil, zero value otherwise.

### GetConfigOk

`func (o *ServiceInstance) GetConfigOk() (*ServerConfig, bool)`

GetConfigOk returns a tuple with the Config field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConfig

`func (o *ServiceInstance) SetConfig(v ServerConfig)`

SetConfig sets Config field to given value.

### HasConfig

`func (o *ServiceInstance) HasConfig() bool`

HasConfig returns a boolean if a field has been set.

### GetProps

`func (o *ServiceInstance) GetProps() map[string]map[string]interface{}`

GetProps returns the Props field if non-nil, zero value otherwise.

### GetPropsOk

`func (o *ServiceInstance) GetPropsOk() (*map[string]map[string]interface{}, bool)`

GetPropsOk returns a tuple with the Props field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetProps

`func (o *ServiceInstance) SetProps(v map[string]map[string]interface{})`

SetProps sets Props field to given value.

### HasProps

`func (o *ServiceInstance) HasProps() bool`

HasProps returns a boolean if a field has been set.

### GetSeqId

`func (o *ServiceInstance) GetSeqId() int64`

GetSeqId returns the SeqId field if non-nil, zero value otherwise.

### GetSeqIdOk

`func (o *ServiceInstance) GetSeqIdOk() (*int64, bool)`

GetSeqIdOk returns a tuple with the SeqId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSeqId

`func (o *ServiceInstance) SetSeqId(v int64)`

SetSeqId sets SeqId field to given value.

### HasSeqId

`func (o *ServiceInstance) HasSeqId() bool`

HasSeqId returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


