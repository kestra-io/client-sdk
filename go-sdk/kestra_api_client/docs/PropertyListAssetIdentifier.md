# PropertyListAssetIdentifier

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Expression** | Pointer to **string** |  | [optional] 
**Value** | Pointer to [**[]AssetIdentifier**](AssetIdentifier.md) |  | [optional] 

## Methods

### NewPropertyListAssetIdentifier

`func NewPropertyListAssetIdentifier() *PropertyListAssetIdentifier`

NewPropertyListAssetIdentifier instantiates a new PropertyListAssetIdentifier object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPropertyListAssetIdentifierWithDefaults

`func NewPropertyListAssetIdentifierWithDefaults() *PropertyListAssetIdentifier`

NewPropertyListAssetIdentifierWithDefaults instantiates a new PropertyListAssetIdentifier object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetExpression

`func (o *PropertyListAssetIdentifier) GetExpression() string`

GetExpression returns the Expression field if non-nil, zero value otherwise.

### GetExpressionOk

`func (o *PropertyListAssetIdentifier) GetExpressionOk() (*string, bool)`

GetExpressionOk returns a tuple with the Expression field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpression

`func (o *PropertyListAssetIdentifier) SetExpression(v string)`

SetExpression sets Expression field to given value.

### HasExpression

`func (o *PropertyListAssetIdentifier) HasExpression() bool`

HasExpression returns a boolean if a field has been set.

### GetValue

`func (o *PropertyListAssetIdentifier) GetValue() []AssetIdentifier`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *PropertyListAssetIdentifier) GetValueOk() (*[]AssetIdentifier, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *PropertyListAssetIdentifier) SetValue(v []AssetIdentifier)`

SetValue sets Value field to given value.

### HasValue

`func (o *PropertyListAssetIdentifier) HasValue() bool`

HasValue returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


