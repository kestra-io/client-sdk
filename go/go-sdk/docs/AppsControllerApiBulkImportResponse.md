# AppsControllerApiBulkImportResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Success** | Pointer to **[]string** |  | [optional] 
**Errors** | Pointer to [**[]AppsControllerApiBulkImportResponseError**](AppsControllerApiBulkImportResponseError.md) |  | [optional] 

## Methods

### NewAppsControllerApiBulkImportResponse

`func NewAppsControllerApiBulkImportResponse() *AppsControllerApiBulkImportResponse`

NewAppsControllerApiBulkImportResponse instantiates a new AppsControllerApiBulkImportResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAppsControllerApiBulkImportResponseWithDefaults

`func NewAppsControllerApiBulkImportResponseWithDefaults() *AppsControllerApiBulkImportResponse`

NewAppsControllerApiBulkImportResponseWithDefaults instantiates a new AppsControllerApiBulkImportResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSuccess

`func (o *AppsControllerApiBulkImportResponse) GetSuccess() []string`

GetSuccess returns the Success field if non-nil, zero value otherwise.

### GetSuccessOk

`func (o *AppsControllerApiBulkImportResponse) GetSuccessOk() (*[]string, bool)`

GetSuccessOk returns a tuple with the Success field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuccess

`func (o *AppsControllerApiBulkImportResponse) SetSuccess(v []string)`

SetSuccess sets Success field to given value.

### HasSuccess

`func (o *AppsControllerApiBulkImportResponse) HasSuccess() bool`

HasSuccess returns a boolean if a field has been set.

### GetErrors

`func (o *AppsControllerApiBulkImportResponse) GetErrors() []AppsControllerApiBulkImportResponseError`

GetErrors returns the Errors field if non-nil, zero value otherwise.

### GetErrorsOk

`func (o *AppsControllerApiBulkImportResponse) GetErrorsOk() (*[]AppsControllerApiBulkImportResponseError, bool)`

GetErrorsOk returns a tuple with the Errors field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetErrors

`func (o *AppsControllerApiBulkImportResponse) SetErrors(v []AppsControllerApiBulkImportResponseError)`

SetErrors sets Errors field to given value.

### HasErrors

`func (o *AppsControllerApiBulkImportResponse) HasErrors() bool`

HasErrors returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


