# Namespace

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Deleted** | **bool** |  | 
**AllowedTriggers** | Pointer to [**[]NamespaceAllowedTrigger**](NamespaceAllowedTrigger.md) |  | [optional] 
**StorageIsolation** | Pointer to [**Isolation**](Isolation.md) |  | [optional] 
**SecretIsolation** | Pointer to [**Isolation**](Isolation.md) |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Variables** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**PluginDefaults** | Pointer to [**[]PluginDefault**](PluginDefault.md) |  | [optional] 
**AllowedNamespaces** | Pointer to [**[]NamespaceAllowedNamespace**](NamespaceAllowedNamespace.md) |  | [optional] 
**WorkerGroup** | Pointer to [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**StorageType** | Pointer to **string** |  | [optional] 
**StorageConfiguration** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**SecretType** | Pointer to **string** |  | [optional] 
**SecretReadOnly** | Pointer to **bool** |  | [optional] 
**SecretConfiguration** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**OutputsInInternalStorage** | Pointer to **bool** |  | [optional] 

## Methods

### NewNamespace

`func NewNamespace(id string, deleted bool, ) *Namespace`

NewNamespace instantiates a new Namespace object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewNamespaceWithDefaults

`func NewNamespaceWithDefaults() *Namespace`

NewNamespaceWithDefaults instantiates a new Namespace object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *Namespace) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Namespace) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Namespace) SetId(v string)`

SetId sets Id field to given value.


### GetDeleted

`func (o *Namespace) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *Namespace) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *Namespace) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetAllowedTriggers

`func (o *Namespace) GetAllowedTriggers() []NamespaceAllowedTrigger`

GetAllowedTriggers returns the AllowedTriggers field if non-nil, zero value otherwise.

### GetAllowedTriggersOk

`func (o *Namespace) GetAllowedTriggersOk() (*[]NamespaceAllowedTrigger, bool)`

GetAllowedTriggersOk returns a tuple with the AllowedTriggers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedTriggers

`func (o *Namespace) SetAllowedTriggers(v []NamespaceAllowedTrigger)`

SetAllowedTriggers sets AllowedTriggers field to given value.

### HasAllowedTriggers

`func (o *Namespace) HasAllowedTriggers() bool`

HasAllowedTriggers returns a boolean if a field has been set.

### GetStorageIsolation

`func (o *Namespace) GetStorageIsolation() Isolation`

GetStorageIsolation returns the StorageIsolation field if non-nil, zero value otherwise.

### GetStorageIsolationOk

`func (o *Namespace) GetStorageIsolationOk() (*Isolation, bool)`

GetStorageIsolationOk returns a tuple with the StorageIsolation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageIsolation

`func (o *Namespace) SetStorageIsolation(v Isolation)`

SetStorageIsolation sets StorageIsolation field to given value.

### HasStorageIsolation

`func (o *Namespace) HasStorageIsolation() bool`

HasStorageIsolation returns a boolean if a field has been set.

### GetSecretIsolation

`func (o *Namespace) GetSecretIsolation() Isolation`

GetSecretIsolation returns the SecretIsolation field if non-nil, zero value otherwise.

### GetSecretIsolationOk

`func (o *Namespace) GetSecretIsolationOk() (*Isolation, bool)`

GetSecretIsolationOk returns a tuple with the SecretIsolation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretIsolation

`func (o *Namespace) SetSecretIsolation(v Isolation)`

SetSecretIsolation sets SecretIsolation field to given value.

### HasSecretIsolation

`func (o *Namespace) HasSecretIsolation() bool`

HasSecretIsolation returns a boolean if a field has been set.

### GetDescription

`func (o *Namespace) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Namespace) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Namespace) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Namespace) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetVariables

`func (o *Namespace) GetVariables() map[string]map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *Namespace) GetVariablesOk() (*map[string]map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *Namespace) SetVariables(v map[string]map[string]interface{})`

SetVariables sets Variables field to given value.

### HasVariables

`func (o *Namespace) HasVariables() bool`

HasVariables returns a boolean if a field has been set.

### GetPluginDefaults

`func (o *Namespace) GetPluginDefaults() []PluginDefault`

GetPluginDefaults returns the PluginDefaults field if non-nil, zero value otherwise.

### GetPluginDefaultsOk

`func (o *Namespace) GetPluginDefaultsOk() (*[]PluginDefault, bool)`

GetPluginDefaultsOk returns a tuple with the PluginDefaults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginDefaults

`func (o *Namespace) SetPluginDefaults(v []PluginDefault)`

SetPluginDefaults sets PluginDefaults field to given value.

### HasPluginDefaults

`func (o *Namespace) HasPluginDefaults() bool`

HasPluginDefaults returns a boolean if a field has been set.

### GetAllowedNamespaces

`func (o *Namespace) GetAllowedNamespaces() []NamespaceAllowedNamespace`

GetAllowedNamespaces returns the AllowedNamespaces field if non-nil, zero value otherwise.

### GetAllowedNamespacesOk

`func (o *Namespace) GetAllowedNamespacesOk() (*[]NamespaceAllowedNamespace, bool)`

GetAllowedNamespacesOk returns a tuple with the AllowedNamespaces field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedNamespaces

`func (o *Namespace) SetAllowedNamespaces(v []NamespaceAllowedNamespace)`

SetAllowedNamespaces sets AllowedNamespaces field to given value.

### HasAllowedNamespaces

`func (o *Namespace) HasAllowedNamespaces() bool`

HasAllowedNamespaces returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *Namespace) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *Namespace) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *Namespace) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *Namespace) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetStorageType

`func (o *Namespace) GetStorageType() string`

GetStorageType returns the StorageType field if non-nil, zero value otherwise.

### GetStorageTypeOk

`func (o *Namespace) GetStorageTypeOk() (*string, bool)`

GetStorageTypeOk returns a tuple with the StorageType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageType

`func (o *Namespace) SetStorageType(v string)`

SetStorageType sets StorageType field to given value.

### HasStorageType

`func (o *Namespace) HasStorageType() bool`

HasStorageType returns a boolean if a field has been set.

### GetStorageConfiguration

`func (o *Namespace) GetStorageConfiguration() map[string]map[string]interface{}`

GetStorageConfiguration returns the StorageConfiguration field if non-nil, zero value otherwise.

### GetStorageConfigurationOk

`func (o *Namespace) GetStorageConfigurationOk() (*map[string]map[string]interface{}, bool)`

GetStorageConfigurationOk returns a tuple with the StorageConfiguration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageConfiguration

`func (o *Namespace) SetStorageConfiguration(v map[string]map[string]interface{})`

SetStorageConfiguration sets StorageConfiguration field to given value.

### HasStorageConfiguration

`func (o *Namespace) HasStorageConfiguration() bool`

HasStorageConfiguration returns a boolean if a field has been set.

### GetSecretType

`func (o *Namespace) GetSecretType() string`

GetSecretType returns the SecretType field if non-nil, zero value otherwise.

### GetSecretTypeOk

`func (o *Namespace) GetSecretTypeOk() (*string, bool)`

GetSecretTypeOk returns a tuple with the SecretType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretType

`func (o *Namespace) SetSecretType(v string)`

SetSecretType sets SecretType field to given value.

### HasSecretType

`func (o *Namespace) HasSecretType() bool`

HasSecretType returns a boolean if a field has been set.

### GetSecretReadOnly

`func (o *Namespace) GetSecretReadOnly() bool`

GetSecretReadOnly returns the SecretReadOnly field if non-nil, zero value otherwise.

### GetSecretReadOnlyOk

`func (o *Namespace) GetSecretReadOnlyOk() (*bool, bool)`

GetSecretReadOnlyOk returns a tuple with the SecretReadOnly field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretReadOnly

`func (o *Namespace) SetSecretReadOnly(v bool)`

SetSecretReadOnly sets SecretReadOnly field to given value.

### HasSecretReadOnly

`func (o *Namespace) HasSecretReadOnly() bool`

HasSecretReadOnly returns a boolean if a field has been set.

### GetSecretConfiguration

`func (o *Namespace) GetSecretConfiguration() map[string]map[string]interface{}`

GetSecretConfiguration returns the SecretConfiguration field if non-nil, zero value otherwise.

### GetSecretConfigurationOk

`func (o *Namespace) GetSecretConfigurationOk() (*map[string]map[string]interface{}, bool)`

GetSecretConfigurationOk returns a tuple with the SecretConfiguration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretConfiguration

`func (o *Namespace) SetSecretConfiguration(v map[string]map[string]interface{})`

SetSecretConfiguration sets SecretConfiguration field to given value.

### HasSecretConfiguration

`func (o *Namespace) HasSecretConfiguration() bool`

HasSecretConfiguration returns a boolean if a field has been set.

### GetOutputsInInternalStorage

`func (o *Namespace) GetOutputsInInternalStorage() bool`

GetOutputsInInternalStorage returns the OutputsInInternalStorage field if non-nil, zero value otherwise.

### GetOutputsInInternalStorageOk

`func (o *Namespace) GetOutputsInInternalStorageOk() (*bool, bool)`

GetOutputsInInternalStorageOk returns a tuple with the OutputsInInternalStorage field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputsInInternalStorage

`func (o *Namespace) SetOutputsInInternalStorage(v bool)`

SetOutputsInInternalStorage sets OutputsInInternalStorage field to given value.

### HasOutputsInInternalStorage

`func (o *Namespace) HasOutputsInInternalStorage() bool`

HasOutputsInInternalStorage returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


