# Filter

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Filter** | Pointer to **string** |  | [optional] 
**Expression** | Pointer to **map[string]interface{}** |  | [optional] 

## Methods

### NewFilter

`func NewFilter() *Filter`

NewFilter instantiates a new Filter object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFilterWithDefaults

`func NewFilterWithDefaults() *Filter`

NewFilterWithDefaults instantiates a new Filter object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFilter

`func (o *Filter) GetFilter() string`

GetFilter returns the Filter field if non-nil, zero value otherwise.

### GetFilterOk

`func (o *Filter) GetFilterOk() (*string, bool)`

GetFilterOk returns a tuple with the Filter field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFilter

`func (o *Filter) SetFilter(v string)`

SetFilter sets Filter field to given value.

### HasFilter

`func (o *Filter) HasFilter() bool`

HasFilter returns a boolean if a field has been set.

### GetExpression

`func (o *Filter) GetExpression() map[string]interface{}`

GetExpression returns the Expression field if non-nil, zero value otherwise.

### GetExpressionOk

`func (o *Filter) GetExpressionOk() (*map[string]interface{}, bool)`

GetExpressionOk returns a tuple with the Expression field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpression

`func (o *Filter) SetExpression(v map[string]interface{})`

SetExpression sets Expression field to given value.

### HasExpression

`func (o *Filter) HasExpression() bool`

HasExpression returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


