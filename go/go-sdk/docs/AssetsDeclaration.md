# AssetsDeclaration

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Inputs** | Pointer to [**[]AssetIdentifier**](AssetIdentifier.md) |  | [optional] 
**Outputs** | Pointer to [**[]Asset**](Asset.md) |  | [optional] 
**EnableAuto** | Pointer to **bool** |  | [optional] 

## Methods

### NewAssetsDeclaration

`func NewAssetsDeclaration() *AssetsDeclaration`

NewAssetsDeclaration instantiates a new AssetsDeclaration object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssetsDeclarationWithDefaults

`func NewAssetsDeclarationWithDefaults() *AssetsDeclaration`

NewAssetsDeclarationWithDefaults instantiates a new AssetsDeclaration object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetInputs

`func (o *AssetsDeclaration) GetInputs() []AssetIdentifier`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *AssetsDeclaration) GetInputsOk() (*[]AssetIdentifier, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *AssetsDeclaration) SetInputs(v []AssetIdentifier)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *AssetsDeclaration) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *AssetsDeclaration) GetOutputs() []Asset`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *AssetsDeclaration) GetOutputsOk() (*[]Asset, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *AssetsDeclaration) SetOutputs(v []Asset)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *AssetsDeclaration) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetEnableAuto

`func (o *AssetsDeclaration) GetEnableAuto() bool`

GetEnableAuto returns the EnableAuto field if non-nil, zero value otherwise.

### GetEnableAutoOk

`func (o *AssetsDeclaration) GetEnableAutoOk() (*bool, bool)`

GetEnableAutoOk returns a tuple with the EnableAuto field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnableAuto

`func (o *AssetsDeclaration) SetEnableAuto(v bool)`

SetEnableAuto sets EnableAuto field to given value.

### HasEnableAuto

`func (o *AssetsDeclaration) HasEnableAuto() bool`

HasEnableAuto returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


