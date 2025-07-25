# PropertyObject

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Expression** | **string** |  | 
**Value** | Pointer to **interface{}** |  | [optional] 

## Methods

### NewPropertyObject

`func NewPropertyObject(expression string, ) *PropertyObject`

NewPropertyObject instantiates a new PropertyObject object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPropertyObjectWithDefaults

`func NewPropertyObjectWithDefaults() *PropertyObject`

NewPropertyObjectWithDefaults instantiates a new PropertyObject object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetExpression

`func (o *PropertyObject) GetExpression() string`

GetExpression returns the Expression field if non-nil, zero value otherwise.

### GetExpressionOk

`func (o *PropertyObject) GetExpressionOk() (*string, bool)`

GetExpressionOk returns a tuple with the Expression field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpression

`func (o *PropertyObject) SetExpression(v string)`

SetExpression sets Expression field to given value.


### GetValue

`func (o *PropertyObject) GetValue() interface{}`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *PropertyObject) GetValueOk() (*interface{}, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *PropertyObject) SetValue(v interface{})`

SetValue sets Value field to given value.

### HasValue

`func (o *PropertyObject) HasValue() bool`

HasValue returns a boolean if a field has been set.

### SetValueNil

`func (o *PropertyObject) SetValueNil(b bool)`

 SetValueNil sets the value for Value to be an explicit nil

### UnsetValue
`func (o *PropertyObject) UnsetValue()`

UnsetValue ensures that no value is present for Value, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


