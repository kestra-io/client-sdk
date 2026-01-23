# FileAttributes

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**FileName** | Pointer to **string** |  | [optional] 
**LastModifiedTime** | Pointer to **int64** |  | [optional] 
**CreationTime** | Pointer to **int64** |  | [optional] 
**Type** | Pointer to [**FileAttributesFileType**](FileAttributesFileType.md) |  | [optional] 
**Size** | Pointer to **int64** |  | [optional] 
**Metadata** | Pointer to **map[string]string** |  | [optional] 

## Methods

### NewFileAttributes

`func NewFileAttributes() *FileAttributes`

NewFileAttributes instantiates a new FileAttributes object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFileAttributesWithDefaults

`func NewFileAttributesWithDefaults() *FileAttributes`

NewFileAttributesWithDefaults instantiates a new FileAttributes object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFileName

`func (o *FileAttributes) GetFileName() string`

GetFileName returns the FileName field if non-nil, zero value otherwise.

### GetFileNameOk

`func (o *FileAttributes) GetFileNameOk() (*string, bool)`

GetFileNameOk returns a tuple with the FileName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFileName

`func (o *FileAttributes) SetFileName(v string)`

SetFileName sets FileName field to given value.

### HasFileName

`func (o *FileAttributes) HasFileName() bool`

HasFileName returns a boolean if a field has been set.

### GetLastModifiedTime

`func (o *FileAttributes) GetLastModifiedTime() int64`

GetLastModifiedTime returns the LastModifiedTime field if non-nil, zero value otherwise.

### GetLastModifiedTimeOk

`func (o *FileAttributes) GetLastModifiedTimeOk() (*int64, bool)`

GetLastModifiedTimeOk returns a tuple with the LastModifiedTime field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLastModifiedTime

`func (o *FileAttributes) SetLastModifiedTime(v int64)`

SetLastModifiedTime sets LastModifiedTime field to given value.

### HasLastModifiedTime

`func (o *FileAttributes) HasLastModifiedTime() bool`

HasLastModifiedTime returns a boolean if a field has been set.

### GetCreationTime

`func (o *FileAttributes) GetCreationTime() int64`

GetCreationTime returns the CreationTime field if non-nil, zero value otherwise.

### GetCreationTimeOk

`func (o *FileAttributes) GetCreationTimeOk() (*int64, bool)`

GetCreationTimeOk returns a tuple with the CreationTime field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreationTime

`func (o *FileAttributes) SetCreationTime(v int64)`

SetCreationTime sets CreationTime field to given value.

### HasCreationTime

`func (o *FileAttributes) HasCreationTime() bool`

HasCreationTime returns a boolean if a field has been set.

### GetType

`func (o *FileAttributes) GetType() FileAttributesFileType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *FileAttributes) GetTypeOk() (*FileAttributesFileType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *FileAttributes) SetType(v FileAttributesFileType)`

SetType sets Type field to given value.

### HasType

`func (o *FileAttributes) HasType() bool`

HasType returns a boolean if a field has been set.

### GetSize

`func (o *FileAttributes) GetSize() int64`

GetSize returns the Size field if non-nil, zero value otherwise.

### GetSizeOk

`func (o *FileAttributes) GetSizeOk() (*int64, bool)`

GetSizeOk returns a tuple with the Size field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSize

`func (o *FileAttributes) SetSize(v int64)`

SetSize sets Size field to given value.

### HasSize

`func (o *FileAttributes) HasSize() bool`

HasSize returns a boolean if a field has been set.

### GetMetadata

`func (o *FileAttributes) GetMetadata() map[string]string`

GetMetadata returns the Metadata field if non-nil, zero value otherwise.

### GetMetadataOk

`func (o *FileAttributes) GetMetadataOk() (*map[string]string, bool)`

GetMetadataOk returns a tuple with the Metadata field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMetadata

`func (o *FileAttributes) SetMetadata(v map[string]string)`

SetMetadata sets Metadata field to given value.

### HasMetadata

`func (o *FileAttributes) HasMetadata() bool`

HasMetadata returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


