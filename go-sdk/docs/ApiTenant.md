# ApiTenant

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**StorageIsolation** | [**Isolation**](Isolation.md) |  | 
**SecretIsolation** | [**Isolation**](Isolation.md) |  | 
**Id** | **string** |  | 
**Name** | **string** |  | 
**Deleted** | **bool** |  | 
**WorkerGroup** | [**WorkerGroup**](WorkerGroup.md) |  | 
**StorageType** | **string** |  | 
**StorageConfiguration** | **map[string]interface{}** |  | 
**SecretType** | **string** |  | 
**SecretReadOnly** | **bool** |  | 
**SecretConfiguration** | **map[string]interface{}** |  | 
**RequireExistingNamespace** | **bool** |  | 
**OutputsInInternalStorage** | **bool** |  | 
**Logo** | **string** |  | 

## Methods

### NewApiTenant

`func NewApiTenant(storageIsolation Isolation, secretIsolation Isolation, id string, name string, deleted bool, workerGroup WorkerGroup, storageType string, storageConfiguration map[string]interface{}, secretType string, secretReadOnly bool, secretConfiguration map[string]interface{}, requireExistingNamespace bool, outputsInInternalStorage bool, logo string, ) *ApiTenant`

NewApiTenant instantiates a new ApiTenant object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiTenantWithDefaults

`func NewApiTenantWithDefaults() *ApiTenant`

NewApiTenantWithDefaults instantiates a new ApiTenant object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetStorageIsolation

`func (o *ApiTenant) GetStorageIsolation() Isolation`

GetStorageIsolation returns the StorageIsolation field if non-nil, zero value otherwise.

### GetStorageIsolationOk

`func (o *ApiTenant) GetStorageIsolationOk() (*Isolation, bool)`

GetStorageIsolationOk returns a tuple with the StorageIsolation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageIsolation

`func (o *ApiTenant) SetStorageIsolation(v Isolation)`

SetStorageIsolation sets StorageIsolation field to given value.


### GetSecretIsolation

`func (o *ApiTenant) GetSecretIsolation() Isolation`

GetSecretIsolation returns the SecretIsolation field if non-nil, zero value otherwise.

### GetSecretIsolationOk

`func (o *ApiTenant) GetSecretIsolationOk() (*Isolation, bool)`

GetSecretIsolationOk returns a tuple with the SecretIsolation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretIsolation

`func (o *ApiTenant) SetSecretIsolation(v Isolation)`

SetSecretIsolation sets SecretIsolation field to given value.


### GetId

`func (o *ApiTenant) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ApiTenant) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ApiTenant) SetId(v string)`

SetId sets Id field to given value.


### GetName

`func (o *ApiTenant) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *ApiTenant) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *ApiTenant) SetName(v string)`

SetName sets Name field to given value.


### GetDeleted

`func (o *ApiTenant) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *ApiTenant) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *ApiTenant) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetWorkerGroup

`func (o *ApiTenant) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *ApiTenant) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *ApiTenant) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.


### GetStorageType

`func (o *ApiTenant) GetStorageType() string`

GetStorageType returns the StorageType field if non-nil, zero value otherwise.

### GetStorageTypeOk

`func (o *ApiTenant) GetStorageTypeOk() (*string, bool)`

GetStorageTypeOk returns a tuple with the StorageType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageType

`func (o *ApiTenant) SetStorageType(v string)`

SetStorageType sets StorageType field to given value.


### GetStorageConfiguration

`func (o *ApiTenant) GetStorageConfiguration() map[string]interface{}`

GetStorageConfiguration returns the StorageConfiguration field if non-nil, zero value otherwise.

### GetStorageConfigurationOk

`func (o *ApiTenant) GetStorageConfigurationOk() (*map[string]interface{}, bool)`

GetStorageConfigurationOk returns a tuple with the StorageConfiguration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorageConfiguration

`func (o *ApiTenant) SetStorageConfiguration(v map[string]interface{})`

SetStorageConfiguration sets StorageConfiguration field to given value.


### GetSecretType

`func (o *ApiTenant) GetSecretType() string`

GetSecretType returns the SecretType field if non-nil, zero value otherwise.

### GetSecretTypeOk

`func (o *ApiTenant) GetSecretTypeOk() (*string, bool)`

GetSecretTypeOk returns a tuple with the SecretType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretType

`func (o *ApiTenant) SetSecretType(v string)`

SetSecretType sets SecretType field to given value.


### GetSecretReadOnly

`func (o *ApiTenant) GetSecretReadOnly() bool`

GetSecretReadOnly returns the SecretReadOnly field if non-nil, zero value otherwise.

### GetSecretReadOnlyOk

`func (o *ApiTenant) GetSecretReadOnlyOk() (*bool, bool)`

GetSecretReadOnlyOk returns a tuple with the SecretReadOnly field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretReadOnly

`func (o *ApiTenant) SetSecretReadOnly(v bool)`

SetSecretReadOnly sets SecretReadOnly field to given value.


### GetSecretConfiguration

`func (o *ApiTenant) GetSecretConfiguration() map[string]interface{}`

GetSecretConfiguration returns the SecretConfiguration field if non-nil, zero value otherwise.

### GetSecretConfigurationOk

`func (o *ApiTenant) GetSecretConfigurationOk() (*map[string]interface{}, bool)`

GetSecretConfigurationOk returns a tuple with the SecretConfiguration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretConfiguration

`func (o *ApiTenant) SetSecretConfiguration(v map[string]interface{})`

SetSecretConfiguration sets SecretConfiguration field to given value.


### GetRequireExistingNamespace

`func (o *ApiTenant) GetRequireExistingNamespace() bool`

GetRequireExistingNamespace returns the RequireExistingNamespace field if non-nil, zero value otherwise.

### GetRequireExistingNamespaceOk

`func (o *ApiTenant) GetRequireExistingNamespaceOk() (*bool, bool)`

GetRequireExistingNamespaceOk returns a tuple with the RequireExistingNamespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRequireExistingNamespace

`func (o *ApiTenant) SetRequireExistingNamespace(v bool)`

SetRequireExistingNamespace sets RequireExistingNamespace field to given value.


### GetOutputsInInternalStorage

`func (o *ApiTenant) GetOutputsInInternalStorage() bool`

GetOutputsInInternalStorage returns the OutputsInInternalStorage field if non-nil, zero value otherwise.

### GetOutputsInInternalStorageOk

`func (o *ApiTenant) GetOutputsInInternalStorageOk() (*bool, bool)`

GetOutputsInInternalStorageOk returns a tuple with the OutputsInInternalStorage field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputsInInternalStorage

`func (o *ApiTenant) SetOutputsInInternalStorage(v bool)`

SetOutputsInInternalStorage sets OutputsInInternalStorage field to given value.


### GetLogo

`func (o *ApiTenant) GetLogo() string`

GetLogo returns the Logo field if non-nil, zero value otherwise.

### GetLogoOk

`func (o *ApiTenant) GetLogoOk() (*string, bool)`

GetLogoOk returns a tuple with the Logo field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLogo

`func (o *ApiTenant) SetLogo(v string)`

SetLogo sets Logo field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


