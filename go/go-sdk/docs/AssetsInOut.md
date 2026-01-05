# AssetsInOut

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Inputs** | Pointer to [**[]AssetIdentifier**](AssetIdentifier.md) |  | [optional] 
**Outputs** | Pointer to [**[]Asset**](Asset.md) |  | [optional] 

## Methods

### NewAssetsInOut

`func NewAssetsInOut() *AssetsInOut`

NewAssetsInOut instantiates a new AssetsInOut object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssetsInOutWithDefaults

`func NewAssetsInOutWithDefaults() *AssetsInOut`

NewAssetsInOutWithDefaults instantiates a new AssetsInOut object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetInputs

`func (o *AssetsInOut) GetInputs() []AssetIdentifier`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *AssetsInOut) GetInputsOk() (*[]AssetIdentifier, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *AssetsInOut) SetInputs(v []AssetIdentifier)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *AssetsInOut) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *AssetsInOut) GetOutputs() []Asset`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *AssetsInOut) GetOutputsOk() (*[]Asset, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *AssetsInOut) SetOutputs(v []Asset)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *AssetsInOut) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


