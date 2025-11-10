# PatchOperation

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Operation** | Pointer to [**PatchOperationType**](PatchOperationType.md) |  | [optional] 
**Path** | Pointer to [**PatchOperationPath**](PatchOperationPath.md) |  | [optional] 
**Value** | Pointer to **map[string]interface{}** |  | [optional] 

## Methods

### NewPatchOperation

`func NewPatchOperation() *PatchOperation`

NewPatchOperation instantiates a new PatchOperation object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPatchOperationWithDefaults

`func NewPatchOperationWithDefaults() *PatchOperation`

NewPatchOperationWithDefaults instantiates a new PatchOperation object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetOperation

`func (o *PatchOperation) GetOperation() PatchOperationType`

GetOperation returns the Operation field if non-nil, zero value otherwise.

### GetOperationOk

`func (o *PatchOperation) GetOperationOk() (*PatchOperationType, bool)`

GetOperationOk returns a tuple with the Operation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOperation

`func (o *PatchOperation) SetOperation(v PatchOperationType)`

SetOperation sets Operation field to given value.

### HasOperation

`func (o *PatchOperation) HasOperation() bool`

HasOperation returns a boolean if a field has been set.

### GetPath

`func (o *PatchOperation) GetPath() PatchOperationPath`

GetPath returns the Path field if non-nil, zero value otherwise.

### GetPathOk

`func (o *PatchOperation) GetPathOk() (*PatchOperationPath, bool)`

GetPathOk returns a tuple with the Path field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPath

`func (o *PatchOperation) SetPath(v PatchOperationPath)`

SetPath sets Path field to given value.

### HasPath

`func (o *PatchOperation) HasPath() bool`

HasPath returns a boolean if a field has been set.

### GetValue

`func (o *PatchOperation) GetValue() map[string]interface{}`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *PatchOperation) GetValueOk() (*map[string]interface{}, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *PatchOperation) SetValue(v map[string]interface{})`

SetValue sets Value field to given value.

### HasValue

`func (o *PatchOperation) HasValue() bool`

HasValue returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


