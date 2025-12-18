# BulkImportAppsRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**FileUpload** | Pointer to ***os.File** | The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] 

## Methods

### NewBulkImportAppsRequest

`func NewBulkImportAppsRequest() *BulkImportAppsRequest`

NewBulkImportAppsRequest instantiates a new BulkImportAppsRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBulkImportAppsRequestWithDefaults

`func NewBulkImportAppsRequestWithDefaults() *BulkImportAppsRequest`

NewBulkImportAppsRequestWithDefaults instantiates a new BulkImportAppsRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFileUpload

`func (o *BulkImportAppsRequest) GetFileUpload() *os.File`

GetFileUpload returns the FileUpload field if non-nil, zero value otherwise.

### GetFileUploadOk

`func (o *BulkImportAppsRequest) GetFileUploadOk() (**os.File, bool)`

GetFileUploadOk returns a tuple with the FileUpload field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFileUpload

`func (o *BulkImportAppsRequest) SetFileUpload(v *os.File)`

SetFileUpload sets FileUpload field to given value.

### HasFileUpload

`func (o *BulkImportAppsRequest) HasFileUpload() bool`

HasFileUpload returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


