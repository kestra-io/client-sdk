# ValuePathExpression

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AttributePath** | [**AttributeReference**](AttributeReference.md) |  | 
**AttributeExpression** | Pointer to **map[string]interface{}** |  | [optional] 

## Methods

### NewValuePathExpression

`func NewValuePathExpression(attributePath AttributeReference, ) *ValuePathExpression`

NewValuePathExpression instantiates a new ValuePathExpression object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewValuePathExpressionWithDefaults

`func NewValuePathExpressionWithDefaults() *ValuePathExpression`

NewValuePathExpressionWithDefaults instantiates a new ValuePathExpression object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAttributePath

`func (o *ValuePathExpression) GetAttributePath() AttributeReference`

GetAttributePath returns the AttributePath field if non-nil, zero value otherwise.

### GetAttributePathOk

`func (o *ValuePathExpression) GetAttributePathOk() (*AttributeReference, bool)`

GetAttributePathOk returns a tuple with the AttributePath field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttributePath

`func (o *ValuePathExpression) SetAttributePath(v AttributeReference)`

SetAttributePath sets AttributePath field to given value.


### GetAttributeExpression

`func (o *ValuePathExpression) GetAttributeExpression() map[string]interface{}`

GetAttributeExpression returns the AttributeExpression field if non-nil, zero value otherwise.

### GetAttributeExpressionOk

`func (o *ValuePathExpression) GetAttributeExpressionOk() (*map[string]interface{}, bool)`

GetAttributeExpressionOk returns a tuple with the AttributeExpression field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttributeExpression

`func (o *ValuePathExpression) SetAttributeExpression(v map[string]interface{})`

SetAttributeExpression sets AttributeExpression field to given value.

### HasAttributeExpression

`func (o *ValuePathExpression) HasAttributeExpression() bool`

HasAttributeExpression returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


