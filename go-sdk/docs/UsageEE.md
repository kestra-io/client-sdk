# UsageEE

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Groups** | Pointer to [**GroupUsage**](GroupUsage.md) |  | [optional] 
**Users** | Pointer to [**UserUsage**](UserUsage.md) |  | [optional] 
**Roles** | Pointer to [**RoleUsage**](RoleUsage.md) |  | [optional] 
**Namespaces** | Pointer to [**NamespaceUsage**](NamespaceUsage.md) |  | [optional] 
**Tenants** | Pointer to [**TenantUsage**](TenantUsage.md) |  | [optional] 
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

### NewUsageEE

`func NewUsageEE(uuid string, startUuid string, instanceUuid string, serverType ServerType, version string, zoneId string, startTime time.Time, ) *UsageEE`

NewUsageEE instantiates a new UsageEE object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUsageEEWithDefaults

`func NewUsageEEWithDefaults() *UsageEE`

NewUsageEEWithDefaults instantiates a new UsageEE object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetGroups

`func (o *UsageEE) GetGroups() GroupUsage`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *UsageEE) GetGroupsOk() (*GroupUsage, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *UsageEE) SetGroups(v GroupUsage)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *UsageEE) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetUsers

`func (o *UsageEE) GetUsers() UserUsage`

GetUsers returns the Users field if non-nil, zero value otherwise.

### GetUsersOk

`func (o *UsageEE) GetUsersOk() (*UserUsage, bool)`

GetUsersOk returns a tuple with the Users field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsers

`func (o *UsageEE) SetUsers(v UserUsage)`

SetUsers sets Users field to given value.

### HasUsers

`func (o *UsageEE) HasUsers() bool`

HasUsers returns a boolean if a field has been set.

### GetRoles

`func (o *UsageEE) GetRoles() RoleUsage`

GetRoles returns the Roles field if non-nil, zero value otherwise.

### GetRolesOk

`func (o *UsageEE) GetRolesOk() (*RoleUsage, bool)`

GetRolesOk returns a tuple with the Roles field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRoles

`func (o *UsageEE) SetRoles(v RoleUsage)`

SetRoles sets Roles field to given value.

### HasRoles

`func (o *UsageEE) HasRoles() bool`

HasRoles returns a boolean if a field has been set.

### GetNamespaces

`func (o *UsageEE) GetNamespaces() NamespaceUsage`

GetNamespaces returns the Namespaces field if non-nil, zero value otherwise.

### GetNamespacesOk

`func (o *UsageEE) GetNamespacesOk() (*NamespaceUsage, bool)`

GetNamespacesOk returns a tuple with the Namespaces field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespaces

`func (o *UsageEE) SetNamespaces(v NamespaceUsage)`

SetNamespaces sets Namespaces field to given value.

### HasNamespaces

`func (o *UsageEE) HasNamespaces() bool`

HasNamespaces returns a boolean if a field has been set.

### GetTenants

`func (o *UsageEE) GetTenants() TenantUsage`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *UsageEE) GetTenantsOk() (*TenantUsage, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *UsageEE) SetTenants(v TenantUsage)`

SetTenants sets Tenants field to given value.

### HasTenants

`func (o *UsageEE) HasTenants() bool`

HasTenants returns a boolean if a field has been set.

### GetUuid

`func (o *UsageEE) GetUuid() string`

GetUuid returns the Uuid field if non-nil, zero value otherwise.

### GetUuidOk

`func (o *UsageEE) GetUuidOk() (*string, bool)`

GetUuidOk returns a tuple with the Uuid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUuid

`func (o *UsageEE) SetUuid(v string)`

SetUuid sets Uuid field to given value.


### GetStartUuid

`func (o *UsageEE) GetStartUuid() string`

GetStartUuid returns the StartUuid field if non-nil, zero value otherwise.

### GetStartUuidOk

`func (o *UsageEE) GetStartUuidOk() (*string, bool)`

GetStartUuidOk returns a tuple with the StartUuid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartUuid

`func (o *UsageEE) SetStartUuid(v string)`

SetStartUuid sets StartUuid field to given value.


### GetInstanceUuid

`func (o *UsageEE) GetInstanceUuid() string`

GetInstanceUuid returns the InstanceUuid field if non-nil, zero value otherwise.

### GetInstanceUuidOk

`func (o *UsageEE) GetInstanceUuidOk() (*string, bool)`

GetInstanceUuidOk returns a tuple with the InstanceUuid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInstanceUuid

`func (o *UsageEE) SetInstanceUuid(v string)`

SetInstanceUuid sets InstanceUuid field to given value.


### GetServerType

`func (o *UsageEE) GetServerType() ServerType`

GetServerType returns the ServerType field if non-nil, zero value otherwise.

### GetServerTypeOk

`func (o *UsageEE) GetServerTypeOk() (*ServerType, bool)`

GetServerTypeOk returns a tuple with the ServerType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetServerType

`func (o *UsageEE) SetServerType(v ServerType)`

SetServerType sets ServerType field to given value.


### GetVersion

`func (o *UsageEE) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *UsageEE) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *UsageEE) SetVersion(v string)`

SetVersion sets Version field to given value.


### GetZoneId

`func (o *UsageEE) GetZoneId() string`

GetZoneId returns the ZoneId field if non-nil, zero value otherwise.

### GetZoneIdOk

`func (o *UsageEE) GetZoneIdOk() (*string, bool)`

GetZoneIdOk returns a tuple with the ZoneId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetZoneId

`func (o *UsageEE) SetZoneId(v string)`

SetZoneId sets ZoneId field to given value.


### GetUri

`func (o *UsageEE) GetUri() string`

GetUri returns the Uri field if non-nil, zero value otherwise.

### GetUriOk

`func (o *UsageEE) GetUriOk() (*string, bool)`

GetUriOk returns a tuple with the Uri field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUri

`func (o *UsageEE) SetUri(v string)`

SetUri sets Uri field to given value.

### HasUri

`func (o *UsageEE) HasUri() bool`

HasUri returns a boolean if a field has been set.

### SetUriNil

`func (o *UsageEE) SetUriNil(b bool)`

 SetUriNil sets the value for Uri to be an explicit nil

### UnsetUri
`func (o *UsageEE) UnsetUri()`

UnsetUri ensures that no value is present for Uri, not even an explicit nil
### GetEnvironments

`func (o *UsageEE) GetEnvironments() []string`

GetEnvironments returns the Environments field if non-nil, zero value otherwise.

### GetEnvironmentsOk

`func (o *UsageEE) GetEnvironmentsOk() (*[]string, bool)`

GetEnvironmentsOk returns a tuple with the Environments field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnvironments

`func (o *UsageEE) SetEnvironments(v []string)`

SetEnvironments sets Environments field to given value.

### HasEnvironments

`func (o *UsageEE) HasEnvironments() bool`

HasEnvironments returns a boolean if a field has been set.

### SetEnvironmentsNil

`func (o *UsageEE) SetEnvironmentsNil(b bool)`

 SetEnvironmentsNil sets the value for Environments to be an explicit nil

### UnsetEnvironments
`func (o *UsageEE) UnsetEnvironments()`

UnsetEnvironments ensures that no value is present for Environments, not even an explicit nil
### GetStartTime

`func (o *UsageEE) GetStartTime() time.Time`

GetStartTime returns the StartTime field if non-nil, zero value otherwise.

### GetStartTimeOk

`func (o *UsageEE) GetStartTimeOk() (*time.Time, bool)`

GetStartTimeOk returns a tuple with the StartTime field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartTime

`func (o *UsageEE) SetStartTime(v time.Time)`

SetStartTime sets StartTime field to given value.


### GetHost

`func (o *UsageEE) GetHost() HostUsage`

GetHost returns the Host field if non-nil, zero value otherwise.

### GetHostOk

`func (o *UsageEE) GetHostOk() (*HostUsage, bool)`

GetHostOk returns a tuple with the Host field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHost

`func (o *UsageEE) SetHost(v HostUsage)`

SetHost sets Host field to given value.

### HasHost

`func (o *UsageEE) HasHost() bool`

HasHost returns a boolean if a field has been set.

### GetConfigurations

`func (o *UsageEE) GetConfigurations() ConfigurationUsage`

GetConfigurations returns the Configurations field if non-nil, zero value otherwise.

### GetConfigurationsOk

`func (o *UsageEE) GetConfigurationsOk() (*ConfigurationUsage, bool)`

GetConfigurationsOk returns a tuple with the Configurations field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConfigurations

`func (o *UsageEE) SetConfigurations(v ConfigurationUsage)`

SetConfigurations sets Configurations field to given value.

### HasConfigurations

`func (o *UsageEE) HasConfigurations() bool`

HasConfigurations returns a boolean if a field has been set.

### GetPlugins

`func (o *UsageEE) GetPlugins() []PluginUsage`

GetPlugins returns the Plugins field if non-nil, zero value otherwise.

### GetPluginsOk

`func (o *UsageEE) GetPluginsOk() (*[]PluginUsage, bool)`

GetPluginsOk returns a tuple with the Plugins field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPlugins

`func (o *UsageEE) SetPlugins(v []PluginUsage)`

SetPlugins sets Plugins field to given value.

### HasPlugins

`func (o *UsageEE) HasPlugins() bool`

HasPlugins returns a boolean if a field has been set.

### GetFlows

`func (o *UsageEE) GetFlows() FlowUsage`

GetFlows returns the Flows field if non-nil, zero value otherwise.

### GetFlowsOk

`func (o *UsageEE) GetFlowsOk() (*FlowUsage, bool)`

GetFlowsOk returns a tuple with the Flows field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlows

`func (o *UsageEE) SetFlows(v FlowUsage)`

SetFlows sets Flows field to given value.

### HasFlows

`func (o *UsageEE) HasFlows() bool`

HasFlows returns a boolean if a field has been set.

### GetExecutions

`func (o *UsageEE) GetExecutions() ExecutionUsage`

GetExecutions returns the Executions field if non-nil, zero value otherwise.

### GetExecutionsOk

`func (o *UsageEE) GetExecutionsOk() (*ExecutionUsage, bool)`

GetExecutionsOk returns a tuple with the Executions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutions

`func (o *UsageEE) SetExecutions(v ExecutionUsage)`

SetExecutions sets Executions field to given value.

### HasExecutions

`func (o *UsageEE) HasExecutions() bool`

HasExecutions returns a boolean if a field has been set.

### GetServices

`func (o *UsageEE) GetServices() ServiceUsage`

GetServices returns the Services field if non-nil, zero value otherwise.

### GetServicesOk

`func (o *UsageEE) GetServicesOk() (*ServiceUsage, bool)`

GetServicesOk returns a tuple with the Services field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetServices

`func (o *UsageEE) SetServices(v ServiceUsage)`

SetServices sets Services field to given value.

### HasServices

`func (o *UsageEE) HasServices() bool`

HasServices returns a boolean if a field has been set.

### SetServicesNil

`func (o *UsageEE) SetServicesNil(b bool)`

 SetServicesNil sets the value for Services to be an explicit nil

### UnsetServices
`func (o *UsageEE) UnsetServices()`

UnsetServices ensures that no value is present for Services, not even an explicit nil
### GetPluginMetrics

`func (o *UsageEE) GetPluginMetrics() []PluginMetric`

GetPluginMetrics returns the PluginMetrics field if non-nil, zero value otherwise.

### GetPluginMetricsOk

`func (o *UsageEE) GetPluginMetricsOk() (*[]PluginMetric, bool)`

GetPluginMetricsOk returns a tuple with the PluginMetrics field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginMetrics

`func (o *UsageEE) SetPluginMetrics(v []PluginMetric)`

SetPluginMetrics sets PluginMetrics field to given value.

### HasPluginMetrics

`func (o *UsageEE) HasPluginMetrics() bool`

HasPluginMetrics returns a boolean if a field has been set.

### SetPluginMetricsNil

`func (o *UsageEE) SetPluginMetricsNil(b bool)`

 SetPluginMetricsNil sets the value for PluginMetrics to be an explicit nil

### UnsetPluginMetrics
`func (o *UsageEE) UnsetPluginMetrics()`

UnsetPluginMetrics ensures that no value is present for PluginMetrics, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


