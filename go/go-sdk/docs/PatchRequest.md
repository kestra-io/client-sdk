# PatchRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Schemas** | Pointer to **[]string** |  | [optional] 
**PatchOperationList** | Pointer to [**[]PatchOperation**](PatchOperation.md) |  | [optional] 

## Methods

### NewPatchRequest

`func NewPatchRequest() *PatchRequest`

NewPatchRequest instantiates a new PatchRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPatchRequestWithDefaults

`func NewPatchRequestWithDefaults() *PatchRequest`

NewPatchRequestWithDefaults instantiates a new PatchRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSchemas

`func (o *PatchRequest) GetSchemas() []string`

GetSchemas returns the Schemas field if non-nil, zero value otherwise.

### GetSchemasOk

`func (o *PatchRequest) GetSchemasOk() (*[]string, bool)`

GetSchemasOk returns a tuple with the Schemas field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemas

`func (o *PatchRequest) SetSchemas(v []string)`

SetSchemas sets Schemas field to given value.

### HasSchemas

`func (o *PatchRequest) HasSchemas() bool`

HasSchemas returns a boolean if a field has been set.

### GetPatchOperationList

`func (o *PatchRequest) GetPatchOperationList() []PatchOperation`

GetPatchOperationList returns the PatchOperationList field if non-nil, zero value otherwise.

### GetPatchOperationListOk

`func (o *PatchRequest) GetPatchOperationListOk() (*[]PatchOperation, bool)`

GetPatchOperationListOk returns a tuple with the PatchOperationList field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPatchOperationList

`func (o *PatchRequest) SetPatchOperationList(v []PatchOperation)`

SetPatchOperationList sets PatchOperationList field to given value.

### HasPatchOperationList

`func (o *PatchRequest) HasPatchOperationList() bool`

HasPatchOperationList returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


