# PropertyListAsset

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Expression** | Pointer to **string** |  | [optional] 
**Value** | Pointer to [**[]Asset**](Asset.md) |  | [optional] 

## Methods

### NewPropertyListAsset

`func NewPropertyListAsset() *PropertyListAsset`

NewPropertyListAsset instantiates a new PropertyListAsset object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPropertyListAssetWithDefaults

`func NewPropertyListAssetWithDefaults() *PropertyListAsset`

NewPropertyListAssetWithDefaults instantiates a new PropertyListAsset object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetExpression

`func (o *PropertyListAsset) GetExpression() string`

GetExpression returns the Expression field if non-nil, zero value otherwise.

### GetExpressionOk

`func (o *PropertyListAsset) GetExpressionOk() (*string, bool)`

GetExpressionOk returns a tuple with the Expression field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpression

`func (o *PropertyListAsset) SetExpression(v string)`

SetExpression sets Expression field to given value.

### HasExpression

`func (o *PropertyListAsset) HasExpression() bool`

HasExpression returns a boolean if a field has been set.

### GetValue

`func (o *PropertyListAsset) GetValue() []Asset`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *PropertyListAsset) GetValueOk() (*[]Asset, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *PropertyListAsset) SetValue(v []Asset)`

SetValue sets Value field to given value.

### HasValue

`func (o *PropertyListAsset) HasValue() bool`

HasValue returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


