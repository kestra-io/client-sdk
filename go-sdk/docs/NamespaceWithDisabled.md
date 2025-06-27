# NamespaceWithDisabled

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Deleted** | **bool** |  | 
**AllowedTriggers** | Pointer to [**[]NamespaceAllowedTrigger**](NamespaceAllowedTrigger.md) |  | [optional] 
**StorageIsolation** | Pointer to [**Isolation**](Isolation.md) |  | [optional] 
**SecretIsolation** | Pointer to [**Isolation**](Isolation.md) |  | [optional] 
**Description** | **string** |  | 
**Variables** | **map[string]interface{}** |  | 
**PluginDefaults** | [**[]PluginDefault**](PluginDefault.md) |  | 
**AllowedNamespaces** | [**[]NamespaceAllowedNamespace**](NamespaceAllowedNamespace.md) |  | 
**WorkerGroup** | [**WorkerGroup**](WorkerGroup.md) |  | 
**StorageType** | Pointer to **string** |  | [optional] 
**StorageConfiguration** | Pointer to **map[string]interface{}** |  | [optional] 
**SecretType** | Pointer to **string** |  | [optional] 
**SecretReadOnly** | Pointer to **bool** |  | [optional] 
**SecretConfiguration** | Pointer to **map[string]interface{}** |  | [optional] 
**OutputsInInternalStorage** | Pointer to **bool** |  | [optional] 
**Disabled** | **bool** |  | 

## Methods

### NewNamespaceWithDisabled

`func NewNamespaceWithDisabled(id string, deleted bool, description string, variables map[string]interface{}, pluginDefaults []PluginDefault, allowedNamespaces []NamespaceAllowedNamespace, workerGroup WorkerGroup, disabled bool, ) *NamespaceWithDisabled`

NewNamespaceWithDisabled instantiates a new NamespaceWithDisabled object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewNamespaceWithDisabledWithDefaults

`func NewNamespaceWithDisabledWithDefaults() *NamespaceWithDisabled`

NewNamespaceWithDisabledWithDefaults instantiates a new NamespaceWithDisabled object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *NamespaceWithDisabled) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *NamespaceWithDisabled) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *NamespaceWithDisabled) SetId(v string)`

SetId sets Id field to given value.


### GetDeleted

`func (o *NamespaceWithDisabled) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *NamespaceWithDisabled) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *NamespaceWithDisabled) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetAllowedTriggers

`func (o *NamespaceWithDisabled) GetAllowedTriggers() []NamespaceAllowedTrigger`

GetAllowedTriggers returns the AllowedTriggers field if non-nil, zero value otherwise.

### GetAllowedTriggersOk

`func (o *NamespaceWithDisabled) GetAllowedTriggersOk() (*[]NamespaceAllowedTrigger, bool)`

GetAllowedTriggersOk returns a tuple with the AllowedTriggers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedTriggers

`func (o *NamespaceWithDisabled) SetAllowedTriggers(v []NamespaceAllowedTrigger)`

SetAllowedTriggers sets AllowedTriggers field to given value.

### HasAllowedTriggers

`func (o *NamespaceWithDisabled) HasAllowedTriggers() bool`

HasAllowedTriggers returns a boolean if a field has been set.

### GetStorageIsolation

`func (o *NamespaceWithDisabled) GetStorageIsolation() Isolation`

GetStorageIsolation returns the StorageIsolation field if non-nil, zero value otherwise.

### GetStorageIsolationOk

`func (o *NamespaceWithDisabled) GetStorageIsolationOk() (*Isolation, bool)`

GetStorageIsolationOk returns a tuple with the StorageIsolation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageIsolation

`func (o *NamespaceWithDisabled) SetStorageIsolation(v Isolation)`

SetStorageIsolation sets StorageIsolation field to given value.

### HasStorageIsolation

`func (o *NamespaceWithDisabled) HasStorageIsolation() bool`

HasStorageIsolation returns a boolean if a field has been set.

### GetSecretIsolation

`func (o *NamespaceWithDisabled) GetSecretIsolation() Isolation`

GetSecretIsolation returns the SecretIsolation field if non-nil, zero value otherwise.

### GetSecretIsolationOk

`func (o *NamespaceWithDisabled) GetSecretIsolationOk() (*Isolation, bool)`

GetSecretIsolationOk returns a tuple with the SecretIsolation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretIsolation

`func (o *NamespaceWithDisabled) SetSecretIsolation(v Isolation)`

SetSecretIsolation sets SecretIsolation field to given value.

### HasSecretIsolation

`func (o *NamespaceWithDisabled) HasSecretIsolation() bool`

HasSecretIsolation returns a boolean if a field has been set.

### GetDescription

`func (o *NamespaceWithDisabled) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *NamespaceWithDisabled) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *NamespaceWithDisabled) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetVariables

`func (o *NamespaceWithDisabled) GetVariables() map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *NamespaceWithDisabled) GetVariablesOk() (*map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *NamespaceWithDisabled) SetVariables(v map[string]interface{})`

SetVariables sets Variables field to given value.


### GetPluginDefaults

`func (o *NamespaceWithDisabled) GetPluginDefaults() []PluginDefault`

GetPluginDefaults returns the PluginDefaults field if non-nil, zero value otherwise.

### GetPluginDefaultsOk

`func (o *NamespaceWithDisabled) GetPluginDefaultsOk() (*[]PluginDefault, bool)`

GetPluginDefaultsOk returns a tuple with the PluginDefaults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginDefaults

`func (o *NamespaceWithDisabled) SetPluginDefaults(v []PluginDefault)`

SetPluginDefaults sets PluginDefaults field to given value.


### GetAllowedNamespaces

`func (o *NamespaceWithDisabled) GetAllowedNamespaces() []NamespaceAllowedNamespace`

GetAllowedNamespaces returns the AllowedNamespaces field if non-nil, zero value otherwise.

### GetAllowedNamespacesOk

`func (o *NamespaceWithDisabled) GetAllowedNamespacesOk() (*[]NamespaceAllowedNamespace, bool)`

GetAllowedNamespacesOk returns a tuple with the AllowedNamespaces field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedNamespaces

`func (o *NamespaceWithDisabled) SetAllowedNamespaces(v []NamespaceAllowedNamespace)`

SetAllowedNamespaces sets AllowedNamespaces field to given value.


### GetWorkerGroup

`func (o *NamespaceWithDisabled) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *NamespaceWithDisabled) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *NamespaceWithDisabled) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.


### GetStorageType

`func (o *NamespaceWithDisabled) GetStorageType() string`

GetStorageType returns the StorageType field if non-nil, zero value otherwise.

### GetStorageTypeOk

`func (o *NamespaceWithDisabled) GetStorageTypeOk() (*string, bool)`

GetStorageTypeOk returns a tuple with the StorageType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageType

`func (o *NamespaceWithDisabled) SetStorageType(v string)`

SetStorageType sets StorageType field to given value.

### HasStorageType

`func (o *NamespaceWithDisabled) HasStorageType() bool`

HasStorageType returns a boolean if a field has been set.

### GetStorageConfiguration

`func (o *NamespaceWithDisabled) GetStorageConfiguration() map[string]interface{}`

GetStorageConfiguration returns the StorageConfiguration field if non-nil, zero value otherwise.

### GetStorageConfigurationOk

`func (o *NamespaceWithDisabled) GetStorageConfigurationOk() (*map[string]interface{}, bool)`

GetStorageConfigurationOk returns a tuple with the StorageConfiguration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageConfiguration

`func (o *NamespaceWithDisabled) SetStorageConfiguration(v map[string]interface{})`

SetStorageConfiguration sets StorageConfiguration field to given value.

### HasStorageConfiguration

`func (o *NamespaceWithDisabled) HasStorageConfiguration() bool`

HasStorageConfiguration returns a boolean if a field has been set.

### GetSecretType

`func (o *NamespaceWithDisabled) GetSecretType() string`

GetSecretType returns the SecretType field if non-nil, zero value otherwise.

### GetSecretTypeOk

`func (o *NamespaceWithDisabled) GetSecretTypeOk() (*string, bool)`

GetSecretTypeOk returns a tuple with the SecretType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretType

`func (o *NamespaceWithDisabled) SetSecretType(v string)`

SetSecretType sets SecretType field to given value.

### HasSecretType

`func (o *NamespaceWithDisabled) HasSecretType() bool`

HasSecretType returns a boolean if a field has been set.

### GetSecretReadOnly

`func (o *NamespaceWithDisabled) GetSecretReadOnly() bool`

GetSecretReadOnly returns the SecretReadOnly field if non-nil, zero value otherwise.

### GetSecretReadOnlyOk

`func (o *NamespaceWithDisabled) GetSecretReadOnlyOk() (*bool, bool)`

GetSecretReadOnlyOk returns a tuple with the SecretReadOnly field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretReadOnly

`func (o *NamespaceWithDisabled) SetSecretReadOnly(v bool)`

SetSecretReadOnly sets SecretReadOnly field to given value.

### HasSecretReadOnly

`func (o *NamespaceWithDisabled) HasSecretReadOnly() bool`

HasSecretReadOnly returns a boolean if a field has been set.

### GetSecretConfiguration

`func (o *NamespaceWithDisabled) GetSecretConfiguration() map[string]interface{}`

GetSecretConfiguration returns the SecretConfiguration field if non-nil, zero value otherwise.

### GetSecretConfigurationOk

`func (o *NamespaceWithDisabled) GetSecretConfigurationOk() (*map[string]interface{}, bool)`

GetSecretConfigurationOk returns a tuple with the SecretConfiguration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretConfiguration

`func (o *NamespaceWithDisabled) SetSecretConfiguration(v map[string]interface{})`

SetSecretConfiguration sets SecretConfiguration field to given value.

### HasSecretConfiguration

`func (o *NamespaceWithDisabled) HasSecretConfiguration() bool`

HasSecretConfiguration returns a boolean if a field has been set.

### GetOutputsInInternalStorage

`func (o *NamespaceWithDisabled) GetOutputsInInternalStorage() bool`

GetOutputsInInternalStorage returns the OutputsInInternalStorage field if non-nil, zero value otherwise.

### GetOutputsInInternalStorageOk

`func (o *NamespaceWithDisabled) GetOutputsInInternalStorageOk() (*bool, bool)`

GetOutputsInInternalStorageOk returns a tuple with the OutputsInInternalStorage field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputsInInternalStorage

`func (o *NamespaceWithDisabled) SetOutputsInInternalStorage(v bool)`

SetOutputsInInternalStorage sets OutputsInInternalStorage field to given value.

### HasOutputsInInternalStorage

`func (o *NamespaceWithDisabled) HasOutputsInInternalStorage() bool`

HasOutputsInInternalStorage returns a boolean if a field has been set.

### GetDisabled

`func (o *NamespaceWithDisabled) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *NamespaceWithDisabled) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *NamespaceWithDisabled) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


