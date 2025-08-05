# Usage

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Uuid** | **string** |  | 
**StartUuid** | **string** |  | 
**InstanceUuid** | **string** |  | 
**ServerType** | [**ServerType**](ServerType.md) |  | 
**Version** | **string** |  | 
**ZoneId** | **string** |  | 
**Uri** | Pointer to **NullableString** |  | [optional] 
**Environments** | Pointer to **[]string** |  | [optional] 
**StartTime** | **time.Time** |  | 
**Host** | Pointer to [**HostUsage**](HostUsage.md) |  | [optional] 
**Configurations** | Pointer to [**ConfigurationUsage**](ConfigurationUsage.md) |  | [optional] 
**Plugins** | Pointer to [**[]PluginUsage**](PluginUsage.md) |  | [optional] 
**Flows** | Pointer to [**FlowUsage**](FlowUsage.md) |  | [optional] 
**Executions** | Pointer to [**ExecutionUsage**](ExecutionUsage.md) |  | [optional] 
**Services** | Pointer to [**NullableServiceUsage**](ServiceUsage.md) |  | [optional] 
**PluginMetrics** | Pointer to [**[]PluginMetric**](PluginMetric.md) |  | [optional] 

## Methods

### NewUsage

`func NewUsage(uuid string, startUuid string, instanceUuid string, serverType ServerType, version string, zoneId string, startTime time.Time, ) *Usage`

NewUsage instantiates a new Usage object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUsageWithDefaults

`func NewUsageWithDefaults() *Usage`

NewUsageWithDefaults instantiates a new Usage object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUuid

`func (o *Usage) GetUuid() string`

GetUuid returns the Uuid field if non-nil, zero value otherwise.

### GetUuidOk

`func (o *Usage) GetUuidOk() (*string, bool)`

GetUuidOk returns a tuple with the Uuid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUuid

`func (o *Usage) SetUuid(v string)`

SetUuid sets Uuid field to given value.


### GetStartUuid

`func (o *Usage) GetStartUuid() string`

GetStartUuid returns the StartUuid field if non-nil, zero value otherwise.

### GetStartUuidOk

`func (o *Usage) GetStartUuidOk() (*string, bool)`

GetStartUuidOk returns a tuple with the StartUuid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartUuid

`func (o *Usage) SetStartUuid(v string)`

SetStartUuid sets StartUuid field to given value.


### GetInstanceUuid

`func (o *Usage) GetInstanceUuid() string`

GetInstanceUuid returns the InstanceUuid field if non-nil, zero value otherwise.

### GetInstanceUuidOk

`func (o *Usage) GetInstanceUuidOk() (*string, bool)`

GetInstanceUuidOk returns a tuple with the InstanceUuid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInstanceUuid

`func (o *Usage) SetInstanceUuid(v string)`

SetInstanceUuid sets InstanceUuid field to given value.


### GetServerType

`func (o *Usage) GetServerType() ServerType`

GetServerType returns the ServerType field if non-nil, zero value otherwise.

### GetServerTypeOk

`func (o *Usage) GetServerTypeOk() (*ServerType, bool)`

GetServerTypeOk returns a tuple with the ServerType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetServerType

`func (o *Usage) SetServerType(v ServerType)`

SetServerType sets ServerType field to given value.


### GetVersion

`func (o *Usage) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *Usage) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *Usage) SetVersion(v string)`

SetVersion sets Version field to given value.


### GetZoneId

`func (o *Usage) GetZoneId() string`

GetZoneId returns the ZoneId field if non-nil, zero value otherwise.

### GetZoneIdOk

`func (o *Usage) GetZoneIdOk() (*string, bool)`

GetZoneIdOk returns a tuple with the ZoneId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetZoneId

`func (o *Usage) SetZoneId(v string)`

SetZoneId sets ZoneId field to given value.


### GetUri

`func (o *Usage) GetUri() string`

GetUri returns the Uri field if non-nil, zero value otherwise.

### GetUriOk

`func (o *Usage) GetUriOk() (*string, bool)`

GetUriOk returns a tuple with the Uri field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUri

`func (o *Usage) SetUri(v string)`

SetUri sets Uri field to given value.

### HasUri

`func (o *Usage) HasUri() bool`

HasUri returns a boolean if a field has been set.

### SetUriNil

`func (o *Usage) SetUriNil(b bool)`

 SetUriNil sets the value for Uri to be an explicit nil

### UnsetUri
`func (o *Usage) UnsetUri()`

UnsetUri ensures that no value is present for Uri, not even an explicit nil
### GetEnvironments

`func (o *Usage) GetEnvironments() []string`

GetEnvironments returns the Environments field if non-nil, zero value otherwise.

### GetEnvironmentsOk

`func (o *Usage) GetEnvironmentsOk() (*[]string, bool)`

GetEnvironmentsOk returns a tuple with the Environments field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnvironments

`func (o *Usage) SetEnvironments(v []string)`

SetEnvironments sets Environments field to given value.

### HasEnvironments

`func (o *Usage) HasEnvironments() bool`

HasEnvironments returns a boolean if a field has been set.

### SetEnvironmentsNil

`func (o *Usage) SetEnvironmentsNil(b bool)`

 SetEnvironmentsNil sets the value for Environments to be an explicit nil

### UnsetEnvironments
`func (o *Usage) UnsetEnvironments()`

UnsetEnvironments ensures that no value is present for Environments, not even an explicit nil
### GetStartTime

`func (o *Usage) GetStartTime() time.Time`

GetStartTime returns the StartTime field if non-nil, zero value otherwise.

### GetStartTimeOk

`func (o *Usage) GetStartTimeOk() (*time.Time, bool)`

GetStartTimeOk returns a tuple with the StartTime field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartTime

`func (o *Usage) SetStartTime(v time.Time)`

SetStartTime sets StartTime field to given value.


### GetHost

`func (o *Usage) GetHost() HostUsage`

GetHost returns the Host field if non-nil, zero value otherwise.

### GetHostOk

`func (o *Usage) GetHostOk() (*HostUsage, bool)`

GetHostOk returns a tuple with the Host field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHost

`func (o *Usage) SetHost(v HostUsage)`

SetHost sets Host field to given value.

### HasHost

`func (o *Usage) HasHost() bool`

HasHost returns a boolean if a field has been set.

### GetConfigurations

`func (o *Usage) GetConfigurations() ConfigurationUsage`

GetConfigurations returns the Configurations field if non-nil, zero value otherwise.

### GetConfigurationsOk

`func (o *Usage) GetConfigurationsOk() (*ConfigurationUsage, bool)`

GetConfigurationsOk returns a tuple with the Configurations field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConfigurations

`func (o *Usage) SetConfigurations(v ConfigurationUsage)`

SetConfigurations sets Configurations field to given value.

### HasConfigurations

`func (o *Usage) HasConfigurations() bool`

HasConfigurations returns a boolean if a field has been set.

### GetPlugins

`func (o *Usage) GetPlugins() []PluginUsage`

GetPlugins returns the Plugins field if non-nil, zero value otherwise.

### GetPluginsOk

`func (o *Usage) GetPluginsOk() (*[]PluginUsage, bool)`

GetPluginsOk returns a tuple with the Plugins field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPlugins

`func (o *Usage) SetPlugins(v []PluginUsage)`

SetPlugins sets Plugins field to given value.

### HasPlugins

`func (o *Usage) HasPlugins() bool`

HasPlugins returns a boolean if a field has been set.

### GetFlows

`func (o *Usage) GetFlows() FlowUsage`

GetFlows returns the Flows field if non-nil, zero value otherwise.

### GetFlowsOk

`func (o *Usage) GetFlowsOk() (*FlowUsage, bool)`

GetFlowsOk returns a tuple with the Flows field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlows

`func (o *Usage) SetFlows(v FlowUsage)`

SetFlows sets Flows field to given value.

### HasFlows

`func (o *Usage) HasFlows() bool`

HasFlows returns a boolean if a field has been set.

### GetExecutions

`func (o *Usage) GetExecutions() ExecutionUsage`

GetExecutions returns the Executions field if non-nil, zero value otherwise.

### GetExecutionsOk

`func (o *Usage) GetExecutionsOk() (*ExecutionUsage, bool)`

GetExecutionsOk returns a tuple with the Executions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutions

`func (o *Usage) SetExecutions(v ExecutionUsage)`

SetExecutions sets Executions field to given value.

### HasExecutions

`func (o *Usage) HasExecutions() bool`

HasExecutions returns a boolean if a field has been set.

### GetServices

`func (o *Usage) GetServices() ServiceUsage`

GetServices returns the Services field if non-nil, zero value otherwise.

### GetServicesOk

`func (o *Usage) GetServicesOk() (*ServiceUsage, bool)`

GetServicesOk returns a tuple with the Services field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetServices

`func (o *Usage) SetServices(v ServiceUsage)`

SetServices sets Services field to given value.

### HasServices

`func (o *Usage) HasServices() bool`

HasServices returns a boolean if a field has been set.

### SetServicesNil

`func (o *Usage) SetServicesNil(b bool)`

 SetServicesNil sets the value for Services to be an explicit nil

### UnsetServices
`func (o *Usage) UnsetServices()`

UnsetServices ensures that no value is present for Services, not even an explicit nil
### GetPluginMetrics

`func (o *Usage) GetPluginMetrics() []PluginMetric`

GetPluginMetrics returns the PluginMetrics field if non-nil, zero value otherwise.

### GetPluginMetricsOk

`func (o *Usage) GetPluginMetricsOk() (*[]PluginMetric, bool)`

GetPluginMetricsOk returns a tuple with the PluginMetrics field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginMetrics

`func (o *Usage) SetPluginMetrics(v []PluginMetric)`

SetPluginMetrics sets PluginMetrics field to given value.

### HasPluginMetrics

`func (o *Usage) HasPluginMetrics() bool`

HasPluginMetrics returns a boolean if a field has been set.

### SetPluginMetricsNil

`func (o *Usage) SetPluginMetricsNil(b bool)`

 SetPluginMetricsNil sets the value for PluginMetrics to be an explicit nil

### UnsetPluginMetrics
`func (o *Usage) UnsetPluginMetrics()`

UnsetPluginMetrics ensures that no value is present for PluginMetrics, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


