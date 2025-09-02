# PropertyListString

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Expression** | **string** |  | 
**Value** | Pointer to **[]string** |  | [optional] 

## Methods

### NewPropertyListString

`func NewPropertyListString(expression string, ) *PropertyListString`

NewPropertyListString instantiates a new PropertyListString object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPropertyListStringWithDefaults

`func NewPropertyListStringWithDefaults() *PropertyListString`

NewPropertyListStringWithDefaults instantiates a new PropertyListString object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetExpression

`func (o *PropertyListString) GetExpression() string`

GetExpression returns the Expression field if non-nil, zero value otherwise.

### GetExpressionOk

`func (o *PropertyListString) GetExpressionOk() (*string, bool)`

GetExpressionOk returns a tuple with the Expression field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpression

`func (o *PropertyListString) SetExpression(v string)`

SetExpression sets Expression field to given value.


### GetValue

`func (o *PropertyListString) GetValue() []string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *PropertyListString) GetValueOk() (*[]string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *PropertyListString) SetValue(v []string)`

SetValue sets Value field to given value.

### HasValue

`func (o *PropertyListString) HasValue() bool`

HasValue returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


