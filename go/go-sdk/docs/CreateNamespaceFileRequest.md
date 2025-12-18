# CreateNamespaceFileRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**FileContent** | Pointer to ***os.File** | The file to upload | [optional] 

## Methods

### NewCreateNamespaceFileRequest

`func NewCreateNamespaceFileRequest() *CreateNamespaceFileRequest`

NewCreateNamespaceFileRequest instantiates a new CreateNamespaceFileRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewCreateNamespaceFileRequestWithDefaults

`func NewCreateNamespaceFileRequestWithDefaults() *CreateNamespaceFileRequest`

NewCreateNamespaceFileRequestWithDefaults instantiates a new CreateNamespaceFileRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFileContent

`func (o *CreateNamespaceFileRequest) GetFileContent() *os.File`

GetFileContent returns the FileContent field if non-nil, zero value otherwise.

### GetFileContentOk

`func (o *CreateNamespaceFileRequest) GetFileContentOk() (**os.File, bool)`

GetFileContentOk returns a tuple with the FileContent field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFileContent

`func (o *CreateNamespaceFileRequest) SetFileContent(v *os.File)`

SetFileContent sets FileContent field to given value.

### HasFileContent

`func (o *CreateNamespaceFileRequest) HasFileContent() bool`

HasFileContent returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


