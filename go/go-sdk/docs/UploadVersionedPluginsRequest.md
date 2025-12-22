# UploadVersionedPluginsRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**File** | ***os.File** |  | 
**ForceInstallOnExistingVersions** | Pointer to **NullableBool** |  | [optional] 

## Methods

### NewUploadVersionedPluginsRequest

`func NewUploadVersionedPluginsRequest(file *os.File, ) *UploadVersionedPluginsRequest`

NewUploadVersionedPluginsRequest instantiates a new UploadVersionedPluginsRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUploadVersionedPluginsRequestWithDefaults

`func NewUploadVersionedPluginsRequestWithDefaults() *UploadVersionedPluginsRequest`

NewUploadVersionedPluginsRequestWithDefaults instantiates a new UploadVersionedPluginsRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFile

`func (o *UploadVersionedPluginsRequest) GetFile() *os.File`

GetFile returns the File field if non-nil, zero value otherwise.

### GetFileOk

`func (o *UploadVersionedPluginsRequest) GetFileOk() (**os.File, bool)`

GetFileOk returns a tuple with the File field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFile

`func (o *UploadVersionedPluginsRequest) SetFile(v *os.File)`

SetFile sets File field to given value.


### GetForceInstallOnExistingVersions

`func (o *UploadVersionedPluginsRequest) GetForceInstallOnExistingVersions() bool`

GetForceInstallOnExistingVersions returns the ForceInstallOnExistingVersions field if non-nil, zero value otherwise.

### GetForceInstallOnExistingVersionsOk

`func (o *UploadVersionedPluginsRequest) GetForceInstallOnExistingVersionsOk() (*bool, bool)`

GetForceInstallOnExistingVersionsOk returns a tuple with the ForceInstallOnExistingVersions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetForceInstallOnExistingVersions

`func (o *UploadVersionedPluginsRequest) SetForceInstallOnExistingVersions(v bool)`

SetForceInstallOnExistingVersions sets ForceInstallOnExistingVersions field to given value.

### HasForceInstallOnExistingVersions

`func (o *UploadVersionedPluginsRequest) HasForceInstallOnExistingVersions() bool`

HasForceInstallOnExistingVersions returns a boolean if a field has been set.

### SetForceInstallOnExistingVersionsNil

`func (o *UploadVersionedPluginsRequest) SetForceInstallOnExistingVersionsNil(b bool)`

 SetForceInstallOnExistingVersionsNil sets the value for ForceInstallOnExistingVersions to be an explicit nil

### UnsetForceInstallOnExistingVersions
`func (o *UploadVersionedPluginsRequest) UnsetForceInstallOnExistingVersions()`

UnsetForceInstallOnExistingVersions ensures that no value is present for ForceInstallOnExistingVersions, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


