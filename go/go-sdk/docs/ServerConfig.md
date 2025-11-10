# ServerConfig

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**WorkerTaskRestartStrategy** | Pointer to [**NullableWorkerTaskRestartStrategy**](WorkerTaskRestartStrategy.md) |  | [optional] 
**TerminationGracePeriod** | **string** |  | [default to "5m"]
**Liveness** | Pointer to [**ServerConfigLiveness**](ServerConfigLiveness.md) |  | [optional] 

## Methods

### NewServerConfig

`func NewServerConfig(terminationGracePeriod string, ) *ServerConfig`

NewServerConfig instantiates a new ServerConfig object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewServerConfigWithDefaults

`func NewServerConfigWithDefaults() *ServerConfig`

NewServerConfigWithDefaults instantiates a new ServerConfig object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetWorkerTaskRestartStrategy

`func (o *ServerConfig) GetWorkerTaskRestartStrategy() WorkerTaskRestartStrategy`

GetWorkerTaskRestartStrategy returns the WorkerTaskRestartStrategy field if non-nil, zero value otherwise.

### GetWorkerTaskRestartStrategyOk

`func (o *ServerConfig) GetWorkerTaskRestartStrategyOk() (*WorkerTaskRestartStrategy, bool)`

GetWorkerTaskRestartStrategyOk returns a tuple with the WorkerTaskRestartStrategy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerTaskRestartStrategy

`func (o *ServerConfig) SetWorkerTaskRestartStrategy(v WorkerTaskRestartStrategy)`

SetWorkerTaskRestartStrategy sets WorkerTaskRestartStrategy field to given value.

### HasWorkerTaskRestartStrategy

`func (o *ServerConfig) HasWorkerTaskRestartStrategy() bool`

HasWorkerTaskRestartStrategy returns a boolean if a field has been set.

### SetWorkerTaskRestartStrategyNil

`func (o *ServerConfig) SetWorkerTaskRestartStrategyNil(b bool)`

 SetWorkerTaskRestartStrategyNil sets the value for WorkerTaskRestartStrategy to be an explicit nil

### UnsetWorkerTaskRestartStrategy
`func (o *ServerConfig) UnsetWorkerTaskRestartStrategy()`

UnsetWorkerTaskRestartStrategy ensures that no value is present for WorkerTaskRestartStrategy, not even an explicit nil
### GetTerminationGracePeriod

`func (o *ServerConfig) GetTerminationGracePeriod() string`

GetTerminationGracePeriod returns the TerminationGracePeriod field if non-nil, zero value otherwise.

### GetTerminationGracePeriodOk

`func (o *ServerConfig) GetTerminationGracePeriodOk() (*string, bool)`

GetTerminationGracePeriodOk returns a tuple with the TerminationGracePeriod field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTerminationGracePeriod

`func (o *ServerConfig) SetTerminationGracePeriod(v string)`

SetTerminationGracePeriod sets TerminationGracePeriod field to given value.


### GetLiveness

`func (o *ServerConfig) GetLiveness() ServerConfigLiveness`

GetLiveness returns the Liveness field if non-nil, zero value otherwise.

### GetLivenessOk

`func (o *ServerConfig) GetLivenessOk() (*ServerConfigLiveness, bool)`

GetLivenessOk returns a tuple with the Liveness field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLiveness

`func (o *ServerConfig) SetLiveness(v ServerConfigLiveness)`

SetLiveness sets Liveness field to given value.

### HasLiveness

`func (o *ServerConfig) HasLiveness() bool`

HasLiveness returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


